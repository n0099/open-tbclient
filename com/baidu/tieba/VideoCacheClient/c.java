package com.baidu.tieba.VideoCacheClient;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class c {
    public static final String dfa = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String dfb = dfa + "/.tieba_video_cache";
    public static final String mc = dfb + "/v2";
    public static final String dfc = mc + "/";
    public static final String dfd = mc + "/files";
    public static final String dfe = dfd + "/";
    public static final String dff = dfc + "server_port";
}
