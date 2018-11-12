package com.baidu.tieba.homepage.daily.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<bb> {
    private boolean aAQ;
    private final View.OnClickListener aEX;
    private final View.OnClickListener aHO;
    private bb bJG;
    private ThreadCommentAndPraiseInfoLayout bWR;
    private View bvs;
    private View.OnClickListener cLM;
    public PlayVoiceBntNew cOq;
    private ConstrainImageGroup cOt;
    private final View.OnClickListener cOw;
    private View ekv;
    private ThreadForumUserInfoLayout elG;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aAQ = true;
        this.mStType = null;
        this.cLM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anq() != null) {
                    a.this.anq().a(view, a.this.bJG);
                }
                a.this.anK();
            }
        };
        this.cOw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> anq = a.this.anq();
                if (anq != null) {
                    view.setTag("2");
                    anq.a(view, a.this.bJG);
                }
            }
        };
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anq() != null) {
                    a.this.anq().a(view, a.this.bJG);
                }
            }
        };
        this.aHO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anq() != null) {
                    a.this.anq().a(view, a.this.bJG);
                }
            }
        };
        View view = getView();
        this.elG = (ThreadForumUserInfoLayout) view.findViewById(e.g.forum_user_info_layout);
        this.elG.setForumAfterClickListener(this.aEX);
        this.elG.setLikeButtonAfterClickListener(this.aHO);
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cOq = (PlayVoiceBntNew) view.findViewById(e.g.voice_button);
        this.cOq.setAfterClickListener(this.cOw);
        this.cOt = (ConstrainImageGroup) view.findViewById(e.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds16);
        this.cOt.setChildClickListener(this.cLM);
        this.cOt.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        eVar.cW(false);
        this.cOt.setImageProcessor(eVar);
        this.ekv = view.findViewById(e.g.no_image_divider_line);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_info_layout);
        this.bWR.setOnClickListener(this.cLM);
        this.bWR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.anq() != null) {
                    a.this.anq().a(view2, a.this.bJG);
                }
                if (a.this.bJG != null) {
                    o.me(a.this.bJG.getId());
                    a.this.anv();
                }
            }
        });
        this.bWR.setShowCommonView();
        this.bvs = view.findViewById(e.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cOt != null) {
            this.cOt.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cOt != null) {
            this.cOt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cOt != null) {
            this.cOt.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.elG != null) {
            this.elG.setPageUniqueId(bdUniqueId);
        }
        if (this.cOt != null) {
            this.cOt.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            this.elG.onChangeSkinType(i);
            this.cOt.onChangeSkinType();
            this.bWR.onChangeSkinType();
            al.j(this.bvs, e.d.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_daily_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bJG = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cLM);
        }
        this.elG.setData(this.bJG);
        L(this.bJG);
        ArrayList<VoiceData.VoiceModel> yR = this.bJG.yR();
        if (v.I(yR)) {
            this.cOq.setVisibility(8);
            fq(false);
        } else {
            this.cOq.setVisibility(0);
            fq(true);
            VoiceData.VoiceModel voiceModel = yR.get(0);
            this.cOq.setVoiceModel(voiceModel);
            this.cOq.setTag(voiceModel);
            this.cOq.aUo();
            if (voiceModel != null) {
                this.cOq.qc(voiceModel.voice_status.intValue());
            }
            this.cOq.bCH();
        }
        ArrayList<MediaData> yN = this.bJG.yN();
        if (i.wA().wE() && v.H(yN) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < yN.size(); i++) {
                MediaData mediaData = (MediaData) v.d(yN, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.H(linkedList) > 0) {
                this.cOt.setVisibility(0);
                this.ekv.setVisibility(8);
                this.cOt.setFromCDN(this.aAQ);
                this.cOt.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> anq = a.this.anq();
                        if (anq != null) {
                            view.setTag("1");
                            anq.a(view, a.this.bJG);
                        }
                        a.this.anK();
                    }
                });
                this.cOt.setImageMediaList(linkedList);
            } else {
                this.cOt.setVisibility(8);
                this.ekv.setVisibility(0);
            }
        } else {
            this.cOt.setVisibility(8);
            this.ekv.setVisibility(0);
        }
        this.bWR.asl = this.currentPageType;
        this.bWR.setData(this.bJG);
        aCx();
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean L(bb bbVar) {
        SpannableStringBuilder i = bbVar.i(false, true);
        if (i == null || StringUtils.isNull(i.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anv() {
        if (o.mf(this.bJG.getId())) {
            o.a(this.mTitle, this.bJG.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void aCx() {
        if (this.mTitle != null && this.cOq != null && this.cOt != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOq.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds24);
            this.cOq.setLayoutParams(layoutParams);
            if (this.cOq.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cOt.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds10);
                this.cOt.setLayoutParams(layoutParams2);
            }
        }
    }

    private void fq(boolean z) {
        if (this.cOt != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOt.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds10);
            }
            this.cOt.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anK() {
        if (this.bJG != null) {
            o.me(this.bJG.getId());
            o.a(this.mTitle, this.bJG.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bJG, null, this.mStType, 18005, true, false, false);
            if (this.bJG.Ah() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bJG.getFid()));
                createFromThreadCfg.setForumName(this.bJG.yI());
            } else {
                createFromThreadCfg.setForumId(this.bJG.Ah().getForumId());
                createFromThreadCfg.setForumName(this.bJG.Ah().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int aIH() {
        if (this.elG == null || this.elG.getHeaderImg() == null) {
            return -1;
        }
        return this.elG.getHeaderImg().getId();
    }

    public int aII() {
        if (this.elG == null || this.elG.getForumName() == null) {
            return -1;
        }
        return this.elG.getForumName().getId();
    }

    public int aIJ() {
        if (this.elG == null || this.elG.getForumName() == null) {
            return -1;
        }
        return this.elG.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.bWR != null) {
            this.bWR.setShareReportFrom(i);
        }
    }

    public void nT(int i) {
        if (this.bWR != null) {
            this.bWR.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.bWR != null) {
            this.bWR.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
