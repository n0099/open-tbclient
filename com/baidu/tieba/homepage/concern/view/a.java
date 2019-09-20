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
    private TextView VV;
    private String WM;
    private final View.OnClickListener XU;
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    private final View.OnClickListener cbv;
    public ThreadCommentAndPraiseInfoLayout dGt;
    public ThreadSourceShareAndPraiseLayout dHg;
    protected LinearLayout dHr;
    private k eEB;
    private ConstrainImageGroup eEC;
    private View eED;
    private View.OnClickListener eEH;
    private final View.OnClickListener eEI;
    private HeadPendantClickableView eEa;
    public ConcernThreadUserInfoLayout gfM;
    public ConcernForumThreadUserInfoLayout gfN;
    public d gfO;
    private View gfP;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Yd = true;
        this.eEH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view, a.this.eEB);
                }
                a.this.aqp();
            }
        };
        this.eEI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aZU = a.this.aZU();
                if (aZU != null) {
                    view.setTag("2");
                    aZU.a(view, a.this.eEB);
                }
            }
        };
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view, a.this.eEB);
                }
            }
        };
        this.cbv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view, a.this.eEB);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.eEa = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.eEa.getHeadView() != null) {
            this.eEa.getHeadView().setIsRound(true);
            this.eEa.getHeadView().setDrawBorder(false);
            this.eEa.getHeadView().setDefaultResource(17170445);
            this.eEa.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eEa.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.eEa.getHeadView().setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.eEa.getPendantView() != null) {
            this.eEa.getPendantView().setIsRound(true);
            this.eEa.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.Ym = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.Ym.setAfterClickListener(this.eEI);
        this.VV = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.VV.setVisibility(8);
        this.eEC = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.eED = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.eEC.setChildClickListener(this.eEH);
        this.eEC.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.eEC.setImageProcessor(fVar);
        this.dGt = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.dGt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dGt.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dGt.setLayoutParams(layoutParams);
        }
        this.dGt.setOnClickListener(this.eEH);
        this.dGt.setReplyTimeVisible(false);
        this.dGt.setIsBarViewVisible(false);
        this.dGt.setShowPraiseNum(true);
        this.dGt.setNeedAddPraiseIcon(true);
        this.dGt.setNeedAddReplyIcon(true);
        this.dGt.setShareVisible(true);
        this.dGt.setShareReportFrom(4);
        this.dGt.setFrom(9);
        this.dGt.setDisPraiseFrom(4);
        this.dGt.ccG = this.currentPageType;
        this.dGt.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view2, a.this.eEB);
                }
                if (a.this.eEB != null && a.this.eEB.threadData != null) {
                    n.vW(a.this.eEB.threadData.getId());
                    a.this.bwa();
                }
            }
        });
        this.dHg = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.dHg.cdA.setOnClickListener(this.eEH);
        this.dHg.setShareReportFrom(4);
        this.dHg.setFrom(9);
        this.dHg.cdA.ccG = this.currentPageType;
        this.dHg.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view2, a.this.eEB);
                }
                if (a.this.eEB != null && a.this.eEB.threadData != null && view2 != a.this.dHg.ccP) {
                    n.vW(a.this.eEB.threadData.getId());
                    a.this.bwa();
                }
            }
        });
        this.dHr = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gfP = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eEC != null) {
            this.eEC.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eEC != null) {
            this.eEC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eEC != null) {
            this.eEC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.addresslist_item_bg);
            this.eEC.onChangeSkinType();
            this.dGt.onChangeSkinType();
            am.l(this.eED, R.color.cp_bg_line_c);
            this.dHg.onChangeSkinType();
        }
        if (this.gfM != null && this.gfM.getVisibility() == 0) {
            this.gfM.onChangeSkinType(i);
        }
        if (this.gfN != null && this.gfN.getVisibility() == 0) {
            this.gfN.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwa() {
        if (this.eEB != null && this.eEB.threadData.getId() != null) {
            n.a(this.mTitle, this.eEB.acC().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VV, this.eEB.threadData.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bwb() {
        if (this.gfM == null) {
            this.gfM = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bwc() {
        if (this.gfN == null) {
            this.gfN = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.gfN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZU() != null) {
                    a.this.aZU().a(view, a.this.eEB);
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
        this.eEB = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eEH);
        }
        if (kVar.baJ()) {
            bwc();
            this.gfO = this.gfN;
            this.gfN.setVisibility(0);
            if (this.gfM != null) {
                this.gfM.setVisibility(8);
            }
        } else {
            bwb();
            this.gfO = this.gfM;
            this.gfM.setVisibility(0);
            if (this.gfN != null) {
                this.gfN.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!bae() && n.vX(this.eEB.threadData.getId())) {
            bwa();
        }
        final bh acC = kVar.acC();
        if (this.gfO.getHeaderImg() != null) {
            if (this.gfO.getIsSimpleThread()) {
                this.gfO.getHeaderImg().setVisibility(8);
                this.eEa.setVisibility(8);
            } else if (acC.aeC() == null || acC.aeC().getPendantData() == null || StringUtils.isNull(acC.aeC().getPendantData().acZ())) {
                this.eEa.setVisibility(8);
                this.gfO.getHeaderImg().setVisibility(0);
                this.gfO.getHeaderImg().setData(acC, !kVar.baJ());
            } else {
                this.gfO.getHeaderImg().setVisibility(4);
                this.eEa.setVisibility(0);
                this.eEa.setData(acC);
            }
        }
        this.gfO.setData(kVar.threadData);
        this.gfO.setUserAfterClickListener(this.XU);
        ai(acC);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aeQ = kVar.threadData.aeQ();
        if (v.aa(aeQ)) {
            this.Ym.setVisibility(8);
            iF(false);
            z = false;
        } else {
            this.Ym.setVisibility(0);
            iF(true);
            VoiceData.VoiceModel voiceModel = aeQ.get(0);
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bql();
            if (voiceModel != null) {
                this.Ym.we(voiceModel.voice_status.intValue());
            }
            this.Ym.crJ();
            z = true;
        }
        if (this.eEB.eHW && z) {
            this.eEC.setVisibility(8);
            this.gfP.setVisibility(0);
        } else {
            ArrayList<MediaData> aeM = kVar.threadData.aeM();
            if (i.ace().aci() && v.Z(aeM) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aeM.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(aeM, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.Z(linkedList) > 0) {
                    this.eEC.setVisibility(0);
                    this.gfP.setVisibility(8);
                    this.eEC.setFromCDN(this.Yd);
                    this.eEC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z2) {
                            ab<k> aZU = a.this.aZU();
                            if (aZU != null) {
                                view.setTag("1");
                                aZU.a(view, a.this.eEB);
                            }
                            if (z2) {
                                a.this.aqp();
                            } else {
                                a.this.a(view, linkedList, i2, acC);
                            }
                        }
                    });
                    this.eEC.setImageMediaList(linkedList);
                } else {
                    this.eEC.setVisibility(8);
                    this.gfP.setVisibility(0);
                }
            } else {
                this.eEC.setVisibility(8);
                this.gfP.setVisibility(0);
            }
        }
        ban();
        setPageUniqueId(getTag());
        bqn();
        nJ(mt(1));
    }

    private void iF(boolean z) {
        if (this.eEC != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEC.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.eEC.setLayoutParams(layoutParams);
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
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.e(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aeH(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bhVar.getId();
        historyMessage.threadName = bhVar.getTitle();
        historyMessage.forumName = bhVar.aeH();
        historyMessage.postID = bhVar.aeS();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void ban() {
        if (!this.eEB.cuq) {
            this.Ym.setClickable(false);
        } else {
            this.Ym.setClickable(true);
        }
        int childCount = this.eEC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eEC.getChildAt(i);
            if (childAt != null) {
                if (!this.eEB.cuq) {
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
        if (this.eEC != null) {
            this.eEC.setPageUniqueId(bdUniqueId);
        }
        if (this.gfO != null) {
            this.gfO.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gfO != null) {
            return this.gfO.getHeaderImg();
        }
        return null;
    }

    public View aZZ() {
        if (this.gfO != null) {
            return this.gfO.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqp() {
        if (this.eEB != null && this.eEB.threadData != null) {
            if (!bae()) {
                n.vW(this.eEB.threadData.getId());
                n.a(this.mTitle, this.eEB.acC().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.VV, this.eEB.threadData.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.eEB.threadData, null, n.aep(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.eEB.threadData.getFid()));
            createFromThreadCfg.setForumName(this.eEB.threadData.aeH());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean bae() {
        return this.eEB.eHW && !this.eEB.cuq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean ai(bh bhVar) {
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
        if (kVar == null || kVar.threadData == null || kVar.baJ()) {
            this.VV.setVisibility(8);
            return;
        }
        bh bhVar = kVar.threadData;
        if (mt(2) == 1) {
            SpannableString agd = bhVar.agd();
            if (agd != null && !aq.isEmpty(agd.toString())) {
                this.VV.setVisibility(0);
                this.VV.setOnTouchListener(new com.baidu.tieba.view.k(agd));
                this.VV.setText(agd);
                n.a(this.VV, bhVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.VV.setVisibility(8);
            return;
        }
        this.VV.setVisibility(8);
    }

    private void bqn() {
        if (this.mTitle != null && this.Ym != null && this.eEC != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ym.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.Ym.setLayoutParams(layoutParams);
            if (this.Ym.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eEC.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.eEC.setLayoutParams(layoutParams2);
            }
        }
    }

    public void nJ(int i) {
        if (this.eEB != null && this.eEB.threadData != null) {
            if (!this.eEB.baJ() && i == 1) {
                this.dGt.setVisibility(8);
                this.dHg.setStType(n.aep());
                this.dHg.setData(this.eEB.threadData);
                this.gfO.eq(false);
                return;
            }
            this.dGt.setData(this.eEB.threadData);
            this.dGt.setStType(n.aep());
            this.dHg.setVisibility(8);
            this.gfO.eq(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WM = str;
    }

    public int mt(int i) {
        return com.baidu.tieba.a.d.aCV().ag(this.WM, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eEC != null) {
            this.eEC.setPreloadSizeReadyCallback(bVar);
        }
    }
}
