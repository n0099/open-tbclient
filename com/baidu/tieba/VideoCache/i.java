package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class i {
    public static final String cTZ = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cUa = cTZ + "/.tieba_video_cache";
    public static final String ww = cUa + "/v2";
    public static final String cUb = ww + "/";
    public static final String cUc = ww + "/files";
    public static final String cUd = cUc + "/";
    public static final String cUe = cUb + "server_port";
    public static final int cUf = "?segment_postion=".length();
}
