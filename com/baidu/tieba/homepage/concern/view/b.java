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
    private boolean aXs;
    private final View.OnClickListener bbR;
    private final View.OnClickListener bce;
    private View cSq;
    private l cSs;
    private View.OnClickListener cSt;
    public PlayVoiceBntNew cTY;
    private TextView cUa;
    private ConstrainImageGroup cUb;
    private final View.OnClickListener cUe;
    public ThreadCommentAndPraiseInfoLayout ciL;
    protected LinearLayout cjI;
    private HeadPendantClickableView cju;
    public ConcernThreadUserInfoLayout ecj;
    private View ecm;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aXs = true;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akb() != null) {
                    b.this.akb().a(view, b.this.cSs);
                }
                b.this.akv();
            }
        };
        this.cUe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<l> akb = b.this.akb();
                if (akb != null) {
                    view.setTag("2");
                    akb.a(view, b.this.cSs);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akb() != null) {
                    b.this.akb().a(view, b.this.cSs);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akb() != null) {
                    b.this.akb().a(view, b.this.cSs);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cju = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.cju.getHeadView() != null) {
            this.cju.getHeadView().setIsRound(true);
            this.cju.getHeadView().setDrawBorder(false);
            this.cju.getHeadView().setDefaultResource(17170445);
            this.cju.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cju.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.cju.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.cju.getPendantView() != null) {
            this.cju.getPendantView().setIsRound(true);
            this.cju.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.cTY = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.cTY.setAfterClickListener(this.cUe);
        this.cUa = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.cUa.setVisibility(8);
        this.cUb = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.cSq = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cUb.setChildClickListener(this.cSt);
        this.cUb.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.g(1.0d);
        this.cUb.setImageProcessor(fVar);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.ecj = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.ciL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciL.setLayoutParams(layoutParams);
        }
        this.ciL.setOnClickListener(this.cSt);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setIsBarViewVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setShareVisible(true);
        this.ciL.setShareReportFrom(4);
        this.ciL.bbP = this.currentPageType;
        this.ciL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.akb() != null) {
                    b.this.akb().a(view2, b.this.cSs);
                }
                if (b.this.cSs != null && b.this.cSs.threadData != null) {
                    k.kc(b.this.cSs.threadData.getId());
                    b.this.akg();
                }
            }
        });
        this.cjI = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.ecm = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cUb != null) {
            this.cUb.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUb != null) {
            this.cUb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUb != null) {
            this.cUb.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.cUb.onChangeSkinType();
            this.ciL.onChangeSkinType();
            this.ecj.onChangeSkinType();
            aj.t(this.cSq, d.C0107d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akg() {
        if (this.cSs != null && this.cSs.threadData.getId() != null) {
            k.a(this.mTitle, this.cSs.VK().getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            k.a(this.cUa, this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
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
        this.cSs = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        this.ecj.setData(lVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!akf() && k.kd(this.cSs.threadData.getId())) {
            akg();
        }
        this.ecj.setUserAfterClickListener(this.bce);
        this.ciL.setData(lVar.threadData);
        this.ciL.setStType(k.yI());
        final bd VK = lVar.VK();
        if (this.ecj.getHeaderImg() != null) {
            if (this.ecj.getIsSimpleThread()) {
                this.ecj.getHeaderImg().setVisibility(8);
                this.cju.setVisibility(8);
            } else if (VK.yS() == null || VK.yS().getPendantData() == null || StringUtils.isNull(VK.yS().getPendantData().xt())) {
                this.cju.setVisibility(8);
                this.ecj.getHeaderImg().setVisibility(0);
                this.ecj.getHeaderImg().setData(VK);
            } else {
                this.ecj.getHeaderImg().setVisibility(4);
            }
        }
        F(VK);
        ArrayList<VoiceData.VoiceModel> zh = lVar.threadData.zh();
        if (com.baidu.tbadk.core.util.v.E(zh)) {
            this.cTY.setVisibility(8);
            eD(false);
            z = false;
        } else {
            this.cTY.setVisibility(0);
            eD(true);
            VoiceData.VoiceModel voiceModel = zh.get(0);
            this.cTY.setVoiceModel(voiceModel);
            this.cTY.setTag(voiceModel);
            this.cTY.bnf();
            if (voiceModel != null) {
                this.cTY.qE(voiceModel.voice_status.intValue());
            }
            this.cTY.bwP();
            z = true;
        }
        if (this.cSs.cXd && z) {
            this.cUb.setVisibility(8);
            this.ecm.setVisibility(0);
        } else {
            ArrayList<MediaData> zd = lVar.threadData.zd();
            if (i.wA().wG() && com.baidu.tbadk.core.util.v.D(zd) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zd.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zd, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                    this.cUb.setVisibility(0);
                    this.ecm.setVisibility(8);
                    this.cUb.setFromCDN(this.aXs);
                    this.cUb.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<l> akb = b.this.akb();
                            if (akb != null) {
                                view.setTag("1");
                                akb.a(view, b.this.cSs);
                            }
                            if (z2) {
                                b.this.akv();
                            } else {
                                b.this.a(view, linkedList, i2, VK);
                            }
                        }
                    });
                    this.cUb.setImageMediaList(linkedList);
                } else {
                    this.cUb.setVisibility(8);
                    this.ecm.setVisibility(0);
                }
            } else {
                this.cUb.setVisibility(8);
                this.ecm.setVisibility(0);
            }
        }
        aku();
        setPageUniqueId(getTag());
        awG();
    }

    private void eD(boolean z) {
        if (this.cUb != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUb.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cUb.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.aXs ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yY(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXs, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void aku() {
        if (!this.cSs.brt) {
            this.cTY.setClickable(false);
        } else {
            this.cTY.setClickable(true);
        }
        int childCount = this.cUb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cUb.getChildAt(i);
            if (childAt != null) {
                if (!this.cSs.brt) {
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
        if (this.cUb != null) {
            this.cUb.setPageUniqueId(bdUniqueId);
        }
        if (this.ecj != null) {
            this.ecj.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ecj != null) {
            return this.ecj.getHeaderImg();
        }
        return null;
    }

    public View ake() {
        if (this.ecj != null) {
            return this.ecj.bca;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        if (this.cSs != null && this.cSs.threadData != null) {
            if (!akf()) {
                k.kc(this.cSs.threadData.getId());
                k.a(this.mTitle, this.cSs.VK().getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
                k.a(this.cUa, this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cSs.threadData, null, k.yI(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cSs.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cSs.threadData.yY());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean akf() {
        return this.cSs.cXd && !this.cSs.brt;
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
            k.a(this.mTitle, bdVar.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        }
        return true;
    }

    private void awG() {
        if (this.mTitle != null && this.cTY != null && this.cUb != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cTY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.cTY.setLayoutParams(layoutParams);
            if (this.cTY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cUb.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cUb.setLayoutParams(layoutParams2);
            }
        }
    }
}
