package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.PbAppLegoViewHolder;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class b0a extends lh<oea, PbAppLegoViewHolder> implements oz9, jz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public boolean b;
    public boolean c;
    public boolean d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public WeakReference<PbAppLegoViewHolder> h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b0a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b0a b0aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0aVar, Integer.valueOf(i)};
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
            this.a = b0aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && this.a.c) {
                int c = ((PbAppLegoViewHolder) this.a.viewholder).c();
                if (((PbAppLegoViewHolder) this.a.viewholder).b()) {
                    if (c == -1) {
                        ((PbAppLegoViewHolder) this.a.viewholder).a((int) TimeUnit.SECONDS.toSeconds(1L));
                    }
                } else if (c != -1) {
                    ((PbAppLegoViewHolder) this.a.viewholder).stopPlay();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b0a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b0a b0aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0aVar, Integer.valueOf(i)};
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
            this.a = b0aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.updateFontSize();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b0a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b0a b0aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0aVar, Integer.valueOf(i)};
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
            this.a = b0aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                ((PbAppLegoViewHolder) this.a.viewholder).stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ry8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public d(b0a b0aVar, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0aVar, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.baidu.tieba.ry8
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, hashMap) != null) || i == 0) {
                return;
            }
            if (uz9.h(i)) {
                i1a.g(this.a, this.b, hashMap, i);
            } else {
                i1a.n(this.a, this.b, this.c, null, hashMap);
            }
            zy8.c(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId};
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
        this.c = true;
        this.e = new a(this, 2004013);
        this.f = new b(this, 2004018);
        this.g = new c(this, 2004020);
        this.h = null;
        this.a = baseFragmentActivity;
        baseFragmentActivity.registerListener(this.e);
        this.a.registerListener(this.g);
        this.a.registerListener(this.f);
    }

    public PbAppLegoViewHolder E(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
        }
        return (PbAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder' to match base method */
    @Override // com.baidu.tieba.lh
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        E(viewGroup);
        throw null;
    }

    @Override // com.baidu.tieba.oz9
    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.baidu.tieba.lh
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: C */
    public View getView(int i, View view2, ViewGroup viewGroup, oea oeaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, oeaVar})) == null) {
            if (oeaVar != null && oeaVar.G1() != null) {
                if (D(view2, oeaVar)) {
                    PbAppLegoViewHolder onCreateViewHolder = onCreateViewHolder(viewGroup, oeaVar);
                    this.viewholder = onCreateViewHolder;
                    if (onCreateViewHolder != null) {
                        view2 = onCreateViewHolder.getView();
                    }
                }
                View view3 = view2;
                if (view3 != null) {
                    view3 = onFillViewHolder(i, view3, viewGroup, oeaVar, (PbAppLegoViewHolder) view3.getTag());
                    if (mz9.class.isAssignableFrom(view3.getClass())) {
                        ((PbAppLegoViewHolder) this.viewholder).e(((mz9) view3).getVideoOrVrView());
                    }
                }
                return view3;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean D(View view2, oea oeaVar) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, oeaVar)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.viewholder) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.viewholder).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert G1 = oeaVar.G1();
            Object tag = view2.getTag(R.id.tag_first);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !G1.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: F */
    public PbAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup, oea oeaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, oeaVar)) == null) {
            View view2 = (View) sy8.h().a(this.a.getPageContext(), oeaVar.G1(), 4);
            if (view2 != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((mz8) view2);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: G */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, oea oeaVar, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, oeaVar, pbAppLegoViewHolder})) == null) {
            if (this.a == null) {
                return null;
            }
            if (oeaVar.G1() instanceof AdCard) {
                ((AdCard) oeaVar.G1()).isPBBanner = oeaVar.h1;
            }
            boolean z = false;
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert G1 = oeaVar.G1();
            view2.setTag(R.id.tag_first, G1);
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(view2);
            ov4.g(oeaVar);
            AdvertAppInfo advertAppInfo = oeaVar.getAdvertAppInfo();
            if (advertAppInfo.i == null) {
                advertAppInfo.i = new ov4();
            }
            ov4 ov4Var = advertAppInfo.i;
            ov4Var.b = oeaVar.m1;
            ov4Var.a = oeaVar.F1();
            advertAppInfo.position = oeaVar.o1;
            advertAppInfo.v = 3;
            int i2 = oeaVar.m1;
            String str = oeaVar.i1;
            advertAppInfo.u = str;
            mz8<?> mz8Var = (mz8) view2;
            mz8Var.setMulDel(this.d);
            G1.setAdvertAppInfo(advertAppInfo);
            mz8Var.setFromCDN(this.b);
            mz8Var.h(G1);
            H(oeaVar, mz8Var, str);
            Context context = this.mContext;
            if (context instanceof td0) {
                advertAppInfo.s = vd0.b(advertAppInfo.s, (td0) context, view2);
            }
            mz8Var.setAfterClickSchemeListener(new d(this, advertAppInfo, i2, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.h;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.h = new WeakReference<>(pbAppLegoViewHolder);
            }
            updateFontSize();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void H(oea oeaVar, mz8<?> mz8Var, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, oeaVar, mz8Var, str) == null) {
            if (oeaVar.h1) {
                i = oeaVar.p1;
            } else {
                i = oeaVar.p1;
                if (h06.k().m()) {
                    i++;
                }
            }
            b1a.e(oeaVar.getAdvertAppInfo(), mz8Var, str, null, 3, i);
        }
    }

    @Override // com.baidu.tieba.jz9
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (v = this.viewholder) != 0) {
            ((PbAppLegoViewHolder) v).d();
        }
    }

    @Override // com.baidu.tieba.jz9
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            V v = this.viewholder;
            if (v != 0) {
                ((PbAppLegoViewHolder) v).stopPlay();
            }
            this.c = false;
        }
    }

    public void updateFontSize() {
        PbAppLegoViewHolder pbAppLegoViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            WeakReference<PbAppLegoViewHolder> weakReference = this.h;
            if (weakReference != null) {
                pbAppLegoViewHolder = weakReference.get();
            } else {
                pbAppLegoViewHolder = null;
            }
            if (pbAppLegoViewHolder != null) {
                pbAppLegoViewHolder.f();
            }
        }
    }

    @Override // com.baidu.tieba.jz9
    public void onResume() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (v = this.viewholder) != 0 && ((PbAppLegoViewHolder) v).b()) {
            if (((PbAppLegoViewHolder) this.viewholder).c() == -1) {
                ((PbAppLegoViewHolder) this.viewholder).a((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.c = true;
        }
    }
}
