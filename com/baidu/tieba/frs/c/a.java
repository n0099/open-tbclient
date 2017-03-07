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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.tbadkCore.util.r;
import com.baidu.tieba.view.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends at<ab, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> ajF;
    private boolean bSl;
    private com.baidu.adp.lib.e.b<bp> bYV;
    private com.baidu.adp.lib.e.b<bg> bYW;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bSl = false;
        this.bYV = new com.baidu.adp.lib.e.b<>(new b(this), 5, 0);
        this.bYW = new com.baidu.adp.lib.e.b<>(new c(this), 5, 0);
        this.ajF = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public e onCreateViewHolder(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(w.j.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ab abVar, e eVar) {
        super.onFillViewHolder(i, view, viewGroup, abVar, eVar);
        com.baidu.tbadk.i.a.a(this.ajF, view);
        if (abVar.getThreadType() == 33) {
            if (eVar.bZd != null) {
                eVar.bZa.removeView(eVar.bZd.bPf);
                this.bYW.n(eVar.bZd);
                eVar.bZd = null;
            }
            if (eVar.bZe == null) {
                eVar.bZe = this.bYV.fE();
                eVar.bZa.addView(eVar.bZe.bPT);
                eVar.bZe.wP();
            }
            a(eVar.bZe, abVar);
        } else {
            if (eVar.bZe != null) {
                eVar.bZa.removeView(eVar.bZe.bPT);
                this.bYV.n(eVar.bZe);
                eVar.bZe = null;
            }
            if (eVar.bZd == null) {
                eVar.bZd = this.bYW.fE();
                eVar.bZa.addView(eVar.bZd.bPf);
            }
            a(eVar.bZd, abVar);
        }
        eVar.bZc.setOnClickListener(this);
        eVar.bZc.setTag(abVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bOi != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof bj) {
                this.bOi.a(id, 0, view, null, (bj) tag);
            }
        }
    }

    private void a(bp bpVar, ab abVar) {
        PhotoLiveCardData qm = abVar.qm();
        if (qm != null) {
            if (2 == b(qm)) {
                bpVar.bPU.setShowContent(true);
                bpVar.bPU.setShowCover(false);
                bpVar.bPU.setShowExpression(false);
            } else {
                bpVar.bPU.setShowContent(false);
                bpVar.bPU.setShowCover(true);
                bpVar.bPU.setShowExpression(true);
            }
            bpVar.bPU.setChooseStyle(qm.getShowStyle());
            bpVar.bPU.setShowLiveIcon(true);
            bpVar.bPU.setHeadPaddingTop(w.f.ds24);
            bpVar.bPU.setPortraitClicklistener(this);
            bpVar.bPU.setShowImage(l.oQ().oW());
            if (qm.isShowDiffViewInSameAdapter()) {
                bpVar.bPU.setShowBottom(true);
                bpVar.bPU.setShowRefreshTimeInButtom(true);
                bpVar.bPU.setShowHeadLiveIcon(true);
                bpVar.bPU.setShowRefreshTimeInHead(false);
                bpVar.bPU.setContentPaddingBottom(0);
            } else {
                bpVar.bPU.setShowBottom(false);
                bpVar.bPU.setShowRefreshTimeInHead(true);
                bpVar.bPU.setShowHeadLiveIcon(false);
                bpVar.bPU.setShowRefreshTimeInButtom(false);
                bpVar.bPU.setContentPaddingBottom(w.f.ds36);
            }
            bpVar.bPU.setData(qm);
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

    private void a(bg bgVar, ab abVar) {
        int i;
        if (bgVar != null && abVar != null) {
            if (bgVar.amL != this.mSkinType) {
                aq.j(bgVar.bPg, w.g.frs_item_control_btn_bg);
                aq.j(bgVar.bPp, w.g.frs_item_abstract_more_text_bg);
                bgVar.amL = this.mSkinType;
            }
            bgVar.bPo.setOnClickListener(this);
            bgVar.bPp.setOnClickListener(this);
            bgVar.bPo.setTag(abVar);
            bgVar.bPp.setTag(abVar);
            bgVar.bOm.setVisibility(8);
            bgVar.bPu.setVisibility(8);
            bgVar.alu.setText(au.q(abVar.rL() * 1000));
            if (l.oQ().oS() && abVar.getAuthor() != null) {
                bgVar.bPn.setVisibility(0);
                String portrait = abVar.getAuthor().getPortrait();
                bgVar.bPn.setUserId(abVar.getAuthor().getUserId());
                bgVar.bPn.setImageDrawable(null);
                bgVar.bPn.c(portrait, 28, false);
                bgVar.bPn.setOnClickListener(new d(this, abVar));
            } else {
                bgVar.bPn.setVisibility(8);
            }
            bgVar.amf.setVisibility(8);
            bgVar.ame.setVisibility(8);
            bgVar.bPm.setText(abVar.getAuthor().getName_show());
            aq.c(bgVar.bPm, w.e.cp_cont_c, 1);
            r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (abVar.sf() == 1) {
                bgVar.aSO.setVisibility(8);
            } else {
                bgVar.aSO.setVisibility(0);
                abVar.sy();
                SpannableStringBuilder sq = abVar.sq();
                bgVar.aSO.setOnTouchListener(new x(sq));
                bgVar.aSO.setText(sq);
                if (readThreadHistory != null && readThreadHistory.pX(abVar.getId())) {
                    aq.c(bgVar.aSO, w.e.cp_cont_c, 1);
                } else {
                    aq.c(bgVar.aSO, w.e.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (abVar.rY() != null && abVar.rY().trim().length() > 0) {
                stringBuffer.append(abVar.rY());
            }
            ArrayList<MediaData> sa = abVar.sa();
            if (sa != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i2 = 0; i2 < sa.size(); i2++) {
                    if (sa.get(i2).getVideoUrl() != null && sa.get(i2).getVideoUrl().endsWith("swf")) {
                        stringBuffer2.append(sa.get(i2).getVideoUrl());
                    }
                }
                stringBuffer.append(stringBuffer2.toString());
                if (!TextUtils.isEmpty(abVar.g(stringBuffer.toString(), true))) {
                    if (stringBuffer.length() > 170) {
                        bgVar.bPp.setVisibility(0);
                    } else {
                        bgVar.bPp.setVisibility(8);
                    }
                    SpannableString cq = abVar.cq(stringBuffer.toString());
                    bgVar.bPj.setOnTouchListener(new x(cq));
                    bgVar.bPj.setText(cq);
                    bgVar.bPj.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.pX(abVar.getId())) {
                        aq.c(bgVar.bPj, w.e.cp_cont_c, 1);
                    } else {
                        aq.c(bgVar.bPj, w.e.cp_cont_b, 1);
                    }
                } else {
                    bgVar.bPp.setVisibility(8);
                    bgVar.bPj.setVisibility(8);
                }
            }
            if (l.oQ().oW() && sa != null && sa.size() > 0) {
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < sa.size(); i5++) {
                    if (sa.get(i5) != null && (sa.get(i5).getType() == 3 || sa.get(i5).getType() == 5)) {
                        i4++;
                        i3++;
                    }
                }
                if (i4 > 0) {
                    MediaData[] mediaDataArr = new MediaData[i4];
                    int i6 = 0;
                    int i7 = 0;
                    while (i7 < sa.size() && i6 < i4) {
                        if (sa.get(i7).getType() == 3 || sa.get(i7).getType() == 5) {
                            mediaDataArr[i6] = sa.get(i7);
                            i = i6 + 1;
                        } else {
                            i = i6;
                        }
                        i7++;
                        i6 = i;
                    }
                    bgVar.bPl.setVisibility(0);
                    bgVar.bPl.a(abVar, this.bMO.aJp().getName(), this.bMO.aJp().getId(), abVar.getTid());
                    bgVar.bPl.setShowBig(this.bSl);
                    bgVar.bPl.setDrawNum(true);
                    bgVar.bPl.setFromCDN(this.mIsFromCDN);
                    bgVar.bPl.a(this.bcF.getPageContext(), mediaDataArr, i3);
                    bgVar.bPl.setImageFrom("other");
                } else {
                    bgVar.bPl.setVisibility(8);
                }
            } else {
                bgVar.bPl.setVisibility(8);
            }
            bgVar.bPk.setVisibility(8);
            if (abVar.rG() != null && abVar.rG().getNum() > 0) {
                bgVar.alx.setVisibility(0);
                bgVar.alx.setText(au.w(abVar.rG().getNum()));
            } else {
                bgVar.alx.setVisibility(8);
            }
            com.baidu.tieba.graffiti.c.an(bgVar.alx);
            int rJ = abVar.rJ();
            if (rJ > 0) {
                bgVar.bOn.setVisibility(0);
                bgVar.bOn.setText(au.w(rJ));
            } else {
                bgVar.bOn.setVisibility(8);
            }
            bgVar.bPo.setVisibility(8);
        }
    }

    public void dT(boolean z) {
        if (this.bSl != z) {
            this.bSl = z;
        }
    }

    public int acI() {
        return w.h.storecard_close_click;
    }
}
