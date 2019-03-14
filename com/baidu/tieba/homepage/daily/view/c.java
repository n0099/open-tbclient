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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<bg> {
    private final View.OnClickListener bRz;
    private bg bTl;
    private final View.OnClickListener bUt;
    public FrameLayout cAb;
    private TextView cAc;
    private TbImageView cAd;
    private ImageView cAe;
    private TextView cAj;
    private TbImageView.a cAl;
    private View cKK;
    private ThreadCommentAndPraiseInfoLayout dqv;
    private TextView ehV;
    private LinearLayout fHn;
    private View fIF;
    private ThreadForumUserInfoLayout fIz;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.cAl = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && c.this.cAd != null) {
                    c.this.cAd.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bRz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQh() != null) {
                    c.this.aQh().a(view, c.this.bTl);
                }
            }
        };
        this.bUt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQh() != null) {
                    c.this.aQh().a(view, c.this.bTl);
                }
            }
        };
        this.fIF = getView();
        this.fIz = (ThreadForumUserInfoLayout) this.fIF.findViewById(d.g.forum_user_info_layout);
        this.fIz.setForumAfterClickListener(this.bRz);
        this.fIz.setLikeButtonAfterClickListener(this.bUt);
        this.fHn = (LinearLayout) this.fIF.findViewById(d.g.video_card_content_layout);
        this.mTitle = (TextView) this.fIF.findViewById(d.g.thread_title);
        this.cAb = (FrameLayout) this.fIF.findViewById(d.g.frame_video);
        this.cAb.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAb.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cAb.setLayoutParams(layoutParams);
        this.cAd = (TbImageView) this.fIF.findViewById(d.g.image_video);
        this.cAd.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAd.setGifIconSupport(false);
        this.cAd.setEvent(this.cAl);
        this.cAe = (ImageView) this.fIF.findViewById(d.g.image_video_play);
        this.cAc = (TextView) this.fIF.findViewById(d.g.text_video_duration);
        this.cAj = (TextView) this.fIF.findViewById(d.g.text_video_play_count);
        this.dqv = (ThreadCommentAndPraiseInfoLayout) this.fIF.findViewById(d.g.thread_comment_info_layout);
        this.dqv.setOnClickListener(this);
        this.dqv.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQh() != null) {
                    c.this.aQh().a(view, c.this.bTl);
                }
                if (c.this.bTl != null) {
                    n.tA(c.this.bTl.getId());
                    c.this.blA();
                }
            }
        });
        this.dqv.setShowCommonView();
        this.cKK = this.fIF.findViewById(d.g.divider_line);
        this.ehV = (TextView) this.fIF.findViewById(d.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fIz != null) {
            this.fIz.setPageUniqueId(bdUniqueId);
        }
        if (this.cAd != null) {
            this.cAd.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.fIF, d.f.addresslist_item_bg);
            al.c(this.cAe, d.f.btn_icon_play_video_n);
            al.k(this.cKK, d.C0277d.cp_bg_line_e);
            al.j(this.cAc, d.C0277d.cp_btn_a);
            al.j(this.cAj, d.C0277d.cp_btn_a);
            this.fIz.onChangeSkinType(i);
            this.dqv.onChangeSkinType();
            al.j(this.ehV, d.C0277d.cp_btn_a);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_daily_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bg bgVar) {
        boolean z = true;
        if (bgVar == null || bgVar.YR() == null || bgVar.Zi() == null) {
            this.fIF.setVisibility(8);
            return;
        }
        this.bTl = bgVar;
        this.fIF.setVisibility(0);
        this.fIF.setOnClickListener(this);
        this.fIz.setData(this.bTl);
        ah(bgVar);
        aQv();
        this.cAc.setText(ap.hz(this.bTl.Zi().video_duration.intValue() * 1000));
        this.cAj.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.bTl.Zi().play_count.intValue())));
        this.dqv.bSH = this.currentPageType;
        this.dqv.setData(this.bTl);
        if (this.bTl == null || this.bTl.Zi() == null) {
            z = false;
        } else if (this.bTl.Zi().is_vertical.intValue() != 1) {
            z = false;
        }
        this.ehV.setVisibility(z ? 0 : 8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ah(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        bgVar.ZH();
        SpannableStringBuilder Zx = bgVar.Zx();
        if (bgVar.ZE() && !StringUtils.isNull(bgVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bgVar.getTid();
            Zx.append((CharSequence) bgVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0277d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(Zx));
        this.mTitle.setText(Zx);
        n.a(this.mTitle, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blA() {
        if (n.tB(this.bTl.getId())) {
            n.a(this.mTitle, this.bTl.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
    }

    private void aQv() {
        if (this.cAd != null && this.cAb != null) {
            if (i.Wy().WC() && this.bTl != null && this.bTl.Zi() != null) {
                this.cAd.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAd.startLoad(this.bTl.Zi().thumbnail_url, 10, false);
                this.cAb.setVisibility(0);
                return;
            }
            this.cAb.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fIF) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cAb) {
            if (this.bTl != null && this.bTl.Zi() != null) {
                z = this.bTl.Zi().is_vertical.intValue() == 1;
            }
            if (z) {
                bx(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bI(getView());
            } else {
                bz(getView());
            }
        }
    }

    private void bx(View view) {
        if (aQh() != null) {
            aQh().a(view, this.bTl);
        }
        if (!j.kY()) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQp();
        }
    }

    private void aQp() {
        if (this.bTl != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bTl);
            if (this.bTl.aaE() == null) {
                videoItemData.forum_id = String.valueOf(this.bTl.getFid());
                videoItemData.forum_name = this.bTl.YW();
            } else {
                videoItemData.forum_id = this.bTl.aaE().getForumId();
                videoItemData.forum_name = this.bTl.aaE().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bz(View view) {
        if (aQh() != null) {
            aQh().a(view, this.bTl);
        }
        if (this.bTl != null) {
            n.tA(this.bTl.getId());
            n.a(this.mTitle, this.bTl.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bTl, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bTl.aaE() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bTl.getFid()));
                createFromThreadCfg.setForumName(this.bTl.YW());
            } else {
                createFromThreadCfg.setForumId(this.bTl.aaE().getForumId());
                createFromThreadCfg.setForumName(this.bTl.aaE().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void bI(View view) {
        if (aQh() != null) {
            aQh().a(view, this.bTl);
        }
        if (!j.kY()) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQq();
        }
    }

    private void aQq() {
        if (this.bTl != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bTl);
            videoSerializeVideoThreadInfo.forumId = this.bTl.aaE() != null ? this.bTl.aaE().getForumId() : String.valueOf(this.bTl.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cAd.getX() + this.fHn.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cAd.getY() + this.fHn.getY());
            videoCardViewInfo.cardViewWidth = this.cAd.getWidth();
            videoCardViewInfo.cardViewHeight = this.cAd.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bTl.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int blN() {
        if (this.fIz == null || this.fIz.getHeaderImg() == null) {
            return -1;
        }
        return this.fIz.getHeaderImg().getId();
    }

    public int blO() {
        if (this.fIz == null || this.fIz.getForumName() == null) {
            return -1;
        }
        return this.fIz.getForumName().getId();
    }

    public int blP() {
        if (this.fIz == null || this.fIz.getForumName() == null) {
            return -1;
        }
        return this.fIz.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dqv != null) {
            this.dqv.setShareReportFrom(i);
        }
    }

    public void sk(int i) {
        if (this.dqv != null) {
            this.dqv.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dqv != null) {
            this.dqv.setStType(str);
        }
    }
}
