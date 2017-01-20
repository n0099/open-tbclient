package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private String arG;
    private String arH;
    private long arI;
    private int arJ;
    private int arK;
    private int arL;
    private int arM;
    private List<String> arN = new ArrayList();
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

    public void eY(String str) {
        this.mForumName = str;
    }

    public String BK() {
        return this.arG;
    }

    public void eZ(String str) {
        this.arG = str;
    }

    public String BL() {
        return this.arH;
    }

    public int BM() {
        return this.arJ;
    }

    public void er(int i) {
        this.arJ = i;
    }

    public void es(int i) {
        this.arM = i;
    }

    public boolean isSign() {
        return this.arM == 1;
    }

    public List<String> BN() {
        return this.arN;
    }

    public void a(FrequentlyForumInfo frequentlyForumInfo) {
        if (frequentlyForumInfo != null) {
            try {
                this.arG = frequentlyForumInfo.avatar;
                this.mForumId = frequentlyForumInfo.forum_id.longValue();
                this.mForumName = frequentlyForumInfo.forum_name;
                this.arK = frequentlyForumInfo.forum_state.intValue();
                this.arL = frequentlyForumInfo.access_flag.intValue();
                this.arI = frequentlyForumInfo.last_access_time.longValue();
                this.arJ = frequentlyForumInfo.level_id.intValue();
                this.arH = frequentlyForumInfo.new_thread_num;
                this.arM = frequentlyForumInfo.is_sign.intValue();
                if (frequentlyForumInfo.user_list != null && frequentlyForumInfo.user_list.size() > 0) {
                    int size = frequentlyForumInfo.user_list.size();
                    for (int i = 0; i < size; i++) {
                        if (frequentlyForumInfo.user_list.get(i) != null) {
                            this.arN.add(frequentlyForumInfo.user_list.get(i).portrait);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
