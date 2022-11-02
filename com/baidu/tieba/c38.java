package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements ol5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ h18 b;

        public a(PbModel pbModel, h18 h18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, h18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbModel;
            this.b = h18Var;
        }

        @Override // com.baidu.tieba.ol5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.q4(false);
            }
        }

        @Override // com.baidu.tieba.ol5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.S1() == null) {
                return;
            }
            ArrayList<PostData> H = this.a.S1().H();
            if (!ListUtils.isEmpty(H) && !ListUtils.isEmpty(list)) {
                Iterator<PostData> it = H.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.M())) {
                            it.remove();
                            if (this.a.S1().Q() != null) {
                                this.a.S1().Q().setReply_num(this.a.S1().Q().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.G1(this.a.S1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            nl5.b().a();
        }
    }

    public static ql5 b(PbModel pbModel, h18 h18Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, h18Var)) == null) {
            if (pbModel != null && h18Var != null) {
                ql5 ql5Var = new ql5();
                if (pbModel.S1() != null && pbModel.S1().l() != null) {
                    if (pbModel.S1().l().getDeletedReasonInfo() != null) {
                        ql5Var.p(pbModel.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        ql5Var.o(pbModel.S1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    ql5Var.l(pbModel.S1().l().getId());
                    ql5Var.m(pbModel.S1().l().getName());
                    ql5Var.k(pbModel.S1().l().getImage_url());
                    ql5Var.t(pbModel.S1().l().getUser_level());
                }
                if (pbModel.S1() != null && pbModel.S1().o() != null) {
                    ql5Var.n(pbModel.S1().o().has_forum_rule.intValue());
                }
                if (pbModel.S1() != null && pbModel.S1().X() != null) {
                    ql5Var.s(pbModel.S1().X());
                }
                ql5Var.q(new a(pbModel, h18Var));
                if (pbModel.S1() != null) {
                    AntiData d = pbModel.S1().d();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (d != null && d.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = d.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    ql5Var.r(sparseArray);
                }
                return ql5Var;
            }
            return null;
        }
        return (ql5) invokeLL.objValue;
    }

    public static boolean c(dx7 dx7Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, dx7Var, postData)) == null) {
            if (dx7Var != null && postData != null) {
                sl5 sl5Var = new sl5();
                sl5Var.d(postData.I() + "");
                if (dx7Var.Q() != null) {
                    sl5Var.f(dx7Var.Q().getId());
                }
                sl5Var.e(postData.M());
                return nl5.b().c(sl5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, h18 h18Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, h18Var) == null) && tbPageContext != null && pbModel != null && h18Var != null) {
            nl5.b().e(tbPageContext, (ViewGroup) h18Var.n1(), b(pbModel, h18Var));
            nl5.b().d(1);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return nl5.b().f(postData.M());
        }
        return invokeL.booleanValue;
    }
}
