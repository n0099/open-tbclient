package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private String axr;
    private String axs;
    private long axt;
    private int axu;
    private int axv;
    private int axw;
    private int axx;
    private List<String> axy = new ArrayList();
    private long mForumId;
    private String mForumName;

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void eT(String str) {
        this.mForumName = str;
    }

    public String CB() {
        return this.axr;
    }

    public void eU(String str) {
        this.axr = str;
    }

    public String CC() {
        return this.axs;
    }

    public int CD() {
        return this.axu;
    }

    public void ep(int i) {
        this.axu = i;
    }

    public void eq(int i) {
        this.axx = i;
    }

    public boolean isSign() {
        return this.axx == 1;
    }

    public List<String> CE() {
        return this.axy;
    }

    public void a(FrequentlyForumInfo frequentlyForumInfo) {
        if (frequentlyForumInfo != null) {
            try {
                this.axr = frequentlyForumInfo.avatar;
                this.mForumId = frequentlyForumInfo.forum_id.longValue();
                this.mForumName = frequentlyForumInfo.forum_name;
                this.axv = frequentlyForumInfo.forum_state.intValue();
                this.axw = frequentlyForumInfo.access_flag.intValue();
                this.axt = frequentlyForumInfo.last_access_time.longValue();
                this.axu = frequentlyForumInfo.level_id.intValue();
                this.axs = frequentlyForumInfo.new_thread_num;
                this.axx = frequentlyForumInfo.is_sign.intValue();
                if (frequentlyForumInfo.user_list != null && frequentlyForumInfo.user_list.size() > 0) {
                    int size = frequentlyForumInfo.user_list.size();
                    for (int i = 0; i < size; i++) {
                        if (frequentlyForumInfo.user_list.get(i) != null) {
                            this.axy.add(frequentlyForumInfo.user_list.get(i).portrait);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
