package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo cMg;
    private int fRN;
    private int fRO;
    private int fRP;
    private int fRQ;
    private int fRR;
    private ThemeColorInfo fRS;
    private boolean fRT;
    private long fRU;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bwk() {
        return this.mContent;
    }

    public int bwl() {
        return this.fRR;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void rF(int i) {
        this.fRN = i;
    }

    public int bwm() {
        return this.fRN;
    }

    public int bwn() {
        return this.fRP;
    }

    public int isPrivateForum() {
        return this.fRQ;
    }

    public int bwo() {
        return this.fRO;
    }

    public void setLevel(int i) {
        this.mLevel = i;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public ThemeColorInfo bwp() {
        return this.fRS;
    }

    public ArrayList<Integer> bwq() {
        if (this.fRS == null || this.fRS.day == null || this.fRS.night == null || this.fRS.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fRS.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fRS.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fRS.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fRS.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fRS.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cy(this.fRS.dark.dark_color)));
        return arrayList;
    }

    public boolean aLI() {
        return this.fRT;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bwr() {
        return this.fRP == 1 && this.fRQ == 1 && this.cMg != null && this.cMg.private_forum_status.intValue() == 1;
    }

    public boolean bws() {
        return this.fRP == 1 && this.fRQ == 1 && this.cMg != null && this.cMg.private_forum_status.intValue() == 1 && this.cMg.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.fRN = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.fRP = likeForum.is_manager.intValue();
                this.fRQ = likeForum.is_private_forum.intValue();
                this.cMg = likeForum.private_forum_info;
                this.fRO = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.fRR = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.fRS = likeForum.theme_color;
                this.fRT = likeForum.need_trans.booleanValue();
                this.fRU = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bwt() {
        return this.fRU;
    }

    public void dm(long j) {
        this.fRU = j;
    }
}
