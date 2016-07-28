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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.v;
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
public class a extends bj<v, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> EA;
    private boolean bKF;
    private com.baidu.adp.lib.f.b<cy> bRf;
    private com.baidu.adp.lib.f.b<ce> bRg;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bKF = false;
        this.bRf = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.bRg = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.EA = baseActivity.getPageContext();
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
    public View a(int i, View view, ViewGroup viewGroup, v vVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) vVar, (v) eVar);
        com.baidu.tbadk.j.a.a(this.EA, view);
        if (vVar.getThreadType() == 33) {
            if (eVar.bRn != null) {
                eVar.bRk.removeView(eVar.bRn.bHd);
                this.bRg.n(eVar.bRn);
                eVar.bRn = null;
            }
            if (eVar.bRo == null) {
                eVar.bRo = this.bRf.dD();
                eVar.bRk.addView(eVar.bRo.bId);
                eVar.bRo.vm();
            }
            a(eVar.bRo, vVar);
        } else {
            if (eVar.bRo != null) {
                eVar.bRk.removeView(eVar.bRo.bId);
                this.bRf.n(eVar.bRo);
                eVar.bRo = null;
            }
            if (eVar.bRn == null) {
                eVar.bRn = this.bRg.dD();
                eVar.bRk.addView(eVar.bRn.bHd);
            }
            a(eVar.bRn, vVar);
        }
        eVar.bRm.setOnClickListener(this);
        eVar.bRm.setTag(vVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bFF != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof be) {
                this.bFF.a(id, 0, view, null, (be) tag);
            }
        }
    }

    private void a(cy cyVar, v vVar) {
        PhotoLiveCardData oJ = vVar.oJ();
        if (oJ != null) {
            if (2 == b(oJ)) {
                cyVar.bIe.setShowContent(true);
                cyVar.bIe.setShowCover(false);
                cyVar.bIe.setShowExpression(false);
            } else {
                cyVar.bIe.setShowContent(false);
                cyVar.bIe.setShowCover(true);
                cyVar.bIe.setShowExpression(true);
            }
            cyVar.bIe.setChooseStyle(oJ.getShowStyle());
            cyVar.bIe.setShowLiveIcon(true);
            cyVar.bIe.setHeadPaddingTop(u.e.ds24);
            cyVar.bIe.setPortraitClicklistener(this);
            cyVar.bIe.setShowImage(l.nL().nR());
            if (oJ.isShowDiffViewInSameAdapter()) {
                cyVar.bIe.setShowBottom(true);
                cyVar.bIe.setShowRefreshTimeInButtom(true);
                cyVar.bIe.setShowHeadLiveIcon(true);
                cyVar.bIe.setShowRefreshTimeInHead(false);
                cyVar.bIe.setContentPaddingBottom(0);
            } else {
                cyVar.bIe.setShowBottom(false);
                cyVar.bIe.setShowRefreshTimeInHead(true);
                cyVar.bIe.setShowHeadLiveIcon(false);
                cyVar.bIe.setShowRefreshTimeInButtom(false);
                cyVar.bIe.setContentPaddingBottom(u.e.ds36);
            }
            cyVar.bIe.setData(oJ);
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

    private void a(ce ceVar, v vVar) {
        int i;
        if (ceVar != null && vVar != null) {
            if (ceVar.afy != this.mSkinType) {
                av.k(ceVar.bHe, u.f.frs_item_control_btn_bg);
                av.k(ceVar.bHn, u.f.frs_item_abstract_more_text_bg);
                ceVar.afy = this.mSkinType;
            }
            ceVar.bHm.setOnClickListener(this);
            ceVar.bHn.setOnClickListener(this);
            ceVar.bHm.setTag(vVar);
            ceVar.bHn.setTag(vVar);
            ceVar.bGa.setVisibility(8);
            ceVar.bHs.setVisibility(8);
            ceVar.aes.setText(ba.t(vVar.qs() * 1000));
            if (l.nL().nN() && vVar.getAuthor() != null) {
                ceVar.bHl.setVisibility(0);
                String portrait = vVar.getAuthor().getPortrait();
                ceVar.bHl.setUserId(vVar.getAuthor().getUserId());
                ceVar.bHl.setImageDrawable(null);
                ceVar.bHl.c(portrait, 28, false);
                ceVar.bHl.setOnClickListener(new d(this, vVar));
            } else {
                ceVar.bHl.setVisibility(8);
            }
            ceVar.aeU.setVisibility(8);
            ceVar.aeT.setVisibility(8);
            ceVar.bHk.setText(vVar.getAuthor().getName_show());
            av.c(ceVar.bHk, u.d.cp_cont_c, 1);
            s readThreadHistory = TbadkCoreApplication.m10getInst().getReadThreadHistory();
            if (vVar.qK() == 1) {
                ceVar.aSZ.setVisibility(8);
            } else {
                ceVar.aSZ.setVisibility(0);
                vVar.rd();
                ceVar.aSZ.setText(vVar.qV());
                if (readThreadHistory != null && readThreadHistory.qv(vVar.getId())) {
                    av.c(ceVar.aSZ, u.d.cp_cont_c, 1);
                } else {
                    av.c(ceVar.aSZ, u.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (vVar.qD() != null && vVar.qD().trim().length() > 0) {
                stringBuffer.append(vVar.qD());
            }
            ArrayList<MediaData> qF = vVar.qF();
            if (qF != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i2 = 0; i2 < qF.size(); i2++) {
                    if (qF.get(i2).getVideoUrl() != null && qF.get(i2).getVideoUrl().endsWith("swf")) {
                        stringBuffer2.append(qF.get(i2).getVideoUrl());
                    }
                }
                stringBuffer.append(stringBuffer2.toString());
                if (stringBuffer.length() > 0) {
                    if (stringBuffer.length() > 170) {
                        ceVar.bHn.setVisibility(0);
                        ceVar.bHh.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                    } else {
                        ceVar.bHn.setVisibility(8);
                        ceVar.bHh.setText(stringBuffer.toString());
                    }
                    ceVar.bHh.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.qv(vVar.getId())) {
                        av.c(ceVar.bHh, u.d.cp_cont_c, 1);
                    } else {
                        av.c(ceVar.bHh, u.d.cp_cont_b, 1);
                    }
                } else {
                    ceVar.bHn.setVisibility(8);
                    ceVar.bHh.setVisibility(8);
                }
            }
            if (l.nL().nR() && qF != null && qF.size() > 0) {
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < qF.size(); i5++) {
                    if (qF.get(i5) != null && (qF.get(i5).getType() == 3 || qF.get(i5).getType() == 5)) {
                        i4++;
                        i3++;
                    }
                }
                if (i4 > 0) {
                    MediaData[] mediaDataArr = new MediaData[i4];
                    int i6 = 0;
                    int i7 = 0;
                    while (i7 < qF.size() && i6 < i4) {
                        if (qF.get(i7).getType() == 3 || qF.get(i7).getType() == 5) {
                            mediaDataArr[i6] = qF.get(i7);
                            i = i6 + 1;
                        } else {
                            i = i6;
                        }
                        i7++;
                        i6 = i;
                    }
                    ceVar.bHj.setVisibility(0);
                    ceVar.bHj.a(vVar, this.bDM.aGX().getName(), this.bDM.aGX().getId(), vVar.getTid());
                    ceVar.bHj.setShowBig(this.bKF);
                    ceVar.bHj.setDrawNum(true);
                    ceVar.bHj.setFromCDN(this.mIsFromCDN);
                    ceVar.bHj.a(this.bem.getPageContext(), mediaDataArr, i3);
                    ceVar.bHj.setImageFrom("other");
                } else {
                    ceVar.bHj.setVisibility(8);
                }
            } else {
                ceVar.bHj.setVisibility(8);
            }
            ceVar.bHi.setVisibility(8);
            if (vVar.qp() != null && vVar.qp().getNum() > 0) {
                ceVar.aev.setVisibility(0);
                ceVar.aev.setText(ba.y(vVar.qp().getNum()));
            } else {
                ceVar.aev.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.al(ceVar.aev);
            int qr = vVar.qr();
            if (qr > 0) {
                ceVar.bGb.setVisibility(0);
                ceVar.bGb.setText(ba.y(qr));
            } else {
                ceVar.bGb.setVisibility(8);
            }
            ceVar.bHm.setVisibility(8);
        }
    }

    public void dx(boolean z) {
        if (this.bKF != z) {
            this.bKF = z;
        }
    }

    public int ZT() {
        return u.g.storecard_close_click;
    }
}
