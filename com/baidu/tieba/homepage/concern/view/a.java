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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.n;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<k> implements e {
    private TextView VC;
    private String Wt;
    private final View.OnClickListener XA;
    private boolean XJ;
    public PlayVoiceBntNew XS;
    private final View.OnClickListener bZt;
    public ThreadSourceShareAndPraiseLayout dBT;
    public ThreadCommentAndPraiseInfoLayout dBf;
    protected LinearLayout dCe;
    private k exN;
    private ConstrainImageGroup exO;
    private View exP;
    private View.OnClickListener exT;
    private final View.OnClickListener exU;
    private HeadPendantClickableView exl;
    public ConcernThreadUserInfoLayout fYf;
    public ConcernForumThreadUserInfoLayout fYg;
    public d fYh;
    private View fYi;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.XJ = true;
        this.exT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view, a.this.exN);
                }
                a.this.aoV();
            }
        };
        this.exU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aXr = a.this.aXr();
                if (aXr != null) {
                    view.setTag("2");
                    aXr.a(view, a.this.exN);
                }
            }
        };
        this.XA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view, a.this.exN);
                }
            }
        };
        this.bZt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view, a.this.exN);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.exl = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.exl.getHeadView() != null) {
            this.exl.getHeadView().setIsRound(true);
            this.exl.getHeadView().setDrawBorder(false);
            this.exl.getHeadView().setDefaultResource(17170445);
            this.exl.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.exl.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.exl.getHeadView().setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.exl.getPendantView() != null) {
            this.exl.getPendantView().setIsRound(true);
            this.exl.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.XS = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.XS.setAfterClickListener(this.exU);
        this.VC = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.VC.setVisibility(8);
        this.exO = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.exP = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.exO.setChildClickListener(this.exT);
        this.exO.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.exO.setImageProcessor(fVar);
        this.dBf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.dBf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dBf.setLayoutParams(layoutParams);
        }
        this.dBf.setOnClickListener(this.exT);
        this.dBf.setReplyTimeVisible(false);
        this.dBf.setIsBarViewVisible(false);
        this.dBf.setShowPraiseNum(true);
        this.dBf.setNeedAddPraiseIcon(true);
        this.dBf.setNeedAddReplyIcon(true);
        this.dBf.setShareVisible(true);
        this.dBf.setShareReportFrom(4);
        this.dBf.setFrom(9);
        this.dBf.setDisPraiseFrom(4);
        this.dBf.caC = this.currentPageType;
        this.dBf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view2, a.this.exN);
                }
                if (a.this.exN != null && a.this.exN.threadData != null) {
                    n.uS(a.this.exN.threadData.getId());
                    a.this.bsW();
                }
            }
        });
        this.dBT = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.dBT.cbw.setOnClickListener(this.exT);
        this.dBT.setShareReportFrom(4);
        this.dBT.setFrom(9);
        this.dBT.cbw.caC = this.currentPageType;
        this.dBT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view2, a.this.exN);
                }
                if (a.this.exN != null && a.this.exN.threadData != null && view2 != a.this.dBT.caL) {
                    n.uS(a.this.exN.threadData.getId());
                    a.this.bsW();
                }
            }
        });
        this.dCe = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.fYi = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.exO != null) {
            this.exO.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exO != null) {
            this.exO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exO != null) {
            this.exO.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.drawable.addresslist_item_bg);
            this.exO.onChangeSkinType();
            this.dBf.onChangeSkinType();
            al.l(this.exP, R.color.cp_bg_line_e);
            this.dBT.onChangeSkinType();
        }
        if (this.fYf != null && this.fYf.getVisibility() == 0) {
            this.fYf.onChangeSkinType(i);
        }
        if (this.fYg != null && this.fYg.getVisibility() == 0) {
            this.fYg.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsW() {
        if (this.exN != null && this.exN.threadData.getId() != null) {
            n.a(this.mTitle, this.exN.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VC, this.exN.threadData.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bsX() {
        if (this.fYf == null) {
            this.fYf = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bsY() {
        if (this.fYg == null) {
            this.fYg = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.fYg.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXr() != null) {
                    a.this.aXr().a(view, a.this.exN);
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
        this.exN = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.exT);
        }
        if (kVar.aYe()) {
            bsY();
            this.fYh = this.fYg;
            this.fYg.setVisibility(0);
            if (this.fYf != null) {
                this.fYf.setVisibility(8);
            }
        } else {
            bsX();
            this.fYh = this.fYf;
            this.fYf.setVisibility(0);
            if (this.fYg != null) {
                this.fYg.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aXB() && n.uT(this.exN.threadData.getId())) {
            bsW();
        }
        final bg abv = kVar.abv();
        if (this.fYh.getHeaderImg() != null) {
            if (this.fYh.getIsSimpleThread()) {
                this.fYh.getHeaderImg().setVisibility(8);
                this.exl.setVisibility(8);
            } else if (abv.adv() == null || abv.adv().getPendantData() == null || StringUtils.isNull(abv.adv().getPendantData().abS())) {
                this.exl.setVisibility(8);
                this.fYh.getHeaderImg().setVisibility(0);
                this.fYh.getHeaderImg().setData(abv, !kVar.aYe());
            } else {
                this.fYh.getHeaderImg().setVisibility(4);
                this.exl.setVisibility(0);
                this.exl.setData(abv);
            }
        }
        this.fYh.setData(kVar.threadData);
        this.fYh.setUserAfterClickListener(this.XA);
        ag(abv);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> adJ = kVar.threadData.adJ();
        if (v.aa(adJ)) {
            this.XS.setVisibility(8);
            it(false);
            z = false;
        } else {
            this.XS.setVisibility(0);
            it(true);
            VoiceData.VoiceModel voiceModel = adJ.get(0);
            this.XS.setVoiceModel(voiceModel);
            this.XS.setTag(voiceModel);
            this.XS.bFD();
            if (voiceModel != null) {
                this.XS.vx(voiceModel.voice_status.intValue());
            }
            this.XS.cnF();
            z = true;
        }
        if (this.exN.eBk && z) {
            this.exO.setVisibility(8);
            this.fYi.setVisibility(0);
        } else {
            ArrayList<MediaData> adF = kVar.threadData.adF();
            if (i.abb().abf() && v.Z(adF) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < adF.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(adF, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.Z(linkedList) > 0) {
                    this.exO.setVisibility(0);
                    this.fYi.setVisibility(8);
                    this.exO.setFromCDN(this.XJ);
                    this.exO.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z2) {
                            ab<k> aXr = a.this.aXr();
                            if (aXr != null) {
                                view.setTag("1");
                                aXr.a(view, a.this.exN);
                            }
                            if (z2) {
                                a.this.aoV();
                            } else {
                                a.this.a(view, linkedList, i2, abv);
                            }
                        }
                    });
                    this.exO.setImageMediaList(linkedList);
                } else {
                    this.exO.setVisibility(8);
                    this.fYi.setVisibility(0);
                }
            } else {
                this.exO.setVisibility(8);
                this.fYi.setVisibility(0);
            }
        }
        aXJ();
        setPageUniqueId(getTag());
        bnn();
        nv(mh(1));
    }

    private void it(boolean z) {
        if (this.exO != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.exO.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.exO.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
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
                    imageUrlData.urlType = this.XJ ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bgVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.adA(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.XJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bgVar.getId();
        historyMessage.threadName = bgVar.getTitle();
        historyMessage.forumName = bgVar.adA();
        historyMessage.postID = bgVar.adL();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void aXJ() {
        if (!this.exN.crZ) {
            this.XS.setClickable(false);
        } else {
            this.XS.setClickable(true);
        }
        int childCount = this.exO.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.exO.getChildAt(i);
            if (childAt != null) {
                if (!this.exN.crZ) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.exO != null) {
            this.exO.setPageUniqueId(bdUniqueId);
        }
        if (this.fYh != null) {
            this.fYh.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fYh != null) {
            return this.fYh.getHeaderImg();
        }
        return null;
    }

    public View aXw() {
        if (this.fYh != null) {
            return this.fYh.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoV() {
        if (this.exN != null && this.exN.threadData != null) {
            if (!aXB()) {
                n.uS(this.exN.threadData.getId());
                n.a(this.mTitle, this.exN.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.VC, this.exN.threadData.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.exN.threadData, null, n.adi(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.exN.threadData.getFid()));
            createFromThreadCfg.setForumName(this.exN.threadData.adA());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aXB() {
        return this.exN.eBk && !this.exN.crZ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean ag(bg bgVar) {
        SpannableStringBuilder m = bgVar.m(false, true);
        if (m == null || StringUtils.isNull(m.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(m));
            this.mTitle.setText(m);
            n.a(this.mTitle, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.aYe()) {
            this.VC.setVisibility(8);
            return;
        }
        bg bgVar = kVar.threadData;
        if (mh(2) == 1) {
            SpannableString aeW = bgVar.aeW();
            if (aeW != null && !ap.isEmpty(aeW.toString())) {
                this.VC.setVisibility(0);
                this.VC.setOnTouchListener(new com.baidu.tieba.view.k(aeW));
                this.VC.setText(aeW);
                n.a(this.VC, bgVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.VC.setVisibility(8);
            return;
        }
        this.VC.setVisibility(8);
    }

    private void bnn() {
        if (this.mTitle != null && this.XS != null && this.exO != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XS.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.XS.setLayoutParams(layoutParams);
            if (this.XS.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.exO.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.exO.setLayoutParams(layoutParams2);
            }
        }
    }

    public void nv(int i) {
        if (this.exN != null && this.exN.threadData != null) {
            if (!this.exN.aYe() && i == 1) {
                this.dBf.setVisibility(8);
                this.dBT.setStType(n.adi());
                this.dBT.setData(this.exN.threadData);
                this.fYh.ej(false);
                return;
            }
            this.dBf.setData(this.exN.threadData);
            this.dBf.setStType(n.adi());
            this.dBT.setVisibility(8);
            this.fYh.ej(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBq().ag(this.Wt, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.exO != null) {
            this.exO.setPreloadSizeReadyCallback(bVar);
        }
    }
}
