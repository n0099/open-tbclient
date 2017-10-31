package com.baidu.tieba.card;

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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class n extends a<com.baidu.tieba.card.data.l> {
    private boolean aiR;
    private final View.OnClickListener anA;
    private final View.OnClickListener anS;
    private String anz;
    private HeadPendantClickableView bQP;
    private ThreadGodReplyLayout bQQ;
    private com.baidu.tieba.NEGFeedBack.c bQR;
    private View bQS;
    private com.baidu.tieba.card.data.l bQT;
    private View.OnClickListener bQU;
    private View.OnClickListener bRT;
    public PlayVoiceBntNew bSJ;
    private View bSK;
    private TextView bSL;
    private ConstrainImageGroup bSM;
    private final View.OnClickListener bSN;
    public ThreadCommentAndPraiseInfoLayout boD;
    protected LinearLayout boH;
    public ThreadUserInfoLayout boz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bQR = null;
        this.mSkinType = 3;
        this.aiR = true;
        this.bQU = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.Zx() != null) {
                    n.this.Zx().a(view, n.this.bQT);
                }
                n.this.dy(view == n.this.bQQ);
            }
        };
        this.bSN = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Zx = n.this.Zx();
                if (Zx != null) {
                    view.setTag("2");
                    Zx.a(view, n.this.bQT);
                }
            }
        };
        this.anS = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.Zx() != null) {
                    n.this.Zx().a(view, n.this.bQT);
                }
            }
        };
        this.anA = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.Zx() != null) {
                    n.this.Zx().a(view, n.this.bQT);
                }
            }
        };
        this.bRT = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.bQT != null && !StringUtils.isNull(n.this.bQT.blk.rz())) {
                    String rz = n.this.bQT.blk.rz();
                    if (!StringUtils.isNull(n.this.mStType) && !StringUtils.isNull(n.this.anz)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createCfgForpersonalized(rz, n.this.mStType, n.this.anz)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(rz, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                    if (n.this.anA != null) {
                        n.this.anA.onClick(view);
                    }
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bQP = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bQP.getHeadView() != null) {
            this.bQP.getHeadView().setIsRound(true);
            this.bQP.getHeadView().setDrawBorder(false);
            this.bQP.getHeadView().setDefaultResource(17170445);
            this.bQP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bQP.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bQP.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bQP.wg();
        if (this.bQP.getPendantView() != null) {
            this.bQP.getPendantView().setIsRound(true);
            this.bQP.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.bSJ = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.bSJ.setAfterClickListener(this.bSN);
        this.bSL = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.bSL.setVisibility(8);
        this.bSM = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.bQS = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.bSM.setChildClickListener(this.bQU);
        this.bSM.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bSM.setImageProcessor(fVar);
        this.bSK = view.findViewById(d.g.divider_line_above_praise);
        this.boD = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.boz = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bQR = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.bQR.Ku();
        this.bQR.setLeftPadding((int) getContext().getResources().getDimension(d.e.ds60));
        this.boz.addView(this.bQR);
        if (this.boD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boD.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boD.setLayoutParams(layoutParams);
        }
        this.boD.setOnClickListener(this.bQU);
        this.boD.setReplyTimeVisible(false);
        this.boD.setShowPraiseNum(true);
        this.boD.setNeedAddPraiseIcon(true);
        this.boD.setNeedAddReplyIcon(true);
        this.boD.setShareVisible(true);
        this.boD.setFrom(1);
        this.boD.setShareReportFrom(3);
        this.boD.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.Zx() != null) {
                    n.this.Zx().a(view2, n.this.bQT);
                }
            }
        });
        this.boH = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.bQQ = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bQQ.setOnClickListener(this.bQU);
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
            aj.k(this.bSK, d.C0080d.cp_bg_line_e);
            this.bSM.onChangeSkinType();
            this.boD.onChangeSkinType();
            this.bQQ.onChangeSkinType();
            this.boz.onChangeSkinType();
            if (this.bQR != null) {
                this.bQR.onChangeSkinType();
            }
            aj.k(this.bQS, d.C0080d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
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
        if (this.bQR != null && this.bQT.Np() != null) {
            al alVar = new al();
            alVar.cD(this.bQT.Np().getTid());
            alVar.setFid(this.bQT.Np().getFid());
            alVar.a(this.bQT.Xm);
            this.bQR.setData(alVar);
            this.bQR.setFirstRowSingleColumn(true);
        }
        this.boz.setData(lVar.blk);
        this.bQQ.setFromCDN(this.aiR);
        this.bQQ.setData(lVar.blk.sL());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bQQ.onChangeSkinType();
        if (lVar.blk.rt() != null && !StringUtils.isNull(lVar.blk.rt().getUserId())) {
            if (lVar.blk.rt().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bQR.setVisibility(8);
            } else {
                this.bQR.setVisibility(0);
            }
        }
        if (!ZB() && m.jL(this.bQT.blk.getId())) {
            m.a(this.mTitle, this.bQT.Np().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSL, this.bQT.blk.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
            m.a(this.bQQ.getGodReplyContent(), this.bQT.blk.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        }
        this.boz.setUserAfterClickListener(this.anS);
        this.boD.setData(lVar.blk);
        this.mStType = m.rj();
        this.boD.setStType(this.mStType);
        this.anz = "feed#" + lVar.aaa();
        final bh Np = lVar.Np();
        if (this.boz.getHeaderImg() != null) {
            if (this.boz.getIsSimpleThread()) {
                this.boz.getHeaderImg().setVisibility(8);
                this.bQP.setVisibility(8);
            } else if (Np.rt() == null || Np.rt().getPendantData() == null || StringUtils.isNull(Np.rt().getPendantData().pQ())) {
                this.bQP.setVisibility(8);
                this.boz.getHeaderImg().setVisibility(0);
                this.boz.getHeaderImg().setData(Np);
            } else {
                this.boz.getHeaderImg().setVisibility(4);
                this.bQP.setVisibility(0);
                this.bQP.setData(Np);
            }
        }
        y(Np);
        ArrayList<VoiceData.VoiceModel> rI = lVar.blk.rI();
        if (com.baidu.tbadk.core.util.v.v(rI)) {
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
        } else {
            ArrayList<MediaData> rE = Np.rE();
            if (com.baidu.tbadk.core.h.oT().oZ() && com.baidu.tbadk.core.util.v.u(rE) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < rE.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rE, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.u(linkedList) > 0) {
                    this.bSM.setVisibility(0);
                    this.bSM.setFromCDN(this.aiR);
                    this.bSM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            x<com.baidu.tieba.card.data.l> Zx = n.this.Zx();
                            if (Zx != null) {
                                view.setTag("1");
                                Zx.a(view, n.this.bQT);
                            }
                            if (z2) {
                                n.this.ZP();
                            } else {
                                n.this.a(view, linkedList, i2, Np);
                            }
                        }
                    });
                    this.bSM.setImageMediaList(linkedList);
                } else {
                    this.bSM.setVisibility(8);
                }
            } else {
                this.bSM.setVisibility(8);
            }
        }
        ZN();
        ZO();
        setPageUniqueId(getTag());
        ZQ();
    }

    private void ZN() {
        if (this.bSK != null && this.bSM != null && this.bQQ != null) {
            if (this.bSM.getVisibility() == 8 && this.bQQ.getVisibility() == 8) {
                this.bSK.setVisibility(0);
            } else {
                this.bSK.setVisibility(8);
            }
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
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
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

    public void setFromCDN(boolean z) {
        this.aiR = z;
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
        if (this.bQR != null) {
            this.bQR.setUniqueId(bdUniqueId);
        }
        if (this.boz != null) {
            this.boz.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.bQR != null) {
            this.bQR.setEventCallback(aVar);
        }
    }

    public View Zz() {
        return this.bQQ;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.boz != null) {
            return this.boz.anN;
        }
        return null;
    }

    public View ZA() {
        if (this.boz != null) {
            return this.boz.anO;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZP() {
        dy(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(boolean z) {
        if (this.bQT != null && this.bQT.blk != null) {
            if (!ZB()) {
                m.jK(this.bQT.blk.getId());
                m.a(this.mTitle, this.bQT.Np().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                m.a(this.bSL, this.bQT.blk.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
                m.a(this.bQQ.getGodReplyContent(), this.bQT.blk.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bQT.blk, null, m.rj(), 18003, true, false, false).addLocateParam(this.bQT.aab());
            addLocateParam.setForumId(String.valueOf(this.bQT.blk.getFid()));
            addLocateParam.setForumName(this.bQT.blk.rz());
            if (this.bQT.bUF == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bQT.bUF);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
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
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
                this.bSM.setLayoutParams(layoutParams2);
            }
        }
    }
}
