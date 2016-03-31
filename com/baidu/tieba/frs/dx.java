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
public class dx extends bx<com.baidu.tbadk.core.data.as, ec> implements View.OnClickListener {
    private BaseActivity bix;
    private boolean bjl;
    private int bpo;
    private int bpq;
    private View.OnClickListener bpv;

    /* JADX INFO: Access modifiers changed from: protected */
    public dx(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bjl = false;
        this.bpq = 0;
        this.bpo = 0;
        this.bpv = new dy(this);
        this.bix = baseActivity;
        this.bpq = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds38);
        this.bpo = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds24);
    }

    private void a(int i, View view, com.baidu.tbadk.core.data.as asVar, ec ecVar) {
        MetaData author;
        if (asVar != null && ecVar != null && (author = asVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ecVar.bqe.getLayoutParams();
                layoutParams.topMargin = this.bpo;
                ecVar.bpB.setVisibility(8);
                ecVar.bqe.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ecVar.bqe.getLayoutParams();
                layoutParams2.topMargin = this.bpq;
                ecVar.bpB.setVisibility(0);
                ecVar.bpB.setImageBitmap(null);
                ecVar.bpB.c(themeCard.getCardImageUrlAndroid(), 10, false);
                ecVar.bqe.setLayoutParams(layoutParams2);
            }
            ecVar.bpB.setOnClickListener(new dz(this, themeCard));
        }
    }

    private View b(int i, View view, com.baidu.tbadk.core.data.as asVar, ec ecVar) {
        if (asVar == null || asVar.tm() == null) {
            return null;
        }
        a(i, view, asVar, ecVar);
        if (ecVar.aik != this.mSkinType) {
            ecVar.bqh.setGrade(com.baidu.tbadk.core.util.at.getDrawable(t.f.pic_grade_vote_no1));
            ecVar.bqi.setGrade(com.baidu.tbadk.core.util.at.getDrawable(t.f.pic_grade_vote_no2));
            ecVar.bqj.setGrade(com.baidu.tbadk.core.util.at.getDrawable(t.f.pic_grade_vote_no3));
            ecVar.bqh.onChangeSkinType(this.mSkinType);
            ecVar.bqi.onChangeSkinType(this.mSkinType);
            ecVar.bqj.onChangeSkinType(this.mSkinType);
            ecVar.bqf.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
            ecVar.bjK.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.util.at.j((View) ecVar.bqf, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) ecVar.bjK, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) ecVar.ahr, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.l(ecVar.bpH, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) ecVar.bnF, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.j((View) ecVar.bqk, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.j((View) ecVar.bql, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.at.k(ecVar.bjB, t.f.frs_item_control_btn_bg);
        }
        if (asVar != null && !asVar.tJ() && !TextUtils.isEmpty(asVar.getAddress()) && !TextUtils.isEmpty(asVar.getAddress().trim())) {
            ecVar.bnF.setVisibility(0);
            ecVar.bpH.setVisibility(0);
            ecVar.bnF.setText(asVar.getAddress());
        } else {
            ecVar.bnF.setVisibility(8);
            ecVar.bpH.setVisibility(8);
        }
        ecVar.ahr.setText(com.baidu.tbadk.core.util.ay.w(asVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.qE().qG()) {
            ecVar.bjG.setVisibility(0);
            String portrait = asVar.getAuthor().getPortrait();
            ecVar.bjG.setUserId(asVar.getAuthor().getUserId());
            ecVar.bjG.setImageDrawable(null);
            ecVar.bjG.c(portrait, 28, false);
        } else {
            ecVar.bjG.setVisibility(8);
        }
        ecVar.bjG.setOnClickListener(new ea(this, asVar));
        ecVar.bjO.setOnClickListener(new eb(this, asVar));
        ArrayList<IconData> iconInfo = asVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            ecVar.ahO.setVisibility(0);
            com.baidu.tbadk.core.util.at.b(ecVar.bjF, t.d.cp_cont_h, 1);
            ecVar.ahO.setTag(Integer.valueOf(i));
            ecVar.ahO.setOnClickListener(this);
            ecVar.ahO.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            ecVar.ahO.setOnClickListener(this.bpv);
        } else {
            ecVar.ahO.setVisibility(8);
            com.baidu.tbadk.core.util.at.b(ecVar.bjF, t.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = asVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            ecVar.ahN.setVisibility(0);
            com.baidu.tbadk.core.util.at.b(ecVar.bjF, t.d.cp_cont_h, 1);
            ecVar.ahN.setTag(Integer.valueOf(i));
            ecVar.ahN.setOnClickListener(this);
            ecVar.ahN.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
        } else {
            ecVar.ahN.setVisibility(8);
            com.baidu.tbadk.core.util.at.b(ecVar.bjF, t.d.cp_cont_c, 1);
        }
        ecVar.bjF.setText(asVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (asVar.tA() == 1) {
            ecVar.aSh.setVisibility(8);
        } else {
            ecVar.aSh.setVisibility(0);
            asVar.parser_title();
            ecVar.aSh.setText(asVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.oh(asVar.getId())) {
                com.baidu.tbadk.core.util.at.b(ecVar.aSh, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.b(ecVar.aSh, t.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (asVar.tu() != null && asVar.tu().trim().length() > 0) {
            stringBuffer.append(asVar.tu());
        }
        ArrayList<MediaData> medias = asVar.getMedias();
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
                    ecVar.bjC.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    ecVar.bjC.setText(stringBuffer.toString());
                }
                ecVar.bjC.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.oh(asVar.getId())) {
                    com.baidu.tbadk.core.util.at.b(ecVar.bjC, t.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.at.b(ecVar.bjC, t.d.cp_cont_b, 1);
                }
            } else {
                ecVar.bjC.setVisibility(8);
            }
        }
        int reply_num = asVar.getReply_num();
        if (reply_num > 0) {
            ecVar.bjK.setVisibility(0);
            ecVar.bjK.setText(com.baidu.tbadk.core.util.ay.z(reply_num));
        } else {
            ecVar.bjK.setVisibility(8);
        }
        long longValue = asVar.tm().total_num.longValue();
        if (longValue > 0) {
            ecVar.bqf.setVisibility(0);
            ecVar.bqf.setText(com.baidu.tbadk.core.util.ay.z(longValue));
        } else {
            ecVar.bqf.setVisibility(8);
        }
        List<PollOption> list = asVar.tm().options;
        if (com.baidu.tbadk.core.l.qE().qK() && list != null && list.size() > 1) {
            ecVar.bqg.setVisibility(0);
            ecVar.bqh.setVisibility(0);
            ecVar.bqi.setVisibility(0);
            if (list.size() > 2) {
                ecVar.bqj.setVisibility(0);
            } else {
                ecVar.bqj.setVisibility(4);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < list.size() && i5 != 3) {
                    PollOption pollOption = list.get(i5);
                    switch (i5) {
                        case 0:
                            ecVar.bqh.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), asVar.tm().total_poll.longValue());
                            break;
                        case 1:
                            ecVar.bqi.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), asVar.tm().total_poll.longValue());
                            break;
                        case 2:
                            ecVar.bqj.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), asVar.tm().total_poll.longValue());
                            break;
                    }
                    i4 = i5 + 1;
                }
            }
        } else {
            ecVar.bqg.setVisibility(8);
        }
        if (asVar.tm().options_count.intValue() == 0) {
            ecVar.bqk.setVisibility(8);
            ecVar.bql.setVisibility(8);
        } else {
            String string = this.bix.getResources().getString(t.j.total_x_vote_option);
            ecVar.bqk.setVisibility(0);
            ecVar.bqk.setText(String.format(string, asVar.tm().options_count));
            if (StringUtils.isNull(asVar.tm().tips, true)) {
                ecVar.bql.setVisibility(8);
            } else {
                ecVar.bql.setVisibility(0);
                ecVar.bql.setText("(" + asVar.tm().tips + ")");
            }
        }
        ecVar.aik = this.mSkinType;
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bmX != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aF = aF(intValue);
                if (aF instanceof com.baidu.tbadk.core.data.as) {
                    View childAt = this.bjr.getChildAt(intValue - (this.bjr.getFirstVisiblePosition() - this.bjr.getHeaderViewsCount()));
                    this.bmX.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.as) aF);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public ec b(ViewGroup viewGroup) {
        return new ec(LayoutInflater.from(this.mContext).inflate(t.h.frs_pic_vote_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, ec ecVar) {
        super.a(i, view, viewGroup, (ViewGroup) asVar, (com.baidu.tbadk.core.data.as) ecVar);
        return b(i, view, asVar, ecVar);
    }
}
