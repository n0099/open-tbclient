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
/* loaded from: classes7.dex */
public class n extends b<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private static final int aip = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private TextView air;
    private String ajx;
    private final View.OnClickListener alB;
    private boolean amh;
    public PlayVoiceBntNew amu;
    protected LinearLayout gpQ;
    public ThreadSourceShareAndPraiseLayout hpQ;
    public ThreadUserInfoLayout hpd;
    public ThreadCommentAndPraiseInfoLayout hpe;
    private NEGFeedBackView hpp;
    private View iyS;
    private com.baidu.tieba.card.data.k iyT;
    private ConstrainImageGroup iyU;
    private View iyV;
    private boolean iyW;
    private RelativeLayout iyX;
    private ThreadForumEnterButton iyY;
    private View.OnClickListener iyZ;
    private ThreadGodReplyLayout iyu;
    private HeadPendantClickableView iyv;
    private final View.OnClickListener iza;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hpp = null;
        this.mSkinType = 3;
        this.amh = true;
        this.iyW = true;
        this.iyZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.iyT != null) {
                    n.this.iyT.objType = 1;
                }
                if (n.this.csi() != null) {
                    n.this.csi().a(view, n.this.iyT);
                }
                n.this.pv(view == n.this.iyu);
            }
        };
        this.iza = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.card.data.k> csi = n.this.csi();
                if (csi != null) {
                    view.setTag("2");
                    csi.a(view, n.this.iyT);
                }
            }
        };
        this.alB = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.iyT == null) {
                    if (n.this.csi() != null) {
                        n.this.csi().a(view, n.this.iyT);
                        return;
                    }
                    return;
                }
                if (view == n.this.hpd.getUserName()) {
                    n.this.iyT.objType = 3;
                } else if (view == n.this.hpd.getHeaderImg()) {
                    n.this.iyT.objType = 4;
                } else if (view == n.this.iyU) {
                    n.this.iyT.objType = 2;
                    return;
                } else {
                    n.this.iyT.objType = 1;
                }
                if (n.this.csi() != null) {
                    n.this.csi().a(view, n.this.iyT);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iyv = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.iyv.getHeadView() != null) {
            this.iyv.getHeadView().setIsRound(true);
            this.iyv.getHeadView().setDrawBorder(false);
            this.iyv.getHeadView().setDefaultResource(17170445);
            this.iyv.getHeadView().setPlaceHolder(1);
            this.iyv.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.iyv.setHasPendantStyle();
        if (this.iyv.getPendantView() != null) {
            this.iyv.getPendantView().setIsRound(true);
            this.iyv.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.amu = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.amu.setAfterClickListener(this.iza);
        this.air = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.iyU = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.iyV = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.iyU.setChildClickListener(this.iyZ);
        this.iyU.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.r(1.0d);
        this.iyU.setImageProcessor(fVar);
        this.iyS = view.findViewById(R.id.divider_line_above_praise);
        this.hpe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hpd = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hpp = new NEGFeedBackView(this.mPageContext);
        this.iyX = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hpp.a(this.iyX, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.hpe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hpe.setLayoutParams(layoutParams);
        }
        this.hpe.setOnClickListener(this.iyZ);
        this.hpe.setReplyTimeVisible(false);
        this.hpe.setShowPraiseNum(true);
        this.hpe.setNeedAddPraiseIcon(true);
        this.hpe.setNeedAddReplyIcon(true);
        this.hpe.setShareVisible(true);
        this.hpe.setFrom(1);
        this.hpe.setShareReportFrom(3);
        this.hpe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.csi() != null) {
                    n.this.csi().a(view2, n.this.iyT);
                }
                if (n.this.iyT != null && n.this.iyT.eLr != null) {
                    m.IW(n.this.iyT.eLr.getId());
                    if (!n.this.csr()) {
                        m.a(n.this.mTitle, n.this.iyT.blp().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.air, n.this.iyT.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.iyu.getGodReplyContent(), n.this.iyT.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.gpQ = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.iyu = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.iyu.setOnClickListener(this.iyZ);
        this.hpQ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.hpQ.fmS.setOnClickListener(this.iyZ);
        this.hpQ.setFrom(1);
        this.hpQ.setShareReportFrom(3);
        this.hpQ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.csi() != null) {
                    n.this.csi().a(view2, n.this.iyT);
                }
                if (n.this.iyT != null && n.this.iyT.eLr != null && view2 != n.this.hpQ.fmg) {
                    m.IW(n.this.iyT.eLr.getId());
                    if (!n.this.csr()) {
                        m.a(n.this.mTitle, n.this.iyT.blp().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.air, n.this.iyT.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.iyu.getGodReplyContent(), n.this.iyT.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.iyY = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iyU != null) {
            this.iyU.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iyU != null) {
            this.iyU.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.iyS, R.color.transparent);
            this.iyU.onChangeSkinType();
            this.hpe.onChangeSkinType();
            this.iyu.onChangeSkinType();
            this.hpd.onChangeSkinType();
            if (this.hpp != null) {
                this.hpp.onChangeSkinType();
            }
            ap.setBackgroundColor(this.iyV, R.color.CAM_X0204);
            if (this.hpQ != null) {
                this.hpQ.onChangeSkinType();
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
        if (kVar == null || kVar.blp() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.iyT = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.iyZ);
        }
        if (this.hpp != null) {
            if (this.iyT.feedBackReasonMap != null && this.iyT.feedBackReasonMap.size() > 0) {
                av avVar = new av();
                avVar.setTid(this.iyT.blp().getTid());
                avVar.setFid(this.iyT.blp().getFid());
                avVar.setNid(this.iyT.blp().bmq());
                avVar.setFeedBackReasonMap(this.iyT.feedBackReasonMap);
                this.hpp.setData(avVar);
                this.hpp.setFirstRowSingleColumn(true);
                if (kVar.eLr.bnS() != null && !StringUtils.isNull(kVar.eLr.bnS().getUserId())) {
                    if (kVar.eLr.bnS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.hpp.setVisibility(8);
                    } else if (this.hpp != null) {
                        this.hpp.setVisibility(this.iyW ? 0 : 8);
                    }
                }
            } else {
                this.hpp.setVisibility(8);
            }
        }
        this.hpd.setData(kVar.eLr);
        this.iyu.setFromCDN(this.amh);
        this.iyu.setData(kVar.eLr.bpx());
        if (!csr() && m.IX(this.iyT.eLr.getId())) {
            m.a(this.mTitle, this.iyT.blp().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.air, this.iyT.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.iyu.getGodReplyContent(), this.iyT.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        this.hpd.setUserAfterClickListener(this.alB);
        final cb blp = kVar.blp();
        if (this.hpd.getHeaderImg() != null) {
            if (this.hpd.getIsSimpleThread()) {
                this.hpd.getHeaderImg().setVisibility(8);
                this.iyv.setVisibility(8);
            } else if (blp.bnS() == null || blp.bnS().getPendantData() == null || StringUtils.isNull(blp.bnS().getPendantData().getImgUrl())) {
                this.iyv.setVisibility(8);
                this.hpd.getHeaderImg().setVisibility(0);
                this.hpd.getHeaderImg().setData(blp);
            } else {
                this.hpd.getHeaderImg().setVisibility(4);
                this.iyv.setVisibility(0);
                this.iyv.setData(blp);
            }
        }
        az.a(this.mTitle, blp);
        az.a(this.air, this.mTitle, blp, aip);
        ArrayList<VoiceData.VoiceModel> bof = kVar.eLr.bof();
        if (com.baidu.tbadk.core.util.y.isEmpty(bof)) {
            this.amu.setVisibility(8);
            z = false;
        } else {
            this.amu.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bof.get(0);
            this.amu.setVoiceModel(voiceModel);
            this.amu.setTag(voiceModel);
            this.amu.bur();
            if (voiceModel != null) {
                this.amu.Ds(voiceModel.voice_status.intValue());
            }
            this.amu.ccH();
            z = true;
        }
        if (this.iyT.iCU && z) {
            this.iyU.setVisibility(8);
        } else {
            ArrayList<MediaData> bob = blp.bob();
            if (com.baidu.tbadk.core.k.bkV().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bob) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < bob.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bob, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.y.getCount(linkedList) > 0) {
                    this.iyU.setVisibility(0);
                    this.iyU.setFromCDN(this.amh);
                    this.iyU.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.k> csi = n.this.csi();
                            if (csi != null) {
                                view.setTag("1");
                                if (n.this.alB != null) {
                                    n.this.alB.onClick(n.this.iyU);
                                }
                                csi.a(view, n.this.iyT);
                            }
                            if (z2) {
                                n.this.bzn();
                            } else {
                                n.this.a(view, linkedList, i2, blp);
                            }
                        }
                    });
                    this.iyU.setImageMediaList(linkedList);
                } else {
                    this.iyU.setVisibility(8);
                }
            } else {
                this.iyU.setVisibility(8);
            }
        }
        csz();
        csA();
        setPageUniqueId(getTag());
        this.iyY.setVisibility(8);
        vb(sY(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void csz() {
        if (this.iyS != null && this.iyU != null && this.iyu != null) {
            if (this.iyU.getVisibility() == 8 && this.iyu.getVisibility() == 8) {
                this.iyS.setVisibility(0);
            } else {
                this.iyS.setVisibility(8);
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
                    imageUrlData.urlType = this.amh ? 13 : 14;
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
        aVar.s(arrayList).mR(i).zQ(cbVar.bnW()).zR(String.valueOf(cbVar.getFid())).zS(cbVar.getTid()).jg(this.amh).zT(arrayList.size() > 0 ? arrayList.get(0) : "").jh(true).d(concurrentHashMap).ji(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eO = aVar.eO(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            eO.getIntent().putExtra("from", "index");
        } else {
            eO.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = cbVar.getId();
        historyMessage.threadName = cbVar.getTitle();
        historyMessage.forumName = cbVar.bnW();
        historyMessage.postID = cbVar.boi();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void csA() {
        if (!this.iyT.fEo) {
            this.amu.setClickable(false);
        } else {
            this.amu.setClickable(true);
        }
        int childCount = this.iyU.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iyU.getChildAt(i);
            if (childAt != null) {
                if (!this.iyT.fEo) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.iyU != null) {
            this.iyU.setPageUniqueId(bdUniqueId);
        }
        if (this.hpp != null) {
            this.hpp.setUniqueId(bdUniqueId);
        }
        if (this.hpd != null) {
            this.hpd.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzn() {
        pv(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pv(boolean z) {
        if (this.iyT != null && this.iyT.eLr != null) {
            if (!csr()) {
                m.IW(this.iyT.eLr.getId());
                m.a(this.mTitle, this.iyT.blp().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.air, this.iyT.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.iyu.getGodReplyContent(), this.iyT.eLr.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.iyT.eLr, null, m.bnE(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.iyT.bls());
            addLocateParam.setForumId(String.valueOf(this.iyT.eLr.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.iyT.eLr.bnW());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.IW(this.iyT.blp().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csr() {
        return this.iyT.iCU && !this.iyT.fEo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void pw(boolean z) {
        if (this.iyV != null) {
            this.iyV.setVisibility(z ? 0 : 8);
        }
    }

    public void px(boolean z) {
        this.iyW = z;
    }

    public void vb(int i) {
        if (this.iyT != null && this.iyT.eLr != null) {
            this.mStType = m.bnE();
            if (i == 1) {
                this.hpe.setVisibility(8);
                this.hpQ.setStType(this.mStType);
                this.hpQ.setData(this.iyT.eLr);
                this.hpd.kf(false);
                return;
            }
            this.hpe.setData(this.iyT.eLr);
            this.hpe.setStType(this.mStType);
            this.hpQ.setVisibility(8);
            this.hpd.kf(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }

    public int sY(int i) {
        return com.baidu.tieba.a.d.bKY().aB(this.ajx, i);
    }
}
