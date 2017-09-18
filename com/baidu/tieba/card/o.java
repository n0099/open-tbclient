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
    private boolean aje;
    private final View.OnClickListener aoc;
    public ClickableHeaderImageView aop;
    public ViewStub aor;
    public TbImageView aos;
    private final View.OnClickListener aou;
    private View axT;
    public View bKj;
    private com.baidu.tieba.card.data.l bKm;
    private View.OnClickListener bKn;
    public PlayVoiceBntNew bLV;
    private TextView bLW;
    private final View.OnClickListener bLY;
    public ThreadCommentAndPraiseInfoLayout bMc;
    private final String bMd;
    private final String bMe;
    private UserIconLayout bMf;
    private FrsCommonImageLayout bMg;
    private FrsCommonImageLayout.b bMh;
    private final View.OnClickListener bMi;
    private TbPageContext<?> mF;
    private int mSkinType;
    private TextView mTitle;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bMd = "1";
        this.bMe = "2";
        this.mSkinType = 3;
        this.aje = true;
        this.bKn = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.XL() != null) {
                    o.this.XL().a(view, o.this.bKm);
                }
                o.this.Yc();
            }
        };
        this.bMh = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.o.2
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void dv(int i) {
                o.this.Yc();
            }
        };
        this.bMi = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> XL = o.this.XL();
                if (XL != null) {
                    view.setTag("1");
                    XL.a(view, o.this.bKm);
                }
            }
        };
        this.bLY = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> XL = o.this.XL();
                if (XL != null) {
                    view.setTag("2");
                    XL.a(view, o.this.bKm);
                }
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.XL() != null) {
                    o.this.XL().a(view, o.this.bKm);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.XL() != null) {
                    o.this.XL().a(view, o.this.bKm);
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.axT = view.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.aop = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aor = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.aop.setDefaultResource(17170445);
        this.aop.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.aop.setDefaultBgResource(d.e.cp_bg_line_e);
        this.aop.setRadius(com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds70));
        this.bMf = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLV = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLV.setAfterClickListener(this.bLY);
        this.bLW = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bMg = (FrsCommonImageLayout) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bMg.setDrawNum(false);
        this.bMg.setAfterChildClickListener(this.bMi);
        this.bMc = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bKj = view.findViewById(d.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.k(this.axT, d.e.cp_bg_line_b);
            this.bMf.onChangeSkinType();
            this.bMc.onChangeSkinType();
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
        this.bKm = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bKn);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (this.bKm.bOb) {
            this.aop.setVisibility(8);
            this.bMf.setVisibility(8);
        } else {
            this.bMf.setVisibility(0);
            this.aop.setVisibility(0);
            this.aop.setData(lVar.threadData);
            this.aop.setAfterClickListener(this.aou);
            UserTbVipInfoData rB = this.bKm.threadData.rB();
            if (rB != null && rB.getvipV_url() != null && this.aor != null) {
                if (this.aos == null) {
                    this.aor.inflate();
                    this.aos = (TbImageView) getView().findViewById(d.h.user_head_mask);
                }
                this.aos.c(rB.getvipV_url(), 10, false);
                this.aop.setIsBigV(true);
            }
        }
        this.bMf.setData(lVar.threadData);
        this.bMf.setUserAfterClickListener(this.aou);
        this.bMc.setShareVisible(true);
        this.bMc.setShareReportFrom(3);
        if (this.bMc.c(lVar.threadData)) {
            this.bKj.setVisibility(8);
        }
        this.bMc.setForumAfterClickListener(this.aoc);
        this.bMc.setStType(m.rs());
        this.bMc.setYuelaouLocate("feed#" + lVar.Ym());
        this.bMc.setFrom(1);
        if ((StringUtils.isNull(lVar.threadData.getTitle()) && (lVar.threadData.rz() == null || lVar.threadData.rz().size() == 0)) || lVar.threadData.rQ() == 1) {
            lVar.threadData.e(false, true);
            if (lVar.threadData.sb() == null || StringUtils.isNull(lVar.threadData.sb().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(lVar.threadData.sb());
            }
        } else {
            this.mTitle.setVisibility(0);
            lVar.threadData.Yv = 0;
            lVar.threadData.sj();
            SpannableStringBuilder sb = lVar.threadData.sb();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(sb));
            this.mTitle.setText(sb);
            if (!XP()) {
                m.a(this.mTitle, lVar.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            } else {
                aj.i(this.mTitle, d.e.cp_cont_b);
            }
        }
        if (!XP() && m.jv(lVar.threadData.getId())) {
            m.a(this.mTitle, this.bKm.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLW, this.bKm.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.threadData.rJ() != null && !StringUtils.isNull(lVar.threadData.rJ())) {
            stringBuffer.append(lVar.threadData.rJ());
        }
        ArrayList<MediaData> rL = lVar.threadData.rL();
        if (rL != null) {
            i = rL.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rL.get(i4).getVideoUrl() != null && rL.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rL.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(lVar.threadData.g(stringBuffer.toString(), true))) {
                this.bLW.setVisibility(0);
                SpannableString cE = lVar.threadData.cE(stringBuffer.toString());
                this.bLW.setOnTouchListener(new com.baidu.tieba.view.m(cE));
                this.bLW.setText(cE);
                if (!XP()) {
                    m.a(this.bLW, lVar.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                } else {
                    aj.i(this.bLW, d.e.cp_cont_j);
                }
            } else {
                this.bLW.setVisibility(8);
            }
        } else {
            this.bLW.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rP = lVar.threadData.rP();
        if (rP != null && rP.size() > 0) {
            this.bLV.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rP.get(0);
            this.bLV.setVoiceModel(voiceModel);
            this.bLV.setTag(voiceModel);
            this.bLV.bhC();
            if (voiceModel != null) {
                this.bLV.nl(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bLV.setVisibility(8);
            z = false;
        }
        if (this.bKm.bOb && z) {
            this.bMg.setVisibility(8);
        } else if (com.baidu.tbadk.core.h.oS().oY() && com.baidu.tbadk.core.util.v.u(rL) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rL.get(i5) == null || !(rL.get(i5).getType() == 3 || rL.get(i5).getType() == 5)) {
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
                    if (rL.get(i9).getType() == 3 || rL.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rL.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bMg.setVisibility(0);
                this.bMg.a(lVar.threadData, lVar.threadData.rG(), lVar.threadData.getFid() + "", lVar.threadData.getTid());
                this.bMg.setShowBig(an.vO().vQ());
                this.bMg.a(this.mF, mediaDataArr, i6);
                this.bMg.setFromCDN(this.aje);
                this.bMg.setImageFrom("other");
            } else {
                this.bMg.setVisibility(8);
            }
        } else {
            this.bMg.setVisibility(8);
        }
        Yb();
    }

    private void Yb() {
        if (!this.bKm.aCG) {
            this.bMg.setOnChildClickListener(this.bMh);
            this.bLV.setClickable(false);
            this.bMc.setBarNameClickEnabled(false);
        } else {
            this.bMg.setOnChildClickListener(null);
            this.bLV.setClickable(true);
            this.bMc.setBarNameClickEnabled(true);
        }
        int childCount = this.bMg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bMg.getChildAt(i);
            if (childAt != null) {
                if (!this.bKm.aCG) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aje = z;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bMc != null) {
            this.bMc.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yc() {
        if (this.bKm != null && this.bKm.threadData != null) {
            if (!XP()) {
                m.ju(this.bKm.threadData.getId());
                m.a(this.mTitle, this.bKm.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bLW, this.bKm.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.bKm.threadData, null, m.rs(), 18003, true, false, false).addLocateParam(this.bKm.Yn());
            addLocateParam.setForumId(String.valueOf(this.bKm.threadData.getFid()));
            addLocateParam.setForumName(this.bKm.threadData.rG());
            if (this.bKm.bNJ == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bKm.bNJ);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XP() {
        return this.bKm.bOb && !this.bKm.aCG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
