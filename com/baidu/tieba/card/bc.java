package com.baidu.tieba.card;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bc extends a<com.baidu.tieba.card.data.n> {
    private TextView aSO;
    private boolean ahO;
    private TbPageContext<?> ajF;
    private final View.OnClickListener alM;
    private final View.OnClickListener amj;
    private View avr;
    public ViewStub bbh;
    public TbImageView bbi;
    private TextView brK;
    private FrsCommonImageLayout brL;
    public ThreadCommentAndPraiseInfoLayout brM;
    private CustomMessageListener bsL;
    private FrsCommonImageLayout.b btA;
    private final View.OnClickListener btB;
    private final String btF;
    private final String btG;
    private final View.OnClickListener btH;
    public ClickableHeaderImageView btt;
    public PlayVoiceBntNew btu;
    public View btv;
    private UserIconLayout btw;
    private com.baidu.tieba.card.data.n btx;
    private View.OnClickListener btz;
    private int mSkinType;

    public bc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.btF = "1";
        this.btG = "2";
        this.mSkinType = 3;
        this.ahO = true;
        this.btz = new bd(this);
        this.bsL = new be(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.btA = new bf(this);
        this.btH = new bg(this);
        this.btB = new bh(this);
        this.amj = new bi(this);
        this.alM = new bj(this);
        View view = getView();
        this.ajF = tbPageContext;
        this.avr = view.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.btt = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bbh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.btt.setDefaultResource(17170445);
        this.btt.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.btt.setDefaultBgResource(w.e.cp_bg_line_e);
        this.btt.setRadius(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds70));
        this.btw = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.aSO = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.btu = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.btu.setAfterClickListener(this.btB);
        this.brK = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.brL = (FrsCommonImageLayout) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.brL.setDrawNum(false);
        this.brL.setAfterChildClickListener(this.btH);
        this.brM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.btv = view.findViewById(w.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avr, w.e.cp_bg_line_b);
            this.btw.tD();
            this.brM.tD();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.n nVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        if (nVar == null || nVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.btx = nVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.btz);
        }
        onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.btx.bvp) {
            this.btt.setVisibility(8);
            this.btw.setVisibility(8);
        } else {
            this.btw.setVisibility(0);
            this.btt.setVisibility(0);
            this.btt.setData(nVar.threadData);
            this.btt.setAfterClickListener(this.amj);
            UserTbVipInfoData rR = this.btx.threadData.rR();
            if (rR != null && rR.getvipV_url() != null && this.bbh != null) {
                if (this.bbi == null) {
                    this.bbh.inflate();
                    this.bbi = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.bbi.c(rR.getvipV_url(), 10, false);
                this.btt.setIsBigV(true);
            }
        }
        this.btw.setData(nVar.threadData);
        this.btw.setUserAfterClickListener(this.amj);
        if (this.brM.a(nVar.threadData)) {
            this.btv.setVisibility(8);
        }
        this.brM.setForumAfterClickListener(this.alM);
        this.brM.setStType(at.rH());
        this.brM.setYuelaouLocate("feed#" + nVar.Sx());
        if ((StringUtils.isNull(nVar.threadData.getTitle()) && (nVar.threadData.rP() == null || nVar.threadData.rP().size() == 0)) || nVar.threadData.sf() == 1) {
            this.aSO.setVisibility(8);
        } else {
            this.aSO.setVisibility(0);
            nVar.threadData.XW = 0;
            nVar.threadData.sy();
            SpannableStringBuilder sq = nVar.threadData.sq();
            this.aSO.setOnTouchListener(new com.baidu.tieba.view.x(sq));
            this.aSO.setText(sq);
            if (!Sn()) {
                at.a(this.aSO, nVar.JN().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.aq.i((View) this.aSO, w.e.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (nVar.threadData.rY() != null && !StringUtils.isNull(nVar.threadData.rY())) {
            stringBuffer.append(nVar.threadData.rY());
        }
        ArrayList<MediaData> sa = nVar.threadData.sa();
        if (sa != null) {
            i = sa.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (sa.get(i4).getVideoUrl() != null && sa.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(sa.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(nVar.threadData.g(stringBuffer.toString(), true))) {
                this.brK.setVisibility(0);
                SpannableString cq = nVar.threadData.cq(stringBuffer.toString());
                this.brK.setOnTouchListener(new com.baidu.tieba.view.x(cq));
                this.brK.setText(cq);
                if (!Sn()) {
                    at.a(this.brK, nVar.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.aq.i((View) this.brK, w.e.cp_cont_j);
                }
            } else {
                this.brK.setVisibility(8);
            }
        } else {
            this.brK.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> se = nVar.threadData.se();
        if (se != null && se.size() > 0) {
            this.btu.setVisibility(0);
            VoiceData.VoiceModel voiceModel = se.get(0);
            this.btu.setVoiceModel(voiceModel);
            this.btu.setTag(voiceModel);
            this.btu.ayg();
            if (voiceModel != null) {
                this.btu.lZ(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.btu.setVisibility(8);
            z = false;
        }
        if (this.btx.bvp && z) {
            this.brL.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oQ().oW() && com.baidu.tbadk.core.util.x.p(sa) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (sa.get(i5) == null || !(sa.get(i5).getType() == 3 || sa.get(i5).getType() == 5)) {
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
                    if (sa.get(i9).getType() == 3 || sa.get(i9).getType() == 5) {
                        mediaDataArr[i8] = sa.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.brL.setVisibility(0);
                this.brL.a(nVar.threadData, nVar.threadData.rV(), new StringBuilder(String.valueOf(nVar.threadData.getFid())).toString(), nVar.threadData.getTid());
                this.brL.setShowBig(com.baidu.tbadk.core.util.av.vD().vF());
                this.brL.a(this.ajF, mediaDataArr, i6);
                this.brL.setFromCDN(this.ahO);
                this.brL.setImageFrom("other");
            } else {
                this.brL.setVisibility(8);
            }
        } else {
            this.brL.setVisibility(8);
        }
        Sq();
    }

    private void Sq() {
        if (!this.btx.azY) {
            this.brL.setOnChildClickListener(this.btA);
            this.btu.setClickable(false);
            this.brM.setBarNameClickEnabled(false);
        } else {
            this.brL.setOnChildClickListener(null);
            this.btu.setClickable(true);
            this.brM.setBarNameClickEnabled(true);
        }
        int childCount = this.brL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.brL.getChildAt(i);
            if (childAt != null) {
                if (!this.btx.azY) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahO = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.brM != null && this.bsL != null) {
            this.brM.h(bdUniqueId);
            this.bsL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sr() {
        if (this.btx != null && this.btx.threadData != null) {
            if (!Sn()) {
                at.hU(this.btx.threadData.getId());
            }
            this.ajF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajF.getPageActivity()).createFromThreadCfg(this.btx.threadData, null, at.rH(), 18003, true, false, false).addLocateParam(this.btx.Sy())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sn() {
        return this.btx.bvp && !this.btx.azY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
