package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class dm extends bm<com.baidu.tbadk.core.data.z, dq> implements View.OnClickListener {
    private BaseActivity aXA;
    private boolean aYl;
    private boolean bdr;
    private View.OnClickListener bdv;

    /* JADX INFO: Access modifiers changed from: protected */
    public dm(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aYl = false;
        this.bdr = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.bdv = new dn(this);
        this.aXA = baseActivity;
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.z zVar, dq dqVar) {
        if (zVar == null || zVar.sH() == null) {
            return null;
        }
        if (dqVar.afY != this.mSkinType) {
            dqVar.beg.setGrade(com.baidu.tbadk.core.util.as.getDrawable(n.e.pic_grade_vote_no1));
            dqVar.beh.setGrade(com.baidu.tbadk.core.util.as.getDrawable(n.e.pic_grade_vote_no2));
            dqVar.bei.setGrade(com.baidu.tbadk.core.util.as.getDrawable(n.e.pic_grade_vote_no3));
            dqVar.beg.onChangeSkinType(this.mSkinType);
            dqVar.beh.onChangeSkinType(this.mSkinType);
            dqVar.bei.onChangeSkinType(this.mSkinType);
            dqVar.bee.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
            dqVar.aYK.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.util.as.h((View) dqVar.bee, n.c.cp_cont_d);
            com.baidu.tbadk.core.util.as.h((View) dqVar.aYK, n.c.cp_cont_d);
            com.baidu.tbadk.core.util.as.h((View) dqVar.aYC, n.c.cp_cont_d);
            com.baidu.tbadk.core.util.as.j(dqVar.bcl, n.c.cp_bg_line_c);
            com.baidu.tbadk.core.util.as.h((View) dqVar.bck, n.c.cp_cont_d);
            com.baidu.tbadk.core.util.as.h((View) dqVar.bej, n.c.cp_cont_c);
            com.baidu.tbadk.core.util.as.h((View) dqVar.bek, n.c.cp_cont_c);
            com.baidu.tbadk.core.util.as.i(dqVar.aYy, n.e.frs_item_control_btn_bg);
        }
        if (zVar != null && !zVar.sZ() && !TextUtils.isEmpty(zVar.getAddress()) && !TextUtils.isEmpty(zVar.getAddress().trim())) {
            dqVar.bck.setVisibility(0);
            dqVar.bcl.setVisibility(0);
            dqVar.bck.setText(zVar.getAddress());
        } else {
            dqVar.bck.setVisibility(8);
            dqVar.bcl.setVisibility(8);
        }
        dqVar.aYC.setText(com.baidu.tbadk.core.util.ax.s(zVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.rh().rj()) {
            dqVar.aYF.setVisibility(0);
            String portrait = zVar.getAuthor().getPortrait();
            dqVar.aYF.setUserId(zVar.getAuthor().getUserId());
            dqVar.aYF.setImageDrawable(null);
            dqVar.aYF.d(portrait, 28, false);
        } else {
            dqVar.aYF.setVisibility(8);
        }
        dqVar.aYF.setOnClickListener(new Cdo(this, zVar));
        dqVar.aYO.setOnClickListener(new dp(this, zVar));
        ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            dqVar.bdA.setVisibility(0);
            com.baidu.tbadk.core.util.as.b(dqVar.aYD, n.c.cp_cont_h, 1);
            dqVar.bdA.setTag(Integer.valueOf(i));
            dqVar.bdA.setOnClickListener(this);
            dqVar.bdA.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.d.ds30), this.mContext.getResources().getDimensionPixelSize(n.d.ds30), this.mContext.getResources().getDimensionPixelSize(n.d.ds10), true);
            dqVar.bdA.setOnClickListener(this.bdv);
        } else {
            dqVar.bdA.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(dqVar.aYD, n.c.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dqVar.aYE.setVisibility(0);
            com.baidu.tbadk.core.util.as.b(dqVar.aYD, n.c.cp_cont_h, 1);
            dqVar.aYE.setTag(Integer.valueOf(i));
            dqVar.aYE.setOnClickListener(this);
            dqVar.aYE.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_width), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.d.small_icon_margin), true);
        } else {
            dqVar.aYE.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(dqVar.aYD, n.c.cp_cont_c, 1);
        }
        dqVar.aYD.setText(zVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (zVar.sS() == 1) {
            dqVar.aUB.setVisibility(8);
        } else {
            dqVar.aUB.setVisibility(0);
            zVar.parser_title();
            dqVar.aUB.setText(zVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mF(zVar.getId())) {
                com.baidu.tbadk.core.util.as.b(dqVar.aUB, n.c.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(dqVar.aUB, n.c.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (zVar.sO() != null && zVar.sO().trim().length() > 0) {
            stringBuffer.append(zVar.sO());
        }
        ArrayList<MediaData> medias = zVar.getMedias();
        if (medias != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= medias.size()) {
                    break;
                }
                if (medias.get(i3).getVideoUrl() != null && medias.get(i3).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(medias.get(i3).getVideoUrl());
                }
                i2 = i3 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                if (stringBuffer.length() > 170) {
                    dqVar.aYz.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dqVar.aYz.setText(stringBuffer.toString());
                }
                dqVar.aYz.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.mF(zVar.getId())) {
                    com.baidu.tbadk.core.util.as.b(dqVar.aYz, n.c.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(dqVar.aYz, n.c.cp_cont_b, 1);
                }
            } else {
                dqVar.aYz.setVisibility(8);
            }
        }
        int reply_num = zVar.getReply_num();
        if (reply_num > 0) {
            dqVar.aYK.setVisibility(0);
            dqVar.aYK.setText(com.baidu.tbadk.core.util.ax.v(reply_num));
        } else {
            dqVar.aYK.setVisibility(8);
        }
        long longValue = zVar.sH().total_num.longValue();
        if (longValue > 0) {
            dqVar.bee.setVisibility(0);
            dqVar.bee.setText(com.baidu.tbadk.core.util.ax.v(longValue));
        } else {
            dqVar.bee.setVisibility(8);
        }
        List<PollOption> list = zVar.sH().options;
        if (com.baidu.tbadk.core.m.rh().rn() && list != null && list.size() > 1) {
            dqVar.bef.setVisibility(0);
            dqVar.beg.setVisibility(0);
            dqVar.beh.setVisibility(0);
            if (list.size() > 2) {
                dqVar.bei.setVisibility(0);
            } else {
                dqVar.bei.setVisibility(4);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < list.size() && i5 != 3) {
                    PollOption pollOption = list.get(i5);
                    switch (i5) {
                        case 0:
                            dqVar.beg.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), zVar.sH().total_poll.longValue());
                            break;
                        case 1:
                            dqVar.beh.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), zVar.sH().total_poll.longValue());
                            break;
                        case 2:
                            dqVar.bei.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), zVar.sH().total_poll.longValue());
                            break;
                    }
                    i4 = i5 + 1;
                }
            }
        } else {
            dqVar.bef.setVisibility(8);
        }
        if (zVar.sH().options_count.intValue() == 0) {
            dqVar.bej.setVisibility(8);
            dqVar.bek.setVisibility(8);
        } else {
            String string = this.aXA.getResources().getString(n.i.total_x_vote_option);
            dqVar.bej.setVisibility(0);
            dqVar.bej.setText(String.format(string, zVar.sH().options_count));
            if (StringUtils.isNull(zVar.sH().tips, true)) {
                dqVar.bek.setVisibility(8);
            } else {
                dqVar.bek.setVisibility(0);
                dqVar.bek.setText("(" + zVar.sH().tips + ")");
            }
        }
        dqVar.afY = this.mSkinType;
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbF != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aB = aB(intValue);
                if (aB instanceof com.baidu.tbadk.core.data.z) {
                    View childAt = this.aYr.getChildAt(intValue - (this.aYr.getFirstVisiblePosition() - this.aYr.getHeaderViewsCount()));
                    this.bbF.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.z) aB);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public dq a(ViewGroup viewGroup) {
        return new dq(LayoutInflater.from(this.mContext).inflate(n.g.frs_pic_vote_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, dq dqVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) dqVar);
        return a(i, view, zVar, dqVar);
    }
}
