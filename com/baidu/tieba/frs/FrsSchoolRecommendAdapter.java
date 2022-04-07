package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hq4;
import com.repackage.id6;
import com.repackage.iq4;
import com.repackage.nr6;
import com.repackage.vd6;
import com.repackage.ye6;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FrsSchoolRecommendAdapter extends id6<hq4, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nr6 t;

    /* loaded from: classes3.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public nr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, nr6 nr6Var) {
            super(nr6Var.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendAdapter, nr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nr6Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSchoolRecommendAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: l0 */
    public FrsSchoolRecommendViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.t = new nr6(this.k, this.e);
            return new FrsSchoolRecommendViewHolder(this, this.t);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.id6, com.repackage.ho
    /* renamed from: m0 */
    public View S(int i, View view2, ViewGroup viewGroup, hq4 hq4Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hq4Var, frsSchoolRecommendViewHolder})) == null) {
            super.S(i, view2, viewGroup, hq4Var, frsSchoolRecommendViewHolder);
            this.t = frsSchoolRecommendViewHolder.a;
            ArrayList<iq4> e = hq4Var.e();
            if (e.size() <= 0) {
                return null;
            }
            vd6 vd6Var = new vd6();
            vd6Var.showTopDivider = true;
            vd6Var.mGroupTitle = hq4Var.getTitle();
            for (int i2 = 0; i2 != e.size(); i2++) {
                iq4 iq4Var = e.get(i2);
                if (iq4Var != null) {
                    ye6 ye6Var = new ye6();
                    ye6Var.a.setUserId(iq4Var.d());
                    ye6Var.a.setUserName(iq4Var.e());
                    ye6Var.a.setPortrait(iq4Var.c());
                    ye6Var.a.getGodUserData().setIsLike(iq4Var.b() == 1);
                    ye6Var.a.getGodUserData().setIntro(iq4Var.a());
                    vd6Var.e(ye6Var);
                }
            }
            this.t.m(this.k, this.n);
            frsSchoolRecommendViewHolder.a.u(vd6Var);
            return frsSchoolRecommendViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
