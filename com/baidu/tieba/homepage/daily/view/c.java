package com.baidu.tieba.homepage.daily.view;

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
import com.baidu.tieba.f;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.g;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<bb> {
    private final View.OnClickListener axw;
    private final View.OnClickListener azq;
    private ThreadCommentAndPraiseInfoLayout bHO;
    public FrameLayout bcQ;
    private TextView bcR;
    private TbImageView bcS;
    private ImageView bcT;
    private TextView bcZ;
    private TbImageView.a bdc;
    private View bkJ;
    private bb buy;
    private TextView cyK;
    private LinearLayout dTQ;
    private ThreadForumUserInfoLayout dVa;
    private View dVg;
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
        this.axw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, c.this.buy);
                }
            }
        };
        this.azq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, c.this.buy);
                }
            }
        };
        this.dVg = getView();
        this.dVa = (ThreadForumUserInfoLayout) this.dVg.findViewById(f.g.forum_user_info_layout);
        this.dVa.setForumAfterClickListener(this.axw);
        this.dVa.setLikeButtonAfterClickListener(this.azq);
        this.dTQ = (LinearLayout) this.dVg.findViewById(f.g.video_card_content_layout);
        this.mTitle = (TextView) this.dVg.findViewById(f.g.thread_title);
        this.bcQ = (FrameLayout) this.dVg.findViewById(f.g.frame_video);
        this.bcQ.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcQ.getLayoutParams();
        layoutParams.width = l.ah(this.mTbPageContext.getPageActivity()) - l.f(this.mTbPageContext.getPageActivity(), f.e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.bcQ.setLayoutParams(layoutParams);
        this.bcS = (TbImageView) this.dVg.findViewById(f.g.image_video);
        this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.bcS.setGifIconSupport(false);
        this.bcS.setEvent(this.bdc);
        this.bcT = (ImageView) this.dVg.findViewById(f.g.image_video_play);
        this.bcR = (TextView) this.dVg.findViewById(f.g.text_video_duration);
        this.bcZ = (TextView) this.dVg.findViewById(f.g.text_video_play_count);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) this.dVg.findViewById(f.g.thread_comment_info_layout);
        this.bHO.setOnClickListener(this);
        this.bHO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, c.this.buy);
                }
                if (c.this.buy != null) {
                    o.kY(c.this.buy.getId());
                    c.this.aiH();
                }
            }
        });
        this.bHO.setShowCommonView();
        this.bkJ = this.dVg.findViewById(f.g.divider_line);
        this.cyK = (TextView) this.dVg.findViewById(f.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.dVa != null) {
            this.dVa.setPageUniqueId(bdUniqueId);
        }
        if (this.bcS != null) {
            this.bcS.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.i(this.dVg, f.C0146f.addresslist_item_bg);
            am.c(this.bcT, f.C0146f.btn_icon_play_video_n);
            am.i(this.bkJ, f.d.cp_bg_line_e);
            am.h(this.bcR, f.d.cp_cont_i);
            am.h(this.bcZ, f.d.cp_cont_i);
            this.dVa.onChangeSkinType(i);
            this.bHO.onChangeSkinType();
            am.h(this.cyK, f.d.cp_cont_i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_daily_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        boolean z = true;
        if (bbVar == null || bbVar.vj() == null || bbVar.vB() == null) {
            this.dVg.setVisibility(8);
            return;
        }
        this.buy = bbVar;
        this.dVg.setVisibility(0);
        this.dVg.setOnClickListener(this);
        this.dVa.setData(this.buy);
        K(bbVar);
        aiQ();
        this.bcR.setText(ap.da(this.buy.vB().video_duration.intValue() * 1000));
        this.bcZ.setText(String.format(this.mContext.getResources().getString(f.j.play_count), ap.H(this.buy.vB().play_count.intValue())));
        this.bHO.ajY = this.currentPageType;
        this.bHO.setData(this.buy);
        if (this.buy == null || this.buy.vB() == null) {
            z = false;
        } else if (this.buy.vB().is_vertical.intValue() != 1) {
            z = false;
        }
        this.cyK.setVisibility(z ? 0 : 8);
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean K(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        bbVar.vR();
        SpannableStringBuilder vI = bbVar.vI();
        if (bbVar.vO() && !StringUtils.isNull(bbVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
            vI.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new an("c12841").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(f.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(vI));
        this.mTitle.setText(vI);
        o.a(this.mTitle, bbVar.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (o.kZ(this.buy.getId())) {
            o.a(this.mTitle, this.buy.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        }
    }

    private void aiQ() {
        if (this.bcS != null && this.bcQ != null) {
            if (i.td().tj() && this.buy != null && this.buy.vB() != null) {
                this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
                this.bcS.startLoad(this.buy.vB().thumbnail_url, 10, false);
                this.bcQ.setVisibility(0);
                return;
            }
            this.bcQ.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.dVg) {
            am(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.bcQ) {
            if (this.buy != null && this.buy.vB() != null) {
                z = this.buy.vB().is_vertical.intValue() == 1;
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
        if (aiC() != null) {
            aiC().a(view, this.buy);
        }
        if (!j.jE()) {
            l.showToast(this.mTbPageContext.getPageActivity(), f.j.no_network_guide);
        } else {
            aiM();
        }
    }

    private void aiM() {
        if (this.buy != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.buy);
            if (this.buy.wK() == null) {
                videoItemData.forum_id = String.valueOf(this.buy.getFid());
                videoItemData.forum_name = this.buy.vp();
            } else {
                videoItemData.forum_id = this.buy.wK().getForumId();
                videoItemData.forum_name = this.buy.wK().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void am(View view) {
        if (aiC() != null) {
            aiC().a(view, this.buy);
        }
        if (this.buy != null) {
            o.kY(this.buy.getId());
            o.a(this.mTitle, this.buy.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.buy, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.buy.wK() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.buy.getFid()));
                createFromThreadCfg.setForumName(this.buy.vp());
            } else {
                createFromThreadCfg.setForumId(this.buy.wK().getForumId());
                createFromThreadCfg.setForumName(this.buy.wK().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void ax(View view) {
        if (aiC() != null) {
            aiC().a(view, this.buy);
        }
        if (!j.jE()) {
            l.showToast(this.mTbPageContext.getPageActivity(), f.j.no_network_guide);
        } else if (!j.jF() && !g.bAk().bAl()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mTbPageContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(f.h.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(f.g.tv_title)).setText(f.j.confirm_title);
            ((TextView) inflate.findViewById(f.g.tv_msg)).setText(f.j.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(f.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.a(true, c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getResources().getString(f.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.homepage.daily.view.c.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.aiN();
                }
            });
            aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.homepage.daily.view.c.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ch(1);
            aVar.cg(f.d.cp_cont_b);
            aVar.av(true);
            aVar.b(this.mTbPageContext).xe();
        } else {
            aiN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiN() {
        if (this.buy != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.buy);
            videoSerializeVideoThreadInfo.forumId = this.buy.wK() != null ? this.buy.wK().getForumId() : String.valueOf(this.buy.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.bcS.getX() + this.dTQ.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.bcS.getY() + this.dTQ.getY());
            videoCardViewInfo.cardViewWidth = this.bcS.getWidth();
            videoCardViewInfo.cardViewHeight = this.bcS.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.buy.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int aDE() {
        if (this.dVa == null || this.dVa.getHeaderImg() == null) {
            return -1;
        }
        return this.dVa.getHeaderImg().getId();
    }

    public int aDF() {
        if (this.dVa == null || this.dVa.getForumName() == null) {
            return -1;
        }
        return this.dVa.getForumName().getId();
    }

    public int aDG() {
        if (this.dVa == null || this.dVa.getForumName() == null) {
            return -1;
        }
        return this.dVa.getForumName().getId();
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
