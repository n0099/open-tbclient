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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<bk> implements com.baidu.tieba.a.e, y {
    private TextView adV;
    private String aeX;
    protected bk aee;
    private final View.OnClickListener agI;
    private AppletsCellView ahY;
    protected boolean aha;
    private PlayVoiceBntNew ahm;
    private RelativeLayout bej;
    protected View eLr;
    public LinearLayout eTM;
    public ThreadUserInfoLayout fGy;
    protected ThreadCommentAndPraiseInfoLayout fGz;
    protected ThreadSourceShareAndPraiseLayout fHl;
    private ThreadGodReplyLayout gDW;
    private HeadPendantClickableView gDX;
    private View.OnClickListener gEC;
    private final View.OnClickListener gED;
    protected View gEv;
    protected ConstrainImageGroup gEx;
    public TbImageView gGd;
    private TbImageView gGf;
    private i hxV;
    private String hyf;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aha = true;
        this.gEC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bTZ().bUa()) {
                    if (c.this.fGz != null) {
                        c.this.fGz.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.bKU() != null) {
                    c.this.bKU().a(view, c.this.aee);
                }
                c.this.lN(view == c.this.gDW);
            }
        };
        this.gED = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<bk> bKU = c.this.bKU();
                if (bKU != null) {
                    view.setTag("2");
                    bKU.a(view, c.this.aee);
                }
            }
        };
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bKU() != null) {
                    c.this.bKU().a(view, c.this.aee);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.gDX = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.gDX.getHeadView() != null) {
            this.gDX.getHeadView().setIsRound(true);
            this.gDX.getHeadView().setDrawBorder(false);
            this.gDX.getHeadView().setDefaultResource(17170445);
            this.gDX.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gDX.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.gDX.setHasPendantStyle();
        if (this.gDX.getPendantView() != null) {
            this.gDX.getPendantView().setIsRound(true);
            this.gDX.getPendantView().setDrawBorder(false);
        }
        this.gDX.setAfterClickListener(this.agI);
        this.eLr = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.ahm = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.ahm.setAfterClickListener(this.gED);
        this.adV = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.adV.setVisibility(8);
        this.gEv = view.findViewById(R.id.divider_line_above_praise);
        this.gEx = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.gEx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gEx.setChildClickListener(this.gEC);
        f fVar = new f(3);
        fVar.o(1.0d);
        this.gEx.setImageProcessor(fVar);
        this.fGz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.fGy = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.fGy.setUserAfterClickListener(this.agI);
        this.fGy.setFrom(3);
        this.fGz.setOnClickListener(this.gEC);
        this.fGz.setForumAfterClickListener(this.agI);
        this.fGz.setReplyTimeVisible(false);
        this.fGz.setShowPraiseNum(true);
        this.fGz.setNeedAddPraiseIcon(true);
        this.fGz.setNeedAddReplyIcon(true);
        this.fGz.setIsBarViewVisible(false);
        this.fGz.setShareVisible(true);
        this.fGz.setShareReportFrom(1);
        this.fGz.setStType("frs_page");
        this.fGz.setFrom(2);
        this.fGz.dWv = 3;
        this.fHl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.fHl != null) {
            this.fHl.dXt.setOnClickListener(this.gEC);
            this.fHl.setFrom(2);
            this.fHl.setShareReportFrom(1);
            this.fHl.setSourceFromForPb(3);
            this.fHl.setStType("frs_page");
            this.fHl.setHideBarName(true);
            this.fHl.dXt.setNeedAddReplyIcon(true);
        }
        this.bej = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hxV = new i(this.mPageContext, this.bej);
        this.hxV.setUniqueId(getTag());
        this.gDW = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.gDW.setOnClickListener(this.gEC);
        this.gGd = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.gGd.setPageId(getTag());
        this.gGf = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.gGf != null) {
            this.gGf.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fGz != null) {
                    c.this.fGz.changeSelectStatus();
                }
            }
        });
        this.fGz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void hp(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.eTM = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.ahY = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.gEx != null) {
            this.gEx.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gEx != null) {
            this.gEx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gEx != null) {
            this.gEx.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.eLr, R.color.cp_bg_line_c);
            this.gEx.onChangeSkinType();
            this.fGz.onChangeSkinType();
            this.fGy.onChangeSkinType();
            if (this.ahY != null) {
                this.ahY.onChangeSkinType();
            }
            this.hxV.onChangeSkinType();
            if (this.fHl != null && this.fHl.getVisibility() == 0) {
                this.fHl.onChangeSkinType();
            }
            if (this.gDX != null && this.gDX.getHeadView() != null && (this.gDX.getHeadView() instanceof TbImageView)) {
                this.gDX.getHeadView().setPlaceHolder(1);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(final bk bkVar) {
        if (bkVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aee = bkVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gEC);
        }
        this.gDW.onChangeSkinType();
        if (!bLd() && m.Do(this.aee.getId())) {
            m.a(this.mTitle, this.aee.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.adV, this.aee.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            m.a(this.gDW.getGodReplyContent(), this.aee.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bkVar);
        this.hxV.aA(this.aee);
        Z(bkVar);
        this.fGy.setData(this.aee);
        this.gDW.setFromCDN(this.aha);
        this.gDW.setData(this.aee.aSb());
        this.fGy.setUserAfterClickListener(this.agI);
        qA(pa(1));
        if (this.fGy.getHeaderImg() != null) {
            if (this.fGy.getIsSimpleThread()) {
                this.fGy.getHeaderImg().setVisibility(8);
                this.gDX.setVisibility(8);
            } else if (bkVar.aQx() == null || bkVar.aQx().getPendantData() == null || StringUtils.isNull(bkVar.aQx().getPendantData().aOP())) {
                this.gDX.setVisibility(8);
                this.fGy.getHeaderImg().setVisibility(0);
                this.fGy.getHeaderImg().setData(bkVar);
            } else {
                this.fGy.getHeaderImg().setVisibility(4);
                this.gDX.setVisibility(0);
                this.gDX.setData(bkVar);
            }
        }
        at(bkVar);
        au(bkVar);
        this.ahY.setData(bkVar.aRn());
        this.ahY.setForumId(String.valueOf(bkVar.getFid()));
        AppletsCellView appletsCellView = this.ahY;
        AppletsCellView appletsCellView2 = this.ahY;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aQL = bkVar.aQL();
        if (v.isEmpty(aQL)) {
            this.ahm.setVisibility(8);
        } else {
            this.ahm.dfa();
            this.ahm.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aQL.get(0);
            this.ahm.setVoiceModel(voiceModel);
            this.ahm.setTag(voiceModel);
            this.ahm.crv();
            if (voiceModel != null) {
                this.ahm.yk(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aQH = bkVar.aQH();
        if (k.aNQ().isShowImages() && v.getCount(aQH) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aQH.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aQH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.gEx.setVisibility(0);
                this.gEx.setFromCDN(this.aha);
                this.gEx.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        aa<bk> bKU = c.this.bKU();
                        if (z) {
                            if (bKU != null) {
                                view.setTag("1");
                                bKU.agg = true;
                                bKU.a(view, c.this.aee);
                            }
                            c.this.lN(false);
                            return;
                        }
                        if (bKU != null) {
                            view.setTag("1");
                            bKU.agg = false;
                            bKU.a(view, c.this.aee);
                        }
                        c.this.a(view, linkedList, i2, bkVar);
                    }
                });
                this.gEx.setImageMediaList(linkedList);
            } else {
                this.gEx.setVisibility(8);
            }
        } else {
            this.gEx.setVisibility(8);
        }
        bLl();
        bLm();
        bYD();
        if (this.fGz.isInFrsAllThread() && com.baidu.tieba.frs.a.bTZ().bUa()) {
            this.mMaskView.setVisibility(0);
            if (this.aee.aSk() || this.aee.aSl()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bLl() {
        if (this.gEv != null && this.gEx != null && this.gDW != null) {
            if (this.gEx.getVisibility() == 8 && this.gDW.getVisibility() == 8 && this.ahY.getVisibility() == 8) {
                this.gEv.setVisibility(0);
            } else {
                this.gEv.setVisibility(8);
            }
        }
    }

    private void Z(final bk bkVar) {
        if (this.gGf != null) {
            if (this.gGd == null || bkVar == null) {
                this.gGf.setVisibility(8);
            } else if (!StringUtils.isNull(bkVar.dHn) && this.gGd.getVisibility() != 0) {
                if (this.hxV != null && this.hxV.cci() && (this.gGf.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gGf.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.gGf.setLayoutParams(layoutParams);
                }
                this.gGf.setVisibility(0);
                this.gGf.setImageDrawable(null);
                this.gGf.startLoad(bkVar.dHn, 10, false);
                this.gGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bkVar.dHo, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gGf.setVisibility(8);
            }
        }
    }

    public void b(bk bkVar) {
        MetaData aQx;
        if (bkVar != null && this.gGd != null && (aQx = bkVar.aQx()) != null) {
            final ThemeCardInUserData themeCard = aQx.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.gGd.setVisibility(8);
                return;
            }
            this.gGd.setVisibility(0);
            this.gGd.setImageDrawable(null);
            this.gGd.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.gGd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bk bkVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
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
                imageUrlData.urlType = this.aha ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bkVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.isEmpty(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bkVar.aQC(), String.valueOf(bkVar.getFid()), bkVar.getTid(), this.aha, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            createConfig.setThreadData(bkVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bkVar.getId();
            historyMessage.threadName = bkVar.getTitle();
            historyMessage.forumName = bkVar.aQC();
            historyMessage.postID = bkVar.aQP();
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

    private void bLm() {
        this.ahm.setClickable(true);
        int childCount = this.gEx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gEx.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fGz != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fGy != null) {
            this.fGy.setPageUniqueId(bdUniqueId);
        }
        if (this.gEx != null) {
            this.gEx.setPageUniqueId(bdUniqueId);
        }
    }

    protected void lN(boolean z) {
        if (this.aee != null) {
            m.Dn(this.aee.getId());
            m.a(this.mTitle, this.aee.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.adV, this.aee.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            m.a(this.gDW.getGodReplyContent(), this.aee.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            o aRJ = this.aee.aRJ();
            if (aRJ != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aRJ.getCartoonId(), aRJ.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.aee.dGL;
            if (this.aee.dGK == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.dBx;
                long j = lVar.dBy;
                com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
                anVar.pageContext = this.mPageContext;
                anVar.dBL = str;
                anVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, anVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aee, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aee.aRF() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean bLd() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
        this.currentPageType = i;
        if (this.fGz != null) {
            this.fGz.dWv = i;
            this.fGz.setFrom(2);
        }
        if (this.fGy != null) {
            this.fGy.setFrom(3);
        }
    }

    private boolean at(bk bkVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hyf)) {
            bkVar.cY(this.mUrl, this.hyf);
        }
        SpannableStringBuilder x = bkVar.x(false, true);
        if (x == null || StringUtils.isNull(x.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(x));
            this.mTitle.setText(x);
            m.a(this.mTitle, bkVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void au(bk bkVar) {
        if (bkVar != null && pa(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hyf)) {
                bkVar.cY(this.mUrl, this.hyf);
            }
            SpannableString aRt = bkVar.aRt();
            if (aRt != null && !aq.isEmpty(aRt.toString())) {
                this.adV.setVisibility(0);
                this.adV.setOnTouchListener(new com.baidu.tieba.view.i(aRt));
                this.adV.setText(aRt);
                m.a(this.adV, bkVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.adV.setVisibility(8);
            return;
        }
        this.adV.setVisibility(8);
    }

    private void bYD() {
        if (this.mTitle != null && this.ahm != null && this.gEx != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahm.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.ahm.setLayoutParams(layoutParams);
            if (this.ahm.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gEx.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.gEx.setLayoutParams(layoutParams2);
            }
        }
    }

    public void qA(int i) {
        if (this.aee != null) {
            if (i == 1) {
                this.fGz.setVisibility(8);
                if (this.fHl != null) {
                    this.fHl.setData(this.aee);
                    return;
                }
                return;
            }
            this.fGz.setData(this.aee);
            if (this.fHl != null) {
                this.fHl.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int pa(int i) {
        return com.baidu.tieba.a.d.bmb().as(this.aeX, i);
    }
}
