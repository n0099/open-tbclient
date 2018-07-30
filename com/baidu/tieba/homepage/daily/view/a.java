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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bb> {
    private boolean asR;
    private final View.OnClickListener axz;
    private final View.OnClickListener azt;
    private ThreadCommentAndPraiseInfoLayout bHO;
    private View bkE;
    private bb buw;
    private View.OnClickListener cwy;
    public PlayVoiceBntNew czb;
    private ConstrainImageGroup cze;
    private final View.OnClickListener czh;
    private View dTT;
    private ThreadForumUserInfoLayout dVf;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.asR = true;
        this.mStType = null;
        this.cwy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiz() != null) {
                    a.this.aiz().a(view, a.this.buw);
                }
                a.this.aiS();
            }
        };
        this.czh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> aiz = a.this.aiz();
                if (aiz != null) {
                    view.setTag("2");
                    aiz.a(view, a.this.buw);
                }
            }
        };
        this.axz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiz() != null) {
                    a.this.aiz().a(view, a.this.buw);
                }
            }
        };
        this.azt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiz() != null) {
                    a.this.aiz().a(view, a.this.buw);
                }
            }
        };
        View view = getView();
        this.dVf = (ThreadForumUserInfoLayout) view.findViewById(d.g.forum_user_info_layout);
        this.dVf.setForumAfterClickListener(this.axz);
        this.dVf.setLikeButtonAfterClickListener(this.azt);
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.czb = (PlayVoiceBntNew) view.findViewById(d.g.voice_button);
        this.czb.setAfterClickListener(this.czh);
        this.cze = (ConstrainImageGroup) view.findViewById(d.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cze.setChildClickListener(this.cwy);
        this.cze.setImageMargin(dimensionPixelSize);
        e eVar = new e(3);
        eVar.h(1.0d);
        eVar.cj(false);
        this.cze.setImageProcessor(eVar);
        this.dTT = view.findViewById(d.g.no_image_divider_line);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_info_layout);
        this.bHO.setOnClickListener(this.cwy);
        this.bHO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aiz() != null) {
                    a.this.aiz().a(view2, a.this.buw);
                }
                if (a.this.buw != null) {
                    o.kW(a.this.buw.getId());
                    a.this.aiE();
                }
            }
        });
        this.bHO.setShowCommonView();
        this.bkE = view.findViewById(d.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cze != null) {
            this.cze.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cze != null) {
            this.cze.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cze != null) {
            this.cze.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.dVf != null) {
            this.dVf.setPageUniqueId(bdUniqueId);
        }
        if (this.cze != null) {
            this.cze.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.i(getView(), d.f.addresslist_item_bg);
            this.dVf.onChangeSkinType(i);
            this.cze.onChangeSkinType();
            this.bHO.onChangeSkinType();
            am.j(this.bkE, d.C0140d.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_daily_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.buw = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwy);
        }
        this.dVf.setData(this.buw);
        K(this.buw);
        ArrayList<VoiceData.VoiceModel> vz = this.buw.vz();
        if (w.z(vz)) {
            this.czb.setVisibility(8);
            ew(false);
        } else {
            this.czb.setVisibility(0);
            ew(true);
            VoiceData.VoiceModel voiceModel = vz.get(0);
            this.czb.setVoiceModel(voiceModel);
            this.czb.setTag(voiceModel);
            this.czb.aPt();
            if (voiceModel != null) {
                this.czb.oH(voiceModel.voice_status.intValue());
            }
            this.czb.bxp();
        }
        ArrayList<MediaData> vv = this.buw.vv();
        if (i.te().tk() && w.y(vv) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < vv.size(); i++) {
                MediaData mediaData = (MediaData) w.d(vv, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (w.y(linkedList) > 0) {
                this.cze.setVisibility(0);
                this.dTT.setVisibility(8);
                this.cze.setFromCDN(this.asR);
                this.cze.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void c(View view, int i2, boolean z) {
                        ad<bb> aiz = a.this.aiz();
                        if (aiz != null) {
                            view.setTag("1");
                            aiz.a(view, a.this.buw);
                        }
                        a.this.aiS();
                    }
                });
                this.cze.setImageMediaList(linkedList);
            } else {
                this.cze.setVisibility(8);
                this.dTT.setVisibility(0);
            }
        } else {
            this.cze.setVisibility(8);
            this.dTT.setVisibility(0);
        }
        this.bHO.ajY = this.currentPageType;
        this.bHO.setData(this.buw);
        axw();
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean K(bb bbVar) {
        SpannableStringBuilder g = bbVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bbVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiE() {
        if (o.kX(this.buw.getId())) {
            o.a(this.mTitle, this.buw.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
    }

    private void axw() {
        if (this.mTitle != null && this.czb != null && this.cze != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.czb.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.czb.setLayoutParams(layoutParams);
            if (this.czb.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cze.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cze.setLayoutParams(layoutParams2);
            }
        }
    }

    private void ew(boolean z) {
        if (this.cze != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cze.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cze.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiS() {
        if (this.buw != null) {
            o.kW(this.buw.getId());
            o.a(this.mTitle, this.buw.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.buw, null, this.mStType, 18005, true, false, false);
            if (this.buw.wL() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.buw.getFid()));
                createFromThreadCfg.setForumName(this.buw.vq());
            } else {
                createFromThreadCfg.setForumId(this.buw.wL().getForumId());
                createFromThreadCfg.setForumName(this.buw.wL().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int aDH() {
        if (this.dVf == null || this.dVf.getHeaderImg() == null) {
            return -1;
        }
        return this.dVf.getHeaderImg().getId();
    }

    public int aDI() {
        if (this.dVf == null || this.dVf.getForumName() == null) {
            return -1;
        }
        return this.dVf.getForumName().getId();
    }

    public int aDJ() {
        if (this.dVf == null || this.dVf.getForumName() == null) {
            return -1;
        }
        return this.dVf.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.bHO != null) {
            this.bHO.setShareReportFrom(i);
        }
    }

    public void mz(int i) {
        if (this.bHO != null) {
            this.bHO.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.bHO != null) {
            this.bHO.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
