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
    private com.baidu.tbadk.core.data.bi aiB;
    private boolean aic;
    private TbPageContext<?> ajT;
    public TextView amq;
    private View avH;
    private View avI;
    private BdUniqueId baI;
    public ViewStub bba;
    public TbImageView bbb;
    private ImageView brA;
    public PlayVoiceBnt brB;
    private TextView brC;
    private FrsCommonImageLayout brD;
    public ThreadCommentAndPraiseInfoLayout brE;
    private PbHistoryCacheModel brF;
    private com.baidu.tieba.tbadkCore.util.n brG;
    private int brH;
    private com.baidu.tieba.card.data.f brI;
    private boolean brJ;
    private CustomMessageListener brK;
    private View brp;
    public boolean brs;
    private CommonUserLikeButton.a brt;
    public GodHeadImageView bru;
    public TextView brv;
    public EntelechyUserLikeButton brw;
    private com.baidu.tbadk.core.view.userLike.c brx;
    public FrameLayout bry;
    private TbImageView brz;
    private int mSkinType;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.brs = true;
        this.mSkinType = 3;
        this.brt = new f(this);
        this.brH = w.e.cp_cont_d;
        this.aic = true;
        this.brJ = true;
        this.brK = new g(this, CmdConfigCustom.CMD_ADD_HISTORY);
        View view = getView();
        this.ajT = tbPageContext;
        this.avH = view.findViewById(w.h.card_god_feed_top_line);
        this.avI = view.findViewById(w.h.card_god_feed_bottom_line);
        this.brp = view.findViewById(w.h.card_god_feed_top_margin);
        this.bru = (GodHeadImageView) view.findViewById(w.h.card_god_feed_user_header);
        this.bba = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.amq = (TextView) view.findViewById(w.h.card_god_feed_user_name);
        this.brv = (TextView) view.findViewById(w.h.card_god_feed_fan_num);
        this.mTitle = (TextView) view.findViewById(w.h.card_god_feed_title);
        this.bry = (FrameLayout) view.findViewById(w.h.god_feed_video_frame);
        this.brz = (TbImageView) view.findViewById(w.h.god_feed_video_background);
        this.brA = (ImageView) view.findViewById(w.h.god_feed_video_play);
        this.brB = (PlayVoiceBnt) view.findViewById(w.h.card_god_feed_abstract_voice);
        this.brB.setAfterClickListener(this);
        this.brC = (TextView) view.findViewById(w.h.card_god_feed_abstract);
        this.brD = (FrsCommonImageLayout) view.findViewById(w.h.card_god_feed_img_layout);
        this.brD.setDrawNum(false);
        this.brD.setAfterChildClickListener(this);
        this.brE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_god_feed_thread_info_layout);
        this.brE.setForumAfterClickListener(this);
        this.brG = TbadkCoreApplication.m9getInst().getGodFeedReadHistory();
        this.brw = (EntelechyUserLikeButton) view.findViewById(w.h.card_god_feed_like_btn);
        this.brx = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.brw);
        this.brw.setFanNumCallBack(this.brt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(this.brp, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.i(this.amq, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.brv, w.e.cp_cont_d);
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avH, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.avI, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.c(this.brA, w.g.icon_play_video);
            this.brE.onChangeSkinType();
            this.bru.wH();
            this.brw.onChangeSkinType(i);
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
            this.brI = fVar;
            this.aiB = fVar.threadData;
            getView().setOnClickListener(this);
            this.bru.setOnClickListener(this);
            this.amq.setOnClickListener(this);
            this.brv.setOnClickListener(this);
            if (this.brs && this.aiB.getAuthor() != null && this.aiB.getAuthor().getGodUserData() != null) {
                if (this.aiB.getAuthor().getGodUserData().getIsLike()) {
                    this.brw.setVisibility(8);
                } else {
                    this.brw.setVisibility(0);
                    this.brx.a(this.aiB.getAuthor());
                }
            } else {
                this.brw.setVisibility(8);
            }
            if (fVar.needTopMargin) {
                this.brp.setVisibility(0);
            } else {
                this.brp.setVisibility(8);
            }
            if (fVar.threadData.getAuthor() != null) {
                this.bru.setContentDescription(String.valueOf(fVar.threadData.getAuthor().getUserName()) + this.ajT.getString(w.l.somebodys_portrait));
                this.bru.c(fVar.threadData.getAuthor().getPortrait(), 28, false);
                UserTbVipInfoData sp = this.aiB.sp();
                if (sp != null && sp.getvipV_url() != null) {
                    if (this.bba != null) {
                        if (this.bbb == null) {
                            this.bba.inflate();
                            this.bbb = (TbImageView) getView().findViewById(w.h.user_head_mask);
                        }
                        this.bru.setShapeType(3);
                        this.bbb.c(sp.getvipV_url(), 10, false);
                    }
                } else {
                    this.bru.setShapeType(1);
                    this.bru.setShowType(1);
                }
            }
            if (fVar.threadData.getAuthor() != null) {
                this.amq.setText(com.baidu.tbadk.core.util.au.dz(com.baidu.tbadk.core.util.au.c(fVar.threadData.getAuthor().getName_show(), 14, "...")));
                gI(fVar.threadData.getAuthor().getFansNum());
            }
            this.brE.a(fVar.threadData);
            if (fVar.threadData.sD() == 1 || StringUtils.isNull(fVar.threadData.getTitle())) {
                this.mTitle.setVisibility(8);
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(fVar.threadData.getTitle());
                j(this.mTitle, w.e.cp_cont_b);
            }
            if (fVar.threadData.sF() == null || StringUtils.isNull(fVar.threadData.sF().video_url)) {
                this.bry.setVisibility(8);
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
                        this.brC.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                        this.brC.setText(cx);
                        this.brC.setVisibility(0);
                        j(this.brC, w.e.cp_cont_c);
                    } else {
                        this.brC.setVisibility(8);
                    }
                } else {
                    this.brC.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> sC = fVar.threadData.sC();
                if (sC != null && sC.size() > 0) {
                    this.brB.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = sC.get(0);
                    this.brB.setVoiceModel(voiceModel);
                    this.brB.setTag(voiceModel);
                    this.brB.bac();
                    if (voiceModel != null) {
                        this.brB.ma(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.brB.setVisibility(8);
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
                        this.brD.setVisibility(0);
                        this.brD.a(fVar.threadData, fVar.threadData.st(), new StringBuilder(String.valueOf(fVar.threadData.getFid())).toString(), fVar.threadData.getTid());
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
            } else {
                this.brC.setVisibility(8);
                this.brB.setVisibility(8);
                this.brD.setVisibility(8);
                if (com.baidu.tbadk.core.q.po().pu() && !StringUtils.isNull(fVar.threadData.sF().video_url)) {
                    this.bry.setVisibility(0);
                    this.brz.c(fVar.threadData.sF().thumbnail_url, 10, true);
                } else {
                    this.bry.setVisibility(8);
                }
            }
            onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aiB != null) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(view, this.brI);
            }
            if (view == this.bru || view == this.amq || view == this.brv) {
                if (this.aiB.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.ajT.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.aiB.getAuthor().getUserId(), 0L), false)));
                }
            } else if (view == getView() && !StringUtils.isNull(this.aiB.getId())) {
                if (this.brG == null) {
                    SG();
                    return;
                }
                com.baidu.tieba.myCollection.baseHistory.a ql = this.brG.ql(this.aiB.getId());
                if (ql == null) {
                    SG();
                    return;
                }
                this.ajT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajT.getPageActivity()).createGodHistoryCfg(ql.getThreadId(), ql.DJ(), ql.aFM(), ql.aFN(), null, this.aiB.sP(), this.aiB.sl()).disablePbKeyPostId()));
            }
        }
    }

    private void SG() {
        this.ajT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajT.getPageActivity()).createFromThreadCfg(this.aiB, null, at.sf(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(TextView textView, int i) {
        at.a(textView, this.aiB.getId(), i, this.brH);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.brE != null) {
            this.baI = bdUniqueId;
            this.brK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.brK);
            this.brE.h(bdUniqueId);
            this.brx.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(int i) {
        this.brv.setText(String.format(this.ajT.getResources().getString(w.l.fans_default_name_god_user), com.baidu.tbadk.core.util.au.t(i)));
    }
}
