package com.baidu.tieba.frs.a;

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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.dp;
import com.baidu.tieba.frs.el;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends bx<r, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> ND;
    private boolean bjl;
    private com.baidu.adp.lib.f.b<el> bsZ;
    private com.baidu.adp.lib.f.b<dp> bta;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bjl = false;
        this.bsZ = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.bta = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.ND = baseActivity.getPageContext();
        SY();
    }

    private void SY() {
        this.bsZ.k(this.bsZ.hp());
        this.bta.k(this.bta.hp());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public e b(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, r rVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) rVar, (r) eVar);
        com.baidu.tbadk.i.a.a(this.ND, view);
        if (rVar.getThreadType() == 33) {
            if (eVar.bth != null) {
                eVar.bte.removeView(eVar.bth.bpz);
                this.bta.k(eVar.bth);
                eVar.bth = null;
            }
            if (eVar.bti == null) {
                eVar.bti = this.bsZ.hp();
                eVar.bte.addView(eVar.bti.bqB);
                eVar.bti.xy();
            }
            a(eVar.bti, rVar);
        } else {
            if (eVar.bti != null) {
                eVar.bte.removeView(eVar.bti.bqB);
                this.bsZ.k(eVar.bti);
                eVar.bti = null;
            }
            if (eVar.bth == null) {
                eVar.bth = this.bta.hp();
                eVar.bte.addView(eVar.bth.bpz);
            }
            a(eVar.bth, rVar);
        }
        eVar.btg.setOnClickListener(this);
        eVar.btg.setTag(rVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bmX != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof as) {
                this.bmX.a(id, 0, view, null, (as) tag);
            }
        }
    }

    private void a(el elVar, r rVar) {
        PhotoLiveCardData rJ = rVar.rJ();
        if (rJ != null) {
            if (2 == b(rJ)) {
                elVar.bqC.setShowContent(true);
                elVar.bqC.setShowCover(false);
                elVar.bqC.setShowExpression(false);
            } else {
                elVar.bqC.setShowContent(false);
                elVar.bqC.setShowCover(true);
                elVar.bqC.setShowExpression(true);
            }
            elVar.bqC.setChooseStyle(rJ.getShowStyle());
            elVar.bqC.setShowLiveIcon(true);
            elVar.bqC.setHeadPaddingTop(t.e.ds24);
            elVar.bqC.setPortraitClicklistener(this);
            elVar.bqC.setShowImage(l.qE().qK());
            if (rJ.isShowDiffViewInSameAdapter()) {
                elVar.bqC.setShowBottom(true);
                elVar.bqC.setShowRefreshTimeInButtom(true);
                elVar.bqC.setShowHeadLiveIcon(true);
                elVar.bqC.setShowRefreshTimeInHead(false);
                elVar.bqC.setContentPaddingBottom(0);
            } else {
                elVar.bqC.setShowBottom(false);
                elVar.bqC.setShowRefreshTimeInHead(true);
                elVar.bqC.setShowHeadLiveIcon(false);
                elVar.bqC.setShowRefreshTimeInButtom(false);
                elVar.bqC.setContentPaddingBottom(t.e.ds36);
            }
            elVar.bqC.setData(rJ);
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

    private void a(dp dpVar, r rVar) {
        int i;
        if (dpVar != null && rVar != null) {
            if (dpVar.aik != this.mSkinType) {
                at.k(dpVar.bjB, t.f.frs_item_control_btn_bg);
                at.k(dpVar.bjM, t.f.frs_item_abstract_more_text_bg);
                dpVar.aik = this.mSkinType;
            }
            dpVar.bpC.setOnClickListener(this);
            dpVar.bjM.setOnClickListener(this);
            dpVar.bpC.setTag(rVar);
            dpVar.bjM.setTag(rVar);
            dpVar.bnF.setVisibility(8);
            dpVar.bpH.setVisibility(8);
            dpVar.ahr.setText(ay.w(rVar.getLast_time_int() * 1000));
            if (l.qE().qG() && rVar.getAuthor() != null) {
                dpVar.bjG.setVisibility(0);
                String portrait = rVar.getAuthor().getPortrait();
                dpVar.bjG.setUserId(rVar.getAuthor().getUserId());
                dpVar.bjG.setImageDrawable(null);
                dpVar.bjG.c(portrait, 28, false);
                dpVar.bjG.setOnClickListener(new d(this, rVar));
            } else {
                dpVar.bjG.setVisibility(8);
            }
            dpVar.ahO.setVisibility(8);
            dpVar.ahN.setVisibility(8);
            dpVar.bjF.setText(rVar.getAuthor().getName_show());
            at.b(dpVar.bjF, t.d.cp_cont_c, 1);
            s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (rVar.tA() == 1) {
                dpVar.aSh.setVisibility(8);
            } else {
                dpVar.aSh.setVisibility(0);
                rVar.parser_title();
                dpVar.aSh.setText(rVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.oh(rVar.getId())) {
                    at.b(dpVar.aSh, t.d.cp_cont_c, 1);
                } else {
                    at.b(dpVar.aSh, t.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (rVar.tu() != null && rVar.tu().trim().length() > 0) {
                stringBuffer.append(rVar.tu());
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
                        dpVar.bjM.setVisibility(0);
                        dpVar.bjC.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        dpVar.bjM.setVisibility(8);
                        dpVar.bjC.setText(stringBuffer.toString());
                    }
                    dpVar.bjC.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.oh(rVar.getId())) {
                        at.b(dpVar.bjC, t.d.cp_cont_c, 1);
                    } else {
                        at.b(dpVar.bjC, t.d.cp_cont_b, 1);
                    }
                } else {
                    dpVar.bjM.setVisibility(8);
                    dpVar.bjC.setVisibility(8);
                }
            }
            if (l.qE().qK() && medias != null && medias.size() > 0) {
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
                    dpVar.bjE.setVisibility(0);
                    dpVar.bjE.a(rVar, this.bkq.avu().getName(), this.bkq.avu().getId(), rVar.getTid());
                    dpVar.bjE.setShowBig(this.bjl);
                    dpVar.bjE.setDrawNum(true);
                    dpVar.bjE.setFromCDN(this.mIsFromCDN);
                    dpVar.bjE.a(this.bix.getPageContext(), mediaDataArr, i3);
                    dpVar.bjE.setImageFrom("other");
                } else {
                    dpVar.bjE.setVisibility(8);
                }
            } else {
                dpVar.bjE.setVisibility(8);
            }
            dpVar.bjD.setVisibility(8);
            if (rVar.getPraise() != null && rVar.getPraise().getNum() > 0) {
                dpVar.ahs.setVisibility(0);
                dpVar.ahs.setText(ay.A(rVar.getPraise().getNum()));
            } else {
                dpVar.ahs.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.af(dpVar.ahs);
            int reply_num = rVar.getReply_num();
            if (reply_num > 0) {
                dpVar.bjK.setVisibility(0);
                dpVar.bjK.setText(ay.A(reply_num));
            } else {
                dpVar.bjK.setVisibility(8);
            }
            dpVar.bpC.setVisibility(8);
        }
    }

    public void cw(boolean z) {
        if (this.bjl != z) {
            this.bjl = z;
        }
    }

    public int SZ() {
        return t.g.storecard_close_click;
    }
}
