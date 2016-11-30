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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a<com.baidu.tieba.card.data.g> {
    private View GD;
    private TbPageContext<?> GO;
    private TextView aOH;
    private com.baidu.tbadk.core.view.userLike.c aRC;
    private CommonUserLikeButton.a aRG;
    private boolean adU;
    private com.baidu.tbadk.core.data.bk aeu;
    public TextView ahV;
    private View aro;
    private View bbL;
    public boolean bbO;
    public GodHeadImageView bbP;
    public ViewStub bbQ;
    public TbImageView bbR;
    public TextView bbS;
    public EntelechyUserLikeButton bbT;
    public FrameLayout bbU;
    private TbImageView bbV;
    private ImageView bbW;
    public PlayVoiceBnt bbX;
    private TextView bbY;
    private FrsCommonImageLayout bbZ;
    public ThreadCommentAndPraiseInfoLayout bca;
    private com.baidu.tieba.myCollection.baseHistory.a bcb;
    private com.baidu.tieba.tbadkCore.util.n bcc;
    private int bcd;
    private com.baidu.tieba.card.data.g bce;
    private BdUniqueId bcf;
    private boolean bcg;
    private CustomMessageListener bch;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bbO = true;
        this.mSkinType = 3;
        this.aRG = new f(this);
        this.bcd = r.d.cp_cont_d;
        this.adU = true;
        this.bcg = true;
        this.bch = new g(this, CmdConfigCustom.CMD_ADD_HISTORY);
        View view = getView();
        this.GO = tbPageContext;
        this.aro = view.findViewById(r.g.card_god_feed_top_line);
        this.GD = view.findViewById(r.g.card_god_feed_bottom_line);
        this.bbL = view.findViewById(r.g.card_god_feed_top_margin);
        this.bbP = (GodHeadImageView) view.findViewById(r.g.card_god_feed_user_header);
        this.bbQ = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.ahV = (TextView) view.findViewById(r.g.card_god_feed_user_name);
        this.bbS = (TextView) view.findViewById(r.g.card_god_feed_fan_num);
        this.aOH = (TextView) view.findViewById(r.g.card_god_feed_title);
        this.bbU = (FrameLayout) view.findViewById(r.g.god_feed_video_frame);
        this.bbV = (TbImageView) view.findViewById(r.g.god_feed_video_background);
        this.bbW = (ImageView) view.findViewById(r.g.god_feed_video_play);
        this.bbX = (PlayVoiceBnt) view.findViewById(r.g.card_god_feed_abstract_voice);
        this.bbX.setAfterClickListener(this);
        this.bbY = (TextView) view.findViewById(r.g.card_god_feed_abstract);
        this.bbZ = (FrsCommonImageLayout) view.findViewById(r.g.card_god_feed_img_layout);
        this.bbZ.setDrawNum(false);
        this.bbZ.setAfterChildClickListener(this);
        this.bca = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_god_feed_thread_info_layout);
        this.bca.setForumAfterClickListener(this);
        this.bcc = TbadkCoreApplication.m9getInst().getGodFeedReadHistory();
        this.bbT = (EntelechyUserLikeButton) view.findViewById(r.g.card_god_feed_like_btn);
        this.aRC = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bbT);
        this.bbT.setFanNumCallBack(this.aRG);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.l(this.bbL, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.ahV, r.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.j((View) this.bbS, r.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.k(getView(), r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aro, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(this.GD, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(this.bbW, r.f.icon_play_video);
            this.bca.tB();
            this.bbP.wk();
            this.bbT.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_god_feed;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.g gVar) {
        int i;
        int i2;
        int i3;
        if (gVar != null && gVar.threadData != null) {
            this.bce = gVar;
            this.aeu = gVar.threadData;
            getView().setOnClickListener(this);
            this.bbP.setOnClickListener(this);
            this.ahV.setOnClickListener(this);
            this.bbS.setOnClickListener(this);
            if (this.bbO && this.aeu.getAuthor() != null && this.aeu.getAuthor().getGodUserData() != null) {
                if (this.aeu.getAuthor().getGodUserData().getIsLike()) {
                    this.bbT.setVisibility(8);
                } else {
                    this.bbT.setVisibility(0);
                    this.aRC.a(this.aeu.getAuthor());
                }
            } else {
                this.bbT.setVisibility(8);
            }
            if (gVar.needTopMargin) {
                this.bbL.setVisibility(0);
            } else {
                this.bbL.setVisibility(8);
            }
            if (gVar.threadData.getAuthor() != null) {
                this.bbP.setContentDescription(String.valueOf(gVar.threadData.getAuthor().getUserName()) + this.GO.getString(r.j.somebodys_portrait));
                this.bbP.c(gVar.threadData.getAuthor().getPortrait(), 28, false);
                UserTbVipInfoData rQ = this.aeu.rQ();
                if (rQ != null && rQ.getvipV_url() != null) {
                    if (this.bbQ != null) {
                        if (this.bbR == null) {
                            this.bbQ.inflate();
                            this.bbR = (TbImageView) getView().findViewById(r.g.user_head_mask);
                        }
                        this.bbP.setShapeType(3);
                        this.bbR.c(rQ.getvipV_url(), 10, false);
                    }
                } else {
                    this.bbP.setShapeType(1);
                    this.bbP.setShowType(1);
                }
            }
            if (gVar.threadData.getAuthor() != null) {
                this.ahV.setText(com.baidu.tbadk.core.util.ax.dF(com.baidu.tbadk.core.util.ax.c(gVar.threadData.getAuthor().getName_show(), 14, "...")));
                gh(gVar.threadData.getAuthor().getFansNum());
            }
            this.bca.a(gVar.threadData);
            if (gVar.threadData.sd() == 1 || StringUtils.isNull(gVar.threadData.getTitle())) {
                this.aOH.setVisibility(8);
            } else {
                this.aOH.setVisibility(0);
                this.aOH.setText(gVar.threadData.getTitle());
                m(this.aOH, r.d.cp_cont_b);
            }
            if (gVar.threadData.sf() == null || StringUtils.isNull(gVar.threadData.sf().video_url)) {
                this.bbU.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (gVar.threadData.rW() != null && !StringUtils.isNull(gVar.threadData.rW())) {
                    stringBuffer.append(gVar.threadData.rW());
                }
                ArrayList<MediaData> rY = gVar.threadData.rY();
                if (rY != null) {
                    i = rY.size();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i4 = 0; i4 < i; i4++) {
                        if (rY.get(i4).getVideoUrl() != null && rY.get(i4).getVideoUrl().endsWith("swf")) {
                            stringBuffer2.append(rY.get(i4).getVideoUrl());
                        }
                    }
                    stringBuffer.append(stringBuffer2.toString());
                    if (stringBuffer.length() > 0) {
                        SpannableString cy = gVar.threadData.cy(stringBuffer.toString());
                        this.bbY.setOnTouchListener(new com.baidu.tieba.view.x(cy));
                        this.bbY.setText(cy);
                        this.bbY.setVisibility(0);
                        m(this.bbY, r.d.cp_cont_c);
                    } else {
                        this.bbY.setVisibility(8);
                    }
                } else {
                    this.bbY.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> sc = gVar.threadData.sc();
                if (sc != null && sc.size() > 0) {
                    this.bbX.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = sc.get(0);
                    this.bbX.setVoiceModel(voiceModel);
                    this.bbX.setTag(voiceModel);
                    this.bbX.aEg();
                    if (voiceModel != null) {
                        this.bbX.mm(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.bbX.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.oJ().oP() && com.baidu.tbadk.core.util.x.s(rY) != 0 && (sc == null || sc.size() == 0)) {
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
                        this.bbZ.a(gVar.threadData, gVar.threadData.getForum_name(), new StringBuilder(String.valueOf(gVar.threadData.getFid())).toString(), gVar.threadData.getTid());
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
            } else {
                this.bbY.setVisibility(8);
                this.bbX.setVisibility(8);
                this.bbZ.setVisibility(8);
                if (com.baidu.tbadk.core.l.oJ().oP() && !StringUtils.isNull(gVar.threadData.sf().video_url)) {
                    this.bbU.setVisibility(0);
                    this.bbV.c(gVar.threadData.sf().thumbnail_url, 10, true);
                } else {
                    this.bbU.setVisibility(8);
                }
            }
            onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeu != null) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(view, this.bce);
            }
            if (view == this.bbP || view == this.ahV || view == this.bbS) {
                if (this.aeu.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.GO.getPageActivity()).createNormalConfig(com.baidu.adp.lib.h.b.c(this.aeu.getAuthor().getUserId(), 0L), false)));
                }
            } else if (view == getView() && !StringUtils.isNull(this.aeu.getId())) {
                if (this.bcc == null) {
                    OX();
                    return;
                }
                com.baidu.tieba.myCollection.baseHistory.b rM = this.bcc.rM(this.aeu.getId());
                if (rM == null) {
                    OX();
                    return;
                }
                this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createHistoryCfg(rM.getThreadId(), rM.Do(), rM.aKM(), rM.aKN(), null).disablePbKeyPostId()));
            }
        }
    }

    private void OX() {
        this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createFromThreadCfg(this.aeu, this.aeu.getForum_name(), an.Pf(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(TextView textView, int i) {
        an.a(textView, this.aeu.getId(), i, this.bcd);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bca != null) {
            this.bcf = bdUniqueId;
            this.bch.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bch);
            this.bca.h(bdUniqueId);
            this.aRC.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(int i) {
        this.bbS.setText(String.format(this.GO.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ax.v(i)));
    }
}
