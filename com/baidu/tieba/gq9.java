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
/* loaded from: classes6.dex */
public class gq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements f16 {
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

        @Override // com.baidu.tieba.f16
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.K2(false);
            }
        }

        @Override // com.baidu.tieba.f16
        public void b(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.a.r1() == null) {
                return;
            }
            ArrayList<tha> F = this.a.r1().F();
            if (!ListUtils.isEmpty(F) && !ListUtils.isEmpty(list)) {
                Iterator<tha> it = F.iterator();
                while (it.hasNext()) {
                    tha next = it.next();
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (TextUtils.equals(list.get(i), next.U())) {
                            it.remove();
                            if (this.a.r1().O() != null) {
                                this.a.r1().O().setReply_num(this.a.r1().O().getReply_num() - 1);
                            }
                        } else {
                            i++;
                        }
                    }
                }
                this.b.w2();
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            e16.b().a();
        }
    }

    public static h16 b(PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pbModel, detailInfoAndReplyFragment)) == null) {
            if (detailInfoAndReplyFragment != null && pbModel != null) {
                h16 h16Var = new h16();
                if (pbModel.r1() != null && pbModel.r1().k() != null) {
                    if (pbModel.r1().k().getDeletedReasonInfo() != null) {
                        h16Var.p(pbModel.r1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                        h16Var.o(pbModel.r1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                    }
                    h16Var.l(pbModel.r1().k().getId());
                    h16Var.m(pbModel.r1().k().getName());
                    h16Var.k(pbModel.r1().k().getImage_url());
                    h16Var.t(pbModel.r1().k().getUser_level());
                }
                if (pbModel.r1() != null && pbModel.r1().n() != null) {
                    h16Var.n(pbModel.r1().n().has_forum_rule.intValue());
                }
                if (pbModel.r1() != null && pbModel.r1().V() != null) {
                    h16Var.s(pbModel.r1().V());
                }
                h16Var.q(new a(pbModel, detailInfoAndReplyFragment));
                if (pbModel.r1() != null) {
                    AntiData c = pbModel.r1().c();
                    SparseArray<String> sparseArray = new SparseArray<>();
                    if (c != null && c.getDelThreadInfoList() != null) {
                        List<DeleteThreadInfo> delThreadInfoList = c.getDelThreadInfoList();
                        for (int i = 0; i < delThreadInfoList.size(); i++) {
                            if (delThreadInfoList.get(i) != null && !TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                                sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                            }
                        }
                    }
                    h16Var.r(sparseArray);
                }
                return h16Var;
            }
            return null;
        }
        return (h16) invokeLL.objValue;
    }

    public static boolean c(aj9 aj9Var, tha thaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aj9Var, thaVar)) == null) {
            if (aj9Var != null && thaVar != null) {
                j16 j16Var = new j16();
                j16Var.d(thaVar.Q() + "");
                if (aj9Var.O() != null) {
                    j16Var.f(aj9Var.O().getId());
                }
                j16Var.e(thaVar.U());
                return e16.b().c(j16Var);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<BaseFragmentActivity> tbPageContext, PbModel pbModel, DetailInfoAndReplyFragment detailInfoAndReplyFragment, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65539, null, tbPageContext, pbModel, detailInfoAndReplyFragment, view2) == null) && tbPageContext != null && pbModel != null && detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.getView() != null) {
            e16.b().e(tbPageContext, (ViewGroup) view2, b(pbModel, detailInfoAndReplyFragment));
            e16.b().d(2);
        }
    }

    public static boolean e(tha thaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, thaVar)) == null) {
            if (thaVar == null) {
                return false;
            }
            return e16.b().f(thaVar.U());
        }
        return invokeL.booleanValue;
    }
}
