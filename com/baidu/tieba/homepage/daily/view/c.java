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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    public FrameLayout cTn;
    private TextView cTo;
    private TbImageView cTp;
    private ImageView cTq;
    private TextView cTv;
    private TbImageView.a cTx;
    private final View.OnClickListener coV;
    private bh cqG;
    private final View.OnClickListener crR;
    private ThreadCommentAndPraiseInfoLayout dSA;
    private View ddZ;
    private TextView eMa;
    private LinearLayout gex;
    private View gfC;
    private ThreadForumUserInfoLayout gfw;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.cTx = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && c.this.cTp != null) {
                    c.this.cTp.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.coV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZV() != null) {
                    c.this.aZV().a(view, c.this.cqG);
                }
            }
        };
        this.crR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZV() != null) {
                    c.this.aZV().a(view, c.this.cqG);
                }
            }
        };
        this.gfC = getView();
        this.gfw = (ThreadForumUserInfoLayout) this.gfC.findViewById(R.id.forum_user_info_layout);
        this.gfw.setForumAfterClickListener(this.coV);
        this.gfw.setLikeButtonAfterClickListener(this.crR);
        this.gex = (LinearLayout) this.gfC.findViewById(R.id.video_card_content_layout);
        this.mTitle = (TextView) this.gfC.findViewById(R.id.thread_title);
        this.cTn = (FrameLayout) this.gfC.findViewById(R.id.frame_video);
        this.cTn.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cTn.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cTn.setLayoutParams(layoutParams);
        this.cTp = (TbImageView) this.gfC.findViewById(R.id.image_video);
        this.cTp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cTp.setGifIconSupport(false);
        this.cTp.setEvent(this.cTx);
        this.cTq = (ImageView) this.gfC.findViewById(R.id.image_video_play);
        this.cTo = (TextView) this.gfC.findViewById(R.id.text_video_duration);
        this.cTv = (TextView) this.gfC.findViewById(R.id.text_video_play_count);
        this.dSA = (ThreadCommentAndPraiseInfoLayout) this.gfC.findViewById(R.id.thread_comment_info_layout);
        this.dSA.setOnClickListener(this);
        this.dSA.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZV() != null) {
                    c.this.aZV().a(view, c.this.cqG);
                }
                if (c.this.cqG != null) {
                    n.uz(c.this.cqG.getId());
                    c.this.btd();
                }
            }
        });
        this.dSA.setShowCommonView();
        this.ddZ = this.gfC.findViewById(R.id.divider_line);
        this.eMa = (TextView) this.gfC.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.gfw != null) {
            this.gfw.setPageUniqueId(bdUniqueId);
        }
        if (this.cTp != null) {
            this.cTp.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.gfC, R.drawable.addresslist_item_bg);
            am.setImageResource(this.cTq, R.drawable.btn_icon_play_video_n);
            am.setBackgroundResource(this.ddZ, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cTo, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cTv, (int) R.color.cp_cont_a);
            this.gfw.onChangeSkinType(i);
            this.dSA.onChangeSkinType();
            am.setViewTextColor(this.eMa, (int) R.color.cp_cont_a);
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
        if (bhVar == null || bhVar.aiE() == null || bhVar.aiV() == null) {
            this.gfC.setVisibility(8);
            return;
        }
        this.cqG = bhVar;
        this.gfC.setVisibility(0);
        this.gfC.setOnClickListener(this);
        this.gfw.setData(this.cqG);
        ag(bhVar);
        baj();
        this.cTo.setText(aq.stringForVideoTime(this.cqG.aiV().video_duration.intValue() * 1000));
        this.cTv.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.cqG.aiV().play_count.intValue())));
        this.dSA.cqc = this.currentPageType;
        this.dSA.setData(this.cqG);
        if (this.cqG == null || this.cqG.aiV() == null) {
            z = false;
        } else if (this.cqG.aiV().is_vertical.intValue() != 1) {
            z = false;
        }
        this.eMa.setVisibility(z ? 0 : 8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ag(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        bhVar.aju();
        SpannableStringBuilder ajk = bhVar.ajk();
        if (bhVar.ajr() && !StringUtils.isNull(bhVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.alP().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bhVar.getTid();
            ajk.append((CharSequence) bhVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").bS("obj_source", "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(ajk));
        this.mTitle.setText(ajk);
        n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btd() {
        if (n.uA(this.cqG.getId())) {
            n.a(this.mTitle, this.cqG.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void baj() {
        if (this.cTp != null && this.cTn != null) {
            if (i.ago().isShowImages() && this.cqG != null && this.cqG.aiV() != null) {
                this.cTp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cTp.startLoad(this.cqG.aiV().thumbnail_url, 10, false);
                this.cTn.setVisibility(0);
                return;
            }
            this.cTn.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.gfC) {
            bF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cTn) {
            if (this.cqG != null && this.cqG.aiV() != null) {
                z = this.cqG.aiV().is_vertical.intValue() == 1;
            }
            if (z) {
                bD(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                bQ(getView());
            } else {
                bF(getView());
            }
        }
    }

    private void bD(View view) {
        if (aZV() != null) {
            aZV().a(view, this.cqG);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bad();
        }
    }

    private void bad() {
        if (this.cqG != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cqG);
            if (this.cqG.akq() == null) {
                videoItemData.forum_id = String.valueOf(this.cqG.getFid());
                videoItemData.forum_name = this.cqG.aiJ();
            } else {
                videoItemData.forum_id = this.cqG.akq().getForumId();
                videoItemData.forum_name = this.cqG.akq().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bF(View view) {
        if (aZV() != null) {
            aZV().a(view, this.cqG);
        }
        if (this.cqG != null) {
            n.uz(this.cqG.getId());
            n.a(this.mTitle, this.cqG.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.cqG, null, this.mStType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.cqG.akq() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.cqG.getFid()));
                createFromThreadCfg.setForumName(this.cqG.aiJ());
            } else {
                createFromThreadCfg.setForumId(this.cqG.akq().getForumId());
                createFromThreadCfg.setForumName(this.cqG.akq().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private void bQ(View view) {
        if (aZV() != null) {
            aZV().a(view, this.cqG);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bae();
        }
    }

    private void bae() {
        if (this.cqG != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cqG);
            videoSerializeVideoThreadInfo.forumId = this.cqG.akq() != null ? this.cqG.akq().getForumId() : String.valueOf(this.cqG.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cTp.getX() + this.gex.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cTp.getY() + this.gex.getY());
            videoCardViewInfo.cardViewWidth = this.cTp.getWidth();
            videoCardViewInfo.cardViewHeight = this.cTp.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.cqG.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int btq() {
        if (this.gfw == null || this.gfw.getHeaderImg() == null) {
            return -1;
        }
        return this.gfw.getHeaderImg().getId();
    }

    public int btr() {
        if (this.gfw == null || this.gfw.getForumName() == null) {
            return -1;
        }
        return this.gfw.getForumName().getId();
    }

    public int bts() {
        if (this.gfw == null || this.gfw.getForumName() == null) {
            return -1;
        }
        return this.gfw.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dSA != null) {
            this.dSA.setShareReportFrom(i);
        }
    }

    public void sF(int i) {
        if (this.dSA != null) {
            this.dSA.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dSA != null) {
            this.dSA.setStType(str);
        }
    }
}
