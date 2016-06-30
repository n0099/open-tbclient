package com.baidu.tieba.card;

import android.view.View;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends a<com.baidu.tieba.card.a.g> {
    private View DO;
    private TbPageContext<?> Ea;
    private boolean ZM;
    private UserLikeButton.a aIT;
    private View aRW;
    public boolean aRZ;
    private View aSa;
    public GodHeadImageView aSb;
    public TextView aSc;
    private TextView aSd;
    public UserLikeButton aSe;
    public FrameLayout aSf;
    private TbImageView aSg;
    private ImageView aSh;
    public PlayVoiceBnt aSi;
    private TextView aSj;
    private FrsCommonImageLayout aSk;
    public ThreadCommentAndPraiseInfoLayout aSl;
    private com.baidu.tieba.myCollection.baseHistory.a aSm;
    private com.baidu.tieba.tbadkCore.util.o aSn;
    private int aSo;
    private com.baidu.tieba.card.a.g aSp;
    private BdUniqueId aSq;
    private boolean aSr;
    private CustomMessageListener aSs;
    private com.baidu.tbadk.core.data.az aas;
    public TextView aee;
    private int mSkinType;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aRZ = true;
        this.mSkinType = 3;
        this.aIT = new l(this);
        this.aSo = u.d.cp_cont_d;
        this.ZM = true;
        this.aSr = true;
        this.aSs = new m(this, CmdConfigCustom.CMD_ADD_HISTORY);
        View view = getView();
        this.Ea = tbPageContext;
        this.aSa = view.findViewById(u.g.card_god_feed_top_line);
        this.DO = view.findViewById(u.g.card_god_feed_bottom_line);
        this.aRW = view.findViewById(u.g.card_god_feed_top_margin);
        this.aSb = (GodHeadImageView) view.findViewById(u.g.card_god_feed_user_header);
        this.aSb.setShapeType(1);
        this.aSb.setShowType(1);
        this.aee = (TextView) view.findViewById(u.g.card_god_feed_user_name);
        this.aSc = (TextView) view.findViewById(u.g.card_god_feed_fan_num);
        this.aSd = (TextView) view.findViewById(u.g.card_god_feed_title);
        this.aSf = (FrameLayout) view.findViewById(u.g.god_feed_video_frame);
        this.aSg = (TbImageView) view.findViewById(u.g.god_feed_video_background);
        this.aSh = (ImageView) view.findViewById(u.g.god_feed_video_play);
        this.aSi = (PlayVoiceBnt) view.findViewById(u.g.card_god_feed_abstract_voice);
        this.aSi.setAfterClickListener(this);
        this.aSj = (TextView) view.findViewById(u.g.card_god_feed_abstract);
        this.aSk = (FrsCommonImageLayout) view.findViewById(u.g.card_god_feed_img_layout);
        this.aSk.setDrawNum(false);
        this.aSk.setAfterChildClickListener(this);
        this.aSl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.card_god_feed_thread_info_layout);
        this.aSl.setForumAfterClickListener(this);
        this.aSn = TbadkCoreApplication.m9getInst().getGodFeedReadHistory();
        this.aSe = (UserLikeButton) view.findViewById(u.g.card_god_feed_like_btn);
        this.aSe.setFanNumCallBack(this.aIT);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.l(this.aRW, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.aee, u.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.j((View) this.aSc, u.d.cp_cont_d);
            com.baidu.tbadk.core.util.av.k(getView(), u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aSa, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(this.DO, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.c(this.aSh, u.f.icon_play_video);
            this.aSl.se();
            this.aSb.uQ();
            this.aSe.aG(true);
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
            this.aSp = gVar;
            this.aas = gVar.threadData;
            getView().setOnClickListener(this);
            this.aSb.setOnClickListener(this);
            this.aee.setOnClickListener(this);
            this.aSc.setOnClickListener(this);
            if (this.aRZ && this.aas.getAuthor() != null && this.aas.getAuthor().getGodUserData() != null) {
                if (this.aas.getAuthor().getGodUserData().getFollowed() == 1) {
                    this.aSe.setVisibility(8);
                } else {
                    this.aSe.setVisibility(0);
                    this.aSe.setData(this.aas);
                }
            } else {
                this.aSe.setVisibility(8);
            }
            if (gVar.aUT) {
                this.aRW.setVisibility(0);
            } else {
                this.aRW.setVisibility(8);
            }
            if (gVar.threadData.getAuthor() != null) {
                this.aSb.setContentDescription(String.valueOf(gVar.threadData.getAuthor().getUserName()) + this.Ea.getString(u.j.somebodys_portrait));
                this.aSb.c(gVar.threadData.getAuthor().getPortrait(), 28, false);
            }
            if (gVar.threadData.getAuthor() != null) {
                this.aee.setText(com.baidu.tbadk.core.util.ba.dz(com.baidu.tbadk.core.util.ba.c(gVar.threadData.getAuthor().getName_show(), 14, "...")));
                fF(gVar.threadData.getAuthor().getFansNum());
            }
            this.aSl.setData(gVar.threadData);
            if (gVar.threadData.qU() == 1 || StringUtils.isNull(gVar.threadData.getTitle())) {
                this.aSd.setVisibility(8);
            } else {
                this.aSd.setVisibility(0);
                this.aSd.setText(gVar.threadData.getTitle());
                m(this.aSd, u.d.cp_cont_b);
            }
            if (gVar.threadData.qW() == null || StringUtils.isNull(gVar.threadData.qW().video_url)) {
                this.aSf.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (gVar.threadData.qO() != null && !StringUtils.isNull(gVar.threadData.qO())) {
                    stringBuffer.append(gVar.threadData.qO());
                }
                ArrayList<MediaData> medias = gVar.threadData.getMedias();
                if (medias != null) {
                    i = medias.size();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i4 = 0; i4 < i; i4++) {
                        if (medias.get(i4).getVideoUrl() != null && medias.get(i4).getVideoUrl().endsWith("swf")) {
                            stringBuffer2.append(medias.get(i4).getVideoUrl());
                        }
                    }
                    stringBuffer.append(stringBuffer2.toString());
                    if (stringBuffer.length() > 0) {
                        this.aSj.setText(stringBuffer.toString());
                        this.aSj.setVisibility(0);
                        m(this.aSj, u.d.cp_cont_j);
                    } else {
                        this.aSj.setVisibility(8);
                    }
                } else {
                    this.aSj.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> qT = gVar.threadData.qT();
                if (qT != null && qT.size() > 0) {
                    this.aSi.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = qT.get(0);
                    this.aSi.setVoiceModel(voiceModel);
                    this.aSi.setTag(voiceModel);
                    this.aSi.bdr();
                    if (voiceModel != null) {
                        this.aSi.ln(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.aSi.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.nW().oc() && com.baidu.tbadk.core.util.y.s(medias) != 0 && (qT == null || qT.size() == 0)) {
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (i5 < i) {
                        if (medias.get(i5) == null || !(medias.get(i5).getType() == 3 || medias.get(i5).getType() == 5)) {
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
                            if (medias.get(i9).getType() == 3 || medias.get(i9).getType() == 5) {
                                mediaDataArr[i8] = medias.get(i9);
                                i2 = i8 + 1;
                            } else {
                                i2 = i8;
                            }
                            i9++;
                            i8 = i2;
                        }
                        this.aSk.setVisibility(0);
                        this.aSk.a(gVar.threadData, gVar.threadData.getForum_name(), new StringBuilder(String.valueOf(gVar.threadData.getFid())).toString(), gVar.threadData.getTid());
                        this.aSk.setShowBig(com.baidu.tbadk.core.util.bb.uf().uh());
                        this.aSk.a(this.Ea, mediaDataArr, i6);
                        this.aSk.setFromCDN(this.ZM);
                        this.aSk.setImageFrom("other");
                    } else {
                        this.aSk.setVisibility(8);
                    }
                } else {
                    this.aSk.setVisibility(8);
                }
            } else {
                this.aSj.setVisibility(8);
                this.aSi.setVisibility(8);
                this.aSk.setVisibility(8);
                if (com.baidu.tbadk.core.l.nW().oc() && !StringUtils.isNull(gVar.threadData.qW().video_url)) {
                    this.aSf.setVisibility(0);
                    this.aSg.c(gVar.threadData.qW().thumbnail_url, 10, true);
                } else {
                    this.aSf.setVisibility(8);
                }
            }
            d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aas != null) {
            if (KO() != null) {
                KO().a(view, this.aSp);
            }
            if (view == this.aSb || view == this.aee || view == this.aSc) {
                if (this.aas.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.Ea.getPageActivity(), this.aas.getAuthor().getUserId(), this.aas.getAuthor().getName_show(), this.aas.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            } else if (view == getView() && !StringUtils.isNull(this.aas.getId())) {
                if (this.aSn == null) {
                    KS();
                    return;
                }
                com.baidu.tieba.myCollection.baseHistory.b pI = this.aSn.pI(this.aas.getId());
                if (pI == null) {
                    KS();
                    return;
                }
                this.Ea.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Ea.getPageActivity()).createHistoryCfg(pI.getThreadId(), pI.BL(), pI.aCC(), pI.aCD(), null).disablePbKeyPostId()));
            }
        }
    }

    private void KS() {
        this.Ea.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Ea.getPageActivity()).createFromThreadCfg(this.aas, this.aas.getForum_name(), at.Lb(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(TextView textView, int i) {
        at.a(textView, this.aas.getId(), i, this.aSo);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSl != null) {
            this.aSq = bdUniqueId;
            this.aSs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aSs);
            this.aSe.i(bdUniqueId);
            this.aSl.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(int i) {
        this.aSc.setText(String.format(this.Ea.getResources().getString(u.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ba.B(i)));
    }
}
