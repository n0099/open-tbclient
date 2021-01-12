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
/* loaded from: classes7.dex */
public class n extends b<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private static final int ahh = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private TextView ahj;
    private String air;
    private boolean akY;
    private final View.OnClickListener akt;
    public PlayVoiceBntNew alm;
    protected LinearLayout gln;
    public ThreadUserInfoLayout hiS;
    public ThreadCommentAndPraiseInfoLayout hiT;
    public ThreadSourceShareAndPraiseLayout hjF;
    private NEGFeedBackView hje;
    private ThreadGodReplyLayout iqT;
    private HeadPendantClickableView iqU;
    private View irr;
    private com.baidu.tieba.card.data.k irs;
    private ConstrainImageGroup irt;
    private View iru;
    private boolean irv;
    private RelativeLayout irw;
    private ThreadForumEnterButton irx;
    private View.OnClickListener iry;
    private final View.OnClickListener irz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hje = null;
        this.mSkinType = 3;
        this.akY = true;
        this.irv = true;
        this.iry = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.irs != null) {
                    n.this.irs.objType = 1;
                }
                if (n.this.cqL() != null) {
                    n.this.cqL().a(view, n.this.irs);
                }
                n.this.pl(view == n.this.iqT);
            }
        };
        this.irz = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tieba.card.data.k> cqL = n.this.cqL();
                if (cqL != null) {
                    view.setTag("2");
                    cqL.a(view, n.this.irs);
                }
            }
        };
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.irs == null) {
                    if (n.this.cqL() != null) {
                        n.this.cqL().a(view, n.this.irs);
                        return;
                    }
                    return;
                }
                if (view == n.this.hiS.getUserName()) {
                    n.this.irs.objType = 3;
                } else if (view == n.this.hiS.getHeaderImg()) {
                    n.this.irs.objType = 4;
                } else if (view == n.this.irt) {
                    n.this.irs.objType = 2;
                    return;
                } else {
                    n.this.irs.objType = 1;
                }
                if (n.this.cqL() != null) {
                    n.this.cqL().a(view, n.this.irs);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.iqU = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.iqU.getHeadView() != null) {
            this.iqU.getHeadView().setIsRound(true);
            this.iqU.getHeadView().setDrawBorder(false);
            this.iqU.getHeadView().setDefaultResource(17170445);
            this.iqU.getHeadView().setPlaceHolder(1);
            this.iqU.getHeadView().setRadius(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.iqU.setHasPendantStyle();
        if (this.iqU.getPendantView() != null) {
            this.iqU.getPendantView().setIsRound(true);
            this.iqU.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.alm = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.alm.setAfterClickListener(this.irz);
        this.ahj = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.irt = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.iru = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.irt.setChildClickListener(this.iry);
        this.irt.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.r(1.0d);
        this.irt.setImageProcessor(fVar);
        this.irr = view.findViewById(R.id.divider_line_above_praise);
        this.hiT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.hiS = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.hje = new NEGFeedBackView(this.mPageContext);
        this.irw = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.hje.a(this.irw, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds120), 0);
        if (this.hiT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hiT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.hiT.setLayoutParams(layoutParams);
        }
        this.hiT.setOnClickListener(this.iry);
        this.hiT.setReplyTimeVisible(false);
        this.hiT.setShowPraiseNum(true);
        this.hiT.setNeedAddPraiseIcon(true);
        this.hiT.setNeedAddReplyIcon(true);
        this.hiT.setShareVisible(true);
        this.hiT.setFrom(1);
        this.hiT.setShareReportFrom(3);
        this.hiT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cqL() != null) {
                    n.this.cqL().a(view2, n.this.irs);
                }
                if (n.this.irs != null && n.this.irs.eHK != null) {
                    m.Ic(n.this.irs.eHK.getId());
                    if (!n.this.cqU()) {
                        m.a(n.this.mTitle, n.this.irs.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.ahj, n.this.irs.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.iqT.getGodReplyContent(), n.this.irs.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.gln = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.iqT = (ThreadGodReplyLayout) view.findViewById(R.id.card_home_page_god_reply_layout);
        this.iqT.setOnClickListener(this.iry);
        this.hjF = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        this.hjF.fjb.setOnClickListener(this.iry);
        this.hjF.setFrom(1);
        this.hjF.setShareReportFrom(3);
        this.hjF.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.cqL() != null) {
                    n.this.cqL().a(view2, n.this.irs);
                }
                if (n.this.irs != null && n.this.irs.eHK != null && view2 != n.this.hjF.fio) {
                    m.Ic(n.this.irs.eHK.getId());
                    if (!n.this.cqU()) {
                        m.a(n.this.mTitle, n.this.irs.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.ahj, n.this.irs.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                        m.a(n.this.iqT.getGodReplyContent(), n.this.irs.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    }
                }
            }
        });
        this.irx = (ThreadForumEnterButton) view.findViewById(R.id.card_home_page_forum_enter_button);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.irt != null) {
            this.irt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.irt != null) {
            this.irt.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.irr, R.color.transparent);
            this.irt.onChangeSkinType();
            this.hiT.onChangeSkinType();
            this.iqT.onChangeSkinType();
            this.hiS.onChangeSkinType();
            if (this.hje != null) {
                this.hje.onChangeSkinType();
            }
            ao.setBackgroundColor(this.iru, R.color.CAM_X0204);
            if (this.hjF != null) {
                this.hjF.onChangeSkinType();
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
        if (kVar == null || kVar.bkV() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.irs = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.iry);
        }
        if (this.hje != null) {
            if (this.irs.feedBackReasonMap != null && this.irs.feedBackReasonMap.size() > 0) {
                at atVar = new at();
                atVar.setTid(this.irs.bkV().getTid());
                atVar.setFid(this.irs.bkV().getFid());
                atVar.setNid(this.irs.bkV().blV());
                atVar.setFeedBackReasonMap(this.irs.feedBackReasonMap);
                this.hje.setData(atVar);
                this.hje.setFirstRowSingleColumn(true);
                if (kVar.eHK.bnx() != null && !StringUtils.isNull(kVar.eHK.bnx().getUserId())) {
                    if (kVar.eHK.bnx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.hje.setVisibility(8);
                    } else if (this.hje != null) {
                        this.hje.setVisibility(this.irv ? 0 : 8);
                    }
                }
            } else {
                this.hje.setVisibility(8);
            }
        }
        this.hiS.setData(kVar.eHK);
        this.iqT.setFromCDN(this.akY);
        this.iqT.setData(kVar.eHK.bpd());
        if (!cqU() && m.Id(this.irs.eHK.getId())) {
            m.a(this.mTitle, this.irs.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.ahj, this.irs.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            m.a(this.iqT.getGodReplyContent(), this.irs.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        this.hiS.setUserAfterClickListener(this.akt);
        final bz bkV = kVar.bkV();
        if (this.hiS.getHeaderImg() != null) {
            if (this.hiS.getIsSimpleThread()) {
                this.hiS.getHeaderImg().setVisibility(8);
                this.iqU.setVisibility(8);
            } else if (bkV.bnx() == null || bkV.bnx().getPendantData() == null || StringUtils.isNull(bkV.bnx().getPendantData().getImgUrl())) {
                this.iqU.setVisibility(8);
                this.hiS.getHeaderImg().setVisibility(0);
                this.hiS.getHeaderImg().setData(bkV);
            } else {
                this.hiS.getHeaderImg().setVisibility(4);
                this.iqU.setVisibility(0);
                this.iqU.setData(bkV);
            }
        }
        ay.a(this.mTitle, bkV);
        ay.a(this.ahj, this.mTitle, bkV, ahh);
        ArrayList<VoiceData.VoiceModel> bnK = kVar.eHK.bnK();
        if (com.baidu.tbadk.core.util.x.isEmpty(bnK)) {
            this.alm.setVisibility(8);
            z = false;
        } else {
            this.alm.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bnK.get(0);
            this.alm.setVoiceModel(voiceModel);
            this.alm.setTag(voiceModel);
            this.alm.btU();
            if (voiceModel != null) {
                this.alm.CY(voiceModel.voice_status.intValue());
            }
            this.alm.cbz();
            z = true;
        }
        if (this.irs.ivn && z) {
            this.irt.setVisibility(8);
        } else {
            ArrayList<MediaData> bnG = bkV.bnG();
            if (com.baidu.tbadk.core.k.bkB().isShowImages() && com.baidu.tbadk.core.util.x.getCount(bnG) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < bnG.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(bnG, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.x.getCount(linkedList) > 0) {
                    this.irt.setVisibility(0);
                    this.irt.setFromCDN(this.akY);
                    this.irt.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            aa<com.baidu.tieba.card.data.k> cqL = n.this.cqL();
                            if (cqL != null) {
                                view.setTag("1");
                                if (n.this.akt != null) {
                                    n.this.akt.onClick(n.this.irt);
                                }
                                cqL.a(view, n.this.irs);
                            }
                            if (z2) {
                                n.this.byS();
                            } else {
                                n.this.a(view, linkedList, i2, bkV);
                            }
                        }
                    });
                    this.irt.setImageMediaList(linkedList);
                } else {
                    this.irt.setVisibility(8);
                }
            } else {
                this.irt.setVisibility(8);
            }
        }
        crc();
        crd();
        setPageUniqueId(getTag());
        this.irx.setVisibility(8);
        uP(sR(1));
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void crc() {
        if (this.irr != null && this.irt != null && this.iqT != null) {
            if (this.irt.getVisibility() == 8 && this.iqT.getVisibility() == 8) {
                this.irr.setVisibility(0);
            } else {
                this.irr.setVisibility(8);
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
                    imageUrlData.urlType = this.akY ? 13 : 14;
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
        aVar.s(arrayList).mN(i).zs(bzVar.bnB()).zt(String.valueOf(bzVar.getFid())).zu(bzVar.getTid()).je(this.akY).zv(arrayList.size() > 0 ? arrayList.get(0) : "").jf(true).d(concurrentHashMap).jg(true).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eQ = aVar.eQ(this.mPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            eQ.getIntent().putExtra("from", "index");
        } else {
            eQ.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bzVar.getId();
        historyMessage.threadName = bzVar.getTitle();
        historyMessage.forumName = bzVar.bnB();
        historyMessage.postID = bzVar.bnN();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void crd() {
        if (!this.irs.fAA) {
            this.alm.setClickable(false);
        } else {
            this.alm.setClickable(true);
        }
        int childCount = this.irt.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.irt.getChildAt(i);
            if (childAt != null) {
                if (!this.irs.fAA) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.irt != null) {
            this.irt.setPageUniqueId(bdUniqueId);
        }
        if (this.hje != null) {
            this.hje.setUniqueId(bdUniqueId);
        }
        if (this.hiS != null) {
            this.hiS.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byS() {
        pl(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl(boolean z) {
        if (this.irs != null && this.irs.eHK != null) {
            if (!cqU()) {
                m.Ic(this.irs.eHK.getId());
                m.a(this.mTitle, this.irs.bkV().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.ahj, this.irs.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                m.a(this.iqT.getGodReplyContent(), this.irs.eHK.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.irs.eHK, null, m.bnj(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(this.irs.bkY());
            addLocateParam.setForumId(String.valueOf(this.irs.eHK.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.irs.eHK.bnB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            m.Ic(this.irs.bkV().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqU() {
        return this.irs.ivn && !this.irs.fAA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void pm(boolean z) {
        if (this.iru != null) {
            this.iru.setVisibility(z ? 0 : 8);
        }
    }

    public void pn(boolean z) {
        this.irv = z;
    }

    public void uP(int i) {
        if (this.irs != null && this.irs.eHK != null) {
            this.mStType = m.bnj();
            if (i == 1) {
                this.hiT.setVisibility(8);
                this.hjF.setStType(this.mStType);
                this.hjF.setData(this.irs.eHK);
                this.hiS.kc(false);
                return;
            }
            this.hiT.setData(this.irs.eHK);
            this.hiT.setStType(this.mStType);
            this.hjF.setVisibility(8);
            this.hiS.kc(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.air = str;
    }

    public int sR(int i) {
        return com.baidu.tieba.a.d.bKv().az(this.air, i);
    }
}
