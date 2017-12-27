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
import com.baidu.tbadk.core.data.be;
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
    private boolean aXt;
    private final View.OnClickListener bbR;
    private final View.OnClickListener bce;
    private HeadPendantClickableView cNO;
    private View cNQ;
    private l cNR;
    private View.OnClickListener cNS;
    private final View.OnClickListener cPC;
    public PlayVoiceBntNew cPw;
    private TextView cPy;
    private ConstrainImageGroup cPz;
    public ThreadCommentAndPraiseInfoLayout ciE;
    protected LinearLayout cjA;
    public ConcernThreadUserInfoLayout eaZ;
    private View ebc;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aXt = true;
        this.cNS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiY() != null) {
                    b.this.aiY().a(view, b.this.cNR);
                }
                b.this.ajs();
            }
        };
        this.cPC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<l> aiY = b.this.aiY();
                if (aiY != null) {
                    view.setTag("2");
                    aiY.a(view, b.this.cNR);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiY() != null) {
                    b.this.aiY().a(view, b.this.cNR);
                }
            }
        };
        this.bbR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiY() != null) {
                    b.this.aiY().a(view, b.this.cNR);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cNO = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.cNO.getHeadView() != null) {
            this.cNO.getHeadView().setIsRound(true);
            this.cNO.getHeadView().setDrawBorder(false);
            this.cNO.getHeadView().setDefaultResource(17170445);
            this.cNO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cNO.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cNO.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.cNO.getPendantView() != null) {
            this.cNO.getPendantView().setIsRound(true);
            this.cNO.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.cPw = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.cPw.setAfterClickListener(this.cPC);
        this.cPy = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.cPy.setVisibility(8);
        this.cPz = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.cNQ = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cPz.setChildClickListener(this.cNS);
        this.cPz.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.f(1.0d);
        this.cPz.setImageProcessor(fVar);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.eaZ = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.ciE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciE.setLayoutParams(layoutParams);
        }
        this.ciE.setOnClickListener(this.cNS);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setIsBarViewVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setShareVisible(true);
        this.ciE.setShareReportFrom(4);
        this.ciE.bbP = this.currentPageType;
        this.ciE.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aiY() != null) {
                    b.this.aiY().a(view2, b.this.cNR);
                }
                if (b.this.cNR != null && b.this.cNR.threadData != null) {
                    k.jT(b.this.cNR.threadData.getId());
                    b.this.ajd();
                }
            }
        });
        this.cjA = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.ebc = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cPz != null) {
            this.cPz.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cPz != null) {
            this.cPz.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cPz != null) {
            this.cPz.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.cPz.onChangeSkinType();
            this.ciE.onChangeSkinType();
            this.eaZ.onChangeSkinType();
            aj.t(this.cNQ, d.C0108d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajd() {
        if (this.cNR != null && this.cNR.threadData.getId() != null) {
            k.a(this.mTitle, this.cNR.VW().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            k.a(this.cPy, this.cNR.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
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
        this.cNR = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cNS);
        }
        this.eaZ.setData(lVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!ajc() && k.jU(this.cNR.threadData.getId())) {
            ajd();
        }
        this.eaZ.setUserAfterClickListener(this.bce);
        this.ciE.setData(lVar.threadData);
        this.ciE.setStType(k.yN());
        final be VW = lVar.VW();
        if (this.eaZ.getHeaderImg() != null) {
            if (this.eaZ.getIsSimpleThread()) {
                this.eaZ.getHeaderImg().setVisibility(8);
                this.cNO.setVisibility(8);
            } else if (VW.yX() == null || VW.yX().getPendantData() == null || StringUtils.isNull(VW.yX().getPendantData().xu())) {
                this.cNO.setVisibility(8);
                this.eaZ.getHeaderImg().setVisibility(0);
                this.eaZ.getHeaderImg().setData(VW);
            } else {
                this.eaZ.getHeaderImg().setVisibility(4);
            }
        }
        F(VW);
        ArrayList<VoiceData.VoiceModel> zm = lVar.threadData.zm();
        if (com.baidu.tbadk.core.util.v.G(zm)) {
            this.cPw.setVisibility(8);
            ez(false);
            z = false;
        } else {
            this.cPw.setVisibility(0);
            ez(true);
            VoiceData.VoiceModel voiceModel = zm.get(0);
            this.cPw.setVoiceModel(voiceModel);
            this.cPw.setTag(voiceModel);
            this.cPw.btM();
            if (voiceModel != null) {
                this.cPw.qL(voiceModel.voice_status.intValue());
            }
            this.cPw.bDs();
            z = true;
        }
        if (this.cNR.cSB && z) {
            this.cPz.setVisibility(8);
            this.ebc.setVisibility(0);
        } else {
            ArrayList<MediaData> zi = lVar.threadData.zi();
            if (i.wB().wH() && com.baidu.tbadk.core.util.v.F(zi) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zi.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zi, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.F(linkedList) > 0) {
                    this.cPz.setVisibility(0);
                    this.ebc.setVisibility(8);
                    this.cPz.setFromCDN(this.aXt);
                    this.cPz.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<l> aiY = b.this.aiY();
                            if (aiY != null) {
                                view.setTag("1");
                                aiY.a(view, b.this.cNR);
                            }
                            if (z2) {
                                b.this.ajs();
                            } else {
                                b.this.a(view, linkedList, i2, VW);
                            }
                        }
                    });
                    this.cPz.setImageMediaList(linkedList);
                } else {
                    this.cPz.setVisibility(8);
                    this.ebc.setVisibility(0);
                }
            } else {
                this.cPz.setVisibility(8);
                this.ebc.setVisibility(0);
            }
        }
        ajr();
        setPageUniqueId(getTag());
        avD();
    }

    private void ez(boolean z) {
        if (this.cPz != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPz.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cPz.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, be beVar) {
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
                    imageUrlData.urlType = this.aXt ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(beVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, beVar.zd(), String.valueOf(beVar.getFid()), beVar.getTid(), this.aXt, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void ajr() {
        if (!this.cNR.brk) {
            this.cPw.setClickable(false);
        } else {
            this.cPw.setClickable(true);
        }
        int childCount = this.cPz.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cPz.getChildAt(i);
            if (childAt != null) {
                if (!this.cNR.brk) {
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
        if (this.cPz != null) {
            this.cPz.setPageUniqueId(bdUniqueId);
        }
        if (this.eaZ != null) {
            this.eaZ.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.eaZ != null) {
            return this.eaZ.getHeaderImg();
        }
        return null;
    }

    public View ajb() {
        if (this.eaZ != null) {
            return this.eaZ.bca;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajs() {
        if (this.cNR != null && this.cNR.threadData != null) {
            if (!ajc()) {
                k.jT(this.cNR.threadData.getId());
                k.a(this.mTitle, this.cNR.VW().getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                k.a(this.cPy, this.cNR.threadData.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cNR.threadData, null, k.yN(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cNR.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cNR.threadData.zd());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean ajc() {
        return this.cNR.cSB && !this.cNR.brk;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean F(be beVar) {
        SpannableStringBuilder j = beVar.j(false, true);
        if (j == null || StringUtils.isNull(j.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new m(j));
            this.mTitle.setText(j);
            k.a(this.mTitle, beVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
        return true;
    }

    private void avD() {
        if (this.mTitle != null && this.cPw != null && this.cPz != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cPw.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.cPw.setLayoutParams(layoutParams);
            if (this.cPw.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cPz.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cPz.setLayoutParams(layoutParams2);
            }
        }
    }
}
