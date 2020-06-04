package com.baidu.tieba.VideoCacheClient;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class c {
    public static final String eMr = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String eMs = eMr + "/.tieba_video_cache";
    public static final String HV = eMs + "/v2";
    public static final String eMt = HV + "/";
    public static final String eMu = HV + "/files";
    public static final String eMv = eMu + "/";
    public static final String eMw = eMt + "server_port";
}
