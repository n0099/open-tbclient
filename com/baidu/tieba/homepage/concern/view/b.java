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
    private TextView XL;
    private String YB;
    private final View.OnClickListener ZI;
    private boolean ZR;
    public PlayVoiceBntNew aaa;
    private final View.OnClickListener bRC;
    public ThreadCommentAndPraiseInfoLayout dqz;
    public ThreadSourceShareAndPraiseLayout dro;
    protected LinearLayout drz;
    private k ehZ;
    private HeadPendantClickableView ehx;
    private ConstrainImageGroup eia;
    private View eib;
    private View.OnClickListener eif;
    private final View.OnClickListener eig;
    public ConcernThreadUserInfoLayout fGV;
    public ConcernForumThreadUserInfoLayout fGX;
    public com.baidu.tbadk.core.view.d fGY;
    private View fGZ;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ZR = true;
        this.eif = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQf() != null) {
                    b.this.aQf().a(view, b.this.ehZ);
                }
                b.this.ajU();
            }
        };
        this.eig = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aQf = b.this.aQf();
                if (aQf != null) {
                    view.setTag("2");
                    aQf.a(view, b.this.ehZ);
                }
            }
        };
        this.ZI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQf() != null) {
                    b.this.aQf().a(view, b.this.ehZ);
                }
            }
        };
        this.bRC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQf() != null) {
                    b.this.aQf().a(view, b.this.ehZ);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.ehx = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.ehx.getHeadView() != null) {
            this.ehx.getHeadView().setIsRound(true);
            this.ehx.getHeadView().setDrawBorder(false);
            this.ehx.getHeadView().setDefaultResource(17170445);
            this.ehx.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehx.getHeadView().setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.ehx.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.ehx.getPendantView() != null) {
            this.ehx.getPendantView().setIsRound(true);
            this.ehx.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.aaa = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.aaa.setAfterClickListener(this.eig);
        this.XL = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.XL.setVisibility(8);
        this.eia = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.eib = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.eia.setChildClickListener(this.eif);
        this.eia.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.eia.setImageProcessor(fVar);
        this.dqz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        if (this.dqz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqz.setLayoutParams(layoutParams);
        }
        this.dqz.setOnClickListener(this.eif);
        this.dqz.setReplyTimeVisible(false);
        this.dqz.setIsBarViewVisible(false);
        this.dqz.setShowPraiseNum(true);
        this.dqz.setNeedAddPraiseIcon(true);
        this.dqz.setNeedAddReplyIcon(true);
        this.dqz.setShareVisible(true);
        this.dqz.setShareReportFrom(4);
        this.dqz.setFrom(9);
        this.dqz.setDisPraiseFrom(4);
        this.dqz.bSK = this.currentPageType;
        this.dqz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aQf() != null) {
                    b.this.aQf().a(view2, b.this.ehZ);
                }
                if (b.this.ehZ != null && b.this.ehZ.threadData != null) {
                    n.tz(b.this.ehZ.threadData.getId());
                    b.this.blx();
                }
            }
        });
        this.dro = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.dro.bTC.setOnClickListener(this.eif);
        this.dro.setShareReportFrom(4);
        this.dro.setFrom(9);
        this.dro.bTC.bSK = this.currentPageType;
        this.dro.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aQf() != null) {
                    b.this.aQf().a(view2, b.this.ehZ);
                }
                if (b.this.ehZ != null && b.this.ehZ.threadData != null && view2 != b.this.dro.bST) {
                    n.tz(b.this.ehZ.threadData.getId());
                    b.this.blx();
                }
            }
        });
        this.drz = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.fGZ = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eia != null) {
            this.eia.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eia != null) {
            this.eia.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eia != null) {
            this.eia.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.eia.onChangeSkinType();
            this.dqz.onChangeSkinType();
            al.l(this.eib, d.C0277d.cp_bg_line_e);
            this.dro.onChangeSkinType();
        }
        if (this.fGV != null && this.fGV.getVisibility() == 0) {
            this.fGV.onChangeSkinType(i);
        }
        if (this.fGX != null && this.fGX.getVisibility() == 0) {
            this.fGX.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        if (this.ehZ != null && this.ehZ.threadData.getId() != null) {
            n.a(this.mTitle, this.ehZ.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.XL, this.ehZ.threadData.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_normal_thread;
    }

    private void bly() {
        if (this.fGV == null) {
            this.fGV = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void blz() {
        if (this.fGX == null) {
            this.fGX = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.fGX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQf() != null) {
                    b.this.aQf().a(view, b.this.ehZ);
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
        this.ehZ = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eif);
        }
        if (kVar.aQS()) {
            blz();
            this.fGY = this.fGX;
            this.fGX.setVisibility(0);
            if (this.fGV != null) {
                this.fGV.setVisibility(8);
            }
        } else {
            bly();
            this.fGY = this.fGV;
            this.fGV.setVisibility(0);
            if (this.fGX != null) {
                this.fGX.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aQp() && n.tA(this.ehZ.threadData.getId())) {
            blx();
        }
        final bg WO = kVar.WO();
        if (this.fGY.getHeaderImg() != null) {
            if (this.fGY.getIsSimpleThread()) {
                this.fGY.getHeaderImg().setVisibility(8);
                this.ehx.setVisibility(8);
            } else if (WO.YO() == null || WO.YO().getPendantData() == null || StringUtils.isNull(WO.YO().getPendantData().Xk())) {
                this.ehx.setVisibility(8);
                this.fGY.getHeaderImg().setVisibility(0);
                this.fGY.getHeaderImg().setData(WO, !kVar.aQS());
            } else {
                this.fGY.getHeaderImg().setVisibility(4);
                this.ehx.setVisibility(0);
                this.ehx.setData(WO);
            }
        }
        this.fGY.setData(kVar.threadData);
        this.fGY.setUserAfterClickListener(this.ZI);
        ag(WO);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> Zc = kVar.threadData.Zc();
        if (v.T(Zc)) {
            this.aaa.setVisibility(8);
            hO(false);
            z = false;
        } else {
            this.aaa.setVisibility(0);
            hO(true);
            VoiceData.VoiceModel voiceModel = Zc.get(0);
            this.aaa.setVoiceModel(voiceModel);
            this.aaa.setTag(voiceModel);
            this.aaa.bxS();
            if (voiceModel != null) {
                this.aaa.uq(voiceModel.voice_status.intValue());
            }
            this.aaa.cfz();
            z = true;
        }
        if (this.ehZ.elv && z) {
            this.eia.setVisibility(8);
            this.fGZ.setVisibility(0);
        } else {
            ArrayList<MediaData> YY = kVar.threadData.YY();
            if (i.Wv().Wz() && v.S(YY) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < YY.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(YY, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.S(linkedList) > 0) {
                    this.eia.setVisibility(0);
                    this.fGZ.setVisibility(8);
                    this.eia.setFromCDN(this.ZR);
                    this.eia.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z2) {
                            ab<k> aQf = b.this.aQf();
                            if (aQf != null) {
                                view.setTag("1");
                                aQf.a(view, b.this.ehZ);
                            }
                            if (z2) {
                                b.this.ajU();
                            } else {
                                b.this.a(view, linkedList, i2, WO);
                            }
                        }
                    });
                    this.eia.setImageMediaList(linkedList);
                } else {
                    this.eia.setVisibility(8);
                    this.fGZ.setVisibility(0);
                }
            } else {
                this.eia.setVisibility(8);
                this.fGZ.setVisibility(0);
            }
        }
        aQx();
        setPageUniqueId(getTag());
        bfR();
        mE(ls(1));
    }

    private void hO(boolean z) {
        if (this.eia != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eia.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.eia.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.ZR ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YT(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bgVar.getId();
        historyMessage.threadName = bgVar.getTitle();
        historyMessage.forumName = bgVar.YT();
        historyMessage.postID = bgVar.Ze();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void aQx() {
        if (!this.ehZ.cjR) {
            this.aaa.setClickable(false);
        } else {
            this.aaa.setClickable(true);
        }
        int childCount = this.eia.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eia.getChildAt(i);
            if (childAt != null) {
                if (!this.ehZ.cjR) {
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
        if (this.eia != null) {
            this.eia.setPageUniqueId(bdUniqueId);
        }
        if (this.fGY != null) {
            this.fGY.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fGY != null) {
            return this.fGY.getHeaderImg();
        }
        return null;
    }

    public View aQk() {
        if (this.fGY != null) {
            return this.fGY.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajU() {
        if (this.ehZ != null && this.ehZ.threadData != null) {
            if (!aQp()) {
                n.tz(this.ehZ.threadData.getId());
                n.a(this.mTitle, this.ehZ.WO().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                n.a(this.XL, this.ehZ.threadData.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ehZ.threadData, null, n.YB(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.ehZ.threadData.getFid()));
            createFromThreadCfg.setForumName(this.ehZ.threadData.YT());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aQp() {
        return this.ehZ.elv && !this.ehZ.cjR;
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
            n.a(this.mTitle, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.aQS()) {
            this.XL.setVisibility(8);
            return;
        }
        bg bgVar = kVar.threadData;
        if (ls(2) == 1) {
            SpannableString aap = bgVar.aap();
            if (aap != null && !ap.isEmpty(aap.toString())) {
                this.XL.setVisibility(0);
                this.XL.setOnTouchListener(new com.baidu.tieba.view.k(aap));
                this.XL.setText(aap);
                n.a(this.XL, bgVar.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
                return;
            }
            this.XL.setVisibility(8);
            return;
        }
        this.XL.setVisibility(8);
    }

    private void bfR() {
        if (this.mTitle != null && this.aaa != null && this.eia != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aaa.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.aaa.setLayoutParams(layoutParams);
            if (this.aaa.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eia.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.eia.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mE(int i) {
        if (this.ehZ != null && this.ehZ.threadData != null) {
            if (!this.ehZ.aQS() && i == 1) {
                this.dqz.setVisibility(8);
                this.dro.setStType(n.YB());
                this.dro.setData(this.ehZ.threadData);
                this.fGY.dN(false);
                return;
            }
            this.dqz.setData(this.ehZ.threadData);
            this.dqz.setStType(n.YB());
            this.dro.setVisibility(8);
            this.fGY.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    public int ls(int i) {
        return com.baidu.tieba.a.d.awh().ak(this.YB, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eia != null) {
            this.eia.setPreloadSizeReadyCallback(bVar);
        }
    }
}
