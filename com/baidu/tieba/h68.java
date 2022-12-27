package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
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
/* loaded from: classes4.dex */
public class h68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements um5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ m48 b;

        public a(PbModel pbModel, m48 m48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, m48Var};
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
            this.b = m48Var;
        }

        @Override // com.baidu.tieba.um5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.r4(false);
            }
        }

        @Override // com.baidu.tieba.um5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.l1() == null) {
                return;
            }
            ArrayList<PostData> H = this.a.l1().H();
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
                            if (this.a.l1().Q() != null) {
                                this.a.l1().Q().setReply_num(this.a.l1().Q().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.G1(this.a.l1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            tm5.b().a();
        }
    }

    public static wm5 b(PbModel pbModel, m48 m48Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, m48Var)) == null) {
            if (pbModel != null && m48Var != null) {
                wm5 wm5Var = new wm5();
                if (pbModel.l1() != null && pbModel.l1().l() != null) {
                    if (pbModel.l1().l().getDeletedReasonInfo() != null) {
                        wm5Var.p(pbModel.l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        wm5Var.o(pbModel.l1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    wm5Var.l(pbModel.l1().l().getId());
                    wm5Var.m(pbModel.l1().l().getName());
                    wm5Var.k(pbModel.l1().l().getImage_url());
                    wm5Var.t(pbModel.l1().l().getUser_level());
                }
                if (pbModel.l1() != null && pbModel.l1().o() != null) {
                    wm5Var.n(pbModel.l1().o().has_forum_rule.intValue());
                }
                if (pbModel.l1() != null && pbModel.l1().X() != null) {
                    wm5Var.s(pbModel.l1().X());
                }
                wm5Var.q(new a(pbModel, m48Var));
                if (pbModel.l1() != null) {
                    AntiData d = pbModel.l1().d();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (d != null && d.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = d.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    wm5Var.r(sparseArray);
                }
                return wm5Var;
            }
            return null;
        }
        return (wm5) invokeLL.objValue;
    }

    public static boolean c(i08 i08Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, i08Var, postData)) == null) {
            if (i08Var != null && postData != null) {
                ym5 ym5Var = new ym5();
                ym5Var.d(postData.I() + "");
                if (i08Var.Q() != null) {
                    ym5Var.f(i08Var.Q().getId());
                }
                ym5Var.e(postData.M());
                return tm5.b().c(ym5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, m48 m48Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, m48Var) == null) && tbPageContext != null && pbModel != null && m48Var != null) {
            tm5.b().e(tbPageContext, m48Var.n1(), b(pbModel, m48Var));
            tm5.b().d(1);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return tm5.b().f(postData.M());
        }
        return invokeL.booleanValue;
    }
}
