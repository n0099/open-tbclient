package com.baidu.tieba.frs;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class er extends bw<com.baidu.tbadk.core.data.ax, ew> implements View.OnClickListener {
    private int bkF;
    private int bkG;
    private View.OnClickListener bkL;
    private int maxWidth;

    public er(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bkG = 0;
        this.bkF = 0;
        this.bkL = new es(this);
        Activity pageActivity = baseActivity.getPageContext().getPageActivity();
        if (pageActivity != null && pageActivity.getResources() != null) {
            this.maxWidth = com.baidu.adp.lib.util.k.B(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(t.e.ds30) * 2);
            this.bkG = com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds38);
            this.bkF = com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds24);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public ew b(ViewGroup viewGroup) {
        return new ew(LayoutInflater.from(this.mContext).inflate(t.h.frs_text_vote_item, (ViewGroup) null));
    }

    private void a(int i, View view, com.baidu.tbadk.core.data.ax axVar, ew ewVar) {
        MetaData author;
        if (axVar != null && ewVar != null && (author = axVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ewVar.bll.getLayoutParams();
                layoutParams.topMargin = this.bkF;
                ewVar.bkR.setVisibility(8);
                ewVar.bll.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ewVar.bll.getLayoutParams();
                layoutParams2.topMargin = this.bkG;
                ewVar.bkR.setVisibility(0);
                ewVar.bkR.setImageBitmap(null);
                ewVar.bkR.c(themeCard.getCardImageUrlAndroid(), 10, false);
                ewVar.bll.setLayoutParams(layoutParams2);
            }
            ewVar.bkR.setOnClickListener(new et(this, themeCard));
        }
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, ew ewVar) {
        if (ewVar == null || axVar == null || axVar.qL() == null) {
            return null;
        }
        a(i, view, axVar, ewVar);
        if (ewVar.aej != this.mSkinType) {
            com.baidu.tbadk.core.util.at.k(ewVar.bmh, t.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.at.c(ewVar.bmi, t.d.cp_cont_d, 1);
        }
        if (axVar != null && !axVar.rh() && !TextUtils.isEmpty(axVar.getAddress()) && !TextUtils.isEmpty(axVar.getAddress().trim())) {
            ewVar.bji.setVisibility(0);
            ewVar.bkX.setVisibility(0);
            ewVar.bji.setText(axVar.getAddress());
            if (ewVar.aej != this.mSkinType) {
                com.baidu.tbadk.core.util.at.l(ewVar.bkX, t.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.at.c(ewVar.bji, t.d.cp_cont_d, 1);
            }
        } else {
            ewVar.bji.setVisibility(8);
            ewVar.bkX.setVisibility(8);
        }
        ewVar.bmi.setText(com.baidu.tbadk.core.util.ay.x(axVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.ob().od()) {
            ewVar.bmm.setVisibility(0);
            String portrait = axVar.getAuthor().getPortrait();
            ewVar.bmm.setUserId(axVar.getAuthor().getUserId());
            ewVar.bmm.setImageDrawable(null);
            ewVar.bmm.c(portrait, 28, false);
        } else {
            ewVar.bmm.setVisibility(8);
        }
        ewVar.bmm.setOnClickListener(new eu(this, axVar));
        ewVar.bmq.setOnClickListener(new ev(this, axVar));
        ArrayList<IconData> iconInfo = axVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            ewVar.bml.setVisibility(0);
            com.baidu.tbadk.core.util.at.c(ewVar.bmj, t.d.cp_cont_h, 1);
            ewVar.bml.setTag(Integer.valueOf(i));
            ewVar.bml.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            ewVar.bml.setOnClickListener(this.bkL);
        } else {
            ewVar.bml.setVisibility(8);
            com.baidu.tbadk.core.util.at.c(ewVar.bmj, t.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = axVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            ewVar.bmk.setVisibility(0);
            com.baidu.tbadk.core.util.at.c(ewVar.bmj, t.d.cp_cont_h, 1);
            ewVar.bmk.setTag(Integer.valueOf(i));
            ewVar.bmk.setOnClickListener(this);
            ewVar.bmk.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
        } else {
            ewVar.bmk.setVisibility(8);
            com.baidu.tbadk.core.util.at.c(ewVar.bmj, t.d.cp_cont_c, 1);
        }
        ewVar.bmj.setText(axVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
        if (axVar.qY() == 1) {
            ewVar.title.setVisibility(8);
        } else {
            ewVar.title.setVisibility(0);
            axVar.parser_title();
            ewVar.title.setText(axVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.od(axVar.getId())) {
                com.baidu.tbadk.core.util.at.c(ewVar.title, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.c(ewVar.title, t.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (axVar.qS() != null && axVar.qS().trim().length() > 0) {
            stringBuffer.append(axVar.qS());
        }
        ArrayList<MediaData> medias = axVar.getMedias();
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
                    ewVar.bfC.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    ewVar.bfC.setText(stringBuffer.toString());
                }
                ewVar.bfC.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.od(axVar.getId())) {
                    com.baidu.tbadk.core.util.at.c(ewVar.bfC, t.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.at.c(ewVar.bfC, t.d.cp_cont_b, 1);
                }
            } else {
                ewVar.bfC.setVisibility(8);
            }
        }
        int reply_num = axVar.getReply_num();
        ewVar.bmn.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (reply_num > 0) {
            ewVar.bmn.setVisibility(0);
            ewVar.bmn.setText(com.baidu.tbadk.core.util.ay.A(reply_num));
            if (ewVar.aej != this.mSkinType) {
                com.baidu.tbadk.core.util.at.c(ewVar.bmn, t.d.cp_cont_d, 1);
            }
        } else {
            ewVar.bmn.setVisibility(8);
        }
        long longValue = axVar.qL().total_poll.longValue();
        ewVar.bmo.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (longValue > 0) {
            ewVar.bmo.setVisibility(0);
            ewVar.bmo.setText(com.baidu.tbadk.core.util.ay.A(axVar.qL().total_num.longValue()));
            if (ewVar.aej != this.mSkinType) {
                com.baidu.tbadk.core.util.at.c(ewVar.bmo, t.d.cp_cont_d, 1);
            }
        } else {
            ewVar.bmo.setVisibility(8);
        }
        long j = longValue < 0 ? 0L : longValue;
        List<PollOption> list = axVar.qL().options;
        LinkedList linkedList = new LinkedList();
        if (list != null && list.size() > 0) {
            int i4 = 1;
            for (PollOption pollOption : list) {
                if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                    fx fxVar = new fx();
                    fxVar.a(i4, pollOption, j);
                    linkedList.add(fxVar);
                    int i5 = i4 + 1;
                    if (i5 > 3) {
                        break;
                    }
                    i4 = i5;
                }
            }
            if (linkedList.size() > 0) {
                ewVar.bmr.setWidth(this.maxWidth);
                ewVar.bmr.setBoallotsForListView(linkedList);
                ewVar.bmr.onChangeSkinType(this.mSkinType);
                ewVar.bmr.setVisibility(0);
            } else {
                ewVar.bmr.setVisibility(8);
            }
        }
        if (axVar.qL().options_count.intValue() == 0) {
            ewVar.bms.setVisibility(8);
            ewVar.bmt.setVisibility(8);
        } else {
            String string = this.bek.getResources().getString(t.j.total_x_vote_option);
            ewVar.bms.setVisibility(0);
            ewVar.bms.setText(String.format(string, axVar.qL().options_count));
            if (ewVar.aej != this.mSkinType) {
                com.baidu.tbadk.core.util.at.c(ewVar.bms, t.d.cp_cont_c, 1);
            }
            if (StringUtils.isNull(axVar.qL().tips, true)) {
                ewVar.bmt.setVisibility(8);
            } else {
                ewVar.bmt.setVisibility(0);
                ewVar.bmt.setText("(" + axVar.qL().tips + ")");
                if (ewVar.aej != this.mSkinType) {
                    com.baidu.tbadk.core.util.at.c(ewVar.bmt, t.d.cp_cont_d, 1);
                }
            }
        }
        ewVar.aej = this.mSkinType;
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, ew ewVar) {
        super.a(i, view, viewGroup, (ViewGroup) axVar, (com.baidu.tbadk.core.data.ax) ewVar);
        return a(i, view, viewGroup, axVar, ewVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bix != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.v at = at(intValue);
                if (at instanceof com.baidu.tbadk.core.data.ax) {
                    View childAt = this.bfr.getChildAt(intValue - (this.bfr.getFirstVisiblePosition() - this.bfr.getHeaderViewsCount()));
                    this.bix.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.ax) at);
                }
            }
        }
    }
}
