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
    private TextView XL;
    protected bg XT;
    private String YB;
    private final View.OnClickListener ZI;
    protected boolean ZR;
    private AppletsCellView aaJ;
    private PlayVoiceBntNew aaa;
    protected View cKN;
    public ThreadUserInfoLayout dqy;
    protected ThreadCommentAndPraiseInfoLayout dqz;
    protected ThreadSourceShareAndPraiseLayout dro;
    public LinearLayout drz;
    private RelativeLayout eCh;
    protected View ehY;
    private ThreadGodReplyLayout ehw;
    private HeadPendantClickableView ehx;
    protected ConstrainImageGroup eia;
    private View.OnClickListener eif;
    private final View.OnClickListener eig;
    public TbImageView ejI;
    private TbImageView ejK;
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
        this.ZR = true;
        this.eif = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bbD().bbE()) {
                    if (c.this.dqz != null) {
                        c.this.dqz.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.XT);
                }
                c.this.hL(view == c.this.ehw);
            }
        };
        this.eig = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aQf = c.this.aQf();
                if (aQf != null) {
                    view.setTag("2");
                    aQf.a(view, c.this.XT);
                }
            }
        };
        this.ZI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aQf() != null) {
                    c.this.aQf().a(view, c.this.XT);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.ehx = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.ehx.getHeadView() != null) {
            this.ehx.getHeadView().setIsRound(true);
            this.ehx.getHeadView().setDrawBorder(false);
            this.ehx.getHeadView().setDefaultResource(17170445);
            this.ehx.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehx.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.ehx.setHasPendantStyle();
        if (this.ehx.getPendantView() != null) {
            this.ehx.getPendantView().setIsRound(true);
            this.ehx.getPendantView().setDrawBorder(false);
        }
        this.ehx.setAfterClickListener(this.ZI);
        this.cKN = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.aaa = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.aaa.setAfterClickListener(this.eig);
        this.XL = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.XL.setVisibility(8);
        this.ehY = view.findViewById(d.g.divider_line_above_praise);
        this.eia = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.eia.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.eia.setChildClickListener(this.eif);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.eia.setImageProcessor(fVar);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.dqy = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.dqy.setUserAfterClickListener(this.ZI);
        this.dqy.setFrom(3);
        this.dqz.setOnClickListener(this.eif);
        this.dqz.setForumAfterClickListener(this.ZI);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setShareVisible(true);
        this.dqz.setShareReportFrom(1);
        this.dqz.setStType("frs_page");
        this.dqz.setFrom(2);
        this.dqz.setDisPraiseFrom(2);
        this.dqz.bSK = 3;
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        if (this.dro != null) {
            this.dro.bTC.setOnClickListener(this.eif);
            this.dro.setFrom(2);
            this.dro.setShareReportFrom(1);
            this.dro.setSourceFromForPb(3);
            this.dro.setStType("frs_page");
            this.dro.setHideBarName(true);
            this.dro.bTC.setNeedAddReplyIcon(true);
        }
        this.eCh = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.fij = new g(this.mPageContext, this.eCh);
        this.fij.setUniqueId(getTag());
        this.ehw = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.ehw.setOnClickListener(this.eif);
        this.ejI = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ejI.setPageId(getTag());
        this.ejK = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        if (this.ejK != null) {
            this.ejK.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(d.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dqz != null) {
                    c.this.dqz.changeSelectStatus();
                }
            }
        });
        this.dqz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void dT(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(al.getColor(z ? d.C0277d.cp_bg_line_d : d.C0277d.transparent));
                }
            }
        });
        this.drz = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.aaJ = (AppletsCellView) view.findViewById(d.g.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.eia != null) {
            this.eia.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eia != null) {
            this.eia.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eia != null) {
            this.eia.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            al.l(this.cKN, d.C0277d.cp_bg_line_e);
            this.eia.onChangeSkinType();
            this.dqz.onChangeSkinType();
            this.dqy.onChangeSkinType();
            if (this.aaJ != null) {
                this.aaJ.onChangeSkinType();
            }
            this.fij.onChangeSkinType();
            if (this.dro != null && this.dro.getVisibility() == 0) {
                this.dro.onChangeSkinType();
            }
            if (this.ehx != null && this.ehx.getHeadView() != null && (this.ehx.getHeadView() instanceof TbImageView)) {
                this.ehx.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.XT = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eif);
        }
        this.ehw.onChangeSkinType();
        if (!aQp() && n.tA(this.XT.getId())) {
            n.a(this.mTitle, this.XT.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.XL, this.XT.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            n.a(this.ehw.getGodReplyContent(), this.XT.getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
        }
        b(bgVar);
        this.fij.am(this.XT);
        R(bgVar);
        this.dqy.setData(this.XT);
        this.ehw.setFromCDN(this.ZR);
        this.ehw.setData(this.XT.aam());
        this.dqy.setUserAfterClickListener(this.ZI);
        mE(ls(1));
        if (this.dqy.getHeaderImg() != null) {
            if (this.dqy.getIsSimpleThread()) {
                this.dqy.getHeaderImg().setVisibility(8);
                this.ehx.setVisibility(8);
            } else if (bgVar.YO() == null || bgVar.YO().getPendantData() == null || StringUtils.isNull(bgVar.YO().getPendantData().Xk())) {
                this.ehx.setVisibility(8);
                this.dqy.getHeaderImg().setVisibility(0);
                this.dqy.getHeaderImg().setData(bgVar);
            } else {
                this.dqy.getHeaderImg().setVisibility(4);
                this.ehx.setVisibility(0);
                this.ehx.setData(bgVar);
            }
        }
        ag(bgVar);
        ah(bgVar);
        this.aaJ.setData(bgVar.ZA());
        this.aaJ.setForumId(String.valueOf(bgVar.getFid()));
        AppletsCellView appletsCellView = this.aaJ;
        AppletsCellView appletsCellView2 = this.aaJ;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> Zc = bgVar.Zc();
        if (v.T(Zc)) {
            this.aaa.setVisibility(8);
        } else {
            this.aaa.cfz();
            this.aaa.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Zc.get(0);
            this.aaa.setVoiceModel(voiceModel);
            this.aaa.setTag(voiceModel);
            this.aaa.bxS();
            if (voiceModel != null) {
                this.aaa.uq(voiceModel.voice_status.intValue());
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
                this.eia.setVisibility(0);
                this.eia.setFromCDN(this.ZR);
                this.eia.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aQf = c.this.aQf();
                        if (z) {
                            if (aQf != null) {
                                view.setTag("1");
                                aQf.Zx = true;
                                aQf.a(view, c.this.XT);
                            }
                            c.this.hL(false);
                            return;
                        }
                        if (aQf != null) {
                            view.setTag("1");
                            aQf.Zx = false;
                            aQf.a(view, c.this.XT);
                        }
                        c.this.a(view, linkedList, i2, bgVar);
                    }
                });
                this.eia.setImageMediaList(linkedList);
            } else {
                this.eia.setVisibility(8);
            }
        } else {
            this.eia.setVisibility(8);
        }
        aQw();
        aQx();
        bfR();
        if (this.dqz.isInFrsAllThread() && com.baidu.tieba.frs.a.bbD().bbE()) {
            this.mMaskView.setVisibility(0);
            if (this.XT.aax() || this.XT.aay()) {
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
        if (this.ehY != null && this.eia != null && this.ehw != null) {
            if (this.eia.getVisibility() == 8 && this.ehw.getVisibility() == 8 && this.aaJ.getVisibility() == 8) {
                this.ehY.setVisibility(0);
            } else {
                this.ehY.setVisibility(8);
            }
        }
    }

    private void R(final bg bgVar) {
        if (this.ejK != null) {
            if (this.ejI == null || bgVar == null) {
                this.ejK.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bDA) && this.ejI.getVisibility() != 0) {
                if (this.fij != null && this.fij.bjk() && (this.ejK.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ejK.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.ejK.setLayoutParams(layoutParams);
                }
                this.ejK.setVisibility(0);
                this.ejK.setImageDrawable(null);
                this.ejK.startLoad(bgVar.bDA, 10, false);
                this.ejK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bgVar.bDB, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ejK.setVisibility(8);
            }
        }
    }

    public void b(bg bgVar) {
        MetaData YO;
        if (bgVar != null && this.ejI != null && (YO = bgVar.YO()) != null) {
            final ThemeCardInUserData themeCard = YO.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ejI.setVisibility(8);
                return;
            }
            this.ejI.setVisibility(0);
            this.ejI.setImageDrawable(null);
            this.ejI.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ejI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.urlType = this.ZR ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YT(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        this.aaa.setClickable(true);
        int childCount = this.eia.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eia.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dqz != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqy != null) {
            this.dqy.setPageUniqueId(bdUniqueId);
        }
        if (this.eia != null) {
            this.eia.setPageUniqueId(bdUniqueId);
        }
    }

    protected void hL(boolean z) {
        if (this.XT != null) {
            n.tz(this.XT.getId());
            n.a(this.mTitle, this.XT.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.XL, this.XT.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            n.a(this.ehw.getGodReplyContent(), this.XT.getId(), d.C0277d.cp_cont_f, d.C0277d.cp_cont_d);
            o ZR = this.XT.ZR();
            if (ZR != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.cY(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ZR.getCartoonId(), ZR.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.XT.bCQ;
            if (this.XT.bCP == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.bxL;
                long j = lVar.bxM;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.mPageContext;
                amVar.bxZ = str;
                amVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.XT, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.XT.ZN() && addLocateParam.getIntent() != null) {
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
        if (this.dqz != null) {
            this.dqz.bSK = i;
            if (i == 15) {
                this.dqz.setFrom(10);
            } else {
                this.dqz.setFrom(2);
                this.dqz.setDisPraiseFrom(2);
            }
        }
        if (this.dqy != null) {
            if (i == 15) {
                this.dqy.setFrom(5);
            } else {
                this.dqy.setFrom(3);
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
                this.XL.setVisibility(0);
                this.XL.setOnTouchListener(new k(aap));
                this.XL.setText(aap);
                n.a(this.XL, bgVar.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
                return;
            }
            this.XL.setVisibility(8);
            return;
        }
        this.XL.setVisibility(8);
    }

    private void bfR() {
        if (this.mTitle != null && this.aaa != null && this.eia != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aaa.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.aaa.setLayoutParams(layoutParams);
            if (this.aaa.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eia.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.eia.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mE(int i) {
        if (this.XT != null) {
            if (i == 1) {
                this.dqz.setVisibility(8);
                if (this.dro != null) {
                    this.dro.setData(this.XT);
                    return;
                }
                return;
            }
            this.dqz.setData(this.XT);
            if (this.dro != null) {
                this.dro.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YB, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eia != null) {
            this.eia.setPreloadSizeReadyCallback(bVar);
        }
    }
}
