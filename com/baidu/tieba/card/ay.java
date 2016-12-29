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
public class ay extends a<com.baidu.tieba.card.data.m> {
    private TbPageContext<?> GO;
    private TextView aNY;
    private boolean adn;
    private final View.OnClickListener ahA;
    private final View.OnClickListener ahg;
    private View aqR;
    public ViewStub baW;
    public TbImageView baX;
    private TextView bbe;
    private FrsCommonImageLayout bbf;
    public ThreadCommentAndPraiseInfoLayout bbg;
    public ClickableHeaderImageView bcJ;
    public PlayVoiceBntNew bcK;
    public View bcL;
    private UserIconLayout bcM;
    private com.baidu.tieba.card.data.m bcN;
    private View.OnClickListener bcP;
    private FrsCommonImageLayout.b bcQ;
    private final View.OnClickListener bcR;
    private final String bcV;
    private final String bcW;
    private final View.OnClickListener bcX;
    private CustomMessageListener bct;
    private int mSkinType;

    public ay(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bcV = "1";
        this.bcW = "2";
        this.mSkinType = 3;
        this.adn = true;
        this.bcP = new az(this);
        this.bct = new ba(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bcQ = new bb(this);
        this.bcX = new bc(this);
        this.bcR = new bd(this);
        this.ahA = new be(this);
        this.ahg = new bf(this);
        View view = getView();
        this.GO = tbPageContext;
        this.aqR = view.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.bcJ = (ClickableHeaderImageView) view.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.baW = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bcJ.setDefaultResource(17170445);
        this.bcJ.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bcJ.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bcJ.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.bcM = (UserIconLayout) view.findViewById(r.g.card_home_page_normal_thread_user_layout);
        this.aNY = (TextView) view.findViewById(r.g.card_home_page_normal_thread_title);
        this.bcK = (PlayVoiceBntNew) view.findViewById(r.g.card_home_page_normal_thread_abstract_voice);
        this.bcK.setAfterClickListener(this.bcR);
        this.bbe = (TextView) view.findViewById(r.g.card_home_page_normal_thread_abstract);
        this.bbf = (FrsCommonImageLayout) view.findViewById(r.g.card_home_page_normal_thread_img_layout);
        this.bbf.setDrawNum(false);
        this.bbf.setAfterChildClickListener(this.bcX);
        this.bbg = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_home_page_normal_thread_info_layout);
        this.bcL = view.findViewById(r.g.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(getView(), r.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.ar.l(this.aqR, r.d.cp_bg_line_b);
            this.bcM.tm();
            this.bbg.tm();
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
        this.bcN = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bcP);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bcN.beA) {
            this.bcJ.setVisibility(8);
            this.bcM.setVisibility(8);
        } else {
            this.bcM.setVisibility(0);
            this.bcJ.setVisibility(0);
            this.bcJ.setData(mVar.threadData);
            this.bcJ.setAfterClickListener(this.ahA);
            UserTbVipInfoData rF = this.bcN.threadData.rF();
            if (rF != null && rF.getvipV_url() != null && this.baW != null) {
                if (this.baX == null) {
                    this.baW.inflate();
                    this.baX = (TbImageView) getView().findViewById(r.g.user_head_mask);
                }
                this.baX.c(rF.getvipV_url(), 10, false);
                this.bcJ.setIsBigV(true);
            }
        }
        this.bcM.setData(mVar.threadData);
        this.bcM.setUserAfterClickListener(this.ahA);
        if (this.bbg.a(mVar.threadData)) {
            this.bcL.setVisibility(8);
        }
        this.bbg.setForumAfterClickListener(this.ahg);
        this.bbg.setStType(ap.OB());
        this.bbg.setYuelaouLocate("feed#" + mVar.OJ());
        if ((StringUtils.isNull(mVar.threadData.getTitle()) && (mVar.threadData.rD() == null || mVar.threadData.rD().size() == 0)) || mVar.threadData.rU() == 1) {
            this.aNY.setVisibility(8);
        } else {
            this.aNY.setVisibility(0);
            mVar.threadData.Tx = 0;
            mVar.threadData.sl();
            SpannableStringBuilder sd = mVar.threadData.sd();
            this.aNY.setOnTouchListener(new com.baidu.tieba.view.x(sd));
            this.aNY.setText(sd);
            if (!Ow()) {
                ap.a(this.aNY, mVar.IU().getId(), r.d.cp_cont_b, r.d.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.ar.j((View) this.aNY, r.d.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (mVar.threadData.rN() != null && !StringUtils.isNull(mVar.threadData.rN())) {
            stringBuffer.append(mVar.threadData.rN());
        }
        ArrayList<MediaData> rP = mVar.threadData.rP();
        if (rP != null) {
            i = rP.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rP.get(i4).getVideoUrl() != null && rP.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rP.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(mVar.threadData.g(stringBuffer.toString(), true))) {
                this.bbe.setVisibility(0);
                SpannableString cz = mVar.threadData.cz(stringBuffer.toString());
                this.bbe.setOnTouchListener(new com.baidu.tieba.view.x(cz));
                this.bbe.setText(cz);
                if (!Ow()) {
                    ap.a(this.bbe, mVar.threadData.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.ar.j((View) this.bbe, r.d.cp_cont_j);
                }
            } else {
                this.bbe.setVisibility(8);
            }
        } else {
            this.bbe.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rT = mVar.threadData.rT();
        if (rT != null && rT.size() > 0) {
            this.bcK.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rT.get(0);
            this.bcK.setVoiceModel(voiceModel);
            this.bcK.setTag(voiceModel);
            this.bcK.axx();
            if (voiceModel != null) {
                this.bcK.lw(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bcK.setVisibility(8);
            z = false;
        }
        if (this.bcN.beA && z) {
            this.bbf.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oJ().oP() && com.baidu.tbadk.core.util.x.s(rP) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rP.get(i5) == null || !(rP.get(i5).getType() == 3 || rP.get(i5).getType() == 5)) {
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
                    if (rP.get(i9).getType() == 3 || rP.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rP.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bbf.setVisibility(0);
                this.bbf.a(mVar.threadData, mVar.threadData.rK(), new StringBuilder(String.valueOf(mVar.threadData.getFid())).toString(), mVar.threadData.getTid());
                this.bbf.setShowBig(com.baidu.tbadk.core.util.aw.vm().vo());
                this.bbf.a(this.GO, mediaDataArr, i6);
                this.bbf.setFromCDN(this.adn);
                this.bbf.setImageFrom("other");
            } else {
                this.bbf.setVisibility(8);
            }
        } else {
            this.bbf.setVisibility(8);
        }
        OC();
    }

    private void OC() {
        if (!this.bcN.avy) {
            this.bbf.setOnChildClickListener(this.bcQ);
            this.bcK.setClickable(false);
            this.bbg.setBarNameClickEnabled(false);
        } else {
            this.bbf.setOnChildClickListener(null);
            this.bcK.setClickable(true);
            this.bbg.setBarNameClickEnabled(true);
        }
        int childCount = this.bbf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bbf.getChildAt(i);
            if (childAt != null) {
                if (!this.bcN.avy) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adn = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbg != null && this.bct != null) {
            this.bbg.h(bdUniqueId);
            this.bct.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bct);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        if (this.bcN != null && this.bcN.threadData != null) {
            if (!Ow()) {
                ap.hL(this.bcN.threadData.getId());
            }
            this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createFromThreadCfg(this.bcN.threadData, null, ap.OB(), 18003, true, false, false).addLocateParam(this.bcN.OK())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ow() {
        return this.bcN.beA && !this.bcN.avy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
