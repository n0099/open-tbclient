package com.baidu.tieba.card;

import android.graphics.Rect;
import android.text.SpannableString;
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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class p extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private boolean asK;
    private final View.OnClickListener axr;
    private String bER;
    private HeadPendantClickableView bFP;
    public ThreadSourceShareAndPraiseLayout bFT;
    public ThreadUserInfoLayout bFd;
    public ThreadCommentAndPraiseInfoLayout bFe;
    private NEGFeedBackView bFq;
    protected LinearLayout bGe;
    private ThreadGodReplyLayout cvM;
    private View cvN;
    private com.baidu.tieba.card.data.k cvO;
    private View.OnClickListener cvP;
    public PlayVoiceBntNew cyE;
    private View cyF;
    private TextView cyG;
    private ConstrainImageGroup cyH;
    private boolean cyI;
    private RelativeLayout cyJ;
    private final View.OnClickListener cyK;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bFq = null;
        this.mSkinType = 3;
        this.asK = true;
        this.cyI = true;
        this.cvP = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cvO != null) {
                    p.this.cvO.cBp = 1;
                }
                if (p.this.aiI() != null) {
                    p.this.aiI().a(view, p.this.cvO);
                }
                p.this.es(view == p.this.cvM);
            }
        };
        this.cyK = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.card.data.k> aiI = p.this.aiI();
                if (aiI != null) {
                    view.setTag("2");
                    aiI.a(view, p.this.cvO);
                }
            }
        };
        this.axr = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cvO == null) {
                    if (p.this.aiI() != null) {
                        p.this.aiI().a(view, p.this.cvO);
                        return;
                    }
                    return;
                }
                if (view == p.this.bFd.getUserName()) {
                    p.this.cvO.cBp = 3;
                } else if (view == p.this.bFd.getHeaderImg()) {
                    p.this.cvO.cBp = 4;
                } else if (view == p.this.cyH) {
                    p.this.cvO.cBp = 2;
                    return;
                } else {
                    p.this.cvO.cBp = 1;
                }
                if (p.this.aiI() != null) {
                    p.this.aiI().a(view, p.this.cvO);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bFP = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bFP.getHeadView() != null) {
            this.bFP.getHeadView().setIsRound(true);
            this.bFP.getHeadView().setDrawBorder(false);
            this.bFP.getHeadView().setDefaultResource(17170445);
            this.bFP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bFP.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bFP.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bFP.setHasPendantStyle();
        if (this.bFP.getPendantView() != null) {
            this.bFP.getPendantView().setIsRound(true);
            this.bFP.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cyE = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cyE.setAfterClickListener(this.cyK);
        this.cyG = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cyG.setVisibility(8);
        this.cyH = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cvN = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.cyH.setChildClickListener(this.cvP);
        this.cyH.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.j(1.0d);
        this.cyH.setImageProcessor(eVar);
        this.cyF = view.findViewById(d.g.divider_line_above_praise);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bFd = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bFq = new NEGFeedBackView(this.mPageContext);
        this.cyJ = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.bFq.a(this.cyJ, com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds120), 0);
        if (this.bFe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bFe.setLayoutParams(layoutParams);
        }
        this.bFe.setOnClickListener(this.cvP);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setShareVisible(true);
        this.bFe.setFrom(1);
        this.bFe.setShareReportFrom(3);
        this.bFe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aiI() != null) {
                    p.this.aiI().a(view2, p.this.cvO);
                }
                if (p.this.cvO != null && p.this.cvO.threadData != null) {
                    o.lb(p.this.cvO.threadData.getId());
                    if (!p.this.aiM()) {
                        o.a(p.this.mTitle, p.this.cvO.Sz().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                        o.a(p.this.cyG, p.this.cvO.threadData.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                        o.a(p.this.cvM.getGodReplyContent(), p.this.cvO.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                    }
                }
            }
        });
        this.bGe = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cvM = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cvM.setOnClickListener(this.cvP);
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.bFT.axN.setOnClickListener(this.cvP);
        this.bFT.setFrom(1);
        this.bFT.setShareReportFrom(3);
        this.bFT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aiI() != null) {
                    p.this.aiI().a(view2, p.this.cvO);
                }
                if (p.this.cvO != null && p.this.cvO.threadData != null && view2 != p.this.bFT.axM) {
                    o.lb(p.this.cvO.threadData.getId());
                    if (!p.this.aiM()) {
                        o.a(p.this.mTitle, p.this.cvO.Sz().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                        o.a(p.this.cyG, p.this.cvO.threadData.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                        o.a(p.this.cvM.getGodReplyContent(), p.this.cvO.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cyH != null) {
            this.cyH.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cyH != null) {
            this.cyH.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.addresslist_item_bg);
            al.j(this.cyF, d.C0141d.transparent);
            this.cyH.onChangeSkinType();
            this.bFe.onChangeSkinType();
            this.cvM.onChangeSkinType();
            this.bFd.onChangeSkinType();
            if (this.bFq != null) {
                this.bFq.onChangeSkinType();
            }
            al.j(this.cvN, d.C0141d.cp_bg_line_e);
            if (this.bFT != null) {
                this.bFT.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        boolean z;
        if (kVar == null || kVar.Sz() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cvO = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cvP);
        }
        if (this.bFq != null) {
            if (this.cvO.agK != null && this.cvO.agK.size() > 0) {
                ai aiVar = new ai();
                aiVar.dh(this.cvO.Sz().getTid());
                aiVar.setFid(this.cvO.Sz().getFid());
                aiVar.a(this.cvO.agK);
                this.bFq.setData(aiVar);
                this.bFq.setFirstRowSingleColumn(true);
                if (kVar.threadData.vm() != null && !StringUtils.isNull(kVar.threadData.vm().getUserId())) {
                    if (kVar.threadData.vm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bFq.setVisibility(8);
                    } else if (this.bFq != null) {
                        this.bFq.setVisibility(this.cyI ? 0 : 8);
                    }
                }
            } else {
                this.bFq.setVisibility(8);
            }
        }
        this.bFd.setData(kVar.threadData);
        this.cvM.setFromCDN(this.asK);
        this.cvM.setData(kVar.threadData.wy());
        if (!aiM() && o.lc(this.cvO.threadData.getId())) {
            o.a(this.mTitle, this.cvO.Sz().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            o.a(this.cyG, this.cvO.threadData.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
            o.a(this.cvM.getGodReplyContent(), this.cvO.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        this.bFd.setUserAfterClickListener(this.axr);
        final bd Sz = kVar.Sz();
        if (this.bFd.getHeaderImg() != null) {
            if (this.bFd.getIsSimpleThread()) {
                this.bFd.getHeaderImg().setVisibility(8);
                this.bFP.setVisibility(8);
            } else if (Sz.vm() == null || Sz.vm().getPendantData() == null || StringUtils.isNull(Sz.vm().getPendantData().ub())) {
                this.bFP.setVisibility(8);
                this.bFd.getHeaderImg().setVisibility(0);
                this.bFd.getHeaderImg().setData(Sz);
            } else {
                this.bFd.getHeaderImg().setVisibility(4);
                this.bFP.setVisibility(0);
                this.bFP.setData(Sz);
            }
        }
        G(Sz);
        H(Sz);
        ArrayList<VoiceData.VoiceModel> vA = kVar.threadData.vA();
        if (com.baidu.tbadk.core.util.w.z(vA)) {
            this.cyE.setVisibility(8);
            z = false;
        } else {
            this.cyE.setVisibility(0);
            VoiceData.VoiceModel voiceModel = vA.get(0);
            this.cyE.setVoiceModel(voiceModel);
            this.cyE.setTag(voiceModel);
            this.cyE.aNN();
            if (voiceModel != null) {
                this.cyE.om(voiceModel.voice_status.intValue());
            }
            this.cyE.byi();
            z = true;
        }
        if (this.cvO.cBM && z) {
            this.cyH.setVisibility(8);
        } else {
            ArrayList<MediaData> vw = Sz.vw();
            if (com.baidu.tbadk.core.i.tt().tz() && com.baidu.tbadk.core.util.w.y(vw) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < vw.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.c(vw, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.w.y(linkedList) > 0) {
                    this.cyH.setVisibility(0);
                    this.cyH.setFromCDN(this.asK);
                    this.cyH.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.k> aiI = p.this.aiI();
                            if (aiI != null) {
                                view.setTag("1");
                                if (p.this.axr != null) {
                                    p.this.axr.onClick(p.this.cyH);
                                }
                                aiI.a(view, p.this.cvO);
                            }
                            if (z2) {
                                p.this.ajb();
                            } else {
                                p.this.a(view, linkedList, i2, Sz);
                            }
                        }
                    });
                    this.cyH.setImageMediaList(linkedList);
                } else {
                    this.cyH.setVisibility(8);
                }
            } else {
                this.cyH.setVisibility(8);
            }
        }
        aiZ();
        aja();
        setPageUniqueId(getTag());
        hd(go(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aiZ() {
        if (this.cyF != null && this.cyH != null && this.cvM != null) {
            if (this.cyH.getVisibility() == 8 && this.cvM.getVisibility() == 8) {
                this.cyF.setVisibility(0);
            } else {
                this.cyF.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.k.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.asK ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.vr(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.asK, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void aja() {
        if (!this.cvO.aMC) {
            this.cyE.setClickable(false);
        } else {
            this.cyE.setClickable(true);
        }
        int childCount = this.cyH.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cyH.getChildAt(i);
            if (childAt != null) {
                if (!this.cvO.aMC) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.asK = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cyH != null) {
            this.cyH.setPageUniqueId(bdUniqueId);
        }
        if (this.bFq != null) {
            this.bFq.setUniqueId(bdUniqueId);
        }
        if (this.bFd != null) {
            this.bFd.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bFq != null) {
            this.bFq.setEventCallback(aVar);
        }
    }

    public View aiK() {
        return this.cvM;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bFd != null) {
            return this.bFd.axn;
        }
        return null;
    }

    public View aiL() {
        if (this.bFd != null) {
            return this.bFd.axo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajb() {
        es(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.cvO != null && this.cvO.threadData != null) {
            if (!aiM()) {
                o.lb(this.cvO.threadData.getId());
                o.a(this.mTitle, this.cvO.Sz().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                o.a(this.cyG, this.cvO.threadData.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                o.a(this.cvM.getGodReplyContent(), this.cvO.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cvO.threadData, null, o.vb(), 18003, true, false, false).addLocateParam(this.cvO.ajq());
            addLocateParam.setForumId(String.valueOf(this.cvO.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cvO.threadData.vr());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.lb(this.cvO.Sz().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiM() {
        return this.cvO.cBM && !this.cvO.aMC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean G(bd bdVar) {
        SpannableStringBuilder g = bdVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        return true;
    }

    private void H(bd bdVar) {
        if (bdVar != null && go(2) == 1) {
            SpannableString wA = bdVar.wA();
            if (wA != null && !ao.isEmpty(wA.toString())) {
                this.cyG.setVisibility(0);
                this.cyG.setOnTouchListener(new com.baidu.tieba.view.k(wA));
                this.cyG.setText(wA);
                o.a(this.cyG, bdVar.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                return;
            }
            this.cyG.setVisibility(8);
            return;
        }
        this.cyG.setVisibility(8);
    }

    public void eu(boolean z) {
        if (this.cvN != null) {
            this.cvN.setVisibility(z ? 0 : 8);
        }
    }

    public void ev(boolean z) {
        this.cyI = z;
    }

    public void hd(int i) {
        if (this.cvO != null && this.cvO.threadData != null) {
            this.mStType = o.vb();
            if (i == 1) {
                this.bFe.setVisibility(8);
                this.bFT.setStType(this.mStType);
                this.bFT.setData(this.cvO.threadData);
                this.bFd.showForumNameView(false);
                return;
            }
            this.bFe.setData(this.cvO.threadData);
            this.bFe.setStType(this.mStType);
            this.bFT.setVisibility(8);
            this.bFd.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}
