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
    private final View.OnClickListener ZH;
    protected boolean ZQ;
    private PlayVoiceBntNew ZZ;
    private AppletsCellView aaI;
    protected View cKM;
    public ThreadUserInfoLayout dqx;
    protected ThreadCommentAndPraiseInfoLayout dqy;
    protected ThreadSourceShareAndPraiseLayout drn;
    public LinearLayout dry;
    private RelativeLayout eCg;
    protected View ehX;
    protected ConstrainImageGroup ehZ;
    private ThreadGodReplyLayout ehv;
    private HeadPendantClickableView ehw;
    private View.OnClickListener eie;
    private final View.OnClickListener eif;
    public TbImageView ejH;
    private TbImageView ejJ;
    private g fij;
    private String fit;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ZQ = true;
        this.eie = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bbD().bbE()) {
                    if (c.this.dqy != null) {
                        c.this.dqy.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.XS);
                }
                c.this.hL(view == c.this.ehv);
            }
        };
        this.eif = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aQf = c.this.aQf();
                if (aQf != null) {
                    view.setTag("2");
                    aQf.a(view, c.this.XS);
                }
            }
        };
        this.ZH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.XS);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.ehw = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.ehw.getHeadView() != null) {
            this.ehw.getHeadView().setIsRound(true);
            this.ehw.getHeadView().setDrawBorder(false);
            this.ehw.getHeadView().setDefaultResource(17170445);
            this.ehw.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehw.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.ehw.setHasPendantStyle();
        if (this.ehw.getPendantView() != null) {
            this.ehw.getPendantView().setIsRound(true);
            this.ehw.getPendantView().setDrawBorder(false);
        }
        this.ehw.setAfterClickListener(this.ZH);
        this.cKM = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.ZZ = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.ZZ.setAfterClickListener(this.eif);
        this.XK = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.XK.setVisibility(8);
        this.ehX = view.findViewById(d.g.divider_line_above_praise);
        this.ehZ = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.ehZ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.ehZ.setChildClickListener(this.eie);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.ehZ.setImageProcessor(fVar);
        this.dqy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.dqx = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.dqx.setUserAfterClickListener(this.ZH);
        this.dqx.setFrom(3);
        this.dqy.setOnClickListener(this.eie);
        this.dqy.setForumAfterClickListener(this.ZH);
        this.dqy.setReplyTimeVisible(false);
        this.dqy.setShowPraiseNum(true);
        this.dqy.setNeedAddPraiseIcon(true);
        this.dqy.setNeedAddReplyIcon(true);
        this.dqy.setIsBarViewVisible(false);
        this.dqy.setShareVisible(true);
        this.dqy.setShareReportFrom(1);
        this.dqy.setStType("frs_page");
        this.dqy.setFrom(2);
        this.dqy.setDisPraiseFrom(2);
        this.dqy.bSJ = 3;
        this.drn = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        if (this.drn != null) {
            this.drn.bTB.setOnClickListener(this.eie);
            this.drn.setFrom(2);
            this.drn.setShareReportFrom(1);
            this.drn.setSourceFromForPb(3);
            this.drn.setStType("frs_page");
            this.drn.setHideBarName(true);
            this.drn.bTB.setNeedAddReplyIcon(true);
        }
        this.eCg = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.fij = new g(this.mPageContext, this.eCg);
        this.fij.setUniqueId(getTag());
        this.ehv = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.ehv.setOnClickListener(this.eie);
        this.ejH = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ejH.setPageId(getTag());
        this.ejJ = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        if (this.ejJ != null) {
            this.ejJ.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(d.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dqy != null) {
                    c.this.dqy.changeSelectStatus();
                }
            }
        });
        this.dqy.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void dT(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(al.getColor(z ? d.C0277d.cp_bg_line_d : d.C0277d.transparent));
                }
            }
        });
        this.dry = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.aaI = (AppletsCellView) view.findViewById(d.g.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.ehZ != null) {
            this.ehZ.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ehZ != null) {
            this.ehZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ehZ != null) {
            this.ehZ.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.l(this.cKM, d.C0277d.cp_bg_line_e);
            this.ehZ.onChangeSkinType();
            this.dqy.onChangeSkinType();
            this.dqx.onChangeSkinType();
            if (this.aaI != null) {
                this.aaI.onChangeSkinType();
            }
            this.fij.onChangeSkinType();
            if (this.drn != null && this.drn.getVisibility() == 0) {
                this.drn.onChangeSkinType();
            }
            if (this.ehw != null && this.ehw.getHeadView() != null && (this.ehw.getHeadView() instanceof TbImageView)) {
                this.ehw.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
            getView().setOnClickListener(this.eie);
        }
        this.ehv.onChangeSkinType();
        if (!aQp() && n.tA(this.XS.getId())) {
            n.a(this.mTitle, this.XS.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.XK, this.XS.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            n.a(this.ehv.getGodReplyContent(), this.XS.getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
        b(bgVar);
        this.fij.am(this.XS);
        R(bgVar);
        this.dqx.setData(this.XS);
        this.ehv.setFromCDN(this.ZQ);
        this.ehv.setData(this.XS.aam());
        this.dqx.setUserAfterClickListener(this.ZH);
        mE(ls(1));
        if (this.dqx.getHeaderImg() != null) {
            if (this.dqx.getIsSimpleThread()) {
                this.dqx.getHeaderImg().setVisibility(8);
                this.ehw.setVisibility(8);
            } else if (bgVar.YO() == null || bgVar.YO().getPendantData() == null || StringUtils.isNull(bgVar.YO().getPendantData().Xk())) {
                this.ehw.setVisibility(8);
                this.dqx.getHeaderImg().setVisibility(0);
                this.dqx.getHeaderImg().setData(bgVar);
            } else {
                this.dqx.getHeaderImg().setVisibility(4);
                this.ehw.setVisibility(0);
                this.ehw.setData(bgVar);
            }
        }
        ag(bgVar);
        ah(bgVar);
        this.aaI.setData(bgVar.ZA());
        this.aaI.setForumId(String.valueOf(bgVar.getFid()));
        AppletsCellView appletsCellView = this.aaI;
        AppletsCellView appletsCellView2 = this.aaI;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> Zc = bgVar.Zc();
        if (v.T(Zc)) {
            this.ZZ.setVisibility(8);
        } else {
            this.ZZ.cfz();
            this.ZZ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Zc.get(0);
            this.ZZ.setVoiceModel(voiceModel);
            this.ZZ.setTag(voiceModel);
            this.ZZ.bxS();
            if (voiceModel != null) {
                this.ZZ.uq(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> YY = bgVar.YY();
        if (i.Wv().Wz() && v.S(YY) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < YY.size(); i++) {
                MediaData mediaData = (MediaData) v.c(YY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.S(linkedList) > 0) {
                this.ehZ.setVisibility(0);
                this.ehZ.setFromCDN(this.ZQ);
                this.ehZ.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aQf = c.this.aQf();
                        if (z) {
                            if (aQf != null) {
                                view.setTag("1");
                                aQf.Zw = true;
                                aQf.a(view, c.this.XS);
                            }
                            c.this.hL(false);
                            return;
                        }
                        if (aQf != null) {
                            view.setTag("1");
                            aQf.Zw = false;
                            aQf.a(view, c.this.XS);
                        }
                        c.this.a(view, linkedList, i2, bgVar);
                    }
                });
                this.ehZ.setImageMediaList(linkedList);
            } else {
                this.ehZ.setVisibility(8);
            }
        } else {
            this.ehZ.setVisibility(8);
        }
        aQw();
        aQx();
        bfR();
        if (this.dqy.isInFrsAllThread() && com.baidu.tieba.frs.a.bbD().bbE()) {
            this.mMaskView.setVisibility(0);
            if (this.XS.aax() || this.XS.aay()) {
                al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(d.C0277d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aQw() {
        if (this.ehX != null && this.ehZ != null && this.ehv != null) {
            if (this.ehZ.getVisibility() == 8 && this.ehv.getVisibility() == 8 && this.aaI.getVisibility() == 8) {
                this.ehX.setVisibility(0);
            } else {
                this.ehX.setVisibility(8);
            }
        }
    }

    private void R(final bg bgVar) {
        if (this.ejJ != null) {
            if (this.ejH == null || bgVar == null) {
                this.ejJ.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDz) && this.ejH.getVisibility() != 0) {
                if (this.fij != null && this.fij.bjk() && (this.ejJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ejJ.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.ejJ.setLayoutParams(layoutParams);
                }
                this.ejJ.setVisibility(0);
                this.ejJ.setImageDrawable(null);
                this.ejJ.startLoad(bgVar.bDz, 10, false);
                this.ejJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bgVar.bDA, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ejJ.setVisibility(8);
            }
        }
    }

    public void b(bg bgVar) {
        MetaData YO;
        if (bgVar != null && this.ejH != null && (YO = bgVar.YO()) != null) {
            final ThemeCardInUserData themeCard = YO.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ejH.setVisibility(8);
                return;
            }
            this.ejH.setVisibility(0);
            this.ejH.setImageDrawable(null);
            this.ejH.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ejH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.urlType = this.ZQ ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YT(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZQ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bgVar.getId();
            historyMessage.threadName = bgVar.getTitle();
            historyMessage.forumName = bgVar.YT();
            historyMessage.postID = bgVar.Ze();
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

    private void aQx() {
        this.ZZ.setClickable(true);
        int childCount = this.ehZ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ehZ.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dqy != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqx != null) {
            this.dqx.setPageUniqueId(bdUniqueId);
        }
        if (this.ehZ != null) {
            this.ehZ.setPageUniqueId(bdUniqueId);
        }
    }

    protected void hL(boolean z) {
        if (this.XS != null) {
            n.tz(this.XS.getId());
            n.a(this.mTitle, this.XS.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.XK, this.XS.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            n.a(this.ehv.getGodReplyContent(), this.XS.getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
            o ZR = this.XS.ZR();
            if (ZR != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.cY(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ZR.getCartoonId(), ZR.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.XS.bCP;
            if (this.XS.bCO == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.bxK;
                long j = lVar.bxL;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.mPageContext;
                amVar.bxY = str;
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
            if (this.XS.ZN() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aQp() {
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
    public void mC(int i) {
        this.currentPageType = i;
        if (this.dqy != null) {
            this.dqy.bSJ = i;
            if (i == 15) {
                this.dqy.setFrom(10);
            } else {
                this.dqy.setFrom(2);
                this.dqy.setDisPraiseFrom(2);
            }
        }
        if (this.dqx != null) {
            if (i == 15) {
                this.dqx.setFrom(5);
            } else {
                this.dqx.setFrom(3);
            }
        }
    }

    private boolean ag(bg bgVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fit)) {
            bgVar.bt(this.mUrl, this.fit);
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

    private void ah(bg bgVar) {
        if (bgVar != null && ls(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fit)) {
                bgVar.bt(this.mUrl, this.fit);
            }
            SpannableString aap = bgVar.aap();
            if (aap != null && !ap.isEmpty(aap.toString())) {
                this.XK.setVisibility(0);
                this.XK.setOnTouchListener(new k(aap));
                this.XK.setText(aap);
                n.a(this.XK, bgVar.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
                return;
            }
            this.XK.setVisibility(8);
            return;
        }
        this.XK.setVisibility(8);
    }

    private void bfR() {
        if (this.mTitle != null && this.ZZ != null && this.ehZ != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZZ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.ZZ.setLayoutParams(layoutParams);
            if (this.ZZ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ehZ.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.ehZ.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mE(int i) {
        if (this.XS != null) {
            if (i == 1) {
                this.dqy.setVisibility(8);
                if (this.drn != null) {
                    this.drn.setData(this.XS);
                    return;
                }
                return;
            }
            this.dqy.setData(this.XS);
            if (this.drn != null) {
                this.drn.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YA, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.ehZ != null) {
            this.ehZ.setPreloadSizeReadyCallback(bVar);
        }
    }
}
