package com.baidu.tieba.im;

import android.content.Context;
import com.baidu.adp.lib.util.BdUtilHelper;
/* loaded from: classes.dex */
public class g {
    public static String a = "ws://im.tieba.baidu.com:8000";
    public static int[] b = {30, 60, 300, 600, 1800, 3600, 7200, 14400};
    public static String c = "post_image";
    public static int d = 30;
    public static int e = 30;
    public static String f = "c/i/msgcenter/uploadPic";
    public static String g = "http://c.tieba.baidu.com/c/s/uploadPicture";
    public static String h = "http://tieba.baidu.com/group/index?id=";

    public static byte[] a() {
        return com.baidu.adp.lib.webSocket.a.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwQpwBZxXJV/JVRF/uNfyMSdu7YWwRNLM8+2xbniGp2iIQHOikPpTYQjlQgMi1uvq1kZpJ32rHo3hkwjy2l0lFwr3u4Hk2Wk7vnsqYQjAlYlK0TCzjpmiI+OiPOUNVtbWHQiLiVqFtzvpvi4AU7C1iKGvc/4IS45WjHxeScHhnZZ7njS4S1UgNP/GflRIbzgbBhyZ9kEW5/OO5YfG1fy6r4KSlDJw4o/mw5XhftyIpL+5ZBVBC6E1EIiP/dd9AbK62VV1PByfPMHMixpxI3GM2qwcmFsXcCcgvUXJBa9k6zP8dDQ3csCM2QNT+CQAOxthjtp/TFWaD7MzOdsIYb3THwIDAQAB");
    }

    public static int a(Context context) {
        return BdUtilHelper.a(context, 300.0f);
    }
}
