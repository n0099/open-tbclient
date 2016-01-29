package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class df extends bv<com.baidu.tbadk.core.data.ah, dj> implements View.OnClickListener {
    private BaseActivity bdK;
    private boolean bez;
    private HashMap<Integer, Long> bkf;
    private int bkg;
    private int bkh;
    private int bki;
    private View.OnClickListener bkj;

    /* JADX INFO: Access modifiers changed from: protected */
    public df(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bez = false;
        this.bkg = 0;
        this.bkh = 0;
        this.bki = 0;
        this.bkj = new dg(this);
        this.bdK = baseActivity;
        this.bkf = new HashMap<>();
        this.bkg = 0;
        this.bkh = 0;
        this.bki = com.baidu.adp.lib.util.k.c(this.bdK.getPageContext().getPageActivity(), t.e.ds70);
    }

    private View a(int i, View view, com.baidu.tbadk.core.data.ah ahVar, dj djVar) {
        if (ahVar == null) {
            return null;
        }
        if (ahVar != null && ahVar.tN() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.bkg, 0, this.bkh, 0);
            layoutParams.gravity = 1;
            djVar.beP.setLayoutParams(layoutParams);
            djVar.bkm.setVisibility(8);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(this.bkg, this.bki, this.bkh, 0);
            layoutParams2.gravity = 1;
            djVar.beP.setLayoutParams(layoutParams2);
            com.baidu.tbadk.core.util.ar.k(djVar.bkm, t.f.yangnian2);
            djVar.bkm.setVisibility(0);
        }
        cg.a(this.bdK, djVar.bkl, djVar.beU, djVar.beT, djVar.bkq, djVar.bkr, djVar.bko, djVar.bkp, view, ahVar, this.mSkinType, new dh(this, ahVar), this.bhx);
        if (djVar.ahU != this.mSkinType) {
            com.baidu.tbadk.core.util.ar.k(djVar.beP, t.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.ar.k(djVar.bfa, t.f.frs_item_abstract_more_text_bg);
            this.bdK.getLayoutMode().ac(this.mSkinType == 1);
            this.bdK.getLayoutMode().x(view);
        }
        djVar.bkn.setOnClickListener(this);
        djVar.bfa.setOnClickListener(this);
        djVar.bkn.setTag(Integer.valueOf(i));
        djVar.bfa.setTag(Integer.valueOf(i));
        if (ahVar != null && !ahVar.tF() && !TextUtils.isEmpty(ahVar.getAddress()) && !TextUtils.isEmpty(ahVar.getAddress().trim())) {
            djVar.biV.setVisibility(0);
            djVar.bks.setVisibility(0);
            djVar.biV.setText(ahVar.getAddress());
        } else {
            djVar.biV.setVisibility(8);
            djVar.bks.setVisibility(8);
        }
        djVar.ahm.setText(com.baidu.tbadk.core.util.aw.t(ahVar.getLast_time_int() * 1000));
        boolean g = g(ahVar);
        if (com.baidu.tbadk.core.l.rn().rp() && !g) {
            djVar.beU.setVisibility(0);
            String portrait = ahVar.getAuthor().getPortrait();
            djVar.beU.setUserId(ahVar.getAuthor().getUserId());
            djVar.beU.setImageDrawable(null);
            djVar.beU.d(portrait, 28, false);
        } else {
            djVar.beU.setVisibility(8);
        }
        djVar.beU.setOnClickListener(new di(this, ahVar));
        ArrayList<IconData> iconInfo = ahVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            djVar.ahJ.setVisibility(0);
            com.baidu.tbadk.core.util.ar.b(djVar.beT, t.d.cp_cont_h, 1);
            djVar.ahJ.setTag(Integer.valueOf(i));
            djVar.ahJ.setOnClickListener(this);
            djVar.ahJ.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            djVar.ahJ.setOnClickListener(this.bkj);
        } else {
            djVar.ahJ.setVisibility(8);
            com.baidu.tbadk.core.util.ar.b(djVar.beT, t.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = ahVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            djVar.ahI.setVisibility(0);
            com.baidu.tbadk.core.util.ar.b(djVar.beT, t.d.cp_cont_h, 1);
            djVar.ahI.setTag(Integer.valueOf(i));
            djVar.ahI.setOnClickListener(this);
            djVar.ahI.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
        } else {
            djVar.ahI.setVisibility(8);
            com.baidu.tbadk.core.util.ar.b(djVar.beT, t.d.cp_cont_c, 1);
        }
        djVar.beT.setText(ahVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (ahVar.tx() == 1) {
            djVar.aPr.setVisibility(8);
        } else {
            djVar.aPr.setVisibility(0);
            ahVar.parser_title();
            djVar.aPr.setText(ahVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.mU(ahVar.getId())) {
                com.baidu.tbadk.core.util.ar.b(djVar.aPr, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.ar.b(djVar.aPr, t.d.cp_cont_b, 1);
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
                    djVar.bfa.setVisibility(0);
                    djVar.beQ.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    djVar.bfa.setVisibility(8);
                    djVar.beQ.setText(stringBuffer.toString());
                }
                djVar.beQ.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.mU(ahVar.getId())) {
                    com.baidu.tbadk.core.util.ar.b(djVar.beQ, t.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.ar.b(djVar.beQ, t.d.cp_cont_b, 1);
                }
            } else {
                djVar.bfa.setVisibility(8);
                djVar.beQ.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.l.rn().rt() && medias != null && medias.size() > 0) {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = i4;
                if (i7 >= medias.size()) {
                    break;
                }
                if (medias.get(i7) != null && (medias.get(i7).getType() == 3 || medias.get(i7).getType() == 5)) {
                    i5++;
                    i6++;
                }
                i4 = i7 + 1;
            }
            if (i5 > 0) {
                MediaData[] mediaDataArr = new MediaData[i5];
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    int i10 = i8;
                    int i11 = i9;
                    if (i10 >= medias.size() || i11 >= i5) {
                        break;
                    }
                    if (medias.get(i10).getType() == 3 || medias.get(i10).getType() == 5) {
                        mediaDataArr[i11] = medias.get(i10);
                        i9 = i11 + 1;
                    } else {
                        i9 = i11;
                    }
                    i8 = i10 + 1;
                }
                djVar.beS.setVisibility(0);
                djVar.beS.a(ahVar, this.bfF.aoE().getName(), this.bfF.aoE().getId(), ahVar.getTid());
                djVar.beS.setShowBig(this.bez);
                djVar.beS.setDrawNum(true);
                djVar.beS.setFromCDN(this.mIsFromCDN);
                djVar.beS.a(this.bdK.getPageContext(), mediaDataArr, i6);
                djVar.beS.setImageFrom("other");
            } else {
                djVar.beS.setVisibility(8);
            }
        } else {
            djVar.beS.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> tw = ahVar.tw();
        if (tw != null && tw.size() > 0) {
            djVar.beR.setVisibility(0);
            VoiceData.VoiceModel voiceModel = tw.get(0);
            djVar.beR.setVoiceModel(voiceModel);
            djVar.beR.setTag(voiceModel);
            djVar.beR.aNB();
            if (voiceModel != null) {
                djVar.beR.jB(voiceModel.voice_status.intValue());
            }
        } else {
            djVar.beR.setVisibility(8);
        }
        if (ahVar.getPraise() != null && ahVar.getPraise().getNum() > 0) {
            djVar.ahn.setVisibility(0);
            djVar.ahn.setText(com.baidu.tbadk.core.util.aw.y(ahVar.getPraise().getNum()));
        } else {
            djVar.ahn.setVisibility(8);
        }
        int reply_num = ahVar.getReply_num();
        if (reply_num > 0) {
            djVar.beY.setVisibility(0);
            djVar.beY.setText(com.baidu.tbadk.core.util.aw.y(reply_num));
        } else {
            djVar.beY.setVisibility(8);
        }
        if (ahVar.tF()) {
            djVar.aPr.setMaxLines(2);
            djVar.aPr.setEllipsize(TextUtils.TruncateAt.END);
            if (ahVar.tE() == 1) {
                if (ahVar.tt().get(0).getStatus() == 1) {
                    djVar.bkn.setText(this.mContext.getResources().getString(t.j.i_want_lottery));
                    djVar.bkn.setVisibility(0);
                } else {
                    djVar.bkn.setVisibility(8);
                }
            } else if (ahVar.tE() == 2) {
                if (ahVar.tt().get(0).getStatus() == 1) {
                    djVar.bkn.setText(this.mContext.getResources().getString(t.j.i_want_share_picture));
                    djVar.bkn.setVisibility(0);
                } else {
                    djVar.bkn.setVisibility(8);
                }
            } else {
                djVar.bkn.setVisibility(8);
                djVar.aPr.setMaxLines(Integer.MAX_VALUE);
                djVar.aPr.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            djVar.bkn.setVisibility(8);
            if (ahVar.tu() != null) {
                djVar.bfa.setVisibility(8);
                djVar.beQ.setVisibility(8);
                String ue = ahVar.tu().ue();
                if (!StringUtils.isNull(ue)) {
                    djVar.bkt.setVisibility(0);
                    djVar.bkt.d(ue, 10, true);
                } else {
                    djVar.bkt.setVisibility(8);
                    djVar.bkt.d("", 10, true);
                }
            } else {
                djVar.bkt.setVisibility(8);
            }
            if (ahVar.tv() != null) {
                djVar.bfa.setVisibility(8);
                String rP = ahVar.tv().rP();
                String pj = ahVar.tv().pj();
                if (!StringUtils.isNull(pj)) {
                    djVar.bkw.setText(com.baidu.tbadk.core.util.aw.getFixedText(pj, 20, true));
                }
                if (!StringUtils.isNull(rP)) {
                    djVar.bku.setVisibility(0);
                    djVar.bkv.d(rP, 10, true);
                } else {
                    djVar.bku.setVisibility(8);
                    djVar.bkv.d("", 10, true);
                }
            } else {
                djVar.bku.setVisibility(8);
            }
        }
        djVar.ahU = this.mSkinType;
        return view;
    }

    public void ck(boolean z) {
        if (this.bez != z) {
            this.bez = z;
        }
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

    public int OL() {
        return t.g.frs_more_abstract;
    }

    public int Pz() {
        return t.g.action_button;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: v */
    public dj b(ViewGroup viewGroup) {
        this.beF = (ListView) viewGroup;
        return new dj(LayoutInflater.from(this.mContext).inflate(t.h.frs_item, (ViewGroup) null), this.beC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ah ahVar, dj djVar) {
        super.a(i, view, viewGroup, (ViewGroup) ahVar, (com.baidu.tbadk.core.data.ah) djVar);
        return a(i, view, ahVar, djVar);
    }

    public int PB() {
        return t.g.frs_user_tshow_icon_box;
    }

    private boolean g(com.baidu.tbadk.core.data.ah ahVar) {
        return (ahVar == null || ahVar.getAuthor() == null || ahVar.getAuthor().getGodUserData() == null || ahVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }
}
