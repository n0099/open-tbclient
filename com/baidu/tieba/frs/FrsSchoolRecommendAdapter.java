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
import com.repackage.fb6;
import com.repackage.gp4;
import com.repackage.hp4;
import com.repackage.sb6;
import com.repackage.vo6;
import com.repackage.wc6;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FrsSchoolRecommendAdapter extends fb6<gp4, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vo6 t;

    /* loaded from: classes3.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vo6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, vo6 vo6Var) {
            super(vo6Var.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendAdapter, vo6Var};
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
            this.a = vo6Var;
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
    @Override // com.repackage.wm
    /* renamed from: l0 */
    public FrsSchoolRecommendViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.t = new vo6(this.k, this.e);
            return new FrsSchoolRecommendViewHolder(this, this.t);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fb6, com.repackage.wm
    /* renamed from: m0 */
    public View S(int i, View view2, ViewGroup viewGroup, gp4 gp4Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gp4Var, frsSchoolRecommendViewHolder})) == null) {
            super.S(i, view2, viewGroup, gp4Var, frsSchoolRecommendViewHolder);
            this.t = frsSchoolRecommendViewHolder.a;
            ArrayList<hp4> e = gp4Var.e();
            if (e.size() <= 0) {
                return null;
            }
            sb6 sb6Var = new sb6();
            sb6Var.showTopDivider = true;
            sb6Var.mGroupTitle = gp4Var.getTitle();
            for (int i2 = 0; i2 != e.size(); i2++) {
                hp4 hp4Var = e.get(i2);
                if (hp4Var != null) {
                    wc6 wc6Var = new wc6();
                    wc6Var.a.setUserId(hp4Var.d());
                    wc6Var.a.setUserName(hp4Var.e());
                    wc6Var.a.setPortrait(hp4Var.c());
                    wc6Var.a.getGodUserData().setIsLike(hp4Var.b() == 1);
                    wc6Var.a.getGodUserData().setIntro(hp4Var.a());
                    sb6Var.e(wc6Var);
                }
            }
            this.t.m(this.k, this.n);
            frsSchoolRecommendViewHolder.a.u(sb6Var);
            return frsSchoolRecommendViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
