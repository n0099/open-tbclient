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
    private boolean ahm;
    private TbPageContext<?> ajh;
    private final View.OnClickListener alO;
    public ClickableHeaderImageView alV;
    public ViewStub alX;
    public TbImageView alY;
    private final View.OnClickListener ama;
    private View avx;
    private UserIconLayout bBA;
    private FrsCommonImageLayout bBB;
    private FrsCommonImageLayout.b bBC;
    private final View.OnClickListener bBD;
    public PlayVoiceBntNew bBq;
    private TextView bBr;
    private final View.OnClickListener bBt;
    public ThreadCommentAndPraiseInfoLayout bBx;
    private final String bBy;
    private final String bBz;
    public View bzE;
    private com.baidu.tieba.card.data.l bzH;
    private View.OnClickListener bzI;
    private int mSkinType;
    private TextView mTitle;

    public bc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bBy = "1";
        this.bBz = "2";
        this.mSkinType = 3;
        this.ahm = true;
        this.bzI = new bd(this);
        this.bBC = new be(this);
        this.bBD = new bf(this);
        this.bBt = new bg(this);
        this.ama = new bh(this);
        this.alO = new bi(this);
        View view = getView();
        this.ajh = tbPageContext;
        this.avx = view.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.alV = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.alX = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.alV.setDefaultResource(17170445);
        this.alV.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.alV.setDefaultBgResource(w.e.cp_bg_line_e);
        this.alV.setRadius(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds70));
        this.bBA = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bBq = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bBq.setAfterClickListener(this.bBt);
        this.bBr = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bBB = (FrsCommonImageLayout) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bBB.setDrawNum(false);
        this.bBB.setAfterChildClickListener(this.bBD);
        this.bBx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bzE = view.findViewById(w.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avx, w.e.cp_bg_line_b);
            this.bBA.onChangeSkinType();
            this.bBx.onChangeSkinType();
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
        this.bzH = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bzI);
        }
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bzH.bDt) {
            this.alV.setVisibility(8);
            this.bBA.setVisibility(8);
        } else {
            this.bBA.setVisibility(0);
            this.alV.setVisibility(0);
            this.alV.setData(lVar.threadData);
            this.alV.setAfterClickListener(this.ama);
            UserTbVipInfoData rv = this.bzH.threadData.rv();
            if (rv != null && rv.getvipV_url() != null && this.alX != null) {
                if (this.alY == null) {
                    this.alX.inflate();
                    this.alY = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.alY.c(rv.getvipV_url(), 10, false);
                this.alV.setIsBigV(true);
            }
        }
        this.bBA.setData(lVar.threadData);
        this.bBA.setUserAfterClickListener(this.ama);
        if (this.bBx.a(lVar.threadData)) {
            this.bzE.setVisibility(8);
        }
        this.bBx.setForumAfterClickListener(this.alO);
        this.bBx.setStType(at.rl());
        this.bBx.setYuelaouLocate("feed#" + lVar.UB());
        if ((StringUtils.isNull(lVar.threadData.getTitle()) && (lVar.threadData.rt() == null || lVar.threadData.rt().size() == 0)) || lVar.threadData.rJ() == 1) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            lVar.threadData.XB = 0;
            lVar.threadData.sc();
            SpannableStringBuilder rU = lVar.threadData.rU();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.aa(rU));
            this.mTitle.setText(rU);
            if (!Uh()) {
                at.a(this.mTitle, lVar.LH().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.aq.i(this.mTitle, w.e.cp_cont_b);
            }
        }
        if (!Uh() && at.ic(lVar.threadData.getId())) {
            at.a(this.mTitle, this.bzH.LH().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            at.a(this.bBr, this.bzH.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.threadData.rC() != null && !StringUtils.isNull(lVar.threadData.rC())) {
            stringBuffer.append(lVar.threadData.rC());
        }
        ArrayList<MediaData> rE = lVar.threadData.rE();
        if (rE != null) {
            i = rE.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rE.get(i4).getVideoUrl() != null && rE.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rE.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(lVar.threadData.g(stringBuffer.toString(), true))) {
                this.bBr.setVisibility(0);
                SpannableString cu = lVar.threadData.cu(stringBuffer.toString());
                this.bBr.setOnTouchListener(new com.baidu.tieba.view.aa(cu));
                this.bBr.setText(cu);
                if (!Uh()) {
                    at.a(this.bBr, lVar.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.aq.i(this.bBr, w.e.cp_cont_j);
                }
            } else {
                this.bBr.setVisibility(8);
            }
        } else {
            this.bBr.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rI = lVar.threadData.rI();
        if (rI != null && rI.size() > 0) {
            this.bBq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bBq.setVoiceModel(voiceModel);
            this.bBq.setTag(voiceModel);
            this.bBq.aZV();
            if (voiceModel != null) {
                this.bBq.mn(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bBq.setVisibility(8);
            z = false;
        }
        if (this.bzH.bDt && z) {
            this.bBB.setVisibility(8);
        } else if (com.baidu.tbadk.core.r.oN().oT() && com.baidu.tbadk.core.util.x.q(rE) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rE.get(i5) == null || !(rE.get(i5).getType() == 3 || rE.get(i5).getType() == 5)) {
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
                    if (rE.get(i9).getType() == 3 || rE.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rE.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bBB.setVisibility(0);
                this.bBB.a(lVar.threadData, lVar.threadData.rz(), new StringBuilder(String.valueOf(lVar.threadData.getFid())).toString(), lVar.threadData.getTid());
                this.bBB.setShowBig(com.baidu.tbadk.core.util.av.vl().vn());
                this.bBB.a(this.ajh, mediaDataArr, i6);
                this.bBB.setFromCDN(this.ahm);
                this.bBB.setImageFrom("other");
            } else {
                this.bBB.setVisibility(8);
            }
        } else {
            this.bBB.setVisibility(8);
        }
        Uq();
    }

    private void Uq() {
        if (!this.bzH.aAa) {
            this.bBB.setOnChildClickListener(this.bBC);
            this.bBq.setClickable(false);
            this.bBx.setBarNameClickEnabled(false);
        } else {
            this.bBB.setOnChildClickListener(null);
            this.bBq.setClickable(true);
            this.bBx.setBarNameClickEnabled(true);
        }
        int childCount = this.bBB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bBB.getChildAt(i);
            if (childAt != null) {
                if (!this.bzH.aAa) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahm = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bBx != null) {
            this.bBx.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        if (this.bzH != null && this.bzH.threadData != null) {
            if (!Uh()) {
                at.ib(this.bzH.threadData.getId());
                at.a(this.mTitle, this.bzH.LH().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                at.a(this.bBr, this.bzH.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajh.getPageActivity()).createFromThreadCfg(this.bzH.threadData, null, at.rl(), 18003, true, false, false).addLocateParam(this.bzH.UC());
            addLocateParam.setForumId(String.valueOf(this.bzH.threadData.getFid()));
            addLocateParam.setForumName(this.bzH.threadData.rz());
            if (this.bzH.bDb == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bzH.bDb);
            }
            this.ajh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Uh() {
        return this.bzH.bDt && !this.bzH.aAa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
