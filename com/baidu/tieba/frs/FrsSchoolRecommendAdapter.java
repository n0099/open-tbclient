package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.ij6;
import com.baidu.tieba.iu4;
import com.baidu.tieba.ju4;
import com.baidu.tieba.nk6;
import com.baidu.tieba.ui6;
import com.baidu.tieba.xv6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendAdapter extends ui6<iu4, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xv6 l;

    /* loaded from: classes4.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public xv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, xv6 xv6Var) {
            super(xv6Var.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendAdapter, xv6Var};
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
            this.a = xv6Var;
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
    @Override // com.baidu.tieba.jn
    /* renamed from: E */
    public FrsSchoolRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            this.l = new xv6(this.c, this.mPageId);
            return new FrsSchoolRecommendViewHolder(this, this.l);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ui6, com.baidu.tieba.jn
    /* renamed from: F */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, iu4 iu4Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, iu4Var, frsSchoolRecommendViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, iu4Var, frsSchoolRecommendViewHolder);
            this.l = frsSchoolRecommendViewHolder.a;
            ArrayList<ju4> c = iu4Var.c();
            if (c.size() <= 0) {
                return null;
            }
            ij6 ij6Var = new ij6();
            ij6Var.showTopDivider = true;
            ij6Var.mGroupTitle = iu4Var.getTitle();
            for (int i2 = 0; i2 != c.size(); i2++) {
                ju4 ju4Var = c.get(i2);
                if (ju4Var != null) {
                    nk6 nk6Var = new nk6();
                    nk6Var.a.setUserId(ju4Var.d());
                    nk6Var.a.setUserName(ju4Var.e());
                    nk6Var.a.setPortrait(ju4Var.c());
                    GodUserData godUserData = nk6Var.a.getGodUserData();
                    if (ju4Var.b() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    godUserData.setIsLike(z);
                    nk6Var.a.getGodUserData().setIntro(ju4Var.a());
                    ij6Var.c(nk6Var);
                }
            }
            this.l.m(this.c, this.f);
            frsSchoolRecommendViewHolder.a.t(ij6Var);
            return frsSchoolRecommendViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
