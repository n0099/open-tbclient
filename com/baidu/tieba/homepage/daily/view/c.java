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
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<bb> {
    private final View.OnClickListener aJb;
    private final View.OnClickListener aLT;
    private bb bOl;
    public FrameLayout bpC;
    private TextView bpD;
    private TbImageView bpE;
    private ImageView bpF;
    private TextView bpL;
    private TbImageView.a bpN;
    private View bzH;
    private TextView cYk;
    private ThreadCommentAndPraiseInfoLayout cby;
    private LinearLayout euQ;
    private ThreadForumUserInfoLayout evZ;
    private View ewf;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.bpN = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && c.this.bpE != null) {
                    c.this.bpE.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.aJb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.bOl);
                }
            }
        };
        this.aLT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.bOl);
                }
            }
        };
        this.ewf = getView();
        this.evZ = (ThreadForumUserInfoLayout) this.ewf.findViewById(e.g.forum_user_info_layout);
        this.evZ.setForumAfterClickListener(this.aJb);
        this.evZ.setLikeButtonAfterClickListener(this.aLT);
        this.euQ = (LinearLayout) this.ewf.findViewById(e.g.video_card_content_layout);
        this.mTitle = (TextView) this.ewf.findViewById(e.g.thread_title);
        this.bpC = (FrameLayout) this.ewf.findViewById(e.g.frame_video);
        this.bpC.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bpC.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.bpC.setLayoutParams(layoutParams);
        this.bpE = (TbImageView) this.ewf.findViewById(e.g.image_video);
        this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpE.setGifIconSupport(false);
        this.bpE.setEvent(this.bpN);
        this.bpF = (ImageView) this.ewf.findViewById(e.g.image_video_play);
        this.bpD = (TextView) this.ewf.findViewById(e.g.text_video_duration);
        this.bpL = (TextView) this.ewf.findViewById(e.g.text_video_play_count);
        this.cby = (ThreadCommentAndPraiseInfoLayout) this.ewf.findViewById(e.g.thread_comment_info_layout);
        this.cby.setOnClickListener(this);
        this.cby.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.bOl);
                }
                if (c.this.bOl != null) {
                    o.mW(c.this.bOl.getId());
                    c.this.aqu();
                }
            }
        });
        this.cby.setShowCommonView();
        this.bzH = this.ewf.findViewById(e.g.divider_line);
        this.cYk = (TextView) this.ewf.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.evZ != null) {
            this.evZ.setPageUniqueId(bdUniqueId);
        }
        if (this.bpE != null) {
            this.bpE.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.ewf, e.f.addresslist_item_bg);
            al.c(this.bpF, e.f.btn_icon_play_video_n);
            al.i(this.bzH, e.d.cp_bg_line_e);
            al.h(this.bpD, e.d.cp_cont_i);
            al.h(this.bpL, e.d.cp_cont_i);
            this.evZ.onChangeSkinType(i);
            this.cby.onChangeSkinType();
            al.h(this.cYk, e.d.cp_cont_i);
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
        if (bbVar == null || bbVar.zT() == null || bbVar.Al() == null) {
            this.ewf.setVisibility(8);
            return;
        }
        this.bOl = bbVar;
        this.ewf.setVisibility(0);
        this.ewf.setOnClickListener(this);
        this.evZ.setData(this.bOl);
        L(bbVar);
        aqD();
        this.bpD.setText(ao.dV(this.bOl.Al().video_duration.intValue() * 1000));
        this.bpL.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.bOl.Al().play_count.intValue())));
        this.cby.awp = this.currentPageType;
        this.cby.setData(this.bOl);
        if (this.bOl == null || this.bOl.Al() == null) {
            z = false;
        } else if (this.bOl.Al().is_vertical.intValue() != 1) {
            z = false;
        }
        this.cYk.setVisibility(z ? 0 : 8);
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean L(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        bbVar.AD();
        SpannableStringBuilder At = bbVar.At();
        if (bbVar.AA() && !StringUtils.isNull(bbVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
            At.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(At));
        this.mTitle.setText(At);
        o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqu() {
        if (o.mX(this.bOl.getId())) {
            o.a(this.mTitle, this.bOl.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void aqD() {
        if (this.bpE != null && this.bpC != null) {
            if (i.xR().xV() && this.bOl != null && this.bOl.Al() != null) {
                this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpE.startLoad(this.bOl.Al().thumbnail_url, 10, false);
                this.bpC.setVisibility(0);
                return;
            }
            this.bpC.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.ewf) {
            aF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bpC) {
            if (this.bOl != null && this.bOl.Al() != null) {
                z = this.bOl.Al().is_vertical.intValue() == 1;
            }
            if (z) {
                aD(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aQ(getView());
            } else {
                aF(getView());
            }
        }
    }

    private void aD(View view) {
        if (aqp() != null) {
            aqp().a(view, this.bOl);
        }
        if (!j.kV()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqz();
        }
    }

    private void aqz() {
        if (this.bOl != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bOl);
            if (this.bOl.By() == null) {
                videoItemData.forum_id = String.valueOf(this.bOl.getFid());
                videoItemData.forum_name = this.bOl.zZ();
            } else {
                videoItemData.forum_id = this.bOl.By().getForumId();
                videoItemData.forum_name = this.bOl.By().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void aF(View view) {
        if (aqp() != null) {
            aqp().a(view, this.bOl);
        }
        if (this.bOl != null) {
            o.mW(this.bOl.getId());
            o.a(this.mTitle, this.bOl.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bOl, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bOl.By() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bOl.getFid()));
                createFromThreadCfg.setForumName(this.bOl.zZ());
            } else {
                createFromThreadCfg.setForumId(this.bOl.By().getForumId());
                createFromThreadCfg.setForumName(this.bOl.By().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void aQ(View view) {
        if (aqp() != null) {
            aqp().a(view, this.bOl);
        }
        if (!j.kV()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqA();
        }
    }

    private void aqA() {
        if (this.bOl != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bOl);
            videoSerializeVideoThreadInfo.forumId = this.bOl.By() != null ? this.bOl.By().getForumId() : String.valueOf(this.bOl.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bpE.getX() + this.euQ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bpE.getY() + this.euQ.getY());
            videoCardViewInfo.cardViewWidth = this.bpE.getWidth();
            videoCardViewInfo.cardViewHeight = this.bpE.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bOl.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int aLL() {
        if (this.evZ == null || this.evZ.getHeaderImg() == null) {
            return -1;
        }
        return this.evZ.getHeaderImg().getId();
    }

    public int aLM() {
        if (this.evZ == null || this.evZ.getForumName() == null) {
            return -1;
        }
        return this.evZ.getForumName().getId();
    }

    public int aLN() {
        if (this.evZ == null || this.evZ.getForumName() == null) {
            return -1;
        }
        return this.evZ.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.cby != null) {
            this.cby.setShareReportFrom(i);
        }
    }

    public void oB(int i) {
        if (this.cby != null) {
            this.cby.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.cby != null) {
            this.cby.setStType(str);
        }
    }
}
