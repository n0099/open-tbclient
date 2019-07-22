package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo bIp;
    private int eIL;
    private int eWn;
    private String eWo;
    private int eWp;
    private int eWq;
    private int eWr;
    private ThemeColorInfo eWs;
    private boolean eWt;
    private long eWu;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bfo() {
        return this.mContent;
    }

    public int bfp() {
        return this.eIL;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void qv(int i) {
        this.eWn = i;
    }

    public int bfq() {
        return this.eWn;
    }

    public int bfr() {
        return this.eWq;
    }

    public int isPrivateForum() {
        return this.eWr;
    }

    public int bfs() {
        return this.eWp;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.eWo;
    }

    public ThemeColorInfo bft() {
        return this.eWs;
    }

    public ArrayList<Integer> bfu() {
        if (this.eWs == null || this.eWs.day == null || this.eWs.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eWs.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eWs.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eWs.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cE(this.eWs.night.dark_color)));
        return arrayList;
    }

    public boolean arK() {
        return this.eWt;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bfv() {
        return this.eWq == 1 && this.eWr == 1 && this.bIp != null && this.bIp.private_forum_status.intValue() == 1;
    }

    public boolean bfw() {
        return this.eWq == 1 && this.eWr == 1 && this.bIp != null && this.bIp.private_forum_status.intValue() == 1 && this.bIp.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.eWn = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.eWo = likeForum.avatar;
                this.eWq = likeForum.is_manager.intValue();
                this.eWr = likeForum.is_private_forum.intValue();
                this.bIp = likeForum.private_forum_info;
                this.eWp = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eIL = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.eWs = likeForum.theme_color;
                this.eWt = likeForum.need_trans.booleanValue();
                this.eWu = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bfx() {
        return this.eWu;
    }

    public void cZ(long j) {
        this.eWu = j;
    }
}
