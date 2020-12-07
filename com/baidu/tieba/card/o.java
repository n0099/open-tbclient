package com.baidu.tieba.card;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes21.dex */
public class o extends b<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private static final int ahn;
    private TextView ahp;
    private String aiw;
    private final View.OnClickListener akI;
    public PlayVoiceBntNew alB;
    private boolean alo;
    protected LinearLayout gfN;
    public ThreadUserInfoLayout hbK;
    public ThreadCommentAndPraiseInfoLayout hbL;
    private NEGFeedBackView hbW;
    public ThreadSourceShareAndPraiseLayout hcx;
    private View ijB;
    private com.baidu.tieba.card.data.k ijC;
    private ConstrainImageGroup ijD;
    private View ijE;
    private boolean ijF;
    private RelativeLayout ijG;
    private ThreadForumEnterButton ijH;
    private View.OnClickListener ijI;
    private final View.OnClickListener ijJ;
    private ThreadGodReplyLayout ijd;
    private HeadPendantClickableView ije;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    static {
        ahn = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bkA() ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hbW = null;
        this.mSkinType = 3;
        this.alo = true;
        this.ijF = true;
        this.ijI = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.ijC != null) {
                    o.this.ijC.objType = 1;
                }
                if (o.this.crI() != null) {
                    o.this.crI().a(view, o.this.ijC);
                }
                o.this.oR(view == o.this.ijd);
            }
        };
        this.ijJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.card.data.k> crI = o.this.crI();
                if (crI != null) {
                    view.setTag("2");
                    crI.a(view, o.this.ijC);
                }
            }
        };
        this.akI = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.ijC == null) {
                    if (o.this.crI() != null) {
                        o.this.crI().a(view, o.this.ijC);
                        return;
                    }
                    return;
                }
                if (view == o.this.hbK.getUserName()) {
                    o.this.ijC.objType = 3;
                } else if (view == o.this.hbK.getHeaderImg()) {
                    o.this.ijC.objType = 4;
                } else if (view == o.this.ijD) {
                    o.this.ijC.objType = 2;
                    return;
                } else {
                    o.this.ijC.objType = 1;
                }
                if (o.this.crI() != null) {
                    o.this.crI().a(view, o.this.ijC);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.ije = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.ije.getHeadView() != null) {
            this.ije.getHeadView().setIsRound(true);
            this.ije.getHeadView().setDrawBorder(false);
            this.ije.getHeadView().setDefaultResource(17170445);
            this.ije.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ije.getHeadView().setPlaceHolder(1);
            this.ije.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.ije.setHasPendantStyle();
        if (this.ije.getPendantView() != null) {
            this.ije.getPendantView().setIsRound(true);
            this.ije.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.alB = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.alB.setAfterClickListener(this.ijJ);
        this.ahp = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.ijD = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.ijE = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.ijD.setChildClickListener(this.ijI);
        this.ijD.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.x(1.0d);
        this.ijD.setImageProcessor(fVar);
        this.ijB = view.findViewById(R.id.divider_line_above_praise);
        this.hbL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hbK = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hbW = new NEGFeedBackView(this.mPageContext);
        this.ijG = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hbW.a(this.ijG, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.hbL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hbL.setLayoutParams(layoutParams);
        }
        this.hbL.setOnClickListener(this.ijI);
        this.hbL.setReplyTimeVisible(false);
        this.hbL.setShowPraiseNum(true);
        this.hbL.setNeedAddPraiseIcon(true);
        this.hbL.setNeedAddReplyIcon(true);
        this.hbL.setShareVisible(true);
        this.hbL.setFrom(1);
        this.hbL.setShareReportFrom(3);
        this.hbL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (o.this.crI() != null) {
                    o.this.crI().a(view2, o.this.ijC);
                }
                if (o.this.ijC != null && o.this.ijC.eCR != null) {
                    n.Jq(o.this.ijC.eCR.getId());
                    if (!o.this.crR()) {
                        n.a(o.this.mTitle, o.this.ijC.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.ahp, o.this.ijC.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.ijd.getGodReplyContent(), o.this.ijC.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.gfN = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.ijd = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.ijd.setOnClickListener(this.ijI);
        this.hcx = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.hcx.feb.setOnClickListener(this.ijI);
        this.hcx.setFrom(1);
        this.hcx.setShareReportFrom(3);
        this.hcx.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (o.this.crI() != null) {
                    o.this.crI().a(view2, o.this.ijC);
                }
                if (o.this.ijC != null && o.this.ijC.eCR != null && view2 != o.this.hcx.fdq) {
                    n.Jq(o.this.ijC.eCR.getId());
                    if (!o.this.crR()) {
                        n.a(o.this.mTitle, o.this.ijC.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.ahp, o.this.ijC.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.ijd.getGodReplyContent(), o.this.ijC.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.ijH = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
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
            ap.setBackgroundColor(this.ijB, R.color.transparent);
            this.ijD.onChangeSkinType();
            this.hbL.onChangeSkinType();
            this.ijd.onChangeSkinType();
            this.hbK.onChangeSkinType();
            if (this.hbW != null) {
                this.hbW.onChangeSkinType();
            }
            ap.setBackgroundColor(this.ijE, R.color.CAM_X0204);
            if (this.hcx != null) {
                this.hcx.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.k kVar) {
        boolean z;
        if (kVar == null || kVar.bmn() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ijC = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ijI);
        }
        if (this.hbW != null) {
            if (this.ijC.feedBackReasonMap != null && this.ijC.feedBackReasonMap.size() > 0) {
                at atVar = new at();
                atVar.setTid(this.ijC.bmn().getTid());
                atVar.setFid(this.ijC.bmn().getFid());
                atVar.setNid(this.ijC.bmn().getNid());
                atVar.setFeedBackReasonMap(this.ijC.feedBackReasonMap);
                this.hbW.setData(atVar);
                this.hbW.setFirstRowSingleColumn(true);
                if (kVar.eCR.boP() != null && !StringUtils.isNull(kVar.eCR.boP().getUserId())) {
                    if (kVar.eCR.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.hbW.setVisibility(8);
                    } else if (this.hbW != null) {
                        this.hbW.setVisibility(this.ijF ? 0 : 8);
                    }
                }
            } else {
                this.hbW.setVisibility(8);
            }
        }
        this.hbK.setData(kVar.eCR);
        this.ijd.setFromCDN(this.alo);
        this.ijd.setData(kVar.eCR.bqu());
        if (!crR() && n.Jr(this.ijC.eCR.getId())) {
            n.a(this.mTitle, this.ijC.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.ahp, this.ijC.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.ijd.getGodReplyContent(), this.ijC.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        this.hbK.setUserAfterClickListener(this.akI);
        final by bmn = kVar.bmn();
        if (this.hbK.getHeaderImg() != null) {
            if (this.hbK.getIsSimpleThread()) {
                this.hbK.getHeaderImg().setVisibility(8);
                this.ije.setVisibility(8);
            } else if (bmn.boP() == null || bmn.boP().getPendantData() == null || StringUtils.isNull(bmn.boP().getPendantData().bmL())) {
                this.ije.setVisibility(8);
                this.hbK.getHeaderImg().setVisibility(0);
                this.hbK.getHeaderImg().setData(bmn);
            } else {
                this.hbK.getHeaderImg().setVisibility(4);
                this.ije.setVisibility(0);
                this.ije.setData(bmn);
            }
        }
        az.a(this.mTitle, bmn);
        az.a(this.ahp, this.mTitle, bmn, ahn);
        ArrayList<VoiceData.VoiceModel> bpc = kVar.eCR.bpc();
        if (com.baidu.tbadk.core.util.y.isEmpty(bpc)) {
            this.alB.setVisibility(8);
            z = false;
        } else {
            this.alB.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bpc.get(0);
            this.alB.setVoiceModel(voiceModel);
            this.alB.setTag(voiceModel);
            this.alB.bvs();
            if (voiceModel != null) {
                this.alB.EM(voiceModel.voice_status.intValue());
            }
            this.alB.ccz();
            z = true;
        }
        if (this.ijC.iny && z) {
            this.ijD.setVisibility(8);
        } else {
            ArrayList<MediaData> boY = bmn.boY();
            if (com.baidu.tbadk.core.k.blV().isShowImages() && com.baidu.tbadk.core.util.y.getCount(boY) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < boY.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(boY, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.ijD.setVisibility(0);
                    this.ijD.setFromCDN(this.alo);
                    this.ijD.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.o.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.k> crI = o.this.crI();
                            if (crI != null) {
                                view.setTag("1");
                                if (o.this.akI != null) {
                                    o.this.akI.onClick(o.this.ijD);
                                }
                                crI.a(view, o.this.ijC);
                            }
                            if (z2) {
                                o.this.bAr();
                            } else {
                                o.this.a(view, linkedList, i2, bmn);
                            }
                        }
                    });
                    this.ijD.setImageMediaList(linkedList);
                } else {
                    this.ijD.setVisibility(8);
                }
            } else {
                this.ijD.setVisibility(8);
            }
        }
        crZ();
        csa();
        setPageUniqueId(getTag());
        this.ijH.setVisibility(8);
        wk(ul(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void crZ() {
        if (this.ijB != null && this.ijD != null && this.ijd != null) {
            if (this.ijD.getVisibility() == 8 && this.ijd.getVisibility() == 8) {
                this.ijB.setVisibility(0);
            } else {
                this.ijB.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, by byVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.alo ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(byVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                }
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(arrayList).oj(i).AG(byVar.boT()).AH(String.valueOf(byVar.getFid())).AI(byVar.getTid()).iN(this.alo).AJ(arrayList.size() > 0 ? arrayList.get(0) : "").iO(true).a(concurrentHashMap).iP(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig ez = aVar.ez(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            ez.getIntent().putExtra("from", "index");
        } else {
            ez.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, ez));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = byVar.getId();
        historyMessage.threadName = byVar.getTitle();
        historyMessage.forumName = byVar.boT();
        historyMessage.postID = byVar.bpg();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void csa() {
        if (!this.ijC.fvC) {
            this.alB.setClickable(false);
        } else {
            this.alB.setClickable(true);
        }
        int childCount = this.ijD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ijD.getChildAt(i);
            if (childAt != null) {
                if (!this.ijC.fvC) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ijD != null) {
            this.ijD.setPageUniqueId(bdUniqueId);
        }
        if (this.hbW != null) {
            this.hbW.setUniqueId(bdUniqueId);
        }
        if (this.hbK != null) {
            this.hbK.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAr() {
        oR(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(boolean z) {
        if (this.ijC != null && this.ijC.eCR != null) {
            if (!crR()) {
                n.Jq(this.ijC.eCR.getId());
                n.a(this.mTitle, this.ijC.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                n.a(this.ahp, this.ijC.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                n.a(this.ijd.getGodReplyContent(), this.ijC.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ijC.eCR, null, n.boB(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.ijC.bmq());
            addLocateParam.setForumId(String.valueOf(this.ijC.eCR.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.ijC.eCR.boT());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            n.Jq(this.ijC.bmn().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crR() {
        return this.ijC.iny && !this.ijC.fvC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void oS(boolean z) {
        if (this.ijE != null) {
            this.ijE.setVisibility(z ? 0 : 8);
        }
    }

    public void oT(boolean z) {
        this.ijF = z;
    }

    public void wk(int i) {
        if (this.ijC != null && this.ijC.eCR != null) {
            this.mStType = n.boB();
            if (i == 1) {
                this.hbL.setVisibility(8);
                this.hcx.setStType(this.mStType);
                this.hcx.setData(this.ijC.eCR);
                this.hbK.jK(false);
                return;
            }
            this.hbL.setData(this.ijC.eCR);
            this.hbL.setStType(this.mStType);
            this.hcx.setVisibility(8);
            this.hbK.jK(true);
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
