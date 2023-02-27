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
public class hj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements qt5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ lh8 b;

        public a(PbModel pbModel, lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, lh8Var};
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
            this.b = lh8Var;
        }

        @Override // com.baidu.tieba.qt5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.z4(false);
            }
        }

        @Override // com.baidu.tieba.qt5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.s1() == null) {
                return;
            }
            ArrayList<PostData> H = this.a.s1().H();
            if (!ListUtils.isEmpty(H) && !ListUtils.isEmpty(list)) {
                Iterator<PostData> it = H.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.O())) {
                            it.remove();
                            if (this.a.s1().Q() != null) {
                                this.a.s1().Q().setReply_num(this.a.s1().Q().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.N1(this.a.s1());
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            pt5.b().a();
        }
    }

    public static st5 b(PbModel pbModel, lh8 lh8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, lh8Var)) == null) {
            if (pbModel != null && lh8Var != null) {
                st5 st5Var = new st5();
                if (pbModel.s1() != null && pbModel.s1().l() != null) {
                    if (pbModel.s1().l().getDeletedReasonInfo() != null) {
                        st5Var.p(pbModel.s1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        st5Var.o(pbModel.s1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    st5Var.l(pbModel.s1().l().getId());
                    st5Var.m(pbModel.s1().l().getName());
                    st5Var.k(pbModel.s1().l().getImage_url());
                    st5Var.t(pbModel.s1().l().getUser_level());
                }
                if (pbModel.s1() != null && pbModel.s1().o() != null) {
                    st5Var.n(pbModel.s1().o().has_forum_rule.intValue());
                }
                if (pbModel.s1() != null && pbModel.s1().X() != null) {
                    st5Var.s(pbModel.s1().X());
                }
                st5Var.q(new a(pbModel, lh8Var));
                if (pbModel.s1() != null) {
                    AntiData d = pbModel.s1().d();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (d != null && d.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = d.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    st5Var.r(sparseArray);
                }
                return st5Var;
            }
            return null;
        }
        return (st5) invokeLL.objValue;
    }

    public static boolean c(hd8 hd8Var, PostData postData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, hd8Var, postData)) == null) {
            if (hd8Var != null && postData != null) {
                ut5 ut5Var = new ut5();
                ut5Var.d(postData.K() + "");
                if (hd8Var.Q() != null) {
                    ut5Var.f(hd8Var.Q().getId());
                }
                ut5Var.e(postData.O());
                return pt5.b().c(ut5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, lh8 lh8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, pbModel, lh8Var) == null) && tbPageContext != null && pbModel != null && lh8Var != null) {
            pt5.b().e(tbPageContext, lh8Var.t1(), b(pbModel, lh8Var));
            pt5.b().d(1);
        }
    }

    public static boolean e(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, postData)) == null) {
            if (postData == null) {
                return false;
            }
            return pt5.b().f(postData.O());
        }
        return invokeL.booleanValue;
    }
}
