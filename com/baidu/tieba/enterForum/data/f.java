package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo bHo;
    private int eDO;
    private int eRm;
    private String eRn;
    private int eRo;
    private int eRp;
    private int eRq;
    private ThemeColorInfo eRr;
    private boolean eRs;
    private long eRt;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bdj() {
        return this.mContent;
    }

    public int bdk() {
        return this.eDO;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void qd(int i) {
        this.eRm = i;
    }

    public int bdl() {
        return this.eRm;
    }

    public int bdm() {
        return this.eRp;
    }

    public int isPrivateForum() {
        return this.eRq;
    }

    public int bdn() {
        return this.eRo;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.eRn;
    }

    public ThemeColorInfo bdo() {
        return this.eRr;
    }

    public ArrayList<Integer> bdp() {
        if (this.eRr == null || this.eRr.day == null || this.eRr.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eRr.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eRr.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eRr.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.parseColor(this.eRr.night.dark_color)));
        return arrayList;
    }

    public boolean aqE() {
        return this.eRs;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bdq() {
        return this.eRp == 1 && this.eRq == 1 && this.bHo != null && this.bHo.private_forum_status.intValue() == 1;
    }

    public boolean bdr() {
        return this.eRp == 1 && this.eRq == 1 && this.bHo != null && this.bHo.private_forum_status.intValue() == 1 && this.bHo.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.eRm = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.eRn = likeForum.avatar;
                this.eRp = likeForum.is_manager.intValue();
                this.eRq = likeForum.is_private_forum.intValue();
                this.bHo = likeForum.private_forum_info;
                this.eRo = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eDO = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.eRr = likeForum.theme_color;
                this.eRs = likeForum.need_trans.booleanValue();
                this.eRt = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bds() {
        return this.eRt;
    }

    public void cS(long j) {
        this.eRt = j;
    }
}
