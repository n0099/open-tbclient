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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class p extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private boolean asR;
    private final View.OnClickListener axO;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    protected LinearLayout bIN;
    private NEGFeedBackView bIa;
    private HeadPendantClickableView bIz;
    private ThreadGodReplyLayout cwv;
    private View cww;
    private com.baidu.tieba.card.data.k cwx;
    private View.OnClickListener cwy;
    public PlayVoiceBntNew czb;
    private View czc;
    private TextView czd;
    private ConstrainImageGroup cze;
    private boolean czf;
    private RelativeLayout czg;
    private final View.OnClickListener czh;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIa = null;
        this.mSkinType = 3;
        this.asR = true;
        this.czf = true;
        this.cwy = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cwx != null) {
                    p.this.cwx.cBO = 1;
                }
                if (p.this.aiz() != null) {
                    p.this.aiz().a(view, p.this.cwx);
                }
                p.this.es(view == p.this.cwv);
            }
        };
        this.czh = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.card.data.k> aiz = p.this.aiz();
                if (aiz != null) {
                    view.setTag("2");
                    aiz.a(view, p.this.cwx);
                }
            }
        };
        this.axO = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cwx == null) {
                    if (p.this.aiz() != null) {
                        p.this.aiz().a(view, p.this.cwx);
                        return;
                    }
                    return;
                }
                if (view == p.this.bHN.getUserName()) {
                    p.this.cwx.cBO = 3;
                } else if (view == p.this.bHN.getHeaderImg()) {
                    p.this.cwx.cBO = 4;
                } else if (view == p.this.cze) {
                    p.this.cwx.cBO = 2;
                    return;
                } else {
                    p.this.cwx.cBO = 1;
                }
                if (p.this.aiz() != null) {
                    p.this.aiz().a(view, p.this.cwx);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bIz = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.czb = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.czb.setAfterClickListener(this.czh);
        this.czd = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.czd.setVisibility(8);
        this.cze = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cww = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.cze.setChildClickListener(this.cwy);
        this.cze.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.h(1.0d);
        this.cze.setImageProcessor(eVar);
        this.czc = view.findViewById(d.g.divider_line_above_praise);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bIa = new NEGFeedBackView(this.mPageContext);
        this.czg = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.bIa.a(this.czg, com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds120), 0);
        if (this.bHO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bHO.setLayoutParams(layoutParams);
        }
        this.bHO.setOnClickListener(this.cwy);
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
                if (p.this.aiz() != null) {
                    p.this.aiz().a(view2, p.this.cwx);
                }
                if (p.this.cwx != null && p.this.cwx.threadData != null) {
                    o.kW(p.this.cwx.threadData.getId());
                    if (!p.this.aiD()) {
                        o.a(p.this.mTitle, p.this.cwx.Td().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                        o.a(p.this.czd, p.this.cwx.threadData.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
                        o.a(p.this.cwv.getGodReplyContent(), p.this.cwx.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
                    }
                }
            }
        });
        this.bIN = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cwv = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cwv.setOnClickListener(this.cwy);
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.bIC.ayr.setOnClickListener(this.cwy);
        this.bIC.setFrom(1);
        this.bIC.setShareReportFrom(3);
        this.bIC.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aiz() != null) {
                    p.this.aiz().a(view2, p.this.cwx);
                }
                if (p.this.cwx != null && p.this.cwx.threadData != null && view2 != p.this.bIC.ayq) {
                    o.kW(p.this.cwx.threadData.getId());
                    if (!p.this.aiD()) {
                        o.a(p.this.mTitle, p.this.cwx.Td().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                        o.a(p.this.czd, p.this.cwx.threadData.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
                        o.a(p.this.cwv.getGodReplyContent(), p.this.cwx.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cze != null) {
            this.cze.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cze != null) {
            this.cze.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            am.j(this.czc, d.C0140d.transparent);
            this.cze.onChangeSkinType();
            this.bHO.onChangeSkinType();
            this.cwv.onChangeSkinType();
            this.bHN.onChangeSkinType();
            if (this.bIa != null) {
                this.bIa.onChangeSkinType();
            }
            am.j(this.cww, d.C0140d.cp_bg_line_e);
            if (this.bIC != null) {
                this.bIC.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        boolean z;
        if (kVar == null || kVar.Td() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cwx = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwy);
        }
        if (this.bIa != null) {
            if (this.cwx.agt != null && this.cwx.agt.size() > 0) {
                ah ahVar = new ah();
                ahVar.dh(this.cwx.Td().getTid());
                ahVar.setFid(this.cwx.Td().getFid());
                ahVar.a(this.cwx.agt);
                this.bIa.setData(ahVar);
                this.bIa.setFirstRowSingleColumn(true);
                if (kVar.threadData.vk() != null && !StringUtils.isNull(kVar.threadData.vk().getUserId())) {
                    if (kVar.threadData.vk().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bIa.setVisibility(8);
                    } else if (this.bIa != null) {
                        this.bIa.setVisibility(this.czf ? 0 : 8);
                    }
                }
            } else {
                this.bIa.setVisibility(8);
            }
        }
        this.bHN.setData(kVar.threadData);
        this.cwv.setFromCDN(this.asR);
        this.cwv.setData(kVar.threadData.wx());
        if (!aiD() && o.kX(this.cwx.threadData.getId())) {
            o.a(this.mTitle, this.cwx.Td().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            o.a(this.czd, this.cwx.threadData.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
            o.a(this.cwv.getGodReplyContent(), this.cwx.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        }
        this.bHN.setUserAfterClickListener(this.axO);
        final bb Td = kVar.Td();
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (Td.vk() == null || Td.vk().getPendantData() == null || StringUtils.isNull(Td.vk().getPendantData().tU())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(Td);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(Td);
            }
        }
        K(Td);
        L(Td);
        ArrayList<VoiceData.VoiceModel> vz = kVar.threadData.vz();
        if (com.baidu.tbadk.core.util.w.z(vz)) {
            this.czb.setVisibility(8);
            z = false;
        } else {
            this.czb.setVisibility(0);
            VoiceData.VoiceModel voiceModel = vz.get(0);
            this.czb.setVoiceModel(voiceModel);
            this.czb.setTag(voiceModel);
            this.czb.aPt();
            if (voiceModel != null) {
                this.czb.oH(voiceModel.voice_status.intValue());
            }
            this.czb.bxp();
            z = true;
        }
        if (this.cwx.cCm && z) {
            this.cze.setVisibility(8);
        } else {
            ArrayList<MediaData> vv = Td.vv();
            if (com.baidu.tbadk.core.i.te().tk() && com.baidu.tbadk.core.util.w.y(vv) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < vv.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.d(vv, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.w.y(linkedList) > 0) {
                    this.cze.setVisibility(0);
                    this.cze.setFromCDN(this.asR);
                    this.cze.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view, int i2, boolean z2) {
                            ad<com.baidu.tieba.card.data.k> aiz = p.this.aiz();
                            if (aiz != null) {
                                view.setTag("1");
                                if (p.this.axO != null) {
                                    p.this.axO.onClick(p.this.cze);
                                }
                                aiz.a(view, p.this.cwx);
                            }
                            if (z2) {
                                p.this.aiS();
                            } else {
                                p.this.a(view, linkedList, i2, Td);
                            }
                        }
                    });
                    this.cze.setImageMediaList(linkedList);
                } else {
                    this.cze.setVisibility(8);
                }
            } else {
                this.cze.setVisibility(8);
            }
        }
        aiQ();
        aiR();
        setPageUniqueId(getTag());
        hn(gu(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aiQ() {
        if (this.czc != null && this.cze != null && this.cwv != null) {
            if (this.cze.getVisibility() == 8 && this.cwv.getVisibility() == 8) {
                this.czc.setVisibility(0);
            } else {
                this.czc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
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
                    imageUrlData.urlType = this.asR ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.vq(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.asR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void aiR() {
        if (!this.cwx.aNy) {
            this.czb.setClickable(false);
        } else {
            this.czb.setClickable(true);
        }
        int childCount = this.cze.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cze.getChildAt(i);
            if (childAt != null) {
                if (!this.cwx.aNy) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.asR = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cze != null) {
            this.cze.setPageUniqueId(bdUniqueId);
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

    public View aiB() {
        return this.cwv;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bHN != null) {
            return this.bHN.axK;
        }
        return null;
    }

    public View aiC() {
        if (this.bHN != null) {
            return this.bHN.axL;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiS() {
        es(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.cwx != null && this.cwx.threadData != null) {
            if (!aiD()) {
                o.kW(this.cwx.threadData.getId());
                o.a(this.mTitle, this.cwx.Td().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                o.a(this.czd, this.cwx.threadData.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
                o.a(this.cwv.getGodReplyContent(), this.cwx.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cwx.threadData, null, o.uY(), 18003, true, false, false).addLocateParam(this.cwx.ajj());
            addLocateParam.setForumId(String.valueOf(this.cwx.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cwx.threadData.vq());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.kW(this.cwx.Td().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiD() {
        return this.cwx.cCm && !this.cwx.aNy;
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
            o.a(this.mTitle, bbVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
        return true;
    }

    private void L(bb bbVar) {
        if (bbVar != null && gu(2) == 1) {
            SpannableString wz = bbVar.wz();
            if (wz != null && !ap.isEmpty(wz.toString())) {
                this.czd.setVisibility(0);
                this.czd.setOnTouchListener(new com.baidu.tieba.view.k(wz));
                this.czd.setText(wz);
                o.a(this.czd, bbVar.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
                return;
            }
            this.czd.setVisibility(8);
            return;
        }
        this.czd.setVisibility(8);
    }

    public void eu(boolean z) {
        if (this.cww != null) {
            this.cww.setVisibility(z ? 0 : 8);
        }
    }

    public void ev(boolean z) {
        this.czf = z;
    }

    public void hn(int i) {
        if (this.cwx != null && this.cwx.threadData != null) {
            this.mStType = o.uY();
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setStType(this.mStType);
                this.bIC.setData(this.cwx.threadData);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.cwx.threadData);
            this.bHO.setStType(this.mStType);
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}
