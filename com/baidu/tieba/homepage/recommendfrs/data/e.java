package com.baidu.tieba.homepage.recommendfrs.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private int cBE;
    private long cBF;
    private long cBG;
    private long cBH;
    private String desc;
    private long excId;
    private String forumName;
    private long threadId;
    private int thread_type;
    private List<String> thumbnail;
    private String title;
    private ZhiBoInfoTW twzhibo_info;
    private int type;
    private boolean auS = true;
    public String Uc = "";
    public String cBI = "";
    public String abtest = "";

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0082: IGET  (r1v0 java.lang.Integer A[REMOVE]) = (r3v0 tbclient.ExcFrsPage.ExcellentThreadInfo) tbclient.ExcFrsPage.ExcellentThreadInfo.source java.lang.Integer)] */
    public e b(ExcellentThreadInfo excellentThreadInfo) {
        if (excellentThreadInfo != null) {
            if (excellentThreadInfo.rank != null) {
                this.cBH = excellentThreadInfo.rank.longValue();
            }
            if (excellentThreadInfo.excid != null) {
                this.excId = excellentThreadInfo.excid.longValue();
            }
            this.threadId = excellentThreadInfo.thread_id.longValue();
            this.title = excellentThreadInfo.title;
            this.type = excellentThreadInfo.frs_type.intValue();
            this.cBE = excellentThreadInfo.pb_type.intValue();
            this.desc = excellentThreadInfo._abstract;
            this.thumbnail = new ArrayList();
            if (excellentThreadInfo.thumbnail != null) {
                this.thumbnail.addAll(excellentThreadInfo.thumbnail);
            }
            this.forumName = excellentThreadInfo.forum_name;
            if (excellentThreadInfo.post_num != null) {
                this.cBG = excellentThreadInfo.post_num.longValue();
            }
            if (excellentThreadInfo.zansum != null) {
                this.cBF = excellentThreadInfo.zansum.longValue();
            }
            if (excellentThreadInfo.thread_type != null) {
                this.thread_type = excellentThreadInfo.thread_type.intValue();
            }
            this.twzhibo_info = excellentThreadInfo.twzhibo_info;
            this.Uc = excellentThreadInfo.tag_name;
            this.cBI = new StringBuilder().append(excellentThreadInfo.source).toString();
            this.abtest = excellentThreadInfo.abtest;
        }
        return this;
    }

    public long ajY() {
        return this.cBH;
    }

    public long ajZ() {
        return this.cBF;
    }

    public long aka() {
        return this.cBG;
    }

    public long akb() {
        return this.excId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getDesc() {
        return this.desc;
    }

    public List<String> akc() {
        return this.thumbnail;
    }

    public String getForumName() {
        return this.forumName;
    }

    public int akd() {
        return this.thread_type;
    }

    public ZhiBoInfoTW ake() {
        return this.twzhibo_info;
    }

    public boolean ajW() {
        return this.auS;
    }

    public void setShowImage(boolean z) {
        this.auS = z;
    }

    public int akf() {
        return this.cBE;
    }

    public long getThreadId() {
        return this.threadId;
    }
}
