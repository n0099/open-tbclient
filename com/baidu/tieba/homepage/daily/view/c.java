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
    private final View.OnClickListener aIx;
    private final View.OnClickListener aLo;
    private bb bNv;
    public FrameLayout boK;
    private TextView boL;
    private TbImageView boM;
    private ImageView boN;
    private TextView boT;
    private TbImageView.a boV;
    private View byP;
    private TextView cUI;
    private ThreadCommentAndPraiseInfoLayout caJ;
    private LinearLayout ers;
    private ThreadForumUserInfoLayout esB;
    private View esH;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.boV = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && c.this.boM != null) {
                    c.this.boM.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.aIx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, c.this.bNv);
                }
            }
        };
        this.aLo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, c.this.bNv);
                }
            }
        };
        this.esH = getView();
        this.esB = (ThreadForumUserInfoLayout) this.esH.findViewById(e.g.forum_user_info_layout);
        this.esB.setForumAfterClickListener(this.aIx);
        this.esB.setLikeButtonAfterClickListener(this.aLo);
        this.ers = (LinearLayout) this.esH.findViewById(e.g.video_card_content_layout);
        this.mTitle = (TextView) this.esH.findViewById(e.g.thread_title);
        this.boK = (FrameLayout) this.esH.findViewById(e.g.frame_video);
        this.boK.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boK.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.boK.setLayoutParams(layoutParams);
        this.boM = (TbImageView) this.esH.findViewById(e.g.image_video);
        this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boM.setGifIconSupport(false);
        this.boM.setEvent(this.boV);
        this.boN = (ImageView) this.esH.findViewById(e.g.image_video_play);
        this.boL = (TextView) this.esH.findViewById(e.g.text_video_duration);
        this.boT = (TextView) this.esH.findViewById(e.g.text_video_play_count);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) this.esH.findViewById(e.g.thread_comment_info_layout);
        this.caJ.setOnClickListener(this);
        this.caJ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, c.this.bNv);
                }
                if (c.this.bNv != null) {
                    o.mD(c.this.bNv.getId());
                    c.this.aph();
                }
            }
        });
        this.caJ.setShowCommonView();
        this.byP = this.esH.findViewById(e.g.divider_line);
        this.cUI = (TextView) this.esH.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.esB != null) {
            this.esB.setPageUniqueId(bdUniqueId);
        }
        if (this.boM != null) {
            this.boM.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.esH, e.f.addresslist_item_bg);
            al.c(this.boN, e.f.btn_icon_play_video_n);
            al.i(this.byP, e.d.cp_bg_line_e);
            al.h(this.boL, e.d.cp_cont_i);
            al.h(this.boT, e.d.cp_cont_i);
            this.esB.onChangeSkinType(i);
            this.caJ.onChangeSkinType();
            al.h(this.cUI, e.d.cp_cont_i);
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
        if (bbVar == null || bbVar.zG() == null || bbVar.zY() == null) {
            this.esH.setVisibility(8);
            return;
        }
        this.bNv = bbVar;
        this.esH.setVisibility(0);
        this.esH.setOnClickListener(this);
        this.esB.setData(this.bNv);
        L(bbVar);
        apr();
        this.boL.setText(ao.dV(this.bNv.zY().video_duration.intValue() * 1000));
        this.boT.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.W(this.bNv.zY().play_count.intValue())));
        this.caJ.avL = this.currentPageType;
        this.caJ.setData(this.bNv);
        if (this.bNv == null || this.bNv.zY() == null) {
            z = false;
        } else if (this.bNv.zY().is_vertical.intValue() != 1) {
            z = false;
        }
        this.cUI.setVisibility(z ? 0 : 8);
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean L(bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        bbVar.Aq();
        SpannableStringBuilder Ag = bbVar.Ag();
        if (bbVar.An() && !StringUtils.isNull(bbVar.getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + bbVar.getTid();
            Ag.append((CharSequence) bbVar.a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.daily.view.c.2
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new am("c12841").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTitle.setOnTouchListener(new k(Ag));
        this.mTitle.setText(Ag);
        o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aph() {
        if (o.mE(this.bNv.getId())) {
            o.a(this.mTitle, this.bNv.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void apr() {
        if (this.boM != null && this.boK != null) {
            if (i.xE().xI() && this.bNv != null && this.bNv.zY() != null) {
                this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boM.startLoad(this.bNv.zY().thumbnail_url, 10, false);
                this.boK.setVisibility(0);
                return;
            }
            this.boK.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.esH) {
            aC(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.boK) {
            if (this.bNv != null && this.bNv.zY() != null) {
                z = this.bNv.zY().is_vertical.intValue() == 1;
            }
            if (z) {
                aA(view);
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                aN(getView());
            } else {
                aC(getView());
            }
        }
    }

    private void aA(View view) {
        if (apc() != null) {
            apc().a(view, this.bNv);
        }
        if (!j.kV()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            apn();
        }
    }

    private void apn() {
        if (this.bNv != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bNv);
            if (this.bNv.Bl() == null) {
                videoItemData.forum_id = String.valueOf(this.bNv.getFid());
                videoItemData.forum_name = this.bNv.zM();
            } else {
                videoItemData.forum_id = this.bNv.Bl().getForumId();
                videoItemData.forum_name = this.bNv.Bl().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void aC(View view) {
        if (apc() != null) {
            apc().a(view, this.bNv);
        }
        if (this.bNv != null) {
            o.mD(this.bNv.getId());
            o.a(this.mTitle, this.bNv.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bNv, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bNv.Bl() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bNv.getFid()));
                createFromThreadCfg.setForumName(this.bNv.zM());
            } else {
                createFromThreadCfg.setForumId(this.bNv.Bl().getForumId());
                createFromThreadCfg.setForumName(this.bNv.Bl().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void aN(View view) {
        if (apc() != null) {
            apc().a(view, this.bNv);
        }
        if (!j.kV()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            apo();
        }
    }

    private void apo() {
        if (this.bNv != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bNv);
            videoSerializeVideoThreadInfo.forumId = this.bNv.Bl() != null ? this.bNv.Bl().getForumId() : String.valueOf(this.bNv.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.boM.getX() + this.ers.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.boM.getY() + this.ers.getY());
            videoCardViewInfo.cardViewWidth = this.boM.getWidth();
            videoCardViewInfo.cardViewHeight = this.boM.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bNv.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int aKy() {
        if (this.esB == null || this.esB.getHeaderImg() == null) {
            return -1;
        }
        return this.esB.getHeaderImg().getId();
    }

    public int aKz() {
        if (this.esB == null || this.esB.getForumName() == null) {
            return -1;
        }
        return this.esB.getForumName().getId();
    }

    public int aKA() {
        if (this.esB == null || this.esB.getForumName() == null) {
            return -1;
        }
        return this.esB.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.caJ != null) {
            this.caJ.setShareReportFrom(i);
        }
    }

    public void on(int i) {
        if (this.caJ != null) {
            this.caJ.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.caJ != null) {
            this.caJ.setStType(str);
        }
    }
}
