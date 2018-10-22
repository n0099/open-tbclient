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
    private boolean aAb;
    private final View.OnClickListener aEh;
    private final View.OnClickListener aGY;
    private bb bIV;
    private ThreadCommentAndPraiseInfoLayout bWf;
    private View buH;
    private View.OnClickListener cKG;
    public PlayVoiceBntNew cNk;
    private ConstrainImageGroup cNn;
    private final View.OnClickListener cNq;
    private View ejb;
    private ThreadForumUserInfoLayout ekn;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aAb = true;
        this.mStType = null;
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anP() != null) {
                    a.this.anP().a(view, a.this.bIV);
                }
                a.this.aoj();
            }
        };
        this.cNq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> anP = a.this.anP();
                if (anP != null) {
                    view.setTag("2");
                    anP.a(view, a.this.bIV);
                }
            }
        };
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anP() != null) {
                    a.this.anP().a(view, a.this.bIV);
                }
            }
        };
        this.aGY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.anP() != null) {
                    a.this.anP().a(view, a.this.bIV);
                }
            }
        };
        View view = getView();
        this.ekn = (ThreadForumUserInfoLayout) view.findViewById(e.g.forum_user_info_layout);
        this.ekn.setForumAfterClickListener(this.aEh);
        this.ekn.setLikeButtonAfterClickListener(this.aGY);
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cNk = (PlayVoiceBntNew) view.findViewById(e.g.voice_button);
        this.cNk.setAfterClickListener(this.cNq);
        this.cNn = (ConstrainImageGroup) view.findViewById(e.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds16);
        this.cNn.setChildClickListener(this.cKG);
        this.cNn.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        eVar.cF(false);
        this.cNn.setImageProcessor(eVar);
        this.ejb = view.findViewById(e.g.no_image_divider_line);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_info_layout);
        this.bWf.setOnClickListener(this.cKG);
        this.bWf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.anP() != null) {
                    a.this.anP().a(view2, a.this.bIV);
                }
                if (a.this.bIV != null) {
                    o.md(a.this.bIV.getId());
                    a.this.anU();
                }
            }
        });
        this.bWf.setShowCommonView();
        this.buH = view.findViewById(e.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cNn != null) {
            this.cNn.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cNn != null) {
            this.cNn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cNn != null) {
            this.cNn.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ekn != null) {
            this.ekn.setPageUniqueId(bdUniqueId);
        }
        if (this.cNn != null) {
            this.cNn.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            this.ekn.onChangeSkinType(i);
            this.cNn.onChangeSkinType();
            this.bWf.onChangeSkinType();
            al.j(this.buH, e.d.cp_bg_line_e);
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
        this.bIV = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cKG);
        }
        this.ekn.setData(this.bIV);
        L(this.bIV);
        ArrayList<VoiceData.VoiceModel> yK = this.bIV.yK();
        if (v.J(yK)) {
            this.cNk.setVisibility(8);
            ff(false);
        } else {
            this.cNk.setVisibility(0);
            ff(true);
            VoiceData.VoiceModel voiceModel = yK.get(0);
            this.cNk.setVoiceModel(voiceModel);
            this.cNk.setTag(voiceModel);
            this.cNk.aUR();
            if (voiceModel != null) {
                this.cNk.pJ(voiceModel.voice_status.intValue());
            }
            this.cNk.bDm();
        }
        ArrayList<MediaData> yG = this.bIV.yG();
        if (i.ws().ww() && v.I(yG) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < yG.size(); i++) {
                MediaData mediaData = (MediaData) v.d(yG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.I(linkedList) > 0) {
                this.cNn.setVisibility(0);
                this.ejb.setVisibility(8);
                this.cNn.setFromCDN(this.aAb);
                this.cNn.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> anP = a.this.anP();
                        if (anP != null) {
                            view.setTag("1");
                            anP.a(view, a.this.bIV);
                        }
                        a.this.aoj();
                    }
                });
                this.cNn.setImageMediaList(linkedList);
            } else {
                this.cNn.setVisibility(8);
                this.ejb.setVisibility(0);
            }
        } else {
            this.cNn.setVisibility(8);
            this.ejb.setVisibility(0);
        }
        this.bWf.ary = this.currentPageType;
        this.bWf.setData(this.bIV);
        aDd();
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
    public void anU() {
        if (o.me(this.bIV.getId())) {
            o.a(this.mTitle, this.bIV.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void aDd() {
        if (this.mTitle != null && this.cNk != null && this.cNn != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNk.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds24);
            this.cNk.setLayoutParams(layoutParams);
            if (this.cNk.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cNn.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds10);
                this.cNn.setLayoutParams(layoutParams2);
            }
        }
    }

    private void ff(boolean z) {
        if (this.cNn != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNn.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds10);
            }
            this.cNn.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoj() {
        if (this.bIV != null) {
            o.md(this.bIV.getId());
            o.a(this.mTitle, this.bIV.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bIV, null, this.mStType, 18005, true, false, false);
            if (this.bIV.Aa() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bIV.getFid()));
                createFromThreadCfg.setForumName(this.bIV.yB());
            } else {
                createFromThreadCfg.setForumId(this.bIV.Aa().getForumId());
                createFromThreadCfg.setForumName(this.bIV.Aa().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int aJj() {
        if (this.ekn == null || this.ekn.getHeaderImg() == null) {
            return -1;
        }
        return this.ekn.getHeaderImg().getId();
    }

    public int aJk() {
        if (this.ekn == null || this.ekn.getForumName() == null) {
            return -1;
        }
        return this.ekn.getForumName().getId();
    }

    public int aJl() {
        if (this.ekn == null || this.ekn.getForumName() == null) {
            return -1;
        }
        return this.ekn.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.bWf != null) {
            this.bWf.setShareReportFrom(i);
        }
    }

    public void nB(int i) {
        if (this.bWf != null) {
            this.bWf.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.bWf != null) {
            this.bWf.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
