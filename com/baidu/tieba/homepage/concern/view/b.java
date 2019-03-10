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
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<k> implements com.baidu.tieba.a.e {
    private TextView XJ;
    private String Yz;
    private final View.OnClickListener ZF;
    private boolean ZO;
    public PlayVoiceBntNew ZX;
    private final View.OnClickListener bRy;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    protected LinearLayout drz;
    private HeadPendantClickableView ehO;
    private k eiq;
    private ConstrainImageGroup eir;
    private View eis;
    private View.OnClickListener eiw;
    private final View.OnClickListener eix;
    public ConcernThreadUserInfoLayout fHi;
    public ConcernForumThreadUserInfoLayout fHk;
    public com.baidu.tbadk.core.view.d fHl;
    private View fHm;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ZO = true;
        this.eiw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQi() != null) {
                    b.this.aQi().a(view, b.this.eiq);
                }
                b.this.ajY();
            }
        };
        this.eix = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aQi = b.this.aQi();
                if (aQi != null) {
                    view.setTag("2");
                    aQi.a(view, b.this.eiq);
                }
            }
        };
        this.ZF = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQi() != null) {
                    b.this.aQi().a(view, b.this.eiq);
                }
            }
        };
        this.bRy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQi() != null) {
                    b.this.aQi().a(view, b.this.eiq);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.ehO = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.ehO.getHeadView() != null) {
            this.ehO.getHeadView().setIsRound(true);
            this.ehO.getHeadView().setDrawBorder(false);
            this.ehO.getHeadView().setDefaultResource(17170445);
            this.ehO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehO.getHeadView().setDefaultBgResource(d.C0236d.cp_bg_line_e);
            this.ehO.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.ehO.getPendantView() != null) {
            this.ehO.getPendantView().setIsRound(true);
            this.ehO.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.ZX = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.ZX.setAfterClickListener(this.eix);
        this.XJ = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.XJ.setVisibility(8);
        this.eir = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.eis = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.eir.setChildClickListener(this.eiw);
        this.eir.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.eir.setImageProcessor(fVar);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        if (this.dqz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqz.setLayoutParams(layoutParams);
        }
        this.dqz.setOnClickListener(this.eiw);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setShareVisible(true);
        this.dqz.setShareReportFrom(4);
        this.dqz.setFrom(9);
        this.dqz.setDisPraiseFrom(4);
        this.dqz.bSG = this.currentPageType;
        this.dqz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aQi() != null) {
                    b.this.aQi().a(view2, b.this.eiq);
                }
                if (b.this.eiq != null && b.this.eiq.threadData != null) {
                    n.tC(b.this.eiq.threadData.getId());
                    b.this.blB();
                }
            }
        });
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.dro.bTy.setOnClickListener(this.eiw);
        this.dro.setShareReportFrom(4);
        this.dro.setFrom(9);
        this.dro.bTy.bSG = this.currentPageType;
        this.dro.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aQi() != null) {
                    b.this.aQi().a(view2, b.this.eiq);
                }
                if (b.this.eiq != null && b.this.eiq.threadData != null && view2 != b.this.dro.bSP) {
                    n.tC(b.this.eiq.threadData.getId());
                    b.this.blB();
                }
            }
        });
        this.drz = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.fHm = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eir != null) {
            this.eir.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eir != null) {
            this.eir.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eir != null) {
            this.eir.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.eir.onChangeSkinType();
            this.dqz.onChangeSkinType();
            al.l(this.eis, d.C0236d.cp_bg_line_e);
            this.dro.onChangeSkinType();
        }
        if (this.fHi != null && this.fHi.getVisibility() == 0) {
            this.fHi.onChangeSkinType(i);
        }
        if (this.fHk != null && this.fHk.getVisibility() == 0) {
            this.fHk.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blB() {
        if (this.eiq != null && this.eiq.threadData.getId() != null) {
            n.a(this.mTitle, this.eiq.WR().getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
            n.a(this.XJ, this.eiq.threadData.getId(), d.C0236d.cp_cont_j, d.C0236d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_normal_thread;
    }

    private void blC() {
        if (this.fHi == null) {
            this.fHi = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void blD() {
        if (this.fHk == null) {
            this.fHk = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.fHk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQi() != null) {
                    b.this.aQi().a(view, b.this.eiq);
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
        this.eiq = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eiw);
        }
        if (kVar.aQV()) {
            blD();
            this.fHl = this.fHk;
            this.fHk.setVisibility(0);
            if (this.fHi != null) {
                this.fHi.setVisibility(8);
            }
        } else {
            blC();
            this.fHl = this.fHi;
            this.fHi.setVisibility(0);
            if (this.fHk != null) {
                this.fHk.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aQs() && n.tD(this.eiq.threadData.getId())) {
            blB();
        }
        final bg WR = kVar.WR();
        if (this.fHl.getHeaderImg() != null) {
            if (this.fHl.getIsSimpleThread()) {
                this.fHl.getHeaderImg().setVisibility(8);
                this.ehO.setVisibility(8);
            } else if (WR.YR() == null || WR.YR().getPendantData() == null || StringUtils.isNull(WR.YR().getPendantData().Xn())) {
                this.ehO.setVisibility(8);
                this.fHl.getHeaderImg().setVisibility(0);
                this.fHl.getHeaderImg().setData(WR, !kVar.aQV());
            } else {
                this.fHl.getHeaderImg().setVisibility(4);
                this.ehO.setVisibility(0);
                this.ehO.setData(WR);
            }
        }
        this.fHl.setData(kVar.threadData);
        this.fHl.setUserAfterClickListener(this.ZF);
        ah(WR);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> Zf = kVar.threadData.Zf();
        if (v.T(Zf)) {
            this.ZX.setVisibility(8);
            hO(false);
            z = false;
        } else {
            this.ZX.setVisibility(0);
            hO(true);
            VoiceData.VoiceModel voiceModel = Zf.get(0);
            this.ZX.setVoiceModel(voiceModel);
            this.ZX.setTag(voiceModel);
            this.ZX.bxW();
            if (voiceModel != null) {
                this.ZX.uu(voiceModel.voice_status.intValue());
            }
            this.ZX.cfB();
            z = true;
        }
        if (this.eiq.elM && z) {
            this.eir.setVisibility(8);
            this.fHm.setVisibility(0);
        } else {
            ArrayList<MediaData> Zb = kVar.threadData.Zb();
            if (i.Wy().WC() && v.S(Zb) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < Zb.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(Zb, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.S(linkedList) > 0) {
                    this.eir.setVisibility(0);
                    this.fHm.setVisibility(8);
                    this.eir.setFromCDN(this.ZO);
                    this.eir.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z2) {
                            ab<k> aQi = b.this.aQi();
                            if (aQi != null) {
                                view.setTag("1");
                                aQi.a(view, b.this.eiq);
                            }
                            if (z2) {
                                b.this.ajY();
                            } else {
                                b.this.a(view, linkedList, i2, WR);
                            }
                        }
                    });
                    this.eir.setImageMediaList(linkedList);
                } else {
                    this.eir.setVisibility(8);
                    this.fHm.setVisibility(0);
                }
            } else {
                this.eir.setVisibility(8);
                this.fHm.setVisibility(0);
            }
        }
        aQA();
        setPageUniqueId(getTag());
        bfU();
        mF(lt(1));
    }

    private void hO(boolean z) {
        if (this.eir != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eir.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.eir.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ZO ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bgVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YW(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZO, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bgVar.getId();
        historyMessage.threadName = bgVar.getTitle();
        historyMessage.forumName = bgVar.YW();
        historyMessage.postID = bgVar.Zh();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void aQA() {
        if (!this.eiq.cjO) {
            this.ZX.setClickable(false);
        } else {
            this.ZX.setClickable(true);
        }
        int childCount = this.eir.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eir.getChildAt(i);
            if (childAt != null) {
                if (!this.eiq.cjO) {
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
        if (this.eir != null) {
            this.eir.setPageUniqueId(bdUniqueId);
        }
        if (this.fHl != null) {
            this.fHl.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fHl != null) {
            return this.fHl.getHeaderImg();
        }
        return null;
    }

    public View aQn() {
        if (this.fHl != null) {
            return this.fHl.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajY() {
        if (this.eiq != null && this.eiq.threadData != null) {
            if (!aQs()) {
                n.tC(this.eiq.threadData.getId());
                n.a(this.mTitle, this.eiq.WR().getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
                n.a(this.XJ, this.eiq.threadData.getId(), d.C0236d.cp_cont_j, d.C0236d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.eiq.threadData, null, n.YE(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.eiq.threadData.getFid()));
            createFromThreadCfg.setForumName(this.eiq.threadData.YW());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aQs() {
        return this.eiq.elM && !this.eiq.cjO;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean ah(bg bgVar) {
        SpannableStringBuilder m = bgVar.m(false, true);
        if (m == null || StringUtils.isNull(m.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(m));
            this.mTitle.setText(m);
            n.a(this.mTitle, bgVar.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.aQV()) {
            this.XJ.setVisibility(8);
            return;
        }
        bg bgVar = kVar.threadData;
        if (lt(2) == 1) {
            SpannableString aas = bgVar.aas();
            if (aas != null && !ap.isEmpty(aas.toString())) {
                this.XJ.setVisibility(0);
                this.XJ.setOnTouchListener(new com.baidu.tieba.view.k(aas));
                this.XJ.setText(aas);
                n.a(this.XJ, bgVar.getId(), d.C0236d.cp_cont_j, d.C0236d.cp_cont_d);
                return;
            }
            this.XJ.setVisibility(8);
            return;
        }
        this.XJ.setVisibility(8);
    }

    private void bfU() {
        if (this.mTitle != null && this.ZX != null && this.eir != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZX.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.ZX.setLayoutParams(layoutParams);
            if (this.ZX.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eir.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.eir.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mF(int i) {
        if (this.eiq != null && this.eiq.threadData != null) {
            if (!this.eiq.aQV() && i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setStType(n.YE());
                this.dro.setData(this.eiq.threadData);
                this.fHl.dN(false);
                return;
            }
            this.dqz.setData(this.eiq.threadData);
            this.dqz.setStType(n.YE());
            this.dro.setVisibility(8);
            this.fHl.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awl().ak(this.Yz, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eir != null) {
            this.eir.setPreloadSizeReadyCallback(bVar);
        }
    }
}
