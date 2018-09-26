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
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bb> {
    private final View.OnClickListener aCs;
    private boolean avq;
    private final View.OnClickListener azz;
    private bb bAn;
    private ThreadCommentAndPraiseInfoLayout bND;
    private View bqy;
    private View.OnClickListener cCl;
    public PlayVoiceBntNew cEQ;
    private ConstrainImageGroup cET;
    private final View.OnClickListener cEW;
    private View ebh;
    private ThreadForumUserInfoLayout ect;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.avq = true;
        this.mStType = null;
        this.cCl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akm() != null) {
                    a.this.akm().a(view, a.this.bAn);
                }
                a.this.akG();
            }
        };
        this.cEW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> akm = a.this.akm();
                if (akm != null) {
                    view.setTag("2");
                    akm.a(view, a.this.bAn);
                }
            }
        };
        this.azz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akm() != null) {
                    a.this.akm().a(view, a.this.bAn);
                }
            }
        };
        this.aCs = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.akm() != null) {
                    a.this.akm().a(view, a.this.bAn);
                }
            }
        };
        View view = getView();
        this.ect = (ThreadForumUserInfoLayout) view.findViewById(e.g.forum_user_info_layout);
        this.ect.setForumAfterClickListener(this.azz);
        this.ect.setLikeButtonAfterClickListener(this.aCs);
        this.mTitle = (TextView) view.findViewById(e.g.thread_title);
        this.cEQ = (PlayVoiceBntNew) view.findViewById(e.g.voice_button);
        this.cEQ.setAfterClickListener(this.cEW);
        this.cET = (ConstrainImageGroup) view.findViewById(e.g.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds16);
        this.cET.setChildClickListener(this.cCl);
        this.cET.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        eVar.cw(false);
        this.cET.setImageProcessor(eVar);
        this.ebh = view.findViewById(e.g.no_image_divider_line);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.thread_comment_info_layout);
        this.bND.setOnClickListener(this.cCl);
        this.bND.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.akm() != null) {
                    a.this.akm().a(view2, a.this.bAn);
                }
                if (a.this.bAn != null) {
                    o.lA(a.this.bAn.getId());
                    a.this.akr();
                }
            }
        });
        this.bND.setShowCommonView();
        this.bqy = view.findViewById(e.g.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cET != null) {
            this.cET.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cET != null) {
            this.cET.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cET != null) {
            this.cET.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ect != null) {
            this.ect.setPageUniqueId(bdUniqueId);
        }
        if (this.cET != null) {
            this.cET.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            this.ect.onChangeSkinType(i);
            this.cET.onChangeSkinType();
            this.bND.onChangeSkinType();
            al.j(this.bqy, e.d.cp_bg_line_e);
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
        this.bAn = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cCl);
        }
        this.ect.setData(this.bAn);
        L(this.bAn);
        ArrayList<VoiceData.VoiceModel> wB = this.bAn.wB();
        if (v.z(wB)) {
            this.cEQ.setVisibility(8);
            eN(false);
        } else {
            this.cEQ.setVisibility(0);
            eN(true);
            VoiceData.VoiceModel voiceModel = wB.get(0);
            this.cEQ.setVoiceModel(voiceModel);
            this.cEQ.setTag(voiceModel);
            this.cEQ.aRD();
            if (voiceModel != null) {
                this.cEQ.pl(voiceModel.voice_status.intValue());
            }
            this.cEQ.bzY();
        }
        ArrayList<MediaData> wx = this.bAn.wx();
        if (i.uj().un() && v.y(wx) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < wx.size(); i++) {
                MediaData mediaData = (MediaData) v.d(wx, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.y(linkedList) > 0) {
                this.cET.setVisibility(0);
                this.ebh.setVisibility(8);
                this.cET.setFromCDN(this.avq);
                this.cET.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> akm = a.this.akm();
                        if (akm != null) {
                            view.setTag("1");
                            akm.a(view, a.this.bAn);
                        }
                        a.this.akG();
                    }
                });
                this.cET.setImageMediaList(linkedList);
            } else {
                this.cET.setVisibility(8);
                this.ebh.setVisibility(0);
            }
        } else {
            this.cET.setVisibility(8);
            this.ebh.setVisibility(0);
        }
        this.bND.amD = this.currentPageType;
        this.bND.setData(this.bAn);
        azJ();
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
    public void akr() {
        if (o.lB(this.bAn.getId())) {
            o.a(this.mTitle, this.bAn.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void azJ() {
        if (this.mTitle != null && this.cEQ != null && this.cET != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cEQ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds24);
            this.cEQ.setLayoutParams(layoutParams);
            if (this.cEQ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cET.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds10);
                this.cET.setLayoutParams(layoutParams2);
            }
        }
    }

    private void eN(boolean z) {
        if (this.cET != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cET.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds10);
            }
            this.cET.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akG() {
        if (this.bAn != null) {
            o.lA(this.bAn.getId());
            o.a(this.mTitle, this.bAn.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bAn, null, this.mStType, 18005, true, false, false);
            if (this.bAn.xR() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bAn.getFid()));
                createFromThreadCfg.setForumName(this.bAn.ws());
            } else {
                createFromThreadCfg.setForumId(this.bAn.xR().getForumId());
                createFromThreadCfg.setForumName(this.bAn.xR().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int aFR() {
        if (this.ect == null || this.ect.getHeaderImg() == null) {
            return -1;
        }
        return this.ect.getHeaderImg().getId();
    }

    public int aFS() {
        if (this.ect == null || this.ect.getForumName() == null) {
            return -1;
        }
        return this.ect.getForumName().getId();
    }

    public int aFT() {
        if (this.ect == null || this.ect.getForumName() == null) {
            return -1;
        }
        return this.ect.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.bND != null) {
            this.bND.setShareReportFrom(i);
        }
    }

    public void nd(int i) {
        if (this.bND != null) {
            this.bND.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.bND != null) {
            this.bND.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
