package com.baidu.tieba.card;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class p extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private boolean aAQ;
    private final View.OnClickListener aHa;
    private String bWE;
    public ThreadUserInfoLayout bWQ;
    public ThreadCommentAndPraiseInfoLayout bWR;
    private HeadPendantClickableView bXB;
    public ThreadSourceShareAndPraiseLayout bXE;
    protected LinearLayout bXP;
    private NEGFeedBackView bXc;
    private ThreadGodReplyLayout cLJ;
    private View cLK;
    private com.baidu.tieba.card.data.k cLL;
    private View.OnClickListener cLM;
    public PlayVoiceBntNew cOq;
    private View cOr;
    private TextView cOs;
    private ConstrainImageGroup cOt;
    private boolean cOu;
    private RelativeLayout cOv;
    private final View.OnClickListener cOw;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bXc = null;
        this.mSkinType = 3;
        this.aAQ = true;
        this.cOu = true;
        this.cLM = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cLL != null) {
                    p.this.cLL.aBP = 1;
                }
                if (p.this.anq() != null) {
                    p.this.anq().a(view, p.this.cLL);
                }
                p.this.fm(view == p.this.cLJ);
            }
        };
        this.cOw = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.card.data.k> anq = p.this.anq();
                if (anq != null) {
                    view.setTag("2");
                    anq.a(view, p.this.cLL);
                }
            }
        };
        this.aHa = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cLL == null) {
                    if (p.this.anq() != null) {
                        p.this.anq().a(view, p.this.cLL);
                        return;
                    }
                    return;
                }
                if (view == p.this.bWQ.getUserName()) {
                    p.this.cLL.aBP = 3;
                } else if (view == p.this.bWQ.getHeaderImg()) {
                    p.this.cLL.aBP = 4;
                } else if (view == p.this.cOt) {
                    p.this.cLL.aBP = 2;
                    return;
                } else {
                    p.this.cLL.aBP = 1;
                }
                if (p.this.anq() != null) {
                    p.this.anq().a(view, p.this.cLL);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bXB = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bXB.getHeadView() != null) {
            this.bXB.getHeadView().setIsRound(true);
            this.bXB.getHeadView().setDrawBorder(false);
            this.bXB.getHeadView().setDefaultResource(17170445);
            this.bXB.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bXB.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bXB.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0200e.ds70));
        }
        this.bXB.setHasPendantStyle();
        if (this.bXB.getPendantView() != null) {
            this.bXB.getPendantView().setIsRound(true);
            this.bXB.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cOq = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cOq.setAfterClickListener(this.cOw);
        this.cOs = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cOs.setVisibility(8);
        this.cOt = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cLK = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds20);
        this.cOt.setChildClickListener(this.cLM);
        this.cOt.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cOt.setImageProcessor(eVar);
        this.cOr = view.findViewById(e.g.divider_line_above_praise);
        this.bWR = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bWQ = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bXc = new NEGFeedBackView(this.mPageContext);
        this.cOv = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.bXc.a(this.cOv, com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds120), 0);
        if (this.bWR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWR.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWR.setLayoutParams(layoutParams);
        }
        this.bWR.setOnClickListener(this.cLM);
        this.bWR.setReplyTimeVisible(false);
        this.bWR.setShowPraiseNum(true);
        this.bWR.setNeedAddPraiseIcon(true);
        this.bWR.setNeedAddReplyIcon(true);
        this.bWR.setShareVisible(true);
        this.bWR.setFrom(1);
        this.bWR.setDisPraiseFrom(1);
        this.bWR.setShareReportFrom(3);
        this.bWR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.anq() != null) {
                    p.this.anq().a(view2, p.this.cLL);
                }
                if (p.this.cLL != null && p.this.cLL.threadData != null) {
                    o.me(p.this.cLL.threadData.getId());
                    if (!p.this.anu()) {
                        o.a(p.this.mTitle, p.this.cLL.YL().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cOs, p.this.cLL.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cLJ.getGodReplyContent(), p.this.cLL.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
        this.bXP = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.cLJ = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cLJ.setOnClickListener(this.cLM);
        this.bXE = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        this.bXE.aGI.setOnClickListener(this.cLM);
        this.bXE.setFrom(1);
        this.bXE.setShareReportFrom(3);
        this.bXE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.anq() != null) {
                    p.this.anq().a(view2, p.this.cLL);
                }
                if (p.this.cLL != null && p.this.cLL.threadData != null && view2 != p.this.bXE.aGH) {
                    o.me(p.this.cLL.threadData.getId());
                    if (!p.this.anu()) {
                        o.a(p.this.mTitle, p.this.cLL.YL().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cOs, p.this.cLL.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cLJ.getGodReplyContent(), p.this.cLL.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
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
            al.j(this.cOr, e.d.transparent);
            this.cOt.onChangeSkinType();
            this.bWR.onChangeSkinType();
            this.cLJ.onChangeSkinType();
            this.bWQ.onChangeSkinType();
            if (this.bXc != null) {
                this.bXc.onChangeSkinType();
            }
            al.j(this.cLK, e.d.cp_bg_line_e);
            if (this.bXE != null) {
                this.bXE.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        boolean z;
        if (kVar == null || kVar.YL() == null) {
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
        if (this.bXc != null) {
            if (this.cLL.aoB != null && this.cLL.aoB.size() > 0) {
                ah ahVar = new ah();
                ahVar.setTid(this.cLL.YL().getTid());
                ahVar.setFid(this.cLL.YL().getFid());
                ahVar.a(this.cLL.aoB);
                this.bXc.setData(ahVar);
                this.bXc.setFirstRowSingleColumn(true);
                if (kVar.threadData.yC() != null && !StringUtils.isNull(kVar.threadData.yC().getUserId())) {
                    if (kVar.threadData.yC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bXc.setVisibility(8);
                    } else if (this.bXc != null) {
                        this.bXc.setVisibility(this.cOu ? 0 : 8);
                    }
                }
            } else {
                this.bXc.setVisibility(8);
            }
        }
        this.bWQ.setData(kVar.threadData);
        this.cLJ.setFromCDN(this.aAQ);
        this.cLJ.setData(kVar.threadData.zT());
        if (!anu() && o.mf(this.cLL.threadData.getId())) {
            o.a(this.mTitle, this.cLL.YL().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cOs, this.cLL.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cLJ.getGodReplyContent(), this.cLL.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.bWQ.setUserAfterClickListener(this.aHa);
        final bb YL = kVar.YL();
        if (this.bWQ.getHeaderImg() != null) {
            if (this.bWQ.getIsSimpleThread()) {
                this.bWQ.getHeaderImg().setVisibility(8);
                this.bXB.setVisibility(8);
            } else if (YL.yC() == null || YL.yC().getPendantData() == null || StringUtils.isNull(YL.yC().getPendantData().xn())) {
                this.bXB.setVisibility(8);
                this.bWQ.getHeaderImg().setVisibility(0);
                this.bWQ.getHeaderImg().setData(YL);
            } else {
                this.bWQ.getHeaderImg().setVisibility(4);
                this.bXB.setVisibility(0);
                this.bXB.setData(YL);
            }
        }
        L(YL);
        M(YL);
        ArrayList<VoiceData.VoiceModel> yR = kVar.threadData.yR();
        if (com.baidu.tbadk.core.util.v.I(yR)) {
            this.cOq.setVisibility(8);
            z = false;
        } else {
            this.cOq.setVisibility(0);
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
        } else {
            ArrayList<MediaData> yN = YL.yN();
            if (com.baidu.tbadk.core.i.wA().wE() && com.baidu.tbadk.core.util.v.H(yN) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < yN.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(yN, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.H(linkedList) > 0) {
                    this.cOt.setVisibility(0);
                    this.cOt.setFromCDN(this.aAQ);
                    this.cOt.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<com.baidu.tieba.card.data.k> anq = p.this.anq();
                            if (anq != null) {
                                view.setTag("1");
                                if (p.this.aHa != null) {
                                    p.this.aHa.onClick(p.this.cOt);
                                }
                                anq.a(view, p.this.cLL);
                            }
                            if (z2) {
                                p.this.anK();
                            } else {
                                p.this.a(view, linkedList, i2, YL);
                            }
                        }
                    });
                    this.cOt.setImageMediaList(linkedList);
                } else {
                    this.cOt.setVisibility(8);
                }
            } else {
                this.cOt.setVisibility(8);
            }
        }
        anI();
        anJ();
        setPageUniqueId(getTag());
        ix(ho(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void anI() {
        if (this.cOr != null && this.cOt != null && this.cLJ != null) {
            if (this.cOt.getVisibility() == 8 && this.cLJ.getVisibility() == 8) {
                this.cOr.setVisibility(0);
            } else {
                this.cOr.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
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
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
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
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
        }
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

    public void setFromCDN(boolean z) {
        this.aAQ = z;
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
        if (this.bXc != null) {
            this.bXc.setUniqueId(bdUniqueId);
        }
        if (this.bWQ != null) {
            this.bWQ.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bXc != null) {
            this.bXc.setEventCallback(aVar);
        }
    }

    public View ans() {
        return this.cLJ;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bWQ != null) {
            return this.bWQ.aGN;
        }
        return null;
    }

    public View ant() {
        if (this.bWQ != null) {
            return this.bWQ.aGP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anK() {
        fm(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (this.cLL != null && this.cLL.threadData != null) {
            if (!anu()) {
                o.me(this.cLL.threadData.getId());
                o.a(this.mTitle, this.cLL.YL().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cOs, this.cLL.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                o.a(this.cLJ.getGodReplyContent(), this.cLL.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cLL.threadData, null, o.yq(), 18003, true, false, false).addLocateParam(this.cLL.aob());
            addLocateParam.setForumId(String.valueOf(this.cLL.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cLL.threadData.yI());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.me(this.cLL.YL().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anu() {
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

    private void M(bb bbVar) {
        if (bbVar != null && ho(2) == 1) {
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

    public void fo(boolean z) {
        if (this.cLK != null) {
            this.cLK.setVisibility(z ? 0 : 8);
        }
    }

    public void fp(boolean z) {
        this.cOu = z;
    }

    public void ix(int i) {
        if (this.cLL != null && this.cLL.threadData != null) {
            this.mStType = o.yq();
            if (i == 1) {
                this.bWR.setVisibility(8);
                this.bXE.setStType(this.mStType);
                this.bXE.setData(this.cLL.threadData);
                this.bWQ.showForumNameView(false);
                return;
            }
            this.bWR.setData(this.cLL.threadData);
            this.bWR.setStType(this.mStType);
            this.bXE.setVisibility(8);
            this.bWQ.showForumNameView(true);
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
