package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.a88;
import com.baidu.tieba.az4;
import com.baidu.tieba.bu7;
import com.baidu.tieba.gs7;
import com.baidu.tieba.us7;
import com.baidu.tieba.zy4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class FrsSchoolRecommendAdapter extends gs7<zy4, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a88 l;

    /* loaded from: classes6.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a88 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, a88 a88Var) {
            super(a88Var.i());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendAdapter, a88Var};
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
            this.a = a88Var;
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
    @Override // com.baidu.tieba.ci
    /* renamed from: H */
    public FrsSchoolRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            this.l = new a88(this.c, this.mPageId);
            return new FrsSchoolRecommendViewHolder(this, this.l);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gs7, com.baidu.tieba.ci
    /* renamed from: I */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zy4 zy4Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zy4Var, frsSchoolRecommendViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) zy4Var, (zy4) frsSchoolRecommendViewHolder);
            this.l = frsSchoolRecommendViewHolder.a;
            ArrayList<az4> c = zy4Var.c();
            if (c.size() <= 0) {
                return null;
            }
            us7 us7Var = new us7();
            us7Var.showTopDivider = true;
            us7Var.mGroupTitle = zy4Var.getTitle();
            for (int i2 = 0; i2 != c.size(); i2++) {
                az4 az4Var = c.get(i2);
                if (az4Var != null) {
                    bu7 bu7Var = new bu7();
                    bu7Var.a.setUserId(az4Var.d());
                    bu7Var.a.setUserName(az4Var.e());
                    bu7Var.a.setPortrait(az4Var.c());
                    GodUserData godUserData = bu7Var.a.getGodUserData();
                    if (az4Var.b() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    godUserData.setIsLike(z);
                    bu7Var.a.getGodUserData().setIntro(az4Var.a());
                    us7Var.c(bu7Var);
                }
            }
            this.l.k(this.c, this.f);
            frsSchoolRecommendViewHolder.a.j(us7Var);
            return frsSchoolRecommendViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
