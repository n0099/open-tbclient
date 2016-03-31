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
public class dk extends bx<com.baidu.tbadk.core.data.as, dp> implements View.OnClickListener {
    private BaseActivity bix;
    private boolean bjl;
    private final int bpo;
    private final int bpq;
    private final int bpr;
    private final int bps;
    private final int bpt;
    private final int bpu;
    private View.OnClickListener bpv;

    /* JADX INFO: Access modifiers changed from: protected */
    public dk(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bjl = false;
        this.bpv = new dl(this);
        this.bix = baseActivity;
        this.bpq = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds38);
        this.bpo = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds24);
        this.bpr = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds8);
        this.bps = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds10);
        this.bpt = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds30);
        this.bpu = com.baidu.adp.lib.util.k.c(this.bix.getPageContext().getPageActivity(), t.e.ds36);
    }

    private void a(int i, View view, com.baidu.tbadk.core.data.as asVar, dp dpVar) {
        MetaData author;
        if (asVar != null && dpVar != null && (author = asVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dpVar.bpA.getLayoutParams();
                if (layoutParams.topMargin != this.bpo) {
                    layoutParams.topMargin = this.bpo;
                    dpVar.bpA.setLayoutParams(layoutParams);
                }
                dpVar.bpB.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) dpVar.bpA.getLayoutParams();
            if (layoutParams2.topMargin != this.bpq) {
                layoutParams2.topMargin = this.bpq;
                dpVar.bpA.setLayoutParams(layoutParams2);
            }
            dpVar.bpB.setVisibility(0);
            dpVar.bpB.setImageBitmap(null);
            dpVar.bpB.c(themeCard.getCardImageUrlAndroid(), 10, false);
            dpVar.bpB.setOnClickListener(new dm(this, themeCard));
        }
    }

    private View b(int i, View view, com.baidu.tbadk.core.data.as asVar, dp dpVar) {
        int i2;
        int i3;
        if (asVar == null) {
            return null;
        }
        a(i, view, asVar, dpVar);
        ci.a(this.bix, dpVar.bpA, dpVar.bjG, dpVar.bjF, dpVar.bpF, dpVar.bpG, dpVar.bpD, dpVar.bpE, view, asVar, this.mSkinType, new dn(this, asVar), this.bmj);
        if (dpVar.aik != this.mSkinType) {
            com.baidu.tbadk.core.util.at.k(dpVar.bjB, t.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.at.k(dpVar.bjM, t.f.frs_item_abstract_more_text_bg);
            this.bix.getLayoutMode().ab(this.mSkinType == 1);
            this.bix.getLayoutMode().x(view);
        }
        dpVar.bpC.setOnClickListener(this);
        dpVar.bjM.setOnClickListener(this);
        dpVar.bpC.setTag(Integer.valueOf(i));
        dpVar.bjM.setTag(Integer.valueOf(i));
        if (!asVar.tJ() && !TextUtils.isEmpty(asVar.getAddress()) && !TextUtils.isEmpty(asVar.getAddress().trim())) {
            dpVar.bnF.setVisibility(0);
            dpVar.bpH.setVisibility(0);
            dpVar.bnF.setText(asVar.getAddress());
        } else {
            dpVar.bnF.setVisibility(8);
            dpVar.bpH.setVisibility(8);
        }
        dpVar.ahr.setText(com.baidu.tbadk.core.util.ay.w(asVar.getLast_time_int() * 1000));
        boolean g = g(asVar);
        if (com.baidu.tbadk.core.l.qE().qG() && !g) {
            dpVar.bjG.setVisibility(0);
            String portrait = asVar.getAuthor().getPortrait();
            dpVar.bjG.setUserId(asVar.getAuthor().getUserId());
            dpVar.bjG.setImageDrawable(null);
            dpVar.bjG.c(portrait, 28, false);
            dpVar.bjG.setOnClickListener(new Cdo(this, asVar));
        } else {
            dpVar.bjG.setVisibility(8);
        }
        ArrayList<IconData> iconInfo = asVar.getAuthor().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            dpVar.ahO.setVisibility(0);
            com.baidu.tbadk.core.util.at.b(dpVar.bjF, t.d.cp_cont_h, 1);
            dpVar.ahO.setTag(Integer.valueOf(i));
            dpVar.ahO.setOnClickListener(this);
            dpVar.ahO.a(iconInfo, 3, this.bpt, this.bpt, this.bps, true);
            dpVar.ahO.setOnClickListener(this.bpv);
        } else {
            dpVar.ahO.setVisibility(8);
            com.baidu.tbadk.core.util.at.b(dpVar.bjF, t.d.cp_cont_c, 1);
        }
        ArrayList<IconData> tShowInfoNew = asVar.getAuthor().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
            dpVar.ahN.setVisibility(0);
            com.baidu.tbadk.core.util.at.b(dpVar.bjF, t.d.cp_cont_h, 1);
            dpVar.ahN.setTag(Integer.valueOf(i));
            dpVar.ahN.setOnClickListener(this);
            dpVar.ahN.a(tShowInfoNew, 2, this.bpu, this.bpu, this.bpr, true);
        } else {
            dpVar.ahN.setVisibility(8);
            com.baidu.tbadk.core.util.at.b(dpVar.bjF, t.d.cp_cont_c, 1);
        }
        dpVar.bjF.setText(asVar.getAuthor().getName_show());
        com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (asVar.tA() == 1) {
            dpVar.aSh.setVisibility(8);
        } else {
            dpVar.aSh.setVisibility(0);
            asVar.parser_title();
            dpVar.aSh.setText(asVar.getSpan_str());
            if (readThreadHistory != null && readThreadHistory.oh(asVar.getId())) {
                com.baidu.tbadk.core.util.at.b(dpVar.aSh, t.d.cp_cont_c, 1);
            } else {
                com.baidu.tbadk.core.util.at.b(dpVar.aSh, t.d.cp_cont_b, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (asVar.tu() != null && asVar.tu().trim().length() > 0) {
            sb.append(asVar.tu());
        }
        ArrayList<MediaData> medias = asVar.getMedias();
        int p = com.baidu.tbadk.core.util.y.p(medias);
        if (medias != null) {
            for (int i4 = 0; i4 < p; i4++) {
                if (medias.get(i4).getVideoUrl() != null && medias.get(i4).getVideoUrl().endsWith("swf")) {
                    sb.append(medias.get(i4).getVideoUrl());
                }
            }
            if (sb.length() > 0) {
                if (sb.length() > 170) {
                    dpVar.bjM.setVisibility(0);
                    dpVar.bjC.setText(String.valueOf(sb.toString().substring(0, 170)) + "...");
                } else {
                    dpVar.bjM.setVisibility(8);
                    dpVar.bjC.setText(sb.toString());
                }
                dpVar.bjC.setVisibility(0);
                if (readThreadHistory != null && readThreadHistory.oh(asVar.getId())) {
                    com.baidu.tbadk.core.util.at.b(dpVar.bjC, t.d.cp_cont_c, 1);
                } else {
                    com.baidu.tbadk.core.util.at.b(dpVar.bjC, t.d.cp_cont_b, 1);
                }
            } else {
                dpVar.bjM.setVisibility(8);
                dpVar.bjC.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.l.qE().qK() && medias != null && p > 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i7 < p) {
                if (medias.get(i7) == null || !(medias.get(i7).getType() == 3 || medias.get(i7).getType() == 5)) {
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
                while (i9 < p && i8 < i5) {
                    if (medias.get(i9).getType() == 3 || medias.get(i9).getType() == 5) {
                        mediaDataArr[i8] = medias.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                dpVar.bjE.setVisibility(0);
                if (asVar.tW() != null) {
                    dpVar.bjE.setChildrenClickable(false);
                } else {
                    dpVar.bjE.setChildrenClickable(true);
                }
                dpVar.bjE.a(asVar, this.bkq.avu().getName(), this.bkq.avu().getId(), asVar.getTid());
                dpVar.bjE.setShowBig(this.bjl);
                dpVar.bjE.setDrawNum(true);
                dpVar.bjE.setFromCDN(this.mIsFromCDN);
                dpVar.bjE.a(this.bix.getPageContext(), mediaDataArr, i6);
                dpVar.bjE.setImageFrom("other");
            } else {
                dpVar.bjE.setVisibility(8);
            }
        } else {
            dpVar.bjE.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> tz = asVar.tz();
        if (tz != null && tz.size() > 0) {
            dpVar.bjD.setVisibility(0);
            VoiceData.VoiceModel voiceModel = tz.get(0);
            dpVar.bjD.setVoiceModel(voiceModel);
            dpVar.bjD.setTag(voiceModel);
            dpVar.bjD.aUC();
            if (voiceModel != null) {
                dpVar.bjD.kh(voiceModel.voice_status.intValue());
            }
        } else {
            dpVar.bjD.setVisibility(8);
        }
        if (com.baidu.tieba.graffiti.d.af(dpVar.ahs) && asVar.getPraise() != null && asVar.getPraise().getNum() > 0) {
            dpVar.ahs.setVisibility(0);
            String A = com.baidu.tbadk.core.util.ay.A(asVar.getPraise().getNum());
            dpVar.ahs.setText(A);
            dpVar.ahs.setContentDescription(String.valueOf(this.bix.getResources().getString(t.j.zan_num)) + A);
        } else {
            dpVar.ahs.setVisibility(8);
        }
        int reply_num = asVar.getReply_num();
        if (reply_num > 0) {
            dpVar.bjK.setVisibility(0);
            String A2 = com.baidu.tbadk.core.util.ay.A(reply_num);
            dpVar.bjK.setText(A2);
            dpVar.bjK.setContentDescription(String.valueOf(this.bix.getResources().getString(t.j.reply_num)) + A2);
        } else {
            dpVar.bjK.setVisibility(8);
        }
        if (asVar.tJ()) {
            dpVar.aSh.setMaxLines(2);
            dpVar.aSh.setEllipsize(TextUtils.TruncateAt.END);
            if (asVar.tI() == 1) {
                if (asVar.tw().get(0).getStatus() == 1) {
                    dpVar.bpC.setText(this.mContext.getResources().getString(t.j.i_want_lottery));
                    dpVar.bpC.setVisibility(0);
                } else {
                    dpVar.bpC.setVisibility(8);
                }
            } else if (asVar.tI() == 2) {
                if (asVar.tw().get(0).getStatus() == 1) {
                    dpVar.bpC.setText(this.mContext.getResources().getString(t.j.i_want_share_picture));
                    dpVar.bpC.setVisibility(0);
                } else {
                    dpVar.bpC.setVisibility(8);
                }
            } else {
                dpVar.bpC.setVisibility(8);
                dpVar.aSh.setMaxLines(Integer.MAX_VALUE);
                dpVar.aSh.setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            dpVar.bpC.setVisibility(8);
            if (asVar.tx() != null) {
                dpVar.bjM.setVisibility(8);
                dpVar.bjC.setVisibility(8);
                String uk = asVar.tx().uk();
                if (!StringUtils.isNull(uk)) {
                    dpVar.bpI.setVisibility(0);
                    dpVar.bpI.c(uk, 10, true);
                } else {
                    dpVar.bpI.setVisibility(8);
                    dpVar.bpI.c("", 10, true);
                }
            } else {
                dpVar.bpI.setVisibility(8);
            }
            if (asVar.ty() != null) {
                dpVar.bjM.setVisibility(8);
                String rn = asVar.ty().rn();
                String pc = asVar.ty().pc();
                if (!StringUtils.isNull(pc)) {
                    dpVar.bpL.setText(com.baidu.tbadk.core.util.ay.getFixedText(pc, 20, true));
                }
                if (!StringUtils.isNull(rn)) {
                    dpVar.bpJ.setVisibility(0);
                    dpVar.bpK.c(rn, 10, true);
                } else {
                    dpVar.bpJ.setVisibility(8);
                    dpVar.bpK.c("", 10, true);
                }
            } else {
                dpVar.bpJ.setVisibility(8);
            }
        }
        dpVar.aik = this.mSkinType;
        return view;
    }

    public void cw(boolean z) {
        if (this.bjl != z) {
            this.bjl = z;
        }
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

    public int QA() {
        return t.g.frs_more_abstract;
    }

    public int Ro() {
        return t.g.action_button;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public dp b(ViewGroup viewGroup) {
        this.bjr = (ListView) viewGroup;
        return new dp(LayoutInflater.from(this.mContext).inflate(t.h.frs_item, (ViewGroup) null), this.bjo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.as asVar, dp dpVar) {
        super.a(i, view, viewGroup, (ViewGroup) asVar, (com.baidu.tbadk.core.data.as) dpVar);
        return b(i, view, asVar, dpVar);
    }

    public int Rq() {
        return t.g.frs_user_tshow_icon_box;
    }

    private boolean g(com.baidu.tbadk.core.data.as asVar) {
        return (asVar == null || asVar.getAuthor() == null || asVar.getAuthor().getGodUserData() == null || asVar.getAuthor().getGodUserData().getType() != 2) ? false : true;
    }
}
