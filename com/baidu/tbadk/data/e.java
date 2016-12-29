package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private String asB;
    private String asC;
    private long asD;
    private int asE;
    private int asF;
    private int asG;
    private int asH;
    private List<String> asI = new ArrayList();
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

    public void fb(String str) {
        this.mForumName = str;
    }

    public String BP() {
        return this.asB;
    }

    public void fc(String str) {
        this.asB = str;
    }

    public String BQ() {
        return this.asC;
    }

    public int BR() {
        return this.asE;
    }

    public void eq(int i) {
        this.asE = i;
    }

    public void er(int i) {
        this.asH = i;
    }

    public boolean isSign() {
        return this.asH == 1;
    }

    public List<String> BS() {
        return this.asI;
    }

    public void a(FrequentlyForumInfo frequentlyForumInfo) {
        if (frequentlyForumInfo != null) {
            try {
                this.asB = frequentlyForumInfo.avatar;
                this.mForumId = frequentlyForumInfo.forum_id.longValue();
                this.mForumName = frequentlyForumInfo.forum_name;
                this.asF = frequentlyForumInfo.forum_state.intValue();
                this.asG = frequentlyForumInfo.access_flag.intValue();
                this.asD = frequentlyForumInfo.last_access_time.longValue();
                this.asE = frequentlyForumInfo.level_id.intValue();
                this.asC = frequentlyForumInfo.new_thread_num;
                this.asH = frequentlyForumInfo.is_sign.intValue();
                if (frequentlyForumInfo.user_list != null && frequentlyForumInfo.user_list.size() > 0) {
                    int size = frequentlyForumInfo.user_list.size();
                    for (int i = 0; i < size; i++) {
                        if (frequentlyForumInfo.user_list.get(i) != null) {
                            this.asI.add(frequentlyForumInfo.user_list.get(i).portrait);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
