package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.ck6;
import com.baidu.tieba.gx6;
import com.baidu.tieba.lu4;
import com.baidu.tieba.mu4;
import com.baidu.tieba.qk6;
import com.baidu.tieba.vl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FrsSchoolRecommendAdapter extends ck6<lu4, FrsSchoolRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gx6 l;

    /* loaded from: classes4.dex */
    public class FrsSchoolRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsSchoolRecommendViewHolder(FrsSchoolRecommendAdapter frsSchoolRecommendAdapter, gx6 gx6Var) {
            super(gx6Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSchoolRecommendAdapter, gx6Var};
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
            this.a = gx6Var;
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
    @Override // com.baidu.tieba.kn
    /* renamed from: E */
    public FrsSchoolRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            this.l = new gx6(this.c, this.mPageId);
            return new FrsSchoolRecommendViewHolder(this, this.l);
        }
        return (FrsSchoolRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ck6, com.baidu.tieba.kn
    /* renamed from: F */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lu4 lu4Var, FrsSchoolRecommendViewHolder frsSchoolRecommendViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lu4Var, frsSchoolRecommendViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) lu4Var, (lu4) frsSchoolRecommendViewHolder);
            this.l = frsSchoolRecommendViewHolder.a;
            ArrayList<mu4> c = lu4Var.c();
            if (c.size() <= 0) {
                return null;
            }
            qk6 qk6Var = new qk6();
            qk6Var.showTopDivider = true;
            qk6Var.mGroupTitle = lu4Var.getTitle();
            for (int i2 = 0; i2 != c.size(); i2++) {
                mu4 mu4Var = c.get(i2);
                if (mu4Var != null) {
                    vl6 vl6Var = new vl6();
                    vl6Var.a.setUserId(mu4Var.d());
                    vl6Var.a.setUserName(mu4Var.e());
                    vl6Var.a.setPortrait(mu4Var.c());
                    GodUserData godUserData = vl6Var.a.getGodUserData();
                    if (mu4Var.b() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    godUserData.setIsLike(z);
                    vl6Var.a.getGodUserData().setIntro(mu4Var.a());
                    qk6Var.c(vl6Var);
                }
            }
            this.l.j(this.c, this.f);
            frsSchoolRecommendViewHolder.a.t(qk6Var);
            return frsSchoolRecommendViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
