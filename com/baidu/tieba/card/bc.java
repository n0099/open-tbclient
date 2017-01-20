package com.baidu.tieba.card;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bc extends a<com.baidu.tieba.card.data.n> {
    private TbPageContext<?> FY;
    private TextView aNb;
    public ViewStub aUU;
    public TbImageView aUV;
    private boolean acy;
    private final View.OnClickListener agO;
    private final View.OnClickListener agt;
    private View apX;
    private TextView bkS;
    private FrsCommonImageLayout bkT;
    public ThreadCommentAndPraiseInfoLayout bkU;
    private CustomMessageListener blR;
    public View bmA;
    private UserIconLayout bmB;
    private com.baidu.tieba.card.data.n bmC;
    private View.OnClickListener bmE;
    private FrsCommonImageLayout.b bmF;
    private final View.OnClickListener bmG;
    private final String bmK;
    private final String bmL;
    private final View.OnClickListener bmM;
    public ClickableHeaderImageView bmy;
    public PlayVoiceBntNew bmz;
    private int mSkinType;

    public bc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bmK = "1";
        this.bmL = "2";
        this.mSkinType = 3;
        this.acy = true;
        this.bmE = new bd(this);
        this.blR = new be(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bmF = new bf(this);
        this.bmM = new bg(this);
        this.bmG = new bh(this);
        this.agO = new bi(this);
        this.agt = new bj(this);
        View view = getView();
        this.FY = tbPageContext;
        this.apX = view.findViewById(r.h.card_home_page_normal_thread_top_line);
        this.bmy = (ClickableHeaderImageView) view.findViewById(r.h.card_home_page_normal_thread_user_header);
        this.aUU = (ViewStub) view.findViewById(r.h.viewstub_headimage_mask);
        this.bmy.setDefaultResource(17170445);
        this.bmy.setDefaultErrorResource(r.g.icon_default_avatar100);
        this.bmy.setDefaultBgResource(r.e.cp_bg_line_e);
        this.bmy.setRadius(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds70));
        this.bmB = (UserIconLayout) view.findViewById(r.h.card_home_page_normal_thread_user_layout);
        this.aNb = (TextView) view.findViewById(r.h.card_home_page_normal_thread_title);
        this.bmz = (PlayVoiceBntNew) view.findViewById(r.h.card_home_page_normal_thread_abstract_voice);
        this.bmz.setAfterClickListener(this.bmG);
        this.bkS = (TextView) view.findViewById(r.h.card_home_page_normal_thread_abstract);
        this.bkT = (FrsCommonImageLayout) view.findViewById(r.h.card_home_page_normal_thread_img_layout);
        this.bkT.setDrawNum(false);
        this.bkT.setAfterChildClickListener(this.bmM);
        this.bkU = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.h.card_home_page_normal_thread_info_layout);
        this.bmA = view.findViewById(r.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.j(getView(), r.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.ap.k(this.apX, r.e.cp_bg_line_b);
            this.bmB.tg();
            this.bkU.tg();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_home_page_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.n nVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        if (nVar == null || nVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bmC = nVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bmE);
        }
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bmC.bou) {
            this.bmy.setVisibility(8);
            this.bmB.setVisibility(8);
        } else {
            this.bmB.setVisibility(0);
            this.bmy.setVisibility(0);
            this.bmy.setData(nVar.threadData);
            this.bmy.setAfterClickListener(this.agO);
            UserTbVipInfoData rx = this.bmC.threadData.rx();
            if (rx != null && rx.getvipV_url() != null && this.aUU != null) {
                if (this.aUV == null) {
                    this.aUU.inflate();
                    this.aUV = (TbImageView) getView().findViewById(r.h.user_head_mask);
                }
                this.aUV.c(rx.getvipV_url(), 10, false);
                this.bmy.setIsBigV(true);
            }
        }
        this.bmB.setData(nVar.threadData);
        this.bmB.setUserAfterClickListener(this.agO);
        if (this.bkU.a(nVar.threadData)) {
            this.bmA.setVisibility(8);
        }
        this.bkU.setForumAfterClickListener(this.agt);
        this.bkU.setStType(at.Mt());
        this.bkU.setYuelaouLocate("feed#" + nVar.Rz());
        if ((StringUtils.isNull(nVar.threadData.getTitle()) && (nVar.threadData.rv() == null || nVar.threadData.rv().size() == 0)) || nVar.threadData.rL() == 1) {
            this.aNb.setVisibility(8);
        } else {
            this.aNb.setVisibility(0);
            nVar.threadData.SJ = 0;
            nVar.threadData.sd();
            SpannableStringBuilder rV = nVar.threadData.rV();
            this.aNb.setOnTouchListener(new com.baidu.tieba.view.x(rV));
            this.aNb.setText(rV);
            if (!Rp()) {
                at.a(this.aNb, nVar.Ji().getId(), r.e.cp_cont_b, r.e.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.ap.i((View) this.aNb, r.e.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (nVar.threadData.rE() != null && !StringUtils.isNull(nVar.threadData.rE())) {
            stringBuffer.append(nVar.threadData.rE());
        }
        ArrayList<MediaData> rG = nVar.threadData.rG();
        if (rG != null) {
            i = rG.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rG.get(i4).getVideoUrl() != null && rG.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rG.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(nVar.threadData.g(stringBuffer.toString(), true))) {
                this.bkS.setVisibility(0);
                SpannableString cx = nVar.threadData.cx(stringBuffer.toString());
                this.bkS.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                this.bkS.setText(cx);
                if (!Rp()) {
                    at.a(this.bkS, nVar.threadData.getId(), r.e.cp_cont_j, r.e.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.ap.i((View) this.bkS, r.e.cp_cont_j);
                }
            } else {
                this.bkS.setVisibility(8);
            }
        } else {
            this.bkS.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rK = nVar.threadData.rK();
        if (rK != null && rK.size() > 0) {
            this.bmz.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rK.get(0);
            this.bmz.setVoiceModel(voiceModel);
            this.bmz.setTag(voiceModel);
            this.bmz.ayK();
            if (voiceModel != null) {
                this.bmz.mj(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bmz.setVisibility(8);
            z = false;
        }
        if (this.bmC.bou && z) {
            this.bkT.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oC().oI() && com.baidu.tbadk.core.util.w.r(rG) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rG.get(i5) == null || !(rG.get(i5).getType() == 3 || rG.get(i5).getType() == 5)) {
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
                    if (rG.get(i9).getType() == 3 || rG.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rG.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bkT.setVisibility(0);
                this.bkT.a(nVar.threadData, nVar.threadData.rB(), new StringBuilder(String.valueOf(nVar.threadData.getFid())).toString(), nVar.threadData.getTid());
                this.bkT.setShowBig(com.baidu.tbadk.core.util.au.vg().vi());
                this.bkT.a(this.FY, mediaDataArr, i6);
                this.bkT.setFromCDN(this.acy);
                this.bkT.setImageFrom("other");
            } else {
                this.bkT.setVisibility(8);
            }
        } else {
            this.bkT.setVisibility(8);
        }
        Rs();
    }

    private void Rs() {
        if (!this.bmC.auD) {
            this.bkT.setOnChildClickListener(this.bmF);
            this.bmz.setClickable(false);
            this.bkU.setBarNameClickEnabled(false);
        } else {
            this.bkT.setOnChildClickListener(null);
            this.bmz.setClickable(true);
            this.bkU.setBarNameClickEnabled(true);
        }
        int childCount = this.bkT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bkT.getChildAt(i);
            if (childAt != null) {
                if (!this.bmC.auD) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.acy = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bkU != null && this.blR != null) {
            this.bkU.h(bdUniqueId);
            this.blR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rt() {
        if (this.bmC != null && this.bmC.threadData != null) {
            if (!Rp()) {
                at.ie(this.bmC.threadData.getId());
            }
            this.FY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.FY.getPageActivity()).createFromThreadCfg(this.bmC.threadData, null, at.Mt(), 18003, true, false, false).addLocateParam(this.bmC.RA())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Rp() {
        return this.bmC.bou && !this.bmC.auD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
