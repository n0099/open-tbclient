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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.p;
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.b<bz> implements e, y {
    private TextView aia;
    protected bz aim;
    private String aji;
    protected boolean alQ;
    private final View.OnClickListener alk;
    private PlayVoiceBntNew amd;
    private AppletsCellView ani;
    private RelativeLayout bNf;
    protected View ghM;
    public LinearLayout gpU;
    public ThreadUserInfoLayout hny;
    protected ThreadCommentAndPraiseInfoLayout hnz;
    protected ThreadSourceShareAndPraiseLayout hol;
    private ThreadGodReplyLayout ivA;
    private HeadPendantClickableView ivB;
    protected View ivY;
    protected ConstrainImageGroup iwa;
    private View.OnClickListener iwf;
    private final View.OnClickListener iwg;
    public TbImageView ixJ;
    private TbImageView ixL;
    private i jrF;
    private String jrP;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.alQ = true;
        this.iwf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.cDY().cDS() || com.baidu.tieba.frs.a.cDR().cDS()) {
                    if (c.this.hnz != null) {
                        c.this.hnz.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.cuD() != null) {
                    c.this.cuD().a(view, c.this.aim);
                }
                c.this.pp(view == c.this.ivA);
            }
        };
        this.iwg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<bz> cuD = c.this.cuD();
                if (cuD != null) {
                    view.setTag("2");
                    cuD.a(view, c.this.aim);
                }
            }
        };
        this.alk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cuD() != null) {
                    c.this.cuD().a(view, c.this.aim);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.ivB = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.ivB.getHeadView() != null) {
            this.ivB.getHeadView().setIsRound(true);
            this.ivB.getHeadView().setDrawBorder(false);
            this.ivB.getHeadView().setDefaultResource(17170445);
            this.ivB.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.ivB.setHasPendantStyle();
        if (this.ivB.getPendantView() != null) {
            this.ivB.getPendantView().setIsRound(true);
            this.ivB.getPendantView().setDrawBorder(false);
        }
        this.ivB.setAfterClickListener(this.alk);
        this.ghM = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.amd = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.amd.setAfterClickListener(this.iwg);
        this.aia = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.aia.setVisibility(8);
        this.ivY = view.findViewById(R.id.divider_line_above_praise);
        this.iwa = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.iwa.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iwa.setChildClickListener(this.iwf);
        f fVar = new f(3);
        fVar.x(1.0d);
        this.iwa.setImageProcessor(fVar);
        this.hnz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hny = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hny.setUserAfterClickListener(this.alk);
        this.hny.setFrom(3);
        this.hnz.setOnClickListener(this.iwf);
        this.hnz.setForumAfterClickListener(this.alk);
        this.hnz.setReplyTimeVisible(false);
        this.hnz.setShowPraiseNum(true);
        this.hnz.setNeedAddPraiseIcon(true);
        this.hnz.setNeedAddReplyIcon(true);
        this.hnz.setIsBarViewVisible(false);
        this.hnz.setShareVisible(true);
        this.hnz.setShareReportFrom(1);
        this.hnz.setStType("frs_page");
        this.hnz.setFrom(2);
        this.hnz.fmP = 3;
        this.hol = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.hol != null) {
            this.hol.fnK.setOnClickListener(this.iwf);
            this.hol.setFrom(2);
            this.hol.setShareReportFrom(1);
            this.hol.setSourceFromForPb(3);
            this.hol.setStType("frs_page");
            this.hol.setHideBarName(true);
            this.hol.fnK.setNeedAddReplyIcon(true);
        }
        this.bNf = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.jrF = new i(this.mPageContext, this.bNf);
        this.jrF.setUniqueId(getTag());
        this.ivA = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.ivA.setOnClickListener(this.iwf);
        this.ixJ = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.ixJ.setPageId(getTag());
        this.ixL = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.ixL != null) {
            this.ixL.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.hnz != null) {
                    c.this.hnz.changeSelectStatus();
                }
            }
        });
        this.hnz.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void kf(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ao.getColor(z ? R.color.CAM_X0201 : R.color.transparent));
                }
            }
        });
        this.gpU = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.ani = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.iwa != null) {
            this.iwa.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iwa != null) {
            this.iwa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iwa != null) {
            this.iwa.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.ghM, R.color.CAM_X0204);
            this.iwa.onChangeSkinType();
            this.hnz.onChangeSkinType();
            this.hny.onChangeSkinType();
            if (this.ani != null) {
                this.ani.onChangeSkinType();
            }
            this.jrF.onChangeSkinType();
            if (this.hol != null && this.hol.getVisibility() == 0) {
                this.hol.onChangeSkinType();
            }
            if (this.ivB != null && this.ivB.getHeadView() != null && (this.ivB.getHeadView() instanceof TbImageView)) {
                this.ivB.getHeadView().setPlaceHolder(1);
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
    public void a(final bz bzVar) {
        if (bzVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aim = bzVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.iwf);
        }
        this.ivA.onChangeSkinType();
        if (!cuM() && m.Jo(this.aim.getId())) {
            m.a(this.mTitle, this.aim.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.aia, this.aim.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            m.a(this.ivA.getGodReplyContent(), this.aim.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        b(bzVar);
        this.jrF.aA(this.aim);
        aa(bzVar);
        this.hny.setData(this.aim);
        this.ivA.setFromCDN(this.alQ);
        this.ivA.setData(this.aim.bsX());
        this.hny.setUserAfterClickListener(this.alk);
        wv(ux(1));
        if (this.hny.getHeaderImg() != null) {
            if (this.hny.getIsSimpleThread()) {
                this.hny.getHeaderImg().setVisibility(8);
                this.ivB.setVisibility(8);
            } else if (bzVar.brr() == null || bzVar.brr().getPendantData() == null || StringUtils.isNull(bzVar.brr().getPendantData().getImgUrl())) {
                this.ivB.setVisibility(8);
                this.hny.getHeaderImg().setVisibility(0);
                this.hny.getHeaderImg().setData(bzVar);
            } else {
                this.hny.getHeaderImg().setVisibility(4);
                this.ivB.setVisibility(0);
                this.ivB.setData(bzVar);
            }
        }
        at(bzVar);
        au(bzVar);
        this.ani.setData(bzVar.bsg());
        this.ani.setForumId(String.valueOf(bzVar.getFid()));
        AppletsCellView appletsCellView = this.ani;
        AppletsCellView appletsCellView2 = this.ani;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> brE = bzVar.brE();
        if (x.isEmpty(brE)) {
            this.amd.setVisibility(8);
        } else {
            this.amd.cfr();
            this.amd.setVisibility(0);
            VoiceData.VoiceModel voiceModel = brE.get(0);
            this.amd.setVoiceModel(voiceModel);
            this.amd.setTag(voiceModel);
            this.amd.bxO();
            if (voiceModel != null) {
                this.amd.EE(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> brA = bzVar.brA();
        if (k.bov().isShowImages() && x.getCount(brA) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < brA.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(brA, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (x.getCount(linkedList) > 0) {
                this.iwa.setVisibility(0);
                this.iwa.setFromCDN(this.alQ);
                this.iwa.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        aa<bz> cuD = c.this.cuD();
                        if (z) {
                            if (cuD != null) {
                                view.setTag("1");
                                cuD.akp = true;
                                cuD.a(view, c.this.aim);
                            }
                            c.this.pp(false);
                            return;
                        }
                        if (cuD != null) {
                            view.setTag("1");
                            cuD.akp = false;
                            cuD.a(view, c.this.aim);
                        }
                        c.this.a(view, linkedList, i2, bzVar);
                    }
                });
                this.iwa.setImageMediaList(linkedList);
            } else {
                this.iwa.setVisibility(8);
            }
        } else {
            this.iwa.setVisibility(8);
        }
        cuU();
        cuV();
        cJm();
        if ((com.baidu.tieba.frs.b.cDY().cDS() || com.baidu.tieba.frs.a.cDR().cDS()) && this.hnz.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.aim.btf() || this.aim.btg() || this.aim.bth()) {
                ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cuU() {
        if (this.ivY != null && this.iwa != null && this.ivA != null) {
            if (this.iwa.getVisibility() == 8 && this.ivA.getVisibility() == 8 && this.ani.getVisibility() == 8) {
                this.ivY.setVisibility(0);
            } else {
                this.ivY.setVisibility(8);
            }
        }
    }

    private void aa(final bz bzVar) {
        if (this.ixL != null) {
            if (this.ixJ == null || bzVar == null) {
                this.ixL.setVisibility(8);
            } else if (!StringUtils.isNull(bzVar.eVC) && this.ixJ.getVisibility() != 0) {
                if (this.jrF != null && this.jrF.cNZ() && (this.ixL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ixL.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ixL.setLayoutParams(layoutParams);
                }
                this.ixL.setVisibility(0);
                this.ixL.setImageDrawable(null);
                this.ixL.startLoad(bzVar.eVC, 10, false);
                this.ixL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bzVar.eVD, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ixL.setVisibility(8);
            }
        }
    }

    public void b(bz bzVar) {
        MetaData brr;
        if (bzVar != null && this.ixJ != null && (brr = bzVar.brr()) != null) {
            final ThemeCardInUserData themeCard = brr.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ixJ.setVisibility(8);
                return;
            }
            this.ixJ.setVisibility(0);
            this.ixJ.setImageDrawable(null);
            this.ixJ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ixJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bz bzVar) {
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
                imageUrlData.urlType = this.alQ ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bzVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!x.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).ot(i).AD(bzVar.brv()).AE(String.valueOf(bzVar.getFid())).AF(bzVar.getTid()).ji(this.alQ).AG(arrayList.size() > 0 ? arrayList.get(0) : "").jj(true).d(concurrentHashMap).jk(true).s(bzVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig eS = aVar.eS(this.mPageContext.getPageActivity());
            eS.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bzVar.getId();
            historyMessage.threadName = bzVar.getTitle();
            historyMessage.forumName = bzVar.brv();
            historyMessage.postID = bzVar.brH();
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

    private void cuV() {
        this.amd.setClickable(true);
        int childCount = this.iwa.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iwa.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hnz != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hny != null) {
            this.hny.setPageUniqueId(bdUniqueId);
        }
        if (this.iwa != null) {
            this.iwa.setPageUniqueId(bdUniqueId);
        }
    }

    protected void pp(boolean z) {
        if (this.aim != null) {
            m.Jn(this.aim.getId());
            m.a(this.mTitle, this.aim.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.aia, this.aim.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            m.a(this.ivA.getGodReplyContent(), this.aim.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
            s bsE = this.aim.bsE();
            if (bsE != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bg.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bsE.getCartoonId(), bsE.getChapterId(), 2)));
                return;
            }
            p pVar = this.aim.eVa;
            if (this.aim.eUZ == 1 && pVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = pVar.eOZ;
                long j = pVar.ePa;
                aw awVar = new aw();
                awVar.pageContext = this.mPageContext;
                awVar.ePz = str;
                awVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, awVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aim, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aim.bsA() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean cuM() {
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
    public void wt(int i) {
        this.currentPageType = i;
        if (this.hnz != null) {
            this.hnz.fmP = i;
            this.hnz.setFrom(2);
        }
        if (this.hny != null) {
            this.hny.setFrom(3);
        }
    }

    private boolean at(bz bzVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.jrP)) {
            bzVar.dK(this.mUrl, this.jrP);
        }
        SpannableStringBuilder B = bzVar.B(false, true);
        if (B == null || StringUtils.isNull(B.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            m.a(this.mTitle, bzVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        return true;
    }

    private void au(bz bzVar) {
        if (bzVar != null && ux(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.jrP)) {
                bzVar.dK(this.mUrl, this.jrP);
            }
            SpannableString bso = bzVar.bso();
            if (bso != null && !at.isEmpty(bso.toString())) {
                this.aia.setVisibility(0);
                this.aia.setOnTouchListener(new com.baidu.tieba.view.i(bso));
                this.aia.setText(bso);
                m.a(this.aia, bzVar.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
                return;
            }
            this.aia.setVisibility(8);
            return;
        }
        this.aia.setVisibility(8);
    }

    private void cJm() {
        if (this.mTitle != null && this.amd != null && this.iwa != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.amd.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.amd.setLayoutParams(layoutParams);
            if (this.amd.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iwa.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.iwa.setLayoutParams(layoutParams2);
            }
        }
    }

    public void wv(int i) {
        if (this.aim != null) {
            if (i == 1) {
                this.hnz.setVisibility(8);
                if (this.hol != null) {
                    this.hol.setData(this.aim);
                    return;
                }
                return;
            }
            this.hnz.setData(this.aim);
            if (this.hol != null) {
                this.hol.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }

    public int ux(int i) {
        return com.baidu.tieba.a.d.bOn().az(this.aji, i);
    }
}
