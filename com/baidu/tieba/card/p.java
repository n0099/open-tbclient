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
public class p extends a<com.baidu.tieba.card.a.i> {
    private TbPageContext<?> ND;
    private View Nu;
    private View aSa;
    public boolean aSd;
    private View aSe;
    public GodHeadImageView aSf;
    public TextView aSg;
    private TextView aSh;
    public TextView aSi;
    public FrameLayout aSj;
    private TbImageView aSk;
    private ImageView aSl;
    public PlayVoiceBnt aSm;
    private TextView aSn;
    private FrsCommonImageLayout aSo;
    public ThreadCommentAndPraiseInfoLayout aSp;
    private com.baidu.tieba.myCollection.baseHistory.a aSq;
    private com.baidu.tieba.tbadkCore.util.o aSr;
    private int aSs;
    private com.baidu.tieba.card.a.i aSt;
    private BdUniqueId aSu;
    private boolean aSv;
    private CustomMessageListener aSw;
    private boolean adX;
    private com.baidu.tbadk.core.data.as aeC;
    public TextView ahM;
    private String ahV;
    private String ahW;
    private com.baidu.tbadk.coreExtra.d.a ahY;
    private CustomMessageListener ahZ;
    private int mSkinType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aSd = true;
        this.mSkinType = 3;
        this.aSs = t.d.cp_cont_d;
        this.adX = true;
        this.ahV = TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed);
        this.ahW = TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv);
        this.aSv = true;
        this.aSw = new q(this, CmdConfigCustom.CMD_ADD_HISTORY);
        this.ahZ = new r(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        View view = getView();
        this.ND = tbPageContext;
        this.aSe = view.findViewById(t.g.card_god_feed_top_line);
        this.Nu = view.findViewById(t.g.card_god_feed_bottom_line);
        this.aSa = view.findViewById(t.g.card_god_feed_top_margin);
        this.aSf = (GodHeadImageView) view.findViewById(t.g.card_god_feed_user_header);
        this.aSf.setShapeType(1);
        this.aSf.setShowType(1);
        this.ahM = (TextView) view.findViewById(t.g.card_god_feed_user_name);
        this.aSg = (TextView) view.findViewById(t.g.card_god_feed_fan_num);
        this.aSh = (TextView) view.findViewById(t.g.card_god_feed_title);
        this.aSj = (FrameLayout) view.findViewById(t.g.god_feed_video_frame);
        this.aSk = (TbImageView) view.findViewById(t.g.god_feed_video_background);
        this.aSl = (ImageView) view.findViewById(t.g.god_feed_video_play);
        this.aSm = (PlayVoiceBnt) view.findViewById(t.g.card_god_feed_abstract_voice);
        this.aSm.setAfterClickListener(this);
        this.aSn = (TextView) view.findViewById(t.g.card_god_feed_abstract);
        this.aSo = (FrsCommonImageLayout) view.findViewById(t.g.card_god_feed_img_layout);
        this.aSo.setDrawNum(false);
        this.aSo.setAfterChildClickListener(this);
        this.aSp = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_god_feed_thread_info_layout);
        this.aSp.setForumAfterClickListener(this);
        this.aSr = TbadkCoreApplication.m411getInst().getGodFeedReadHistory();
        this.aSi = (TextView) view.findViewById(t.g.card_god_feed_like_btn);
        this.ahY = new com.baidu.tbadk.coreExtra.d.a(null);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.l(this.aSa, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.j((View) this.ahM, t.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.j((View) this.aSg, t.d.cp_cont_d);
            com.baidu.tbadk.core.util.at.k(getView(), t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aSe, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(this.Nu, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.c(this.aSl, t.f.icon_play_video);
            this.aSp.uA();
            this.aSf.xh();
            aD(true);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_god_feed;
    }

    public void a(com.baidu.tieba.card.a.i iVar) {
        int i;
        int i2;
        int i3;
        if (iVar != null && iVar.aVJ != null) {
            this.aSt = iVar;
            this.aeC = iVar.aVJ;
            getView().setOnClickListener(this);
            this.aSf.setOnClickListener(this);
            this.ahM.setOnClickListener(this);
            this.aSg.setOnClickListener(this);
            this.aSi.setOnClickListener(this);
            if (this.aSd) {
                this.aSi.setVisibility(0);
                aD(false);
            } else {
                this.aSi.setVisibility(8);
            }
            if (iVar.aVs) {
                this.aSa.setVisibility(0);
            } else {
                this.aSa.setVisibility(8);
            }
            if (iVar.aVJ.getAuthor() != null) {
                this.aSf.setContentDescription(String.valueOf(iVar.aVJ.getAuthor().getUserName()) + this.ND.getString(t.j.somebodys_portrait));
                this.aSf.c(iVar.aVJ.getAuthor().getPortrait(), 28, false);
            }
            if (iVar.aVJ.getAuthor() != null) {
                this.ahM.setText(com.baidu.tbadk.core.util.ay.dz(com.baidu.tbadk.core.util.ay.c(iVar.aVJ.getAuthor().getName_show(), 14, "...")));
                fL(iVar.aVJ.getAuthor().getFansNum());
            }
            this.aSp.setData(iVar.aVJ);
            if (iVar.aVJ.tA() == 1 || StringUtils.isNull(iVar.aVJ.getTitle())) {
                this.aSh.setVisibility(8);
            } else {
                this.aSh.setVisibility(0);
                this.aSh.setText(iVar.aVJ.getTitle());
                m(this.aSh, t.d.cp_cont_b);
            }
            if (iVar.aVJ.tC() == null || StringUtils.isNull(iVar.aVJ.tC().video_url)) {
                this.aSj.setVisibility(8);
                StringBuffer stringBuffer = new StringBuffer();
                if (iVar.aVJ.tu() != null && !StringUtils.isNull(iVar.aVJ.tu())) {
                    stringBuffer.append(iVar.aVJ.tu());
                }
                ArrayList<MediaData> medias = iVar.aVJ.getMedias();
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
                        this.aSn.setText(stringBuffer.toString());
                        this.aSn.setVisibility(0);
                        m(this.aSn, t.d.cp_cont_j);
                    } else {
                        this.aSn.setVisibility(8);
                    }
                } else {
                    this.aSn.setVisibility(8);
                    i = 0;
                }
                ArrayList<VoiceData.VoiceModel> tz = iVar.aVJ.tz();
                if (tz != null && tz.size() > 0) {
                    this.aSm.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = tz.get(0);
                    this.aSm.setVoiceModel(voiceModel);
                    this.aSm.setTag(voiceModel);
                    this.aSm.aUC();
                    if (voiceModel != null) {
                        this.aSm.kh(voiceModel.voice_status.intValue());
                    }
                } else {
                    this.aSm.setVisibility(8);
                }
                if (com.baidu.tbadk.core.l.qE().qK() && com.baidu.tbadk.core.util.y.p(medias) != 0 && (tz == null || tz.size() == 0)) {
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
                        this.aSo.setVisibility(0);
                        this.aSo.a(iVar.aVJ, iVar.aVJ.tr(), new StringBuilder(String.valueOf(iVar.aVJ.getFid())).toString(), iVar.aVJ.getTid());
                        this.aSo.setShowBig(com.baidu.tbadk.core.util.az.wz().wB());
                        this.aSo.a(this.ND, mediaDataArr, i6);
                        this.aSo.setFromCDN(this.adX);
                        this.aSo.setImageFrom("other");
                    } else {
                        this.aSo.setVisibility(8);
                    }
                } else {
                    this.aSo.setVisibility(8);
                }
            } else {
                this.aSn.setVisibility(8);
                this.aSm.setVisibility(8);
                this.aSo.setVisibility(8);
                if (com.baidu.tbadk.core.l.qE().qK() && !StringUtils.isNull(iVar.aVJ.tC().video_url)) {
                    this.aSj.setVisibility(0);
                    this.aSk.c(iVar.aVJ.tC().thumbnail_url, 10, true);
                } else {
                    this.aSj.setVisibility(8);
                }
            }
            d(this.ND, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MetaData author;
        if (this.aeC != null) {
            if (Ld() != null) {
                Ld().a(view, this.aSt);
            }
            if (view == this.aSf || view == this.ahM || view == this.aSg) {
                if (this.aeC.getAuthor() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ND.getPageActivity(), this.aeC.getAuthor().getUserId(), this.aeC.getAuthor().getName_show(), this.aeC.tr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            } else if (view == getView()) {
                if (!StringUtils.isNull(this.aeC.getId())) {
                    if (this.aSr == null) {
                        Li();
                        return;
                    }
                    com.baidu.tieba.myCollection.baseHistory.b od = this.aSr.od(this.aeC.getId());
                    if (od == null) {
                        Li();
                    } else {
                        this.ND.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ND.getPageActivity()).createHistoryCfg(od.getThreadId(), od.DH(), od.aup(), od.auq(), null).disablePbKeyPostId()));
                    }
                }
            } else if (view == this.aSi && com.baidu.tbadk.core.util.bl.ad(this.ND.getPageActivity()) && (author = this.aeC.getAuthor()) != null && author.getGodUserData() != null) {
                this.ahY.a(author.getGodUserData().getFollowed() == 1 ? false : true, author.getPortrait(), author.getUserId());
            }
        }
    }

    private void Li() {
        this.ND.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ND.getPageActivity()).createFromThreadCfg(this.aeC, this.aeC.tr(), bc.Ls(), 18003, true, false, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(TextView textView, int i) {
        bc.a(textView, this.aeC.getId(), i, this.aSs);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSp != null) {
            this.aSu = bdUniqueId;
            this.aSw.setTag(bdUniqueId);
            this.ahZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aSw);
            MessageManager.getInstance().registerListener(this.ahZ);
            this.aSp.h(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(boolean z) {
        if (this.aSd && this.aeC != null && this.aeC.getAuthor() != null && this.aeC.getAuthor().getGodUserData() != null) {
            if (this.aeC.getAuthor().getGodUserData().getFollowed() == 1) {
                if (this.aSv) {
                    this.aSi.setClickable(false);
                }
                if (z || aE(false)) {
                    this.aSi.setText(this.ahV);
                    com.baidu.tbadk.core.util.at.j((View) this.aSi, t.d.cp_cont_d);
                    this.aSi.setBackgroundDrawable(null);
                    this.aSi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.aSi.setPadding(0, 0, 0, 0);
                    return;
                }
                return;
            }
            if (this.aSv) {
                this.aSi.setClickable(true);
            }
            if (z || aE(true)) {
                this.aSi.setText(this.ahW);
                com.baidu.tbadk.core.util.at.j((View) this.aSi, t.d.btn_forum_focus_color);
                com.baidu.tbadk.core.util.at.k(this.aSi, t.f.btn_focus_border_bg);
                this.aSi.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
                this.aSi.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
            }
        }
    }

    private boolean aE(boolean z) {
        if (this.aSi == null) {
            return false;
        }
        String a = com.baidu.adp.lib.util.j.a(this.aSi.getText(), "");
        if (StringUtils.isNull(a)) {
            return true;
        }
        return z ? !this.ahW.equals(a) : !this.ahV.equals(a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL(int i) {
        this.aSg.setText(String.format(this.ND.getResources().getString(t.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ay.z(i)));
    }
}
