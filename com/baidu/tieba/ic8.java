package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.CardAppLegoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class ic8 extends cn<n06, CardAppLegoViewHolder> implements vb8, ac8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public int b;
    public boolean c;
    public AdvertAppInfo.ILegoAdvert d;
    public String e;
    public Runnable f;
    public CustomMessageListener g;

    /* loaded from: classes4.dex */
    public class a implements te7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(ic8 ic8Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ic8Var, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.baidu.tieba.te7
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) || i == 0) {
                return;
            }
            if (fc8.h(i)) {
                rd8.g(this.a, this.b, hashMap, i);
            } else {
                rd8.n(this.a, this.b, this.c, null, hashMap);
            }
            bf7.c(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic8 a;

        public b(ic8 ic8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ic8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ic8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((CardAppLegoViewHolder) this.a.viewholder).a((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ic8 ic8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ic8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ic8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.viewholder == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof Boolean)) {
                ((CardAppLegoViewHolder) this.a.viewholder).stopPlay();
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                ((CardAppLegoViewHolder) this.a.viewholder).stopPlay();
            } else {
                int c = ((CardAppLegoViewHolder) this.a.viewholder).c();
                if (!((CardAppLegoViewHolder) this.a.viewholder).b()) {
                    if (c != -1) {
                        ((CardAppLegoViewHolder) this.a.viewholder).stopPlay();
                    }
                } else if (c == -1) {
                    sg.a().removeCallbacks(this.a.f);
                    sg.a().postDelayed(this.a.f, 500L);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ic8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.c = false;
        this.d = null;
        this.e = null;
        this.f = new b(this);
        this.g = new c(this, 2921517);
        this.a = tbPageContext;
        this.e = str;
        if ((tbPageContext.getPageActivity() instanceof BaseFragmentActivity) && TextUtils.equals(str, "CONCERN")) {
            if (bdUniqueId == AdvertAppInfo.C || bdUniqueId == AdvertAppInfo.E) {
                MessageManager.getInstance().registerListener(this.g);
            }
        }
    }

    public final boolean A(View view2) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.viewholder) == 0 || this.d == null || !((CardAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.viewholder).getClass()) || !(view2.getTag(R.id.obfuscated_res_0x7f091ff4) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.d.isReusable((AdvertAppInfo.ILegoAdvert) view2.getTag(R.id.obfuscated_res_0x7f091ff4));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: B */
    public CardAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            if (this.d == null || (view2 = (View) ue7.h().a(this.a, this.d, 2)) == null) {
                return null;
            }
            view2.setTag(R.id.obfuscated_res_0x7f091ff4, this.d);
            return new CardAppLegoViewHolder((pf7) view2);
        }
        return (CardAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: C */
    public CardAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup, n06 n06Var) {
        InterceptResult invokeLL;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, n06Var)) == null) {
            if (n06Var == null || (advertAppInfo = n06Var.a) == null || (iLegoAdvert = advertAppInfo.h) == null) {
                return null;
            }
            this.d = iLegoAdvert;
            return onCreateViewHolder(viewGroup);
        }
        return (CardAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n06 n06Var, CardAppLegoViewHolder cardAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n06Var, cardAppLegoViewHolder})) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext != null && n06Var != null && n06Var.a != null) {
                if (tbPageContext.getPageActivity() instanceof ig0) {
                    AdvertAppInfo advertAppInfo = n06Var.a;
                    advertAppInfo.r = kg0.b(advertAppInfo.r, (ig0) this.a.getPageActivity(), cardAppLegoViewHolder.itemView);
                }
                AdvertAppInfo.ILegoAdvert iLegoAdvert = n06Var.a.h;
                this.d = iLegoAdvert;
                if (iLegoAdvert != null && view2 != null) {
                    if (this.viewholder == 0) {
                        this.viewholder = cardAppLegoViewHolder;
                    }
                    lo4.d(n06Var);
                    this.a.getLayoutMode().l(this.b == 1);
                    this.a.getLayoutMode().k(view2);
                    AdvertAppInfo c2 = n06Var.c();
                    c2.u = 1;
                    pf7 pf7Var = (pf7) view2;
                    this.d.setAdvertAppInfo(c2);
                    pf7Var.setFromCDN(this.c);
                    pf7Var.update(this.d);
                    int i2 = n06Var.c;
                    String str = n06Var.b;
                    jd8.e(n06Var.c(), pf7Var, str, this.e, 1, -1);
                    pf7Var.setAfterClickSchemeListener(new a(this, c2, i2, str));
                    if (yb8.class.isAssignableFrom(view2.getClass())) {
                        cardAppLegoViewHolder.d(((yb8) view2).getVideoOrVrView());
                    }
                    return view2;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.vb8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    @Override // com.baidu.tieba.vb8
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.tieba.vb8
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ac8
    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.c = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: z */
    public View getView(int i, View view2, ViewGroup viewGroup, n06 n06Var) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n06Var})) == null) {
            if (n06Var == null || (advertAppInfo = n06Var.a) == null || (iLegoAdvert = advertAppInfo.h) == null) {
                return null;
            }
            this.d = iLegoAdvert;
            if (A(view2)) {
                CardAppLegoViewHolder onCreateViewHolder = onCreateViewHolder(viewGroup);
                this.viewholder = onCreateViewHolder;
                if (onCreateViewHolder != null) {
                    view2 = onCreateViewHolder.getView();
                }
            }
            View view3 = view2;
            if (view3 != null) {
                view3 = onFillViewHolder(i, view3, viewGroup, n06Var, (CardAppLegoViewHolder) view3.getTag());
                if (yb8.class.isAssignableFrom(view3.getClass())) {
                    ((CardAppLegoViewHolder) this.viewholder).d(((yb8) view3).getVideoOrVrView());
                }
            }
            return view3;
        }
        return (View) invokeCommon.objValue;
    }
}
