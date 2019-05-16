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
    public ThreadSourceShareAndPraiseLayout dBS;
    public ThreadCommentAndPraiseInfoLayout dBe;
    protected LinearLayout dCd;
    private k exM;
    private ConstrainImageGroup exN;
    private View exO;
    private View.OnClickListener exS;
    private final View.OnClickListener exT;
    private HeadPendantClickableView exk;
    public ConcernThreadUserInfoLayout fYe;
    public ConcernForumThreadUserInfoLayout fYf;
    public d fYg;
    private View fYh;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.XJ = true;
        this.exS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXo() != null) {
                    a.this.aXo().a(view, a.this.exM);
                }
                a.this.aoV();
            }
        };
        this.exT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aXo = a.this.aXo();
                if (aXo != null) {
                    view.setTag("2");
                    aXo.a(view, a.this.exM);
                }
            }
        };
        this.XA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXo() != null) {
                    a.this.aXo().a(view, a.this.exM);
                }
            }
        };
        this.bZt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXo() != null) {
                    a.this.aXo().a(view, a.this.exM);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.exk = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.exk.getHeadView() != null) {
            this.exk.getHeadView().setIsRound(true);
            this.exk.getHeadView().setDrawBorder(false);
            this.exk.getHeadView().setDefaultResource(17170445);
            this.exk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.exk.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.exk.getHeadView().setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.exk.getPendantView() != null) {
            this.exk.getPendantView().setIsRound(true);
            this.exk.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.XS = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.XS.setAfterClickListener(this.exT);
        this.VC = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.VC.setVisibility(8);
        this.exN = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.exO = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.exN.setChildClickListener(this.exS);
        this.exN.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.exN.setImageProcessor(fVar);
        this.dBe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.dBe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dBe.setLayoutParams(layoutParams);
        }
        this.dBe.setOnClickListener(this.exS);
        this.dBe.setReplyTimeVisible(false);
        this.dBe.setIsBarViewVisible(false);
        this.dBe.setShowPraiseNum(true);
        this.dBe.setNeedAddPraiseIcon(true);
        this.dBe.setNeedAddReplyIcon(true);
        this.dBe.setShareVisible(true);
        this.dBe.setShareReportFrom(4);
        this.dBe.setFrom(9);
        this.dBe.setDisPraiseFrom(4);
        this.dBe.caC = this.currentPageType;
        this.dBe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aXo() != null) {
                    a.this.aXo().a(view2, a.this.exM);
                }
                if (a.this.exM != null && a.this.exM.threadData != null) {
                    n.uS(a.this.exM.threadData.getId());
                    a.this.bsT();
                }
            }
        });
        this.dBS = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.dBS.cbw.setOnClickListener(this.exS);
        this.dBS.setShareReportFrom(4);
        this.dBS.setFrom(9);
        this.dBS.cbw.caC = this.currentPageType;
        this.dBS.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aXo() != null) {
                    a.this.aXo().a(view2, a.this.exM);
                }
                if (a.this.exM != null && a.this.exM.threadData != null && view2 != a.this.dBS.caL) {
                    n.uS(a.this.exM.threadData.getId());
                    a.this.bsT();
                }
            }
        });
        this.dCd = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.fYh = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.exN != null) {
            this.exN.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.exN != null) {
            this.exN.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.exN != null) {
            this.exN.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.drawable.addresslist_item_bg);
            this.exN.onChangeSkinType();
            this.dBe.onChangeSkinType();
            al.l(this.exO, R.color.cp_bg_line_e);
            this.dBS.onChangeSkinType();
        }
        if (this.fYe != null && this.fYe.getVisibility() == 0) {
            this.fYe.onChangeSkinType(i);
        }
        if (this.fYf != null && this.fYf.getVisibility() == 0) {
            this.fYf.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsT() {
        if (this.exM != null && this.exM.threadData.getId() != null) {
            n.a(this.mTitle, this.exM.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VC, this.exM.threadData.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bsU() {
        if (this.fYe == null) {
            this.fYe = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bsV() {
        if (this.fYf == null) {
            this.fYf = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.fYf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aXo() != null) {
                    a.this.aXo().a(view, a.this.exM);
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
        this.exM = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.exS);
        }
        if (kVar.aYb()) {
            bsV();
            this.fYg = this.fYf;
            this.fYf.setVisibility(0);
            if (this.fYe != null) {
                this.fYe.setVisibility(8);
            }
        } else {
            bsU();
            this.fYg = this.fYe;
            this.fYe.setVisibility(0);
            if (this.fYf != null) {
                this.fYf.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aXy() && n.uT(this.exM.threadData.getId())) {
            bsT();
        }
        final bg abv = kVar.abv();
        if (this.fYg.getHeaderImg() != null) {
            if (this.fYg.getIsSimpleThread()) {
                this.fYg.getHeaderImg().setVisibility(8);
                this.exk.setVisibility(8);
            } else if (abv.adv() == null || abv.adv().getPendantData() == null || StringUtils.isNull(abv.adv().getPendantData().abS())) {
                this.exk.setVisibility(8);
                this.fYg.getHeaderImg().setVisibility(0);
                this.fYg.getHeaderImg().setData(abv, !kVar.aYb());
            } else {
                this.fYg.getHeaderImg().setVisibility(4);
                this.exk.setVisibility(0);
                this.exk.setData(abv);
            }
        }
        this.fYg.setData(kVar.threadData);
        this.fYg.setUserAfterClickListener(this.XA);
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
            this.XS.bFA();
            if (voiceModel != null) {
                this.XS.vx(voiceModel.voice_status.intValue());
            }
            this.XS.cnD();
            z = true;
        }
        if (this.exM.eBj && z) {
            this.exN.setVisibility(8);
            this.fYh.setVisibility(0);
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
                    this.exN.setVisibility(0);
                    this.fYh.setVisibility(8);
                    this.exN.setFromCDN(this.XJ);
                    this.exN.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z2) {
                            ab<k> aXo = a.this.aXo();
                            if (aXo != null) {
                                view.setTag("1");
                                aXo.a(view, a.this.exM);
                            }
                            if (z2) {
                                a.this.aoV();
                            } else {
                                a.this.a(view, linkedList, i2, abv);
                            }
                        }
                    });
                    this.exN.setImageMediaList(linkedList);
                } else {
                    this.exN.setVisibility(8);
                    this.fYh.setVisibility(0);
                }
            } else {
                this.exN.setVisibility(8);
                this.fYh.setVisibility(0);
            }
        }
        aXG();
        setPageUniqueId(getTag());
        bnk();
        nv(mh(1));
    }

    private void it(boolean z) {
        if (this.exN != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.exN.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.exN.setLayoutParams(layoutParams);
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

    private void aXG() {
        if (!this.exM.crZ) {
            this.XS.setClickable(false);
        } else {
            this.XS.setClickable(true);
        }
        int childCount = this.exN.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.exN.getChildAt(i);
            if (childAt != null) {
                if (!this.exM.crZ) {
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
        if (this.exN != null) {
            this.exN.setPageUniqueId(bdUniqueId);
        }
        if (this.fYg != null) {
            this.fYg.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fYg != null) {
            return this.fYg.getHeaderImg();
        }
        return null;
    }

    public View aXt() {
        if (this.fYg != null) {
            return this.fYg.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoV() {
        if (this.exM != null && this.exM.threadData != null) {
            if (!aXy()) {
                n.uS(this.exM.threadData.getId());
                n.a(this.mTitle, this.exM.abv().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.VC, this.exM.threadData.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.exM.threadData, null, n.adi(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.exM.threadData.getFid()));
            createFromThreadCfg.setForumName(this.exM.threadData.adA());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aXy() {
        return this.exM.eBj && !this.exM.crZ;
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
        if (kVar == null || kVar.threadData == null || kVar.aYb()) {
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

    private void bnk() {
        if (this.mTitle != null && this.XS != null && this.exN != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XS.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.XS.setLayoutParams(layoutParams);
            if (this.XS.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.exN.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.exN.setLayoutParams(layoutParams2);
            }
        }
    }

    public void nv(int i) {
        if (this.exM != null && this.exM.threadData != null) {
            if (!this.exM.aYb() && i == 1) {
                this.dBe.setVisibility(8);
                this.dBS.setStType(n.adi());
                this.dBS.setData(this.exM.threadData);
                this.fYg.ej(false);
                return;
            }
            this.dBe.setData(this.exM.threadData);
            this.dBe.setStType(n.adi());
            this.dBS.setVisibility(8);
            this.fYg.ej(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }

    public int mh(int i) {
        return com.baidu.tieba.a.d.aBn().ag(this.Wt, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.exN != null) {
            this.exN.setPreloadSizeReadyCallback(bVar);
        }
    }
}
