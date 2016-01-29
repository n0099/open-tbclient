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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.view.GodHeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p extends a<com.baidu.tieba.card.a.i> {
    private View Nn;
    private TbPageContext<?> Nw;
    private com.baidu.tieba.myCollection.baseHistory.a aPA;
    private com.baidu.tieba.tbadkCore.util.o aPB;
    private int aPC;
    private com.baidu.tieba.card.a.i aPD;
    private com.baidu.tbadk.coreExtra.d.a aPE;
    private BdUniqueId aPF;
    private String aPG;
    private String aPH;
    private boolean aPI;
    private CustomMessageListener aPJ;
    private CustomMessageListener aPK;
    private View aPk;
    public boolean aPn;
    private View aPo;
    private GodHeadImageView aPp;
    private TextView aPq;
    private TextView aPr;
    private TextView aPs;
    private FrameLayout aPt;
    private TbImageView aPu;
    private ImageView aPv;
    private PlayVoiceBnt aPw;
    private TextView aPx;
    private FrsCommonImageLayout aPy;
    private ThreadCommentAndPraiseInfoLayout aPz;
    private boolean aeC;
    private com.baidu.tbadk.core.data.ah afg;
    private TextView ahH;
    private int mSkinType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aPn = true;
        this.mSkinType = 3;
        this.aPC = t.d.cp_cont_d;
        this.aeC = true;
        this.aPG = TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed);
        this.aPH = TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv);
        this.aPI = true;
        this.aPJ = new q(this, CmdConfigCustom.CMD_ADD_HISTORY);
        this.aPK = new r(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        View view = getView();
        this.Nw = tbPageContext;
        this.aPo = view.findViewById(t.g.card_god_feed_top_line);
        this.Nn = view.findViewById(t.g.card_god_feed_bottom_line);
        this.aPk = view.findViewById(t.g.card_god_feed_top_margin);
        this.aPp = (GodHeadImageView) view.findViewById(t.g.card_god_feed_user_header);
        this.aPp.setShapeType(1);
        this.aPp.setShowType(1);
        this.ahH = (TextView) view.findViewById(t.g.card_god_feed_user_name);
        this.aPq = (TextView) view.findViewById(t.g.card_god_feed_fan_num);
        this.aPr = (TextView) view.findViewById(t.g.card_god_feed_title);
        this.aPt = (FrameLayout) view.findViewById(t.g.god_feed_video_frame);
        this.aPu = (TbImageView) view.findViewById(t.g.god_feed_video_background);
        this.aPv = (ImageView) view.findViewById(t.g.god_feed_video_play);
        this.aPw = (PlayVoiceBnt) view.findViewById(t.g.card_god_feed_abstract_voice);
        this.aPx = (TextView) view.findViewById(t.g.card_god_feed_abstract);
        this.aPy = (FrsCommonImageLayout) view.findViewById(t.g.card_god_feed_img_layout);
        this.aPy.setDrawNum(false);
        this.aPz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_god_feed_thread_info_layout);
        this.aPB = TbadkCoreApplication.m411getInst().getGodFeedReadHistory();
        this.aPs = (TextView) view.findViewById(t.g.card_god_feed_like_btn);
        this.aPE = new com.baidu.tbadk.coreExtra.d.a(null);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.l(this.aPk, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.j((View) this.ahH, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.ar.j((View) this.aPq, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.ar.k(getView(), t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.ar.l(this.aPo, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.l(this.Nn, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.c(this.aPv, t.f.icon_play_video);
            this.aPz.uv();
            this.aPp.wP();
            bQ(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
        return t.h.card_god_feed;
    }

    public void a(com.baidu.tieba.card.a.i iVar) {
        int i;
        int i2;
        int i3;
        if (iVar != null && iVar.aSc != null) {
            this.aPD = iVar;
            this.afg = iVar.aSc;
            getView().setOnClickListener(this);
            this.aPp.setOnClickListener(this);
            this.ahH.setOnClickListener(this);
            this.aPq.setOnClickListener(this);
            this.aPs.setOnClickListener(this);
            if (this.aPn) {
                this.aPs.setVisibility(0);
                bQ(false);
            } else {
                this.aPs.setVisibility(8);
            }
            if (iVar.aRK) {
                this.aPk.setVisibility(0);
            } else {
                this.aPk.setVisibility(8);
            }
            if (iVar.aSc.getAuthor() != null) {
                this.aPp.d(iVar.aSc.getAuthor().getPortrait(), 28, false);
            }
            if (iVar.aSc.getAuthor() != null) {
                this.ahH.setText(com.baidu.tbadk.core.util.aw.dw(com.baidu.tbadk.core.util.aw.d(iVar.aSc.getAuthor().getName_show(), 14, "...")));
                fy(iVar.aSc.getAuthor().getFansNum());
            }
            this.aPz.setData(iVar.aSc);
            if (iVar.aSc.tx() == 1 || StringUtils.isNull(iVar.aSc.getTitle())) {
                this.aPr.setVisibility(8);
            } else {
                this.aPr.setVisibility(0);
                this.aPr.setText(iVar.aSc.getTitle());
                m(this.aPr, t.d.cp_cont_b);
            }
            if (iVar.aSc.tz() == null || StringUtils.isNull(iVar.aSc.tz().video_url)) {
                this.aPt.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (iVar.aSc.tr() != null && !StringUtils.isNull(iVar.aSc.tr())) {
                    stringBuffer.append(iVar.aSc.tr());
                }
                ArrayList<MediaData> medias = iVar.aSc.getMedias();
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
                        this.aPx.setText(stringBuffer.toString());
                        this.aPx.setVisibility(0);
                        m(this.aPx, t.d.cp_cont_j);
                    } else {
                        this.aPx.setVisibility(8);
                    }
                } else {
                    this.aPx.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> tw = iVar.aSc.tw();
                if (tw != null && tw.size() > 0) {
                    this.aPw.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = tw.get(0);
                    this.aPw.setVoiceModel(voiceModel);
                    this.aPw.setTag(voiceModel);
                    this.aPw.aNB();
                    if (voiceModel != null) {
                        this.aPw.jB(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.aPw.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.rn().rt() && com.baidu.tbadk.core.util.x.o(medias) != 0 && (tw == null || tw.size() == 0)) {
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
                        this.aPy.setVisibility(0);
                        this.aPy.a(iVar.aSc, iVar.aSc.tn(), new StringBuilder(String.valueOf(iVar.aSc.getFid())).toString(), iVar.aSc.getTid());
                        this.aPy.setShowBig(com.baidu.tbadk.core.util.ax.wg().wi());
                        this.aPy.a(this.Nw, mediaDataArr, i6);
                        this.aPy.setFromCDN(this.aeC);
                        this.aPy.setImageFrom("other");
                    } else {
                        this.aPy.setVisibility(8);
                    }
                } else {
                    this.aPy.setVisibility(8);
                }
            } else {
                this.aPx.setVisibility(8);
                this.aPw.setVisibility(8);
                this.aPy.setVisibility(8);
                if (com.baidu.tbadk.core.l.rn().rt() && !StringUtils.isNull(iVar.aSc.tz().video_url)) {
                    this.aPt.setVisibility(0);
                    this.aPu.d(iVar.aSc.tz().thumbnail_url, 10, true);
                } else {
                    this.aPt.setVisibility(8);
                }
            }
            d(this.Nw, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MetaData author;
        if (this.afg != null) {
            if (view == this.aPp || view == this.ahH || view == this.aPq) {
                if (this.afg.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.Nw.getPageActivity(), this.afg.getAuthor().getUserId(), this.afg.getAuthor().getName_show(), this.afg.tn(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            } else if (view == getView()) {
                if (!StringUtils.isNull(this.afg.getId())) {
                    if (JL() != null) {
                        JL().a(view, this.aPD);
                    }
                    if (this.aPB == null) {
                        JQ();
                        return;
                    }
                    com.baidu.tieba.myCollection.baseHistory.b mR = this.aPB.mR(this.afg.getId());
                    if (mR == null) {
                        JQ();
                    } else {
                        this.Nw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Nw.getPageActivity()).createHistoryCfg(mR.getThreadId(), mR.CZ(), mR.anw(), mR.anx(), null).disablePbKeyPostId()));
                    }
                }
            } else if (view == this.aPs && bi.ah(this.Nw.getPageActivity()) && (author = this.afg.getAuthor()) != null && author.getGodUserData() != null) {
                boolean z = author.getGodUserData().getFollowed() == 1;
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10803").aa("tid", this.afg.getTid()).r("obj_locate", 1));
                this.aPE.a(z ? false : true, author.getPortrait(), author.getUserId());
            }
        }
    }

    private void JQ() {
        this.Nw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Nw.getPageActivity()).createFromThreadCfg(this.afg, this.afg.tn(), ae.JV(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(TextView textView, int i) {
        ae.a(textView, this.afg.getId(), i, this.aPC);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aPz != null) {
            this.aPF = bdUniqueId;
            this.aPJ.setTag(bdUniqueId);
            this.aPK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aPJ);
            MessageManager.getInstance().registerListener(this.aPK);
            this.aPz.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(boolean z) {
        if (this.aPn && this.afg != null && this.afg.getAuthor() != null && this.afg.getAuthor().getGodUserData() != null) {
            if (this.afg.getAuthor().getGodUserData().getFollowed() == 1) {
                if (this.aPI) {
                    this.aPs.setClickable(false);
                }
                if (z || bR(false)) {
                    this.aPs.setText(this.aPG);
                    com.baidu.tbadk.core.util.ar.j((View) this.aPs, t.d.cp_cont_d);
                    this.aPs.setBackgroundDrawable(null);
                    this.aPs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.aPs.setPadding(0, 0, 0, 0);
                    return;
                }
                return;
            }
            if (this.aPI) {
                this.aPs.setClickable(true);
            }
            if (z || bR(true)) {
                this.aPs.setText(this.aPH);
                com.baidu.tbadk.core.util.ar.j((View) this.aPs, t.d.btn_forum_focus_color);
                com.baidu.tbadk.core.util.ar.k(this.aPs, t.f.btn_focus_border_bg);
                this.aPs.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
                this.aPs.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
            }
        }
    }

    private boolean bR(boolean z) {
        if (this.aPs == null) {
            return false;
        }
        String str = (String) this.aPs.getText();
        if (StringUtils.isNull(str)) {
            return true;
        }
        return z ? !this.aPH.equals(str) : !this.aPG.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy(int i) {
        this.aPq.setText(String.format(this.Nw.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.aw.x(i)));
    }
}
