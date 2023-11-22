package com.baidu.tieba;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.DownloadBar;
import tbclient.FeedMaskLayer;
import tbclient.FeedVideoAdComponent;
import tbclient.MaskLayerText;
import tbclient.VideoField;
/* loaded from: classes5.dex */
public final class a97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a extends i97 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaskLayerText a;

        public a(MaskLayerText maskLayerText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maskLayerText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = maskLayerText;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                ha7.c(widget.getContext(), this.a.schema);
            }
        }
    }

    public static final SpannableString a(List<MaskLayerText> textList) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, textList)) == null) {
            Intrinsics.checkNotNullParameter(textList, "textList");
            if (ListUtils.isEmpty(textList)) {
                return new SpannableString("");
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (MaskLayerText maskLayerText : textList) {
                if (maskLayerText != null) {
                    String str = maskLayerText.text;
                    boolean z2 = true;
                    if (str != null && str.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        String str2 = maskLayerText.schema;
                        if (str2 != null && str2.length() != 0) {
                            z2 = false;
                        }
                        if (z2) {
                            spannableStringBuilder.append((CharSequence) maskLayerText.text);
                        } else {
                            SpannableString spannableString = new SpannableString(maskLayerText.text);
                            spannableString.setSpan(new a(maskLayerText), 0, maskLayerText.text.length(), 17);
                            spannableStringBuilder.append((CharSequence) spannableString);
                        }
                    }
                }
            }
            return new SpannableString(spannableStringBuilder);
        }
        return (SpannableString) invokeL.objValue;
    }

    public static final void b(FeedVideoAdComponent feedVideoAdComponent, List<ab7<?>> dataList, v77 videoSchemaData, a67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, feedVideoAdComponent, dataList, videoSchemaData, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedVideoAdComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            VideoField videoField = feedVideoAdComponent.video_info;
            if (videoField != null) {
                k47 b = b97.b(videoField, videoSchemaData, feedExtraData);
                String str = "";
                SpannableString spannableString = new SpannableString("");
                FeedMaskLayer mask_layer = feedVideoAdComponent.mask_layer;
                if (mask_layer != null) {
                    Intrinsics.checkNotNullExpressionValue(mask_layer, "mask_layer");
                    String str2 = mask_layer.topright_text;
                    if (str2 != null) {
                        Intrinsics.checkNotNullExpressionValue(str2, "mask.topright_text ?: \"\"");
                        str = str2;
                    }
                    List<MaskLayerText> list = mask_layer.button_texts;
                    Intrinsics.checkNotNullExpressionValue(list, "mask.button_texts");
                    spannableString = a(list);
                }
                b.q(spannableString);
                t57 t57Var = new t57(null, null, null, null, null, null, 63, null);
                DownloadBar download_bar = feedVideoAdComponent.download_bar;
                if (download_bar != null) {
                    Intrinsics.checkNotNullExpressionValue(download_bar, "download_bar");
                    String str3 = download_bar.type;
                    Intrinsics.checkNotNullExpressionValue(str3, "bar.type");
                    String str4 = download_bar.icon;
                    Intrinsics.checkNotNullExpressionValue(str4, "bar.icon");
                    String str5 = download_bar.guide_text;
                    Intrinsics.checkNotNullExpressionValue(str5, "bar.guide_text");
                    String str6 = download_bar.button_text;
                    Intrinsics.checkNotNullExpressionValue(str6, "bar.button_text");
                    String str7 = download_bar.schema;
                    Intrinsics.checkNotNullExpressionValue(str7, "bar.schema");
                    t57Var = new t57(str3, str4, str5, str6, str7, feedExtraData.a());
                }
                dataList.add(new bb7(new j47(b, str, spannableString, t57Var), "video_ad"));
            }
        }
    }
}
