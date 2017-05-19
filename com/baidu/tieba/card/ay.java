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
public class ay extends a<com.baidu.tieba.card.data.l> {
    private boolean ahv;
    private TbPageContext<?> ajr;
    private final View.OnClickListener alY;
    public ClickableHeaderImageView amf;
    public ViewStub amh;
    public TbImageView ami;
    private final View.OnClickListener amk;
    private View avN;
    public View buR;
    public PlayVoiceBntNew bvC;
    private com.baidu.tieba.card.data.l bvE;
    private TextView bvF;
    private View.OnClickListener bvI;
    private final View.OnClickListener bvJ;
    public ThreadCommentAndPraiseInfoLayout bvN;
    private final String bvO;
    private final String bvP;
    private UserIconLayout bvQ;
    private FrsCommonImageLayout bvR;
    private FrsCommonImageLayout.b bvS;
    private final View.OnClickListener bvT;
    private int mSkinType;
    private TextView mTitle;

    public ay(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bvO = "1";
        this.bvP = "2";
        this.mSkinType = 3;
        this.ahv = true;
        this.bvI = new az(this);
        this.bvS = new ba(this);
        this.bvT = new bb(this);
        this.bvJ = new bc(this);
        this.amk = new bd(this);
        this.alY = new be(this);
        View view = getView();
        this.ajr = tbPageContext;
        this.avN = view.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.amf = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.amh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.amf.setDefaultResource(17170445);
        this.amf.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.amf.setDefaultBgResource(w.e.cp_bg_line_e);
        this.amf.setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds70));
        this.bvQ = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bvC = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bvC.setAfterClickListener(this.bvJ);
        this.bvF = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bvR = (FrsCommonImageLayout) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bvR.setDrawNum(false);
        this.bvR.setAfterChildClickListener(this.bvT);
        this.bvN = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.buR = view.findViewById(w.h.divider_below_reply_number_layout);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avN, w.e.cp_bg_line_b);
            this.bvQ.onChangeSkinType();
            this.bvN.onChangeSkinType();
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
    public void onBindDataToView(com.baidu.tieba.card.data.l lVar) {
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
        this.bvE = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bvI);
        }
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.bvE.bxx) {
            this.amf.setVisibility(8);
            this.bvQ.setVisibility(8);
        } else {
            this.bvQ.setVisibility(0);
            this.amf.setVisibility(0);
            this.amf.setData(lVar.threadData);
            this.amf.setAfterClickListener(this.amk);
            UserTbVipInfoData rz = this.bvE.threadData.rz();
            if (rz != null && rz.getvipV_url() != null && this.amh != null) {
                if (this.ami == null) {
                    this.amh.inflate();
                    this.ami = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.ami.c(rz.getvipV_url(), 10, false);
                this.amf.setIsBigV(true);
            }
        }
        this.bvQ.setData(lVar.threadData);
        this.bvQ.setUserAfterClickListener(this.amk);
        if (this.bvN.a(lVar.threadData)) {
            this.buR.setVisibility(8);
        }
        this.bvN.setForumAfterClickListener(this.alY);
        this.bvN.setStType(ap.rp());
        this.bvN.setYuelaouLocate("feed#" + lVar.Tq());
        if ((StringUtils.isNull(lVar.threadData.getTitle()) && (lVar.threadData.rx() == null || lVar.threadData.rx().size() == 0)) || lVar.threadData.rN() == 1) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            lVar.threadData.XF = 0;
            lVar.threadData.sg();
            SpannableStringBuilder rY = lVar.threadData.rY();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.aa(rY));
            this.mTitle.setText(rY);
            if (!Te()) {
                ap.a(this.mTitle, lVar.JB().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.aq.i(this.mTitle, w.e.cp_cont_b);
            }
        }
        if (!Te() && ap.hZ(lVar.threadData.getId())) {
            ap.a(this.mTitle, this.bvE.JB().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            ap.a(this.bvF, this.bvE.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.threadData.rG() != null && !StringUtils.isNull(lVar.threadData.rG())) {
            stringBuffer.append(lVar.threadData.rG());
        }
        ArrayList<MediaData> rI = lVar.threadData.rI();
        if (rI != null) {
            i = rI.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (rI.get(i4).getVideoUrl() != null && rI.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(rI.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (!TextUtils.isEmpty(lVar.threadData.g(stringBuffer.toString(), true))) {
                this.bvF.setVisibility(0);
                SpannableString cv = lVar.threadData.cv(stringBuffer.toString());
                this.bvF.setOnTouchListener(new com.baidu.tieba.view.aa(cv));
                this.bvF.setText(cv);
                if (!Te()) {
                    ap.a(this.bvF, lVar.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.aq.i(this.bvF, w.e.cp_cont_j);
                }
            } else {
                this.bvF.setVisibility(8);
            }
        } else {
            this.bvF.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> rM = lVar.threadData.rM();
        if (rM != null && rM.size() > 0) {
            this.bvC.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rM.get(0);
            this.bvC.setVoiceModel(voiceModel);
            this.bvC.setTag(voiceModel);
            this.bvC.aYC();
            if (voiceModel != null) {
                this.bvC.lT(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.bvC.setVisibility(8);
            z = false;
        }
        if (this.bvE.bxx && z) {
            this.bvR.setVisibility(8);
        } else if (com.baidu.tbadk.core.r.oV().pb() && com.baidu.tbadk.core.util.x.q(rI) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (rI.get(i5) == null || !(rI.get(i5).getType() == 3 || rI.get(i5).getType() == 5)) {
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
                    if (rI.get(i9).getType() == 3 || rI.get(i9).getType() == 5) {
                        mediaDataArr[i8] = rI.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.bvR.setVisibility(0);
                this.bvR.a(lVar.threadData, lVar.threadData.rD(), new StringBuilder(String.valueOf(lVar.threadData.getFid())).toString(), lVar.threadData.getTid());
                this.bvR.setShowBig(com.baidu.tbadk.core.util.av.vo().vq());
                this.bvR.a(this.ajr, mediaDataArr, i6);
                this.bvR.setFromCDN(this.ahv);
                this.bvR.setImageFrom("other");
            } else {
                this.bvR.setVisibility(8);
            }
        } else {
            this.bvR.setVisibility(8);
        }
        Ti();
    }

    private void Ti() {
        if (!this.bvE.aAo) {
            this.bvR.setOnChildClickListener(this.bvS);
            this.bvC.setClickable(false);
            this.bvN.setBarNameClickEnabled(false);
        } else {
            this.bvR.setOnChildClickListener(null);
            this.bvC.setClickable(true);
            this.bvN.setBarNameClickEnabled(true);
        }
        int childCount = this.bvR.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvR.getChildAt(i);
            if (childAt != null) {
                if (!this.bvE.aAo) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahv = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvN != null) {
            this.bvN.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tj() {
        if (this.bvE != null && this.bvE.threadData != null) {
            if (!Te()) {
                ap.hY(this.bvE.threadData.getId());
                ap.a(this.mTitle, this.bvE.JB().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                ap.a(this.bvF, this.bvE.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajr.getPageActivity()).createFromThreadCfg(this.bvE.threadData, null, ap.rp(), 18003, true, false, false).addLocateParam(this.bvE.Tr());
            addLocateParam.setForumId(String.valueOf(this.bvE.threadData.getFid()));
            if (this.bvE.bxe == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bvE.bxe);
            }
            this.ajr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Te() {
        return this.bvE.bxx && !this.bvE.aAo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
