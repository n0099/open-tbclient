package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class ez8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements du5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ DetailInfoAndReplyFragment b;

        public a(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, detailInfoAndReplyFragment};
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
            this.b = detailInfoAndReplyFragment;
        }

        @Override // com.baidu.tieba.du5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.q2(false);
            }
        }

        @Override // com.baidu.tieba.du5
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.u1() == null) {
                return;
            }
            ArrayList<am9> F = this.a.u1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<am9> it = F.iterator();
                while (it.hasNext()) {
                    am9 next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.O())) {
                            it.remove();
                            if (this.a.u1().M() != null) {
                                this.a.u1().M().setReply_num(this.a.u1().M().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.c2();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            cu5.b().a();
        }
    }

    public static fu5 b(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, detailInfoAndReplyFragment)) == null) {
            if (detailInfoAndReplyFragment != null && pbModel != null) {
                fu5 fu5Var = new fu5();
                if (pbModel.u1() != null && pbModel.u1().k() != null) {
                    if (pbModel.u1().k().getDeletedReasonInfo() != null) {
                        fu5Var.p(pbModel.u1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        fu5Var.o(pbModel.u1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    fu5Var.l(pbModel.u1().k().getId());
                    fu5Var.m(pbModel.u1().k().getName());
                    fu5Var.k(pbModel.u1().k().getImage_url());
                    fu5Var.t(pbModel.u1().k().getUser_level());
                }
                if (pbModel.u1() != null && pbModel.u1().n() != null) {
                    fu5Var.n(pbModel.u1().n().has_forum_rule.intValue());
                }
                if (pbModel.u1() != null && pbModel.u1().T() != null) {
                    fu5Var.s(pbModel.u1().T());
                }
                fu5Var.q(new a(pbModel, detailInfoAndReplyFragment));
                if (pbModel.u1() != null) {
                    AntiData c = pbModel.u1().c();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (c != null && c.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    fu5Var.r(sparseArray);
                }
                return fu5Var;
            }
            return null;
        }
        return (fu5) invokeLL.objValue;
    }

    public static boolean c(ht8 ht8Var, am9 am9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ht8Var, am9Var)) == null) {
            if (ht8Var != null && am9Var != null) {
                hu5 hu5Var = new hu5();
                hu5Var.d(am9Var.K() + "");
                if (ht8Var.M() != null) {
                    hu5Var.f(ht8Var.M().getId());
                }
                hu5Var.e(am9Var.O());
                return cu5.b().c(hu5Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65539, null, tbPageContext, pbModel, detailInfoAndReplyFragment, view2) == null) && tbPageContext != null && pbModel != null && detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.getView() != null) {
            cu5.b().e(tbPageContext, (ViewGroup) view2, b(pbModel, detailInfoAndReplyFragment));
            cu5.b().d(2);
        }
    }

    public static boolean e(am9 am9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, am9Var)) == null) {
            if (am9Var == null) {
                return false;
            }
            return cu5.b().f(am9Var.O());
        }
        return invokeL.booleanValue;
    }
}
