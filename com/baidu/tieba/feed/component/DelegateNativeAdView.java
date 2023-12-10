package com.baidu.tieba.feed.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.kw4;
import com.baidu.tieba.lb7;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lha;
import com.baidu.tieba.lja;
import com.baidu.tieba.mb7;
import com.baidu.tieba.mg9;
import com.baidu.tieba.pha;
import com.baidu.tieba.qda;
import com.baidu.tieba.ra7;
import com.baidu.tieba.rf9;
import com.baidu.tieba.sf9;
import com.baidu.tieba.wha;
import com.baidu.tieba.xha;
import com.baidu.tieba.zf9;
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
public final class DelegateNativeAdView extends FrameLayout implements lb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final View b;
    public AdvertAppInfo c;

    /* loaded from: classes5.dex */
    public static final class a implements qda {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public lha a;

        @Override // com.baidu.tieba.qda
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
            if (pha.class.isAssignableFrom(view2.getClass())) {
                this.a = ((pha) view2).getVideoOrVrView();
            }
        }

        @Override // com.baidu.tieba.qda
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                lha lhaVar = this.a;
                if (lhaVar != null) {
                    return (int) lhaVar.getCurrentPosition();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.qda
        public String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                lha lhaVar = this.a;
                if (lhaVar == null) {
                    return "";
                }
                Intrinsics.checkNotNull(lhaVar);
                String playUrl = lhaVar.getPlayUrl();
                Intrinsics.checkNotNullExpressionValue(playUrl, "videoView!!.getPlayUrl()");
                return playUrl;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.qda
        public View getVideoContainer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                lha lhaVar = this.a;
                if (lhaVar != null) {
                    return lhaVar.getVideoContainer();
                }
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.qda
        public boolean isPlayStarted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                lha lhaVar = this.a;
                if (lhaVar != null) {
                    return lhaVar.isPlayStarted();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.qda
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                lha lhaVar = this.a;
                if (lhaVar != null) {
                    return lhaVar.isPlaying();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.qda
        public void startPlay() {
            lha lhaVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (lhaVar = this.a) != null) {
                lhaVar.startPlay();
            }
        }

        @Override // com.baidu.tieba.qda
        public void stopPlay() {
            lha lhaVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (lhaVar = this.a) != null) {
                lhaVar.stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements rf9 {
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

        @Override // com.baidu.tieba.rf9
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, hashMap) != null) || i == 0) {
                return;
            }
            if (xha.h(i)) {
                lja.g(this.a, 0, hashMap, i);
            } else {
                lja.n(this.a, 0, "", null, hashMap);
            }
            zf9.c(this.a);
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
            mg9 a2 = sf9.h().a(tbPageContext, iCardInfo, i);
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
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.c = data;
            if ((this.b instanceof mg9) && data.h != null) {
                ra7.a aVar = ra7.a;
                kw4 kw4Var = data.i;
                if (kw4Var != null) {
                    str = kw4Var.a;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                if (aVar.a(str)) {
                    kw4.b(data);
                } else {
                    kw4.d(data);
                }
                mg9<?> mg9Var = (mg9) this.b;
                mg9Var.setMulDel(data.w);
                mg9Var.h(data.h);
                wha.m().c(data, mg9Var, data.u, this.a, 1, -1);
                mg9Var.setAfterClickSchemeListener(new b(data));
                setTag(new a(this.b));
            }
        }
    }

    @Override // com.baidu.tieba.lb7
    public void f() {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || mb7.a(this)) {
            return;
        }
        View view2 = this.b;
        if ((view2 instanceof mg9) && (advertAppInfo = this.c) != null && (iLegoAdvert = advertAppInfo.h) != null) {
            ((mg9) view2).h(iLegoAdvert);
        }
    }
}
