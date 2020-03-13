package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class f extends d implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo cQl;
    private int fUA;
    private ThemeColorInfo fUB;
    private boolean fUC;
    private long fUD;
    private int fUw;
    private int fUx;
    private int fUy;
    private int fUz;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;

    public f() {
        setType(1);
    }

    public String bxQ() {
        return this.mContent;
    }

    public int bxR() {
        return this.fUA;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void rM(int i) {
        this.fUw = i;
    }

    public int bxS() {
        return this.fUw;
    }

    public int bxT() {
        return this.fUy;
    }

    public int isPrivateForum() {
        return this.fUz;
    }

    public int bxU() {
        return this.fUx;
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

    public ThemeColorInfo bxV() {
        return this.fUB;
    }

    public ArrayList<Integer> bxW() {
        if (this.fUB == null || this.fUB.day == null || this.fUB.night == null || this.fUB.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUB.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUB.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUB.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUB.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUB.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.a.cG(this.fUB.dark.dark_color)));
        return arrayList;
    }

    public boolean aOh() {
        return this.fUC;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, null);
        }
    }

    public boolean bxX() {
        return this.fUy == 1 && this.fUz == 1 && this.cQl != null && this.cQl.private_forum_status.intValue() == 1;
    }

    public boolean bxY() {
        return this.fUy == 1 && this.fUz == 1 && this.cQl != null && this.cQl.private_forum_status.intValue() == 1 && this.cQl.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.fUw = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.fUy = likeForum.is_manager.intValue();
                this.fUz = likeForum.is_private_forum.intValue();
                this.cQl = likeForum.private_forum_info;
                this.fUx = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.fUA = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.fUB = likeForum.theme_color;
                this.fUC = likeForum.need_trans.booleanValue();
                this.fUD = likeForum.hot_thread_id.longValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long bxZ() {
        return this.fUD;
    }

    /* renamed from: do  reason: not valid java name */
    public void m33do(long j) {
        this.fUD = j;
    }
}
