package com.baidu.tbadk;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class k {
    public static final BdUniqueId a = BdUniqueId.gen();
    private static final BdAsyncTaskParallel j = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, a);
    public static String b = "ws://im.tieba.baidu.com:8000";
    public static int[] c = {30, 60, TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI, TbConfig.POST_IMAGE_SMALL, 1800, 3600, 7200, 14400};
    public static String d = "post_image";
    public static int e = 30;
    public static int f = 30;
    public static String g = "c/i/msgcenter/uploadPic";
    public static String h = "http://tieba.baidu.com/group/index?id=";
    public static String i = "http://tieba.baidu.com/mo/q/liveshowshare?gid=";

    public static byte[] a() {
        return com.baidu.adp.lib.webSocket.a.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwQpwBZxXJV/JVRF/uNfyMSdu7YWwRNLM8+2xbniGp2iIQHOikPpTYQjlQgMi1uvq1kZpJ32rHo3hkwjy2l0lFwr3u4Hk2Wk7vnsqYQjAlYlK0TCzjpmiI+OiPOUNVtbWHQiLiVqFtzvpvi4AU7C1iKGvc/4IS45WjHxeScHhnZZ7njS4S1UgNP/GflRIbzgbBhyZ9kEW5/OO5YfG1fy6r4KSlDJw4o/mw5XhftyIpL+5ZBVBC6E1EIiP/dd9AbK62VV1PByfPMHMixpxI3GM2qwcmFsXcCcgvUXJBa9k6zP8dDQ3csCM2QNT+CQAOxthjtp/TFWaD7MzOdsIYb3THwIDAQAB");
    }

    public static int a(Context context) {
        return com.baidu.adp.lib.util.j.a(context, 300.0f);
    }

    public static BdAsyncTaskParallel b() {
        return j;
    }
}
