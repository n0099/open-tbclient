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
    private boolean ZQ;
    public PlayVoiceBntNew ZZ;
    private final View.OnClickListener bRB;
    private bg bTn;
    private final View.OnClickListener bUv;
    private View cKM;
    private ThreadCommentAndPraiseInfoLayout dqy;
    private ConstrainImageGroup ehZ;
    private View.OnClickListener eie;
    private final View.OnClickListener eif;
    private View fGZ;
    private ThreadForumUserInfoLayout fIn;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ZQ = true;
        this.mStType = null;
        this.eie = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.bTn);
                }
                a.this.ajU();
            }
        };
        this.eif = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aQf = a.this.aQf();
                if (aQf != null) {
                    view.setTag("2");
                    aQf.a(view, a.this.bTn);
                }
            }
        };
        this.bRB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.bTn);
                }
            }
        };
        this.bUv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view, a.this.bTn);
                }
            }
        };
        View view = getView();
        this.fIn = (ThreadForumUserInfoLayout) view.findViewById(d.g.forum_user_info_layout);
        this.fIn.setForumAfterClickListener(this.bRB);
        this.fIn.setLikeButtonAfterClickListener(this.bUv);
        this.mTitle = (TextView) view.findViewById(d.g.thread_title);
        this.ZZ = (PlayVoiceBntNew) view.findViewById(d.g.voice_button);
        this.ZZ.setAfterClickListener(this.eif);
        this.ehZ = (ConstrainImageGroup) view.findViewById(d.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.ehZ.setChildClickListener(this.eie);
        this.ehZ.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        fVar.fq(false);
        this.ehZ.setImageProcessor(fVar);
        this.fGZ = view.findViewById(d.g.no_image_divider_line);
        this.dqy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_comment_info_layout);
        this.dqy.setOnClickListener(this.eie);
        this.dqy.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aQf() != null) {
                    a.this.aQf().a(view2, a.this.bTn);
                }
                if (a.this.bTn != null) {
                    n.tz(a.this.bTn.getId());
                    a.this.blx();
                }
            }
        });
        this.dqy.setShowCommonView();
        this.cKM = view.findViewById(d.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.ehZ != null) {
            this.ehZ.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ehZ != null) {
            this.ehZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ehZ != null) {
            this.ehZ.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fIn != null) {
            this.fIn.setPageUniqueId(bdUniqueId);
        }
        if (this.ehZ != null) {
            this.ehZ.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(getView(), d.f.addresslist_item_bg);
            this.fIn.onChangeSkinType(i);
            this.ehZ.onChangeSkinType();
            this.dqy.onChangeSkinType();
            al.l(this.cKM, d.C0277d.cp_bg_line_e);
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
        this.bTn = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eie);
        }
        this.fIn.setData(this.bTn);
        ag(this.bTn);
        ArrayList<VoiceData.VoiceModel> Zc = this.bTn.Zc();
        if (v.T(Zc)) {
            this.ZZ.setVisibility(8);
            hO(false);
        } else {
            this.ZZ.setVisibility(0);
            hO(true);
            VoiceData.VoiceModel voiceModel = Zc.get(0);
            this.ZZ.setVoiceModel(voiceModel);
            this.ZZ.setTag(voiceModel);
            this.ZZ.bxS();
            if (voiceModel != null) {
                this.ZZ.uq(voiceModel.voice_status.intValue());
            }
            this.ZZ.cfz();
        }
        ArrayList<MediaData> YY = this.bTn.YY();
        if (i.Wv().Wz() && v.S(YY) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < YY.size(); i++) {
                MediaData mediaData = (MediaData) v.c(YY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.S(linkedList) > 0) {
                this.ehZ.setVisibility(0);
                this.fGZ.setVisibility(8);
                this.ehZ.setFromCDN(this.ZQ);
                this.ehZ.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aQf = a.this.aQf();
                        if (aQf != null) {
                            view.setTag("1");
                            aQf.a(view, a.this.bTn);
                        }
                        a.this.ajU();
                    }
                });
                this.ehZ.setImageMediaList(linkedList);
            } else {
                this.ehZ.setVisibility(8);
                this.fGZ.setVisibility(0);
            }
        } else {
            this.ehZ.setVisibility(8);
            this.fGZ.setVisibility(0);
        }
        this.dqy.bSJ = this.currentPageType;
        this.dqy.setData(this.bTn);
        bfR();
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ag(bg bgVar) {
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
    public void blx() {
        if (n.tA(this.bTn.getId())) {
            n.a(this.mTitle, this.bTn.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
    }

    private void bfR() {
        if (this.mTitle != null && this.ZZ != null && this.ehZ != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZZ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.ZZ.setLayoutParams(layoutParams);
            if (this.ZZ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ehZ.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.ehZ.setLayoutParams(layoutParams2);
            }
        }
    }

    private void hO(boolean z) {
        if (this.ehZ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehZ.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.ehZ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajU() {
        if (this.bTn != null) {
            n.tz(this.bTn.getId());
            n.a(this.mTitle, this.bTn.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bTn, null, this.mStType, 18005, true, false, false);
            if (this.bTn.aaB() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bTn.getFid()));
                createFromThreadCfg.setForumName(this.bTn.YT());
            } else {
                createFromThreadCfg.setForumId(this.bTn.aaB().getForumId());
                createFromThreadCfg.setForumName(this.bTn.aaB().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int blK() {
        if (this.fIn == null || this.fIn.getHeaderImg() == null) {
            return -1;
        }
        return this.fIn.getHeaderImg().getId();
    }

    public int blL() {
        if (this.fIn == null || this.fIn.getForumName() == null) {
            return -1;
        }
        return this.fIn.getForumName().getId();
    }

    public int blM() {
        if (this.fIn == null || this.fIn.getForumName() == null) {
            return -1;
        }
        return this.fIn.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dqy != null) {
            this.dqy.setShareReportFrom(i);
        }
    }

    public void sg(int i) {
        if (this.dqy != null) {
            this.dqy.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dqy != null) {
            this.dqy.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
