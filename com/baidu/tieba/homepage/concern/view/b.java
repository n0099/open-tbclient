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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<k> implements com.baidu.tieba.a.e {
    private boolean asR;
    private final View.OnClickListener axO;
    private final View.OnClickListener axz;
    private String bHB;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    protected LinearLayout bIN;
    private HeadPendantClickableView bIz;
    private View cww;
    private k cwx;
    private View.OnClickListener cwy;
    public PlayVoiceBntNew czb;
    private TextView czd;
    private ConstrainImageGroup cze;
    private final View.OnClickListener czh;
    public ConcernThreadUserInfoLayout dTP;
    public ConcernForumThreadUserInfoLayout dTR;
    public com.baidu.tbadk.core.view.c dTS;
    private View dTT;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.asR = true;
        this.cwy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiz() != null) {
                    b.this.aiz().a(view, b.this.cwx);
                }
                b.this.aiS();
            }
        };
        this.czh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<k> aiz = b.this.aiz();
                if (aiz != null) {
                    view.setTag("2");
                    aiz.a(view, b.this.cwx);
                }
            }
        };
        this.axO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiz() != null) {
                    b.this.aiz().a(view, b.this.cwx);
                }
            }
        };
        this.axz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiz() != null) {
                    b.this.aiz().a(view, b.this.cwx);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bIz = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.czb = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.czb.setAfterClickListener(this.czh);
        this.czd = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.czd.setVisibility(8);
        this.cze = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.cww = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cze.setChildClickListener(this.cwy);
        this.cze.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.h(1.0d);
        this.cze.setImageProcessor(eVar);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this.cwy);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.setShareReportFrom(4);
        this.bHO.setFrom(9);
        this.bHO.ajY = this.currentPageType;
        this.bHO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aiz() != null) {
                    b.this.aiz().a(view2, b.this.cwx);
                }
                if (b.this.cwx != null && b.this.cwx.threadData != null) {
                    o.kW(b.this.cwx.threadData.getId());
                    b.this.aiE();
                }
            }
        });
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.bIC.ayr.setOnClickListener(this.cwy);
        this.bIC.setShareReportFrom(4);
        this.bIC.setFrom(9);
        this.bIC.ayr.ajY = this.currentPageType;
        this.bIC.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aiz() != null) {
                    b.this.aiz().a(view2, b.this.cwx);
                }
                if (b.this.cwx != null && b.this.cwx.threadData != null && view2 != b.this.bIC.ayq) {
                    o.kW(b.this.cwx.threadData.getId());
                    b.this.aiE();
                }
            }
        });
        this.bIN = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.dTT = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cze != null) {
            this.cze.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cze != null) {
            this.cze.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cze != null) {
            this.cze.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            this.cze.onChangeSkinType();
            this.bHO.onChangeSkinType();
            am.j(this.cww, d.C0140d.cp_bg_line_e);
            this.bIC.onChangeSkinType();
        }
        if (this.dTP != null && this.dTP.getVisibility() == 0) {
            this.dTP.onChangeSkinType(i);
        }
        if (this.dTR != null && this.dTR.getVisibility() == 0) {
            this.dTR.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiE() {
        if (this.cwx != null && this.cwx.threadData.getId() != null) {
            o.a(this.mTitle, this.cwx.Td().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            o.a(this.czd, this.cwx.threadData.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_normal_thread;
    }

    private void aDu() {
        if (this.dTP == null) {
            this.dTP = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aDv() {
        if (this.dTR == null) {
            this.dTR = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.dTR.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiz() != null) {
                    b.this.aiz().a(view, b.this.cwx);
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
        this.cwx = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwy);
        }
        if (kVar.ajo()) {
            aDv();
            this.dTS = this.dTR;
            this.dTR.setVisibility(0);
            if (this.dTP != null) {
                this.dTP.setVisibility(8);
            }
        } else {
            aDu();
            this.dTS = this.dTP;
            this.dTP.setVisibility(0);
            if (this.dTR != null) {
                this.dTR.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aiD() && o.kX(this.cwx.threadData.getId())) {
            aiE();
        }
        final bb Td = kVar.Td();
        if (this.dTS.getHeaderImg() != null) {
            if (this.dTS.getIsSimpleThread()) {
                this.dTS.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (Td.vk() == null || Td.vk().getPendantData() == null || StringUtils.isNull(Td.vk().getPendantData().tU())) {
                this.bIz.setVisibility(8);
                this.dTS.getHeaderImg().setVisibility(0);
                this.dTS.getHeaderImg().setData(Td, !kVar.ajo());
            } else {
                this.dTS.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(Td);
            }
        }
        this.dTS.setData(kVar.threadData);
        this.dTS.setUserAfterClickListener(this.axO);
        K(Td);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> vz = kVar.threadData.vz();
        if (w.z(vz)) {
            this.czb.setVisibility(8);
            ew(false);
            z = false;
        } else {
            this.czb.setVisibility(0);
            ew(true);
            VoiceData.VoiceModel voiceModel = vz.get(0);
            this.czb.setVoiceModel(voiceModel);
            this.czb.setTag(voiceModel);
            this.czb.aPt();
            if (voiceModel != null) {
                this.czb.oH(voiceModel.voice_status.intValue());
            }
            this.czb.bxp();
            z = true;
        }
        if (this.cwx.cCm && z) {
            this.cze.setVisibility(8);
            this.dTT.setVisibility(0);
        } else {
            ArrayList<MediaData> vv = kVar.threadData.vv();
            if (i.te().tk() && w.y(vv) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < vv.size(); i++) {
                    MediaData mediaData = (MediaData) w.d(vv, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (w.y(linkedList) > 0) {
                    this.cze.setVisibility(0);
                    this.dTT.setVisibility(8);
                    this.cze.setFromCDN(this.asR);
                    this.cze.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view, int i2, boolean z2) {
                            ad<k> aiz = b.this.aiz();
                            if (aiz != null) {
                                view.setTag("1");
                                aiz.a(view, b.this.cwx);
                            }
                            if (z2) {
                                b.this.aiS();
                            } else {
                                b.this.a(view, linkedList, i2, Td);
                            }
                        }
                    });
                    this.cze.setImageMediaList(linkedList);
                } else {
                    this.cze.setVisibility(8);
                    this.dTT.setVisibility(0);
                }
            } else {
                this.cze.setVisibility(8);
                this.dTT.setVisibility(0);
            }
        }
        aiR();
        setPageUniqueId(getTag());
        axw();
        hn(gu(1));
    }

    private void ew(boolean z) {
        if (this.cze != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cze.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cze.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
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
                    imageUrlData.urlType = this.asR ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bbVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.vq(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.asR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void aiR() {
        if (!this.cwx.aNy) {
            this.czb.setClickable(false);
        } else {
            this.czb.setClickable(true);
        }
        int childCount = this.cze.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cze.getChildAt(i);
            if (childAt != null) {
                if (!this.cwx.aNy) {
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
        if (this.cze != null) {
            this.cze.setPageUniqueId(bdUniqueId);
        }
        if (this.dTS != null) {
            this.dTS.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dTS != null) {
            return this.dTS.getHeaderImg();
        }
        return null;
    }

    public View aiC() {
        if (this.dTS != null) {
            return this.dTS.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiS() {
        if (this.cwx != null && this.cwx.threadData != null) {
            if (!aiD()) {
                o.kW(this.cwx.threadData.getId());
                o.a(this.mTitle, this.cwx.Td().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                o.a(this.czd, this.cwx.threadData.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cwx.threadData, null, o.uY(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cwx.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cwx.threadData.vq());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aiD() {
        return this.cwx.cCm && !this.cwx.aNy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean K(bb bbVar) {
        SpannableStringBuilder g = bbVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bbVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
        return true;
    }

    private void c(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.ajo()) {
            this.czd.setVisibility(8);
            return;
        }
        bb bbVar = kVar.threadData;
        if (gu(2) == 1) {
            SpannableString wz = bbVar.wz();
            if (wz != null && !ap.isEmpty(wz.toString())) {
                this.czd.setVisibility(0);
                this.czd.setOnTouchListener(new com.baidu.tieba.view.k(wz));
                this.czd.setText(wz);
                o.a(this.czd, bbVar.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
                return;
            }
            this.czd.setVisibility(8);
            return;
        }
        this.czd.setVisibility(8);
    }

    private void axw() {
        if (this.mTitle != null && this.czb != null && this.cze != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.czb.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.czb.setLayoutParams(layoutParams);
            if (this.czb.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cze.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cze.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hn(int i) {
        if (this.cwx != null && this.cwx.threadData != null) {
            if (!this.cwx.ajo() && i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setStType(o.uY());
                this.bIC.setData(this.cwx.threadData);
                this.dTS.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.cwx.threadData);
            this.bHO.setStType(o.uY());
            this.bIC.setVisibility(8);
            this.dTS.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}
