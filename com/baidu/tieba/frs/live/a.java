package com.baidu.tieba.frs.live;

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
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.util.q;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends bp<k, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private boolean bck;
    private com.baidu.adp.lib.f.b<dy> blf;
    private com.baidu.adp.lib.f.b<de> blg;
    private TbPageContext<?> mPageContext;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bck = false;
        this.blf = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.blg = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.mPageContext = baseActivity.getPageContext();
        Ph();
    }

    private void Ph() {
        this.blf.k(this.blf.hb());
        this.blg.k(this.blg.hb());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: G */
    public e a(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(n.h.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bp, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) kVar, (k) eVar);
        com.baidu.tbadk.i.a.a(this.mPageContext, view);
        if (kVar.getThreadType() == 33) {
            if (eVar.bln != null) {
                eVar.blk.removeView(eVar.bln.bcw);
                this.blg.k(eVar.bln);
                eVar.bln = null;
            }
            if (eVar.blo == null) {
                eVar.blo = this.blf.hb();
                eVar.blk.addView(eVar.blo.bit);
            }
            a(eVar.blo, kVar);
        } else {
            if (eVar.blo != null) {
                eVar.blk.removeView(eVar.blo.bit);
                this.blf.k(eVar.blo);
                eVar.blo = null;
            }
            if (eVar.bln == null) {
                eVar.bln = this.blg.hb();
                eVar.blk.addView(eVar.bln.bcw);
            }
            a(eVar.bln, kVar);
        }
        eVar.blm.setOnClickListener(this);
        eVar.blm.setTag(kVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bfE != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof z) {
                this.bfE.a(id, 0, view, null, (z) tag);
            }
        }
    }

    private void a(dy dyVar, k kVar) {
        PhotoLiveCardData rz = kVar.rz();
        if (rz != null) {
            if (2 == b(rz)) {
                dyVar.biu.setShowContent(true);
                dyVar.biu.setShowCover(false);
                dyVar.biu.setShowExpression(false);
            } else {
                dyVar.biu.setShowContent(false);
                dyVar.biu.setShowCover(true);
                dyVar.biu.setShowExpression(true);
            }
            dyVar.biu.setChooseStyle(rz.getShowStyle());
            dyVar.biu.setShowLiveIcon(true);
            dyVar.biu.setHeadPaddingTop(n.e.ds24);
            dyVar.biu.setPortraitClicklistener(this);
            dyVar.biu.setShowImage(m.qQ().qW());
            if (rz.isShowDiffViewInSameAdapter()) {
                dyVar.biu.setShowBottom(true);
                dyVar.biu.setShowRefreshTimeInButtom(true);
                dyVar.biu.setShowHeadLiveIcon(true);
                dyVar.biu.setShowRefreshTimeInHead(false);
                dyVar.biu.setContentPaddingBottom(0);
            } else {
                dyVar.biu.setShowBottom(false);
                dyVar.biu.setShowRefreshTimeInHead(true);
                dyVar.biu.setShowHeadLiveIcon(false);
                dyVar.biu.setShowRefreshTimeInButtom(false);
                dyVar.biu.setContentPaddingBottom(n.e.ds36);
            }
            dyVar.biu.setData(rz);
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

    private void a(de deVar, k kVar) {
        int i;
        if (deVar != null && kVar != null) {
            if (deVar.ahf != this.mSkinType) {
                as.i(deVar.bcx, n.f.frs_item_control_btn_bg);
                as.i((View) deVar.bcI, n.f.frs_item_abstract_more_text_bg);
                deVar.ahf = this.mSkinType;
            }
            deVar.bhA.setOnClickListener(this);
            deVar.bcI.setOnClickListener(this);
            deVar.bhA.setTag(kVar);
            deVar.bcI.setTag(kVar);
            deVar.bgj.setVisibility(8);
            deVar.bgk.setVisibility(8);
            deVar.agy.setText(ax.s(kVar.getLast_time_int() * 1000));
            if (m.qQ().qS() && kVar.getAuthor() != null) {
                deVar.bcC.setVisibility(0);
                String portrait = kVar.getAuthor().getPortrait();
                deVar.bcC.setUserId(kVar.getAuthor().getUserId());
                deVar.bcC.setImageDrawable(null);
                deVar.bcC.d(portrait, 28, false);
                deVar.bcC.setOnClickListener(new d(this, kVar));
            } else {
                deVar.bcC.setVisibility(8);
            }
            deVar.agU.setVisibility(8);
            deVar.agT.setVisibility(8);
            deVar.bcB.setText(kVar.getAuthor().getName_show());
            as.b(deVar.bcB, n.d.cp_cont_c, 1);
            q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (kVar.sC() == 1) {
                deVar.aOn.setVisibility(8);
            } else {
                deVar.aOn.setVisibility(0);
                kVar.parser_title();
                deVar.aOn.setText(kVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.mC(kVar.getId())) {
                    as.b(deVar.aOn, n.d.cp_cont_c, 1);
                } else {
                    as.b(deVar.aOn, n.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (kVar.sy() != null && kVar.sy().trim().length() > 0) {
                stringBuffer.append(kVar.sy());
            }
            ArrayList<MediaData> medias = kVar.getMedias();
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
                        deVar.bcI.setVisibility(0);
                        deVar.bcy.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        deVar.bcI.setVisibility(8);
                        deVar.bcy.setText(stringBuffer.toString());
                    }
                    deVar.bcy.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.mC(kVar.getId())) {
                        as.b(deVar.bcy, n.d.cp_cont_c, 1);
                    } else {
                        as.b(deVar.bcy, n.d.cp_cont_b, 1);
                    }
                } else {
                    deVar.bcI.setVisibility(8);
                    deVar.bcy.setVisibility(8);
                }
            }
            if (m.qQ().qW() && medias != null && medias.size() > 0) {
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
                    deVar.bcA.setVisibility(0);
                    deVar.bcA.a(kVar, this.bdo.akG().getName(), this.bdo.akG().getId(), kVar.getTid());
                    deVar.bcA.setShowBig(this.bck);
                    deVar.bcA.setDrawNum(true);
                    deVar.bcA.setFromCDN(this.mIsFromCDN);
                    deVar.bcA.a(this.bbA.getPageContext(), mediaDataArr, i3);
                    deVar.bcA.setImageFrom("other");
                } else {
                    deVar.bcA.setVisibility(8);
                }
            } else {
                deVar.bcA.setVisibility(8);
            }
            deVar.bcz.setVisibility(8);
            if (kVar.getPraise() != null && kVar.getPraise().getNum() > 0) {
                deVar.agz.setVisibility(0);
                deVar.agz.setText(ax.x(kVar.getPraise().getNum()));
            } else {
                deVar.agz.setVisibility(8);
            }
            int reply_num = kVar.getReply_num();
            if (reply_num > 0) {
                deVar.bcG.setVisibility(0);
                deVar.bcG.setText(ax.x(reply_num));
            } else {
                deVar.bcG.setVisibility(8);
            }
            deVar.bhA.setVisibility(8);
        }
    }

    public void cl(boolean z) {
        if (this.bck != z) {
            this.bck = z;
        }
    }

    public int Pi() {
        return n.g.storecard_close_click;
    }
}
