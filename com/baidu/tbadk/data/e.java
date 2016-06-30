package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private int aoA;
    private int aoB;
    private int aoC;
    private int aoD;
    private List<String> aoE = new ArrayList();
    private String aox;
    private String aoy;
    private long aoz;
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

    public void eZ(String str) {
        this.mForumName = str;
    }

    public String AE() {
        return this.aox;
    }

    public void fa(String str) {
        this.aox = str;
    }

    public String AF() {
        return this.aoy;
    }

    public int AG() {
        return this.aoA;
    }

    public void dZ(int i) {
        this.aoA = i;
    }

    public void ea(int i) {
        this.aoD = i;
    }

    public boolean isSign() {
        return this.aoD == 1;
    }

    public List<String> AH() {
        return this.aoE;
    }

    public void a(FrequentlyForumInfo frequentlyForumInfo) {
        if (frequentlyForumInfo != null) {
            try {
                this.aox = frequentlyForumInfo.avatar;
                this.mForumId = frequentlyForumInfo.forum_id.longValue();
                this.mForumName = frequentlyForumInfo.forum_name;
                this.aoB = frequentlyForumInfo.forum_state.intValue();
                this.aoC = frequentlyForumInfo.access_flag.intValue();
                this.aoz = frequentlyForumInfo.last_access_time.longValue();
                this.aoA = frequentlyForumInfo.level_id.intValue();
                this.aoy = frequentlyForumInfo.new_thread_num;
                this.aoD = frequentlyForumInfo.is_sign.intValue();
                if (frequentlyForumInfo.user_list != null && frequentlyForumInfo.user_list.size() > 0) {
                    int size = frequentlyForumInfo.user_list.size();
                    for (int i = 0; i < size; i++) {
                        if (frequentlyForumInfo.user_list.get(i) != null) {
                            this.aoE.add(frequentlyForumInfo.user_list.get(i).portrait);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
