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
    protected boolean aAQ;
    protected bb aBF;
    private final View.OnClickListener aHa;
    private String bWE;
    public ThreadUserInfoLayout bWQ;
    protected ThreadCommentAndPraiseInfoLayout bWR;
    private HeadPendantClickableView bXB;
    protected ThreadSourceShareAndPraiseLayout bXE;
    public LinearLayout bXP;
    protected View bvs;
    private ThreadGodReplyLayout cLJ;
    private View.OnClickListener cLM;
    private PlayVoiceBntNew cOq;
    protected View cOr;
    private TextView cOs;
    protected ConstrainImageGroup cOt;
    private final View.OnClickListener cOw;
    public TbImageView cPZ;
    private TbImageView cQb;
    private com.baidu.tieba.frs.vc.g dKG;
    private String dKR;
    private AppletsCellView dKS;
    private RelativeLayout dhJ;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aAQ = true;
        this.cLM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.ayk().ayl()) {
                    if (e.this.bWR != null) {
                        e.this.bWR.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (e.this.anq() != null) {
                    e.this.anq().a(view, e.this.aBF);
                }
                e.this.fm(view == e.this.cLJ);
            }
        };
        this.cOw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> anq = e.this.anq();
                if (anq != null) {
                    view.setTag("2");
                    anq.a(view, e.this.aBF);
                }
            }
        };
        this.aHa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.anq() != null) {
                    e.this.anq().a(view, e.this.aBF);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bXB = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bXB.getHeadView() != null) {
            this.bXB.getHeadView().setIsRound(true);
            this.bXB.getHeadView().setDrawBorder(false);
            this.bXB.getHeadView().setDefaultResource(17170445);
            this.bXB.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bXB.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bXB.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0200e.ds70));
        }
        this.bXB.setHasPendantStyle();
        if (this.bXB.getPendantView() != null) {
            this.bXB.getPendantView().setIsRound(true);
            this.bXB.getPendantView().setDrawBorder(false);
        }
        this.bXB.setAfterClickListener(this.aHa);
        this.bvs = view.findViewById(e.g.divider_line);
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cOq = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cOq.setAfterClickListener(this.cOw);
        this.cOs = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cOs.setVisibility(8);
        this.cOr = view.findViewById(e.g.divider_line_above_praise);
        this.cOt = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cOt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds20));
        this.cOt.setChildClickListener(this.cLM);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cOt.setImageProcessor(eVar);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bWQ = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bWQ.setUserAfterClickListener(this.aHa);
        this.bWQ.setFrom(3);
        this.bWR.setOnClickListener(this.cLM);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setIsBarViewVisible(false);
        this.bWR.setShareVisible(true);
        this.bWR.setShareReportFrom(1);
        this.bWR.setStType("frs_page");
        this.bWR.setFrom(2);
        this.bWR.setDisPraiseFrom(2);
        this.bWR.asl = 3;
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        if (this.bXE != null) {
            this.bXE.aGI.setOnClickListener(this.cLM);
            this.bXE.setFrom(2);
            this.bXE.setShareReportFrom(1);
            this.bXE.setSourceFromForPb(3);
            this.bXE.setStType("frs_page");
            this.bXE.setHideBarName(true);
            this.bXE.aGI.setNeedAddReplyIcon(true);
        }
        this.dhJ = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.dKG = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.dhJ);
        this.dKG.setUniqueId(getTag());
        this.cLJ = (ThreadGodReplyLayout) view.findViewById(e.g.card_frs_god_reply_layout);
        this.cLJ.setOnClickListener(this.cLM);
        this.cPZ = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.cPZ.setPageId(getTag());
        this.cQb = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        if (this.cQb != null) {
            this.cQb.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bWR != null) {
                    e.this.bWR.changeSelectStatus();
                }
            }
        });
        this.bWR.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bI(boolean z) {
                if (e.this.mMaskView != null) {
                    e.this.mMaskView.setBackgroundColor(al.getColor(z ? e.d.cp_bg_line_d : e.d.transparent));
                }
            }
        });
        this.bXP = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.dKS = (AppletsCellView) view.findViewById(e.g.card_home_page_normal_thread_share_info);
    }

    public ThreadCommentAndPraiseInfoLayout abi() {
        return this.bWR;
    }

    public ThreadCommentAndPraiseInfoLayout abj() {
        if (this.bXE != null) {
            return this.bXE.aGI;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.cOt != null) {
            this.cOt.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cOt != null) {
            this.cOt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cOt != null) {
            this.cOt.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.bvs, e.d.cp_bg_line_e);
            this.cOt.onChangeSkinType();
            this.bWR.onChangeSkinType();
            this.bWQ.onChangeSkinType();
            this.dKG.onChangeSkinType();
            if (this.bXE != null && this.bXE.getVisibility() == 0) {
                this.bXE.onChangeSkinType();
            }
            if (this.dKS != null) {
                this.dKS.onChangeSkinType();
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
        this.aBF = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cLM);
        }
        this.cLJ.onChangeSkinType();
        if (!anu() && o.mf(this.aBF.getId())) {
            o.a(this.mTitle, this.aBF.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cOs, this.aBF.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cLJ.getGodReplyContent(), this.aBF.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        Q(bbVar);
        this.dKG.af(this.aBF);
        N(bbVar);
        this.bWQ.setData(this.aBF);
        this.cLJ.setFromCDN(this.aAQ);
        this.cLJ.setData(this.aBF.zT());
        this.bWQ.setUserAfterClickListener(this.aHa);
        ix(ho(1));
        if (this.bWQ.getHeaderImg() != null) {
            if (this.bWQ.getIsSimpleThread()) {
                this.bWQ.getHeaderImg().setVisibility(8);
                this.bXB.setVisibility(8);
            } else if (bbVar.yC() == null || bbVar.yC().getPendantData() == null || StringUtils.isNull(bbVar.yC().getPendantData().xn())) {
                this.bXB.setVisibility(8);
                this.bWQ.getHeaderImg().setVisibility(0);
                this.bWQ.getHeaderImg().setData(bbVar);
            } else {
                this.bWQ.getHeaderImg().setVisibility(4);
                this.bXB.setVisibility(0);
                this.bXB.setData(bbVar);
            }
        }
        L(bbVar);
        M(bbVar);
        this.dKS.setData(bbVar.zi());
        this.dKS.setForumId(String.valueOf(bbVar.getFid()));
        AppletsCellView appletsCellView = this.dKS;
        AppletsCellView appletsCellView2 = this.dKS;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> yR = bbVar.yR();
        if (v.I(yR)) {
            this.cOq.setVisibility(8);
        } else {
            this.cOq.bCH();
            this.cOq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = yR.get(0);
            this.cOq.setVoiceModel(voiceModel);
            this.cOq.setTag(voiceModel);
            this.cOq.aUo();
            if (voiceModel != null) {
                this.cOq.qc(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> yN = bbVar.yN();
        if (com.baidu.tbadk.core.i.wA().wE() && v.H(yN) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < yN.size(); i++) {
                MediaData mediaData = (MediaData) v.d(yN, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.H(linkedList) > 0) {
                this.cOt.setVisibility(0);
                this.cOt.setFromCDN(this.aAQ);
                this.cOt.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> anq = e.this.anq();
                        if (z) {
                            if (anq != null) {
                                view.setTag("1");
                                anq.bsl = true;
                                anq.a(view, e.this.aBF);
                            }
                            e.this.fm(false);
                            return;
                        }
                        if (anq != null) {
                            view.setTag("1");
                            anq.bsl = false;
                            anq.a(view, e.this.aBF);
                        }
                        e.this.a(view, linkedList, i2, bbVar);
                    }
                });
                this.cOt.setImageMediaList(linkedList);
            } else {
                this.cOt.setVisibility(8);
            }
        } else {
            this.cOt.setVisibility(8);
        }
        anI();
        anJ();
        aCx();
        if (this.bWR.isInFrsAllThread() && com.baidu.tieba.frs.a.ayk().ayl()) {
            this.mMaskView.setVisibility(0);
            if (this.aBF.Ad() || this.aBF.Ae()) {
                al.j(this.mMaskView, e.d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(e.d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void anI() {
        if (this.cOr != null && this.cOt != null && this.cLJ != null) {
            if (this.cOt.getVisibility() == 8 && this.cLJ.getVisibility() == 8 && this.dKS.getVisibility() == 8) {
                this.cOr.setVisibility(0);
            } else {
                this.cOr.setVisibility(8);
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.cQb != null) {
            if (this.cPZ == null || bbVar == null) {
                this.cQb.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.arU) && this.cPZ.getVisibility() != 0) {
                if (this.dKG != null && this.dKG.aFG() && (this.cQb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cQb.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0200e.tbds106);
                    this.cQb.setLayoutParams(layoutParams);
                }
                this.cQb.setVisibility(0);
                this.cQb.setImageDrawable(null);
                this.cQb.startLoad(bbVar.arU, 10, false);
                this.cQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bbVar.arV, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cQb.setVisibility(8);
            }
        }
    }

    public void Q(bb bbVar) {
        MetaData yC;
        if (bbVar != null && this.cPZ != null && (yC = bbVar.yC()) != null) {
            final ThemeCardInUserData themeCard = yC.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cPZ.setVisibility(8);
                return;
            }
            this.cPZ.setVisibility(0);
            this.cPZ.setImageDrawable(null);
            this.cPZ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cPZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
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
                imageUrlData.urlType = this.aAQ ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.yI(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aAQ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bbVar.getId();
            historyMessage.threadName = bbVar.getTitle();
            historyMessage.forumName = bbVar.yI();
            historyMessage.postID = bbVar.yT();
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

    private void anJ() {
        this.cOq.setClickable(true);
        int childCount = this.cOt.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cOt.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aAQ = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bWR != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bWQ != null) {
            this.bWQ.setPageUniqueId(bdUniqueId);
        }
        if (this.cOt != null) {
            this.cOt.setPageUniqueId(bdUniqueId);
        }
    }

    protected void fm(boolean z) {
        if (this.aBF != null) {
            o.me(this.aBF.getId());
            o.a(this.mTitle, this.aBF.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cOs, this.aBF.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cLJ.getGodReplyContent(), this.aBF.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            m zx = this.aBF.zx();
            if (zx != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bF(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zx.getCartoonId(), zx.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aBF.arp;
            if (this.aBF.aro == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.amN;
                long j = jVar.amO;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.anb = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aBF, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aBF.zt() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean anu() {
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
    public void iv(int i) {
        this.currentPageType = i;
        if (this.bWR != null) {
            this.bWR.asl = i;
            if (i == 15) {
                this.bWR.setFrom(10);
            } else {
                this.bWR.setFrom(2);
                this.bWR.setDisPraiseFrom(2);
            }
        }
        if (this.bWQ != null) {
            if (i == 15) {
                this.bWQ.setFrom(5);
            } else {
                this.bWQ.setFrom(3);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cOq != null) {
            this.cOq.setVoiceManager(voiceManager);
        }
    }

    private boolean L(bb bbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dKR)) {
            bbVar.ai(this.mUrl, this.dKR);
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
        if (bbVar != null && ho(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dKR)) {
                bbVar.ai(this.mUrl, this.dKR);
            }
            SpannableString zV = bbVar.zV();
            if (zV != null && !ao.isEmpty(zV.toString())) {
                this.cOs.setVisibility(0);
                this.cOs.setOnTouchListener(new k(zV));
                this.cOs.setText(zV);
                o.a(this.cOs, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cOs.setVisibility(8);
            return;
        }
        this.cOs.setVisibility(8);
    }

    private void aCx() {
        if (this.mTitle != null && this.cOq != null && this.cOt != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOq.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds20);
            this.cOq.setLayoutParams(layoutParams);
            if (this.cOq.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cOt.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds28);
                this.cOt.setLayoutParams(layoutParams2);
            }
        }
    }

    public void ix(int i) {
        if (this.aBF != null) {
            if (i == 1) {
                this.bWR.setVisibility(8);
                if (this.bXE != null) {
                    this.bXE.setData(this.aBF);
                    return;
                }
                return;
            }
            this.bWR.setData(this.aBF);
            if (this.bXE != null) {
                this.bXE.setVisibility(8);
            }
        }
    }

    public void ai(String str, String str2) {
        this.mUrl = str;
        this.dKR = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cOt != null) {
            this.cOt.setPreloadSizeReadyCallback(bVar);
        }
    }
}
