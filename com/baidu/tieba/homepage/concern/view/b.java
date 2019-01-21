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
    private boolean aEU;
    private final View.OnClickListener aJb;
    private final View.OnClickListener aLf;
    private View cVT;
    private k cVU;
    private View.OnClickListener cVV;
    private TextView cYB;
    private ConstrainImageGroup cYC;
    private final View.OnClickListener cYF;
    public PlayVoiceBntNew cYz;
    private String cbl;
    public ThreadCommentAndPraiseInfoLayout cby;
    private HeadPendantClickableView cci;
    public ThreadSourceShareAndPraiseLayout ccl;
    protected LinearLayout ccx;
    public ConcernThreadUserInfoLayout euK;
    public ConcernForumThreadUserInfoLayout euM;
    public com.baidu.tbadk.core.view.f euN;
    private View euO;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aEU = true;
        this.cVV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view, b.this.cVU);
                }
                b.this.aqJ();
            }
        };
        this.cYF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<k> aqp = b.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, b.this.cVU);
                }
            }
        };
        this.aLf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view, b.this.cVU);
                }
            }
        };
        this.aJb = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view, b.this.cVU);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cci = (HeadPendantClickableView) view.findViewById(e.g.card_concern_normal_thread_user_pendant_header);
        if (this.cci.getHeadView() != null) {
            this.cci.getHeadView().setIsRound(true);
            this.cci.getHeadView().setDrawBorder(false);
            this.cci.getHeadView().setDefaultResource(17170445);
            this.cci.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cci.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cci.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds60));
        }
        if (this.cci.getPendantView() != null) {
            this.cci.getPendantView().setIsRound(true);
            this.cci.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_normal_thread_title);
        this.cYz = (PlayVoiceBntNew) view.findViewById(e.g.card_concern_normal_thread_abstract_voice);
        this.cYz.setAfterClickListener(this.cYF);
        this.cYB = (TextView) view.findViewById(e.g.card_concern_normal_thread_abstract);
        this.cYB.setVisibility(8);
        this.cYC = (ConstrainImageGroup) view.findViewById(e.g.card_concern_normal_thread_img_layout);
        this.cVT = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.cYC.setChildClickListener(this.cVV);
        this.cYC.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cYC.setImageProcessor(eVar);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_normal_thread_info_layout);
        if (this.cby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cby.setLayoutParams(layoutParams);
        }
        this.cby.setOnClickListener(this.cVV);
        this.cby.setReplyTimeVisible(false);
        this.cby.setIsBarViewVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setShareVisible(true);
        this.cby.setShareReportFrom(4);
        this.cby.setFrom(9);
        this.cby.setDisPraiseFrom(4);
        this.cby.awp = this.currentPageType;
        this.cby.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view2, b.this.cVU);
                }
                if (b.this.cVU != null && b.this.cVU.threadData != null) {
                    o.mW(b.this.cVU.threadData.getId());
                    b.this.aqu();
                }
            }
        });
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_nomal_source_read_share_layout);
        this.ccl.aKN.setOnClickListener(this.cVV);
        this.ccl.setShareReportFrom(4);
        this.ccl.setFrom(9);
        this.ccl.aKN.awp = this.currentPageType;
        this.ccl.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view2, b.this.cVU);
                }
                if (b.this.cVU != null && b.this.cVU.threadData != null && view2 != b.this.ccl.aKM) {
                    o.mW(b.this.cVU.threadData.getId());
                    b.this.aqu();
                }
            }
        });
        this.ccx = (LinearLayout) view.findViewById(e.g.card_concern_normal_thread_content_layout);
        this.euO = view.findViewById(e.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cYC != null) {
            this.cYC.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYC != null) {
            this.cYC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYC != null) {
            this.cYC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.cYC.onChangeSkinType();
            this.cby.onChangeSkinType();
            al.j(this.cVT, e.d.cp_bg_line_e);
            this.ccl.onChangeSkinType();
        }
        if (this.euK != null && this.euK.getVisibility() == 0) {
            this.euK.onChangeSkinType(i);
        }
        if (this.euM != null && this.euM.getVisibility() == 0) {
            this.euM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqu() {
        if (this.cVU != null && this.cVU.threadData.getId() != null) {
            o.a(this.mTitle, this.cVU.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cYB, this.cVU.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_normal_thread;
    }

    private void aLy() {
        if (this.euK == null) {
            this.euK = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aLz() {
        if (this.euM == null) {
            this.euM = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.euM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view, b.this.cVU);
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
        this.cVU = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVV);
        }
        if (kVar.arf()) {
            aLz();
            this.euN = this.euM;
            this.euM.setVisibility(0);
            if (this.euK != null) {
                this.euK.setVisibility(8);
            }
        } else {
            aLy();
            this.euN = this.euK;
            this.euK.setVisibility(0);
            if (this.euM != null) {
                this.euM.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aqt() && o.mX(this.cVU.threadData.getId())) {
            aqu();
        }
        final bb aaq = kVar.aaq();
        if (this.euN.getHeaderImg() != null) {
            if (this.euN.getIsSimpleThread()) {
                this.euN.getHeaderImg().setVisibility(8);
                this.cci.setVisibility(8);
            } else if (aaq.zT() == null || aaq.zT().getPendantData() == null || StringUtils.isNull(aaq.zT().getPendantData().yF())) {
                this.cci.setVisibility(8);
                this.euN.getHeaderImg().setVisibility(0);
                this.euN.getHeaderImg().setData(aaq, !kVar.arf());
            } else {
                this.euN.getHeaderImg().setVisibility(4);
                this.cci.setVisibility(0);
                this.cci.setData(aaq);
            }
        }
        this.euN.setData(kVar.threadData);
        this.euN.setUserAfterClickListener(this.aLf);
        L(aaq);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> Ai = kVar.threadData.Ai();
        if (v.I(Ai)) {
            this.cYz.setVisibility(8);
            fw(false);
            z = false;
        } else {
            this.cYz.setVisibility(0);
            fw(true);
            VoiceData.VoiceModel voiceModel = Ai.get(0);
            this.cYz.setVoiceModel(voiceModel);
            this.cYz.setTag(voiceModel);
            this.cYz.aXt();
            if (voiceModel != null) {
                this.cYz.qK(voiceModel.voice_status.intValue());
            }
            this.cYz.bGc();
            z = true;
        }
        if (this.cVU.dbK && z) {
            this.cYC.setVisibility(8);
            this.euO.setVisibility(0);
        } else {
            ArrayList<MediaData> Ae = kVar.threadData.Ae();
            if (i.xR().xV() && v.H(Ae) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < Ae.size(); i++) {
                    MediaData mediaData = (MediaData) v.d(Ae, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.H(linkedList) > 0) {
                    this.cYC.setVisibility(0);
                    this.euO.setVisibility(8);
                    this.cYC.setFromCDN(this.aEU);
                    this.cYC.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<k> aqp = b.this.aqp();
                            if (aqp != null) {
                                view.setTag("1");
                                aqp.a(view, b.this.cVU);
                            }
                            if (z2) {
                                b.this.aqJ();
                            } else {
                                b.this.a(view, linkedList, i2, aaq);
                            }
                        }
                    });
                    this.cYC.setImageMediaList(linkedList);
                } else {
                    this.cYC.setVisibility(8);
                    this.euO.setVisibility(0);
                }
            } else {
                this.cYC.setVisibility(8);
                this.euO.setVisibility(0);
            }
        }
        aqI();
        setPageUniqueId(getTag());
        aFv();
        iM(hD(1));
    }

    private void fw(boolean z) {
        if (this.cYC != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYC.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10);
            }
            this.cYC.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.aEU ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zZ(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bbVar.getId();
        historyMessage.threadName = bbVar.getTitle();
        historyMessage.forumName = bbVar.zZ();
        historyMessage.postID = bbVar.Ak();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void aqI() {
        if (!this.cVU.bap) {
            this.cYz.setClickable(false);
        } else {
            this.cYz.setClickable(true);
        }
        int childCount = this.cYC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cYC.getChildAt(i);
            if (childAt != null) {
                if (!this.cVU.bap) {
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
        if (this.cYC != null) {
            this.cYC.setPageUniqueId(bdUniqueId);
        }
        if (this.euN != null) {
            this.euN.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.euN != null) {
            return this.euN.getHeaderImg();
        }
        return null;
    }

    public View aqs() {
        if (this.euN != null) {
            return this.euN.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqJ() {
        if (this.cVU != null && this.cVU.threadData != null) {
            if (!aqt()) {
                o.mW(this.cVU.threadData.getId());
                o.a(this.mTitle, this.cVU.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cYB, this.cVU.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVU.threadData, null, o.zH(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cVU.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cVU.threadData.zZ());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aqt() {
        return this.cVU.dbK && !this.cVU.bap;
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
        if (kVar == null || kVar.threadData == null || kVar.arf()) {
            this.cYB.setVisibility(8);
            return;
        }
        bb bbVar = kVar.threadData;
        if (hD(2) == 1) {
            SpannableString Bm = bbVar.Bm();
            if (Bm != null && !ao.isEmpty(Bm.toString())) {
                this.cYB.setVisibility(0);
                this.cYB.setOnTouchListener(new com.baidu.tieba.view.k(Bm));
                this.cYB.setText(Bm);
                o.a(this.cYB, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cYB.setVisibility(8);
            return;
        }
        this.cYB.setVisibility(8);
    }

    private void aFv() {
        if (this.mTitle != null && this.cYz != null && this.cYC != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYz.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
            this.cYz.setLayoutParams(layoutParams);
            if (this.cYz.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYC.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                this.cYC.setLayoutParams(layoutParams2);
            }
        }
    }

    public void iM(int i) {
        if (this.cVU != null && this.cVU.threadData != null) {
            if (!this.cVU.arf() && i == 1) {
                this.cby.setVisibility(8);
                this.ccl.setStType(o.zH());
                this.ccl.setData(this.cVU.threadData);
                this.euN.showForumNameView(false);
                return;
            }
            this.cby.setData(this.cVU.threadData);
            this.cby.setStType(o.zH());
            this.ccl.setVisibility(8);
            this.euN.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cYC != null) {
            this.cYC.setPreloadSizeReadyCallback(bVar);
        }
    }
}
