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
    private boolean aiG;
    public ClickableHeaderImageView anE;
    public ViewStub anG;
    public TbImageView anH;
    private final View.OnClickListener anJ;
    private final View.OnClickListener anr;
    private View axd;
    private View.OnClickListener bJA;
    private com.baidu.tieba.card.data.l bJz;
    public View bKw;
    private final String bLA;
    private final String bLB;
    private UserIconLayout bLC;
    private FrsCommonImageLayout bLD;
    private FrsCommonImageLayout.b bLE;
    private final View.OnClickListener bLF;
    public PlayVoiceBntNew bLr;
    private TextView bLt;
    private final View.OnClickListener bLv;
    public ThreadCommentAndPraiseInfoLayout bLz;
    private TbPageContext<?> mG;
    private int mSkinType;
    private TextView mTitle;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bLA = "1";
        this.bLB = "2";
        this.mSkinType = 3;
        this.aiG = true;
        this.bJA = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Xr() != null) {
                    o.this.Xr().a(view, o.this.bJz);
                }
                o.this.XJ();
            }
        };
        this.bLE = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.o.2
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void dF(int i) {
                o.this.XJ();
            }
        };
        this.bLF = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Xr = o.this.Xr();
                if (Xr != null) {
                    view.setTag("1");
                    Xr.a(view, o.this.bJz);
                }
            }
        };
        this.bLv = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Xr = o.this.Xr();
                if (Xr != null) {
                    view.setTag("2");
                    Xr.a(view, o.this.bJz);
                }
            }
        };
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Xr() != null) {
                    o.this.Xr().a(view, o.this.bJz);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Xr() != null) {
                    o.this.Xr().a(view, o.this.bJz);
                }
            }
        };
        View view = getView();
        this.mG = tbPageContext;
        this.axd = view.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.anE = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.anG = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.anE.setDefaultResource(17170445);
        this.anE.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.anE.setDefaultBgResource(d.e.cp_bg_line_e);
        this.anE.setRadius(com.baidu.adp.lib.util.l.f(this.mG.getPageActivity(), d.f.ds70));
        this.bLC = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLr = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLr.setAfterClickListener(this.bLv);
        this.bLt = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLD = (FrsCommonImageLayout) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bLD.setDrawNum(false);
        this.bLD.setAfterChildClickListener(this.bLF);
        this.bLz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bKw = view.findViewById(d.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.k(this.axd, d.e.cp_bg_line_b);
            this.bLC.onChangeSkinType();
            this.bLz.onChangeSkinType();
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
        this.bJz = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJA);
        }
        d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        if (this.bJz.bNG) {
            this.anE.setVisibility(8);
            this.bLC.setVisibility(8);
        } else {
            this.bLC.setVisibility(0);
            this.anE.setVisibility(0);
            this.anE.setData(lVar.threadData);
            this.anE.setAfterClickListener(this.anJ);
            UserTbVipInfoData rv = this.bJz.threadData.rv();
            if (rv != null && rv.getvipV_url() != null && this.anG != null) {
                if (this.anH == null) {
                    this.anG.inflate();
                    this.anH = (TbImageView) getView().findViewById(d.h.user_head_mask);
                }
                this.anH.c(rv.getvipV_url(), 10, false);
                this.anE.setIsBigV(true);
            }
        }
        this.bLC.setData(lVar.threadData);
        this.bLC.setUserAfterClickListener(this.anJ);
        this.bLz.setShareVisible(true);
        this.bLz.setShareReportFrom(3);
        if (this.bLz.setData(lVar.threadData)) {
            this.bKw.setVisibility(8);
        }
        this.bLz.setForumAfterClickListener(this.anr);
        this.bLz.setStType(m.rm());
        this.bLz.setYuelaouLocate("feed#" + lVar.XU());
        this.bLz.setFrom(1);
        if ((StringUtils.isNull(lVar.threadData.getTitle()) && (lVar.threadData.rt() == null || lVar.threadData.rt().size() == 0)) || lVar.threadData.rK() == 1) {
            lVar.threadData.e(false, true);
            if (lVar.threadData.rV() == null || StringUtils.isNull(lVar.threadData.rV().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(lVar.threadData.rV());
            }
        } else {
            this.mTitle.setVisibility(0);
            lVar.threadData.Yw = 0;
            lVar.threadData.sd();
            SpannableStringBuilder rV = lVar.threadData.rV();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(rV));
            this.mTitle.setText(rV);
            if (!Xv()) {
                m.a(this.mTitle, lVar.Nj().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            } else {
                aj.i(this.mTitle, d.e.cp_cont_b);
            }
        }
        if (!Xv() && m.jn(lVar.threadData.getId())) {
            m.a(this.mTitle, this.bJz.Nj().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLt, this.bJz.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.threadData.rD() != null && !StringUtils.isNull(lVar.threadData.rD())) {
            stringBuffer.append(lVar.threadData.rD());
        }
        ArrayList<MediaData> rF = lVar.threadData.rF();
        if (rF != null) {
            i = rF.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rF.get(i4).getVideoUrl() != null && rF.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rF.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(lVar.threadData.g(stringBuffer.toString(), true))) {
                this.bLt.setVisibility(0);
                SpannableString cE = lVar.threadData.cE(stringBuffer.toString());
                this.bLt.setOnTouchListener(new com.baidu.tieba.view.k(cE));
                this.bLt.setText(cE);
                if (!Xv()) {
                    m.a(this.bLt, lVar.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                } else {
                    aj.i(this.bLt, d.e.cp_cont_j);
                }
            } else {
                this.bLt.setVisibility(8);
            }
        } else {
            this.bLt.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rJ = lVar.threadData.rJ();
        if (rJ != null && rJ.size() > 0) {
            this.bLr.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rJ.get(0);
            this.bLr.setVoiceModel(voiceModel);
            this.bLr.setTag(voiceModel);
            this.bLr.bgh();
            if (voiceModel != null) {
                this.bLr.nh(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bLr.setVisibility(8);
            z = false;
        }
        if (this.bJz.bNG && z) {
            this.bLD.setVisibility(8);
        } else if (com.baidu.tbadk.core.h.oT().oZ() && com.baidu.tbadk.core.util.v.t(rF) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rF.get(i5) == null || !(rF.get(i5).getType() == 3 || rF.get(i5).getType() == 5)) {
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
                    if (rF.get(i9).getType() == 3 || rF.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rF.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bLD.setVisibility(0);
                this.bLD.a(lVar.threadData, lVar.threadData.rA(), lVar.threadData.getFid() + "", lVar.threadData.getTid());
                this.bLD.setShowBig(an.vs().vu());
                this.bLD.a(this.mG, mediaDataArr, i6);
                this.bLD.setFromCDN(this.aiG);
                this.bLD.setImageFrom("other");
            } else {
                this.bLD.setVisibility(8);
            }
        } else {
            this.bLD.setVisibility(8);
        }
        XI();
    }

    private void XI() {
        if (!this.bJz.aCa) {
            this.bLD.setOnChildClickListener(this.bLE);
            this.bLr.setClickable(false);
            this.bLz.setBarNameClickEnabled(false);
        } else {
            this.bLD.setOnChildClickListener(null);
            this.bLr.setClickable(true);
            this.bLz.setBarNameClickEnabled(true);
        }
        int childCount = this.bLD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLD.getChildAt(i);
            if (childAt != null) {
                if (!this.bJz.aCa) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiG = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bLz != null) {
            this.bLz.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XJ() {
        if (this.bJz != null && this.bJz.threadData != null) {
            if (!Xv()) {
                m.jm(this.bJz.threadData.getId());
                m.a(this.mTitle, this.bJz.Nj().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bLt, this.bJz.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mG.getPageActivity()).createFromThreadCfg(this.bJz.threadData, null, m.rm(), 18003, true, false, false).addLocateParam(this.bJz.XV());
            addLocateParam.setForumId(String.valueOf(this.bJz.threadData.getFid()));
            addLocateParam.setForumName(this.bJz.threadData.rA());
            if (this.bJz.bNn == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bJz.bNn);
            }
            this.mG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xv() {
        return this.bJz.bNG && !this.bJz.aCa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
