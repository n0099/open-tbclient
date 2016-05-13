package com.baidu.tieba.frs.c;

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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.dk;
import com.baidu.tieba.frs.eg;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends bw<r, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> DV;
    private boolean bfl;
    private com.baidu.adp.lib.f.b<eg> brP;
    private com.baidu.adp.lib.f.b<dk> brQ;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bfl = false;
        this.brP = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.brQ = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.DV = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public e b(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, r rVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (r) eVar);
        com.baidu.tbadk.i.a.a(this.DV, view);
        if (rVar.getThreadType() == 33) {
            if (eVar.brX != null) {
                eVar.brU.removeView(eVar.brX.bkP);
                this.brQ.k(eVar.brX);
                eVar.brX = null;
            }
            if (eVar.brY == null) {
                eVar.brY = this.brP.dD();
                eVar.brU.addView(eVar.brY.blQ);
                eVar.brY.vm();
            }
            a(eVar.brY, rVar);
        } else {
            if (eVar.brY != null) {
                eVar.brU.removeView(eVar.brY.blQ);
                this.brP.k(eVar.brY);
                eVar.brY = null;
            }
            if (eVar.brX == null) {
                eVar.brX = this.brQ.dD();
                eVar.brU.addView(eVar.brX.bkP);
            }
            a(eVar.brX, rVar);
        }
        eVar.brW.setOnClickListener(this);
        eVar.brW.setTag(rVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bix != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof ax) {
                this.bix.a(id, 0, view, null, (ax) tag);
            }
        }
    }

    private void a(eg egVar, r rVar) {
        PhotoLiveCardData pc = rVar.pc();
        if (pc != null) {
            if (2 == b(pc)) {
                egVar.blR.setShowContent(true);
                egVar.blR.setShowCover(false);
                egVar.blR.setShowExpression(false);
            } else {
                egVar.blR.setShowContent(false);
                egVar.blR.setShowCover(true);
                egVar.blR.setShowExpression(true);
            }
            egVar.blR.setChooseStyle(pc.getShowStyle());
            egVar.blR.setShowLiveIcon(true);
            egVar.blR.setHeadPaddingTop(t.e.ds24);
            egVar.blR.setPortraitClicklistener(this);
            egVar.blR.setShowImage(l.ob().oh());
            if (pc.isShowDiffViewInSameAdapter()) {
                egVar.blR.setShowBottom(true);
                egVar.blR.setShowRefreshTimeInButtom(true);
                egVar.blR.setShowHeadLiveIcon(true);
                egVar.blR.setShowRefreshTimeInHead(false);
                egVar.blR.setContentPaddingBottom(0);
            } else {
                egVar.blR.setShowBottom(false);
                egVar.blR.setShowRefreshTimeInHead(true);
                egVar.blR.setShowHeadLiveIcon(false);
                egVar.blR.setShowRefreshTimeInButtom(false);
                egVar.blR.setContentPaddingBottom(t.e.ds36);
            }
            egVar.blR.setData(pc);
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

    private void a(dk dkVar, r rVar) {
        int i;
        if (dkVar != null && rVar != null) {
            if (dkVar.aej != this.mSkinType) {
                at.k(dkVar.bfB, t.f.frs_item_control_btn_bg);
                at.k(dkVar.bfM, t.f.frs_item_abstract_more_text_bg);
                dkVar.aej = this.mSkinType;
            }
            dkVar.bkS.setOnClickListener(this);
            dkVar.bfM.setOnClickListener(this);
            dkVar.bkS.setTag(rVar);
            dkVar.bfM.setTag(rVar);
            dkVar.bji.setVisibility(8);
            dkVar.bkX.setVisibility(8);
            dkVar.adg.setText(ay.x(rVar.getLast_time_int() * 1000));
            if (l.ob().od() && rVar.getAuthor() != null) {
                dkVar.bfG.setVisibility(0);
                String portrait = rVar.getAuthor().getPortrait();
                dkVar.bfG.setUserId(rVar.getAuthor().getUserId());
                dkVar.bfG.setImageDrawable(null);
                dkVar.bfG.c(portrait, 28, false);
                dkVar.bfG.setOnClickListener(new d(this, rVar));
            } else {
                dkVar.bfG.setVisibility(8);
            }
            dkVar.adI.setVisibility(8);
            dkVar.adH.setVisibility(8);
            dkVar.bfF.setText(rVar.getAuthor().getName_show());
            at.c(dkVar.bfF, t.d.cp_cont_c, 1);
            s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
            if (rVar.qZ() == 1) {
                dkVar.aOG.setVisibility(8);
            } else {
                dkVar.aOG.setVisibility(0);
                rVar.parser_title();
                dkVar.aOG.setText(rVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.od(rVar.getId())) {
                    at.c(dkVar.aOG, t.d.cp_cont_c, 1);
                } else {
                    at.c(dkVar.aOG, t.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (rVar.qT() != null && rVar.qT().trim().length() > 0) {
                stringBuffer.append(rVar.qT());
            }
            ArrayList<MediaData> medias = rVar.getMedias();
            if (medias != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i2 = 0; i2 < medias.size(); i2++) {
                    if (medias.get(i2).getVideoUrl() != null && medias.get(i2).getVideoUrl().endsWith("swf")) {
                        stringBuffer2.append(medias.get(i2).getVideoUrl());
                    }
                }
                stringBuffer.append(stringBuffer2.toString());
                if (stringBuffer.length() > 0) {
                    if (stringBuffer.length() > 170) {
                        dkVar.bfM.setVisibility(0);
                        dkVar.bfC.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        dkVar.bfM.setVisibility(8);
                        dkVar.bfC.setText(stringBuffer.toString());
                    }
                    dkVar.bfC.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.od(rVar.getId())) {
                        at.c(dkVar.bfC, t.d.cp_cont_c, 1);
                    } else {
                        at.c(dkVar.bfC, t.d.cp_cont_b, 1);
                    }
                } else {
                    dkVar.bfM.setVisibility(8);
                    dkVar.bfC.setVisibility(8);
                }
            }
            if (l.ob().oh() && medias != null && medias.size() > 0) {
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < medias.size(); i5++) {
                    if (medias.get(i5) != null && (medias.get(i5).getType() == 3 || medias.get(i5).getType() == 5)) {
                        i4++;
                        i3++;
                    }
                }
                if (i4 > 0) {
                    MediaData[] mediaDataArr = new MediaData[i4];
                    int i6 = 0;
                    int i7 = 0;
                    while (i7 < medias.size() && i6 < i4) {
                        if (medias.get(i7).getType() == 3 || medias.get(i7).getType() == 5) {
                            mediaDataArr[i6] = medias.get(i7);
                            i = i6 + 1;
                        } else {
                            i = i6;
                        }
                        i7++;
                        i6 = i;
                    }
                    dkVar.bfE.setVisibility(0);
                    dkVar.bfE.a(rVar, this.bgq.avD().getName(), this.bgq.avD().getId(), rVar.getTid());
                    dkVar.bfE.setShowBig(this.bfl);
                    dkVar.bfE.setDrawNum(true);
                    dkVar.bfE.setFromCDN(this.mIsFromCDN);
                    dkVar.bfE.a(this.bek.getPageContext(), mediaDataArr, i3);
                    dkVar.bfE.setImageFrom("other");
                } else {
                    dkVar.bfE.setVisibility(8);
                }
            } else {
                dkVar.bfE.setVisibility(8);
            }
            dkVar.bfD.setVisibility(8);
            if (rVar.getPraise() != null && rVar.getPraise().getNum() > 0) {
                dkVar.adj.setVisibility(0);
                dkVar.adj.setText(ay.B(rVar.getPraise().getNum()));
            } else {
                dkVar.adj.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.aj(dkVar.adj);
            int reply_num = rVar.getReply_num();
            if (reply_num > 0) {
                dkVar.bfK.setVisibility(0);
                dkVar.bfK.setText(ay.B(reply_num));
            } else {
                dkVar.bfK.setVisibility(8);
            }
            dkVar.bkS.setVisibility(8);
        }
    }

    public void cG(boolean z) {
        if (this.bfl != z) {
            this.bfl = z;
        }
    }

    public int Tl() {
        return t.g.storecard_close_click;
    }
}
