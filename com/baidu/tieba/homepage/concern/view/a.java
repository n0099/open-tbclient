package com.baidu.tieba.homepage.concern.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.a<k> implements e {
    private TextView KA;
    private String LC;
    private boolean NK;
    public PlayVoiceBntNew NZ;
    private final View.OnClickListener Nx;
    private final View.OnClickListener dik;
    public ThreadCommentAndPraiseInfoLayout eNX;
    public ThreadSourceShareAndPraiseLayout eOJ;
    protected LinearLayout ehj;
    private k fKJ;
    private ConstrainImageGroup fKK;
    private View fKL;
    private View.OnClickListener fKP;
    private final View.OnClickListener fKQ;
    private HeadPendantClickableView fKk;
    public ConcernThreadUserInfoLayout gZL;
    public ConcernForumThreadUserInfoLayout gZM;
    public com.baidu.tbadk.core.view.c gZN;
    private View gZO;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.NK = true;
        this.fKP = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buM() != null) {
                    a.this.buM().a(view, a.this.fKJ);
                }
                a.this.aMD();
            }
        };
        this.fKQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<k> buM = a.this.buM();
                if (buM != null) {
                    view.setTag("2");
                    buM.a(view, a.this.fKJ);
                }
            }
        };
        this.Nx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buM() != null) {
                    a.this.buM().a(view, a.this.fKJ);
                }
            }
        };
        this.dik = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buM() != null) {
                    a.this.buM().a(view, a.this.fKJ);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.fKk = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.fKk.getHeadView() != null) {
            this.fKk.getHeadView().setIsRound(true);
            this.fKk.getHeadView().setDrawBorder(false);
            this.fKk.getHeadView().setDefaultResource(17170445);
            this.fKk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fKk.getHeadView().setPlaceHolder(1);
            this.fKk.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.fKk.getPendantView() != null) {
            this.fKk.getPendantView().setIsRound(true);
            this.fKk.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.NZ = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.NZ.setAfterClickListener(this.fKQ);
        this.KA = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.KA.setVisibility(8);
        this.fKK = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.fKL = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.fKK.setChildClickListener(this.fKP);
        this.fKK.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fKK.setImageProcessor(fVar);
        this.eNX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.eNX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNX.setLayoutParams(layoutParams);
        }
        this.eNX.setOnClickListener(this.fKP);
        this.eNX.setReplyTimeVisible(false);
        this.eNX.setIsBarViewVisible(false);
        this.eNX.setShowPraiseNum(true);
        this.eNX.setNeedAddPraiseIcon(true);
        this.eNX.setNeedAddReplyIcon(true);
        this.eNX.setShareVisible(true);
        this.eNX.setShareReportFrom(4);
        this.eNX.setFrom(9);
        this.eNX.dih = this.currentPageType;
        this.eNX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.buM() != null) {
                    a.this.buM().a(view2, a.this.fKJ);
                }
                if (a.this.fKJ != null && a.this.fKJ.cRt != null) {
                    com.baidu.tieba.card.l.zV(a.this.fKJ.cRt.getId());
                    a.this.bNE();
                }
            }
        });
        this.eOJ = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.eOJ.djh.setOnClickListener(this.fKP);
        this.eOJ.setShareReportFrom(4);
        this.eOJ.setFrom(9);
        this.eOJ.djh.dih = this.currentPageType;
        this.eOJ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.buM() != null) {
                    a.this.buM().a(view2, a.this.fKJ);
                }
                if (a.this.fKJ != null && a.this.fKJ.cRt != null && view2 != a.this.eOJ.diw) {
                    com.baidu.tieba.card.l.zV(a.this.fKJ.cRt.getId());
                    a.this.bNE();
                }
            }
        });
        this.ehj = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gZO = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.fKK != null) {
            this.fKK.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fKK != null) {
            this.fKK.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fKK != null) {
            this.fKK.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.fKK.onChangeSkinType();
            this.eNX.onChangeSkinType();
            am.setBackgroundColor(this.fKL, R.color.cp_bg_line_c);
            this.eOJ.onChangeSkinType();
        }
        if (this.gZL != null && this.gZL.getVisibility() == 0) {
            this.gZL.onChangeSkinType(i);
        }
        if (this.gZM != null && this.gZM.getVisibility() == 0) {
            this.gZM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNE() {
        if (this.fKJ != null && this.fKJ.cRt.getId() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.fKJ.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.KA, this.fKJ.cRt.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bNF() {
        if (this.gZL == null) {
            this.gZL = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bNG() {
        if (this.gZM == null) {
            this.gZM = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.gZM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buM() != null) {
                    a.this.buM().a(view, a.this.fKJ);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.cRt == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.fKJ = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fKP);
        }
        if (kVar.bvB()) {
            bNG();
            this.gZN = this.gZM;
            this.gZM.setVisibility(0);
            if (this.gZL != null) {
                this.gZL.setVisibility(8);
            }
        } else {
            bNF();
            this.gZN = this.gZL;
            this.gZL.setVisibility(0);
            if (this.gZM != null) {
                this.gZM.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!buX() && com.baidu.tieba.card.l.zW(this.fKJ.cRt.getId())) {
            bNE();
        }
        final bj aAj = kVar.aAj();
        if (this.gZN.getHeaderImg() != null) {
            if (this.gZN.getIsSimpleThread()) {
                this.gZN.getHeaderImg().setVisibility(8);
                this.fKk.setVisibility(8);
            } else if (aAj.aCr() == null || aAj.aCr().getPendantData() == null || StringUtils.isNull(aAj.aCr().getPendantData().aAJ())) {
                this.fKk.setVisibility(8);
                this.gZN.getHeaderImg().setVisibility(0);
                this.gZN.getHeaderImg().setData(aAj, !kVar.bvB());
            } else {
                this.gZN.getHeaderImg().setVisibility(4);
                this.fKk.setVisibility(0);
                this.fKk.setData(aAj);
            }
        }
        this.gZN.setData(kVar.cRt);
        this.gZN.setUserAfterClickListener(this.Nx);
        ar(aAj);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aCF = kVar.cRt.aCF();
        if (v.isEmpty(aCF)) {
            this.NZ.setVisibility(8);
            ks(false);
            z = false;
        } else {
            this.NZ.setVisibility(0);
            ks(true);
            VoiceData.VoiceModel voiceModel = aCF.get(0);
            this.NZ.setVoiceModel(voiceModel);
            this.NZ.setTag(voiceModel);
            this.NZ.can();
            if (voiceModel != null) {
                this.NZ.xe(voiceModel.voice_status.intValue());
            }
            this.NZ.cMC();
            z = true;
        }
        if (this.fKJ.fOi && z) {
            this.fKK.setVisibility(8);
            this.gZO.setVisibility(0);
        } else {
            ArrayList<MediaData> aCB = kVar.cRt.aCB();
            if (i.azR().isShowImages() && v.getCount(aCB) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aCB.size(); i++) {
                    MediaData mediaData = (MediaData) v.getItem(aCB, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.getCount(linkedList) > 0) {
                    this.fKK.setVisibility(0);
                    this.gZO.setVisibility(8);
                    this.fKK.setFromCDN(this.NK);
                    this.fKK.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            z<k> buM = a.this.buM();
                            if (buM != null) {
                                view.setTag("1");
                                buM.a(view, a.this.fKJ);
                            }
                            if (z2) {
                                a.this.aMD();
                            } else {
                                a.this.a(view, linkedList, i2, aAj);
                            }
                        }
                    });
                    this.fKK.setImageMediaList(linkedList);
                } else {
                    this.fKK.setVisibility(8);
                    this.gZO.setVisibility(0);
                }
            } else {
                this.fKK.setVisibility(8);
                this.gZO.setVisibility(0);
            }
        }
        bvg();
        setPageUniqueId(getTag());
        bHH();
        pD(oe(1));
    }

    private void ks(boolean z) {
        if (this.fKK != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKK.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.fKK.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.NK ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCw(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NK, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bjVar.getId();
        historyMessage.threadName = bjVar.getTitle();
        historyMessage.forumName = bjVar.aCw();
        historyMessage.postID = bjVar.aCH();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void bvg() {
        if (!this.fKJ.dyu) {
            this.NZ.setClickable(false);
        } else {
            this.NZ.setClickable(true);
        }
        int childCount = this.fKK.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fKK.getChildAt(i);
            if (childAt != null) {
                if (!this.fKJ.dyu) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fKK != null) {
            this.fKK.setPageUniqueId(bdUniqueId);
        }
        if (this.gZN != null) {
            this.gZN.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMD() {
        if (this.fKJ != null && this.fKJ.cRt != null) {
            if (!buX()) {
                com.baidu.tieba.card.l.zV(this.fKJ.cRt.getId());
                com.baidu.tieba.card.l.a(this.mTitle, this.fKJ.aAj().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                com.baidu.tieba.card.l.a(this.KA, this.fKJ.cRt.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.fKJ.cRt, null, com.baidu.tieba.card.l.aCd(), RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.fKJ.cRt.getFid()));
            createFromThreadCfg.setForumName(this.fKJ.cRt.aCw());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setThreadData(this.fKJ.cRt);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean buX() {
        return this.fKJ.fOi && !this.fKJ.dyu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean ar(bj bjVar) {
        SpannableStringBuilder v = bjVar.v(false, true);
        if (v == null || StringUtils.isNull(v.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new h(v));
            this.mTitle.setText(v);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.cRt == null || kVar.bvB()) {
            this.KA.setVisibility(8);
            return;
        }
        bj bjVar = kVar.cRt;
        if (oe(2) == 1) {
            SpannableString aDj = bjVar.aDj();
            if (aDj != null && !aq.isEmpty(aDj.toString())) {
                this.KA.setVisibility(0);
                this.KA.setOnTouchListener(new h(aDj));
                this.KA.setText(aDj);
                com.baidu.tieba.card.l.a(this.KA, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.KA.setVisibility(8);
            return;
        }
        this.KA.setVisibility(8);
    }

    private void bHH() {
        if (this.mTitle != null && this.NZ != null && this.fKK != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.NZ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.NZ.setLayoutParams(layoutParams);
            if (this.NZ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fKK.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.fKK.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pD(int i) {
        if (this.fKJ != null && this.fKJ.cRt != null) {
            if (!this.fKJ.bvB() && i == 1) {
                this.eNX.setVisibility(8);
                this.eOJ.setStType(com.baidu.tieba.card.l.aCd());
                this.eOJ.setData(this.fKJ.cRt);
                this.gZN.fS(false);
                return;
            }
            this.eNX.setData(this.fKJ.cRt);
            this.eNX.setStType(com.baidu.tieba.card.l.aCd());
            this.eOJ.setVisibility(8);
            this.gZN.fS(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oe(int i) {
        return com.baidu.tieba.a.d.aXK().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fKK != null) {
            this.fKK.setPreloadSizeReadyCallback(bVar);
        }
    }
}
