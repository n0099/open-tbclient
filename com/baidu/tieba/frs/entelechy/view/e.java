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
    protected boolean aEr;
    protected bb aFg;
    private final View.OnClickListener aKC;
    protected View byS;
    private ThreadGodReplyLayout cVg;
    private View.OnClickListener cVj;
    private PlayVoiceBntNew cXN;
    protected View cXO;
    private TextView cXP;
    protected ConstrainImageGroup cXQ;
    private final View.OnClickListener cXT;
    public TbImageView cZw;
    private TbImageView cZy;
    public ThreadUserInfoLayout caL;
    protected ThreadCommentAndPraiseInfoLayout caM;
    private String caz;
    public LinearLayout cbK;
    private HeadPendantClickableView cbw;
    protected ThreadSourceShareAndPraiseLayout cbz;
    private com.baidu.tieba.frs.vc.g dUa;
    private String dUl;
    private AppletsCellView dUm;
    private RelativeLayout drh;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aEr = true;
        this.cVj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.aAJ().aAK()) {
                    if (e.this.caM != null) {
                        e.this.caM.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (e.this.apS() != null) {
                    e.this.apS().a(view, e.this.aFg);
                }
                e.this.fp(view == e.this.cVg);
            }
        };
        this.cXT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> apS = e.this.apS();
                if (apS != null) {
                    view.setTag("2");
                    apS.a(view, e.this.aFg);
                }
            }
        };
        this.aKC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.apS() != null) {
                    e.this.apS().a(view, e.this.aFg);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cbw = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cbw.getHeadView() != null) {
            this.cbw.getHeadView().setIsRound(true);
            this.cbw.getHeadView().setDrawBorder(false);
            this.cbw.getHeadView().setDefaultResource(17170445);
            this.cbw.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbw.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbw.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbw.setHasPendantStyle();
        if (this.cbw.getPendantView() != null) {
            this.cbw.getPendantView().setIsRound(true);
            this.cbw.getPendantView().setDrawBorder(false);
        }
        this.cbw.setAfterClickListener(this.aKC);
        this.byS = view.findViewById(e.g.divider_line);
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cXN = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cXN.setAfterClickListener(this.cXT);
        this.cXP = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cXP.setVisibility(8);
        this.cXO = view.findViewById(e.g.divider_line_above_praise);
        this.cXQ = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cXQ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        this.cXQ.setChildClickListener(this.cVj);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cXQ.setImageProcessor(eVar);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.caL = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.caL.setUserAfterClickListener(this.aKC);
        this.caL.setFrom(3);
        this.caM.setOnClickListener(this.cVj);
        this.caM.setForumAfterClickListener(this.aKC);
        this.caM.setReplyTimeVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setIsBarViewVisible(false);
        this.caM.setShareVisible(true);
        this.caM.setShareReportFrom(1);
        this.caM.setStType("frs_page");
        this.caM.setFrom(2);
        this.caM.setDisPraiseFrom(2);
        this.caM.avM = 3;
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        if (this.cbz != null) {
            this.cbz.aKk.setOnClickListener(this.cVj);
            this.cbz.setFrom(2);
            this.cbz.setShareReportFrom(1);
            this.cbz.setSourceFromForPb(3);
            this.cbz.setStType("frs_page");
            this.cbz.setHideBarName(true);
            this.cbz.aKk.setNeedAddReplyIcon(true);
        }
        this.drh = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.dUa = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.drh);
        this.dUa.setUniqueId(getTag());
        this.cVg = (ThreadGodReplyLayout) view.findViewById(e.g.card_frs_god_reply_layout);
        this.cVg.setOnClickListener(this.cVj);
        this.cZw = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.cZw.setPageId(getTag());
        this.cZy = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        if (this.cZy != null) {
            this.cZy.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.caM != null) {
                    e.this.caM.changeSelectStatus();
                }
            }
        });
        this.caM.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bJ(boolean z) {
                if (e.this.mMaskView != null) {
                    e.this.mMaskView.setBackgroundColor(al.getColor(z ? e.d.cp_bg_line_d : e.d.transparent));
                }
            }
        });
        this.cbK = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.dUm = (AppletsCellView) view.findViewById(e.g.card_home_page_normal_thread_share_info);
    }

    public ThreadCommentAndPraiseInfoLayout acq() {
        return this.caM;
    }

    public ThreadCommentAndPraiseInfoLayout acr() {
        if (this.cbz != null) {
            return this.cbz.aKk;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.cXQ != null) {
            this.cXQ.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cXQ != null) {
            this.cXQ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cXQ != null) {
            this.cXQ.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.byS, e.d.cp_bg_line_e);
            this.cXQ.onChangeSkinType();
            this.caM.onChangeSkinType();
            this.caL.onChangeSkinType();
            this.dUa.onChangeSkinType();
            if (this.cbz != null && this.cbz.getVisibility() == 0) {
                this.cbz.onChangeSkinType();
            }
            if (this.dUm != null) {
                this.dUm.onChangeSkinType();
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
        this.aFg = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVj);
        }
        this.cVg.onChangeSkinType();
        if (!apW() && o.mH(this.aFg.getId())) {
            o.a(this.mTitle, this.aFg.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cXP, this.aFg.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cVg.getGodReplyContent(), this.aFg.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        Q(bbVar);
        this.dUa.af(this.aFg);
        N(bbVar);
        this.caL.setData(this.aFg);
        this.cVg.setFromCDN(this.aEr);
        this.cVg.setData(this.aFg.AX());
        this.caL.setUserAfterClickListener(this.aKC);
        iM(hD(1));
        if (this.caL.getHeaderImg() != null) {
            if (this.caL.getIsSimpleThread()) {
                this.caL.getHeaderImg().setVisibility(8);
                this.cbw.setVisibility(8);
            } else if (bbVar.zG() == null || bbVar.zG().getPendantData() == null || StringUtils.isNull(bbVar.zG().getPendantData().ys())) {
                this.cbw.setVisibility(8);
                this.caL.getHeaderImg().setVisibility(0);
                this.caL.getHeaderImg().setData(bbVar);
            } else {
                this.caL.getHeaderImg().setVisibility(4);
                this.cbw.setVisibility(0);
                this.cbw.setData(bbVar);
            }
        }
        L(bbVar);
        M(bbVar);
        this.dUm.setData(bbVar.Am());
        this.dUm.setForumId(String.valueOf(bbVar.getFid()));
        AppletsCellView appletsCellView = this.dUm;
        AppletsCellView appletsCellView2 = this.dUm;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> zV = bbVar.zV();
        if (v.I(zV)) {
            this.cXN.setVisibility(8);
        } else {
            this.cXN.bFt();
            this.cXN.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zV.get(0);
            this.cXN.setVoiceModel(voiceModel);
            this.cXN.setTag(voiceModel);
            this.cXN.aWT();
            if (voiceModel != null) {
                this.cXN.qJ(voiceModel.voice_status.intValue());
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
                this.cXQ.setVisibility(0);
                this.cXQ.setFromCDN(this.aEr);
                this.cXQ.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> apS = e.this.apS();
                        if (z) {
                            if (apS != null) {
                                view.setTag("1");
                                apS.bvN = true;
                                apS.a(view, e.this.aFg);
                            }
                            e.this.fp(false);
                            return;
                        }
                        if (apS != null) {
                            view.setTag("1");
                            apS.bvN = false;
                            apS.a(view, e.this.aFg);
                        }
                        e.this.a(view, linkedList, i2, bbVar);
                    }
                });
                this.cXQ.setImageMediaList(linkedList);
            } else {
                this.cXQ.setVisibility(8);
            }
        } else {
            this.cXQ.setVisibility(8);
        }
        aqk();
        aql();
        aEY();
        if (this.caM.isInFrsAllThread() && com.baidu.tieba.frs.a.aAJ().aAK()) {
            this.mMaskView.setVisibility(0);
            if (this.aFg.Bh() || this.aFg.Bi()) {
                al.j(this.mMaskView, e.d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(e.d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aqk() {
        if (this.cXO != null && this.cXQ != null && this.cVg != null) {
            if (this.cXQ.getVisibility() == 8 && this.cVg.getVisibility() == 8 && this.dUm.getVisibility() == 8) {
                this.cXO.setVisibility(0);
            } else {
                this.cXO.setVisibility(8);
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.cZy != null) {
            if (this.cZw == null || bbVar == null) {
                this.cZy.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.avu) && this.cZw.getVisibility() != 0) {
                if (this.dUa != null && this.dUa.aIh() && (this.cZy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cZy.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds106);
                    this.cZy.setLayoutParams(layoutParams);
                }
                this.cZy.setVisibility(0);
                this.cZy.setImageDrawable(null);
                this.cZy.startLoad(bbVar.avu, 10, false);
                this.cZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bbVar.avv, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cZy.setVisibility(8);
            }
        }
    }

    public void Q(bb bbVar) {
        MetaData zG;
        if (bbVar != null && this.cZw != null && (zG = bbVar.zG()) != null) {
            final ThemeCardInUserData themeCard = zG.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cZw.setVisibility(8);
                return;
            }
            this.cZw.setVisibility(0);
            this.cZw.setImageDrawable(null);
            this.cZw.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
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
                imageUrlData.urlType = this.aEr ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zM(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEr, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void aql() {
        this.cXN.setClickable(true);
        int childCount = this.cXQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cXQ.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aEr = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.caM != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.caL != null) {
            this.caL.setPageUniqueId(bdUniqueId);
        }
        if (this.cXQ != null) {
            this.cXQ.setPageUniqueId(bdUniqueId);
        }
    }

    protected void fp(boolean z) {
        if (this.aFg != null) {
            o.mG(this.aFg.getId());
            o.a(this.mTitle, this.aFg.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cXP, this.aFg.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cVg.getGodReplyContent(), this.aFg.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            m AB = this.aFg.AB();
            if (AB != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bI(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), AB.getCartoonId(), AB.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aFg.auP;
            if (this.aFg.auO == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aqo;
                long j = jVar.aqp;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aqC = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aFg, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aFg.Ax() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean apW() {
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
    public void iK(int i) {
        this.currentPageType = i;
        if (this.caM != null) {
            this.caM.avM = i;
            if (i == 15) {
                this.caM.setFrom(10);
            } else {
                this.caM.setFrom(2);
                this.caM.setDisPraiseFrom(2);
            }
        }
        if (this.caL != null) {
            if (i == 15) {
                this.caL.setFrom(5);
            } else {
                this.caL.setFrom(3);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cXN != null) {
            this.cXN.setVoiceManager(voiceManager);
        }
    }

    private boolean L(bb bbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dUl)) {
            bbVar.al(this.mUrl, this.dUl);
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
        if (bbVar != null && hD(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dUl)) {
                bbVar.al(this.mUrl, this.dUl);
            }
            SpannableString AZ = bbVar.AZ();
            if (AZ != null && !ao.isEmpty(AZ.toString())) {
                this.cXP.setVisibility(0);
                this.cXP.setOnTouchListener(new k(AZ));
                this.cXP.setText(AZ);
                o.a(this.cXP, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cXP.setVisibility(8);
            return;
        }
        this.cXP.setVisibility(8);
    }

    private void aEY() {
        if (this.mTitle != null && this.cXN != null && this.cXQ != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXN.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds20);
            this.cXN.setLayoutParams(layoutParams);
            if (this.cXN.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cXQ.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds28);
                this.cXQ.setLayoutParams(layoutParams2);
            }
        }
    }

    public void iM(int i) {
        if (this.aFg != null) {
            if (i == 1) {
                this.caM.setVisibility(8);
                if (this.cbz != null) {
                    this.cbz.setData(this.aFg);
                    return;
                }
                return;
            }
            this.caM.setData(this.aFg);
            if (this.cbz != null) {
                this.cbz.setVisibility(8);
            }
        }
    }

    public void al(String str, String str2) {
        this.mUrl = str;
        this.dUl = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cXQ != null) {
            this.cXQ.setPreloadSizeReadyCallback(bVar);
        }
    }
}
