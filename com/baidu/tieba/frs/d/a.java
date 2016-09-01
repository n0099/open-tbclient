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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.cu;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.view.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends bf<w, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> GM;
    private boolean bVP;
    private com.baidu.adp.lib.f.b<cu> ccr;
    private com.baidu.adp.lib.f.b<ca> ccs;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bVP = false;
        this.ccr = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.ccs = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.GM = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public e a(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, w wVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) wVar, (w) eVar);
        com.baidu.tbadk.j.a.a(this.GM, view);
        if (wVar.getThreadType() == 33) {
            if (eVar.ccz != null) {
                eVar.ccw.removeView(eVar.ccz.bSj);
                this.ccs.n(eVar.ccz);
                eVar.ccz = null;
            }
            if (eVar.ccA == null) {
                eVar.ccA = this.ccr.ey();
                eVar.ccw.addView(eVar.ccA.bTj);
                eVar.ccA.wq();
            }
            a(eVar.ccA, wVar);
        } else {
            if (eVar.ccA != null) {
                eVar.ccw.removeView(eVar.ccA.bTj);
                this.ccr.n(eVar.ccA);
                eVar.ccA = null;
            }
            if (eVar.ccz == null) {
                eVar.ccz = this.ccs.ey();
                eVar.ccw.addView(eVar.ccz.bSj);
            }
            a(eVar.ccz, wVar);
        }
        eVar.ccy.setOnClickListener(this);
        eVar.ccy.setTag(wVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bQN != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof bg) {
                this.bQN.a(id, 0, view, null, (bg) tag);
            }
        }
    }

    private void a(cu cuVar, w wVar) {
        PhotoLiveCardData pM = wVar.pM();
        if (pM != null) {
            if (2 == b(pM)) {
                cuVar.bTk.setShowContent(true);
                cuVar.bTk.setShowCover(false);
                cuVar.bTk.setShowExpression(false);
            } else {
                cuVar.bTk.setShowContent(false);
                cuVar.bTk.setShowCover(true);
                cuVar.bTk.setShowExpression(true);
            }
            cuVar.bTk.setChooseStyle(pM.getShowStyle());
            cuVar.bTk.setShowLiveIcon(true);
            cuVar.bTk.setHeadPaddingTop(t.e.ds24);
            cuVar.bTk.setPortraitClicklistener(this);
            cuVar.bTk.setShowImage(l.oG().oM());
            if (pM.isShowDiffViewInSameAdapter()) {
                cuVar.bTk.setShowBottom(true);
                cuVar.bTk.setShowRefreshTimeInButtom(true);
                cuVar.bTk.setShowHeadLiveIcon(true);
                cuVar.bTk.setShowRefreshTimeInHead(false);
                cuVar.bTk.setContentPaddingBottom(0);
            } else {
                cuVar.bTk.setShowBottom(false);
                cuVar.bTk.setShowRefreshTimeInHead(true);
                cuVar.bTk.setShowHeadLiveIcon(false);
                cuVar.bTk.setShowRefreshTimeInButtom(false);
                cuVar.bTk.setContentPaddingBottom(t.e.ds36);
            }
            cuVar.bTk.setData(pM);
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

    private void a(ca caVar, w wVar) {
        int i;
        if (caVar != null && wVar != null) {
            if (caVar.ait != this.mSkinType) {
                av.k(caVar.bSk, t.f.frs_item_control_btn_bg);
                av.k(caVar.bSt, t.f.frs_item_abstract_more_text_bg);
                caVar.ait = this.mSkinType;
            }
            caVar.bSs.setOnClickListener(this);
            caVar.bSt.setOnClickListener(this);
            caVar.bSs.setTag(wVar);
            caVar.bSt.setTag(wVar);
            caVar.bRi.setVisibility(8);
            caVar.bSy.setVisibility(8);
            caVar.ahn.setText(ba.t(wVar.rw() * 1000));
            if (l.oG().oI() && wVar.getAuthor() != null) {
                caVar.bSr.setVisibility(0);
                String portrait = wVar.getAuthor().getPortrait();
                caVar.bSr.setUserId(wVar.getAuthor().getUserId());
                caVar.bSr.setImageDrawable(null);
                caVar.bSr.c(portrait, 28, false);
                caVar.bSr.setOnClickListener(new d(this, wVar));
            } else {
                caVar.bSr.setVisibility(8);
            }
            caVar.ahP.setVisibility(8);
            caVar.ahO.setVisibility(8);
            caVar.bSq.setText(wVar.getAuthor().getName_show());
            av.c(caVar.bSq, t.d.cp_cont_c, 1);
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (wVar.rP() == 1) {
                caVar.aYh.setVisibility(8);
            } else {
                caVar.aYh.setVisibility(0);
                wVar.si();
                SpannableStringBuilder sa = wVar.sa();
                caVar.aYh.setOnTouchListener(new y(sa));
                caVar.aYh.setText(sa);
                if (readThreadHistory != null && readThreadHistory.rf(wVar.getId())) {
                    av.c(caVar.aYh, t.d.cp_cont_c, 1);
                } else {
                    av.c(caVar.aYh, t.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (wVar.rI() != null && wVar.rI().trim().length() > 0) {
                stringBuffer.append(wVar.rI());
            }
            ArrayList<MediaData> rK = wVar.rK();
            if (rK != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i2 = 0; i2 < rK.size(); i2++) {
                    if (rK.get(i2).getVideoUrl() != null && rK.get(i2).getVideoUrl().endsWith("swf")) {
                        stringBuffer2.append(rK.get(i2).getVideoUrl());
                    }
                }
                stringBuffer.append(stringBuffer2.toString());
                if (!TextUtils.isEmpty(wVar.g(stringBuffer.toString(), true))) {
                    if (stringBuffer.length() > 170) {
                        caVar.bSt.setVisibility(0);
                    } else {
                        caVar.bSt.setVisibility(8);
                    }
                    SpannableString cu = wVar.cu(stringBuffer.toString());
                    caVar.bSn.setOnTouchListener(new y(cu));
                    caVar.bSn.setText(cu);
                    caVar.bSn.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.rf(wVar.getId())) {
                        av.c(caVar.bSn, t.d.cp_cont_c, 1);
                    } else {
                        av.c(caVar.bSn, t.d.cp_cont_b, 1);
                    }
                } else {
                    caVar.bSt.setVisibility(8);
                    caVar.bSn.setVisibility(8);
                }
            }
            if (l.oG().oM() && rK != null && rK.size() > 0) {
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < rK.size(); i5++) {
                    if (rK.get(i5) != null && (rK.get(i5).getType() == 3 || rK.get(i5).getType() == 5)) {
                        i4++;
                        i3++;
                    }
                }
                if (i4 > 0) {
                    MediaData[] mediaDataArr = new MediaData[i4];
                    int i6 = 0;
                    int i7 = 0;
                    while (i7 < rK.size() && i6 < i4) {
                        if (rK.get(i7).getType() == 3 || rK.get(i7).getType() == 5) {
                            mediaDataArr[i6] = rK.get(i7);
                            i = i6 + 1;
                        } else {
                            i = i6;
                        }
                        i7++;
                        i6 = i;
                    }
                    caVar.bSp.setVisibility(0);
                    caVar.bSp.a(wVar, this.bPq.aLP().getName(), this.bPq.aLP().getId(), wVar.getTid());
                    caVar.bSp.setShowBig(this.bVP);
                    caVar.bSp.setDrawNum(true);
                    caVar.bSp.setFromCDN(this.mIsFromCDN);
                    caVar.bSp.a(this.aPR.getPageContext(), mediaDataArr, i3);
                    caVar.bSp.setImageFrom("other");
                } else {
                    caVar.bSp.setVisibility(8);
                }
            } else {
                caVar.bSp.setVisibility(8);
            }
            caVar.bSo.setVisibility(8);
            if (wVar.rt() != null && wVar.rt().getNum() > 0) {
                caVar.ahq.setVisibility(0);
                caVar.ahq.setText(ba.y(wVar.rt().getNum()));
            } else {
                caVar.ahq.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.al(caVar.ahq);
            int rv = wVar.rv();
            if (rv > 0) {
                caVar.bRj.setVisibility(0);
                caVar.bRj.setText(ba.y(rv));
            } else {
                caVar.bRj.setVisibility(8);
            }
            caVar.bSs.setVisibility(8);
        }
    }

    public void dT(boolean z) {
        if (this.bVP != z) {
            this.bVP = z;
        }
    }

    public int aeD() {
        return t.g.storecard_close_click;
    }
}
