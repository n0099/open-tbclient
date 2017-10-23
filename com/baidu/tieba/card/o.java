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
    private boolean aiu;
    private final View.OnClickListener anf;
    public ClickableHeaderImageView ans;
    public ViewStub anu;
    public TbImageView anv;
    private final View.OnClickListener anx;
    private View awR;
    private com.baidu.tieba.card.data.l bJn;
    private View.OnClickListener bJo;
    public View bKk;
    public PlayVoiceBntNew bLf;
    private TextView bLh;
    private final View.OnClickListener bLj;
    public ThreadCommentAndPraiseInfoLayout bLn;
    private final String bLo;
    private final String bLp;
    private UserIconLayout bLq;
    private FrsCommonImageLayout bLr;
    private FrsCommonImageLayout.b bLs;
    private final View.OnClickListener bLt;
    private TbPageContext<?> mH;
    private int mSkinType;
    private TextView mTitle;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bLo = "1";
        this.bLp = "2";
        this.mSkinType = 3;
        this.aiu = true;
        this.bJo = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Xn() != null) {
                    o.this.Xn().a(view, o.this.bJn);
                }
                o.this.XF();
            }
        };
        this.bLs = new FrsCommonImageLayout.b() { // from class: com.baidu.tieba.card.o.2
            @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.b
            public void dE(int i) {
                o.this.XF();
            }
        };
        this.bLt = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Xn = o.this.Xn();
                if (Xn != null) {
                    view.setTag("1");
                    Xn.a(view, o.this.bJn);
                }
            }
        };
        this.bLj = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Xn = o.this.Xn();
                if (Xn != null) {
                    view.setTag("2");
                    Xn.a(view, o.this.bJn);
                }
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Xn() != null) {
                    o.this.Xn().a(view, o.this.bJn);
                }
            }
        };
        this.anf = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.Xn() != null) {
                    o.this.Xn().a(view, o.this.bJn);
                }
            }
        };
        View view = getView();
        this.mH = tbPageContext;
        this.awR = view.findViewById(d.h.card_home_page_normal_thread_top_line);
        this.ans = (ClickableHeaderImageView) view.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.anu = (ViewStub) view.findViewById(d.h.viewstub_headimage_mask);
        this.ans.setDefaultResource(17170445);
        this.ans.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.ans.setDefaultBgResource(d.e.cp_bg_line_e);
        this.ans.setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds70));
        this.bLq = (UserIconLayout) view.findViewById(d.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLf = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLf.setAfterClickListener(this.bLj);
        this.bLh = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLr = (FrsCommonImageLayout) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bLr.setDrawNum(false);
        this.bLr.setAfterChildClickListener(this.bLt);
        this.bLn = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bKk = view.findViewById(d.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.home_thread_card_item_bg);
            aj.k(this.awR, d.e.cp_bg_line_b);
            this.bLq.onChangeSkinType();
            this.bLn.onChangeSkinType();
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
        this.bJn = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJo);
        }
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        if (this.bJn.bNu) {
            this.ans.setVisibility(8);
            this.bLq.setVisibility(8);
        } else {
            this.bLq.setVisibility(0);
            this.ans.setVisibility(0);
            this.ans.setData(lVar.threadData);
            this.ans.setAfterClickListener(this.anx);
            UserTbVipInfoData ro = this.bJn.threadData.ro();
            if (ro != null && ro.getvipV_url() != null && this.anu != null) {
                if (this.anv == null) {
                    this.anu.inflate();
                    this.anv = (TbImageView) getView().findViewById(d.h.user_head_mask);
                }
                this.anv.c(ro.getvipV_url(), 10, false);
                this.ans.setIsBigV(true);
            }
        }
        this.bLq.setData(lVar.threadData);
        this.bLq.setUserAfterClickListener(this.anx);
        this.bLn.setShareVisible(true);
        this.bLn.setShareReportFrom(3);
        if (this.bLn.setData(lVar.threadData)) {
            this.bKk.setVisibility(8);
        }
        this.bLn.setForumAfterClickListener(this.anf);
        this.bLn.setStType(m.rf());
        this.bLn.setYuelaouLocate("feed#" + lVar.XQ());
        this.bLn.setFrom(1);
        if ((StringUtils.isNull(lVar.threadData.getTitle()) && (lVar.threadData.rm() == null || lVar.threadData.rm().size() == 0)) || lVar.threadData.rD() == 1) {
            lVar.threadData.e(false, true);
            if (lVar.threadData.rO() == null || StringUtils.isNull(lVar.threadData.rO().toString())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(lVar.threadData.rO());
            }
        } else {
            this.mTitle.setVisibility(0);
            lVar.threadData.Yk = 0;
            lVar.threadData.rW();
            SpannableStringBuilder rO = lVar.threadData.rO();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(rO));
            this.mTitle.setText(rO);
            if (!Xr()) {
                m.a(this.mTitle, lVar.Nd().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            } else {
                aj.i(this.mTitle, d.e.cp_cont_b);
            }
        }
        if (!Xr() && m.jm(lVar.threadData.getId())) {
            m.a(this.mTitle, this.bJn.Nd().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLh, this.bJn.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.threadData.rw() != null && !StringUtils.isNull(lVar.threadData.rw())) {
            stringBuffer.append(lVar.threadData.rw());
        }
        ArrayList<MediaData> ry = lVar.threadData.ry();
        if (ry != null) {
            i = ry.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (ry.get(i4).getVideoUrl() != null && ry.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(ry.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(lVar.threadData.g(stringBuffer.toString(), true))) {
                this.bLh.setVisibility(0);
                SpannableString cD = lVar.threadData.cD(stringBuffer.toString());
                this.bLh.setOnTouchListener(new com.baidu.tieba.view.k(cD));
                this.bLh.setText(cD);
                if (!Xr()) {
                    m.a(this.bLh, lVar.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
                } else {
                    aj.i(this.bLh, d.e.cp_cont_j);
                }
            } else {
                this.bLh.setVisibility(8);
            }
        } else {
            this.bLh.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rC = lVar.threadData.rC();
        if (rC != null && rC.size() > 0) {
            this.bLf.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rC.get(0);
            this.bLf.setVoiceModel(voiceModel);
            this.bLf.setTag(voiceModel);
            this.bLf.bgc();
            if (voiceModel != null) {
                this.bLf.ng(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bLf.setVisibility(8);
            z = false;
        }
        if (this.bJn.bNu && z) {
            this.bLr.setVisibility(8);
        } else if (com.baidu.tbadk.core.h.oM().oS() && com.baidu.tbadk.core.util.v.t(ry) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (ry.get(i5) == null || !(ry.get(i5).getType() == 3 || ry.get(i5).getType() == 5)) {
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
                    if (ry.get(i9).getType() == 3 || ry.get(i9).getType() == 5) {
                        mediaDataArr[i8] = ry.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bLr.setVisibility(0);
                this.bLr.a(lVar.threadData, lVar.threadData.rt(), lVar.threadData.getFid() + "", lVar.threadData.getTid());
                this.bLr.setShowBig(an.vl().vn());
                this.bLr.a(this.mH, mediaDataArr, i6);
                this.bLr.setFromCDN(this.aiu);
                this.bLr.setImageFrom("other");
            } else {
                this.bLr.setVisibility(8);
            }
        } else {
            this.bLr.setVisibility(8);
        }
        XE();
    }

    private void XE() {
        if (!this.bJn.aBN) {
            this.bLr.setOnChildClickListener(this.bLs);
            this.bLf.setClickable(false);
            this.bLn.setBarNameClickEnabled(false);
        } else {
            this.bLr.setOnChildClickListener(null);
            this.bLf.setClickable(true);
            this.bLn.setBarNameClickEnabled(true);
        }
        int childCount = this.bLr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLr.getChildAt(i);
            if (childAt != null) {
                if (!this.bJn.aBN) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiu = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bLn != null) {
            this.bLn.registPraiseNumSynchronizeListener(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XF() {
        if (this.bJn != null && this.bJn.threadData != null) {
            if (!Xr()) {
                m.jl(this.bJn.threadData.getId());
                m.a(this.mTitle, this.bJn.Nd().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bLh, this.bJn.threadData.getId(), d.e.cp_cont_j, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mH.getPageActivity()).createFromThreadCfg(this.bJn.threadData, null, m.rf(), 18003, true, false, false).addLocateParam(this.bJn.XR());
            addLocateParam.setForumId(String.valueOf(this.bJn.threadData.getFid()));
            addLocateParam.setForumName(this.bJn.threadData.rt());
            if (this.bJn.bNb == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bJn.bNb);
            }
            this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xr() {
        return this.bJn.bNu && !this.bJn.aBN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
