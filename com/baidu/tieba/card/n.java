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
    protected LinearLayout goh;
    private NEGFeedBackView hnF;
    public ThreadUserInfoLayout hnt;
    public ThreadCommentAndPraiseInfoLayout hnu;
    public ThreadSourceShareAndPraiseLayout hog;
    private ThreadGodReplyLayout iwL;
    private HeadPendantClickableView iwM;
    private View ixj;
    private com.baidu.tieba.card.data.k ixk;
    private ConstrainImageGroup ixl;
    private View ixm;
    private boolean ixn;
    private RelativeLayout ixo;
    private ThreadForumEnterButton ixp;
    private View.OnClickListener ixq;
    private final View.OnClickListener ixr;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hnF = null;
        this.mSkinType = 3;
        this.akO = true;
        this.ixn = true;
        this.ixq = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.ixk != null) {
                    n.this.ixk.objType = 1;
                }
                if (n.this.csc() != null) {
                    n.this.csc().a(view, n.this.ixk);
                }
                n.this.pv(view == n.this.iwL);
            }
        };
        this.ixr = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.card.data.k> csc = n.this.csc();
                if (csc != null) {
                    view.setTag("2");
                    csc.a(view, n.this.ixk);
                }
            }
        };
        this.aki = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.ixk == null) {
                    if (n.this.csc() != null) {
                        n.this.csc().a(view, n.this.ixk);
                        return;
                    }
                    return;
                }
                if (view == n.this.hnt.getUserName()) {
                    n.this.ixk.objType = 3;
                } else if (view == n.this.hnt.getHeaderImg()) {
                    n.this.ixk.objType = 4;
                } else if (view == n.this.ixl) {
                    n.this.ixk.objType = 2;
                    return;
                } else {
                    n.this.ixk.objType = 1;
                }
                if (n.this.csc() != null) {
                    n.this.csc().a(view, n.this.ixk);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iwM = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.iwM.getHeadView() != null) {
            this.iwM.getHeadView().setIsRound(true);
            this.iwM.getHeadView().setDrawBorder(false);
            this.iwM.getHeadView().setDefaultResource(17170445);
            this.iwM.getHeadView().setPlaceHolder(1);
            this.iwM.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.iwM.setHasPendantStyle();
        if (this.iwM.getPendantView() != null) {
            this.iwM.getPendantView().setIsRound(true);
            this.iwM.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.alb = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.alb.setAfterClickListener(this.ixr);
        this.agY = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.ixl = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.ixm = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.ixl.setChildClickListener(this.ixq);
        this.ixl.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.r(1.0d);
        this.ixl.setImageProcessor(fVar);
        this.ixj = view.findViewById(R.id.divider_line_above_praise);
        this.hnu = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hnt = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hnF = new NEGFeedBackView(this.mPageContext);
        this.ixo = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hnF.a(this.ixo, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.hnu.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnu.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hnu.setLayoutParams(layoutParams);
        }
        this.hnu.setOnClickListener(this.ixq);
        this.hnu.setReplyTimeVisible(false);
        this.hnu.setShowPraiseNum(true);
        this.hnu.setNeedAddPraiseIcon(true);
        this.hnu.setNeedAddReplyIcon(true);
        this.hnu.setShareVisible(true);
        this.hnu.setFrom(1);
        this.hnu.setShareReportFrom(3);
        this.hnu.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.csc() != null) {
                    n.this.csc().a(view2, n.this.ixk);
                }
                if (n.this.ixk != null && n.this.ixk.eJQ != null) {
                    m.IN(n.this.ixk.eJQ.getId());
                    if (!n.this.csl()) {
                        m.a(n.this.mTitle, n.this.ixk.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.agY, n.this.ixk.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.iwL.getGodReplyContent(), n.this.ixk.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.goh = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.iwL = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.iwL.setOnClickListener(this.ixq);
        this.hog = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.hog.fls.setOnClickListener(this.ixq);
        this.hog.setFrom(1);
        this.hog.setShareReportFrom(3);
        this.hog.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.csc() != null) {
                    n.this.csc().a(view2, n.this.ixk);
                }
                if (n.this.ixk != null && n.this.ixk.eJQ != null && view2 != n.this.hog.fkH) {
                    m.IN(n.this.ixk.eJQ.getId());
                    if (!n.this.csl()) {
                        m.a(n.this.mTitle, n.this.ixk.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.agY, n.this.ixk.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.iwL.getGodReplyContent(), n.this.ixk.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.ixp = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ixl != null) {
            this.ixl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ixl != null) {
            this.ixl.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.ixj, R.color.transparent);
            this.ixl.onChangeSkinType();
            this.hnu.onChangeSkinType();
            this.iwL.onChangeSkinType();
            this.hnt.onChangeSkinType();
            if (this.hnF != null) {
                this.hnF.onChangeSkinType();
            }
            ap.setBackgroundColor(this.ixm, R.color.CAM_X0204);
            if (this.hog != null) {
                this.hog.onChangeSkinType();
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
        this.ixk = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ixq);
        }
        if (this.hnF != null) {
            if (this.ixk.feedBackReasonMap != null && this.ixk.feedBackReasonMap.size() > 0) {
                av avVar = new av();
                avVar.setTid(this.ixk.bln().getTid());
                avVar.setFid(this.ixk.bln().getFid());
                avVar.setNid(this.ixk.bln().bmo());
                avVar.setFeedBackReasonMap(this.ixk.feedBackReasonMap);
                this.hnF.setData(avVar);
                this.hnF.setFirstRowSingleColumn(true);
                if (kVar.eJQ.bnQ() != null && !StringUtils.isNull(kVar.eJQ.bnQ().getUserId())) {
                    if (kVar.eJQ.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.hnF.setVisibility(8);
                    } else if (this.hnF != null) {
                        this.hnF.setVisibility(this.ixn ? 0 : 8);
                    }
                }
            } else {
                this.hnF.setVisibility(8);
            }
        }
        this.hnt.setData(kVar.eJQ);
        this.iwL.setFromCDN(this.akO);
        this.iwL.setData(kVar.eJQ.bpv());
        if (!csl() && m.IO(this.ixk.eJQ.getId())) {
            m.a(this.mTitle, this.ixk.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.agY, this.ixk.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.iwL.getGodReplyContent(), this.ixk.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        this.hnt.setUserAfterClickListener(this.aki);
        final cb bln = kVar.bln();
        if (this.hnt.getHeaderImg() != null) {
            if (this.hnt.getIsSimpleThread()) {
                this.hnt.getHeaderImg().setVisibility(8);
                this.iwM.setVisibility(8);
            } else if (bln.bnQ() == null || bln.bnQ().getPendantData() == null || StringUtils.isNull(bln.bnQ().getPendantData().getImgUrl())) {
                this.iwM.setVisibility(8);
                this.hnt.getHeaderImg().setVisibility(0);
                this.hnt.getHeaderImg().setData(bln);
            } else {
                this.hnt.getHeaderImg().setVisibility(4);
                this.iwM.setVisibility(0);
                this.iwM.setData(bln);
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
            this.alb.ccB();
            z = true;
        }
        if (this.ixk.iBl && z) {
            this.ixl.setVisibility(8);
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
                    this.ixl.setVisibility(0);
                    this.ixl.setFromCDN(this.akO);
                    this.ixl.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.k> csc = n.this.csc();
                            if (csc != null) {
                                view.setTag("1");
                                if (n.this.aki != null) {
                                    n.this.aki.onClick(n.this.ixl);
                                }
                                csc.a(view, n.this.ixk);
                            }
                            if (z2) {
                                n.this.bzk();
                            } else {
                                n.this.a(view, linkedList, i2, bln);
                            }
                        }
                    });
                    this.ixl.setImageMediaList(linkedList);
                } else {
                    this.ixl.setVisibility(8);
                }
            } else {
                this.ixl.setVisibility(8);
            }
        }
        cst();
        csu();
        setPageUniqueId(getTag());
        this.ixp.setVisibility(8);
        uZ(sW(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cst() {
        if (this.ixj != null && this.ixl != null && this.iwL != null) {
            if (this.ixl.getVisibility() == 8 && this.iwL.getVisibility() == 8) {
                this.ixj.setVisibility(0);
            } else {
                this.ixj.setVisibility(8);
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

    private void csu() {
        if (!this.ixk.fCP) {
            this.alb.setClickable(false);
        } else {
            this.alb.setClickable(true);
        }
        int childCount = this.ixl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ixl.getChildAt(i);
            if (childAt != null) {
                if (!this.ixk.fCP) {
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
        if (this.ixl != null) {
            this.ixl.setPageUniqueId(bdUniqueId);
        }
        if (this.hnF != null) {
            this.hnF.setUniqueId(bdUniqueId);
        }
        if (this.hnt != null) {
            this.hnt.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzk() {
        pv(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pv(boolean z) {
        if (this.ixk != null && this.ixk.eJQ != null) {
            if (!csl()) {
                m.IN(this.ixk.eJQ.getId());
                m.a(this.mTitle, this.ixk.bln().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.agY, this.ixk.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.iwL.getGodReplyContent(), this.ixk.eJQ.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ixk.eJQ, null, m.bnC(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.ixk.blq());
            addLocateParam.setForumId(String.valueOf(this.ixk.eJQ.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.ixk.eJQ.bnU());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.IN(this.ixk.bln().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csl() {
        return this.ixk.iBl && !this.ixk.fCP;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void pw(boolean z) {
        if (this.ixm != null) {
            this.ixm.setVisibility(z ? 0 : 8);
        }
    }

    public void px(boolean z) {
        this.ixn = z;
    }

    public void uZ(int i) {
        if (this.ixk != null && this.ixk.eJQ != null) {
            this.mStType = m.bnC();
            if (i == 1) {
                this.hnu.setVisibility(8);
                this.hog.setStType(this.mStType);
                this.hog.setData(this.ixk.eJQ);
                this.hnt.kf(false);
                return;
            }
            this.hnu.setData(this.ixk.eJQ);
            this.hnu.setStType(this.mStType);
            this.hog.setVisibility(8);
            this.hnt.kf(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    public int sW(int i) {
        return com.baidu.tieba.a.d.bKU().aB(this.aif, i);
    }
}
