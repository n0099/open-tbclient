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
    private boolean ZO;
    public PlayVoiceBntNew ZX;
    private final View.OnClickListener bRy;
    private bg bTk;
    private final View.OnClickListener bUs;
    private View cKN;
    private ThreadCommentAndPraiseInfoLayout dqz;
    private ConstrainImageGroup eir;
    private View.OnClickListener eiw;
    private final View.OnClickListener eix;
    private View fHm;
    private ThreadForumUserInfoLayout fIA;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ZO = true;
        this.mStType = null;
        this.eiw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.bTk);
                }
                a.this.ajY();
            }
        };
        this.eix = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aQh = a.this.aQh();
                if (aQh != null) {
                    view.setTag("2");
                    aQh.a(view, a.this.bTk);
                }
            }
        };
        this.bRy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.bTk);
                }
            }
        };
        this.bUs = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view, a.this.bTk);
                }
            }
        };
        View view = getView();
        this.fIA = (ThreadForumUserInfoLayout) view.findViewById(d.g.forum_user_info_layout);
        this.fIA.setForumAfterClickListener(this.bRy);
        this.fIA.setLikeButtonAfterClickListener(this.bUs);
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.ZX = (PlayVoiceBntNew) view.findViewById(d.g.voice_button);
        this.ZX.setAfterClickListener(this.eix);
        this.eir = (ConstrainImageGroup) view.findViewById(d.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.eir.setChildClickListener(this.eiw);
        this.eir.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        fVar.fq(false);
        this.eir.setImageProcessor(fVar);
        this.fHm = view.findViewById(d.g.no_image_divider_line);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_info_layout);
        this.dqz.setOnClickListener(this.eiw);
        this.dqz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aQh() != null) {
                    a.this.aQh().a(view2, a.this.bTk);
                }
                if (a.this.bTk != null) {
                    n.tB(a.this.bTk.getId());
                    a.this.blA();
                }
            }
        });
        this.dqz.setShowCommonView();
        this.cKN = view.findViewById(d.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eir != null) {
            this.eir.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eir != null) {
            this.eir.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eir != null) {
            this.eir.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fIA != null) {
            this.fIA.setPageUniqueId(bdUniqueId);
        }
        if (this.eir != null) {
            this.eir.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(getView(), d.f.addresslist_item_bg);
            this.fIA.onChangeSkinType(i);
            this.eir.onChangeSkinType();
            this.dqz.onChangeSkinType();
            al.l(this.cKN, d.C0236d.cp_bg_line_e);
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
        this.bTk = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eiw);
        }
        this.fIA.setData(this.bTk);
        ah(this.bTk);
        ArrayList<VoiceData.VoiceModel> Zf = this.bTk.Zf();
        if (v.T(Zf)) {
            this.ZX.setVisibility(8);
            hO(false);
        } else {
            this.ZX.setVisibility(0);
            hO(true);
            VoiceData.VoiceModel voiceModel = Zf.get(0);
            this.ZX.setVoiceModel(voiceModel);
            this.ZX.setTag(voiceModel);
            this.ZX.bxV();
            if (voiceModel != null) {
                this.ZX.uu(voiceModel.voice_status.intValue());
            }
            this.ZX.cfA();
        }
        ArrayList<MediaData> Zb = this.bTk.Zb();
        if (i.Wy().WC() && v.S(Zb) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < Zb.size(); i++) {
                MediaData mediaData = (MediaData) v.c(Zb, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.S(linkedList) > 0) {
                this.eir.setVisibility(0);
                this.fHm.setVisibility(8);
                this.eir.setFromCDN(this.ZO);
                this.eir.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aQh = a.this.aQh();
                        if (aQh != null) {
                            view.setTag("1");
                            aQh.a(view, a.this.bTk);
                        }
                        a.this.ajY();
                    }
                });
                this.eir.setImageMediaList(linkedList);
            } else {
                this.eir.setVisibility(8);
                this.fHm.setVisibility(0);
            }
        } else {
            this.eir.setVisibility(8);
            this.fHm.setVisibility(0);
        }
        this.dqz.bSG = this.currentPageType;
        this.dqz.setData(this.bTk);
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
            n.a(this.mTitle, bgVar.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blA() {
        if (n.tC(this.bTk.getId())) {
            n.a(this.mTitle, this.bTk.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        }
    }

    private void bfT() {
        if (this.mTitle != null && this.ZX != null && this.eir != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZX.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.ZX.setLayoutParams(layoutParams);
            if (this.ZX.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eir.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.eir.setLayoutParams(layoutParams2);
            }
        }
    }

    private void hO(boolean z) {
        if (this.eir != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eir.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.eir.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajY() {
        if (this.bTk != null) {
            n.tB(this.bTk.getId());
            n.a(this.mTitle, this.bTk.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bTk, null, this.mStType, 18005, true, false, false);
            if (this.bTk.aaE() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bTk.getFid()));
                createFromThreadCfg.setForumName(this.bTk.YW());
            } else {
                createFromThreadCfg.setForumId(this.bTk.aaE().getForumId());
                createFromThreadCfg.setForumName(this.bTk.aaE().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int blN() {
        if (this.fIA == null || this.fIA.getHeaderImg() == null) {
            return -1;
        }
        return this.fIA.getHeaderImg().getId();
    }

    public int blO() {
        if (this.fIA == null || this.fIA.getForumName() == null) {
            return -1;
        }
        return this.fIA.getForumName().getId();
    }

    public int blP() {
        if (this.fIA == null || this.fIA.getForumName() == null) {
            return -1;
        }
        return this.fIA.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dqz != null) {
            this.dqz.setShareReportFrom(i);
        }
    }

    public void sk(int i) {
        if (this.dqz != null) {
            this.dqz.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dqz != null) {
            this.dqz.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
