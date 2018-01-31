package com.baidu.tieba.homepage.concern.view;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<l> {
    private boolean aXA;
    private final View.OnClickListener bbZ;
    private final View.OnClickListener bcm;
    private View cSL;
    private l cSN;
    private View.OnClickListener cSO;
    public PlayVoiceBntNew cUt;
    private TextView cUv;
    private ConstrainImageGroup cUw;
    private final View.OnClickListener cUz;
    public ThreadCommentAndPraiseInfoLayout ciT;
    private HeadPendantClickableView cjC;
    protected LinearLayout cjQ;
    public ConcernThreadUserInfoLayout ecE;
    private View ecH;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aXA = true;
        this.cSO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akg() != null) {
                    b.this.akg().a(view, b.this.cSN);
                }
                b.this.akA();
            }
        };
        this.cUz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<l> akg = b.this.akg();
                if (akg != null) {
                    view.setTag("2");
                    akg.a(view, b.this.cSN);
                }
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akg() != null) {
                    b.this.akg().a(view, b.this.cSN);
                }
            }
        };
        this.bbZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akg() != null) {
                    b.this.akg().a(view, b.this.cSN);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cjC = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.cjC.getHeadView() != null) {
            this.cjC.getHeadView().setIsRound(true);
            this.cjC.getHeadView().setDrawBorder(false);
            this.cjC.getHeadView().setDefaultResource(17170445);
            this.cjC.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cjC.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cjC.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.cjC.getPendantView() != null) {
            this.cjC.getPendantView().setIsRound(true);
            this.cjC.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.cUt = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.cUt.setAfterClickListener(this.cUz);
        this.cUv = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.cUv.setVisibility(8);
        this.cUw = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.cSL = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cUw.setChildClickListener(this.cSO);
        this.cUw.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.g(1.0d);
        this.cUw.setImageProcessor(fVar);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.ecE = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.ciT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciT.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciT.setLayoutParams(layoutParams);
        }
        this.ciT.setOnClickListener(this.cSO);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setIsBarViewVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setShareVisible(true);
        this.ciT.setShareReportFrom(4);
        this.ciT.bbX = this.currentPageType;
        this.ciT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.akg() != null) {
                    b.this.akg().a(view2, b.this.cSN);
                }
                if (b.this.cSN != null && b.this.cSN.threadData != null) {
                    k.kj(b.this.cSN.threadData.getId());
                    b.this.akl();
                }
            }
        });
        this.cjQ = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.ecH = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cUw != null) {
            this.cUw.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUw != null) {
            this.cUw.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUw != null) {
            this.cUw.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.cUw.onChangeSkinType();
            this.ciT.onChangeSkinType();
            this.ecE.onChangeSkinType();
            aj.t(this.cSL, d.C0108d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akl() {
        if (this.cSN != null && this.cSN.threadData.getId() != null) {
            k.a(this.mTitle, this.cSN.VM().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            k.a(this.cUv, this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        boolean z;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cSN = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSO);
        }
        this.ecE.setData(lVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!akk() && k.kk(this.cSN.threadData.getId())) {
            akl();
        }
        this.ecE.setUserAfterClickListener(this.bcm);
        this.ciT.setData(lVar.threadData);
        this.ciT.setStType(k.yJ());
        final bd VM = lVar.VM();
        if (this.ecE.getHeaderImg() != null) {
            if (this.ecE.getIsSimpleThread()) {
                this.ecE.getHeaderImg().setVisibility(8);
                this.cjC.setVisibility(8);
            } else if (VM.yT() == null || VM.yT().getPendantData() == null || StringUtils.isNull(VM.yT().getPendantData().xu())) {
                this.cjC.setVisibility(8);
                this.ecE.getHeaderImg().setVisibility(0);
                this.ecE.getHeaderImg().setData(VM);
            } else {
                this.ecE.getHeaderImg().setVisibility(4);
            }
        }
        F(VM);
        ArrayList<VoiceData.VoiceModel> zi = lVar.threadData.zi();
        if (com.baidu.tbadk.core.util.v.E(zi)) {
            this.cUt.setVisibility(8);
            eF(false);
            z = false;
        } else {
            this.cUt.setVisibility(0);
            eF(true);
            VoiceData.VoiceModel voiceModel = zi.get(0);
            this.cUt.setVoiceModel(voiceModel);
            this.cUt.setTag(voiceModel);
            this.cUt.bng();
            if (voiceModel != null) {
                this.cUt.qE(voiceModel.voice_status.intValue());
            }
            this.cUt.bwR();
            z = true;
        }
        if (this.cSN.cXy && z) {
            this.cUw.setVisibility(8);
            this.ecH.setVisibility(0);
        } else {
            ArrayList<MediaData> ze = lVar.threadData.ze();
            if (i.wB().wH() && com.baidu.tbadk.core.util.v.D(ze) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < ze.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(ze, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                    this.cUw.setVisibility(0);
                    this.ecH.setVisibility(8);
                    this.cUw.setFromCDN(this.aXA);
                    this.cUw.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<l> akg = b.this.akg();
                            if (akg != null) {
                                view.setTag("1");
                                akg.a(view, b.this.cSN);
                            }
                            if (z2) {
                                b.this.akA();
                            } else {
                                b.this.a(view, linkedList, i2, VM);
                            }
                        }
                    });
                    this.cUw.setImageMediaList(linkedList);
                } else {
                    this.cUw.setVisibility(8);
                    this.ecH.setVisibility(0);
                }
            } else {
                this.cUw.setVisibility(8);
                this.ecH.setVisibility(0);
            }
        }
        akz();
        setPageUniqueId(getTag());
        awL();
    }

    private void eF(boolean z) {
        if (this.cUw != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUw.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cUw.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aXA ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bdVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yZ(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXA, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void akz() {
        if (!this.cSN.brC) {
            this.cUt.setClickable(false);
        } else {
            this.cUt.setClickable(true);
        }
        int childCount = this.cUw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cUw.getChildAt(i);
            if (childAt != null) {
                if (!this.cSN.brC) {
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
        if (this.cUw != null) {
            this.cUw.setPageUniqueId(bdUniqueId);
        }
        if (this.ecE != null) {
            this.ecE.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ecE != null) {
            return this.ecE.getHeaderImg();
        }
        return null;
    }

    public View akj() {
        if (this.ecE != null) {
            return this.ecE.bci;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        if (this.cSN != null && this.cSN.threadData != null) {
            if (!akk()) {
                k.kj(this.cSN.threadData.getId());
                k.a(this.mTitle, this.cSN.VM().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                k.a(this.cUv, this.cSN.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cSN.threadData, null, k.yJ(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cSN.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cSN.threadData.yZ());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean akk() {
        return this.cSN.cXy && !this.cSN.brC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean F(bd bdVar) {
        SpannableStringBuilder j = bdVar.j(false, true);
        if (j == null || StringUtils.isNull(j.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new m(j));
            this.mTitle.setText(j);
            k.a(this.mTitle, bdVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
        return true;
    }

    private void awL() {
        if (this.mTitle != null && this.cUt != null && this.cUw != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cUt.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.cUt.setLayoutParams(layoutParams);
            if (this.cUt.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cUw.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cUw.setLayoutParams(layoutParams2);
            }
        }
    }
}
