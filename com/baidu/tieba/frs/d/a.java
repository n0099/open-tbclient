package com.baidu.tieba.frs.d;

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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends bj<t, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> Ea;
    private boolean bBx;
    private com.baidu.adp.lib.f.b<cy> bPs;
    private com.baidu.adp.lib.f.b<ce> bPt;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bBx = false;
        this.bPs = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.bPt = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.Ea = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public e a(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(u.h.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, t tVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) tVar, (t) eVar);
        com.baidu.tbadk.j.a.a(this.Ea, view);
        if (tVar.getThreadType() == 33) {
            if (eVar.bPA != null) {
                eVar.bPx.removeView(eVar.bPA.bFP);
                this.bPt.k(eVar.bPA);
                eVar.bPA = null;
            }
            if (eVar.bPB == null) {
                eVar.bPB = this.bPs.dE();
                eVar.bPx.addView(eVar.bPB.bGH);
                eVar.bPB.vm();
            }
            a(eVar.bPB, tVar);
        } else {
            if (eVar.bPB != null) {
                eVar.bPx.removeView(eVar.bPB.bGH);
                this.bPs.k(eVar.bPB);
                eVar.bPB = null;
            }
            if (eVar.bPA == null) {
                eVar.bPA = this.bPt.dE();
                eVar.bPx.addView(eVar.bPA.bFP);
            }
            a(eVar.bPA, tVar);
        }
        eVar.bPz.setOnClickListener(this);
        eVar.bPz.setTag(tVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bEt != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof az) {
                this.bEt.a(id, 0, view, null, (az) tag);
            }
        }
    }

    private void a(cy cyVar, t tVar) {
        PhotoLiveCardData oU = tVar.oU();
        if (oU != null) {
            if (2 == b(oU)) {
                cyVar.bGI.setShowContent(true);
                cyVar.bGI.setShowCover(false);
                cyVar.bGI.setShowExpression(false);
            } else {
                cyVar.bGI.setShowContent(false);
                cyVar.bGI.setShowCover(true);
                cyVar.bGI.setShowExpression(true);
            }
            cyVar.bGI.setChooseStyle(oU.getShowStyle());
            cyVar.bGI.setShowLiveIcon(true);
            cyVar.bGI.setHeadPaddingTop(u.e.ds24);
            cyVar.bGI.setPortraitClicklistener(this);
            cyVar.bGI.setShowImage(l.nW().oc());
            if (oU.isShowDiffViewInSameAdapter()) {
                cyVar.bGI.setShowBottom(true);
                cyVar.bGI.setShowRefreshTimeInButtom(true);
                cyVar.bGI.setShowHeadLiveIcon(true);
                cyVar.bGI.setShowRefreshTimeInHead(false);
                cyVar.bGI.setContentPaddingBottom(0);
            } else {
                cyVar.bGI.setShowBottom(false);
                cyVar.bGI.setShowRefreshTimeInHead(true);
                cyVar.bGI.setShowHeadLiveIcon(false);
                cyVar.bGI.setShowRefreshTimeInButtom(false);
                cyVar.bGI.setContentPaddingBottom(u.e.ds36);
            }
            cyVar.bGI.setData(oU);
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

    private void a(ce ceVar, t tVar) {
        int i;
        if (ceVar != null && tVar != null) {
            if (ceVar.aeK != this.mSkinType) {
                av.k(ceVar.bBN, u.f.frs_item_control_btn_bg);
                av.k(ceVar.bBY, u.f.frs_item_abstract_more_text_bg);
                ceVar.aeK = this.mSkinType;
            }
            ceVar.bFS.setOnClickListener(this);
            ceVar.bBY.setOnClickListener(this);
            ceVar.bFS.setTag(tVar);
            ceVar.bBY.setTag(tVar);
            ceVar.bEN.setVisibility(8);
            ceVar.bFX.setVisibility(8);
            ceVar.adE.setText(ba.y(tVar.getLast_time_int() * 1000));
            if (l.nW().nY() && tVar.getAuthor() != null) {
                ceVar.bBS.setVisibility(0);
                String portrait = tVar.getAuthor().getPortrait();
                ceVar.bBS.setUserId(tVar.getAuthor().getUserId());
                ceVar.bBS.setImageDrawable(null);
                ceVar.bBS.c(portrait, 28, false);
                ceVar.bBS.setOnClickListener(new d(this, tVar));
            } else {
                ceVar.bBS.setVisibility(8);
            }
            ceVar.aeg.setVisibility(8);
            ceVar.aef.setVisibility(8);
            ceVar.bBR.setText(tVar.getAuthor().getName_show());
            av.c(ceVar.bBR, u.d.cp_cont_c, 1);
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (tVar.qU() == 1) {
                ceVar.aSd.setVisibility(8);
            } else {
                ceVar.aSd.setVisibility(0);
                tVar.parser_title();
                ceVar.aSd.setText(tVar.getSpan_str());
                if (readThreadHistory != null && readThreadHistory.pL(tVar.getId())) {
                    av.c(ceVar.aSd, u.d.cp_cont_c, 1);
                } else {
                    av.c(ceVar.aSd, u.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (tVar.qO() != null && tVar.qO().trim().length() > 0) {
                stringBuffer.append(tVar.qO());
            }
            ArrayList<MediaData> medias = tVar.getMedias();
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
                        ceVar.bBY.setVisibility(0);
                        ceVar.bBO.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        ceVar.bBY.setVisibility(8);
                        ceVar.bBO.setText(stringBuffer.toString());
                    }
                    ceVar.bBO.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.pL(tVar.getId())) {
                        av.c(ceVar.bBO, u.d.cp_cont_c, 1);
                    } else {
                        av.c(ceVar.bBO, u.d.cp_cont_b, 1);
                    }
                } else {
                    ceVar.bBY.setVisibility(8);
                    ceVar.bBO.setVisibility(8);
                }
            }
            if (l.nW().oc() && medias != null && medias.size() > 0) {
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
                    ceVar.bBQ.setVisibility(0);
                    ceVar.bBQ.a(tVar, this.bCF.aDN().getName(), this.bCF.aDN().getId(), tVar.getTid());
                    ceVar.bBQ.setShowBig(this.bBx);
                    ceVar.bBQ.setDrawNum(true);
                    ceVar.bBQ.setFromCDN(this.mIsFromCDN);
                    ceVar.bBQ.a(this.bkc.getPageContext(), mediaDataArr, i3);
                    ceVar.bBQ.setImageFrom("other");
                } else {
                    ceVar.bBQ.setVisibility(8);
                }
            } else {
                ceVar.bBQ.setVisibility(8);
            }
            ceVar.bBP.setVisibility(8);
            if (tVar.getPraise() != null && tVar.getPraise().getNum() > 0) {
                ceVar.adH.setVisibility(0);
                ceVar.adH.setText(ba.D(tVar.getPraise().getNum()));
            } else {
                ceVar.adH.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.an(ceVar.adH);
            int reply_num = tVar.getReply_num();
            if (reply_num > 0) {
                ceVar.bBW.setVisibility(0);
                ceVar.bBW.setText(ba.D(reply_num));
            } else {
                ceVar.bBW.setVisibility(8);
            }
            ceVar.bFS.setVisibility(8);
        }
    }

    public void db(boolean z) {
        if (this.bBx != z) {
            this.bBx = z;
        }
    }

    public int Zx() {
        return u.g.storecard_close_click;
    }
}
