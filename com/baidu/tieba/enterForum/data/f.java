package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private int azk;
    private PrivateForumInfo cLW;
    private String eqU;
    private int fOE;
    private int fOF;
    private int fOG;
    private int fOH;
    private int fOI;
    private ThemeColorInfo fOJ;
    private boolean fOK;
    private long fOL;
    private String mContent;
    private String mId;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bvi() {
        return this.mContent;
    }

    public int bvj() {
        return this.fOI;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void rA(int i) {
        this.fOE = i;
    }

    public int bvk() {
        return this.fOE;
    }

    public int bvl() {
        return this.fOG;
    }

    public int isPrivateForum() {
        return this.fOH;
    }

    public int bvm() {
        return this.fOF;
    }

    public void setLevel(int i) {
        this.azk = i;
    }

    public int getLevel() {
        return this.azk;
    }

    public String getAvatar() {
        return this.eqU;
    }

    public ThemeColorInfo bvn() {
        return this.fOJ;
    }

    public ArrayList<Integer> bvo() {
        if (this.fOJ == null || this.fOJ.day == null || this.fOJ.night == null || this.fOJ.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fOJ.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fOJ.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fOJ.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fOJ.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fOJ.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fOJ.dark.dark_color)));
        return arrayList;
    }

    public boolean aLp() {
        return this.fOK;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bvp() {
        return this.fOG == 1 && this.fOH == 1 && this.cLW != null && this.cLW.private_forum_status.intValue() == 1;
    }

    public boolean bvq() {
        return this.fOG == 1 && this.fOH == 1 && this.cLW != null && this.cLW.private_forum_status.intValue() == 1 && this.cLW.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.fOE = likeForum.is_sign.intValue();
                this.azk = likeForum.level_id.intValue();
                this.eqU = likeForum.avatar;
                this.fOG = likeForum.is_manager.intValue();
                this.fOH = likeForum.is_private_forum.intValue();
                this.cLW = likeForum.private_forum_info;
                this.fOF = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.fOI = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.fOJ = likeForum.theme_color;
                this.fOK = likeForum.need_trans.booleanValue();
                this.fOL = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bvr() {
        return this.fOL;
    }

    public void dh(long j) {
        this.fOL = j;
    }
}
