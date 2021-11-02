package com.baidu.tieba.hottopic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.b0.c0;
import b.a.r0.b0.e0.l;
import b.a.r0.q2.e;
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
/* loaded from: classes9.dex */
public class HomePageVideoThreadAdapter extends b.a.e.l.e.a<l, HomePageVideoThreadViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<HotTopicActivity> n;
    public b.a.r0.b0.l o;
    public c0<l> p;

    /* loaded from: classes9.dex */
    public static class HomePageVideoThreadViewHolder extends TypeAdapter.ViewHolder implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b.a.r0.b0.l mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageVideoThreadViewHolder(b.a.r0.b0.l lVar) {
            super(lVar.i());
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
            this.mView = lVar;
        }

        @Override // b.a.r0.q2.e
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.r0.b0.l lVar = this.mView;
                if (lVar == null) {
                    return 0;
                }
                return lVar.getCurrentPosition();
            }
            return invokeV.intValue;
        }

        @Override // b.a.r0.q2.e
        public String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b.a.r0.b0.l lVar = this.mView;
                if (lVar == null) {
                    return null;
                }
                return lVar.P();
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.r0.q2.e
        public View getVideoContainer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                b.a.r0.b0.l lVar = this.mView;
                if (lVar == null) {
                    return null;
                }
                return lVar.Q();
            }
            return (View) invokeV.objValue;
        }

        @Override // b.a.r0.q2.e
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // b.a.r0.q2.e
        public boolean isPlayStarted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                b.a.r0.b0.l lVar = this.mView;
                if (lVar == null) {
                    return false;
                }
                return lVar.b0();
            }
            return invokeV.booleanValue;
        }

        @Override // b.a.r0.q2.e
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                b.a.r0.b0.l lVar = this.mView;
                if (lVar == null) {
                    return false;
                }
                return lVar.isPlaying();
            }
            return invokeV.booleanValue;
        }

        @Override // b.a.r0.q2.e
        public void startPlay() {
            b.a.r0.b0.l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (lVar = this.mView) == null) {
                return;
            }
            lVar.startPlay();
        }

        @Override // b.a.r0.q2.e
        public void stopPlay() {
            b.a.r0.b0.l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (lVar = this.mView) == null) {
                return;
            }
            lVar.stopPlay();
        }
    }

    /* loaded from: classes9.dex */
    public class a extends c0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageVideoThreadAdapter f49984b;

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
            this.f49984b = homePageVideoThreadAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) || lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().s1()) || StringUtils.isNull(lVar.C()) || this.f49984b.n == null || !(this.f49984b.n.getOrignalPage() instanceof b.a.r0.j1.k.a)) {
                return;
            }
            ((HotTopicActivity) this.f49984b.n.getOrignalPage()).businessStatisticForTopicClick(lVar);
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
    @Override // b.a.e.l.e.a
    /* renamed from: h0 */
    public HomePageVideoThreadViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b.a.r0.b0.l lVar = new b.a.r0.b0.l(this.n);
            this.o = lVar;
            lVar.i0(false);
            this.o.e0(this.m);
            this.o.setFrom("hottopic");
            return new HomePageVideoThreadViewHolder(this.o);
        }
        return (HomePageVideoThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: i0 */
    public View Z(int i2, View view, ViewGroup viewGroup, l lVar, HomePageVideoThreadViewHolder homePageVideoThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, homePageVideoThreadViewHolder})) == null) {
            if (lVar != null) {
                lVar.K(i2 + 1);
                lVar.W = 1;
            }
            homePageVideoThreadViewHolder.mView.j(lVar);
            homePageVideoThreadViewHolder.mView.l(this.p);
            TbPageContext<HotTopicActivity> tbPageContext = this.n;
            if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof b.a.r0.j1.k.a)) {
                this.n.getOrignalPage().businessStatisticForTopic(lVar);
            }
            return homePageVideoThreadViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
