package com.baidu.tieba.frs.c;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.r;
import com.baidu.tieba.view.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends at<aa, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> FY;
    private boolean bLf;
    private com.baidu.adp.lib.e.b<bp> bRN;
    private com.baidu.adp.lib.e.b<bg> bRO;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bLf = false;
        this.bRN = new com.baidu.adp.lib.e.b<>(new b(this), 5, 0);
        this.bRO = new com.baidu.adp.lib.e.b<>(new c(this), 5, 0);
        this.FY = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public e onCreateViewHolder(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(r.j.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, aa aaVar, e eVar) {
        super.onFillViewHolder(i, view, viewGroup, aaVar, eVar);
        com.baidu.tbadk.i.a.a(this.FY, view);
        if (aaVar.getThreadType() == 33) {
            if (eVar.bRV != null) {
                eVar.bRS.removeView(eVar.bRV.bHW);
                this.bRO.n(eVar.bRV);
                eVar.bRV = null;
            }
            if (eVar.bRW == null) {
                eVar.bRW = this.bRN.ew();
                eVar.bRS.addView(eVar.bRW.bIK);
                eVar.bRW.ws();
            }
            a(eVar.bRW, aaVar);
        } else {
            if (eVar.bRW != null) {
                eVar.bRS.removeView(eVar.bRW.bIK);
                this.bRN.n(eVar.bRW);
                eVar.bRW = null;
            }
            if (eVar.bRV == null) {
                eVar.bRV = this.bRO.ew();
                eVar.bRS.addView(eVar.bRV.bHW);
            }
            a(eVar.bRV, aaVar);
        }
        eVar.bRU.setOnClickListener(this);
        eVar.bRU.setTag(aaVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bGZ != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof bh) {
                this.bGZ.a(id, 0, view, null, (bh) tag);
            }
        }
    }

    private void a(bp bpVar, aa aaVar) {
        PhotoLiveCardData pU = aaVar.pU();
        if (pU != null) {
            if (2 == b(pU)) {
                bpVar.bIL.setShowContent(true);
                bpVar.bIL.setShowCover(false);
                bpVar.bIL.setShowExpression(false);
            } else {
                bpVar.bIL.setShowContent(false);
                bpVar.bIL.setShowCover(true);
                bpVar.bIL.setShowExpression(true);
            }
            bpVar.bIL.setChooseStyle(pU.getShowStyle());
            bpVar.bIL.setShowLiveIcon(true);
            bpVar.bIL.setHeadPaddingTop(r.f.ds24);
            bpVar.bIL.setPortraitClicklistener(this);
            bpVar.bIL.setShowImage(l.oC().oI());
            if (pU.isShowDiffViewInSameAdapter()) {
                bpVar.bIL.setShowBottom(true);
                bpVar.bIL.setShowRefreshTimeInButtom(true);
                bpVar.bIL.setShowHeadLiveIcon(true);
                bpVar.bIL.setShowRefreshTimeInHead(false);
                bpVar.bIL.setContentPaddingBottom(0);
            } else {
                bpVar.bIL.setShowBottom(false);
                bpVar.bIL.setShowRefreshTimeInHead(true);
                bpVar.bIL.setShowHeadLiveIcon(false);
                bpVar.bIL.setShowRefreshTimeInButtom(false);
                bpVar.bIL.setContentPaddingBottom(r.f.ds36);
            }
            bpVar.bIL.setData(pU);
        }
    }

    private int b(PhotoLiveCardData photoLiveCardData) {
        return (photoLiveCardData == null || StringUtils.isNull(photoLiveCardData.getPhotoLiveCover())) ? 2 : 1;
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, photoLiveCardData.getAuthorId(), null)));
            }
        }
    }

    private void a(bg bgVar, aa aaVar) {
        int i;
        if (bgVar != null && aaVar != null) {
            if (bgVar.ahp != this.mSkinType) {
                ap.j(bgVar.bHX, r.g.frs_item_control_btn_bg);
                ap.j((View) bgVar.bIg, r.g.frs_item_abstract_more_text_bg);
                bgVar.ahp = this.mSkinType;
            }
            bgVar.bIf.setOnClickListener(this);
            bgVar.bIg.setOnClickListener(this);
            bgVar.bIf.setTag(aaVar);
            bgVar.bIg.setTag(aaVar);
            bgVar.bHd.setVisibility(8);
            bgVar.bIl.setVisibility(8);
            bgVar.agb.setText(com.baidu.tbadk.core.util.at.r(aaVar.rr() * 1000));
            if (l.oC().oE() && aaVar.getAuthor() != null) {
                bgVar.bIe.setVisibility(0);
                String portrait = aaVar.getAuthor().getPortrait();
                bgVar.bIe.setUserId(aaVar.getAuthor().getUserId());
                bgVar.bIe.setImageDrawable(null);
                bgVar.bIe.c(portrait, 28, false);
                bgVar.bIe.setOnClickListener(new d(this, aaVar));
            } else {
                bgVar.bIe.setVisibility(8);
            }
            bgVar.agM.setVisibility(8);
            bgVar.agL.setVisibility(8);
            bgVar.bId.setText(aaVar.getAuthor().getName_show());
            ap.c(bgVar.bId, r.e.cp_cont_c, 1);
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (aaVar.rL() == 1) {
                bgVar.aNb.setVisibility(8);
            } else {
                bgVar.aNb.setVisibility(0);
                aaVar.sd();
                SpannableStringBuilder rV = aaVar.rV();
                bgVar.aNb.setOnTouchListener(new x(rV));
                bgVar.aNb.setText(rV);
                if (readThreadHistory != null && readThreadHistory.qP(aaVar.getId())) {
                    ap.c(bgVar.aNb, r.e.cp_cont_c, 1);
                } else {
                    ap.c(bgVar.aNb, r.e.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (aaVar.rE() != null && aaVar.rE().trim().length() > 0) {
                stringBuffer.append(aaVar.rE());
            }
            ArrayList<MediaData> rG = aaVar.rG();
            if (rG != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i2 = 0; i2 < rG.size(); i2++) {
                    if (rG.get(i2).getVideoUrl() != null && rG.get(i2).getVideoUrl().endsWith("swf")) {
                        stringBuffer2.append(rG.get(i2).getVideoUrl());
                    }
                }
                stringBuffer.append(stringBuffer2.toString());
                if (!TextUtils.isEmpty(aaVar.g(stringBuffer.toString(), true))) {
                    if (stringBuffer.length() > 170) {
                        bgVar.bIg.setVisibility(0);
                    } else {
                        bgVar.bIg.setVisibility(8);
                    }
                    SpannableString cx = aaVar.cx(stringBuffer.toString());
                    bgVar.bIa.setOnTouchListener(new x(cx));
                    bgVar.bIa.setText(cx);
                    bgVar.bIa.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.qP(aaVar.getId())) {
                        ap.c(bgVar.bIa, r.e.cp_cont_c, 1);
                    } else {
                        ap.c(bgVar.bIa, r.e.cp_cont_b, 1);
                    }
                } else {
                    bgVar.bIg.setVisibility(8);
                    bgVar.bIa.setVisibility(8);
                }
            }
            if (l.oC().oI() && rG != null && rG.size() > 0) {
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < rG.size(); i5++) {
                    if (rG.get(i5) != null && (rG.get(i5).getType() == 3 || rG.get(i5).getType() == 5)) {
                        i4++;
                        i3++;
                    }
                }
                if (i4 > 0) {
                    MediaData[] mediaDataArr = new MediaData[i4];
                    int i6 = 0;
                    int i7 = 0;
                    while (i7 < rG.size() && i6 < i4) {
                        if (rG.get(i7).getType() == 3 || rG.get(i7).getType() == 5) {
                            mediaDataArr[i6] = rG.get(i7);
                            i = i6 + 1;
                        } else {
                            i = i6;
                        }
                        i7++;
                        i6 = i;
                    }
                    bgVar.bIc.setVisibility(0);
                    bgVar.bIc.a(aaVar, this.bFG.aJY().getName(), this.bFG.aJY().getId(), aaVar.getTid());
                    bgVar.bIc.setShowBig(this.bLf);
                    bgVar.bIc.setDrawNum(true);
                    bgVar.bIc.setFromCDN(this.mIsFromCDN);
                    bgVar.bIc.a(this.aWr.getPageContext(), mediaDataArr, i3);
                    bgVar.bIc.setImageFrom("other");
                } else {
                    bgVar.bIc.setVisibility(8);
                }
            } else {
                bgVar.bIc.setVisibility(8);
            }
            bgVar.bIb.setVisibility(8);
            if (aaVar.rn() != null && aaVar.rn().getNum() > 0) {
                bgVar.agf.setVisibility(0);
                bgVar.agf.setText(com.baidu.tbadk.core.util.at.w(aaVar.rn().getNum()));
            } else {
                bgVar.agf.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.ap(bgVar.agf);
            int rp = aaVar.rp();
            if (rp > 0) {
                bgVar.bHe.setVisibility(0);
                bgVar.bHe.setText(com.baidu.tbadk.core.util.at.w(rp));
            } else {
                bgVar.bHe.setVisibility(8);
            }
            bgVar.bIf.setVisibility(8);
        }
    }

    public void dT(boolean z) {
        if (this.bLf != z) {
            this.bLf = z;
        }
    }

    public int abL() {
        return r.h.storecard_close_click;
    }
}
