package com.baidu.tieba.feed.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.dc9;
import com.baidu.tieba.gw4;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.nca;
import com.baidu.tieba.nea;
import com.baidu.tieba.o8a;
import com.baidu.tieba.qc9;
import com.baidu.tieba.rca;
import com.baidu.tieba.sa7;
import com.baidu.tieba.ta7;
import com.baidu.tieba.vb9;
import com.baidu.tieba.wb9;
import com.baidu.tieba.yca;
import com.baidu.tieba.zca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/feed/component/DelegateNativeAdView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "typeCardInfo", "Lcom/baidu/tieba/lego/card/model/ICardInfo;", "businessType", "", "formTab", "", "(Landroid/content/Context;Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/lego/card/model/ICardInfo;ILjava/lang/String;)V", "curData", "Lcom/baidu/tbadk/core/data/AdvertAppInfo;", "realView", "Landroid/view/View;", "onChangeSkin", "", "updateAdView", "data", "ViewHolder", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public final class DelegateNativeAdView extends FrameLayout implements sa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final View b;
    public AdvertAppInfo c;

    /* loaded from: classes5.dex */
    public static final class a implements o8a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public nca a;

        @Override // com.baidu.tieba.o8a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(view2, "view");
            if (rca.class.isAssignableFrom(view2.getClass())) {
                this.a = ((rca) view2).getVideoOrVrView();
            }
        }

        @Override // com.baidu.tieba.o8a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                nca ncaVar = this.a;
                if (ncaVar != null) {
                    return (int) ncaVar.getCurrentPosition();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.o8a
        public String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                nca ncaVar = this.a;
                if (ncaVar == null) {
                    return "";
                }
                Intrinsics.checkNotNull(ncaVar);
                String playUrl = ncaVar.getPlayUrl();
                Intrinsics.checkNotNullExpressionValue(playUrl, "videoView!!.getPlayUrl()");
                return playUrl;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.o8a
        public View getVideoContainer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                nca ncaVar = this.a;
                if (ncaVar != null) {
                    return ncaVar.getVideoContainer();
                }
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.o8a
        public boolean isPlayStarted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                nca ncaVar = this.a;
                if (ncaVar != null) {
                    return ncaVar.isPlayStarted();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.o8a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                nca ncaVar = this.a;
                if (ncaVar != null) {
                    return ncaVar.isPlaying();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.o8a
        public void startPlay() {
            nca ncaVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ncaVar = this.a) != null) {
                ncaVar.startPlay();
            }
        }

        @Override // com.baidu.tieba.o8a
        public void stopPlay() {
            nca ncaVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (ncaVar = this.a) != null) {
                ncaVar.stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements vb9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;

        public b(AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {advertAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advertAppInfo;
        }

        @Override // com.baidu.tieba.vb9
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, hashMap) != null) || i == 0) {
                return;
            }
            if (zca.h(i)) {
                nea.g(this.a, 0, hashMap, i);
            } else {
                nea.n(this.a, 0, "", null, hashMap);
            }
            dc9.c(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DelegateNativeAdView(Context context, TbPageContext<?> tbPageContext, ICardInfo iCardInfo, int i, String str) {
        super(context);
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tbPageContext, iCardInfo, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = str;
        if (tbPageContext == null && (context instanceof TbPageContext)) {
            tbPageContext = (TbPageContext) context;
        }
        if (tbPageContext != null && iCardInfo != null) {
            qc9 a2 = wb9.h().a(tbPageContext, iCardInfo, i);
            if (a2 instanceof View) {
                view2 = (View) a2;
                view2 = view2 == null ? new View(context) : view2;
                this.b = view2;
                addView(view2, new FrameLayout.LayoutParams(-1, -2));
            }
        }
        view2 = null;
        if (view2 == null) {
        }
        this.b = view2;
        addView(view2, new FrameLayout.LayoutParams(-1, -2));
    }

    public final void a(AdvertAppInfo data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.c = data;
            if ((this.b instanceof qc9) && data.h != null) {
                gw4.d(data);
                qc9<?> qc9Var = (qc9) this.b;
                qc9Var.setMulDel(data.w);
                qc9Var.h(data.h);
                yca.m().c(data, qc9Var, data.u, this.a, 1, -1);
                qc9Var.setAfterClickSchemeListener(new b(data));
                setTag(new a(this.b));
            }
        }
    }

    @Override // com.baidu.tieba.sa7
    public void r() {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || ta7.a(this)) {
            return;
        }
        View view2 = this.b;
        if ((view2 instanceof qc9) && (advertAppInfo = this.c) != null && (iLegoAdvert = advertAppInfo.h) != null) {
            ((qc9) view2).h(iLegoAdvert);
        }
    }
}
