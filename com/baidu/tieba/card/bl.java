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
public class bl extends a<com.baidu.tieba.card.a.t> {
    private TbPageContext<?> ND;
    private View aSe;
    private TextView aSh;
    private TextView aSn;
    private FrsCommonImageLayout aSo;
    public ThreadCommentAndPraiseInfoLayout aSp;
    private CustomMessageListener aTI;
    public ClickableHeaderImageView aTT;
    public PlayVoiceBntNew aTU;
    private UserIconLayout aTV;
    private com.baidu.tieba.card.a.t aTW;
    private View.OnClickListener aTY;
    private FrsCommonImageLayout.b aTZ;
    private final View.OnClickListener aUa;
    private final String aUe;
    private final String aUf;
    private final View.OnClickListener aUg;
    private boolean adX;
    private final View.OnClickListener ahQ;
    private final View.OnClickListener ahw;
    private int mSkinType;

    public bl(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aUe = "1";
        this.aUf = "2";
        this.mSkinType = 3;
        this.adX = true;
        this.aTY = new bm(this);
        this.aTI = new bn(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aTZ = new bo(this);
        this.aUg = new bp(this);
        this.aUa = new bq(this);
        this.ahQ = new br(this);
        this.ahw = new bs(this);
        View view = getView();
        this.ND = tbPageContext;
        this.aSe = view.findViewById(t.g.card_home_page_normal_thread_top_line);
        this.aTT = (ClickableHeaderImageView) view.findViewById(t.g.card_home_page_normal_thread_user_header);
        this.aTT.setDefaultResource(17170445);
        this.aTT.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aTT.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aTT.setRadius(com.baidu.adp.lib.util.k.c(this.ND.getPageActivity(), t.e.ds70));
        this.aTV = (UserIconLayout) view.findViewById(t.g.card_home_page_normal_thread_user_layout);
        this.aSh = (TextView) view.findViewById(t.g.card_home_page_normal_thread_title);
        this.aTU = (PlayVoiceBntNew) view.findViewById(t.g.card_home_page_normal_thread_abstract_voice);
        this.aTU.setAfterClickListener(this.aUa);
        this.aSn = (TextView) view.findViewById(t.g.card_home_page_normal_thread_abstract);
        this.aSo = (FrsCommonImageLayout) view.findViewById(t.g.card_home_page_normal_thread_img_layout);
        this.aSo.setDrawNum(false);
        this.aSo.setAfterChildClickListener(this.aUg);
        this.aSp = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_home_page_normal_thread_info_layout);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), t.f.home_thread_card_item_bg);
            com.baidu.tbadk.core.util.at.l(this.aSe, t.d.cp_bg_line_b);
            this.aTV.uA();
            this.aSp.uA();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_home_page_normal_thread;
    }

    public void a(com.baidu.tieba.card.a.t tVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        if (tVar == null || tVar.aVJ == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aTW = tVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aTY);
        }
        d(this.ND, TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aTW.aWe) {
            this.aTT.setVisibility(8);
            this.aTV.setVisibility(8);
        } else {
            this.aTV.setVisibility(0);
            this.aTT.setVisibility(0);
            this.aTT.setData(tVar.aVJ);
            this.aTT.setAfterClickListener(this.ahQ);
        }
        this.aTV.setData(tVar.aVJ);
        this.aTV.setUserAfterClickListener(this.ahQ);
        this.aSp.setData(tVar.aVJ);
        this.aSp.setForumAfterClickListener(this.ahw);
        this.aSp.setStType(bc.Ls());
        this.aSp.setYuelaouLocate("feed#" + tVar.Ly());
        if (StringUtils.isNull(tVar.aVJ.getTitle()) || tVar.aVJ.tA() == 1) {
            this.aSh.setVisibility(8);
        } else {
            this.aSh.setVisibility(0);
            tVar.aVJ.Va = 0;
            if (this.aTW.aWe) {
                this.aSh.setText(tVar.aVJ.getTitle());
            } else {
                tVar.aVJ.parser_title();
                this.aSh.setText(tVar.aVJ.getSpan_str());
            }
            if (!Lm()) {
                bc.a(this.aSh, tVar.LC().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.at.j((View) this.aSh, t.d.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (tVar.aVJ.tu() != null && !StringUtils.isNull(tVar.aVJ.tu())) {
            stringBuffer.append(tVar.aVJ.tu());
        }
        ArrayList<MediaData> medias = tVar.aVJ.getMedias();
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
                if (!Lm()) {
                    bc.a(this.aSn, tVar.aVJ.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.at.j((View) this.aSn, t.d.cp_cont_j);
                }
            } else {
                this.aSn.setVisibility(8);
            }
        } else {
            this.aSn.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> tz = tVar.aVJ.tz();
        if (tz != null && tz.size() > 0) {
            this.aTU.setVisibility(0);
            VoiceData.VoiceModel voiceModel = tz.get(0);
            this.aTU.setVoiceModel(voiceModel);
            this.aTU.setTag(voiceModel);
            this.aTU.aUC();
            if (voiceModel != null) {
                this.aTU.kh(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.aTU.setVisibility(8);
            z = false;
        }
        if (this.aTW.aWe && z) {
            this.aSo.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.qE().qK() && com.baidu.tbadk.core.util.y.p(medias) != 0) {
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
                this.aSo.a(tVar.aVJ, tVar.aVJ.tr(), new StringBuilder(String.valueOf(tVar.aVJ.getFid())).toString(), tVar.aVJ.getTid());
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
        Lt();
    }

    private void Lt() {
        if (!this.aTW.auT) {
            this.aSo.setOnChildClickListener(this.aTZ);
            this.aTU.setClickable(false);
            this.aSp.setBarNameClickEnabled(false);
        } else {
            this.aSo.setOnChildClickListener(null);
            this.aTU.setClickable(true);
            this.aSp.setBarNameClickEnabled(true);
        }
        int childCount = this.aSo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aSo.getChildAt(i);
            if (childAt != null) {
                if (!this.aTW.auT) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.adX = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSp != null && this.aTI != null) {
            this.aSp.h(bdUniqueId);
            this.aTI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lu() {
        if (this.aTW != null && this.aTW.aVJ != null) {
            if (!Lm()) {
                bc.ha(this.aTW.aVJ.getId());
            }
            this.ND.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ND.getPageActivity()).createFromThreadCfg(this.aTW.aVJ, this.aTW.aVJ.tr(), bc.Ls(), 18003, true, false, false).addLocateParam(this.aTW.Lz()).addFrom(getClass().getName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lm() {
        return this.aTW.aWe && !this.aTW.auT;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
