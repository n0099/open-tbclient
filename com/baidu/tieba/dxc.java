package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Focus;
import tbclient.FrsPage.Good;
import tbclient.FrsPage.Identify;
import tbclient.FrsPage.Info;
import tbclient.FrsPage.Music;
import tbclient.FrsPage.PhotoInfo;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
import tbclient.FrsPage.Ticket;
import tbclient.FrsPage.Video;
/* loaded from: classes5.dex */
public class dxc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarInfo starInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "has_frs_star", starInfo.has_frs_star);
            poc.a(jSONObject, "top", starInfo.top);
            poc.a(jSONObject, "head", starInfo.head);
            poc.a(jSONObject, "gender", starInfo.gender);
            Info info = starInfo.info;
            if (info != null) {
                poc.a(jSONObject, "info", uvc.b(info));
            }
            Fans fans = starInfo.fans;
            if (fans != null) {
                poc.a(jSONObject, "fans", xuc.b(fans));
            }
            if (starInfo.focus != null) {
                JSONArray jSONArray = new JSONArray();
                for (Focus focus : starInfo.focus) {
                    jSONArray.put(zuc.b(focus));
                }
                poc.a(jSONObject, AddFriendActivityConfig.TYPE_FOCUS, jSONArray);
            }
            PhotoInfo photoInfo = starInfo.photo;
            if (photoInfo != null) {
                poc.a(jSONObject, "photo", hwc.b(photoInfo));
            }
            Video video = starInfo.video;
            if (video != null) {
                poc.a(jSONObject, "video", rxc.b(video));
            }
            Music music = starInfo.music;
            if (music != null) {
                poc.a(jSONObject, "music", awc.b(music));
            }
            Music music2 = starInfo.mv;
            if (music2 != null) {
                poc.a(jSONObject, "mv", awc.b(music2));
            }
            Good good = starInfo.good;
            if (good != null) {
                poc.a(jSONObject, FrsActivityConfig.GOOD, mvc.b(good));
            }
            Identify identify = starInfo.identify;
            if (identify != null) {
                poc.a(jSONObject, "identify", tvc.b(identify));
            }
            Size size = starInfo.top_size;
            if (size != null) {
                poc.a(jSONObject, "top_size", axc.c(size));
            }
            Size size2 = starInfo.head_size;
            if (size2 != null) {
                poc.a(jSONObject, "head_size", axc.c(size2));
            }
            Ticket ticket = starInfo.trade;
            if (ticket != null) {
                poc.a(jSONObject, "trade", kxc.b(ticket));
            }
            poc.a(jSONObject, "star_forum_headimg", starInfo.star_forum_headimg);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
