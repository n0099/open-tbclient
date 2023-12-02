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
public class e2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarInfo starInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "has_frs_star", starInfo.has_frs_star);
            ktc.a(jSONObject, "top", starInfo.top);
            ktc.a(jSONObject, "head", starInfo.head);
            ktc.a(jSONObject, "gender", starInfo.gender);
            Info info = starInfo.info;
            if (info != null) {
                ktc.a(jSONObject, "info", u0d.b(info));
            }
            Fans fans = starInfo.fans;
            if (fans != null) {
                ktc.a(jSONObject, "fans", xzc.b(fans));
            }
            if (starInfo.focus != null) {
                JSONArray jSONArray = new JSONArray();
                for (Focus focus : starInfo.focus) {
                    jSONArray.put(zzc.b(focus));
                }
                ktc.a(jSONObject, AddFriendActivityConfig.TYPE_FOCUS, jSONArray);
            }
            PhotoInfo photoInfo = starInfo.photo;
            if (photoInfo != null) {
                ktc.a(jSONObject, "photo", i1d.b(photoInfo));
            }
            Video video = starInfo.video;
            if (video != null) {
                ktc.a(jSONObject, "video", u2d.b(video));
            }
            Music music = starInfo.music;
            if (music != null) {
                ktc.a(jSONObject, "music", b1d.b(music));
            }
            Music music2 = starInfo.mv;
            if (music2 != null) {
                ktc.a(jSONObject, "mv", b1d.b(music2));
            }
            Good good = starInfo.good;
            if (good != null) {
                ktc.a(jSONObject, FrsActivityConfig.GOOD, m0d.b(good));
            }
            Identify identify = starInfo.identify;
            if (identify != null) {
                ktc.a(jSONObject, "identify", t0d.b(identify));
            }
            Size size = starInfo.top_size;
            if (size != null) {
                ktc.a(jSONObject, "top_size", b2d.c(size));
            }
            Size size2 = starInfo.head_size;
            if (size2 != null) {
                ktc.a(jSONObject, "head_size", b2d.c(size2));
            }
            Ticket ticket = starInfo.trade;
            if (ticket != null) {
                ktc.a(jSONObject, "trade", l2d.b(ticket));
            }
            ktc.a(jSONObject, "star_forum_headimg", starInfo.star_forum_headimg);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
