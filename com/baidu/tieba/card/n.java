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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aw;
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
    private static final int aey = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private TextView aeA;
    private String afG;
    private final View.OnClickListener ahM;
    private boolean aik;
    public PlayVoiceBntNew aiw;
    public ThreadUserInfoLayout fRH;
    public ThreadCommentAndPraiseInfoLayout fRI;
    private NEGFeedBackView fRT;
    public ThreadSourceShareAndPraiseLayout fSu;
    protected LinearLayout fdX;
    private ThreadGodReplyLayout gQM;
    private HeadPendantClickableView gQN;
    private View gRl;
    private com.baidu.tieba.card.data.k gRm;
    private ConstrainImageGroup gRn;
    private View gRo;
    private boolean gRp;
    private RelativeLayout gRq;
    private ThreadForumEnterButton gRr;
    private View.OnClickListener gRs;
    private final View.OnClickListener gRt;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fRT = null;
        this.mSkinType = 3;
        this.aik = true;
        this.gRp = true;
        this.gRs = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.gRm != null) {
                    n.this.gRm.objType = 1;
                }
                if (n.this.bOc() != null) {
                    n.this.bOc().a(view, n.this.gRm);
                }
                n.this.lW(view == n.this.gQM);
            }
        };
        this.gRt = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tieba.card.data.k> bOc = n.this.bOc();
                if (bOc != null) {
                    view.setTag("2");
                    bOc.a(view, n.this.gRm);
                }
            }
        };
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.gRm == null) {
                    if (n.this.bOc() != null) {
                        n.this.bOc().a(view, n.this.gRm);
                        return;
                    }
                    return;
                }
                if (view == n.this.fRH.getUserName()) {
                    n.this.gRm.objType = 3;
                } else if (view == n.this.fRH.getHeaderImg()) {
                    n.this.gRm.objType = 4;
                } else if (view == n.this.gRn) {
                    n.this.gRm.objType = 2;
                    return;
                } else {
                    n.this.gRm.objType = 1;
                }
                if (n.this.bOc() != null) {
                    n.this.bOc().a(view, n.this.gRm);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.gQN = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.gQN.getHeadView() != null) {
            this.gQN.getHeadView().setIsRound(true);
            this.gQN.getHeadView().setDrawBorder(false);
            this.gQN.getHeadView().setDefaultResource(17170445);
            this.gQN.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gQN.getHeadView().setPlaceHolder(1);
            this.gQN.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.gQN.setHasPendantStyle();
        if (this.gQN.getPendantView() != null) {
            this.gQN.getPendantView().setIsRound(true);
            this.gQN.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.aiw = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.aiw.setAfterClickListener(this.gRt);
        this.aeA = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.gRn = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.gRo = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.gRn.setChildClickListener(this.gRs);
        this.gRn.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.o(1.0d);
        this.gRn.setImageProcessor(fVar);
        this.gRl = view.findViewById(R.id.divider_line_above_praise);
        this.fRI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.fRH = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.fRT = new NEGFeedBackView(this.mPageContext);
        this.gRq = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.fRT.a(this.gRq, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.fRI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fRI.setLayoutParams(layoutParams);
        }
        this.fRI.setOnClickListener(this.gRs);
        this.fRI.setReplyTimeVisible(false);
        this.fRI.setShowPraiseNum(true);
        this.fRI.setNeedAddPraiseIcon(true);
        this.fRI.setNeedAddReplyIcon(true);
        this.fRI.setShareVisible(true);
        this.fRI.setFrom(1);
        this.fRI.setShareReportFrom(3);
        this.fRI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.bOc() != null) {
                    n.this.bOc().a(view2, n.this.gRm);
                }
                if (n.this.gRm != null && n.this.gRm.dLi != null) {
                    m.DO(n.this.gRm.dLi.getId());
                    if (!n.this.bOl()) {
                        m.a(n.this.mTitle, n.this.gRm.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                        m.a(n.this.aeA, n.this.gRm.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                        m.a(n.this.gQM.getGodReplyContent(), n.this.gRm.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    }
                }
            }
        });
        this.fdX = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.gQM = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.gQM.setOnClickListener(this.gRs);
        this.fSu = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.fSu.eeP.setOnClickListener(this.gRs);
        this.fSu.setFrom(1);
        this.fSu.setShareReportFrom(3);
        this.fSu.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.bOc() != null) {
                    n.this.bOc().a(view2, n.this.gRm);
                }
                if (n.this.gRm != null && n.this.gRm.dLi != null && view2 != n.this.fSu.eee) {
                    m.DO(n.this.gRm.dLi.getId());
                    if (!n.this.bOl()) {
                        m.a(n.this.mTitle, n.this.gRm.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                        m.a(n.this.aeA, n.this.gRm.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                        m.a(n.this.gQM.getGodReplyContent(), n.this.gRm.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                    }
                }
            }
        });
        this.gRr = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gRn != null) {
            this.gRn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gRn != null) {
            this.gRn.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            an.setBackgroundColor(this.gRl, R.color.transparent);
            this.gRn.onChangeSkinType();
            this.fRI.onChangeSkinType();
            this.gQM.onChangeSkinType();
            this.fRH.onChangeSkinType();
            if (this.fRT != null) {
                this.fRT.onChangeSkinType();
            }
            an.setBackgroundColor(this.gRo, R.color.cp_bg_line_c);
            if (this.fSu != null) {
                this.fSu.onChangeSkinType();
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
        if (kVar == null || kVar.aPS() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.gRm = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gRs);
        }
        if (this.fRT != null) {
            if (this.gRm.feedBackReasonMap != null && this.gRm.feedBackReasonMap.size() > 0) {
                ap apVar = new ap();
                apVar.setTid(this.gRm.aPS().getTid());
                apVar.setFid(this.gRm.aPS().getFid());
                apVar.setNid(this.gRm.aPS().getNid());
                apVar.setFeedBackReasonMap(this.gRm.feedBackReasonMap);
                this.fRT.setData(apVar);
                this.fRT.setFirstRowSingleColumn(true);
                if (kVar.dLi.aSp() != null && !StringUtils.isNull(kVar.dLi.aSp().getUserId())) {
                    if (kVar.dLi.aSp().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.fRT.setVisibility(8);
                    } else if (this.fRT != null) {
                        this.fRT.setVisibility(this.gRp ? 0 : 8);
                    }
                }
            } else {
                this.fRT.setVisibility(8);
            }
        }
        this.fRH.setData(kVar.dLi);
        this.gQM.setFromCDN(this.aik);
        this.gQM.setData(kVar.dLi.aTS());
        if (!bOl() && m.DP(this.gRm.dLi.getId())) {
            m.a(this.mTitle, this.gRm.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.aeA, this.gRm.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            m.a(this.gQM.getGodReplyContent(), this.gRm.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        this.fRH.setUserAfterClickListener(this.ahM);
        final bu aPS = kVar.aPS();
        if (this.fRH.getHeaderImg() != null) {
            if (this.fRH.getIsSimpleThread()) {
                this.fRH.getHeaderImg().setVisibility(8);
                this.gQN.setVisibility(8);
            } else if (aPS.aSp() == null || aPS.aSp().getPendantData() == null || StringUtils.isNull(aPS.aSp().getPendantData().aQl())) {
                this.gQN.setVisibility(8);
                this.fRH.getHeaderImg().setVisibility(0);
                this.fRH.getHeaderImg().setData(aPS);
            } else {
                this.fRH.getHeaderImg().setVisibility(4);
                this.gQN.setVisibility(0);
                this.gQN.setData(aPS);
            }
        }
        aw.a(this.mTitle, aPS);
        aw.a(this.aeA, this.mTitle, aPS, aey);
        ArrayList<VoiceData.VoiceModel> aSC = kVar.dLi.aSC();
        if (com.baidu.tbadk.core.util.w.isEmpty(aSC)) {
            this.aiw.setVisibility(8);
            z = false;
        } else {
            this.aiw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aSC.get(0);
            this.aiw.setVoiceModel(voiceModel);
            this.aiw.setTag(voiceModel);
            this.aiw.aYi();
            if (voiceModel != null) {
                this.aiw.yU(voiceModel.voice_status.intValue());
            }
            this.aiw.bCn();
            z = true;
        }
        if (this.gRm.gUT && z) {
            this.gRn.setVisibility(8);
        } else {
            ArrayList<MediaData> aSy = aPS.aSy();
            if (com.baidu.tbadk.core.k.aPA().isShowImages() && com.baidu.tbadk.core.util.w.getCount(aSy) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aSy.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.getItem(aSy, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.w.getCount(linkedList) > 0) {
                    this.gRn.setVisibility(0);
                    this.gRn.setFromCDN(this.aik);
                    this.gRn.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            aa<com.baidu.tieba.card.data.k> bOc = n.this.bOc();
                            if (bOc != null) {
                                view.setTag("1");
                                if (n.this.ahM != null) {
                                    n.this.ahM.onClick(n.this.gRn);
                                }
                                bOc.a(view, n.this.gRm);
                            }
                            if (z2) {
                                n.this.bdl();
                            } else {
                                n.this.a(view, linkedList, i2, aPS);
                            }
                        }
                    });
                    this.gRn.setImageMediaList(linkedList);
                } else {
                    this.gRn.setVisibility(8);
                }
            } else {
                this.gRn.setVisibility(8);
            }
        }
        bOt();
        bOu();
        setPageUniqueId(getTag());
        this.gRr.setVisibility(8);
        qZ(pz(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bOt() {
        if (this.gRl != null && this.gRn != null && this.gQM != null) {
            if (this.gRn.getVisibility() == 8 && this.gQM.getVisibility() == 8) {
                this.gRl.setVisibility(0);
            } else {
                this.gRl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bu buVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aik ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(buVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, buVar.aSt(), String.valueOf(buVar.getFid()), buVar.getTid(), this.aik, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", "other");
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = buVar.getId();
        historyMessage.threadName = buVar.getTitle();
        historyMessage.forumName = buVar.aSt();
        historyMessage.postID = buVar.aSG();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void bOu() {
        if (!this.gRm.evf) {
            this.aiw.setClickable(false);
        } else {
            this.aiw.setClickable(true);
        }
        int childCount = this.gRn.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gRn.getChildAt(i);
            if (childAt != null) {
                if (!this.gRm.evf) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gRn != null) {
            this.gRn.setPageUniqueId(bdUniqueId);
        }
        if (this.fRT != null) {
            this.fRT.setUniqueId(bdUniqueId);
        }
        if (this.fRH != null) {
            this.fRH.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdl() {
        lW(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW(boolean z) {
        if (this.gRm != null && this.gRm.dLi != null) {
            if (!bOl()) {
                m.DO(this.gRm.dLi.getId());
                m.a(this.mTitle, this.gRm.aPS().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                m.a(this.aeA, this.gRm.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                m.a(this.gQM.getGodReplyContent(), this.gRm.dLi.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.gRm.dLi, null, m.aSb(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.gRm.aPV());
            addLocateParam.setForumId(String.valueOf(this.gRm.dLi.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.gRm.dLi.aSt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.DO(this.gRm.aPS().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOl() {
        return this.gRm.gUT && !this.gRm.evf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void lX(boolean z) {
        if (this.gRo != null) {
            this.gRo.setVisibility(z ? 0 : 8);
        }
    }

    public void lY(boolean z) {
        this.gRp = z;
    }

    public void qZ(int i) {
        if (this.gRm != null && this.gRm.dLi != null) {
            this.mStType = m.aSb();
            if (i == 1) {
                this.fRI.setVisibility(8);
                this.fSu.setStType(this.mStType);
                this.fSu.setData(this.gRm.dLi);
                this.fRH.hz(false);
                return;
            }
            this.fRI.setData(this.gRm.dLi);
            this.fRI.setStType(this.mStType);
            this.fSu.setVisibility(8);
            this.fRH.hz(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }

    public int pz(int i) {
        return com.baidu.tieba.a.d.boA().as(this.afG, i);
    }
}
