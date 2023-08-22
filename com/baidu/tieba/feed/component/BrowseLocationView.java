package com.baidu.tieba.feed.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.cb7;
import com.baidu.tieba.db7;
import com.baidu.tieba.feed.component.BrowseLocationView;
import com.baidu.tieba.feed.component.uistate.BrowseLocationUiState;
import com.baidu.tieba.z67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/feed/component/BrowseLocationView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "M_H_X003", "", "mProgressView", "Landroid/widget/TextView;", "mReadHere", "", "onChangeSkin", "", "updateState", "state", "Lcom/baidu/tieba/feed/component/uistate/BrowseLocationUiState;", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BrowseLocationView extends FrameLayout implements cb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public TextView b;
    public String c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BrowseLocationView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BrowseLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        View findViewById = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0186, (ViewGroup) this, true).findViewById(R.id.obfuscated_res_0x7f091e45);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.read_progress)");
        TextView textView = (TextView) findViewById;
        this.b = textView;
        int i3 = this.a;
        textView.setPadding(0, i3, 0, i3);
        this.c = getResources().getString(R.string.obfuscated_res_0x7f0f0389);
        TextView textView2 = this.b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "%s%s", Arrays.copyOf(new Object[]{getResources().getString(R.string.obfuscated_res_0x7f0f038a), this.c}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        textView2.setText(format);
        c();
    }

    public /* synthetic */ BrowseLocationView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void b(BrowseLocationUiState browseLocationUiState, z67 data, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, browseLocationUiState, data, view2) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Function2<z67, View, Unit> i = browseLocationUiState.i();
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            i.invoke(data, view2);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void a(final BrowseLocationUiState browseLocationUiState) {
        final z67 h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, browseLocationUiState) == null) && browseLocationUiState != null && (h = browseLocationUiState.h()) != null) {
            String formatTimeShort = StringHelper.getFormatTimeShort(h.d);
            TextView textView = this.b;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "%s%s", Arrays.copyOf(new Object[]{formatTimeShort, this.c}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            textView.setText(format);
            setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.n57
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        BrowseLocationView.b(BrowseLocationUiState.this, h, view2);
                    }
                }
            });
            c();
        }
    }

    @Override // com.baidu.tieba.cb7
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || db7.a(this)) {
            return;
        }
        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0304);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_card_refresh16, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
        pureDrawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
        this.b.setCompoundDrawables(pureDrawable, null, null, null);
    }
}
