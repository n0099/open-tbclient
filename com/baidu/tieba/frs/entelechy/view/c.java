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
    protected View eLg;
    public LinearLayout eTB;
    public ThreadUserInfoLayout fGn;
    protected ThreadCommentAndPraiseInfoLayout fGo;
    protected ThreadSourceShareAndPraiseLayout fHa;
    private ThreadGodReplyLayout gDL;
    private HeadPendantClickableView gDM;
    protected View gEk;
    protected ConstrainImageGroup gEm;
    private View.OnClickListener gEr;
    private final View.OnClickListener gEs;
    public TbImageView gFS;
    private TbImageView gFU;
    private i hxK;
    private String hxU;
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
        this.gEr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bTX().bTY()) {
                    if (c.this.fGo != null) {
                        c.this.fGo.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.bKS() != null) {
                    c.this.bKS().a(view, c.this.aee);
                }
                c.this.lN(view == c.this.gDL);
            }
        };
        this.gEs = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<bk> bKS = c.this.bKS();
                if (bKS != null) {
                    view.setTag("2");
                    bKS.a(view, c.this.aee);
                }
            }
        };
        this.agI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bKS() != null) {
                    c.this.bKS().a(view, c.this.aee);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.gDM = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.gDM.getHeadView() != null) {
            this.gDM.getHeadView().setIsRound(true);
            this.gDM.getHeadView().setDrawBorder(false);
            this.gDM.getHeadView().setDefaultResource(17170445);
            this.gDM.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gDM.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.gDM.setHasPendantStyle();
        if (this.gDM.getPendantView() != null) {
            this.gDM.getPendantView().setIsRound(true);
            this.gDM.getPendantView().setDrawBorder(false);
        }
        this.gDM.setAfterClickListener(this.agI);
        this.eLg = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.ahm = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.ahm.setAfterClickListener(this.gEs);
        this.adV = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.adV.setVisibility(8);
        this.gEk = view.findViewById(R.id.divider_line_above_praise);
        this.gEm = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.gEm.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gEm.setChildClickListener(this.gEr);
        f fVar = new f(3);
        fVar.o(1.0d);
        this.gEm.setImageProcessor(fVar);
        this.fGo = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.fGn = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.fGn.setUserAfterClickListener(this.agI);
        this.fGn.setFrom(3);
        this.fGo.setOnClickListener(this.gEr);
        this.fGo.setForumAfterClickListener(this.agI);
        this.fGo.setReplyTimeVisible(false);
        this.fGo.setShowPraiseNum(true);
        this.fGo.setNeedAddPraiseIcon(true);
        this.fGo.setNeedAddReplyIcon(true);
        this.fGo.setIsBarViewVisible(false);
        this.fGo.setShareVisible(true);
        this.fGo.setShareReportFrom(1);
        this.fGo.setStType("frs_page");
        this.fGo.setFrom(2);
        this.fGo.dWv = 3;
        this.fHa = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.fHa != null) {
            this.fHa.dXt.setOnClickListener(this.gEr);
            this.fHa.setFrom(2);
            this.fHa.setShareReportFrom(1);
            this.fHa.setSourceFromForPb(3);
            this.fHa.setStType("frs_page");
            this.fHa.setHideBarName(true);
            this.fHa.dXt.setNeedAddReplyIcon(true);
        }
        this.bej = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hxK = new i(this.mPageContext, this.bej);
        this.hxK.setUniqueId(getTag());
        this.gDL = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.gDL.setOnClickListener(this.gEr);
        this.gFS = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.gFS.setPageId(getTag());
        this.gFU = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.gFU != null) {
            this.gFU.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fGo != null) {
                    c.this.fGo.changeSelectStatus();
                }
            }
        });
        this.fGo.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void hp(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.eTB = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.ahY = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.gEm != null) {
            this.gEm.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gEm != null) {
            this.gEm.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gEm != null) {
            this.gEm.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.eLg, R.color.cp_bg_line_c);
            this.gEm.onChangeSkinType();
            this.fGo.onChangeSkinType();
            this.fGn.onChangeSkinType();
            if (this.ahY != null) {
                this.ahY.onChangeSkinType();
            }
            this.hxK.onChangeSkinType();
            if (this.fHa != null && this.fHa.getVisibility() == 0) {
                this.fHa.onChangeSkinType();
            }
            if (this.gDM != null && this.gDM.getHeadView() != null && (this.gDM.getHeadView() instanceof TbImageView)) {
                this.gDM.getHeadView().setPlaceHolder(1);
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
            getView().setOnClickListener(this.gEr);
        }
        this.gDL.onChangeSkinType();
        if (!bLb() && m.Do(this.aee.getId())) {
            m.a(this.mTitle, this.aee.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.adV, this.aee.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            m.a(this.gDL.getGodReplyContent(), this.aee.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bkVar);
        this.hxK.aA(this.aee);
        Z(bkVar);
        this.fGn.setData(this.aee);
        this.gDL.setFromCDN(this.aha);
        this.gDL.setData(this.aee.aSb());
        this.fGn.setUserAfterClickListener(this.agI);
        qy(oY(1));
        if (this.fGn.getHeaderImg() != null) {
            if (this.fGn.getIsSimpleThread()) {
                this.fGn.getHeaderImg().setVisibility(8);
                this.gDM.setVisibility(8);
            } else if (bkVar.aQx() == null || bkVar.aQx().getPendantData() == null || StringUtils.isNull(bkVar.aQx().getPendantData().aOP())) {
                this.gDM.setVisibility(8);
                this.fGn.getHeaderImg().setVisibility(0);
                this.fGn.getHeaderImg().setData(bkVar);
            } else {
                this.fGn.getHeaderImg().setVisibility(4);
                this.gDM.setVisibility(0);
                this.gDM.setData(bkVar);
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
            this.ahm.deL();
            this.ahm.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aQL.get(0);
            this.ahm.setVoiceModel(voiceModel);
            this.ahm.setTag(voiceModel);
            this.ahm.crm();
            if (voiceModel != null) {
                this.ahm.yi(voiceModel.voice_status.intValue());
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
                this.gEm.setVisibility(0);
                this.gEm.setFromCDN(this.aha);
                this.gEm.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        aa<bk> bKS = c.this.bKS();
                        if (z) {
                            if (bKS != null) {
                                view.setTag("1");
                                bKS.agg = true;
                                bKS.a(view, c.this.aee);
                            }
                            c.this.lN(false);
                            return;
                        }
                        if (bKS != null) {
                            view.setTag("1");
                            bKS.agg = false;
                            bKS.a(view, c.this.aee);
                        }
                        c.this.a(view, linkedList, i2, bkVar);
                    }
                });
                this.gEm.setImageMediaList(linkedList);
            } else {
                this.gEm.setVisibility(8);
            }
        } else {
            this.gEm.setVisibility(8);
        }
        bLj();
        bLk();
        bYA();
        if (this.fGo.isInFrsAllThread() && com.baidu.tieba.frs.a.bTX().bTY()) {
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

    private void bLj() {
        if (this.gEk != null && this.gEm != null && this.gDL != null) {
            if (this.gEm.getVisibility() == 8 && this.gDL.getVisibility() == 8 && this.ahY.getVisibility() == 8) {
                this.gEk.setVisibility(0);
            } else {
                this.gEk.setVisibility(8);
            }
        }
    }

    private void Z(final bk bkVar) {
        if (this.gFU != null) {
            if (this.gFS == null || bkVar == null) {
                this.gFU.setVisibility(8);
            } else if (!StringUtils.isNull(bkVar.dHn) && this.gFS.getVisibility() != 0) {
                if (this.hxK != null && this.hxK.cca() && (this.gFU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFU.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.gFU.setLayoutParams(layoutParams);
                }
                this.gFU.setVisibility(0);
                this.gFU.setImageDrawable(null);
                this.gFU.startLoad(bkVar.dHn, 10, false);
                this.gFU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bkVar.dHo, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gFU.setVisibility(8);
            }
        }
    }

    public void b(bk bkVar) {
        MetaData aQx;
        if (bkVar != null && this.gFS != null && (aQx = bkVar.aQx()) != null) {
            final ThemeCardInUserData themeCard = aQx.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.gFS.setVisibility(8);
                return;
            }
            this.gFS.setVisibility(0);
            this.gFS.setImageDrawable(null);
            this.gFS.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.gFS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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

    private void bLk() {
        this.ahm.setClickable(true);
        int childCount = this.gEm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gEm.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fGo != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fGn != null) {
            this.fGn.setPageUniqueId(bdUniqueId);
        }
        if (this.gEm != null) {
            this.gEm.setPageUniqueId(bdUniqueId);
        }
    }

    protected void lN(boolean z) {
        if (this.aee != null) {
            m.Dn(this.aee.getId());
            m.a(this.mTitle, this.aee.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.adV, this.aee.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            m.a(this.gDL.getGodReplyContent(), this.aee.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
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

    private boolean bLb() {
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
    public void qw(int i) {
        this.currentPageType = i;
        if (this.fGo != null) {
            this.fGo.dWv = i;
            this.fGo.setFrom(2);
        }
        if (this.fGn != null) {
            this.fGn.setFrom(3);
        }
    }

    private boolean at(bk bkVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hxU)) {
            bkVar.cY(this.mUrl, this.hxU);
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
        if (bkVar != null && oY(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hxU)) {
                bkVar.cY(this.mUrl, this.hxU);
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

    private void bYA() {
        if (this.mTitle != null && this.ahm != null && this.gEm != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahm.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.ahm.setLayoutParams(layoutParams);
            if (this.ahm.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gEm.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.gEm.setLayoutParams(layoutParams2);
            }
        }
    }

    public void qy(int i) {
        if (this.aee != null) {
            if (i == 1) {
                this.fGo.setVisibility(8);
                if (this.fHa != null) {
                    this.fHa.setData(this.aee);
                    return;
                }
                return;
            }
            this.fGo.setData(this.aee);
            if (this.fHa != null) {
                this.fHa.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    public int oY(int i) {
        return com.baidu.tieba.a.d.blZ().as(this.aeX, i);
    }
}
