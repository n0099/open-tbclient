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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends bv<n, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> Nw;
    private boolean bez;
    private com.baidu.adp.lib.f.b<ed> boc;
    private com.baidu.adp.lib.f.b<dj> bod;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bez = false;
        this.boc = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.bod = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.Nw = baseActivity.getPageContext();
        Rl();
    }

    private void Rl() {
        this.boc.k(this.boc.hj());
        this.bod.k(this.bod.hj());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public e b(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(t.h.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, n nVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) nVar, (n) eVar);
        com.baidu.tbadk.i.a.a(this.Nw, view);
        if (nVar.getThreadType() == 33) {
            if (eVar.bok != null) {
                eVar.boh.removeView(eVar.bok.beO);
                this.bod.k(eVar.bok);
                eVar.bok = null;
            }
            if (eVar.bol == null) {
                eVar.bol = this.boc.hj();
                eVar.boh.addView(eVar.bol.blj);
                eVar.bol.xf();
            }
            a(eVar.bol, nVar);
        } else {
            if (eVar.bol != null) {
                eVar.boh.removeView(eVar.bol.blj);
                this.boc.k(eVar.bol);
                eVar.bol = null;
            }
            if (eVar.bok == null) {
                eVar.bok = this.bod.hj();
                eVar.boh.addView(eVar.bok.beO);
            }
            a(eVar.bok, nVar);
        }
        eVar.boj.setOnClickListener(this);
        eVar.boj.setTag(nVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bim != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof ah) {
                this.bim.a(id, 0, view, null, (ah) tag);
            }
        }
    }

    private void a(ed edVar, n nVar) {
        PhotoLiveCardData sd = nVar.sd();
        if (sd != null) {
            if (2 == b(sd)) {
                edVar.blk.setShowContent(true);
                edVar.blk.setShowCover(false);
                edVar.blk.setShowExpression(false);
            } else {
                edVar.blk.setShowContent(false);
                edVar.blk.setShowCover(true);
                edVar.blk.setShowExpression(true);
            }
            edVar.blk.setChooseStyle(sd.getShowStyle());
            edVar.blk.setShowLiveIcon(true);
            edVar.blk.setHeadPaddingTop(t.e.ds24);
            edVar.blk.setPortraitClicklistener(this);
            edVar.blk.setShowImage(l.rn().rt());
            if (sd.isShowDiffViewInSameAdapter()) {
                edVar.blk.setShowBottom(true);
                edVar.blk.setShowRefreshTimeInButtom(true);
                edVar.blk.setShowHeadLiveIcon(true);
                edVar.blk.setShowRefreshTimeInHead(false);
                edVar.blk.setContentPaddingBottom(0);
            } else {
                edVar.blk.setShowBottom(false);
                edVar.blk.setShowRefreshTimeInHead(true);
                edVar.blk.setShowHeadLiveIcon(false);
                edVar.blk.setShowRefreshTimeInButtom(false);
                edVar.blk.setContentPaddingBottom(t.e.ds36);
            }
            edVar.blk.setData(sd);
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

    private void a(dj djVar, n nVar) {
        int i;
        if (djVar != null && nVar != null) {
            if (djVar.ahU != this.mSkinType) {
                ar.k(djVar.beP, t.f.frs_item_control_btn_bg);
                ar.k(djVar.bfa, t.f.frs_item_abstract_more_text_bg);
                djVar.ahU = this.mSkinType;
            }
            djVar.bkn.setOnClickListener(this);
            djVar.bfa.setOnClickListener(this);
            djVar.bkn.setTag(nVar);
            djVar.bfa.setTag(nVar);
            djVar.biV.setVisibility(8);
            djVar.bks.setVisibility(8);
            djVar.ahm.setText(aw.t(nVar.getLast_time_int() * 1000));
            if (l.rn().rp() && nVar.getAuthor() != null) {
                djVar.beU.setVisibility(0);
                String portrait = nVar.getAuthor().getPortrait();
                djVar.beU.setUserId(nVar.getAuthor().getUserId());
                djVar.beU.setImageDrawable(null);
                djVar.beU.d(portrait, 28, false);
                djVar.beU.setOnClickListener(new d(this, nVar));
            } else {
                djVar.beU.setVisibility(8);
            }
            djVar.ahJ.setVisibility(8);
            djVar.ahI.setVisibility(8);
            djVar.beT.setText(nVar.getAuthor().getName_show());
            ar.b(djVar.beT, t.d.cp_cont_c, 1);
            r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (nVar.tx() == 1) {
                djVar.aPr.setVisibility(8);
            } else {
                djVar.aPr.setVisibility(0);
                nVar.parser_title();
                djVar.aPr.setText(nVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.mU(nVar.getId())) {
                    ar.b(djVar.aPr, t.d.cp_cont_c, 1);
                } else {
                    ar.b(djVar.aPr, t.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (nVar.tr() != null && nVar.tr().trim().length() > 0) {
                stringBuffer.append(nVar.tr());
            }
            ArrayList<MediaData> medias = nVar.getMedias();
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
                        djVar.bfa.setVisibility(0);
                        djVar.beQ.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        djVar.bfa.setVisibility(8);
                        djVar.beQ.setText(stringBuffer.toString());
                    }
                    djVar.beQ.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.mU(nVar.getId())) {
                        ar.b(djVar.beQ, t.d.cp_cont_c, 1);
                    } else {
                        ar.b(djVar.beQ, t.d.cp_cont_b, 1);
                    }
                } else {
                    djVar.bfa.setVisibility(8);
                    djVar.beQ.setVisibility(8);
                }
            }
            if (l.rn().rt() && medias != null && medias.size() > 0) {
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
                    djVar.beS.setVisibility(0);
                    djVar.beS.a(nVar, this.bfF.aoE().getName(), this.bfF.aoE().getId(), nVar.getTid());
                    djVar.beS.setShowBig(this.bez);
                    djVar.beS.setDrawNum(true);
                    djVar.beS.setFromCDN(this.mIsFromCDN);
                    djVar.beS.a(this.bdK.getPageContext(), mediaDataArr, i3);
                    djVar.beS.setImageFrom("other");
                } else {
                    djVar.beS.setVisibility(8);
                }
            } else {
                djVar.beS.setVisibility(8);
            }
            djVar.beR.setVisibility(8);
            if (nVar.getPraise() != null && nVar.getPraise().getNum() > 0) {
                djVar.ahn.setVisibility(0);
                djVar.ahn.setText(aw.y(nVar.getPraise().getNum()));
            } else {
                djVar.ahn.setVisibility(8);
            }
            int reply_num = nVar.getReply_num();
            if (reply_num > 0) {
                djVar.beY.setVisibility(0);
                djVar.beY.setText(aw.y(reply_num));
            } else {
                djVar.beY.setVisibility(8);
            }
            djVar.bkn.setVisibility(8);
        }
    }

    public void ck(boolean z) {
        if (this.bez != z) {
            this.bez = z;
        }
    }

    public int Rm() {
        return t.g.storecard_close_click;
    }
}
