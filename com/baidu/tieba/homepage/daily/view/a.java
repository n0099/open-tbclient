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
    private boolean aEr;
    private final View.OnClickListener aIy;
    private final View.OnClickListener aLq;
    private bb bNy;
    private View byS;
    private View.OnClickListener cVj;
    public PlayVoiceBntNew cXN;
    private ConstrainImageGroup cXQ;
    private final View.OnClickListener cXT;
    private ThreadCommentAndPraiseInfoLayout caM;
    private View euh;
    private ThreadForumUserInfoLayout evs;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aEr = true;
        this.mStType = null;
        this.cVj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apS() != null) {
                    a.this.apS().a(view, a.this.bNy);
                }
                a.this.aqm();
            }
        };
        this.cXT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> apS = a.this.apS();
                if (apS != null) {
                    view.setTag("2");
                    apS.a(view, a.this.bNy);
                }
            }
        };
        this.aIy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apS() != null) {
                    a.this.apS().a(view, a.this.bNy);
                }
            }
        };
        this.aLq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.apS() != null) {
                    a.this.apS().a(view, a.this.bNy);
                }
            }
        };
        View view = getView();
        this.evs = (ThreadForumUserInfoLayout) view.findViewById(e.g.forum_user_info_layout);
        this.evs.setForumAfterClickListener(this.aIy);
        this.evs.setLikeButtonAfterClickListener(this.aLq);
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cXN = (PlayVoiceBntNew) view.findViewById(e.g.voice_button);
        this.cXN.setAfterClickListener(this.cXT);
        this.cXQ = (ConstrainImageGroup) view.findViewById(e.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.cXQ.setChildClickListener(this.cVj);
        this.cXQ.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        eVar.cX(false);
        this.cXQ.setImageProcessor(eVar);
        this.euh = view.findViewById(e.g.no_image_divider_line);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_info_layout);
        this.caM.setOnClickListener(this.cVj);
        this.caM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.apS() != null) {
                    a.this.apS().a(view2, a.this.bNy);
                }
                if (a.this.bNy != null) {
                    o.mG(a.this.bNy.getId());
                    a.this.apX();
                }
            }
        });
        this.caM.setShowCommonView();
        this.byS = view.findViewById(e.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cXQ != null) {
            this.cXQ.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cXQ != null) {
            this.cXQ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cXQ != null) {
            this.cXQ.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.evs != null) {
            this.evs.setPageUniqueId(bdUniqueId);
        }
        if (this.cXQ != null) {
            this.cXQ.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            this.evs.onChangeSkinType(i);
            this.cXQ.onChangeSkinType();
            this.caM.onChangeSkinType();
            al.j(this.byS, e.d.cp_bg_line_e);
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
        this.bNy = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVj);
        }
        this.evs.setData(this.bNy);
        L(this.bNy);
        ArrayList<VoiceData.VoiceModel> zV = this.bNy.zV();
        if (v.I(zV)) {
            this.cXN.setVisibility(8);
            ft(false);
        } else {
            this.cXN.setVisibility(0);
            ft(true);
            VoiceData.VoiceModel voiceModel = zV.get(0);
            this.cXN.setVoiceModel(voiceModel);
            this.cXN.setTag(voiceModel);
            this.cXN.aWT();
            if (voiceModel != null) {
                this.cXN.qJ(voiceModel.voice_status.intValue());
            }
            this.cXN.bFt();
        }
        ArrayList<MediaData> zR = this.bNy.zR();
        if (i.xE().xI() && v.H(zR) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < zR.size(); i++) {
                MediaData mediaData = (MediaData) v.d(zR, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.H(linkedList) > 0) {
                this.cXQ.setVisibility(0);
                this.euh.setVisibility(8);
                this.cXQ.setFromCDN(this.aEr);
                this.cXQ.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> apS = a.this.apS();
                        if (apS != null) {
                            view.setTag("1");
                            apS.a(view, a.this.bNy);
                        }
                        a.this.aqm();
                    }
                });
                this.cXQ.setImageMediaList(linkedList);
            } else {
                this.cXQ.setVisibility(8);
                this.euh.setVisibility(0);
            }
        } else {
            this.cXQ.setVisibility(8);
            this.euh.setVisibility(0);
        }
        this.caM.avM = this.currentPageType;
        this.caM.setData(this.bNy);
        aEY();
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
    public void apX() {
        if (o.mH(this.bNy.getId())) {
            o.a(this.mTitle, this.bNy.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void aEY() {
        if (this.mTitle != null && this.cXN != null && this.cXQ != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXN.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
            this.cXN.setLayoutParams(layoutParams);
            if (this.cXN.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cXQ.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                this.cXQ.setLayoutParams(layoutParams2);
            }
        }
    }

    private void ft(boolean z) {
        if (this.cXQ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXQ.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10);
            }
            this.cXQ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqm() {
        if (this.bNy != null) {
            o.mG(this.bNy.getId());
            o.a(this.mTitle, this.bNy.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bNy, null, this.mStType, 18005, true, false, false);
            if (this.bNy.Bl() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bNy.getFid()));
                createFromThreadCfg.setForumName(this.bNy.zM());
            } else {
                createFromThreadCfg.setForumId(this.bNy.Bl().getForumId());
                createFromThreadCfg.setForumName(this.bNy.Bl().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int aLn() {
        if (this.evs == null || this.evs.getHeaderImg() == null) {
            return -1;
        }
        return this.evs.getHeaderImg().getId();
    }

    public int aLo() {
        if (this.evs == null || this.evs.getForumName() == null) {
            return -1;
        }
        return this.evs.getForumName().getId();
    }

    public int aLp() {
        if (this.evs == null || this.evs.getForumName() == null) {
            return -1;
        }
        return this.evs.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.caM != null) {
            this.caM.setShareReportFrom(i);
        }
    }

    public void oA(int i) {
        if (this.caM != null) {
            this.caM.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.caM != null) {
            this.caM.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
