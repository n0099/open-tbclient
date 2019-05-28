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
    private View cSZ;
    private bg cbg;
    private final View.OnClickListener ccq;
    private ThreadCommentAndPraiseInfoLayout dBf;
    private ConstrainImageGroup exO;
    private View.OnClickListener exT;
    private final View.OnClickListener exU;
    private View fYi;
    private ThreadForumUserInfoLayout fZj;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.XJ = true;
        this.mStType = null;
        this.exT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view, a.this.cbg);
                }
                a.this.aoV();
            }
        };
        this.exU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aXr = a.this.aXr();
                if (aXr != null) {
                    view.setTag("2");
                    aXr.a(view, a.this.cbg);
                }
            }
        };
        this.bZt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view, a.this.cbg);
                }
            }
        };
        this.ccq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view, a.this.cbg);
                }
            }
        };
        View view = getView();
        this.fZj = (ThreadForumUserInfoLayout) view.findViewById(R.id.forum_user_info_layout);
        this.fZj.setForumAfterClickListener(this.bZt);
        this.fZj.setLikeButtonAfterClickListener(this.ccq);
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.XS = (PlayVoiceBntNew) view.findViewById(R.id.voice_button);
        this.XS.setAfterClickListener(this.exU);
        this.exO = (ConstrainImageGroup) view.findViewById(R.id.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.exO.setChildClickListener(this.exT);
        this.exO.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        fVar.fN(false);
        this.exO.setImageProcessor(fVar);
        this.fYi = view.findViewById(R.id.no_image_divider_line);
        this.dBf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_info_layout);
        this.dBf.setOnClickListener(this.exT);
        this.dBf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view2, a.this.cbg);
                }
                if (a.this.cbg != null) {
                    n.uS(a.this.cbg.getId());
                    a.this.bsW();
                }
            }
        });
        this.dBf.setShowCommonView();
        this.cSZ = view.findViewById(R.id.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.exO != null) {
            this.exO.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exO != null) {
            this.exO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exO != null) {
            this.exO.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fZj != null) {
            this.fZj.setPageUniqueId(bdUniqueId);
        }
        if (this.exO != null) {
            this.exO.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(getView(), R.drawable.addresslist_item_bg);
            this.fZj.onChangeSkinType(i);
            this.exO.onChangeSkinType();
            this.dBf.onChangeSkinType();
            al.l(this.cSZ, R.color.cp_bg_line_e);
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
            getView().setOnClickListener(this.exT);
        }
        this.fZj.setData(this.cbg);
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
            this.XS.bFD();
            if (voiceModel != null) {
                this.XS.vx(voiceModel.voice_status.intValue());
            }
            this.XS.cnF();
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
                this.exO.setVisibility(0);
                this.fYi.setVisibility(8);
                this.exO.setFromCDN(this.XJ);
                this.exO.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aXr = a.this.aXr();
                        if (aXr != null) {
                            view.setTag("1");
                            aXr.a(view, a.this.cbg);
                        }
                        a.this.aoV();
                    }
                });
                this.exO.setImageMediaList(linkedList);
            } else {
                this.exO.setVisibility(8);
                this.fYi.setVisibility(0);
            }
        } else {
            this.exO.setVisibility(8);
            this.fYi.setVisibility(0);
        }
        this.dBf.caC = this.currentPageType;
        this.dBf.setData(this.cbg);
        bnn();
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
    public void bsW() {
        if (n.uT(this.cbg.getId())) {
            n.a(this.mTitle, this.cbg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void bnn() {
        if (this.mTitle != null && this.XS != null && this.exO != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XS.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.XS.setLayoutParams(layoutParams);
            if (this.XS.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.exO.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.exO.setLayoutParams(layoutParams2);
            }
        }
    }

    private void it(boolean z) {
        if (this.exO != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.exO.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.exO.setLayoutParams(layoutParams);
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

    public int btj() {
        if (this.fZj == null || this.fZj.getHeaderImg() == null) {
            return -1;
        }
        return this.fZj.getHeaderImg().getId();
    }

    public int btk() {
        if (this.fZj == null || this.fZj.getForumName() == null) {
            return -1;
        }
        return this.fZj.getForumName().getId();
    }

    public int btl() {
        if (this.fZj == null || this.fZj.getForumName() == null) {
            return -1;
        }
        return this.fZj.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dBf != null) {
            this.dBf.setShareReportFrom(i);
        }
    }

    public void tn(int i) {
        if (this.dBf != null) {
            this.dBf.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dBf != null) {
            this.dBf.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
