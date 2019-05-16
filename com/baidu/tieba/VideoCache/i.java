package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class i {
    public static final String cTY = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cTZ = cTY + "/.tieba_video_cache";
    public static final String ww = cTZ + "/v2";
    public static final String cUa = ww + "/";
    public static final String cUb = ww + "/files";
    public static final String cUc = cUb + "/";
    public static final String cUd = cUa + "server_port";
    public static final int cUe = "?segment_postion=".length();
}
