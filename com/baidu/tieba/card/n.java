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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
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
/* loaded from: classes15.dex */
public class n extends b<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private static final int aeo = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView aeq;
    private String afx;
    private final View.OnClickListener ahD;
    private boolean aib;
    public PlayVoiceBntNew aio;
    public ThreadSourceShareAndPraiseLayout fXN;
    public ThreadUserInfoLayout fXa;
    public ThreadCommentAndPraiseInfoLayout fXb;
    private NEGFeedBackView fXm;
    protected LinearLayout fiQ;
    private View gWQ;
    private com.baidu.tieba.card.data.k gWR;
    private ConstrainImageGroup gWS;
    private View gWT;
    private boolean gWU;
    private RelativeLayout gWV;
    private ThreadForumEnterButton gWW;
    private View.OnClickListener gWX;
    private final View.OnClickListener gWY;
    private ThreadGodReplyLayout gWs;
    private HeadPendantClickableView gWt;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fXm = null;
        this.mSkinType = 3;
        this.aib = true;
        this.gWU = true;
        this.gWX = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.gWR != null) {
                    n.this.gWR.objType = 1;
                }
                if (n.this.bRn() != null) {
                    n.this.bRn().a(view, n.this.gWR);
                }
                n.this.mB(view == n.this.gWs);
            }
        };
        this.gWY = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tieba.card.data.k> bRn = n.this.bRn();
                if (bRn != null) {
                    view.setTag("2");
                    bRn.a(view, n.this.gWR);
                }
            }
        };
        this.ahD = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.gWR == null) {
                    if (n.this.bRn() != null) {
                        n.this.bRn().a(view, n.this.gWR);
                        return;
                    }
                    return;
                }
                if (view == n.this.fXa.getUserName()) {
                    n.this.gWR.objType = 3;
                } else if (view == n.this.fXa.getHeaderImg()) {
                    n.this.gWR.objType = 4;
                } else if (view == n.this.gWS) {
                    n.this.gWR.objType = 2;
                    return;
                } else {
                    n.this.gWR.objType = 1;
                }
                if (n.this.bRn() != null) {
                    n.this.bRn().a(view, n.this.gWR);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.gWt = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.gWt.getHeadView() != null) {
            this.gWt.getHeadView().setIsRound(true);
            this.gWt.getHeadView().setDrawBorder(false);
            this.gWt.getHeadView().setDefaultResource(17170445);
            this.gWt.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gWt.getHeadView().setPlaceHolder(1);
            this.gWt.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.gWt.setHasPendantStyle();
        if (this.gWt.getPendantView() != null) {
            this.gWt.getPendantView().setIsRound(true);
            this.gWt.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.aio = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.aio.setAfterClickListener(this.gWY);
        this.aeq = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.gWS = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.gWT = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.gWS.setChildClickListener(this.gWX);
        this.gWS.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.o(1.0d);
        this.gWS.setImageProcessor(fVar);
        this.gWQ = view.findViewById(R.id.divider_line_above_praise);
        this.fXb = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.fXa = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.fXm = new NEGFeedBackView(this.mPageContext);
        this.gWV = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.fXm.a(this.gWV, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.fXb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fXb.setLayoutParams(layoutParams);
        }
        this.fXb.setOnClickListener(this.gWX);
        this.fXb.setReplyTimeVisible(false);
        this.fXb.setShowPraiseNum(true);
        this.fXb.setNeedAddPraiseIcon(true);
        this.fXb.setNeedAddReplyIcon(true);
        this.fXb.setShareVisible(true);
        this.fXb.setFrom(1);
        this.fXb.setShareReportFrom(3);
        this.fXb.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.bRn() != null) {
                    n.this.bRn().a(view2, n.this.gWR);
                }
                if (n.this.gWR != null && n.this.gWR.dLK != null) {
                    m.Ez(n.this.gWR.dLK.getId());
                    if (!n.this.bRw()) {
                        m.a(n.this.mTitle, n.this.gWR.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.aeq, n.this.gWR.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.gWs.getGodReplyContent(), n.this.gWR.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.fiQ = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.gWs = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.gWs.setOnClickListener(this.gWX);
        this.fXN = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.fXN.ekZ.setOnClickListener(this.gWX);
        this.fXN.setFrom(1);
        this.fXN.setShareReportFrom(3);
        this.fXN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.bRn() != null) {
                    n.this.bRn().a(view2, n.this.gWR);
                }
                if (n.this.gWR != null && n.this.gWR.dLK != null && view2 != n.this.fXN.eko) {
                    m.Ez(n.this.gWR.dLK.getId());
                    if (!n.this.bRw()) {
                        m.a(n.this.mTitle, n.this.gWR.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.aeq, n.this.gWR.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                        m.a(n.this.gWs.getGodReplyContent(), n.this.gWR.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                    }
                }
            }
        });
        this.gWW = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gWS != null) {
            this.gWS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gWS != null) {
            this.gWS.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.gWQ, R.color.transparent);
            this.gWS.onChangeSkinType();
            this.fXb.onChangeSkinType();
            this.gWs.onChangeSkinType();
            this.fXa.onChangeSkinType();
            if (this.fXm != null) {
                this.fXm.onChangeSkinType();
            }
            ao.setBackgroundColor(this.gWT, R.color.cp_bg_line_c);
            if (this.fXN != null) {
                this.fXN.onChangeSkinType();
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
        if (kVar == null || kVar.aTN() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.gWR = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gWX);
        }
        if (this.fXm != null) {
            if (this.gWR.feedBackReasonMap != null && this.gWR.feedBackReasonMap.size() > 0) {
                aq aqVar = new aq();
                aqVar.setTid(this.gWR.aTN().getTid());
                aqVar.setFid(this.gWR.aTN().getFid());
                aqVar.setNid(this.gWR.aTN().getNid());
                aqVar.setFeedBackReasonMap(this.gWR.feedBackReasonMap);
                this.fXm.setData(aqVar);
                this.fXm.setFirstRowSingleColumn(true);
                if (kVar.dLK.aWl() != null && !StringUtils.isNull(kVar.dLK.aWl().getUserId())) {
                    if (kVar.dLK.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.fXm.setVisibility(8);
                    } else if (this.fXm != null) {
                        this.fXm.setVisibility(this.gWU ? 0 : 8);
                    }
                }
            } else {
                this.fXm.setVisibility(8);
            }
        }
        this.fXa.setData(kVar.dLK);
        this.gWs.setFromCDN(this.aib);
        this.gWs.setData(kVar.dLK.aXO());
        if (!bRw() && m.EA(this.gWR.dLK.getId())) {
            m.a(this.mTitle, this.gWR.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.aeq, this.gWR.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            m.a(this.gWs.getGodReplyContent(), this.gWR.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        this.fXa.setUserAfterClickListener(this.ahD);
        final bv aTN = kVar.aTN();
        if (this.fXa.getHeaderImg() != null) {
            if (this.fXa.getIsSimpleThread()) {
                this.fXa.getHeaderImg().setVisibility(8);
                this.gWt.setVisibility(8);
            } else if (aTN.aWl() == null || aTN.aWl().getPendantData() == null || StringUtils.isNull(aTN.aWl().getPendantData().aUh())) {
                this.gWt.setVisibility(8);
                this.fXa.getHeaderImg().setVisibility(0);
                this.fXa.getHeaderImg().setData(aTN);
            } else {
                this.fXa.getHeaderImg().setVisibility(4);
                this.gWt.setVisibility(0);
                this.gWt.setData(aTN);
            }
        }
        ax.a(this.mTitle, aTN);
        ax.a(this.aeq, this.mTitle, aTN, aeo);
        ArrayList<VoiceData.VoiceModel> aWy = kVar.dLK.aWy();
        if (com.baidu.tbadk.core.util.x.isEmpty(aWy)) {
            this.aio.setVisibility(8);
            z = false;
        } else {
            this.aio.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aWy.get(0);
            this.aio.setVoiceModel(voiceModel);
            this.aio.setTag(voiceModel);
            this.aio.changeSkin();
            if (voiceModel != null) {
                this.aio.zt(voiceModel.voice_status.intValue());
            }
            this.aio.bFz();
            z = true;
        }
        if (this.gWR.hax && z) {
            this.gWS.setVisibility(8);
        } else {
            ArrayList<MediaData> aWu = aTN.aWu();
            if (com.baidu.tbadk.core.k.aTv().isShowImages() && com.baidu.tbadk.core.util.x.getCount(aWu) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aWu.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(aWu, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.x.getCount(linkedList) > 0) {
                    this.gWS.setVisibility(0);
                    this.gWS.setFromCDN(this.aib);
                    this.gWS.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            aa<com.baidu.tieba.card.data.k> bRn = n.this.bRn();
                            if (bRn != null) {
                                view.setTag("1");
                                if (n.this.ahD != null) {
                                    n.this.ahD.onClick(n.this.gWS);
                                }
                                bRn.a(view, n.this.gWR);
                            }
                            if (z2) {
                                n.this.bgS();
                            } else {
                                n.this.a(view, linkedList, i2, aTN);
                            }
                        }
                    });
                    this.gWS.setImageMediaList(linkedList);
                } else {
                    this.gWS.setVisibility(8);
                }
            } else {
                this.gWS.setVisibility(8);
            }
        }
        bRE();
        bRF();
        setPageUniqueId(getTag());
        this.gWW.setVisibility(8);
        rp(pM(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bRE() {
        if (this.gWQ != null && this.gWS != null && this.gWs != null) {
            if (this.gWS.getVisibility() == 8 && this.gWs.getVisibility() == 8) {
                this.gWQ.setVisibility(0);
            } else {
                this.gWQ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bv bvVar) {
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
                    imageUrlData.urlType = this.aib ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bvVar.getTid(), -1L);
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
        aVar.s(arrayList).kG(i).wE(bvVar.aWp()).wF(String.valueOf(bvVar.getFid())).wG(bvVar.getTid()).hl(this.aib).wH(arrayList.size() > 0 ? arrayList.get(0) : "").hm(true).a(concurrentHashMap).hn(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dI = aVar.dI(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dI.getIntent().putExtra("from", "index");
        } else {
            dI.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bvVar.getId();
        historyMessage.threadName = bvVar.getTitle();
        historyMessage.forumName = bvVar.aWp();
        historyMessage.postID = bvVar.aWC();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void bRF() {
        if (!this.gWR.eBy) {
            this.aio.setClickable(false);
        } else {
            this.aio.setClickable(true);
        }
        int childCount = this.gWS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gWS.getChildAt(i);
            if (childAt != null) {
                if (!this.gWR.eBy) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    public void p(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gWS != null) {
            this.gWS.setPageUniqueId(bdUniqueId);
        }
        if (this.fXm != null) {
            this.fXm.setUniqueId(bdUniqueId);
        }
        if (this.fXa != null) {
            this.fXa.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgS() {
        mB(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB(boolean z) {
        if (this.gWR != null && this.gWR.dLK != null) {
            if (!bRw()) {
                m.Ez(this.gWR.dLK.getId());
                m.a(this.mTitle, this.gWR.aTN().getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.aeq, this.gWR.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
                m.a(this.gWs.getGodReplyContent(), this.gWR.dLK.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.gWR.dLK, null, m.aVX(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.gWR.aTQ());
            addLocateParam.setForumId(String.valueOf(this.gWR.dLK.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.gWR.dLK.aWp());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.Ez(this.gWR.aTN().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bRw() {
        return this.gWR.hax && !this.gWR.eBy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void mC(boolean z) {
        if (this.gWT != null) {
            this.gWT.setVisibility(z ? 0 : 8);
        }
    }

    public void mD(boolean z) {
        this.gWU = z;
    }

    public void rp(int i) {
        if (this.gWR != null && this.gWR.dLK != null) {
            this.mStType = m.aVX();
            if (i == 1) {
                this.fXb.setVisibility(8);
                this.fXN.setStType(this.mStType);
                this.fXN.setData(this.gWR.dLK);
                this.fXa.ie(false);
                return;
            }
            this.fXb.setData(this.gWR.dLK);
            this.fXb.setStType(this.mStType);
            this.fXN.setVisibility(8);
            this.fXa.ie(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afx = str;
    }

    public int pM(int i) {
        return com.baidu.tieba.a.d.brD().ar(this.afx, i);
    }
}
