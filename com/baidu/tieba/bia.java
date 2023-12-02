package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.FrsAppLegoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class bia extends gs7<AdvertAppInfo, FrsAppLegoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo.ILegoAdvert l;
    public rha m;
    public String n;

    /* loaded from: classes5.dex */
    public class a implements qf9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(bia biaVar, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biaVar, advertAppInfo, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advertAppInfo;
            this.b = i;
            this.c = str;
        }

        @Override // com.baidu.tieba.qf9
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) {
                if (wha.h(i)) {
                    kja.g(this.a, this.b, hashMap, i);
                } else {
                    kja.n(this.a, this.b, this.c, null, hashMap);
                }
                yf9.c(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bia(rha rhaVar, BdUniqueId bdUniqueId, String str) {
        super(rhaVar.I(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rhaVar, bdUniqueId, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = rhaVar;
        this.n = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: H */
    public View getView(int i, View view2, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeCommon;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, advertAppInfo})) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null) {
                return null;
            }
            this.l = iLegoAdvert;
            if (I(view2)) {
                FrsAppLegoViewHolder onCreateViewHolder = onCreateViewHolder(viewGroup);
                this.viewholder = onCreateViewHolder;
                if (onCreateViewHolder == null) {
                    return null;
                }
                view2 = onCreateViewHolder.getView();
            }
            View view3 = view2;
            return onFillViewHolder(i, view3, viewGroup, advertAppInfo, (FrsAppLegoViewHolder) view3.getTag());
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean I(View view2) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.viewholder) == 0 || this.l == null || !((FrsAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.viewholder).getClass()) || !(view2.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.l.isReusable((AdvertAppInfo.ILegoAdvert) view2.getTag(R.id.tag_first));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: J */
    public FrsAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (this.l == null || (view2 = (View) rf9.h().a(this.c, this.l, 1)) == null) {
                return null;
            }
            view2.setTag(R.id.tag_first, this.l);
            return new FrsAppLegoViewHolder((lg9) view2);
        }
        return (FrsAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: K */
    public FrsAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeLL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, advertAppInfo)) == null) {
            if (advertAppInfo != null && (iLegoAdvert = advertAppInfo.h) != null) {
                this.l = iLegoAdvert;
                return onCreateViewHolder(viewGroup);
            }
            return null;
        }
        return (FrsAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gs7, com.baidu.tieba.ci
    /* renamed from: L */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, advertAppInfo, frsAppLegoViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) advertAppInfo, (AdvertAppInfo) frsAppLegoViewHolder);
            if (this.m == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.h;
            this.l = iLegoAdvert;
            if (iLegoAdvert == null || view2 == null) {
                return null;
            }
            if (this.c.getPageActivity() instanceof le0) {
                advertAppInfo.s = ne0.b(advertAppInfo.s, (le0) this.c.getPageActivity(), frsAppLegoViewHolder.itemView);
            }
            BDLayoutMode layoutMode = this.c.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.c.getLayoutMode().onModeChanged(view2);
            String C0 = this.m.C0();
            int m2 = this.m.m2();
            kw4.b(advertAppInfo);
            advertAppInfo.u = C0;
            advertAppInfo.v = 2;
            lg9 lg9Var = (lg9) view2;
            lg9Var.setFromCDN(this.a);
            lg9Var.h(this.l);
            dja.e(advertAppInfo, lg9Var, C0, this.n, 2, -1);
            this.m.Z0();
            lg9Var.setAfterClickSchemeListener(new a(this, advertAppInfo, m2, C0));
            if (oha.class.isAssignableFrom(view2.getClass())) {
                frsAppLegoViewHolder.b(((oha) view2).getVideoOrVrView());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.gs7
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            V v = this.viewholder;
            if (v != 0) {
                ((FrsAppLegoViewHolder) v).a();
            }
            super.y();
        }
    }
}
