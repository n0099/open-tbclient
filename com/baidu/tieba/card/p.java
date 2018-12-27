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
    private boolean aEr;
    private final View.OnClickListener aKC;
    private ThreadGodReplyLayout cVg;
    private View cVh;
    private com.baidu.tieba.card.data.k cVi;
    private View.OnClickListener cVj;
    public PlayVoiceBntNew cXN;
    private View cXO;
    private TextView cXP;
    private ConstrainImageGroup cXQ;
    private boolean cXR;
    private RelativeLayout cXS;
    private final View.OnClickListener cXT;
    public ThreadUserInfoLayout caL;
    public ThreadCommentAndPraiseInfoLayout caM;
    private NEGFeedBackView caX;
    private String caz;
    protected LinearLayout cbK;
    private HeadPendantClickableView cbw;
    public ThreadSourceShareAndPraiseLayout cbz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caX = null;
        this.mSkinType = 3;
        this.aEr = true;
        this.cXR = true;
        this.cVj = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cVi != null) {
                    p.this.cVi.aFq = 1;
                }
                if (p.this.apS() != null) {
                    p.this.apS().a(view, p.this.cVi);
                }
                p.this.fp(view == p.this.cVg);
            }
        };
        this.cXT = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.card.data.k> apS = p.this.apS();
                if (apS != null) {
                    view.setTag("2");
                    apS.a(view, p.this.cVi);
                }
            }
        };
        this.aKC = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cVi == null) {
                    if (p.this.apS() != null) {
                        p.this.apS().a(view, p.this.cVi);
                        return;
                    }
                    return;
                }
                if (view == p.this.caL.getUserName()) {
                    p.this.cVi.aFq = 3;
                } else if (view == p.this.caL.getHeaderImg()) {
                    p.this.cVi.aFq = 4;
                } else if (view == p.this.cXQ) {
                    p.this.cVi.aFq = 2;
                    return;
                } else {
                    p.this.cVi.aFq = 1;
                }
                if (p.this.apS() != null) {
                    p.this.apS().a(view, p.this.cVi);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cbw = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cbw.getHeadView() != null) {
            this.cbw.getHeadView().setIsRound(true);
            this.cbw.getHeadView().setDrawBorder(false);
            this.cbw.getHeadView().setDefaultResource(17170445);
            this.cbw.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbw.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbw.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbw.setHasPendantStyle();
        if (this.cbw.getPendantView() != null) {
            this.cbw.getPendantView().setIsRound(true);
            this.cbw.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cXN = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cXN.setAfterClickListener(this.cXT);
        this.cXP = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cXP.setVisibility(8);
        this.cXQ = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cVh = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20);
        this.cXQ.setChildClickListener(this.cVj);
        this.cXQ.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cXQ.setImageProcessor(eVar);
        this.cXO = view.findViewById(e.g.divider_line_above_praise);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.caL = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.caX = new NEGFeedBackView(this.mPageContext);
        this.cXS = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.caX.a(this.cXS, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120), 0);
        if (this.caM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caM.setLayoutParams(layoutParams);
        }
        this.caM.setOnClickListener(this.cVj);
        this.caM.setReplyTimeVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setShareVisible(true);
        this.caM.setFrom(1);
        this.caM.setDisPraiseFrom(1);
        this.caM.setShareReportFrom(3);
        this.caM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.apS() != null) {
                    p.this.apS().a(view2, p.this.cVi);
                }
                if (p.this.cVi != null && p.this.cVi.threadData != null) {
                    o.mG(p.this.cVi.threadData.getId());
                    if (!p.this.apW()) {
                        o.a(p.this.mTitle, p.this.cVi.ZT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cXP, p.this.cVi.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cVg.getGodReplyContent(), p.this.cVi.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
        this.cbK = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.cVg = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cVg.setOnClickListener(this.cVj);
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        this.cbz.aKk.setOnClickListener(this.cVj);
        this.cbz.setFrom(1);
        this.cbz.setShareReportFrom(3);
        this.cbz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.apS() != null) {
                    p.this.apS().a(view2, p.this.cVi);
                }
                if (p.this.cVi != null && p.this.cVi.threadData != null && view2 != p.this.cbz.aKj) {
                    o.mG(p.this.cVi.threadData.getId());
                    if (!p.this.apW()) {
                        o.a(p.this.mTitle, p.this.cVi.ZT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cXP, p.this.cVi.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cVg.getGodReplyContent(), p.this.cVi.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cXQ != null) {
            this.cXQ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cXQ != null) {
            this.cXQ.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cXO, e.d.transparent);
            this.cXQ.onChangeSkinType();
            this.caM.onChangeSkinType();
            this.cVg.onChangeSkinType();
            this.caL.onChangeSkinType();
            if (this.caX != null) {
                this.caX.onChangeSkinType();
            }
            al.j(this.cVh, e.d.cp_bg_line_e);
            if (this.cbz != null) {
                this.cbz.onChangeSkinType();
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
        if (kVar == null || kVar.ZT() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cVi = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVj);
        }
        if (this.caX != null) {
            if (this.cVi.asc != null && this.cVi.asc.size() > 0) {
                ah ahVar = new ah();
                ahVar.setTid(this.cVi.ZT().getTid());
                ahVar.setFid(this.cVi.ZT().getFid());
                ahVar.a(this.cVi.asc);
                this.caX.setData(ahVar);
                this.caX.setFirstRowSingleColumn(true);
                if (kVar.threadData.zG() != null && !StringUtils.isNull(kVar.threadData.zG().getUserId())) {
                    if (kVar.threadData.zG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.caX.setVisibility(8);
                    } else if (this.caX != null) {
                        this.caX.setVisibility(this.cXR ? 0 : 8);
                    }
                }
            } else {
                this.caX.setVisibility(8);
            }
        }
        this.caL.setData(kVar.threadData);
        this.cVg.setFromCDN(this.aEr);
        this.cVg.setData(kVar.threadData.AX());
        if (!apW() && o.mH(this.cVi.threadData.getId())) {
            o.a(this.mTitle, this.cVi.ZT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cXP, this.cVi.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cVg.getGodReplyContent(), this.cVi.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.caL.setUserAfterClickListener(this.aKC);
        final bb ZT = kVar.ZT();
        if (this.caL.getHeaderImg() != null) {
            if (this.caL.getIsSimpleThread()) {
                this.caL.getHeaderImg().setVisibility(8);
                this.cbw.setVisibility(8);
            } else if (ZT.zG() == null || ZT.zG().getPendantData() == null || StringUtils.isNull(ZT.zG().getPendantData().ys())) {
                this.cbw.setVisibility(8);
                this.caL.getHeaderImg().setVisibility(0);
                this.caL.getHeaderImg().setData(ZT);
            } else {
                this.caL.getHeaderImg().setVisibility(4);
                this.cbw.setVisibility(0);
                this.cbw.setData(ZT);
            }
        }
        L(ZT);
        M(ZT);
        ArrayList<VoiceData.VoiceModel> zV = kVar.threadData.zV();
        if (com.baidu.tbadk.core.util.v.I(zV)) {
            this.cXN.setVisibility(8);
            z = false;
        } else {
            this.cXN.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zV.get(0);
            this.cXN.setVoiceModel(voiceModel);
            this.cXN.setTag(voiceModel);
            this.cXN.aWT();
            if (voiceModel != null) {
                this.cXN.qJ(voiceModel.voice_status.intValue());
            }
            this.cXN.bFt();
            z = true;
        }
        if (this.cVi.daY && z) {
            this.cXQ.setVisibility(8);
        } else {
            ArrayList<MediaData> zR = ZT.zR();
            if (com.baidu.tbadk.core.i.xE().xI() && com.baidu.tbadk.core.util.v.H(zR) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zR.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(zR, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.H(linkedList) > 0) {
                    this.cXQ.setVisibility(0);
                    this.cXQ.setFromCDN(this.aEr);
                    this.cXQ.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<com.baidu.tieba.card.data.k> apS = p.this.apS();
                            if (apS != null) {
                                view.setTag("1");
                                if (p.this.aKC != null) {
                                    p.this.aKC.onClick(p.this.cXQ);
                                }
                                apS.a(view, p.this.cVi);
                            }
                            if (z2) {
                                p.this.aqm();
                            } else {
                                p.this.a(view, linkedList, i2, ZT);
                            }
                        }
                    });
                    this.cXQ.setImageMediaList(linkedList);
                } else {
                    this.cXQ.setVisibility(8);
                }
            } else {
                this.cXQ.setVisibility(8);
            }
        }
        aqk();
        aql();
        setPageUniqueId(getTag());
        iM(hD(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aqk() {
        if (this.cXO != null && this.cXQ != null && this.cVg != null) {
            if (this.cXQ.getVisibility() == 8 && this.cVg.getVisibility() == 8) {
                this.cXO.setVisibility(0);
            } else {
                this.cXO.setVisibility(8);
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
                    imageUrlData.urlType = this.aEr ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zM(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEr, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bbVar.zM();
        historyMessage.postID = bbVar.zX();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void aql() {
        if (!this.cVi.aZE) {
            this.cXN.setClickable(false);
        } else {
            this.cXN.setClickable(true);
        }
        int childCount = this.cXQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cXQ.getChildAt(i);
            if (childAt != null) {
                if (!this.cVi.aZE) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aEr = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cXQ != null) {
            this.cXQ.setPageUniqueId(bdUniqueId);
        }
        if (this.caX != null) {
            this.caX.setUniqueId(bdUniqueId);
        }
        if (this.caL != null) {
            this.caL.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.caX != null) {
            this.caX.setEventCallback(aVar);
        }
    }

    public View apU() {
        return this.cVg;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caL != null) {
            return this.caL.aKp;
        }
        return null;
    }

    public View apV() {
        if (this.caL != null) {
            return this.caL.aKr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqm() {
        fp(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (this.cVi != null && this.cVi.threadData != null) {
            if (!apW()) {
                o.mG(this.cVi.threadData.getId());
                o.a(this.mTitle, this.cVi.ZT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cXP, this.cVi.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                o.a(this.cVg.getGodReplyContent(), this.cVi.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVi.threadData, null, o.zu(), 18003, true, false, false).addLocateParam(this.cVi.aqD());
            addLocateParam.setForumId(String.valueOf(this.cVi.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cVi.threadData.zM());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.mG(this.cVi.ZT().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apW() {
        return this.cVi.daY && !this.cVi.aZE;
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
        if (bbVar != null && hD(2) == 1) {
            SpannableString AZ = bbVar.AZ();
            if (AZ != null && !ao.isEmpty(AZ.toString())) {
                this.cXP.setVisibility(0);
                this.cXP.setOnTouchListener(new com.baidu.tieba.view.k(AZ));
                this.cXP.setText(AZ);
                o.a(this.cXP, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cXP.setVisibility(8);
            return;
        }
        this.cXP.setVisibility(8);
    }

    public void fr(boolean z) {
        if (this.cVh != null) {
            this.cVh.setVisibility(z ? 0 : 8);
        }
    }

    public void fs(boolean z) {
        this.cXR = z;
    }

    public void iM(int i) {
        if (this.cVi != null && this.cVi.threadData != null) {
            this.mStType = o.zu();
            if (i == 1) {
                this.caM.setVisibility(8);
                this.cbz.setStType(this.mStType);
                this.cbz.setData(this.cVi.threadData);
                this.caL.showForumNameView(false);
                return;
            }
            this.caM.setData(this.cVi.threadData);
            this.caM.setStType(this.mStType);
            this.cbz.setVisibility(8);
            this.caL.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caz = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.VO().N(this.caz, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cXQ != null) {
            this.cXQ.setPreloadSizeReadyCallback(bVar);
        }
    }

    public void kL(int i) {
        if (this.caM != null) {
            this.caM.aJD = String.valueOf(i);
        }
    }
}
