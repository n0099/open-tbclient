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
import com.baidu.tieba.view.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<bj> implements com.baidu.tieba.a.e, x {
    private TextView KA;
    protected bj KJ;
    private String LC;
    protected boolean NK;
    private PlayVoiceBntNew NZ;
    private final View.OnClickListener Nx;
    private AppletsCellView OP;
    private RelativeLayout aDf;
    protected View cey;
    public ThreadUserInfoLayout eNW;
    protected ThreadCommentAndPraiseInfoLayout eNX;
    protected ThreadSourceShareAndPraiseLayout eOJ;
    public LinearLayout ehj;
    protected View fKI;
    protected ConstrainImageGroup fKK;
    private View.OnClickListener fKP;
    private final View.OnClickListener fKQ;
    private ThreadGodReplyLayout fKj;
    private HeadPendantClickableView fKk;
    public TbImageView fMq;
    private TbImageView fMs;
    private String gzE;
    private i gzu;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.NK = true;
        this.fKP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.bDd().bDe()) {
                    if (c.this.eNX != null) {
                        c.this.eNX.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.buM() != null) {
                    c.this.buM().a(view, c.this.KJ);
                }
                c.this.ko(view == c.this.fKj);
            }
        };
        this.fKQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<bj> buM = c.this.buM();
                if (buM != null) {
                    view.setTag("2");
                    buM.a(view, c.this.KJ);
                }
            }
        };
        this.Nx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.buM() != null) {
                    c.this.buM().a(view, c.this.KJ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.fKk = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.fKk.getHeadView() != null) {
            this.fKk.getHeadView().setIsRound(true);
            this.fKk.getHeadView().setDrawBorder(false);
            this.fKk.getHeadView().setDefaultResource(17170445);
            this.fKk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fKk.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.fKk.setHasPendantStyle();
        if (this.fKk.getPendantView() != null) {
            this.fKk.getPendantView().setIsRound(true);
            this.fKk.getPendantView().setDrawBorder(false);
        }
        this.fKk.setAfterClickListener(this.Nx);
        this.cey = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.NZ = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.NZ.setAfterClickListener(this.fKQ);
        this.KA = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.KA.setVisibility(8);
        this.fKI = view.findViewById(R.id.divider_line_above_praise);
        this.fKK = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.fKK.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fKK.setChildClickListener(this.fKP);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fKK.setImageProcessor(fVar);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.eNW = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.eNW.setUserAfterClickListener(this.Nx);
        this.eNW.setFrom(3);
        this.eNX.setOnClickListener(this.fKP);
        this.eNX.setForumAfterClickListener(this.Nx);
        this.eNX.setReplyTimeVisible(false);
        this.eNX.setShowPraiseNum(true);
        this.eNX.setNeedAddPraiseIcon(true);
        this.eNX.setNeedAddReplyIcon(true);
        this.eNX.setIsBarViewVisible(false);
        this.eNX.setShareVisible(true);
        this.eNX.setShareReportFrom(1);
        this.eNX.setStType("frs_page");
        this.eNX.setFrom(2);
        this.eNX.dih = 3;
        this.eOJ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.eOJ != null) {
            this.eOJ.djh.setOnClickListener(this.fKP);
            this.eOJ.setFrom(2);
            this.eOJ.setShareReportFrom(1);
            this.eOJ.setSourceFromForPb(3);
            this.eOJ.setStType("frs_page");
            this.eOJ.setHideBarName(true);
            this.eOJ.djh.setNeedAddReplyIcon(true);
        }
        this.aDf = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gzu = new i(this.mPageContext, this.aDf);
        this.gzu.setUniqueId(getTag());
        this.fKj = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.fKj.setOnClickListener(this.fKP);
        this.fMq = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.fMq.setPageId(getTag());
        this.fMs = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.fMs != null) {
            this.fMs.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eNX != null) {
                    c.this.eNX.changeSelectStatus();
                }
            }
        });
        this.eNX.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void fU(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.ehj = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.OP = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.fKK != null) {
            this.fKK.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fKK != null) {
            this.fKK.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fKK != null) {
            this.fKK.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.cey, R.color.cp_bg_line_c);
            this.fKK.onChangeSkinType();
            this.eNX.onChangeSkinType();
            this.eNW.onChangeSkinType();
            if (this.OP != null) {
                this.OP.onChangeSkinType();
            }
            this.gzu.onChangeSkinType();
            if (this.eOJ != null && this.eOJ.getVisibility() == 0) {
                this.eOJ.onChangeSkinType();
            }
            if (this.fKk != null && this.fKk.getHeadView() != null && (this.fKk.getHeadView() instanceof TbImageView)) {
                this.fKk.getHeadView().setPlaceHolder(1);
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
        this.KJ = bjVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fKP);
        }
        this.fKj.onChangeSkinType();
        if (!buX() && com.baidu.tieba.card.l.zW(this.KJ.getId())) {
            com.baidu.tieba.card.l.a(this.mTitle, this.KJ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.KA, this.KJ.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fKj.getGodReplyContent(), this.KJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bjVar);
        this.gzu.ay(this.KJ);
        Y(bjVar);
        this.eNW.setData(this.KJ);
        this.fKj.setFromCDN(this.NK);
        this.fKj.setData(this.KJ.aDQ());
        this.eNW.setUserAfterClickListener(this.Nx);
        pD(oe(1));
        if (this.eNW.getHeaderImg() != null) {
            if (this.eNW.getIsSimpleThread()) {
                this.eNW.getHeaderImg().setVisibility(8);
                this.fKk.setVisibility(8);
            } else if (bjVar.aCr() == null || bjVar.aCr().getPendantData() == null || StringUtils.isNull(bjVar.aCr().getPendantData().aAJ())) {
                this.fKk.setVisibility(8);
                this.eNW.getHeaderImg().setVisibility(0);
                this.eNW.getHeaderImg().setData(bjVar);
            } else {
                this.eNW.getHeaderImg().setVisibility(4);
                this.fKk.setVisibility(0);
                this.fKk.setData(bjVar);
            }
        }
        ar(bjVar);
        as(bjVar);
        this.OP.setData(bjVar.aDd());
        this.OP.setForumId(String.valueOf(bjVar.getFid()));
        AppletsCellView appletsCellView = this.OP;
        AppletsCellView appletsCellView2 = this.OP;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aCF = bjVar.aCF();
        if (v.isEmpty(aCF)) {
            this.NZ.setVisibility(8);
        } else {
            this.NZ.cMC();
            this.NZ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aCF.get(0);
            this.NZ.setVoiceModel(voiceModel);
            this.NZ.setTag(voiceModel);
            this.NZ.can();
            if (voiceModel != null) {
                this.NZ.xe(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aCB = bjVar.aCB();
        if (com.baidu.tbadk.core.i.azR().isShowImages() && v.getCount(aCB) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aCB.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aCB, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.fKK.setVisibility(0);
                this.fKK.setFromCDN(this.NK);
                this.fKK.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        z<bj> buM = c.this.buM();
                        if (z) {
                            if (buM != null) {
                                view.setTag("1");
                                buM.MV = true;
                                buM.a(view, c.this.KJ);
                            }
                            c.this.ko(false);
                            return;
                        }
                        if (buM != null) {
                            view.setTag("1");
                            buM.MV = false;
                            buM.a(view, c.this.KJ);
                        }
                        c.this.a(view, linkedList, i2, bjVar);
                    }
                });
                this.fKK.setImageMediaList(linkedList);
            } else {
                this.fKK.setVisibility(8);
            }
        } else {
            this.fKK.setVisibility(8);
        }
        bvf();
        bvg();
        bHH();
        if (this.eNX.isInFrsAllThread() && com.baidu.tieba.frs.a.bDd().bDe()) {
            this.mMaskView.setVisibility(0);
            if (this.KJ.aDZ() || this.KJ.aEa()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bvf() {
        if (this.fKI != null && this.fKK != null && this.fKj != null) {
            if (this.fKK.getVisibility() == 8 && this.fKj.getVisibility() == 8 && this.OP.getVisibility() == 8) {
                this.fKI.setVisibility(0);
            } else {
                this.fKI.setVisibility(8);
            }
        }
    }

    private void Y(final bj bjVar) {
        if (this.fMs != null) {
            if (this.fMq == null || bjVar == null) {
                this.fMs.setVisibility(8);
            } else if (!StringUtils.isNull(bjVar.cUf) && this.fMq.getVisibility() != 0) {
                if (this.gzu != null && this.gzu.bLd() && (this.fMs.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fMs.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.fMs.setLayoutParams(layoutParams);
                }
                this.fMs.setVisibility(0);
                this.fMs.setImageDrawable(null);
                this.fMs.startLoad(bjVar.cUf, 10, false);
                this.fMs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bjVar.cUg, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.fMs.setVisibility(8);
            }
        }
    }

    public void b(bj bjVar) {
        MetaData aCr;
        if (bjVar != null && this.fMq != null && (aCr = bjVar.aCr()) != null) {
            final ThemeCardInUserData themeCard = aCr.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.fMq.setVisibility(8);
                return;
            }
            this.fMq.setVisibility(0);
            this.fMq.setImageDrawable(null);
            this.fMq.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.fMq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.urlType = this.NK ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCw(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NK, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
            historyMessage.forumName = bjVar.aCw();
            historyMessage.postID = bjVar.aCH();
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

    private void bvg() {
        this.NZ.setClickable(true);
        int childCount = this.fKK.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fKK.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.eNX != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eNW != null) {
            this.eNW.setPageUniqueId(bdUniqueId);
        }
        if (this.fKK != null) {
            this.fKK.setPageUniqueId(bdUniqueId);
        }
    }

    protected void ko(boolean z) {
        if (this.KJ != null) {
            com.baidu.tieba.card.l.zV(this.KJ.getId());
            com.baidu.tieba.card.l.a(this.mTitle, this.KJ.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.KA, this.KJ.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.fKj.getGodReplyContent(), this.KJ.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            p aDz = this.KJ.aDz();
            if (aDz != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), aDz.getCartoonId(), aDz.getChapterId(), 2)));
                return;
            }
            m mVar = this.KJ.cTD;
            if (this.KJ.cTC == 1 && mVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = mVar.cOn;
                long j = mVar.cOo;
                ao aoVar = new ao();
                aoVar.pageContext = this.mPageContext;
                aoVar.cOB = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.KJ, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.KJ.aDv() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean buX() {
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
    public void pB(int i) {
        this.currentPageType = i;
        if (this.eNX != null) {
            this.eNX.dih = i;
            this.eNX.setFrom(2);
        }
        if (this.eNW != null) {
            this.eNW.setFrom(3);
        }
    }

    private boolean ar(bj bjVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.gzE)) {
            bjVar.co(this.mUrl, this.gzE);
        }
        SpannableStringBuilder v = bjVar.v(false, true);
        if (v == null || StringUtils.isNull(v.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new h(v));
            this.mTitle.setText(v);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void as(bj bjVar) {
        if (bjVar != null && oe(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.gzE)) {
                bjVar.co(this.mUrl, this.gzE);
            }
            SpannableString aDj = bjVar.aDj();
            if (aDj != null && !aq.isEmpty(aDj.toString())) {
                this.KA.setVisibility(0);
                this.KA.setOnTouchListener(new h(aDj));
                this.KA.setText(aDj);
                com.baidu.tieba.card.l.a(this.KA, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.KA.setVisibility(8);
            return;
        }
        this.KA.setVisibility(8);
    }

    private void bHH() {
        if (this.mTitle != null && this.NZ != null && this.fKK != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.NZ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.NZ.setLayoutParams(layoutParams);
            if (this.NZ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fKK.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.fKK.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pD(int i) {
        if (this.KJ != null) {
            if (i == 1) {
                this.eNX.setVisibility(8);
                if (this.eOJ != null) {
                    this.eOJ.setData(this.KJ);
                    return;
                }
                return;
            }
            this.eNX.setData(this.KJ);
            if (this.eOJ != null) {
                this.eOJ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oe(int i) {
        return com.baidu.tieba.a.d.aXK().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fKK != null) {
            this.fKK.setPreloadSizeReadyCallback(bVar);
        }
    }
}
