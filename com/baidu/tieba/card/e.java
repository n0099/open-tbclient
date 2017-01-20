package com.baidu.tieba.card;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.GodHeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a<com.baidu.tieba.card.data.f> {
    private View FN;
    private TbPageContext<?> FY;
    private TextView aNb;
    private BdUniqueId aUC;
    public ViewStub aUU;
    public TbImageView aUV;
    private com.baidu.tbadk.core.data.bh acX;
    private boolean acy;
    public TextView agJ;
    private View apX;
    private View bkF;
    public boolean bkI;
    private CommonUserLikeButton.a bkJ;
    public GodHeadImageView bkK;
    public TextView bkL;
    public EntelechyUserLikeButton bkM;
    private com.baidu.tbadk.core.view.userLike.c bkN;
    public FrameLayout bkO;
    private TbImageView bkP;
    private ImageView bkQ;
    public PlayVoiceBnt bkR;
    private TextView bkS;
    private FrsCommonImageLayout bkT;
    public ThreadCommentAndPraiseInfoLayout bkU;
    private PbHistoryCacheModel bkV;
    private com.baidu.tieba.tbadkCore.util.n bkW;
    private int bkX;
    private com.baidu.tieba.card.data.f bkY;
    private boolean bkZ;
    private CustomMessageListener bla;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bkI = true;
        this.mSkinType = 3;
        this.bkJ = new f(this);
        this.bkX = r.e.cp_cont_d;
        this.acy = true;
        this.bkZ = true;
        this.bla = new g(this, CmdConfigCustom.CMD_ADD_HISTORY);
        View view = getView();
        this.FY = tbPageContext;
        this.apX = view.findViewById(r.h.card_god_feed_top_line);
        this.FN = view.findViewById(r.h.card_god_feed_bottom_line);
        this.bkF = view.findViewById(r.h.card_god_feed_top_margin);
        this.bkK = (GodHeadImageView) view.findViewById(r.h.card_god_feed_user_header);
        this.aUU = (ViewStub) view.findViewById(r.h.viewstub_headimage_mask);
        this.agJ = (TextView) view.findViewById(r.h.card_god_feed_user_name);
        this.bkL = (TextView) view.findViewById(r.h.card_god_feed_fan_num);
        this.aNb = (TextView) view.findViewById(r.h.card_god_feed_title);
        this.bkO = (FrameLayout) view.findViewById(r.h.god_feed_video_frame);
        this.bkP = (TbImageView) view.findViewById(r.h.god_feed_video_background);
        this.bkQ = (ImageView) view.findViewById(r.h.god_feed_video_play);
        this.bkR = (PlayVoiceBnt) view.findViewById(r.h.card_god_feed_abstract_voice);
        this.bkR.setAfterClickListener(this);
        this.bkS = (TextView) view.findViewById(r.h.card_god_feed_abstract);
        this.bkT = (FrsCommonImageLayout) view.findViewById(r.h.card_god_feed_img_layout);
        this.bkT.setDrawNum(false);
        this.bkT.setAfterChildClickListener(this);
        this.bkU = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.h.card_god_feed_thread_info_layout);
        this.bkU.setForumAfterClickListener(this);
        this.bkW = TbadkCoreApplication.m9getInst().getGodFeedReadHistory();
        this.bkM = (EntelechyUserLikeButton) view.findViewById(r.h.card_god_feed_like_btn);
        this.bkN = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bkM);
        this.bkM.setFanNumCallBack(this.bkJ);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.k(this.bkF, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.i((View) this.agJ, r.e.cp_cont_b);
            com.baidu.tbadk.core.util.ap.i((View) this.bkL, r.e.cp_cont_d);
            com.baidu.tbadk.core.util.ap.j(getView(), r.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.ap.k(this.apX, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.k(this.FN, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.c(this.bkQ, r.g.icon_play_video);
            this.bkU.tg();
            this.bkK.vO();
            this.bkM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_god_feed;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.f fVar) {
        int i;
        int i2;
        int i3;
        if (fVar != null && fVar.threadData != null) {
            this.bkY = fVar;
            this.acX = fVar.threadData;
            getView().setOnClickListener(this);
            this.bkK.setOnClickListener(this);
            this.agJ.setOnClickListener(this);
            this.bkL.setOnClickListener(this);
            if (this.bkI && this.acX.getAuthor() != null && this.acX.getAuthor().getGodUserData() != null) {
                if (this.acX.getAuthor().getGodUserData().getIsLike()) {
                    this.bkM.setVisibility(8);
                } else {
                    this.bkM.setVisibility(0);
                    this.bkN.a(this.acX.getAuthor());
                }
            } else {
                this.bkM.setVisibility(8);
            }
            if (fVar.needTopMargin) {
                this.bkF.setVisibility(0);
            } else {
                this.bkF.setVisibility(8);
            }
            if (fVar.threadData.getAuthor() != null) {
                this.bkK.setContentDescription(String.valueOf(fVar.threadData.getAuthor().getUserName()) + this.FY.getString(r.l.somebodys_portrait));
                this.bkK.c(fVar.threadData.getAuthor().getPortrait(), 28, false);
                UserTbVipInfoData rx = this.acX.rx();
                if (rx != null && rx.getvipV_url() != null) {
                    if (this.aUU != null) {
                        if (this.aUV == null) {
                            this.aUU.inflate();
                            this.aUV = (TbImageView) getView().findViewById(r.h.user_head_mask);
                        }
                        this.bkK.setShapeType(3);
                        this.aUV.c(rx.getvipV_url(), 10, false);
                    }
                } else {
                    this.bkK.setShapeType(1);
                    this.bkK.setShowType(1);
                }
            }
            if (fVar.threadData.getAuthor() != null) {
                this.agJ.setText(com.baidu.tbadk.core.util.at.dA(com.baidu.tbadk.core.util.at.c(fVar.threadData.getAuthor().getName_show(), 14, "...")));
                gI(fVar.threadData.getAuthor().getFansNum());
            }
            this.bkU.a(fVar.threadData);
            if (fVar.threadData.rL() == 1 || StringUtils.isNull(fVar.threadData.getTitle())) {
                this.aNb.setVisibility(8);
            } else {
                this.aNb.setVisibility(0);
                this.aNb.setText(fVar.threadData.getTitle());
                m(this.aNb, r.e.cp_cont_b);
            }
            if (fVar.threadData.rN() == null || StringUtils.isNull(fVar.threadData.rN().video_url)) {
                this.bkO.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (fVar.threadData.rE() != null && !StringUtils.isNull(fVar.threadData.rE())) {
                    stringBuffer.append(fVar.threadData.rE());
                }
                ArrayList<MediaData> rG = fVar.threadData.rG();
                if (rG != null) {
                    i = rG.size();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i4 = 0; i4 < i; i4++) {
                        if (rG.get(i4).getVideoUrl() != null && rG.get(i4).getVideoUrl().endsWith("swf")) {
                            stringBuffer2.append(rG.get(i4).getVideoUrl());
                        }
                    }
                    stringBuffer.append(stringBuffer2.toString());
                    if (stringBuffer.length() > 0) {
                        SpannableString cx = fVar.threadData.cx(stringBuffer.toString());
                        this.bkS.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                        this.bkS.setText(cx);
                        this.bkS.setVisibility(0);
                        m(this.bkS, r.e.cp_cont_c);
                    } else {
                        this.bkS.setVisibility(8);
                    }
                } else {
                    this.bkS.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> rK = fVar.threadData.rK();
                if (rK != null && rK.size() > 0) {
                    this.bkR.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rK.get(0);
                    this.bkR.setVoiceModel(voiceModel);
                    this.bkR.setTag(voiceModel);
                    this.bkR.ayK();
                    if (voiceModel != null) {
                        this.bkR.mj(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.bkR.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.oC().oI() && com.baidu.tbadk.core.util.w.r(rG) != 0 && (rK == null || rK.size() == 0)) {
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (i5 < i) {
                        if (rG.get(i5) == null || !(rG.get(i5).getType() == 3 || rG.get(i5).getType() == 5)) {
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
                            if (rG.get(i9).getType() == 3 || rG.get(i9).getType() == 5) {
                                mediaDataArr[i8] = rG.get(i9);
                                i2 = i8 + 1;
                            } else {
                                i2 = i8;
                            }
                            i9++;
                            i8 = i2;
                        }
                        this.bkT.setVisibility(0);
                        this.bkT.a(fVar.threadData, fVar.threadData.rB(), new StringBuilder(String.valueOf(fVar.threadData.getFid())).toString(), fVar.threadData.getTid());
                        this.bkT.setShowBig(com.baidu.tbadk.core.util.au.vg().vi());
                        this.bkT.a(this.FY, mediaDataArr, i6);
                        this.bkT.setFromCDN(this.acy);
                        this.bkT.setImageFrom("other");
                    } else {
                        this.bkT.setVisibility(8);
                    }
                } else {
                    this.bkT.setVisibility(8);
                }
            } else {
                this.bkS.setVisibility(8);
                this.bkR.setVisibility(8);
                this.bkT.setVisibility(8);
                if (com.baidu.tbadk.core.l.oC().oI() && !StringUtils.isNull(fVar.threadData.rN().video_url)) {
                    this.bkO.setVisibility(0);
                    this.bkP.c(fVar.threadData.rN().thumbnail_url, 10, true);
                } else {
                    this.bkO.setVisibility(8);
                }
            }
            onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.acX != null) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(view, this.bkY);
            }
            if (view == this.bkK || view == this.agJ || view == this.bkL) {
                if (this.acX.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.FY.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.acX.getAuthor().getUserId(), 0L), false)));
                }
            } else if (view == getView() && !StringUtils.isNull(this.acX.getId())) {
                if (this.bkW == null) {
                    Rl();
                    return;
                }
                com.baidu.tieba.myCollection.baseHistory.a qM = this.bkW.qM(this.acX.getId());
                if (qM == null) {
                    Rl();
                    return;
                }
                this.FY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.FY.getPageActivity()).createGodHistoryCfg(qM.getThreadId(), qM.CS(), qM.aGB(), qM.aGC(), null, this.acX.rW(), this.acX.rt()).disablePbKeyPostId()));
            }
        }
    }

    private void Rl() {
        this.FY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.FY.getPageActivity()).createFromThreadCfg(this.acX, null, at.Mt(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(TextView textView, int i) {
        at.a(textView, this.acX.getId(), i, this.bkX);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bkU != null) {
            this.aUC = bdUniqueId;
            this.bla.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bla);
            this.bkU.h(bdUniqueId);
            this.bkN.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(int i) {
        this.bkL.setText(String.format(this.FY.getResources().getString(r.l.fans_default_name_god_user), com.baidu.tbadk.core.util.at.u(i)));
    }
}
