package com.baidu.tieba.frs;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class es extends bv<com.baidu.tbadk.core.data.ah, ew> implements View.OnClickListener {
    private View.OnClickListener bkj;
    private int maxWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    public es(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bkj = new et(this);
        Activity pageActivity = baseActivity.getPageContext().getPageActivity();
        if (pageActivity != null && pageActivity.getResources() != null) {
            this.maxWidth = com.baidu.adp.lib.util.k.K(pageActivity) - (pageActivity.getResources().getDimensionPixelSize(t.e.ds30) * 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: E */
    public ew b(ViewGroup viewGroup) {
        return new ew(LayoutInflater.from(this.mContext).inflate(t.h.frs_text_vote_item, (ViewGroup) null));
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ah ahVar, ew ewVar) {
        if (ewVar == null || ahVar == null || ahVar.tk() == null) {
            return null;
        }
        if (ewVar.ahU != this.mSkinType) {
            com.baidu.tbadk.core.util.ar.k(ewVar.blC, t.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.ar.b(ewVar.blD, t.d.cp_cont_d, 1);
        }
        if (ahVar != null && !ahVar.tF() && !TextUtils.isEmpty(ahVar.getAddress()) && !TextUtils.isEmpty(ahVar.getAddress().trim())) {
            ewVar.biV.setVisibility(0);
            ewVar.bks.setVisibility(0);
            ewVar.biV.setText(ahVar.getAddress());
            if (ewVar.ahU != this.mSkinType) {
                com.baidu.tbadk.core.util.ar.l(ewVar.bks, t.d.cp_bg_line_c);
                com.baidu.tbadk.core.util.ar.b(ewVar.biV, t.d.cp_cont_d, 1);
            }
        } else {
            ewVar.biV.setVisibility(8);
            ewVar.bks.setVisibility(8);
        }
        ewVar.blD.setText(com.baidu.tbadk.core.util.aw.t(ahVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.rn().rp()) {
            ewVar.blH.setVisibility(0);
            String portrait = ahVar.getAuthor().getPortrait();
            ewVar.blH.setUserId(ahVar.getAuthor().getUserId());
            ewVar.blH.setImageDrawable(null);
            ewVar.blH.d(portrait, 28, false);
        } else {
            ewVar.blH.setVisibility(8);
        }
        ewVar.blH.setOnClickListener(new eu(this, ahVar));
        ewVar.blL.setOnClickListener(new ev(this, ahVar));
        ArrayList<IconData> iconInfo = ahVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            ewVar.blG.setVisibility(0);
            if (ewVar.ahU != this.mSkinType) {
                com.baidu.tbadk.core.util.ar.b(ewVar.blE, t.d.cp_cont_h, 1);
            }
            ewVar.blG.setTag(Integer.valueOf(i));
            ewVar.blG.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            ewVar.blG.setOnClickListener(this.bkj);
        } else {
            ewVar.blG.setVisibility(8);
            if (ewVar.ahU != this.mSkinType) {
                com.baidu.tbadk.core.util.ar.b(ewVar.blE, t.d.cp_cont_c, 1);
            }
        }
        ArrayList<IconData> tShowInfoNew = ahVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            ewVar.blF.setVisibility(0);
            if (ewVar.ahU != this.mSkinType) {
                com.baidu.tbadk.core.util.ar.b(ewVar.blE, t.d.cp_cont_h, 1);
            }
            ewVar.blF.setTag(Integer.valueOf(i));
            ewVar.blF.setOnClickListener(this);
            ewVar.blF.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
        } else {
            ewVar.blF.setVisibility(8);
            if (ewVar.ahU != this.mSkinType) {
                com.baidu.tbadk.core.util.ar.b(ewVar.blE, t.d.cp_cont_c, 1);
            }
        }
        ewVar.blE.setText(ahVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (ahVar.tx() == 1) {
            ewVar.apm.setVisibility(8);
        } else {
            ewVar.apm.setVisibility(0);
            ahVar.parser_title();
            ewVar.apm.setText(ahVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mU(ahVar.getId())) {
                com.baidu.tbadk.core.util.ar.b(ewVar.apm, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.ar.b(ewVar.apm, t.d.cp_cont_b, 1);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (ahVar.tr() != null && ahVar.tr().trim().length() > 0) {
            stringBuffer.append(ahVar.tr());
        }
        ArrayList<MediaData> medias = ahVar.getMedias();
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
                    ewVar.beQ.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    ewVar.beQ.setText(stringBuffer.toString());
                }
                ewVar.beQ.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.mU(ahVar.getId())) {
                    com.baidu.tbadk.core.util.ar.b(ewVar.beQ, t.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.ar.b(ewVar.beQ, t.d.cp_cont_b, 1);
                }
            } else {
                ewVar.beQ.setVisibility(8);
            }
        }
        int reply_num = ahVar.getReply_num();
        ewVar.blJ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (reply_num > 0) {
            ewVar.blJ.setVisibility(0);
            ewVar.blJ.setText(com.baidu.tbadk.core.util.aw.x(reply_num));
            if (ewVar.ahU != this.mSkinType) {
                com.baidu.tbadk.core.util.ar.b(ewVar.blJ, t.d.cp_cont_d, 1);
            }
        } else {
            ewVar.blJ.setVisibility(8);
        }
        long longValue = ahVar.tk().total_poll.longValue();
        ewVar.blK.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
        if (longValue > 0) {
            ewVar.blK.setVisibility(0);
            ewVar.blK.setText(com.baidu.tbadk.core.util.aw.x(ahVar.tk().total_num.longValue()));
            if (ewVar.ahU != this.mSkinType) {
                com.baidu.tbadk.core.util.ar.b(ewVar.blK, t.d.cp_cont_d, 1);
            }
        } else {
            ewVar.blK.setVisibility(8);
        }
        long j = longValue < 0 ? 0L : longValue;
        List<PollOption> list = ahVar.tk().options;
        LinkedList linkedList = new LinkedList();
        if (list != null && list.size() > 0) {
            int i4 = 1;
            for (PollOption pollOption : list) {
                if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                    fq fqVar = new fq();
                    fqVar.a(i4, pollOption, j);
                    linkedList.add(fqVar);
                    int i5 = i4 + 1;
                    if (i5 > 3) {
                        break;
                    }
                    i4 = i5;
                }
            }
            if (linkedList.size() > 0) {
                ewVar.blM.setWidth(this.maxWidth);
                ewVar.blM.setBoallotsForListView(linkedList);
                ewVar.blM.onChangeSkinType(this.mSkinType);
                ewVar.blM.setVisibility(0);
            } else {
                ewVar.blM.setVisibility(8);
            }
        }
        if (ahVar.tk().options_count.intValue() == 0) {
            ewVar.blN.setVisibility(8);
            ewVar.blO.setVisibility(8);
        } else {
            String string = this.bdK.getResources().getString(t.j.total_x_vote_option);
            ewVar.blN.setVisibility(0);
            ewVar.blN.setText(String.format(string, ahVar.tk().options_count));
            if (ewVar.ahU != this.mSkinType) {
                com.baidu.tbadk.core.util.ar.b(ewVar.blN, t.d.cp_cont_c, 1);
            }
            if (StringUtils.isNull(ahVar.tk().tips, true)) {
                ewVar.blO.setVisibility(8);
            } else {
                ewVar.blO.setVisibility(0);
                ewVar.blO.setText("(" + ahVar.tk().tips + ")");
                if (ewVar.ahU != this.mSkinType) {
                    com.baidu.tbadk.core.util.ar.b(ewVar.blO, t.d.cp_cont_d, 1);
                }
            }
        }
        ewVar.ahU = this.mSkinType;
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ah ahVar, ew ewVar) {
        super.a(i, view, viewGroup, (ViewGroup) ahVar, (com.baidu.tbadk.core.data.ah) ewVar);
        return a(i, view, viewGroup, ahVar, ewVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bim != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                com.baidu.adp.widget.ListView.u aG = aG(intValue);
                if (aG instanceof com.baidu.tbadk.core.data.ah) {
                    View childAt = this.beF.getChildAt(intValue - (this.beF.getFirstVisiblePosition() - this.beF.getHeaderViewsCount()));
                    this.bim.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.ah) aG);
                }
            }
        }
    }
}
