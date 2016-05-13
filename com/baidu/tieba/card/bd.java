package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bd extends a<com.baidu.tieba.card.a.l> {
    private TbPageContext<?> DV;
    private boolean Zv;
    private View aOD;
    private TextView aOG;
    private TextView aOM;
    private FrsCommonImageLayout aON;
    public ThreadCommentAndPraiseInfoLayout aOO;
    private final View.OnClickListener aQA;
    private CustomMessageListener aQc;
    public ClickableHeaderImageView aQn;
    public PlayVoiceBntNew aQo;
    private UserIconLayout aQp;
    private com.baidu.tieba.card.a.l aQq;
    private View.OnClickListener aQs;
    private FrsCommonImageLayout.b aQt;
    private final View.OnClickListener aQu;
    private final String aQy;
    private final String aQz;
    private final View.OnClickListener adK;
    private final View.OnClickListener adn;
    private int mSkinType;

    public bd(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQy = "1";
        this.aQz = "2";
        this.mSkinType = 3;
        this.Zv = true;
        this.aQs = new be(this);
        this.aQc = new bf(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aQt = new bg(this);
        this.aQA = new bh(this);
        this.aQu = new bi(this);
        this.adK = new bj(this);
        this.adn = new bk(this);
        View view = getView();
        this.DV = tbPageContext;
        this.aOD = view.findViewById(t.g.card_home_page_normal_thread_top_line);
        this.aQn = (ClickableHeaderImageView) view.findViewById(t.g.card_home_page_normal_thread_user_header);
        this.aQn.setDefaultResource(17170445);
        this.aQn.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aQn.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aQn.setRadius(com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds70));
        this.aQp = (UserIconLayout) view.findViewById(t.g.card_home_page_normal_thread_user_layout);
        this.aOG = (TextView) view.findViewById(t.g.card_home_page_normal_thread_title);
        this.aQo = (PlayVoiceBntNew) view.findViewById(t.g.card_home_page_normal_thread_abstract_voice);
        this.aQo.setAfterClickListener(this.aQu);
        this.aOM = (TextView) view.findViewById(t.g.card_home_page_normal_thread_abstract);
        this.aON = (FrsCommonImageLayout) view.findViewById(t.g.card_home_page_normal_thread_img_layout);
        this.aON.setDrawNum(false);
        this.aON.setAfterChildClickListener(this.aQA);
        this.aOO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_home_page_normal_thread_info_layout);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), t.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aOD, t.d.cp_bg_line_b);
            this.aQp.sg();
            this.aOO.sg();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JP() {
        return t.h.card_home_page_normal_thread;
    }

    public void a(com.baidu.tieba.card.a.l lVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        if (lVar == null || lVar.aRG == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aQq = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aQs);
        }
        d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        if (this.aQq.aRY) {
            this.aQn.setVisibility(8);
            this.aQp.setVisibility(8);
        } else {
            this.aQp.setVisibility(0);
            this.aQn.setVisibility(0);
            this.aQn.setData(lVar.aRG);
            this.aQn.setAfterClickListener(this.adK);
        }
        this.aQp.setData(lVar.aRG);
        this.aQp.setUserAfterClickListener(this.adK);
        this.aOO.setData(lVar.aRG);
        this.aOO.setForumAfterClickListener(this.adn);
        this.aOO.setStType(au.Kd());
        this.aOO.setYuelaouLocate("feed#" + lVar.Kj());
        if (StringUtils.isNull(lVar.aRG.getTitle()) || lVar.aRG.qZ() == 1) {
            this.aOG.setVisibility(8);
        } else {
            this.aOG.setVisibility(0);
            lVar.aRG.Qa = 0;
            if (this.aQq.aRY) {
                this.aOG.setText(lVar.aRG.getTitle());
            } else {
                lVar.aRG.parser_title();
                this.aOG.setText(lVar.aRG.getSpan_str());
            }
            if (!JV()) {
                au.a(this.aOG, lVar.Kn().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.at.j((View) this.aOG, t.d.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (lVar.aRG.qT() != null && !StringUtils.isNull(lVar.aRG.qT())) {
            stringBuffer.append(lVar.aRG.qT());
        }
        ArrayList<MediaData> medias = lVar.aRG.getMedias();
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
                if (!JV()) {
                    au.a(this.aOM, lVar.aRG.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.at.j((View) this.aOM, t.d.cp_cont_j);
                }
            } else {
                this.aOM.setVisibility(8);
            }
        } else {
            this.aOM.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> qY = lVar.aRG.qY();
        if (qY != null && qY.size() > 0) {
            this.aQo.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qY.get(0);
            this.aQo.setVoiceModel(voiceModel);
            this.aQo.setTag(voiceModel);
            this.aQo.aVd();
            if (voiceModel != null) {
                this.aQo.jL(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.aQo.setVisibility(8);
            z = false;
        }
        if (this.aQq.aRY && z) {
            this.aON.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.ob().oh() && com.baidu.tbadk.core.util.y.r(medias) != 0) {
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
                this.aON.a(lVar.aRG, lVar.aRG.qQ(), new StringBuilder(String.valueOf(lVar.aRG.getFid())).toString(), lVar.aRG.getTid());
                this.aON.setShowBig(com.baidu.tbadk.core.util.az.ug().ui());
                this.aON.a(this.DV, mediaDataArr, i6);
                this.aON.setFromCDN(this.Zv);
                this.aON.setImageFrom("other");
            } else {
                this.aON.setVisibility(8);
            }
        } else {
            this.aON.setVisibility(8);
        }
        Ke();
    }

    private void Ke() {
        if (!this.aQq.aqS) {
            this.aON.setOnChildClickListener(this.aQt);
            this.aQo.setClickable(false);
            this.aOO.setBarNameClickEnabled(false);
        } else {
            this.aON.setOnChildClickListener(null);
            this.aQo.setClickable(true);
            this.aOO.setBarNameClickEnabled(true);
        }
        int childCount = this.aON.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aON.getChildAt(i);
            if (childAt != null) {
                if (!this.aQq.aqS) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.Zv = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aOO != null && this.aQc != null) {
            this.aOO.h(bdUniqueId);
            this.aQc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kf() {
        if (this.aQq != null && this.aQq.aRG != null) {
            if (!JV()) {
                au.hb(this.aQq.aRG.getId());
            }
            this.DV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.DV.getPageActivity()).createFromThreadCfg(this.aQq.aRG, this.aQq.aRG.qQ(), au.Kd(), 18003, true, false, false).addLocateParam(this.aQq.Kk()).addFrom(getClass().getName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JV() {
        return this.aQq.aRY && !this.aQq.aqS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
