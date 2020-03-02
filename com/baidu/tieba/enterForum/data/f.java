package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo cQk;
    private int fUj;
    private int fUk;
    private int fUl;
    private int fUm;
    private int fUn;
    private ThemeColorInfo fUo;
    private boolean fUp;
    private long fUq;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bxP() {
        return this.mContent;
    }

    public int bxQ() {
        return this.fUn;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void rM(int i) {
        this.fUj = i;
    }

    public int bxR() {
        return this.fUj;
    }

    public int bxS() {
        return this.fUl;
    }

    public int isPrivateForum() {
        return this.fUm;
    }

    public int bxT() {
        return this.fUk;
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

    public ThemeColorInfo bxU() {
        return this.fUo;
    }

    public ArrayList<Integer> bxV() {
        if (this.fUo == null || this.fUo.day == null || this.fUo.night == null || this.fUo.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUo.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUo.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUo.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUo.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUo.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUo.dark.dark_color)));
        return arrayList;
    }

    public boolean aOg() {
        return this.fUp;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bxW() {
        return this.fUl == 1 && this.fUm == 1 && this.cQk != null && this.cQk.private_forum_status.intValue() == 1;
    }

    public boolean bxX() {
        return this.fUl == 1 && this.fUm == 1 && this.cQk != null && this.cQk.private_forum_status.intValue() == 1 && this.cQk.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.fUj = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.fUl = likeForum.is_manager.intValue();
                this.fUm = likeForum.is_private_forum.intValue();
                this.cQk = likeForum.private_forum_info;
                this.fUk = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.fUn = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.fUo = likeForum.theme_color;
                this.fUp = likeForum.need_trans.booleanValue();
                this.fUq = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bxY() {
        return this.fUq;
    }

    /* renamed from: do  reason: not valid java name */
    public void m33do(long j) {
        this.fUq = j;
    }
}
