package com.baidu.tieba.enterForum.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.u;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import tbclient.ForumRecommend.LikeForum;
import tbclient.FrsTabInfo;
import tbclient.PrivateForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes22.dex */
public class f extends u implements com.baidu.tbadk.mvc.b.a {
    private PrivateForumInfo eCq;
    private int iiL;
    private int iiM;
    private int iiN;
    private int iiO;
    private int iiP;
    private ThemeColorInfo iiQ;
    private boolean iiR;
    private long iiS;
    private String mAvatar;
    private String mContent;
    private String mId;
    private int mLevel;
    private String mName;
    private int sortType;
    private ArrayList<FrsTabItemData> tabItemDatas;

    public f() {
        nT(1);
    }

    public String crb() {
        return this.mContent;
    }

    public int crc() {
        return this.iiP;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void xF(int i) {
        this.iiL = i;
    }

    public int crd() {
        return this.iiL;
    }

    public int cre() {
        return this.iiN;
    }

    public int isPrivateForum() {
        return this.iiO;
    }

    public int crf() {
        return this.iiM;
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

    public ThemeColorInfo crg() {
        return this.iiQ;
    }

    public ArrayList<Integer> crh() {
        if (this.iiQ == null || this.iiQ.day == null || this.iiQ.night == null || this.iiQ.dark == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.iiQ.day.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.iiQ.day.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.iiQ.night.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.iiQ.night.dark_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.iiQ.dark.light_color)));
        arrayList.add(Integer.valueOf(com.baidu.tieba.lego.card.d.b.fv(this.iiQ.dark.dark_color)));
        return arrayList;
    }

    public boolean bze() {
        return this.iiR;
    }

    public void a(LikeForum likeForum) {
        if (likeForum != null) {
            a(likeForum, (Context) null);
        }
    }

    public boolean cri() {
        return this.iiN == 1 && this.iiO == 1 && this.eCq != null && this.eCq.private_forum_status.intValue() == 1;
    }

    public boolean crj() {
        return this.iiN == 1 && this.iiO == 1 && this.eCq != null && this.eCq.private_forum_status.intValue() == 1 && this.eCq.private_forum_audit_status.intValue() == 2;
    }

    public void a(LikeForum likeForum, Context context) {
        if (likeForum != null) {
            try {
                this.mId = String.valueOf(likeForum.forum_id);
                this.mName = likeForum.forum_name;
                this.iiL = likeForum.is_sign.intValue();
                this.mLevel = likeForum.level_id.intValue();
                this.mAvatar = likeForum.avatar;
                this.iiN = likeForum.is_manager.intValue();
                this.iiO = likeForum.is_private_forum.intValue();
                this.eCq = likeForum.private_forum_info;
                this.iiM = likeForum.is_brand_forum.intValue();
                this.mContent = likeForum.content;
                this.iiP = likeForum.is_top.intValue();
                this.sortType = likeForum.sort_type.intValue();
                this.iiQ = likeForum.theme_color;
                this.iiR = likeForum.need_trans.booleanValue();
                this.iiS = likeForum.hot_thread_id.longValue();
                this.tabItemDatas = new ArrayList<>();
                for (FrsTabInfo frsTabInfo : likeForum.tab_info) {
                    if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                        this.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long crk() {
        return this.iiS;
    }

    public void fw(long j) {
        this.iiS = j;
    }

    public ArrayList<FrsTabItemData> crl() {
        return this.tabItemDatas;
    }
}
