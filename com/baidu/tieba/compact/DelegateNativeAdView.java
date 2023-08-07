package com.baidu.tieba.compact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.az9;
import com.baidu.tieba.ky8;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lx9;
import com.baidu.tieba.mx9;
import com.baidu.tieba.n97;
import com.baidu.tieba.o97;
import com.baidu.tieba.px8;
import com.baidu.tieba.qx8;
import com.baidu.tieba.v05;
import com.baidu.tieba.vp6;
import com.baidu.tieba.xx8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/compact/DelegateNativeAdView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "typeCardInfo", "Lcom/baidu/tieba/lego/card/model/ICardInfo;", "businessType", "", "formTab", "", "(Landroid/content/Context;Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/lego/card/model/ICardInfo;ILjava/lang/String;)V", "curData", "Lcom/baidu/tbadk/core/data/AdvertAppInfo;", "realView", "Landroid/view/View;", "onChangeSkin", "", "updateAdView", "data", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public final class DelegateNativeAdView extends FrameLayout implements n97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final View b;
    public AdvertAppInfo c;

    /* loaded from: classes5.dex */
    public static final class a implements px8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;

        public a(AdvertAppInfo advertAppInfo) {
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

        @Override // com.baidu.tieba.px8
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, hashMap) != null) || i == 0) {
                return;
            }
            if (mx9.h(i)) {
                az9.g(this.a, 0, hashMap, i);
            } else {
                az9.n(this.a, 0, "", null, hashMap);
            }
            xx8.c(this.a);
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
            ky8 a2 = qx8.h().a(tbPageContext, iCardInfo, i);
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
            if ((this.b instanceof ky8) && data.h != null) {
                v05.d(data);
                ky8<?> ky8Var = (ky8) this.b;
                ky8Var.update(data.h);
                lx9.m().c(data, ky8Var, data.u, this.a, 1, -1);
                ky8Var.setAfterClickSchemeListener(new a(data));
                View view2 = this.b;
                view2.setTag(new vp6(view2));
            }
        }
    }

    @Override // com.baidu.tieba.n97
    public void c() {
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || o97.a(this)) {
            return;
        }
        View view2 = this.b;
        if ((view2 instanceof ky8) && (advertAppInfo = this.c) != null && (iLegoAdvert = advertAppInfo.h) != null) {
            ((ky8) view2).update(iLegoAdvert);
        }
    }
}
