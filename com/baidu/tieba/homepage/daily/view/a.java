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
    private boolean aET;
    private final View.OnClickListener aJa;
    private final View.OnClickListener aLS;
    private bb bOk;
    private View bzG;
    private View.OnClickListener cVU;
    private ConstrainImageGroup cYB;
    private final View.OnClickListener cYE;
    public PlayVoiceBntNew cYy;
    private ThreadCommentAndPraiseInfoLayout cbx;
    private View euN;
    private ThreadForumUserInfoLayout evY;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aET = true;
        this.mStType = null;
        this.cVU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.bOk);
                }
                a.this.aqJ();
            }
        };
        this.cYE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> aqp = a.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, a.this.bOk);
                }
            }
        };
        this.aJa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.bOk);
                }
            }
        };
        this.aLS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view, a.this.bOk);
                }
            }
        };
        View view = getView();
        this.evY = (ThreadForumUserInfoLayout) view.findViewById(e.g.forum_user_info_layout);
        this.evY.setForumAfterClickListener(this.aJa);
        this.evY.setLikeButtonAfterClickListener(this.aLS);
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cYy = (PlayVoiceBntNew) view.findViewById(e.g.voice_button);
        this.cYy.setAfterClickListener(this.cYE);
        this.cYB = (ConstrainImageGroup) view.findViewById(e.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.cYB.setChildClickListener(this.cVU);
        this.cYB.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        eVar.da(false);
        this.cYB.setImageProcessor(eVar);
        this.euN = view.findViewById(e.g.no_image_divider_line);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_info_layout);
        this.cbx.setOnClickListener(this.cVU);
        this.cbx.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aqp() != null) {
                    a.this.aqp().a(view2, a.this.bOk);
                }
                if (a.this.bOk != null) {
                    o.mW(a.this.bOk.getId());
                    a.this.aqu();
                }
            }
        });
        this.cbx.setShowCommonView();
        this.bzG = view.findViewById(e.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cYB != null) {
            this.cYB.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYB != null) {
            this.cYB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYB != null) {
            this.cYB.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.evY != null) {
            this.evY.setPageUniqueId(bdUniqueId);
        }
        if (this.cYB != null) {
            this.cYB.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            this.evY.onChangeSkinType(i);
            this.cYB.onChangeSkinType();
            this.cbx.onChangeSkinType();
            al.j(this.bzG, e.d.cp_bg_line_e);
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
        this.bOk = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVU);
        }
        this.evY.setData(this.bOk);
        L(this.bOk);
        ArrayList<VoiceData.VoiceModel> Ai = this.bOk.Ai();
        if (v.I(Ai)) {
            this.cYy.setVisibility(8);
            fw(false);
        } else {
            this.cYy.setVisibility(0);
            fw(true);
            VoiceData.VoiceModel voiceModel = Ai.get(0);
            this.cYy.setVoiceModel(voiceModel);
            this.cYy.setTag(voiceModel);
            this.cYy.aXt();
            if (voiceModel != null) {
                this.cYy.qK(voiceModel.voice_status.intValue());
            }
            this.cYy.bGc();
        }
        ArrayList<MediaData> Ae = this.bOk.Ae();
        if (i.xR().xV() && v.H(Ae) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < Ae.size(); i++) {
                MediaData mediaData = (MediaData) v.d(Ae, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.H(linkedList) > 0) {
                this.cYB.setVisibility(0);
                this.euN.setVisibility(8);
                this.cYB.setFromCDN(this.aET);
                this.cYB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> aqp = a.this.aqp();
                        if (aqp != null) {
                            view.setTag("1");
                            aqp.a(view, a.this.bOk);
                        }
                        a.this.aqJ();
                    }
                });
                this.cYB.setImageMediaList(linkedList);
            } else {
                this.cYB.setVisibility(8);
                this.euN.setVisibility(0);
            }
        } else {
            this.cYB.setVisibility(8);
            this.euN.setVisibility(0);
        }
        this.cbx.awo = this.currentPageType;
        this.cbx.setData(this.bOk);
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
        if (o.mX(this.bOk.getId())) {
            o.a(this.mTitle, this.bOk.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void aFv() {
        if (this.mTitle != null && this.cYy != null && this.cYB != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYy.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
            this.cYy.setLayoutParams(layoutParams);
            if (this.cYy.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYB.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                this.cYB.setLayoutParams(layoutParams2);
            }
        }
    }

    private void fw(boolean z) {
        if (this.cYB != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYB.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10);
            }
            this.cYB.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqJ() {
        if (this.bOk != null) {
            o.mW(this.bOk.getId());
            o.a(this.mTitle, this.bOk.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bOk, null, this.mStType, 18005, true, false, false);
            if (this.bOk.By() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bOk.getFid()));
                createFromThreadCfg.setForumName(this.bOk.zZ());
            } else {
                createFromThreadCfg.setForumId(this.bOk.By().getForumId());
                createFromThreadCfg.setForumName(this.bOk.By().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int aLL() {
        if (this.evY == null || this.evY.getHeaderImg() == null) {
            return -1;
        }
        return this.evY.getHeaderImg().getId();
    }

    public int aLM() {
        if (this.evY == null || this.evY.getForumName() == null) {
            return -1;
        }
        return this.evY.getForumName().getId();
    }

    public int aLN() {
        if (this.evY == null || this.evY.getForumName() == null) {
            return -1;
        }
        return this.evY.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.cbx != null) {
            this.cbx.setShareReportFrom(i);
        }
    }

    public void oB(int i) {
        if (this.cbx != null) {
            this.cbx.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.cbx != null) {
            this.cbx.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
