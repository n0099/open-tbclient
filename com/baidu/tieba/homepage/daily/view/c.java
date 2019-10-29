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
    public FrameLayout cUe;
    private TextView cUf;
    private TbImageView cUg;
    private ImageView cUh;
    private TextView cUm;
    private TbImageView.a cUo;
    private final View.OnClickListener cpN;
    private bh cry;
    private final View.OnClickListener csI;
    private ThreadCommentAndPraiseInfoLayout dTr;
    private View deR;
    private TextView eMR;
    private LinearLayout gfo;
    private ThreadForumUserInfoLayout ggn;
    private View ggt;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.cUo = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && c.this.cUg != null) {
                    c.this.cUg.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.cpN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZX() != null) {
                    c.this.aZX().a(view, c.this.cry);
                }
            }
        };
        this.csI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZX() != null) {
                    c.this.aZX().a(view, c.this.cry);
                }
            }
        };
        this.ggt = getView();
        this.ggn = (ThreadForumUserInfoLayout) this.ggt.findViewById(R.id.forum_user_info_layout);
        this.ggn.setForumAfterClickListener(this.cpN);
        this.ggn.setLikeButtonAfterClickListener(this.csI);
        this.gfo = (LinearLayout) this.ggt.findViewById(R.id.video_card_content_layout);
        this.mTitle = (TextView) this.ggt.findViewById(R.id.thread_title);
        this.cUe = (FrameLayout) this.ggt.findViewById(R.id.frame_video);
        this.cUe.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUe.getLayoutParams();
        layoutParams.width = l.getEquipmentWidth(this.mTbPageContext.getPageActivity()) - l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.cUe.setLayoutParams(layoutParams);
        this.cUg = (TbImageView) this.ggt.findViewById(R.id.image_video);
        this.cUg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.cUg.setGifIconSupport(false);
        this.cUg.setEvent(this.cUo);
        this.cUh = (ImageView) this.ggt.findViewById(R.id.image_video_play);
        this.cUf = (TextView) this.ggt.findViewById(R.id.text_video_duration);
        this.cUm = (TextView) this.ggt.findViewById(R.id.text_video_play_count);
        this.dTr = (ThreadCommentAndPraiseInfoLayout) this.ggt.findViewById(R.id.thread_comment_info_layout);
        this.dTr.setOnClickListener(this);
        this.dTr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZX() != null) {
                    c.this.aZX().a(view, c.this.cry);
                }
                if (c.this.cry != null) {
                    n.uz(c.this.cry.getId());
                    c.this.btf();
                }
            }
        });
        this.dTr.setShowCommonView();
        this.deR = this.ggt.findViewById(R.id.divider_line);
        this.eMR = (TextView) this.ggt.findViewById(R.id.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ggn != null) {
            this.ggn.setPageUniqueId(bdUniqueId);
        }
        if (this.cUg != null) {
            this.cUg.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.ggt, R.drawable.addresslist_item_bg);
            am.setImageResource(this.cUh, R.drawable.btn_icon_play_video_n);
            am.setBackgroundResource(this.deR, R.color.cp_bg_line_c);
            am.setViewTextColor(this.cUf, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.cUm, (int) R.color.cp_cont_a);
            this.ggn.onChangeSkinType(i);
            this.dTr.onChangeSkinType();
            am.setViewTextColor(this.eMR, (int) R.color.cp_cont_a);
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
        if (bhVar == null || bhVar.aiG() == null || bhVar.aiX() == null) {
            this.ggt.setVisibility(8);
            return;
        }
        this.cry = bhVar;
        this.ggt.setVisibility(0);
        this.ggt.setOnClickListener(this);
        this.ggn.setData(this.cry);
        ag(bhVar);
        bal();
        this.cUf.setText(aq.stringForVideoTime(this.cry.aiX().video_duration.intValue() * 1000));
        this.cUm.setText(String.format(this.mContext.getResources().getString(R.string.play_count), aq.numFormatOverWan(this.cry.aiX().play_count.intValue())));
        this.dTr.cqT = this.currentPageType;
        this.dTr.setData(this.cry);
        if (this.cry == null || this.cry.aiX() == null) {
            z = false;
        } else if (this.cry.aiX().is_vertical.intValue() != 1) {
            z = false;
        }
        this.eMR.setVisibility(z ? 0 : 8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ag(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        bhVar.ajw();
        SpannableStringBuilder ajm = bhVar.ajm();
        if (bhVar.ajt() && !StringUtils.isNull(bhVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.alR().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bhVar.getTid();
            ajm.append((CharSequence) bhVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
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
        this.mTitle.setOnTouchListener(new k(ajm));
        this.mTitle.setText(ajm);
        n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btf() {
        if (n.uA(this.cry.getId())) {
            n.a(this.mTitle, this.cry.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void bal() {
        if (this.cUg != null && this.cUe != null) {
            if (i.agq().isShowImages() && this.cry != null && this.cry.aiX() != null) {
                this.cUg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                this.cUg.startLoad(this.cry.aiX().thumbnail_url, 10, false);
                this.cUe.setVisibility(0);
                return;
            }
            this.cUe.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.ggt) {
            bF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cUe) {
            if (this.cry != null && this.cry.aiX() != null) {
                z = this.cry.aiX().is_vertical.intValue() == 1;
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
        if (aZX() != null) {
            aZX().a(view, this.cry);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            baf();
        }
    }

    private void baf() {
        if (this.cry != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.cry);
            if (this.cry.aks() == null) {
                videoItemData.forum_id = String.valueOf(this.cry.getFid());
                videoItemData.forum_name = this.cry.aiL();
            } else {
                videoItemData.forum_id = this.cry.aks().getForumId();
                videoItemData.forum_name = this.cry.aks().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void bF(View view) {
        if (aZX() != null) {
            aZX().a(view, this.cry);
        }
        if (this.cry != null) {
            n.uz(this.cry.getId());
            n.a(this.mTitle, this.cry.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.cry, null, this.mStType, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.cry.aks() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.cry.getFid()));
                createFromThreadCfg.setForumName(this.cry.aiL());
            } else {
                createFromThreadCfg.setForumId(this.cry.aks().getForumId());
                createFromThreadCfg.setForumName(this.cry.aks().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private void bQ(View view) {
        if (aZX() != null) {
            aZX().a(view, this.cry);
        }
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.no_network_guide);
        } else {
            bag();
        }
    }

    private void bag() {
        if (this.cry != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cry);
            videoSerializeVideoThreadInfo.forumId = this.cry.aks() != null ? this.cry.aks().getForumId() : String.valueOf(this.cry.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cUg.getX() + this.gfo.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cUg.getY() + this.gfo.getY());
            videoCardViewInfo.cardViewWidth = this.cUg.getWidth();
            videoCardViewInfo.cardViewHeight = this.cUg.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.cry.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int bts() {
        if (this.ggn == null || this.ggn.getHeaderImg() == null) {
            return -1;
        }
        return this.ggn.getHeaderImg().getId();
    }

    public int btt() {
        if (this.ggn == null || this.ggn.getForumName() == null) {
            return -1;
        }
        return this.ggn.getForumName().getId();
    }

    public int btu() {
        if (this.ggn == null || this.ggn.getForumName() == null) {
            return -1;
        }
        return this.ggn.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dTr != null) {
            this.dTr.setShareReportFrom(i);
        }
    }

    public void sG(int i) {
        if (this.dTr != null) {
            this.dTr.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dTr != null) {
            this.dTr.setStType(str);
        }
    }
}
