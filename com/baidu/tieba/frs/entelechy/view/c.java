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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.b<bv> implements com.baidu.tieba.a.e, y {
    protected bv aeA;
    private TextView aeq;
    private String afx;
    private final View.OnClickListener ahD;
    protected boolean aib;
    private PlayVoiceBntNew aio;
    private AppletsCellView ajq;
    private RelativeLayout bjP;
    protected ThreadSourceShareAndPraiseLayout fXN;
    public ThreadUserInfoLayout fXa;
    protected ThreadCommentAndPraiseInfoLayout fXb;
    protected View fbk;
    public LinearLayout fiQ;
    protected View gWQ;
    protected ConstrainImageGroup gWS;
    private View.OnClickListener gWX;
    private final View.OnClickListener gWY;
    private ThreadGodReplyLayout gWs;
    private HeadPendantClickableView gWt;
    public TbImageView gYB;
    private TbImageView gYD;
    private i hQR;
    private String hRb;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aib = true;
        this.gWX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) {
                    if (c.this.fXb != null) {
                        c.this.fXb.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.bRn() != null) {
                    c.this.bRn().a(view, c.this.aeA);
                }
                c.this.mB(view == c.this.gWs);
            }
        };
        this.gWY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<bv> bRn = c.this.bRn();
                if (bRn != null) {
                    view.setTag("2");
                    bRn.a(view, c.this.aeA);
                }
            }
        };
        this.ahD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bRn() != null) {
                    c.this.bRn().a(view, c.this.aeA);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.gWt = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.gWt.getHeadView() != null) {
            this.gWt.getHeadView().setIsRound(true);
            this.gWt.getHeadView().setDrawBorder(false);
            this.gWt.getHeadView().setDefaultResource(17170445);
            this.gWt.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gWt.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.gWt.setHasPendantStyle();
        if (this.gWt.getPendantView() != null) {
            this.gWt.getPendantView().setIsRound(true);
            this.gWt.getPendantView().setDrawBorder(false);
        }
        this.gWt.setAfterClickListener(this.ahD);
        this.fbk = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.aio = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.aio.setAfterClickListener(this.gWY);
        this.aeq = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.aeq.setVisibility(8);
        this.gWQ = view.findViewById(R.id.divider_line_above_praise);
        this.gWS = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.gWS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gWS.setChildClickListener(this.gWX);
        f fVar = new f(3);
        fVar.o(1.0d);
        this.gWS.setImageProcessor(fVar);
        this.fXb = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.fXa = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.fXa.setUserAfterClickListener(this.ahD);
        this.fXa.setFrom(3);
        this.fXb.setOnClickListener(this.gWX);
        this.fXb.setForumAfterClickListener(this.ahD);
        this.fXb.setReplyTimeVisible(false);
        this.fXb.setShowPraiseNum(true);
        this.fXb.setNeedAddPraiseIcon(true);
        this.fXb.setNeedAddReplyIcon(true);
        this.fXb.setIsBarViewVisible(false);
        this.fXb.setShareVisible(true);
        this.fXb.setShareReportFrom(1);
        this.fXb.setStType("frs_page");
        this.fXb.setFrom(2);
        this.fXb.ekb = 3;
        this.fXN = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.fXN != null) {
            this.fXN.ekZ.setOnClickListener(this.gWX);
            this.fXN.setFrom(2);
            this.fXN.setShareReportFrom(1);
            this.fXN.setSourceFromForPb(3);
            this.fXN.setStType("frs_page");
            this.fXN.setHideBarName(true);
            this.fXN.ekZ.setNeedAddReplyIcon(true);
        }
        this.bjP = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hQR = new i(this.mPageContext, this.bjP);
        this.hQR.setUniqueId(getTag());
        this.gWs = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.gWs.setOnClickListener(this.gWX);
        this.gYB = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.gYB.setPageId(getTag());
        this.gYD = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.gYD != null) {
            this.gYD.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.fXb != null) {
                    c.this.fXb.changeSelectStatus();
                }
            }
        });
        this.fXb.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void id(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ao.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.fiQ = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.ajq = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.gWS != null) {
            this.gWS.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gWS != null) {
            this.gWS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gWS != null) {
            this.gWS.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.fbk, R.color.cp_bg_line_c);
            this.gWS.onChangeSkinType();
            this.fXb.onChangeSkinType();
            this.fXa.onChangeSkinType();
            if (this.ajq != null) {
                this.ajq.onChangeSkinType();
            }
            this.hQR.onChangeSkinType();
            if (this.fXN != null && this.fXN.getVisibility() == 0) {
                this.fXN.onChangeSkinType();
            }
            if (this.gWt != null && this.gWt.getHeadView() != null && (this.gWt.getHeadView() instanceof TbImageView)) {
                this.gWt.getHeadView().setPlaceHolder(1);
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
    public void a(final bv bvVar) {
        if (bvVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aeA = bvVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gWX);
        }
        this.gWs.onChangeSkinType();
        if (!bRw() && m.EA(this.aeA.getId())) {
            m.a(this.mTitle, this.aeA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.aeq, this.aeA.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            m.a(this.gWs.getGodReplyContent(), this.aeA.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        b(bvVar);
        this.hQR.ax(this.aeA);
        X(bvVar);
        this.fXa.setData(this.aeA);
        this.gWs.setFromCDN(this.aib);
        this.gWs.setData(this.aeA.aXO());
        this.fXa.setUserAfterClickListener(this.ahD);
        rp(pM(1));
        if (this.fXa.getHeaderImg() != null) {
            if (this.fXa.getIsSimpleThread()) {
                this.fXa.getHeaderImg().setVisibility(8);
                this.gWt.setVisibility(8);
            } else if (bvVar.aWl() == null || bvVar.aWl().getPendantData() == null || StringUtils.isNull(bvVar.aWl().getPendantData().aUh())) {
                this.gWt.setVisibility(8);
                this.fXa.getHeaderImg().setVisibility(0);
                this.fXa.getHeaderImg().setData(bvVar);
            } else {
                this.fXa.getHeaderImg().setVisibility(4);
                this.gWt.setVisibility(0);
                this.gWt.setData(bvVar);
            }
        }
        aq(bvVar);
        ar(bvVar);
        this.ajq.setData(bvVar.aXa());
        this.ajq.setForumId(String.valueOf(bvVar.getFid()));
        AppletsCellView appletsCellView = this.ajq;
        AppletsCellView appletsCellView2 = this.ajq;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aWy = bvVar.aWy();
        if (x.isEmpty(aWy)) {
            this.aio.setVisibility(8);
        } else {
            this.aio.bFz();
            this.aio.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aWy.get(0);
            this.aio.setVoiceModel(voiceModel);
            this.aio.setTag(voiceModel);
            this.aio.changeSkin();
            if (voiceModel != null) {
                this.aio.zt(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aWu = bvVar.aWu();
        if (k.aTv().isShowImages() && x.getCount(aWu) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aWu.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(aWu, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (x.getCount(linkedList) > 0) {
                this.gWS.setVisibility(0);
                this.gWS.setFromCDN(this.aib);
                this.gWS.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        aa<bv> bRn = c.this.bRn();
                        if (z) {
                            if (bRn != null) {
                                view.setTag("1");
                                bRn.agK = true;
                                bRn.a(view, c.this.aeA);
                            }
                            c.this.mB(false);
                            return;
                        }
                        if (bRn != null) {
                            view.setTag("1");
                            bRn.agK = false;
                            bRn.a(view, c.this.aeA);
                        }
                        c.this.a(view, linkedList, i2, bvVar);
                    }
                });
                this.gWS.setImageMediaList(linkedList);
            } else {
                this.gWS.setVisibility(8);
            }
        } else {
            this.gWS.setVisibility(8);
        }
        bRE();
        bRF();
        cfq();
        if ((com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) && this.fXb.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.aeA.aXW() || this.aeA.aXX() || this.aeA.aXY()) {
                ao.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bRE() {
        if (this.gWQ != null && this.gWS != null && this.gWs != null) {
            if (this.gWS.getVisibility() == 8 && this.gWs.getVisibility() == 8 && this.ajq.getVisibility() == 8) {
                this.gWQ.setVisibility(0);
            } else {
                this.gWQ.setVisibility(8);
            }
        }
    }

    private void X(final bv bvVar) {
        if (this.gYD != null) {
            if (this.gYB == null || bvVar == null) {
                this.gYD.setVisibility(8);
            } else if (!StringUtils.isNull(bvVar.dUj) && this.gYB.getVisibility() != 0) {
                if (this.hQR != null && this.hQR.cja() && (this.gYD.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYD.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.gYD.setLayoutParams(layoutParams);
                }
                this.gYD.setVisibility(0);
                this.gYD.setImageDrawable(null);
                this.gYD.startLoad(bvVar.dUj, 10, false);
                this.gYD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bvVar.dUk, true)));
                        }
                        TiebaStatic.log(new ap(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.gYD.setVisibility(8);
            }
        }
    }

    public void b(bv bvVar) {
        MetaData aWl;
        if (bvVar != null && this.gYB != null && (aWl = bvVar.aWl()) != null) {
            final ThemeCardInUserData themeCard = aWl.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.gYB.setVisibility(8);
                return;
            }
            this.gYB.setVisibility(0);
            this.gYB.setImageDrawable(null);
            this.gYB.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.gYB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bv bvVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.aib ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bvVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!x.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).kG(i).wE(bvVar.aWp()).wF(String.valueOf(bvVar.getFid())).wG(bvVar.getTid()).hl(this.aib).wH(arrayList.size() > 0 ? arrayList.get(0) : "").hm(true).a(concurrentHashMap).hn(true).r(bvVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig dI = aVar.dI(this.mPageContext.getPageActivity());
            dI.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bvVar.getId();
            historyMessage.threadName = bvVar.getTitle();
            historyMessage.forumName = bvVar.aWp();
            historyMessage.postID = bvVar.aWC();
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

    private void bRF() {
        this.aio.setClickable(true);
        int childCount = this.gWS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gWS.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fXb != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fXa != null) {
            this.fXa.setPageUniqueId(bdUniqueId);
        }
        if (this.gWS != null) {
            this.gWS.setPageUniqueId(bdUniqueId);
        }
    }

    protected void mB(boolean z) {
        if (this.aeA != null) {
            m.Ez(this.aeA.getId());
            m.a(this.mTitle, this.aeA.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.aeq, this.aeA.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            m.a(this.gWs.getGodReplyContent(), this.aeA.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
            r aXw = this.aeA.aXw();
            if (aXw != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bf.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aXw.getCartoonId(), aXw.getChapterId(), 2)));
                return;
            }
            o oVar = this.aeA.dTH;
            if (this.aeA.dTG == 1 && oVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = oVar.dOb;
                long j = oVar.dOc;
                at atVar = new at();
                atVar.pageContext = this.mPageContext;
                atVar.dOr = str;
                atVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, atVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aeA, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aeA.aXs() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean bRw() {
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
    public void rn(int i) {
        this.currentPageType = i;
        if (this.fXb != null) {
            this.fXb.ekb = i;
            this.fXb.setFrom(2);
        }
        if (this.fXa != null) {
            this.fXa.setFrom(3);
        }
    }

    private boolean aq(bv bvVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hRb)) {
            bvVar.de(this.mUrl, this.hRb);
        }
        SpannableStringBuilder y = bvVar.y(false, true);
        if (y == null || StringUtils.isNull(y.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(y));
            this.mTitle.setText(y);
            m.a(this.mTitle, bvVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        return true;
    }

    private void ar(bv bvVar) {
        if (bvVar != null && pM(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.hRb)) {
                bvVar.de(this.mUrl, this.hRb);
            }
            SpannableString aXg = bvVar.aXg();
            if (aXg != null && !as.isEmpty(aXg.toString())) {
                this.aeq.setVisibility(0);
                this.aeq.setOnTouchListener(new com.baidu.tieba.view.i(aXg));
                this.aeq.setText(aXg);
                m.a(this.aeq, bvVar.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
                return;
            }
            this.aeq.setVisibility(8);
            return;
        }
        this.aeq.setVisibility(8);
    }

    private void cfq() {
        if (this.mTitle != null && this.aio != null && this.gWS != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aio.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.aio.setLayoutParams(layoutParams);
            if (this.aio.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gWS.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.gWS.setLayoutParams(layoutParams2);
            }
        }
    }

    public void rp(int i) {
        if (this.aeA != null) {
            if (i == 1) {
                this.fXb.setVisibility(8);
                if (this.fXN != null) {
                    this.fXN.setData(this.aeA);
                    return;
                }
                return;
            }
            this.fXb.setData(this.aeA);
            if (this.fXN != null) {
                this.fXN.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afx = str;
    }

    public int pM(int i) {
        return com.baidu.tieba.a.d.brD().ar(this.afx, i);
    }
}
