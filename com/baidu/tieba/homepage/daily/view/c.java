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
    private final View.OnClickListener bRB;
    private bg bTn;
    private final View.OnClickListener bUv;
    public FrameLayout cAd;
    private TextView cAe;
    private TbImageView cAf;
    private ImageView cAg;
    private TextView cAl;
    private TbImageView.a cAn;
    private View cKM;
    private ThreadCommentAndPraiseInfoLayout dqy;
    private TextView ehH;
    private LinearLayout fHb;
    private ThreadForumUserInfoLayout fIn;
    private View fIt;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.cAn = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && c.this.cAf != null) {
                    c.this.cAf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bRB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.bTn);
                }
            }
        };
        this.bUv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.bTn);
                }
            }
        };
        this.fIt = getView();
        this.fIn = (ThreadForumUserInfoLayout) this.fIt.findViewById(d.g.forum_user_info_layout);
        this.fIn.setForumAfterClickListener(this.bRB);
        this.fIn.setLikeButtonAfterClickListener(this.bUv);
        this.fHb = (LinearLayout) this.fIt.findViewById(d.g.video_card_content_layout);
        this.mTitle = (TextView) this.fIt.findViewById(d.g.thread_title);
        this.cAd = (FrameLayout) this.fIt.findViewById(d.g.frame_video);
        this.cAd.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAd.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cAd.setLayoutParams(layoutParams);
        this.cAf = (TbImageView) this.fIt.findViewById(d.g.image_video);
        this.cAf.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAf.setGifIconSupport(false);
        this.cAf.setEvent(this.cAn);
        this.cAg = (ImageView) this.fIt.findViewById(d.g.image_video_play);
        this.cAe = (TextView) this.fIt.findViewById(d.g.text_video_duration);
        this.cAl = (TextView) this.fIt.findViewById(d.g.text_video_play_count);
        this.dqy = (ThreadCommentAndPraiseInfoLayout) this.fIt.findViewById(d.g.thread_comment_info_layout);
        this.dqy.setOnClickListener(this);
        this.dqy.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.bTn);
                }
                if (c.this.bTn != null) {
                    n.tz(c.this.bTn.getId());
                    c.this.blx();
                }
            }
        });
        this.dqy.setShowCommonView();
        this.cKM = this.fIt.findViewById(d.g.divider_line);
        this.ehH = (TextView) this.fIt.findViewById(d.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fIn != null) {
            this.fIn.setPageUniqueId(bdUniqueId);
        }
        if (this.cAf != null) {
            this.cAf.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.fIt, d.f.addresslist_item_bg);
            al.c(this.cAg, d.f.btn_icon_play_video_n);
            al.k(this.cKM, d.C0277d.cp_bg_line_e);
            al.j(this.cAe, d.C0277d.cp_btn_a);
            al.j(this.cAl, d.C0277d.cp_btn_a);
            this.fIn.onChangeSkinType(i);
            this.dqy.onChangeSkinType();
            al.j(this.ehH, d.C0277d.cp_btn_a);
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
        if (bgVar == null || bgVar.YO() == null || bgVar.Zf() == null) {
            this.fIt.setVisibility(8);
            return;
        }
        this.bTn = bgVar;
        this.fIt.setVisibility(0);
        this.fIt.setOnClickListener(this);
        this.fIn.setData(this.bTn);
        ag(bgVar);
        aQt();
        this.cAe.setText(ap.hy(this.bTn.Zf().video_duration.intValue() * 1000));
        this.cAl.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.bTn.Zf().play_count.intValue())));
        this.dqy.bSJ = this.currentPageType;
        this.dqy.setData(this.bTn);
        if (this.bTn == null || this.bTn.Zf() == null) {
            z = false;
        } else if (this.bTn.Zf().is_vertical.intValue() != 1) {
            z = false;
        }
        this.ehH.setVisibility(z ? 0 : 8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ag(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        bgVar.ZE();
        SpannableStringBuilder Zu = bgVar.Zu();
        if (bgVar.ZB() && !StringUtils.isNull(bgVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bgVar.getTid();
            Zu.append((CharSequence) bgVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
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
        this.mTitle.setOnTouchListener(new k(Zu));
        this.mTitle.setText(Zu);
        n.a(this.mTitle, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        if (n.tA(this.bTn.getId())) {
            n.a(this.mTitle, this.bTn.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
    }

    private void aQt() {
        if (this.cAf != null && this.cAd != null) {
            if (i.Wv().Wz() && this.bTn != null && this.bTn.Zf() != null) {
                this.cAf.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAf.startLoad(this.bTn.Zf().thumbnail_url, 10, false);
                this.cAd.setVisibility(0);
                return;
            }
            this.cAd.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fIt) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cAd) {
            if (this.bTn != null && this.bTn.Zf() != null) {
                z = this.bTn.Zf().is_vertical.intValue() == 1;
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
        if (aQf() != null) {
            aQf().a(view, this.bTn);
        }
        if (!j.kY()) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQn();
        }
    }

    private void aQn() {
        if (this.bTn != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bTn);
            if (this.bTn.aaB() == null) {
                videoItemData.forum_id = String.valueOf(this.bTn.getFid());
                videoItemData.forum_name = this.bTn.YT();
            } else {
                videoItemData.forum_id = this.bTn.aaB().getForumId();
                videoItemData.forum_name = this.bTn.aaB().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bz(View view) {
        if (aQf() != null) {
            aQf().a(view, this.bTn);
        }
        if (this.bTn != null) {
            n.tz(this.bTn.getId());
            n.a(this.mTitle, this.bTn.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bTn, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bTn.aaB() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bTn.getFid()));
                createFromThreadCfg.setForumName(this.bTn.YT());
            } else {
                createFromThreadCfg.setForumId(this.bTn.aaB().getForumId());
                createFromThreadCfg.setForumName(this.bTn.aaB().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void bI(View view) {
        if (aQf() != null) {
            aQf().a(view, this.bTn);
        }
        if (!j.kY()) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQo();
        }
    }

    private void aQo() {
        if (this.bTn != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bTn);
            videoSerializeVideoThreadInfo.forumId = this.bTn.aaB() != null ? this.bTn.aaB().getForumId() : String.valueOf(this.bTn.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cAf.getX() + this.fHb.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cAf.getY() + this.fHb.getY());
            videoCardViewInfo.cardViewWidth = this.cAf.getWidth();
            videoCardViewInfo.cardViewHeight = this.cAf.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bTn.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int blK() {
        if (this.fIn == null || this.fIn.getHeaderImg() == null) {
            return -1;
        }
        return this.fIn.getHeaderImg().getId();
    }

    public int blL() {
        if (this.fIn == null || this.fIn.getForumName() == null) {
            return -1;
        }
        return this.fIn.getForumName().getId();
    }

    public int blM() {
        if (this.fIn == null || this.fIn.getForumName() == null) {
            return -1;
        }
        return this.fIn.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dqy != null) {
            this.dqy.setShareReportFrom(i);
        }
    }

    public void sg(int i) {
        if (this.dqy != null) {
            this.dqy.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dqy != null) {
            this.dqy.setStType(str);
        }
    }
}
