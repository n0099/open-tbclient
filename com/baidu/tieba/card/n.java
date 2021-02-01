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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes8.dex */
public class n extends b<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private static final int agW = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private TextView agY;
    private String aif;
    private boolean akO;
    private final View.OnClickListener aki;
    public PlayVoiceBntNew alb;
    protected LinearLayout gnT;
    public ThreadSourceShareAndPraiseLayout hnS;
    public ThreadUserInfoLayout hnf;
    public ThreadCommentAndPraiseInfoLayout hng;
    private NEGFeedBackView hnr;
    private View iwV;
    private com.baidu.tieba.card.data.k iwW;
    private ConstrainImageGroup iwX;
    private View iwY;
    private boolean iwZ;
    private ThreadGodReplyLayout iwx;
    private HeadPendantClickableView iwy;
    private RelativeLayout ixa;
    private ThreadForumEnterButton ixb;
    private View.OnClickListener ixc;
    private final View.OnClickListener ixd;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hnr = null;
        this.mSkinType = 3;
        this.akO = true;
        this.iwZ = true;
        this.ixc = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.iwW != null) {
                    n.this.iwW.objType = 1;
                }
                if (n.this.crV() != null) {
                    n.this.crV().a(view, n.this.iwW);
                }
                n.this.pv(view == n.this.iwx);
            }
        };
        this.ixd = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.card.data.k> crV = n.this.crV();
                if (crV != null) {
                    view.setTag("2");
                    crV.a(view, n.this.iwW);
                }
            }
        };
        this.aki = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.iwW == null) {
                    if (n.this.crV() != null) {
                        n.this.crV().a(view, n.this.iwW);
                        return;
                    }
                    return;
                }
                if (view == n.this.hnf.getUserName()) {
                    n.this.iwW.objType = 3;
                } else if (view == n.this.hnf.getHeaderImg()) {
                    n.this.iwW.objType = 4;
                } else if (view == n.this.iwX) {
                    n.this.iwW.objType = 2;
                    return;
                } else {
                    n.this.iwW.objType = 1;
                }
                if (n.this.crV() != null) {
                    n.this.crV().a(view, n.this.iwW);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iwy = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.iwy.getHeadView() != null) {
            this.iwy.getHeadView().setIsRound(true);
            this.iwy.getHeadView().setDrawBorder(false);
            this.iwy.getHeadView().setDefaultResource(17170445);
            this.iwy.getHeadView().setPlaceHolder(1);
            this.iwy.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.iwy.setHasPendantStyle();
        if (this.iwy.getPendantView() != null) {
            this.iwy.getPendantView().setIsRound(true);
            this.iwy.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.alb = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.alb.setAfterClickListener(this.ixd);
        this.agY = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.iwX = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.iwY = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.iwX.setChildClickListener(this.ixc);
        this.iwX.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.r(1.0d);
        this.iwX.setImageProcessor(fVar);
        this.iwV = view.findViewById(R.id.divider_line_above_praise);
        this.hng = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hnf = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hnr = new NEGFeedBackView(this.mPageContext);
        this.ixa = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hnr.a(this.ixa, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.hng.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hng.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hng.setLayoutParams(layoutParams);
        }
        this.hng.setOnClickListener(this.ixc);
        this.hng.setReplyTimeVisible(false);
        this.hng.setShowPraiseNum(true);
        this.hng.setNeedAddPraiseIcon(true);
        this.hng.setNeedAddReplyIcon(true);
        this.hng.setShareVisible(true);
        this.hng.setFrom(1);
        this.hng.setShareReportFrom(3);
        this.hng.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.crV() != null) {
                    n.this.crV().a(view2, n.this.iwW);
                }
                if (n.this.iwW != null && n.this.iwW.eJQ != null) {
                    m.IM(n.this.iwW.eJQ.getId());
                    if (!n.this.cse()) {
                        m.a(n.this.mTitle, n.this.iwW.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.agY, n.this.iwW.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.iwx.getGodReplyContent(), n.this.iwW.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.gnT = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.iwx = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.iwx.setOnClickListener(this.ixc);
        this.hnS = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.hnS.fls.setOnClickListener(this.ixc);
        this.hnS.setFrom(1);
        this.hnS.setShareReportFrom(3);
        this.hnS.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.crV() != null) {
                    n.this.crV().a(view2, n.this.iwW);
                }
                if (n.this.iwW != null && n.this.iwW.eJQ != null && view2 != n.this.hnS.fkH) {
                    m.IM(n.this.iwW.eJQ.getId());
                    if (!n.this.cse()) {
                        m.a(n.this.mTitle, n.this.iwW.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.agY, n.this.iwW.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.iwx.getGodReplyContent(), n.this.iwW.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.ixb = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iwX != null) {
            this.iwX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iwX != null) {
            this.iwX.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.iwV, R.color.transparent);
            this.iwX.onChangeSkinType();
            this.hng.onChangeSkinType();
            this.iwx.onChangeSkinType();
            this.hnf.onChangeSkinType();
            if (this.hnr != null) {
                this.hnr.onChangeSkinType();
            }
            ap.setBackgroundColor(this.iwY, R.color.CAM_X0204);
            if (this.hnS != null) {
                this.hnS.onChangeSkinType();
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
        if (kVar == null || kVar.bln() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.iwW = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ixc);
        }
        if (this.hnr != null) {
            if (this.iwW.feedBackReasonMap != null && this.iwW.feedBackReasonMap.size() > 0) {
                av avVar = new av();
                avVar.setTid(this.iwW.bln().getTid());
                avVar.setFid(this.iwW.bln().getFid());
                avVar.setNid(this.iwW.bln().bmo());
                avVar.setFeedBackReasonMap(this.iwW.feedBackReasonMap);
                this.hnr.setData(avVar);
                this.hnr.setFirstRowSingleColumn(true);
                if (kVar.eJQ.bnQ() != null && !StringUtils.isNull(kVar.eJQ.bnQ().getUserId())) {
                    if (kVar.eJQ.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.hnr.setVisibility(8);
                    } else if (this.hnr != null) {
                        this.hnr.setVisibility(this.iwZ ? 0 : 8);
                    }
                }
            } else {
                this.hnr.setVisibility(8);
            }
        }
        this.hnf.setData(kVar.eJQ);
        this.iwx.setFromCDN(this.akO);
        this.iwx.setData(kVar.eJQ.bpv());
        if (!cse() && m.IN(this.iwW.eJQ.getId())) {
            m.a(this.mTitle, this.iwW.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.agY, this.iwW.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.iwx.getGodReplyContent(), this.iwW.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        this.hnf.setUserAfterClickListener(this.aki);
        final cb bln = kVar.bln();
        if (this.hnf.getHeaderImg() != null) {
            if (this.hnf.getIsSimpleThread()) {
                this.hnf.getHeaderImg().setVisibility(8);
                this.iwy.setVisibility(8);
            } else if (bln.bnQ() == null || bln.bnQ().getPendantData() == null || StringUtils.isNull(bln.bnQ().getPendantData().getImgUrl())) {
                this.iwy.setVisibility(8);
                this.hnf.getHeaderImg().setVisibility(0);
                this.hnf.getHeaderImg().setData(bln);
            } else {
                this.hnf.getHeaderImg().setVisibility(4);
                this.iwy.setVisibility(0);
                this.iwy.setData(bln);
            }
        }
        az.a(this.mTitle, bln);
        az.a(this.agY, this.mTitle, bln, agW);
        ArrayList<VoiceData.VoiceModel> bod = kVar.eJQ.bod();
        if (com.baidu.tbadk.core.util.y.isEmpty(bod)) {
            this.alb.setVisibility(8);
            z = false;
        } else {
            this.alb.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bod.get(0);
            this.alb.setVoiceModel(voiceModel);
            this.alb.setTag(voiceModel);
            this.alb.buo();
            if (voiceModel != null) {
                this.alb.Dp(voiceModel.voice_status.intValue());
            }
            this.alb.ccu();
            z = true;
        }
        if (this.iwW.iAX && z) {
            this.iwX.setVisibility(8);
        } else {
            ArrayList<MediaData> bnZ = bln.bnZ();
            if (com.baidu.tbadk.core.k.bkT().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bnZ) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < bnZ.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bnZ, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.iwX.setVisibility(0);
                    this.iwX.setFromCDN(this.akO);
                    this.iwX.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.k> crV = n.this.crV();
                            if (crV != null) {
                                view.setTag("1");
                                if (n.this.aki != null) {
                                    n.this.aki.onClick(n.this.iwX);
                                }
                                crV.a(view, n.this.iwW);
                            }
                            if (z2) {
                                n.this.bzk();
                            } else {
                                n.this.a(view, linkedList, i2, bln);
                            }
                        }
                    });
                    this.iwX.setImageMediaList(linkedList);
                } else {
                    this.iwX.setVisibility(8);
                }
            } else {
                this.iwX.setVisibility(8);
            }
        }
        csm();
        csn();
        setPageUniqueId(getTag());
        this.ixb.setVisibility(8);
        uZ(sW(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void csm() {
        if (this.iwV != null && this.iwX != null && this.iwx != null) {
            if (this.iwX.getVisibility() == 8 && this.iwx.getVisibility() == 8) {
                this.iwV.setVisibility(0);
            } else {
                this.iwV.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, cb cbVar) {
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
                    imageUrlData.urlType = this.akO ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(cbVar.getTid(), -1L);
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
        aVar.s(arrayList).mQ(i).zJ(cbVar.bnU()).zK(String.valueOf(cbVar.getFid())).zL(cbVar.getTid()).jg(this.akO).zM(arrayList.size() > 0 ? arrayList.get(0) : "").jh(true).d(concurrentHashMap).ji(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eP = aVar.eP(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            eP.getIntent().putExtra("from", "index");
        } else {
            eP.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eP));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = cbVar.getId();
        historyMessage.threadName = cbVar.getTitle();
        historyMessage.forumName = cbVar.bnU();
        historyMessage.postID = cbVar.bog();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void csn() {
        if (!this.iwW.fCP) {
            this.alb.setClickable(false);
        } else {
            this.alb.setClickable(true);
        }
        int childCount = this.iwX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iwX.getChildAt(i);
            if (childAt != null) {
                if (!this.iwW.fCP) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.iwX != null) {
            this.iwX.setPageUniqueId(bdUniqueId);
        }
        if (this.hnr != null) {
            this.hnr.setUniqueId(bdUniqueId);
        }
        if (this.hnf != null) {
            this.hnf.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzk() {
        pv(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pv(boolean z) {
        if (this.iwW != null && this.iwW.eJQ != null) {
            if (!cse()) {
                m.IM(this.iwW.eJQ.getId());
                m.a(this.mTitle, this.iwW.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.agY, this.iwW.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.iwx.getGodReplyContent(), this.iwW.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.iwW.eJQ, null, m.bnC(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.iwW.blq());
            addLocateParam.setForumId(String.valueOf(this.iwW.eJQ.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.iwW.eJQ.bnU());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.IM(this.iwW.bln().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cse() {
        return this.iwW.iAX && !this.iwW.fCP;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void pw(boolean z) {
        if (this.iwY != null) {
            this.iwY.setVisibility(z ? 0 : 8);
        }
    }

    public void px(boolean z) {
        this.iwZ = z;
    }

    public void uZ(int i) {
        if (this.iwW != null && this.iwW.eJQ != null) {
            this.mStType = m.bnC();
            if (i == 1) {
                this.hng.setVisibility(8);
                this.hnS.setStType(this.mStType);
                this.hnS.setData(this.iwW.eJQ);
                this.hnf.kf(false);
                return;
            }
            this.hng.setData(this.iwW.eJQ);
            this.hng.setStType(this.mStType);
            this.hnS.setVisibility(8);
            this.hnf.kf(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public int sW(int i) {
        return com.baidu.tieba.a.d.bKP().aB(this.aif, i);
    }
}
