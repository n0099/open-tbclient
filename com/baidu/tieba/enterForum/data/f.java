package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private int arz;
    private PrivateForumInfo bZE;
    private int eSp;
    private int eZX;
    private String eZY;
    private int eZZ;
    private int faa;
    private int fab;
    private ThemeColorInfo fac;
    private boolean fad;
    private long fae;
    private String mContent;
    private String mId;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bdM() {
        return this.mContent;
    }

    public int bdN() {
        return this.eSp;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void pu(int i) {
        this.eZX = i;
    }

    public int bdO() {
        return this.eZX;
    }

    public int bdP() {
        return this.faa;
    }

    public int isPrivateForum() {
        return this.fab;
    }

    public int bdQ() {
        return this.eZZ;
    }

    public void setLevel(int i) {
        this.arz = i;
    }

    public int getLevel() {
        return this.arz;
    }

    public String getAvatar() {
        return this.eZY;
    }

    public ThemeColorInfo bdR() {
        return this.fac;
    }

    public ArrayList<Integer> bdS() {
        if (this.fac == null || this.fac.day == null || this.fac.night == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.bR(this.fac.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.bR(this.fac.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.bR(this.fac.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.bR(this.fac.night.dark_color)));
        return arrayList;
    }

    public boolean atK() {
        return this.fad;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bdT() {
        return this.faa == 1 && this.fab == 1 && this.bZE != null && this.bZE.private_forum_status.intValue() == 1;
    }

    public boolean bdU() {
        return this.faa == 1 && this.fab == 1 && this.bZE != null && this.bZE.private_forum_status.intValue() == 1 && this.bZE.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.eZX = likeForum.is_sign.intValue();
                this.arz = likeForum.level_id.intValue();
                this.eZY = likeForum.avatar;
                this.faa = likeForum.is_manager.intValue();
                this.fab = likeForum.is_private_forum.intValue();
                this.bZE = likeForum.private_forum_info;
                this.eZZ = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.eSp = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.fac = likeForum.theme_color;
                this.fad = likeForum.need_trans.booleanValue();
                this.fae = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bdV() {
        return this.fae;
    }

    public void cB(long j) {
        this.fae = j;
    }
}
