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
    private TbPageContext<?> GO;
    private TextView aOH;
    private boolean adU;
    private final View.OnClickListener ahD;
    private final View.OnClickListener ahZ;
    private View aro;
    public ViewStub bbQ;
    public TbImageView bbR;
    private TextView bbY;
    private FrsCommonImageLayout bbZ;
    public ThreadCommentAndPraiseInfoLayout bca;
    private final String bdD;
    private final String bdE;
    private final View.OnClickListener bdF;
    private CustomMessageListener bdb;
    public ClickableHeaderImageView bdr;
    public PlayVoiceBntNew bds;
    public View bdt;
    private UserIconLayout bdu;
    private com.baidu.tieba.card.data.m bdv;
    private View.OnClickListener bdx;
    private FrsCommonImageLayout.b bdy;
    private final View.OnClickListener bdz;
    private int mSkinType;

    public aw(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bdD = "1";
        this.bdE = "2";
        this.mSkinType = 3;
        this.adU = true;
        this.bdx = new ax(this);
        this.bdb = new ay(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bdy = new az(this);
        this.bdF = new ba(this);
        this.bdz = new bb(this);
        this.ahZ = new bc(this);
        this.ahD = new bd(this);
        View view = getView();
        this.GO = tbPageContext;
        this.aro = view.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.bdr = (ClickableHeaderImageView) view.findViewById(r.g.card_home_page_normal_thread_user_header);
        this.bbQ = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.bdr.setDefaultResource(17170445);
        this.bdr.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bdr.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bdr.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.bdu = (UserIconLayout) view.findViewById(r.g.card_home_page_normal_thread_user_layout);
        this.aOH = (TextView) view.findViewById(r.g.card_home_page_normal_thread_title);
        this.bds = (PlayVoiceBntNew) view.findViewById(r.g.card_home_page_normal_thread_abstract_voice);
        this.bds.setAfterClickListener(this.bdz);
        this.bbY = (TextView) view.findViewById(r.g.card_home_page_normal_thread_abstract);
        this.bbZ = (FrsCommonImageLayout) view.findViewById(r.g.card_home_page_normal_thread_img_layout);
        this.bbZ.setDrawNum(false);
        this.bbZ.setAfterChildClickListener(this.bdF);
        this.bca = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_home_page_normal_thread_info_layout);
        this.bdt = view.findViewById(r.g.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), r.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aro, r.d.cp_bg_line_b);
            this.bdu.tB();
            this.bca.tB();
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
        this.bdv = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bdx);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bdv.bfl) {
            this.bdr.setVisibility(8);
            this.bdu.setVisibility(8);
        } else {
            this.bdu.setVisibility(0);
            this.bdr.setVisibility(0);
            this.bdr.setData(mVar.threadData);
            this.bdr.setAfterClickListener(this.ahZ);
            UserTbVipInfoData rQ = this.bdv.threadData.rQ();
            if (rQ != null && rQ.getvipV_url() != null && this.bbQ != null) {
                if (this.bbR == null) {
                    this.bbQ.inflate();
                    this.bbR = (TbImageView) getView().findViewById(r.g.user_head_mask);
                }
                this.bbR.c(rQ.getvipV_url(), 10, false);
                this.bdr.setIsBigV(true);
            }
        }
        this.bdu.setData(mVar.threadData);
        this.bdu.setUserAfterClickListener(this.ahZ);
        if (this.bca.a(mVar.threadData)) {
            this.bdt.setVisibility(8);
        }
        this.bca.setForumAfterClickListener(this.ahD);
        this.bca.setStType(an.Pf());
        this.bca.setYuelaouLocate("feed#" + mVar.Pn());
        if ((StringUtils.isNull(mVar.threadData.getTitle()) && (mVar.threadData.rO() == null || mVar.threadData.rO().size() == 0)) || mVar.threadData.sd() == 1) {
            this.aOH.setVisibility(8);
        } else {
            this.aOH.setVisibility(0);
            mVar.threadData.TX = 0;
            mVar.threadData.sw();
            SpannableStringBuilder so = mVar.threadData.so();
            this.aOH.setOnTouchListener(new com.baidu.tieba.view.x(so));
            this.aOH.setText(so);
            if (!Pa()) {
                an.a(this.aOH, mVar.Jz().getId(), r.d.cp_cont_b, r.d.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.at.j((View) this.aOH, r.d.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (mVar.threadData.rW() != null && !StringUtils.isNull(mVar.threadData.rW())) {
            stringBuffer.append(mVar.threadData.rW());
        }
        ArrayList<MediaData> rY = mVar.threadData.rY();
        if (rY != null) {
            i = rY.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rY.get(i4).getVideoUrl() != null && rY.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rY.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(mVar.threadData.g(stringBuffer.toString(), true))) {
                this.bbY.setVisibility(0);
                SpannableString cy = mVar.threadData.cy(stringBuffer.toString());
                this.bbY.setOnTouchListener(new com.baidu.tieba.view.x(cy));
                this.bbY.setText(cy);
                if (!Pa()) {
                    an.a(this.bbY, mVar.threadData.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.at.j((View) this.bbY, r.d.cp_cont_j);
                }
            } else {
                this.bbY.setVisibility(8);
            }
        } else {
            this.bbY.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> sc = mVar.threadData.sc();
        if (sc != null && sc.size() > 0) {
            this.bds.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sc.get(0);
            this.bds.setVoiceModel(voiceModel);
            this.bds.setTag(voiceModel);
            this.bds.aEg();
            if (voiceModel != null) {
                this.bds.mm(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bds.setVisibility(8);
            z = false;
        }
        if (this.bdv.bfl && z) {
            this.bbZ.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.oJ().oP() && com.baidu.tbadk.core.util.x.s(rY) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rY.get(i5) == null || !(rY.get(i5).getType() == 3 || rY.get(i5).getType() == 5)) {
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
                    if (rY.get(i9).getType() == 3 || rY.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rY.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bbZ.setVisibility(0);
                this.bbZ.a(mVar.threadData, mVar.threadData.getForum_name(), new StringBuilder(String.valueOf(mVar.threadData.getFid())).toString(), mVar.threadData.getTid());
                this.bbZ.setShowBig(com.baidu.tbadk.core.util.ay.vC().vE());
                this.bbZ.a(this.GO, mediaDataArr, i6);
                this.bbZ.setFromCDN(this.adU);
                this.bbZ.setImageFrom("other");
            } else {
                this.bbZ.setVisibility(8);
            }
        } else {
            this.bbZ.setVisibility(8);
        }
        Pg();
    }

    private void Pg() {
        if (!this.bdv.awb) {
            this.bbZ.setOnChildClickListener(this.bdy);
            this.bds.setClickable(false);
            this.bca.setBarNameClickEnabled(false);
        } else {
            this.bbZ.setOnChildClickListener(null);
            this.bds.setClickable(true);
            this.bca.setBarNameClickEnabled(true);
        }
        int childCount = this.bbZ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bbZ.getChildAt(i);
            if (childAt != null) {
                if (!this.bdv.awb) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adU = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bca != null && this.bdb != null) {
            this.bca.h(bdUniqueId);
            this.bdb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        if (this.bdv != null && this.bdv.threadData != null) {
            if (!Pa()) {
                an.hR(this.bdv.threadData.getId());
            }
            this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createFromThreadCfg(this.bdv.threadData, null, an.Pf(), 18003, true, false, false).addLocateParam(this.bdv.Po())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Pa() {
        return this.bdv.bfl && !this.bdv.awb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
