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
    private boolean aEr;
    private final View.OnClickListener aIy;
    private final View.OnClickListener aKC;
    private View cVh;
    private k cVi;
    private View.OnClickListener cVj;
    public PlayVoiceBntNew cXN;
    private TextView cXP;
    private ConstrainImageGroup cXQ;
    private final View.OnClickListener cXT;
    public ThreadCommentAndPraiseInfoLayout caM;
    private String caz;
    protected LinearLayout cbK;
    private HeadPendantClickableView cbw;
    public ThreadSourceShareAndPraiseLayout cbz;
    public ConcernThreadUserInfoLayout eud;
    public ConcernForumThreadUserInfoLayout euf;
    public com.baidu.tbadk.core.view.f eug;
    private View euh;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aEr = true;
        this.cVj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.apS() != null) {
                    b.this.apS().a(view, b.this.cVi);
                }
                b.this.aqm();
            }
        };
        this.cXT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<k> apS = b.this.apS();
                if (apS != null) {
                    view.setTag("2");
                    apS.a(view, b.this.cVi);
                }
            }
        };
        this.aKC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.apS() != null) {
                    b.this.apS().a(view, b.this.cVi);
                }
            }
        };
        this.aIy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.apS() != null) {
                    b.this.apS().a(view, b.this.cVi);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cbw = (HeadPendantClickableView) view.findViewById(e.g.card_concern_normal_thread_user_pendant_header);
        if (this.cbw.getHeadView() != null) {
            this.cbw.getHeadView().setIsRound(true);
            this.cbw.getHeadView().setDrawBorder(false);
            this.cbw.getHeadView().setDefaultResource(17170445);
            this.cbw.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbw.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbw.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds60));
        }
        if (this.cbw.getPendantView() != null) {
            this.cbw.getPendantView().setIsRound(true);
            this.cbw.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_normal_thread_title);
        this.cXN = (PlayVoiceBntNew) view.findViewById(e.g.card_concern_normal_thread_abstract_voice);
        this.cXN.setAfterClickListener(this.cXT);
        this.cXP = (TextView) view.findViewById(e.g.card_concern_normal_thread_abstract);
        this.cXP.setVisibility(8);
        this.cXQ = (ConstrainImageGroup) view.findViewById(e.g.card_concern_normal_thread_img_layout);
        this.cVh = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.cXQ.setChildClickListener(this.cVj);
        this.cXQ.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cXQ.setImageProcessor(eVar);
        this.caM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_normal_thread_info_layout);
        if (this.caM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caM.setLayoutParams(layoutParams);
        }
        this.caM.setOnClickListener(this.cVj);
        this.caM.setReplyTimeVisible(false);
        this.caM.setIsBarViewVisible(false);
        this.caM.setShowPraiseNum(true);
        this.caM.setNeedAddPraiseIcon(true);
        this.caM.setNeedAddReplyIcon(true);
        this.caM.setShareVisible(true);
        this.caM.setShareReportFrom(4);
        this.caM.setFrom(9);
        this.caM.setDisPraiseFrom(4);
        this.caM.avM = this.currentPageType;
        this.caM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.apS() != null) {
                    b.this.apS().a(view2, b.this.cVi);
                }
                if (b.this.cVi != null && b.this.cVi.threadData != null) {
                    o.mG(b.this.cVi.threadData.getId());
                    b.this.apX();
                }
            }
        });
        this.cbz = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_nomal_source_read_share_layout);
        this.cbz.aKk.setOnClickListener(this.cVj);
        this.cbz.setShareReportFrom(4);
        this.cbz.setFrom(9);
        this.cbz.aKk.avM = this.currentPageType;
        this.cbz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.apS() != null) {
                    b.this.apS().a(view2, b.this.cVi);
                }
                if (b.this.cVi != null && b.this.cVi.threadData != null && view2 != b.this.cbz.aKj) {
                    o.mG(b.this.cVi.threadData.getId());
                    b.this.apX();
                }
            }
        });
        this.cbK = (LinearLayout) view.findViewById(e.g.card_concern_normal_thread_content_layout);
        this.euh = view.findViewById(e.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cXQ != null) {
            this.cXQ.setSingleImageRatio(d);
        }
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
            this.cXQ.onChangeSkinType();
            this.caM.onChangeSkinType();
            al.j(this.cVh, e.d.cp_bg_line_e);
            this.cbz.onChangeSkinType();
        }
        if (this.eud != null && this.eud.getVisibility() == 0) {
            this.eud.onChangeSkinType(i);
        }
        if (this.euf != null && this.euf.getVisibility() == 0) {
            this.euf.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apX() {
        if (this.cVi != null && this.cVi.threadData.getId() != null) {
            o.a(this.mTitle, this.cVi.ZT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cXP, this.cVi.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_normal_thread;
    }

    private void aLa() {
        if (this.eud == null) {
            this.eud = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aLb() {
        if (this.euf == null) {
            this.euf = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.euf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.apS() != null) {
                    b.this.apS().a(view, b.this.cVi);
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
        this.cVi = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVj);
        }
        if (kVar.aqI()) {
            aLb();
            this.eug = this.euf;
            this.euf.setVisibility(0);
            if (this.eud != null) {
                this.eud.setVisibility(8);
            }
        } else {
            aLa();
            this.eug = this.eud;
            this.eud.setVisibility(0);
            if (this.euf != null) {
                this.euf.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!apW() && o.mH(this.cVi.threadData.getId())) {
            apX();
        }
        final bb ZT = kVar.ZT();
        if (this.eug.getHeaderImg() != null) {
            if (this.eug.getIsSimpleThread()) {
                this.eug.getHeaderImg().setVisibility(8);
                this.cbw.setVisibility(8);
            } else if (ZT.zG() == null || ZT.zG().getPendantData() == null || StringUtils.isNull(ZT.zG().getPendantData().ys())) {
                this.cbw.setVisibility(8);
                this.eug.getHeaderImg().setVisibility(0);
                this.eug.getHeaderImg().setData(ZT, !kVar.aqI());
            } else {
                this.eug.getHeaderImg().setVisibility(4);
                this.cbw.setVisibility(0);
                this.cbw.setData(ZT);
            }
        }
        this.eug.setData(kVar.threadData);
        this.eug.setUserAfterClickListener(this.aKC);
        L(ZT);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> zV = kVar.threadData.zV();
        if (v.I(zV)) {
            this.cXN.setVisibility(8);
            ft(false);
            z = false;
        } else {
            this.cXN.setVisibility(0);
            ft(true);
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
            this.euh.setVisibility(0);
        } else {
            ArrayList<MediaData> zR = kVar.threadData.zR();
            if (i.xE().xI() && v.H(zR) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zR.size(); i++) {
                    MediaData mediaData = (MediaData) v.d(zR, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.H(linkedList) > 0) {
                    this.cXQ.setVisibility(0);
                    this.euh.setVisibility(8);
                    this.cXQ.setFromCDN(this.aEr);
                    this.cXQ.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<k> apS = b.this.apS();
                            if (apS != null) {
                                view.setTag("1");
                                apS.a(view, b.this.cVi);
                            }
                            if (z2) {
                                b.this.aqm();
                            } else {
                                b.this.a(view, linkedList, i2, ZT);
                            }
                        }
                    });
                    this.cXQ.setImageMediaList(linkedList);
                } else {
                    this.cXQ.setVisibility(8);
                    this.euh.setVisibility(0);
                }
            } else {
                this.cXQ.setVisibility(8);
                this.euh.setVisibility(0);
            }
        }
        aql();
        setPageUniqueId(getTag());
        aEY();
        iM(hD(1));
    }

    private void ft(boolean z) {
        if (this.cXQ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXQ.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10);
            }
            this.cXQ.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.aEr ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zM(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEr, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
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
        if (this.eug != null) {
            this.eug.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eug != null) {
            return this.eug.getHeaderImg();
        }
        return null;
    }

    public View apV() {
        if (this.eug != null) {
            return this.eug.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqm() {
        if (this.cVi != null && this.cVi.threadData != null) {
            if (!apW()) {
                o.mG(this.cVi.threadData.getId());
                o.a(this.mTitle, this.cVi.ZT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cXP, this.cVi.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVi.threadData, null, o.zu(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cVi.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cVi.threadData.zM());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean apW() {
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

    private void c(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.aqI()) {
            this.cXP.setVisibility(8);
            return;
        }
        bb bbVar = kVar.threadData;
        if (hD(2) == 1) {
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

    private void aEY() {
        if (this.mTitle != null && this.cXN != null && this.cXQ != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXN.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
            this.cXN.setLayoutParams(layoutParams);
            if (this.cXN.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cXQ.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                this.cXQ.setLayoutParams(layoutParams2);
            }
        }
    }

    public void iM(int i) {
        if (this.cVi != null && this.cVi.threadData != null) {
            if (!this.cVi.aqI() && i == 1) {
                this.caM.setVisibility(8);
                this.cbz.setStType(o.zu());
                this.cbz.setData(this.cVi.threadData);
                this.eug.showForumNameView(false);
                return;
            }
            this.caM.setData(this.cVi.threadData);
            this.caM.setStType(o.zu());
            this.cbz.setVisibility(8);
            this.eug.showForumNameView(true);
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
}
