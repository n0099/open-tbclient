package com.baidu.tieba.frs.d;

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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.cu;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.s;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends bf<y, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> GM;
    private boolean bVO;
    private com.baidu.adp.lib.f.b<cu> ccr;
    private com.baidu.adp.lib.f.b<ca> ccs;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bVO = false;
        this.ccr = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.ccs = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.GM = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: T */
    public e a(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(r.h.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, y yVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) yVar, (y) eVar);
        com.baidu.tbadk.i.a.a(this.GM, view);
        if (yVar.getThreadType() == 33) {
            if (eVar.ccz != null) {
                eVar.ccw.removeView(eVar.ccz.bSc);
                this.ccs.n(eVar.ccz);
                eVar.ccz = null;
            }
            if (eVar.ccA == null) {
                eVar.ccA = this.ccr.ey();
                eVar.ccw.addView(eVar.ccA.bTc);
                eVar.ccA.wH();
            }
            a(eVar.ccA, yVar);
        } else {
            if (eVar.ccA != null) {
                eVar.ccw.removeView(eVar.ccA.bTc);
                this.ccr.n(eVar.ccA);
                eVar.ccA = null;
            }
            if (eVar.ccz == null) {
                eVar.ccz = this.ccs.ey();
                eVar.ccw.addView(eVar.ccz.bSc);
            }
            a(eVar.ccz, yVar);
        }
        eVar.ccy.setOnClickListener(this);
        eVar.ccy.setTag(yVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bQG != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof bi) {
                this.bQG.a(id, 0, view, null, (bi) tag);
            }
        }
    }

    private void a(cu cuVar, y yVar) {
        PhotoLiveCardData pX = yVar.pX();
        if (pX != null) {
            if (2 == b(pX)) {
                cuVar.bTd.setShowContent(true);
                cuVar.bTd.setShowCover(false);
                cuVar.bTd.setShowExpression(false);
            } else {
                cuVar.bTd.setShowContent(false);
                cuVar.bTd.setShowCover(true);
                cuVar.bTd.setShowExpression(true);
            }
            cuVar.bTd.setChooseStyle(pX.getShowStyle());
            cuVar.bTd.setShowLiveIcon(true);
            cuVar.bTd.setHeadPaddingTop(r.e.ds24);
            cuVar.bTd.setPortraitClicklistener(this);
            cuVar.bTd.setShowImage(l.oH().oN());
            if (pX.isShowDiffViewInSameAdapter()) {
                cuVar.bTd.setShowBottom(true);
                cuVar.bTd.setShowRefreshTimeInButtom(true);
                cuVar.bTd.setShowHeadLiveIcon(true);
                cuVar.bTd.setShowRefreshTimeInHead(false);
                cuVar.bTd.setContentPaddingBottom(0);
            } else {
                cuVar.bTd.setShowBottom(false);
                cuVar.bTd.setShowRefreshTimeInHead(true);
                cuVar.bTd.setShowHeadLiveIcon(false);
                cuVar.bTd.setShowRefreshTimeInButtom(false);
                cuVar.bTd.setContentPaddingBottom(r.e.ds36);
            }
            cuVar.bTd.setData(pX);
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

    private void a(ca caVar, y yVar) {
        int i;
        if (caVar != null && yVar != null) {
            if (caVar.ahV != this.mSkinType) {
                av.k(caVar.bSd, r.f.frs_item_control_btn_bg);
                av.k(caVar.bSm, r.f.frs_item_abstract_more_text_bg);
                caVar.ahV = this.mSkinType;
            }
            caVar.bSl.setOnClickListener(this);
            caVar.bSm.setOnClickListener(this);
            caVar.bSl.setTag(yVar);
            caVar.bSm.setTag(yVar);
            caVar.bRb.setVisibility(8);
            caVar.bSr.setVisibility(8);
            caVar.agW.setText(az.t(yVar.rI() * 1000));
            if (l.oH().oJ() && yVar.getAuthor() != null) {
                caVar.bSk.setVisibility(0);
                String portrait = yVar.getAuthor().getPortrait();
                caVar.bSk.setUserId(yVar.getAuthor().getUserId());
                caVar.bSk.setImageDrawable(null);
                caVar.bSk.c(portrait, 28, false);
                caVar.bSk.setOnClickListener(new d(this, yVar));
            } else {
                caVar.bSk.setVisibility(8);
            }
            caVar.ahx.setVisibility(8);
            caVar.ahw.setVisibility(8);
            caVar.bSj.setText(yVar.getAuthor().getName_show());
            av.c(caVar.bSj, r.d.cp_cont_c, 1);
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (yVar.sb() == 1) {
                caVar.aMI.setVisibility(8);
            } else {
                caVar.aMI.setVisibility(0);
                yVar.su();
                SpannableStringBuilder sm = yVar.sm();
                caVar.aMI.setOnTouchListener(new com.baidu.tieba.view.y(sm));
                caVar.aMI.setText(sm);
                if (readThreadHistory != null && readThreadHistory.ru(yVar.getId())) {
                    av.c(caVar.aMI, r.d.cp_cont_c, 1);
                } else {
                    av.c(caVar.aMI, r.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (yVar.rU() != null && yVar.rU().trim().length() > 0) {
                stringBuffer.append(yVar.rU());
            }
            ArrayList<MediaData> rW = yVar.rW();
            if (rW != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i2 = 0; i2 < rW.size(); i2++) {
                    if (rW.get(i2).getVideoUrl() != null && rW.get(i2).getVideoUrl().endsWith("swf")) {
                        stringBuffer2.append(rW.get(i2).getVideoUrl());
                    }
                }
                stringBuffer.append(stringBuffer2.toString());
                if (!TextUtils.isEmpty(yVar.g(stringBuffer.toString(), true))) {
                    if (stringBuffer.length() > 170) {
                        caVar.bSm.setVisibility(0);
                    } else {
                        caVar.bSm.setVisibility(8);
                    }
                    SpannableString cw = yVar.cw(stringBuffer.toString());
                    caVar.bSg.setOnTouchListener(new com.baidu.tieba.view.y(cw));
                    caVar.bSg.setText(cw);
                    caVar.bSg.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.ru(yVar.getId())) {
                        av.c(caVar.bSg, r.d.cp_cont_c, 1);
                    } else {
                        av.c(caVar.bSg, r.d.cp_cont_b, 1);
                    }
                } else {
                    caVar.bSm.setVisibility(8);
                    caVar.bSg.setVisibility(8);
                }
            }
            if (l.oH().oN() && rW != null && rW.size() > 0) {
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < rW.size(); i5++) {
                    if (rW.get(i5) != null && (rW.get(i5).getType() == 3 || rW.get(i5).getType() == 5)) {
                        i4++;
                        i3++;
                    }
                }
                if (i4 > 0) {
                    MediaData[] mediaDataArr = new MediaData[i4];
                    int i6 = 0;
                    int i7 = 0;
                    while (i7 < rW.size() && i6 < i4) {
                        if (rW.get(i7).getType() == 3 || rW.get(i7).getType() == 5) {
                            mediaDataArr[i6] = rW.get(i7);
                            i = i6 + 1;
                        } else {
                            i = i6;
                        }
                        i7++;
                        i6 = i;
                    }
                    caVar.bSi.setVisibility(0);
                    caVar.bSi.a(yVar, this.bPk.aMr().getName(), this.bPk.aMr().getId(), yVar.getTid());
                    caVar.bSi.setShowBig(this.bVO);
                    caVar.bSi.setDrawNum(true);
                    caVar.bSi.setFromCDN(this.mIsFromCDN);
                    caVar.bSi.a(this.aRd.getPageContext(), mediaDataArr, i3);
                    caVar.bSi.setImageFrom("other");
                } else {
                    caVar.bSi.setVisibility(8);
                }
            } else {
                caVar.bSi.setVisibility(8);
            }
            caVar.bSh.setVisibility(8);
            if (yVar.rF() != null && yVar.rF().getNum() > 0) {
                caVar.agZ.setVisibility(0);
                caVar.agZ.setText(az.z(yVar.rF().getNum()));
            } else {
                caVar.agZ.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(caVar.agZ);
            int rH = yVar.rH();
            if (rH > 0) {
                caVar.bRc.setVisibility(0);
                caVar.bRc.setText(az.z(rH));
            } else {
                caVar.bRc.setVisibility(8);
            }
            caVar.bSl.setVisibility(8);
        }
    }

    public void dU(boolean z) {
        if (this.bVO != z) {
            this.bVO = z;
        }
    }

    public int aeR() {
        return r.g.storecard_close_click;
    }
}
