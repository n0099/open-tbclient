package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.fi7;
import com.baidu.tieba.ti7;
import com.baidu.tieba.tx7;
import com.baidu.tieba.u35;
import com.baidu.tieba.v35;
import com.baidu.tieba.zj7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class FrsSchoolRecommendAdapter extends fi7<u35, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tx7 l;

    /* loaded from: classes5.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public tx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, tx7 tx7Var) {
            super(tx7Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendAdapter, tx7Var};
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
            this.a = tx7Var;
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
    @Override // com.baidu.tieba.pm
    /* renamed from: G */
    public FrsSchoolRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            this.l = new tx7(this.c, this.mPageId);
            return new FrsSchoolRecommendViewHolder(this, this.l);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fi7, com.baidu.tieba.pm
    /* renamed from: H */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, u35 u35Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, u35Var, frsSchoolRecommendViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) u35Var, (u35) frsSchoolRecommendViewHolder);
            this.l = frsSchoolRecommendViewHolder.a;
            ArrayList<v35> c = u35Var.c();
            if (c.size() <= 0) {
                return null;
            }
            ti7 ti7Var = new ti7();
            ti7Var.showTopDivider = true;
            ti7Var.mGroupTitle = u35Var.getTitle();
            for (int i2 = 0; i2 != c.size(); i2++) {
                v35 v35Var = c.get(i2);
                if (v35Var != null) {
                    zj7 zj7Var = new zj7();
                    zj7Var.a.setUserId(v35Var.d());
                    zj7Var.a.setUserName(v35Var.e());
                    zj7Var.a.setPortrait(v35Var.c());
                    GodUserData godUserData = zj7Var.a.getGodUserData();
                    if (v35Var.b() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    godUserData.setIsLike(z);
                    zj7Var.a.getGodUserData().setIntro(v35Var.a());
                    ti7Var.c(zj7Var);
                }
            }
            this.l.j(this.c, this.f);
            frsSchoolRecommendViewHolder.a.t(ti7Var);
            return frsSchoolRecommendViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
