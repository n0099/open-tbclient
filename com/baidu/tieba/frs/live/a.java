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
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.util.p;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends bm<k, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private boolean aYl;
    private com.baidu.adp.lib.f.b<dy> bho;
    private com.baidu.adp.lib.f.b<db> bhp;
    private TbPageContext<?> mPageContext;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aYl = false;
        this.bho = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.bhp = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.mPageContext = baseActivity.getPageContext();
        OP();
    }

    private void OP() {
        this.bho.k(this.bho.hb());
        this.bhp.k(this.bhp.hb());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public e a(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(n.g.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) kVar, (k) eVar);
        com.baidu.tbadk.i.a.a(this.mPageContext, view);
        if (kVar.getThreadType() == 33) {
            if (eVar.bhw != null) {
                eVar.bht.removeView(eVar.bhw.aYx);
                this.bhp.k(eVar.bhw);
                eVar.bhw = null;
            }
            if (eVar.bhx == null) {
                eVar.bhx = this.bho.hb();
                eVar.bht.addView(eVar.bhx.bez);
            }
            a(eVar.bhx, kVar);
        } else {
            if (eVar.bhx != null) {
                eVar.bht.removeView(eVar.bhx.bez);
                this.bho.k(eVar.bhx);
                eVar.bhx = null;
            }
            if (eVar.bhw == null) {
                eVar.bhw = this.bhp.hb();
                eVar.bht.addView(eVar.bhw.aYx);
            }
            a(eVar.bhw, kVar);
        }
        eVar.bhv.setOnClickListener(this);
        eVar.bhv.setTag(kVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbF != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof z) {
                this.bbF.a(id, 0, view, null, (z) tag);
            }
        }
    }

    private void a(dy dyVar, k kVar) {
        PhotoLiveCardData rQ = kVar.rQ();
        if (rQ != null) {
            if (2 == b(rQ)) {
                dyVar.beA.setShowContent(true);
                dyVar.beA.setShowCover(false);
                dyVar.beA.setShowExpression(false);
            } else {
                dyVar.beA.setShowContent(false);
                dyVar.beA.setShowCover(true);
                dyVar.beA.setShowExpression(true);
            }
            dyVar.beA.setChooseStyle(rQ.getShowStyle());
            dyVar.beA.setShowLiveIcon(true);
            dyVar.beA.setHeadPaddingTop(n.d.ds24);
            dyVar.beA.setPortraitClicklistener(this);
            dyVar.beA.setShowImage(m.rh().rn());
            if (rQ.isShowDiffViewInSameAdapter()) {
                dyVar.beA.setShowBottom(true);
                dyVar.beA.setShowRefreshTimeInButtom(true);
                dyVar.beA.setShowHeadLiveIcon(true);
                dyVar.beA.setShowRefreshTimeInHead(false);
                dyVar.beA.setContentPaddingBottom(0);
            } else {
                dyVar.beA.setShowBottom(false);
                dyVar.beA.setShowRefreshTimeInHead(true);
                dyVar.beA.setShowHeadLiveIcon(false);
                dyVar.beA.setShowRefreshTimeInButtom(false);
                dyVar.beA.setContentPaddingBottom(n.d.ds36);
            }
            dyVar.beA.setData(rQ);
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

    private void a(db dbVar, k kVar) {
        int i;
        if (dbVar != null && kVar != null) {
            if (dbVar.afY != this.mSkinType) {
                as.i(dbVar.aYy, n.e.frs_item_control_btn_bg);
                as.i((View) dbVar.aYM, n.e.frs_item_abstract_more_text_bg);
                dbVar.afY = this.mSkinType;
            }
            dbVar.bdB.setOnClickListener(this);
            dbVar.aYM.setOnClickListener(this);
            dbVar.bdB.setTag(kVar);
            dbVar.aYM.setTag(kVar);
            dbVar.bck.setVisibility(8);
            dbVar.bcl.setVisibility(8);
            dbVar.aYC.setText(ax.s(kVar.getLast_time_int() * 1000));
            if (m.rh().rj() && kVar.getAuthor() != null) {
                dbVar.aYF.setVisibility(0);
                String portrait = kVar.getAuthor().getPortrait();
                dbVar.aYF.setUserId(kVar.getAuthor().getUserId());
                dbVar.aYF.setImageDrawable(null);
                dbVar.aYF.d(portrait, 28, false);
                dbVar.aYF.setOnClickListener(new d(this, kVar));
            } else {
                dbVar.aYF.setVisibility(8);
            }
            dbVar.bdA.setVisibility(8);
            dbVar.aYE.setVisibility(8);
            dbVar.aYD.setText(kVar.getAuthor().getName_show());
            as.b(dbVar.aYD, n.c.cp_cont_c, 1);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (kVar.sS() == 1) {
                dbVar.aUB.setVisibility(8);
            } else {
                dbVar.aUB.setVisibility(0);
                kVar.parser_title();
                dbVar.aUB.setText(kVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.mF(kVar.getId())) {
                    as.b(dbVar.aUB, n.c.cp_cont_c, 1);
                } else {
                    as.b(dbVar.aUB, n.c.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (kVar.sO() != null && kVar.sO().trim().length() > 0) {
                stringBuffer.append(kVar.sO());
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
                        dbVar.aYM.setVisibility(0);
                        dbVar.aYz.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        dbVar.aYM.setVisibility(8);
                        dbVar.aYz.setText(stringBuffer.toString());
                    }
                    dbVar.aYz.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.mF(kVar.getId())) {
                        as.b(dbVar.aYz, n.c.cp_cont_c, 1);
                    } else {
                        as.b(dbVar.aYz, n.c.cp_cont_b, 1);
                    }
                } else {
                    dbVar.aYM.setVisibility(8);
                    dbVar.aYz.setVisibility(8);
                }
            }
            if (m.rh().rn() && medias != null && medias.size() > 0) {
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
                    dbVar.aYB.setVisibility(0);
                    dbVar.aYB.a(kVar, this.aZs.ajy().getName(), this.aZs.ajy().getId(), kVar.getTid());
                    dbVar.aYB.setShowBig(this.aYl);
                    dbVar.aYB.setDrawNum(true);
                    dbVar.aYB.setFromCDN(this.mIsFromCDN);
                    dbVar.aYB.a(this.aXA.getPageContext(), mediaDataArr, i3);
                    dbVar.aYB.setImageFrom("other");
                } else {
                    dbVar.aYB.setVisibility(8);
                }
            } else {
                dbVar.aYB.setVisibility(8);
            }
            dbVar.aYA.setVisibility(8);
            if (kVar.getPraise() != null && kVar.getPraise().getNum() > 0) {
                dbVar.aYI.setVisibility(0);
                dbVar.aYI.setText(ax.w(kVar.getPraise().getNum()));
            } else {
                dbVar.aYI.setVisibility(8);
            }
            int reply_num = kVar.getReply_num();
            if (reply_num > 0) {
                dbVar.aYK.setVisibility(0);
                dbVar.aYK.setText(ax.w(reply_num));
            } else {
                dbVar.aYK.setVisibility(8);
            }
            dbVar.bdB.setVisibility(8);
        }
    }

    public void ck(boolean z) {
        if (this.aYl != z) {
            this.aYl = z;
        }
    }

    public int OQ() {
        return n.f.storecard_close_click;
    }
}
