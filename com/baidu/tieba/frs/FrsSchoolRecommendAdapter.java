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
import com.repackage.af6;
import com.repackage.gq4;
import com.repackage.hq4;
import com.repackage.kd6;
import com.repackage.pr6;
import com.repackage.xd6;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FrsSchoolRecommendAdapter extends kd6<gq4, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pr6 t;

    /* loaded from: classes3.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public pr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, pr6 pr6Var) {
            super(pr6Var.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendAdapter, pr6Var};
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
            this.a = pr6Var;
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
            this.t = new pr6(this.k, this.e);
            return new FrsSchoolRecommendViewHolder(this, this.t);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.kd6, com.repackage.ho
    /* renamed from: m0 */
    public View S(int i, View view2, ViewGroup viewGroup, gq4 gq4Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gq4Var, frsSchoolRecommendViewHolder})) == null) {
            super.S(i, view2, viewGroup, gq4Var, frsSchoolRecommendViewHolder);
            this.t = frsSchoolRecommendViewHolder.a;
            ArrayList<hq4> e = gq4Var.e();
            if (e.size() <= 0) {
                return null;
            }
            xd6 xd6Var = new xd6();
            xd6Var.showTopDivider = true;
            xd6Var.mGroupTitle = gq4Var.getTitle();
            for (int i2 = 0; i2 != e.size(); i2++) {
                hq4 hq4Var = e.get(i2);
                if (hq4Var != null) {
                    af6 af6Var = new af6();
                    af6Var.a.setUserId(hq4Var.d());
                    af6Var.a.setUserName(hq4Var.e());
                    af6Var.a.setPortrait(hq4Var.c());
                    af6Var.a.getGodUserData().setIsLike(hq4Var.b() == 1);
                    af6Var.a.getGodUserData().setIntro(hq4Var.a());
                    xd6Var.e(af6Var);
                }
            }
            this.t.m(this.k, this.n);
            frsSchoolRecommendViewHolder.a.u(xd6Var);
            return frsSchoolRecommendViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
