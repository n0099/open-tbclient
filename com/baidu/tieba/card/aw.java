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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aw extends a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> GM;
    private TextView aMI;
    public ViewStub aYH;
    public TbImageView aYI;
    private TextView aYP;
    private FrsCommonImageLayout aYQ;
    public ThreadCommentAndPraiseInfoLayout aYR;
    private CustomMessageListener aZT;
    private boolean adw;
    private final View.OnClickListener ahd;
    private final View.OnClickListener ahz;
    private View aqu;
    public ClickableHeaderImageView bai;
    public PlayVoiceBntNew baj;
    private UserIconLayout bak;
    private com.baidu.tieba.card.data.m bal;
    private View.OnClickListener ban;
    private FrsCommonImageLayout.b bao;
    private final View.OnClickListener bap;
    private final String bau;
    private final String bav;
    private final View.OnClickListener baw;
    private int mSkinType;

    public aw(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bau = "1";
        this.bav = "2";
        this.mSkinType = 3;
        this.adw = true;
        this.ban = new ax(this);
        this.aZT = new ay(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bao = new az(this);
        this.baw = new ba(this);
        this.bap = new bb(this);
        this.ahz = new bc(this);
        this.ahd = new bd(this);
        View view = getView();
        this.GM = tbPageContext;
        this.aqu = view.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.bai = (ClickableHeaderImageView) view.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.aYH = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bai.setDefaultResource(17170445);
        this.bai.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bai.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bai.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds70));
        this.bak = (UserIconLayout) view.findViewById(r.g.card_home_page_normal_thread_user_layout);
        this.aMI = (TextView) view.findViewById(r.g.card_home_page_normal_thread_title);
        this.baj = (PlayVoiceBntNew) view.findViewById(r.g.card_home_page_normal_thread_abstract_voice);
        this.baj.setAfterClickListener(this.bap);
        this.aYP = (TextView) view.findViewById(r.g.card_home_page_normal_thread_abstract);
        this.aYQ = (FrsCommonImageLayout) view.findViewById(r.g.card_home_page_normal_thread_img_layout);
        this.aYQ.setDrawNum(false);
        this.aYQ.setAfterChildClickListener(this.baw);
        this.aYR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_home_page_normal_thread_info_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), r.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aqu, r.d.cp_bg_line_b);
            this.bak.tx();
            this.aYR.tx();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.m mVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        if (mVar == null || mVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bal = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ban);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bal.bcm) {
            this.bai.setVisibility(8);
            this.bak.setVisibility(8);
        } else {
            this.bak.setVisibility(0);
            this.bai.setVisibility(0);
            this.bai.setData(mVar.threadData);
            this.bai.setAfterClickListener(this.ahz);
            UserTbVipInfoData rO = this.bal.threadData.rO();
            if (rO != null && rO.getvipV_url() != null && this.aYH != null) {
                if (this.aYI == null) {
                    this.aYH.inflate();
                    this.aYI = (TbImageView) getView().findViewById(r.g.user_head_mask);
                }
                this.aYI.c(rO.getvipV_url(), 10, false);
                this.bai.setIsBigV(true);
            }
        }
        this.bak.setData(mVar.threadData);
        this.bak.setUserAfterClickListener(this.ahz);
        this.aYR.setData(mVar.threadData);
        this.aYR.setForumAfterClickListener(this.ahd);
        this.aYR.setStType(an.Od());
        this.aYR.setYuelaouLocate("feed#" + mVar.Ok());
        if ((StringUtils.isNull(mVar.threadData.getTitle()) && (mVar.threadData.rM() == null || mVar.threadData.rM().size() == 0)) || mVar.threadData.sb() == 1) {
            this.aMI.setVisibility(8);
        } else {
            this.aMI.setVisibility(0);
            mVar.threadData.TA = 0;
            mVar.threadData.su();
            SpannableStringBuilder sm = mVar.threadData.sm();
            this.aMI.setOnTouchListener(new com.baidu.tieba.view.y(sm));
            this.aMI.setText(sm);
            if (!NW()) {
                an.a(this.aMI, mVar.Jv().getId(), r.d.cp_cont_b, r.d.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.av.j((View) this.aMI, r.d.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (mVar.threadData.rU() != null && !StringUtils.isNull(mVar.threadData.rU())) {
            stringBuffer.append(mVar.threadData.rU());
        }
        ArrayList<MediaData> rW = mVar.threadData.rW();
        if (rW != null) {
            i = rW.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rW.get(i4).getVideoUrl() != null && rW.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rW.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(mVar.threadData.g(stringBuffer.toString(), true))) {
                this.aYP.setVisibility(0);
                SpannableString cw = mVar.threadData.cw(stringBuffer.toString());
                this.aYP.setOnTouchListener(new com.baidu.tieba.view.y(cw));
                this.aYP.setText(cw);
                if (!NW()) {
                    an.a(this.aYP, mVar.threadData.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.av.j((View) this.aYP, r.d.cp_cont_j);
                }
            } else {
                this.aYP.setVisibility(8);
            }
        } else {
            this.aYP.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> sa = mVar.threadData.sa();
        if (sa != null && sa.size() > 0) {
            this.baj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sa.get(0);
            this.baj.setVoiceModel(voiceModel);
            this.baj.setTag(voiceModel);
            this.baj.aCk();
            if (voiceModel != null) {
                this.baj.me(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.baj.setVisibility(8);
            z = false;
        }
        if (this.bal.bcm && z) {
            this.aYQ.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oH().oN() && com.baidu.tbadk.core.util.y.s(rW) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rW.get(i5) == null || !(rW.get(i5).getType() == 3 || rW.get(i5).getType() == 5)) {
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
                    if (rW.get(i9).getType() == 3 || rW.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rW.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.aYQ.setVisibility(0);
                this.aYQ.a(mVar.threadData, mVar.threadData.getForum_name(), new StringBuilder(String.valueOf(mVar.threadData.getFid())).toString(), mVar.threadData.getTid());
                this.aYQ.setShowBig(com.baidu.tbadk.core.util.ba.vy().vA());
                this.aYQ.a(this.GM, mediaDataArr, i6);
                this.aYQ.setFromCDN(this.adw);
                this.aYQ.setImageFrom("other");
            } else {
                this.aYQ.setVisibility(8);
            }
        } else {
            this.aYQ.setVisibility(8);
        }
        Oe();
    }

    private void Oe() {
        if (!this.bal.avh) {
            this.aYQ.setOnChildClickListener(this.bao);
            this.baj.setClickable(false);
            this.aYR.setBarNameClickEnabled(false);
        } else {
            this.aYQ.setOnChildClickListener(null);
            this.baj.setClickable(true);
            this.aYR.setBarNameClickEnabled(true);
        }
        int childCount = this.aYQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aYQ.getChildAt(i);
            if (childAt != null) {
                if (!this.bal.avh) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adw = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aYR != null && this.aZT != null) {
            this.aYR.h(bdUniqueId);
            this.aZT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Of() {
        if (this.bal != null && this.bal.threadData != null) {
            if (!NW()) {
                an.hN(this.bal.threadData.getId());
            }
            this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createFromThreadCfg(this.bal.threadData, null, an.Od(), 18003, true, false, false).addLocateParam(this.bal.Ol())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean NW() {
        return this.bal.bcm && !this.bal.avh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
