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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
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
public class a extends com.baidu.tieba.card.a<bh> {
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    private View cVw;
    private final View.OnClickListener cbv;
    private bh cdk;
    private final View.OnClickListener ceu;
    private ThreadCommentAndPraiseInfoLayout dGt;
    private ConstrainImageGroup eEC;
    private View.OnClickListener eEH;
    private final View.OnClickListener eEI;
    private View gfP;
    private ThreadForumUserInfoLayout ggQ;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.Yd = true;
        this.mStType = null;
        this.eEH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view, a.this.cdk);
                }
                a.this.aqp();
            }
        };
        this.eEI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bh> aZU = a.this.aZU();
                if (aZU != null) {
                    view.setTag("2");
                    aZU.a(view, a.this.cdk);
                }
            }
        };
        this.cbv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view, a.this.cdk);
                }
            }
        };
        this.ceu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view, a.this.cdk);
                }
            }
        };
        View view = getView();
        this.ggQ = (ThreadForumUserInfoLayout) view.findViewById(R.id.forum_user_info_layout);
        this.ggQ.setForumAfterClickListener(this.cbv);
        this.ggQ.setLikeButtonAfterClickListener(this.ceu);
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.Ym = (PlayVoiceBntNew) view.findViewById(R.id.voice_button);
        this.Ym.setAfterClickListener(this.eEI);
        this.eEC = (ConstrainImageGroup) view.findViewById(R.id.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.eEC.setChildClickListener(this.eEH);
        this.eEC.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        fVar.fU(false);
        this.eEC.setImageProcessor(fVar);
        this.gfP = view.findViewById(R.id.no_image_divider_line);
        this.dGt = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_info_layout);
        this.dGt.setOnClickListener(this.eEH);
        this.dGt.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view2, a.this.cdk);
                }
                if (a.this.cdk != null) {
                    n.vW(a.this.cdk.getId());
                    a.this.bwa();
                }
            }
        });
        this.dGt.setShowCommonView();
        this.cVw = view.findViewById(R.id.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eEC != null) {
            this.eEC.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eEC != null) {
            this.eEC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eEC != null) {
            this.eEC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ggQ != null) {
            this.ggQ.setPageUniqueId(bdUniqueId);
        }
        if (this.eEC != null) {
            this.eEC.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.k(getView(), R.drawable.addresslist_item_bg);
            this.ggQ.onChangeSkinType(i);
            this.eEC.onChangeSkinType();
            this.dGt.onChangeSkinType();
            am.l(this.cVw, R.color.cp_bg_line_c);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_daily_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cdk = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eEH);
        }
        this.ggQ.setData(this.cdk);
        ai(this.cdk);
        ArrayList<VoiceData.VoiceModel> aeQ = this.cdk.aeQ();
        if (v.aa(aeQ)) {
            this.Ym.setVisibility(8);
            iF(false);
        } else {
            this.Ym.setVisibility(0);
            iF(true);
            VoiceData.VoiceModel voiceModel = aeQ.get(0);
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bql();
            if (voiceModel != null) {
                this.Ym.we(voiceModel.voice_status.intValue());
            }
            this.Ym.crJ();
        }
        ArrayList<MediaData> aeM = this.cdk.aeM();
        if (i.ace().aci() && v.Z(aeM) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aeM.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeM, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.eEC.setVisibility(0);
                this.gfP.setVisibility(8);
                this.eEC.setFromCDN(this.Yd);
                this.eEC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bh> aZU = a.this.aZU();
                        if (aZU != null) {
                            view.setTag("1");
                            aZU.a(view, a.this.cdk);
                        }
                        a.this.aqp();
                    }
                });
                this.eEC.setImageMediaList(linkedList);
            } else {
                this.eEC.setVisibility(8);
                this.gfP.setVisibility(0);
            }
        } else {
            this.eEC.setVisibility(8);
            this.gfP.setVisibility(0);
        }
        this.dGt.ccG = this.currentPageType;
        this.dGt.setData(this.cdk);
        bqn();
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ai(bh bhVar) {
        SpannableStringBuilder o = bhVar.o(false, true);
        if (o == null || StringUtils.isNull(o.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(o));
            this.mTitle.setText(o);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwa() {
        if (n.vX(this.cdk.getId())) {
            n.a(this.mTitle, this.cdk.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void bqn() {
        if (this.mTitle != null && this.Ym != null && this.eEC != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ym.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.Ym.setLayoutParams(layoutParams);
            if (this.Ym.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eEC.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.eEC.setLayoutParams(layoutParams2);
            }
        }
    }

    private void iF(boolean z) {
        if (this.eEC != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEC.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.eEC.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqp() {
        if (this.cdk != null) {
            n.vW(this.cdk.getId());
            n.a(this.mTitle, this.cdk.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.cdk, null, this.mStType, 18005, true, false, false);
            if (this.cdk.agp() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.cdk.getFid()));
                createFromThreadCfg.setForumName(this.cdk.aeH());
            } else {
                createFromThreadCfg.setForumId(this.cdk.agp().getForumId());
                createFromThreadCfg.setForumName(this.cdk.agp().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int bwn() {
        if (this.ggQ == null || this.ggQ.getHeaderImg() == null) {
            return -1;
        }
        return this.ggQ.getHeaderImg().getId();
    }

    public int bwo() {
        if (this.ggQ == null || this.ggQ.getForumName() == null) {
            return -1;
        }
        return this.ggQ.getForumName().getId();
    }

    public int bwp() {
        if (this.ggQ == null || this.ggQ.getForumName() == null) {
            return -1;
        }
        return this.ggQ.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dGt != null) {
            this.dGt.setShareReportFrom(i);
        }
    }

    public void tL(int i) {
        if (this.dGt != null) {
            this.dGt.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dGt != null) {
            this.dGt.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
