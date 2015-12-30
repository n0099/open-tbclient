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
public class dm extends bp<com.baidu.tbadk.core.data.z, dq> implements View.OnClickListener {
    private BaseActivity bbA;
    private boolean bck;
    private boolean bhr;
    private View.OnClickListener bhv;

    /* JADX INFO: Access modifiers changed from: protected */
    public dm(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bck = false;
        this.bhr = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
        this.bhv = new dn(this);
        this.bbA = baseActivity;
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.z zVar, dq dqVar) {
        if (zVar == null || zVar.sr() == null) {
            return null;
        }
        if (dqVar.ahf != this.mSkinType) {
            dqVar.bhZ.setGrade(com.baidu.tbadk.core.util.as.getDrawable(n.f.pic_grade_vote_no1));
            dqVar.bia.setGrade(com.baidu.tbadk.core.util.as.getDrawable(n.f.pic_grade_vote_no2));
            dqVar.bib.setGrade(com.baidu.tbadk.core.util.as.getDrawable(n.f.pic_grade_vote_no3));
            dqVar.bhZ.onChangeSkinType(this.mSkinType);
            dqVar.bia.onChangeSkinType(this.mSkinType);
            dqVar.bib.onChangeSkinType(this.mSkinType);
            dqVar.bhX.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
            dqVar.bcG.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.util.as.h((View) dqVar.bhX, n.d.cp_cont_d);
            com.baidu.tbadk.core.util.as.h((View) dqVar.bcG, n.d.cp_cont_d);
            com.baidu.tbadk.core.util.as.h((View) dqVar.agy, n.d.cp_cont_d);
            com.baidu.tbadk.core.util.as.j(dqVar.bgk, n.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.as.h((View) dqVar.bgj, n.d.cp_cont_d);
            com.baidu.tbadk.core.util.as.h((View) dqVar.bic, n.d.cp_cont_c);
            com.baidu.tbadk.core.util.as.h((View) dqVar.bie, n.d.cp_cont_c);
            com.baidu.tbadk.core.util.as.i(dqVar.bcx, n.f.frs_item_control_btn_bg);
        }
        if (zVar != null && !zVar.sJ() && !TextUtils.isEmpty(zVar.getAddress()) && !TextUtils.isEmpty(zVar.getAddress().trim())) {
            dqVar.bgj.setVisibility(0);
            dqVar.bgk.setVisibility(0);
            dqVar.bgj.setText(zVar.getAddress());
        } else {
            dqVar.bgj.setVisibility(8);
            dqVar.bgk.setVisibility(8);
        }
        dqVar.agy.setText(com.baidu.tbadk.core.util.ax.s(zVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.m.qQ().qS()) {
            dqVar.bcC.setVisibility(0);
            String portrait = zVar.getAuthor().getPortrait();
            dqVar.bcC.setUserId(zVar.getAuthor().getUserId());
            dqVar.bcC.setImageDrawable(null);
            dqVar.bcC.d(portrait, 28, false);
        } else {
            dqVar.bcC.setVisibility(8);
        }
        dqVar.bcC.setOnClickListener(new Cdo(this, zVar));
        dqVar.bcK.setOnClickListener(new dp(this, zVar));
        ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            dqVar.agU.setVisibility(0);
            com.baidu.tbadk.core.util.as.b(dqVar.bcB, n.d.cp_cont_h, 1);
            dqVar.agU.setTag(Integer.valueOf(i));
            dqVar.agU.setOnClickListener(this);
            dqVar.agU.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds10), true);
            dqVar.agU.setOnClickListener(this.bhv);
        } else {
            dqVar.agU.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(dqVar.bcB, n.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dqVar.agT.setVisibility(0);
            com.baidu.tbadk.core.util.as.b(dqVar.bcB, n.d.cp_cont_h, 1);
            dqVar.agT.setTag(Integer.valueOf(i));
            dqVar.agT.setOnClickListener(this);
            dqVar.agT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_margin), true);
        } else {
            dqVar.agT.setVisibility(8);
            com.baidu.tbadk.core.util.as.b(dqVar.bcB, n.d.cp_cont_c, 1);
        }
        dqVar.bcB.setText(zVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (zVar.sC() == 1) {
            dqVar.aOn.setVisibility(8);
        } else {
            dqVar.aOn.setVisibility(0);
            zVar.parser_title();
            dqVar.aOn.setText(zVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mC(zVar.getId())) {
                com.baidu.tbadk.core.util.as.b(dqVar.aOn, n.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(dqVar.aOn, n.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (zVar.sy() != null && zVar.sy().trim().length() > 0) {
            stringBuffer.append(zVar.sy());
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
                    dqVar.bcy.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dqVar.bcy.setText(stringBuffer.toString());
                }
                dqVar.bcy.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.mC(zVar.getId())) {
                    com.baidu.tbadk.core.util.as.b(dqVar.bcy, n.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.as.b(dqVar.bcy, n.d.cp_cont_b, 1);
                }
            } else {
                dqVar.bcy.setVisibility(8);
            }
        }
        int reply_num = zVar.getReply_num();
        if (reply_num > 0) {
            dqVar.bcG.setVisibility(0);
            dqVar.bcG.setText(com.baidu.tbadk.core.util.ax.w(reply_num));
        } else {
            dqVar.bcG.setVisibility(8);
        }
        long longValue = zVar.sr().total_num.longValue();
        if (longValue > 0) {
            dqVar.bhX.setVisibility(0);
            dqVar.bhX.setText(com.baidu.tbadk.core.util.ax.w(longValue));
        } else {
            dqVar.bhX.setVisibility(8);
        }
        List<PollOption> list = zVar.sr().options;
        if (com.baidu.tbadk.core.m.qQ().qW() && list != null && list.size() > 1) {
            dqVar.bhY.setVisibility(0);
            dqVar.bhZ.setVisibility(0);
            dqVar.bia.setVisibility(0);
            if (list.size() > 2) {
                dqVar.bib.setVisibility(0);
            } else {
                dqVar.bib.setVisibility(4);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < list.size() && i5 != 3) {
                    PollOption pollOption = list.get(i5);
                    switch (i5) {
                        case 0:
                            dqVar.bhZ.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), zVar.sr().total_poll.longValue());
                            break;
                        case 1:
                            dqVar.bia.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), zVar.sr().total_poll.longValue());
                            break;
                        case 2:
                            dqVar.bib.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), zVar.sr().total_poll.longValue());
                            break;
                    }
                    i4 = i5 + 1;
                }
            }
        } else {
            dqVar.bhY.setVisibility(8);
        }
        if (zVar.sr().options_count.intValue() == 0) {
            dqVar.bic.setVisibility(8);
            dqVar.bie.setVisibility(8);
        } else {
            String string = this.bbA.getResources().getString(n.j.total_x_vote_option);
            dqVar.bic.setVisibility(0);
            dqVar.bic.setText(String.format(string, zVar.sr().options_count));
            if (StringUtils.isNull(zVar.sr().tips, true)) {
                dqVar.bie.setVisibility(8);
            } else {
                dqVar.bie.setVisibility(0);
                dqVar.bie.setText("(" + zVar.sr().tips + ")");
            }
        }
        dqVar.ahf = this.mSkinType;
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bfE != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u au = au(intValue);
                if (au instanceof com.baidu.tbadk.core.data.z) {
                    View childAt = this.bcq.getChildAt(intValue - (this.bcq.getFirstVisiblePosition() - this.bcq.getHeaderViewsCount()));
                    this.bfE.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.z) au);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public dq a(ViewGroup viewGroup) {
        return new dq(LayoutInflater.from(this.mContext).inflate(n.h.frs_pic_vote_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.z zVar, dq dqVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tbadk.core.data.z) dqVar);
        return a(i, view, zVar, dqVar);
    }
}
