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
    private boolean aic;
    private TbPageContext<?> ajT;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    private View avH;
    public ViewStub bba;
    public TbImageView bbb;
    private TextView brC;
    private FrsCommonImageLayout brD;
    public ThreadCommentAndPraiseInfoLayout brE;
    private CustomMessageListener bsD;
    public ClickableHeaderImageView btk;
    public PlayVoiceBntNew btl;
    public View btm;
    private UserIconLayout bto;
    private com.baidu.tieba.card.data.n btp;
    private View.OnClickListener btr;
    private FrsCommonImageLayout.b bts;
    private final View.OnClickListener btt;
    private final String btx;
    private final String bty;
    private final View.OnClickListener btz;
    private int mSkinType;
    private TextView mTitle;

    public bc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.btx = "1";
        this.bty = "2";
        this.mSkinType = 3;
        this.aic = true;
        this.btr = new bd(this);
        this.bsD = new be(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bts = new bf(this);
        this.btz = new bg(this);
        this.btt = new bh(this);
        this.amx = new bi(this);
        this.ama = new bj(this);
        View view = getView();
        this.ajT = tbPageContext;
        this.avH = view.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.btk = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bba = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.btk.setDefaultResource(17170445);
        this.btk.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.btk.setDefaultBgResource(w.e.cp_bg_line_e);
        this.btk.setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds70));
        this.bto = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.btl = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.btl.setAfterClickListener(this.btt);
        this.brC = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.brD = (FrsCommonImageLayout) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.brD.setDrawNum(false);
        this.brD.setAfterChildClickListener(this.btz);
        this.brE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.btm = view.findViewById(w.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avH, w.e.cp_bg_line_b);
            this.bto.onChangeSkinType();
            this.brE.onChangeSkinType();
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
        this.btp = nVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.btr);
        }
        onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.btp.bvi) {
            this.btk.setVisibility(8);
            this.bto.setVisibility(8);
        } else {
            this.bto.setVisibility(0);
            this.btk.setVisibility(0);
            this.btk.setData(nVar.threadData);
            this.btk.setAfterClickListener(this.amx);
            UserTbVipInfoData sp = this.btp.threadData.sp();
            if (sp != null && sp.getvipV_url() != null && this.bba != null) {
                if (this.bbb == null) {
                    this.bba.inflate();
                    this.bbb = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.bbb.c(sp.getvipV_url(), 10, false);
                this.btk.setIsBigV(true);
            }
        }
        this.bto.setData(nVar.threadData);
        this.bto.setUserAfterClickListener(this.amx);
        if (this.brE.a(nVar.threadData)) {
            this.btm.setVisibility(8);
        }
        this.brE.setForumAfterClickListener(this.ama);
        this.brE.setStType(at.sf());
        this.brE.setYuelaouLocate("feed#" + nVar.SV());
        if ((StringUtils.isNull(nVar.threadData.getTitle()) && (nVar.threadData.sn() == null || nVar.threadData.sn().size() == 0)) || nVar.threadData.sD() == 1) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            nVar.threadData.Ym = 0;
            nVar.threadData.sW();
            SpannableStringBuilder sO = nVar.threadData.sO();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.x(sO));
            this.mTitle.setText(sO);
            if (!SL()) {
                at.a(this.mTitle, nVar.Kn().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.aq.i(this.mTitle, w.e.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (nVar.threadData.sw() != null && !StringUtils.isNull(nVar.threadData.sw())) {
            stringBuffer.append(nVar.threadData.sw());
        }
        ArrayList<MediaData> sy = nVar.threadData.sy();
        if (sy != null) {
            i = sy.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (sy.get(i4).getVideoUrl() != null && sy.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(sy.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(nVar.threadData.g(stringBuffer.toString(), true))) {
                this.brC.setVisibility(0);
                SpannableString cx = nVar.threadData.cx(stringBuffer.toString());
                this.brC.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                this.brC.setText(cx);
                if (!SL()) {
                    at.a(this.brC, nVar.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.aq.i(this.brC, w.e.cp_cont_j);
                }
            } else {
                this.brC.setVisibility(8);
            }
        } else {
            this.brC.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> sC = nVar.threadData.sC();
        if (sC != null && sC.size() > 0) {
            this.btl.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sC.get(0);
            this.btl.setVoiceModel(voiceModel);
            this.btl.setTag(voiceModel);
            this.btl.bac();
            if (voiceModel != null) {
                this.btl.ma(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.btl.setVisibility(8);
            z = false;
        }
        if (this.btp.bvi && z) {
            this.brD.setVisibility(8);
        } else if (com.baidu.tbadk.core.q.po().pu() && com.baidu.tbadk.core.util.x.p(sy) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (sy.get(i5) == null || !(sy.get(i5).getType() == 3 || sy.get(i5).getType() == 5)) {
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
                    if (sy.get(i9).getType() == 3 || sy.get(i9).getType() == 5) {
                        mediaDataArr[i8] = sy.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.brD.setVisibility(0);
                this.brD.a(nVar.threadData, nVar.threadData.st(), new StringBuilder(String.valueOf(nVar.threadData.getFid())).toString(), nVar.threadData.getTid());
                this.brD.setShowBig(com.baidu.tbadk.core.util.av.wa().wc());
                this.brD.a(this.ajT, mediaDataArr, i6);
                this.brD.setFromCDN(this.aic);
                this.brD.setImageFrom("other");
            } else {
                this.brD.setVisibility(8);
            }
        } else {
            this.brD.setVisibility(8);
        }
        SO();
    }

    private void SO() {
        if (!this.btp.aAo) {
            this.brD.setOnChildClickListener(this.bts);
            this.btl.setClickable(false);
            this.brE.setBarNameClickEnabled(false);
        } else {
            this.brD.setOnChildClickListener(null);
            this.btl.setClickable(true);
            this.brE.setBarNameClickEnabled(true);
        }
        int childCount = this.brD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.brD.getChildAt(i);
            if (childAt != null) {
                if (!this.btp.aAo) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aic = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.brE != null && this.bsD != null) {
            this.brE.h(bdUniqueId);
            this.bsD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SP() {
        if (this.btp != null && this.btp.threadData != null) {
            if (!SL()) {
                at.hY(this.btp.threadData.getId());
            }
            this.ajT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajT.getPageActivity()).createFromThreadCfg(this.btp.threadData, null, at.sf(), 18003, true, false, false).addLocateParam(this.btp.SW())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SL() {
        return this.btp.bvi && !this.btp.aAo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
