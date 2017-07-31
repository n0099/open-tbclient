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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends a<com.baidu.tieba.card.data.l> {
    private boolean ajJ;
    private TbPageContext<?> alI;
    private final View.OnClickListener aoG;
    public ClickableHeaderImageView aoR;
    public ViewStub aoT;
    public TbImageView aoU;
    private final View.OnClickListener aoW;
    private View ayJ;
    public View bFO;
    private com.baidu.tieba.card.data.l bFR;
    private View.OnClickListener bFS;
    public PlayVoiceBntNew bHA;
    private TextView bHB;
    private final View.OnClickListener bHD;
    public ThreadCommentAndPraiseInfoLayout bHH;
    private final String bHI;
    private final String bHJ;
    private UserIconLayout bHK;
    private FrsCommonImageLayout bHL;
    private FrsCommonImageLayout.b bHM;
    private final View.OnClickListener bHN;
    private int mSkinType;
    private TextView mTitle;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHI = "1";
        this.bHJ = "2";
        this.mSkinType = 3;
        this.ajJ = true;
        this.bFS = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.We() != null) {
                    o.this.We().a(view, o.this.bFR);
                }
                o.this.Wu();
            }
        };
        this.bHM = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.o.2
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void du(int i) {
                o.this.Wu();
            }
        };
        this.bHN = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> We = o.this.We();
                if (We != null) {
                    view.setTag("1");
                    We.a(view, o.this.bFR);
                }
            }
        };
        this.bHD = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> We = o.this.We();
                if (We != null) {
                    view.setTag("2");
                    We.a(view, o.this.bFR);
                }
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.We() != null) {
                    o.this.We().a(view, o.this.bFR);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.We() != null) {
                    o.this.We().a(view, o.this.bFR);
                }
            }
        };
        View view = getView();
        this.alI = tbPageContext;
        this.ayJ = view.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.aoR = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aoT = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.aoR.setDefaultResource(17170445);
        this.aoR.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.aoR.setDefaultBgResource(d.e.cp_bg_line_e);
        this.aoR.setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
        this.bHK = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bHA = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bHA.setAfterClickListener(this.bHD);
        this.bHB = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bHL = (FrsCommonImageLayout) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bHL.setDrawNum(false);
        this.bHL.setAfterChildClickListener(this.bHN);
        this.bHH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bFO = view.findViewById(d.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.k(this.ayJ, d.e.cp_bg_line_b);
            this.bHK.onChangeSkinType();
            this.bHH.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_normal_thread;
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
        this.bFR = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bFS);
        }
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        if (this.bFR.bJI) {
            this.aoR.setVisibility(8);
            this.bHK.setVisibility(8);
        } else {
            this.bHK.setVisibility(0);
            this.aoR.setVisibility(0);
            this.aoR.setData(lVar.threadData);
            this.aoR.setAfterClickListener(this.aoW);
            UserTbVipInfoData rF = this.bFR.threadData.rF();
            if (rF != null && rF.getvipV_url() != null && this.aoT != null) {
                if (this.aoU == null) {
                    this.aoT.inflate();
                    this.aoU = (TbImageView) getView().findViewById(d.h.user_head_mask);
                }
                this.aoU.c(rF.getvipV_url(), 10, false);
                this.aoR.setIsBigV(true);
            }
        }
        this.bHK.setData(lVar.threadData);
        this.bHK.setUserAfterClickListener(this.aoW);
        if (this.bHH.a(lVar.threadData)) {
            this.bFO.setVisibility(8);
        }
        this.bHH.setForumAfterClickListener(this.aoG);
        this.bHH.setStType(m.rw());
        this.bHH.setYuelaouLocate("feed#" + lVar.WF());
        if ((StringUtils.isNull(lVar.threadData.getTitle()) && (lVar.threadData.rD() == null || lVar.threadData.rD().size() == 0)) || lVar.threadData.rU() == 1) {
            lVar.threadData.e(false, true);
            if (lVar.threadData.sf() == null || StringUtils.isNull(lVar.threadData.sf().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(lVar.threadData.sf());
            }
        } else {
            this.mTitle.setVisibility(0);
            lVar.threadData.Zo = 0;
            lVar.threadData.sn();
            SpannableStringBuilder sf = lVar.threadData.sf();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(sf));
            this.mTitle.setText(sf);
            if (!Wi()) {
                m.a(this.mTitle, lVar.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            } else {
                ai.i(this.mTitle, d.e.cp_cont_b);
            }
        }
        if (!Wi() && m.je(lVar.threadData.getId())) {
            m.a(this.mTitle, this.bFR.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bHB, this.bFR.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.threadData.rN() != null && !StringUtils.isNull(lVar.threadData.rN())) {
            stringBuffer.append(lVar.threadData.rN());
        }
        ArrayList<MediaData> rP = lVar.threadData.rP();
        if (rP != null) {
            i = rP.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rP.get(i4).getVideoUrl() != null && rP.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rP.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(lVar.threadData.g(stringBuffer.toString(), true))) {
                this.bHB.setVisibility(0);
                SpannableString cL = lVar.threadData.cL(stringBuffer.toString());
                this.bHB.setOnTouchListener(new com.baidu.tieba.view.l(cL));
                this.bHB.setText(cL);
                if (!Wi()) {
                    m.a(this.bHB, lVar.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                } else {
                    ai.i(this.bHB, d.e.cp_cont_j);
                }
            } else {
                this.bHB.setVisibility(8);
            }
        } else {
            this.bHB.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rT = lVar.threadData.rT();
        if (rT != null && rT.size() > 0) {
            this.bHA.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rT.get(0);
            this.bHA.setVoiceModel(voiceModel);
            this.bHA.setTag(voiceModel);
            this.bHA.bhR();
            if (voiceModel != null) {
                this.bHA.mG(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bHA.setVisibility(8);
            z = false;
        }
        if (this.bFR.bJI && z) {
            this.bHL.setVisibility(8);
        } else if (com.baidu.tbadk.core.h.oX().pd() && com.baidu.tbadk.core.util.u.u(rP) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rP.get(i5) == null || !(rP.get(i5).getType() == 3 || rP.get(i5).getType() == 5)) {
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
                    if (rP.get(i9).getType() == 3 || rP.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rP.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bHL.setVisibility(0);
                this.bHL.a(lVar.threadData, lVar.threadData.rK(), lVar.threadData.getFid() + "", lVar.threadData.getTid());
                this.bHL.setShowBig(am.vQ().vS());
                this.bHL.a(this.alI, mediaDataArr, i6);
                this.bHL.setFromCDN(this.ajJ);
                this.bHL.setImageFrom("other");
            } else {
                this.bHL.setVisibility(8);
            }
        } else {
            this.bHL.setVisibility(8);
        }
        Wt();
    }

    private void Wt() {
        if (!this.bFR.aDu) {
            this.bHL.setOnChildClickListener(this.bHM);
            this.bHA.setClickable(false);
            this.bHH.setBarNameClickEnabled(false);
        } else {
            this.bHL.setOnChildClickListener(null);
            this.bHA.setClickable(true);
            this.bHH.setBarNameClickEnabled(true);
        }
        int childCount = this.bHL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bHL.getChildAt(i);
            if (childAt != null) {
                if (!this.bFR.aDu) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajJ = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bHH != null) {
            this.bHH.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wu() {
        if (this.bFR != null && this.bFR.threadData != null) {
            if (!Wi()) {
                m.jd(this.bFR.threadData.getId());
                m.a(this.mTitle, this.bFR.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bHB, this.bFR.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.alI.getPageActivity()).createFromThreadCfg(this.bFR.threadData, null, m.rw(), 18003, true, false, false).addLocateParam(this.bFR.WG());
            addLocateParam.setForumId(String.valueOf(this.bFR.threadData.getFid()));
            addLocateParam.setForumName(this.bFR.threadData.rK());
            if (this.bFR.bJq == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bFR.bJq);
            }
            this.alI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wi() {
        return this.bFR.bJI && !this.bFR.aDu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
