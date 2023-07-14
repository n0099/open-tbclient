package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
public class az9 extends yh7<AdvertAppInfo, FrsAppLegoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo.ILegoAdvert l;
    public qy9 m;
    public String n;

    /* loaded from: classes5.dex */
    public class a implements tz8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(az9 az9Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az9Var, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.baidu.tieba.tz8
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) {
                if (vy9.h(i)) {
                    j0a.g(this.a, this.b, hashMap, i);
                } else {
                    j0a.n(this.a, this.b, this.c, null, hashMap);
                }
                b09.c(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az9(qy9 qy9Var, BdUniqueId bdUniqueId, String str) {
        super(qy9Var.t(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qy9Var, bdUniqueId, str};
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
        this.m = qy9Var;
        this.n = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: G */
    public View getView(int i, View view2, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeCommon;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, advertAppInfo})) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null) {
                return null;
            }
            this.l = iLegoAdvert;
            if (H(view2)) {
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

    public final boolean H(View view2) {
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
    @Override // com.baidu.tieba.ln
    /* renamed from: I */
    public FrsAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (this.l == null || (view2 = (View) uz8.h().a(this.c, this.l, 1)) == null) {
                return null;
            }
            view2.setTag(R.id.tag_first, this.l);
            return new FrsAppLegoViewHolder((p09) view2);
        }
        return (FrsAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: J */
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
    @Override // com.baidu.tieba.yh7, com.baidu.tieba.ln
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
            if (this.c.getPageActivity() instanceof vj0) {
                advertAppInfo.s = xj0.b(advertAppInfo.s, (vj0) this.c.getPageActivity(), frsAppLegoViewHolder.itemView);
            }
            q05 layoutMode = this.c.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.c.getLayoutMode().k(view2);
            String d0 = this.m.d0();
            int r1 = this.m.r1();
            y15.b(advertAppInfo);
            advertAppInfo.u = d0;
            advertAppInfo.v = 2;
            p09 p09Var = (p09) view2;
            p09Var.setFromCDN(this.a);
            p09Var.update(this.l);
            b0a.e(advertAppInfo, p09Var, d0, this.n, 2, -1);
            this.m.v0();
            p09Var.setAfterClickSchemeListener(new a(this, advertAppInfo, r1, d0));
            if (ny9.class.isAssignableFrom(view2.getClass())) {
                frsAppLegoViewHolder.c(((ny9) view2).getVideoOrVrView());
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

    @Override // com.baidu.tieba.yh7
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            V v = this.viewholder;
            if (v != 0) {
                ((FrsAppLegoViewHolder) v).b();
            }
            super.x();
        }
    }
}
