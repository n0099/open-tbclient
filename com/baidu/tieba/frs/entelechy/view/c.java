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
    private TextView VB;
    protected bg VJ;
    private String Ws;
    protected boolean XI;
    private PlayVoiceBntNew XR;
    private final View.OnClickListener Xz;
    private AppletsCellView YA;
    protected View cTa;
    protected ThreadSourceShareAndPraiseLayout dBT;
    public ThreadUserInfoLayout dBe;
    protected ThreadCommentAndPraiseInfoLayout dBf;
    public LinearLayout dCe;
    private RelativeLayout epW;
    protected View exM;
    protected ConstrainImageGroup exO;
    private View.OnClickListener exT;
    private final View.OnClickListener exU;
    private ThreadGodReplyLayout exk;
    private HeadPendantClickableView exl;
    public TbImageView ezx;
    private TbImageView ezz;
    private g fyG;
    private String fyQ;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.XI = true;
        this.exT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.biW().biX()) {
                    if (c.this.dBf != null) {
                        c.this.dBf.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.aXr() != null) {
                    c.this.aXr().a(view, c.this.VJ);
                }
                c.this.iq(view == c.this.exk);
            }
        };
        this.exU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aXr = c.this.aXr();
                if (aXr != null) {
                    view.setTag("2");
                    aXr.a(view, c.this.VJ);
                }
            }
        };
        this.Xz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aXr() != null) {
                    c.this.aXr().a(view, c.this.VJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.exl = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.exl.getHeadView() != null) {
            this.exl.getHeadView().setIsRound(true);
            this.exl.getHeadView().setDrawBorder(false);
            this.exl.getHeadView().setDefaultResource(17170445);
            this.exl.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.exl.getHeadView().setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.exl.setHasPendantStyle();
        if (this.exl.getPendantView() != null) {
            this.exl.getPendantView().setIsRound(true);
            this.exl.getPendantView().setDrawBorder(false);
        }
        this.exl.setAfterClickListener(this.Xz);
        this.cTa = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.XR = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.XR.setAfterClickListener(this.exU);
        this.VB = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.VB.setVisibility(8);
        this.exM = view.findViewById(R.id.divider_line_above_praise);
        this.exO = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.exO.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.exO.setChildClickListener(this.exT);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.exO.setImageProcessor(fVar);
        this.dBf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.dBe = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.dBe.setUserAfterClickListener(this.Xz);
        this.dBe.setFrom(3);
        this.dBf.setOnClickListener(this.exT);
        this.dBf.setForumAfterClickListener(this.Xz);
        this.dBf.setReplyTimeVisible(false);
        this.dBf.setShowPraiseNum(true);
        this.dBf.setNeedAddPraiseIcon(true);
        this.dBf.setNeedAddReplyIcon(true);
        this.dBf.setIsBarViewVisible(false);
        this.dBf.setShareVisible(true);
        this.dBf.setShareReportFrom(1);
        this.dBf.setStType("frs_page");
        this.dBf.setFrom(2);
        this.dBf.setDisPraiseFrom(2);
        this.dBf.caD = 3;
        this.dBT = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.dBT != null) {
            this.dBT.cbx.setOnClickListener(this.exT);
            this.dBT.setFrom(2);
            this.dBT.setShareReportFrom(1);
            this.dBT.setSourceFromForPb(3);
            this.dBT.setStType("frs_page");
            this.dBT.setHideBarName(true);
            this.dBT.cbx.setNeedAddReplyIcon(true);
        }
        this.epW = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.fyG = new g(this.mPageContext, this.epW);
        this.fyG.setUniqueId(getTag());
        this.exk = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.exk.setOnClickListener(this.exT);
        this.ezx = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.ezx.setPageId(getTag());
        this.ezz = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.ezz != null) {
            this.ezz.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dBf != null) {
                    c.this.dBf.changeSelectStatus();
                }
            }
        });
        this.dBf.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void eq(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(al.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.dCe = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.YA = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.exO != null) {
            this.exO.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exO != null) {
            this.exO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exO != null) {
            this.exO.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.drawable.addresslist_item_bg);
            al.l(this.cTa, R.color.cp_bg_line_e);
            this.exO.onChangeSkinType();
            this.dBf.onChangeSkinType();
            this.dBe.onChangeSkinType();
            if (this.YA != null) {
                this.YA.onChangeSkinType();
            }
            this.fyG.onChangeSkinType();
            if (this.dBT != null && this.dBT.getVisibility() == 0) {
                this.dBT.onChangeSkinType();
            }
            if (this.exl != null && this.exl.getHeadView() != null && (this.exl.getHeadView() instanceof TbImageView)) {
                this.exl.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.get());
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
        this.VJ = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.exT);
        }
        this.exk.onChangeSkinType();
        if (!aXB() && n.uS(this.VJ.getId())) {
            n.a(this.mTitle, this.VJ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VB, this.VJ.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.exk.getGodReplyContent(), this.VJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bgVar);
        this.fyG.am(this.VJ);
        R(bgVar);
        this.dBe.setData(this.VJ);
        this.exk.setFromCDN(this.XI);
        this.exk.setData(this.VJ.aeT());
        this.dBe.setUserAfterClickListener(this.Xz);
        nv(mh(1));
        if (this.dBe.getHeaderImg() != null) {
            if (this.dBe.getIsSimpleThread()) {
                this.dBe.getHeaderImg().setVisibility(8);
                this.exl.setVisibility(8);
            } else if (bgVar.adv() == null || bgVar.adv().getPendantData() == null || StringUtils.isNull(bgVar.adv().getPendantData().abS())) {
                this.exl.setVisibility(8);
                this.dBe.getHeaderImg().setVisibility(0);
                this.dBe.getHeaderImg().setData(bgVar);
            } else {
                this.dBe.getHeaderImg().setVisibility(4);
                this.exl.setVisibility(0);
                this.exl.setData(bgVar);
            }
        }
        ag(bgVar);
        ah(bgVar);
        this.YA.setData(bgVar.aeh());
        this.YA.setForumId(String.valueOf(bgVar.getFid()));
        AppletsCellView appletsCellView = this.YA;
        AppletsCellView appletsCellView2 = this.YA;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> adJ = bgVar.adJ();
        if (v.aa(adJ)) {
            this.XR.setVisibility(8);
        } else {
            this.XR.cnG();
            this.XR.setVisibility(0);
            VoiceData.VoiceModel voiceModel = adJ.get(0);
            this.XR.setVoiceModel(voiceModel);
            this.XR.setTag(voiceModel);
            this.XR.bFE();
            if (voiceModel != null) {
                this.XR.vx(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> adF = bgVar.adF();
        if (i.abb().abf() && v.Z(adF) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < adF.size(); i++) {
                MediaData mediaData = (MediaData) v.c(adF, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.exO.setVisibility(0);
                this.exO.setFromCDN(this.XI);
                this.exO.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aXr = c.this.aXr();
                        if (z) {
                            if (aXr != null) {
                                view.setTag("1");
                                aXr.Xo = true;
                                aXr.a(view, c.this.VJ);
                            }
                            c.this.iq(false);
                            return;
                        }
                        if (aXr != null) {
                            view.setTag("1");
                            aXr.Xo = false;
                            aXr.a(view, c.this.VJ);
                        }
                        c.this.a(view, linkedList, i2, bgVar);
                    }
                });
                this.exO.setImageMediaList(linkedList);
            } else {
                this.exO.setVisibility(8);
            }
        } else {
            this.exO.setVisibility(8);
        }
        aXI();
        aXJ();
        bnn();
        if (this.dBf.isInFrsAllThread() && com.baidu.tieba.frs.a.biW().biX()) {
            this.mMaskView.setVisibility(0);
            if (this.VJ.afe() || this.VJ.aff()) {
                al.l(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aXI() {
        if (this.exM != null && this.exO != null && this.exk != null) {
            if (this.exO.getVisibility() == 8 && this.exk.getVisibility() == 8 && this.YA.getVisibility() == 8) {
                this.exM.setVisibility(0);
            } else {
                this.exM.setVisibility(8);
            }
        }
    }

    private void R(final bg bgVar) {
        if (this.ezz != null) {
            if (this.ezx == null || bgVar == null) {
                this.ezz.setVisibility(8);
            } else if (!StringUtils.isNull(bgVar.bKR) && this.ezx.getVisibility() != 0) {
                if (this.fyG != null && this.fyG.bqH() && (this.ezz.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ezz.getLayoutParams();
                    layoutParams.rightMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ezz.setLayoutParams(layoutParams);
                }
                this.ezz.setVisibility(0);
                this.ezz.setImageDrawable(null);
                this.ezz.startLoad(bgVar.bKR, 10, false);
                this.ezz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bgVar.bKS, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.ezz.setVisibility(8);
            }
        }
    }

    public void b(bg bgVar) {
        MetaData adv;
        if (bgVar != null && this.ezx != null && (adv = bgVar.adv()) != null) {
            final ThemeCardInUserData themeCard = adv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ezx.setVisibility(8);
                return;
            }
            this.ezx.setVisibility(0);
            this.ezx.setImageDrawable(null);
            this.ezx.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ezx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.urlType = this.XI ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.adA(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.XI, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bgVar.getId();
            historyMessage.threadName = bgVar.getTitle();
            historyMessage.forumName = bgVar.adA();
            historyMessage.postID = bgVar.adL();
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

    private void aXJ() {
        this.XR.setClickable(true);
        int childCount = this.exO.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.exO.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dBf != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dBe != null) {
            this.dBe.setPageUniqueId(bdUniqueId);
        }
        if (this.exO != null) {
            this.exO.setPageUniqueId(bdUniqueId);
        }
    }

    protected void iq(boolean z) {
        if (this.VJ != null) {
            n.uR(this.VJ.getId());
            n.a(this.mTitle, this.VJ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VB, this.VJ.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.exk.getGodReplyContent(), this.VJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            o aey = this.VJ.aey();
            if (aey != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.cD(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aey.getCartoonId(), aey.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.VJ.bKh;
            if (this.VJ.bKg == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.bEX;
                long j = lVar.bEY;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.mPageContext;
                amVar.bFl = str;
                amVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.VJ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.VJ.aeu() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aXB() {
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
    public void nt(int i) {
        this.currentPageType = i;
        if (this.dBf != null) {
            this.dBf.caD = i;
            if (i == 15) {
                this.dBf.setFrom(10);
            } else {
                this.dBf.setFrom(2);
                this.dBf.setDisPraiseFrom(2);
            }
        }
        if (this.dBe != null) {
            if (i == 15) {
                this.dBe.setFrom(5);
            } else {
                this.dBe.setFrom(3);
            }
        }
    }

    private boolean ag(bg bgVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fyQ)) {
            bgVar.bC(this.mUrl, this.fyQ);
        }
        SpannableStringBuilder m = bgVar.m(false, true);
        if (m == null || StringUtils.isNull(m.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(m));
            this.mTitle.setText(m);
            n.a(this.mTitle, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void ah(bg bgVar) {
        if (bgVar != null && mh(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fyQ)) {
                bgVar.bC(this.mUrl, this.fyQ);
            }
            SpannableString aeW = bgVar.aeW();
            if (aeW != null && !ap.isEmpty(aeW.toString())) {
                this.VB.setVisibility(0);
                this.VB.setOnTouchListener(new k(aeW));
                this.VB.setText(aeW);
                n.a(this.VB, bgVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.VB.setVisibility(8);
            return;
        }
        this.VB.setVisibility(8);
    }

    private void bnn() {
        if (this.mTitle != null && this.XR != null && this.exO != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XR.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.XR.setLayoutParams(layoutParams);
            if (this.XR.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.exO.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.exO.setLayoutParams(layoutParams2);
            }
        }
    }

    public void nv(int i) {
        if (this.VJ != null) {
            if (i == 1) {
                this.dBf.setVisibility(8);
                if (this.dBT != null) {
                    this.dBT.setData(this.VJ);
                    return;
                }
                return;
            }
            this.dBf.setData(this.VJ);
            if (this.dBT != null) {
                this.dBT.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Ws = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBq().ag(this.Ws, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.exO != null) {
            this.exO.setPreloadSizeReadyCallback(bVar);
        }
    }
}
