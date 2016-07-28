package com.baidu.tieba.card;

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
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.GodHeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserLikeButton;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends a<com.baidu.tieba.card.a.g> {
    private TbPageContext<?> EA;
    private View Eo;
    private UserLikeButton.a aJK;
    private View aSQ;
    public boolean aST;
    private View aSU;
    public GodHeadImageView aSV;
    public ViewStub aSW;
    public TbImageView aSX;
    public TextView aSY;
    private TextView aSZ;
    public UserLikeButton aTa;
    public FrameLayout aTb;
    private TbImageView aTc;
    private ImageView aTd;
    public PlayVoiceBnt aTe;
    private TextView aTf;
    private FrsCommonImageLayout aTg;
    public ThreadCommentAndPraiseInfoLayout aTh;
    private com.baidu.tieba.myCollection.baseHistory.a aTi;
    private com.baidu.tieba.tbadkCore.util.o aTj;
    private int aTk;
    private com.baidu.tieba.card.a.g aTl;
    private BdUniqueId aTm;
    private boolean aTn;
    private CustomMessageListener aTo;
    private boolean aav;
    private com.baidu.tbadk.core.data.be abb;
    public TextView aeS;
    private int mSkinType;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aST = true;
        this.mSkinType = 3;
        this.aJK = new l(this);
        this.aTk = u.d.cp_cont_d;
        this.aav = true;
        this.aTn = true;
        this.aTo = new m(this, CmdConfigCustom.CMD_ADD_HISTORY);
        View view = getView();
        this.EA = tbPageContext;
        this.aSU = view.findViewById(u.g.card_god_feed_top_line);
        this.Eo = view.findViewById(u.g.card_god_feed_bottom_line);
        this.aSQ = view.findViewById(u.g.card_god_feed_top_margin);
        this.aSV = (GodHeadImageView) view.findViewById(u.g.card_god_feed_user_header);
        this.aSW = (ViewStub) view.findViewById(u.g.viewstub_headimage_mask);
        this.aeS = (TextView) view.findViewById(u.g.card_god_feed_user_name);
        this.aSY = (TextView) view.findViewById(u.g.card_god_feed_fan_num);
        this.aSZ = (TextView) view.findViewById(u.g.card_god_feed_title);
        this.aTb = (FrameLayout) view.findViewById(u.g.god_feed_video_frame);
        this.aTc = (TbImageView) view.findViewById(u.g.god_feed_video_background);
        this.aTd = (ImageView) view.findViewById(u.g.god_feed_video_play);
        this.aTe = (PlayVoiceBnt) view.findViewById(u.g.card_god_feed_abstract_voice);
        this.aTe.setAfterClickListener(this);
        this.aTf = (TextView) view.findViewById(u.g.card_god_feed_abstract);
        this.aTg = (FrsCommonImageLayout) view.findViewById(u.g.card_god_feed_img_layout);
        this.aTg.setDrawNum(false);
        this.aTg.setAfterChildClickListener(this);
        this.aTh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.card_god_feed_thread_info_layout);
        this.aTh.setForumAfterClickListener(this);
        this.aTj = TbadkCoreApplication.m10getInst().getGodFeedReadHistory();
        this.aTa = (UserLikeButton) view.findViewById(u.g.card_god_feed_like_btn);
        this.aTa.setFanNumCallBack(this.aJK);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(this.aSQ, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.aeS, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aSY, u.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.k(getView(), u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aSU, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(this.Eo, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.aTd, u.f.icon_play_video);
            this.aTh.sd();
            this.aSV.uQ();
            this.aTa.aJ(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_god_feed;
    }

    public void a(com.baidu.tieba.card.a.g gVar) {
        int i;
        int i2;
        int i3;
        if (gVar != null && gVar.threadData != null) {
            this.aTl = gVar;
            this.abb = gVar.threadData;
            getView().setOnClickListener(this);
            this.aSV.setOnClickListener(this);
            this.aeS.setOnClickListener(this);
            this.aSY.setOnClickListener(this);
            if (this.aST && this.abb.getAuthor() != null && this.abb.getAuthor().getGodUserData() != null) {
                if (this.abb.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aTa.setVisibility(8);
                } else {
                    this.aTa.setVisibility(0);
                    this.aTa.setData(this.abb);
                }
            } else {
                this.aTa.setVisibility(8);
            }
            if (gVar.aVQ) {
                this.aSQ.setVisibility(0);
            } else {
                this.aSQ.setVisibility(8);
            }
            if (gVar.threadData.getAuthor() != null) {
                this.aSV.setContentDescription(String.valueOf(gVar.threadData.getAuthor().getUserName()) + this.EA.getString(u.j.somebodys_portrait));
                this.aSV.c(gVar.threadData.getAuthor().getPortrait(), 28, false);
                UserTbVipInfoData qx = this.abb.qx();
                if (qx != null && qx.getvipV_url() != null) {
                    if (this.aSW != null) {
                        if (this.aSX == null) {
                            this.aSW.inflate();
                            this.aSX = (TbImageView) getView().findViewById(u.g.user_head_mask);
                        }
                        this.aSV.setShapeType(3);
                        this.aSX.c(qx.getvipV_url(), 10, false);
                    }
                } else {
                    this.aSV.setShapeType(1);
                    this.aSV.setShowType(1);
                }
            }
            if (gVar.threadData.getAuthor() != null) {
                this.aeS.setText(com.baidu.tbadk.core.util.ba.dy(com.baidu.tbadk.core.util.ba.c(gVar.threadData.getAuthor().getName_show(), 14, "...")));
                fE(gVar.threadData.getAuthor().getFansNum());
            }
            this.aTh.setData(gVar.threadData);
            if (gVar.threadData.qK() == 1 || StringUtils.isNull(gVar.threadData.getTitle())) {
                this.aSZ.setVisibility(8);
            } else {
                this.aSZ.setVisibility(0);
                this.aSZ.setText(gVar.threadData.getTitle());
                m(this.aSZ, u.d.cp_cont_b);
            }
            if (gVar.threadData.qM() == null || StringUtils.isNull(gVar.threadData.qM().video_url)) {
                this.aTb.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (gVar.threadData.qD() != null && !StringUtils.isNull(gVar.threadData.qD())) {
                    stringBuffer.append(gVar.threadData.qD());
                }
                ArrayList<MediaData> qF = gVar.threadData.qF();
                if (qF != null) {
                    i = qF.size();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i4 = 0; i4 < i; i4++) {
                        if (qF.get(i4).getVideoUrl() != null && qF.get(i4).getVideoUrl().endsWith("swf")) {
                            stringBuffer2.append(qF.get(i4).getVideoUrl());
                        }
                    }
                    stringBuffer.append(stringBuffer2.toString());
                    if (stringBuffer.length() > 0) {
                        this.aTf.setText(stringBuffer.toString());
                        this.aTf.setVisibility(0);
                        m(this.aTf, u.d.cp_cont_j);
                    } else {
                        this.aTf.setVisibility(8);
                    }
                } else {
                    this.aTf.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> qJ = gVar.threadData.qJ();
                if (qJ != null && qJ.size() > 0) {
                    this.aTe.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = qJ.get(0);
                    this.aTe.setVoiceModel(voiceModel);
                    this.aTe.setTag(voiceModel);
                    this.aTe.bgJ();
                    if (voiceModel != null) {
                        this.aTe.lt(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.aTe.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.nL().nR() && com.baidu.tbadk.core.util.y.s(qF) != 0 && (qJ == null || qJ.size() == 0)) {
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (i5 < i) {
                        if (qF.get(i5) == null || !(qF.get(i5).getType() == 3 || qF.get(i5).getType() == 5)) {
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
                            if (qF.get(i9).getType() == 3 || qF.get(i9).getType() == 5) {
                                mediaDataArr[i8] = qF.get(i9);
                                i2 = i8 + 1;
                            } else {
                                i2 = i8;
                            }
                            i9++;
                            i8 = i2;
                        }
                        this.aTg.setVisibility(0);
                        this.aTg.a(gVar.threadData, gVar.threadData.getForum_name(), new StringBuilder(String.valueOf(gVar.threadData.getFid())).toString(), gVar.threadData.getTid());
                        this.aTg.setShowBig(com.baidu.tbadk.core.util.bb.ue().ug());
                        this.aTg.a(this.EA, mediaDataArr, i6);
                        this.aTg.setFromCDN(this.aav);
                        this.aTg.setImageFrom("other");
                    } else {
                        this.aTg.setVisibility(8);
                    }
                } else {
                    this.aTg.setVisibility(8);
                }
            } else {
                this.aTf.setVisibility(8);
                this.aTe.setVisibility(8);
                this.aTg.setVisibility(8);
                if (com.baidu.tbadk.core.l.nL().nR() && !StringUtils.isNull(gVar.threadData.qM().video_url)) {
                    this.aTb.setVisibility(0);
                    this.aTc.c(gVar.threadData.qM().thumbnail_url, 10, true);
                } else {
                    this.aTb.setVisibility(8);
                }
            }
            d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.abb != null) {
            if (KN() != null) {
                KN().a(view, this.aTl);
            }
            if (view == this.aSV || view == this.aeS || view == this.aSY) {
                if (this.abb.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.EA.getPageActivity(), this.abb.getAuthor().getUserId(), this.abb.getAuthor().getName_show(), this.abb.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            } else if (view == getView() && !StringUtils.isNull(this.abb.getId())) {
                if (this.aTj == null) {
                    KR();
                    return;
                }
                com.baidu.tieba.myCollection.baseHistory.b qs = this.aTj.qs(this.abb.getId());
                if (qs == null) {
                    KR();
                    return;
                }
                this.EA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.EA.getPageActivity()).createHistoryCfg(qs.getThreadId(), qs.BL(), qs.aDD(), qs.aDE(), null).disablePbKeyPostId()));
            }
        }
    }

    private void KR() {
        this.EA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.EA.getPageActivity()).createFromThreadCfg(this.abb, this.abb.getForum_name(), at.La(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(TextView textView, int i) {
        at.a(textView, this.abb.getId(), i, this.aTk);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aTh != null) {
            this.aTm = bdUniqueId;
            this.aTo.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTo);
            this.aTa.i(bdUniqueId);
            this.aTh.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(int i) {
        this.aSY.setText(String.format(this.EA.getResources().getString(u.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.w(i)));
    }
}
