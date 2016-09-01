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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends a<com.baidu.tieba.card.data.g> {
    private View GB;
    private TbPageContext<?> GM;
    private UserLikeButton.a aOm;
    private View aXY;
    public boolean aYb;
    private View aYc;
    public GodHeadImageView aYd;
    public ViewStub aYe;
    public TbImageView aYf;
    public TextView aYg;
    private TextView aYh;
    public UserLikeButton aYi;
    public FrameLayout aYj;
    private TbImageView aYk;
    private ImageView aYl;
    public PlayVoiceBnt aYm;
    private TextView aYn;
    private FrsCommonImageLayout aYo;
    public ThreadCommentAndPraiseInfoLayout aYp;
    private com.baidu.tieba.myCollection.baseHistory.a aYq;
    private com.baidu.tieba.tbadkCore.util.o aYr;
    private int aYs;
    private com.baidu.tieba.card.data.g aYt;
    private BdUniqueId aYu;
    private boolean aYv;
    private CustomMessageListener aYw;
    private com.baidu.tbadk.core.data.bg adL;
    private boolean adl;
    public TextView ahN;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aYb = true;
        this.mSkinType = 3;
        this.aOm = new f(this);
        this.aYs = t.d.cp_cont_d;
        this.adl = true;
        this.aYv = true;
        this.aYw = new g(this, CmdConfigCustom.CMD_ADD_HISTORY);
        View view = getView();
        this.GM = tbPageContext;
        this.aYc = view.findViewById(t.g.card_god_feed_top_line);
        this.GB = view.findViewById(t.g.card_god_feed_bottom_line);
        this.aXY = view.findViewById(t.g.card_god_feed_top_margin);
        this.aYd = (GodHeadImageView) view.findViewById(t.g.card_god_feed_user_header);
        this.aYe = (ViewStub) view.findViewById(t.g.viewstub_headimage_mask);
        this.ahN = (TextView) view.findViewById(t.g.card_god_feed_user_name);
        this.aYg = (TextView) view.findViewById(t.g.card_god_feed_fan_num);
        this.aYh = (TextView) view.findViewById(t.g.card_god_feed_title);
        this.aYj = (FrameLayout) view.findViewById(t.g.god_feed_video_frame);
        this.aYk = (TbImageView) view.findViewById(t.g.god_feed_video_background);
        this.aYl = (ImageView) view.findViewById(t.g.god_feed_video_play);
        this.aYm = (PlayVoiceBnt) view.findViewById(t.g.card_god_feed_abstract_voice);
        this.aYm.setAfterClickListener(this);
        this.aYn = (TextView) view.findViewById(t.g.card_god_feed_abstract);
        this.aYo = (FrsCommonImageLayout) view.findViewById(t.g.card_god_feed_img_layout);
        this.aYo.setDrawNum(false);
        this.aYo.setAfterChildClickListener(this);
        this.aYp = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_god_feed_thread_info_layout);
        this.aYp.setForumAfterClickListener(this);
        this.aYr = TbadkCoreApplication.m9getInst().getGodFeedReadHistory();
        this.aYi = (UserLikeButton) view.findViewById(t.g.card_god_feed_like_btn);
        this.aYi.setFanNumCallBack(this.aOm);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(this.aXY, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.ahN, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aYg, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.k(getView(), t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aYc, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(this.GB, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.aYl, t.f.icon_play_video);
            this.aYp.ti();
            this.aYd.vS();
            this.aYi.aK(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_god_feed;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.g gVar) {
        int i;
        int i2;
        int i3;
        if (gVar != null && gVar.threadData != null) {
            this.aYt = gVar;
            this.adL = gVar.threadData;
            getView().setOnClickListener(this);
            this.aYd.setOnClickListener(this);
            this.ahN.setOnClickListener(this);
            this.aYg.setOnClickListener(this);
            if (this.aYb && this.adL.getAuthor() != null && this.adL.getAuthor().getGodUserData() != null) {
                if (this.adL.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aYi.setVisibility(8);
                } else {
                    this.aYi.setVisibility(0);
                    this.aYi.setData(this.adL);
                }
            } else {
                this.aYi.setVisibility(8);
            }
            if (gVar.bbt) {
                this.aXY.setVisibility(0);
            } else {
                this.aXY.setVisibility(8);
            }
            if (gVar.threadData.getAuthor() != null) {
                this.aYd.setContentDescription(String.valueOf(gVar.threadData.getAuthor().getUserName()) + this.GM.getString(t.j.somebodys_portrait));
                this.aYd.c(gVar.threadData.getAuthor().getPortrait(), 28, false);
                UserTbVipInfoData rC = this.adL.rC();
                if (rC != null && rC.getvipV_url() != null) {
                    if (this.aYe != null) {
                        if (this.aYf == null) {
                            this.aYe.inflate();
                            this.aYf = (TbImageView) getView().findViewById(t.g.user_head_mask);
                        }
                        this.aYd.setShapeType(3);
                        this.aYf.c(rC.getvipV_url(), 10, false);
                    }
                } else {
                    this.aYd.setShapeType(1);
                    this.aYd.setShowType(1);
                }
            }
            if (gVar.threadData.getAuthor() != null) {
                this.ahN.setText(com.baidu.tbadk.core.util.ba.dB(com.baidu.tbadk.core.util.ba.c(gVar.threadData.getAuthor().getName_show(), 14, "...")));
                gc(gVar.threadData.getAuthor().getFansNum());
            }
            this.aYp.setData(gVar.threadData);
            if (gVar.threadData.rP() == 1 || StringUtils.isNull(gVar.threadData.getTitle())) {
                this.aYh.setVisibility(8);
            } else {
                this.aYh.setVisibility(0);
                this.aYh.setText(gVar.threadData.getTitle());
                m(this.aYh, t.d.cp_cont_b);
            }
            if (gVar.threadData.rR() == null || StringUtils.isNull(gVar.threadData.rR().video_url)) {
                this.aYj.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (gVar.threadData.rI() != null && !StringUtils.isNull(gVar.threadData.rI())) {
                    stringBuffer.append(gVar.threadData.rI());
                }
                ArrayList<MediaData> rK = gVar.threadData.rK();
                if (rK != null) {
                    i = rK.size();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i4 = 0; i4 < i; i4++) {
                        if (rK.get(i4).getVideoUrl() != null && rK.get(i4).getVideoUrl().endsWith("swf")) {
                            stringBuffer2.append(rK.get(i4).getVideoUrl());
                        }
                    }
                    stringBuffer.append(stringBuffer2.toString());
                    if (stringBuffer.length() > 0) {
                        SpannableString cu = gVar.threadData.cu(stringBuffer.toString());
                        this.aYn.setOnTouchListener(new com.baidu.tieba.view.y(cu));
                        this.aYn.setText(cu);
                        this.aYn.setVisibility(0);
                        m(this.aYn, t.d.cp_cont_j);
                    } else {
                        this.aYn.setVisibility(8);
                    }
                } else {
                    this.aYn.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> rO = gVar.threadData.rO();
                if (rO != null && rO.size() > 0) {
                    this.aYm.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rO.get(0);
                    this.aYm.setVoiceModel(voiceModel);
                    this.aYm.setTag(voiceModel);
                    this.aYm.bkk();
                    if (voiceModel != null) {
                        this.aYm.lW(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.aYm.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.oG().oM() && com.baidu.tbadk.core.util.y.s(rK) != 0 && (rO == null || rO.size() == 0)) {
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (i5 < i) {
                        if (rK.get(i5) == null || !(rK.get(i5).getType() == 3 || rK.get(i5).getType() == 5)) {
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
                            if (rK.get(i9).getType() == 3 || rK.get(i9).getType() == 5) {
                                mediaDataArr[i8] = rK.get(i9);
                                i2 = i8 + 1;
                            } else {
                                i2 = i8;
                            }
                            i9++;
                            i8 = i2;
                        }
                        this.aYo.setVisibility(0);
                        this.aYo.a(gVar.threadData, gVar.threadData.getForum_name(), new StringBuilder(String.valueOf(gVar.threadData.getFid())).toString(), gVar.threadData.getTid());
                        this.aYo.setShowBig(com.baidu.tbadk.core.util.bb.vk().vm());
                        this.aYo.a(this.GM, mediaDataArr, i6);
                        this.aYo.setFromCDN(this.adl);
                        this.aYo.setImageFrom("other");
                    } else {
                        this.aYo.setVisibility(8);
                    }
                } else {
                    this.aYo.setVisibility(8);
                }
            } else {
                this.aYn.setVisibility(8);
                this.aYm.setVisibility(8);
                this.aYo.setVisibility(8);
                if (com.baidu.tbadk.core.l.oG().oM() && !StringUtils.isNull(gVar.threadData.rR().video_url)) {
                    this.aYj.setVisibility(0);
                    this.aYk.c(gVar.threadData.rR().thumbnail_url, 10, true);
                } else {
                    this.aYj.setVisibility(8);
                }
            }
            onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adL != null) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(view, this.aYt);
            }
            if (view == this.aYd || view == this.ahN || view == this.aYg) {
                if (this.adL.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.GM.getPageActivity()).createNormalConfig(com.baidu.adp.lib.h.b.c(this.adL.getAuthor().getUserId(), 0L), false)));
                }
            } else if (view == getView() && !StringUtils.isNull(this.adL.getId())) {
                if (this.aYr == null) {
                    Nt();
                    return;
                }
                com.baidu.tieba.myCollection.baseHistory.b rc = this.aYr.rc(this.adL.getId());
                if (rc == null) {
                    Nt();
                    return;
                }
                this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createHistoryCfg(rc.getThreadId(), rc.Dg(), rc.aIr(), rc.aIs(), null).disablePbKeyPostId()));
            }
        }
    }

    private void Nt() {
        this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createFromThreadCfg(this.adL, this.adL.getForum_name(), ap.ND(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(TextView textView, int i) {
        ap.a(textView, this.adL.getId(), i, this.aYs);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aYp != null) {
            this.aYu = bdUniqueId;
            this.aYw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aYw);
            this.aYi.i(bdUniqueId);
            this.aYp.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(int i) {
        this.aYg.setText(String.format(this.GM.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.w(i)));
    }
}
