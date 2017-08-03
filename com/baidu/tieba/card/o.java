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
    private boolean aiq;
    private TbPageContext<?> ako;
    public ViewStub anA;
    public TbImageView anB;
    private final View.OnClickListener anD;
    private final View.OnClickListener ann;
    public ClickableHeaderImageView any;
    private View axs;
    public View bEE;
    private com.baidu.tieba.card.data.l bEH;
    private View.OnClickListener bEI;
    private UserIconLayout bGA;
    private FrsCommonImageLayout bGB;
    private FrsCommonImageLayout.b bGC;
    private final View.OnClickListener bGD;
    public PlayVoiceBntNew bGq;
    private TextView bGr;
    private final View.OnClickListener bGt;
    public ThreadCommentAndPraiseInfoLayout bGx;
    private final String bGy;
    private final String bGz;
    private int mSkinType;
    private TextView mTitle;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGy = "1";
        this.bGz = "2";
        this.mSkinType = 3;
        this.aiq = true;
        this.bEI = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.VZ() != null) {
                    o.this.VZ().a(view, o.this.bEH);
                }
                o.this.Wp();
            }
        };
        this.bGC = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.o.2
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void ds(int i) {
                o.this.Wp();
            }
        };
        this.bGD = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> VZ = o.this.VZ();
                if (VZ != null) {
                    view.setTag("1");
                    VZ.a(view, o.this.bEH);
                }
            }
        };
        this.bGt = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> VZ = o.this.VZ();
                if (VZ != null) {
                    view.setTag("2");
                    VZ.a(view, o.this.bEH);
                }
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.VZ() != null) {
                    o.this.VZ().a(view, o.this.bEH);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.VZ() != null) {
                    o.this.VZ().a(view, o.this.bEH);
                }
            }
        };
        View view = getView();
        this.ako = tbPageContext;
        this.axs = view.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.any = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.anA = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.any.setDefaultResource(17170445);
        this.any.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.any.setDefaultBgResource(d.e.cp_bg_line_e);
        this.any.setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
        this.bGA = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bGq = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bGq.setAfterClickListener(this.bGt);
        this.bGr = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bGB = (FrsCommonImageLayout) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bGB.setDrawNum(false);
        this.bGB.setAfterChildClickListener(this.bGD);
        this.bGx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bEE = view.findViewById(d.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.k(this.axs, d.e.cp_bg_line_b);
            this.bGA.onChangeSkinType();
            this.bGx.onChangeSkinType();
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
        this.bEH = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bEI);
        }
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        if (this.bEH.bIy) {
            this.any.setVisibility(8);
            this.bGA.setVisibility(8);
        } else {
            this.bGA.setVisibility(0);
            this.any.setVisibility(0);
            this.any.setData(lVar.threadData);
            this.any.setAfterClickListener(this.anD);
            UserTbVipInfoData rv = this.bEH.threadData.rv();
            if (rv != null && rv.getvipV_url() != null && this.anA != null) {
                if (this.anB == null) {
                    this.anA.inflate();
                    this.anB = (TbImageView) getView().findViewById(d.h.user_head_mask);
                }
                this.anB.c(rv.getvipV_url(), 10, false);
                this.any.setIsBigV(true);
            }
        }
        this.bGA.setData(lVar.threadData);
        this.bGA.setUserAfterClickListener(this.anD);
        if (this.bGx.a(lVar.threadData)) {
            this.bEE.setVisibility(8);
        }
        this.bGx.setForumAfterClickListener(this.ann);
        this.bGx.setStType(m.rm());
        this.bGx.setYuelaouLocate("feed#" + lVar.WA());
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
            lVar.threadData.XS = 0;
            lVar.threadData.sd();
            SpannableStringBuilder rV = lVar.threadData.rV();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(rV));
            this.mTitle.setText(rV);
            if (!Wd()) {
                m.a(this.mTitle, lVar.MA().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            } else {
                ai.i(this.mTitle, d.e.cp_cont_b);
            }
        }
        if (!Wd() && m.iZ(lVar.threadData.getId())) {
            m.a(this.mTitle, this.bEH.MA().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGr, this.bEH.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
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
                this.bGr.setVisibility(0);
                SpannableString cF = lVar.threadData.cF(stringBuffer.toString());
                this.bGr.setOnTouchListener(new com.baidu.tieba.view.l(cF));
                this.bGr.setText(cF);
                if (!Wd()) {
                    m.a(this.bGr, lVar.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                } else {
                    ai.i(this.bGr, d.e.cp_cont_j);
                }
            } else {
                this.bGr.setVisibility(8);
            }
        } else {
            this.bGr.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rJ = lVar.threadData.rJ();
        if (rJ != null && rJ.size() > 0) {
            this.bGq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rJ.get(0);
            this.bGq.setVoiceModel(voiceModel);
            this.bGq.setTag(voiceModel);
            this.bGq.bhH();
            if (voiceModel != null) {
                this.bGq.mG(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bGq.setVisibility(8);
            z = false;
        }
        if (this.bEH.bIy && z) {
            this.bGB.setVisibility(8);
        } else if (com.baidu.tbadk.core.h.oN().oT() && com.baidu.tbadk.core.util.u.u(rF) != 0) {
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
                this.bGB.setVisibility(0);
                this.bGB.a(lVar.threadData, lVar.threadData.rA(), lVar.threadData.getFid() + "", lVar.threadData.getTid());
                this.bGB.setShowBig(am.vG().vI());
                this.bGB.a(this.ako, mediaDataArr, i6);
                this.bGB.setFromCDN(this.aiq);
                this.bGB.setImageFrom("other");
            } else {
                this.bGB.setVisibility(8);
            }
        } else {
            this.bGB.setVisibility(8);
        }
        Wo();
    }

    private void Wo() {
        if (!this.bEH.aCd) {
            this.bGB.setOnChildClickListener(this.bGC);
            this.bGq.setClickable(false);
            this.bGx.setBarNameClickEnabled(false);
        } else {
            this.bGB.setOnChildClickListener(null);
            this.bGq.setClickable(true);
            this.bGx.setBarNameClickEnabled(true);
        }
        int childCount = this.bGB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bGB.getChildAt(i);
            if (childAt != null) {
                if (!this.bEH.aCd) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiq = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bGx != null) {
            this.bGx.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wp() {
        if (this.bEH != null && this.bEH.threadData != null) {
            if (!Wd()) {
                m.iY(this.bEH.threadData.getId());
                m.a(this.mTitle, this.bEH.MA().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bGr, this.bEH.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ako.getPageActivity()).createFromThreadCfg(this.bEH.threadData, null, m.rm(), 18003, true, false, false).addLocateParam(this.bEH.WB());
            addLocateParam.setForumId(String.valueOf(this.bEH.threadData.getFid()));
            addLocateParam.setForumName(this.bEH.threadData.rA());
            if (this.bEH.bIg == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bEH.bIg);
            }
            this.ako.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wd() {
        return this.bEH.bIy && !this.bEH.aCd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
