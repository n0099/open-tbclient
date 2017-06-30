package com.baidu.tieba.card;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bc extends a<com.baidu.tieba.card.data.l> {
    private boolean ahU;
    private TbPageContext<?> ajP;
    private final View.OnClickListener amF;
    public ClickableHeaderImageView amN;
    public ViewStub amP;
    public TbImageView amQ;
    private final View.OnClickListener amS;
    private View awA;
    private com.baidu.tieba.card.data.l bAA;
    private View.OnClickListener bAB;
    public View bAx;
    public PlayVoiceBntNew bCj;
    private TextView bCk;
    private final View.OnClickListener bCm;
    public ThreadCommentAndPraiseInfoLayout bCq;
    private final String bCr;
    private final String bCs;
    private UserIconLayout bCt;
    private FrsCommonImageLayout bCu;
    private FrsCommonImageLayout.b bCv;
    private final View.OnClickListener bCw;
    private int mSkinType;
    private TextView mTitle;

    public bc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bCr = "1";
        this.bCs = "2";
        this.mSkinType = 3;
        this.ahU = true;
        this.bAB = new bd(this);
        this.bCv = new be(this);
        this.bCw = new bf(this);
        this.bCm = new bg(this);
        this.amS = new bh(this);
        this.amF = new bi(this);
        View view = getView();
        this.ajP = tbPageContext;
        this.awA = view.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.amN = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.amP = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.amN.setDefaultResource(17170445);
        this.amN.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.amN.setDefaultBgResource(w.e.cp_bg_line_e);
        this.amN.setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
        this.bCt = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bCj = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bCj.setAfterClickListener(this.bCm);
        this.bCk = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bCu = (FrsCommonImageLayout) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bCu.setDrawNum(false);
        this.bCu.setAfterChildClickListener(this.bCw);
        this.bCq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bAx = view.findViewById(w.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.as.k(this.awA, w.e.cp_bg_line_b);
            this.bCt.onChangeSkinType();
            this.bCq.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bAA = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bAB);
        }
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bAA.bEm) {
            this.amN.setVisibility(8);
            this.bCt.setVisibility(8);
        } else {
            this.bCt.setVisibility(0);
            this.amN.setVisibility(0);
            this.amN.setData(lVar.threadData);
            this.amN.setAfterClickListener(this.amS);
            UserTbVipInfoData rr = this.bAA.threadData.rr();
            if (rr != null && rr.getvipV_url() != null && this.amP != null) {
                if (this.amQ == null) {
                    this.amP.inflate();
                    this.amQ = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.amQ.c(rr.getvipV_url(), 10, false);
                this.amN.setIsBigV(true);
            }
        }
        this.bCt.setData(lVar.threadData);
        this.bCt.setUserAfterClickListener(this.amS);
        if (this.bCq.a(lVar.threadData)) {
            this.bAx.setVisibility(8);
        }
        this.bCq.setForumAfterClickListener(this.amF);
        this.bCq.setStType(at.ri());
        this.bCq.setYuelaouLocate("feed#" + lVar.VS());
        if ((StringUtils.isNull(lVar.threadData.getTitle()) && (lVar.threadData.rp() == null || lVar.threadData.rp().size() == 0)) || lVar.threadData.rG() == 1) {
            lVar.threadData.e(false, true);
            if (lVar.threadData.rR() == null || StringUtils.isNull(lVar.threadData.rR().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(lVar.threadData.rR());
            }
        } else {
            this.mTitle.setVisibility(0);
            lVar.threadData.XB = 0;
            lVar.threadData.rZ();
            SpannableStringBuilder rR = lVar.threadData.rR();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.aa(rR));
            this.mTitle.setText(rR);
            if (!Vw()) {
                at.a(this.mTitle, lVar.Mv().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.as.i(this.mTitle, w.e.cp_cont_b);
            }
        }
        if (!Vw() && at.iJ(lVar.threadData.getId())) {
            at.a(this.mTitle, this.bAA.Mv().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            at.a(this.bCk, this.bAA.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.threadData.rz() != null && !StringUtils.isNull(lVar.threadData.rz())) {
            stringBuffer.append(lVar.threadData.rz());
        }
        ArrayList<MediaData> rB = lVar.threadData.rB();
        if (rB != null) {
            i = rB.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rB.get(i4).getVideoUrl() != null && rB.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rB.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(lVar.threadData.g(stringBuffer.toString(), true))) {
                this.bCk.setVisibility(0);
                SpannableString cA = lVar.threadData.cA(stringBuffer.toString());
                this.bCk.setOnTouchListener(new com.baidu.tieba.view.aa(cA));
                this.bCk.setText(cA);
                if (!Vw()) {
                    at.a(this.bCk, lVar.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.as.i(this.bCk, w.e.cp_cont_j);
                }
            } else {
                this.bCk.setVisibility(8);
            }
        } else {
            this.bCk.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rF = lVar.threadData.rF();
        if (rF != null && rF.size() > 0) {
            this.bCj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rF.get(0);
            this.bCj.setVoiceModel(voiceModel);
            this.bCj.setTag(voiceModel);
            this.bCj.bef();
            if (voiceModel != null) {
                this.bCj.my(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bCj.setVisibility(8);
            z = false;
        }
        if (this.bAA.bEm && z) {
            this.bCu.setVisibility(8);
        } else if (com.baidu.tbadk.core.r.oK().oQ() && com.baidu.tbadk.core.util.z.s(rB) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rB.get(i5) == null || !(rB.get(i5).getType() == 3 || rB.get(i5).getType() == 5)) {
                    i3 = i6;
                } else {
                    i7++;
                    i3 = i6 + 1;
                }
                i5++;
                i7 = i7;
                i6 = i3;
            }
            if (i7 > 0) {
                MediaData[] mediaDataArr = new MediaData[i7];
                int i8 = 0;
                int i9 = 0;
                while (i9 < i && i8 < i7) {
                    if (rB.get(i9).getType() == 3 || rB.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rB.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bCu.setVisibility(0);
                this.bCu.a(lVar.threadData, lVar.threadData.rw(), new StringBuilder(String.valueOf(lVar.threadData.getFid())).toString(), lVar.threadData.getTid());
                this.bCu.setShowBig(com.baidu.tbadk.core.util.ax.vA().vC());
                this.bCu.a(this.ajP, mediaDataArr, i6);
                this.bCu.setFromCDN(this.ahU);
                this.bCu.setImageFrom("other");
            } else {
                this.bCu.setVisibility(8);
            }
        } else {
            this.bCu.setVisibility(8);
        }
        VH();
    }

    private void VH() {
        if (!this.bAA.aBd) {
            this.bCu.setOnChildClickListener(this.bCv);
            this.bCj.setClickable(false);
            this.bCq.setBarNameClickEnabled(false);
        } else {
            this.bCu.setOnChildClickListener(null);
            this.bCj.setClickable(true);
            this.bCq.setBarNameClickEnabled(true);
        }
        int childCount = this.bCu.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bCu.getChildAt(i);
            if (childAt != null) {
                if (!this.bAA.aBd) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahU = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bCq != null) {
            this.bCq.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VI() {
        if (this.bAA != null && this.bAA.threadData != null) {
            if (!Vw()) {
                at.iI(this.bAA.threadData.getId());
                at.a(this.mTitle, this.bAA.Mv().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                at.a(this.bCk, this.bAA.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajP.getPageActivity()).createFromThreadCfg(this.bAA.threadData, null, at.ri(), 18003, true, false, false).addLocateParam(this.bAA.VT());
            addLocateParam.setForumId(String.valueOf(this.bAA.threadData.getFid()));
            addLocateParam.setForumName(this.bAA.threadData.rw());
            if (this.bAA.bDU == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bAA.bDU);
            }
            this.ajP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Vw() {
        return this.bAA.bEm && !this.bAA.aBd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
