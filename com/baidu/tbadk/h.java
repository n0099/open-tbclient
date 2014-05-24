package com.baidu.tbadk;

import android.content.Context;
import com.baidu.adp.lib.util.k;
/* loaded from: classes.dex */
public class h {
    public static String a = "ws://im.tieba.baidu.com:8000";
    public static int[] b = {30, 60, TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI, TbConfig.POST_IMAGE_SMALL, 1800, 3600, 7200, 14400};
    public static String c = "post_image";
    public static int d = 30;
    public static int e = 30;
    public static String f = "c/i/msgcenter/uploadPic";
    public static String g = "http://tieba.baidu.com/group/index?id=";
    public static String h = "http://tieba.baidu.com/mo/q/liveshowshare?gid=";

    public static int a(Context context) {
        return k.a(context, 300.0f);
    }
}
