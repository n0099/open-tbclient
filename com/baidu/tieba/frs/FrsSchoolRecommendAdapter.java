package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.fx7;
import com.baidu.tieba.m45;
import com.baidu.tieba.mi7;
import com.baidu.tieba.n45;
import com.baidu.tieba.sj7;
import com.baidu.tieba.yh7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class FrsSchoolRecommendAdapter extends yh7<m45, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fx7 l;

    /* loaded from: classes5.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, fx7 fx7Var) {
            super(fx7Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendAdapter, fx7Var};
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
            this.a = fx7Var;
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
    @Override // com.baidu.tieba.ln
    /* renamed from: G */
    public FrsSchoolRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            this.l = new fx7(this.c, this.mPageId);
            return new FrsSchoolRecommendViewHolder(this, this.l);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yh7, com.baidu.tieba.ln
    /* renamed from: H */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, m45 m45Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, m45Var, frsSchoolRecommendViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) m45Var, (m45) frsSchoolRecommendViewHolder);
            this.l = frsSchoolRecommendViewHolder.a;
            ArrayList<n45> c = m45Var.c();
            if (c.size() <= 0) {
                return null;
            }
            mi7 mi7Var = new mi7();
            mi7Var.showTopDivider = true;
            mi7Var.mGroupTitle = m45Var.getTitle();
            for (int i2 = 0; i2 != c.size(); i2++) {
                n45 n45Var = c.get(i2);
                if (n45Var != null) {
                    sj7 sj7Var = new sj7();
                    sj7Var.a.setUserId(n45Var.d());
                    sj7Var.a.setUserName(n45Var.e());
                    sj7Var.a.setPortrait(n45Var.c());
                    GodUserData godUserData = sj7Var.a.getGodUserData();
                    if (n45Var.b() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    godUserData.setIsLike(z);
                    sj7Var.a.getGodUserData().setIntro(n45Var.a());
                    mi7Var.c(sj7Var);
                }
            }
            this.l.j(this.c, this.f);
            frsSchoolRecommendViewHolder.a.t(mi7Var);
            return frsSchoolRecommendViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
