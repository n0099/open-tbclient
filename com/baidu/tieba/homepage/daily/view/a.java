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
    private View cUD;
    private final View.OnClickListener caC;
    private bh ccq;
    private final View.OnClickListener cdB;
    private ThreadCommentAndPraiseInfoLayout dEI;
    private ConstrainImageGroup eCT;
    private View.OnClickListener eCY;
    private final View.OnClickListener eCZ;
    private View gdX;
    private ThreadForumUserInfoLayout geZ;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.Yd = true;
        this.mStType = null;
        this.eCY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view, a.this.ccq);
                }
                a.this.aqd();
            }
        };
        this.eCZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bh> aZq = a.this.aZq();
                if (aZq != null) {
                    view.setTag("2");
                    aZq.a(view, a.this.ccq);
                }
            }
        };
        this.caC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view, a.this.ccq);
                }
            }
        };
        this.cdB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view, a.this.ccq);
                }
            }
        };
        View view = getView();
        this.geZ = (ThreadForumUserInfoLayout) view.findViewById(R.id.forum_user_info_layout);
        this.geZ.setForumAfterClickListener(this.caC);
        this.geZ.setLikeButtonAfterClickListener(this.cdB);
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.Ym = (PlayVoiceBntNew) view.findViewById(R.id.voice_button);
        this.Ym.setAfterClickListener(this.eCZ);
        this.eCT = (ConstrainImageGroup) view.findViewById(R.id.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.eCT.setChildClickListener(this.eCY);
        this.eCT.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        fVar.fR(false);
        this.eCT.setImageProcessor(fVar);
        this.gdX = view.findViewById(R.id.no_image_divider_line);
        this.dEI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_info_layout);
        this.dEI.setOnClickListener(this.eCY);
        this.dEI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view2, a.this.ccq);
                }
                if (a.this.ccq != null) {
                    n.vx(a.this.ccq.getId());
                    a.this.bvm();
                }
            }
        });
        this.dEI.setShowCommonView();
        this.cUD = view.findViewById(R.id.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eCT != null) {
            this.eCT.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCT != null) {
            this.eCT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCT != null) {
            this.eCT.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.geZ != null) {
            this.geZ.setPageUniqueId(bdUniqueId);
        }
        if (this.eCT != null) {
            this.eCT.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.k(getView(), R.drawable.addresslist_item_bg);
            this.geZ.onChangeSkinType(i);
            this.eCT.onChangeSkinType();
            this.dEI.onChangeSkinType();
            am.l(this.cUD, R.color.cp_bg_line_e);
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
        this.ccq = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eCY);
        }
        this.geZ.setData(this.ccq);
        ah(this.ccq);
        ArrayList<VoiceData.VoiceModel> aeM = this.ccq.aeM();
        if (v.aa(aeM)) {
            this.Ym.setVisibility(8);
            iC(false);
        } else {
            this.Ym.setVisibility(0);
            iC(true);
            VoiceData.VoiceModel voiceModel = aeM.get(0);
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bIz();
            if (voiceModel != null) {
                this.Ym.wa(voiceModel.voice_status.intValue());
            }
            this.Ym.cqV();
        }
        ArrayList<MediaData> aeI = this.ccq.aeI();
        if (i.aca().ace() && v.Z(aeI) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aeI.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeI, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.eCT.setVisibility(0);
                this.gdX.setVisibility(8);
                this.eCT.setFromCDN(this.Yd);
                this.eCT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bh> aZq = a.this.aZq();
                        if (aZq != null) {
                            view.setTag("1");
                            aZq.a(view, a.this.ccq);
                        }
                        a.this.aqd();
                    }
                });
                this.eCT.setImageMediaList(linkedList);
            } else {
                this.eCT.setVisibility(8);
                this.gdX.setVisibility(0);
            }
        } else {
            this.eCT.setVisibility(8);
            this.gdX.setVisibility(0);
        }
        this.dEI.cbM = this.currentPageType;
        this.dEI.setData(this.ccq);
        bpB();
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ah(bh bhVar) {
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
    public void bvm() {
        if (n.vy(this.ccq.getId())) {
            n.a(this.mTitle, this.ccq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void bpB() {
        if (this.mTitle != null && this.Ym != null && this.eCT != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ym.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.Ym.setLayoutParams(layoutParams);
            if (this.Ym.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eCT.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.eCT.setLayoutParams(layoutParams2);
            }
        }
    }

    private void iC(boolean z) {
        if (this.eCT != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCT.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.eCT.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqd() {
        if (this.ccq != null) {
            n.vx(this.ccq.getId());
            n.a(this.mTitle, this.ccq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.ccq, null, this.mStType, 18005, true, false, false);
            if (this.ccq.agl() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.ccq.getFid()));
                createFromThreadCfg.setForumName(this.ccq.aeD());
            } else {
                createFromThreadCfg.setForumId(this.ccq.agl().getForumId());
                createFromThreadCfg.setForumName(this.ccq.agl().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int bvz() {
        if (this.geZ == null || this.geZ.getHeaderImg() == null) {
            return -1;
        }
        return this.geZ.getHeaderImg().getId();
    }

    public int bvA() {
        if (this.geZ == null || this.geZ.getForumName() == null) {
            return -1;
        }
        return this.geZ.getForumName().getId();
    }

    public int bvB() {
        if (this.geZ == null || this.geZ.getForumName() == null) {
            return -1;
        }
        return this.geZ.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dEI != null) {
            this.dEI.setShareReportFrom(i);
        }
    }

    public void tH(int i) {
        if (this.dEI != null) {
            this.dEI.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dEI != null) {
            this.dEI.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
