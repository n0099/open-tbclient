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
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a<com.baidu.tieba.card.data.g> {
    private View GB;
    private TbPageContext<?> GM;
    private TextView aMI;
    private UserLikeButton.a aPz;
    private View aYC;
    public boolean aYF;
    public GodHeadImageView aYG;
    public ViewStub aYH;
    public TbImageView aYI;
    public TextView aYJ;
    public UserLikeButton aYK;
    public FrameLayout aYL;
    private TbImageView aYM;
    private ImageView aYN;
    public PlayVoiceBnt aYO;
    private TextView aYP;
    private FrsCommonImageLayout aYQ;
    public ThreadCommentAndPraiseInfoLayout aYR;
    private com.baidu.tieba.myCollection.baseHistory.a aYS;
    private com.baidu.tieba.tbadkCore.util.o aYT;
    private int aYU;
    private com.baidu.tieba.card.data.g aYV;
    private BdUniqueId aYW;
    private boolean aYX;
    private CustomMessageListener aYY;
    private com.baidu.tbadk.core.data.bi adW;
    private boolean adw;
    public TextView ahv;
    private View aqu;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aYF = true;
        this.mSkinType = 3;
        this.aPz = new f(this);
        this.aYU = r.d.cp_cont_d;
        this.adw = true;
        this.aYX = true;
        this.aYY = new g(this, CmdConfigCustom.CMD_ADD_HISTORY);
        View view = getView();
        this.GM = tbPageContext;
        this.aqu = view.findViewById(r.g.card_god_feed_top_line);
        this.GB = view.findViewById(r.g.card_god_feed_bottom_line);
        this.aYC = view.findViewById(r.g.card_god_feed_top_margin);
        this.aYG = (GodHeadImageView) view.findViewById(r.g.card_god_feed_user_header);
        this.aYH = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.ahv = (TextView) view.findViewById(r.g.card_god_feed_user_name);
        this.aYJ = (TextView) view.findViewById(r.g.card_god_feed_fan_num);
        this.aMI = (TextView) view.findViewById(r.g.card_god_feed_title);
        this.aYL = (FrameLayout) view.findViewById(r.g.god_feed_video_frame);
        this.aYM = (TbImageView) view.findViewById(r.g.god_feed_video_background);
        this.aYN = (ImageView) view.findViewById(r.g.god_feed_video_play);
        this.aYO = (PlayVoiceBnt) view.findViewById(r.g.card_god_feed_abstract_voice);
        this.aYO.setAfterClickListener(this);
        this.aYP = (TextView) view.findViewById(r.g.card_god_feed_abstract);
        this.aYQ = (FrsCommonImageLayout) view.findViewById(r.g.card_god_feed_img_layout);
        this.aYQ.setDrawNum(false);
        this.aYQ.setAfterChildClickListener(this);
        this.aYR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_god_feed_thread_info_layout);
        this.aYR.setForumAfterClickListener(this);
        this.aYT = TbadkCoreApplication.m9getInst().getGodFeedReadHistory();
        this.aYK = (UserLikeButton) view.findViewById(r.g.card_god_feed_like_btn);
        this.aYK.setFanNumCallBack(this.aPz);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(this.aYC, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.ahv, r.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aYJ, r.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.k(getView(), r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aqu, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(this.GB, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.aYN, r.f.icon_play_video);
            this.aYR.tx();
            this.aYG.wg();
            this.aYK.aK(true);
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
            this.aYV = gVar;
            this.adW = gVar.threadData;
            getView().setOnClickListener(this);
            this.aYG.setOnClickListener(this);
            this.ahv.setOnClickListener(this);
            this.aYJ.setOnClickListener(this);
            if (this.aYF && this.adW.getAuthor() != null && this.adW.getAuthor().getGodUserData() != null) {
                if (this.adW.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aYK.setVisibility(8);
                } else {
                    this.aYK.setVisibility(0);
                    this.aYK.setData(this.adW);
                }
            } else {
                this.aYK.setVisibility(8);
            }
            if (gVar.bbL) {
                this.aYC.setVisibility(0);
            } else {
                this.aYC.setVisibility(8);
            }
            if (gVar.threadData.getAuthor() != null) {
                this.aYG.setContentDescription(String.valueOf(gVar.threadData.getAuthor().getUserName()) + this.GM.getString(r.j.somebodys_portrait));
                this.aYG.c(gVar.threadData.getAuthor().getPortrait(), 28, false);
                UserTbVipInfoData rO = this.adW.rO();
                if (rO != null && rO.getvipV_url() != null) {
                    if (this.aYH != null) {
                        if (this.aYI == null) {
                            this.aYH.inflate();
                            this.aYI = (TbImageView) getView().findViewById(r.g.user_head_mask);
                        }
                        this.aYG.setShapeType(3);
                        this.aYI.c(rO.getvipV_url(), 10, false);
                    }
                } else {
                    this.aYG.setShapeType(1);
                    this.aYG.setShowType(1);
                }
            }
            if (gVar.threadData.getAuthor() != null) {
                this.ahv.setText(com.baidu.tbadk.core.util.az.dD(com.baidu.tbadk.core.util.az.c(gVar.threadData.getAuthor().getName_show(), 14, "...")));
                gh(gVar.threadData.getAuthor().getFansNum());
            }
            this.aYR.setData(gVar.threadData);
            if (gVar.threadData.sb() == 1 || StringUtils.isNull(gVar.threadData.getTitle())) {
                this.aMI.setVisibility(8);
            } else {
                this.aMI.setVisibility(0);
                this.aMI.setText(gVar.threadData.getTitle());
                m(this.aMI, r.d.cp_cont_b);
            }
            if (gVar.threadData.sd() == null || StringUtils.isNull(gVar.threadData.sd().video_url)) {
                this.aYL.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (gVar.threadData.rU() != null && !StringUtils.isNull(gVar.threadData.rU())) {
                    stringBuffer.append(gVar.threadData.rU());
                }
                ArrayList<MediaData> rW = gVar.threadData.rW();
                if (rW != null) {
                    i = rW.size();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i4 = 0; i4 < i; i4++) {
                        if (rW.get(i4).getVideoUrl() != null && rW.get(i4).getVideoUrl().endsWith("swf")) {
                            stringBuffer2.append(rW.get(i4).getVideoUrl());
                        }
                    }
                    stringBuffer.append(stringBuffer2.toString());
                    if (stringBuffer.length() > 0) {
                        SpannableString cw = gVar.threadData.cw(stringBuffer.toString());
                        this.aYP.setOnTouchListener(new com.baidu.tieba.view.y(cw));
                        this.aYP.setText(cw);
                        this.aYP.setVisibility(0);
                        m(this.aYP, r.d.cp_cont_j);
                    } else {
                        this.aYP.setVisibility(8);
                    }
                } else {
                    this.aYP.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> sa = gVar.threadData.sa();
                if (sa != null && sa.size() > 0) {
                    this.aYO.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = sa.get(0);
                    this.aYO.setVoiceModel(voiceModel);
                    this.aYO.setTag(voiceModel);
                    this.aYO.aCk();
                    if (voiceModel != null) {
                        this.aYO.me(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.aYO.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.oH().oN() && com.baidu.tbadk.core.util.y.s(rW) != 0 && (sa == null || sa.size() == 0)) {
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (i5 < i) {
                        if (rW.get(i5) == null || !(rW.get(i5).getType() == 3 || rW.get(i5).getType() == 5)) {
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
                            if (rW.get(i9).getType() == 3 || rW.get(i9).getType() == 5) {
                                mediaDataArr[i8] = rW.get(i9);
                                i2 = i8 + 1;
                            } else {
                                i2 = i8;
                            }
                            i9++;
                            i8 = i2;
                        }
                        this.aYQ.setVisibility(0);
                        this.aYQ.a(gVar.threadData, gVar.threadData.getForum_name(), new StringBuilder(String.valueOf(gVar.threadData.getFid())).toString(), gVar.threadData.getTid());
                        this.aYQ.setShowBig(com.baidu.tbadk.core.util.ba.vy().vA());
                        this.aYQ.a(this.GM, mediaDataArr, i6);
                        this.aYQ.setFromCDN(this.adw);
                        this.aYQ.setImageFrom("other");
                    } else {
                        this.aYQ.setVisibility(8);
                    }
                } else {
                    this.aYQ.setVisibility(8);
                }
            } else {
                this.aYP.setVisibility(8);
                this.aYO.setVisibility(8);
                this.aYQ.setVisibility(8);
                if (com.baidu.tbadk.core.l.oH().oN() && !StringUtils.isNull(gVar.threadData.sd().video_url)) {
                    this.aYL.setVisibility(0);
                    this.aYM.c(gVar.threadData.sd().thumbnail_url, 10, true);
                } else {
                    this.aYL.setVisibility(8);
                }
            }
            onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adW != null) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(view, this.aYV);
            }
            if (view == this.aYG || view == this.ahv || view == this.aYJ) {
                if (this.adW.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.GM.getPageActivity()).createNormalConfig(com.baidu.adp.lib.h.b.c(this.adW.getAuthor().getUserId(), 0L), false)));
                }
            } else if (view == getView() && !StringUtils.isNull(this.adW.getId())) {
                if (this.aYT == null) {
                    NU();
                    return;
                }
                com.baidu.tieba.myCollection.baseHistory.b rr = this.aYT.rr(this.adW.getId());
                if (rr == null) {
                    NU();
                    return;
                }
                this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createHistoryCfg(rr.getThreadId(), rr.Dg(), rr.aIS(), rr.aIT(), null).disablePbKeyPostId()));
            }
        }
    }

    private void NU() {
        this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createFromThreadCfg(this.adW, this.adW.getForum_name(), an.Od(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(TextView textView, int i) {
        an.a(textView, this.adW.getId(), i, this.aYU);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aYR != null) {
            this.aYW = bdUniqueId;
            this.aYY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aYY);
            this.aYK.i(bdUniqueId);
            this.aYR.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(int i) {
        this.aYJ.setText(String.format(this.GM.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.az.w(i)));
    }
}
