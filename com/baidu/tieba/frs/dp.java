package com.baidu.tieba.frs;

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
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class dp extends bw<com.baidu.tbadk.core.data.ax, du> implements View.OnClickListener {
    private BaseActivity bek;
    private boolean bfl;
    private int bkF;
    private int bkG;
    private View.OnClickListener bkL;

    public dp(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bfl = false;
        this.bkG = 0;
        this.bkF = 0;
        this.bkL = new dq(this);
        this.bek = baseActivity;
        this.bkG = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds38);
        this.bkF = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds24);
    }

    private void a(int i, View view, com.baidu.tbadk.core.data.ax axVar, du duVar) {
        MetaData author;
        if (axVar != null && duVar != null && (author = axVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) duVar.bll.getLayoutParams();
                layoutParams.topMargin = this.bkF;
                duVar.bkR.setVisibility(8);
                duVar.bll.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) duVar.bll.getLayoutParams();
                layoutParams2.topMargin = this.bkG;
                duVar.bkR.setVisibility(0);
                duVar.bkR.setImageBitmap(null);
                duVar.bkR.c(themeCard.getCardImageUrlAndroid(), 10, false);
                duVar.bll.setLayoutParams(layoutParams2);
            }
            duVar.bkR.setOnClickListener(new dr(this, themeCard));
        }
    }

    private View b(int i, View view, com.baidu.tbadk.core.data.ax axVar, du duVar) {
        if (axVar == null || axVar.qM() == null) {
            return null;
        }
        a(i, view, axVar, duVar);
        if (duVar.aej != this.mSkinType) {
            duVar.blo.setGrade(com.baidu.tbadk.core.util.at.getDrawable(t.f.pic_grade_vote_no1));
            duVar.blp.setGrade(com.baidu.tbadk.core.util.at.getDrawable(t.f.pic_grade_vote_no2));
            duVar.blq.setGrade(com.baidu.tbadk.core.util.at.getDrawable(t.f.pic_grade_vote_no3));
            duVar.blo.onChangeSkinType(this.mSkinType);
            duVar.blp.onChangeSkinType(this.mSkinType);
            duVar.blq.onChangeSkinType(this.mSkinType);
            duVar.blm.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
            duVar.bfK.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.util.at.j((View) duVar.blm, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) duVar.bfK, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) duVar.adg, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.l(duVar.bkX, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) duVar.bji, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) duVar.blr, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.j((View) duVar.bls, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.k(duVar.bfB, t.f.frs_item_control_btn_bg);
        }
        if (axVar != null && !axVar.ri() && !TextUtils.isEmpty(axVar.getAddress()) && !TextUtils.isEmpty(axVar.getAddress().trim())) {
            duVar.bji.setVisibility(0);
            duVar.bkX.setVisibility(0);
            duVar.bji.setText(axVar.getAddress());
        } else {
            duVar.bji.setVisibility(8);
            duVar.bkX.setVisibility(8);
        }
        duVar.adg.setText(com.baidu.tbadk.core.util.ay.x(axVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.ob().od()) {
            duVar.bfG.setVisibility(0);
            String portrait = axVar.getAuthor().getPortrait();
            duVar.bfG.setUserId(axVar.getAuthor().getUserId());
            duVar.bfG.setImageDrawable(null);
            duVar.bfG.c(portrait, 28, false);
        } else {
            duVar.bfG.setVisibility(8);
        }
        duVar.bfG.setOnClickListener(new ds(this, axVar));
        duVar.bfO.setOnClickListener(new dt(this, axVar));
        ArrayList<IconData> iconInfo = axVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            duVar.adI.setVisibility(0);
            com.baidu.tbadk.core.util.at.c(duVar.bfF, t.d.cp_cont_h, 1);
            duVar.adI.setTag(Integer.valueOf(i));
            duVar.adI.setOnClickListener(this);
            duVar.adI.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            duVar.adI.setOnClickListener(this.bkL);
        } else {
            duVar.adI.setVisibility(8);
            com.baidu.tbadk.core.util.at.c(duVar.bfF, t.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = axVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            duVar.adH.setVisibility(0);
            com.baidu.tbadk.core.util.at.c(duVar.bfF, t.d.cp_cont_h, 1);
            duVar.adH.setTag(Integer.valueOf(i));
            duVar.adH.setOnClickListener(this);
            duVar.adH.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
        } else {
            duVar.adH.setVisibility(8);
            com.baidu.tbadk.core.util.at.c(duVar.bfF, t.d.cp_cont_c, 1);
        }
        duVar.bfF.setText(axVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
        if (axVar.qZ() == 1) {
            duVar.aOG.setVisibility(8);
        } else {
            duVar.aOG.setVisibility(0);
            axVar.parser_title();
            duVar.aOG.setText(axVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.od(axVar.getId())) {
                com.baidu.tbadk.core.util.at.c(duVar.aOG, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.c(duVar.aOG, t.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (axVar.qT() != null && axVar.qT().trim().length() > 0) {
            stringBuffer.append(axVar.qT());
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
                    duVar.bfC.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    duVar.bfC.setText(stringBuffer.toString());
                }
                duVar.bfC.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.od(axVar.getId())) {
                    com.baidu.tbadk.core.util.at.c(duVar.bfC, t.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.at.c(duVar.bfC, t.d.cp_cont_b, 1);
                }
            } else {
                duVar.bfC.setVisibility(8);
            }
        }
        int reply_num = axVar.getReply_num();
        if (reply_num > 0) {
            duVar.bfK.setVisibility(0);
            duVar.bfK.setText(com.baidu.tbadk.core.util.ay.A(reply_num));
        } else {
            duVar.bfK.setVisibility(8);
        }
        long longValue = axVar.qM().total_num.longValue();
        if (longValue > 0) {
            duVar.blm.setVisibility(0);
            duVar.blm.setText(com.baidu.tbadk.core.util.ay.A(longValue));
        } else {
            duVar.blm.setVisibility(8);
        }
        List<PollOption> list = axVar.qM().options;
        if (com.baidu.tbadk.core.l.ob().oh() && list != null && list.size() > 1) {
            duVar.bln.setVisibility(0);
            duVar.blo.setVisibility(0);
            duVar.blp.setVisibility(0);
            if (list.size() > 2) {
                duVar.blq.setVisibility(0);
            } else {
                duVar.blq.setVisibility(4);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < list.size() && i5 != 3) {
                    PollOption pollOption = list.get(i5);
                    switch (i5) {
                        case 0:
                            duVar.blo.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), axVar.qM().total_poll.longValue());
                            break;
                        case 1:
                            duVar.blp.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), axVar.qM().total_poll.longValue());
                            break;
                        case 2:
                            duVar.blq.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), axVar.qM().total_poll.longValue());
                            break;
                    }
                    i4 = i5 + 1;
                }
            }
        } else {
            duVar.bln.setVisibility(8);
        }
        if (axVar.qM().options_count.intValue() == 0) {
            duVar.blr.setVisibility(8);
            duVar.bls.setVisibility(8);
        } else {
            String string = this.bek.getResources().getString(t.j.total_x_vote_option);
            duVar.blr.setVisibility(0);
            duVar.blr.setText(String.format(string, axVar.qM().options_count));
            if (StringUtils.isNull(axVar.qM().tips, true)) {
                duVar.bls.setVisibility(8);
            } else {
                duVar.bls.setVisibility(0);
                duVar.bls.setText("(" + axVar.qM().tips + ")");
            }
        }
        duVar.aej = this.mSkinType;
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bix != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.v as = as(intValue);
                if (as instanceof com.baidu.tbadk.core.data.ax) {
                    View childAt = this.bfr.getChildAt(intValue - (this.bfr.getFirstVisiblePosition() - this.bfr.getHeaderViewsCount()));
                    this.bix.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.ax) as);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: t */
    public du b(ViewGroup viewGroup) {
        return new du(LayoutInflater.from(this.mContext).inflate(t.h.frs_pic_vote_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, du duVar) {
        super.a(i, view, viewGroup, (ViewGroup) axVar, (com.baidu.tbadk.core.data.ax) duVar);
        return b(i, view, axVar, duVar);
    }
}
