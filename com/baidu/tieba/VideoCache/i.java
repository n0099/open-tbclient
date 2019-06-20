package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class i {
    public static final String cUa = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cUb = cUa + "/.tieba_video_cache";
    public static final String wv = cUb + "/v2";
    public static final String cUc = wv + "/";
    public static final String cUd = wv + "/files";
    public static final String cUe = cUd + "/";
    public static final String cUf = cUc + "server_port";
    public static final int cUg = "?segment_postion=".length();
}
