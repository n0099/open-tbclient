package com.baidu.tieba.hottopic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.a0.b0;
import c.a.r0.a0.d0.l;
import c.a.r0.p2.e;
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
/* loaded from: classes7.dex */
public class HomePageVideoThreadAdapter extends c.a.e.l.e.a<l, HomePageVideoThreadViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<HotTopicActivity> n;
    public c.a.r0.a0.l o;
    public b0<l> p;

    /* loaded from: classes7.dex */
    public static class HomePageVideoThreadViewHolder extends TypeAdapter.ViewHolder implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.r0.a0.l mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageVideoThreadViewHolder(c.a.r0.a0.l lVar) {
            super(lVar.j());
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

        @Override // c.a.r0.p2.e
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.r0.a0.l lVar = this.mView;
                if (lVar == null) {
                    return 0;
                }
                return lVar.getCurrentPosition();
            }
            return invokeV.intValue;
        }

        @Override // c.a.r0.p2.e
        public String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.a.r0.a0.l lVar = this.mView;
                if (lVar == null) {
                    return null;
                }
                return lVar.Q();
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.r0.p2.e
        public View getVideoContainer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c.a.r0.a0.l lVar = this.mView;
                if (lVar == null) {
                    return null;
                }
                return lVar.R();
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.r0.p2.e
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.p2.e
        public boolean isPlayStarted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                c.a.r0.a0.l lVar = this.mView;
                if (lVar == null) {
                    return false;
                }
                return lVar.c0();
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.p2.e
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                c.a.r0.a0.l lVar = this.mView;
                if (lVar == null) {
                    return false;
                }
                return lVar.isPlaying();
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.p2.e
        public void startPlay() {
            c.a.r0.a0.l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (lVar = this.mView) == null) {
                return;
            }
            lVar.startPlay();
        }

        @Override // c.a.r0.p2.e
        public void stopPlay() {
            c.a.r0.a0.l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (lVar = this.mView) == null) {
                return;
            }
            lVar.stopPlay();
        }
    }

    /* loaded from: classes7.dex */
    public class a extends b0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageVideoThreadAdapter f52661b;

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
            this.f52661b = homePageVideoThreadAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a0.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) || lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().s1()) || StringUtils.isNull(lVar.C()) || this.f52661b.n == null || !(this.f52661b.n.getOrignalPage() instanceof c.a.r0.i1.b.a)) {
                return;
            }
            ((HotTopicActivity) this.f52661b.n.getOrignalPage()).businessStatisticForTopicClick(lVar);
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
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public HomePageVideoThreadViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            c.a.r0.a0.l lVar = new c.a.r0.a0.l(this.n);
            this.o = lVar;
            lVar.j0(false);
            this.o.f0(this.m);
            this.o.setFrom("hottopic");
            return new HomePageVideoThreadViewHolder(this.o);
        }
        return (HomePageVideoThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public View a0(int i2, View view, ViewGroup viewGroup, l lVar, HomePageVideoThreadViewHolder homePageVideoThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, homePageVideoThreadViewHolder})) == null) {
            if (lVar != null) {
                lVar.K(i2 + 1);
                lVar.W = 1;
            }
            homePageVideoThreadViewHolder.mView.k(lVar);
            homePageVideoThreadViewHolder.mView.m(this.p);
            TbPageContext<HotTopicActivity> tbPageContext = this.n;
            if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof c.a.r0.i1.b.a)) {
                this.n.getOrignalPage().businessStatisticForTopic(lVar);
            }
            return homePageVideoThreadViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
