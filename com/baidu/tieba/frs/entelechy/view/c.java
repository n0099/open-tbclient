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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<by> implements com.baidu.tieba.a.e, z {
    protected by ahA;
    private TextView ahp;
    private String aiw;
    private final View.OnClickListener akI;
    private PlayVoiceBntNew alB;
    protected boolean alo;
    private AppletsCellView amE;
    private RelativeLayout bIq;
    protected View fYd;
    public LinearLayout gfN;
    public ThreadUserInfoLayout hbK;
    protected ThreadCommentAndPraiseInfoLayout hbL;
    protected ThreadSourceShareAndPraiseLayout hcx;
    protected View ijB;
    protected ConstrainImageGroup ijD;
    private View.OnClickListener ijI;
    private final View.OnClickListener ijJ;
    private ThreadGodReplyLayout ijd;
    private HeadPendantClickableView ije;
    public TbImageView ilm;
    private TbImageView ilo;
    private i jfe;
    private String jfo;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.alo = true;
        this.ijI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.cBd().cAX() || com.baidu.tieba.frs.a.cAW().cAX()) {
                    if (c.this.hbL != null) {
                        c.this.hbL.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.crI() != null) {
                    c.this.crI().a(view, c.this.ahA);
                }
                c.this.oR(view == c.this.ijd);
            }
        };
        this.ijJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<by> crI = c.this.crI();
                if (crI != null) {
                    view.setTag("2");
                    crI.a(view, c.this.ahA);
                }
            }
        };
        this.akI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.crI() != null) {
                    c.this.crI().a(view, c.this.ahA);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.ije = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.ije.getHeadView() != null) {
            this.ije.getHeadView().setIsRound(true);
            this.ije.getHeadView().setDrawBorder(false);
            this.ije.getHeadView().setDefaultResource(17170445);
            this.ije.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ije.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.ije.setHasPendantStyle();
        if (this.ije.getPendantView() != null) {
            this.ije.getPendantView().setIsRound(true);
            this.ije.getPendantView().setDrawBorder(false);
        }
        this.ije.setAfterClickListener(this.akI);
        this.fYd = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.alB = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.alB.setAfterClickListener(this.ijJ);
        this.ahp = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.ahp.setVisibility(8);
        this.ijB = view.findViewById(R.id.divider_line_above_praise);
        this.ijD = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.ijD.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.ijD.setChildClickListener(this.ijI);
        f fVar = new f(3);
        fVar.x(1.0d);
        this.ijD.setImageProcessor(fVar);
        this.hbL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hbK = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hbK.setUserAfterClickListener(this.akI);
        this.hbK.setFrom(3);
        this.hbL.setOnClickListener(this.ijI);
        this.hbL.setForumAfterClickListener(this.akI);
        this.hbL.setReplyTimeVisible(false);
        this.hbL.setShowPraiseNum(true);
        this.hbL.setNeedAddPraiseIcon(true);
        this.hbL.setNeedAddReplyIcon(true);
        this.hbL.setIsBarViewVisible(false);
        this.hbL.setShareVisible(true);
        this.hbL.setShareReportFrom(1);
        this.hbL.setStType("frs_page");
        this.hbL.setFrom(2);
        this.hbL.fdg = 3;
        this.hcx = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.hcx != null) {
            this.hcx.feb.setOnClickListener(this.ijI);
            this.hcx.setFrom(2);
            this.hcx.setShareReportFrom(1);
            this.hcx.setSourceFromForPb(3);
            this.hcx.setStType("frs_page");
            this.hcx.setHideBarName(true);
            this.hcx.feb.setNeedAddReplyIcon(true);
        }
        this.bIq = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.jfe = new i(this.mPageContext, this.bIq);
        this.jfe.setUniqueId(getTag());
        this.ijd = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.ijd.setOnClickListener(this.ijI);
        this.ilm = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.ilm.setPageId(getTag());
        this.ilo = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.ilo != null) {
            this.ilo.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.hbL != null) {
                    c.this.hbL.changeSelectStatus();
                }
            }
        });
        this.hbL.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void jJ(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ap.getColor(z ? R.color.CAM_X0201 : R.color.transparent));
                }
            }
        });
        this.gfN = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.amE = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.ijD != null) {
            this.ijD.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ijD != null) {
            this.ijD.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ijD != null) {
            this.ijD.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.fYd, R.color.CAM_X0204);
            this.ijD.onChangeSkinType();
            this.hbL.onChangeSkinType();
            this.hbK.onChangeSkinType();
            if (this.amE != null) {
                this.amE.onChangeSkinType();
            }
            this.jfe.onChangeSkinType();
            if (this.hcx != null && this.hcx.getVisibility() == 0) {
                this.hcx.onChangeSkinType();
            }
            if (this.ije != null && this.ije.getHeadView() != null && (this.ije.getHeadView() instanceof TbImageView)) {
                this.ije.getHeadView().setPlaceHolder(1);
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
    public void a(final by byVar) {
        if (byVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahA = byVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ijI);
        }
        this.ijd.onChangeSkinType();
        if (!crR() && n.Jr(this.ahA.getId())) {
            n.a(this.mTitle, this.ahA.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.ahp, this.ahA.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            n.a(this.ijd.getGodReplyContent(), this.ahA.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        b(byVar);
        this.jfe.aA(this.ahA);
        aa(byVar);
        this.hbK.setData(this.ahA);
        this.ijd.setFromCDN(this.alo);
        this.ijd.setData(this.ahA.bqu());
        this.hbK.setUserAfterClickListener(this.akI);
        wk(ul(1));
        if (this.hbK.getHeaderImg() != null) {
            if (this.hbK.getIsSimpleThread()) {
                this.hbK.getHeaderImg().setVisibility(8);
                this.ije.setVisibility(8);
            } else if (byVar.boP() == null || byVar.boP().getPendantData() == null || StringUtils.isNull(byVar.boP().getPendantData().bmL())) {
                this.ije.setVisibility(8);
                this.hbK.getHeaderImg().setVisibility(0);
                this.hbK.getHeaderImg().setData(byVar);
            } else {
                this.hbK.getHeaderImg().setVisibility(4);
                this.ije.setVisibility(0);
                this.ije.setData(byVar);
            }
        }
        at(byVar);
        au(byVar);
        this.amE.setData(byVar.bpE());
        this.amE.setForumId(String.valueOf(byVar.getFid()));
        AppletsCellView appletsCellView = this.amE;
        AppletsCellView appletsCellView2 = this.amE;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> bpc = byVar.bpc();
        if (y.isEmpty(bpc)) {
            this.alB.setVisibility(8);
        } else {
            this.alB.ccz();
            this.alB.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bpc.get(0);
            this.alB.setVoiceModel(voiceModel);
            this.alB.setTag(voiceModel);
            this.alB.bvs();
            if (voiceModel != null) {
                this.alB.EM(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> boY = byVar.boY();
        if (k.blV().isShowImages() && y.getCount(boY) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < boY.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(boY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.ijD.setVisibility(0);
                this.ijD.setFromCDN(this.alo);
                this.ijD.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        ab<by> crI = c.this.crI();
                        if (z) {
                            if (crI != null) {
                                view.setTag("1");
                                crI.ajN = true;
                                crI.a(view, c.this.ahA);
                            }
                            c.this.oR(false);
                            return;
                        }
                        if (crI != null) {
                            view.setTag("1");
                            crI.ajN = false;
                            crI.a(view, c.this.ahA);
                        }
                        c.this.a(view, linkedList, i2, byVar);
                    }
                });
                this.ijD.setImageMediaList(linkedList);
            } else {
                this.ijD.setVisibility(8);
            }
        } else {
            this.ijD.setVisibility(8);
        }
        crZ();
        csa();
        cGl();
        if ((com.baidu.tieba.frs.b.cBd().cAX() || com.baidu.tieba.frs.a.cAW().cAX()) && this.hbL.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.ahA.bqC() || this.ahA.bqD() || this.ahA.bqE()) {
                ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void crZ() {
        if (this.ijB != null && this.ijD != null && this.ijd != null) {
            if (this.ijD.getVisibility() == 8 && this.ijd.getVisibility() == 8 && this.amE.getVisibility() == 8) {
                this.ijB.setVisibility(0);
            } else {
                this.ijB.setVisibility(8);
            }
        }
    }

    private void aa(final by byVar) {
        if (this.ilo != null) {
            if (this.ilm == null || byVar == null) {
                this.ilo.setVisibility(8);
            } else if (!StringUtils.isNull(byVar.eLI) && this.ilm.getVisibility() != 0) {
                if (this.jfe != null && this.jfe.cKW() && (this.ilo.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilo.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ilo.setLayoutParams(layoutParams);
                }
                this.ilo.setVisibility(0);
                this.ilo.setImageDrawable(null);
                this.ilo.startLoad(byVar.eLI, 10, false);
                this.ilo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", byVar.eLJ, true)));
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ilo.setVisibility(8);
            }
        }
    }

    public void b(by byVar) {
        MetaData boP;
        if (byVar != null && this.ilm != null && (boP = byVar.boP()) != null) {
            final ThemeCardInUserData themeCard = boP.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ilm.setVisibility(8);
                return;
            }
            this.ilm.setVisibility(0);
            this.ilm.setImageDrawable(null);
            this.ilm.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ilm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, by byVar) {
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
                imageUrlData.urlType = this.alo ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(byVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!y.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).oj(i).AG(byVar.boT()).AH(String.valueOf(byVar.getFid())).AI(byVar.getTid()).iN(this.alo).AJ(arrayList.size() > 0 ? arrayList.get(0) : "").iO(true).a(concurrentHashMap).iP(true).s(byVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig ez = aVar.ez(this.mPageContext.getPageActivity());
            ez.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = byVar.getId();
            historyMessage.threadName = byVar.getTitle();
            historyMessage.forumName = byVar.boT();
            historyMessage.postID = byVar.bpg();
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

    private void csa() {
        this.alB.setClickable(true);
        int childCount = this.ijD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ijD.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hbL != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hbK != null) {
            this.hbK.setPageUniqueId(bdUniqueId);
        }
        if (this.ijD != null) {
            this.ijD.setPageUniqueId(bdUniqueId);
        }
    }

    protected void oR(boolean z) {
        if (this.ahA != null) {
            n.Jq(this.ahA.getId());
            n.a(this.mTitle, this.ahA.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.ahp, this.ahA.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            n.a(this.ijd.getGodReplyContent(), this.ahA.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
            s bqc = this.ahA.bqc();
            if (bqc != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bh.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bqc.getCartoonId(), bqc.getChapterId(), 2)));
                return;
            }
            p pVar = this.ahA.eLg;
            if (this.ahA.eLf == 1 && pVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = pVar.eFj;
                long j = pVar.eFk;
                aw awVar = new aw();
                awVar.pageContext = this.mPageContext;
                awVar.eFJ = str;
                awVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, awVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ahA, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.ahA.bpY() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean crR() {
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
    public void wi(int i) {
        this.currentPageType = i;
        if (this.hbL != null) {
            this.hbL.fdg = i;
            this.hbL.setFrom(2);
        }
        if (this.hbK != null) {
            this.hbK.setFrom(3);
        }
    }

    private boolean at(by byVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.jfo)) {
            byVar.dL(this.mUrl, this.jfo);
        }
        SpannableStringBuilder B = byVar.B(false, true);
        if (B == null || StringUtils.isNull(B.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            n.a(this.mTitle, byVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        return true;
    }

    private void au(by byVar) {
        if (byVar != null && ul(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.jfo)) {
                byVar.dL(this.mUrl, this.jfo);
            }
            SpannableString bpM = byVar.bpM();
            if (bpM != null && !au.isEmpty(bpM.toString())) {
                this.ahp.setVisibility(0);
                this.ahp.setOnTouchListener(new com.baidu.tieba.view.i(bpM));
                this.ahp.setText(bpM);
                n.a(this.ahp, byVar.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
                return;
            }
            this.ahp.setVisibility(8);
            return;
        }
        this.ahp.setVisibility(8);
    }

    private void cGl() {
        if (this.mTitle != null && this.alB != null && this.ijD != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alB.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.alB.setLayoutParams(layoutParams);
            if (this.alB.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ijD.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.ijD.setLayoutParams(layoutParams2);
            }
        }
    }

    public void wk(int i) {
        if (this.ahA != null) {
            if (i == 1) {
                this.hbL.setVisibility(8);
                if (this.hcx != null) {
                    this.hcx.setData(this.ahA);
                    return;
                }
                return;
            }
            this.hbL.setData(this.ahA);
            if (this.hcx != null) {
                this.hcx.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    public int ul(int i) {
        return com.baidu.tieba.a.d.bLT().ax(this.aiw, i);
    }
}
