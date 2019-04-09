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
    private final View.OnClickListener bRC;
    private bg bTo;
    private final View.OnClickListener bUw;
    public FrameLayout cAe;
    private TextView cAf;
    private TbImageView cAg;
    private ImageView cAh;
    private TextView cAm;
    private TbImageView.a cAo;
    private View cKN;
    private ThreadCommentAndPraiseInfoLayout dqz;
    private TextView ehI;
    private LinearLayout fHb;
    private ThreadForumUserInfoLayout fIn;
    private View fIt;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.cAo = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && c.this.cAg != null) {
                    c.this.cAg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.bRC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.bTo);
                }
            }
        };
        this.bUw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.bTo);
                }
            }
        };
        this.fIt = getView();
        this.fIn = (ThreadForumUserInfoLayout) this.fIt.findViewById(d.g.forum_user_info_layout);
        this.fIn.setForumAfterClickListener(this.bRC);
        this.fIn.setLikeButtonAfterClickListener(this.bUw);
        this.fHb = (LinearLayout) this.fIt.findViewById(d.g.video_card_content_layout);
        this.mTitle = (TextView) this.fIt.findViewById(d.g.thread_title);
        this.cAe = (FrameLayout) this.fIt.findViewById(d.g.frame_video);
        this.cAe.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAe.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cAe.setLayoutParams(layoutParams);
        this.cAg = (TbImageView) this.fIt.findViewById(d.g.image_video);
        this.cAg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAg.setGifIconSupport(false);
        this.cAg.setEvent(this.cAo);
        this.cAh = (ImageView) this.fIt.findViewById(d.g.image_video_play);
        this.cAf = (TextView) this.fIt.findViewById(d.g.text_video_duration);
        this.cAm = (TextView) this.fIt.findViewById(d.g.text_video_play_count);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) this.fIt.findViewById(d.g.thread_comment_info_layout);
        this.dqz.setOnClickListener(this);
        this.dqz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.bTo);
                }
                if (c.this.bTo != null) {
                    n.tz(c.this.bTo.getId());
                    c.this.blx();
                }
            }
        });
        this.dqz.setShowCommonView();
        this.cKN = this.fIt.findViewById(d.g.divider_line);
        this.ehI = (TextView) this.fIt.findViewById(d.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fIn != null) {
            this.fIn.setPageUniqueId(bdUniqueId);
        }
        if (this.cAg != null) {
            this.cAg.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.fIt, d.f.addresslist_item_bg);
            al.c(this.cAh, d.f.btn_icon_play_video_n);
            al.k(this.cKN, d.C0277d.cp_bg_line_e);
            al.j(this.cAf, d.C0277d.cp_btn_a);
            al.j(this.cAm, d.C0277d.cp_btn_a);
            this.fIn.onChangeSkinType(i);
            this.dqz.onChangeSkinType();
            al.j(this.ehI, d.C0277d.cp_btn_a);
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
        this.bTo = bgVar;
        this.fIt.setVisibility(0);
        this.fIt.setOnClickListener(this);
        this.fIn.setData(this.bTo);
        ag(bgVar);
        aQt();
        this.cAf.setText(ap.hy(this.bTo.Zf().video_duration.intValue() * 1000));
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.bTo.Zf().play_count.intValue())));
        this.dqz.bSK = this.currentPageType;
        this.dqz.setData(this.bTo);
        if (this.bTo == null || this.bTo.Zf() == null) {
            z = false;
        } else if (this.bTo.Zf().is_vertical.intValue() != 1) {
            z = false;
        }
        this.ehI.setVisibility(z ? 0 : 8);
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
        if (n.tA(this.bTo.getId())) {
            n.a(this.mTitle, this.bTo.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
    }

    private void aQt() {
        if (this.cAg != null && this.cAe != null) {
            if (i.Wv().Wz() && this.bTo != null && this.bTo.Zf() != null) {
                this.cAg.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAg.startLoad(this.bTo.Zf().thumbnail_url, 10, false);
                this.cAe.setVisibility(0);
                return;
            }
            this.cAe.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fIt) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cAe) {
            if (this.bTo != null && this.bTo.Zf() != null) {
                z = this.bTo.Zf().is_vertical.intValue() == 1;
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
            aQf().a(view, this.bTo);
        }
        if (!j.kY()) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQn();
        }
    }

    private void aQn() {
        if (this.bTo != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bTo);
            if (this.bTo.aaB() == null) {
                videoItemData.forum_id = String.valueOf(this.bTo.getFid());
                videoItemData.forum_name = this.bTo.YT();
            } else {
                videoItemData.forum_id = this.bTo.aaB().getForumId();
                videoItemData.forum_name = this.bTo.aaB().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bz(View view) {
        if (aQf() != null) {
            aQf().a(view, this.bTo);
        }
        if (this.bTo != null) {
            n.tz(this.bTo.getId());
            n.a(this.mTitle, this.bTo.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bTo, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bTo.aaB() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bTo.getFid()));
                createFromThreadCfg.setForumName(this.bTo.YT());
            } else {
                createFromThreadCfg.setForumId(this.bTo.aaB().getForumId());
                createFromThreadCfg.setForumName(this.bTo.aaB().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void bI(View view) {
        if (aQf() != null) {
            aQf().a(view, this.bTo);
        }
        if (!j.kY()) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQo();
        }
    }

    private void aQo() {
        if (this.bTo != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bTo);
            videoSerializeVideoThreadInfo.forumId = this.bTo.aaB() != null ? this.bTo.aaB().getForumId() : String.valueOf(this.bTo.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cAg.getX() + this.fHb.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cAg.getY() + this.fHb.getY());
            videoCardViewInfo.cardViewWidth = this.cAg.getWidth();
            videoCardViewInfo.cardViewHeight = this.cAg.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bTo.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
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
        if (this.dqz != null) {
            this.dqz.setShareReportFrom(i);
        }
    }

    public void sg(int i) {
        if (this.dqz != null) {
            this.dqz.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dqz != null) {
            this.dqz.setStType(str);
        }
    }
}
