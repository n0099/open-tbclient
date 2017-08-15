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
    private boolean ajL;
    private final View.OnClickListener aoH;
    public ClickableHeaderImageView aoS;
    public ViewStub aoU;
    public TbImageView aoV;
    private final View.OnClickListener aoX;
    private View ayK;
    private com.baidu.tieba.card.data.l bGA;
    private View.OnClickListener bGB;
    public View bGx;
    public PlayVoiceBntNew bIj;
    private TextView bIk;
    private final View.OnClickListener bIm;
    public ThreadCommentAndPraiseInfoLayout bIq;
    private final String bIr;
    private final String bIs;
    private UserIconLayout bIt;
    private FrsCommonImageLayout bIu;
    private FrsCommonImageLayout.b bIv;
    private final View.OnClickListener bIw;
    private int mSkinType;
    private TextView mTitle;
    private TbPageContext<?> oV;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIr = "1";
        this.bIs = "2";
        this.mSkinType = 3;
        this.ajL = true;
        this.bGB = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.WA() != null) {
                    o.this.WA().a(view, o.this.bGA);
                }
                o.this.WQ();
            }
        };
        this.bIv = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.o.2
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void du(int i) {
                o.this.WQ();
            }
        };
        this.bIw = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> WA = o.this.WA();
                if (WA != null) {
                    view.setTag("1");
                    WA.a(view, o.this.bGA);
                }
            }
        };
        this.bIm = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> WA = o.this.WA();
                if (WA != null) {
                    view.setTag("2");
                    WA.a(view, o.this.bGA);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.WA() != null) {
                    o.this.WA().a(view, o.this.bGA);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.WA() != null) {
                    o.this.WA().a(view, o.this.bGA);
                }
            }
        };
        View view = getView();
        this.oV = tbPageContext;
        this.ayK = view.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.aoS = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aoU = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.aoS.setDefaultResource(17170445);
        this.aoS.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.aoS.setDefaultBgResource(d.e.cp_bg_line_e);
        this.aoS.setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds70));
        this.bIt = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bIj = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bIj.setAfterClickListener(this.bIm);
        this.bIk = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bIu = (FrsCommonImageLayout) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bIu.setDrawNum(false);
        this.bIu.setAfterChildClickListener(this.bIw);
        this.bIq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bGx = view.findViewById(d.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.k(this.ayK, d.e.cp_bg_line_b);
            this.bIt.onChangeSkinType();
            this.bIq.onChangeSkinType();
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
        this.bGA = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGB);
        }
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        if (this.bGA.bKr) {
            this.aoS.setVisibility(8);
            this.bIt.setVisibility(8);
        } else {
            this.bIt.setVisibility(0);
            this.aoS.setVisibility(0);
            this.aoS.setData(lVar.threadData);
            this.aoS.setAfterClickListener(this.aoX);
            UserTbVipInfoData rF = this.bGA.threadData.rF();
            if (rF != null && rF.getvipV_url() != null && this.aoU != null) {
                if (this.aoV == null) {
                    this.aoU.inflate();
                    this.aoV = (TbImageView) getView().findViewById(d.h.user_head_mask);
                }
                this.aoV.c(rF.getvipV_url(), 10, false);
                this.aoS.setIsBigV(true);
            }
        }
        this.bIt.setData(lVar.threadData);
        this.bIt.setUserAfterClickListener(this.aoX);
        if (this.bIq.a(lVar.threadData)) {
            this.bGx.setVisibility(8);
        }
        this.bIq.setForumAfterClickListener(this.aoH);
        this.bIq.setStType(m.rw());
        this.bIq.setYuelaouLocate("feed#" + lVar.Xb());
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
            lVar.threadData.Zq = 0;
            lVar.threadData.sn();
            SpannableStringBuilder sf = lVar.threadData.sf();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(sf));
            this.mTitle.setText(sf);
            if (!WE()) {
                m.a(this.mTitle, lVar.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            } else {
                ai.i(this.mTitle, d.e.cp_cont_b);
            }
        }
        if (!WE() && m.jf(lVar.threadData.getId())) {
            m.a(this.mTitle, this.bGA.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIk, this.bGA.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
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
                this.bIk.setVisibility(0);
                SpannableString cL = lVar.threadData.cL(stringBuffer.toString());
                this.bIk.setOnTouchListener(new com.baidu.tieba.view.l(cL));
                this.bIk.setText(cL);
                if (!WE()) {
                    m.a(this.bIk, lVar.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                } else {
                    ai.i(this.bIk, d.e.cp_cont_j);
                }
            } else {
                this.bIk.setVisibility(8);
            }
        } else {
            this.bIk.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rT = lVar.threadData.rT();
        if (rT != null && rT.size() > 0) {
            this.bIj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rT.get(0);
            this.bIj.setVoiceModel(voiceModel);
            this.bIj.setTag(voiceModel);
            this.bIj.bix();
            if (voiceModel != null) {
                this.bIj.mQ(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bIj.setVisibility(8);
            z = false;
        }
        if (this.bGA.bKr && z) {
            this.bIu.setVisibility(8);
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
                this.bIu.setVisibility(0);
                this.bIu.a(lVar.threadData, lVar.threadData.rK(), lVar.threadData.getFid() + "", lVar.threadData.getTid());
                this.bIu.setShowBig(am.vQ().vS());
                this.bIu.a(this.oV, mediaDataArr, i6);
                this.bIu.setFromCDN(this.ajL);
                this.bIu.setImageFrom("other");
            } else {
                this.bIu.setVisibility(8);
            }
        } else {
            this.bIu.setVisibility(8);
        }
        WP();
    }

    private void WP() {
        if (!this.bGA.aDv) {
            this.bIu.setOnChildClickListener(this.bIv);
            this.bIj.setClickable(false);
            this.bIq.setBarNameClickEnabled(false);
        } else {
            this.bIu.setOnChildClickListener(null);
            this.bIj.setClickable(true);
            this.bIq.setBarNameClickEnabled(true);
        }
        int childCount = this.bIu.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIu.getChildAt(i);
            if (childAt != null) {
                if (!this.bGA.aDv) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajL = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bIq != null) {
            this.bIq.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WQ() {
        if (this.bGA != null && this.bGA.threadData != null) {
            if (!WE()) {
                m.je(this.bGA.threadData.getId());
                m.a(this.mTitle, this.bGA.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bIk, this.bGA.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.oV.getPageActivity()).createFromThreadCfg(this.bGA.threadData, null, m.rw(), 18003, true, false, false).addLocateParam(this.bGA.Xc());
            addLocateParam.setForumId(String.valueOf(this.bGA.threadData.getFid()));
            addLocateParam.setForumName(this.bGA.threadData.rK());
            if (this.bGA.bJZ == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bGA.bJZ);
            }
            this.oV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean WE() {
        return this.bGA.bKr && !this.bGA.aDv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
