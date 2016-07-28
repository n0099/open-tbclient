package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private String apm;
    private String apn;
    private long apo;
    private int apq;
    private int apr;
    private int aps;
    private int apt;
    private List<String> apu = new ArrayList();
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

    public void eX(String str) {
        this.mForumName = str;
    }

    public String AE() {
        return this.apm;
    }

    public void eY(String str) {
        this.apm = str;
    }

    public String AF() {
        return this.apn;
    }

    public int AG() {
        return this.apq;
    }

    public void dZ(int i) {
        this.apq = i;
    }

    public void ea(int i) {
        this.apt = i;
    }

    public boolean isSign() {
        return this.apt == 1;
    }

    public List<String> AH() {
        return this.apu;
    }

    public void a(FrequentlyForumInfo frequentlyForumInfo) {
        if (frequentlyForumInfo != null) {
            try {
                this.apm = frequentlyForumInfo.avatar;
                this.mForumId = frequentlyForumInfo.forum_id.longValue();
                this.mForumName = frequentlyForumInfo.forum_name;
                this.apr = frequentlyForumInfo.forum_state.intValue();
                this.aps = frequentlyForumInfo.access_flag.intValue();
                this.apo = frequentlyForumInfo.last_access_time.longValue();
                this.apq = frequentlyForumInfo.level_id.intValue();
                this.apn = frequentlyForumInfo.new_thread_num;
                this.apt = frequentlyForumInfo.is_sign.intValue();
                if (frequentlyForumInfo.user_list != null && frequentlyForumInfo.user_list.size() > 0) {
                    int size = frequentlyForumInfo.user_list.size();
                    for (int i = 0; i < size; i++) {
                        if (frequentlyForumInfo.user_list.get(i) != null) {
                            this.apu.add(frequentlyForumInfo.user_list.get(i).portrait);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
