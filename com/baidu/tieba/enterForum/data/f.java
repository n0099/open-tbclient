package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo cQj;
    private int fUh;
    private int fUi;
    private int fUj;
    private int fUk;
    private int fUl;
    private ThemeColorInfo fUm;
    private boolean fUn;
    private long fUo;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bxN() {
        return this.mContent;
    }

    public int bxO() {
        return this.fUl;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void rM(int i) {
        this.fUh = i;
    }

    public int bxP() {
        return this.fUh;
    }

    public int bxQ() {
        return this.fUj;
    }

    public int isPrivateForum() {
        return this.fUk;
    }

    public int bxR() {
        return this.fUi;
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

    public ThemeColorInfo bxS() {
        return this.fUm;
    }

    public ArrayList<Integer> bxT() {
        if (this.fUm == null || this.fUm.day == null || this.fUm.night == null || this.fUm.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUm.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUm.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUm.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUm.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUm.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUm.dark.dark_color)));
        return arrayList;
    }

    public boolean aOe() {
        return this.fUn;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bxU() {
        return this.fUj == 1 && this.fUk == 1 && this.cQj != null && this.cQj.private_forum_status.intValue() == 1;
    }

    public boolean bxV() {
        return this.fUj == 1 && this.fUk == 1 && this.cQj != null && this.cQj.private_forum_status.intValue() == 1 && this.cQj.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.fUh = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.fUj = likeForum.is_manager.intValue();
                this.fUk = likeForum.is_private_forum.intValue();
                this.cQj = likeForum.private_forum_info;
                this.fUi = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.fUl = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.fUm = likeForum.theme_color;
                this.fUn = likeForum.need_trans.booleanValue();
                this.fUo = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bxW() {
        return this.fUo;
    }

    /* renamed from: do  reason: not valid java name */
    public void m33do(long j) {
        this.fUo = j;
    }
}
