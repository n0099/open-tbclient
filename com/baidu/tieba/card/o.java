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
    public ClickableHeaderImageView anM;
    public ViewStub anO;
    public TbImageView anP;
    private final View.OnClickListener anR;
    private final View.OnClickListener anz;
    private View axw;
    private com.baidu.tieba.card.data.l bRg;
    private View.OnClickListener bRh;
    public PlayVoiceBntNew bSW;
    private TextView bSY;
    public View bSd;
    private final View.OnClickListener bTa;
    public ThreadCommentAndPraiseInfoLayout bTe;
    private final String bTf;
    private final String bTg;
    private UserIconLayout bTh;
    private FrsCommonImageLayout bTi;
    private FrsCommonImageLayout.b bTj;
    private final View.OnClickListener bTk;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bTf = "1";
        this.bTg = "2";
        this.mSkinType = 3;
        this.aiR = true;
        this.bRh = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.ZJ() != null) {
                    o.this.ZJ().a(view, o.this.bRg);
                }
                o.this.aab();
            }
        };
        this.bTj = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.o.2
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void dE(int i) {
                o.this.aab();
            }
        };
        this.bTk = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> ZJ = o.this.ZJ();
                if (ZJ != null) {
                    view.setTag("1");
                    ZJ.a(view, o.this.bRg);
                }
            }
        };
        this.bTa = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> ZJ = o.this.ZJ();
                if (ZJ != null) {
                    view.setTag("2");
                    ZJ.a(view, o.this.bRg);
                }
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.ZJ() != null) {
                    o.this.ZJ().a(view, o.this.bRg);
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.ZJ() != null) {
                    o.this.ZJ().a(view, o.this.bRg);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.axw = view.findViewById(d.g.card_home_page_normal_thread_top_line);
        this.anM = (ClickableHeaderImageView) view.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.anO = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.anM.setDefaultResource(17170445);
        this.anM.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.anM.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        this.anM.setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        this.bTh = (UserIconLayout) view.findViewById(d.g.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.bSW = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.bSW.setAfterClickListener(this.bTa);
        this.bSY = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.bTi = (FrsCommonImageLayout) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.bTi.setDrawNum(false);
        this.bTi.setAfterChildClickListener(this.bTk);
        this.bTe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bTe.getBarNameTv().setMaxWidth(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds120));
        this.bSd = view.findViewById(d.g.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.home_thread_card_item_bg);
            aj.k(this.axw, d.C0080d.cp_bg_line_b);
            this.bTh.onChangeSkinType();
            this.bTe.onChangeSkinType();
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
        if (lVar == null || lVar.blt == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bRg = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bRh);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.bRg.bVl) {
            this.anM.setVisibility(8);
            this.bTh.setVisibility(8);
        } else {
            this.bTh.setVisibility(0);
            this.anM.setVisibility(0);
            this.anM.setData(lVar.blt);
            this.anM.setAfterClickListener(this.anR);
            UserTbVipInfoData ru = this.bRg.blt.ru();
            if (ru != null && ru.getvipV_url() != null && this.anO != null) {
                if (this.anP == null) {
                    this.anO.inflate();
                    this.anP = (TbImageView) getView().findViewById(d.g.user_head_mask);
                }
                this.anP.startLoad(ru.getvipV_url(), 10, false);
                this.anM.setIsBigV(true);
            }
        }
        this.bTh.setData(lVar.blt);
        this.bTh.setUserAfterClickListener(this.anR);
        this.bTe.setShareVisible(true);
        this.bTe.setShareReportFrom(3);
        if (this.bTe.setData(lVar.blt)) {
            this.bSd.setVisibility(8);
        }
        this.bTe.setForumAfterClickListener(this.anz);
        this.bTe.setStType(m.rj());
        this.bTe.setYuelaouLocate("feed#" + lVar.aam());
        this.bTe.setFrom(1);
        if ((StringUtils.isNull(lVar.blt.getTitle()) && (lVar.blt.rr() == null || lVar.blt.rr().size() == 0)) || lVar.blt.rJ() == 1) {
            lVar.blt.e(false, true);
            if (lVar.blt.rU() == null || StringUtils.isNull(lVar.blt.rU().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(lVar.blt.rU());
            }
        } else {
            this.mTitle.setVisibility(0);
            lVar.blt.YC = 0;
            lVar.blt.sc();
            SpannableStringBuilder rU = lVar.blt.rU();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(rU));
            this.mTitle.setText(rU);
            if (!ZN()) {
                m.a(this.mTitle, lVar.NA().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            } else {
                aj.i(this.mTitle, d.C0080d.cp_cont_b);
            }
        }
        if (!ZN() && m.jM(lVar.blt.getId())) {
            m.a(this.mTitle, this.bRg.NA().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSY, this.bRg.blt.getId(), d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.blt.getAbstract() != null && !StringUtils.isNull(lVar.blt.getAbstract())) {
            stringBuffer.append(lVar.blt.getAbstract());
        }
        ArrayList<MediaData> rE = lVar.blt.rE();
        if (rE != null) {
            i = rE.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rE.get(i4).getVideoUrl() != null && rE.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rE.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(lVar.blt.g(stringBuffer.toString(), true))) {
                this.bSY.setVisibility(0);
                SpannableString cJ = lVar.blt.cJ(stringBuffer.toString());
                this.bSY.setOnTouchListener(new com.baidu.tieba.view.l(cJ));
                this.bSY.setText(cJ);
                if (!ZN()) {
                    m.a(this.bSY, lVar.blt.getId(), d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
                } else {
                    aj.i(this.bSY, d.C0080d.cp_cont_j);
                }
            } else {
                this.bSY.setVisibility(8);
            }
        } else {
            this.bSY.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rI = lVar.blt.rI();
        if (rI != null && rI.size() > 0) {
            this.bSW.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bSW.setVoiceModel(voiceModel);
            this.bSW.setTag(voiceModel);
            this.bSW.bjz();
            if (voiceModel != null) {
                this.bSW.ny(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bSW.setVisibility(8);
            z = false;
        }
        if (this.bRg.bVl && z) {
            this.bTi.setVisibility(8);
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
                this.bTi.setVisibility(0);
                this.bTi.a(lVar.blt, lVar.blt.rz(), lVar.blt.getFid() + "", lVar.blt.getTid());
                this.bTi.setShowBig(an.vs().vu());
                this.bTi.a(this.mPageContext, mediaDataArr, i6);
                this.bTi.setFromCDN(this.aiR);
                this.bTi.setImageFrom("other");
            } else {
                this.bTi.setVisibility(8);
            }
        } else {
            this.bTi.setVisibility(8);
        }
        aaa();
    }

    private void aaa() {
        if (!this.bRg.aCE) {
            this.bTi.setOnChildClickListener(this.bTj);
            this.bSW.setClickable(false);
            this.bTe.setBarNameClickEnabled(false);
        } else {
            this.bTi.setOnChildClickListener(null);
            this.bSW.setClickable(true);
            this.bTe.setBarNameClickEnabled(true);
        }
        int childCount = this.bTi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bTi.getChildAt(i);
            if (childAt != null) {
                if (!this.bRg.aCE) {
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
        if (bdUniqueId != null && this.bTe != null) {
            this.bTe.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        if (this.bRg != null && this.bRg.blt != null) {
            if (!ZN()) {
                m.jL(this.bRg.blt.getId());
                m.a(this.mTitle, this.bRg.NA().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                m.a(this.bSY, this.bRg.blt.getId(), d.C0080d.cp_cont_j, d.C0080d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bRg.blt, null, m.rj(), 18003, true, false, false).addLocateParam(this.bRg.aan());
            addLocateParam.setForumId(String.valueOf(this.bRg.blt.getFid()));
            addLocateParam.setForumName(this.bRg.blt.rz());
            if (this.bRg.bUS == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bRg.bUS);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ZN() {
        return this.bRg.bVl && !this.bRg.aCE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
