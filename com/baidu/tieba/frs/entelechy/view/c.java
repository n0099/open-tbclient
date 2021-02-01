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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
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
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.b<cb> implements e, z {
    private TextView agY;
    protected cb ahi;
    private String aif;
    protected boolean akO;
    private final View.OnClickListener aki;
    private PlayVoiceBntNew alb;
    private AppletsCellView amh;
    private RelativeLayout bMd;
    protected View gft;
    public LinearLayout gnT;
    protected ThreadSourceShareAndPraiseLayout hnS;
    public ThreadUserInfoLayout hnf;
    protected ThreadCommentAndPraiseInfoLayout hng;
    protected View iwV;
    protected ConstrainImageGroup iwX;
    private ThreadGodReplyLayout iwx;
    private HeadPendantClickableView iwy;
    private View.OnClickListener ixc;
    private final View.OnClickListener ixd;
    public TbImageView iyM;
    private TbImageView iyO;
    private i jsF;
    private String jsP;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akO = true;
        this.ixc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.cBr().cBl() || com.baidu.tieba.frs.a.cBk().cBl()) {
                    if (c.this.hng != null) {
                        c.this.hng.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.crV() != null) {
                    c.this.crV().a(view, c.this.ahi);
                }
                c.this.pv(view == c.this.iwx);
            }
        };
        this.ixd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<cb> crV = c.this.crV();
                if (crV != null) {
                    view.setTag("2");
                    crV.a(view, c.this.ahi);
                }
            }
        };
        this.aki = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.crV() != null) {
                    c.this.crV().a(view, c.this.ahi);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.iwy = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.iwy.getHeadView() != null) {
            this.iwy.getHeadView().setIsRound(true);
            this.iwy.getHeadView().setDrawBorder(false);
            this.iwy.getHeadView().setDefaultResource(17170445);
            this.iwy.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.iwy.setHasPendantStyle();
        if (this.iwy.getPendantView() != null) {
            this.iwy.getPendantView().setIsRound(true);
            this.iwy.getPendantView().setDrawBorder(false);
        }
        this.iwy.setAfterClickListener(this.aki);
        this.gft = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.alb = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.alb.setAfterClickListener(this.ixd);
        this.agY = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.agY.setVisibility(8);
        this.iwV = view.findViewById(R.id.divider_line_above_praise);
        this.iwX = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.iwX.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iwX.setChildClickListener(this.ixc);
        f fVar = new f(3);
        fVar.r(1.0d);
        this.iwX.setImageProcessor(fVar);
        this.hng = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hnf = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hnf.setUserAfterClickListener(this.aki);
        this.hnf.setFrom(3);
        this.hng.setOnClickListener(this.ixc);
        this.hng.setForumAfterClickListener(this.aki);
        this.hng.setReplyTimeVisible(false);
        this.hng.setShowPraiseNum(true);
        this.hng.setNeedAddPraiseIcon(true);
        this.hng.setNeedAddReplyIcon(true);
        this.hng.setIsBarViewVisible(false);
        this.hng.setShareVisible(true);
        this.hng.setShareReportFrom(1);
        this.hng.setStType("frs_page");
        this.hng.setFrom(2);
        this.hng.fkw = 3;
        this.hnS = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.hnS != null) {
            this.hnS.fls.setOnClickListener(this.ixc);
            this.hnS.setFrom(2);
            this.hnS.setShareReportFrom(1);
            this.hnS.setSourceFromForPb(3);
            this.hnS.setStType("frs_page");
            this.hnS.setHideBarName(true);
            this.hnS.fls.setNeedAddReplyIcon(true);
        }
        this.bMd = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.jsF = new i(this.mPageContext, this.bMd);
        this.jsF.setUniqueId(getTag());
        this.iwx = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.iwx.setOnClickListener(this.ixc);
        this.iyM = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.iyM.setPageId(getTag());
        this.iyO = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.iyO != null) {
            this.iyO.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.hng != null) {
                    c.this.hng.changeSelectStatus();
                }
            }
        });
        this.hng.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void ke(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ap.getColor(z ? R.color.CAM_X0201 : R.color.transparent));
                }
            }
        });
        this.gnT = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.amh = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.iwX != null) {
            this.iwX.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iwX != null) {
            this.iwX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iwX != null) {
            this.iwX.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.gft, R.color.CAM_X0204);
            this.iwX.onChangeSkinType();
            this.hng.onChangeSkinType();
            this.hnf.onChangeSkinType();
            if (this.amh != null) {
                this.amh.onChangeSkinType();
            }
            this.jsF.onChangeSkinType();
            if (this.hnS != null && this.hnS.getVisibility() == 0) {
                this.hnS.onChangeSkinType();
            }
            if (this.iwy != null && this.iwy.getHeadView() != null && (this.iwy.getHeadView() instanceof TbImageView)) {
                this.iwy.getHeadView().setPlaceHolder(1);
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
    public void a(final cb cbVar) {
        if (cbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahi = cbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ixc);
        }
        this.iwx.onChangeSkinType();
        if (!cse() && m.IN(this.ahi.getId())) {
            m.a(this.mTitle, this.ahi.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.agY, this.ahi.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            m.a(this.iwx.getGodReplyContent(), this.ahi.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        b(cbVar);
        this.jsF.aB(this.ahi);
        ab(cbVar);
        this.hnf.setData(this.ahi);
        this.iwx.setFromCDN(this.akO);
        this.iwx.setData(this.ahi.bpv());
        this.hnf.setUserAfterClickListener(this.aki);
        uZ(sW(1));
        if (this.hnf.getHeaderImg() != null) {
            if (this.hnf.getIsSimpleThread()) {
                this.hnf.getHeaderImg().setVisibility(8);
                this.iwy.setVisibility(8);
            } else if (cbVar.bnQ() == null || cbVar.bnQ().getPendantData() == null || StringUtils.isNull(cbVar.bnQ().getPendantData().getImgUrl())) {
                this.iwy.setVisibility(8);
                this.hnf.getHeaderImg().setVisibility(0);
                this.hnf.getHeaderImg().setData(cbVar);
            } else {
                this.hnf.getHeaderImg().setVisibility(4);
                this.iwy.setVisibility(0);
                this.iwy.setData(cbVar);
            }
        }
        au(cbVar);
        av(cbVar);
        this.amh.setData(cbVar.boE());
        this.amh.setForumId(String.valueOf(cbVar.getFid()));
        AppletsCellView appletsCellView = this.amh;
        AppletsCellView appletsCellView2 = this.amh;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> bod = cbVar.bod();
        if (y.isEmpty(bod)) {
            this.alb.setVisibility(8);
        } else {
            this.alb.ccu();
            this.alb.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bod.get(0);
            this.alb.setVoiceModel(voiceModel);
            this.alb.setTag(voiceModel);
            this.alb.buo();
            if (voiceModel != null) {
                this.alb.Dp(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        if (k.bkT().isShowImages() && y.getCount(bnZ) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bnZ.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bnZ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.iwX.setVisibility(0);
                this.iwX.setFromCDN(this.akO);
                this.iwX.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        ab<cb> crV = c.this.crV();
                        if (z) {
                            if (crV != null) {
                                view.setTag("1");
                                crV.ajn = true;
                                crV.a(view, c.this.ahi);
                            }
                            c.this.pv(false);
                            return;
                        }
                        if (crV != null) {
                            view.setTag("1");
                            crV.ajn = false;
                            crV.a(view, c.this.ahi);
                        }
                        c.this.a(view, linkedList, i2, cbVar);
                    }
                });
                this.iwX.setImageMediaList(linkedList);
            } else {
                this.iwX.setVisibility(8);
            }
        } else {
            this.iwX.setVisibility(8);
        }
        csm();
        csn();
        cGH();
        if ((com.baidu.tieba.frs.b.cBr().cBl() || com.baidu.tieba.frs.a.cBk().cBl()) && this.hng.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.ahi.bpD() || this.ahi.bpE() || this.ahi.bpF()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void csm() {
        if (this.iwV != null && this.iwX != null && this.iwx != null) {
            if (this.iwX.getVisibility() == 8 && this.iwx.getVisibility() == 8 && this.amh.getVisibility() == 8) {
                this.iwV.setVisibility(0);
            } else {
                this.iwV.setVisibility(8);
            }
        }
    }

    private void ab(final cb cbVar) {
        if (this.iyO != null) {
            if (this.iyM == null || cbVar == null) {
                this.iyO.setVisibility(8);
            } else if (!StringUtils.isNull(cbVar.eTd) && this.iyM.getVisibility() != 0) {
                if (this.jsF != null && this.jsF.cLv() && (this.iyO.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iyO.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.iyO.setLayoutParams(layoutParams);
                }
                this.iyO.setVisibility(0);
                this.iyO.setImageDrawable(null);
                this.iyO.startLoad(cbVar.eTd, 10, false);
                this.iyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", cbVar.eTe, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.iyO.setVisibility(8);
            }
        }
    }

    public void b(cb cbVar) {
        MetaData bnQ;
        if (cbVar != null && this.iyM != null && (bnQ = cbVar.bnQ()) != null) {
            final ThemeCardInUserData themeCard = bnQ.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.iyM.setVisibility(8);
                return;
            }
            this.iyM.setVisibility(0);
            this.iyM.setImageDrawable(null);
            this.iyM.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.iyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, cb cbVar) {
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
                imageUrlData.urlType = this.akO ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(cbVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!y.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).mQ(i).zJ(cbVar.bnU()).zK(String.valueOf(cbVar.getFid())).zL(cbVar.getTid()).jg(this.akO).zM(arrayList.size() > 0 ? arrayList.get(0) : "").jh(true).d(concurrentHashMap).ji(true).s(cbVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig eP = aVar.eP(this.mPageContext.getPageActivity());
            eP.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eP));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = cbVar.getId();
            historyMessage.threadName = cbVar.getTitle();
            historyMessage.forumName = cbVar.bnU();
            historyMessage.postID = cbVar.bog();
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

    private void csn() {
        this.alb.setClickable(true);
        int childCount = this.iwX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iwX.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hng != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hnf != null) {
            this.hnf.setPageUniqueId(bdUniqueId);
        }
        if (this.iwX != null) {
            this.iwX.setPageUniqueId(bdUniqueId);
        }
    }

    protected void pv(boolean z) {
        if (this.ahi != null) {
            m.IM(this.ahi.getId());
            m.a(this.mTitle, this.ahi.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.agY, this.ahi.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            m.a(this.iwx.getGodReplyContent(), this.ahi.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
            t bpc = this.ahi.bpc();
            if (bpc != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bh.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bpc.getCartoonId(), bpc.getChapterId(), 2)));
                return;
            }
            q qVar = this.ahi.eSB;
            if (this.ahi.eSA == 1 && qVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = qVar.eMA;
                long j = qVar.eMB;
                ay ayVar = new ay();
                ayVar.pageContext = this.mPageContext;
                ayVar.eNa = str;
                ayVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, ayVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ahi, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.ahi.boY() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean cse() {
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
    public void uX(int i) {
        this.currentPageType = i;
        if (this.hng != null) {
            this.hng.fkw = i;
            this.hng.setFrom(2);
        }
        if (this.hnf != null) {
            this.hnf.setFrom(3);
        }
    }

    private boolean au(cb cbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.jsP)) {
            cbVar.dD(this.mUrl, this.jsP);
        }
        SpannableStringBuilder A = cbVar.A(false, true);
        if (A == null || StringUtils.isNull(A.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(A));
            this.mTitle.setText(A);
            m.a(this.mTitle, cbVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        return true;
    }

    private void av(cb cbVar) {
        if (cbVar != null && sW(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.jsP)) {
                cbVar.dD(this.mUrl, this.jsP);
            }
            SpannableString boM = cbVar.boM();
            if (boM != null && !au.isEmpty(boM.toString())) {
                this.agY.setVisibility(0);
                this.agY.setOnTouchListener(new com.baidu.tieba.view.i(boM));
                this.agY.setText(boM);
                m.a(this.agY, cbVar.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
                return;
            }
            this.agY.setVisibility(8);
            return;
        }
        this.agY.setVisibility(8);
    }

    private void cGH() {
        if (this.mTitle != null && this.alb != null && this.iwX != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alb.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.alb.setLayoutParams(layoutParams);
            if (this.alb.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iwX.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.iwX.setLayoutParams(layoutParams2);
            }
        }
    }

    public void uZ(int i) {
        if (this.ahi != null) {
            if (i == 1) {
                this.hng.setVisibility(8);
                if (this.hnS != null) {
                    this.hnS.setData(this.ahi);
                    return;
                }
                return;
            }
            this.hng.setData(this.ahi);
            if (this.hnS != null) {
                this.hnS.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public int sW(int i) {
        return com.baidu.tieba.a.d.bKP().aB(this.aif, i);
    }
}
