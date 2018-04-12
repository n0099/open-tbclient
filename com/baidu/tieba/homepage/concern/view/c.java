package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<l> implements com.baidu.tieba.a.e {
    private TbPageContext<?> adf;
    private final View.OnClickListener aoY;
    private ImageView bkA;
    private String bvX;
    private HeadPendantClickableView bwV;
    public ThreadSourceShareAndPraiseLayout bwZ;
    private RelativeLayout bwi;
    public ThreadCommentAndPraiseInfoLayout bwk;
    private View bwn;
    private ThreadGodReplyLayout cma;
    private TbImageView.a coG;
    private final View.OnClickListener coJ;
    private final View.OnClickListener coK;
    private TbImageView cog;
    private TextView coh;
    public FrameLayout con;
    private TextView coq;
    private LinearLayout cor;
    private l cov;
    public ConcernThreadUserInfoLayout dBA;
    private LinearLayout dBF;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.coG = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && c.this.cog != null) {
                    c.this.cog.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.coJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.cov);
                }
            }
        };
        this.coK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(view2, c.this.cov);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cov != null) {
                    if (c.this.aeZ() != null) {
                        c.this.aeZ().a(view2, c.this.cov);
                    }
                    if (c.this.cov.bji != null && view2 != c.this.bwZ.apF) {
                        o.kv(c.this.cov.bji.getId());
                        c.this.afe();
                    }
                }
            }
        };
        this.adf = tbPageContext;
        this.currentPageType = 1;
        View view2 = getView();
        this.bwi = (RelativeLayout) view2.findViewById(d.g.layout_root);
        this.bwV = (HeadPendantClickableView) this.bwi.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bwV.getHeadView() != null) {
            this.bwV.getHeadView().setIsRound(true);
            this.bwV.getHeadView().setDrawBorder(false);
            this.bwV.getHeadView().setDefaultResource(17170445);
            this.bwV.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bwV.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bwV.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.ds70));
        }
        if (this.bwV.getPendantView() != null) {
            this.bwV.getPendantView().setIsRound(true);
            this.bwV.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view2.findViewById(d.g.text_title);
        this.dBA = (ConcernThreadUserInfoLayout) view2.findViewById(d.g.card_concern_video_user_info_layout);
        this.dBF = (LinearLayout) view2.findViewById(d.g.video_card_content_layout);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.text_bottom);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.bwk.setOnClickListener(this);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setIsBarViewVisible(false);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setShareVisible(true);
        this.bwk.setFrom(9);
        this.bwk.setShareReportFrom(4);
        this.bwk.setForumAfterClickListener(this.aoY);
        this.bwk.abV = this.currentPageType;
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_concern_video_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this);
        this.bwZ.setShareReportFrom(4);
        this.bwZ.setFrom(9);
        this.bwZ.apG.abV = this.currentPageType;
        this.bwZ.setForumAfterClickListener(this.aoY);
        this.bwi.setOnClickListener(this);
        this.con = (FrameLayout) view2.findViewById(d.g.frame_video);
        this.con.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.con.getLayoutParams();
        layoutParams2.width = com.baidu.adp.lib.util.l.af(this.adf.getPageActivity()) - com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.con.setLayoutParams(layoutParams2);
        this.cog = (TbImageView) view2.findViewById(d.g.image_video);
        this.cog.setDefaultErrorResource(0);
        this.cog.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cog.setGifIconSupport(false);
        this.cog.setEvent(this.coG);
        this.bkA = (ImageView) view2.findViewById(d.g.image_video_play);
        this.coq = (TextView) view2.findViewById(d.g.text_video_duration);
        this.cor = (LinearLayout) view2.findViewById(d.g.duration_container);
        this.coh = (TextView) view2.findViewById(d.g.text_video_play_count);
        this.bwn = view2.findViewById(d.g.divider_line);
        this.cma = (ThreadGodReplyLayout) view2.findViewById(d.g.card_god_reply_layout);
        this.cma.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.bwi, d.f.addresslist_item_bg);
            ak.c(this.bkA, d.f.btn_icon_play_video_n);
            this.dBA.onChangeSkinType();
            this.bwk.onChangeSkinType();
            this.bwZ.onChangeSkinType();
            ak.i(this.bwn, d.C0126d.cp_bg_line_e);
            ak.h(this.coq, d.C0126d.cp_cont_i);
            ak.h(this.coh, d.C0126d.cp_cont_i);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        this.cov = lVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.bwi || view2 == this.cma) {
            ah(view2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view2 == this.con) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                as(getView());
            } else {
                ah(getView());
            }
        }
    }

    private void as(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cov);
        }
        if (!j.gP()) {
            com.baidu.adp.lib.util.l.showToast(this.adf.getPageActivity(), d.k.no_network_guide);
        } else if (!j.gQ() && !com.baidu.tieba.video.f.bvW().bvX()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
            View inflate = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.video_no_wifi_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tv_title)).setText(d.k.confirm_title);
            ((TextView) inflate.findViewById(d.g.tv_msg)).setText(d.k.enter_video_center_page_no_wifi_tip);
            ((TextView) inflate.findViewById(d.g.tv_open_free_data)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    com.baidu.tbadk.browser.a.a(true, (Context) c.this.adf.getPageActivity(), c.this.adf.getPageActivity().getResources().getString(d.k.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                }
            });
            aVar.w(inflate);
            aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.afk();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.cc(1);
            aVar.cb(d.C0126d.cp_cont_b);
            aVar.ar(true);
            aVar.b(this.mTbPageContext).tD();
        } else {
            afk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        if (this.cov != null && this.cov.bji != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.cov.bji);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (getView().getX() + this.cog.getX() + this.dBF.getX());
            videoCardViewInfo.cardViewY = (int) (getView().getY() + this.cog.getY() + this.dBF.getY());
            videoCardViewInfo.cardViewWidth = this.cog.getWidth();
            videoCardViewInfo.cardViewHeight = this.cog.getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(this.adf.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cov.bji.getTid(), o.rG(), this.cov.afJ(), videoSerializeVideoThreadInfo)));
        }
    }

    private boolean afd() {
        return this.cov.csb && !this.cov.csl;
    }

    private void ah(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.cov);
        }
        if (this.cov != null && this.cov.bji != null) {
            if (!afd()) {
                o.kv(this.cov.bji.getId());
                o.a(this.mTextTitle, this.cov.bji.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.adf.getPageActivity()).createFromThreadCfg(this.cov.bji, null, o.rG(), 18003, true, false, false).addLocateParam(this.cov.afJ());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cov.bji.getFid()));
            addLocateParam.setForumName(this.cov.bji.rV());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view2 == this.cma) {
                addLocateParam.setJumpGodReply(true);
            }
            this.adf.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.cov == null || this.cov.bji == null || this.cov.bji.rQ() == null || this.cov.bji.sh() == null) {
            this.bwi.setVisibility(8);
            return;
        }
        this.bwi.setVisibility(0);
        afn();
        if (!afd() && o.kw(this.cov.bji.getId())) {
            o.a(this.mTextTitle, this.cov.bji.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.cma.getGodReplyContent(), this.cov.Pe().getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        }
        this.cov.Pe().sx();
        SpannableStringBuilder so = this.cov.Pe().so();
        if (this.cov.Pe().su() && !StringUtils.isNull(this.cov.Pe().getTid())) {
            final String str = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.cov.Pe().getTid();
            so.append((CharSequence) this.cov.Pe().a(new com.baidu.tbadk.widget.richText.c(2, str) { // from class: com.baidu.tieba.homepage.concern.view.c.5
                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                public void onClick(View view2) {
                    com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str);
                    TiebaStatic.log(new al("c12841").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1"));
                }

                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0126d.cp_link_tip_c));
                    textPaint.setUnderlineText(false);
                }
            }));
        }
        this.mTextTitle.setOnTouchListener(new com.baidu.tieba.view.j(so));
        this.mTextTitle.setText(so);
        this.dBA.setData(this.cov.Pe());
        this.dBA.setUserAfterClickListener(this.coJ);
        if (this.dBA.getHeaderImg() != null) {
            this.dBA.getHeaderImg().setAfterClickListener(this.coK);
            if (this.dBA.getIsSimpleThread()) {
                this.dBA.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (this.cov.Pe() == null || this.cov.Pe().rQ() == null || this.cov.Pe().rQ().getPendantData() == null || StringUtils.isNull(this.cov.Pe().rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.dBA.getHeaderImg().setVisibility(0);
                this.dBA.getHeaderImg().setData(this.cov.Pe());
            } else {
                this.dBA.getHeaderImg().setVisibility(4);
                this.bwV.setVisibility(0);
                this.bwV.setData(this.cov.Pe());
            }
        }
        this.coq.setText(an.cV(this.cov.bji.sh().video_duration.intValue() * 1000));
        this.coh.setText(String.format(this.adf.getResources().getString(d.k.play_count), an.B(this.cov.bji.sh().play_count.intValue())));
        this.cma.setData(this.cov.Pe().tc());
        this.cma.onChangeSkinType();
        d(this.adf, TbadkCoreApplication.getInst().getSkinType());
        if (o.kw(this.cov.bji.getId())) {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_d, 1);
        } else {
            ak.c(this.mTextTitle, d.C0126d.cp_cont_b, 1);
        }
        hc(gn(1));
    }

    private void afn() {
        if (this.cog != null && this.con != null) {
            if (i.pY().qe() && this.cov != null && this.cov.bji != null && this.cov.bji.sh() != null) {
                this.cog.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cog.startLoad(this.cov.bji.sh().thumbnail_url, 10, false);
                this.con.setVisibility(0);
                return;
            }
            this.con.setVisibility(8);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dBA != null) {
            this.dBA.setPageUniqueId(bdUniqueId);
        }
        if (this.cog != null) {
            this.cog.setPageId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afe() {
        if (this.cov != null && this.cov.bji != null) {
            o.a(this.mTextTitle, this.cov.bji.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.cma.getGodReplyContent(), this.cov.Pe().getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dBA != null) {
            return this.dBA.getHeaderImg();
        }
        return null;
    }

    public View afc() {
        if (this.dBA != null) {
            return this.dBA.apg;
        }
        return null;
    }

    public void hc(int i) {
        if (this.cov != null && this.cov.bji != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setStType(o.rG());
                this.bwZ.setData(this.cov.bji);
                this.dBA.showForumNameView(false);
                return;
            }
            this.bwk.setData(this.cov.bji);
            this.bwk.setStType(o.rG());
            this.bwZ.setVisibility(8);
            this.dBA.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
