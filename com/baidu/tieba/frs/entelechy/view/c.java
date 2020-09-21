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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, y {
    private TextView afT;
    protected bw agf;
    private String ahc;
    protected boolean ajR;
    private final View.OnClickListener ajn;
    private PlayVoiceBntNew akd;
    private AppletsCellView alg;
    private RelativeLayout bsG;
    protected View fpN;
    public LinearLayout fxB;
    protected ThreadSourceShareAndPraiseLayout gmX;
    public ThreadUserInfoLayout gmk;
    protected ThreadCommentAndPraiseInfoLayout gml;
    protected View hqQ;
    protected ConstrainImageGroup hqS;
    private View.OnClickListener hqX;
    private final View.OnClickListener hqY;
    private ThreadGodReplyLayout hqs;
    private HeadPendantClickableView hqt;
    public TbImageView hsB;
    private TbImageView hsD;
    private i imj;
    private String imt;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajR = true;
        this.hqX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) {
                    if (c.this.gml != null) {
                        c.this.gml.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.ceP() != null) {
                    c.this.ceP().a(view, c.this.agf);
                }
                c.this.nm(view == c.this.hqs);
            }
        };
        this.hqY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<bw> ceP = c.this.ceP();
                if (ceP != null) {
                    view.setTag("2");
                    ceP.a(view, c.this.agf);
                }
            }
        };
        this.ajn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ceP() != null) {
                    c.this.ceP().a(view, c.this.agf);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.hqt = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hqt.getHeadView() != null) {
            this.hqt.getHeadView().setIsRound(true);
            this.hqt.getHeadView().setDrawBorder(false);
            this.hqt.getHeadView().setDefaultResource(17170445);
            this.hqt.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hqt.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hqt.setHasPendantStyle();
        if (this.hqt.getPendantView() != null) {
            this.hqt.getPendantView().setIsRound(true);
            this.hqt.getPendantView().setDrawBorder(false);
        }
        this.hqt.setAfterClickListener(this.ajn);
        this.fpN = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.akd = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.akd.setAfterClickListener(this.hqY);
        this.afT = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.afT.setVisibility(8);
        this.hqQ = view.findViewById(R.id.divider_line_above_praise);
        this.hqS = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hqS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hqS.setChildClickListener(this.hqX);
        f fVar = new f(3);
        fVar.u(1.0d);
        this.hqS.setImageProcessor(fVar);
        this.gml = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gmk = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gmk.setUserAfterClickListener(this.ajn);
        this.gmk.setFrom(3);
        this.gml.setOnClickListener(this.hqX);
        this.gml.setForumAfterClickListener(this.ajn);
        this.gml.setReplyTimeVisible(false);
        this.gml.setShowPraiseNum(true);
        this.gml.setNeedAddPraiseIcon(true);
        this.gml.setNeedAddReplyIcon(true);
        this.gml.setIsBarViewVisible(false);
        this.gml.setShareVisible(true);
        this.gml.setShareReportFrom(1);
        this.gml.setStType("frs_page");
        this.gml.setFrom(2);
        this.gml.ewe = 3;
        this.gmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.gmX != null) {
            this.gmX.exc.setOnClickListener(this.hqX);
            this.gmX.setFrom(2);
            this.gmX.setShareReportFrom(1);
            this.gmX.setSourceFromForPb(3);
            this.gmX.setStType("frs_page");
            this.gmX.setHideBarName(true);
            this.gmX.exc.setNeedAddReplyIcon(true);
        }
        this.bsG = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.imj = new i(this.mPageContext, this.bsG);
        this.imj.setUniqueId(getTag());
        this.hqs = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.hqs.setOnClickListener(this.hqX);
        this.hsB = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.hsB.setPageId(getTag());
        this.hsD = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.hsD != null) {
            this.hsD.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gml != null) {
                    c.this.gml.changeSelectStatus();
                }
            }
        });
        this.gml.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void iy(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ap.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.fxB = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.alg = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.hqS != null) {
            this.hqS.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hqS != null) {
            this.hqS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hqS != null) {
            this.hqS.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.fpN, R.color.cp_bg_line_c);
            this.hqS.onChangeSkinType();
            this.gml.onChangeSkinType();
            this.gmk.onChangeSkinType();
            if (this.alg != null) {
                this.alg.onChangeSkinType();
            }
            this.imj.onChangeSkinType();
            if (this.gmX != null && this.gmX.getVisibility() == 0) {
                this.gmX.onChangeSkinType();
            }
            if (this.hqt != null && this.hqt.getHeadView() != null && (this.hqt.getHeadView() instanceof TbImageView)) {
                this.hqt.getHeadView().setPlaceHolder(1);
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
    public void a(final bw bwVar) {
        if (bwVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.agf = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hqX);
        }
        this.hqs.onChangeSkinType();
        if (!ceY() && m.Hx(this.agf.getId())) {
            m.a(this.mTitle, this.agf.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.afT, this.agf.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            m.a(this.hqs.getGodReplyContent(), this.agf.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        b(bwVar);
        this.imj.ay(this.agf);
        Y(bwVar);
        this.gmk.setData(this.agf);
        this.hqs.setFromCDN(this.ajR);
        this.hqs.setData(this.agf.bhb());
        this.gmk.setUserAfterClickListener(this.ajn);
        tU(sq(1));
        if (this.gmk.getHeaderImg() != null) {
            if (this.gmk.getIsSimpleThread()) {
                this.gmk.getHeaderImg().setVisibility(8);
                this.hqt.setVisibility(8);
            } else if (bwVar.bfy() == null || bwVar.bfy().getPendantData() == null || StringUtils.isNull(bwVar.bfy().getPendantData().bdu())) {
                this.hqt.setVisibility(8);
                this.gmk.getHeaderImg().setVisibility(0);
                this.gmk.getHeaderImg().setData(bwVar);
            } else {
                this.gmk.getHeaderImg().setVisibility(4);
                this.hqt.setVisibility(0);
                this.hqt.setData(bwVar);
            }
        }
        ar(bwVar);
        as(bwVar);
        this.alg.setData(bwVar.bgn());
        this.alg.setForumId(String.valueOf(bwVar.getFid()));
        AppletsCellView appletsCellView = this.alg;
        AppletsCellView appletsCellView2 = this.alg;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> bfL = bwVar.bfL();
        if (com.baidu.tbadk.core.util.y.isEmpty(bfL)) {
            this.akd.setVisibility(8);
        } else {
            this.akd.bQr();
            this.akd.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bfL.get(0);
            this.akd.setVoiceModel(voiceModel);
            this.akd.setTag(voiceModel);
            this.akd.changeSkin();
            if (voiceModel != null) {
                this.akd.Cn(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> bfH = bwVar.bfH();
        if (k.bcG().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bfH) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bfH.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bfH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                this.hqS.setVisibility(0);
                this.hqS.setFromCDN(this.ajR);
                this.hqS.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        aa<bw> ceP = c.this.ceP();
                        if (z) {
                            if (ceP != null) {
                                view.setTag("1");
                                ceP.aiq = true;
                                ceP.a(view, c.this.agf);
                            }
                            c.this.nm(false);
                            return;
                        }
                        if (ceP != null) {
                            view.setTag("1");
                            ceP.aiq = false;
                            ceP.a(view, c.this.agf);
                        }
                        c.this.a(view, linkedList, i2, bwVar);
                    }
                });
                this.hqS.setImageMediaList(linkedList);
            } else {
                this.hqS.setVisibility(8);
            }
        } else {
            this.hqS.setVisibility(8);
        }
        cfg();
        cfh();
        ctj();
        if ((com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) && this.gml.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.agf.bhj() || this.agf.bhk() || this.agf.bhl()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cfg() {
        if (this.hqQ != null && this.hqS != null && this.hqs != null) {
            if (this.hqS.getVisibility() == 8 && this.hqs.getVisibility() == 8 && this.alg.getVisibility() == 8) {
                this.hqQ.setVisibility(0);
            } else {
                this.hqQ.setVisibility(8);
            }
        }
    }

    private void Y(final bw bwVar) {
        if (this.hsD != null) {
            if (this.hsB == null || bwVar == null) {
                this.hsD.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.efT) && this.hsB.getVisibility() != 0) {
                if (this.imj != null && this.imj.cwX() && (this.hsD.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsD.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hsD.setLayoutParams(layoutParams);
                }
                this.hsD.setVisibility(0);
                this.hsD.setImageDrawable(null);
                this.hsD.startLoad(bwVar.efT, 10, false);
                this.hsD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bwVar.efU, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hsD.setVisibility(8);
            }
        }
    }

    public void b(bw bwVar) {
        MetaData bfy;
        if (bwVar != null && this.hsB != null && (bfy = bwVar.bfy()) != null) {
            final ThemeCardInUserData themeCard = bfy.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hsB.setVisibility(8);
                return;
            }
            this.hsB.setVisibility(0);
            this.hsB.setImageDrawable(null);
            this.hsB.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hsB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
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
                imageUrlData.urlType = this.ajR ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).mX(i).zl(bwVar.bfC()).zm(String.valueOf(bwVar.getFid())).zn(bwVar.getTid()).hF(this.ajR).zo(arrayList.size() > 0 ? arrayList.get(0) : "").hG(true).a(concurrentHashMap).hH(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig dO = aVar.dO(this.mPageContext.getPageActivity());
            dO.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bwVar.getId();
            historyMessage.threadName = bwVar.getTitle();
            historyMessage.forumName = bwVar.bfC();
            historyMessage.postID = bwVar.bfP();
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

    private void cfh() {
        this.akd.setClickable(true);
        int childCount = this.hqS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hqS.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gml != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gmk != null) {
            this.gmk.setPageUniqueId(bdUniqueId);
        }
        if (this.hqS != null) {
            this.hqS.setPageUniqueId(bdUniqueId);
        }
    }

    protected void nm(boolean z) {
        if (this.agf != null) {
            m.Hw(this.agf.getId());
            m.a(this.mTitle, this.agf.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.afT, this.agf.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            m.a(this.hqs.getGodReplyContent(), this.agf.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
            r bgJ = this.agf.bgJ();
            if (bgJ != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bg.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bgJ.getCartoonId(), bgJ.getChapterId(), 2)));
                return;
            }
            o oVar = this.agf.efr;
            if (this.agf.efq == 1 && oVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = oVar.dZy;
                long j = oVar.dZz;
                au auVar = new au();
                auVar.pageContext = this.mPageContext;
                auVar.dZY = str;
                auVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.agf, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.agf.bgF() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ceY() {
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
    public void tS(int i) {
        this.currentPageType = i;
        if (this.gml != null) {
            this.gml.ewe = i;
            this.gml.setFrom(2);
        }
        if (this.gmk != null) {
            this.gmk.setFrom(3);
        }
    }

    private boolean ar(bw bwVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.imt)) {
            bwVar.du(this.mUrl, this.imt);
        }
        SpannableStringBuilder B = bwVar.B(false, true);
        if (B == null || StringUtils.isNull(B.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            m.a(this.mTitle, bwVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        return true;
    }

    private void as(bw bwVar) {
        if (bwVar != null && sq(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.imt)) {
                bwVar.du(this.mUrl, this.imt);
            }
            SpannableString bgt = bwVar.bgt();
            if (bgt != null && !at.isEmpty(bgt.toString())) {
                this.afT.setVisibility(0);
                this.afT.setOnTouchListener(new com.baidu.tieba.view.i(bgt));
                this.afT.setText(bgt);
                m.a(this.afT, bwVar.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
                return;
            }
            this.afT.setVisibility(8);
            return;
        }
        this.afT.setVisibility(8);
    }

    private void ctj() {
        if (this.mTitle != null && this.akd != null && this.hqS != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akd.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.akd.setLayoutParams(layoutParams);
            if (this.akd.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hqS.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.hqS.setLayoutParams(layoutParams2);
            }
        }
    }

    public void tU(int i) {
        if (this.agf != null) {
            if (i == 1) {
                this.gml.setVisibility(8);
                if (this.gmX != null) {
                    this.gmX.setData(this.agf);
                    return;
                }
                return;
            }
            this.gml.setData(this.agf);
            if (this.gmX != null) {
                this.gmX.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }

    public int sq(int i) {
        return com.baidu.tieba.a.d.bBN().au(this.ahc, i);
    }
}
