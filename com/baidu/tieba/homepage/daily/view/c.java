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
    private final View.OnClickListener aIy;
    private final View.OnClickListener aLq;
    private bb bNy;
    public FrameLayout boN;
    private TextView boO;
    private TbImageView boP;
    private ImageView boQ;
    private TextView boW;
    private TbImageView.a boY;
    private View byS;
    private TextView cXy;
    private ThreadCommentAndPraiseInfoLayout caM;
    private LinearLayout euj;
    private ThreadForumUserInfoLayout evs;
    private View evy;
    private String mStType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mStType = null;
        this.boY = new TbImageView.a() { // from class: com.baidu.tieba.homepage.daily.view.c.3
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && c.this.boP != null) {
                    c.this.boP.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.aIy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, c.this.bNy);
                }
            }
        };
        this.aLq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, c.this.bNy);
                }
            }
        };
        this.evy = getView();
        this.evs = (ThreadForumUserInfoLayout) this.evy.findViewById(e.g.forum_user_info_layout);
        this.evs.setForumAfterClickListener(this.aIy);
        this.evs.setLikeButtonAfterClickListener(this.aLq);
        this.euj = (LinearLayout) this.evy.findViewById(e.g.video_card_content_layout);
        this.mTitle = (TextView) this.evy.findViewById(e.g.thread_title);
        this.boN = (FrameLayout) this.evy.findViewById(e.g.frame_video);
        this.boN.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boN.getLayoutParams();
        layoutParams.width = l.aO(this.mTbPageContext.getPageActivity()) - l.h(this.mTbPageContext.getPageActivity(), e.C0210e.tbds88);
        layoutParams.height = (int) (0.5625d * layoutParams.width);
        this.boN.setLayoutParams(layoutParams);
        this.boP = (TbImageView) this.evy.findViewById(e.g.image_video);
        this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boP.setGifIconSupport(false);
        this.boP.setEvent(this.boY);
        this.boQ = (ImageView) this.evy.findViewById(e.g.image_video_play);
        this.boO = (TextView) this.evy.findViewById(e.g.text_video_duration);
        this.boW = (TextView) this.evy.findViewById(e.g.text_video_play_count);
        this.caM = (ThreadCommentAndPraiseInfoLayout) this.evy.findViewById(e.g.thread_comment_info_layout);
        this.caM.setOnClickListener(this);
        this.caM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, c.this.bNy);
                }
                if (c.this.bNy != null) {
                    o.mG(c.this.bNy.getId());
                    c.this.apX();
                }
            }
        });
        this.caM.setShowCommonView();
        this.byS = this.evy.findViewById(e.g.divider_line);
        this.cXy = (TextView) this.evy.findViewById(e.g.nani_video_icon);
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.evs != null) {
            this.evs.setPageUniqueId(bdUniqueId);
        }
        if (this.boP != null) {
            this.boP.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(this.evy, e.f.addresslist_item_bg);
            al.c(this.boQ, e.f.btn_icon_play_video_n);
            al.i(this.byS, e.d.cp_bg_line_e);
            al.h(this.boO, e.d.cp_cont_i);
            al.h(this.boW, e.d.cp_cont_i);
            this.evs.onChangeSkinType(i);
            this.caM.onChangeSkinType();
            al.h(this.cXy, e.d.cp_cont_i);
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
            this.evy.setVisibility(8);
            return;
        }
        this.bNy = bbVar;
        this.evy.setVisibility(0);
        this.evy.setOnClickListener(this);
        this.evs.setData(this.bNy);
        L(bbVar);
        aqg();
        this.boO.setText(ao.dV(this.bNy.zY().video_duration.intValue() * 1000));
        this.boW.setText(String.format(this.mContext.getResources().getString(e.j.play_count), ao.X(this.bNy.zY().play_count.intValue())));
        this.caM.avM = this.currentPageType;
        this.caM.setData(this.bNy);
        if (this.bNy == null || this.bNy.zY() == null) {
            z = false;
        } else if (this.bNy.zY().is_vertical.intValue() != 1) {
            z = false;
        }
        this.cXy.setVisibility(z ? 0 : 8);
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
    public void apX() {
        if (o.mH(this.bNy.getId())) {
            o.a(this.mTitle, this.bNy.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
    }

    private void aqg() {
        if (this.boP != null && this.boN != null) {
            if (i.xE().xI() && this.bNy != null && this.bNy.zY() != null) {
                this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boP.startLoad(this.bNy.zY().thumbnail_url, 10, false);
                this.boN.setVisibility(0);
                return;
            }
            this.boN.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = false;
        if (view == this.evy) {
            aF(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.boN) {
            if (this.bNy != null && this.bNy.zY() != null) {
                z = this.bNy.zY().is_vertical.intValue() == 1;
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
        if (apS() != null) {
            apS().a(view, this.bNy);
        }
        if (!j.kV()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqc();
        }
    }

    private void aqc() {
        if (this.bNy != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.bNy);
            if (this.bNy.Bl() == null) {
                videoItemData.forum_id = String.valueOf(this.bNy.getFid());
                videoItemData.forum_name = this.bNy.zM();
            } else {
                videoItemData.forum_id = this.bNy.Bl().getForumId();
                videoItemData.forum_name = this.bNy.Bl().getForumName();
            }
            arrayList.add(videoItemData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.mTbPageContext.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, this.mStType, "", "daily_tab")));
        }
    }

    private void aF(View view) {
        if (apS() != null) {
            apS().a(view, this.bNy);
        }
        if (this.bNy != null) {
            o.mG(this.bNy.getId());
            o.a(this.mTitle, this.bNy.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.bNy, null, this.mStType, 18003, true, false, false);
            createFromThreadCfg.setVideo_source("daily_tab");
            if (this.bNy.Bl() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.bNy.getFid()));
                createFromThreadCfg.setForumName(this.bNy.zM());
            } else {
                createFromThreadCfg.setForumId(this.bNy.Bl().getForumId());
                createFromThreadCfg.setForumName(this.bNy.Bl().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private void aQ(View view) {
        if (apS() != null) {
            apS().a(view, this.bNy);
        }
        if (!j.kV()) {
            l.showToast(this.mTbPageContext.getPageActivity(), e.j.no_network_guide);
        } else {
            aqd();
        }
    }

    private void aqd() {
        if (this.bNy != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.bNy);
            videoSerializeVideoThreadInfo.forumId = this.bNy.Bl() != null ? this.bNy.Bl().getForumId() : String.valueOf(this.bNy.getFid());
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.boP.getX() + this.euj.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.boP.getY() + this.euj.getY());
            videoCardViewInfo.cardViewWidth = this.boP.getWidth();
            videoCardViewInfo.cardViewHeight = this.boP.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.mTbPageContext.getPageActivity(), "daily_tab", this.bNy.getTid(), this.mStType, "", videoSerializeVideoThreadInfo)));
        }
    }

    public int aLn() {
        if (this.evs == null || this.evs.getHeaderImg() == null) {
            return -1;
        }
        return this.evs.getHeaderImg().getId();
    }

    public int aLo() {
        if (this.evs == null || this.evs.getForumName() == null) {
            return -1;
        }
        return this.evs.getForumName().getId();
    }

    public int aLp() {
        if (this.evs == null || this.evs.getForumName() == null) {
            return -1;
        }
        return this.evs.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.caM != null) {
            this.caM.setShareReportFrom(i);
        }
    }

    public void oA(int i) {
        if (this.caM != null) {
            this.caM.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.caM != null) {
            this.caM.setStType(str);
        }
    }
}
