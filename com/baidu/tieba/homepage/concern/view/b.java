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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<l> {
    private boolean aiR;
    private final View.OnClickListener anA;
    private final View.OnClickListener anS;
    private HeadPendantClickableView bQP;
    private View bQS;
    private l bQT;
    private View.OnClickListener bQU;
    public PlayVoiceBntNew bSJ;
    private TextView bSL;
    private ConstrainImageGroup bSM;
    private final View.OnClickListener bSN;
    public ThreadCommentAndPraiseInfoLayout boD;
    protected LinearLayout boH;
    public ConcernThreadUserInfoLayout deG;
    private View deJ;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiR = true;
        this.bQU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Zx() != null) {
                    b.this.Zx().a(view, b.this.bQT);
                }
                b.this.ZP();
            }
        };
        this.bSN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<l> Zx = b.this.Zx();
                if (Zx != null) {
                    view.setTag("2");
                    Zx.a(view, b.this.bQT);
                }
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Zx() != null) {
                    b.this.Zx().a(view, b.this.bQT);
                }
            }
        };
        this.anA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Zx() != null) {
                    b.this.Zx().a(view, b.this.bQT);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bQP = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.bQP.getHeadView() != null) {
            this.bQP.getHeadView().setIsRound(true);
            this.bQP.getHeadView().setDrawBorder(false);
            this.bQP.getHeadView().setDefaultResource(17170445);
            this.bQP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bQP.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bQP.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.bQP.getPendantView() != null) {
            this.bQP.getPendantView().setIsRound(true);
            this.bQP.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.bSJ = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.bSJ.setAfterClickListener(this.bSN);
        this.bSL = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.bSL.setVisibility(8);
        this.bSM = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.bQS = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.bSM.setChildClickListener(this.bQU);
        this.bSM.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bSM.setImageProcessor(fVar);
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.deG = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.boD.setOnClickListener(this.bQU);
        this.boD.setReplyTimeVisible(false);
        this.boD.setIsBarViewVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(true);
        this.boD.setShareVisible(true);
        this.boD.setShareReportFrom(4);
        this.boD.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.Zx() != null) {
                    b.this.Zx().a(view2, b.this.bQT);
                }
            }
        });
        this.boH = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.deJ = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.bSM != null) {
            this.bSM.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bSM != null) {
            this.bSM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bSM != null) {
            this.bSM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.deJ, d.C0080d.cp_bg_line_e);
            this.bSM.onChangeSkinType();
            this.boD.onChangeSkinType();
            this.deG.onChangeSkinType();
            aj.k(this.bQS, d.C0080d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        boolean z;
        if (lVar == null || lVar.blk == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bQT = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bQU);
        }
        this.deG.setData(lVar.blk);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!ZB() && m.jL(this.bQT.blk.getId())) {
            m.a(this.mTitle, this.bQT.Np().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSL, this.bQT.blk.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        }
        this.deG.setUserAfterClickListener(this.anS);
        this.boD.setData(lVar.blk);
        this.boD.setStType(m.rj());
        final bh Np = lVar.Np();
        if (this.deG.getHeaderImg() != null) {
            if (this.deG.getIsSimpleThread()) {
                this.deG.getHeaderImg().setVisibility(8);
                this.bQP.setVisibility(8);
            } else if (Np.rt() == null || Np.rt().getPendantData() == null || StringUtils.isNull(Np.rt().getPendantData().pQ())) {
                this.bQP.setVisibility(8);
                this.deG.getHeaderImg().setVisibility(0);
                this.deG.getHeaderImg().setData(Np);
            } else {
                this.deG.getHeaderImg().setVisibility(4);
            }
        }
        y(Np);
        ArrayList<VoiceData.VoiceModel> rI = lVar.blk.rI();
        if (v.v(rI)) {
            this.bSJ.setVisibility(8);
            dz(false);
            z = false;
        } else {
            this.bSJ.setVisibility(0);
            dz(true);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bSJ.setVoiceModel(voiceModel);
            this.bSJ.setTag(voiceModel);
            this.bSJ.bjo();
            if (voiceModel != null) {
                this.bSJ.nx(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bQT.bUY && z) {
            this.bSM.setVisibility(8);
            this.deJ.setVisibility(0);
        } else {
            ArrayList<MediaData> rE = lVar.blk.rE();
            if (h.oT().oZ() && v.u(rE) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < rE.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(rE, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.u(linkedList) > 0) {
                    this.bSM.setVisibility(0);
                    this.deJ.setVisibility(8);
                    this.bSM.setFromCDN(this.aiR);
                    this.bSM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            x<l> Zx = b.this.Zx();
                            if (Zx != null) {
                                view.setTag("1");
                                Zx.a(view, b.this.bQT);
                            }
                            if (z2) {
                                b.this.ZP();
                            } else {
                                b.this.a(view, linkedList, i2, Np);
                            }
                        }
                    });
                    this.bSM.setImageMediaList(linkedList);
                } else {
                    this.bSM.setVisibility(8);
                    this.deJ.setVisibility(0);
                }
            } else {
                this.bSM.setVisibility(8);
                this.deJ.setVisibility(0);
            }
        }
        ZO();
        setPageUniqueId(getTag());
        ZQ();
    }

    private void dz(boolean z) {
        if (this.bSM != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSM.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.bSM.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                    imageUrlData.urlType = this.aiR ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.rz(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void ZO() {
        if (!this.bQT.aCw) {
            this.bSJ.setClickable(false);
        } else {
            this.bSJ.setClickable(true);
        }
        int childCount = this.bSM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bSM.getChildAt(i);
            if (childAt != null) {
                if (!this.bQT.aCw) {
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
        if (this.bSM != null) {
            this.bSM.setPageUniqueId(bdUniqueId);
        }
        if (this.deG != null) {
            this.deG.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.deG != null) {
            return this.deG.getHeaderImg();
        }
        return null;
    }

    public View ZA() {
        if (this.deG != null) {
            return this.deG.anO;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZP() {
        if (this.bQT != null && this.bQT.blk != null) {
            if (!ZB()) {
                m.jK(this.bQT.blk.getId());
                m.a(this.mTitle, this.bQT.Np().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                m.a(this.bSL, this.bQT.blk.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bQT.blk, null, m.rj(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.bQT.blk.getFid()));
            createFromThreadCfg.setForumName(this.bQT.blk.rz());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean ZB() {
        return this.bQT.bUY && !this.bQT.aCw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean y(bh bhVar) {
        SpannableStringBuilder g = bhVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(g));
            this.mTitle.setText(g);
            m.a(this.mTitle, bhVar.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        }
        return true;
    }

    private void ZQ() {
        if (this.mTitle != null && this.bSJ != null && this.bSM != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bSJ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.bSJ.setLayoutParams(layoutParams);
            if (this.bSJ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bSM.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.bSM.setLayoutParams(layoutParams2);
            }
        }
    }
}
