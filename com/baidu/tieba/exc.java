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
public class exc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarInfo starInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "has_frs_star", starInfo.has_frs_star);
            qoc.a(jSONObject, "top", starInfo.top);
            qoc.a(jSONObject, "head", starInfo.head);
            qoc.a(jSONObject, "gender", starInfo.gender);
            Info info = starInfo.info;
            if (info != null) {
                qoc.a(jSONObject, "info", vvc.b(info));
            }
            Fans fans = starInfo.fans;
            if (fans != null) {
                qoc.a(jSONObject, "fans", yuc.b(fans));
            }
            if (starInfo.focus != null) {
                JSONArray jSONArray = new JSONArray();
                for (Focus focus : starInfo.focus) {
                    jSONArray.put(avc.b(focus));
                }
                qoc.a(jSONObject, AddFriendActivityConfig.TYPE_FOCUS, jSONArray);
            }
            PhotoInfo photoInfo = starInfo.photo;
            if (photoInfo != null) {
                qoc.a(jSONObject, "photo", iwc.b(photoInfo));
            }
            Video video = starInfo.video;
            if (video != null) {
                qoc.a(jSONObject, "video", sxc.b(video));
            }
            Music music = starInfo.music;
            if (music != null) {
                qoc.a(jSONObject, "music", bwc.b(music));
            }
            Music music2 = starInfo.mv;
            if (music2 != null) {
                qoc.a(jSONObject, "mv", bwc.b(music2));
            }
            Good good = starInfo.good;
            if (good != null) {
                qoc.a(jSONObject, FrsActivityConfig.GOOD, nvc.b(good));
            }
            Identify identify = starInfo.identify;
            if (identify != null) {
                qoc.a(jSONObject, "identify", uvc.b(identify));
            }
            Size size = starInfo.top_size;
            if (size != null) {
                qoc.a(jSONObject, "top_size", bxc.c(size));
            }
            Size size2 = starInfo.head_size;
            if (size2 != null) {
                qoc.a(jSONObject, "head_size", bxc.c(size2));
            }
            Ticket ticket = starInfo.trade;
            if (ticket != null) {
                qoc.a(jSONObject, "trade", lxc.b(ticket));
            }
            qoc.a(jSONObject, "star_forum_headimg", starInfo.star_forum_headimg);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
