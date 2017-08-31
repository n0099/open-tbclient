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
    private boolean ajf;
    private final View.OnClickListener aoe;
    public ClickableHeaderImageView aor;
    public ViewStub aot;
    public TbImageView aou;
    private final View.OnClickListener aow;
    private View axW;
    public View bJs;
    private com.baidu.tieba.card.data.l bJv;
    private View.OnClickListener bJw;
    public PlayVoiceBntNew bLe;
    private TextView bLf;
    private final View.OnClickListener bLh;
    public ThreadCommentAndPraiseInfoLayout bLl;
    private final String bLm;
    private final String bLn;
    private UserIconLayout bLo;
    private FrsCommonImageLayout bLp;
    private FrsCommonImageLayout.b bLq;
    private final View.OnClickListener bLr;
    private TbPageContext<?> mF;
    private int mSkinType;
    private TextView mTitle;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bLm = "1";
        this.bLn = "2";
        this.mSkinType = 3;
        this.ajf = true;
        this.bJw = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.XA() != null) {
                    o.this.XA().a(view, o.this.bJv);
                }
                o.this.XR();
            }
        };
        this.bLq = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.o.2
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void dv(int i) {
                o.this.XR();
            }
        };
        this.bLr = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> XA = o.this.XA();
                if (XA != null) {
                    view.setTag("1");
                    XA.a(view, o.this.bJv);
                }
            }
        };
        this.bLh = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> XA = o.this.XA();
                if (XA != null) {
                    view.setTag("2");
                    XA.a(view, o.this.bJv);
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.XA() != null) {
                    o.this.XA().a(view, o.this.bJv);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.XA() != null) {
                    o.this.XA().a(view, o.this.bJv);
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.axW = view.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.aor = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aot = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.aor.setDefaultResource(17170445);
        this.aor.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.aor.setDefaultBgResource(d.e.cp_bg_line_e);
        this.aor.setRadius(com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds70));
        this.bLo = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLe = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLe.setAfterClickListener(this.bLh);
        this.bLf = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLp = (FrsCommonImageLayout) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bLp.setDrawNum(false);
        this.bLp.setAfterChildClickListener(this.bLr);
        this.bLl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bJs = view.findViewById(d.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.k(this.axW, d.e.cp_bg_line_b);
            this.bLo.onChangeSkinType();
            this.bLl.onChangeSkinType();
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
        this.bJv = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJw);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        if (this.bJv.bNk) {
            this.aor.setVisibility(8);
            this.bLo.setVisibility(8);
        } else {
            this.bLo.setVisibility(0);
            this.aor.setVisibility(0);
            this.aor.setData(lVar.threadData);
            this.aor.setAfterClickListener(this.aow);
            UserTbVipInfoData rB = this.bJv.threadData.rB();
            if (rB != null && rB.getvipV_url() != null && this.aot != null) {
                if (this.aou == null) {
                    this.aot.inflate();
                    this.aou = (TbImageView) getView().findViewById(d.h.user_head_mask);
                }
                this.aou.c(rB.getvipV_url(), 10, false);
                this.aor.setIsBigV(true);
            }
        }
        this.bLo.setData(lVar.threadData);
        this.bLo.setUserAfterClickListener(this.aow);
        this.bLl.setShareVisible(true);
        this.bLl.setShareReportFrom(3);
        if (this.bLl.c(lVar.threadData)) {
            this.bJs.setVisibility(8);
        }
        this.bLl.setForumAfterClickListener(this.aoe);
        this.bLl.setStType(m.rs());
        this.bLl.setYuelaouLocate("feed#" + lVar.Yb());
        this.bLl.setFrom(1);
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
            if (!XE()) {
                m.a(this.mTitle, lVar.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            } else {
                aj.i(this.mTitle, d.e.cp_cont_b);
            }
        }
        if (!XE() && m.jt(lVar.threadData.getId())) {
            m.a(this.mTitle, this.bJv.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLf, this.bJv.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
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
                this.bLf.setVisibility(0);
                SpannableString cE = lVar.threadData.cE(stringBuffer.toString());
                this.bLf.setOnTouchListener(new com.baidu.tieba.view.m(cE));
                this.bLf.setText(cE);
                if (!XE()) {
                    m.a(this.bLf, lVar.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                } else {
                    aj.i(this.bLf, d.e.cp_cont_j);
                }
            } else {
                this.bLf.setVisibility(8);
            }
        } else {
            this.bLf.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rP = lVar.threadData.rP();
        if (rP != null && rP.size() > 0) {
            this.bLe.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rP.get(0);
            this.bLe.setVoiceModel(voiceModel);
            this.bLe.setTag(voiceModel);
            this.bLe.bhr();
            if (voiceModel != null) {
                this.bLe.nj(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bLe.setVisibility(8);
            z = false;
        }
        if (this.bJv.bNk && z) {
            this.bLp.setVisibility(8);
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
                this.bLp.setVisibility(0);
                this.bLp.a(lVar.threadData, lVar.threadData.rG(), lVar.threadData.getFid() + "", lVar.threadData.getTid());
                this.bLp.setShowBig(an.vO().vQ());
                this.bLp.a(this.mF, mediaDataArr, i6);
                this.bLp.setFromCDN(this.ajf);
                this.bLp.setImageFrom("other");
            } else {
                this.bLp.setVisibility(8);
            }
        } else {
            this.bLp.setVisibility(8);
        }
        XQ();
    }

    private void XQ() {
        if (!this.bJv.aCJ) {
            this.bLp.setOnChildClickListener(this.bLq);
            this.bLe.setClickable(false);
            this.bLl.setBarNameClickEnabled(false);
        } else {
            this.bLp.setOnChildClickListener(null);
            this.bLe.setClickable(true);
            this.bLl.setBarNameClickEnabled(true);
        }
        int childCount = this.bLp.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLp.getChildAt(i);
            if (childAt != null) {
                if (!this.bJv.aCJ) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajf = z;
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bLl != null) {
            this.bLl.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XR() {
        if (this.bJv != null && this.bJv.threadData != null) {
            if (!XE()) {
                m.js(this.bJv.threadData.getId());
                m.a(this.mTitle, this.bJv.MR().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bLf, this.bJv.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mF.getPageActivity()).createFromThreadCfg(this.bJv.threadData, null, m.rs(), 18003, true, false, false).addLocateParam(this.bJv.Yc());
            addLocateParam.setForumId(String.valueOf(this.bJv.threadData.getFid()));
            addLocateParam.setForumName(this.bJv.threadData.rG());
            if (this.bJv.bMS == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bJv.bMS);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean XE() {
        return this.bJv.bNk && !this.bJv.aCJ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
