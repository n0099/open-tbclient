package com.baidu.tieba.hottopic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.a0.b0;
import d.a.p0.a0.e0.l;
import d.a.p0.n2.e;
/* loaded from: classes4.dex */
public class HomePageVideoThreadAdapter extends d.a.c.k.e.a<l, HomePageVideoThreadViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<HotTopicActivity> n;
    public d.a.p0.a0.l o;
    public b0<l> p;

    /* loaded from: classes4.dex */
    public static class HomePageVideoThreadViewHolder extends TypeAdapter.ViewHolder implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.p0.a0.l f17053e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageVideoThreadViewHolder(d.a.p0.a0.l lVar) {
            super(lVar.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17053e = lVar;
        }

        @Override // d.a.p0.n2.e
        public boolean C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.p0.n2.e
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                d.a.p0.a0.l lVar = this.f17053e;
                if (lVar == null) {
                    return 0;
                }
                return lVar.getCurrentPosition();
            }
            return invokeV.intValue;
        }

        @Override // d.a.p0.n2.e
        public String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                d.a.p0.a0.l lVar = this.f17053e;
                if (lVar == null) {
                    return null;
                }
                return lVar.N();
            }
            return (String) invokeV.objValue;
        }

        @Override // d.a.p0.n2.e
        public View getVideoContainer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                d.a.p0.a0.l lVar = this.f17053e;
                if (lVar == null) {
                    return null;
                }
                return lVar.O();
            }
            return (View) invokeV.objValue;
        }

        @Override // d.a.p0.n2.e
        public boolean isPlayStarted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                d.a.p0.a0.l lVar = this.f17053e;
                if (lVar == null) {
                    return false;
                }
                return lVar.a0();
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.p0.n2.e
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                d.a.p0.a0.l lVar = this.f17053e;
                if (lVar == null) {
                    return false;
                }
                return lVar.isPlaying();
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.p0.n2.e
        public void startPlay() {
            d.a.p0.a0.l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (lVar = this.f17053e) == null) {
                return;
            }
            lVar.startPlay();
        }

        @Override // d.a.p0.n2.e
        public void stopPlay() {
            d.a.p0.a0.l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (lVar = this.f17053e) == null) {
                return;
            }
            lVar.stopPlay();
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageVideoThreadAdapter f17054b;

        public a(HomePageVideoThreadAdapter homePageVideoThreadAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageVideoThreadAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17054b = homePageVideoThreadAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) || lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().n1()) || StringUtils.isNull(lVar.A()) || this.f17054b.n == null || !(this.f17054b.n.getOrignalPage() instanceof d.a.p0.g1.b.a)) {
                return;
            }
            ((HotTopicActivity) this.f17054b.n.getOrignalPage()).businessStatisticForTopicClick(lVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageVideoThreadAdapter(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.n = tbPageContext;
        this.m = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public HomePageVideoThreadViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            d.a.p0.a0.l lVar = new d.a.p0.a0.l(this.n);
            this.o = lVar;
            lVar.i0(false);
            this.o.d0(this.m);
            this.o.setFrom("hottopic");
            return new HomePageVideoThreadViewHolder(this.o);
        }
        return (HomePageVideoThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, l lVar, HomePageVideoThreadViewHolder homePageVideoThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, homePageVideoThreadViewHolder})) == null) {
            if (lVar != null) {
                lVar.I(i2 + 1);
                lVar.W = 1;
            }
            homePageVideoThreadViewHolder.f17053e.l(lVar);
            homePageVideoThreadViewHolder.f17053e.n(this.p);
            TbPageContext<HotTopicActivity> tbPageContext = this.n;
            if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof d.a.p0.g1.b.a)) {
                this.n.getOrignalPage().businessStatisticForTopic(lVar);
            }
            return homePageVideoThreadViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
