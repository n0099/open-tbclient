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
public class f2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarInfo starInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "has_frs_star", starInfo.has_frs_star);
            ltc.a(jSONObject, "top", starInfo.top);
            ltc.a(jSONObject, "head", starInfo.head);
            ltc.a(jSONObject, "gender", starInfo.gender);
            Info info = starInfo.info;
            if (info != null) {
                ltc.a(jSONObject, "info", v0d.b(info));
            }
            Fans fans = starInfo.fans;
            if (fans != null) {
                ltc.a(jSONObject, "fans", yzc.b(fans));
            }
            if (starInfo.focus != null) {
                JSONArray jSONArray = new JSONArray();
                for (Focus focus : starInfo.focus) {
                    jSONArray.put(a0d.b(focus));
                }
                ltc.a(jSONObject, AddFriendActivityConfig.TYPE_FOCUS, jSONArray);
            }
            PhotoInfo photoInfo = starInfo.photo;
            if (photoInfo != null) {
                ltc.a(jSONObject, "photo", j1d.b(photoInfo));
            }
            Video video = starInfo.video;
            if (video != null) {
                ltc.a(jSONObject, "video", v2d.b(video));
            }
            Music music = starInfo.music;
            if (music != null) {
                ltc.a(jSONObject, "music", c1d.b(music));
            }
            Music music2 = starInfo.mv;
            if (music2 != null) {
                ltc.a(jSONObject, "mv", c1d.b(music2));
            }
            Good good = starInfo.good;
            if (good != null) {
                ltc.a(jSONObject, FrsActivityConfig.GOOD, n0d.b(good));
            }
            Identify identify = starInfo.identify;
            if (identify != null) {
                ltc.a(jSONObject, "identify", u0d.b(identify));
            }
            Size size = starInfo.top_size;
            if (size != null) {
                ltc.a(jSONObject, "top_size", c2d.c(size));
            }
            Size size2 = starInfo.head_size;
            if (size2 != null) {
                ltc.a(jSONObject, "head_size", c2d.c(size2));
            }
            Ticket ticket = starInfo.trade;
            if (ticket != null) {
                ltc.a(jSONObject, "trade", m2d.b(ticket));
            }
            ltc.a(jSONObject, "star_forum_headimg", starInfo.star_forum_headimg);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
