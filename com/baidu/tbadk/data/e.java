package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private List<String> asA = new ArrayList();
    private String ast;
    private String asu;
    private long asv;
    private int asw;
    private int asx;
    private int asy;
    private int asz;
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

    public void fa(String str) {
        this.mForumName = str;
    }

    public String BT() {
        return this.ast;
    }

    public void fb(String str) {
        this.ast = str;
    }

    public String BU() {
        return this.asu;
    }

    public int BV() {
        return this.asw;
    }

    public void en(int i) {
        this.asw = i;
    }

    public void eo(int i) {
        this.asz = i;
    }

    public boolean isSign() {
        return this.asz == 1;
    }

    public List<String> BW() {
        return this.asA;
    }

    public void a(FrequentlyForumInfo frequentlyForumInfo) {
        if (frequentlyForumInfo != null) {
            try {
                this.ast = frequentlyForumInfo.avatar;
                this.mForumId = frequentlyForumInfo.forum_id.longValue();
                this.mForumName = frequentlyForumInfo.forum_name;
                this.asx = frequentlyForumInfo.forum_state.intValue();
                this.asy = frequentlyForumInfo.access_flag.intValue();
                this.asv = frequentlyForumInfo.last_access_time.longValue();
                this.asw = frequentlyForumInfo.level_id.intValue();
                this.asu = frequentlyForumInfo.new_thread_num;
                this.asz = frequentlyForumInfo.is_sign.intValue();
                if (frequentlyForumInfo.user_list != null && frequentlyForumInfo.user_list.size() > 0) {
                    int size = frequentlyForumInfo.user_list.size();
                    for (int i = 0; i < size; i++) {
                        if (frequentlyForumInfo.user_list.get(i) != null) {
                            this.asA.add(frequentlyForumInfo.user_list.get(i).portrait);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
