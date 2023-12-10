package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GraffitiInfo;
import tbclient.Item;
import tbclient.MemeInfo;
import tbclient.NativeApp;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
import tbclient.TogetherHi;
/* loaded from: classes5.dex */
public class a6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbContent pbContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", pbContent.type);
            ltc.a(jSONObject, "text", pbContent.text);
            ltc.a(jSONObject, "link", pbContent.link);
            ltc.a(jSONObject, "src", pbContent.src);
            ltc.a(jSONObject, "bsize", pbContent.bsize);
            ltc.a(jSONObject, "big_src", pbContent.big_src);
            ltc.a(jSONObject, "big_size", pbContent.big_size);
            ltc.a(jSONObject, "cdn_src", pbContent.cdn_src);
            ltc.a(jSONObject, "big_cdn_src", pbContent.big_cdn_src);
            ltc.a(jSONObject, "imgtype", pbContent.imgtype);
            ltc.a(jSONObject, "c", pbContent.c);
            ltc.a(jSONObject, "voice_md5", pbContent.voice_md5);
            ltc.a(jSONObject, "during_time", pbContent.during_time);
            ltc.a(jSONObject, "is_sub", pbContent.is_sub);
            ltc.a(jSONObject, "uid", pbContent.uid);
            ltc.a(jSONObject, PraiseUBCHelper.SOURCE_DYNAMIC, pbContent.dynamic);
            ltc.a(jSONObject, "static", pbContent._static);
            ltc.a(jSONObject, "width", pbContent.width);
            ltc.a(jSONObject, "height", pbContent.height);
            ltc.a(jSONObject, "packet_name", pbContent.packet_name);
            ltc.a(jSONObject, "phonetype", pbContent.phonetype);
            ltc.a(jSONObject, "is_native_app", pbContent.is_native_app);
            NativeApp nativeApp = pbContent.native_app;
            if (nativeApp != null) {
                ltc.a(jSONObject, "native_app", k5d.b(nativeApp));
            }
            ltc.a(jSONObject, "e_type", pbContent.e_type);
            ltc.a(jSONObject, "origin_src", pbContent.origin_src);
            ltc.a(jSONObject, "btn_type", pbContent.btn_type);
            ltc.a(jSONObject, "origin_size", pbContent.origin_size);
            ltc.a(jSONObject, "count", pbContent.count);
            GraffitiInfo graffitiInfo = pbContent.graffiti_info;
            if (graffitiInfo != null) {
                ltc.a(jSONObject, "graffiti_info", t3d.b(graffitiInfo));
            }
            TogetherHi togetherHi = pbContent.high_together;
            if (togetherHi != null) {
                ltc.a(jSONObject, "high_together", jad.b(togetherHi));
            }
            ltc.a(jSONObject, "media_subtitle", pbContent.media_subtitle);
            ltc.a(jSONObject, "url_type", pbContent.url_type);
            MemeInfo memeInfo = pbContent.meme_info;
            if (memeInfo != null) {
                ltc.a(jSONObject, "meme_info", e5d.b(memeInfo));
            }
            ltc.a(jSONObject, "is_long_pic", pbContent.is_long_pic);
            ltc.a(jSONObject, "show_original_btn", pbContent.show_original_btn);
            ltc.a(jSONObject, "cdn_src_active", pbContent.cdn_src_active);
            ltc.a(jSONObject, "topic_special_icon", pbContent.topic_special_icon);
            ltc.a(jSONObject, "item_id", pbContent.item_id);
            ltc.a(jSONObject, "item_forum_name", pbContent.item_forum_name);
            TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
            if (tiebaPlusInfo != null) {
                ltc.a(jSONObject, "tiebaplus_info", ead.b(tiebaPlusInfo));
            }
            Item item = pbContent.item;
            if (item != null) {
                ltc.a(jSONObject, "item", c4d.b(item));
            }
            ltc.a(jSONObject, EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, pbContent.pic_id);
            ltc.a(jSONObject, "link_type", pbContent.link_type);
            ltc.a(jSONObject, "target_scheme", pbContent.target_scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
