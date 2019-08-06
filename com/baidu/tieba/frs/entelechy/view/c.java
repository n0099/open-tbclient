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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.vc.g;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<bh> implements com.baidu.tieba.a.e, z {
    private TextView VW;
    private String WN;
    protected bh We;
    private final View.OnClickListener XU;
    private AppletsCellView YV;
    protected boolean Yd;
    private PlayVoiceBntNew Ym;
    protected View cUD;
    public ThreadUserInfoLayout dEH;
    protected ThreadCommentAndPraiseInfoLayout dEI;
    public LinearLayout dFG;
    protected ThreadSourceShareAndPraiseLayout dFv;
    protected View eCR;
    protected ConstrainImageGroup eCT;
    private View.OnClickListener eCY;
    private final View.OnClickListener eCZ;
    private ThreadGodReplyLayout eCq;
    private HeadPendantClickableView eCr;
    public TbImageView eEA;
    private TbImageView eEC;
    private RelativeLayout evb;
    private String fEA;
    private g fEq;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Yd = true;
        this.eCY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.blf().blg()) {
                    if (c.this.dEI != null) {
                        c.this.dEI.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.aZq() != null) {
                    c.this.aZq().a(view, c.this.We);
                }
                c.this.iz(view == c.this.eCq);
            }
        };
        this.eCZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bh> aZq = c.this.aZq();
                if (aZq != null) {
                    view.setTag("2");
                    aZq.a(view, c.this.We);
                }
            }
        };
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZq() != null) {
                    c.this.aZq().a(view, c.this.We);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.eCr = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.eCr.getHeadView() != null) {
            this.eCr.getHeadView().setIsRound(true);
            this.eCr.getHeadView().setDrawBorder(false);
            this.eCr.getHeadView().setDefaultResource(17170445);
            this.eCr.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCr.getHeadView().setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.eCr.setHasPendantStyle();
        if (this.eCr.getPendantView() != null) {
            this.eCr.getPendantView().setIsRound(true);
            this.eCr.getPendantView().setDrawBorder(false);
        }
        this.eCr.setAfterClickListener(this.XU);
        this.cUD = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.Ym = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.Ym.setAfterClickListener(this.eCZ);
        this.VW = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.VW.setVisibility(8);
        this.eCR = view.findViewById(R.id.divider_line_above_praise);
        this.eCT = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.eCT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eCT.setChildClickListener(this.eCY);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.eCT.setImageProcessor(fVar);
        this.dEI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.dEH = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.dEH.setUserAfterClickListener(this.XU);
        this.dEH.setFrom(3);
        this.dEI.setOnClickListener(this.eCY);
        this.dEI.setForumAfterClickListener(this.XU);
        this.dEI.setReplyTimeVisible(false);
        this.dEI.setShowPraiseNum(true);
        this.dEI.setNeedAddPraiseIcon(true);
        this.dEI.setNeedAddReplyIcon(true);
        this.dEI.setIsBarViewVisible(false);
        this.dEI.setShareVisible(true);
        this.dEI.setShareReportFrom(1);
        this.dEI.setStType("frs_page");
        this.dEI.setFrom(2);
        this.dEI.setDisPraiseFrom(2);
        this.dEI.cbM = 3;
        this.dFv = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.dFv != null) {
            this.dFv.ccH.setOnClickListener(this.eCY);
            this.dFv.setFrom(2);
            this.dFv.setShareReportFrom(1);
            this.dFv.setSourceFromForPb(3);
            this.dFv.setStType("frs_page");
            this.dFv.setHideBarName(true);
            this.dFv.ccH.setNeedAddReplyIcon(true);
        }
        this.evb = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.fEq = new g(this.mPageContext, this.evb);
        this.fEq.setUniqueId(getTag());
        this.eCq = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.eCq.setOnClickListener(this.eCY);
        this.eEA = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.eEA.setPageId(getTag());
        this.eEC = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.eEC != null) {
            this.eEC.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dEI != null) {
                    c.this.dEI.changeSelectStatus();
                }
            }
        });
        this.dEI.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void eu(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.dFG = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.YV = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.eCT != null) {
            this.eCT.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCT != null) {
            this.eCT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCT != null) {
            this.eCT.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.addresslist_item_bg);
            am.l(this.cUD, R.color.cp_bg_line_e);
            this.eCT.onChangeSkinType();
            this.dEI.onChangeSkinType();
            this.dEH.onChangeSkinType();
            if (this.YV != null) {
                this.YV.onChangeSkinType();
            }
            this.fEq.onChangeSkinType();
            if (this.dFv != null && this.dFv.getVisibility() == 0) {
                this.dFv.onChangeSkinType();
            }
            if (this.eCr != null && this.eCr.getHeadView() != null && (this.eCr.getHeadView() instanceof TbImageView)) {
                this.eCr.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(final bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.We = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eCY);
        }
        this.eCq.onChangeSkinType();
        if (!aZA() && n.vy(this.We.getId())) {
            n.a(this.mTitle, this.We.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VW, this.We.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.eCq.getGodReplyContent(), this.We.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bhVar);
        this.fEq.an(this.We);
        S(bhVar);
        this.dEH.setData(this.We);
        this.eCq.setFromCDN(this.Yd);
        this.eCq.setData(this.We.afW());
        this.dEH.setUserAfterClickListener(this.XU);
        nF(mp(1));
        if (this.dEH.getHeaderImg() != null) {
            if (this.dEH.getIsSimpleThread()) {
                this.dEH.getHeaderImg().setVisibility(8);
                this.eCr.setVisibility(8);
            } else if (bhVar.aey() == null || bhVar.aey().getPendantData() == null || StringUtils.isNull(bhVar.aey().getPendantData().acV())) {
                this.eCr.setVisibility(8);
                this.dEH.getHeaderImg().setVisibility(0);
                this.dEH.getHeaderImg().setData(bhVar);
            } else {
                this.dEH.getHeaderImg().setVisibility(4);
                this.eCr.setVisibility(0);
                this.eCr.setData(bhVar);
            }
        }
        ah(bhVar);
        ai(bhVar);
        this.YV.setData(bhVar.afk());
        this.YV.setForumId(String.valueOf(bhVar.getFid()));
        AppletsCellView appletsCellView = this.YV;
        AppletsCellView appletsCellView2 = this.YV;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aeM = bhVar.aeM();
        if (v.aa(aeM)) {
            this.Ym.setVisibility(8);
        } else {
            this.Ym.cqV();
            this.Ym.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aeM.get(0);
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bIz();
            if (voiceModel != null) {
                this.Ym.wa(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aeI = bhVar.aeI();
        if (i.aca().ace() && v.Z(aeI) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aeI.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeI, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.eCT.setVisibility(0);
                this.eCT.setFromCDN(this.Yd);
                this.eCT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bh> aZq = c.this.aZq();
                        if (z) {
                            if (aZq != null) {
                                view.setTag("1");
                                aZq.XJ = true;
                                aZq.a(view, c.this.We);
                            }
                            c.this.iz(false);
                            return;
                        }
                        if (aZq != null) {
                            view.setTag("1");
                            aZq.XJ = false;
                            aZq.a(view, c.this.We);
                        }
                        c.this.a(view, linkedList, i2, bhVar);
                    }
                });
                this.eCT.setImageMediaList(linkedList);
            } else {
                this.eCT.setVisibility(8);
            }
        } else {
            this.eCT.setVisibility(8);
        }
        aZI();
        aZJ();
        bpB();
        if (this.dEI.isInFrsAllThread() && com.baidu.tieba.frs.a.blf().blg()) {
            this.mMaskView.setVisibility(0);
            if (this.We.agh() || this.We.agi()) {
                am.l(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aZI() {
        if (this.eCR != null && this.eCT != null && this.eCq != null) {
            if (this.eCT.getVisibility() == 8 && this.eCq.getVisibility() == 8 && this.YV.getVisibility() == 8) {
                this.eCR.setVisibility(0);
            } else {
                this.eCR.setVisibility(8);
            }
        }
    }

    private void S(final bh bhVar) {
        if (this.eEC != null) {
            if (this.eEA == null || bhVar == null) {
                this.eEC.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.bLW) && this.eEA.getVisibility() != 0) {
                if (this.fEq != null && this.fEq.bsV() && (this.eEC.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEC.getLayoutParams();
                    layoutParams.rightMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.eEC.setLayoutParams(layoutParams);
                }
                this.eEC.setVisibility(0);
                this.eEC.setImageDrawable(null);
                this.eEC.startLoad(bhVar.bLW, 10, false);
                this.eEC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bhVar.bLX, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.eEC.setVisibility(8);
            }
        }
    }

    public void b(bh bhVar) {
        MetaData aey;
        if (bhVar != null && this.eEA != null && (aey = bhVar.aey()) != null) {
            final ThemeCardInUserData themeCard = aey.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.eEA.setVisibility(8);
                return;
            }
            this.eEA.setVisibility(0);
            this.eEA.setImageDrawable(null);
            this.eEA.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.eEA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.Yd ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.aa(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aeD(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bhVar.getId();
            historyMessage.threadName = bhVar.getTitle();
            historyMessage.forumName = bhVar.aeD();
            historyMessage.postID = bhVar.aeO();
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

    private void aZJ() {
        this.Ym.setClickable(true);
        int childCount = this.eCT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eCT.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dEI != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dEH != null) {
            this.dEH.setPageUniqueId(bdUniqueId);
        }
        if (this.eCT != null) {
            this.eCT.setPageUniqueId(bdUniqueId);
        }
    }

    protected void iz(boolean z) {
        if (this.We != null) {
            n.vx(this.We.getId());
            n.a(this.mTitle, this.We.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VW, this.We.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.eCq.getGodReplyContent(), this.We.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            o afB = this.We.afB();
            if (afB != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bd.cE(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), afB.getCartoonId(), afB.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.We.bLm;
            if (this.We.bLl == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.bFZ;
                long j = lVar.bGa;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.mPageContext;
                amVar.bGn = str;
                amVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.We, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.We.afx() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aZA() {
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
    public void nD(int i) {
        this.currentPageType = i;
        if (this.dEI != null) {
            this.dEI.cbM = i;
            if (i == 15) {
                this.dEI.setFrom(10);
            } else {
                this.dEI.setFrom(2);
                this.dEI.setDisPraiseFrom(2);
            }
        }
        if (this.dEH != null) {
            if (i == 15) {
                this.dEH.setFrom(5);
            } else {
                this.dEH.setFrom(3);
            }
        }
    }

    private boolean ah(bh bhVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fEA)) {
            bhVar.bC(this.mUrl, this.fEA);
        }
        SpannableStringBuilder o = bhVar.o(false, true);
        if (o == null || StringUtils.isNull(o.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(o));
            this.mTitle.setText(o);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void ai(bh bhVar) {
        if (bhVar != null && mp(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fEA)) {
                bhVar.bC(this.mUrl, this.fEA);
            }
            SpannableString afZ = bhVar.afZ();
            if (afZ != null && !aq.isEmpty(afZ.toString())) {
                this.VW.setVisibility(0);
                this.VW.setOnTouchListener(new k(afZ));
                this.VW.setText(afZ);
                n.a(this.VW, bhVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.VW.setVisibility(8);
            return;
        }
        this.VW.setVisibility(8);
    }

    private void bpB() {
        if (this.mTitle != null && this.Ym != null && this.eCT != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ym.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.Ym.setLayoutParams(layoutParams);
            if (this.Ym.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eCT.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.eCT.setLayoutParams(layoutParams2);
            }
        }
    }

    public void nF(int i) {
        if (this.We != null) {
            if (i == 1) {
                this.dEI.setVisibility(8);
                if (this.dFv != null) {
                    this.dFv.setData(this.We);
                    return;
                }
                return;
            }
            this.dEI.setData(this.We);
            if (this.dFv != null) {
                this.dFv.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mp(int i) {
        return com.baidu.tieba.a.d.aCH().ag(this.WN, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eCT != null) {
            this.eCT.setPreloadSizeReadyCallback(bVar);
        }
    }
}
