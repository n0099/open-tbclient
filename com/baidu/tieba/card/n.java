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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes8.dex */
public class n extends b<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private static final int ahY = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private TextView aia;
    private String aji;
    private boolean alQ;
    private final View.OnClickListener alk;
    public PlayVoiceBntNew amd;
    protected LinearLayout gpU;
    private NEGFeedBackView hnK;
    public ThreadUserInfoLayout hny;
    public ThreadCommentAndPraiseInfoLayout hnz;
    public ThreadSourceShareAndPraiseLayout hol;
    private ThreadGodReplyLayout ivA;
    private HeadPendantClickableView ivB;
    private View ivY;
    private com.baidu.tieba.card.data.k ivZ;
    private ConstrainImageGroup iwa;
    private View iwb;
    private boolean iwc;
    private RelativeLayout iwd;
    private ThreadForumEnterButton iwe;
    private View.OnClickListener iwf;
    private final View.OnClickListener iwg;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hnK = null;
        this.mSkinType = 3;
        this.alQ = true;
        this.iwc = true;
        this.iwf = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.ivZ != null) {
                    n.this.ivZ.objType = 1;
                }
                if (n.this.cuC() != null) {
                    n.this.cuC().a(view, n.this.ivZ);
                }
                n.this.pp(view == n.this.ivA);
            }
        };
        this.iwg = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tieba.card.data.k> cuC = n.this.cuC();
                if (cuC != null) {
                    view.setTag("2");
                    cuC.a(view, n.this.ivZ);
                }
            }
        };
        this.alk = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.ivZ == null) {
                    if (n.this.cuC() != null) {
                        n.this.cuC().a(view, n.this.ivZ);
                        return;
                    }
                    return;
                }
                if (view == n.this.hny.getUserName()) {
                    n.this.ivZ.objType = 3;
                } else if (view == n.this.hny.getHeaderImg()) {
                    n.this.ivZ.objType = 4;
                } else if (view == n.this.iwa) {
                    n.this.ivZ.objType = 2;
                    return;
                } else {
                    n.this.ivZ.objType = 1;
                }
                if (n.this.cuC() != null) {
                    n.this.cuC().a(view, n.this.ivZ);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.ivB = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.ivB.getHeadView() != null) {
            this.ivB.getHeadView().setIsRound(true);
            this.ivB.getHeadView().setDrawBorder(false);
            this.ivB.getHeadView().setDefaultResource(17170445);
            this.ivB.getHeadView().setPlaceHolder(1);
            this.ivB.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.ivB.setHasPendantStyle();
        if (this.ivB.getPendantView() != null) {
            this.ivB.getPendantView().setIsRound(true);
            this.ivB.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.amd = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.amd.setAfterClickListener(this.iwg);
        this.aia = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.iwa = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.iwb = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.iwa.setChildClickListener(this.iwf);
        this.iwa.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.x(1.0d);
        this.iwa.setImageProcessor(fVar);
        this.ivY = view.findViewById(R.id.divider_line_above_praise);
        this.hnz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hny = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hnK = new NEGFeedBackView(this.mPageContext);
        this.iwd = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hnK.a(this.iwd, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.hnz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hnz.setLayoutParams(layoutParams);
        }
        this.hnz.setOnClickListener(this.iwf);
        this.hnz.setReplyTimeVisible(false);
        this.hnz.setShowPraiseNum(true);
        this.hnz.setNeedAddPraiseIcon(true);
        this.hnz.setNeedAddReplyIcon(true);
        this.hnz.setShareVisible(true);
        this.hnz.setFrom(1);
        this.hnz.setShareReportFrom(3);
        this.hnz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cuC() != null) {
                    n.this.cuC().a(view2, n.this.ivZ);
                }
                if (n.this.ivZ != null && n.this.ivZ.eMv != null) {
                    m.Jo(n.this.ivZ.eMv.getId());
                    if (!n.this.cuL()) {
                        m.a(n.this.mTitle, n.this.ivZ.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.aia, n.this.ivZ.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.ivA.getGodReplyContent(), n.this.ivZ.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.gpU = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.ivA = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.ivA.setOnClickListener(this.iwf);
        this.hol = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.hol.fnK.setOnClickListener(this.iwf);
        this.hol.setFrom(1);
        this.hol.setShareReportFrom(3);
        this.hol.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cuC() != null) {
                    n.this.cuC().a(view2, n.this.ivZ);
                }
                if (n.this.ivZ != null && n.this.ivZ.eMv != null && view2 != n.this.hol.fmZ) {
                    m.Jo(n.this.ivZ.eMv.getId());
                    if (!n.this.cuL()) {
                        m.a(n.this.mTitle, n.this.ivZ.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.aia, n.this.ivZ.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.ivA.getGodReplyContent(), n.this.ivZ.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.iwe = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iwa != null) {
            this.iwa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iwa != null) {
            this.iwa.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.ivY, R.color.transparent);
            this.iwa.onChangeSkinType();
            this.hnz.onChangeSkinType();
            this.ivA.onChangeSkinType();
            this.hny.onChangeSkinType();
            if (this.hnK != null) {
                this.hnK.onChangeSkinType();
            }
            ao.setBackgroundColor(this.iwb, R.color.CAM_X0204);
            if (this.hol != null) {
                this.hol.onChangeSkinType();
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
        if (kVar == null || kVar.boO() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ivZ = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.iwf);
        }
        if (this.hnK != null) {
            if (this.ivZ.feedBackReasonMap != null && this.ivZ.feedBackReasonMap.size() > 0) {
                at atVar = new at();
                atVar.setTid(this.ivZ.boO().getTid());
                atVar.setFid(this.ivZ.boO().getFid());
                atVar.setNid(this.ivZ.boO().bpO());
                atVar.setFeedBackReasonMap(this.ivZ.feedBackReasonMap);
                this.hnK.setData(atVar);
                this.hnK.setFirstRowSingleColumn(true);
                if (kVar.eMv.brq() != null && !StringUtils.isNull(kVar.eMv.brq().getUserId())) {
                    if (kVar.eMv.brq().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.hnK.setVisibility(8);
                    } else if (this.hnK != null) {
                        this.hnK.setVisibility(this.iwc ? 0 : 8);
                    }
                }
            } else {
                this.hnK.setVisibility(8);
            }
        }
        this.hny.setData(kVar.eMv);
        this.ivA.setFromCDN(this.alQ);
        this.ivA.setData(kVar.eMv.bsW());
        if (!cuL() && m.Jp(this.ivZ.eMv.getId())) {
            m.a(this.mTitle, this.ivZ.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.aia, this.ivZ.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.ivA.getGodReplyContent(), this.ivZ.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        this.hny.setUserAfterClickListener(this.alk);
        final bz boO = kVar.boO();
        if (this.hny.getHeaderImg() != null) {
            if (this.hny.getIsSimpleThread()) {
                this.hny.getHeaderImg().setVisibility(8);
                this.ivB.setVisibility(8);
            } else if (boO.brq() == null || boO.brq().getPendantData() == null || StringUtils.isNull(boO.brq().getPendantData().getImgUrl())) {
                this.ivB.setVisibility(8);
                this.hny.getHeaderImg().setVisibility(0);
                this.hny.getHeaderImg().setData(boO);
            } else {
                this.hny.getHeaderImg().setVisibility(4);
                this.ivB.setVisibility(0);
                this.ivB.setData(boO);
            }
        }
        ay.a(this.mTitle, boO);
        ay.a(this.aia, this.mTitle, boO, ahY);
        ArrayList<VoiceData.VoiceModel> brD = kVar.eMv.brD();
        if (com.baidu.tbadk.core.util.x.isEmpty(brD)) {
            this.amd.setVisibility(8);
            z = false;
        } else {
            this.amd.setVisibility(0);
            VoiceData.VoiceModel voiceModel = brD.get(0);
            this.amd.setVoiceModel(voiceModel);
            this.amd.setTag(voiceModel);
            this.amd.bxN();
            if (voiceModel != null) {
                this.amd.EE(voiceModel.voice_status.intValue());
            }
            this.amd.cfq();
            z = true;
        }
        if (this.ivZ.izU && z) {
            this.iwa.setVisibility(8);
        } else {
            ArrayList<MediaData> brz = boO.brz();
            if (com.baidu.tbadk.core.k.bou().isShowImages() && com.baidu.tbadk.core.util.x.getCount(brz) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < brz.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(brz, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.x.getCount(linkedList) > 0) {
                    this.iwa.setVisibility(0);
                    this.iwa.setFromCDN(this.alQ);
                    this.iwa.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            aa<com.baidu.tieba.card.data.k> cuC = n.this.cuC();
                            if (cuC != null) {
                                view.setTag("1");
                                if (n.this.alk != null) {
                                    n.this.alk.onClick(n.this.iwa);
                                }
                                cuC.a(view, n.this.ivZ);
                            }
                            if (z2) {
                                n.this.bCL();
                            } else {
                                n.this.a(view, linkedList, i2, boO);
                            }
                        }
                    });
                    this.iwa.setImageMediaList(linkedList);
                } else {
                    this.iwa.setVisibility(8);
                }
            } else {
                this.iwa.setVisibility(8);
            }
        }
        cuT();
        cuU();
        setPageUniqueId(getTag());
        this.iwe.setVisibility(8);
        wv(ux(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cuT() {
        if (this.ivY != null && this.iwa != null && this.ivA != null) {
            if (this.iwa.getVisibility() == 8 && this.ivA.getVisibility() == 8) {
                this.ivY.setVisibility(0);
            } else {
                this.ivY.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bz bzVar) {
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
                    imageUrlData.urlType = this.alQ ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bzVar.getTid(), -1L);
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
        aVar.x(arrayList).ot(i).AE(bzVar.bru()).AF(String.valueOf(bzVar.getFid())).AG(bzVar.getTid()).ji(this.alQ).AH(arrayList.size() > 0 ? arrayList.get(0) : "").jj(true).d(concurrentHashMap).jk(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eS = aVar.eS(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            eS.getIntent().putExtra("from", "index");
        } else {
            eS.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bzVar.getId();
        historyMessage.threadName = bzVar.getTitle();
        historyMessage.forumName = bzVar.bru();
        historyMessage.postID = bzVar.brG();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void cuU() {
        if (!this.ivZ.fFi) {
            this.amd.setClickable(false);
        } else {
            this.amd.setClickable(true);
        }
        int childCount = this.iwa.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iwa.getChildAt(i);
            if (childAt != null) {
                if (!this.ivZ.fFi) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.iwa != null) {
            this.iwa.setPageUniqueId(bdUniqueId);
        }
        if (this.hnK != null) {
            this.hnK.setUniqueId(bdUniqueId);
        }
        if (this.hny != null) {
            this.hny.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCL() {
        pp(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pp(boolean z) {
        if (this.ivZ != null && this.ivZ.eMv != null) {
            if (!cuL()) {
                m.Jo(this.ivZ.eMv.getId());
                m.a(this.mTitle, this.ivZ.boO().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.aia, this.ivZ.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.ivA.getGodReplyContent(), this.ivZ.eMv.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ivZ.eMv, null, m.brc(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.ivZ.boR());
            addLocateParam.setForumId(String.valueOf(this.ivZ.eMv.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.ivZ.eMv.bru());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.Jo(this.ivZ.boO().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cuL() {
        return this.ivZ.izU && !this.ivZ.fFi;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void pq(boolean z) {
        if (this.iwb != null) {
            this.iwb.setVisibility(z ? 0 : 8);
        }
    }

    public void pr(boolean z) {
        this.iwc = z;
    }

    public void wv(int i) {
        if (this.ivZ != null && this.ivZ.eMv != null) {
            this.mStType = m.brc();
            if (i == 1) {
                this.hnz.setVisibility(8);
                this.hol.setStType(this.mStType);
                this.hol.setData(this.ivZ.eMv);
                this.hny.kg(false);
                return;
            }
            this.hnz.setData(this.ivZ.eMv);
            this.hnz.setStType(this.mStType);
            this.hol.setVisibility(8);
            this.hny.kg(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }

    public int ux(int i) {
        return com.baidu.tieba.a.d.bOm().az(this.aji, i);
    }
}
