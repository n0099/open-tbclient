package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.vc.g;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<bg> implements com.baidu.tieba.a.e, z {
    private TextView XK;
    protected bg XS;
    private String YA;
    private final View.OnClickListener ZG;
    protected boolean ZP;
    private PlayVoiceBntNew ZY;
    private AppletsCellView aaH;
    protected View cKK;
    public ThreadUserInfoLayout dqu;
    protected ThreadCommentAndPraiseInfoLayout dqv;
    protected ThreadSourceShareAndPraiseLayout drk;
    public LinearLayout drv;
    private RelativeLayout eCv;
    private ThreadGodReplyLayout ehJ;
    private HeadPendantClickableView ehK;
    protected View eil;
    protected ConstrainImageGroup ein;
    private View.OnClickListener eis;
    private final View.OnClickListener eit;
    public TbImageView ejV;
    private TbImageView ejX;
    private String fiI;
    private g fiy;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ZP = true;
        this.eis = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bbF().bbG()) {
                    if (c.this.dqv != null) {
                        c.this.dqv.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.aQh() != null) {
                    c.this.aQh().a(view, c.this.XS);
                }
                c.this.hL(view == c.this.ehJ);
            }
        };
        this.eit = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aQh = c.this.aQh();
                if (aQh != null) {
                    view.setTag("2");
                    aQh.a(view, c.this.XS);
                }
            }
        };
        this.ZG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQh() != null) {
                    c.this.aQh().a(view, c.this.XS);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.ehK = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.ehK.getHeadView() != null) {
            this.ehK.getHeadView().setIsRound(true);
            this.ehK.getHeadView().setDrawBorder(false);
            this.ehK.getHeadView().setDefaultResource(17170445);
            this.ehK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehK.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.ehK.setHasPendantStyle();
        if (this.ehK.getPendantView() != null) {
            this.ehK.getPendantView().setIsRound(true);
            this.ehK.getPendantView().setDrawBorder(false);
        }
        this.ehK.setAfterClickListener(this.ZG);
        this.cKK = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.ZY = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.ZY.setAfterClickListener(this.eit);
        this.XK = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.XK.setVisibility(8);
        this.eil = view.findViewById(d.g.divider_line_above_praise);
        this.ein = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.ein.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.ein.setChildClickListener(this.eis);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.ein.setImageProcessor(fVar);
        this.dqv = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.dqu = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.dqu.setUserAfterClickListener(this.ZG);
        this.dqu.setFrom(3);
        this.dqv.setOnClickListener(this.eis);
        this.dqv.setForumAfterClickListener(this.ZG);
        this.dqv.setReplyTimeVisible(false);
        this.dqv.setShowPraiseNum(true);
        this.dqv.setNeedAddPraiseIcon(true);
        this.dqv.setNeedAddReplyIcon(true);
        this.dqv.setIsBarViewVisible(false);
        this.dqv.setShareVisible(true);
        this.dqv.setShareReportFrom(1);
        this.dqv.setStType("frs_page");
        this.dqv.setFrom(2);
        this.dqv.setDisPraiseFrom(2);
        this.dqv.bSH = 3;
        this.drk = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        if (this.drk != null) {
            this.drk.bTz.setOnClickListener(this.eis);
            this.drk.setFrom(2);
            this.drk.setShareReportFrom(1);
            this.drk.setSourceFromForPb(3);
            this.drk.setStType("frs_page");
            this.drk.setHideBarName(true);
            this.drk.bTz.setNeedAddReplyIcon(true);
        }
        this.eCv = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.fiy = new g(this.mPageContext, this.eCv);
        this.fiy.setUniqueId(getTag());
        this.ehJ = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.ehJ.setOnClickListener(this.eis);
        this.ejV = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ejV.setPageId(getTag());
        this.ejX = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        if (this.ejX != null) {
            this.ejX.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(d.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dqv != null) {
                    c.this.dqv.changeSelectStatus();
                }
            }
        });
        this.dqv.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void dT(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(al.getColor(z ? d.C0277d.cp_bg_line_d : d.C0277d.transparent));
                }
            }
        });
        this.drv = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.aaH = (AppletsCellView) view.findViewById(d.g.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.ein != null) {
            this.ein.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ein != null) {
            this.ein.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ein != null) {
            this.ein.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.l(this.cKK, d.C0277d.cp_bg_line_e);
            this.ein.onChangeSkinType();
            this.dqv.onChangeSkinType();
            this.dqu.onChangeSkinType();
            if (this.aaH != null) {
                this.aaH.onChangeSkinType();
            }
            this.fiy.onChangeSkinType();
            if (this.drk != null && this.drk.getVisibility() == 0) {
                this.drk.onChangeSkinType();
            }
            if (this.ehK != null && this.ehK.getHeadView() != null && (this.ehK.getHeadView() instanceof TbImageView)) {
                this.ehK.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(final bg bgVar) {
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.XS = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eis);
        }
        this.ehJ.onChangeSkinType();
        if (!aQr() && n.tB(this.XS.getId())) {
            n.a(this.mTitle, this.XS.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.XK, this.XS.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            n.a(this.ehJ.getGodReplyContent(), this.XS.getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
        b(bgVar);
        this.fiy.an(this.XS);
        S(bgVar);
        this.dqu.setData(this.XS);
        this.ehJ.setFromCDN(this.ZP);
        this.ehJ.setData(this.XS.aap());
        this.dqu.setUserAfterClickListener(this.ZG);
        mF(lt(1));
        if (this.dqu.getHeaderImg() != null) {
            if (this.dqu.getIsSimpleThread()) {
                this.dqu.getHeaderImg().setVisibility(8);
                this.ehK.setVisibility(8);
            } else if (bgVar.YR() == null || bgVar.YR().getPendantData() == null || StringUtils.isNull(bgVar.YR().getPendantData().Xn())) {
                this.ehK.setVisibility(8);
                this.dqu.getHeaderImg().setVisibility(0);
                this.dqu.getHeaderImg().setData(bgVar);
            } else {
                this.dqu.getHeaderImg().setVisibility(4);
                this.ehK.setVisibility(0);
                this.ehK.setData(bgVar);
            }
        }
        ah(bgVar);
        ai(bgVar);
        this.aaH.setData(bgVar.ZD());
        this.aaH.setForumId(String.valueOf(bgVar.getFid()));
        AppletsCellView appletsCellView = this.aaH;
        AppletsCellView appletsCellView2 = this.aaH;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> Zf = bgVar.Zf();
        if (v.T(Zf)) {
            this.ZY.setVisibility(8);
        } else {
            this.ZY.cfD();
            this.ZY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Zf.get(0);
            this.ZY.setVoiceModel(voiceModel);
            this.ZY.setTag(voiceModel);
            this.ZY.bxV();
            if (voiceModel != null) {
                this.ZY.uu(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> Zb = bgVar.Zb();
        if (i.Wy().WC() && v.S(Zb) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < Zb.size(); i++) {
                MediaData mediaData = (MediaData) v.c(Zb, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.S(linkedList) > 0) {
                this.ein.setVisibility(0);
                this.ein.setFromCDN(this.ZP);
                this.ein.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aQh = c.this.aQh();
                        if (z) {
                            if (aQh != null) {
                                view.setTag("1");
                                aQh.Zw = true;
                                aQh.a(view, c.this.XS);
                            }
                            c.this.hL(false);
                            return;
                        }
                        if (aQh != null) {
                            view.setTag("1");
                            aQh.Zw = false;
                            aQh.a(view, c.this.XS);
                        }
                        c.this.a(view, linkedList, i2, bgVar);
                    }
                });
                this.ein.setImageMediaList(linkedList);
            } else {
                this.ein.setVisibility(8);
            }
        } else {
            this.ein.setVisibility(8);
        }
        aQy();
        aQz();
        bfT();
        if (this.dqv.isInFrsAllThread() && com.baidu.tieba.frs.a.bbF().bbG()) {
            this.mMaskView.setVisibility(0);
            if (this.XS.aaA() || this.XS.aaB()) {
                al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(d.C0277d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aQy() {
        if (this.eil != null && this.ein != null && this.ehJ != null) {
            if (this.ein.getVisibility() == 8 && this.ehJ.getVisibility() == 8 && this.aaH.getVisibility() == 8) {
                this.eil.setVisibility(0);
            } else {
                this.eil.setVisibility(8);
            }
        }
    }

    private void S(final bg bgVar) {
        if (this.ejX != null) {
            if (this.ejV == null || bgVar == null) {
                this.ejX.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDw) && this.ejV.getVisibility() != 0) {
                if (this.fiy != null && this.fiy.bjm() && (this.ejX.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ejX.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.ejX.setLayoutParams(layoutParams);
                }
                this.ejX.setVisibility(0);
                this.ejX.setImageDrawable(null);
                this.ejX.startLoad(bgVar.bDw, 10, false);
                this.ejX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bgVar.bDx, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ejX.setVisibility(8);
            }
        }
    }

    public void b(bg bgVar) {
        MetaData YR;
        if (bgVar != null && this.ejV != null && (YR = bgVar.YR()) != null) {
            final ThemeCardInUserData themeCard = YR.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ejV.setVisibility(8);
                return;
            }
            this.ejV.setVisibility(0);
            this.ejV.setImageDrawable(null);
            this.ejV.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ejV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            String str = null;
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                str = mediaData.getSrc_pic();
            } else if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                str = mediaData.getPicUrl();
            }
            if (!StringUtils.isNull(str)) {
                arrayList.add(str);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.ZP ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bgVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.T(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YW(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZP, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bgVar.getId();
            historyMessage.threadName = bgVar.getTitle();
            historyMessage.forumName = bgVar.YW();
            historyMessage.postID = bgVar.Zh();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private String a(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            return mediaData.getSrc_pic();
        }
        return picUrl;
    }

    private void aQz() {
        this.ZY.setClickable(true);
        int childCount = this.ein.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ein.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dqv != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqu != null) {
            this.dqu.setPageUniqueId(bdUniqueId);
        }
        if (this.ein != null) {
            this.ein.setPageUniqueId(bdUniqueId);
        }
    }

    protected void hL(boolean z) {
        if (this.XS != null) {
            n.tA(this.XS.getId());
            n.a(this.mTitle, this.XS.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.XK, this.XS.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            n.a(this.ehJ.getGodReplyContent(), this.XS.getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
            o ZU = this.XS.ZU();
            if (ZU != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.cY(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ZU.getCartoonId(), ZU.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.XS.bCM;
            if (this.XS.bCL == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.bxH;
                long j = lVar.bxI;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.mPageContext;
                amVar.bxV = str;
                amVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.XS, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.XS.ZQ() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aQr() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mD(int i) {
        this.currentPageType = i;
        if (this.dqv != null) {
            this.dqv.bSH = i;
            if (i == 15) {
                this.dqv.setFrom(10);
            } else {
                this.dqv.setFrom(2);
                this.dqv.setDisPraiseFrom(2);
            }
        }
        if (this.dqu != null) {
            if (i == 15) {
                this.dqu.setFrom(5);
            } else {
                this.dqu.setFrom(3);
            }
        }
    }

    private boolean ah(bg bgVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fiI)) {
            bgVar.bt(this.mUrl, this.fiI);
        }
        SpannableStringBuilder m = bgVar.m(false, true);
        if (m == null || StringUtils.isNull(m.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(m));
            this.mTitle.setText(m);
            n.a(this.mTitle, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
        return true;
    }

    private void ai(bg bgVar) {
        if (bgVar != null && lt(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fiI)) {
                bgVar.bt(this.mUrl, this.fiI);
            }
            SpannableString aas = bgVar.aas();
            if (aas != null && !ap.isEmpty(aas.toString())) {
                this.XK.setVisibility(0);
                this.XK.setOnTouchListener(new k(aas));
                this.XK.setText(aas);
                n.a(this.XK, bgVar.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
                return;
            }
            this.XK.setVisibility(8);
            return;
        }
        this.XK.setVisibility(8);
    }

    private void bfT() {
        if (this.mTitle != null && this.ZY != null && this.ein != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.ZY.setLayoutParams(layoutParams);
            if (this.ZY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ein.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.ein.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mF(int i) {
        if (this.XS != null) {
            if (i == 1) {
                this.dqv.setVisibility(8);
                if (this.drk != null) {
                    this.drk.setData(this.XS);
                    return;
                }
                return;
            }
            this.dqv.setData(this.XS);
            if (this.drk != null) {
                this.drk.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.YA, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.ein != null) {
            this.ein.setPreloadSizeReadyCallback(bVar);
        }
    }
}
