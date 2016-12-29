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
public class e extends a<com.baidu.tieba.card.data.f> {
    private View GD;
    private TbPageContext<?> GO;
    private TextView aNY;
    private com.baidu.tbadk.core.view.userLike.c aQT;
    private CommonUserLikeButton.a aQX;
    private com.baidu.tbadk.core.data.bg adN;
    private boolean adn;
    public TextView ahw;
    private View aqR;
    private View baR;
    public boolean baU;
    public GodHeadImageView baV;
    public ViewStub baW;
    public TbImageView baX;
    public TextView baY;
    public EntelechyUserLikeButton baZ;
    public FrameLayout bba;
    private TbImageView bbb;
    private ImageView bbc;
    public PlayVoiceBnt bbd;
    private TextView bbe;
    private FrsCommonImageLayout bbf;
    public ThreadCommentAndPraiseInfoLayout bbg;
    private com.baidu.tieba.myCollection.baseHistory.a bbh;
    private com.baidu.tieba.tbadkCore.util.n bbi;
    private int bbj;
    private com.baidu.tieba.card.data.f bbk;
    private BdUniqueId bbl;
    private boolean bbm;
    private CustomMessageListener bbn;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.baU = true;
        this.mSkinType = 3;
        this.aQX = new f(this);
        this.bbj = r.d.cp_cont_d;
        this.adn = true;
        this.bbm = true;
        this.bbn = new g(this, CmdConfigCustom.CMD_ADD_HISTORY);
        View view = getView();
        this.GO = tbPageContext;
        this.aqR = view.findViewById(r.g.card_god_feed_top_line);
        this.GD = view.findViewById(r.g.card_god_feed_bottom_line);
        this.baR = view.findViewById(r.g.card_god_feed_top_margin);
        this.baV = (GodHeadImageView) view.findViewById(r.g.card_god_feed_user_header);
        this.baW = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.ahw = (TextView) view.findViewById(r.g.card_god_feed_user_name);
        this.baY = (TextView) view.findViewById(r.g.card_god_feed_fan_num);
        this.aNY = (TextView) view.findViewById(r.g.card_god_feed_title);
        this.bba = (FrameLayout) view.findViewById(r.g.god_feed_video_frame);
        this.bbb = (TbImageView) view.findViewById(r.g.god_feed_video_background);
        this.bbc = (ImageView) view.findViewById(r.g.god_feed_video_play);
        this.bbd = (PlayVoiceBnt) view.findViewById(r.g.card_god_feed_abstract_voice);
        this.bbd.setAfterClickListener(this);
        this.bbe = (TextView) view.findViewById(r.g.card_god_feed_abstract);
        this.bbf = (FrsCommonImageLayout) view.findViewById(r.g.card_god_feed_img_layout);
        this.bbf.setDrawNum(false);
        this.bbf.setAfterChildClickListener(this);
        this.bbg = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.card_god_feed_thread_info_layout);
        this.bbg.setForumAfterClickListener(this);
        this.bbi = TbadkCoreApplication.m9getInst().getGodFeedReadHistory();
        this.baZ = (EntelechyUserLikeButton) view.findViewById(r.g.card_god_feed_like_btn);
        this.aQT = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.baZ);
        this.baZ.setFanNumCallBack(this.aQX);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.l(this.baR, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.j((View) this.ahw, r.d.cp_cont_b);
            com.baidu.tbadk.core.util.ar.j((View) this.baY, r.d.cp_cont_d);
            com.baidu.tbadk.core.util.ar.k(getView(), r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.ar.l(this.aqR, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.l(this.GD, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.c(this.bbc, r.f.icon_play_video);
            this.bbg.tm();
            this.baV.vU();
            this.baZ.onChangeSkinType(i);
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
    public void onBindDataToView(com.baidu.tieba.card.data.f fVar) {
        int i;
        int i2;
        int i3;
        if (fVar != null && fVar.threadData != null) {
            this.bbk = fVar;
            this.adN = fVar.threadData;
            getView().setOnClickListener(this);
            this.baV.setOnClickListener(this);
            this.ahw.setOnClickListener(this);
            this.baY.setOnClickListener(this);
            if (this.baU && this.adN.getAuthor() != null && this.adN.getAuthor().getGodUserData() != null) {
                if (this.adN.getAuthor().getGodUserData().getIsLike()) {
                    this.baZ.setVisibility(8);
                } else {
                    this.baZ.setVisibility(0);
                    this.aQT.a(this.adN.getAuthor());
                }
            } else {
                this.baZ.setVisibility(8);
            }
            if (fVar.needTopMargin) {
                this.baR.setVisibility(0);
            } else {
                this.baR.setVisibility(8);
            }
            if (fVar.threadData.getAuthor() != null) {
                this.baV.setContentDescription(String.valueOf(fVar.threadData.getAuthor().getUserName()) + this.GO.getString(r.j.somebodys_portrait));
                this.baV.c(fVar.threadData.getAuthor().getPortrait(), 28, false);
                UserTbVipInfoData rF = this.adN.rF();
                if (rF != null && rF.getvipV_url() != null) {
                    if (this.baW != null) {
                        if (this.baX == null) {
                            this.baW.inflate();
                            this.baX = (TbImageView) getView().findViewById(r.g.user_head_mask);
                        }
                        this.baV.setShapeType(3);
                        this.baX.c(rF.getvipV_url(), 10, false);
                    }
                } else {
                    this.baV.setShapeType(1);
                    this.baV.setShowType(1);
                }
            }
            if (fVar.threadData.getAuthor() != null) {
                this.ahw.setText(com.baidu.tbadk.core.util.av.dC(com.baidu.tbadk.core.util.av.c(fVar.threadData.getAuthor().getName_show(), 14, "...")));
                gg(fVar.threadData.getAuthor().getFansNum());
            }
            this.bbg.a(fVar.threadData);
            if (fVar.threadData.rU() == 1 || StringUtils.isNull(fVar.threadData.getTitle())) {
                this.aNY.setVisibility(8);
            } else {
                this.aNY.setVisibility(0);
                this.aNY.setText(fVar.threadData.getTitle());
                m(this.aNY, r.d.cp_cont_b);
            }
            if (fVar.threadData.rW() == null || StringUtils.isNull(fVar.threadData.rW().video_url)) {
                this.bba.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (fVar.threadData.rN() != null && !StringUtils.isNull(fVar.threadData.rN())) {
                    stringBuffer.append(fVar.threadData.rN());
                }
                ArrayList<MediaData> rP = fVar.threadData.rP();
                if (rP != null) {
                    i = rP.size();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i4 = 0; i4 < i; i4++) {
                        if (rP.get(i4).getVideoUrl() != null && rP.get(i4).getVideoUrl().endsWith("swf")) {
                            stringBuffer2.append(rP.get(i4).getVideoUrl());
                        }
                    }
                    stringBuffer.append(stringBuffer2.toString());
                    if (stringBuffer.length() > 0) {
                        SpannableString cz = fVar.threadData.cz(stringBuffer.toString());
                        this.bbe.setOnTouchListener(new com.baidu.tieba.view.x(cz));
                        this.bbe.setText(cz);
                        this.bbe.setVisibility(0);
                        m(this.bbe, r.d.cp_cont_c);
                    } else {
                        this.bbe.setVisibility(8);
                    }
                } else {
                    this.bbe.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> rT = fVar.threadData.rT();
                if (rT != null && rT.size() > 0) {
                    this.bbd.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rT.get(0);
                    this.bbd.setVoiceModel(voiceModel);
                    this.bbd.setTag(voiceModel);
                    this.bbd.axx();
                    if (voiceModel != null) {
                        this.bbd.lw(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.bbd.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.oJ().oP() && com.baidu.tbadk.core.util.x.s(rP) != 0 && (rT == null || rT.size() == 0)) {
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (i5 < i) {
                        if (rP.get(i5) == null || !(rP.get(i5).getType() == 3 || rP.get(i5).getType() == 5)) {
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
                            if (rP.get(i9).getType() == 3 || rP.get(i9).getType() == 5) {
                                mediaDataArr[i8] = rP.get(i9);
                                i2 = i8 + 1;
                            } else {
                                i2 = i8;
                            }
                            i9++;
                            i8 = i2;
                        }
                        this.bbf.setVisibility(0);
                        this.bbf.a(fVar.threadData, fVar.threadData.rK(), new StringBuilder(String.valueOf(fVar.threadData.getFid())).toString(), fVar.threadData.getTid());
                        this.bbf.setShowBig(com.baidu.tbadk.core.util.aw.vm().vo());
                        this.bbf.a(this.GO, mediaDataArr, i6);
                        this.bbf.setFromCDN(this.adn);
                        this.bbf.setImageFrom("other");
                    } else {
                        this.bbf.setVisibility(8);
                    }
                } else {
                    this.bbf.setVisibility(8);
                }
            } else {
                this.bbe.setVisibility(8);
                this.bbd.setVisibility(8);
                this.bbf.setVisibility(8);
                if (com.baidu.tbadk.core.l.oJ().oP() && !StringUtils.isNull(fVar.threadData.rW().video_url)) {
                    this.bba.setVisibility(0);
                    this.bbb.c(fVar.threadData.rW().thumbnail_url, 10, true);
                } else {
                    this.bba.setVisibility(8);
                }
            }
            onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adN != null) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(view, this.bbk);
            }
            if (view == this.baV || view == this.ahw || view == this.baY) {
                if (this.adN.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.GO.getPageActivity()).createNormalConfig(com.baidu.adp.lib.h.b.c(this.adN.getAuthor().getUserId(), 0L), false)));
                }
            } else if (view == getView() && !StringUtils.isNull(this.adN.getId())) {
                if (this.bbi == null) {
                    Os();
                    return;
                }
                com.baidu.tieba.myCollection.baseHistory.b qs = this.bbi.qs(this.adN.getId());
                if (qs == null) {
                    Os();
                    return;
                }
                this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createGodHistoryCfg(qs.getThreadId(), qs.CX(), qs.aEN(), qs.aEO(), null, this.adN.se(), this.adN.rB()).disablePbKeyPostId()));
            }
        }
    }

    private void Os() {
        this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createFromThreadCfg(this.adN, null, ap.OB(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(TextView textView, int i) {
        ap.a(textView, this.adN.getId(), i, this.bbj);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbg != null) {
            this.bbl = bdUniqueId;
            this.bbn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bbn);
            this.bbg.h(bdUniqueId);
            this.aQT.i(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(int i) {
        this.baY.setText(String.format(this.GO.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.av.v(i)));
    }
}
