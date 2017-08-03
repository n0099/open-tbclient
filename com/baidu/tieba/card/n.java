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
    private boolean aiq;
    private TbPageContext<?> ako;
    private final View.OnClickListener anD;
    private String anm;
    private final View.OnClickListener ann;
    private View.OnClickListener ant;
    private HeadPendantClickableView bEC;
    private ThreadGodReplyLayout bED;
    private View bEE;
    private com.baidu.tbadk.core.view.h bEF;
    private View bEG;
    private com.baidu.tieba.card.data.l bEH;
    private View.OnClickListener bEI;
    public PlayVoiceBntNew bGq;
    private TextView bGr;
    private ConstrainImageGroup bGs;
    private final View.OnClickListener bGt;
    public ThreadUserInfoLayout bjL;
    public ThreadCommentAndPraiseInfoLayout bjP;
    protected LinearLayout bjT;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bEF = null;
        this.mSkinType = 3;
        this.aiq = true;
        this.bEI = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.VZ() != null) {
                    n.this.VZ().a(view, n.this.bEH);
                }
                n.this.dD(view == n.this.bED);
            }
        };
        this.bGt = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.card.data.l> VZ = n.this.VZ();
                if (VZ != null) {
                    view.setTag("2");
                    VZ.a(view, n.this.bEH);
                }
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.VZ() != null) {
                    n.this.VZ().a(view, n.this.bEH);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.VZ() != null) {
                    n.this.VZ().a(view, n.this.bEH);
                }
            }
        };
        this.ant = new View.OnClickListener() { // from class: com.baidu.tieba.card.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.bEH != null && !StringUtils.isNull(n.this.bEH.threadData.rA())) {
                    String rA = n.this.bEH.threadData.rA();
                    if (!StringUtils.isNull(n.this.mStType) && !StringUtils.isNull(n.this.anm)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createCfgForpersonalized(rA, n.this.mStType, n.this.anm)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(rA, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                    if (n.this.ann != null) {
                        n.this.ann.onClick(view);
                    }
                }
            }
        };
        View view = getView();
        this.ako = tbPageContext;
        this.bEC = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bEC.getHeadView() != null) {
            this.bEC.getHeadView().setIsRound(true);
            this.bEC.getHeadView().setDrawBorder(false);
            this.bEC.getHeadView().setDefaultResource(17170445);
            this.bEC.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bEC.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bEC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
        }
        this.bEC.wt();
        if (this.bEC.getPendantView() != null) {
            this.bEC.getPendantView().setIsRound(true);
            this.bEC.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bGq = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bGq.setAfterClickListener(this.bGt);
        this.bGr = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bGs = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bEG = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bGs.setChildClickListener(this.bEI);
        this.bGs.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bGs.setImageProcessor(fVar);
        this.bjP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bjL = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bEE = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bEF = new com.baidu.tbadk.core.view.h(this.ako);
        this.bEF.wA();
        this.bEF.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bjL.addView(this.bEF);
        if (this.bjP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bjP.setLayoutParams(layoutParams);
        }
        this.bjP.setOnClickListener(this.bEI);
        this.bjP.setReplyTimeVisible(false);
        this.bjP.setShowPraiseNum(true);
        this.bjP.setNeedAddPraiseIcon(true);
        this.bjP.setNeedAddReplyIcon(true);
        this.bjP.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bjP.setFrom(1);
        this.bjP.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (n.this.VZ() != null) {
                    n.this.VZ().a(view2, n.this.bEH);
                }
            }
        });
        this.bjT = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
        this.bED = (ThreadGodReplyLayout) view.findViewById(d.h.card_home_page_god_reply_layout);
        this.bED.setOnClickListener(this.bEI);
    }

    public void setSingleImageRatio(double d) {
        if (this.bGs != null) {
            this.bGs.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bGs != null) {
            this.bGs.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bGs != null) {
            this.bGs.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bGs.onChangeSkinType();
            this.bjP.onChangeSkinType();
            this.bED.onChangeSkinType();
            this.bjL.onChangeSkinType();
            if (this.bEF != null) {
                this.bEF.onChangeSkinType();
            }
            ai.k(this.bEG, d.e.cp_bg_line_c);
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
        ArrayList<MediaData> rF;
        int i;
        boolean z2;
        ArrayList<VoiceData.VoiceModel> rJ;
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
        this.bEH = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bEI);
        }
        if (this.bEF != null && this.bEH.MA() != null) {
            an anVar = new an();
            anVar.cz(this.bEH.MA().getTid());
            anVar.setFid(this.bEH.MA().getFid());
            anVar.a(this.bEH.Wx);
            this.bEF.setData(anVar);
            this.bEF.setFirstRowSingleColumn(true);
        }
        this.bjL.a(lVar.threadData);
        this.bED.setFromCDN(this.aiq);
        this.bED.setData(lVar.threadData.sK());
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        this.bED.onChangeSkinType();
        if (lVar.threadData.getAuthor() != null && !StringUtils.isNull(lVar.threadData.getAuthor().getUserId())) {
            if (lVar.threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bEF.setVisibility(8);
            } else {
                this.bEF.setVisibility(0);
            }
        }
        if (!Wd() && m.iZ(this.bEH.threadData.getId())) {
            m.a(this.mTitle, this.bEH.MA().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGr, this.bEH.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bED.getGodReplyContent(), this.bEH.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bED.getPraiseNum(), this.bEH.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.bjL.setUserAfterClickListener(this.anD);
        this.bjP.a(lVar.threadData);
        this.bEE.setVisibility(0);
        this.mStType = m.rm();
        this.anm = "feed#" + lVar.WA();
        final bl MA = lVar.MA();
        if (this.bjL.getHeaderImg() != null) {
            if (this.bjL.getIsSimpleThread()) {
                this.bjL.getHeaderImg().setVisibility(8);
                this.bEC.setVisibility(8);
            } else if (MA.getAuthor() == null || MA.getAuthor().getPendantData() == null || StringUtils.isNull(MA.getAuthor().getPendantData().pL())) {
                this.bEC.setVisibility(8);
                this.bjL.getHeaderImg().setVisibility(0);
                this.bjL.getHeaderImg().setData(MA);
            } else {
                this.bjL.getHeaderImg().setVisibility(4);
                this.bEC.setVisibility(0);
                this.bEC.setData(MA);
            }
        }
        m.b(MA, this.mTitle);
        if ((StringUtils.isNull(MA.getTitle()) && (MA.rt() == null || MA.rt().size() == 0)) || MA.rK() == 1) {
            MA.e(false, true);
            if (MA.rV() == null || StringUtils.isNull(MA.rV().toString())) {
                z = false;
                sb = new StringBuilder();
                if (MA.rD() != null && !StringUtils.isNull(MA.rD())) {
                    sb.append(MA.rD());
                }
                rF = lVar.threadData.rF();
                if (rF == null) {
                    i = rF.size();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 0; i2 < i; i2++) {
                        if (rF.get(i2).getVideoUrl() != null && rF.get(i2).getVideoUrl().endsWith("swf")) {
                            sb2.append(rF.get(i2).getVideoUrl());
                        }
                    }
                    sb.append(sb2.toString());
                    if (!TextUtils.isEmpty(lVar.MA().g(sb.toString(), true))) {
                        SpannableString cF = lVar.threadData.cF(sb.toString());
                        this.bGr.setOnTouchListener(new com.baidu.tieba.view.l(cF));
                        this.bGr.setText(cF);
                        this.bGr.setVisibility(0);
                        m.a(this.bGr, lVar.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                        z4 = true;
                    } else {
                        this.bGr.setVisibility(8);
                        z4 = false;
                    }
                    z2 = z4;
                } else {
                    this.bGr.setVisibility(8);
                    i = 0;
                    z2 = false;
                }
                rJ = lVar.threadData.rJ();
                if (!com.baidu.tbadk.core.util.u.v(rJ)) {
                    this.bGq.setVisibility(8);
                    z3 = false;
                } else {
                    this.bGq.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rJ.get(0);
                    this.bGq.setVoiceModel(voiceModel);
                    this.bGq.setTag(voiceModel);
                    this.bGq.bhH();
                    if (voiceModel != null) {
                        this.bGq.mG(voiceModel.voice_status.intValue());
                    }
                    z3 = true;
                }
                if (!this.bEH.bIy && z3) {
                    this.bGs.setVisibility(8);
                } else if (!com.baidu.tbadk.core.h.oN().oT() && com.baidu.tbadk.core.util.u.u(rF) != 0) {
                    LinkedList linkedList = new LinkedList();
                    final LinkedList linkedList2 = new LinkedList();
                    for (int i3 = 0; i3 < i; i3++) {
                        MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.u.c(rF, i3);
                        if (mediaData != null && mediaData.getType() == 3) {
                            linkedList.add(mediaData.getThumbnails_url());
                            linkedList2.add(mediaData);
                        }
                    }
                    if (com.baidu.tbadk.core.util.u.u(linkedList) > 0) {
                        this.bGs.setVisibility(0);
                        this.bGs.setFromCDN(this.aiq);
                        this.bGs.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.n.2
                            @Override // com.baidu.tbadk.widget.layout.d
                            public void c(View view, int i4, boolean z7) {
                                x<com.baidu.tieba.card.data.l> VZ = n.this.VZ();
                                if (VZ != null) {
                                    view.setTag("1");
                                    VZ.a(view, n.this.bEH);
                                }
                                if (z7) {
                                    n.this.Wp();
                                } else {
                                    n.this.a(linkedList2, i4, MA);
                                }
                            }
                        });
                        this.bGs.setImageUrls(linkedList);
                    } else {
                        this.bGs.setVisibility(8);
                        z5 = false;
                    }
                    z6 = z5;
                } else {
                    this.bGs.setVisibility(8);
                }
                Wo();
                g(z, z2, z6);
                setPageUniqueId(getTag());
            }
        }
        z = true;
        sb = new StringBuilder();
        if (MA.rD() != null) {
            sb.append(MA.rD());
        }
        rF = lVar.threadData.rF();
        if (rF == null) {
        }
        rJ = lVar.threadData.rJ();
        if (!com.baidu.tbadk.core.util.u.v(rJ)) {
        }
        if (!this.bEH.bIy) {
        }
        if (!com.baidu.tbadk.core.h.oN().oT()) {
        }
        this.bGs.setVisibility(8);
        Wo();
        g(z, z2, z6);
        setPageUniqueId(getTag());
    }

    private void g(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGr.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bGs.getLayoutParams();
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
            com.baidu.adp.lib.util.k.showToast(this.ako.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aiq ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(blVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ako.getPageActivity()).createConfig(arrayList, i, blVar.rA(), String.valueOf(blVar.getFid()), blVar.getTid(), this.aiq, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Wo() {
        if (!this.bEH.aCd) {
            this.bGq.setClickable(false);
        } else {
            this.bGq.setClickable(true);
        }
        int childCount = this.bGs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bGs.getChildAt(i);
            if (childAt != null) {
                if (!this.bEH.aCd) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiq = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bGs != null) {
            this.bGs.setPageUniqueId(bdUniqueId);
        }
        if (this.bEF != null) {
            this.bEF.setUniqueId(bdUniqueId);
        }
        if (this.bjL != null) {
            this.bjL.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(h.a aVar) {
        if (this.bEF != null) {
            this.bEF.setEventCallback(aVar);
        }
    }

    public View Wb() {
        return this.bED;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bjL != null) {
            return this.bjL.any;
        }
        return null;
    }

    public View Wc() {
        if (this.bjL != null) {
            return this.bjL.anz;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wp() {
        dD(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        if (this.bEH != null && this.bEH.threadData != null) {
            if (!Wd()) {
                m.iY(this.bEH.threadData.getId());
                m.a(this.mTitle, this.bEH.MA().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bGr, this.bEH.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bED.getGodReplyContent(), this.bEH.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                m.a(this.bED.getPraiseNum(), this.bEH.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ako.getPageActivity()).createFromThreadCfg(this.bEH.threadData, null, m.rm(), 18003, true, false, false).addLocateParam(this.bEH.WB());
            addLocateParam.setForumId(String.valueOf(this.bEH.threadData.getFid()));
            addLocateParam.setForumName(this.bEH.threadData.rA());
            if (this.bEH.bIg == 0) {
                addLocateParam.setStartFrom(2);
            } else {
                addLocateParam.setStartFrom(this.bEH.bIg);
            }
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ako.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wd() {
        return this.bEH.bIy && !this.bEH.aCd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
