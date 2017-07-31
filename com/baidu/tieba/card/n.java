package com.baidu.tieba.card;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class n extends a<com.baidu.tieba.card.data.l> {
    private boolean ajJ;
    private TbPageContext<?> alI;
    private String aoF;
    private final View.OnClickListener aoG;
    private View.OnClickListener aoM;
    private final View.OnClickListener aoW;
    private HeadPendantClickableView bFM;
    private ThreadGodReplyLayout bFN;
    private View bFO;
    private com.baidu.tbadk.core.view.h bFP;
    private View bFQ;
    private com.baidu.tieba.card.data.l bFR;
    private View.OnClickListener bFS;
    public PlayVoiceBntNew bHA;
    private TextView bHB;
    private ConstrainImageGroup bHC;
    private final View.OnClickListener bHD;
    public ThreadUserInfoLayout bkV;
    public ThreadCommentAndPraiseInfoLayout bkZ;
    protected LinearLayout bld;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bFP = null;
        this.mSkinType = 3;
        this.ajJ = true;
        this.bFS = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.We() != null) {
                    n.this.We().a(view, n.this.bFR);
                }
                n.this.dD(view == n.this.bFN);
            }
        };
        this.bHD = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> We = n.this.We();
                if (We != null) {
                    view.setTag("2");
                    We.a(view, n.this.bFR);
                }
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.We() != null) {
                    n.this.We().a(view, n.this.bFR);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.We() != null) {
                    n.this.We().a(view, n.this.bFR);
                }
            }
        };
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.bFR != null && !StringUtils.isNull(n.this.bFR.threadData.rK())) {
                    String rK = n.this.bFR.threadData.rK();
                    if (!StringUtils.isNull(n.this.mStType) && !StringUtils.isNull(n.this.aoF)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createCfgForpersonalized(rK, n.this.mStType, n.this.aoF)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(rK, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                    if (n.this.aoG != null) {
                        n.this.aoG.onClick(view);
                    }
                }
            }
        };
        View view = getView();
        this.alI = tbPageContext;
        this.bFM = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
        }
        this.bFM.wD();
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bHA = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bHA.setAfterClickListener(this.bHD);
        this.bHB = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bHC = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bFQ = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bHC.setChildClickListener(this.bFS);
        this.bHC.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bHC.setImageProcessor(fVar);
        this.bkZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bkV = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bFO = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bFP = new com.baidu.tbadk.core.view.h(this.alI);
        this.bFP.wK();
        this.bFP.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bkV.addView(this.bFP);
        if (this.bkZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bkZ.setLayoutParams(layoutParams);
        }
        this.bkZ.setOnClickListener(this.bFS);
        this.bkZ.setReplyTimeVisible(false);
        this.bkZ.setShowPraiseNum(true);
        this.bkZ.setNeedAddPraiseIcon(true);
        this.bkZ.setNeedAddReplyIcon(true);
        this.bkZ.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bkZ.setFrom(1);
        this.bkZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.We() != null) {
                    n.this.We().a(view2, n.this.bFR);
                }
            }
        });
        this.bld = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.bFN = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bFN.setOnClickListener(this.bFS);
    }

    public void setSingleImageRatio(double d) {
        if (this.bHC != null) {
            this.bHC.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bHC != null) {
            this.bHC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bHC != null) {
            this.bHC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bHC.onChangeSkinType();
            this.bkZ.onChangeSkinType();
            this.bFN.onChangeSkinType();
            this.bkV.onChangeSkinType();
            if (this.bFP != null) {
                this.bFP.onChangeSkinType();
            }
            ai.k(this.bFQ, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02f9  */
    @Override // com.baidu.tieba.card.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.card.data.l lVar) {
        boolean z;
        StringBuilder sb;
        ArrayList<MediaData> rP;
        int i;
        boolean z2;
        ArrayList<VoiceData.VoiceModel> rT;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        boolean z6 = false;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bFR = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bFS);
        }
        if (this.bFP != null && this.bFR.MF() != null) {
            an anVar = new an();
            anVar.cF(this.bFR.MF().getTid());
            anVar.setFid(this.bFR.MF().getFid());
            anVar.a(this.bFR.XT);
            this.bFP.setData(anVar);
            this.bFP.setFirstRowSingleColumn(true);
        }
        this.bkV.a(lVar.threadData);
        this.bFN.setFromCDN(this.ajJ);
        this.bFN.setData(lVar.threadData.sU());
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        this.bFN.onChangeSkinType();
        if (lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bFP.setVisibility(8);
            } else {
                this.bFP.setVisibility(0);
            }
        }
        if (!Wi() && m.je(this.bFR.threadData.getId())) {
            m.a(this.mTitle, this.bFR.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bHB, this.bFR.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bFN.getGodReplyContent(), this.bFR.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bFN.getPraiseNum(), this.bFR.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bkV.setUserAfterClickListener(this.aoW);
        this.bkZ.a(lVar.threadData);
        this.bFO.setVisibility(0);
        this.mStType = m.rw();
        this.aoF = "feed#" + lVar.WF();
        final bl MF = lVar.MF();
        if (this.bkV.getHeaderImg() != null) {
            if (this.bkV.getIsSimpleThread()) {
                this.bkV.getHeaderImg().setVisibility(8);
                this.bFM.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pV())) {
                this.bFM.setVisibility(8);
                this.bkV.getHeaderImg().setVisibility(0);
                this.bkV.getHeaderImg().setData(MF);
            } else {
                this.bkV.getHeaderImg().setVisibility(4);
                this.bFM.setVisibility(0);
                this.bFM.setData(MF);
            }
        }
        m.b(MF, this.mTitle);
        if ((StringUtils.isNull(MF.getTitle()) && (MF.rD() == null || MF.rD().size() == 0)) || MF.rU() == 1) {
            MF.e(false, true);
            if (MF.sf() == null || StringUtils.isNull(MF.sf().toString())) {
                z = false;
                sb = new StringBuilder();
                if (MF.rN() != null && !StringUtils.isNull(MF.rN())) {
                    sb.append(MF.rN());
                }
                rP = lVar.threadData.rP();
                if (rP == null) {
                    i = rP.size();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 0; i2 < i; i2++) {
                        if (rP.get(i2).getVideoUrl() != null && rP.get(i2).getVideoUrl().endsWith("swf")) {
                            sb2.append(rP.get(i2).getVideoUrl());
                        }
                    }
                    sb.append(sb2.toString());
                    if (!TextUtils.isEmpty(lVar.MF().g(sb.toString(), true))) {
                        SpannableString cL = lVar.threadData.cL(sb.toString());
                        this.bHB.setOnTouchListener(new com.baidu.tieba.view.l(cL));
                        this.bHB.setText(cL);
                        this.bHB.setVisibility(0);
                        m.a(this.bHB, lVar.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                        z4 = true;
                    } else {
                        this.bHB.setVisibility(8);
                        z4 = false;
                    }
                    z2 = z4;
                } else {
                    this.bHB.setVisibility(8);
                    i = 0;
                    z2 = false;
                }
                rT = lVar.threadData.rT();
                if (!com.baidu.tbadk.core.util.u.v(rT)) {
                    this.bHA.setVisibility(8);
                    z3 = false;
                } else {
                    this.bHA.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rT.get(0);
                    this.bHA.setVoiceModel(voiceModel);
                    this.bHA.setTag(voiceModel);
                    this.bHA.bhR();
                    if (voiceModel != null) {
                        this.bHA.mG(voiceModel.voice_status.intValue());
                    }
                    z3 = true;
                }
                if (!this.bFR.bJI && z3) {
                    this.bHC.setVisibility(8);
                } else if (!com.baidu.tbadk.core.h.oX().pd() && com.baidu.tbadk.core.util.u.u(rP) != 0) {
                    LinkedList linkedList = new LinkedList();
                    final LinkedList linkedList2 = new LinkedList();
                    for (int i3 = 0; i3 < i; i3++) {
                        MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.u.c(rP, i3);
                        if (mediaData != null && mediaData.getType() == 3) {
                            linkedList.add(mediaData.getThumbnails_url());
                            linkedList2.add(mediaData);
                        }
                    }
                    if (com.baidu.tbadk.core.util.u.u(linkedList) > 0) {
                        this.bHC.setVisibility(0);
                        this.bHC.setFromCDN(this.ajJ);
                        this.bHC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.2
                            @Override // com.baidu.tbadk.widget.layout.d
                            public void c(View view, int i4, boolean z7) {
                                x<com.baidu.tieba.card.data.l> We = n.this.We();
                                if (We != null) {
                                    view.setTag("1");
                                    We.a(view, n.this.bFR);
                                }
                                if (z7) {
                                    n.this.Wu();
                                } else {
                                    n.this.a(linkedList2, i4, MF);
                                }
                            }
                        });
                        this.bHC.setImageUrls(linkedList);
                    } else {
                        this.bHC.setVisibility(8);
                        z5 = false;
                    }
                    z6 = z5;
                } else {
                    this.bHC.setVisibility(8);
                }
                Wt();
                g(z, z2, z6);
                setPageUniqueId(getTag());
            }
        }
        z = true;
        sb = new StringBuilder();
        if (MF.rN() != null) {
            sb.append(MF.rN());
        }
        rP = lVar.threadData.rP();
        if (rP == null) {
        }
        rT = lVar.threadData.rT();
        if (!com.baidu.tbadk.core.util.u.v(rT)) {
        }
        if (!this.bFR.bJI) {
        }
        if (!com.baidu.tbadk.core.h.oX().pd()) {
        }
        this.bHC.setVisibility(8);
        Wt();
        g(z, z2, z6);
        setPageUniqueId(getTag());
    }

    private void g(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHB.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bHC.getLayoutParams();
        if (!z && z2) {
            layoutParams.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2);
            } else if (z) {
                layoutParams2.topMargin = 0;
            }
        } else if (z2) {
            layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds13);
        } else if (z) {
            layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.alI.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajJ ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(blVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.alI.getPageActivity()).createConfig(arrayList, i, blVar.rK(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Wt() {
        if (!this.bFR.aDu) {
            this.bHA.setClickable(false);
        } else {
            this.bHA.setClickable(true);
        }
        int childCount = this.bHC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bHC.getChildAt(i);
            if (childAt != null) {
                if (!this.bFR.aDu) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajJ = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bHC != null) {
            this.bHC.setPageUniqueId(bdUniqueId);
        }
        if (this.bFP != null) {
            this.bFP.setUniqueId(bdUniqueId);
        }
        if (this.bkV != null) {
            this.bkV.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(h.a aVar) {
        if (this.bFP != null) {
            this.bFP.setEventCallback(aVar);
        }
    }

    public View Wg() {
        return this.bFN;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bkV != null) {
            return this.bkV.aoR;
        }
        return null;
    }

    public View Wh() {
        if (this.bkV != null) {
            return this.bkV.aoS;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wu() {
        dD(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        if (this.bFR != null && this.bFR.threadData != null) {
            if (!Wi()) {
                m.jd(this.bFR.threadData.getId());
                m.a(this.mTitle, this.bFR.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bHB, this.bFR.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bFN.getGodReplyContent(), this.bFR.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bFN.getPraiseNum(), this.bFR.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.alI.getPageActivity()).createFromThreadCfg(this.bFR.threadData, null, m.rw(), 18003, true, false, false).addLocateParam(this.bFR.WG());
            addLocateParam.setForumId(String.valueOf(this.bFR.threadData.getFid()));
            addLocateParam.setForumName(this.bFR.threadData.rK());
            if (this.bFR.bJq == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bFR.bJq);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.alI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wi() {
        return this.bFR.bJI && !this.bFR.aDu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
