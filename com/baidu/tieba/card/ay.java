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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ay extends a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> GM;
    private View aYc;
    public ViewStub aYe;
    public TbImageView aYf;
    private TextView aYh;
    private TextView aYn;
    private FrsCommonImageLayout aYo;
    public ThreadCommentAndPraiseInfoLayout aYp;
    private CustomMessageListener aZB;
    public ClickableHeaderImageView aZR;
    public PlayVoiceBntNew aZS;
    private UserIconLayout aZT;
    private com.baidu.tieba.card.data.m aZU;
    private View.OnClickListener aZW;
    private FrsCommonImageLayout.b aZX;
    private final View.OnClickListener aZY;
    private boolean adl;
    private final View.OnClickListener ahR;
    private final View.OnClickListener ahu;
    private final String bac;
    private final String bad;
    private final View.OnClickListener bae;
    private int mSkinType;

    public ay(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bac = "1";
        this.bad = "2";
        this.mSkinType = 3;
        this.adl = true;
        this.aZW = new az(this);
        this.aZB = new ba(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aZX = new bb(this);
        this.bae = new bc(this);
        this.aZY = new bd(this);
        this.ahR = new be(this);
        this.ahu = new bf(this);
        View view = getView();
        this.GM = tbPageContext;
        this.aYc = view.findViewById(t.g.card_home_page_normal_thread_top_line);
        this.aZR = (ClickableHeaderImageView) view.findViewById(t.g.card_home_page_normal_thread_user_header);
        this.aYe = (ViewStub) view.findViewById(t.g.viewstub_headimage_mask);
        this.aZR.setDefaultResource(17170445);
        this.aZR.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aZR.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aZR.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds70));
        this.aZT = (UserIconLayout) view.findViewById(t.g.card_home_page_normal_thread_user_layout);
        this.aYh = (TextView) view.findViewById(t.g.card_home_page_normal_thread_title);
        this.aZS = (PlayVoiceBntNew) view.findViewById(t.g.card_home_page_normal_thread_abstract_voice);
        this.aZS.setAfterClickListener(this.aZY);
        this.aYn = (TextView) view.findViewById(t.g.card_home_page_normal_thread_abstract);
        this.aYo = (FrsCommonImageLayout) view.findViewById(t.g.card_home_page_normal_thread_img_layout);
        this.aYo.setDrawNum(false);
        this.aYo.setAfterChildClickListener(this.bae);
        this.aYp = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_home_page_normal_thread_info_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), t.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aYc, t.d.cp_bg_line_b);
            this.aZT.ti();
            this.aYp.ti();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_home_page_normal_thread;
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
        this.aZU = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aZW);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.aZU.bbU) {
            this.aZR.setVisibility(8);
            this.aZT.setVisibility(8);
        } else {
            this.aZT.setVisibility(0);
            this.aZR.setVisibility(0);
            this.aZR.setData(mVar.threadData);
            this.aZR.setAfterClickListener(this.ahR);
            UserTbVipInfoData rC = this.aZU.threadData.rC();
            if (rC != null && rC.getvipV_url() != null && this.aYe != null) {
                if (this.aYf == null) {
                    this.aYe.inflate();
                    this.aYf = (TbImageView) getView().findViewById(t.g.user_head_mask);
                }
                this.aYf.c(rC.getvipV_url(), 10, false);
                this.aZR.setIsBigV(true);
            }
        }
        this.aZT.setData(mVar.threadData);
        this.aZT.setUserAfterClickListener(this.ahR);
        this.aYp.setData(mVar.threadData);
        this.aYp.setForumAfterClickListener(this.ahu);
        this.aYp.setStType(ap.ND());
        this.aYp.setYuelaouLocate("feed#" + mVar.NJ());
        if ((StringUtils.isNull(mVar.threadData.getTitle()) && (mVar.threadData.rA() == null || mVar.threadData.rA().size() == 0)) || mVar.threadData.rP() == 1) {
            this.aYh.setVisibility(8);
        } else {
            this.aYh.setVisibility(0);
            mVar.threadData.Ts = 0;
            mVar.threadData.si();
            SpannableStringBuilder sa = mVar.threadData.sa();
            this.aYh.setOnTouchListener(new com.baidu.tieba.view.y(sa));
            this.aYh.setText(sa);
            if (!Nv()) {
                ap.a(this.aYh, mVar.Kw().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.av.j((View) this.aYh, t.d.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (mVar.threadData.rI() != null && !StringUtils.isNull(mVar.threadData.rI())) {
            stringBuffer.append(mVar.threadData.rI());
        }
        ArrayList<MediaData> rK = mVar.threadData.rK();
        if (rK != null) {
            i = rK.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rK.get(i4).getVideoUrl() != null && rK.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rK.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(mVar.threadData.g(stringBuffer.toString(), true))) {
                this.aYn.setVisibility(0);
                SpannableString cu = mVar.threadData.cu(stringBuffer.toString());
                this.aYn.setOnTouchListener(new com.baidu.tieba.view.y(cu));
                this.aYn.setText(cu);
                if (!Nv()) {
                    ap.a(this.aYn, mVar.threadData.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.av.j((View) this.aYn, t.d.cp_cont_j);
                }
            } else {
                this.aYn.setVisibility(8);
            }
        } else {
            this.aYn.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rO = mVar.threadData.rO();
        if (rO != null && rO.size() > 0) {
            this.aZS.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rO.get(0);
            this.aZS.setVoiceModel(voiceModel);
            this.aZS.setTag(voiceModel);
            this.aZS.bkk();
            if (voiceModel != null) {
                this.aZS.lW(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.aZS.setVisibility(8);
            z = false;
        }
        if (this.aZU.bbU && z) {
            this.aYo.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oG().oM() && com.baidu.tbadk.core.util.y.s(rK) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rK.get(i5) == null || !(rK.get(i5).getType() == 3 || rK.get(i5).getType() == 5)) {
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
                    if (rK.get(i9).getType() == 3 || rK.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rK.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.aYo.setVisibility(0);
                this.aYo.a(mVar.threadData, mVar.threadData.getForum_name(), new StringBuilder(String.valueOf(mVar.threadData.getFid())).toString(), mVar.threadData.getTid());
                this.aYo.setShowBig(com.baidu.tbadk.core.util.bb.vk().vm());
                this.aYo.a(this.GM, mediaDataArr, i6);
                this.aYo.setFromCDN(this.adl);
                this.aYo.setImageFrom("other");
            } else {
                this.aYo.setVisibility(8);
            }
        } else {
            this.aYo.setVisibility(8);
        }
        NE();
    }

    private void NE() {
        if (!this.aZU.avE) {
            this.aYo.setOnChildClickListener(this.aZX);
            this.aZS.setClickable(false);
            this.aYp.setBarNameClickEnabled(false);
        } else {
            this.aYo.setOnChildClickListener(null);
            this.aZS.setClickable(true);
            this.aYp.setBarNameClickEnabled(true);
        }
        int childCount = this.aYo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aYo.getChildAt(i);
            if (childAt != null) {
                if (!this.aZU.avE) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adl = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aYp != null && this.aZB != null) {
            this.aYp.h(bdUniqueId);
            this.aZB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF() {
        if (this.aZU != null && this.aZU.threadData != null) {
            if (!Nv()) {
                ap.hG(this.aZU.threadData.getId());
            }
            this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createFromThreadCfg(this.aZU.threadData, null, ap.ND(), 18003, true, false, false).addLocateParam(this.aZU.NK())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nv() {
        return this.aZU.bbU && !this.aZU.avE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
