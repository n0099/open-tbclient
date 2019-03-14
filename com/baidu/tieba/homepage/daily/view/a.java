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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<bg> {
    private boolean ZP;
    public PlayVoiceBntNew ZY;
    private final View.OnClickListener bRz;
    private bg bTl;
    private final View.OnClickListener bUt;
    private View cKK;
    private ThreadCommentAndPraiseInfoLayout dqv;
    private ConstrainImageGroup ein;
    private View.OnClickListener eis;
    private final View.OnClickListener eit;
    private View fHl;
    private ThreadForumUserInfoLayout fIz;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ZP = true;
        this.mStType = null;
        this.eis = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.bTl);
                }
                a.this.ajX();
            }
        };
        this.eit = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aQh = a.this.aQh();
                if (aQh != null) {
                    view.setTag("2");
                    aQh.a(view, a.this.bTl);
                }
            }
        };
        this.bRz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.bTl);
                }
            }
        };
        this.bUt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.bTl);
                }
            }
        };
        View view = getView();
        this.fIz = (ThreadForumUserInfoLayout) view.findViewById(d.g.forum_user_info_layout);
        this.fIz.setForumAfterClickListener(this.bRz);
        this.fIz.setLikeButtonAfterClickListener(this.bUt);
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.ZY = (PlayVoiceBntNew) view.findViewById(d.g.voice_button);
        this.ZY.setAfterClickListener(this.eit);
        this.ein = (ConstrainImageGroup) view.findViewById(d.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.ein.setChildClickListener(this.eis);
        this.ein.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        fVar.fq(false);
        this.ein.setImageProcessor(fVar);
        this.fHl = view.findViewById(d.g.no_image_divider_line);
        this.dqv = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_info_layout);
        this.dqv.setOnClickListener(this.eis);
        this.dqv.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view2, a.this.bTl);
                }
                if (a.this.bTl != null) {
                    n.tA(a.this.bTl.getId());
                    a.this.blA();
                }
            }
        });
        this.dqv.setShowCommonView();
        this.cKK = view.findViewById(d.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.ein != null) {
            this.ein.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ein != null) {
            this.ein.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ein != null) {
            this.ein.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fIz != null) {
            this.fIz.setPageUniqueId(bdUniqueId);
        }
        if (this.ein != null) {
            this.ein.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(getView(), d.f.addresslist_item_bg);
            this.fIz.onChangeSkinType(i);
            this.ein.onChangeSkinType();
            this.dqv.onChangeSkinType();
            al.l(this.cKK, d.C0277d.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_daily_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bg bgVar) {
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bTl = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eis);
        }
        this.fIz.setData(this.bTl);
        ah(this.bTl);
        ArrayList<VoiceData.VoiceModel> Zf = this.bTl.Zf();
        if (v.T(Zf)) {
            this.ZY.setVisibility(8);
            hO(false);
        } else {
            this.ZY.setVisibility(0);
            hO(true);
            VoiceData.VoiceModel voiceModel = Zf.get(0);
            this.ZY.setVoiceModel(voiceModel);
            this.ZY.setTag(voiceModel);
            this.ZY.bxV();
            if (voiceModel != null) {
                this.ZY.uu(voiceModel.voice_status.intValue());
            }
            this.ZY.cfD();
        }
        ArrayList<MediaData> Zb = this.bTl.Zb();
        if (i.Wy().WC() && v.S(Zb) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < Zb.size(); i++) {
                MediaData mediaData = (MediaData) v.c(Zb, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.S(linkedList) > 0) {
                this.ein.setVisibility(0);
                this.fHl.setVisibility(8);
                this.ein.setFromCDN(this.ZP);
                this.ein.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aQh = a.this.aQh();
                        if (aQh != null) {
                            view.setTag("1");
                            aQh.a(view, a.this.bTl);
                        }
                        a.this.ajX();
                    }
                });
                this.ein.setImageMediaList(linkedList);
            } else {
                this.ein.setVisibility(8);
                this.fHl.setVisibility(0);
            }
        } else {
            this.ein.setVisibility(8);
            this.fHl.setVisibility(0);
        }
        this.dqv.bSH = this.currentPageType;
        this.dqv.setData(this.bTl);
        bfT();
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ah(bg bgVar) {
        SpannableStringBuilder m = bgVar.m(false, true);
        if (m == null || StringUtils.isNull(m.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(m));
            this.mTitle.setText(m);
            n.a(this.mTitle, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blA() {
        if (n.tB(this.bTl.getId())) {
            n.a(this.mTitle, this.bTl.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
    }

    private void bfT() {
        if (this.mTitle != null && this.ZY != null && this.ein != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.ZY.setLayoutParams(layoutParams);
            if (this.ZY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ein.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.ein.setLayoutParams(layoutParams2);
            }
        }
    }

    private void hO(boolean z) {
        if (this.ein != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ein.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.ein.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajX() {
        if (this.bTl != null) {
            n.tA(this.bTl.getId());
            n.a(this.mTitle, this.bTl.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bTl, null, this.mStType, 18005, true, false, false);
            if (this.bTl.aaE() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bTl.getFid()));
                createFromThreadCfg.setForumName(this.bTl.YW());
            } else {
                createFromThreadCfg.setForumId(this.bTl.aaE().getForumId());
                createFromThreadCfg.setForumName(this.bTl.aaE().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int blN() {
        if (this.fIz == null || this.fIz.getHeaderImg() == null) {
            return -1;
        }
        return this.fIz.getHeaderImg().getId();
    }

    public int blO() {
        if (this.fIz == null || this.fIz.getForumName() == null) {
            return -1;
        }
        return this.fIz.getForumName().getId();
    }

    public int blP() {
        if (this.fIz == null || this.fIz.getForumName() == null) {
            return -1;
        }
        return this.fIz.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dqv != null) {
            this.dqv.setShareReportFrom(i);
        }
    }

    public void sk(int i) {
        if (this.dqv != null) {
            this.dqv.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dqv != null) {
            this.dqv.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
