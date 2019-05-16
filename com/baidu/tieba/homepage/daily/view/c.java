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
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<bg> {
    private final View.OnClickListener bZt;
    public FrameLayout cIm;
    private TextView cIn;
    private TbImageView cIo;
    private ImageView cIp;
    private TextView cIu;
    private TbImageView.a cIw;
    private View cSY;
    private bg cbg;
    private final View.OnClickListener ccq;
    private ThreadCommentAndPraiseInfoLayout dBe;
    private TextView exv;
    private LinearLayout fYj;
    private ThreadForumUserInfoLayout fZi;
    private View fZo;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.cIw = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && c.this.cIo != null) {
                    c.this.cIo.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bZt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aXo() != null) {
                    c.this.aXo().a(view, c.this.cbg);
                }
            }
        };
        this.ccq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aXo() != null) {
                    c.this.aXo().a(view, c.this.cbg);
                }
            }
        };
        this.fZo = getView();
        this.fZi = (ThreadForumUserInfoLayout) this.fZo.findViewById(R.id.forum_user_info_layout);
        this.fZi.setForumAfterClickListener(this.bZt);
        this.fZi.setLikeButtonAfterClickListener(this.ccq);
        this.fYj = (LinearLayout) this.fZo.findViewById(R.id.video_card_content_layout);
        this.mTitle = (TextView) this.fZo.findViewById(R.id.thread_title);
        this.cIm = (FrameLayout) this.fZo.findViewById(R.id.frame_video);
        this.cIm.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cIm.getLayoutParams();
        layoutParams.width = l.af(this.mTbPageContext.getPageActivity()) - l.g(this.mTbPageContext.getPageActivity(), R.dimen.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cIm.setLayoutParams(layoutParams);
        this.cIo = (TbImageView) this.fZo.findViewById(R.id.image_video);
        this.cIo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cIo.setGifIconSupport(false);
        this.cIo.setEvent(this.cIw);
        this.cIp = (ImageView) this.fZo.findViewById(R.id.image_video_play);
        this.cIn = (TextView) this.fZo.findViewById(R.id.text_video_duration);
        this.cIu = (TextView) this.fZo.findViewById(R.id.text_video_play_count);
        this.dBe = (ThreadCommentAndPraiseInfoLayout) this.fZo.findViewById(R.id.thread_comment_info_layout);
        this.dBe.setOnClickListener(this);
        this.dBe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aXo() != null) {
                    c.this.aXo().a(view, c.this.cbg);
                }
                if (c.this.cbg != null) {
                    n.uS(c.this.cbg.getId());
                    c.this.bsT();
                }
            }
        });
        this.dBe.setShowCommonView();
        this.cSY = this.fZo.findViewById(R.id.divider_line);
        this.exv = (TextView) this.fZo.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fZi != null) {
            this.fZi.setPageUniqueId(bdUniqueId);
        }
        if (this.cIo != null) {
            this.cIo.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.fZo, R.drawable.addresslist_item_bg);
            al.c(this.cIp, (int) R.drawable.btn_icon_play_video_n);
            al.k(this.cSY, R.color.cp_bg_line_e);
            al.j(this.cIn, R.color.cp_btn_a);
            al.j(this.cIu, R.color.cp_btn_a);
            this.fZi.onChangeSkinType(i);
            this.dBe.onChangeSkinType();
            al.j(this.exv, R.color.cp_btn_a);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_daily_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bg bgVar) {
        boolean z = true;
        if (bgVar == null || bgVar.adv() == null || bgVar.adM() == null) {
            this.fZo.setVisibility(8);
            return;
        }
        this.cbg = bgVar;
        this.fZo.setVisibility(0);
        this.fZo.setOnClickListener(this);
        this.fZi.setData(this.cbg);
        ag(bgVar);
        aXC();
        this.cIn.setText(ap.im(this.cbg.adM().video_duration.intValue() * 1000));
        this.cIu.setText(String.format(this.mContext.getResources().getString(R.string.play_count), ap.aN(this.cbg.adM().play_count.intValue())));
        this.dBe.caC = this.currentPageType;
        this.dBe.setData(this.cbg);
        if (this.cbg == null || this.cbg.adM() == null) {
            z = false;
        } else if (this.cbg.adM().is_vertical.intValue() != 1) {
            z = false;
        }
        this.exv.setVisibility(z ? 0 : 8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ag(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        bgVar.ael();
        SpannableStringBuilder aeb = bgVar.aeb();
        if (bgVar.aei() && !StringUtils.isNull(bgVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bgVar.getTid();
            aeb.append((CharSequence) bgVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(aeb));
        this.mTitle.setText(aeb);
        n.a(this.mTitle, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsT() {
        if (n.uT(this.cbg.getId())) {
            n.a(this.mTitle, this.cbg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void aXC() {
        if (this.cIo != null && this.cIm != null) {
            if (i.abb().abf() && this.cbg != null && this.cbg.adM() != null) {
                this.cIo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cIo.startLoad(this.cbg.adM().thumbnail_url, 10, false);
                this.cIm.setVisibility(0);
                return;
            }
            this.cIm.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fZo) {
            bG(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cIm) {
            if (this.cbg != null && this.cbg.adM() != null) {
                z = this.cbg.adM().is_vertical.intValue() == 1;
            }
            if (z) {
                bE(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bQ(getView());
            } else {
                bG(getView());
            }
        }
    }

    private void bE(View view) {
        if (aXo() != null) {
            aXo().a(view, this.cbg);
        }
        if (!j.jS()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXw();
        }
    }

    private void aXw() {
        if (this.cbg != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cbg);
            if (this.cbg.afi() == null) {
                videoItemData.forum_id = String.valueOf(this.cbg.getFid());
                videoItemData.forum_name = this.cbg.adA();
            } else {
                videoItemData.forum_id = this.cbg.afi().getForumId();
                videoItemData.forum_name = this.cbg.afi().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bG(View view) {
        if (aXo() != null) {
            aXo().a(view, this.cbg);
        }
        if (this.cbg != null) {
            n.uS(this.cbg.getId());
            n.a(this.mTitle, this.cbg.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.cbg, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.cbg.afi() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.cbg.getFid()));
                createFromThreadCfg.setForumName(this.cbg.adA());
            } else {
                createFromThreadCfg.setForumId(this.cbg.afi().getForumId());
                createFromThreadCfg.setForumName(this.cbg.afi().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void bQ(View view) {
        if (aXo() != null) {
            aXo().a(view, this.cbg);
        }
        if (!j.jS()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXx();
        }
    }

    private void aXx() {
        if (this.cbg != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cbg);
            videoSerializeVideoThreadInfo.forumId = this.cbg.afi() != null ? this.cbg.afi().getForumId() : String.valueOf(this.cbg.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cIo.getX() + this.fYj.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cIo.getY() + this.fYj.getY());
            videoCardViewInfo.cardViewWidth = this.cIo.getWidth();
            videoCardViewInfo.cardViewHeight = this.cIo.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.cbg.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int btg() {
        if (this.fZi == null || this.fZi.getHeaderImg() == null) {
            return -1;
        }
        return this.fZi.getHeaderImg().getId();
    }

    public int bth() {
        if (this.fZi == null || this.fZi.getForumName() == null) {
            return -1;
        }
        return this.fZi.getForumName().getId();
    }

    public int bti() {
        if (this.fZi == null || this.fZi.getForumName() == null) {
            return -1;
        }
        return this.fZi.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dBe != null) {
            this.dBe.setShareReportFrom(i);
        }
    }

    public void tn(int i) {
        if (this.dBe != null) {
            this.dBe.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dBe != null) {
            this.dBe.setStType(str);
        }
    }
}
