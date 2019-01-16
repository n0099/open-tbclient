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
    private final View.OnClickListener aJa;
    private final View.OnClickListener aLS;
    private bb bOk;
    public FrameLayout bpB;
    private TextView bpC;
    private TbImageView bpD;
    private ImageView bpE;
    private TextView bpK;
    private TbImageView.a bpM;
    private View bzG;
    private TextView cYj;
    private ThreadCommentAndPraiseInfoLayout cbx;
    private LinearLayout euP;
    private ThreadForumUserInfoLayout evY;
    private View ewe;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.bpM = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && c.this.bpD != null) {
                    c.this.bpD.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.aJa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.bOk);
                }
            }
        };
        this.aLS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.bOk);
                }
            }
        };
        this.ewe = getView();
        this.evY = (ThreadForumUserInfoLayout) this.ewe.findViewById(e.g.forum_user_info_layout);
        this.evY.setForumAfterClickListener(this.aJa);
        this.evY.setLikeButtonAfterClickListener(this.aLS);
        this.euP = (LinearLayout) this.ewe.findViewById(e.g.video_card_content_layout);
        this.mTitle = (TextView) this.ewe.findViewById(e.g.thread_title);
        this.bpB = (FrameLayout) this.ewe.findViewById(e.g.frame_video);
        this.bpB.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bpB.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.bpB.setLayoutParams(layoutParams);
        this.bpD = (TbImageView) this.ewe.findViewById(e.g.image_video);
        this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpD.setGifIconSupport(false);
        this.bpD.setEvent(this.bpM);
        this.bpE = (ImageView) this.ewe.findViewById(e.g.image_video_play);
        this.bpC = (TextView) this.ewe.findViewById(e.g.text_video_duration);
        this.bpK = (TextView) this.ewe.findViewById(e.g.text_video_play_count);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) this.ewe.findViewById(e.g.thread_comment_info_layout);
        this.cbx.setOnClickListener(this);
        this.cbx.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aqp() != null) {
                    c.this.aqp().a(view, c.this.bOk);
                }
                if (c.this.bOk != null) {
                    o.mW(c.this.bOk.getId());
                    c.this.aqu();
                }
            }
        });
        this.cbx.setShowCommonView();
        this.bzG = this.ewe.findViewById(e.g.divider_line);
        this.cYj = (TextView) this.ewe.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.evY != null) {
            this.evY.setPageUniqueId(bdUniqueId);
        }
        if (this.bpD != null) {
            this.bpD.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.ewe, e.f.addresslist_item_bg);
            al.c(this.bpE, e.f.btn_icon_play_video_n);
            al.i(this.bzG, e.d.cp_bg_line_e);
            al.h(this.bpC, e.d.cp_cont_i);
            al.h(this.bpK, e.d.cp_cont_i);
            this.evY.onChangeSkinType(i);
            this.cbx.onChangeSkinType();
            al.h(this.cYj, e.d.cp_cont_i);
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
            this.ewe.setVisibility(8);
            return;
        }
        this.bOk = bbVar;
        this.ewe.setVisibility(0);
        this.ewe.setOnClickListener(this);
        this.evY.setData(this.bOk);
        L(bbVar);
        aqD();
        this.bpC.setText(ao.dV(this.bOk.Al().video_duration.intValue() * 1000));
        this.bpK.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.bOk.Al().play_count.intValue())));
        this.cbx.awo = this.currentPageType;
        this.cbx.setData(this.bOk);
        if (this.bOk == null || this.bOk.Al() == null) {
            z = false;
        } else if (this.bOk.Al().is_vertical.intValue() != 1) {
            z = false;
        }
        this.cYj.setVisibility(z ? 0 : 8);
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
        if (o.mX(this.bOk.getId())) {
            o.a(this.mTitle, this.bOk.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void aqD() {
        if (this.bpD != null && this.bpB != null) {
            if (i.xR().xV() && this.bOk != null && this.bOk.Al() != null) {
                this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpD.startLoad(this.bOk.Al().thumbnail_url, 10, false);
                this.bpB.setVisibility(0);
                return;
            }
            this.bpB.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.ewe) {
            aF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bpB) {
            if (this.bOk != null && this.bOk.Al() != null) {
                z = this.bOk.Al().is_vertical.intValue() == 1;
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
            aqp().a(view, this.bOk);
        }
        if (!j.kV()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqz();
        }
    }

    private void aqz() {
        if (this.bOk != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bOk);
            if (this.bOk.By() == null) {
                videoItemData.forum_id = String.valueOf(this.bOk.getFid());
                videoItemData.forum_name = this.bOk.zZ();
            } else {
                videoItemData.forum_id = this.bOk.By().getForumId();
                videoItemData.forum_name = this.bOk.By().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void aF(View view) {
        if (aqp() != null) {
            aqp().a(view, this.bOk);
        }
        if (this.bOk != null) {
            o.mW(this.bOk.getId());
            o.a(this.mTitle, this.bOk.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bOk, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bOk.By() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bOk.getFid()));
                createFromThreadCfg.setForumName(this.bOk.zZ());
            } else {
                createFromThreadCfg.setForumId(this.bOk.By().getForumId());
                createFromThreadCfg.setForumName(this.bOk.By().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void aQ(View view) {
        if (aqp() != null) {
            aqp().a(view, this.bOk);
        }
        if (!j.kV()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqA();
        }
    }

    private void aqA() {
        if (this.bOk != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bOk);
            videoSerializeVideoThreadInfo.forumId = this.bOk.By() != null ? this.bOk.By().getForumId() : String.valueOf(this.bOk.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bpD.getX() + this.euP.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bpD.getY() + this.euP.getY());
            videoCardViewInfo.cardViewWidth = this.bpD.getWidth();
            videoCardViewInfo.cardViewHeight = this.bpD.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bOk.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int aLL() {
        if (this.evY == null || this.evY.getHeaderImg() == null) {
            return -1;
        }
        return this.evY.getHeaderImg().getId();
    }

    public int aLM() {
        if (this.evY == null || this.evY.getForumName() == null) {
            return -1;
        }
        return this.evY.getForumName().getId();
    }

    public int aLN() {
        if (this.evY == null || this.evY.getForumName() == null) {
            return -1;
        }
        return this.evY.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.cbx != null) {
            this.cbx.setShareReportFrom(i);
        }
    }

    public void oB(int i) {
        if (this.cbx != null) {
            this.cbx.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.cbx != null) {
            this.cbx.setStType(str);
        }
    }
}
