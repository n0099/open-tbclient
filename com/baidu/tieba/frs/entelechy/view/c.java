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
public class c extends com.baidu.tieba.card.a<bg> implements com.baidu.tieba.a.e, z {
    private TextView VW;
    private String WN;
    protected bg We;
    private final View.OnClickListener XU;
    private AppletsCellView YV;
    protected boolean Yd;
    private PlayVoiceBntNew Ym;
    protected View cUw;
    public ThreadUserInfoLayout dEA;
    protected ThreadCommentAndPraiseInfoLayout dEB;
    protected ThreadSourceShareAndPraiseLayout dFo;
    public LinearLayout dFz;
    protected View eCK;
    protected ConstrainImageGroup eCM;
    private View.OnClickListener eCR;
    private final View.OnClickListener eCS;
    private ThreadGodReplyLayout eCj;
    private HeadPendantClickableView eCk;
    public TbImageView eEt;
    private TbImageView eEv;
    private RelativeLayout euU;
    private g fDC;
    private String fDM;
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
        this.eCR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bkY().bkZ()) {
                    if (c.this.dEB != null) {
                        c.this.dEB.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.aZo() != null) {
                    c.this.aZo().a(view, c.this.We);
                }
                c.this.iz(view == c.this.eCj);
            }
        };
        this.eCS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aZo = c.this.aZo();
                if (aZo != null) {
                    view.setTag("2");
                    aZo.a(view, c.this.We);
                }
            }
        };
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZo() != null) {
                    c.this.aZo().a(view, c.this.We);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.eCk = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.eCk.getHeadView() != null) {
            this.eCk.getHeadView().setIsRound(true);
            this.eCk.getHeadView().setDrawBorder(false);
            this.eCk.getHeadView().setDefaultResource(17170445);
            this.eCk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCk.getHeadView().setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.eCk.setHasPendantStyle();
        if (this.eCk.getPendantView() != null) {
            this.eCk.getPendantView().setIsRound(true);
            this.eCk.getPendantView().setDrawBorder(false);
        }
        this.eCk.setAfterClickListener(this.XU);
        this.cUw = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.Ym = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.Ym.setAfterClickListener(this.eCS);
        this.VW = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.VW.setVisibility(8);
        this.eCK = view.findViewById(R.id.divider_line_above_praise);
        this.eCM = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.eCM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eCM.setChildClickListener(this.eCR);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.eCM.setImageProcessor(fVar);
        this.dEB = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.dEA = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.dEA.setUserAfterClickListener(this.XU);
        this.dEA.setFrom(3);
        this.dEB.setOnClickListener(this.eCR);
        this.dEB.setForumAfterClickListener(this.XU);
        this.dEB.setReplyTimeVisible(false);
        this.dEB.setShowPraiseNum(true);
        this.dEB.setNeedAddPraiseIcon(true);
        this.dEB.setNeedAddReplyIcon(true);
        this.dEB.setIsBarViewVisible(false);
        this.dEB.setShareVisible(true);
        this.dEB.setShareReportFrom(1);
        this.dEB.setStType("frs_page");
        this.dEB.setFrom(2);
        this.dEB.setDisPraiseFrom(2);
        this.dEB.cbF = 3;
        this.dFo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.dFo != null) {
            this.dFo.ccA.setOnClickListener(this.eCR);
            this.dFo.setFrom(2);
            this.dFo.setShareReportFrom(1);
            this.dFo.setSourceFromForPb(3);
            this.dFo.setStType("frs_page");
            this.dFo.setHideBarName(true);
            this.dFo.ccA.setNeedAddReplyIcon(true);
        }
        this.euU = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.fDC = new g(this.mPageContext, this.euU);
        this.fDC.setUniqueId(getTag());
        this.eCj = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.eCj.setOnClickListener(this.eCR);
        this.eEt = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.eEt.setPageId(getTag());
        this.eEv = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.eEv != null) {
            this.eEv.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dEB != null) {
                    c.this.dEB.changeSelectStatus();
                }
            }
        });
        this.dEB.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void eu(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.dFz = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.YV = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.eCM != null) {
            this.eCM.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCM != null) {
            this.eCM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCM != null) {
            this.eCM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.addresslist_item_bg);
            am.l(this.cUw, R.color.cp_bg_line_e);
            this.eCM.onChangeSkinType();
            this.dEB.onChangeSkinType();
            this.dEA.onChangeSkinType();
            if (this.YV != null) {
                this.YV.onChangeSkinType();
            }
            this.fDC.onChangeSkinType();
            if (this.dFo != null && this.dFo.getVisibility() == 0) {
                this.dFo.onChangeSkinType();
            }
            if (this.eCk != null && this.eCk.getHeadView() != null && (this.eCk.getHeadView() instanceof TbImageView)) {
                this.eCk.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
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
    public void a(final bg bgVar) {
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.We = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eCR);
        }
        this.eCj.onChangeSkinType();
        if (!aZy() && n.vx(this.We.getId())) {
            n.a(this.mTitle, this.We.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VW, this.We.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.eCj.getGodReplyContent(), this.We.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bgVar);
        this.fDC.am(this.We);
        R(bgVar);
        this.dEA.setData(this.We);
        this.eCj.setFromCDN(this.Yd);
        this.eCj.setData(this.We.afV());
        this.dEA.setUserAfterClickListener(this.XU);
        nE(mo(1));
        if (this.dEA.getHeaderImg() != null) {
            if (this.dEA.getIsSimpleThread()) {
                this.dEA.getHeaderImg().setVisibility(8);
                this.eCk.setVisibility(8);
            } else if (bgVar.aex() == null || bgVar.aex().getPendantData() == null || StringUtils.isNull(bgVar.aex().getPendantData().acU())) {
                this.eCk.setVisibility(8);
                this.dEA.getHeaderImg().setVisibility(0);
                this.dEA.getHeaderImg().setData(bgVar);
            } else {
                this.dEA.getHeaderImg().setVisibility(4);
                this.eCk.setVisibility(0);
                this.eCk.setData(bgVar);
            }
        }
        ag(bgVar);
        ah(bgVar);
        this.YV.setData(bgVar.afj());
        this.YV.setForumId(String.valueOf(bgVar.getFid()));
        AppletsCellView appletsCellView = this.YV;
        AppletsCellView appletsCellView2 = this.YV;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aeL = bgVar.aeL();
        if (v.aa(aeL)) {
            this.Ym.setVisibility(8);
        } else {
            this.Ym.cqz();
            this.Ym.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aeL.get(0);
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bIl();
            if (voiceModel != null) {
                this.Ym.vY(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aeH = bgVar.aeH();
        if (i.aca().ace() && v.Z(aeH) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aeH.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.eCM.setVisibility(0);
                this.eCM.setFromCDN(this.Yd);
                this.eCM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aZo = c.this.aZo();
                        if (z) {
                            if (aZo != null) {
                                view.setTag("1");
                                aZo.XJ = true;
                                aZo.a(view, c.this.We);
                            }
                            c.this.iz(false);
                            return;
                        }
                        if (aZo != null) {
                            view.setTag("1");
                            aZo.XJ = false;
                            aZo.a(view, c.this.We);
                        }
                        c.this.a(view, linkedList, i2, bgVar);
                    }
                });
                this.eCM.setImageMediaList(linkedList);
            } else {
                this.eCM.setVisibility(8);
            }
        } else {
            this.eCM.setVisibility(8);
        }
        aZG();
        aZH();
        bpo();
        if (this.dEB.isInFrsAllThread() && com.baidu.tieba.frs.a.bkY().bkZ()) {
            this.mMaskView.setVisibility(0);
            if (this.We.agg() || this.We.agh()) {
                am.l(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aZG() {
        if (this.eCK != null && this.eCM != null && this.eCj != null) {
            if (this.eCM.getVisibility() == 8 && this.eCj.getVisibility() == 8 && this.YV.getVisibility() == 8) {
                this.eCK.setVisibility(0);
            } else {
                this.eCK.setVisibility(8);
            }
        }
    }

    private void R(final bg bgVar) {
        if (this.eEv != null) {
            if (this.eEt == null || bgVar == null) {
                this.eEv.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bLR) && this.eEt.getVisibility() != 0) {
                if (this.fDC != null && this.fDC.bsI() && (this.eEv.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEv.getLayoutParams();
                    layoutParams.rightMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.eEv.setLayoutParams(layoutParams);
                }
                this.eEv.setVisibility(0);
                this.eEv.setImageDrawable(null);
                this.eEv.startLoad(bgVar.bLR, 10, false);
                this.eEv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bgVar.bLS, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.eEv.setVisibility(8);
            }
        }
    }

    public void b(bg bgVar) {
        MetaData aex;
        if (bgVar != null && this.eEt != null && (aex = bgVar.aex()) != null) {
            final ThemeCardInUserData themeCard = aex.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.eEt.setVisibility(8);
                return;
            }
            this.eEt.setVisibility(0);
            this.eEt.setImageDrawable(null);
            this.eEt.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.eEt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bgVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.aa(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.aeC(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bgVar.getId();
            historyMessage.threadName = bgVar.getTitle();
            historyMessage.forumName = bgVar.aeC();
            historyMessage.postID = bgVar.aeN();
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

    private void aZH() {
        this.Ym.setClickable(true);
        int childCount = this.eCM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eCM.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dEB != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dEA != null) {
            this.dEA.setPageUniqueId(bdUniqueId);
        }
        if (this.eCM != null) {
            this.eCM.setPageUniqueId(bdUniqueId);
        }
    }

    protected void iz(boolean z) {
        if (this.We != null) {
            n.vw(this.We.getId());
            n.a(this.mTitle, this.We.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VW, this.We.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.eCj.getGodReplyContent(), this.We.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            o afA = this.We.afA();
            if (afA != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bd.cE(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), afA.getCartoonId(), afA.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.We.bLh;
            if (this.We.bLg == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.bFY;
                long j = lVar.bFZ;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.mPageContext;
                amVar.bGm = str;
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
            if (this.We.afw() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aZy() {
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
    public void nC(int i) {
        this.currentPageType = i;
        if (this.dEB != null) {
            this.dEB.cbF = i;
            if (i == 15) {
                this.dEB.setFrom(10);
            } else {
                this.dEB.setFrom(2);
                this.dEB.setDisPraiseFrom(2);
            }
        }
        if (this.dEA != null) {
            if (i == 15) {
                this.dEA.setFrom(5);
            } else {
                this.dEA.setFrom(3);
            }
        }
    }

    private boolean ag(bg bgVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fDM)) {
            bgVar.bC(this.mUrl, this.fDM);
        }
        SpannableStringBuilder o = bgVar.o(false, true);
        if (o == null || StringUtils.isNull(o.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(o));
            this.mTitle.setText(o);
            n.a(this.mTitle, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void ah(bg bgVar) {
        if (bgVar != null && mo(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fDM)) {
                bgVar.bC(this.mUrl, this.fDM);
            }
            SpannableString afY = bgVar.afY();
            if (afY != null && !aq.isEmpty(afY.toString())) {
                this.VW.setVisibility(0);
                this.VW.setOnTouchListener(new k(afY));
                this.VW.setText(afY);
                n.a(this.VW, bgVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.VW.setVisibility(8);
            return;
        }
        this.VW.setVisibility(8);
    }

    private void bpo() {
        if (this.mTitle != null && this.Ym != null && this.eCM != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ym.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.Ym.setLayoutParams(layoutParams);
            if (this.Ym.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eCM.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.eCM.setLayoutParams(layoutParams2);
            }
        }
    }

    public void nE(int i) {
        if (this.We != null) {
            if (i == 1) {
                this.dEB.setVisibility(8);
                if (this.dFo != null) {
                    this.dFo.setData(this.We);
                    return;
                }
                return;
            }
            this.dEB.setData(this.We);
            if (this.dFo != null) {
                this.dFo.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mo(int i) {
        return com.baidu.tieba.a.d.aCF().ag(this.WN, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eCM != null) {
            this.eCM.setPreloadSizeReadyCallback(bVar);
        }
    }
}
