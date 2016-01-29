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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class dr extends bv<com.baidu.tbadk.core.data.ah, dv> implements View.OnClickListener {
    private BaseActivity bdK;
    private boolean bez;
    private View.OnClickListener bkj;

    /* JADX INFO: Access modifiers changed from: protected */
    public dr(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bez = false;
        this.bkj = new ds(this);
        this.bdK = baseActivity;
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.ah ahVar, dv dvVar) {
        if (ahVar == null || ahVar.tk() == null) {
            return null;
        }
        if (dvVar.ahU != this.mSkinType) {
            dvVar.bkR.setGrade(com.baidu.tbadk.core.util.ar.getDrawable(t.f.pic_grade_vote_no1));
            dvVar.bkS.setGrade(com.baidu.tbadk.core.util.ar.getDrawable(t.f.pic_grade_vote_no2));
            dvVar.bkT.setGrade(com.baidu.tbadk.core.util.ar.getDrawable(t.f.pic_grade_vote_no3));
            dvVar.bkR.onChangeSkinType(this.mSkinType);
            dvVar.bkS.onChangeSkinType(this.mSkinType);
            dvVar.bkT.onChangeSkinType(this.mSkinType);
            dvVar.bkP.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_vote_n), (Drawable) null, (Drawable) null, (Drawable) null);
            dvVar.beY.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.util.ar.j((View) dvVar.bkP, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.ar.j((View) dvVar.beY, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.ar.j((View) dvVar.ahm, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.ar.l(dvVar.bks, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.j((View) dvVar.biV, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.ar.j((View) dvVar.bkU, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.ar.j((View) dvVar.bkV, t.d.cp_cont_c);
            com.baidu.tbadk.core.util.ar.k(dvVar.beP, t.f.frs_item_control_btn_bg);
        }
        if (ahVar != null && !ahVar.tF() && !TextUtils.isEmpty(ahVar.getAddress()) && !TextUtils.isEmpty(ahVar.getAddress().trim())) {
            dvVar.biV.setVisibility(0);
            dvVar.bks.setVisibility(0);
            dvVar.biV.setText(ahVar.getAddress());
        } else {
            dvVar.biV.setVisibility(8);
            dvVar.bks.setVisibility(8);
        }
        dvVar.ahm.setText(com.baidu.tbadk.core.util.aw.t(ahVar.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.rn().rp()) {
            dvVar.beU.setVisibility(0);
            String portrait = ahVar.getAuthor().getPortrait();
            dvVar.beU.setUserId(ahVar.getAuthor().getUserId());
            dvVar.beU.setImageDrawable(null);
            dvVar.beU.d(portrait, 28, false);
        } else {
            dvVar.beU.setVisibility(8);
        }
        dvVar.beU.setOnClickListener(new dt(this, ahVar));
        dvVar.bfc.setOnClickListener(new du(this, ahVar));
        ArrayList<IconData> iconInfo = ahVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            dvVar.ahJ.setVisibility(0);
            com.baidu.tbadk.core.util.ar.b(dvVar.beT, t.d.cp_cont_h, 1);
            dvVar.ahJ.setTag(Integer.valueOf(i));
            dvVar.ahJ.setOnClickListener(this);
            dvVar.ahJ.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            dvVar.ahJ.setOnClickListener(this.bkj);
        } else {
            dvVar.ahJ.setVisibility(8);
            com.baidu.tbadk.core.util.ar.b(dvVar.beT, t.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = ahVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dvVar.ahI.setVisibility(0);
            com.baidu.tbadk.core.util.ar.b(dvVar.beT, t.d.cp_cont_h, 1);
            dvVar.ahI.setTag(Integer.valueOf(i));
            dvVar.ahI.setOnClickListener(this);
            dvVar.ahI.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_width), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_height), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
        } else {
            dvVar.ahI.setVisibility(8);
            com.baidu.tbadk.core.util.ar.b(dvVar.beT, t.d.cp_cont_c, 1);
        }
        dvVar.beT.setText(ahVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (ahVar.tx() == 1) {
            dvVar.aPr.setVisibility(8);
        } else {
            dvVar.aPr.setVisibility(0);
            ahVar.parser_title();
            dvVar.aPr.setText(ahVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mU(ahVar.getId())) {
                com.baidu.tbadk.core.util.ar.b(dvVar.aPr, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.ar.b(dvVar.aPr, t.d.cp_cont_b, 1);
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
                    dvVar.beQ.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    dvVar.beQ.setText(stringBuffer.toString());
                }
                dvVar.beQ.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.mU(ahVar.getId())) {
                    com.baidu.tbadk.core.util.ar.b(dvVar.beQ, t.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.ar.b(dvVar.beQ, t.d.cp_cont_b, 1);
                }
            } else {
                dvVar.beQ.setVisibility(8);
            }
        }
        int reply_num = ahVar.getReply_num();
        if (reply_num > 0) {
            dvVar.beY.setVisibility(0);
            dvVar.beY.setText(com.baidu.tbadk.core.util.aw.x(reply_num));
        } else {
            dvVar.beY.setVisibility(8);
        }
        long longValue = ahVar.tk().total_num.longValue();
        if (longValue > 0) {
            dvVar.bkP.setVisibility(0);
            dvVar.bkP.setText(com.baidu.tbadk.core.util.aw.x(longValue));
        } else {
            dvVar.bkP.setVisibility(8);
        }
        List<PollOption> list = ahVar.tk().options;
        if (com.baidu.tbadk.core.l.rn().rt() && list != null && list.size() > 1) {
            dvVar.bkQ.setVisibility(0);
            dvVar.bkR.setVisibility(0);
            dvVar.bkS.setVisibility(0);
            if (list.size() > 2) {
                dvVar.bkT.setVisibility(0);
            } else {
                dvVar.bkT.setVisibility(4);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < list.size() && i5 != 3) {
                    PollOption pollOption = list.get(i5);
                    switch (i5) {
                        case 0:
                            dvVar.bkR.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), ahVar.tk().total_poll.longValue());
                            break;
                        case 1:
                            dvVar.bkS.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), ahVar.tk().total_poll.longValue());
                            break;
                        case 2:
                            dvVar.bkT.a(i5 + 1, pollOption.image, Boolean.valueOf(this.mIsFromCDN), pollOption.text, pollOption.num.longValue(), ahVar.tk().total_poll.longValue());
                            break;
                    }
                    i4 = i5 + 1;
                }
            }
        } else {
            dvVar.bkQ.setVisibility(8);
        }
        if (ahVar.tk().options_count.intValue() == 0) {
            dvVar.bkU.setVisibility(8);
            dvVar.bkV.setVisibility(8);
        } else {
            String string = this.bdK.getResources().getString(t.j.total_x_vote_option);
            dvVar.bkU.setVisibility(0);
            dvVar.bkU.setText(String.format(string, ahVar.tk().options_count));
            if (StringUtils.isNull(ahVar.tk().tips, true)) {
                dvVar.bkV.setVisibility(8);
            } else {
                dvVar.bkV.setVisibility(0);
                dvVar.bkV.setText("(" + ahVar.tk().tips + ")");
            }
        }
        dvVar.ahU = this.mSkinType;
        return view;
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public dv b(ViewGroup viewGroup) {
        return new dv(LayoutInflater.from(this.mContext).inflate(t.h.frs_pic_vote_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ah ahVar, dv dvVar) {
        super.a(i, view, viewGroup, (ViewGroup) ahVar, (com.baidu.tbadk.core.data.ah) dvVar);
        return a(i, view, ahVar, dvVar);
    }
}
