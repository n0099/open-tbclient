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
    private final View.OnClickListener bRy;
    private bg bTk;
    private final View.OnClickListener bUs;
    public FrameLayout cAe;
    private TextView cAf;
    private TbImageView cAg;
    private ImageView cAh;
    private TextView cAm;
    private TbImageView.a cAo;
    private View cKN;
    private ThreadCommentAndPraiseInfoLayout dqz;
    private TextView ehZ;
    private LinearLayout fHo;
    private ThreadForumUserInfoLayout fIA;
    private View fIG;
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
        this.bRy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQi() != null) {
                    c.this.aQi().a(view, c.this.bTk);
                }
            }
        };
        this.bUs = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQi() != null) {
                    c.this.aQi().a(view, c.this.bTk);
                }
            }
        };
        this.fIG = getView();
        this.fIA = (ThreadForumUserInfoLayout) this.fIG.findViewById(d.g.forum_user_info_layout);
        this.fIA.setForumAfterClickListener(this.bRy);
        this.fIA.setLikeButtonAfterClickListener(this.bUs);
        this.fHo = (LinearLayout) this.fIG.findViewById(d.g.video_card_content_layout);
        this.mTitle = (TextView) this.fIG.findViewById(d.g.thread_title);
        this.cAe = (FrameLayout) this.fIG.findViewById(d.g.frame_video);
        this.cAe.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAe.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cAe.setLayoutParams(layoutParams);
        this.cAg = (TbImageView) this.fIG.findViewById(d.g.image_video);
        this.cAg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAg.setGifIconSupport(false);
        this.cAg.setEvent(this.cAo);
        this.cAh = (ImageView) this.fIG.findViewById(d.g.image_video_play);
        this.cAf = (TextView) this.fIG.findViewById(d.g.text_video_duration);
        this.cAm = (TextView) this.fIG.findViewById(d.g.text_video_play_count);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) this.fIG.findViewById(d.g.thread_comment_info_layout);
        this.dqz.setOnClickListener(this);
        this.dqz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQi() != null) {
                    c.this.aQi().a(view, c.this.bTk);
                }
                if (c.this.bTk != null) {
                    n.tC(c.this.bTk.getId());
                    c.this.blB();
                }
            }
        });
        this.dqz.setShowCommonView();
        this.cKN = this.fIG.findViewById(d.g.divider_line);
        this.ehZ = (TextView) this.fIG.findViewById(d.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fIA != null) {
            this.fIA.setPageUniqueId(bdUniqueId);
        }
        if (this.cAg != null) {
            this.cAg.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(this.fIG, d.f.addresslist_item_bg);
            al.c(this.cAh, d.f.btn_icon_play_video_n);
            al.k(this.cKN, d.C0236d.cp_bg_line_e);
            al.j(this.cAf, d.C0236d.cp_btn_a);
            al.j(this.cAm, d.C0236d.cp_btn_a);
            this.fIA.onChangeSkinType(i);
            this.dqz.onChangeSkinType();
            al.j(this.ehZ, d.C0236d.cp_btn_a);
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
            this.fIG.setVisibility(8);
            return;
        }
        this.bTk = bgVar;
        this.fIG.setVisibility(0);
        this.fIG.setOnClickListener(this);
        this.fIA.setData(this.bTk);
        ah(bgVar);
        aQw();
        this.cAf.setText(ap.hz(this.bTk.Zi().video_duration.intValue() * 1000));
        this.cAm.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.az(this.bTk.Zi().play_count.intValue())));
        this.dqz.bSG = this.currentPageType;
        this.dqz.setData(this.bTk);
        if (this.bTk == null || this.bTk.Zi() == null) {
            z = false;
        } else if (this.bTk.Zi().is_vertical.intValue() != 1) {
            z = false;
        }
        this.ehZ.setVisibility(z ? 0 : 8);
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
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0236d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(Zx));
        this.mTitle.setText(Zx);
        n.a(this.mTitle, bgVar.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blB() {
        if (n.tD(this.bTk.getId())) {
            n.a(this.mTitle, this.bTk.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        }
    }

    private void aQw() {
        if (this.cAg != null && this.cAe != null) {
            if (i.Wy().WC() && this.bTk != null && this.bTk.Zi() != null) {
                this.cAg.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cAg.startLoad(this.bTk.Zi().thumbnail_url, 10, false);
                this.cAe.setVisibility(0);
                return;
            }
            this.cAe.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.fIG) {
            bz(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cAe) {
            if (this.bTk != null && this.bTk.Zi() != null) {
                z = this.bTk.Zi().is_vertical.intValue() == 1;
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
        if (aQi() != null) {
            aQi().a(view, this.bTk);
        }
        if (!j.kY()) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQq();
        }
    }

    private void aQq() {
        if (this.bTk != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bTk);
            if (this.bTk.aaE() == null) {
                videoItemData.forum_id = String.valueOf(this.bTk.getFid());
                videoItemData.forum_name = this.bTk.YW();
            } else {
                videoItemData.forum_id = this.bTk.aaE().getForumId();
                videoItemData.forum_name = this.bTk.aaE().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bz(View view) {
        if (aQi() != null) {
            aQi().a(view, this.bTk);
        }
        if (this.bTk != null) {
            n.tC(this.bTk.getId());
            n.a(this.mTitle, this.bTk.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bTk, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bTk.aaE() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bTk.getFid()));
                createFromThreadCfg.setForumName(this.bTk.YW());
            } else {
                createFromThreadCfg.setForumId(this.bTk.aaE().getForumId());
                createFromThreadCfg.setForumName(this.bTk.aaE().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void bI(View view) {
        if (aQi() != null) {
            aQi().a(view, this.bTk);
        }
        if (!j.kY()) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aQr();
        }
    }

    private void aQr() {
        if (this.bTk != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bTk);
            videoSerializeVideoThreadInfo.forumId = this.bTk.aaE() != null ? this.bTk.aaE().getForumId() : String.valueOf(this.bTk.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cAg.getX() + this.fHo.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cAg.getY() + this.fHo.getY());
            videoCardViewInfo.cardViewWidth = this.cAg.getWidth();
            videoCardViewInfo.cardViewHeight = this.cAg.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bTk.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int blO() {
        if (this.fIA == null || this.fIA.getHeaderImg() == null) {
            return -1;
        }
        return this.fIA.getHeaderImg().getId();
    }

    public int blP() {
        if (this.fIA == null || this.fIA.getForumName() == null) {
            return -1;
        }
        return this.fIA.getForumName().getId();
    }

    public int blQ() {
        if (this.fIA == null || this.fIA.getForumName() == null) {
            return -1;
        }
        return this.fIA.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dqz != null) {
            this.dqz.setShareReportFrom(i);
        }
    }

    public void sk(int i) {
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
