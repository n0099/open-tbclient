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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.data.p;
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
import com.baidu.tieba.card.x;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private RelativeLayout aWR;
    private TextView adB;
    protected bj adJ;
    private String aeB;
    private PlayVoiceBntNew agJ;
    private final View.OnClickListener agl;
    protected boolean agw;
    private AppletsCellView ahv;
    protected View cDC;
    public LinearLayout eHe;
    public ThreadUserInfoLayout fsv;
    protected ThreadCommentAndPraiseInfoLayout fsw;
    protected ThreadSourceShareAndPraiseLayout fti;
    private ThreadGodReplyLayout goV;
    private HeadPendantClickableView goW;
    private View.OnClickListener gpC;
    private final View.OnClickListener gpD;
    protected View gpv;
    protected ConstrainImageGroup gpx;
    public TbImageView grd;
    private TbImageView grf;
    private i hiW;
    private String hjg;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.agw = true;
        this.gpC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bNC().bND()) {
                    if (c.this.fsw != null) {
                        c.this.fsw.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.bEx() != null) {
                    c.this.bEx().a(view, c.this.adJ);
                }
                c.this.lr(view == c.this.goV);
            }
        };
        this.gpD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<bj> bEx = c.this.bEx();
                if (bEx != null) {
                    view.setTag("2");
                    bEx.a(view, c.this.adJ);
                }
            }
        };
        this.agl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bEx() != null) {
                    c.this.bEx().a(view, c.this.adJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.goW = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.goW.getHeadView() != null) {
            this.goW.getHeadView().setIsRound(true);
            this.goW.getHeadView().setDrawBorder(false);
            this.goW.getHeadView().setDefaultResource(17170445);
            this.goW.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goW.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.goW.setHasPendantStyle();
        if (this.goW.getPendantView() != null) {
            this.goW.getPendantView().setIsRound(true);
            this.goW.getPendantView().setDrawBorder(false);
        }
        this.goW.setAfterClickListener(this.agl);
        this.cDC = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.agJ = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.agJ.setAfterClickListener(this.gpD);
        this.adB = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.adB.setVisibility(8);
        this.gpv = view.findViewById(R.id.divider_line_above_praise);
        this.gpx = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.gpx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gpx.setChildClickListener(this.gpC);
        f fVar = new f(3);
        fVar.n(1.0d);
        this.gpx.setImageProcessor(fVar);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.fsv = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.fsv.setUserAfterClickListener(this.agl);
        this.fsv.setFrom(3);
        this.fsw.setOnClickListener(this.gpC);
        this.fsw.setForumAfterClickListener(this.agl);
        this.fsw.setReplyTimeVisible(false);
        this.fsw.setShowPraiseNum(true);
        this.fsw.setNeedAddPraiseIcon(true);
        this.fsw.setNeedAddReplyIcon(true);
        this.fsw.setIsBarViewVisible(false);
        this.fsw.setShareVisible(true);
        this.fsw.setShareReportFrom(1);
        this.fsw.setStType("frs_page");
        this.fsw.setFrom(2);
        this.fsw.dIg = 3;
        this.fti = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.fti != null) {
            this.fti.dJe.setOnClickListener(this.gpC);
            this.fti.setFrom(2);
            this.fti.setShareReportFrom(1);
            this.fti.setSourceFromForPb(3);
            this.fti.setStType("frs_page");
            this.fti.setHideBarName(true);
            this.fti.dJe.setNeedAddReplyIcon(true);
        }
        this.aWR = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hiW = new i(this.mPageContext, this.aWR);
        this.hiW.setUniqueId(getTag());
        this.goV = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.goV.setOnClickListener(this.gpC);
        this.grd = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.grd.setPageId(getTag());
        this.grf = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.grf != null) {
            this.grf.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fsw != null) {
                    c.this.fsw.changeSelectStatus();
                }
            }
        });
        this.fsw.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void gS(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.eHe = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.ahv = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.gpx != null) {
            this.gpx.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpx != null) {
            this.gpx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpx != null) {
            this.gpx.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.cDC, R.color.cp_bg_line_c);
            this.gpx.onChangeSkinType();
            this.fsw.onChangeSkinType();
            this.fsv.onChangeSkinType();
            if (this.ahv != null) {
                this.ahv.onChangeSkinType();
            }
            this.hiW.onChangeSkinType();
            if (this.fti != null && this.fti.getVisibility() == 0) {
                this.fti.onChangeSkinType();
            }
            if (this.goW != null && this.goW.getHeadView() != null && (this.goW.getHeadView() instanceof TbImageView)) {
                this.goW.getHeadView().setPlaceHolder(1);
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
    public void a(final bj bjVar) {
        if (bjVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.adJ = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gpC);
        }
        this.goV.onChangeSkinType();
        if (!bEI() && com.baidu.tieba.card.l.BF(this.adJ.getId())) {
            com.baidu.tieba.card.l.a(this.mTitle, this.adJ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.adB, this.adJ.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.goV.getGodReplyContent(), this.adJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bjVar);
        this.hiW.az(this.adJ);
        Y(bjVar);
        this.fsv.setData(this.adJ);
        this.goV.setFromCDN(this.agw);
        this.goV.setData(this.adJ.aMc());
        this.fsv.setUserAfterClickListener(this.agl);
        pX(or(1));
        if (this.fsv.getHeaderImg() != null) {
            if (this.fsv.getIsSimpleThread()) {
                this.fsv.getHeaderImg().setVisibility(8);
                this.goW.setVisibility(8);
            } else if (bjVar.aKC() == null || bjVar.aKC().getPendantData() == null || StringUtils.isNull(bjVar.aKC().getPendantData().aIU())) {
                this.goW.setVisibility(8);
                this.fsv.getHeaderImg().setVisibility(0);
                this.fsv.getHeaderImg().setData(bjVar);
            } else {
                this.fsv.getHeaderImg().setVisibility(4);
                this.goW.setVisibility(0);
                this.goW.setData(bjVar);
            }
        }
        as(bjVar);
        at(bjVar);
        this.ahv.setData(bjVar.aLo());
        this.ahv.setForumId(String.valueOf(bjVar.getFid()));
        AppletsCellView appletsCellView = this.ahv;
        AppletsCellView appletsCellView2 = this.ahv;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aKQ = bjVar.aKQ();
        if (v.isEmpty(aKQ)) {
            this.agJ.setVisibility(8);
        } else {
            this.agJ.cXx();
            this.agJ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aKQ.get(0);
            this.agJ.setVoiceModel(voiceModel);
            this.agJ.setTag(voiceModel);
            this.agJ.ckN();
            if (voiceModel != null) {
                this.agJ.xC(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aKM = bjVar.aKM();
        if (com.baidu.tbadk.core.i.aIc().isShowImages() && v.getCount(aKM) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aKM.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aKM, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.gpx.setVisibility(0);
                this.gpx.setFromCDN(this.agw);
                this.gpx.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        z<bj> bEx = c.this.bEx();
                        if (z) {
                            if (bEx != null) {
                                view.setTag("1");
                                bEx.afJ = true;
                                bEx.a(view, c.this.adJ);
                            }
                            c.this.lr(false);
                            return;
                        }
                        if (bEx != null) {
                            view.setTag("1");
                            bEx.afJ = false;
                            bEx.a(view, c.this.adJ);
                        }
                        c.this.a(view, linkedList, i2, bjVar);
                    }
                });
                this.gpx.setImageMediaList(linkedList);
            } else {
                this.gpx.setVisibility(8);
            }
        } else {
            this.gpx.setVisibility(8);
        }
        bEQ();
        bER();
        bSf();
        if (this.fsw.isInFrsAllThread() && com.baidu.tieba.frs.a.bNC().bND()) {
            this.mMaskView.setVisibility(0);
            if (this.adJ.aMl() || this.adJ.aMm()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bEQ() {
        if (this.gpv != null && this.gpx != null && this.goV != null) {
            if (this.gpx.getVisibility() == 8 && this.goV.getVisibility() == 8 && this.ahv.getVisibility() == 8) {
                this.gpv.setVisibility(0);
            } else {
                this.gpv.setVisibility(8);
            }
        }
    }

    private void Y(final bj bjVar) {
        if (this.grf != null) {
            if (this.grd == null || bjVar == null) {
                this.grf.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.dtu) && this.grd.getVisibility() != 0) {
                if (this.hiW != null && this.hiW.bVC() && (this.grf.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grf.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.grf.setLayoutParams(layoutParams);
                }
                this.grf.setVisibility(0);
                this.grf.setImageDrawable(null);
                this.grf.startLoad(bjVar.dtu, 10, false);
                this.grf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bjVar.dtv, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.grf.setVisibility(8);
            }
        }
    }

    public void b(bj bjVar) {
        MetaData aKC;
        if (bjVar != null && this.grd != null && (aKC = bjVar.aKC()) != null) {
            final ThemeCardInUserData themeCard = aKC.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.grd.setVisibility(8);
                return;
            }
            this.grd.setVisibility(0);
            this.grd.setImageDrawable(null);
            this.grd.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.grd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bj bjVar) {
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
                imageUrlData.urlType = this.agw ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.isEmpty(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aKH(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.agw, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            createConfig.setThreadData(bjVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bjVar.getId();
            historyMessage.threadName = bjVar.getTitle();
            historyMessage.forumName = bjVar.aKH();
            historyMessage.postID = bjVar.aKS();
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

    private void bER() {
        this.agJ.setClickable(true);
        int childCount = this.gpx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gpx.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fsw != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fsv != null) {
            this.fsv.setPageUniqueId(bdUniqueId);
        }
        if (this.gpx != null) {
            this.gpx.setPageUniqueId(bdUniqueId);
        }
    }

    protected void lr(boolean z) {
        if (this.adJ != null) {
            com.baidu.tieba.card.l.BE(this.adJ.getId());
            com.baidu.tieba.card.l.a(this.mTitle, this.adJ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.adB, this.adJ.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.goV.getGodReplyContent(), this.adJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            p aLK = this.adJ.aLK();
            if (aLK != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aLK.getCartoonId(), aLK.getChapterId(), 2)));
                return;
            }
            m mVar = this.adJ.dsR;
            if (this.adJ.dsQ == 1 && mVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = mVar.dnw;
                long j = mVar.dnx;
                ao aoVar = new ao();
                aoVar.pageContext = this.mPageContext;
                aoVar.dnK = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.adJ, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.adJ.aLG() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean bEI() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.currentPageType = i;
        if (this.fsw != null) {
            this.fsw.dIg = i;
            this.fsw.setFrom(2);
        }
        if (this.fsv != null) {
            this.fsv.setFrom(3);
        }
    }

    private boolean as(bj bjVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hjg)) {
            bjVar.cz(this.mUrl, this.hjg);
        }
        SpannableStringBuilder u = bjVar.u(false, true);
        if (u == null || StringUtils.isNull(u.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(u));
            this.mTitle.setText(u);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void at(bj bjVar) {
        if (bjVar != null && or(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hjg)) {
                bjVar.cz(this.mUrl, this.hjg);
            }
            SpannableString aLu = bjVar.aLu();
            if (aLu != null && !aq.isEmpty(aLu.toString())) {
                this.adB.setVisibility(0);
                this.adB.setOnTouchListener(new com.baidu.tieba.view.i(aLu));
                this.adB.setText(aLu);
                com.baidu.tieba.card.l.a(this.adB, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.adB.setVisibility(8);
            return;
        }
        this.adB.setVisibility(8);
    }

    private void bSf() {
        if (this.mTitle != null && this.agJ != null && this.gpx != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agJ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.agJ.setLayoutParams(layoutParams);
            if (this.agJ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gpx.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.gpx.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pX(int i) {
        if (this.adJ != null) {
            if (i == 1) {
                this.fsw.setVisibility(8);
                if (this.fti != null) {
                    this.fti.setData(this.adJ);
                    return;
                }
                return;
            }
            this.fsw.setData(this.adJ);
            if (this.fti != null) {
                this.fti.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfN().ar(this.aeB, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.gpx != null) {
            this.gpx.setPreloadSizeReadyCallback(bVar);
        }
    }
}
