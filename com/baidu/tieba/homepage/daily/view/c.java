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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<bb> {
    private final View.OnClickListener aCs;
    private final View.OnClickListener azz;
    private bb bAn;
    private ThreadCommentAndPraiseInfoLayout bND;
    public FrameLayout bgl;
    private TextView bgm;
    private TbImageView bgn;
    private ImageView bgo;
    private TextView bgv;
    private TbImageView.a bgx;
    private View bqy;
    private TextView cEB;
    private LinearLayout ebj;
    private ThreadForumUserInfoLayout ect;
    private View ecz;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.bgx = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z && c.this.bgn != null) {
                    c.this.bgn.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.azz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, c.this.bAn);
                }
            }
        };
        this.aCs = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, c.this.bAn);
                }
            }
        };
        this.ecz = getView();
        this.ect = (ThreadForumUserInfoLayout) this.ecz.findViewById(e.g.forum_user_info_layout);
        this.ect.setForumAfterClickListener(this.azz);
        this.ect.setLikeButtonAfterClickListener(this.aCs);
        this.ebj = (LinearLayout) this.ecz.findViewById(e.g.video_card_content_layout);
        this.mTitle = (TextView) this.ecz.findViewById(e.g.thread_title);
        this.bgl = (FrameLayout) this.ecz.findViewById(e.g.frame_video);
        this.bgl.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgl.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), e.C0141e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.bgl.setLayoutParams(layoutParams);
        this.bgn = (TbImageView) this.ecz.findViewById(e.g.image_video);
        this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bgn.setGifIconSupport(false);
        this.bgn.setEvent(this.bgx);
        this.bgo = (ImageView) this.ecz.findViewById(e.g.image_video_play);
        this.bgm = (TextView) this.ecz.findViewById(e.g.text_video_duration);
        this.bgv = (TextView) this.ecz.findViewById(e.g.text_video_play_count);
        this.bND = (ThreadCommentAndPraiseInfoLayout) this.ecz.findViewById(e.g.thread_comment_info_layout);
        this.bND.setOnClickListener(this);
        this.bND.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, c.this.bAn);
                }
                if (c.this.bAn != null) {
                    o.lA(c.this.bAn.getId());
                    c.this.akr();
                }
            }
        });
        this.bND.setShowCommonView();
        this.bqy = this.ecz.findViewById(e.g.divider_line);
        this.cEB = (TextView) this.ecz.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ect != null) {
            this.ect.setPageUniqueId(bdUniqueId);
        }
        if (this.bgn != null) {
            this.bgn.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.ecz, e.f.addresslist_item_bg);
            al.c(this.bgo, e.f.btn_icon_play_video_n);
            al.i(this.bqy, e.d.cp_bg_line_e);
            al.h(this.bgm, e.d.cp_cont_i);
            al.h(this.bgv, e.d.cp_cont_i);
            this.ect.onChangeSkinType(i);
            this.bND.onChangeSkinType();
            al.h(this.cEB, e.d.cp_cont_i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_daily_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        boolean z = true;
        if (bbVar == null || bbVar.wm() == null || bbVar.wE() == null) {
            this.ecz.setVisibility(8);
            return;
        }
        this.bAn = bbVar;
        this.ecz.setVisibility(0);
        this.ecz.setOnClickListener(this);
        this.ect.setData(this.bAn);
        L(bbVar);
        akA();
        this.bgm.setText(ao.dj(this.bAn.wE().video_duration.intValue() * 1000));
        this.bgv.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.L(this.bAn.wE().play_count.intValue())));
        this.bND.amD = this.currentPageType;
        this.bND.setData(this.bAn);
        if (this.bAn == null || this.bAn.wE() == null) {
            z = false;
        } else if (this.bAn.wE().is_vertical.intValue() != 1) {
            z = false;
        }
        this.cEB.setVisibility(z ? 0 : 8);
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean L(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        bbVar.wW();
        SpannableStringBuilder wM = bbVar.wM();
        if (bbVar.wT() && !StringUtils.isNull(bbVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
            wM.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(wM));
        this.mTitle.setText(wM);
        o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akr() {
        if (o.lB(this.bAn.getId())) {
            o.a(this.mTitle, this.bAn.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void akA() {
        if (this.bgn != null && this.bgl != null) {
            if (i.uj().un() && this.bAn != null && this.bAn.wE() != null) {
                this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bgn.startLoad(this.bAn.wE().thumbnail_url, 10, false);
                this.bgl.setVisibility(0);
                return;
            }
            this.bgl.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.ecz) {
            aA(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bgl) {
            if (this.bAn != null && this.bAn.wE() != null) {
                z = this.bAn.wE().is_vertical.intValue() == 1;
            }
            if (z) {
                ay(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aL(getView());
            } else {
                aA(getView());
            }
        }
    }

    private void ay(View view) {
        if (akm() != null) {
            akm().a(view, this.bAn);
        }
        if (!j.kK()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            akw();
        }
    }

    private void akw() {
        if (this.bAn != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bAn);
            if (this.bAn.xR() == null) {
                videoItemData.forum_id = String.valueOf(this.bAn.getFid());
                videoItemData.forum_name = this.bAn.ws();
            } else {
                videoItemData.forum_id = this.bAn.xR().getForumId();
                videoItemData.forum_name = this.bAn.xR().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void aA(View view) {
        if (akm() != null) {
            akm().a(view, this.bAn);
        }
        if (this.bAn != null) {
            o.lA(this.bAn.getId());
            o.a(this.mTitle, this.bAn.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bAn, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bAn.xR() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bAn.getFid()));
                createFromThreadCfg.setForumName(this.bAn.ws());
            } else {
                createFromThreadCfg.setForumId(this.bAn.xR().getForumId());
                createFromThreadCfg.setForumName(this.bAn.xR().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void aL(View view) {
        if (akm() != null) {
            akm().a(view, this.bAn);
        }
        if (!j.kK()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            akx();
        }
    }

    private void akx() {
        if (this.bAn != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bAn);
            videoSerializeVideoThreadInfo.forumId = this.bAn.xR() != null ? this.bAn.xR().getForumId() : String.valueOf(this.bAn.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bgn.getX() + this.ebj.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bgn.getY() + this.ebj.getY());
            videoCardViewInfo.cardViewWidth = this.bgn.getWidth();
            videoCardViewInfo.cardViewHeight = this.bgn.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bAn.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int aFR() {
        if (this.ect == null || this.ect.getHeaderImg() == null) {
            return -1;
        }
        return this.ect.getHeaderImg().getId();
    }

    public int aFS() {
        if (this.ect == null || this.ect.getForumName() == null) {
            return -1;
        }
        return this.ect.getForumName().getId();
    }

    public int aFT() {
        if (this.ect == null || this.ect.getForumName() == null) {
            return -1;
        }
        return this.ect.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.bND != null) {
            this.bND.setShareReportFrom(i);
        }
    }

    public void nd(int i) {
        if (this.bND != null) {
            this.bND.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.bND != null) {
            this.bND.setStType(str);
        }
    }
}
