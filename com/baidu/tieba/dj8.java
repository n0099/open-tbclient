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
public class dj8 extends kn<q56, CardAppLegoViewHolder> implements qi8, vi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public int b;
    public boolean c;
    public AdvertAppInfo.ILegoAdvert d;
    public String e;
    public Runnable f;
    public CustomMessageListener g;

    @Override // com.baidu.tieba.qi8
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.tieba.qi8
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements rl7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(dj8 dj8Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj8Var, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.baidu.tieba.rl7
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, hashMap) != null) || i == 0) {
                return;
            }
            if (aj8.h(i)) {
                mk8.g(this.a, this.b, hashMap, i);
            } else {
                mk8.n(this.a, this.b, this.c, null, hashMap);
            }
            zl7.c(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj8 a;

        public b(dj8 dj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj8Var;
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
        public final /* synthetic */ dj8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(dj8 dj8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj8Var, Integer.valueOf(i)};
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
            this.a = dj8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.viewholder == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof Boolean)) {
                ((CardAppLegoViewHolder) this.a.viewholder).stopPlay();
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                ((CardAppLegoViewHolder) this.a.viewholder).stopPlay();
            } else {
                int c = ((CardAppLegoViewHolder) this.a.viewholder).c();
                if (((CardAppLegoViewHolder) this.a.viewholder).b()) {
                    if (c == -1) {
                        ah.a().removeCallbacks(this.a.f);
                        ah.a().postDelayed(this.a.f, 500L);
                    }
                } else if (c != -1) {
                    ((CardAppLegoViewHolder) this.a.viewholder).stopPlay();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
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

    @Override // com.baidu.tieba.vi8
    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.c = z;
        }
    }

    public final boolean A(View view2) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.viewholder) == 0 || this.d == null || !((CardAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.viewholder).getClass()) || !(view2.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.d.isReusable((AdvertAppInfo.ILegoAdvert) view2.getTag(R.id.tag_first));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: B */
    public CardAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            if (this.d == null || (view2 = (View) sl7.h().a(this.a, this.d, 2)) == null) {
                return null;
            }
            view2.setTag(R.id.tag_first, this.d);
            return new CardAppLegoViewHolder((nm7) view2);
        }
        return (CardAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: C */
    public CardAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup, q56 q56Var) {
        InterceptResult invokeLL;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, q56Var)) == null) {
            if (q56Var != null && (advertAppInfo = q56Var.a) != null && (iLegoAdvert = advertAppInfo.h) != null) {
                this.d = iLegoAdvert;
                return onCreateViewHolder(viewGroup);
            }
            return null;
        }
        return (CardAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, q56 q56Var, CardAppLegoViewHolder cardAppLegoViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, q56Var, cardAppLegoViewHolder})) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext != null && q56Var != null && q56Var.a != null) {
                if (tbPageContext.getPageActivity() instanceof di0) {
                    AdvertAppInfo advertAppInfo = q56Var.a;
                    advertAppInfo.r = fi0.b(advertAppInfo.r, (di0) this.a.getPageActivity(), cardAppLegoViewHolder.itemView);
                }
                AdvertAppInfo.ILegoAdvert iLegoAdvert = q56Var.a.h;
                this.d = iLegoAdvert;
                if (iLegoAdvert != null && view2 != null) {
                    if (this.viewholder == 0) {
                        this.viewholder = cardAppLegoViewHolder;
                    }
                    as4.d(q56Var);
                    tq4 layoutMode = this.a.getLayoutMode();
                    if (this.b == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    layoutMode.l(z);
                    this.a.getLayoutMode().k(view2);
                    AdvertAppInfo c2 = q56Var.c();
                    c2.u = 1;
                    nm7 nm7Var = (nm7) view2;
                    this.d.setAdvertAppInfo(c2);
                    nm7Var.setFromCDN(this.c);
                    nm7Var.update(this.d);
                    int i2 = q56Var.c;
                    String str = q56Var.b;
                    ek8.e(q56Var.c(), nm7Var, str, this.e, 1, -1);
                    nm7Var.setAfterClickSchemeListener(new a(this, c2, i2, str));
                    if (ti8.class.isAssignableFrom(view2.getClass())) {
                        cardAppLegoViewHolder.d(((ti8) view2).getVideoOrVrView());
                    }
                    return view2;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.qi8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: z */
    public View getView(int i, View view2, ViewGroup viewGroup, q56 q56Var) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), view2, viewGroup, q56Var})) == null) {
            if (q56Var != null && (advertAppInfo = q56Var.a) != null && (iLegoAdvert = advertAppInfo.h) != null) {
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
                    view3 = onFillViewHolder(i, view3, viewGroup, q56Var, (CardAppLegoViewHolder) view3.getTag());
                    if (ti8.class.isAssignableFrom(view3.getClass())) {
                        ((CardAppLegoViewHolder) this.viewholder).d(((ti8) view3).getVideoOrVrView());
                    }
                }
                return view3;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
