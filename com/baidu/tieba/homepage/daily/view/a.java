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
    private boolean aEq;
    private final View.OnClickListener aIx;
    private final View.OnClickListener aLo;
    private bb bNv;
    private View byP;
    private View.OnClickListener cSt;
    public PlayVoiceBntNew cUX;
    private ConstrainImageGroup cVa;
    private final View.OnClickListener cVd;
    private ThreadCommentAndPraiseInfoLayout caJ;
    private View erp;
    private ThreadForumUserInfoLayout esB;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aEq = true;
        this.mStType = null;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apc() != null) {
                    a.this.apc().a(view, a.this.bNv);
                }
                a.this.apx();
            }
        };
        this.cVd = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> apc = a.this.apc();
                if (apc != null) {
                    view.setTag("2");
                    apc.a(view, a.this.bNv);
                }
            }
        };
        this.aIx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apc() != null) {
                    a.this.apc().a(view, a.this.bNv);
                }
            }
        };
        this.aLo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apc() != null) {
                    a.this.apc().a(view, a.this.bNv);
                }
            }
        };
        View view = getView();
        this.esB = (ThreadForumUserInfoLayout) view.findViewById(e.g.forum_user_info_layout);
        this.esB.setForumAfterClickListener(this.aIx);
        this.esB.setLikeButtonAfterClickListener(this.aLo);
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cUX = (PlayVoiceBntNew) view.findViewById(e.g.voice_button);
        this.cUX.setAfterClickListener(this.cVd);
        this.cVa = (ConstrainImageGroup) view.findViewById(e.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.cVa.setChildClickListener(this.cSt);
        this.cVa.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        eVar.cX(false);
        this.cVa.setImageProcessor(eVar);
        this.erp = view.findViewById(e.g.no_image_divider_line);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_info_layout);
        this.caJ.setOnClickListener(this.cSt);
        this.caJ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.apc() != null) {
                    a.this.apc().a(view2, a.this.bNv);
                }
                if (a.this.bNv != null) {
                    o.mD(a.this.bNv.getId());
                    a.this.aph();
                }
            }
        });
        this.caJ.setShowCommonView();
        this.byP = view.findViewById(e.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cVa != null) {
            this.cVa.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cVa != null) {
            this.cVa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cVa != null) {
            this.cVa.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.esB != null) {
            this.esB.setPageUniqueId(bdUniqueId);
        }
        if (this.cVa != null) {
            this.cVa.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            this.esB.onChangeSkinType(i);
            this.cVa.onChangeSkinType();
            this.caJ.onChangeSkinType();
            al.j(this.byP, e.d.cp_bg_line_e);
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
        this.bNv = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        this.esB.setData(this.bNv);
        L(this.bNv);
        ArrayList<VoiceData.VoiceModel> zV = this.bNv.zV();
        if (v.I(zV)) {
            this.cUX.setVisibility(8);
            fr(false);
        } else {
            this.cUX.setVisibility(0);
            fr(true);
            VoiceData.VoiceModel voiceModel = zV.get(0);
            this.cUX.setVoiceModel(voiceModel);
            this.cUX.setTag(voiceModel);
            this.cUX.aWf();
            if (voiceModel != null) {
                this.cUX.qw(voiceModel.voice_status.intValue());
            }
            this.cUX.bEB();
        }
        ArrayList<MediaData> zR = this.bNv.zR();
        if (i.xE().xI() && v.H(zR) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < zR.size(); i++) {
                MediaData mediaData = (MediaData) v.d(zR, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.H(linkedList) > 0) {
                this.cVa.setVisibility(0);
                this.erp.setVisibility(8);
                this.cVa.setFromCDN(this.aEq);
                this.cVa.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> apc = a.this.apc();
                        if (apc != null) {
                            view.setTag("1");
                            apc.a(view, a.this.bNv);
                        }
                        a.this.apx();
                    }
                });
                this.cVa.setImageMediaList(linkedList);
            } else {
                this.cVa.setVisibility(8);
                this.erp.setVisibility(0);
            }
        } else {
            this.cVa.setVisibility(8);
            this.erp.setVisibility(0);
        }
        this.caJ.avL = this.currentPageType;
        this.caJ.setData(this.bNv);
        aEj();
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
    public void aph() {
        if (o.mE(this.bNv.getId())) {
            o.a(this.mTitle, this.bNv.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void aEj() {
        if (this.mTitle != null && this.cUX != null && this.cVa != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUX.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
            this.cUX.setLayoutParams(layoutParams);
            if (this.cUX.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cVa.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                this.cVa.setLayoutParams(layoutParams2);
            }
        }
    }

    private void fr(boolean z) {
        if (this.cVa != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVa.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10);
            }
            this.cVa.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        if (this.bNv != null) {
            o.mD(this.bNv.getId());
            o.a(this.mTitle, this.bNv.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bNv, null, this.mStType, 18005, true, false, false);
            if (this.bNv.Bl() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bNv.getFid()));
                createFromThreadCfg.setForumName(this.bNv.zM());
            } else {
                createFromThreadCfg.setForumId(this.bNv.Bl().getForumId());
                createFromThreadCfg.setForumName(this.bNv.Bl().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int aKy() {
        if (this.esB == null || this.esB.getHeaderImg() == null) {
            return -1;
        }
        return this.esB.getHeaderImg().getId();
    }

    public int aKz() {
        if (this.esB == null || this.esB.getForumName() == null) {
            return -1;
        }
        return this.esB.getForumName().getId();
    }

    public int aKA() {
        if (this.esB == null || this.esB.getForumName() == null) {
            return -1;
        }
        return this.esB.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.caJ != null) {
            this.caJ.setShareReportFrom(i);
        }
    }

    public void on(int i) {
        if (this.caJ != null) {
            this.caJ.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.caJ != null) {
            this.caJ.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
