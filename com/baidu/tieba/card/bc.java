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
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bc extends a<com.baidu.tieba.card.data.n> {
    private boolean aid;
    private TbPageContext<?> ajU;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    private View avJ;
    public ViewStub bbW;
    public TbImageView bbX;
    private TextView btU;
    private FrsCommonImageLayout btV;
    public ThreadCommentAndPraiseInfoLayout btW;
    private CustomMessageListener buW;
    public ClickableHeaderImageView bvD;
    public PlayVoiceBntNew bvE;
    public View bvF;
    private UserIconLayout bvG;
    private com.baidu.tieba.card.data.n bvH;
    private View.OnClickListener bvJ;
    private FrsCommonImageLayout.b bvK;
    private final View.OnClickListener bvL;
    private final String bvP;
    private final String bvQ;
    private final View.OnClickListener bvR;
    private int mSkinType;
    private TextView mTitle;

    public bc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bvP = "1";
        this.bvQ = "2";
        this.mSkinType = 3;
        this.aid = true;
        this.bvJ = new bd(this);
        this.buW = new be(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bvK = new bf(this);
        this.bvR = new bg(this);
        this.bvL = new bh(this);
        this.amx = new bi(this);
        this.ama = new bj(this);
        View view = getView();
        this.ajU = tbPageContext;
        this.avJ = view.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.bvD = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bbW = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.bvD.setDefaultResource(17170445);
        this.bvD.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bvD.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bvD.setRadius(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds70));
        this.bvG = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bvE = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bvE.setAfterClickListener(this.bvL);
        this.btU = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.btV = (FrsCommonImageLayout) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.btV.setDrawNum(false);
        this.btV.setAfterChildClickListener(this.bvR);
        this.btW = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bvF = view.findViewById(w.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avJ, w.e.cp_bg_line_b);
            this.bvG.onChangeSkinType();
            this.btW.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_normal_thread;
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
        this.bvH = nVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bvJ);
        }
        onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bvH.bxz) {
            this.bvD.setVisibility(8);
            this.bvG.setVisibility(8);
        } else {
            this.bvG.setVisibility(0);
            this.bvD.setVisibility(0);
            this.bvD.setData(nVar.threadData);
            this.bvD.setAfterClickListener(this.amx);
            UserTbVipInfoData sp = this.bvH.threadData.sp();
            if (sp != null && sp.getvipV_url() != null && this.bbW != null) {
                if (this.bbX == null) {
                    this.bbW.inflate();
                    this.bbX = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.bbX.c(sp.getvipV_url(), 10, false);
                this.bvD.setIsBigV(true);
            }
        }
        this.bvG.setData(nVar.threadData);
        this.bvG.setUserAfterClickListener(this.amx);
        if (this.btW.a(nVar.threadData)) {
            this.bvF.setVisibility(8);
        }
        this.btW.setForumAfterClickListener(this.ama);
        this.btW.setStType(at.sf());
        this.btW.setYuelaouLocate("feed#" + nVar.TX());
        if ((StringUtils.isNull(nVar.threadData.getTitle()) && (nVar.threadData.sn() == null || nVar.threadData.sn().size() == 0)) || nVar.threadData.sD() == 1) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            nVar.threadData.Yn = 0;
            nVar.threadData.sW();
            SpannableStringBuilder sO = nVar.threadData.sO();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.x(sO));
            this.mTitle.setText(sO);
            if (!TN()) {
                at.a(this.mTitle, nVar.Kn().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.aq.i(this.mTitle, w.e.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (nVar.threadData.sw() != null && !StringUtils.isNull(nVar.threadData.sw())) {
            stringBuffer.append(nVar.threadData.sw());
        }
        ArrayList<MediaData> sy = nVar.threadData.sy();
        if (sy != null) {
            i = sy.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (sy.get(i4).getVideoUrl() != null && sy.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(sy.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(nVar.threadData.g(stringBuffer.toString(), true))) {
                this.btU.setVisibility(0);
                SpannableString cx = nVar.threadData.cx(stringBuffer.toString());
                this.btU.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                this.btU.setText(cx);
                if (!TN()) {
                    at.a(this.btU, nVar.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.aq.i(this.btU, w.e.cp_cont_j);
                }
            } else {
                this.btU.setVisibility(8);
            }
        } else {
            this.btU.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> sC = nVar.threadData.sC();
        if (sC != null && sC.size() > 0) {
            this.bvE.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sC.get(0);
            this.bvE.setVoiceModel(voiceModel);
            this.bvE.setTag(voiceModel);
            this.bvE.bbd();
            if (voiceModel != null) {
                this.bvE.mg(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bvE.setVisibility(8);
            z = false;
        }
        if (this.bvH.bxz && z) {
            this.btV.setVisibility(8);
        } else if (com.baidu.tbadk.core.q.po().pu() && com.baidu.tbadk.core.util.x.p(sy) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (sy.get(i5) == null || !(sy.get(i5).getType() == 3 || sy.get(i5).getType() == 5)) {
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
                    if (sy.get(i9).getType() == 3 || sy.get(i9).getType() == 5) {
                        mediaDataArr[i8] = sy.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.btV.setVisibility(0);
                this.btV.a(nVar.threadData, nVar.threadData.st(), new StringBuilder(String.valueOf(nVar.threadData.getFid())).toString(), nVar.threadData.getTid());
                this.btV.setShowBig(com.baidu.tbadk.core.util.av.wa().wc());
                this.btV.a(this.ajU, mediaDataArr, i6);
                this.btV.setFromCDN(this.aid);
                this.btV.setImageFrom("other");
            } else {
                this.btV.setVisibility(8);
            }
        } else {
            this.btV.setVisibility(8);
        }
        TQ();
    }

    private void TQ() {
        if (!this.bvH.aAq) {
            this.btV.setOnChildClickListener(this.bvK);
            this.bvE.setClickable(false);
            this.btW.setBarNameClickEnabled(false);
        } else {
            this.btV.setOnChildClickListener(null);
            this.bvE.setClickable(true);
            this.btW.setBarNameClickEnabled(true);
        }
        int childCount = this.btV.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.btV.getChildAt(i);
            if (childAt != null) {
                if (!this.bvH.aAq) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aid = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.btW != null && this.buW != null) {
            this.btW.h(bdUniqueId);
            this.buW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TR() {
        if (this.bvH != null && this.bvH.threadData != null) {
            if (!TN()) {
                at.hZ(this.bvH.threadData.getId());
            }
            this.ajU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajU.getPageActivity()).createFromThreadCfg(this.bvH.threadData, null, at.sf(), 18003, true, false, false).addLocateParam(this.bvH.TY())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TN() {
        return this.bvH.bxz && !this.bvH.aAq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
