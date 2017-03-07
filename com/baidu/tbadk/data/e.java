package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private String axb;
    private String axc;
    private long axd;
    private int axe;
    private int axf;
    private int axg;
    private int axh;
    private List<String> axi = new ArrayList();
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

    public void eN(String str) {
        this.mForumName = str;
    }

    public String Cd() {
        return this.axb;
    }

    public void eO(String str) {
        this.axb = str;
    }

    public String Ce() {
        return this.axc;
    }

    public int Cf() {
        return this.axe;
    }

    public void em(int i) {
        this.axe = i;
    }

    public void en(int i) {
        this.axh = i;
    }

    public boolean isSign() {
        return this.axh == 1;
    }

    public List<String> Cg() {
        return this.axi;
    }

    public void a(FrequentlyForumInfo frequentlyForumInfo) {
        if (frequentlyForumInfo != null) {
            try {
                this.axb = frequentlyForumInfo.avatar;
                this.mForumId = frequentlyForumInfo.forum_id.longValue();
                this.mForumName = frequentlyForumInfo.forum_name;
                this.axf = frequentlyForumInfo.forum_state.intValue();
                this.axg = frequentlyForumInfo.access_flag.intValue();
                this.axd = frequentlyForumInfo.last_access_time.longValue();
                this.axe = frequentlyForumInfo.level_id.intValue();
                this.axc = frequentlyForumInfo.new_thread_num;
                this.axh = frequentlyForumInfo.is_sign.intValue();
                if (frequentlyForumInfo.user_list != null && frequentlyForumInfo.user_list.size() > 0) {
                    int size = frequentlyForumInfo.user_list.size();
                    for (int i = 0; i < size; i++) {
                        if (frequentlyForumInfo.user_list.get(i) != null) {
                            this.axi.add(frequentlyForumInfo.user_list.get(i).portrait);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
