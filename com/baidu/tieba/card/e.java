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
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a<com.baidu.tieba.card.data.f> {
    private com.baidu.tbadk.core.data.bi aiC;
    private boolean aid;
    private TbPageContext<?> ajU;
    public TextView amq;
    private View avJ;
    private View avK;
    private BdUniqueId bbE;
    public ViewStub bbW;
    public TbImageView bbX;
    private View btH;
    public boolean btK;
    private CommonUserLikeButton.a btL;
    public GodHeadImageView btM;
    public TextView btN;
    public EntelechyUserLikeButton btO;
    private com.baidu.tbadk.core.view.userLike.c btP;
    public FrameLayout btQ;
    private TbImageView btR;
    private ImageView btS;
    public PlayVoiceBnt btT;
    private TextView btU;
    private FrsCommonImageLayout btV;
    public ThreadCommentAndPraiseInfoLayout btW;
    private PbHistoryCacheModel btX;
    private com.baidu.tieba.tbadkCore.util.n btY;
    private int btZ;
    private com.baidu.tieba.card.data.f bua;
    private boolean bub;
    private CustomMessageListener buc;
    private int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.btK = true;
        this.mSkinType = 3;
        this.btL = new f(this);
        this.btZ = w.e.cp_cont_d;
        this.aid = true;
        this.bub = true;
        this.buc = new g(this, CmdConfigCustom.CMD_ADD_HISTORY);
        View view = getView();
        this.ajU = tbPageContext;
        this.avJ = view.findViewById(w.h.card_god_feed_top_line);
        this.avK = view.findViewById(w.h.card_god_feed_bottom_line);
        this.btH = view.findViewById(w.h.card_god_feed_top_margin);
        this.btM = (GodHeadImageView) view.findViewById(w.h.card_god_feed_user_header);
        this.bbW = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.amq = (TextView) view.findViewById(w.h.card_god_feed_user_name);
        this.btN = (TextView) view.findViewById(w.h.card_god_feed_fan_num);
        this.mTitle = (TextView) view.findViewById(w.h.card_god_feed_title);
        this.btQ = (FrameLayout) view.findViewById(w.h.god_feed_video_frame);
        this.btR = (TbImageView) view.findViewById(w.h.god_feed_video_background);
        this.btS = (ImageView) view.findViewById(w.h.god_feed_video_play);
        this.btT = (PlayVoiceBnt) view.findViewById(w.h.card_god_feed_abstract_voice);
        this.btT.setAfterClickListener(this);
        this.btU = (TextView) view.findViewById(w.h.card_god_feed_abstract);
        this.btV = (FrsCommonImageLayout) view.findViewById(w.h.card_god_feed_img_layout);
        this.btV.setDrawNum(false);
        this.btV.setAfterChildClickListener(this);
        this.btW = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_god_feed_thread_info_layout);
        this.btW.setForumAfterClickListener(this);
        this.btY = TbadkCoreApplication.m9getInst().getGodFeedReadHistory();
        this.btO = (EntelechyUserLikeButton) view.findViewById(w.h.card_god_feed_like_btn);
        this.btP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.btO);
        this.btO.setFanNumCallBack(this.btL);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(this.btH, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(this.amq, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.btN, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avJ, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.avK, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.c(this.btS, w.g.icon_play_video);
            this.btW.onChangeSkinType();
            this.btM.wH();
            this.btO.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_god_feed;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.f fVar) {
        int i;
        int i2;
        int i3;
        if (fVar != null && fVar.threadData != null) {
            this.bua = fVar;
            this.aiC = fVar.threadData;
            getView().setOnClickListener(this);
            this.btM.setOnClickListener(this);
            this.amq.setOnClickListener(this);
            this.btN.setOnClickListener(this);
            if (this.btK && this.aiC.getAuthor() != null && this.aiC.getAuthor().getGodUserData() != null) {
                if (this.aiC.getAuthor().getGodUserData().getIsLike()) {
                    this.btO.setVisibility(8);
                } else {
                    this.btO.setVisibility(0);
                    this.btP.a(this.aiC.getAuthor());
                }
            } else {
                this.btO.setVisibility(8);
            }
            if (fVar.needTopMargin) {
                this.btH.setVisibility(0);
            } else {
                this.btH.setVisibility(8);
            }
            if (fVar.threadData.getAuthor() != null) {
                this.btM.setContentDescription(String.valueOf(fVar.threadData.getAuthor().getUserName()) + this.ajU.getString(w.l.somebodys_portrait));
                this.btM.c(fVar.threadData.getAuthor().getPortrait(), 28, false);
                UserTbVipInfoData sp = this.aiC.sp();
                if (sp != null && sp.getvipV_url() != null) {
                    if (this.bbW != null) {
                        if (this.bbX == null) {
                            this.bbW.inflate();
                            this.bbX = (TbImageView) getView().findViewById(w.h.user_head_mask);
                        }
                        this.btM.setShapeType(3);
                        this.bbX.c(sp.getvipV_url(), 10, false);
                    }
                } else {
                    this.btM.setShapeType(1);
                    this.btM.setShowType(1);
                }
            }
            if (fVar.threadData.getAuthor() != null) {
                this.amq.setText(com.baidu.tbadk.core.util.au.dz(com.baidu.tbadk.core.util.au.c(fVar.threadData.getAuthor().getName_show(), 14, "...")));
                gO(fVar.threadData.getAuthor().getFansNum());
            }
            this.btW.a(fVar.threadData);
            if (fVar.threadData.sD() == 1 || StringUtils.isNull(fVar.threadData.getTitle())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(fVar.threadData.getTitle());
                j(this.mTitle, w.e.cp_cont_b);
            }
            if (fVar.threadData.sF() == null || StringUtils.isNull(fVar.threadData.sF().video_url)) {
                this.btQ.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (fVar.threadData.sw() != null && !StringUtils.isNull(fVar.threadData.sw())) {
                    stringBuffer.append(fVar.threadData.sw());
                }
                ArrayList<MediaData> sy = fVar.threadData.sy();
                if (sy != null) {
                    i = sy.size();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i4 = 0; i4 < i; i4++) {
                        if (sy.get(i4).getVideoUrl() != null && sy.get(i4).getVideoUrl().endsWith("swf")) {
                            stringBuffer2.append(sy.get(i4).getVideoUrl());
                        }
                    }
                    stringBuffer.append(stringBuffer2.toString());
                    if (stringBuffer.length() > 0) {
                        SpannableString cx = fVar.threadData.cx(stringBuffer.toString());
                        this.btU.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                        this.btU.setText(cx);
                        this.btU.setVisibility(0);
                        j(this.btU, w.e.cp_cont_c);
                    } else {
                        this.btU.setVisibility(8);
                    }
                } else {
                    this.btU.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> sC = fVar.threadData.sC();
                if (sC != null && sC.size() > 0) {
                    this.btT.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = sC.get(0);
                    this.btT.setVoiceModel(voiceModel);
                    this.btT.setTag(voiceModel);
                    this.btT.bbd();
                    if (voiceModel != null) {
                        this.btT.mg(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.btT.setVisibility(8);
                }
                if (com.baidu.tbadk.core.q.po().pu() && com.baidu.tbadk.core.util.x.p(sy) != 0 && (sC == null || sC.size() == 0)) {
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
                        this.btV.setVisibility(0);
                        this.btV.a(fVar.threadData, fVar.threadData.st(), new StringBuilder(String.valueOf(fVar.threadData.getFid())).toString(), fVar.threadData.getTid());
                        this.btV.setShowBig(com.baidu.tbadk.core.util.av.wa().wc());
                        this.btV.a(this.ajU, mediaDataArr, i6);
                        this.btV.setFromCDN(this.aid);
                        this.btV.setImageFrom("other");
                    } else {
                        this.btV.setVisibility(8);
                    }
                } else {
                    this.btV.setVisibility(8);
                }
            } else {
                this.btU.setVisibility(8);
                this.btT.setVisibility(8);
                this.btV.setVisibility(8);
                if (com.baidu.tbadk.core.q.po().pu() && !StringUtils.isNull(fVar.threadData.sF().video_url)) {
                    this.btQ.setVisibility(0);
                    this.btR.c(fVar.threadData.sF().thumbnail_url, 10, true);
                } else {
                    this.btQ.setVisibility(8);
                }
            }
            onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aiC != null) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(view, this.bua);
            }
            if (view == this.btM || view == this.amq || view == this.btN) {
                if (this.aiC.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.ajU.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.aiC.getAuthor().getUserId(), 0L), false)));
                }
            } else if (view == getView() && !StringUtils.isNull(this.aiC.getId())) {
                if (this.btY == null) {
                    TI();
                    return;
                }
                com.baidu.tieba.myCollection.baseHistory.a qm = this.btY.qm(this.aiC.getId());
                if (qm == null) {
                    TI();
                    return;
                }
                this.ajU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajU.getPageActivity()).createGodHistoryCfg(qm.getThreadId(), qm.DJ(), qm.aGN(), qm.aGO(), null, this.aiC.sP(), this.aiC.sl()).disablePbKeyPostId()));
            }
        }
    }

    private void TI() {
        this.ajU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajU.getPageActivity()).createFromThreadCfg(this.aiC, null, at.sf(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(TextView textView, int i) {
        at.a(textView, this.aiC.getId(), i, this.btZ);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.btW != null) {
            this.bbE = bdUniqueId;
            this.buc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.buc);
            this.btW.h(bdUniqueId);
            this.btP.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(int i) {
        this.btN.setText(String.format(this.ajU.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
    }
}
