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
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bc extends a<com.baidu.tieba.card.a.m> {
    private TbPageContext<?> Ea;
    private boolean ZM;
    private View aSa;
    private TextView aSd;
    private TextView aSj;
    private FrsCommonImageLayout aSk;
    public ThreadCommentAndPraiseInfoLayout aSl;
    public ClickableHeaderImageView aTK;
    public PlayVoiceBntNew aTL;
    private UserIconLayout aTM;
    private com.baidu.tieba.card.a.m aTN;
    private View.OnClickListener aTP;
    private FrsCommonImageLayout.b aTQ;
    private final View.OnClickListener aTR;
    private final String aTV;
    private final String aTW;
    private final View.OnClickListener aTX;
    private CustomMessageListener aTw;
    private final View.OnClickListener adL;
    private final View.OnClickListener aei;
    private int mSkinType;

    public bc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aTV = "1";
        this.aTW = "2";
        this.mSkinType = 3;
        this.ZM = true;
        this.aTP = new bd(this);
        this.aTw = new be(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aTQ = new bf(this);
        this.aTX = new bg(this);
        this.aTR = new bh(this);
        this.aei = new bi(this);
        this.adL = new bj(this);
        View view = getView();
        this.Ea = tbPageContext;
        this.aSa = view.findViewById(u.g.card_home_page_normal_thread_top_line);
        this.aTK = (ClickableHeaderImageView) view.findViewById(u.g.card_home_page_normal_thread_user_header);
        this.aTK.setDefaultResource(17170445);
        this.aTK.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aTK.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aTK.setRadius(com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds70));
        this.aTM = (UserIconLayout) view.findViewById(u.g.card_home_page_normal_thread_user_layout);
        this.aSd = (TextView) view.findViewById(u.g.card_home_page_normal_thread_title);
        this.aTL = (PlayVoiceBntNew) view.findViewById(u.g.card_home_page_normal_thread_abstract_voice);
        this.aTL.setAfterClickListener(this.aTR);
        this.aSj = (TextView) view.findViewById(u.g.card_home_page_normal_thread_abstract);
        this.aSk = (FrsCommonImageLayout) view.findViewById(u.g.card_home_page_normal_thread_img_layout);
        this.aSk.setDrawNum(false);
        this.aSk.setAfterChildClickListener(this.aTX);
        this.aSl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.card_home_page_normal_thread_info_layout);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), u.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aSa, u.d.cp_bg_line_b);
            this.aTM.se();
            this.aSl.se();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_normal_thread;
    }

    public void a(com.baidu.tieba.card.a.m mVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        if (mVar == null || mVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aTN = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aTP);
        }
        d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.aTN.aVu) {
            this.aTK.setVisibility(8);
            this.aTM.setVisibility(8);
        } else {
            this.aTM.setVisibility(0);
            this.aTK.setVisibility(0);
            this.aTK.setData(mVar.threadData);
            this.aTK.setAfterClickListener(this.aei);
        }
        this.aTM.setData(mVar.threadData);
        this.aTM.setUserAfterClickListener(this.aei);
        this.aSl.setData(mVar.threadData);
        this.aSl.setForumAfterClickListener(this.adL);
        this.aSl.setStType(at.Lb());
        this.aSl.setYuelaouLocate("feed#" + mVar.Lh());
        if (StringUtils.isNull(mVar.threadData.getTitle()) || mVar.threadData.qU() == 1) {
            this.aSd.setVisibility(8);
        } else {
            this.aSd.setVisibility(0);
            mVar.threadData.Qo = 0;
            if (this.aTN.aVu) {
                this.aSd.setText(mVar.threadData.getTitle());
            } else {
                mVar.threadData.parser_title();
                this.aSd.setText(mVar.threadData.getSpan_str());
            }
            if (!KU()) {
                at.a(this.aSd, mVar.Ix().getId(), u.d.cp_cont_b, u.d.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.av.j((View) this.aSd, u.d.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (mVar.threadData.qO() != null && !StringUtils.isNull(mVar.threadData.qO())) {
            stringBuffer.append(mVar.threadData.qO());
        }
        ArrayList<MediaData> medias = mVar.threadData.getMedias();
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
                if (!KU()) {
                    at.a(this.aSj, mVar.threadData.getId(), u.d.cp_cont_j, u.d.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.av.j((View) this.aSj, u.d.cp_cont_j);
                }
            } else {
                this.aSj.setVisibility(8);
            }
        } else {
            this.aSj.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> qT = mVar.threadData.qT();
        if (qT != null && qT.size() > 0) {
            this.aTL.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qT.get(0);
            this.aTL.setVoiceModel(voiceModel);
            this.aTL.setTag(voiceModel);
            this.aTL.bdr();
            if (voiceModel != null) {
                this.aTL.ln(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.aTL.setVisibility(8);
            z = false;
        }
        if (this.aTN.aVu && z) {
            this.aSk.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.nW().oc() && com.baidu.tbadk.core.util.y.s(medias) != 0) {
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
                this.aSk.a(mVar.threadData, mVar.threadData.getForum_name(), new StringBuilder(String.valueOf(mVar.threadData.getFid())).toString(), mVar.threadData.getTid());
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
        Lc();
    }

    private void Lc() {
        if (!this.aTN.arI) {
            this.aSk.setOnChildClickListener(this.aTQ);
            this.aTL.setClickable(false);
            this.aSl.setBarNameClickEnabled(false);
        } else {
            this.aSk.setOnChildClickListener(null);
            this.aTL.setClickable(true);
            this.aSl.setBarNameClickEnabled(true);
        }
        int childCount = this.aSk.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aSk.getChildAt(i);
            if (childAt != null) {
                if (!this.aTN.arI) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ZM = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSl != null && this.aTw != null) {
            this.aSl.h(bdUniqueId);
            this.aTw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld() {
        if (this.aTN != null && this.aTN.threadData != null) {
            if (!KU()) {
                at.hb(this.aTN.threadData.getId());
            }
            this.Ea.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Ea.getPageActivity()).createFromThreadCfg(this.aTN.threadData, null, at.Lb(), 18003, true, false, false).addLocateParam(this.aTN.Li())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KU() {
        return this.aTN.aVu && !this.aTN.arI;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
