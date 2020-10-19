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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
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
public class n extends b<com.baidu.tieba.card.data.l> implements com.baidu.tieba.a.e {
    private static final int agj = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView agl;
    private String aht;
    private final View.OnClickListener ajF;
    private boolean akj;
    public PlayVoiceBntNew akv;
    protected LinearLayout fJK;
    public ThreadUserInfoLayout gAD;
    public ThreadCommentAndPraiseInfoLayout gAE;
    private NEGFeedBackView gAP;
    public ThreadSourceShareAndPraiseLayout gBq;
    private View hFK;
    private com.baidu.tieba.card.data.l hFL;
    private ConstrainImageGroup hFM;
    private View hFN;
    private boolean hFO;
    private RelativeLayout hFP;
    private ThreadForumEnterButton hFQ;
    private View.OnClickListener hFR;
    private final View.OnClickListener hFS;
    private ThreadGodReplyLayout hFm;
    private HeadPendantClickableView hFn;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gAP = null;
        this.mSkinType = 3;
        this.akj = true;
        this.hFO = true;
        this.hFR = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.hFL != null) {
                    n.this.hFL.objType = 1;
                }
                if (n.this.cil() != null) {
                    n.this.cil().a(view, n.this.hFL);
                }
                n.this.nR(view == n.this.hFm);
            }
        };
        this.hFS = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tieba.card.data.l> cil = n.this.cil();
                if (cil != null) {
                    view.setTag("2");
                    cil.a(view, n.this.hFL);
                }
            }
        };
        this.ajF = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.hFL == null) {
                    if (n.this.cil() != null) {
                        n.this.cil().a(view, n.this.hFL);
                        return;
                    }
                    return;
                }
                if (view == n.this.gAD.getUserName()) {
                    n.this.hFL.objType = 3;
                } else if (view == n.this.gAD.getHeaderImg()) {
                    n.this.hFL.objType = 4;
                } else if (view == n.this.hFM) {
                    n.this.hFL.objType = 2;
                    return;
                } else {
                    n.this.hFL.objType = 1;
                }
                if (n.this.cil() != null) {
                    n.this.cil().a(view, n.this.hFL);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hFn = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hFn.getHeadView() != null) {
            this.hFn.getHeadView().setIsRound(true);
            this.hFn.getHeadView().setDrawBorder(false);
            this.hFn.getHeadView().setDefaultResource(17170445);
            this.hFn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hFn.getHeadView().setPlaceHolder(1);
            this.hFn.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hFn.setHasPendantStyle();
        if (this.hFn.getPendantView() != null) {
            this.hFn.getPendantView().setIsRound(true);
            this.hFn.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.akv = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.akv.setAfterClickListener(this.hFS);
        this.agl = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.hFM = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hFN = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.hFM.setChildClickListener(this.hFR);
        this.hFM.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.x(1.0d);
        this.hFM.setImageProcessor(fVar);
        this.hFK = view.findViewById(R.id.divider_line_above_praise);
        this.gAE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gAD = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gAP = new NEGFeedBackView(this.mPageContext);
        this.hFP = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.gAP.a(this.hFP, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.gAE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.gAE.setLayoutParams(layoutParams);
        }
        this.gAE.setOnClickListener(this.hFR);
        this.gAE.setReplyTimeVisible(false);
        this.gAE.setShowPraiseNum(true);
        this.gAE.setNeedAddPraiseIcon(true);
        this.gAE.setNeedAddReplyIcon(true);
        this.gAE.setShareVisible(true);
        this.gAE.setFrom(1);
        this.gAE.setShareReportFrom(3);
        this.gAE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cil() != null) {
                    n.this.cil().a(view2, n.this.hFL);
                }
                if (n.this.hFL != null && n.this.hFL.eji != null) {
                    m.Ij(n.this.hFL.eji.getId());
                    if (!n.this.ciu()) {
                        m.a(n.this.mTitle, n.this.hFL.bfG().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.agl, n.this.hFL.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.hFm.getGodReplyContent(), n.this.hFL.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.fJK = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.hFm = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.hFm.setOnClickListener(this.hFR);
        this.gBq = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.gBq.eJm.setOnClickListener(this.hFR);
        this.gBq.setFrom(1);
        this.gBq.setShareReportFrom(3);
        this.gBq.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cil() != null) {
                    n.this.cil().a(view2, n.this.hFL);
                }
                if (n.this.hFL != null && n.this.hFL.eji != null && view2 != n.this.gBq.eIB) {
                    m.Ij(n.this.hFL.eji.getId());
                    if (!n.this.ciu()) {
                        m.a(n.this.mTitle, n.this.hFL.bfG().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.agl, n.this.hFL.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.hFm.getGodReplyContent(), n.this.hFL.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.hFQ = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hFM != null) {
            this.hFM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hFM != null) {
            this.hFM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hFK, R.color.transparent);
            this.hFM.onChangeSkinType();
            this.gAE.onChangeSkinType();
            this.hFm.onChangeSkinType();
            this.gAD.onChangeSkinType();
            if (this.gAP != null) {
                this.gAP.onChangeSkinType();
            }
            ap.setBackgroundColor(this.hFN, R.color.cp_bg_line_c);
            if (this.gBq != null) {
                this.gBq.onChangeSkinType();
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
    public void a(com.baidu.tieba.card.data.l lVar) {
        boolean z;
        if (lVar == null || lVar.bfG() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.hFL = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hFR);
        }
        if (this.gAP != null) {
            if (this.hFL.feedBackReasonMap != null && this.hFL.feedBackReasonMap.size() > 0) {
                ar arVar = new ar();
                arVar.setTid(this.hFL.bfG().getTid());
                arVar.setFid(this.hFL.bfG().getFid());
                arVar.setNid(this.hFL.bfG().getNid());
                arVar.setFeedBackReasonMap(this.hFL.feedBackReasonMap);
                this.gAP.setData(arVar);
                this.gAP.setFirstRowSingleColumn(true);
                if (lVar.eji.bih() != null && !StringUtils.isNull(lVar.eji.bih().getUserId())) {
                    if (lVar.eji.bih().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.gAP.setVisibility(8);
                    } else if (this.gAP != null) {
                        this.gAP.setVisibility(this.hFO ? 0 : 8);
                    }
                }
            } else {
                this.gAP.setVisibility(8);
            }
        }
        this.gAD.setData(lVar.eji);
        this.hFm.setFromCDN(this.akj);
        this.hFm.setData(lVar.eji.bjK());
        if (!ciu() && m.Ik(this.hFL.eji.getId())) {
            m.a(this.mTitle, this.hFL.bfG().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.agl, this.hFL.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.hFm.getGodReplyContent(), this.hFL.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        this.gAD.setUserAfterClickListener(this.ajF);
        final bw bfG = lVar.bfG();
        if (this.gAD.getHeaderImg() != null) {
            if (this.gAD.getIsSimpleThread()) {
                this.gAD.getHeaderImg().setVisibility(8);
                this.hFn.setVisibility(8);
            } else if (bfG.bih() == null || bfG.bih().getPendantData() == null || StringUtils.isNull(bfG.bih().getPendantData().bgd())) {
                this.hFn.setVisibility(8);
                this.gAD.getHeaderImg().setVisibility(0);
                this.gAD.getHeaderImg().setData(bfG);
            } else {
                this.gAD.getHeaderImg().setVisibility(4);
                this.hFn.setVisibility(0);
                this.hFn.setData(bfG);
            }
        }
        ay.a(this.mTitle, bfG);
        ay.a(this.agl, this.mTitle, bfG, agj);
        ArrayList<VoiceData.VoiceModel> biu = lVar.eji.biu();
        if (com.baidu.tbadk.core.util.y.isEmpty(biu)) {
            this.akv.setVisibility(8);
            z = false;
        } else {
            this.akv.setVisibility(0);
            VoiceData.VoiceModel voiceModel = biu.get(0);
            this.akv.setVoiceModel(voiceModel);
            this.akv.setTag(voiceModel);
            this.akv.changeSkin();
            if (voiceModel != null) {
                this.akv.CT(voiceModel.voice_status.intValue());
            }
            this.akv.bTK();
            z = true;
        }
        if (this.hFL.hJr && z) {
            this.hFM.setVisibility(8);
        } else {
            ArrayList<MediaData> biq = bfG.biq();
            if (com.baidu.tbadk.core.k.bfo().isShowImages() && com.baidu.tbadk.core.util.y.getCount(biq) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < biq.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(biq, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.hFM.setVisibility(0);
                    this.hFM.setFromCDN(this.akj);
                    this.hFM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            aa<com.baidu.tieba.card.data.l> cil = n.this.cil();
                            if (cil != null) {
                                view.setTag("1");
                                if (n.this.ajF != null) {
                                    n.this.ajF.onClick(n.this.hFM);
                                }
                                cil.a(view, n.this.hFL);
                            }
                            if (z2) {
                                n.this.btj();
                            } else {
                                n.this.a(view, linkedList, i2, bfG);
                            }
                        }
                    });
                    this.hFM.setImageMediaList(linkedList);
                } else {
                    this.hFM.setVisibility(8);
                }
            } else {
                this.hFM.setVisibility(8);
            }
        }
        ciC();
        ciD();
        setPageUniqueId(getTag());
        this.hFQ.setVisibility(8);
        uz(sO(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void ciC() {
        if (this.hFK != null && this.hFM != null && this.hFm != null) {
            if (this.hFM.getVisibility() == 8 && this.hFm.getVisibility() == 8) {
                this.hFK.setVisibility(0);
            } else {
                this.hFK.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
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
                    imageUrlData.urlType = this.akj ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
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
        aVar.x(arrayList).nu(i).zX(bwVar.bil()).zY(String.valueOf(bwVar.getFid())).zZ(bwVar.getTid()).ib(this.akj).Aa(arrayList.size() > 0 ? arrayList.get(0) : "").ic(true).a(concurrentHashMap).id(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dU.getIntent().putExtra("from", "index");
        } else {
            dU.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.bil();
        historyMessage.postID = bwVar.biy();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void ciD() {
        if (!this.hFL.faA) {
            this.akv.setClickable(false);
        } else {
            this.akv.setClickable(true);
        }
        int childCount = this.hFM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hFM.getChildAt(i);
            if (childAt != null) {
                if (!this.hFL.faA) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.akj = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hFM != null) {
            this.hFM.setPageUniqueId(bdUniqueId);
        }
        if (this.gAP != null) {
            this.gAP.setUniqueId(bdUniqueId);
        }
        if (this.gAD != null) {
            this.gAD.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btj() {
        nR(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nR(boolean z) {
        if (this.hFL != null && this.hFL.eji != null) {
            if (!ciu()) {
                m.Ij(this.hFL.eji.getId());
                m.a(this.mTitle, this.hFL.bfG().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.agl, this.hFL.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.hFm.getGodReplyContent(), this.hFL.eji.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.hFL.eji, null, m.bhT(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.hFL.bfJ());
            addLocateParam.setForumId(String.valueOf(this.hFL.eji.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hFL.eji.bil());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.Ij(this.hFL.bfG().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ciu() {
        return this.hFL.hJr && !this.hFL.faA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void nS(boolean z) {
        if (this.hFN != null) {
            this.hFN.setVisibility(z ? 0 : 8);
        }
    }

    public void nT(boolean z) {
        this.hFO = z;
    }

    public void uz(int i) {
        if (this.hFL != null && this.hFL.eji != null) {
            this.mStType = m.bhT();
            if (i == 1) {
                this.gAE.setVisibility(8);
                this.gBq.setStType(this.mStType);
                this.gBq.setData(this.hFL.eji);
                this.gAD.iX(false);
                return;
            }
            this.gAE.setData(this.hFL.eji);
            this.gAE.setStType(this.mStType);
            this.gBq.setVisibility(8);
            this.gAD.iX(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }

    public int sO(int i) {
        return com.baidu.tieba.a.d.bEz().av(this.aht, i);
    }
}
