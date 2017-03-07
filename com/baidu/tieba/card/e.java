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
    private TextView aSO;
    private boolean ahO;
    private com.baidu.tbadk.core.data.bj ain;
    private TbPageContext<?> ajF;
    public TextView amc;
    private View avr;
    private View avs;
    private BdUniqueId baP;
    public ViewStub bbh;
    public TbImageView bbi;
    public boolean brA;
    private CommonUserLikeButton.a brB;
    public GodHeadImageView brC;
    public TextView brD;
    public EntelechyUserLikeButton brE;
    private com.baidu.tbadk.core.view.userLike.c brF;
    public FrameLayout brG;
    private TbImageView brH;
    private ImageView brI;
    public PlayVoiceBnt brJ;
    private TextView brK;
    private FrsCommonImageLayout brL;
    public ThreadCommentAndPraiseInfoLayout brM;
    private PbHistoryCacheModel brN;
    private com.baidu.tieba.tbadkCore.util.n brO;
    private int brP;
    private com.baidu.tieba.card.data.f brQ;
    private boolean brR;
    private CustomMessageListener brS;
    private View brx;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.brA = true;
        this.mSkinType = 3;
        this.brB = new f(this);
        this.brP = w.e.cp_cont_d;
        this.ahO = true;
        this.brR = true;
        this.brS = new g(this, CmdConfigCustom.CMD_ADD_HISTORY);
        View view = getView();
        this.ajF = tbPageContext;
        this.avr = view.findViewById(w.h.card_god_feed_top_line);
        this.avs = view.findViewById(w.h.card_god_feed_bottom_line);
        this.brx = view.findViewById(w.h.card_god_feed_top_margin);
        this.brC = (GodHeadImageView) view.findViewById(w.h.card_god_feed_user_header);
        this.bbh = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.amc = (TextView) view.findViewById(w.h.card_god_feed_user_name);
        this.brD = (TextView) view.findViewById(w.h.card_god_feed_fan_num);
        this.aSO = (TextView) view.findViewById(w.h.card_god_feed_title);
        this.brG = (FrameLayout) view.findViewById(w.h.god_feed_video_frame);
        this.brH = (TbImageView) view.findViewById(w.h.god_feed_video_background);
        this.brI = (ImageView) view.findViewById(w.h.god_feed_video_play);
        this.brJ = (PlayVoiceBnt) view.findViewById(w.h.card_god_feed_abstract_voice);
        this.brJ.setAfterClickListener(this);
        this.brK = (TextView) view.findViewById(w.h.card_god_feed_abstract);
        this.brL = (FrsCommonImageLayout) view.findViewById(w.h.card_god_feed_img_layout);
        this.brL.setDrawNum(false);
        this.brL.setAfterChildClickListener(this);
        this.brM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_god_feed_thread_info_layout);
        this.brM.setForumAfterClickListener(this);
        this.brO = TbadkCoreApplication.m9getInst().getGodFeedReadHistory();
        this.brE = (EntelechyUserLikeButton) view.findViewById(w.h.card_god_feed_like_btn);
        this.brF = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brE);
        this.brE.setFanNumCallBack(this.brB);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(this.brx, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i((View) this.amc, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i((View) this.brD, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avr, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.avs, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.c(this.brI, w.g.icon_play_video);
            this.brM.tD();
            this.brC.wl();
            this.brE.onChangeSkinType(i);
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
            this.brQ = fVar;
            this.ain = fVar.threadData;
            getView().setOnClickListener(this);
            this.brC.setOnClickListener(this);
            this.amc.setOnClickListener(this);
            this.brD.setOnClickListener(this);
            if (this.brA && this.ain.getAuthor() != null && this.ain.getAuthor().getGodUserData() != null) {
                if (this.ain.getAuthor().getGodUserData().getIsLike()) {
                    this.brE.setVisibility(8);
                } else {
                    this.brE.setVisibility(0);
                    this.brF.a(this.ain.getAuthor());
                }
            } else {
                this.brE.setVisibility(8);
            }
            if (fVar.needTopMargin) {
                this.brx.setVisibility(0);
            } else {
                this.brx.setVisibility(8);
            }
            if (fVar.threadData.getAuthor() != null) {
                this.brC.setContentDescription(String.valueOf(fVar.threadData.getAuthor().getUserName()) + this.ajF.getString(w.l.somebodys_portrait));
                this.brC.c(fVar.threadData.getAuthor().getPortrait(), 28, false);
                UserTbVipInfoData rR = this.ain.rR();
                if (rR != null && rR.getvipV_url() != null) {
                    if (this.bbh != null) {
                        if (this.bbi == null) {
                            this.bbh.inflate();
                            this.bbi = (TbImageView) getView().findViewById(w.h.user_head_mask);
                        }
                        this.brC.setShapeType(3);
                        this.bbi.c(rR.getvipV_url(), 10, false);
                    }
                } else {
                    this.brC.setShapeType(1);
                    this.brC.setShowType(1);
                }
            }
            if (fVar.threadData.getAuthor() != null) {
                this.amc.setText(com.baidu.tbadk.core.util.au.dt(com.baidu.tbadk.core.util.au.c(fVar.threadData.getAuthor().getName_show(), 14, "...")));
                gF(fVar.threadData.getAuthor().getFansNum());
            }
            this.brM.a(fVar.threadData);
            if (fVar.threadData.sf() == 1 || StringUtils.isNull(fVar.threadData.getTitle())) {
                this.aSO.setVisibility(8);
            } else {
                this.aSO.setVisibility(0);
                this.aSO.setText(fVar.threadData.getTitle());
                l(this.aSO, w.e.cp_cont_b);
            }
            if (fVar.threadData.sh() == null || StringUtils.isNull(fVar.threadData.sh().video_url)) {
                this.brG.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (fVar.threadData.rY() != null && !StringUtils.isNull(fVar.threadData.rY())) {
                    stringBuffer.append(fVar.threadData.rY());
                }
                ArrayList<MediaData> sa = fVar.threadData.sa();
                if (sa != null) {
                    i = sa.size();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i4 = 0; i4 < i; i4++) {
                        if (sa.get(i4).getVideoUrl() != null && sa.get(i4).getVideoUrl().endsWith("swf")) {
                            stringBuffer2.append(sa.get(i4).getVideoUrl());
                        }
                    }
                    stringBuffer.append(stringBuffer2.toString());
                    if (stringBuffer.length() > 0) {
                        SpannableString cq = fVar.threadData.cq(stringBuffer.toString());
                        this.brK.setOnTouchListener(new com.baidu.tieba.view.x(cq));
                        this.brK.setText(cq);
                        this.brK.setVisibility(0);
                        l(this.brK, w.e.cp_cont_c);
                    } else {
                        this.brK.setVisibility(8);
                    }
                } else {
                    this.brK.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> se = fVar.threadData.se();
                if (se != null && se.size() > 0) {
                    this.brJ.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = se.get(0);
                    this.brJ.setVoiceModel(voiceModel);
                    this.brJ.setTag(voiceModel);
                    this.brJ.ayg();
                    if (voiceModel != null) {
                        this.brJ.lZ(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.brJ.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.oQ().oW() && com.baidu.tbadk.core.util.x.p(sa) != 0 && (se == null || se.size() == 0)) {
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
                        this.brL.a(fVar.threadData, fVar.threadData.rV(), new StringBuilder(String.valueOf(fVar.threadData.getFid())).toString(), fVar.threadData.getTid());
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
            } else {
                this.brK.setVisibility(8);
                this.brJ.setVisibility(8);
                this.brL.setVisibility(8);
                if (com.baidu.tbadk.core.l.oQ().oW() && !StringUtils.isNull(fVar.threadData.sh().video_url)) {
                    this.brG.setVisibility(0);
                    this.brH.c(fVar.threadData.sh().thumbnail_url, 10, true);
                } else {
                    this.brG.setVisibility(8);
                }
            }
            onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ain != null) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(view, this.brQ);
            }
            if (view == this.brC || view == this.amc || view == this.brD) {
                if (this.ain.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.ajF.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.ain.getAuthor().getUserId(), 0L), false)));
                }
            } else if (view == getView() && !StringUtils.isNull(this.ain.getId())) {
                if (this.brO == null) {
                    Si();
                    return;
                }
                com.baidu.tieba.myCollection.baseHistory.a pU = this.brO.pU(this.ain.getId());
                if (pU == null) {
                    Si();
                    return;
                }
                this.ajF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajF.getPageActivity()).createGodHistoryCfg(pU.getThreadId(), pU.Dl(), pU.aFZ(), pU.aGa(), null, this.ain.sr(), this.ain.rN()).disablePbKeyPostId()));
            }
        }
    }

    private void Si() {
        this.ajF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajF.getPageActivity()).createFromThreadCfg(this.ain, null, at.rH(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(TextView textView, int i) {
        at.a(textView, this.ain.getId(), i, this.brP);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.brM != null) {
            this.baP = bdUniqueId;
            this.brS.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.brS);
            this.brM.h(bdUniqueId);
            this.brF.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(int i) {
        this.brD.setText(String.format(this.ajF.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
    }
}
