package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private String asY;
    private String asZ;
    private long ata;
    private int atb;
    private int atc;
    private int atd;
    private int ate;
    private List<String> atf = new ArrayList();
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

    public void ff(String str) {
        this.mForumName = str;
    }

    public String Cc() {
        return this.asY;
    }

    public void fg(String str) {
        this.asY = str;
    }

    public String Cd() {
        return this.asZ;
    }

    public int Ce() {
        return this.atb;
    }

    public void ep(int i) {
        this.atb = i;
    }

    public void eq(int i) {
        this.ate = i;
    }

    public boolean isSign() {
        return this.ate == 1;
    }

    public List<String> Cf() {
        return this.atf;
    }

    public void a(FrequentlyForumInfo frequentlyForumInfo) {
        if (frequentlyForumInfo != null) {
            try {
                this.asY = frequentlyForumInfo.avatar;
                this.mForumId = frequentlyForumInfo.forum_id.longValue();
                this.mForumName = frequentlyForumInfo.forum_name;
                this.atc = frequentlyForumInfo.forum_state.intValue();
                this.atd = frequentlyForumInfo.access_flag.intValue();
                this.ata = frequentlyForumInfo.last_access_time.longValue();
                this.atb = frequentlyForumInfo.level_id.intValue();
                this.asZ = frequentlyForumInfo.new_thread_num;
                this.ate = frequentlyForumInfo.is_sign.intValue();
                if (frequentlyForumInfo.user_list != null && frequentlyForumInfo.user_list.size() > 0) {
                    int size = frequentlyForumInfo.user_list.size();
                    for (int i = 0; i < size; i++) {
                        if (frequentlyForumInfo.user_list.get(i) != null) {
                            this.atf.add(frequentlyForumInfo.user_list.get(i).portrait);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
