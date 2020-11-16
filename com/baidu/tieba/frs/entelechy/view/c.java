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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.data.s;
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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.b<bx> implements com.baidu.tieba.a.e, z {
    protected bx agB;
    private TextView agr;
    private String ahw;
    private final View.OnClickListener ajJ;
    private PlayVoiceBntNew akA;
    protected boolean akn;
    private AppletsCellView alE;
    private RelativeLayout bDi;
    protected View fPU;
    public LinearLayout fXC;
    public ThreadUserInfoLayout gSx;
    protected ThreadCommentAndPraiseInfoLayout gSy;
    protected ThreadSourceShareAndPraiseLayout gTk;
    protected View hYE;
    protected ConstrainImageGroup hYG;
    private View.OnClickListener hYL;
    private final View.OnClickListener hYM;
    private ThreadGodReplyLayout hYg;
    private HeadPendantClickableView hYh;
    private i iUi;
    private String iUs;
    public TbImageView iaq;
    private TbImageView ias;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akn = true;
        this.hYL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI()) {
                    if (c.this.gSy != null) {
                        c.this.gSy.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.cnv() != null) {
                    c.this.cnv().a(view, c.this.agB);
                }
                c.this.ov(view == c.this.hYg);
            }
        };
        this.hYM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bx> cnv = c.this.cnv();
                if (cnv != null) {
                    view.setTag("2");
                    cnv.a(view, c.this.agB);
                }
            }
        };
        this.ajJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cnv() != null) {
                    c.this.cnv().a(view, c.this.agB);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.hYh = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hYh.getHeadView() != null) {
            this.hYh.getHeadView().setIsRound(true);
            this.hYh.getHeadView().setDrawBorder(false);
            this.hYh.getHeadView().setDefaultResource(17170445);
            this.hYh.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hYh.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hYh.setHasPendantStyle();
        if (this.hYh.getPendantView() != null) {
            this.hYh.getPendantView().setIsRound(true);
            this.hYh.getPendantView().setDrawBorder(false);
        }
        this.hYh.setAfterClickListener(this.ajJ);
        this.fPU = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.akA = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.akA.setAfterClickListener(this.hYM);
        this.agr = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.agr.setVisibility(8);
        this.hYE = view.findViewById(R.id.divider_line_above_praise);
        this.hYG = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hYG.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hYG.setChildClickListener(this.hYL);
        f fVar = new f(3);
        fVar.x(1.0d);
        this.hYG.setImageProcessor(fVar);
        this.gSy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gSx = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gSx.setUserAfterClickListener(this.ajJ);
        this.gSx.setFrom(3);
        this.gSy.setOnClickListener(this.hYL);
        this.gSy.setForumAfterClickListener(this.ajJ);
        this.gSy.setReplyTimeVisible(false);
        this.gSy.setShowPraiseNum(true);
        this.gSy.setNeedAddPraiseIcon(true);
        this.gSy.setNeedAddReplyIcon(true);
        this.gSy.setIsBarViewVisible(false);
        this.gSy.setShareVisible(true);
        this.gSy.setShareReportFrom(1);
        this.gSy.setStType("frs_page");
        this.gSy.setFrom(2);
        this.gSy.eVJ = 3;
        this.gTk = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.gTk != null) {
            this.gTk.eWE.setOnClickListener(this.hYL);
            this.gTk.setFrom(2);
            this.gTk.setShareReportFrom(1);
            this.gTk.setSourceFromForPb(3);
            this.gTk.setStType("frs_page");
            this.gTk.setHideBarName(true);
            this.gTk.eWE.setNeedAddReplyIcon(true);
        }
        this.bDi = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.iUi = new i(this.mPageContext, this.bDi);
        this.iUi.setUniqueId(getTag());
        this.hYg = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.hYg.setOnClickListener(this.hYL);
        this.iaq = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.iaq.setPageId(getTag());
        this.ias = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.ias != null) {
            this.ias.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gSy != null) {
                    c.this.gSy.changeSelectStatus();
                }
            }
        });
        this.gSy.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void jt(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ap.getColor(z ? R.color.CAM_X0201 : R.color.transparent));
                }
            }
        });
        this.fXC = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.alE = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.hYG != null) {
            this.hYG.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYG != null) {
            this.hYG.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYG != null) {
            this.hYG.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.fPU, R.color.CAM_X0204);
            this.hYG.onChangeSkinType();
            this.gSy.onChangeSkinType();
            this.gSx.onChangeSkinType();
            if (this.alE != null) {
                this.alE.onChangeSkinType();
            }
            this.iUi.onChangeSkinType();
            if (this.gTk != null && this.gTk.getVisibility() == 0) {
                this.gTk.onChangeSkinType();
            }
            if (this.hYh != null && this.hYh.getHeadView() != null && (this.hYh.getHeadView() instanceof TbImageView)) {
                this.hYh.getHeadView().setPlaceHolder(1);
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
    public void a(final bx bxVar) {
        if (bxVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.agB = bxVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hYL);
        }
        this.hYg.onChangeSkinType();
        if (!cnE() && n.IB(this.agB.getId())) {
            n.a(this.mTitle, this.agB.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.agr, this.agB.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            n.a(this.hYg.getGodReplyContent(), this.agB.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        b(bxVar);
        this.iUi.aA(this.agB);
        aa(bxVar);
        this.gSx.setData(this.agB);
        this.hYg.setFromCDN(this.akn);
        this.hYg.setData(this.agB.bnh());
        this.gSx.setUserAfterClickListener(this.ajJ);
        vD(tH(1));
        if (this.gSx.getHeaderImg() != null) {
            if (this.gSx.getIsSimpleThread()) {
                this.gSx.getHeaderImg().setVisibility(8);
                this.hYh.setVisibility(8);
            } else if (bxVar.blC() == null || bxVar.blC().getPendantData() == null || StringUtils.isNull(bxVar.blC().getPendantData().bjy())) {
                this.hYh.setVisibility(8);
                this.gSx.getHeaderImg().setVisibility(0);
                this.gSx.getHeaderImg().setData(bxVar);
            } else {
                this.gSx.getHeaderImg().setVisibility(4);
                this.hYh.setVisibility(0);
                this.hYh.setData(bxVar);
            }
        }
        at(bxVar);
        au(bxVar);
        this.alE.setData(bxVar.bmr());
        this.alE.setForumId(String.valueOf(bxVar.getFid()));
        AppletsCellView appletsCellView = this.alE;
        AppletsCellView appletsCellView2 = this.alE;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> blP = bxVar.blP();
        if (y.isEmpty(blP)) {
            this.akA.setVisibility(8);
        } else {
            this.akA.bYE();
            this.akA.setVisibility(0);
            VoiceData.VoiceModel voiceModel = blP.get(0);
            this.akA.setVoiceModel(voiceModel);
            this.akA.setTag(voiceModel);
            this.akA.changeSkin();
            if (voiceModel != null) {
                this.akA.DX(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> blL = bxVar.blL();
        if (k.biL().isShowImages() && y.getCount(blL) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < blL.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(blL, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.hYG.setVisibility(0);
                this.hYG.setFromCDN(this.akn);
                this.hYG.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        ab<bx> cnv = c.this.cnv();
                        if (z) {
                            if (cnv != null) {
                                view.setTag("1");
                                cnv.aiO = true;
                                cnv.a(view, c.this.agB);
                            }
                            c.this.ov(false);
                            return;
                        }
                        if (cnv != null) {
                            view.setTag("1");
                            cnv.aiO = false;
                            cnv.a(view, c.this.agB);
                        }
                        c.this.a(view, linkedList, i2, bxVar);
                    }
                });
                this.hYG.setImageMediaList(linkedList);
            } else {
                this.hYG.setVisibility(8);
            }
        } else {
            this.hYG.setVisibility(8);
        }
        cnM();
        cnN();
        cBS();
        if ((com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI()) && this.gSy.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.agB.bnp() || this.agB.bnq() || this.agB.bnr()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cnM() {
        if (this.hYE != null && this.hYG != null && this.hYg != null) {
            if (this.hYG.getVisibility() == 8 && this.hYg.getVisibility() == 8 && this.alE.getVisibility() == 8) {
                this.hYE.setVisibility(0);
            } else {
                this.hYE.setVisibility(8);
            }
        }
    }

    private void aa(final bx bxVar) {
        if (this.ias != null) {
            if (this.iaq == null || bxVar == null) {
                this.ias.setVisibility(8);
            } else if (!StringUtils.isNull(bxVar.eEG) && this.iaq.getVisibility() != 0) {
                if (this.iUi != null && this.iUi.cFH() && (this.ias.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ias.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ias.setLayoutParams(layoutParams);
                }
                this.ias.setVisibility(0);
                this.ias.setImageDrawable(null);
                this.ias.startLoad(bxVar.eEG, 10, false);
                this.ias.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bxVar.eEH, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ias.setVisibility(8);
            }
        }
    }

    public void b(bx bxVar) {
        MetaData blC;
        if (bxVar != null && this.iaq != null && (blC = bxVar.blC()) != null) {
            final ThemeCardInUserData themeCard = blC.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.iaq.setVisibility(8);
                return;
            }
            this.iaq.setVisibility(0);
            this.iaq.setImageDrawable(null);
            this.iaq.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.iaq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bx bxVar) {
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
                imageUrlData.urlType = this.akn ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bxVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!y.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).nL(i).zZ(bxVar.blG()).Aa(String.valueOf(bxVar.getFid())).Ab(bxVar.getTid()).iy(this.akn).Ac(arrayList.size() > 0 ? arrayList.get(0) : "").iz(true).a(concurrentHashMap).iA(true).s(bxVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
            dU.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bxVar.getId();
            historyMessage.threadName = bxVar.getTitle();
            historyMessage.forumName = bxVar.blG();
            historyMessage.postID = bxVar.blT();
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

    private void cnN() {
        this.akA.setClickable(true);
        int childCount = this.hYG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hYG.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSy != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gSx != null) {
            this.gSx.setPageUniqueId(bdUniqueId);
        }
        if (this.hYG != null) {
            this.hYG.setPageUniqueId(bdUniqueId);
        }
    }

    protected void ov(boolean z) {
        if (this.agB != null) {
            n.IA(this.agB.getId());
            n.a(this.mTitle, this.agB.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.agr, this.agB.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            n.a(this.hYg.getGodReplyContent(), this.agB.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
            s bmP = this.agB.bmP();
            if (bmP != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bh.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bmP.getCartoonId(), bmP.getChapterId(), 2)));
                return;
            }
            p pVar = this.agB.eEe;
            if (this.agB.eEd == 1 && pVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = pVar.eyj;
                long j = pVar.eyk;
                av avVar = new av();
                avVar.pageContext = this.mPageContext;
                avVar.eyK = str;
                avVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, avVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.agB, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.agB.bmL() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean cnE() {
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
    public void vB(int i) {
        this.currentPageType = i;
        if (this.gSy != null) {
            this.gSy.eVJ = i;
            this.gSy.setFrom(2);
        }
        if (this.gSx != null) {
            this.gSx.setFrom(3);
        }
    }

    private boolean at(bx bxVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.iUs)) {
            bxVar.dE(this.mUrl, this.iUs);
        }
        SpannableStringBuilder B = bxVar.B(false, true);
        if (B == null || StringUtils.isNull(B.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            n.a(this.mTitle, bxVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        return true;
    }

    private void au(bx bxVar) {
        if (bxVar != null && tH(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.iUs)) {
                bxVar.dE(this.mUrl, this.iUs);
            }
            SpannableString bmz = bxVar.bmz();
            if (bmz != null && !au.isEmpty(bmz.toString())) {
                this.agr.setVisibility(0);
                this.agr.setOnTouchListener(new com.baidu.tieba.view.i(bmz));
                this.agr.setText(bmz);
                n.a(this.agr, bxVar.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
                return;
            }
            this.agr.setVisibility(8);
            return;
        }
        this.agr.setVisibility(8);
    }

    private void cBS() {
        if (this.mTitle != null && this.akA != null && this.hYG != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akA.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.akA.setLayoutParams(layoutParams);
            if (this.akA.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hYG.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.hYG.setLayoutParams(layoutParams2);
            }
        }
    }

    public void vD(int i) {
        if (this.agB != null) {
            if (i == 1) {
                this.gSy.setVisibility(8);
                if (this.gTk != null) {
                    this.gTk.setData(this.agB);
                    return;
                }
                return;
            }
            this.gSy.setData(this.agB);
            if (this.gTk != null) {
                this.gTk.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahw = str;
    }

    public int tH(int i) {
        return com.baidu.tieba.a.d.bIl().aw(this.ahw, i);
    }
}
