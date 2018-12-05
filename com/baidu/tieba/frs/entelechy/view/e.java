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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    protected boolean aEq;
    protected bb aFf;
    private final View.OnClickListener aKA;
    protected View byP;
    private ThreadGodReplyLayout cSq;
    private View.OnClickListener cSt;
    private PlayVoiceBntNew cUX;
    protected View cUY;
    private TextView cUZ;
    protected ConstrainImageGroup cVa;
    private final View.OnClickListener cVd;
    public TbImageView cWG;
    private TbImageView cWI;
    public ThreadUserInfoLayout caI;
    protected ThreadCommentAndPraiseInfoLayout caJ;
    private String caw;
    public LinearLayout cbH;
    private HeadPendantClickableView cbt;
    protected ThreadSourceShareAndPraiseLayout cbw;
    private com.baidu.tieba.frs.vc.g dRj;
    private String dRu;
    private AppletsCellView dRv;
    private RelativeLayout dor;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aEq = true;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.azU().azV()) {
                    if (e.this.caJ != null) {
                        e.this.caJ.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (e.this.apc() != null) {
                    e.this.apc().a(view, e.this.aFf);
                }
                e.this.fn(view == e.this.cSq);
            }
        };
        this.cVd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> apc = e.this.apc();
                if (apc != null) {
                    view.setTag("2");
                    apc.a(view, e.this.aFf);
                }
            }
        };
        this.aKA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.apc() != null) {
                    e.this.apc().a(view, e.this.aFf);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cbt = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cbt.getHeadView() != null) {
            this.cbt.getHeadView().setIsRound(true);
            this.cbt.getHeadView().setDrawBorder(false);
            this.cbt.getHeadView().setDefaultResource(17170445);
            this.cbt.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbt.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbt.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbt.setHasPendantStyle();
        if (this.cbt.getPendantView() != null) {
            this.cbt.getPendantView().setIsRound(true);
            this.cbt.getPendantView().setDrawBorder(false);
        }
        this.cbt.setAfterClickListener(this.aKA);
        this.byP = view.findViewById(e.g.divider_line);
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cUX = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cUX.setAfterClickListener(this.cVd);
        this.cUZ = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cUZ.setVisibility(8);
        this.cUY = view.findViewById(e.g.divider_line_above_praise);
        this.cVa = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cVa.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        this.cVa.setChildClickListener(this.cSt);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cVa.setImageProcessor(eVar);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.caI = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.caI.setUserAfterClickListener(this.aKA);
        this.caI.setFrom(3);
        this.caJ.setOnClickListener(this.cSt);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setIsBarViewVisible(false);
        this.caJ.setShareVisible(true);
        this.caJ.setShareReportFrom(1);
        this.caJ.setStType("frs_page");
        this.caJ.setFrom(2);
        this.caJ.setDisPraiseFrom(2);
        this.caJ.avL = 3;
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        if (this.cbw != null) {
            this.cbw.aKi.setOnClickListener(this.cSt);
            this.cbw.setFrom(2);
            this.cbw.setShareReportFrom(1);
            this.cbw.setSourceFromForPb(3);
            this.cbw.setStType("frs_page");
            this.cbw.setHideBarName(true);
            this.cbw.aKi.setNeedAddReplyIcon(true);
        }
        this.dor = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.dRj = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.dor);
        this.dRj.setUniqueId(getTag());
        this.cSq = (ThreadGodReplyLayout) view.findViewById(e.g.card_frs_god_reply_layout);
        this.cSq.setOnClickListener(this.cSt);
        this.cWG = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.cWG.setPageId(getTag());
        this.cWI = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        if (this.cWI != null) {
            this.cWI.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.caJ != null) {
                    e.this.caJ.changeSelectStatus();
                }
            }
        });
        this.caJ.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bJ(boolean z) {
                if (e.this.mMaskView != null) {
                    e.this.mMaskView.setBackgroundColor(al.getColor(z ? e.d.cp_bg_line_d : e.d.transparent));
                }
            }
        });
        this.cbH = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.dRv = (AppletsCellView) view.findViewById(e.g.card_home_page_normal_thread_share_info);
    }

    public ThreadCommentAndPraiseInfoLayout aco() {
        return this.caJ;
    }

    public ThreadCommentAndPraiseInfoLayout acp() {
        if (this.cbw != null) {
            return this.cbw.aKi;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.cVa != null) {
            this.cVa.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cVa != null) {
            this.cVa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cVa != null) {
            this.cVa.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.byP, e.d.cp_bg_line_e);
            this.cVa.onChangeSkinType();
            this.caJ.onChangeSkinType();
            this.caI.onChangeSkinType();
            this.dRj.onChangeSkinType();
            if (this.cbw != null && this.cbw.getVisibility() == 0) {
                this.cbw.onChangeSkinType();
            }
            if (this.dRv != null) {
                this.dRv.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(final bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aFf = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        this.cSq.onChangeSkinType();
        if (!apg() && o.mE(this.aFf.getId())) {
            o.a(this.mTitle, this.aFf.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cUZ, this.aFf.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cSq.getGodReplyContent(), this.aFf.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        Q(bbVar);
        this.dRj.af(this.aFf);
        N(bbVar);
        this.caI.setData(this.aFf);
        this.cSq.setFromCDN(this.aEq);
        this.cSq.setData(this.aFf.AX());
        this.caI.setUserAfterClickListener(this.aKA);
        iL(hC(1));
        if (this.caI.getHeaderImg() != null) {
            if (this.caI.getIsSimpleThread()) {
                this.caI.getHeaderImg().setVisibility(8);
                this.cbt.setVisibility(8);
            } else if (bbVar.zG() == null || bbVar.zG().getPendantData() == null || StringUtils.isNull(bbVar.zG().getPendantData().ys())) {
                this.cbt.setVisibility(8);
                this.caI.getHeaderImg().setVisibility(0);
                this.caI.getHeaderImg().setData(bbVar);
            } else {
                this.caI.getHeaderImg().setVisibility(4);
                this.cbt.setVisibility(0);
                this.cbt.setData(bbVar);
            }
        }
        L(bbVar);
        M(bbVar);
        this.dRv.setData(bbVar.Am());
        this.dRv.setForumId(String.valueOf(bbVar.getFid()));
        AppletsCellView appletsCellView = this.dRv;
        AppletsCellView appletsCellView2 = this.dRv;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> zV = bbVar.zV();
        if (v.I(zV)) {
            this.cUX.setVisibility(8);
        } else {
            this.cUX.bEC();
            this.cUX.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zV.get(0);
            this.cUX.setVoiceModel(voiceModel);
            this.cUX.setTag(voiceModel);
            this.cUX.aWg();
            if (voiceModel != null) {
                this.cUX.qw(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> zR = bbVar.zR();
        if (com.baidu.tbadk.core.i.xE().xI() && v.H(zR) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < zR.size(); i++) {
                MediaData mediaData = (MediaData) v.d(zR, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.H(linkedList) > 0) {
                this.cVa.setVisibility(0);
                this.cVa.setFromCDN(this.aEq);
                this.cVa.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> apc = e.this.apc();
                        if (z) {
                            if (apc != null) {
                                view.setTag("1");
                                apc.bvK = true;
                                apc.a(view, e.this.aFf);
                            }
                            e.this.fn(false);
                            return;
                        }
                        if (apc != null) {
                            view.setTag("1");
                            apc.bvK = false;
                            apc.a(view, e.this.aFf);
                        }
                        e.this.a(view, linkedList, i2, bbVar);
                    }
                });
                this.cVa.setImageMediaList(linkedList);
            } else {
                this.cVa.setVisibility(8);
            }
        } else {
            this.cVa.setVisibility(8);
        }
        apv();
        apw();
        aEj();
        if (this.caJ.isInFrsAllThread() && com.baidu.tieba.frs.a.azU().azV()) {
            this.mMaskView.setVisibility(0);
            if (this.aFf.Bh() || this.aFf.Bi()) {
                al.j(this.mMaskView, e.d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(e.d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void apv() {
        if (this.cUY != null && this.cVa != null && this.cSq != null) {
            if (this.cVa.getVisibility() == 8 && this.cSq.getVisibility() == 8 && this.dRv.getVisibility() == 8) {
                this.cUY.setVisibility(0);
            } else {
                this.cUY.setVisibility(8);
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.cWI != null) {
            if (this.cWG == null || bbVar == null) {
                this.cWI.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avu) && this.cWG.getVisibility() != 0) {
                if (this.dRj != null && this.dRj.aHs() && (this.cWI.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cWI.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.cWI.setLayoutParams(layoutParams);
                }
                this.cWI.setVisibility(0);
                this.cWI.setImageDrawable(null);
                this.cWI.startLoad(bbVar.avu, 10, false);
                this.cWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bbVar.avv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cWI.setVisibility(8);
            }
        }
    }

    public void Q(bb bbVar) {
        MetaData zG;
        if (bbVar != null && this.cWG != null && (zG = bbVar.zG()) != null) {
            final ThemeCardInUserData themeCard = zG.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cWG.setVisibility(8);
                return;
            }
            this.cWG.setVisibility(0);
            this.cWG.setImageDrawable(null);
            this.cWG.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.aEq ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bbVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.I(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zM(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEq, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bbVar.getId();
            historyMessage.threadName = bbVar.getTitle();
            historyMessage.forumName = bbVar.zM();
            historyMessage.postID = bbVar.zX();
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

    private void apw() {
        this.cUX.setClickable(true);
        int childCount = this.cVa.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cVa.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aEq = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.caJ != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.caI != null) {
            this.caI.setPageUniqueId(bdUniqueId);
        }
        if (this.cVa != null) {
            this.cVa.setPageUniqueId(bdUniqueId);
        }
    }

    protected void fn(boolean z) {
        if (this.aFf != null) {
            o.mD(this.aFf.getId());
            o.a(this.mTitle, this.aFf.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cUZ, this.aFf.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cSq.getGodReplyContent(), this.aFf.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            m AB = this.aFf.AB();
            if (AB != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bI(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), AB.getCartoonId(), AB.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aFf.auP;
            if (this.aFf.auO == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aqo;
                long j = jVar.aqp;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aqC = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aFf, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aFf.Ax() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean apg() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iJ(int i) {
        this.currentPageType = i;
        if (this.caJ != null) {
            this.caJ.avL = i;
            if (i == 15) {
                this.caJ.setFrom(10);
            } else {
                this.caJ.setFrom(2);
                this.caJ.setDisPraiseFrom(2);
            }
        }
        if (this.caI != null) {
            if (i == 15) {
                this.caI.setFrom(5);
            } else {
                this.caI.setFrom(3);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cUX != null) {
            this.cUX.setVoiceManager(voiceManager);
        }
    }

    private boolean L(bb bbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dRu)) {
            bbVar.al(this.mUrl, this.dRu);
        }
        SpannableStringBuilder i = bbVar.i(false, true);
        if (i == null || StringUtils.isNull(i.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        return true;
    }

    private void M(bb bbVar) {
        if (bbVar != null && hC(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dRu)) {
                bbVar.al(this.mUrl, this.dRu);
            }
            SpannableString AZ = bbVar.AZ();
            if (AZ != null && !ao.isEmpty(AZ.toString())) {
                this.cUZ.setVisibility(0);
                this.cUZ.setOnTouchListener(new k(AZ));
                this.cUZ.setText(AZ);
                o.a(this.cUZ, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cUZ.setVisibility(8);
            return;
        }
        this.cUZ.setVisibility(8);
    }

    private void aEj() {
        if (this.mTitle != null && this.cUX != null && this.cVa != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUX.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds20);
            this.cUX.setLayoutParams(layoutParams);
            if (this.cUX.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cVa.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds28);
                this.cVa.setLayoutParams(layoutParams2);
            }
        }
    }

    public void iL(int i) {
        if (this.aFf != null) {
            if (i == 1) {
                this.caJ.setVisibility(8);
                if (this.cbw != null) {
                    this.cbw.setData(this.aFf);
                    return;
                }
                return;
            }
            this.caJ.setData(this.aFf);
            if (this.cbw != null) {
                this.cbw.setVisibility(8);
            }
        }
    }

    public void al(String str, String str2) {
        this.mUrl = str;
        this.dRu = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cVa != null) {
            this.cVa.setPreloadSizeReadyCallback(bVar);
        }
    }
}
