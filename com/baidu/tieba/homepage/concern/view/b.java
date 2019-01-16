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
    private boolean aET;
    private final View.OnClickListener aJa;
    private final View.OnClickListener aLe;
    private View cVS;
    private k cVT;
    private View.OnClickListener cVU;
    private TextView cYA;
    private ConstrainImageGroup cYB;
    private final View.OnClickListener cYE;
    public PlayVoiceBntNew cYy;
    private String cbk;
    public ThreadCommentAndPraiseInfoLayout cbx;
    private HeadPendantClickableView cch;
    public ThreadSourceShareAndPraiseLayout cck;
    protected LinearLayout ccw;
    public ConcernThreadUserInfoLayout euJ;
    public ConcernForumThreadUserInfoLayout euL;
    public com.baidu.tbadk.core.view.f euM;
    private View euN;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aET = true;
        this.cVU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view, b.this.cVT);
                }
                b.this.aqJ();
            }
        };
        this.cYE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<k> aqp = b.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, b.this.cVT);
                }
            }
        };
        this.aLe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view, b.this.cVT);
                }
            }
        };
        this.aJa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view, b.this.cVT);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cch = (HeadPendantClickableView) view.findViewById(e.g.card_concern_normal_thread_user_pendant_header);
        if (this.cch.getHeadView() != null) {
            this.cch.getHeadView().setIsRound(true);
            this.cch.getHeadView().setDrawBorder(false);
            this.cch.getHeadView().setDefaultResource(17170445);
            this.cch.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cch.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cch.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds60));
        }
        if (this.cch.getPendantView() != null) {
            this.cch.getPendantView().setIsRound(true);
            this.cch.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_normal_thread_title);
        this.cYy = (PlayVoiceBntNew) view.findViewById(e.g.card_concern_normal_thread_abstract_voice);
        this.cYy.setAfterClickListener(this.cYE);
        this.cYA = (TextView) view.findViewById(e.g.card_concern_normal_thread_abstract);
        this.cYA.setVisibility(8);
        this.cYB = (ConstrainImageGroup) view.findViewById(e.g.card_concern_normal_thread_img_layout);
        this.cVS = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.cYB.setChildClickListener(this.cVU);
        this.cYB.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cYB.setImageProcessor(eVar);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_normal_thread_info_layout);
        if (this.cbx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbx.setLayoutParams(layoutParams);
        }
        this.cbx.setOnClickListener(this.cVU);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setIsBarViewVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setShareVisible(true);
        this.cbx.setShareReportFrom(4);
        this.cbx.setFrom(9);
        this.cbx.setDisPraiseFrom(4);
        this.cbx.awo = this.currentPageType;
        this.cbx.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view2, b.this.cVT);
                }
                if (b.this.cVT != null && b.this.cVT.threadData != null) {
                    o.mW(b.this.cVT.threadData.getId());
                    b.this.aqu();
                }
            }
        });
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_nomal_source_read_share_layout);
        this.cck.aKM.setOnClickListener(this.cVU);
        this.cck.setShareReportFrom(4);
        this.cck.setFrom(9);
        this.cck.aKM.awo = this.currentPageType;
        this.cck.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view2, b.this.cVT);
                }
                if (b.this.cVT != null && b.this.cVT.threadData != null && view2 != b.this.cck.aKL) {
                    o.mW(b.this.cVT.threadData.getId());
                    b.this.aqu();
                }
            }
        });
        this.ccw = (LinearLayout) view.findViewById(e.g.card_concern_normal_thread_content_layout);
        this.euN = view.findViewById(e.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cYB != null) {
            this.cYB.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYB != null) {
            this.cYB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYB != null) {
            this.cYB.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.cYB.onChangeSkinType();
            this.cbx.onChangeSkinType();
            al.j(this.cVS, e.d.cp_bg_line_e);
            this.cck.onChangeSkinType();
        }
        if (this.euJ != null && this.euJ.getVisibility() == 0) {
            this.euJ.onChangeSkinType(i);
        }
        if (this.euL != null && this.euL.getVisibility() == 0) {
            this.euL.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqu() {
        if (this.cVT != null && this.cVT.threadData.getId() != null) {
            o.a(this.mTitle, this.cVT.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cYA, this.cVT.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_normal_thread;
    }

    private void aLy() {
        if (this.euJ == null) {
            this.euJ = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aLz() {
        if (this.euL == null) {
            this.euL = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.euL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aqp() != null) {
                    b.this.aqp().a(view, b.this.cVT);
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
        this.cVT = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVU);
        }
        if (kVar.arf()) {
            aLz();
            this.euM = this.euL;
            this.euL.setVisibility(0);
            if (this.euJ != null) {
                this.euJ.setVisibility(8);
            }
        } else {
            aLy();
            this.euM = this.euJ;
            this.euJ.setVisibility(0);
            if (this.euL != null) {
                this.euL.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aqt() && o.mX(this.cVT.threadData.getId())) {
            aqu();
        }
        final bb aaq = kVar.aaq();
        if (this.euM.getHeaderImg() != null) {
            if (this.euM.getIsSimpleThread()) {
                this.euM.getHeaderImg().setVisibility(8);
                this.cch.setVisibility(8);
            } else if (aaq.zT() == null || aaq.zT().getPendantData() == null || StringUtils.isNull(aaq.zT().getPendantData().yF())) {
                this.cch.setVisibility(8);
                this.euM.getHeaderImg().setVisibility(0);
                this.euM.getHeaderImg().setData(aaq, !kVar.arf());
            } else {
                this.euM.getHeaderImg().setVisibility(4);
                this.cch.setVisibility(0);
                this.cch.setData(aaq);
            }
        }
        this.euM.setData(kVar.threadData);
        this.euM.setUserAfterClickListener(this.aLe);
        L(aaq);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> Ai = kVar.threadData.Ai();
        if (v.I(Ai)) {
            this.cYy.setVisibility(8);
            fw(false);
            z = false;
        } else {
            this.cYy.setVisibility(0);
            fw(true);
            VoiceData.VoiceModel voiceModel = Ai.get(0);
            this.cYy.setVoiceModel(voiceModel);
            this.cYy.setTag(voiceModel);
            this.cYy.aXt();
            if (voiceModel != null) {
                this.cYy.qK(voiceModel.voice_status.intValue());
            }
            this.cYy.bGc();
            z = true;
        }
        if (this.cVT.dbJ && z) {
            this.cYB.setVisibility(8);
            this.euN.setVisibility(0);
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
                    this.cYB.setVisibility(0);
                    this.euN.setVisibility(8);
                    this.cYB.setFromCDN(this.aET);
                    this.cYB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<k> aqp = b.this.aqp();
                            if (aqp != null) {
                                view.setTag("1");
                                aqp.a(view, b.this.cVT);
                            }
                            if (z2) {
                                b.this.aqJ();
                            } else {
                                b.this.a(view, linkedList, i2, aaq);
                            }
                        }
                    });
                    this.cYB.setImageMediaList(linkedList);
                } else {
                    this.cYB.setVisibility(8);
                    this.euN.setVisibility(0);
                }
            } else {
                this.cYB.setVisibility(8);
                this.euN.setVisibility(0);
            }
        }
        aqI();
        setPageUniqueId(getTag());
        aFv();
        iM(hD(1));
    }

    private void fw(boolean z) {
        if (this.cYB != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYB.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10);
            }
            this.cYB.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.aET ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zZ(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aET, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        if (!this.cVT.bao) {
            this.cYy.setClickable(false);
        } else {
            this.cYy.setClickable(true);
        }
        int childCount = this.cYB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cYB.getChildAt(i);
            if (childAt != null) {
                if (!this.cVT.bao) {
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
        if (this.cYB != null) {
            this.cYB.setPageUniqueId(bdUniqueId);
        }
        if (this.euM != null) {
            this.euM.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.euM != null) {
            return this.euM.getHeaderImg();
        }
        return null;
    }

    public View aqs() {
        if (this.euM != null) {
            return this.euM.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqJ() {
        if (this.cVT != null && this.cVT.threadData != null) {
            if (!aqt()) {
                o.mW(this.cVT.threadData.getId());
                o.a(this.mTitle, this.cVT.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cYA, this.cVT.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVT.threadData, null, o.zH(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cVT.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cVT.threadData.zZ());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aqt() {
        return this.cVT.dbJ && !this.cVT.bao;
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
            this.cYA.setVisibility(8);
            return;
        }
        bb bbVar = kVar.threadData;
        if (hD(2) == 1) {
            SpannableString Bm = bbVar.Bm();
            if (Bm != null && !ao.isEmpty(Bm.toString())) {
                this.cYA.setVisibility(0);
                this.cYA.setOnTouchListener(new com.baidu.tieba.view.k(Bm));
                this.cYA.setText(Bm);
                o.a(this.cYA, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cYA.setVisibility(8);
            return;
        }
        this.cYA.setVisibility(8);
    }

    private void aFv() {
        if (this.mTitle != null && this.cYy != null && this.cYB != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYy.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
            this.cYy.setLayoutParams(layoutParams);
            if (this.cYy.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYB.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                this.cYB.setLayoutParams(layoutParams2);
            }
        }
    }

    public void iM(int i) {
        if (this.cVT != null && this.cVT.threadData != null) {
            if (!this.cVT.arf() && i == 1) {
                this.cbx.setVisibility(8);
                this.cck.setStType(o.zH());
                this.cck.setData(this.cVT.threadData);
                this.euM.showForumNameView(false);
                return;
            }
            this.cbx.setData(this.cVT.threadData);
            this.cbx.setStType(o.zH());
            this.cck.setVisibility(8);
            this.euM.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cYB != null) {
            this.cYB.setPreloadSizeReadyCallback(bVar);
        }
    }
}
