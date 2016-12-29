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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.r;
import com.baidu.tieba.view.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends au<z, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> GO;
    private boolean bEM;
    private com.baidu.adp.lib.f.b<br> bLx;
    private com.baidu.adp.lib.f.b<bi> bLy;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bEM = false;
        this.bLx = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.bLy = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.GO = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public e a(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(r.h.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.au, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, z zVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (z) eVar);
        com.baidu.tbadk.i.a.a(this.GO, view);
        if (zVar.getThreadType() == 33) {
            if (eVar.bLF != null) {
                eVar.bLC.removeView(eVar.bLF.bAB);
                this.bLy.n(eVar.bLF);
                eVar.bLF = null;
            }
            if (eVar.bLG == null) {
                eVar.bLG = this.bLx.ey();
                eVar.bLC.addView(eVar.bLG.bBq);
                eVar.bLG.wx();
            }
            a(eVar.bLG, zVar);
        } else {
            if (eVar.bLG != null) {
                eVar.bLC.removeView(eVar.bLG.bBq);
                this.bLx.n(eVar.bLG);
                eVar.bLG = null;
            }
            if (eVar.bLF == null) {
                eVar.bLF = this.bLy.ey();
                eVar.bLC.addView(eVar.bLF.bAB);
            }
            a(eVar.bLF, zVar);
        }
        eVar.bLE.setOnClickListener(this);
        eVar.bLE.setTag(zVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bzz != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof bg) {
                this.bzz.a(id, 0, view, null, (bg) tag);
            }
        }
    }

    private void a(br brVar, z zVar) {
        PhotoLiveCardData qb = zVar.qb();
        if (qb != null) {
            if (2 == b(qb)) {
                brVar.bBr.setShowContent(true);
                brVar.bBr.setShowCover(false);
                brVar.bBr.setShowExpression(false);
            } else {
                brVar.bBr.setShowContent(false);
                brVar.bBr.setShowCover(true);
                brVar.bBr.setShowExpression(true);
            }
            brVar.bBr.setChooseStyle(qb.getShowStyle());
            brVar.bBr.setShowLiveIcon(true);
            brVar.bBr.setHeadPaddingTop(r.e.ds24);
            brVar.bBr.setPortraitClicklistener(this);
            brVar.bBr.setShowImage(l.oJ().oP());
            if (qb.isShowDiffViewInSameAdapter()) {
                brVar.bBr.setShowBottom(true);
                brVar.bBr.setShowRefreshTimeInButtom(true);
                brVar.bBr.setShowHeadLiveIcon(true);
                brVar.bBr.setShowRefreshTimeInHead(false);
                brVar.bBr.setContentPaddingBottom(0);
            } else {
                brVar.bBr.setShowBottom(false);
                brVar.bBr.setShowRefreshTimeInHead(true);
                brVar.bBr.setShowHeadLiveIcon(false);
                brVar.bBr.setShowRefreshTimeInButtom(false);
                brVar.bBr.setContentPaddingBottom(r.e.ds36);
            }
            brVar.bBr.setData(qb);
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

    private void a(bi biVar, z zVar) {
        int i;
        if (biVar != null && zVar != null) {
            if (biVar.aib != this.mSkinType) {
                ar.k(biVar.bAC, r.f.frs_item_control_btn_bg);
                ar.k(biVar.bAL, r.f.frs_item_abstract_more_text_bg);
                biVar.aib = this.mSkinType;
            }
            biVar.bAK.setOnClickListener(this);
            biVar.bAL.setOnClickListener(this);
            biVar.bAK.setTag(zVar);
            biVar.bAL.setTag(zVar);
            biVar.bzE.setVisibility(8);
            biVar.bAQ.setVisibility(8);
            biVar.agP.setText(av.s(zVar.rz() * 1000));
            if (l.oJ().oL() && zVar.getAuthor() != null) {
                biVar.bAJ.setVisibility(0);
                String portrait = zVar.getAuthor().getPortrait();
                biVar.bAJ.setUserId(zVar.getAuthor().getUserId());
                biVar.bAJ.setImageDrawable(null);
                biVar.bAJ.c(portrait, 28, false);
                biVar.bAJ.setOnClickListener(new d(this, zVar));
            } else {
                biVar.bAJ.setVisibility(8);
            }
            biVar.ahy.setVisibility(8);
            biVar.ahx.setVisibility(8);
            biVar.bAI.setText(zVar.getAuthor().getName_show());
            ar.c(biVar.bAI, r.d.cp_cont_c, 1);
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (zVar.rU() == 1) {
                biVar.aNY.setVisibility(8);
            } else {
                biVar.aNY.setVisibility(0);
                zVar.sl();
                SpannableStringBuilder sd = zVar.sd();
                biVar.aNY.setOnTouchListener(new x(sd));
                biVar.aNY.setText(sd);
                if (readThreadHistory != null && readThreadHistory.qv(zVar.getId())) {
                    ar.c(biVar.aNY, r.d.cp_cont_c, 1);
                } else {
                    ar.c(biVar.aNY, r.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (zVar.rN() != null && zVar.rN().trim().length() > 0) {
                stringBuffer.append(zVar.rN());
            }
            ArrayList<MediaData> rP = zVar.rP();
            if (rP != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i2 = 0; i2 < rP.size(); i2++) {
                    if (rP.get(i2).getVideoUrl() != null && rP.get(i2).getVideoUrl().endsWith("swf")) {
                        stringBuffer2.append(rP.get(i2).getVideoUrl());
                    }
                }
                stringBuffer.append(stringBuffer2.toString());
                if (!TextUtils.isEmpty(zVar.g(stringBuffer.toString(), true))) {
                    if (stringBuffer.length() > 170) {
                        biVar.bAL.setVisibility(0);
                    } else {
                        biVar.bAL.setVisibility(8);
                    }
                    SpannableString cz = zVar.cz(stringBuffer.toString());
                    biVar.bAF.setOnTouchListener(new x(cz));
                    biVar.bAF.setText(cz);
                    biVar.bAF.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.qv(zVar.getId())) {
                        ar.c(biVar.bAF, r.d.cp_cont_c, 1);
                    } else {
                        ar.c(biVar.bAF, r.d.cp_cont_b, 1);
                    }
                } else {
                    biVar.bAL.setVisibility(8);
                    biVar.bAF.setVisibility(8);
                }
            }
            if (l.oJ().oP() && rP != null && rP.size() > 0) {
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < rP.size(); i5++) {
                    if (rP.get(i5) != null && (rP.get(i5).getType() == 3 || rP.get(i5).getType() == 5)) {
                        i4++;
                        i3++;
                    }
                }
                if (i4 > 0) {
                    MediaData[] mediaDataArr = new MediaData[i4];
                    int i6 = 0;
                    int i7 = 0;
                    while (i7 < rP.size() && i6 < i4) {
                        if (rP.get(i7).getType() == 3 || rP.get(i7).getType() == 5) {
                            mediaDataArr[i6] = rP.get(i7);
                            i = i6 + 1;
                        } else {
                            i = i6;
                        }
                        i7++;
                        i6 = i;
                    }
                    biVar.bAH.setVisibility(0);
                    biVar.bAH.a(zVar, this.byh.aIk().getName(), this.byh.aIk().getId(), zVar.getTid());
                    biVar.bAH.setShowBig(this.bEM);
                    biVar.bAH.setDrawNum(true);
                    biVar.bAH.setFromCDN(this.mIsFromCDN);
                    biVar.bAH.a(this.aSs.getPageContext(), mediaDataArr, i3);
                    biVar.bAH.setImageFrom("other");
                } else {
                    biVar.bAH.setVisibility(8);
                }
            } else {
                biVar.bAH.setVisibility(8);
            }
            biVar.bAG.setVisibility(8);
            if (zVar.rv() != null && zVar.rv().getNum() > 0) {
                biVar.agS.setVisibility(0);
                biVar.agS.setText(av.y(zVar.rv().getNum()));
            } else {
                biVar.agS.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(biVar.agS);
            int rx = zVar.rx();
            if (rx > 0) {
                biVar.bzF.setVisibility(0);
                biVar.bzF.setText(av.y(rx));
            } else {
                biVar.bzF.setVisibility(8);
            }
            biVar.bAK.setVisibility(8);
        }
    }

    public void dO(boolean z) {
        if (this.bEM != z) {
            this.bEM = z;
        }
    }

    public int aaF() {
        return r.g.storecard_close_click;
    }
}
