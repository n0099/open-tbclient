package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private List<String> axA = new ArrayList();
    private String axt;
    private String axu;
    private long axv;
    private int axw;
    private int axx;
    private int axy;
    private int axz;
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
        return this.axt;
    }

    public void eU(String str) {
        this.axt = str;
    }

    public String CC() {
        return this.axu;
    }

    public int CD() {
        return this.axw;
    }

    public void ep(int i) {
        this.axw = i;
    }

    public void eq(int i) {
        this.axz = i;
    }

    public boolean isSign() {
        return this.axz == 1;
    }

    public List<String> CE() {
        return this.axA;
    }

    public void a(FrequentlyForumInfo frequentlyForumInfo) {
        if (frequentlyForumInfo != null) {
            try {
                this.axt = frequentlyForumInfo.avatar;
                this.mForumId = frequentlyForumInfo.forum_id.longValue();
                this.mForumName = frequentlyForumInfo.forum_name;
                this.axx = frequentlyForumInfo.forum_state.intValue();
                this.axy = frequentlyForumInfo.access_flag.intValue();
                this.axv = frequentlyForumInfo.last_access_time.longValue();
                this.axw = frequentlyForumInfo.level_id.intValue();
                this.axu = frequentlyForumInfo.new_thread_num;
                this.axz = frequentlyForumInfo.is_sign.intValue();
                if (frequentlyForumInfo.user_list != null && frequentlyForumInfo.user_list.size() > 0) {
                    int size = frequentlyForumInfo.user_list.size();
                    for (int i = 0; i < size; i++) {
                        if (frequentlyForumInfo.user_list.get(i) != null) {
                            this.axA.add(frequentlyForumInfo.user_list.get(i).portrait);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
