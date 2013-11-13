package com.baidu.tieba.flist;

import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.data.NewErrorData;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForumRankData implements Serializable {
    private static final long serialVersionUID = 6536045499676911895L;
    public NewErrorData error;
    public int error_code;
    public ForumInfoData[] forumsquare_list;
    public String pic_url;
    public long time = 0;
    public long ctime = 0;
    public long logid = 0;
    public long is_order = 0;
    public String title = null;
}
