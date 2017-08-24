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
    private boolean ajL;
    private String aoG;
    private final View.OnClickListener aoH;
    private View.OnClickListener aoN;
    private final View.OnClickListener aoX;
    private View bGA;
    private com.baidu.tieba.card.data.l bGB;
    private View.OnClickListener bGC;
    private HeadPendantClickableView bGw;
    private ThreadGodReplyLayout bGx;
    private View bGy;
    private com.baidu.tbadk.core.view.h bGz;
    public PlayVoiceBntNew bIk;
    private TextView bIl;
    private ConstrainImageGroup bIm;
    private final View.OnClickListener bIn;
    public ThreadUserInfoLayout bla;
    public ThreadCommentAndPraiseInfoLayout ble;
    protected LinearLayout bli;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;
    private TbPageContext<?> oW;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGz = null;
        this.mSkinType = 3;
        this.ajL = true;
        this.bGC = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.Wx() != null) {
                    n.this.Wx().a(view, n.this.bGB);
                }
                n.this.dE(view == n.this.bGx);
            }
        };
        this.bIn = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> Wx = n.this.Wx();
                if (Wx != null) {
                    view.setTag("2");
                    Wx.a(view, n.this.bGB);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.Wx() != null) {
                    n.this.Wx().a(view, n.this.bGB);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.Wx() != null) {
                    n.this.Wx().a(view, n.this.bGB);
                }
            }
        };
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.bGB != null && !StringUtils.isNull(n.this.bGB.threadData.rL())) {
                    String rL = n.this.bGB.threadData.rL();
                    if (!StringUtils.isNull(n.this.mStType) && !StringUtils.isNull(n.this.aoG)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createCfgForpersonalized(rL, n.this.mStType, n.this.aoG)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(rL, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                    if (n.this.aoH != null) {
                        n.this.aoH.onClick(view);
                    }
                }
            }
        };
        View view = getView();
        this.oW = tbPageContext;
        this.bGw = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bGw.getHeadView() != null) {
            this.bGw.getHeadView().setIsRound(true);
            this.bGw.getHeadView().setDrawBorder(false);
            this.bGw.getHeadView().setDefaultResource(17170445);
            this.bGw.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGw.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGw.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
        }
        this.bGw.wE();
        if (this.bGw.getPendantView() != null) {
            this.bGw.getPendantView().setIsRound(true);
            this.bGw.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bIk = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bIk.setAfterClickListener(this.bIn);
        this.bIl = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bIm = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bGA = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bIm.setChildClickListener(this.bGC);
        this.bIm.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bIm.setImageProcessor(fVar);
        this.ble = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bla = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bGy = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bGz = new com.baidu.tbadk.core.view.h(this.oW);
        this.bGz.wL();
        this.bGz.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bla.addView(this.bGz);
        if (this.ble.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ble.setLayoutParams(layoutParams);
        }
        this.ble.setOnClickListener(this.bGC);
        this.ble.setReplyTimeVisible(false);
        this.ble.setShowPraiseNum(true);
        this.ble.setNeedAddPraiseIcon(true);
        this.ble.setNeedAddReplyIcon(true);
        this.ble.setReplyIcon(d.g.icon_home_card_comment_n);
        this.ble.setFrom(1);
        this.ble.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.Wx() != null) {
                    n.this.Wx().a(view2, n.this.bGB);
                }
            }
        });
        this.bli = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.bGx = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bGx.setOnClickListener(this.bGC);
    }

    public void setSingleImageRatio(double d) {
        if (this.bIm != null) {
            this.bIm.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bIm != null) {
            this.bIm.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bIm != null) {
            this.bIm.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bIm.onChangeSkinType();
            this.ble.onChangeSkinType();
            this.bGx.onChangeSkinType();
            this.bla.onChangeSkinType();
            if (this.bGz != null) {
                this.bGz.onChangeSkinType();
            }
            ai.k(this.bGA, d.e.cp_bg_line_c);
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
        ArrayList<MediaData> rQ;
        int i;
        boolean z2;
        ArrayList<VoiceData.VoiceModel> rU;
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
        this.bGB = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGC);
        }
        if (this.bGz != null && this.bGB.MF() != null) {
            an anVar = new an();
            anVar.cI(this.bGB.MF().getTid());
            anVar.setFid(this.bGB.MF().getFid());
            anVar.a(this.bGB.XW);
            this.bGz.setData(anVar);
            this.bGz.setFirstRowSingleColumn(true);
        }
        this.bla.a(lVar.threadData);
        this.bGx.setFromCDN(this.ajL);
        this.bGx.setData(lVar.threadData.sV());
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        this.bGx.onChangeSkinType();
        if (lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bGz.setVisibility(8);
            } else {
                this.bGz.setVisibility(0);
            }
        }
        if (!WB() && m.ji(this.bGB.threadData.getId())) {
            m.a(this.mTitle, this.bGB.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIl, this.bGB.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGx.getGodReplyContent(), this.bGB.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGx.getPraiseNum(), this.bGB.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bla.setUserAfterClickListener(this.aoX);
        this.ble.a(lVar.threadData);
        this.bGy.setVisibility(0);
        this.mStType = m.rx();
        this.aoG = "feed#" + lVar.WY();
        final bl MF = lVar.MF();
        if (this.bla.getHeaderImg() != null) {
            if (this.bla.getIsSimpleThread()) {
                this.bla.getHeaderImg().setVisibility(8);
                this.bGw.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pW())) {
                this.bGw.setVisibility(8);
                this.bla.getHeaderImg().setVisibility(0);
                this.bla.getHeaderImg().setData(MF);
            } else {
                this.bla.getHeaderImg().setVisibility(4);
                this.bGw.setVisibility(0);
                this.bGw.setData(MF);
            }
        }
        m.b(MF, this.mTitle);
        if ((StringUtils.isNull(MF.getTitle()) && (MF.rE() == null || MF.rE().size() == 0)) || MF.rV() == 1) {
            MF.e(false, true);
            if (MF.sg() == null || StringUtils.isNull(MF.sg().toString())) {
                z = false;
                sb = new StringBuilder();
                if (MF.rO() != null && !StringUtils.isNull(MF.rO())) {
                    sb.append(MF.rO());
                }
                rQ = lVar.threadData.rQ();
                if (rQ == null) {
                    i = rQ.size();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 0; i2 < i; i2++) {
                        if (rQ.get(i2).getVideoUrl() != null && rQ.get(i2).getVideoUrl().endsWith("swf")) {
                            sb2.append(rQ.get(i2).getVideoUrl());
                        }
                    }
                    sb.append(sb2.toString());
                    if (!TextUtils.isEmpty(lVar.MF().g(sb.toString(), true))) {
                        SpannableString cO = lVar.threadData.cO(sb.toString());
                        this.bIl.setOnTouchListener(new com.baidu.tieba.view.l(cO));
                        this.bIl.setText(cO);
                        this.bIl.setVisibility(0);
                        m.a(this.bIl, lVar.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                        z4 = true;
                    } else {
                        this.bIl.setVisibility(8);
                        z4 = false;
                    }
                    z2 = z4;
                } else {
                    this.bIl.setVisibility(8);
                    i = 0;
                    z2 = false;
                }
                rU = lVar.threadData.rU();
                if (!com.baidu.tbadk.core.util.u.v(rU)) {
                    this.bIk.setVisibility(8);
                    z3 = false;
                } else {
                    this.bIk.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rU.get(0);
                    this.bIk.setVoiceModel(voiceModel);
                    this.bIk.setTag(voiceModel);
                    this.bIk.bis();
                    if (voiceModel != null) {
                        this.bIk.mQ(voiceModel.voice_status.intValue());
                    }
                    z3 = true;
                }
                if (!this.bGB.bKs && z3) {
                    this.bIm.setVisibility(8);
                } else if (!com.baidu.tbadk.core.h.oY().pe() && com.baidu.tbadk.core.util.u.u(rQ) != 0) {
                    LinkedList linkedList = new LinkedList();
                    final LinkedList linkedList2 = new LinkedList();
                    for (int i3 = 0; i3 < i; i3++) {
                        MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.u.c(rQ, i3);
                        if (mediaData != null && mediaData.getType() == 3) {
                            linkedList.add(mediaData.getThumbnails_url());
                            linkedList2.add(mediaData);
                        }
                    }
                    if (com.baidu.tbadk.core.util.u.u(linkedList) > 0) {
                        this.bIm.setVisibility(0);
                        this.bIm.setFromCDN(this.ajL);
                        this.bIm.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.2
                            @Override // com.baidu.tbadk.widget.layout.d
                            public void c(View view, int i4, boolean z7) {
                                x<com.baidu.tieba.card.data.l> Wx = n.this.Wx();
                                if (Wx != null) {
                                    view.setTag("1");
                                    Wx.a(view, n.this.bGB);
                                }
                                if (z7) {
                                    n.this.WN();
                                } else {
                                    n.this.a(linkedList2, i4, MF);
                                }
                            }
                        });
                        this.bIm.setImageUrls(linkedList);
                    } else {
                        this.bIm.setVisibility(8);
                        z5 = false;
                    }
                    z6 = z5;
                } else {
                    this.bIm.setVisibility(8);
                }
                WM();
                h(z, z2, z6);
                setPageUniqueId(getTag());
            }
        }
        z = true;
        sb = new StringBuilder();
        if (MF.rO() != null) {
            sb.append(MF.rO());
        }
        rQ = lVar.threadData.rQ();
        if (rQ == null) {
        }
        rU = lVar.threadData.rU();
        if (!com.baidu.tbadk.core.util.u.v(rU)) {
        }
        if (!this.bGB.bKs) {
        }
        if (!com.baidu.tbadk.core.h.oY().pe()) {
        }
        this.bIm.setVisibility(8);
        WM();
        h(z, z2, z6);
        setPageUniqueId(getTag());
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIl.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bIm.getLayoutParams();
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
            com.baidu.adp.lib.util.k.showToast(this.oW.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajL ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.oW.getPageActivity()).createConfig(arrayList, i, blVar.rL(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajL, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void WM() {
        if (!this.bGB.aDw) {
            this.bIk.setClickable(false);
        } else {
            this.bIk.setClickable(true);
        }
        int childCount = this.bIm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIm.getChildAt(i);
            if (childAt != null) {
                if (!this.bGB.aDw) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajL = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bIm != null) {
            this.bIm.setPageUniqueId(bdUniqueId);
        }
        if (this.bGz != null) {
            this.bGz.setUniqueId(bdUniqueId);
        }
        if (this.bla != null) {
            this.bla.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(h.a aVar) {
        if (this.bGz != null) {
            this.bGz.setEventCallback(aVar);
        }
    }

    public View Wz() {
        return this.bGx;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bla != null) {
            return this.bla.aoS;
        }
        return null;
    }

    public View WA() {
        if (this.bla != null) {
            return this.bla.aoT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN() {
        dE(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(boolean z) {
        if (this.bGB != null && this.bGB.threadData != null) {
            if (!WB()) {
                m.jh(this.bGB.threadData.getId());
                m.a(this.mTitle, this.bGB.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bIl, this.bGB.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bGx.getGodReplyContent(), this.bGB.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bGx.getPraiseNum(), this.bGB.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.oW.getPageActivity()).createFromThreadCfg(this.bGB.threadData, null, m.rx(), 18003, true, false, false).addLocateParam(this.bGB.WZ());
            addLocateParam.setForumId(String.valueOf(this.bGB.threadData.getFid()));
            addLocateParam.setForumName(this.bGB.threadData.rL());
            if (this.bGB.bKa == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bGB.bKa);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.oW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean WB() {
        return this.bGB.bKs && !this.bGB.aDw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
