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
import com.repackage.cd6;
import com.repackage.fe6;
import com.repackage.pc6;
import com.repackage.pq6;
import com.repackage.rq4;
import com.repackage.sq4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FrsSchoolRecommendAdapter extends pc6<rq4, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pq6 t;

    /* loaded from: classes3.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public pq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, pq6 pq6Var) {
            super(pq6Var.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendAdapter, pq6Var};
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
            this.a = pq6Var;
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
    @Override // com.repackage.eo
    /* renamed from: l0 */
    public FrsSchoolRecommendViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.t = new pq6(this.k, this.e);
            return new FrsSchoolRecommendViewHolder(this, this.t);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: m0 */
    public View S(int i, View view2, ViewGroup viewGroup, rq4 rq4Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rq4Var, frsSchoolRecommendViewHolder})) == null) {
            super.S(i, view2, viewGroup, rq4Var, frsSchoolRecommendViewHolder);
            this.t = frsSchoolRecommendViewHolder.a;
            ArrayList<sq4> e = rq4Var.e();
            if (e.size() <= 0) {
                return null;
            }
            cd6 cd6Var = new cd6();
            cd6Var.showTopDivider = true;
            cd6Var.mGroupTitle = rq4Var.getTitle();
            for (int i2 = 0; i2 != e.size(); i2++) {
                sq4 sq4Var = e.get(i2);
                if (sq4Var != null) {
                    fe6 fe6Var = new fe6();
                    fe6Var.a.setUserId(sq4Var.d());
                    fe6Var.a.setUserName(sq4Var.e());
                    fe6Var.a.setPortrait(sq4Var.c());
                    fe6Var.a.getGodUserData().setIsLike(sq4Var.b() == 1);
                    fe6Var.a.getGodUserData().setIntro(sq4Var.a());
                    cd6Var.e(fe6Var);
                }
            }
            this.t.m(this.k, this.n);
            frsSchoolRecommendViewHolder.a.u(cd6Var);
            return frsSchoolRecommendViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
