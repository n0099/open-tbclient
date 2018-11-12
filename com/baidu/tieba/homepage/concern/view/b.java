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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<k> implements com.baidu.tieba.a.e {
    private boolean aAQ;
    private final View.OnClickListener aEX;
    private final View.OnClickListener aHa;
    private String bWE;
    public ThreadCommentAndPraiseInfoLayout bWR;
    private HeadPendantClickableView bXB;
    public ThreadSourceShareAndPraiseLayout bXE;
    protected LinearLayout bXP;
    private View cLK;
    private k cLL;
    private View.OnClickListener cLM;
    public PlayVoiceBntNew cOq;
    private TextView cOs;
    private ConstrainImageGroup cOt;
    private final View.OnClickListener cOw;
    public ConcernThreadUserInfoLayout ekr;
    public ConcernForumThreadUserInfoLayout ekt;
    public com.baidu.tbadk.core.view.f eku;
    private View ekv;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aAQ = true;
        this.cLM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.anq() != null) {
                    b.this.anq().a(view, b.this.cLL);
                }
                b.this.anK();
            }
        };
        this.cOw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<k> anq = b.this.anq();
                if (anq != null) {
                    view.setTag("2");
                    anq.a(view, b.this.cLL);
                }
            }
        };
        this.aHa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.anq() != null) {
                    b.this.anq().a(view, b.this.cLL);
                }
            }
        };
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.anq() != null) {
                    b.this.anq().a(view, b.this.cLL);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bXB = (HeadPendantClickableView) view.findViewById(e.g.card_concern_normal_thread_user_pendant_header);
        if (this.bXB.getHeadView() != null) {
            this.bXB.getHeadView().setIsRound(true);
            this.bXB.getHeadView().setDrawBorder(false);
            this.bXB.getHeadView().setDefaultResource(17170445);
            this.bXB.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bXB.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bXB.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0200e.ds60));
        }
        if (this.bXB.getPendantView() != null) {
            this.bXB.getPendantView().setIsRound(true);
            this.bXB.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_normal_thread_title);
        this.cOq = (PlayVoiceBntNew) view.findViewById(e.g.card_concern_normal_thread_abstract_voice);
        this.cOq.setAfterClickListener(this.cOw);
        this.cOs = (TextView) view.findViewById(e.g.card_concern_normal_thread_abstract);
        this.cOs.setVisibility(8);
        this.cOt = (ConstrainImageGroup) view.findViewById(e.g.card_concern_normal_thread_img_layout);
        this.cLK = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds16);
        this.cOt.setChildClickListener(this.cLM);
        this.cOt.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cOt.setImageProcessor(eVar);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_normal_thread_info_layout);
        if (this.bWR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWR.setLayoutParams(layoutParams);
        }
        this.bWR.setOnClickListener(this.cLM);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setIsBarViewVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setShareVisible(true);
        this.bWR.setShareReportFrom(4);
        this.bWR.setFrom(9);
        this.bWR.setDisPraiseFrom(4);
        this.bWR.asl = this.currentPageType;
        this.bWR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.anq() != null) {
                    b.this.anq().a(view2, b.this.cLL);
                }
                if (b.this.cLL != null && b.this.cLL.threadData != null) {
                    o.me(b.this.cLL.threadData.getId());
                    b.this.anv();
                }
            }
        });
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_nomal_source_read_share_layout);
        this.bXE.aGI.setOnClickListener(this.cLM);
        this.bXE.setShareReportFrom(4);
        this.bXE.setFrom(9);
        this.bXE.aGI.asl = this.currentPageType;
        this.bXE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.anq() != null) {
                    b.this.anq().a(view2, b.this.cLL);
                }
                if (b.this.cLL != null && b.this.cLL.threadData != null && view2 != b.this.bXE.aGH) {
                    o.me(b.this.cLL.threadData.getId());
                    b.this.anv();
                }
            }
        });
        this.bXP = (LinearLayout) view.findViewById(e.g.card_concern_normal_thread_content_layout);
        this.ekv = view.findViewById(e.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cOt != null) {
            this.cOt.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cOt != null) {
            this.cOt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cOt != null) {
            this.cOt.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.cOt.onChangeSkinType();
            this.bWR.onChangeSkinType();
            al.j(this.cLK, e.d.cp_bg_line_e);
            this.bXE.onChangeSkinType();
        }
        if (this.ekr != null && this.ekr.getVisibility() == 0) {
            this.ekr.onChangeSkinType(i);
        }
        if (this.ekt != null && this.ekt.getVisibility() == 0) {
            this.ekt.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anv() {
        if (this.cLL != null && this.cLL.threadData.getId() != null) {
            o.a(this.mTitle, this.cLL.YL().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cOs, this.cLL.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_normal_thread;
    }

    private void aIu() {
        if (this.ekr == null) {
            this.ekr = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aIv() {
        if (this.ekt == null) {
            this.ekt = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.ekt.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.anq() != null) {
                    b.this.anq().a(view, b.this.cLL);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cLL = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cLM);
        }
        if (kVar.aog()) {
            aIv();
            this.eku = this.ekt;
            this.ekt.setVisibility(0);
            if (this.ekr != null) {
                this.ekr.setVisibility(8);
            }
        } else {
            aIu();
            this.eku = this.ekr;
            this.ekr.setVisibility(0);
            if (this.ekt != null) {
                this.ekt.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!anu() && o.mf(this.cLL.threadData.getId())) {
            anv();
        }
        final bb YL = kVar.YL();
        if (this.eku.getHeaderImg() != null) {
            if (this.eku.getIsSimpleThread()) {
                this.eku.getHeaderImg().setVisibility(8);
                this.bXB.setVisibility(8);
            } else if (YL.yC() == null || YL.yC().getPendantData() == null || StringUtils.isNull(YL.yC().getPendantData().xn())) {
                this.bXB.setVisibility(8);
                this.eku.getHeaderImg().setVisibility(0);
                this.eku.getHeaderImg().setData(YL, !kVar.aog());
            } else {
                this.eku.getHeaderImg().setVisibility(4);
                this.bXB.setVisibility(0);
                this.bXB.setData(YL);
            }
        }
        this.eku.setData(kVar.threadData);
        this.eku.setUserAfterClickListener(this.aHa);
        L(YL);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> yR = kVar.threadData.yR();
        if (v.I(yR)) {
            this.cOq.setVisibility(8);
            fq(false);
            z = false;
        } else {
            this.cOq.setVisibility(0);
            fq(true);
            VoiceData.VoiceModel voiceModel = yR.get(0);
            this.cOq.setVoiceModel(voiceModel);
            this.cOq.setTag(voiceModel);
            this.cOq.aUo();
            if (voiceModel != null) {
                this.cOq.qc(voiceModel.voice_status.intValue());
            }
            this.cOq.bCH();
            z = true;
        }
        if (this.cLL.cRz && z) {
            this.cOt.setVisibility(8);
            this.ekv.setVisibility(0);
        } else {
            ArrayList<MediaData> yN = kVar.threadData.yN();
            if (i.wA().wE() && v.H(yN) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < yN.size(); i++) {
                    MediaData mediaData = (MediaData) v.d(yN, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.H(linkedList) > 0) {
                    this.cOt.setVisibility(0);
                    this.ekv.setVisibility(8);
                    this.cOt.setFromCDN(this.aAQ);
                    this.cOt.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<k> anq = b.this.anq();
                            if (anq != null) {
                                view.setTag("1");
                                anq.a(view, b.this.cLL);
                            }
                            if (z2) {
                                b.this.anK();
                            } else {
                                b.this.a(view, linkedList, i2, YL);
                            }
                        }
                    });
                    this.cOt.setImageMediaList(linkedList);
                } else {
                    this.cOt.setVisibility(8);
                    this.ekv.setVisibility(0);
                }
            } else {
                this.cOt.setVisibility(8);
                this.ekv.setVisibility(0);
            }
        }
        anJ();
        setPageUniqueId(getTag());
        aCx();
        ix(ho(1));
    }

    private void fq(boolean z) {
        if (this.cOt != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOt.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds10);
            }
            this.cOt.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aAQ ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bbVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.yI(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aAQ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bbVar.getId();
        historyMessage.threadName = bbVar.getTitle();
        historyMessage.forumName = bbVar.yI();
        historyMessage.postID = bbVar.yT();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void anJ() {
        if (!this.cLL.aWe) {
            this.cOq.setClickable(false);
        } else {
            this.cOq.setClickable(true);
        }
        int childCount = this.cOt.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cOt.getChildAt(i);
            if (childAt != null) {
                if (!this.cLL.aWe) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cOt != null) {
            this.cOt.setPageUniqueId(bdUniqueId);
        }
        if (this.eku != null) {
            this.eku.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eku != null) {
            return this.eku.getHeaderImg();
        }
        return null;
    }

    public View ant() {
        if (this.eku != null) {
            return this.eku.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anK() {
        if (this.cLL != null && this.cLL.threadData != null) {
            if (!anu()) {
                o.me(this.cLL.threadData.getId());
                o.a(this.mTitle, this.cLL.YL().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cOs, this.cLL.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cLL.threadData, null, o.yq(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cLL.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cLL.threadData.yI());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean anu() {
        return this.cLL.cRz && !this.cLL.aWe;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean L(bb bbVar) {
        SpannableStringBuilder i = bbVar.i(false, true);
        if (i == null || StringUtils.isNull(i.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        return true;
    }

    private void c(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.aog()) {
            this.cOs.setVisibility(8);
            return;
        }
        bb bbVar = kVar.threadData;
        if (ho(2) == 1) {
            SpannableString zV = bbVar.zV();
            if (zV != null && !ao.isEmpty(zV.toString())) {
                this.cOs.setVisibility(0);
                this.cOs.setOnTouchListener(new com.baidu.tieba.view.k(zV));
                this.cOs.setText(zV);
                o.a(this.cOs, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cOs.setVisibility(8);
            return;
        }
        this.cOs.setVisibility(8);
    }

    private void aCx() {
        if (this.mTitle != null && this.cOq != null && this.cOt != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOq.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds24);
            this.cOq.setLayoutParams(layoutParams);
            if (this.cOq.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cOt.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds10);
                this.cOt.setLayoutParams(layoutParams2);
            }
        }
    }

    public void ix(int i) {
        if (this.cLL != null && this.cLL.threadData != null) {
            if (!this.cLL.aog() && i == 1) {
                this.bWR.setVisibility(8);
                this.bXE.setStType(o.yq());
                this.bXE.setData(this.cLL.threadData);
                this.eku.showForumNameView(false);
                return;
            }
            this.bWR.setData(this.cLL.threadData);
            this.bWR.setStType(o.yq());
            this.bXE.setVisibility(8);
            this.eku.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bWE = str;
    }

    public int ho(int i) {
        return com.baidu.tieba.a.d.UG().M(this.bWE, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cOt != null) {
            this.cOt.setPreloadSizeReadyCallback(bVar);
        }
    }
}
