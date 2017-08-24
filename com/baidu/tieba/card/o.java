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
    private View ayL;
    private com.baidu.tieba.card.data.l bGB;
    private View.OnClickListener bGC;
    public View bGy;
    public PlayVoiceBntNew bIk;
    private TextView bIl;
    private final View.OnClickListener bIn;
    public ThreadCommentAndPraiseInfoLayout bIr;
    private final String bIs;
    private final String bIt;
    private UserIconLayout bIu;
    private FrsCommonImageLayout bIv;
    private FrsCommonImageLayout.b bIw;
    private final View.OnClickListener bIx;
    private int mSkinType;
    private TextView mTitle;
    private TbPageContext<?> oW;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIs = "1";
        this.bIt = "2";
        this.mSkinType = 3;
        this.ajL = true;
        this.bGC = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Wx() != null) {
                    o.this.Wx().a(view, o.this.bGB);
                }
                o.this.WN();
            }
        };
        this.bIw = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.o.2
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void du(int i) {
                o.this.WN();
            }
        };
        this.bIx = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Wx = o.this.Wx();
                if (Wx != null) {
                    view.setTag("1");
                    Wx.a(view, o.this.bGB);
                }
            }
        };
        this.bIn = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Wx = o.this.Wx();
                if (Wx != null) {
                    view.setTag("2");
                    Wx.a(view, o.this.bGB);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Wx() != null) {
                    o.this.Wx().a(view, o.this.bGB);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Wx() != null) {
                    o.this.Wx().a(view, o.this.bGB);
                }
            }
        };
        View view = getView();
        this.oW = tbPageContext;
        this.ayL = view.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.aoS = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aoU = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.aoS.setDefaultResource(17170445);
        this.aoS.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.aoS.setDefaultBgResource(d.e.cp_bg_line_e);
        this.aoS.setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
        this.bIu = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bIk = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bIk.setAfterClickListener(this.bIn);
        this.bIl = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bIv = (FrsCommonImageLayout) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bIv.setDrawNum(false);
        this.bIv.setAfterChildClickListener(this.bIx);
        this.bIr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bGy = view.findViewById(d.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.k(this.ayL, d.e.cp_bg_line_b);
            this.bIu.onChangeSkinType();
            this.bIr.onChangeSkinType();
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
        this.bGB = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGC);
        }
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        if (this.bGB.bKs) {
            this.aoS.setVisibility(8);
            this.bIu.setVisibility(8);
        } else {
            this.bIu.setVisibility(0);
            this.aoS.setVisibility(0);
            this.aoS.setData(lVar.threadData);
            this.aoS.setAfterClickListener(this.aoX);
            UserTbVipInfoData rG = this.bGB.threadData.rG();
            if (rG != null && rG.getvipV_url() != null && this.aoU != null) {
                if (this.aoV == null) {
                    this.aoU.inflate();
                    this.aoV = (TbImageView) getView().findViewById(d.h.user_head_mask);
                }
                this.aoV.c(rG.getvipV_url(), 10, false);
                this.aoS.setIsBigV(true);
            }
        }
        this.bIu.setData(lVar.threadData);
        this.bIu.setUserAfterClickListener(this.aoX);
        if (this.bIr.a(lVar.threadData)) {
            this.bGy.setVisibility(8);
        }
        this.bIr.setForumAfterClickListener(this.aoH);
        this.bIr.setStType(m.rx());
        this.bIr.setYuelaouLocate("feed#" + lVar.WY());
        if ((StringUtils.isNull(lVar.threadData.getTitle()) && (lVar.threadData.rE() == null || lVar.threadData.rE().size() == 0)) || lVar.threadData.rV() == 1) {
            lVar.threadData.e(false, true);
            if (lVar.threadData.sg() == null || StringUtils.isNull(lVar.threadData.sg().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(lVar.threadData.sg());
            }
        } else {
            this.mTitle.setVisibility(0);
            lVar.threadData.Zr = 0;
            lVar.threadData.so();
            SpannableStringBuilder sg = lVar.threadData.sg();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(sg));
            this.mTitle.setText(sg);
            if (!WB()) {
                m.a(this.mTitle, lVar.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            } else {
                ai.i(this.mTitle, d.e.cp_cont_b);
            }
        }
        if (!WB() && m.ji(lVar.threadData.getId())) {
            m.a(this.mTitle, this.bGB.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIl, this.bGB.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.threadData.rO() != null && !StringUtils.isNull(lVar.threadData.rO())) {
            stringBuffer.append(lVar.threadData.rO());
        }
        ArrayList<MediaData> rQ = lVar.threadData.rQ();
        if (rQ != null) {
            i = rQ.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rQ.get(i4).getVideoUrl() != null && rQ.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rQ.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(lVar.threadData.g(stringBuffer.toString(), true))) {
                this.bIl.setVisibility(0);
                SpannableString cO = lVar.threadData.cO(stringBuffer.toString());
                this.bIl.setOnTouchListener(new com.baidu.tieba.view.l(cO));
                this.bIl.setText(cO);
                if (!WB()) {
                    m.a(this.bIl, lVar.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                } else {
                    ai.i(this.bIl, d.e.cp_cont_j);
                }
            } else {
                this.bIl.setVisibility(8);
            }
        } else {
            this.bIl.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rU = lVar.threadData.rU();
        if (rU != null && rU.size() > 0) {
            this.bIk.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rU.get(0);
            this.bIk.setVoiceModel(voiceModel);
            this.bIk.setTag(voiceModel);
            this.bIk.bis();
            if (voiceModel != null) {
                this.bIk.mQ(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bIk.setVisibility(8);
            z = false;
        }
        if (this.bGB.bKs && z) {
            this.bIv.setVisibility(8);
        } else if (com.baidu.tbadk.core.h.oY().pe() && com.baidu.tbadk.core.util.u.u(rQ) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rQ.get(i5) == null || !(rQ.get(i5).getType() == 3 || rQ.get(i5).getType() == 5)) {
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
                    if (rQ.get(i9).getType() == 3 || rQ.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rQ.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bIv.setVisibility(0);
                this.bIv.a(lVar.threadData, lVar.threadData.rL(), lVar.threadData.getFid() + "", lVar.threadData.getTid());
                this.bIv.setShowBig(am.vR().vT());
                this.bIv.a(this.oW, mediaDataArr, i6);
                this.bIv.setFromCDN(this.ajL);
                this.bIv.setImageFrom("other");
            } else {
                this.bIv.setVisibility(8);
            }
        } else {
            this.bIv.setVisibility(8);
        }
        WM();
    }

    private void WM() {
        if (!this.bGB.aDw) {
            this.bIv.setOnChildClickListener(this.bIw);
            this.bIk.setClickable(false);
            this.bIr.setBarNameClickEnabled(false);
        } else {
            this.bIv.setOnChildClickListener(null);
            this.bIk.setClickable(true);
            this.bIr.setBarNameClickEnabled(true);
        }
        int childCount = this.bIv.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIv.getChildAt(i);
            if (childAt != null) {
                if (!this.bGB.aDw) {
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
        if (bdUniqueId != null && this.bIr != null) {
            this.bIr.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN() {
        if (this.bGB != null && this.bGB.threadData != null) {
            if (!WB()) {
                m.jh(this.bGB.threadData.getId());
                m.a(this.mTitle, this.bGB.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bIl, this.bGB.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.oW.getPageActivity()).createFromThreadCfg(this.bGB.threadData, null, m.rx(), 18003, true, false, false).addLocateParam(this.bGB.WZ());
            addLocateParam.setForumId(String.valueOf(this.bGB.threadData.getFid()));
            addLocateParam.setForumName(this.bGB.threadData.rL());
            if (this.bGB.bKa == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bGB.bKa);
            }
            this.oW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean WB() {
        return this.bGB.bKs && !this.bGB.aDw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
