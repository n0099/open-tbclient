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
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<bg> {
    private boolean XJ;
    public PlayVoiceBntNew XS;
    private final View.OnClickListener bZt;
    private View cSY;
    private bg cbg;
    private final View.OnClickListener ccq;
    private ThreadCommentAndPraiseInfoLayout dBe;
    private ConstrainImageGroup exN;
    private View.OnClickListener exS;
    private final View.OnClickListener exT;
    private View fYh;
    private ThreadForumUserInfoLayout fZi;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.XJ = true;
        this.mStType = null;
        this.exS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXo() != null) {
                    a.this.aXo().a(view, a.this.cbg);
                }
                a.this.aoV();
            }
        };
        this.exT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aXo = a.this.aXo();
                if (aXo != null) {
                    view.setTag("2");
                    aXo.a(view, a.this.cbg);
                }
            }
        };
        this.bZt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXo() != null) {
                    a.this.aXo().a(view, a.this.cbg);
                }
            }
        };
        this.ccq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXo() != null) {
                    a.this.aXo().a(view, a.this.cbg);
                }
            }
        };
        View view = getView();
        this.fZi = (ThreadForumUserInfoLayout) view.findViewById(R.id.forum_user_info_layout);
        this.fZi.setForumAfterClickListener(this.bZt);
        this.fZi.setLikeButtonAfterClickListener(this.ccq);
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.XS = (PlayVoiceBntNew) view.findViewById(R.id.voice_button);
        this.XS.setAfterClickListener(this.exT);
        this.exN = (ConstrainImageGroup) view.findViewById(R.id.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.exN.setChildClickListener(this.exS);
        this.exN.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        fVar.fN(false);
        this.exN.setImageProcessor(fVar);
        this.fYh = view.findViewById(R.id.no_image_divider_line);
        this.dBe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_info_layout);
        this.dBe.setOnClickListener(this.exS);
        this.dBe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aXo() != null) {
                    a.this.aXo().a(view2, a.this.cbg);
                }
                if (a.this.cbg != null) {
                    n.uS(a.this.cbg.getId());
                    a.this.bsT();
                }
            }
        });
        this.dBe.setShowCommonView();
        this.cSY = view.findViewById(R.id.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.exN != null) {
            this.exN.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exN != null) {
            this.exN.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exN != null) {
            this.exN.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fZi != null) {
            this.fZi.setPageUniqueId(bdUniqueId);
        }
        if (this.exN != null) {
            this.exN.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(getView(), R.drawable.addresslist_item_bg);
            this.fZi.onChangeSkinType(i);
            this.exN.onChangeSkinType();
            this.dBe.onChangeSkinType();
            al.l(this.cSY, R.color.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_daily_normal_thread;
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
        this.cbg = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.exS);
        }
        this.fZi.setData(this.cbg);
        ag(this.cbg);
        ArrayList<VoiceData.VoiceModel> adJ = this.cbg.adJ();
        if (v.aa(adJ)) {
            this.XS.setVisibility(8);
            it(false);
        } else {
            this.XS.setVisibility(0);
            it(true);
            VoiceData.VoiceModel voiceModel = adJ.get(0);
            this.XS.setVoiceModel(voiceModel);
            this.XS.setTag(voiceModel);
            this.XS.bFA();
            if (voiceModel != null) {
                this.XS.vx(voiceModel.voice_status.intValue());
            }
            this.XS.cnD();
        }
        ArrayList<MediaData> adF = this.cbg.adF();
        if (i.abb().abf() && v.Z(adF) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < adF.size(); i++) {
                MediaData mediaData = (MediaData) v.c(adF, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.exN.setVisibility(0);
                this.fYh.setVisibility(8);
                this.exN.setFromCDN(this.XJ);
                this.exN.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aXo = a.this.aXo();
                        if (aXo != null) {
                            view.setTag("1");
                            aXo.a(view, a.this.cbg);
                        }
                        a.this.aoV();
                    }
                });
                this.exN.setImageMediaList(linkedList);
            } else {
                this.exN.setVisibility(8);
                this.fYh.setVisibility(0);
            }
        } else {
            this.exN.setVisibility(8);
            this.fYh.setVisibility(0);
        }
        this.dBe.caC = this.currentPageType;
        this.dBe.setData(this.cbg);
        bnk();
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
            n.a(this.mTitle, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsT() {
        if (n.uT(this.cbg.getId())) {
            n.a(this.mTitle, this.cbg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void bnk() {
        if (this.mTitle != null && this.XS != null && this.exN != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XS.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.XS.setLayoutParams(layoutParams);
            if (this.XS.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.exN.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.exN.setLayoutParams(layoutParams2);
            }
        }
    }

    private void it(boolean z) {
        if (this.exN != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.exN.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.exN.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoV() {
        if (this.cbg != null) {
            n.uS(this.cbg.getId());
            n.a(this.mTitle, this.cbg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.cbg, null, this.mStType, 18005, true, false, false);
            if (this.cbg.afi() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.cbg.getFid()));
                createFromThreadCfg.setForumName(this.cbg.adA());
            } else {
                createFromThreadCfg.setForumId(this.cbg.afi().getForumId());
                createFromThreadCfg.setForumName(this.cbg.afi().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int btg() {
        if (this.fZi == null || this.fZi.getHeaderImg() == null) {
            return -1;
        }
        return this.fZi.getHeaderImg().getId();
    }

    public int bth() {
        if (this.fZi == null || this.fZi.getForumName() == null) {
            return -1;
        }
        return this.fZi.getForumName().getId();
    }

    public int bti() {
        if (this.fZi == null || this.fZi.getForumName() == null) {
            return -1;
        }
        return this.fZi.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dBe != null) {
            this.dBe.setShareReportFrom(i);
        }
    }

    public void tn(int i) {
        if (this.dBe != null) {
            this.dBe.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dBe != null) {
            this.dBe.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
