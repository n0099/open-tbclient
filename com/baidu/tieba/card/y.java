package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y extends a<com.baidu.tieba.card.a.n> {
    private final String aOh;
    private final String aOi;
    private com.baidu.tieba.card.a.n aOj;
    private View aOk;
    private ClickableHeaderImageView aOl;
    private UserIconLayout aOm;
    private TextView aOn;
    private PlayVoiceBnt aOo;
    private TextView aOp;
    private FrsCommonImageLayout aOq;
    private ThreadCommentAndPraiseInfoLayout aOr;
    private View.OnClickListener aOs;
    private final View.OnClickListener aOt;
    private final View.OnClickListener aOu;
    private boolean aec;
    private final View.OnClickListener agD;
    private final View.OnClickListener agW;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public y(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aOh = "1";
        this.aOi = "2";
        this.mSkinType = 3;
        this.aec = true;
        this.aOs = new z(this);
        this.aOt = new aa(this);
        this.aOu = new ab(this);
        this.agW = new ac(this);
        this.agD = new ad(this);
        View view = getView();
        this.mPageContext = tbPageContext;
        this.aOk = view.findViewById(n.g.card_home_page_normal_thread_top_line);
        this.aOl = (ClickableHeaderImageView) view.findViewById(n.g.card_home_page_normal_thread_user_header);
        this.aOl.setDefaultResource(17170445);
        this.aOl.setDefaultBgResource(n.f.icon_default_avatar_round);
        this.aOl.setRadius(com.baidu.adp.lib.util.k.d(this.mPageContext.getPageActivity(), n.e.ds70));
        this.aOm = (UserIconLayout) view.findViewById(n.g.card_home_page_normal_thread_user_layout);
        this.aOn = (TextView) view.findViewById(n.g.card_home_page_normal_thread_title);
        this.aOo = (PlayVoiceBnt) view.findViewById(n.g.card_home_page_normal_thread_abstract_voice);
        this.aOo.setAfterClickListener(this.aOu);
        this.aOp = (TextView) view.findViewById(n.g.card_home_page_normal_thread_abstract);
        this.aOq = (FrsCommonImageLayout) view.findViewById(n.g.card_home_page_normal_thread_img_layout);
        this.aOq.setDrawNum(false);
        this.aOq.setAfterChildClickListener(this.aOt);
        this.aOr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(n.g.card_home_page_normal_thread_info_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, TextView textView, int i, int i2) {
        if (textView != null) {
            if (z) {
                as.h((View) textView, i2);
            } else {
                as.h((View) textView, i);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.i(getView(), n.f.addresslist_item_bg);
            as.j(this.aOk, n.d.cp_bg_line_c);
            this.aOm.vW();
            this.aOr.tr();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int Ig() {
        return n.h.card_home_page_normal_thread;
    }

    public void a(com.baidu.tieba.card.a.n nVar) {
        int i;
        int i2;
        int i3;
        if (nVar == null || nVar.aQo == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aOj = nVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aOs);
        }
        am.Iq().a(this.aOj.IA());
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.m411getInst().getSkinType());
        this.aOl.setData(nVar.aQo);
        this.aOl.setAfterClickListener(this.agW);
        this.aOm.setData(nVar.aQo);
        this.aOm.setUserAfterClickListener(this.agW);
        this.aOr.setData(nVar.aQo);
        this.aOr.setForumAfterClickListener(this.agD);
        this.aOr.setStType(x.In());
        this.aOr.setYuelaouLocate("feed#" + nVar.Is());
        if (nVar.aQo.sC() == 1) {
            this.aOn.setVisibility(8);
        } else {
            this.aOn.setVisibility(0);
            nVar.aQo.WG = 0;
            nVar.aQo.parser_title();
            this.aOn.setText(nVar.aQo.getSpan_str());
            a(x.gJ(nVar.aQo.getId()), this.aOn, n.d.cp_cont_b, n.d.cp_cont_d);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (nVar.aQo.sy() != null && !StringUtils.isNull(nVar.aQo.sy())) {
            stringBuffer.append(nVar.aQo.sy());
        }
        ArrayList<MediaData> medias = nVar.aQo.getMedias();
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
                this.aOp.setText(stringBuffer.toString());
                this.aOp.setVisibility(0);
                a(x.gJ(nVar.aQo.getId()), this.aOp, n.d.cp_cont_j, n.d.cp_cont_d);
            } else {
                this.aOp.setVisibility(8);
            }
        } else {
            this.aOp.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> sB = nVar.aQo.sB();
        if (sB != null && sB.size() > 0) {
            this.aOo.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sB.get(0);
            this.aOo.setVoiceModel(voiceModel);
            this.aOo.setTag(voiceModel);
            this.aOo.aGx();
            if (voiceModel != null) {
                this.aOo.je(voiceModel.voice_status.intValue());
            }
        } else {
            this.aOo.setVisibility(8);
        }
        if (com.baidu.tbadk.core.m.qQ().qW() && com.baidu.tbadk.core.util.y.l(medias) != 0) {
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
                this.aOq.setVisibility(0);
                this.aOq.a(nVar.aQo, nVar.aQo.sv(), new StringBuilder(String.valueOf(nVar.aQo.ss())).toString(), nVar.aQo.getTid());
                this.aOq.setShowBig(ay.va().vc());
                this.aOq.a(this.mPageContext, mediaDataArr, i6);
                this.aOq.setFromCDN(this.aec);
                this.aOq.setImageFrom("other");
                return;
            }
            this.aOq.setVisibility(8);
            return;
        }
        this.aOq.setVisibility(8);
    }

    public void setFromCDN(boolean z) {
        this.aec = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aOr != null) {
            this.aOr.h(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
