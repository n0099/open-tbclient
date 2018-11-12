package com.baidu.tieba.homepage.daily.view;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<bb> {
    private final View.OnClickListener aEX;
    private final View.OnClickListener aHO;
    private bb bJG;
    private ThreadCommentAndPraiseInfoLayout bWR;
    public FrameLayout blm;
    private TextView bln;
    private TbImageView blo;
    private ImageView blp;
    private TextView blv;
    private TbImageView.a blx;
    private View bvs;
    private TextView cOb;
    private LinearLayout ekx;
    private ThreadForumUserInfoLayout elG;
    private View elM;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.blx = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && c.this.blo != null) {
                    c.this.blo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, c.this.bJG);
                }
            }
        };
        this.aHO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, c.this.bJG);
                }
            }
        };
        this.elM = getView();
        this.elG = (ThreadForumUserInfoLayout) this.elM.findViewById(e.g.forum_user_info_layout);
        this.elG.setForumAfterClickListener(this.aEX);
        this.elG.setLikeButtonAfterClickListener(this.aHO);
        this.ekx = (LinearLayout) this.elM.findViewById(e.g.video_card_content_layout);
        this.mTitle = (TextView) this.elM.findViewById(e.g.thread_title);
        this.blm = (FrameLayout) this.elM.findViewById(e.g.frame_video);
        this.blm.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blm.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), e.C0200e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.blm.setLayoutParams(layoutParams);
        this.blo = (TbImageView) this.elM.findViewById(e.g.image_video);
        this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.blo.setGifIconSupport(false);
        this.blo.setEvent(this.blx);
        this.blp = (ImageView) this.elM.findViewById(e.g.image_video_play);
        this.bln = (TextView) this.elM.findViewById(e.g.text_video_duration);
        this.blv = (TextView) this.elM.findViewById(e.g.text_video_play_count);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) this.elM.findViewById(e.g.thread_comment_info_layout);
        this.bWR.setOnClickListener(this);
        this.bWR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, c.this.bJG);
                }
                if (c.this.bJG != null) {
                    o.me(c.this.bJG.getId());
                    c.this.anv();
                }
            }
        });
        this.bWR.setShowCommonView();
        this.bvs = this.elM.findViewById(e.g.divider_line);
        this.cOb = (TextView) this.elM.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.elG != null) {
            this.elG.setPageUniqueId(bdUniqueId);
        }
        if (this.blo != null) {
            this.blo.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.elM, e.f.addresslist_item_bg);
            al.c(this.blp, e.f.btn_icon_play_video_n);
            al.i(this.bvs, e.d.cp_bg_line_e);
            al.h(this.bln, e.d.cp_cont_i);
            al.h(this.blv, e.d.cp_cont_i);
            this.elG.onChangeSkinType(i);
            this.bWR.onChangeSkinType();
            al.h(this.cOb, e.d.cp_cont_i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_daily_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        boolean z = true;
        if (bbVar == null || bbVar.yC() == null || bbVar.yU() == null) {
            this.elM.setVisibility(8);
            return;
        }
        this.bJG = bbVar;
        this.elM.setVisibility(0);
        this.elM.setOnClickListener(this);
        this.elG.setData(this.bJG);
        L(bbVar);
        anE();
        this.bln.setText(ao.dH(this.bJG.yU().video_duration.intValue() * 1000));
        this.blv.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.P(this.bJG.yU().play_count.intValue())));
        this.bWR.asl = this.currentPageType;
        this.bWR.setData(this.bJG);
        if (this.bJG == null || this.bJG.yU() == null) {
            z = false;
        } else if (this.bJG.yU().is_vertical.intValue() != 1) {
            z = false;
        }
        this.cOb.setVisibility(z ? 0 : 8);
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean L(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        bbVar.zm();
        SpannableStringBuilder zc = bbVar.zc();
        if (bbVar.zj() && !StringUtils.isNull(bbVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
            zc.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(zc));
        this.mTitle.setText(zc);
        o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anv() {
        if (o.mf(this.bJG.getId())) {
            o.a(this.mTitle, this.bJG.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void anE() {
        if (this.blo != null && this.blm != null) {
            if (i.wA().wE() && this.bJG != null && this.bJG.yU() != null) {
                this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.blo.startLoad(this.bJG.yU().thumbnail_url, 10, false);
                this.blm.setVisibility(0);
                return;
            }
            this.blm.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.elM) {
            aC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.blm) {
            if (this.bJG != null && this.bJG.yU() != null) {
                z = this.bJG.yU().is_vertical.intValue() == 1;
            }
            if (z) {
                aA(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aN(getView());
            } else {
                aC(getView());
            }
        }
    }

    private void aA(View view) {
        if (anq() != null) {
            anq().a(view, this.bJG);
        }
        if (!j.kV()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anA();
        }
    }

    private void anA() {
        if (this.bJG != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bJG);
            if (this.bJG.Ah() == null) {
                videoItemData.forum_id = String.valueOf(this.bJG.getFid());
                videoItemData.forum_name = this.bJG.yI();
            } else {
                videoItemData.forum_id = this.bJG.Ah().getForumId();
                videoItemData.forum_name = this.bJG.Ah().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void aC(View view) {
        if (anq() != null) {
            anq().a(view, this.bJG);
        }
        if (this.bJG != null) {
            o.me(this.bJG.getId());
            o.a(this.mTitle, this.bJG.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bJG, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bJG.Ah() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bJG.getFid()));
                createFromThreadCfg.setForumName(this.bJG.yI());
            } else {
                createFromThreadCfg.setForumId(this.bJG.Ah().getForumId());
                createFromThreadCfg.setForumName(this.bJG.Ah().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void aN(View view) {
        if (anq() != null) {
            anq().a(view, this.bJG);
        }
        if (!j.kV()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anB();
        }
    }

    private void anB() {
        if (this.bJG != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bJG);
            videoSerializeVideoThreadInfo.forumId = this.bJG.Ah() != null ? this.bJG.Ah().getForumId() : String.valueOf(this.bJG.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.blo.getX() + this.ekx.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.blo.getY() + this.ekx.getY());
            videoCardViewInfo.cardViewWidth = this.blo.getWidth();
            videoCardViewInfo.cardViewHeight = this.blo.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bJG.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int aIH() {
        if (this.elG == null || this.elG.getHeaderImg() == null) {
            return -1;
        }
        return this.elG.getHeaderImg().getId();
    }

    public int aII() {
        if (this.elG == null || this.elG.getForumName() == null) {
            return -1;
        }
        return this.elG.getForumName().getId();
    }

    public int aIJ() {
        if (this.elG == null || this.elG.getForumName() == null) {
            return -1;
        }
        return this.elG.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.bWR != null) {
            this.bWR.setShareReportFrom(i);
        }
    }

    public void nT(int i) {
        if (this.bWR != null) {
            this.bWR.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.bWR != null) {
            this.bWR.setStType(str);
        }
    }
}
