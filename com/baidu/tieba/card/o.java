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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.an;
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
    private boolean aiR;
    private final View.OnClickListener anA;
    public ClickableHeaderImageView anN;
    public ViewStub anP;
    public TbImageView anQ;
    private final View.OnClickListener anS;
    private View axo;
    private com.baidu.tieba.card.data.l bQT;
    private View.OnClickListener bQU;
    public View bRQ;
    public PlayVoiceBntNew bSJ;
    private TextView bSL;
    private final View.OnClickListener bSN;
    public ThreadCommentAndPraiseInfoLayout bSR;
    private final String bSS;
    private final String bST;
    private UserIconLayout bSU;
    private FrsCommonImageLayout bSV;
    private FrsCommonImageLayout.b bSW;
    private final View.OnClickListener bSX;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bSS = "1";
        this.bST = "2";
        this.mSkinType = 3;
        this.aiR = true;
        this.bQU = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Zx() != null) {
                    o.this.Zx().a(view, o.this.bQT);
                }
                o.this.ZP();
            }
        };
        this.bSW = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.o.2
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void dF(int i) {
                o.this.ZP();
            }
        };
        this.bSX = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Zx = o.this.Zx();
                if (Zx != null) {
                    view.setTag("1");
                    Zx.a(view, o.this.bQT);
                }
            }
        };
        this.bSN = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Zx = o.this.Zx();
                if (Zx != null) {
                    view.setTag("2");
                    Zx.a(view, o.this.bQT);
                }
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Zx() != null) {
                    o.this.Zx().a(view, o.this.bQT);
                }
            }
        };
        this.anA = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Zx() != null) {
                    o.this.Zx().a(view, o.this.bQT);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.axo = view.findViewById(d.g.card_home_page_normal_thread_top_line);
        this.anN = (ClickableHeaderImageView) view.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.anP = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.anN.setDefaultResource(17170445);
        this.anN.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.anN.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.anN.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.bSU = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.bSJ = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.bSJ.setAfterClickListener(this.bSN);
        this.bSL = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.bSV = (FrsCommonImageLayout) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.bSV.setDrawNum(false);
        this.bSV.setAfterChildClickListener(this.bSX);
        this.bSR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bSR.getBarNameTv().setMaxWidth(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds120));
        this.bRQ = view.findViewById(d.g.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.home_thread_card_item_bg);
            aj.k(this.axo, d.C0080d.cp_bg_line_b);
            this.bSU.onChangeSkinType();
            this.bSR.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        if (lVar == null || lVar.blk == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bQT = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bQU);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.bQT.bUY) {
            this.anN.setVisibility(8);
            this.bSU.setVisibility(8);
        } else {
            this.bSU.setVisibility(0);
            this.anN.setVisibility(0);
            this.anN.setData(lVar.blk);
            this.anN.setAfterClickListener(this.anS);
            UserTbVipInfoData ru = this.bQT.blk.ru();
            if (ru != null && ru.getvipV_url() != null && this.anP != null) {
                if (this.anQ == null) {
                    this.anP.inflate();
                    this.anQ = (TbImageView) getView().findViewById(d.g.user_head_mask);
                }
                this.anQ.startLoad(ru.getvipV_url(), 10, false);
                this.anN.setIsBigV(true);
            }
        }
        this.bSU.setData(lVar.blk);
        this.bSU.setUserAfterClickListener(this.anS);
        this.bSR.setShareVisible(true);
        this.bSR.setShareReportFrom(3);
        if (this.bSR.setData(lVar.blk)) {
            this.bRQ.setVisibility(8);
        }
        this.bSR.setForumAfterClickListener(this.anA);
        this.bSR.setStType(m.rj());
        this.bSR.setYuelaouLocate("feed#" + lVar.aaa());
        this.bSR.setFrom(1);
        if ((StringUtils.isNull(lVar.blk.getTitle()) && (lVar.blk.rr() == null || lVar.blk.rr().size() == 0)) || lVar.blk.rJ() == 1) {
            lVar.blk.e(false, true);
            if (lVar.blk.rU() == null || StringUtils.isNull(lVar.blk.rU().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(lVar.blk.rU());
            }
        } else {
            this.mTitle.setVisibility(0);
            lVar.blk.YC = 0;
            lVar.blk.sc();
            SpannableStringBuilder rU = lVar.blk.rU();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(rU));
            this.mTitle.setText(rU);
            if (!ZB()) {
                m.a(this.mTitle, lVar.Np().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            } else {
                aj.i(this.mTitle, d.C0080d.cp_cont_b);
            }
        }
        if (!ZB() && m.jL(lVar.blk.getId())) {
            m.a(this.mTitle, this.bQT.Np().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSL, this.bQT.blk.getId(), d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.blk.getAbstract() != null && !StringUtils.isNull(lVar.blk.getAbstract())) {
            stringBuffer.append(lVar.blk.getAbstract());
        }
        ArrayList<MediaData> rE = lVar.blk.rE();
        if (rE != null) {
            i = rE.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rE.get(i4).getVideoUrl() != null && rE.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rE.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(lVar.blk.g(stringBuffer.toString(), true))) {
                this.bSL.setVisibility(0);
                SpannableString cJ = lVar.blk.cJ(stringBuffer.toString());
                this.bSL.setOnTouchListener(new com.baidu.tieba.view.l(cJ));
                this.bSL.setText(cJ);
                if (!ZB()) {
                    m.a(this.bSL, lVar.blk.getId(), d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
                } else {
                    aj.i(this.bSL, d.C0080d.cp_cont_j);
                }
            } else {
                this.bSL.setVisibility(8);
            }
        } else {
            this.bSL.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rI = lVar.blk.rI();
        if (rI != null && rI.size() > 0) {
            this.bSJ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bSJ.setVoiceModel(voiceModel);
            this.bSJ.setTag(voiceModel);
            this.bSJ.bjo();
            if (voiceModel != null) {
                this.bSJ.nx(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bSJ.setVisibility(8);
            z = false;
        }
        if (this.bQT.bUY && z) {
            this.bSV.setVisibility(8);
        } else if (com.baidu.tbadk.core.h.oT().oZ() && com.baidu.tbadk.core.util.v.u(rE) != 0) {
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
                this.bSV.setVisibility(0);
                this.bSV.a(lVar.blk, lVar.blk.rz(), lVar.blk.getFid() + "", lVar.blk.getTid());
                this.bSV.setShowBig(an.vs().vu());
                this.bSV.a(this.mPageContext, mediaDataArr, i6);
                this.bSV.setFromCDN(this.aiR);
                this.bSV.setImageFrom("other");
            } else {
                this.bSV.setVisibility(8);
            }
        } else {
            this.bSV.setVisibility(8);
        }
        ZO();
    }

    private void ZO() {
        if (!this.bQT.aCw) {
            this.bSV.setOnChildClickListener(this.bSW);
            this.bSJ.setClickable(false);
            this.bSR.setBarNameClickEnabled(false);
        } else {
            this.bSV.setOnChildClickListener(null);
            this.bSJ.setClickable(true);
            this.bSR.setBarNameClickEnabled(true);
        }
        int childCount = this.bSV.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bSV.getChildAt(i);
            if (childAt != null) {
                if (!this.bQT.aCw) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiR = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bSR != null) {
            this.bSR.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZP() {
        if (this.bQT != null && this.bQT.blk != null) {
            if (!ZB()) {
                m.jK(this.bQT.blk.getId());
                m.a(this.mTitle, this.bQT.Np().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                m.a(this.bSL, this.bQT.blk.getId(), d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bQT.blk, null, m.rj(), 18003, true, false, false).addLocateParam(this.bQT.aab());
            addLocateParam.setForumId(String.valueOf(this.bQT.blk.getFid()));
            addLocateParam.setForumName(this.bQT.blk.rz());
            if (this.bQT.bUF == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bQT.bUF);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ZB() {
        return this.bQT.bUY && !this.bQT.aCw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
