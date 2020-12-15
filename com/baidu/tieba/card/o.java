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
    protected LinearLayout gfP;
    public ThreadUserInfoLayout hbM;
    public ThreadCommentAndPraiseInfoLayout hbN;
    private NEGFeedBackView hbY;
    public ThreadSourceShareAndPraiseLayout hcz;
    private View ijD;
    private com.baidu.tieba.card.data.k ijE;
    private ConstrainImageGroup ijF;
    private View ijG;
    private boolean ijH;
    private RelativeLayout ijI;
    private ThreadForumEnterButton ijJ;
    private View.OnClickListener ijK;
    private final View.OnClickListener ijL;
    private ThreadGodReplyLayout ijf;
    private HeadPendantClickableView ijg;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    static {
        ahn = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bkA() ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hbY = null;
        this.mSkinType = 3;
        this.alo = true;
        this.ijH = true;
        this.ijK = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.ijE != null) {
                    o.this.ijE.objType = 1;
                }
                if (o.this.crJ() != null) {
                    o.this.crJ().a(view, o.this.ijE);
                }
                o.this.oR(view == o.this.ijf);
            }
        };
        this.ijL = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.card.data.k> crJ = o.this.crJ();
                if (crJ != null) {
                    view.setTag("2");
                    crJ.a(view, o.this.ijE);
                }
            }
        };
        this.akI = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.ijE == null) {
                    if (o.this.crJ() != null) {
                        o.this.crJ().a(view, o.this.ijE);
                        return;
                    }
                    return;
                }
                if (view == o.this.hbM.getUserName()) {
                    o.this.ijE.objType = 3;
                } else if (view == o.this.hbM.getHeaderImg()) {
                    o.this.ijE.objType = 4;
                } else if (view == o.this.ijF) {
                    o.this.ijE.objType = 2;
                    return;
                } else {
                    o.this.ijE.objType = 1;
                }
                if (o.this.crJ() != null) {
                    o.this.crJ().a(view, o.this.ijE);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.ijg = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.ijg.getHeadView() != null) {
            this.ijg.getHeadView().setIsRound(true);
            this.ijg.getHeadView().setDrawBorder(false);
            this.ijg.getHeadView().setDefaultResource(17170445);
            this.ijg.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ijg.getHeadView().setPlaceHolder(1);
            this.ijg.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.ijg.setHasPendantStyle();
        if (this.ijg.getPendantView() != null) {
            this.ijg.getPendantView().setIsRound(true);
            this.ijg.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.alB = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.alB.setAfterClickListener(this.ijL);
        this.ahp = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.ijF = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.ijG = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.ijF.setChildClickListener(this.ijK);
        this.ijF.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.x(1.0d);
        this.ijF.setImageProcessor(fVar);
        this.ijD = view.findViewById(R.id.divider_line_above_praise);
        this.hbN = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hbM = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hbY = new NEGFeedBackView(this.mPageContext);
        this.ijI = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hbY.a(this.ijI, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.hbN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbN.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hbN.setLayoutParams(layoutParams);
        }
        this.hbN.setOnClickListener(this.ijK);
        this.hbN.setReplyTimeVisible(false);
        this.hbN.setShowPraiseNum(true);
        this.hbN.setNeedAddPraiseIcon(true);
        this.hbN.setNeedAddReplyIcon(true);
        this.hbN.setShareVisible(true);
        this.hbN.setFrom(1);
        this.hbN.setShareReportFrom(3);
        this.hbN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (o.this.crJ() != null) {
                    o.this.crJ().a(view2, o.this.ijE);
                }
                if (o.this.ijE != null && o.this.ijE.eCR != null) {
                    n.Jq(o.this.ijE.eCR.getId());
                    if (!o.this.crS()) {
                        n.a(o.this.mTitle, o.this.ijE.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.ahp, o.this.ijE.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.ijf.getGodReplyContent(), o.this.ijE.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.gfP = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.ijf = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.ijf.setOnClickListener(this.ijK);
        this.hcz = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.hcz.feb.setOnClickListener(this.ijK);
        this.hcz.setFrom(1);
        this.hcz.setShareReportFrom(3);
        this.hcz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (o.this.crJ() != null) {
                    o.this.crJ().a(view2, o.this.ijE);
                }
                if (o.this.ijE != null && o.this.ijE.eCR != null && view2 != o.this.hcz.fdq) {
                    n.Jq(o.this.ijE.eCR.getId());
                    if (!o.this.crS()) {
                        n.a(o.this.mTitle, o.this.ijE.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.ahp, o.this.ijE.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.ijf.getGodReplyContent(), o.this.ijE.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.ijJ = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ijF != null) {
            this.ijF.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ijF != null) {
            this.ijF.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.ijD, R.color.transparent);
            this.ijF.onChangeSkinType();
            this.hbN.onChangeSkinType();
            this.ijf.onChangeSkinType();
            this.hbM.onChangeSkinType();
            if (this.hbY != null) {
                this.hbY.onChangeSkinType();
            }
            ap.setBackgroundColor(this.ijG, R.color.CAM_X0204);
            if (this.hcz != null) {
                this.hcz.onChangeSkinType();
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
        this.ijE = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ijK);
        }
        if (this.hbY != null) {
            if (this.ijE.feedBackReasonMap != null && this.ijE.feedBackReasonMap.size() > 0) {
                at atVar = new at();
                atVar.setTid(this.ijE.bmn().getTid());
                atVar.setFid(this.ijE.bmn().getFid());
                atVar.setNid(this.ijE.bmn().getNid());
                atVar.setFeedBackReasonMap(this.ijE.feedBackReasonMap);
                this.hbY.setData(atVar);
                this.hbY.setFirstRowSingleColumn(true);
                if (kVar.eCR.boP() != null && !StringUtils.isNull(kVar.eCR.boP().getUserId())) {
                    if (kVar.eCR.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.hbY.setVisibility(8);
                    } else if (this.hbY != null) {
                        this.hbY.setVisibility(this.ijH ? 0 : 8);
                    }
                }
            } else {
                this.hbY.setVisibility(8);
            }
        }
        this.hbM.setData(kVar.eCR);
        this.ijf.setFromCDN(this.alo);
        this.ijf.setData(kVar.eCR.bqu());
        if (!crS() && n.Jr(this.ijE.eCR.getId())) {
            n.a(this.mTitle, this.ijE.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.ahp, this.ijE.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.ijf.getGodReplyContent(), this.ijE.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        this.hbM.setUserAfterClickListener(this.akI);
        final by bmn = kVar.bmn();
        if (this.hbM.getHeaderImg() != null) {
            if (this.hbM.getIsSimpleThread()) {
                this.hbM.getHeaderImg().setVisibility(8);
                this.ijg.setVisibility(8);
            } else if (bmn.boP() == null || bmn.boP().getPendantData() == null || StringUtils.isNull(bmn.boP().getPendantData().bmL())) {
                this.ijg.setVisibility(8);
                this.hbM.getHeaderImg().setVisibility(0);
                this.hbM.getHeaderImg().setData(bmn);
            } else {
                this.hbM.getHeaderImg().setVisibility(4);
                this.ijg.setVisibility(0);
                this.ijg.setData(bmn);
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
            this.alB.ccA();
            z = true;
        }
        if (this.ijE.inA && z) {
            this.ijF.setVisibility(8);
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
                    this.ijF.setVisibility(0);
                    this.ijF.setFromCDN(this.alo);
                    this.ijF.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.o.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.k> crJ = o.this.crJ();
                            if (crJ != null) {
                                view.setTag("1");
                                if (o.this.akI != null) {
                                    o.this.akI.onClick(o.this.ijF);
                                }
                                crJ.a(view, o.this.ijE);
                            }
                            if (z2) {
                                o.this.bAr();
                            } else {
                                o.this.a(view, linkedList, i2, bmn);
                            }
                        }
                    });
                    this.ijF.setImageMediaList(linkedList);
                } else {
                    this.ijF.setVisibility(8);
                }
            } else {
                this.ijF.setVisibility(8);
            }
        }
        csa();
        csb();
        setPageUniqueId(getTag());
        this.ijJ.setVisibility(8);
        wk(ul(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void csa() {
        if (this.ijD != null && this.ijF != null && this.ijf != null) {
            if (this.ijF.getVisibility() == 8 && this.ijf.getVisibility() == 8) {
                this.ijD.setVisibility(0);
            } else {
                this.ijD.setVisibility(8);
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

    private void csb() {
        if (!this.ijE.fvC) {
            this.alB.setClickable(false);
        } else {
            this.alB.setClickable(true);
        }
        int childCount = this.ijF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ijF.getChildAt(i);
            if (childAt != null) {
                if (!this.ijE.fvC) {
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
        if (this.ijF != null) {
            this.ijF.setPageUniqueId(bdUniqueId);
        }
        if (this.hbY != null) {
            this.hbY.setUniqueId(bdUniqueId);
        }
        if (this.hbM != null) {
            this.hbM.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAr() {
        oR(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(boolean z) {
        if (this.ijE != null && this.ijE.eCR != null) {
            if (!crS()) {
                n.Jq(this.ijE.eCR.getId());
                n.a(this.mTitle, this.ijE.bmn().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                n.a(this.ahp, this.ijE.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                n.a(this.ijf.getGodReplyContent(), this.ijE.eCR.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ijE.eCR, null, n.boB(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.ijE.bmq());
            addLocateParam.setForumId(String.valueOf(this.ijE.eCR.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.ijE.eCR.boT());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            n.Jq(this.ijE.bmn().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crS() {
        return this.ijE.inA && !this.ijE.fvC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void oS(boolean z) {
        if (this.ijG != null) {
            this.ijG.setVisibility(z ? 0 : 8);
        }
    }

    public void oT(boolean z) {
        this.ijH = z;
    }

    public void wk(int i) {
        if (this.ijE != null && this.ijE.eCR != null) {
            this.mStType = n.boB();
            if (i == 1) {
                this.hbN.setVisibility(8);
                this.hcz.setStType(this.mStType);
                this.hcz.setData(this.ijE.eCR);
                this.hbM.jK(false);
                return;
            }
            this.hbN.setData(this.ijE.eCR);
            this.hbN.setStType(this.mStType);
            this.hcz.setVisibility(8);
            this.hbM.jK(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    public int ul(int i) {
        return com.baidu.tieba.a.d.bLU().ax(this.aiw, i);
    }
}
