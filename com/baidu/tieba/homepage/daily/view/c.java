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
    private final View.OnClickListener bZu;
    public FrameLayout cIn;
    private TextView cIo;
    private TbImageView cIp;
    private ImageView cIq;
    private TextView cIv;
    private TbImageView.a cIx;
    private View cTa;
    private bg cbh;
    private final View.OnClickListener ccr;
    private ThreadCommentAndPraiseInfoLayout dBf;
    private TextView exw;
    private LinearLayout fYm;
    private ThreadForumUserInfoLayout fZl;
    private View fZr;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.cIx = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && c.this.cIp != null) {
                    c.this.cIp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bZu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aXr() != null) {
                    c.this.aXr().a(view, c.this.cbh);
                }
            }
        };
        this.ccr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aXr() != null) {
                    c.this.aXr().a(view, c.this.cbh);
                }
            }
        };
        this.fZr = getView();
        this.fZl = (ThreadForumUserInfoLayout) this.fZr.findViewById(R.id.forum_user_info_layout);
        this.fZl.setForumAfterClickListener(this.bZu);
        this.fZl.setLikeButtonAfterClickListener(this.ccr);
        this.fYm = (LinearLayout) this.fZr.findViewById(R.id.video_card_content_layout);
        this.mTitle = (TextView) this.fZr.findViewById(R.id.thread_title);
        this.cIn = (FrameLayout) this.fZr.findViewById(R.id.frame_video);
        this.cIn.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cIn.getLayoutParams();
        layoutParams.width = l.af(this.mTbPageContext.getPageActivity()) - l.g(this.mTbPageContext.getPageActivity(), R.dimen.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cIn.setLayoutParams(layoutParams);
        this.cIp = (TbImageView) this.fZr.findViewById(R.id.image_video);
        this.cIp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cIp.setGifIconSupport(false);
        this.cIp.setEvent(this.cIx);
        this.cIq = (ImageView) this.fZr.findViewById(R.id.image_video_play);
        this.cIo = (TextView) this.fZr.findViewById(R.id.text_video_duration);
        this.cIv = (TextView) this.fZr.findViewById(R.id.text_video_play_count);
        this.dBf = (ThreadCommentAndPraiseInfoLayout) this.fZr.findViewById(R.id.thread_comment_info_layout);
        this.dBf.setOnClickListener(this);
        this.dBf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aXr() != null) {
                    c.this.aXr().a(view, c.this.cbh);
                }
                if (c.this.cbh != null) {
                    n.uR(c.this.cbh.getId());
                    c.this.bsX();
                }
            }
        });
        this.dBf.setShowCommonView();
        this.cTa = this.fZr.findViewById(R.id.divider_line);
        this.exw = (TextView) this.fZr.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fZl != null) {
            this.fZl.setPageUniqueId(bdUniqueId);
        }
        if (this.cIp != null) {
            this.cIp.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.fZr, R.drawable.addresslist_item_bg);
            al.c(this.cIq, (int) R.drawable.btn_icon_play_video_n);
            al.k(this.cTa, R.color.cp_bg_line_e);
            al.j(this.cIo, R.color.cp_btn_a);
            al.j(this.cIv, R.color.cp_btn_a);
            this.fZl.onChangeSkinType(i);
            this.dBf.onChangeSkinType();
            al.j(this.exw, R.color.cp_btn_a);
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
            this.fZr.setVisibility(8);
            return;
        }
        this.cbh = bgVar;
        this.fZr.setVisibility(0);
        this.fZr.setOnClickListener(this);
        this.fZl.setData(this.cbh);
        ag(bgVar);
        aXF();
        this.cIo.setText(ap.im(this.cbh.adM().video_duration.intValue() * 1000));
        this.cIv.setText(String.format(this.mContext.getResources().getString(R.string.play_count), ap.aN(this.cbh.adM().play_count.intValue())));
        this.dBf.caD = this.currentPageType;
        this.dBf.setData(this.cbh);
        if (this.cbh == null || this.cbh.adM() == null) {
            z = false;
        } else if (this.cbh.adM().is_vertical.intValue() != 1) {
            z = false;
        }
        this.exw.setVisibility(z ? 0 : 8);
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
    public void bsX() {
        if (n.uS(this.cbh.getId())) {
            n.a(this.mTitle, this.cbh.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void aXF() {
        if (this.cIp != null && this.cIn != null) {
            if (i.abb().abf() && this.cbh != null && this.cbh.adM() != null) {
                this.cIp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cIp.startLoad(this.cbh.adM().thumbnail_url, 10, false);
                this.cIn.setVisibility(0);
                return;
            }
            this.cIn.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fZr) {
            bG(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cIn) {
            if (this.cbh != null && this.cbh.adM() != null) {
                z = this.cbh.adM().is_vertical.intValue() == 1;
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
        if (aXr() != null) {
            aXr().a(view, this.cbh);
        }
        if (!j.jS()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXz();
        }
    }

    private void aXz() {
        if (this.cbh != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cbh);
            if (this.cbh.afi() == null) {
                videoItemData.forum_id = String.valueOf(this.cbh.getFid());
                videoItemData.forum_name = this.cbh.adA();
            } else {
                videoItemData.forum_id = this.cbh.afi().getForumId();
                videoItemData.forum_name = this.cbh.afi().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bG(View view) {
        if (aXr() != null) {
            aXr().a(view, this.cbh);
        }
        if (this.cbh != null) {
            n.uR(this.cbh.getId());
            n.a(this.mTitle, this.cbh.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.cbh, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.cbh.afi() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.cbh.getFid()));
                createFromThreadCfg.setForumName(this.cbh.adA());
            } else {
                createFromThreadCfg.setForumId(this.cbh.afi().getForumId());
                createFromThreadCfg.setForumName(this.cbh.afi().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void bQ(View view) {
        if (aXr() != null) {
            aXr().a(view, this.cbh);
        }
        if (!j.jS()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aXA();
        }
    }

    private void aXA() {
        if (this.cbh != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cbh);
            videoSerializeVideoThreadInfo.forumId = this.cbh.afi() != null ? this.cbh.afi().getForumId() : String.valueOf(this.cbh.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cIp.getX() + this.fYm.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cIp.getY() + this.fYm.getY());
            videoCardViewInfo.cardViewWidth = this.cIp.getWidth();
            videoCardViewInfo.cardViewHeight = this.cIp.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.cbh.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int btk() {
        if (this.fZl == null || this.fZl.getHeaderImg() == null) {
            return -1;
        }
        return this.fZl.getHeaderImg().getId();
    }

    public int btl() {
        if (this.fZl == null || this.fZl.getForumName() == null) {
            return -1;
        }
        return this.fZl.getForumName().getId();
    }

    public int btm() {
        if (this.fZl == null || this.fZl.getForumName() == null) {
            return -1;
        }
        return this.fZl.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dBf != null) {
            this.dBf.setShareReportFrom(i);
        }
    }

    public void tn(int i) {
        if (this.dBf != null) {
            this.dBf.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dBf != null) {
            this.dBf.setStType(str);
        }
    }
}
