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
    public FrameLayout cKE;
    private TextView cKF;
    private TbImageView cKG;
    private ImageView cKH;
    private TextView cKM;
    private TbImageView.a cKO;
    private View cVw;
    private final View.OnClickListener cbv;
    private bh cdk;
    private final View.OnClickListener ceu;
    private ThreadCommentAndPraiseInfoLayout dGt;
    private TextView eEk;
    private LinearLayout gfR;
    private ThreadForumUserInfoLayout ggQ;
    private View ggW;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.cKO = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && c.this.cKG != null) {
                    c.this.cKG.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cbv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZU() != null) {
                    c.this.aZU().a(view, c.this.cdk);
                }
            }
        };
        this.ceu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZU() != null) {
                    c.this.aZU().a(view, c.this.cdk);
                }
            }
        };
        this.ggW = getView();
        this.ggQ = (ThreadForumUserInfoLayout) this.ggW.findViewById(R.id.forum_user_info_layout);
        this.ggQ.setForumAfterClickListener(this.cbv);
        this.ggQ.setLikeButtonAfterClickListener(this.ceu);
        this.gfR = (LinearLayout) this.ggW.findViewById(R.id.video_card_content_layout);
        this.mTitle = (TextView) this.ggW.findViewById(R.id.thread_title);
        this.cKE = (FrameLayout) this.ggW.findViewById(R.id.frame_video);
        this.cKE.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cKE.getLayoutParams();
        layoutParams.width = l.af(this.mTbPageContext.getPageActivity()) - l.g(this.mTbPageContext.getPageActivity(), R.dimen.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cKE.setLayoutParams(layoutParams);
        this.cKG = (TbImageView) this.ggW.findViewById(R.id.image_video);
        this.cKG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cKG.setGifIconSupport(false);
        this.cKG.setEvent(this.cKO);
        this.cKH = (ImageView) this.ggW.findViewById(R.id.image_video_play);
        this.cKF = (TextView) this.ggW.findViewById(R.id.text_video_duration);
        this.cKM = (TextView) this.ggW.findViewById(R.id.text_video_play_count);
        this.dGt = (ThreadCommentAndPraiseInfoLayout) this.ggW.findViewById(R.id.thread_comment_info_layout);
        this.dGt.setOnClickListener(this);
        this.dGt.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZU() != null) {
                    c.this.aZU().a(view, c.this.cdk);
                }
                if (c.this.cdk != null) {
                    n.vW(c.this.cdk.getId());
                    c.this.bwa();
                }
            }
        });
        this.dGt.setShowCommonView();
        this.cVw = this.ggW.findViewById(R.id.divider_line);
        this.eEk = (TextView) this.ggW.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ggQ != null) {
            this.ggQ.setPageUniqueId(bdUniqueId);
        }
        if (this.cKG != null) {
            this.cKG.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.k(this.ggW, R.drawable.addresslist_item_bg);
            am.c(this.cKH, (int) R.drawable.btn_icon_play_video_n);
            am.k(this.cVw, R.color.cp_bg_line_c);
            am.j(this.cKF, R.color.cp_cont_a);
            am.j(this.cKM, R.color.cp_cont_a);
            this.ggQ.onChangeSkinType(i);
            this.dGt.onChangeSkinType();
            am.j(this.eEk, R.color.cp_cont_a);
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
        if (bhVar == null || bhVar.aeC() == null || bhVar.aeT() == null) {
            this.ggW.setVisibility(8);
            return;
        }
        this.cdk = bhVar;
        this.ggW.setVisibility(0);
        this.ggW.setOnClickListener(this);
        this.ggQ.setData(this.cdk);
        ai(bhVar);
        bai();
        this.cKF.setText(aq.it(this.cdk.aeT().video_duration.intValue() * 1000));
        this.cKM.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.aO(this.cdk.aeT().play_count.intValue())));
        this.dGt.ccG = this.currentPageType;
        this.dGt.setData(this.cdk);
        if (this.cdk == null || this.cdk.aeT() == null) {
            z = false;
        } else if (this.cdk.aeT().is_vertical.intValue() != 1) {
            z = false;
        }
        this.eEk.setVisibility(z ? 0 : 8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ai(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        bhVar.afs();
        SpannableStringBuilder afi = bhVar.afi();
        if (bhVar.afp() && !StringUtils.isNull(bhVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bhVar.getTid();
            afi.append((CharSequence) bhVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
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
        this.mTitle.setOnTouchListener(new k(afi));
        this.mTitle.setText(afi);
        n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwa() {
        if (n.vX(this.cdk.getId())) {
            n.a(this.mTitle, this.cdk.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void bai() {
        if (this.cKG != null && this.cKE != null) {
            if (i.ace().aci() && this.cdk != null && this.cdk.aeT() != null) {
                this.cKG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cKG.startLoad(this.cdk.aeT().thumbnail_url, 10, false);
                this.cKE.setVisibility(0);
                return;
            }
            this.cKE.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.ggW) {
            bI(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.cKE) {
            if (this.cdk != null && this.cdk.aeT() != null) {
                z = this.cdk.aeT().is_vertical.intValue() == 1;
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
        if (aZU() != null) {
            aZU().a(view, this.cdk);
        }
        if (!j.kc()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bac();
        }
    }

    private void bac() {
        if (this.cdk != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cdk);
            if (this.cdk.agp() == null) {
                videoItemData.forum_id = String.valueOf(this.cdk.getFid());
                videoItemData.forum_name = this.cdk.aeH();
            } else {
                videoItemData.forum_id = this.cdk.agp().getForumId();
                videoItemData.forum_name = this.cdk.agp().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bI(View view) {
        if (aZU() != null) {
            aZU().a(view, this.cdk);
        }
        if (this.cdk != null) {
            n.vW(this.cdk.getId());
            n.a(this.mTitle, this.cdk.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.cdk, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.cdk.agp() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.cdk.getFid()));
                createFromThreadCfg.setForumName(this.cdk.aeH());
            } else {
                createFromThreadCfg.setForumId(this.cdk.agp().getForumId());
                createFromThreadCfg.setForumName(this.cdk.agp().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void bT(View view) {
        if (aZU() != null) {
            aZU().a(view, this.cdk);
        }
        if (!j.kc()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bad();
        }
    }

    private void bad() {
        if (this.cdk != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cdk);
            videoSerializeVideoThreadInfo.forumId = this.cdk.agp() != null ? this.cdk.agp().getForumId() : String.valueOf(this.cdk.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cKG.getX() + this.gfR.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cKG.getY() + this.gfR.getY());
            videoCardViewInfo.cardViewWidth = this.cKG.getWidth();
            videoCardViewInfo.cardViewHeight = this.cKG.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.cdk.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int bwn() {
        if (this.ggQ == null || this.ggQ.getHeaderImg() == null) {
            return -1;
        }
        return this.ggQ.getHeaderImg().getId();
    }

    public int bwo() {
        if (this.ggQ == null || this.ggQ.getForumName() == null) {
            return -1;
        }
        return this.ggQ.getForumName().getId();
    }

    public int bwp() {
        if (this.ggQ == null || this.ggQ.getForumName() == null) {
            return -1;
        }
        return this.ggQ.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dGt != null) {
            this.dGt.setShareReportFrom(i);
        }
    }

    public void tL(int i) {
        if (this.dGt != null) {
            this.dGt.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dGt != null) {
            this.dGt.setStType(str);
        }
    }
}
