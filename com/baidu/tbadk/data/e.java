package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrequentlyForumInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.mvc.b.a {
    private String ase;
    private String asf;
    private long asg;
    private int ash;
    private int asi;
    private int asj;
    private int ask;
    private List<String> asl = new ArrayList();
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

    public void fd(String str) {
        this.mForumName = str;
    }

    public String BW() {
        return this.ase;
    }

    public void fe(String str) {
        this.ase = str;
    }

    public String BX() {
        return this.asf;
    }

    public int BY() {
        return this.ash;
    }

    public void en(int i) {
        this.ash = i;
    }

    public void eo(int i) {
        this.ask = i;
    }

    public boolean isSign() {
        return this.ask == 1;
    }

    public List<String> BZ() {
        return this.asl;
    }

    public void a(FrequentlyForumInfo frequentlyForumInfo) {
        if (frequentlyForumInfo != null) {
            try {
                this.ase = frequentlyForumInfo.avatar;
                this.mForumId = frequentlyForumInfo.forum_id.longValue();
                this.mForumName = frequentlyForumInfo.forum_name;
                this.asi = frequentlyForumInfo.forum_state.intValue();
                this.asj = frequentlyForumInfo.access_flag.intValue();
                this.asg = frequentlyForumInfo.last_access_time.longValue();
                this.ash = frequentlyForumInfo.level_id.intValue();
                this.asf = frequentlyForumInfo.new_thread_num;
                this.ask = frequentlyForumInfo.is_sign.intValue();
                if (frequentlyForumInfo.user_list != null && frequentlyForumInfo.user_list.size() > 0) {
                    int size = frequentlyForumInfo.user_list.size();
                    for (int i = 0; i < size; i++) {
                        if (frequentlyForumInfo.user_list.get(i) != null) {
                            this.asl.add(frequentlyForumInfo.user_list.get(i).portrait);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
