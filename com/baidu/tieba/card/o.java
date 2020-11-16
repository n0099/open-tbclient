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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes20.dex */
public class o extends b<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private static final int agp;
    private TextView agr;
    private String ahw;
    private final View.OnClickListener ajJ;
    public PlayVoiceBntNew akA;
    private boolean akn;
    protected LinearLayout fXC;
    private NEGFeedBackView gSJ;
    public ThreadUserInfoLayout gSx;
    public ThreadCommentAndPraiseInfoLayout gSy;
    public ThreadSourceShareAndPraiseLayout gTk;
    private View hYE;
    private com.baidu.tieba.card.data.k hYF;
    private ConstrainImageGroup hYG;
    private View hYH;
    private boolean hYI;
    private RelativeLayout hYJ;
    private ThreadForumEnterButton hYK;
    private View.OnClickListener hYL;
    private final View.OnClickListener hYM;
    private ThreadGodReplyLayout hYg;
    private HeadPendantClickableView hYh;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    static {
        agp = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bhw() ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gSJ = null;
        this.mSkinType = 3;
        this.akn = true;
        this.hYI = true;
        this.hYL = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.hYF != null) {
                    o.this.hYF.objType = 1;
                }
                if (o.this.cnv() != null) {
                    o.this.cnv().a(view, o.this.hYF);
                }
                o.this.ov(view == o.this.hYg);
            }
        };
        this.hYM = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.card.data.k> cnv = o.this.cnv();
                if (cnv != null) {
                    view.setTag("2");
                    cnv.a(view, o.this.hYF);
                }
            }
        };
        this.ajJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.o.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.hYF == null) {
                    if (o.this.cnv() != null) {
                        o.this.cnv().a(view, o.this.hYF);
                        return;
                    }
                    return;
                }
                if (view == o.this.gSx.getUserName()) {
                    o.this.hYF.objType = 3;
                } else if (view == o.this.gSx.getHeaderImg()) {
                    o.this.hYF.objType = 4;
                } else if (view == o.this.hYG) {
                    o.this.hYF.objType = 2;
                    return;
                } else {
                    o.this.hYF.objType = 1;
                }
                if (o.this.cnv() != null) {
                    o.this.cnv().a(view, o.this.hYF);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hYh = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hYh.getHeadView() != null) {
            this.hYh.getHeadView().setIsRound(true);
            this.hYh.getHeadView().setDrawBorder(false);
            this.hYh.getHeadView().setDefaultResource(17170445);
            this.hYh.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hYh.getHeadView().setPlaceHolder(1);
            this.hYh.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hYh.setHasPendantStyle();
        if (this.hYh.getPendantView() != null) {
            this.hYh.getPendantView().setIsRound(true);
            this.hYh.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.akA = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.akA.setAfterClickListener(this.hYM);
        this.agr = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.hYG = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hYH = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.hYG.setChildClickListener(this.hYL);
        this.hYG.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.x(1.0d);
        this.hYG.setImageProcessor(fVar);
        this.hYE = view.findViewById(R.id.divider_line_above_praise);
        this.gSy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gSx = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gSJ = new NEGFeedBackView(this.mPageContext);
        this.hYJ = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gSJ.a(this.hYJ, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.gSy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSy.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gSy.setLayoutParams(layoutParams);
        }
        this.gSy.setOnClickListener(this.hYL);
        this.gSy.setReplyTimeVisible(false);
        this.gSy.setShowPraiseNum(true);
        this.gSy.setNeedAddPraiseIcon(true);
        this.gSy.setNeedAddReplyIcon(true);
        this.gSy.setShareVisible(true);
        this.gSy.setFrom(1);
        this.gSy.setShareReportFrom(3);
        this.gSy.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (o.this.cnv() != null) {
                    o.this.cnv().a(view2, o.this.hYF);
                }
                if (o.this.hYF != null && o.this.hYF.evQ != null) {
                    n.IA(o.this.hYF.evQ.getId());
                    if (!o.this.cnE()) {
                        n.a(o.this.mTitle, o.this.hYF.bjd().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.agr, o.this.hYF.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.hYg.getGodReplyContent(), o.this.hYF.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.fXC = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.hYg = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.hYg.setOnClickListener(this.hYL);
        this.gTk = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.gTk.eWE.setOnClickListener(this.hYL);
        this.gTk.setFrom(1);
        this.gTk.setShareReportFrom(3);
        this.gTk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (o.this.cnv() != null) {
                    o.this.cnv().a(view2, o.this.hYF);
                }
                if (o.this.hYF != null && o.this.hYF.evQ != null && view2 != o.this.gTk.eVT) {
                    n.IA(o.this.hYF.evQ.getId());
                    if (!o.this.cnE()) {
                        n.a(o.this.mTitle, o.this.hYF.bjd().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.agr, o.this.hYF.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        n.a(o.this.hYg.getGodReplyContent(), o.this.hYF.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.hYK = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
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
            ap.setBackgroundColor(this.hYE, R.color.transparent);
            this.hYG.onChangeSkinType();
            this.gSy.onChangeSkinType();
            this.hYg.onChangeSkinType();
            this.gSx.onChangeSkinType();
            if (this.gSJ != null) {
                this.gSJ.onChangeSkinType();
            }
            ap.setBackgroundColor(this.hYH, R.color.CAM_X0204);
            if (this.gTk != null) {
                this.gTk.onChangeSkinType();
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
        if (kVar == null || kVar.bjd() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.hYF = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hYL);
        }
        if (this.gSJ != null) {
            if (this.hYF.feedBackReasonMap != null && this.hYF.feedBackReasonMap.size() > 0) {
                as asVar = new as();
                asVar.setTid(this.hYF.bjd().getTid());
                asVar.setFid(this.hYF.bjd().getFid());
                asVar.setNid(this.hYF.bjd().getNid());
                asVar.setFeedBackReasonMap(this.hYF.feedBackReasonMap);
                this.gSJ.setData(asVar);
                this.gSJ.setFirstRowSingleColumn(true);
                if (kVar.evQ.blC() != null && !StringUtils.isNull(kVar.evQ.blC().getUserId())) {
                    if (kVar.evQ.blC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.gSJ.setVisibility(8);
                    } else if (this.gSJ != null) {
                        this.gSJ.setVisibility(this.hYI ? 0 : 8);
                    }
                }
            } else {
                this.gSJ.setVisibility(8);
            }
        }
        this.gSx.setData(kVar.evQ);
        this.hYg.setFromCDN(this.akn);
        this.hYg.setData(kVar.evQ.bnh());
        if (!cnE() && n.IB(this.hYF.evQ.getId())) {
            n.a(this.mTitle, this.hYF.bjd().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.agr, this.hYF.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            n.a(this.hYg.getGodReplyContent(), this.hYF.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        this.gSx.setUserAfterClickListener(this.ajJ);
        final bx bjd = kVar.bjd();
        if (this.gSx.getHeaderImg() != null) {
            if (this.gSx.getIsSimpleThread()) {
                this.gSx.getHeaderImg().setVisibility(8);
                this.hYh.setVisibility(8);
            } else if (bjd.blC() == null || bjd.blC().getPendantData() == null || StringUtils.isNull(bjd.blC().getPendantData().bjy())) {
                this.hYh.setVisibility(8);
                this.gSx.getHeaderImg().setVisibility(0);
                this.gSx.getHeaderImg().setData(bjd);
            } else {
                this.gSx.getHeaderImg().setVisibility(4);
                this.hYh.setVisibility(0);
                this.hYh.setData(bjd);
            }
        }
        az.a(this.mTitle, bjd);
        az.a(this.agr, this.mTitle, bjd, agp);
        ArrayList<VoiceData.VoiceModel> blP = kVar.evQ.blP();
        if (com.baidu.tbadk.core.util.y.isEmpty(blP)) {
            this.akA.setVisibility(8);
            z = false;
        } else {
            this.akA.setVisibility(0);
            VoiceData.VoiceModel voiceModel = blP.get(0);
            this.akA.setVoiceModel(voiceModel);
            this.akA.setTag(voiceModel);
            this.akA.changeSkin();
            if (voiceModel != null) {
                this.akA.DX(voiceModel.voice_status.intValue());
            }
            this.akA.bYE();
            z = true;
        }
        if (this.hYF.icA && z) {
            this.hYG.setVisibility(8);
        } else {
            ArrayList<MediaData> blL = bjd.blL();
            if (com.baidu.tbadk.core.k.biL().isShowImages() && com.baidu.tbadk.core.util.y.getCount(blL) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < blL.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(blL, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hYG.setVisibility(0);
                    this.hYG.setFromCDN(this.akn);
                    this.hYG.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.o.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.k> cnv = o.this.cnv();
                            if (cnv != null) {
                                view.setTag("1");
                                if (o.this.ajJ != null) {
                                    o.this.ajJ.onClick(o.this.hYG);
                                }
                                cnv.a(view, o.this.hYF);
                            }
                            if (z2) {
                                o.this.bwR();
                            } else {
                                o.this.a(view, linkedList, i2, bjd);
                            }
                        }
                    });
                    this.hYG.setImageMediaList(linkedList);
                } else {
                    this.hYG.setVisibility(8);
                }
            } else {
                this.hYG.setVisibility(8);
            }
        }
        cnM();
        cnN();
        setPageUniqueId(getTag());
        this.hYK.setVisibility(8);
        vD(tH(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cnM() {
        if (this.hYE != null && this.hYG != null && this.hYg != null) {
            if (this.hYG.getVisibility() == 8 && this.hYg.getVisibility() == 8) {
                this.hYE.setVisibility(0);
            } else {
                this.hYE.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bx bxVar) {
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
                    imageUrlData.urlType = this.akn ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bxVar.getTid(), -1L);
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
        aVar.x(arrayList).nL(i).zZ(bxVar.blG()).Aa(String.valueOf(bxVar.getFid())).Ab(bxVar.getTid()).iy(this.akn).Ac(arrayList.size() > 0 ? arrayList.get(0) : "").iz(true).a(concurrentHashMap).iA(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dU.getIntent().putExtra("from", "index");
        } else {
            dU.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bxVar.getId();
        historyMessage.threadName = bxVar.getTitle();
        historyMessage.forumName = bxVar.blG();
        historyMessage.postID = bxVar.blT();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void cnN() {
        if (!this.hYF.fnY) {
            this.akA.setClickable(false);
        } else {
            this.akA.setClickable(true);
        }
        int childCount = this.hYG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hYG.getChildAt(i);
            if (childAt != null) {
                if (!this.hYF.fnY) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hYG != null) {
            this.hYG.setPageUniqueId(bdUniqueId);
        }
        if (this.gSJ != null) {
            this.gSJ.setUniqueId(bdUniqueId);
        }
        if (this.gSx != null) {
            this.gSx.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwR() {
        ov(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov(boolean z) {
        if (this.hYF != null && this.hYF.evQ != null) {
            if (!cnE()) {
                n.IA(this.hYF.evQ.getId());
                n.a(this.mTitle, this.hYF.bjd().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                n.a(this.agr, this.hYF.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                n.a(this.hYg.getGodReplyContent(), this.hYF.evQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.hYF.evQ, null, n.blo(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hYF.bjg());
            addLocateParam.setForumId(String.valueOf(this.hYF.evQ.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hYF.evQ.blG());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            n.IA(this.hYF.bjd().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnE() {
        return this.hYF.icA && !this.hYF.fnY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void ow(boolean z) {
        if (this.hYH != null) {
            this.hYH.setVisibility(z ? 0 : 8);
        }
    }

    public void ox(boolean z) {
        this.hYI = z;
    }

    public void vD(int i) {
        if (this.hYF != null && this.hYF.evQ != null) {
            this.mStType = n.blo();
            if (i == 1) {
                this.gSy.setVisibility(8);
                this.gTk.setStType(this.mStType);
                this.gTk.setData(this.hYF.evQ);
                this.gSx.ju(false);
                return;
            }
            this.gSy.setData(this.hYF.evQ);
            this.gSy.setStType(this.mStType);
            this.gTk.setVisibility(8);
            this.gSx.ju(true);
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
