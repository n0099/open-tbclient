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
    private boolean aAb;
    private final View.OnClickListener aEh;
    private final View.OnClickListener aGk;
    private String bVS;
    private HeadPendantClickableView bWP;
    public ThreadSourceShareAndPraiseLayout bWS;
    public ThreadCommentAndPraiseInfoLayout bWf;
    protected LinearLayout bXd;
    private View cKE;
    private k cKF;
    private View.OnClickListener cKG;
    public PlayVoiceBntNew cNk;
    private TextView cNm;
    private ConstrainImageGroup cNn;
    private final View.OnClickListener cNq;
    public ConcernThreadUserInfoLayout eiW;
    public ConcernForumThreadUserInfoLayout eiY;
    public com.baidu.tbadk.core.view.f eiZ;
    private View eja;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aAb = true;
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.anO() != null) {
                    b.this.anO().a(view, b.this.cKF);
                }
                b.this.aoi();
            }
        };
        this.cNq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<k> anO = b.this.anO();
                if (anO != null) {
                    view.setTag("2");
                    anO.a(view, b.this.cKF);
                }
            }
        };
        this.aGk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.anO() != null) {
                    b.this.anO().a(view, b.this.cKF);
                }
            }
        };
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.anO() != null) {
                    b.this.anO().a(view, b.this.cKF);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bWP = (HeadPendantClickableView) view.findViewById(e.g.card_concern_normal_thread_user_pendant_header);
        if (this.bWP.getHeadView() != null) {
            this.bWP.getHeadView().setIsRound(true);
            this.bWP.getHeadView().setDrawBorder(false);
            this.bWP.getHeadView().setDefaultResource(17170445);
            this.bWP.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bWP.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bWP.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds60));
        }
        if (this.bWP.getPendantView() != null) {
            this.bWP.getPendantView().setIsRound(true);
            this.bWP.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_normal_thread_title);
        this.cNk = (PlayVoiceBntNew) view.findViewById(e.g.card_concern_normal_thread_abstract_voice);
        this.cNk.setAfterClickListener(this.cNq);
        this.cNm = (TextView) view.findViewById(e.g.card_concern_normal_thread_abstract);
        this.cNm.setVisibility(8);
        this.cNn = (ConstrainImageGroup) view.findViewById(e.g.card_concern_normal_thread_img_layout);
        this.cKE = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds16);
        this.cNn.setChildClickListener(this.cKG);
        this.cNn.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cNn.setImageProcessor(eVar);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_normal_thread_info_layout);
        if (this.bWf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWf.setLayoutParams(layoutParams);
        }
        this.bWf.setOnClickListener(this.cKG);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setIsBarViewVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setShareVisible(true);
        this.bWf.setShareReportFrom(4);
        this.bWf.setFrom(9);
        this.bWf.setDisPraiseFrom(4);
        this.bWf.ary = this.currentPageType;
        this.bWf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.anO() != null) {
                    b.this.anO().a(view2, b.this.cKF);
                }
                if (b.this.cKF != null && b.this.cKF.threadData != null) {
                    o.md(b.this.cKF.threadData.getId());
                    b.this.anT();
                }
            }
        });
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_nomal_source_read_share_layout);
        this.bWS.aFS.setOnClickListener(this.cKG);
        this.bWS.setShareReportFrom(4);
        this.bWS.setFrom(9);
        this.bWS.aFS.ary = this.currentPageType;
        this.bWS.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.anO() != null) {
                    b.this.anO().a(view2, b.this.cKF);
                }
                if (b.this.cKF != null && b.this.cKF.threadData != null && view2 != b.this.bWS.aFR) {
                    o.md(b.this.cKF.threadData.getId());
                    b.this.anT();
                }
            }
        });
        this.bXd = (LinearLayout) view.findViewById(e.g.card_concern_normal_thread_content_layout);
        this.eja = view.findViewById(e.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cNn != null) {
            this.cNn.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cNn != null) {
            this.cNn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cNn != null) {
            this.cNn.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.cNn.onChangeSkinType();
            this.bWf.onChangeSkinType();
            al.j(this.cKE, e.d.cp_bg_line_e);
            this.bWS.onChangeSkinType();
        }
        if (this.eiW != null && this.eiW.getVisibility() == 0) {
            this.eiW.onChangeSkinType(i);
        }
        if (this.eiY != null && this.eiY.getVisibility() == 0) {
            this.eiY.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anT() {
        if (this.cKF != null && this.cKF.threadData.getId() != null) {
            o.a(this.mTitle, this.cKF.YA().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cNm, this.cKF.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_normal_thread;
    }

    private void aIW() {
        if (this.eiW == null) {
            this.eiW = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aIX() {
        if (this.eiY == null) {
            this.eiY = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.eiY.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.anO() != null) {
                    b.this.anO().a(view, b.this.cKF);
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
        this.cKF = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cKG);
        }
        if (kVar.aoE()) {
            aIX();
            this.eiZ = this.eiY;
            this.eiY.setVisibility(0);
            if (this.eiW != null) {
                this.eiW.setVisibility(8);
            }
        } else {
            aIW();
            this.eiZ = this.eiW;
            this.eiW.setVisibility(0);
            if (this.eiY != null) {
                this.eiY.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!anS() && o.me(this.cKF.threadData.getId())) {
            anT();
        }
        final bb YA = kVar.YA();
        if (this.eiZ.getHeaderImg() != null) {
            if (this.eiZ.getIsSimpleThread()) {
                this.eiZ.getHeaderImg().setVisibility(8);
                this.bWP.setVisibility(8);
            } else if (YA.yv() == null || YA.yv().getPendantData() == null || StringUtils.isNull(YA.yv().getPendantData().xf())) {
                this.bWP.setVisibility(8);
                this.eiZ.getHeaderImg().setVisibility(0);
                this.eiZ.getHeaderImg().setData(YA, !kVar.aoE());
            } else {
                this.eiZ.getHeaderImg().setVisibility(4);
                this.bWP.setVisibility(0);
                this.bWP.setData(YA);
            }
        }
        this.eiZ.setData(kVar.threadData);
        this.eiZ.setUserAfterClickListener(this.aGk);
        L(YA);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> yK = kVar.threadData.yK();
        if (v.J(yK)) {
            this.cNk.setVisibility(8);
            ff(false);
            z = false;
        } else {
            this.cNk.setVisibility(0);
            ff(true);
            VoiceData.VoiceModel voiceModel = yK.get(0);
            this.cNk.setVoiceModel(voiceModel);
            this.cNk.setTag(voiceModel);
            this.cNk.aUR();
            if (voiceModel != null) {
                this.cNk.pJ(voiceModel.voice_status.intValue());
            }
            this.cNk.bDm();
            z = true;
        }
        if (this.cKF.cQt && z) {
            this.cNn.setVisibility(8);
            this.eja.setVisibility(0);
        } else {
            ArrayList<MediaData> yG = kVar.threadData.yG();
            if (i.ws().ww() && v.I(yG) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < yG.size(); i++) {
                    MediaData mediaData = (MediaData) v.d(yG, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.I(linkedList) > 0) {
                    this.cNn.setVisibility(0);
                    this.eja.setVisibility(8);
                    this.cNn.setFromCDN(this.aAb);
                    this.cNn.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<k> anO = b.this.anO();
                            if (anO != null) {
                                view.setTag("1");
                                anO.a(view, b.this.cKF);
                            }
                            if (z2) {
                                b.this.aoi();
                            } else {
                                b.this.a(view, linkedList, i2, YA);
                            }
                        }
                    });
                    this.cNn.setImageMediaList(linkedList);
                } else {
                    this.cNn.setVisibility(8);
                    this.eja.setVisibility(0);
                }
            } else {
                this.cNn.setVisibility(8);
                this.eja.setVisibility(0);
            }
        }
        aoh();
        setPageUniqueId(getTag());
        aDc();
        ik(hb(1));
    }

    private void ff(boolean z) {
        if (this.cNn != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNn.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds10);
            }
            this.cNn.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.aAb ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.yB(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aAb, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void aoh() {
        if (!this.cKF.aVo) {
            this.cNk.setClickable(false);
        } else {
            this.cNk.setClickable(true);
        }
        int childCount = this.cNn.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cNn.getChildAt(i);
            if (childAt != null) {
                if (!this.cKF.aVo) {
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
        if (this.cNn != null) {
            this.cNn.setPageUniqueId(bdUniqueId);
        }
        if (this.eiZ != null) {
            this.eiZ.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eiZ != null) {
            return this.eiZ.getHeaderImg();
        }
        return null;
    }

    public View anR() {
        if (this.eiZ != null) {
            return this.eiZ.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoi() {
        if (this.cKF != null && this.cKF.threadData != null) {
            if (!anS()) {
                o.md(this.cKF.threadData.getId());
                o.a(this.mTitle, this.cKF.YA().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cNm, this.cKF.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cKF.threadData, null, o.yj(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cKF.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cKF.threadData.yB());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean anS() {
        return this.cKF.cQt && !this.cKF.aVo;
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
        if (kVar == null || kVar.threadData == null || kVar.aoE()) {
            this.cNm.setVisibility(8);
            return;
        }
        bb bbVar = kVar.threadData;
        if (hb(2) == 1) {
            SpannableString zO = bbVar.zO();
            if (zO != null && !ao.isEmpty(zO.toString())) {
                this.cNm.setVisibility(0);
                this.cNm.setOnTouchListener(new com.baidu.tieba.view.k(zO));
                this.cNm.setText(zO);
                o.a(this.cNm, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cNm.setVisibility(8);
            return;
        }
        this.cNm.setVisibility(8);
    }

    private void aDc() {
        if (this.mTitle != null && this.cNk != null && this.cNn != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNk.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds24);
            this.cNk.setLayoutParams(layoutParams);
            if (this.cNk.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cNn.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds10);
                this.cNn.setLayoutParams(layoutParams2);
            }
        }
    }

    public void ik(int i) {
        if (this.cKF != null && this.cKF.threadData != null) {
            if (!this.cKF.aoE() && i == 1) {
                this.bWf.setVisibility(8);
                this.bWS.setStType(o.yj());
                this.bWS.setData(this.cKF.threadData);
                this.eiZ.showForumNameView(false);
                return;
            }
            this.bWf.setData(this.cKF.threadData);
            this.bWf.setStType(o.yj());
            this.bWS.setVisibility(8);
            this.eiZ.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cNn != null) {
            this.cNn.setPreloadSizeReadyCallback(bVar);
        }
    }
}
