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
public class fa extends bx<com.baidu.tbadk.core.data.as, ff> implements View.OnClickListener {
    private int bpo;
    private int bpq;
    private View.OnClickListener bpv;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public fa(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bpq = 0;
        this.bpo = 0;
        this.bpv = new fb(this);
        Activity pageActivity = baseActivity.getPageContext().getPageActivity();
        if (pageActivity != null && pageActivity.getResources() != null) {
            this.maxWidth = com.baidu.adp.lib.util.k.B(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(t.e.ds30) * 2);
            this.bpq = com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds38);
            this.bpo = com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds24);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public ff b(ViewGroup viewGroup) {
        return new ff(LayoutInflater.from(this.mContext).inflate(t.h.frs_text_vote_item, (ViewGroup) null));
    }

    private void a(int i, View view, com.baidu.tbadk.core.data.as asVar, ff ffVar) {
        MetaData author;
        if (asVar != null && ffVar != null && (author = asVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ffVar.bqe.getLayoutParams();
                layoutParams.topMargin = this.bpo;
                ffVar.bpB.setVisibility(8);
                ffVar.bqe.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ffVar.bqe.getLayoutParams();
                layoutParams2.topMargin = this.bpq;
                ffVar.bpB.setVisibility(0);
                ffVar.bpB.setImageBitmap(null);
                ffVar.bpB.c(themeCard.getCardImageUrlAndroid(), 10, false);
                ffVar.bqe.setLayoutParams(layoutParams2);
            }
            ffVar.bpB.setOnClickListener(new fc(this, themeCard));
        }
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, ff ffVar) {
        if (ffVar == null || asVar == null || asVar.tm() == null) {
            return null;
        }
        a(i, view, asVar, ffVar);
        if (ffVar.aik != this.mSkinType) {
            com.baidu.tbadk.core.util.at.k(ffVar.bqU, t.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.at.b(ffVar.bqV, t.d.cp_cont_d, 1);
        }
        if (asVar != null && !asVar.tJ() && !TextUtils.isEmpty(asVar.getAddress()) && !TextUtils.isEmpty(asVar.getAddress().trim())) {
            ffVar.bnF.setVisibility(0);
            ffVar.bpH.setVisibility(0);
            ffVar.bnF.setText(asVar.getAddress());
            if (ffVar.aik != this.mSkinType) {
                com.baidu.tbadk.core.util.at.l(ffVar.bpH, t.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.at.b(ffVar.bnF, t.d.cp_cont_d, 1);
            }
        } else {
            ffVar.bnF.setVisibility(8);
            ffVar.bpH.setVisibility(8);
        }
        ffVar.bqV.setText(com.baidu.tbadk.core.util.ay.w(asVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.qE().qG()) {
            ffVar.bqZ.setVisibility(0);
            String portrait = asVar.getAuthor().getPortrait();
            ffVar.bqZ.setUserId(asVar.getAuthor().getUserId());
            ffVar.bqZ.setImageDrawable(null);
            ffVar.bqZ.c(portrait, 28, false);
        } else {
            ffVar.bqZ.setVisibility(8);
        }
        ffVar.bqZ.setOnClickListener(new fd(this, asVar));
        ffVar.brc.setOnClickListener(new fe(this, asVar));
        ArrayList<IconData> iconInfo = asVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            ffVar.bqY.setVisibility(0);
            if (ffVar.aik != this.mSkinType) {
                com.baidu.tbadk.core.util.at.b(ffVar.bqW, t.d.cp_cont_h, 1);
            }
            ffVar.bqY.setTag(Integer.valueOf(i));
            ffVar.bqY.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            ffVar.bqY.setOnClickListener(this.bpv);
        } else {
            ffVar.bqY.setVisibility(8);
            if (ffVar.aik != this.mSkinType) {
                com.baidu.tbadk.core.util.at.b(ffVar.bqW, t.d.cp_cont_c, 1);
            }
        }
        ArrayList<IconData> tShowInfoNew = asVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            ffVar.bqX.setVisibility(0);
            if (ffVar.aik != this.mSkinType) {
                com.baidu.tbadk.core.util.at.b(ffVar.bqW, t.d.cp_cont_h, 1);
            }
            ffVar.bqX.setTag(Integer.valueOf(i));
            ffVar.bqX.setOnClickListener(this);
            ffVar.bqX.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
        } else {
            ffVar.bqX.setVisibility(8);
            if (ffVar.aik != this.mSkinType) {
                com.baidu.tbadk.core.util.at.b(ffVar.bqW, t.d.cp_cont_c, 1);
            }
        }
        ffVar.bqW.setText(asVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (asVar.tA() == 1) {
            ffVar.apE.setVisibility(8);
        } else {
            ffVar.apE.setVisibility(0);
            asVar.parser_title();
            ffVar.apE.setText(asVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.oh(asVar.getId())) {
                com.baidu.tbadk.core.util.at.b(ffVar.apE, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.b(ffVar.apE, t.d.cp_cont_b, 1);
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
                    ffVar.bjC.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    ffVar.bjC.setText(stringBuffer.toString());
                }
                ffVar.bjC.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.oh(asVar.getId())) {
                    com.baidu.tbadk.core.util.at.b(ffVar.bjC, t.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.at.b(ffVar.bjC, t.d.cp_cont_b, 1);
                }
            } else {
                ffVar.bjC.setVisibility(8);
            }
        }
        int reply_num = asVar.getReply_num();
        ffVar.bra.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (reply_num > 0) {
            ffVar.bra.setVisibility(0);
            ffVar.bra.setText(com.baidu.tbadk.core.util.ay.z(reply_num));
            if (ffVar.aik != this.mSkinType) {
                com.baidu.tbadk.core.util.at.b(ffVar.bra, t.d.cp_cont_d, 1);
            }
        } else {
            ffVar.bra.setVisibility(8);
        }
        long longValue = asVar.tm().total_poll.longValue();
        ffVar.brb.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (longValue > 0) {
            ffVar.brb.setVisibility(0);
            ffVar.brb.setText(com.baidu.tbadk.core.util.ay.z(asVar.tm().total_num.longValue()));
            if (ffVar.aik != this.mSkinType) {
                com.baidu.tbadk.core.util.at.b(ffVar.brb, t.d.cp_cont_d, 1);
            }
        } else {
            ffVar.brb.setVisibility(8);
        }
        long j = longValue < 0 ? 0L : longValue;
        List<PollOption> list = asVar.tm().options;
        LinkedList linkedList = new LinkedList();
        if (list != null && list.size() > 0) {
            int i4 = 1;
            for (PollOption pollOption : list) {
                if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                    fy fyVar = new fy();
                    fyVar.a(i4, pollOption, j);
                    linkedList.add(fyVar);
                    int i5 = i4 + 1;
                    if (i5 > 3) {
                        break;
                    }
                    i4 = i5;
                }
            }
            if (linkedList.size() > 0) {
                ffVar.brd.setWidth(this.maxWidth);
                ffVar.brd.setBoallotsForListView(linkedList);
                ffVar.brd.onChangeSkinType(this.mSkinType);
                ffVar.brd.setVisibility(0);
            } else {
                ffVar.brd.setVisibility(8);
            }
        }
        if (asVar.tm().options_count.intValue() == 0) {
            ffVar.bre.setVisibility(8);
            ffVar.brf.setVisibility(8);
        } else {
            String string = this.bix.getResources().getString(t.j.total_x_vote_option);
            ffVar.bre.setVisibility(0);
            ffVar.bre.setText(String.format(string, asVar.tm().options_count));
            if (ffVar.aik != this.mSkinType) {
                com.baidu.tbadk.core.util.at.b(ffVar.bre, t.d.cp_cont_c, 1);
            }
            if (StringUtils.isNull(asVar.tm().tips, true)) {
                ffVar.brf.setVisibility(8);
            } else {
                ffVar.brf.setVisibility(0);
                ffVar.brf.setText("(" + asVar.tm().tips + ")");
                if (ffVar.aik != this.mSkinType) {
                    com.baidu.tbadk.core.util.at.b(ffVar.brf, t.d.cp_cont_d, 1);
                }
            }
        }
        ffVar.aik = this.mSkinType;
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, ff ffVar) {
        super.a(i, view, viewGroup, (ViewGroup) asVar, (com.baidu.tbadk.core.data.as) ffVar);
        return a(i, view, viewGroup, asVar, ffVar);
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
}
