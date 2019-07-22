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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    public FrameLayout cJH;
    private TextView cJI;
    private TbImageView cJJ;
    private ImageView cJK;
    private TextView cJP;
    private TbImageView.a cJR;
    private View cUw;
    private final View.OnClickListener caw;
    private bg ccj;
    private final View.OnClickListener cdu;
    private ThreadCommentAndPraiseInfoLayout dEB;
    private TextView eCu;
    private LinearLayout gdj;
    private ThreadForumUserInfoLayout gei;
    private View gep;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.cJR = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && c.this.cJJ != null) {
                    c.this.cJJ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.caw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZo() != null) {
                    c.this.aZo().a(view, c.this.ccj);
                }
            }
        };
        this.cdu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZo() != null) {
                    c.this.aZo().a(view, c.this.ccj);
                }
            }
        };
        this.gep = getView();
        this.gei = (ThreadForumUserInfoLayout) this.gep.findViewById(R.id.forum_user_info_layout);
        this.gei.setForumAfterClickListener(this.caw);
        this.gei.setLikeButtonAfterClickListener(this.cdu);
        this.gdj = (LinearLayout) this.gep.findViewById(R.id.video_card_content_layout);
        this.mTitle = (TextView) this.gep.findViewById(R.id.thread_title);
        this.cJH = (FrameLayout) this.gep.findViewById(R.id.frame_video);
        this.cJH.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cJH.getLayoutParams();
        layoutParams.width = l.af(this.mTbPageContext.getPageActivity()) - l.g(this.mTbPageContext.getPageActivity(), R.dimen.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cJH.setLayoutParams(layoutParams);
        this.cJJ = (TbImageView) this.gep.findViewById(R.id.image_video);
        this.cJJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cJJ.setGifIconSupport(false);
        this.cJJ.setEvent(this.cJR);
        this.cJK = (ImageView) this.gep.findViewById(R.id.image_video_play);
        this.cJI = (TextView) this.gep.findViewById(R.id.text_video_duration);
        this.cJP = (TextView) this.gep.findViewById(R.id.text_video_play_count);
        this.dEB = (ThreadCommentAndPraiseInfoLayout) this.gep.findViewById(R.id.thread_comment_info_layout);
        this.dEB.setOnClickListener(this);
        this.dEB.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZo() != null) {
                    c.this.aZo().a(view, c.this.ccj);
                }
                if (c.this.ccj != null) {
                    n.vw(c.this.ccj.getId());
                    c.this.buZ();
                }
            }
        });
        this.dEB.setShowCommonView();
        this.cUw = this.gep.findViewById(R.id.divider_line);
        this.eCu = (TextView) this.gep.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.gei != null) {
            this.gei.setPageUniqueId(bdUniqueId);
        }
        if (this.cJJ != null) {
            this.cJJ.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.k(this.gep, R.drawable.addresslist_item_bg);
            am.c(this.cJK, (int) R.drawable.btn_icon_play_video_n);
            am.k(this.cUw, R.color.cp_bg_line_e);
            am.j(this.cJI, R.color.cp_btn_a);
            am.j(this.cJP, R.color.cp_btn_a);
            this.gei.onChangeSkinType(i);
            this.dEB.onChangeSkinType();
            am.j(this.eCu, R.color.cp_btn_a);
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
        if (bgVar == null || bgVar.aex() == null || bgVar.aeO() == null) {
            this.gep.setVisibility(8);
            return;
        }
        this.ccj = bgVar;
        this.gep.setVisibility(0);
        this.gep.setOnClickListener(this);
        this.gei.setData(this.ccj);
        ag(bgVar);
        aZC();
        this.cJI.setText(aq.is(this.ccj.aeO().video_duration.intValue() * 1000));
        this.cJP.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.ccj.aeO().play_count.intValue())));
        this.dEB.cbF = this.currentPageType;
        this.dEB.setData(this.ccj);
        if (this.ccj == null || this.ccj.aeO() == null) {
            z = false;
        } else if (this.ccj.aeO().is_vertical.intValue() != 1) {
            z = false;
        }
        this.eCu.setVisibility(z ? 0 : 8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ag(bg bgVar) {
        if (bgVar == null) {
            return false;
        }
        bgVar.afn();
        SpannableStringBuilder afd = bgVar.afd();
        if (bgVar.afk() && !StringUtils.isNull(bgVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahO().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bgVar.getTid();
            afd.append((CharSequence) bgVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(afd));
        this.mTitle.setText(afd);
        n.a(this.mTitle, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buZ() {
        if (n.vx(this.ccj.getId())) {
            n.a(this.mTitle, this.ccj.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void aZC() {
        if (this.cJJ != null && this.cJH != null) {
            if (i.aca().ace() && this.ccj != null && this.ccj.aeO() != null) {
                this.cJJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cJJ.startLoad(this.ccj.aeO().thumbnail_url, 10, false);
                this.cJH.setVisibility(0);
                return;
            }
            this.cJH.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.gep) {
            bI(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cJH) {
            if (this.ccj != null && this.ccj.aeO() != null) {
                z = this.ccj.aeO().is_vertical.intValue() == 1;
            }
            if (z) {
                bG(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bS(getView());
            } else {
                bI(getView());
            }
        }
    }

    private void bG(View view) {
        if (aZo() != null) {
            aZo().a(view, this.ccj);
        }
        if (!j.kc()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZw();
        }
    }

    private void aZw() {
        if (this.ccj != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ccj);
            if (this.ccj.agk() == null) {
                videoItemData.forum_id = String.valueOf(this.ccj.getFid());
                videoItemData.forum_name = this.ccj.aeC();
            } else {
                videoItemData.forum_id = this.ccj.agk().getForumId();
                videoItemData.forum_name = this.ccj.agk().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bI(View view) {
        if (aZo() != null) {
            aZo().a(view, this.ccj);
        }
        if (this.ccj != null) {
            n.vw(this.ccj.getId());
            n.a(this.mTitle, this.ccj.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.ccj, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.ccj.agk() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.ccj.getFid()));
                createFromThreadCfg.setForumName(this.ccj.aeC());
            } else {
                createFromThreadCfg.setForumId(this.ccj.agk().getForumId());
                createFromThreadCfg.setForumName(this.ccj.agk().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void bS(View view) {
        if (aZo() != null) {
            aZo().a(view, this.ccj);
        }
        if (!j.kc()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZx();
        }
    }

    private void aZx() {
        if (this.ccj != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ccj);
            videoSerializeVideoThreadInfo.forumId = this.ccj.agk() != null ? this.ccj.agk().getForumId() : String.valueOf(this.ccj.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cJJ.getX() + this.gdj.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cJJ.getY() + this.gdj.getY());
            videoCardViewInfo.cardViewWidth = this.cJJ.getWidth();
            videoCardViewInfo.cardViewHeight = this.cJJ.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.ccj.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int bvm() {
        if (this.gei == null || this.gei.getHeaderImg() == null) {
            return -1;
        }
        return this.gei.getHeaderImg().getId();
    }

    public int bvn() {
        if (this.gei == null || this.gei.getForumName() == null) {
            return -1;
        }
        return this.gei.getForumName().getId();
    }

    public int bvo() {
        if (this.gei == null || this.gei.getForumName() == null) {
            return -1;
        }
        return this.gei.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dEB != null) {
            this.dEB.setShareReportFrom(i);
        }
    }

    public void tF(int i) {
        if (this.dEB != null) {
            this.dEB.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dEB != null) {
            this.dEB.setStType(str);
        }
    }
}
