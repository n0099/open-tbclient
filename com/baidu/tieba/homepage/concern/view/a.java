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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
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
    private TextView VW;
    private String WN;
    private final View.OnClickListener XU;
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    private final View.OnClickListener caC;
    public ThreadCommentAndPraiseInfoLayout dEI;
    protected LinearLayout dFG;
    public ThreadSourceShareAndPraiseLayout dFv;
    private k eCS;
    private ConstrainImageGroup eCT;
    private View eCU;
    private View.OnClickListener eCY;
    private final View.OnClickListener eCZ;
    private HeadPendantClickableView eCr;
    public ConcernThreadUserInfoLayout gdU;
    public ConcernForumThreadUserInfoLayout gdV;
    public d gdW;
    private View gdX;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Yd = true;
        this.eCY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view, a.this.eCS);
                }
                a.this.aqd();
            }
        };
        this.eCZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aZq = a.this.aZq();
                if (aZq != null) {
                    view.setTag("2");
                    aZq.a(view, a.this.eCS);
                }
            }
        };
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view, a.this.eCS);
                }
            }
        };
        this.caC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view, a.this.eCS);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.eCr = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.eCr.getHeadView() != null) {
            this.eCr.getHeadView().setIsRound(true);
            this.eCr.getHeadView().setDrawBorder(false);
            this.eCr.getHeadView().setDefaultResource(17170445);
            this.eCr.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCr.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.eCr.getHeadView().setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.eCr.getPendantView() != null) {
            this.eCr.getPendantView().setIsRound(true);
            this.eCr.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.Ym = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.Ym.setAfterClickListener(this.eCZ);
        this.VW = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.VW.setVisibility(8);
        this.eCT = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.eCU = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.eCT.setChildClickListener(this.eCY);
        this.eCT.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.eCT.setImageProcessor(fVar);
        this.dEI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.dEI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dEI.setLayoutParams(layoutParams);
        }
        this.dEI.setOnClickListener(this.eCY);
        this.dEI.setReplyTimeVisible(false);
        this.dEI.setIsBarViewVisible(false);
        this.dEI.setShowPraiseNum(true);
        this.dEI.setNeedAddPraiseIcon(true);
        this.dEI.setNeedAddReplyIcon(true);
        this.dEI.setShareVisible(true);
        this.dEI.setShareReportFrom(4);
        this.dEI.setFrom(9);
        this.dEI.setDisPraiseFrom(4);
        this.dEI.cbM = this.currentPageType;
        this.dEI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view2, a.this.eCS);
                }
                if (a.this.eCS != null && a.this.eCS.threadData != null) {
                    n.vx(a.this.eCS.threadData.getId());
                    a.this.bvm();
                }
            }
        });
        this.dFv = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.dFv.ccH.setOnClickListener(this.eCY);
        this.dFv.setShareReportFrom(4);
        this.dFv.setFrom(9);
        this.dFv.ccH.cbM = this.currentPageType;
        this.dFv.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view2, a.this.eCS);
                }
                if (a.this.eCS != null && a.this.eCS.threadData != null && view2 != a.this.dFv.cbV) {
                    n.vx(a.this.eCS.threadData.getId());
                    a.this.bvm();
                }
            }
        });
        this.dFG = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gdX = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eCT != null) {
            this.eCT.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCT != null) {
            this.eCT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCT != null) {
            this.eCT.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.addresslist_item_bg);
            this.eCT.onChangeSkinType();
            this.dEI.onChangeSkinType();
            am.l(this.eCU, R.color.cp_bg_line_e);
            this.dFv.onChangeSkinType();
        }
        if (this.gdU != null && this.gdU.getVisibility() == 0) {
            this.gdU.onChangeSkinType(i);
        }
        if (this.gdV != null && this.gdV.getVisibility() == 0) {
            this.gdV.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvm() {
        if (this.eCS != null && this.eCS.threadData.getId() != null) {
            n.a(this.mTitle, this.eCS.acy().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VW, this.eCS.threadData.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bvn() {
        if (this.gdU == null) {
            this.gdU = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bvo() {
        if (this.gdV == null) {
            this.gdV = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.gdV.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZq() != null) {
                    a.this.aZq().a(view, a.this.eCS);
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
        this.eCS = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eCY);
        }
        if (kVar.baf()) {
            bvo();
            this.gdW = this.gdV;
            this.gdV.setVisibility(0);
            if (this.gdU != null) {
                this.gdU.setVisibility(8);
            }
        } else {
            bvn();
            this.gdW = this.gdU;
            this.gdU.setVisibility(0);
            if (this.gdV != null) {
                this.gdV.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aZA() && n.vy(this.eCS.threadData.getId())) {
            bvm();
        }
        final bh acy = kVar.acy();
        if (this.gdW.getHeaderImg() != null) {
            if (this.gdW.getIsSimpleThread()) {
                this.gdW.getHeaderImg().setVisibility(8);
                this.eCr.setVisibility(8);
            } else if (acy.aey() == null || acy.aey().getPendantData() == null || StringUtils.isNull(acy.aey().getPendantData().acV())) {
                this.eCr.setVisibility(8);
                this.gdW.getHeaderImg().setVisibility(0);
                this.gdW.getHeaderImg().setData(acy, !kVar.baf());
            } else {
                this.gdW.getHeaderImg().setVisibility(4);
                this.eCr.setVisibility(0);
                this.eCr.setData(acy);
            }
        }
        this.gdW.setData(kVar.threadData);
        this.gdW.setUserAfterClickListener(this.XU);
        ah(acy);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aeM = kVar.threadData.aeM();
        if (v.aa(aeM)) {
            this.Ym.setVisibility(8);
            iC(false);
            z = false;
        } else {
            this.Ym.setVisibility(0);
            iC(true);
            VoiceData.VoiceModel voiceModel = aeM.get(0);
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bIz();
            if (voiceModel != null) {
                this.Ym.wa(voiceModel.voice_status.intValue());
            }
            this.Ym.cqV();
            z = true;
        }
        if (this.eCS.eGn && z) {
            this.eCT.setVisibility(8);
            this.gdX.setVisibility(0);
        } else {
            ArrayList<MediaData> aeI = kVar.threadData.aeI();
            if (i.aca().ace() && v.Z(aeI) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aeI.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(aeI, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.Z(linkedList) > 0) {
                    this.eCT.setVisibility(0);
                    this.gdX.setVisibility(8);
                    this.eCT.setFromCDN(this.Yd);
                    this.eCT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z2) {
                            ab<k> aZq = a.this.aZq();
                            if (aZq != null) {
                                view.setTag("1");
                                aZq.a(view, a.this.eCS);
                            }
                            if (z2) {
                                a.this.aqd();
                            } else {
                                a.this.a(view, linkedList, i2, acy);
                            }
                        }
                    });
                    this.eCT.setImageMediaList(linkedList);
                } else {
                    this.eCT.setVisibility(8);
                    this.gdX.setVisibility(0);
                }
            } else {
                this.eCT.setVisibility(8);
                this.gdX.setVisibility(0);
            }
        }
        aZJ();
        setPageUniqueId(getTag());
        bpB();
        nF(mp(1));
    }

    private void iC(boolean z) {
        if (this.eCT != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCT.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.eCT.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                    imageUrlData.urlType = this.Yd ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aeD(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bhVar.getId();
        historyMessage.threadName = bhVar.getTitle();
        historyMessage.forumName = bhVar.aeD();
        historyMessage.postID = bhVar.aeO();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void aZJ() {
        if (!this.eCS.ctu) {
            this.Ym.setClickable(false);
        } else {
            this.Ym.setClickable(true);
        }
        int childCount = this.eCT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eCT.getChildAt(i);
            if (childAt != null) {
                if (!this.eCS.ctu) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eCT != null) {
            this.eCT.setPageUniqueId(bdUniqueId);
        }
        if (this.gdW != null) {
            this.gdW.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gdW != null) {
            return this.gdW.getHeaderImg();
        }
        return null;
    }

    public View aZv() {
        if (this.gdW != null) {
            return this.gdW.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqd() {
        if (this.eCS != null && this.eCS.threadData != null) {
            if (!aZA()) {
                n.vx(this.eCS.threadData.getId());
                n.a(this.mTitle, this.eCS.acy().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.VW, this.eCS.threadData.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.eCS.threadData, null, n.ael(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.eCS.threadData.getFid()));
            createFromThreadCfg.setForumName(this.eCS.threadData.aeD());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aZA() {
        return this.eCS.eGn && !this.eCS.ctu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean ah(bh bhVar) {
        SpannableStringBuilder o = bhVar.o(false, true);
        if (o == null || StringUtils.isNull(o.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(o));
            this.mTitle.setText(o);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.baf()) {
            this.VW.setVisibility(8);
            return;
        }
        bh bhVar = kVar.threadData;
        if (mp(2) == 1) {
            SpannableString afZ = bhVar.afZ();
            if (afZ != null && !aq.isEmpty(afZ.toString())) {
                this.VW.setVisibility(0);
                this.VW.setOnTouchListener(new com.baidu.tieba.view.k(afZ));
                this.VW.setText(afZ);
                n.a(this.VW, bhVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.VW.setVisibility(8);
            return;
        }
        this.VW.setVisibility(8);
    }

    private void bpB() {
        if (this.mTitle != null && this.Ym != null && this.eCT != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ym.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.Ym.setLayoutParams(layoutParams);
            if (this.Ym.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eCT.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.eCT.setLayoutParams(layoutParams2);
            }
        }
    }

    public void nF(int i) {
        if (this.eCS != null && this.eCS.threadData != null) {
            if (!this.eCS.baf() && i == 1) {
                this.dEI.setVisibility(8);
                this.dFv.setStType(n.ael());
                this.dFv.setData(this.eCS.threadData);
                this.gdW.en(false);
                return;
            }
            this.dEI.setData(this.eCS.threadData);
            this.dEI.setStType(n.ael());
            this.dFv.setVisibility(8);
            this.gdW.en(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mp(int i) {
        return com.baidu.tieba.a.d.aCH().ag(this.WN, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eCT != null) {
            this.eCT.setPreloadSizeReadyCallback(bVar);
        }
    }
}
