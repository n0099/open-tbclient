package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.GodHeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends a<com.baidu.tieba.card.a.f> {
    private View DM;
    private TbPageContext<?> DV;
    private boolean Zv;
    public boolean aOC;
    private View aOD;
    public GodHeadImageView aOE;
    public TextView aOF;
    private TextView aOG;
    public TextView aOH;
    public FrameLayout aOI;
    private TbImageView aOJ;
    private ImageView aOK;
    public PlayVoiceBnt aOL;
    private TextView aOM;
    private FrsCommonImageLayout aON;
    public ThreadCommentAndPraiseInfoLayout aOO;
    private com.baidu.tieba.myCollection.baseHistory.a aOP;
    private com.baidu.tieba.tbadkCore.util.o aOQ;
    private int aOR;
    private com.baidu.tieba.card.a.f aOS;
    private BdUniqueId aOT;
    private boolean aOU;
    private CustomMessageListener aOV;
    private View aOz;
    private com.baidu.tbadk.core.data.ax aab;
    public TextView adG;
    private String adR;
    private String adS;
    private com.baidu.tbadk.coreExtra.d.a adU;
    private CustomMessageListener adW;
    private int mSkinType;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aOC = true;
        this.mSkinType = 3;
        this.aOR = t.d.cp_cont_d;
        this.Zv = true;
        this.adR = TbadkCoreApplication.m11getInst().getString(t.j.relate_forum_is_followed);
        this.adS = TbadkCoreApplication.m11getInst().getString(t.j.forum_list_attention_tv);
        this.aOU = true;
        this.aOV = new l(this, CmdConfigCustom.CMD_ADD_HISTORY);
        this.adW = new m(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        View view = getView();
        this.DV = tbPageContext;
        this.aOD = view.findViewById(t.g.card_god_feed_top_line);
        this.DM = view.findViewById(t.g.card_god_feed_bottom_line);
        this.aOz = view.findViewById(t.g.card_god_feed_top_margin);
        this.aOE = (GodHeadImageView) view.findViewById(t.g.card_god_feed_user_header);
        this.aOE.setShapeType(1);
        this.aOE.setShowType(1);
        this.adG = (TextView) view.findViewById(t.g.card_god_feed_user_name);
        this.aOF = (TextView) view.findViewById(t.g.card_god_feed_fan_num);
        this.aOG = (TextView) view.findViewById(t.g.card_god_feed_title);
        this.aOI = (FrameLayout) view.findViewById(t.g.god_feed_video_frame);
        this.aOJ = (TbImageView) view.findViewById(t.g.god_feed_video_background);
        this.aOK = (ImageView) view.findViewById(t.g.god_feed_video_play);
        this.aOL = (PlayVoiceBnt) view.findViewById(t.g.card_god_feed_abstract_voice);
        this.aOL.setAfterClickListener(this);
        this.aOM = (TextView) view.findViewById(t.g.card_god_feed_abstract);
        this.aON = (FrsCommonImageLayout) view.findViewById(t.g.card_god_feed_img_layout);
        this.aON.setDrawNum(false);
        this.aON.setAfterChildClickListener(this);
        this.aOO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_god_feed_thread_info_layout);
        this.aOO.setForumAfterClickListener(this);
        this.aOQ = TbadkCoreApplication.m11getInst().getGodFeedReadHistory();
        this.aOH = (TextView) view.findViewById(t.g.card_god_feed_like_btn);
        this.adU = new com.baidu.tbadk.coreExtra.d.a(null);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.l(this.aOz, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.adG, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.j((View) this.aOF, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.k(getView(), t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aOD, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(this.DM, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(this.aOK, t.f.icon_play_video);
            this.aOO.sf();
            this.aOE.uQ();
            aI(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.card_god_feed;
    }

    public void a(com.baidu.tieba.card.a.f fVar) {
        int i;
        int i2;
        int i3;
        if (fVar != null && fVar.aRG != null) {
            this.aOS = fVar;
            this.aab = fVar.aRG;
            getView().setOnClickListener(this);
            this.aOE.setOnClickListener(this);
            this.adG.setOnClickListener(this);
            this.aOF.setOnClickListener(this);
            this.aOH.setOnClickListener(this);
            if (this.aOC) {
                this.aOH.setVisibility(0);
                aI(false);
            } else if (this.aab.getAuthor().getGodUserData().getIsFromNetWork()) {
                this.aOH.setVisibility(8);
            } else {
                aI(true);
            }
            if (fVar.aRx) {
                this.aOz.setVisibility(0);
            } else {
                this.aOz.setVisibility(8);
            }
            if (fVar.aRG.getAuthor() != null) {
                this.aOE.setContentDescription(String.valueOf(fVar.aRG.getAuthor().getUserName()) + this.DV.getString(t.j.somebodys_portrait));
                this.aOE.c(fVar.aRG.getAuthor().getPortrait(), 28, false);
            }
            if (fVar.aRG.getAuthor() != null) {
                this.adG.setText(com.baidu.tbadk.core.util.ay.dw(com.baidu.tbadk.core.util.ay.c(fVar.aRG.getAuthor().getName_show(), 14, "...")));
                fu(fVar.aRG.getAuthor().getFansNum());
            }
            this.aOO.setData(fVar.aRG);
            if (fVar.aRG.qY() == 1 || StringUtils.isNull(fVar.aRG.getTitle())) {
                this.aOG.setVisibility(8);
            } else {
                this.aOG.setVisibility(0);
                this.aOG.setText(fVar.aRG.getTitle());
                m(this.aOG, t.d.cp_cont_b);
            }
            if (fVar.aRG.ra() == null || StringUtils.isNull(fVar.aRG.ra().video_url)) {
                this.aOI.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (fVar.aRG.qS() != null && !StringUtils.isNull(fVar.aRG.qS())) {
                    stringBuffer.append(fVar.aRG.qS());
                }
                ArrayList<MediaData> medias = fVar.aRG.getMedias();
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
                        this.aOM.setText(stringBuffer.toString());
                        this.aOM.setVisibility(0);
                        m(this.aOM, t.d.cp_cont_j);
                    } else {
                        this.aOM.setVisibility(8);
                    }
                } else {
                    this.aOM.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> qX = fVar.aRG.qX();
                if (qX != null && qX.size() > 0) {
                    this.aOL.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = qX.get(0);
                    this.aOL.setVoiceModel(voiceModel);
                    this.aOL.setTag(voiceModel);
                    this.aOL.aUX();
                    if (voiceModel != null) {
                        this.aOL.jM(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.aOL.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.ob().oh() && com.baidu.tbadk.core.util.y.r(medias) != 0 && (qX == null || qX.size() == 0)) {
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
                        this.aON.setVisibility(0);
                        this.aON.a(fVar.aRG, fVar.aRG.qP(), new StringBuilder(String.valueOf(fVar.aRG.getFid())).toString(), fVar.aRG.getTid());
                        this.aON.setShowBig(com.baidu.tbadk.core.util.az.uf().uh());
                        this.aON.a(this.DV, mediaDataArr, i6);
                        this.aON.setFromCDN(this.Zv);
                        this.aON.setImageFrom("other");
                    } else {
                        this.aON.setVisibility(8);
                    }
                } else {
                    this.aON.setVisibility(8);
                }
            } else {
                this.aOM.setVisibility(8);
                this.aOL.setVisibility(8);
                this.aON.setVisibility(8);
                if (com.baidu.tbadk.core.l.ob().oh() && !StringUtils.isNull(fVar.aRG.ra().video_url)) {
                    this.aOI.setVisibility(0);
                    this.aOJ.c(fVar.aRG.ra().thumbnail_url, 10, true);
                } else {
                    this.aOI.setVisibility(8);
                }
            }
            d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MetaData author;
        if (this.aab != null) {
            if (JM() != null) {
                JM().a(view, this.aOS);
            }
            if (view == this.aOE || view == this.adG || view == this.aOF) {
                if (this.aab.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.DV.getPageActivity(), this.aab.getAuthor().getUserId(), this.aab.getAuthor().getName_show(), this.aab.qP(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            } else if (view == getView()) {
                if (!StringUtils.isNull(this.aab.getId())) {
                    if (this.aOQ == null) {
                        JR();
                        return;
                    }
                    com.baidu.tieba.myCollection.baseHistory.b oa = this.aOQ.oa(this.aab.getId());
                    if (oa == null) {
                        JR();
                    } else {
                        this.DV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.DV.getPageActivity()).createHistoryCfg(oa.getThreadId(), oa.BB(), oa.auu(), oa.auv(), null).disablePbKeyPostId()));
                    }
                }
            } else if (view == this.aOH && com.baidu.tbadk.core.util.bl.ac(this.DV.getPageActivity()) && (author = this.aab.getAuthor()) != null && author.getGodUserData() != null) {
                this.adU.a(author.getGodUserData().getFollowed() == 1 ? false : true, author.getPortrait(), author.getUserId());
            }
        }
    }

    private void JR() {
        this.DV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.DV.getPageActivity()).createFromThreadCfg(this.aab, this.aab.qP(), au.Kb(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(TextView textView, int i) {
        au.a(textView, this.aab.getId(), i, this.aOR);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aOO != null) {
            this.aOT = bdUniqueId;
            this.aOV.setTag(bdUniqueId);
            this.adW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aOV);
            MessageManager.getInstance().registerListener(this.adW);
            this.aOO.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(boolean z) {
        if (this.aOC && this.aab != null && this.aab.getAuthor() != null && this.aab.getAuthor().getGodUserData() != null) {
            if (this.aab.getAuthor().getGodUserData().getFollowed() == 1) {
                if (this.aOU) {
                    this.aOH.setClickable(false);
                }
                if (z || aJ(false)) {
                    this.aOH.setText(this.adR);
                    com.baidu.tbadk.core.util.at.j((View) this.aOH, t.d.cp_cont_d);
                    this.aOH.setBackgroundDrawable(null);
                    this.aOH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.aOH.setPadding(0, 0, 0, 0);
                    return;
                }
                return;
            }
            if (this.aOU) {
                this.aOH.setClickable(true);
            }
            if (z || aJ(true)) {
                this.aOH.setText(this.adS);
                com.baidu.tbadk.core.util.at.j((View) this.aOH, t.d.btn_forum_focus_color);
                com.baidu.tbadk.core.util.at.k(this.aOH, t.f.btn_focus_border_bg);
                this.aOH.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
                this.aOH.setPadding(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
            }
        }
    }

    private boolean aJ(boolean z) {
        if (this.aOH == null) {
            return false;
        }
        String a = com.baidu.adp.lib.util.j.a(this.aOH.getText(), "");
        if (StringUtils.isNull(a)) {
            return true;
        }
        return z ? !this.adS.equals(a) : !this.adR.equals(a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu(int i) {
        this.aOF.setText(String.format(this.DV.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ay.A(i)));
    }
}
