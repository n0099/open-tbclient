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
    private final View.OnClickListener aEh;
    private final View.OnClickListener aGY;
    private bb bIV;
    private ThreadCommentAndPraiseInfoLayout bWf;
    public FrameLayout bkB;
    private TextView bkC;
    private TbImageView bkD;
    private ImageView bkE;
    private TextView bkK;
    private TbImageView.a bkM;
    private View buH;
    private TextView cMV;
    private LinearLayout ejd;
    private ThreadForumUserInfoLayout ekn;
    private View ekt;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.bkM = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && c.this.bkD != null) {
                    c.this.bkD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anP() != null) {
                    c.this.anP().a(view, c.this.bIV);
                }
            }
        };
        this.aGY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anP() != null) {
                    c.this.anP().a(view, c.this.bIV);
                }
            }
        };
        this.ekt = getView();
        this.ekn = (ThreadForumUserInfoLayout) this.ekt.findViewById(e.g.forum_user_info_layout);
        this.ekn.setForumAfterClickListener(this.aEh);
        this.ekn.setLikeButtonAfterClickListener(this.aGY);
        this.ejd = (LinearLayout) this.ekt.findViewById(e.g.video_card_content_layout);
        this.mTitle = (TextView) this.ekt.findViewById(e.g.thread_title);
        this.bkB = (FrameLayout) this.ekt.findViewById(e.g.frame_video);
        this.bkB.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkB.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), e.C0175e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.bkB.setLayoutParams(layoutParams);
        this.bkD = (TbImageView) this.ekt.findViewById(e.g.image_video);
        this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bkD.setGifIconSupport(false);
        this.bkD.setEvent(this.bkM);
        this.bkE = (ImageView) this.ekt.findViewById(e.g.image_video_play);
        this.bkC = (TextView) this.ekt.findViewById(e.g.text_video_duration);
        this.bkK = (TextView) this.ekt.findViewById(e.g.text_video_play_count);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) this.ekt.findViewById(e.g.thread_comment_info_layout);
        this.bWf.setOnClickListener(this);
        this.bWf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anP() != null) {
                    c.this.anP().a(view, c.this.bIV);
                }
                if (c.this.bIV != null) {
                    o.md(c.this.bIV.getId());
                    c.this.anU();
                }
            }
        });
        this.bWf.setShowCommonView();
        this.buH = this.ekt.findViewById(e.g.divider_line);
        this.cMV = (TextView) this.ekt.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ekn != null) {
            this.ekn.setPageUniqueId(bdUniqueId);
        }
        if (this.bkD != null) {
            this.bkD.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.ekt, e.f.addresslist_item_bg);
            al.c(this.bkE, e.f.btn_icon_play_video_n);
            al.i(this.buH, e.d.cp_bg_line_e);
            al.h(this.bkC, e.d.cp_cont_i);
            al.h(this.bkK, e.d.cp_cont_i);
            this.ekn.onChangeSkinType(i);
            this.bWf.onChangeSkinType();
            al.h(this.cMV, e.d.cp_cont_i);
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
        if (bbVar == null || bbVar.yv() == null || bbVar.yN() == null) {
            this.ekt.setVisibility(8);
            return;
        }
        this.bIV = bbVar;
        this.ekt.setVisibility(0);
        this.ekt.setOnClickListener(this);
        this.ekn.setData(this.bIV);
        L(bbVar);
        aod();
        this.bkC.setText(ao.dt(this.bIV.yN().video_duration.intValue() * 1000));
        this.bkK.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.N(this.bIV.yN().play_count.intValue())));
        this.bWf.ary = this.currentPageType;
        this.bWf.setData(this.bIV);
        if (this.bIV == null || this.bIV.yN() == null) {
            z = false;
        } else if (this.bIV.yN().is_vertical.intValue() != 1) {
            z = false;
        }
        this.cMV.setVisibility(z ? 0 : 8);
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean L(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        bbVar.zf();
        SpannableStringBuilder yV = bbVar.yV();
        if (bbVar.zc() && !StringUtils.isNull(bbVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
            yV.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
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
        this.mTitle.setOnTouchListener(new k(yV));
        this.mTitle.setText(yV);
        o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anU() {
        if (o.me(this.bIV.getId())) {
            o.a(this.mTitle, this.bIV.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void aod() {
        if (this.bkD != null && this.bkB != null) {
            if (i.ws().ww() && this.bIV != null && this.bIV.yN() != null) {
                this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bkD.startLoad(this.bIV.yN().thumbnail_url, 10, false);
                this.bkB.setVisibility(0);
                return;
            }
            this.bkB.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.ekt) {
            aA(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bkB) {
            if (this.bIV != null && this.bIV.yN() != null) {
                z = this.bIV.yN().is_vertical.intValue() == 1;
            }
            if (z) {
                ay(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aL(getView());
            } else {
                aA(getView());
            }
        }
    }

    private void ay(View view) {
        if (anP() != null) {
            anP().a(view, this.bIV);
        }
        if (!j.kX()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            anZ();
        }
    }

    private void anZ() {
        if (this.bIV != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bIV);
            if (this.bIV.Aa() == null) {
                videoItemData.forum_id = String.valueOf(this.bIV.getFid());
                videoItemData.forum_name = this.bIV.yB();
            } else {
                videoItemData.forum_id = this.bIV.Aa().getForumId();
                videoItemData.forum_name = this.bIV.Aa().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void aA(View view) {
        if (anP() != null) {
            anP().a(view, this.bIV);
        }
        if (this.bIV != null) {
            o.md(this.bIV.getId());
            o.a(this.mTitle, this.bIV.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bIV, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bIV.Aa() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bIV.getFid()));
                createFromThreadCfg.setForumName(this.bIV.yB());
            } else {
                createFromThreadCfg.setForumId(this.bIV.Aa().getForumId());
                createFromThreadCfg.setForumName(this.bIV.Aa().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void aL(View view) {
        if (anP() != null) {
            anP().a(view, this.bIV);
        }
        if (!j.kX()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aoa();
        }
    }

    private void aoa() {
        if (this.bIV != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bIV);
            videoSerializeVideoThreadInfo.forumId = this.bIV.Aa() != null ? this.bIV.Aa().getForumId() : String.valueOf(this.bIV.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bkD.getX() + this.ejd.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bkD.getY() + this.ejd.getY());
            videoCardViewInfo.cardViewWidth = this.bkD.getWidth();
            videoCardViewInfo.cardViewHeight = this.bkD.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bIV.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int aJj() {
        if (this.ekn == null || this.ekn.getHeaderImg() == null) {
            return -1;
        }
        return this.ekn.getHeaderImg().getId();
    }

    public int aJk() {
        if (this.ekn == null || this.ekn.getForumName() == null) {
            return -1;
        }
        return this.ekn.getForumName().getId();
    }

    public int aJl() {
        if (this.ekn == null || this.ekn.getForumName() == null) {
            return -1;
        }
        return this.ekn.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.bWf != null) {
            this.bWf.setShareReportFrom(i);
        }
    }

    public void nB(int i) {
        if (this.bWf != null) {
            this.bWf.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.bWf != null) {
            this.bWf.setStType(str);
        }
    }
}
