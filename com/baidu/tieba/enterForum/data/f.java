package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private int arR;
    private PrivateForumInfo cav;
    private int eTg;
    private int faO;
    private String faP;
    private int faQ;
    private int faR;
    private int faS;
    private ThemeColorInfo faT;
    private boolean faU;
    private long faV;
    private String mContent;
    private String mId;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bdO() {
        return this.mContent;
    }

    public int bdP() {
        return this.eTg;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void pv(int i) {
        this.faO = i;
    }

    public int bdQ() {
        return this.faO;
    }

    public int bdR() {
        return this.faR;
    }

    public int isPrivateForum() {
        return this.faS;
    }

    public int bdS() {
        return this.faQ;
    }

    public void setLevel(int i) {
        this.arR = i;
    }

    public int getLevel() {
        return this.arR;
    }

    public String getAvatar() {
        return this.faP;
    }

    public ThemeColorInfo bdT() {
        return this.faT;
    }

    public ArrayList<Integer> bdU() {
        if (this.faT == null || this.faT.day == null || this.faT.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.bR(this.faT.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.bR(this.faT.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.bR(this.faT.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.bR(this.faT.night.dark_color)));
        return arrayList;
    }

    public boolean atM() {
        return this.faU;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bdV() {
        return this.faR == 1 && this.faS == 1 && this.cav != null && this.cav.private_forum_status.intValue() == 1;
    }

    public boolean bdW() {
        return this.faR == 1 && this.faS == 1 && this.cav != null && this.cav.private_forum_status.intValue() == 1 && this.cav.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.faO = likeForum.is_sign.intValue();
                this.arR = likeForum.level_id.intValue();
                this.faP = likeForum.avatar;
                this.faR = likeForum.is_manager.intValue();
                this.faS = likeForum.is_private_forum.intValue();
                this.cav = likeForum.private_forum_info;
                this.faQ = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eTg = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.faT = likeForum.theme_color;
                this.faU = likeForum.need_trans.booleanValue();
                this.faV = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bdX() {
        return this.faV;
    }

    public void cC(long j) {
        this.faV = j;
    }
}
