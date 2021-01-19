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
    private TextView ahj;
    protected bz ahu;
    private String air;
    protected boolean akY;
    private final View.OnClickListener akt;
    private PlayVoiceBntNew alm;
    private AppletsCellView amr;
    private RelativeLayout bIt;
    protected View gde;
    public LinearLayout gln;
    public ThreadUserInfoLayout hiS;
    protected ThreadCommentAndPraiseInfoLayout hiT;
    protected ThreadSourceShareAndPraiseLayout hjF;
    private ThreadGodReplyLayout iqT;
    private HeadPendantClickableView iqU;
    protected View irr;
    protected ConstrainImageGroup irt;
    private View.OnClickListener iry;
    private final View.OnClickListener irz;
    public TbImageView itc;
    private TbImageView ite;
    private i jmZ;
    private String jnj;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akY = true;
        this.iry = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa()) {
                    if (c.this.hiT != null) {
                        c.this.hiT.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.cqL() != null) {
                    c.this.cqL().a(view, c.this.ahu);
                }
                c.this.pl(view == c.this.iqT);
            }
        };
        this.irz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<bz> cqL = c.this.cqL();
                if (cqL != null) {
                    view.setTag("2");
                    cqL.a(view, c.this.ahu);
                }
            }
        };
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cqL() != null) {
                    c.this.cqL().a(view, c.this.ahu);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.iqU = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.iqU.getHeadView() != null) {
            this.iqU.getHeadView().setIsRound(true);
            this.iqU.getHeadView().setDrawBorder(false);
            this.iqU.getHeadView().setDefaultResource(17170445);
            this.iqU.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.iqU.setHasPendantStyle();
        if (this.iqU.getPendantView() != null) {
            this.iqU.getPendantView().setIsRound(true);
            this.iqU.getPendantView().setDrawBorder(false);
        }
        this.iqU.setAfterClickListener(this.akt);
        this.gde = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.alm = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.alm.setAfterClickListener(this.irz);
        this.ahj = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.ahj.setVisibility(8);
        this.irr = view.findViewById(R.id.divider_line_above_praise);
        this.irt = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.irt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.irt.setChildClickListener(this.iry);
        f fVar = new f(3);
        fVar.r(1.0d);
        this.irt.setImageProcessor(fVar);
        this.hiT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hiS = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hiS.setUserAfterClickListener(this.akt);
        this.hiS.setFrom(3);
        this.hiT.setOnClickListener(this.iry);
        this.hiT.setForumAfterClickListener(this.akt);
        this.hiT.setReplyTimeVisible(false);
        this.hiT.setShowPraiseNum(true);
        this.hiT.setNeedAddPraiseIcon(true);
        this.hiT.setNeedAddReplyIcon(true);
        this.hiT.setIsBarViewVisible(false);
        this.hiT.setShareVisible(true);
        this.hiT.setShareReportFrom(1);
        this.hiT.setStType("frs_page");
        this.hiT.setFrom(2);
        this.hiT.fie = 3;
        this.hjF = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.hjF != null) {
            this.hjF.fjb.setOnClickListener(this.iry);
            this.hjF.setFrom(2);
            this.hjF.setShareReportFrom(1);
            this.hjF.setSourceFromForPb(3);
            this.hjF.setStType("frs_page");
            this.hjF.setHideBarName(true);
            this.hjF.fjb.setNeedAddReplyIcon(true);
        }
        this.bIt = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.jmZ = new i(this.mPageContext, this.bIt);
        this.jmZ.setUniqueId(getTag());
        this.iqT = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.iqT.setOnClickListener(this.iry);
        this.itc = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.itc.setPageId(getTag());
        this.ite = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.ite != null) {
            this.ite.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.hiT != null) {
                    c.this.hiT.changeSelectStatus();
                }
            }
        });
        this.hiT.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void kb(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ao.getColor(z ? R.color.CAM_X0201 : R.color.transparent));
                }
            }
        });
        this.gln = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.amr = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.irt != null) {
            this.irt.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.irt != null) {
            this.irt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.irt != null) {
            this.irt.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.gde, R.color.CAM_X0204);
            this.irt.onChangeSkinType();
            this.hiT.onChangeSkinType();
            this.hiS.onChangeSkinType();
            if (this.amr != null) {
                this.amr.onChangeSkinType();
            }
            this.jmZ.onChangeSkinType();
            if (this.hjF != null && this.hjF.getVisibility() == 0) {
                this.hjF.onChangeSkinType();
            }
            if (this.iqU != null && this.iqU.getHeadView() != null && (this.iqU.getHeadView() instanceof TbImageView)) {
                this.iqU.getHeadView().setPlaceHolder(1);
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
        this.ahu = bzVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.iry);
        }
        this.iqT.onChangeSkinType();
        if (!cqU() && m.Id(this.ahu.getId())) {
            m.a(this.mTitle, this.ahu.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.ahj, this.ahu.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            m.a(this.iqT.getGodReplyContent(), this.ahu.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
        b(bzVar);
        this.jmZ.aA(this.ahu);
        aa(bzVar);
        this.hiS.setData(this.ahu);
        this.iqT.setFromCDN(this.akY);
        this.iqT.setData(this.ahu.bpd());
        this.hiS.setUserAfterClickListener(this.akt);
        uP(sR(1));
        if (this.hiS.getHeaderImg() != null) {
            if (this.hiS.getIsSimpleThread()) {
                this.hiS.getHeaderImg().setVisibility(8);
                this.iqU.setVisibility(8);
            } else if (bzVar.bnx() == null || bzVar.bnx().getPendantData() == null || StringUtils.isNull(bzVar.bnx().getPendantData().getImgUrl())) {
                this.iqU.setVisibility(8);
                this.hiS.getHeaderImg().setVisibility(0);
                this.hiS.getHeaderImg().setData(bzVar);
            } else {
                this.hiS.getHeaderImg().setVisibility(4);
                this.iqU.setVisibility(0);
                this.iqU.setData(bzVar);
            }
        }
        at(bzVar);
        au(bzVar);
        this.amr.setData(bzVar.bom());
        this.amr.setForumId(String.valueOf(bzVar.getFid()));
        AppletsCellView appletsCellView = this.amr;
        AppletsCellView appletsCellView2 = this.amr;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> bnK = bzVar.bnK();
        if (x.isEmpty(bnK)) {
            this.alm.setVisibility(8);
        } else {
            this.alm.cbz();
            this.alm.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bnK.get(0);
            this.alm.setVoiceModel(voiceModel);
            this.alm.setTag(voiceModel);
            this.alm.btU();
            if (voiceModel != null) {
                this.alm.CX(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> bnG = bzVar.bnG();
        if (k.bkB().isShowImages() && x.getCount(bnG) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bnG.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(bnG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (x.getCount(linkedList) > 0) {
                this.irt.setVisibility(0);
                this.irt.setFromCDN(this.akY);
                this.irt.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        aa<bz> cqL = c.this.cqL();
                        if (z) {
                            if (cqL != null) {
                                view.setTag("1");
                                cqL.ajy = true;
                                cqL.a(view, c.this.ahu);
                            }
                            c.this.pl(false);
                            return;
                        }
                        if (cqL != null) {
                            view.setTag("1");
                            cqL.ajy = false;
                            cqL.a(view, c.this.ahu);
                        }
                        c.this.a(view, linkedList, i2, bzVar);
                    }
                });
                this.irt.setImageMediaList(linkedList);
            } else {
                this.irt.setVisibility(8);
            }
        } else {
            this.irt.setVisibility(8);
        }
        crc();
        crd();
        cFu();
        if ((com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa()) && this.hiT.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.ahu.bpl() || this.ahu.bpm() || this.ahu.bpn()) {
                ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void crc() {
        if (this.irr != null && this.irt != null && this.iqT != null) {
            if (this.irt.getVisibility() == 8 && this.iqT.getVisibility() == 8 && this.amr.getVisibility() == 8) {
                this.irr.setVisibility(0);
            } else {
                this.irr.setVisibility(8);
            }
        }
    }

    private void aa(final bz bzVar) {
        if (this.ite != null) {
            if (this.itc == null || bzVar == null) {
                this.ite.setVisibility(8);
            } else if (!StringUtils.isNull(bzVar.eQR) && this.itc.getVisibility() != 0) {
                if (this.jmZ != null && this.jmZ.cKh() && (this.ite.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ite.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.ite.setLayoutParams(layoutParams);
                }
                this.ite.setVisibility(0);
                this.ite.setImageDrawable(null);
                this.ite.startLoad(bzVar.eQR, 10, false);
                this.ite.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bzVar.eQS, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.ite.setVisibility(8);
            }
        }
    }

    public void b(bz bzVar) {
        MetaData bnx;
        if (bzVar != null && this.itc != null && (bnx = bzVar.bnx()) != null) {
            final ThemeCardInUserData themeCard = bnx.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.itc.setVisibility(8);
                return;
            }
            this.itc.setVisibility(0);
            this.itc.setImageDrawable(null);
            this.itc.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.itc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.urlType = this.akY ? 13 : 14;
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
            aVar.s(arrayList).mN(i).zs(bzVar.bnB()).zt(String.valueOf(bzVar.getFid())).zu(bzVar.getTid()).je(this.akY).zv(arrayList.size() > 0 ? arrayList.get(0) : "").jf(true).d(concurrentHashMap).jg(true).s(bzVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig eQ = aVar.eQ(this.mPageContext.getPageActivity());
            eQ.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bzVar.getId();
            historyMessage.threadName = bzVar.getTitle();
            historyMessage.forumName = bzVar.bnB();
            historyMessage.postID = bzVar.bnN();
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

    private void crd() {
        this.alm.setClickable(true);
        int childCount = this.irt.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.irt.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hiT != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hiS != null) {
            this.hiS.setPageUniqueId(bdUniqueId);
        }
        if (this.irt != null) {
            this.irt.setPageUniqueId(bdUniqueId);
        }
    }

    protected void pl(boolean z) {
        if (this.ahu != null) {
            m.Ic(this.ahu.getId());
            m.a(this.mTitle, this.ahu.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.ahj, this.ahu.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
            m.a(this.iqT.getGodReplyContent(), this.ahu.getId(), R.color.CAM_X0106, R.color.CAM_X0109);
            s boK = this.ahu.boK();
            if (boK != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bg.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), boK.getCartoonId(), boK.getChapterId(), 2)));
                return;
            }
            p pVar = this.ahu.eQp;
            if (this.ahu.eQo == 1 && pVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = pVar.eKo;
                long j = pVar.eKp;
                aw awVar = new aw();
                awVar.pageContext = this.mPageContext;
                awVar.eKO = str;
                awVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, awVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ahu, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.ahu.boG() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean cqU() {
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
    public void uN(int i) {
        this.currentPageType = i;
        if (this.hiT != null) {
            this.hiT.fie = i;
            this.hiT.setFrom(2);
        }
        if (this.hiS != null) {
            this.hiS.setFrom(3);
        }
    }

    private boolean at(bz bzVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.jnj)) {
            bzVar.dJ(this.mUrl, this.jnj);
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
        if (bzVar != null && sR(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.jnj)) {
                bzVar.dJ(this.mUrl, this.jnj);
            }
            SpannableString bou = bzVar.bou();
            if (bou != null && !at.isEmpty(bou.toString())) {
                this.ahj.setVisibility(0);
                this.ahj.setOnTouchListener(new com.baidu.tieba.view.i(bou));
                this.ahj.setText(bou);
                m.a(this.ahj, bzVar.getId(), R.color.CAM_X0107, R.color.CAM_X0109);
                return;
            }
            this.ahj.setVisibility(8);
            return;
        }
        this.ahj.setVisibility(8);
    }

    private void cFu() {
        if (this.mTitle != null && this.alm != null && this.irt != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alm.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.alm.setLayoutParams(layoutParams);
            if (this.alm.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.irt.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.irt.setLayoutParams(layoutParams2);
            }
        }
    }

    public void uP(int i) {
        if (this.ahu != null) {
            if (i == 1) {
                this.hiT.setVisibility(8);
                if (this.hjF != null) {
                    this.hjF.setData(this.ahu);
                    return;
                }
                return;
            }
            this.hiT.setData(this.ahu);
            if (this.hjF != null) {
                this.hjF.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.air = str;
    }

    public int sR(int i) {
        return com.baidu.tieba.a.d.bKv().az(this.air, i);
    }
}
