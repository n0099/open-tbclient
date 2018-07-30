package com.baidu.tieba.homepage.daily.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.g;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<bb> {
    private final View.OnClickListener axz;
    private final View.OnClickListener azt;
    private ThreadCommentAndPraiseInfoLayout bHO;
    public FrameLayout bcQ;
    private TextView bcR;
    private TbImageView bcS;
    private ImageView bcT;
    private TextView bcZ;
    private TbImageView.a bdc;
    private View bkE;
    private bb buw;
    private TextView cyN;
    private LinearLayout dTV;
    private ThreadForumUserInfoLayout dVf;
    private View dVl;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && c.this.bcS != null) {
                    c.this.bcS.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.axz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, c.this.buw);
                }
            }
        };
        this.azt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, c.this.buw);
                }
            }
        };
        this.dVl = getView();
        this.dVf = (ThreadForumUserInfoLayout) this.dVl.findViewById(d.g.forum_user_info_layout);
        this.dVf.setForumAfterClickListener(this.axz);
        this.dVf.setLikeButtonAfterClickListener(this.azt);
        this.dTV = (LinearLayout) this.dVl.findViewById(d.g.video_card_content_layout);
        this.mTitle = (TextView) this.dVl.findViewById(d.g.thread_title);
        this.bcQ = (FrameLayout) this.dVl.findViewById(d.g.frame_video);
        this.bcQ.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcQ.getLayoutParams();
        layoutParams.width = l.ah(this.mTbPageContext.getPageActivity()) - l.f(this.mTbPageContext.getPageActivity(), d.e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.bcQ.setLayoutParams(layoutParams);
        this.bcS = (TbImageView) this.dVl.findViewById(d.g.image_video);
        this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcS.setGifIconSupport(false);
        this.bcS.setEvent(this.bdc);
        this.bcT = (ImageView) this.dVl.findViewById(d.g.image_video_play);
        this.bcR = (TextView) this.dVl.findViewById(d.g.text_video_duration);
        this.bcZ = (TextView) this.dVl.findViewById(d.g.text_video_play_count);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) this.dVl.findViewById(d.g.thread_comment_info_layout);
        this.bHO.setOnClickListener(this);
        this.bHO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, c.this.buw);
                }
                if (c.this.buw != null) {
                    o.kW(c.this.buw.getId());
                    c.this.aiE();
                }
            }
        });
        this.bHO.setShowCommonView();
        this.bkE = this.dVl.findViewById(d.g.divider_line);
        this.cyN = (TextView) this.dVl.findViewById(d.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.dVf != null) {
            this.dVf.setPageUniqueId(bdUniqueId);
        }
        if (this.bcS != null) {
            this.bcS.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.i(this.dVl, d.f.addresslist_item_bg);
            am.c(this.bcT, d.f.btn_icon_play_video_n);
            am.i(this.bkE, d.C0140d.cp_bg_line_e);
            am.h(this.bcR, d.C0140d.cp_cont_i);
            am.h(this.bcZ, d.C0140d.cp_cont_i);
            this.dVf.onChangeSkinType(i);
            this.bHO.onChangeSkinType();
            am.h(this.cyN, d.C0140d.cp_cont_i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_daily_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        boolean z = true;
        if (bbVar == null || bbVar.vk() == null || bbVar.vC() == null) {
            this.dVl.setVisibility(8);
            return;
        }
        this.buw = bbVar;
        this.dVl.setVisibility(0);
        this.dVl.setOnClickListener(this);
        this.dVf.setData(this.buw);
        K(bbVar);
        aiN();
        this.bcR.setText(ap.da(this.buw.vC().video_duration.intValue() * 1000));
        this.bcZ.setText(String.format(this.mContext.getResources().getString(d.j.play_count), ap.H(this.buw.vC().play_count.intValue())));
        this.bHO.ajY = this.currentPageType;
        this.bHO.setData(this.buw);
        if (this.buw == null || this.buw.vC() == null) {
            z = false;
        } else if (this.buw.vC().is_vertical.intValue() != 1) {
            z = false;
        }
        this.cyN.setVisibility(z ? 0 : 8);
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean K(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        bbVar.vS();
        SpannableStringBuilder vJ = bbVar.vJ();
        if (bbVar.vP() && !StringUtils.isNull(bbVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
            vJ.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0140d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(vJ));
        this.mTitle.setText(vJ);
        o.a(this.mTitle, bbVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiE() {
        if (o.kX(this.buw.getId())) {
            o.a(this.mTitle, this.buw.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
    }

    private void aiN() {
        if (this.bcS != null && this.bcQ != null) {
            if (i.te().tk() && this.buw != null && this.buw.vC() != null) {
                this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bcS.startLoad(this.buw.vC().thumbnail_url, 10, false);
                this.bcQ.setVisibility(0);
                return;
            }
            this.bcQ.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dVl) {
            am(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bcQ) {
            if (this.buw != null && this.buw.vC() != null) {
                z = this.buw.vC().is_vertical.intValue() == 1;
            }
            if (z) {
                ak(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                ax(getView());
            } else {
                am(getView());
            }
        }
    }

    private void ak(View view) {
        if (aiz() != null) {
            aiz().a(view, this.buw);
        }
        if (!j.jE()) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.no_network_guide);
        } else {
            aiJ();
        }
    }

    private void aiJ() {
        if (this.buw != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.buw);
            if (this.buw.wL() == null) {
                videoItemData.forum_id = String.valueOf(this.buw.getFid());
                videoItemData.forum_name = this.buw.vq();
            } else {
                videoItemData.forum_id = this.buw.wL().getForumId();
                videoItemData.forum_name = this.buw.wL().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void am(View view) {
        if (aiz() != null) {
            aiz().a(view, this.buw);
        }
        if (this.buw != null) {
            o.kW(this.buw.getId());
            o.a(this.mTitle, this.buw.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.buw, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.buw.wL() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.buw.getFid()));
                createFromThreadCfg.setForumName(this.buw.vq());
            } else {
                createFromThreadCfg.setForumId(this.buw.wL().getForumId());
                createFromThreadCfg.setForumName(this.buw.wL().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void ax(View view) {
        if (aiz() != null) {
            aiz().a(view, this.buw);
        }
        if (!j.jE()) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.no_network_guide);
        } else if (!j.jF() && !g.bAi().bAj()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(d.h.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.j.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.j.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, (Context) c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.homepage.daily.view.c.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.aiK();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.homepage.daily.view.c.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ch(1);
            aVar.cg(d.C0140d.cp_cont_b);
            aVar.au(true);
            aVar.b(this.mTbPageContext).xf();
        } else {
            aiK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        if (this.buw != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.buw);
            videoSerializeVideoThreadInfo.forumId = this.buw.wL() != null ? this.buw.wL().getForumId() : String.valueOf(this.buw.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bcS.getX() + this.dTV.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bcS.getY() + this.dTV.getY());
            videoCardViewInfo.cardViewWidth = this.bcS.getWidth();
            videoCardViewInfo.cardViewHeight = this.bcS.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.buw.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int aDH() {
        if (this.dVf == null || this.dVf.getHeaderImg() == null) {
            return -1;
        }
        return this.dVf.getHeaderImg().getId();
    }

    public int aDI() {
        if (this.dVf == null || this.dVf.getForumName() == null) {
            return -1;
        }
        return this.dVf.getForumName().getId();
    }

    public int aDJ() {
        if (this.dVf == null || this.dVf.getForumName() == null) {
            return -1;
        }
        return this.dVf.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.bHO != null) {
            this.bHO.setShareReportFrom(i);
        }
    }

    public void mz(int i) {
        if (this.bHO != null) {
            this.bHO.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.bHO != null) {
            this.bHO.setStType(str);
        }
    }
}
