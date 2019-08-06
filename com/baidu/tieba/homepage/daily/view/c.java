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
import com.baidu.tbadk.core.data.bh;
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
public class c extends com.baidu.tieba.card.a<bh> {
    public FrameLayout cJO;
    private TextView cJP;
    private TbImageView cJQ;
    private ImageView cJR;
    private TextView cJW;
    private TbImageView.a cJY;
    private View cUD;
    private final View.OnClickListener caC;
    private bh ccq;
    private final View.OnClickListener cdB;
    private ThreadCommentAndPraiseInfoLayout dEI;
    private TextView eCB;
    private LinearLayout gdZ;
    private ThreadForumUserInfoLayout geZ;
    private View gff;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.cJY = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && c.this.cJQ != null) {
                    c.this.cJQ.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.caC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZq() != null) {
                    c.this.aZq().a(view, c.this.ccq);
                }
            }
        };
        this.cdB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZq() != null) {
                    c.this.aZq().a(view, c.this.ccq);
                }
            }
        };
        this.gff = getView();
        this.geZ = (ThreadForumUserInfoLayout) this.gff.findViewById(R.id.forum_user_info_layout);
        this.geZ.setForumAfterClickListener(this.caC);
        this.geZ.setLikeButtonAfterClickListener(this.cdB);
        this.gdZ = (LinearLayout) this.gff.findViewById(R.id.video_card_content_layout);
        this.mTitle = (TextView) this.gff.findViewById(R.id.thread_title);
        this.cJO = (FrameLayout) this.gff.findViewById(R.id.frame_video);
        this.cJO.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cJO.getLayoutParams();
        layoutParams.width = l.af(this.mTbPageContext.getPageActivity()) - l.g(this.mTbPageContext.getPageActivity(), R.dimen.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cJO.setLayoutParams(layoutParams);
        this.cJQ = (TbImageView) this.gff.findViewById(R.id.image_video);
        this.cJQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cJQ.setGifIconSupport(false);
        this.cJQ.setEvent(this.cJY);
        this.cJR = (ImageView) this.gff.findViewById(R.id.image_video_play);
        this.cJP = (TextView) this.gff.findViewById(R.id.text_video_duration);
        this.cJW = (TextView) this.gff.findViewById(R.id.text_video_play_count);
        this.dEI = (ThreadCommentAndPraiseInfoLayout) this.gff.findViewById(R.id.thread_comment_info_layout);
        this.dEI.setOnClickListener(this);
        this.dEI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZq() != null) {
                    c.this.aZq().a(view, c.this.ccq);
                }
                if (c.this.ccq != null) {
                    n.vx(c.this.ccq.getId());
                    c.this.bvm();
                }
            }
        });
        this.dEI.setShowCommonView();
        this.cUD = this.gff.findViewById(R.id.divider_line);
        this.eCB = (TextView) this.gff.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.geZ != null) {
            this.geZ.setPageUniqueId(bdUniqueId);
        }
        if (this.cJQ != null) {
            this.cJQ.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.k(this.gff, R.drawable.addresslist_item_bg);
            am.c(this.cJR, (int) R.drawable.btn_icon_play_video_n);
            am.k(this.cUD, R.color.cp_bg_line_e);
            am.j(this.cJP, R.color.cp_btn_a);
            am.j(this.cJW, R.color.cp_btn_a);
            this.geZ.onChangeSkinType(i);
            this.dEI.onChangeSkinType();
            am.j(this.eCB, R.color.cp_btn_a);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_daily_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        boolean z = true;
        if (bhVar == null || bhVar.aey() == null || bhVar.aeP() == null) {
            this.gff.setVisibility(8);
            return;
        }
        this.ccq = bhVar;
        this.gff.setVisibility(0);
        this.gff.setOnClickListener(this);
        this.geZ.setData(this.ccq);
        ah(bhVar);
        aZE();
        this.cJP.setText(aq.is(this.ccq.aeP().video_duration.intValue() * 1000));
        this.cJW.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.ccq.aeP().play_count.intValue())));
        this.dEI.cbM = this.currentPageType;
        this.dEI.setData(this.ccq);
        if (this.ccq == null || this.ccq.aeP() == null) {
            z = false;
        } else if (this.ccq.aeP().is_vertical.intValue() != 1) {
            z = false;
        }
        this.eCB.setVisibility(z ? 0 : 8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ah(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        bhVar.afo();
        SpannableStringBuilder afe = bhVar.afe();
        if (bhVar.afl() && !StringUtils.isNull(bhVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bhVar.getTid();
            afe.append((CharSequence) bhVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
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
        this.mTitle.setOnTouchListener(new k(afe));
        this.mTitle.setText(afe);
        n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvm() {
        if (n.vy(this.ccq.getId())) {
            n.a(this.mTitle, this.ccq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void aZE() {
        if (this.cJQ != null && this.cJO != null) {
            if (i.aca().ace() && this.ccq != null && this.ccq.aeP() != null) {
                this.cJQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cJQ.startLoad(this.ccq.aeP().thumbnail_url, 10, false);
                this.cJO.setVisibility(0);
                return;
            }
            this.cJO.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.gff) {
            bI(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cJO) {
            if (this.ccq != null && this.ccq.aeP() != null) {
                z = this.ccq.aeP().is_vertical.intValue() == 1;
            }
            if (z) {
                bG(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bT(getView());
            } else {
                bI(getView());
            }
        }
    }

    private void bG(View view) {
        if (aZq() != null) {
            aZq().a(view, this.ccq);
        }
        if (!j.kc()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZy();
        }
    }

    private void aZy() {
        if (this.ccq != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.ccq);
            if (this.ccq.agl() == null) {
                videoItemData.forum_id = String.valueOf(this.ccq.getFid());
                videoItemData.forum_name = this.ccq.aeD();
            } else {
                videoItemData.forum_id = this.ccq.agl().getForumId();
                videoItemData.forum_name = this.ccq.agl().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bI(View view) {
        if (aZq() != null) {
            aZq().a(view, this.ccq);
        }
        if (this.ccq != null) {
            n.vx(this.ccq.getId());
            n.a(this.mTitle, this.ccq.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.ccq, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.ccq.agl() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.ccq.getFid()));
                createFromThreadCfg.setForumName(this.ccq.aeD());
            } else {
                createFromThreadCfg.setForumId(this.ccq.agl().getForumId());
                createFromThreadCfg.setForumName(this.ccq.agl().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void bT(View view) {
        if (aZq() != null) {
            aZq().a(view, this.ccq);
        }
        if (!j.kc()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            aZz();
        }
    }

    private void aZz() {
        if (this.ccq != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.ccq);
            videoSerializeVideoThreadInfo.forumId = this.ccq.agl() != null ? this.ccq.agl().getForumId() : String.valueOf(this.ccq.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cJQ.getX() + this.gdZ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cJQ.getY() + this.gdZ.getY());
            videoCardViewInfo.cardViewWidth = this.cJQ.getWidth();
            videoCardViewInfo.cardViewHeight = this.cJQ.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.ccq.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int bvz() {
        if (this.geZ == null || this.geZ.getHeaderImg() == null) {
            return -1;
        }
        return this.geZ.getHeaderImg().getId();
    }

    public int bvA() {
        if (this.geZ == null || this.geZ.getForumName() == null) {
            return -1;
        }
        return this.geZ.getForumName().getId();
    }

    public int bvB() {
        if (this.geZ == null || this.geZ.getForumName() == null) {
            return -1;
        }
        return this.geZ.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dEI != null) {
            this.dEI.setShareReportFrom(i);
        }
    }

    public void tH(int i) {
        if (this.dEI != null) {
            this.dEI.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dEI != null) {
            this.dEI.setStType(str);
        }
    }
}
