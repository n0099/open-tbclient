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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bb> {
    private boolean asS;
    private final View.OnClickListener axw;
    private final View.OnClickListener azq;
    private ThreadCommentAndPraiseInfoLayout bHO;
    private View bkJ;
    private bb buy;
    private View.OnClickListener cwv;
    public PlayVoiceBntNew cyY;
    private ConstrainImageGroup czb;
    private final View.OnClickListener cze;
    private View dTO;
    private ThreadForumUserInfoLayout dVa;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.asS = true;
        this.mStType = null;
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiC() != null) {
                    a.this.aiC().a(view, a.this.buy);
                }
                a.this.aiV();
            }
        };
        this.cze = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> aiC = a.this.aiC();
                if (aiC != null) {
                    view.setTag("2");
                    aiC.a(view, a.this.buy);
                }
            }
        };
        this.axw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiC() != null) {
                    a.this.aiC().a(view, a.this.buy);
                }
            }
        };
        this.azq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aiC() != null) {
                    a.this.aiC().a(view, a.this.buy);
                }
            }
        };
        View view = getView();
        this.dVa = (ThreadForumUserInfoLayout) view.findViewById(f.g.forum_user_info_layout);
        this.dVa.setForumAfterClickListener(this.axw);
        this.dVa.setLikeButtonAfterClickListener(this.azq);
        this.mTitle = (TextView) view.findViewById(f.g.thread_title);
        this.cyY = (PlayVoiceBntNew) view.findViewById(f.g.voice_button);
        this.cyY.setAfterClickListener(this.cze);
        this.czb = (ConstrainImageGroup) view.findViewById(f.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds16);
        this.czb.setChildClickListener(this.cwv);
        this.czb.setImageMargin(dimensionPixelSize);
        e eVar = new e(3);
        eVar.g(1.0d);
        eVar.ck(false);
        this.czb.setImageProcessor(eVar);
        this.dTO = view.findViewById(f.g.no_image_divider_line);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.thread_comment_info_layout);
        this.bHO.setOnClickListener(this.cwv);
        this.bHO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aiC() != null) {
                    a.this.aiC().a(view2, a.this.buy);
                }
                if (a.this.buy != null) {
                    o.kY(a.this.buy.getId());
                    a.this.aiH();
                }
            }
        });
        this.bHO.setShowCommonView();
        this.bkJ = view.findViewById(f.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.czb != null) {
            this.czb.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.czb != null) {
            this.czb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.czb != null) {
            this.czb.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.dVa != null) {
            this.dVa.setPageUniqueId(bdUniqueId);
        }
        if (this.czb != null) {
            this.czb.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.i(getView(), f.C0146f.addresslist_item_bg);
            this.dVa.onChangeSkinType(i);
            this.czb.onChangeSkinType();
            this.bHO.onChangeSkinType();
            am.j(this.bkJ, f.d.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_daily_normal_thread;
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
        this.buy = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwv);
        }
        this.dVa.setData(this.buy);
        K(this.buy);
        ArrayList<VoiceData.VoiceModel> vy = this.buy.vy();
        if (w.z(vy)) {
            this.cyY.setVisibility(8);
            ew(false);
        } else {
            this.cyY.setVisibility(0);
            ew(true);
            VoiceData.VoiceModel voiceModel = vy.get(0);
            this.cyY.setVoiceModel(voiceModel);
            this.cyY.setTag(voiceModel);
            this.cyY.aPq();
            if (voiceModel != null) {
                this.cyY.oH(voiceModel.voice_status.intValue());
            }
            this.cyY.bxq();
        }
        ArrayList<MediaData> vu = this.buy.vu();
        if (i.td().tj() && w.y(vu) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < vu.size(); i++) {
                MediaData mediaData = (MediaData) w.d(vu, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (w.y(linkedList) > 0) {
                this.czb.setVisibility(0);
                this.dTO.setVisibility(8);
                this.czb.setFromCDN(this.asS);
                this.czb.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> aiC = a.this.aiC();
                        if (aiC != null) {
                            view.setTag("1");
                            aiC.a(view, a.this.buy);
                        }
                        a.this.aiV();
                    }
                });
                this.czb.setImageMediaList(linkedList);
            } else {
                this.czb.setVisibility(8);
                this.dTO.setVisibility(0);
            }
        } else {
            this.czb.setVisibility(8);
            this.dTO.setVisibility(0);
        }
        this.bHO.ajY = this.currentPageType;
        this.bHO.setData(this.buy);
        axv();
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
            o.a(this.mTitle, bbVar.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (o.kZ(this.buy.getId())) {
            o.a(this.mTitle, this.buy.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        }
    }

    private void axv() {
        if (this.mTitle != null && this.cyY != null && this.czb != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cyY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(f.e.ds24);
            this.cyY.setLayoutParams(layoutParams);
            if (this.cyY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.czb.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(f.e.ds10);
                this.czb.setLayoutParams(layoutParams2);
            }
        }
    }

    private void ew(boolean z) {
        if (this.czb != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.czb.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds10);
            }
            this.czb.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiV() {
        if (this.buy != null) {
            o.kY(this.buy.getId());
            o.a(this.mTitle, this.buy.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.buy, null, this.mStType, 18005, true, false, false);
            if (this.buy.wK() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.buy.getFid()));
                createFromThreadCfg.setForumName(this.buy.vp());
            } else {
                createFromThreadCfg.setForumId(this.buy.wK().getForumId());
                createFromThreadCfg.setForumName(this.buy.wK().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int aDE() {
        if (this.dVa == null || this.dVa.getHeaderImg() == null) {
            return -1;
        }
        return this.dVa.getHeaderImg().getId();
    }

    public int aDF() {
        if (this.dVa == null || this.dVa.getForumName() == null) {
            return -1;
        }
        return this.dVa.getForumName().getId();
    }

    public int aDG() {
        if (this.dVa == null || this.dVa.getForumName() == null) {
            return -1;
        }
        return this.dVa.getForumName().getId();
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
