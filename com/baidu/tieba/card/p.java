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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class p extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private boolean asS;
    private final View.OnClickListener axL;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    protected LinearLayout bIN;
    private NEGFeedBackView bIa;
    private HeadPendantClickableView bIz;
    private ThreadGodReplyLayout cws;
    private View cwt;
    private com.baidu.tieba.card.data.k cwu;
    private View.OnClickListener cwv;
    public PlayVoiceBntNew cyY;
    private View cyZ;
    private TextView cza;
    private ConstrainImageGroup czb;
    private boolean czc;
    private RelativeLayout czd;
    private final View.OnClickListener cze;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIa = null;
        this.mSkinType = 3;
        this.asS = true;
        this.czc = true;
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cwu != null) {
                    p.this.cwu.cBL = 1;
                }
                if (p.this.aiC() != null) {
                    p.this.aiC().a(view, p.this.cwu);
                }
                p.this.es(view == p.this.cws);
            }
        };
        this.cze = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.card.data.k> aiC = p.this.aiC();
                if (aiC != null) {
                    view.setTag("2");
                    aiC.a(view, p.this.cwu);
                }
            }
        };
        this.axL = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cwu == null) {
                    if (p.this.aiC() != null) {
                        p.this.aiC().a(view, p.this.cwu);
                        return;
                    }
                    return;
                }
                if (view == p.this.bHN.getUserName()) {
                    p.this.cwu.cBL = 3;
                } else if (view == p.this.bHN.getHeaderImg()) {
                    p.this.cwu.cBL = 4;
                } else if (view == p.this.czb) {
                    p.this.cwu.cBL = 2;
                    return;
                } else {
                    p.this.cwu.cBL = 1;
                }
                if (p.this.aiC() != null) {
                    p.this.aiC().a(view, p.this.cwu);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bIz = (HeadPendantClickableView) view.findViewById(f.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), f.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(f.g.card_home_page_normal_thread_title);
        this.cyY = (PlayVoiceBntNew) view.findViewById(f.g.card_home_page_normal_thread_abstract_voice);
        this.cyY.setAfterClickListener(this.cze);
        this.cza = (TextView) view.findViewById(f.g.card_home_page_normal_thread_abstract);
        this.cza.setVisibility(8);
        this.czb = (ConstrainImageGroup) view.findViewById(f.g.card_home_page_normal_thread_img_layout);
        this.cwt = view.findViewById(f.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds20);
        this.czb.setChildClickListener(this.cwv);
        this.czb.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.czb.setImageProcessor(eVar);
        this.cyZ = view.findViewById(f.g.divider_line_above_praise);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.card_home_page_normal_thread_info_layout);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(f.g.card_home_page_normal_thread_user_info_layout);
        this.bIa = new NEGFeedBackView(this.mPageContext);
        this.czd = (RelativeLayout) view.findViewById(f.g.card_home_page_normal_thread_root);
        this.bIa.a(this.czd, com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds120), 0);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this.cwv);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.setFrom(1);
        this.bHO.setShareReportFrom(3);
        this.bHO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aiC() != null) {
                    p.this.aiC().a(view2, p.this.cwu);
                }
                if (p.this.cwu != null && p.this.cwu.threadData != null) {
                    o.kY(p.this.cwu.threadData.getId());
                    if (!p.this.aiG()) {
                        o.a(p.this.mTitle, p.this.cwu.Tg().getId(), f.d.cp_cont_b, f.d.cp_cont_d);
                        o.a(p.this.cza, p.this.cwu.threadData.getId(), f.d.cp_cont_j, f.d.cp_cont_d);
                        o.a(p.this.cws.getGodReplyContent(), p.this.cwu.threadData.getId(), f.d.cp_cont_f, f.d.cp_cont_d);
                    }
                }
            }
        });
        this.bIN = (LinearLayout) view.findViewById(f.g.card_home_page_normal_thread_content_layout);
        this.cws = (ThreadGodReplyLayout) view.findViewById(f.g.card_home_page_god_reply_layout);
        this.cws.setOnClickListener(this.cwv);
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.card_home_page_source_read_share_layout);
        this.bIC.ayo.setOnClickListener(this.cwv);
        this.bIC.setFrom(1);
        this.bIC.setShareReportFrom(3);
        this.bIC.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aiC() != null) {
                    p.this.aiC().a(view2, p.this.cwu);
                }
                if (p.this.cwu != null && p.this.cwu.threadData != null && view2 != p.this.bIC.ayn) {
                    o.kY(p.this.cwu.threadData.getId());
                    if (!p.this.aiG()) {
                        o.a(p.this.mTitle, p.this.cwu.Tg().getId(), f.d.cp_cont_b, f.d.cp_cont_d);
                        o.a(p.this.cza, p.this.cwu.threadData.getId(), f.d.cp_cont_j, f.d.cp_cont_d);
                        o.a(p.this.cws.getGodReplyContent(), p.this.cwu.threadData.getId(), f.d.cp_cont_f, f.d.cp_cont_d);
                    }
                }
            }
        });
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
            am.j(this.cyZ, f.d.transparent);
            this.czb.onChangeSkinType();
            this.bHO.onChangeSkinType();
            this.cws.onChangeSkinType();
            this.bHN.onChangeSkinType();
            if (this.bIa != null) {
                this.bIa.onChangeSkinType();
            }
            am.j(this.cwt, f.d.cp_bg_line_e);
            if (this.bIC != null) {
                this.bIC.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        boolean z;
        if (kVar == null || kVar.Tg() == null) {
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
        if (this.bIa != null) {
            if (this.cwu.agt != null && this.cwu.agt.size() > 0) {
                ah ahVar = new ah();
                ahVar.setTid(this.cwu.Tg().getTid());
                ahVar.setFid(this.cwu.Tg().getFid());
                ahVar.a(this.cwu.agt);
                this.bIa.setData(ahVar);
                this.bIa.setFirstRowSingleColumn(true);
                if (kVar.threadData.vj() != null && !StringUtils.isNull(kVar.threadData.vj().getUserId())) {
                    if (kVar.threadData.vj().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bIa.setVisibility(8);
                    } else if (this.bIa != null) {
                        this.bIa.setVisibility(this.czc ? 0 : 8);
                    }
                }
            } else {
                this.bIa.setVisibility(8);
            }
        }
        this.bHN.setData(kVar.threadData);
        this.cws.setFromCDN(this.asS);
        this.cws.setData(kVar.threadData.ww());
        if (!aiG() && o.kZ(this.cwu.threadData.getId())) {
            o.a(this.mTitle, this.cwu.Tg().getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            o.a(this.cza, this.cwu.threadData.getId(), f.d.cp_cont_j, f.d.cp_cont_d);
            o.a(this.cws.getGodReplyContent(), this.cwu.threadData.getId(), f.d.cp_cont_f, f.d.cp_cont_d);
        }
        this.bHN.setUserAfterClickListener(this.axL);
        final bb Tg = kVar.Tg();
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (Tg.vj() == null || Tg.vj().getPendantData() == null || StringUtils.isNull(Tg.vj().getPendantData().tT())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(Tg);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(Tg);
            }
        }
        K(Tg);
        L(Tg);
        ArrayList<VoiceData.VoiceModel> vy = kVar.threadData.vy();
        if (com.baidu.tbadk.core.util.w.z(vy)) {
            this.cyY.setVisibility(8);
            z = false;
        } else {
            this.cyY.setVisibility(0);
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
        } else {
            ArrayList<MediaData> vu = Tg.vu();
            if (com.baidu.tbadk.core.i.td().tj() && com.baidu.tbadk.core.util.w.y(vu) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < vu.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.d(vu, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.w.y(linkedList) > 0) {
                    this.czb.setVisibility(0);
                    this.czb.setFromCDN(this.asS);
                    this.czb.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<com.baidu.tieba.card.data.k> aiC = p.this.aiC();
                            if (aiC != null) {
                                view.setTag("1");
                                if (p.this.axL != null) {
                                    p.this.axL.onClick(p.this.czb);
                                }
                                aiC.a(view, p.this.cwu);
                            }
                            if (z2) {
                                p.this.aiV();
                            } else {
                                p.this.a(view, linkedList, i2, Tg);
                            }
                        }
                    });
                    this.czb.setImageMediaList(linkedList);
                } else {
                    this.czb.setVisibility(8);
                }
            } else {
                this.czb.setVisibility(8);
            }
        }
        aiT();
        aiU();
        setPageUniqueId(getTag());
        hm(gt(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aiT() {
        if (this.cyZ != null && this.czb != null && this.cws != null) {
            if (this.czb.getVisibility() == 8 && this.cws.getVisibility() == 8) {
                this.cyZ.setVisibility(0);
            } else {
                this.cyZ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), f.j.plugin_image_viewer_install_error_tips);
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
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
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

    public void setFromCDN(boolean z) {
        this.asS = z;
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
        if (this.bIa != null) {
            this.bIa.setUniqueId(bdUniqueId);
        }
        if (this.bHN != null) {
            this.bHN.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bIa != null) {
            this.bIa.setEventCallback(aVar);
        }
    }

    public View aiE() {
        return this.cws;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bHN != null) {
            return this.bHN.axH;
        }
        return null;
    }

    public View aiF() {
        if (this.bHN != null) {
            return this.bHN.axI;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiV() {
        es(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.cwu != null && this.cwu.threadData != null) {
            if (!aiG()) {
                o.kY(this.cwu.threadData.getId());
                o.a(this.mTitle, this.cwu.Tg().getId(), f.d.cp_cont_b, f.d.cp_cont_d);
                o.a(this.cza, this.cwu.threadData.getId(), f.d.cp_cont_j, f.d.cp_cont_d);
                o.a(this.cws.getGodReplyContent(), this.cwu.threadData.getId(), f.d.cp_cont_f, f.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cwu.threadData, null, o.uX(), 18003, true, false, false).addLocateParam(this.cwu.ajm());
            addLocateParam.setForumId(String.valueOf(this.cwu.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cwu.threadData.vp());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.kY(this.cwu.Tg().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiG() {
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

    private void L(bb bbVar) {
        if (bbVar != null && gt(2) == 1) {
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

    public void eu(boolean z) {
        if (this.cwt != null) {
            this.cwt.setVisibility(z ? 0 : 8);
        }
    }

    public void ev(boolean z) {
        this.czc = z;
    }

    public void hm(int i) {
        if (this.cwu != null && this.cwu.threadData != null) {
            this.mStType = o.uX();
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setStType(this.mStType);
                this.bIC.setData(this.cwu.threadData);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.cwu.threadData);
            this.bHO.setStType(this.mStType);
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
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
