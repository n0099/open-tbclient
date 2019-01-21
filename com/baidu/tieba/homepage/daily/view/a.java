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
    private boolean aEU;
    private final View.OnClickListener aJb;
    private final View.OnClickListener aLT;
    private bb bOl;
    private View bzH;
    private View.OnClickListener cVV;
    private ConstrainImageGroup cYC;
    private final View.OnClickListener cYF;
    public PlayVoiceBntNew cYz;
    private ThreadCommentAndPraiseInfoLayout cby;
    private View euO;
    private ThreadForumUserInfoLayout evZ;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aEU = true;
        this.mStType = null;
        this.cVV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.bOl);
                }
                a.this.aqJ();
            }
        };
        this.cYF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> aqp = a.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, a.this.bOl);
                }
            }
        };
        this.aJb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.bOl);
                }
            }
        };
        this.aLT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.bOl);
                }
            }
        };
        View view = getView();
        this.evZ = (ThreadForumUserInfoLayout) view.findViewById(e.g.forum_user_info_layout);
        this.evZ.setForumAfterClickListener(this.aJb);
        this.evZ.setLikeButtonAfterClickListener(this.aLT);
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cYz = (PlayVoiceBntNew) view.findViewById(e.g.voice_button);
        this.cYz.setAfterClickListener(this.cYF);
        this.cYC = (ConstrainImageGroup) view.findViewById(e.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.cYC.setChildClickListener(this.cVV);
        this.cYC.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        eVar.da(false);
        this.cYC.setImageProcessor(eVar);
        this.euO = view.findViewById(e.g.no_image_divider_line);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_info_layout);
        this.cby.setOnClickListener(this.cVV);
        this.cby.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view2, a.this.bOl);
                }
                if (a.this.bOl != null) {
                    o.mW(a.this.bOl.getId());
                    a.this.aqu();
                }
            }
        });
        this.cby.setShowCommonView();
        this.bzH = view.findViewById(e.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cYC != null) {
            this.cYC.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYC != null) {
            this.cYC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYC != null) {
            this.cYC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.evZ != null) {
            this.evZ.setPageUniqueId(bdUniqueId);
        }
        if (this.cYC != null) {
            this.cYC.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            this.evZ.onChangeSkinType(i);
            this.cYC.onChangeSkinType();
            this.cby.onChangeSkinType();
            al.j(this.bzH, e.d.cp_bg_line_e);
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
        this.bOl = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVV);
        }
        this.evZ.setData(this.bOl);
        L(this.bOl);
        ArrayList<VoiceData.VoiceModel> Ai = this.bOl.Ai();
        if (v.I(Ai)) {
            this.cYz.setVisibility(8);
            fw(false);
        } else {
            this.cYz.setVisibility(0);
            fw(true);
            VoiceData.VoiceModel voiceModel = Ai.get(0);
            this.cYz.setVoiceModel(voiceModel);
            this.cYz.setTag(voiceModel);
            this.cYz.aXt();
            if (voiceModel != null) {
                this.cYz.qK(voiceModel.voice_status.intValue());
            }
            this.cYz.bGc();
        }
        ArrayList<MediaData> Ae = this.bOl.Ae();
        if (i.xR().xV() && v.H(Ae) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < Ae.size(); i++) {
                MediaData mediaData = (MediaData) v.d(Ae, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.H(linkedList) > 0) {
                this.cYC.setVisibility(0);
                this.euO.setVisibility(8);
                this.cYC.setFromCDN(this.aEU);
                this.cYC.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> aqp = a.this.aqp();
                        if (aqp != null) {
                            view.setTag("1");
                            aqp.a(view, a.this.bOl);
                        }
                        a.this.aqJ();
                    }
                });
                this.cYC.setImageMediaList(linkedList);
            } else {
                this.cYC.setVisibility(8);
                this.euO.setVisibility(0);
            }
        } else {
            this.cYC.setVisibility(8);
            this.euO.setVisibility(0);
        }
        this.cby.awp = this.currentPageType;
        this.cby.setData(this.bOl);
        aFv();
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
    public void aqu() {
        if (o.mX(this.bOl.getId())) {
            o.a(this.mTitle, this.bOl.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void aFv() {
        if (this.mTitle != null && this.cYz != null && this.cYC != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYz.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
            this.cYz.setLayoutParams(layoutParams);
            if (this.cYz.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYC.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                this.cYC.setLayoutParams(layoutParams2);
            }
        }
    }

    private void fw(boolean z) {
        if (this.cYC != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYC.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10);
            }
            this.cYC.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqJ() {
        if (this.bOl != null) {
            o.mW(this.bOl.getId());
            o.a(this.mTitle, this.bOl.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bOl, null, this.mStType, 18005, true, false, false);
            if (this.bOl.By() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bOl.getFid()));
                createFromThreadCfg.setForumName(this.bOl.zZ());
            } else {
                createFromThreadCfg.setForumId(this.bOl.By().getForumId());
                createFromThreadCfg.setForumName(this.bOl.By().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int aLL() {
        if (this.evZ == null || this.evZ.getHeaderImg() == null) {
            return -1;
        }
        return this.evZ.getHeaderImg().getId();
    }

    public int aLM() {
        if (this.evZ == null || this.evZ.getForumName() == null) {
            return -1;
        }
        return this.evZ.getForumName().getId();
    }

    public int aLN() {
        if (this.evZ == null || this.evZ.getForumName() == null) {
            return -1;
        }
        return this.evZ.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.cby != null) {
            this.cby.setShareReportFrom(i);
        }
    }

    public void oB(int i) {
        if (this.cby != null) {
            this.cby.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.cby != null) {
            this.cby.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
