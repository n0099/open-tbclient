package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class df extends bw<com.baidu.tbadk.core.data.ax, dk> implements View.OnClickListener {
    private BaseActivity bek;
    private boolean bfl;
    private final int bkF;
    private final int bkG;
    private final int bkH;
    private final int bkI;
    private final int bkJ;
    private final int bkK;
    private View.OnClickListener bkL;

    public df(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bfl = false;
        this.bkL = new dg(this);
        this.bek = baseActivity;
        this.bkG = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds38);
        this.bkF = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds24);
        this.bkH = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds8);
        this.bkI = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds10);
        this.bkJ = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds30);
        this.bkK = com.baidu.adp.lib.util.k.c(this.bek.getPageContext().getPageActivity(), t.e.ds36);
    }

    private void a(int i, View view, com.baidu.tbadk.core.data.ax axVar, dk dkVar) {
        MetaData author;
        if (axVar != null && dkVar != null && (author = axVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dkVar.bkQ.getLayoutParams();
                if (layoutParams.topMargin != this.bkF) {
                    layoutParams.topMargin = this.bkF;
                    dkVar.bkQ.setLayoutParams(layoutParams);
                }
                dkVar.bkR.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dkVar.bkQ.getLayoutParams();
            if (layoutParams2.topMargin != this.bkG) {
                layoutParams2.topMargin = this.bkG;
                dkVar.bkQ.setLayoutParams(layoutParams2);
            }
            dkVar.bkR.setVisibility(0);
            dkVar.bkR.setImageBitmap(null);
            dkVar.bkR.c(themeCard.getCardImageUrlAndroid(), 10, false);
            dkVar.bkR.setOnClickListener(new dh(this, themeCard));
        }
    }

    private View b(int i, View view, com.baidu.tbadk.core.data.ax axVar, dk dkVar) {
        int i2;
        int i3;
        if (axVar == null) {
            return null;
        }
        a(i, view, axVar, dkVar);
        ch.a(this.bek, dkVar.bkQ, dkVar.bfG, dkVar.bfF, dkVar.bkV, dkVar.bkW, dkVar.bkT, dkVar.bkU, view, axVar, this.mSkinType, new di(this, axVar), this.biy);
        if (dkVar.aej != this.mSkinType) {
            com.baidu.tbadk.core.util.at.k(dkVar.bfB, t.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.at.k(dkVar.bfM, t.f.frs_item_abstract_more_text_bg);
            this.bek.getLayoutMode().ae(this.mSkinType == 1);
            this.bek.getLayoutMode().x(view);
        }
        dkVar.bkS.setOnClickListener(this);
        dkVar.bfM.setOnClickListener(this);
        dkVar.bkS.setTag(Integer.valueOf(i));
        dkVar.bfM.setTag(Integer.valueOf(i));
        if (!axVar.ri() && !TextUtils.isEmpty(axVar.getAddress()) && !TextUtils.isEmpty(axVar.getAddress().trim())) {
            dkVar.bji.setVisibility(0);
            dkVar.bkX.setVisibility(0);
            dkVar.bji.setText(axVar.getAddress());
        } else {
            dkVar.bji.setVisibility(8);
            dkVar.bkX.setVisibility(8);
        }
        dkVar.adg.setText(com.baidu.tbadk.core.util.ay.x(axVar.getLast_time_int() * 1000));
        boolean g = g(axVar);
        if (com.baidu.tbadk.core.l.ob().od() && !g) {
            dkVar.bfG.setVisibility(0);
            String portrait = axVar.getAuthor().getPortrait();
            dkVar.bfG.setUserId(axVar.getAuthor().getUserId());
            dkVar.bfG.setImageDrawable(null);
            dkVar.bfG.c(portrait, 28, false);
            dkVar.bfG.setOnClickListener(new dj(this, axVar));
        } else {
            dkVar.bfG.setVisibility(8);
        }
        ArrayList<IconData> iconInfo = axVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            dkVar.adI.setVisibility(0);
            com.baidu.tbadk.core.util.at.c(dkVar.bfF, t.d.cp_cont_h, 1);
            dkVar.adI.setTag(Integer.valueOf(i));
            dkVar.adI.setOnClickListener(this);
            dkVar.adI.a(iconInfo, 3, this.bkJ, this.bkJ, this.bkI, true);
            dkVar.adI.setOnClickListener(this.bkL);
        } else {
            dkVar.adI.setVisibility(8);
            com.baidu.tbadk.core.util.at.c(dkVar.bfF, t.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = axVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dkVar.adH.setVisibility(0);
            com.baidu.tbadk.core.util.at.c(dkVar.bfF, t.d.cp_cont_h, 1);
            dkVar.adH.setTag(Integer.valueOf(i));
            dkVar.adH.setOnClickListener(this);
            dkVar.adH.a(tShowInfoNew, 2, this.bkK, this.bkK, this.bkH, true);
        } else {
            dkVar.adH.setVisibility(8);
            com.baidu.tbadk.core.util.at.c(dkVar.bfF, t.d.cp_cont_c, 1);
        }
        dkVar.bfF.setText(axVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
        if (axVar.qZ() == 1) {
            dkVar.aOG.setVisibility(8);
        } else {
            dkVar.aOG.setVisibility(0);
            axVar.parser_title();
            dkVar.aOG.setText(axVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.od(axVar.getId())) {
                com.baidu.tbadk.core.util.at.c(dkVar.aOG, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.c(dkVar.aOG, t.d.cp_cont_b, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (axVar.qT() != null && axVar.qT().trim().length() > 0) {
            sb.append(axVar.qT());
        }
        ArrayList<MediaData> medias = axVar.getMedias();
        int r = com.baidu.tbadk.core.util.y.r(medias);
        if (medias != null) {
            for (int i4 = 0; i4 < r; i4++) {
                if (medias.get(i4).getVideoUrl() != null && medias.get(i4).getVideoUrl().endsWith("swf")) {
                    sb.append(medias.get(i4).getVideoUrl());
                }
            }
            if (sb.length() > 0) {
                if (sb.length() > 170) {
                    dkVar.bfM.setVisibility(0);
                    dkVar.bfC.setText(String.valueOf(sb.toString().substring(0, 170)) + "...");
                } else {
                    dkVar.bfM.setVisibility(8);
                    dkVar.bfC.setText(sb.toString());
                }
                dkVar.bfC.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.od(axVar.getId())) {
                    com.baidu.tbadk.core.util.at.c(dkVar.bfC, t.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.at.c(dkVar.bfC, t.d.cp_cont_b, 1);
                }
            } else {
                dkVar.bfM.setVisibility(8);
                dkVar.bfC.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.l.ob().oh() && medias != null && r > 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i7 < r) {
                if (medias.get(i7) == null || medias.get(i7).getType() != 3) {
                    i3 = i6;
                } else {
                    i5++;
                    i3 = i6 + 1;
                }
                i7++;
                i5 = i5;
                i6 = i3;
            }
            if (i5 > 0) {
                MediaData[] mediaDataArr = new MediaData[i5];
                int i8 = 0;
                int i9 = 0;
                while (i9 < r && i8 < i5) {
                    if (medias.get(i9).getType() != 3) {
                        i2 = i8;
                    } else {
                        mediaDataArr[i8] = medias.get(i9);
                        i2 = i8 + 1;
                    }
                    i9++;
                    i8 = i2;
                }
                dkVar.bfE.setVisibility(0);
                if (axVar.rv() != null) {
                    dkVar.bfE.setChildrenClickable(false);
                } else {
                    dkVar.bfE.setChildrenClickable(true);
                }
                dkVar.bfE.a(axVar, this.bgq.avD().getName(), this.bgq.avD().getId(), axVar.getTid());
                dkVar.bfE.setShowBig(this.bfl);
                dkVar.bfE.setDrawNum(true);
                dkVar.bfE.setFromCDN(this.mIsFromCDN);
                dkVar.bfE.a(this.bek.getPageContext(), mediaDataArr, i6);
                dkVar.bfE.setImageFrom("other");
            } else {
                dkVar.bfE.setVisibility(8);
            }
        } else {
            dkVar.bfE.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> qY = axVar.qY();
        if (qY != null && qY.size() > 0) {
            dkVar.bfD.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qY.get(0);
            dkVar.bfD.setVoiceModel(voiceModel);
            dkVar.bfD.setTag(voiceModel);
            dkVar.bfD.aVd();
            if (voiceModel != null) {
                dkVar.bfD.jL(voiceModel.voice_status.intValue());
            }
        } else {
            dkVar.bfD.setVisibility(8);
        }
        if (com.baidu.tieba.graffiti.d.aj(dkVar.adj) && axVar.getPraise() != null && axVar.getPraise().getNum() > 0) {
            dkVar.adj.setVisibility(0);
            String B = com.baidu.tbadk.core.util.ay.B(axVar.getPraise().getNum());
            dkVar.adj.setText(B);
            dkVar.adj.setContentDescription(String.valueOf(this.bek.getResources().getString(t.j.zan_num)) + B);
        } else {
            dkVar.adj.setVisibility(8);
        }
        int reply_num = axVar.getReply_num();
        if (reply_num > 0) {
            dkVar.bfK.setVisibility(0);
            String B2 = com.baidu.tbadk.core.util.ay.B(reply_num);
            dkVar.bfK.setText(B2);
            dkVar.bfK.setContentDescription(String.valueOf(this.bek.getResources().getString(t.j.reply_num)) + B2);
        } else {
            dkVar.bfK.setVisibility(8);
        }
        if (axVar.ri()) {
            dkVar.aOG.setMaxLines(2);
            dkVar.aOG.setEllipsize(TextUtils.TruncateAt.END);
            if (axVar.rh() == 1) {
                if (axVar.qV().get(0).getStatus() == 1) {
                    dkVar.bkS.setText(this.mContext.getResources().getString(t.j.i_want_lottery));
                    dkVar.bkS.setVisibility(0);
                } else {
                    dkVar.bkS.setVisibility(8);
                }
            } else if (axVar.rh() == 2) {
                if (axVar.qV().get(0).getStatus() == 1) {
                    dkVar.bkS.setText(this.mContext.getResources().getString(t.j.i_want_share_picture));
                    dkVar.bkS.setVisibility(0);
                } else {
                    dkVar.bkS.setVisibility(8);
                }
            } else {
                dkVar.bkS.setVisibility(8);
                dkVar.aOG.setMaxLines(Integer.MAX_VALUE);
                dkVar.aOG.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            dkVar.bkS.setVisibility(8);
            if (axVar.qW() != null) {
                dkVar.bfM.setVisibility(8);
                dkVar.bfC.setVisibility(8);
                String rQ = axVar.qW().rQ();
                if (!StringUtils.isNull(rQ)) {
                    dkVar.bkY.setVisibility(0);
                    dkVar.bkY.c(rQ, 10, true);
                } else {
                    dkVar.bkY.setVisibility(8);
                    dkVar.bkY.c("", 10, true);
                }
            } else {
                dkVar.bkY.setVisibility(8);
            }
            if (axVar.qX() != null) {
                dkVar.bfM.setVisibility(8);
                String oI = axVar.qX().oI();
                String lo = axVar.qX().lo();
                if (!StringUtils.isNull(lo)) {
                    dkVar.blb.setText(com.baidu.tbadk.core.util.ay.getFixedText(lo, 20, true));
                }
                if (!StringUtils.isNull(oI)) {
                    dkVar.bkZ.setVisibility(0);
                    dkVar.bla.c(oI, 10, true);
                } else {
                    dkVar.bkZ.setVisibility(8);
                    dkVar.bla.c("", 10, true);
                }
            } else {
                dkVar.bkZ.setVisibility(8);
            }
        }
        dkVar.aej = this.mSkinType;
        return view;
    }

    public void cG(boolean z) {
        if (this.bfl != z) {
            this.bfl = z;
        }
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

    public int Pz() {
        return t.g.frs_more_abstract;
    }

    public int Rt() {
        return t.g.action_button;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public dk b(ViewGroup viewGroup) {
        this.bfr = (ListView) viewGroup;
        return new dk(LayoutInflater.from(this.mContext).inflate(t.h.frs_item, (ViewGroup) null), this.bfo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, dk dkVar) {
        super.a(i, view, viewGroup, (ViewGroup) axVar, (com.baidu.tbadk.core.data.ax) dkVar);
        return b(i, view, axVar, dkVar);
    }

    public int Ru() {
        return t.g.frs_user_tshow_icon_box;
    }

    private boolean g(com.baidu.tbadk.core.data.ax axVar) {
        return (axVar == null || axVar.getAuthor() == null || axVar.getAuthor().getGodUserData() == null || axVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }
}
