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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<k> implements com.baidu.tieba.a.e {
    private boolean asS;
    private final View.OnClickListener axL;
    private final View.OnClickListener axw;
    private String bHB;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    protected LinearLayout bIN;
    private HeadPendantClickableView bIz;
    private View cwt;
    private k cwu;
    private View.OnClickListener cwv;
    public PlayVoiceBntNew cyY;
    private TextView cza;
    private ConstrainImageGroup czb;
    private final View.OnClickListener cze;
    public ConcernThreadUserInfoLayout dTK;
    public ConcernForumThreadUserInfoLayout dTM;
    public com.baidu.tbadk.core.view.c dTN;
    private View dTO;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.asS = true;
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiC() != null) {
                    b.this.aiC().a(view, b.this.cwu);
                }
                b.this.aiV();
            }
        };
        this.cze = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<k> aiC = b.this.aiC();
                if (aiC != null) {
                    view.setTag("2");
                    aiC.a(view, b.this.cwu);
                }
            }
        };
        this.axL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiC() != null) {
                    b.this.aiC().a(view, b.this.cwu);
                }
            }
        };
        this.axw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiC() != null) {
                    b.this.aiC().a(view, b.this.cwu);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bIz = (HeadPendantClickableView) view.findViewById(f.g.card_concern_normal_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), f.e.ds60));
        }
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(f.g.card_concern_normal_thread_title);
        this.cyY = (PlayVoiceBntNew) view.findViewById(f.g.card_concern_normal_thread_abstract_voice);
        this.cyY.setAfterClickListener(this.cze);
        this.cza = (TextView) view.findViewById(f.g.card_concern_normal_thread_abstract);
        this.cza.setVisibility(8);
        this.czb = (ConstrainImageGroup) view.findViewById(f.g.card_concern_normal_thread_img_layout);
        this.cwt = view.findViewById(f.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds16);
        this.czb.setChildClickListener(this.cwv);
        this.czb.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.czb.setImageProcessor(eVar);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.card_concern_normal_thread_info_layout);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this.cwv);
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
                if (b.this.aiC() != null) {
                    b.this.aiC().a(view2, b.this.cwu);
                }
                if (b.this.cwu != null && b.this.cwu.threadData != null) {
                    o.kY(b.this.cwu.threadData.getId());
                    b.this.aiH();
                }
            }
        });
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.card_concern_nomal_source_read_share_layout);
        this.bIC.ayo.setOnClickListener(this.cwv);
        this.bIC.setShareReportFrom(4);
        this.bIC.setFrom(9);
        this.bIC.ayo.ajY = this.currentPageType;
        this.bIC.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aiC() != null) {
                    b.this.aiC().a(view2, b.this.cwu);
                }
                if (b.this.cwu != null && b.this.cwu.threadData != null && view2 != b.this.bIC.ayn) {
                    o.kY(b.this.cwu.threadData.getId());
                    b.this.aiH();
                }
            }
        });
        this.bIN = (LinearLayout) view.findViewById(f.g.card_concern_normal_thread_content_layout);
        this.dTO = view.findViewById(f.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.czb != null) {
            this.czb.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.czb != null) {
            this.czb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.czb != null) {
            this.czb.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.addresslist_item_bg);
            this.czb.onChangeSkinType();
            this.bHO.onChangeSkinType();
            am.j(this.cwt, f.d.cp_bg_line_e);
            this.bIC.onChangeSkinType();
        }
        if (this.dTK != null && this.dTK.getVisibility() == 0) {
            this.dTK.onChangeSkinType(i);
        }
        if (this.dTM != null && this.dTM.getVisibility() == 0) {
            this.dTM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (this.cwu != null && this.cwu.threadData.getId() != null) {
            o.a(this.mTitle, this.cwu.Tg().getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            o.a(this.cza, this.cwu.threadData.getId(), f.d.cp_cont_j, f.d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_concern_normal_thread;
    }

    private void aDr() {
        if (this.dTK == null) {
            this.dTK = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(f.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aDs() {
        if (this.dTM == null) {
            this.dTM = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(f.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.dTM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiC() != null) {
                    b.this.aiC().a(view, b.this.cwu);
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
        this.cwu = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwv);
        }
        if (kVar.ajr()) {
            aDs();
            this.dTN = this.dTM;
            this.dTM.setVisibility(0);
            if (this.dTK != null) {
                this.dTK.setVisibility(8);
            }
        } else {
            aDr();
            this.dTN = this.dTK;
            this.dTK.setVisibility(0);
            if (this.dTM != null) {
                this.dTM.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aiG() && o.kZ(this.cwu.threadData.getId())) {
            aiH();
        }
        final bb Tg = kVar.Tg();
        if (this.dTN.getHeaderImg() != null) {
            if (this.dTN.getIsSimpleThread()) {
                this.dTN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (Tg.vj() == null || Tg.vj().getPendantData() == null || StringUtils.isNull(Tg.vj().getPendantData().tT())) {
                this.bIz.setVisibility(8);
                this.dTN.getHeaderImg().setVisibility(0);
                this.dTN.getHeaderImg().setData(Tg, !kVar.ajr());
            } else {
                this.dTN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(Tg);
            }
        }
        this.dTN.setData(kVar.threadData);
        this.dTN.setUserAfterClickListener(this.axL);
        K(Tg);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> vy = kVar.threadData.vy();
        if (w.z(vy)) {
            this.cyY.setVisibility(8);
            ew(false);
            z = false;
        } else {
            this.cyY.setVisibility(0);
            ew(true);
            VoiceData.VoiceModel voiceModel = vy.get(0);
            this.cyY.setVoiceModel(voiceModel);
            this.cyY.setTag(voiceModel);
            this.cyY.aPq();
            if (voiceModel != null) {
                this.cyY.oH(voiceModel.voice_status.intValue());
            }
            this.cyY.bxq();
            z = true;
        }
        if (this.cwu.cCj && z) {
            this.czb.setVisibility(8);
            this.dTO.setVisibility(0);
        } else {
            ArrayList<MediaData> vu = kVar.threadData.vu();
            if (i.td().tj() && w.y(vu) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < vu.size(); i++) {
                    MediaData mediaData = (MediaData) w.d(vu, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (w.y(linkedList) > 0) {
                    this.czb.setVisibility(0);
                    this.dTO.setVisibility(8);
                    this.czb.setFromCDN(this.asS);
                    this.czb.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<k> aiC = b.this.aiC();
                            if (aiC != null) {
                                view.setTag("1");
                                aiC.a(view, b.this.cwu);
                            }
                            if (z2) {
                                b.this.aiV();
                            } else {
                                b.this.a(view, linkedList, i2, Tg);
                            }
                        }
                    });
                    this.czb.setImageMediaList(linkedList);
                } else {
                    this.czb.setVisibility(8);
                    this.dTO.setVisibility(0);
                }
            } else {
                this.czb.setVisibility(8);
                this.dTO.setVisibility(0);
            }
        }
        aiU();
        setPageUniqueId(getTag());
        axv();
        hm(gt(1));
    }

    private void ew(boolean z) {
        if (this.czb != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.czb.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds10);
            }
            this.czb.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), f.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.asS ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.vp(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.asS, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void aiU() {
        if (!this.cwu.aNv) {
            this.cyY.setClickable(false);
        } else {
            this.cyY.setClickable(true);
        }
        int childCount = this.czb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.czb.getChildAt(i);
            if (childAt != null) {
                if (!this.cwu.aNv) {
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
        if (this.czb != null) {
            this.czb.setPageUniqueId(bdUniqueId);
        }
        if (this.dTN != null) {
            this.dTN.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dTN != null) {
            return this.dTN.getHeaderImg();
        }
        return null;
    }

    public View aiF() {
        if (this.dTN != null) {
            return this.dTN.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiV() {
        if (this.cwu != null && this.cwu.threadData != null) {
            if (!aiG()) {
                o.kY(this.cwu.threadData.getId());
                o.a(this.mTitle, this.cwu.Tg().getId(), f.d.cp_cont_b, f.d.cp_cont_d);
                o.a(this.cza, this.cwu.threadData.getId(), f.d.cp_cont_j, f.d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cwu.threadData, null, o.uX(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cwu.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cwu.threadData.vp());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aiG() {
        return this.cwu.cCj && !this.cwu.aNv;
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
            o.a(this.mTitle, bbVar.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        }
        return true;
    }

    private void c(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.ajr()) {
            this.cza.setVisibility(8);
            return;
        }
        bb bbVar = kVar.threadData;
        if (gt(2) == 1) {
            SpannableString wy = bbVar.wy();
            if (wy != null && !ap.isEmpty(wy.toString())) {
                this.cza.setVisibility(0);
                this.cza.setOnTouchListener(new com.baidu.tieba.view.k(wy));
                this.cza.setText(wy);
                o.a(this.cza, bbVar.getId(), f.d.cp_cont_j, f.d.cp_cont_d);
                return;
            }
            this.cza.setVisibility(8);
            return;
        }
        this.cza.setVisibility(8);
    }

    private void axv() {
        if (this.mTitle != null && this.cyY != null && this.czb != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cyY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(f.e.ds24);
            this.cyY.setLayoutParams(layoutParams);
            if (this.cyY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.czb.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(f.e.ds10);
                this.czb.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hm(int i) {
        if (this.cwu != null && this.cwu.threadData != null) {
            if (!this.cwu.ajr() && i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setStType(o.uX());
                this.bIC.setData(this.cwu.threadData);
                this.dTN.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.cwu.threadData);
            this.bHO.setStType(o.uX());
            this.bIC.setVisibility(8);
            this.dTN.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}
