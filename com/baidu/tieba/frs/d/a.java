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
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.r;
import com.baidu.tieba.view.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends aq<aa, e> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> GO;
    private boolean bYY;
    private com.baidu.adp.lib.f.b<bs> cfO;
    private com.baidu.adp.lib.f.b<bf> cfP;

    public a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bYY = false;
        this.cfO = new com.baidu.adp.lib.f.b<>(new b(this), 5, 0);
        this.cfP = new com.baidu.adp.lib.f.b<>(new c(this), 5, 0);
        this.GO = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public e a(ViewGroup viewGroup) {
        return new e(LayoutInflater.from(this.mContext).inflate(r.h.frs_item_store_card, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.aq, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, aa aaVar, e eVar) {
        super.a(i, view, viewGroup, (ViewGroup) aaVar, (aa) eVar);
        com.baidu.tbadk.i.a.a(this.GO, view);
        if (aaVar.getThreadType() == 33) {
            if (eVar.cfW != null) {
                eVar.cfT.removeView(eVar.cfW.bUp);
                this.cfP.n(eVar.cfW);
                eVar.cfW = null;
            }
            if (eVar.cfX == null) {
                eVar.cfX = this.cfO.ey();
                eVar.cfT.addView(eVar.cfX.bVi);
                eVar.cfX.wM();
            }
            a(eVar.cfX, aaVar);
        } else {
            if (eVar.cfX != null) {
                eVar.cfT.removeView(eVar.cfX.bVi);
                this.cfO.n(eVar.cfX);
                eVar.cfX = null;
            }
            if (eVar.cfW == null) {
                eVar.cfW = this.cfP.ey();
                eVar.cfT.addView(eVar.cfW.bUp);
            }
            a(eVar.cfW, aaVar);
        }
        eVar.cfV.setOnClickListener(this);
        eVar.cfV.setTag(aaVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bTo != null && view != null) {
            int id = view.getId();
            Object tag = view.getTag();
            if (tag instanceof bk) {
                this.bTo.a(id, 0, view, null, (bk) tag);
            }
        }
    }

    private void a(bs bsVar, aa aaVar) {
        PhotoLiveCardData qa = aaVar.qa();
        if (qa != null) {
            if (2 == b(qa)) {
                bsVar.bVj.setShowContent(true);
                bsVar.bVj.setShowCover(false);
                bsVar.bVj.setShowExpression(false);
            } else {
                bsVar.bVj.setShowContent(false);
                bsVar.bVj.setShowCover(true);
                bsVar.bVj.setShowExpression(true);
            }
            bsVar.bVj.setChooseStyle(qa.getShowStyle());
            bsVar.bVj.setShowLiveIcon(true);
            bsVar.bVj.setHeadPaddingTop(r.e.ds24);
            bsVar.bVj.setPortraitClicklistener(this);
            bsVar.bVj.setShowImage(l.oJ().oP());
            if (qa.isShowDiffViewInSameAdapter()) {
                bsVar.bVj.setShowBottom(true);
                bsVar.bVj.setShowRefreshTimeInButtom(true);
                bsVar.bVj.setShowHeadLiveIcon(true);
                bsVar.bVj.setShowRefreshTimeInHead(false);
                bsVar.bVj.setContentPaddingBottom(0);
            } else {
                bsVar.bVj.setShowBottom(false);
                bsVar.bVj.setShowRefreshTimeInHead(true);
                bsVar.bVj.setShowHeadLiveIcon(false);
                bsVar.bVj.setShowRefreshTimeInButtom(false);
                bsVar.bVj.setContentPaddingBottom(r.e.ds36);
            }
            bsVar.bVj.setData(qa);
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

    private void a(bf bfVar, aa aaVar) {
        int i;
        if (bfVar != null && aaVar != null) {
            if (bfVar.aiA != this.mSkinType) {
                at.k(bfVar.bUq, r.f.frs_item_control_btn_bg);
                at.k(bfVar.bUz, r.f.frs_item_abstract_more_text_bg);
                bfVar.aiA = this.mSkinType;
            }
            bfVar.bUy.setOnClickListener(this);
            bfVar.bUz.setOnClickListener(this);
            bfVar.bUy.setTag(aaVar);
            bfVar.bUz.setTag(aaVar);
            bfVar.bTt.setVisibility(8);
            bfVar.bUE.setVisibility(8);
            bfVar.ahw.setText(ax.s(aaVar.rK() * 1000));
            if (l.oJ().oL() && aaVar.getAuthor() != null) {
                bfVar.bUx.setVisibility(0);
                String portrait = aaVar.getAuthor().getPortrait();
                bfVar.bUx.setUserId(aaVar.getAuthor().getUserId());
                bfVar.bUx.setImageDrawable(null);
                bfVar.bUx.c(portrait, 28, false);
                bfVar.bUx.setOnClickListener(new d(this, aaVar));
            } else {
                bfVar.bUx.setVisibility(8);
            }
            bfVar.ahX.setVisibility(8);
            bfVar.ahW.setVisibility(8);
            bfVar.bUw.setText(aaVar.getAuthor().getName_show());
            at.c(bfVar.bUw, r.d.cp_cont_c, 1);
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (aaVar.sd() == 1) {
                bfVar.aOH.setVisibility(8);
            } else {
                bfVar.aOH.setVisibility(0);
                aaVar.sw();
                SpannableStringBuilder so = aaVar.so();
                bfVar.aOH.setOnTouchListener(new x(so));
                bfVar.aOH.setText(so);
                if (readThreadHistory != null && readThreadHistory.rP(aaVar.getId())) {
                    at.c(bfVar.aOH, r.d.cp_cont_c, 1);
                } else {
                    at.c(bfVar.aOH, r.d.cp_cont_b, 1);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (aaVar.rW() != null && aaVar.rW().trim().length() > 0) {
                stringBuffer.append(aaVar.rW());
            }
            ArrayList<MediaData> rY = aaVar.rY();
            if (rY != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i2 = 0; i2 < rY.size(); i2++) {
                    if (rY.get(i2).getVideoUrl() != null && rY.get(i2).getVideoUrl().endsWith("swf")) {
                        stringBuffer2.append(rY.get(i2).getVideoUrl());
                    }
                }
                stringBuffer.append(stringBuffer2.toString());
                if (!TextUtils.isEmpty(aaVar.g(stringBuffer.toString(), true))) {
                    if (stringBuffer.length() > 170) {
                        bfVar.bUz.setVisibility(0);
                    } else {
                        bfVar.bUz.setVisibility(8);
                    }
                    SpannableString cy = aaVar.cy(stringBuffer.toString());
                    bfVar.bUt.setOnTouchListener(new x(cy));
                    bfVar.bUt.setText(cy);
                    bfVar.bUt.setVisibility(0);
                    if (readThreadHistory != null && readThreadHistory.rP(aaVar.getId())) {
                        at.c(bfVar.bUt, r.d.cp_cont_c, 1);
                    } else {
                        at.c(bfVar.bUt, r.d.cp_cont_b, 1);
                    }
                } else {
                    bfVar.bUz.setVisibility(8);
                    bfVar.bUt.setVisibility(8);
                }
            }
            if (l.oJ().oP() && rY != null && rY.size() > 0) {
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < rY.size(); i5++) {
                    if (rY.get(i5) != null && (rY.get(i5).getType() == 3 || rY.get(i5).getType() == 5)) {
                        i4++;
                        i3++;
                    }
                }
                if (i4 > 0) {
                    MediaData[] mediaDataArr = new MediaData[i4];
                    int i6 = 0;
                    int i7 = 0;
                    while (i7 < rY.size() && i6 < i4) {
                        if (rY.get(i7).getType() == 3 || rY.get(i7).getType() == 5) {
                            mediaDataArr[i6] = rY.get(i7);
                            i = i6 + 1;
                        } else {
                            i = i6;
                        }
                        i7++;
                        i6 = i;
                    }
                    bfVar.bUv.setVisibility(0);
                    bfVar.bUv.a(aaVar, this.bRX.aOk().getName(), this.bRX.aOk().getId(), aaVar.getTid());
                    bfVar.bUv.setShowBig(this.bYY);
                    bfVar.bUv.setDrawNum(true);
                    bfVar.bUv.setFromCDN(this.mIsFromCDN);
                    bfVar.bUv.a(this.aTb.getPageContext(), mediaDataArr, i3);
                    bfVar.bUv.setImageFrom("other");
                } else {
                    bfVar.bUv.setVisibility(8);
                }
            } else {
                bfVar.bUv.setVisibility(8);
            }
            bfVar.bUu.setVisibility(8);
            if (aaVar.rH() != null && aaVar.rH().getNum() > 0) {
                bfVar.ahz.setVisibility(0);
                bfVar.ahz.setText(ax.y(aaVar.rH().getNum()));
            } else {
                bfVar.ahz.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(bfVar.ahz);
            int rJ = aaVar.rJ();
            if (rJ > 0) {
                bfVar.bTu.setVisibility(0);
                bfVar.bTu.setText(ax.y(rJ));
            } else {
                bfVar.bTu.setVisibility(8);
            }
            bfVar.bUy.setVisibility(8);
        }
    }

    public void ee(boolean z) {
        if (this.bYY != z) {
            this.bYY = z;
        }
    }

    public int agj() {
        return r.g.storecard_close_click;
    }
}
