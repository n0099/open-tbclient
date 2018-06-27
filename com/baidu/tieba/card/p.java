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
import com.baidu.tbadk.core.data.bc;
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
    private boolean atn;
    private final View.OnClickListener ayi;
    private String bGM;
    public ThreadUserInfoLayout bGY;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    private HeadPendantClickableView bHK;
    public ThreadSourceShareAndPraiseLayout bHN;
    protected LinearLayout bHY;
    private NEGFeedBackView bHl;
    private ThreadGodReplyLayout ctS;
    private View ctT;
    private com.baidu.tieba.card.data.k ctU;
    private View.OnClickListener ctV;
    private TextView cwA;
    private ConstrainImageGroup cwB;
    private boolean cwC;
    private RelativeLayout cwD;
    private final View.OnClickListener cwE;
    public PlayVoiceBntNew cwy;
    private View cwz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bHl = null;
        this.mSkinType = 3;
        this.atn = true;
        this.cwC = true;
        this.ctV = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.ctU != null) {
                    p.this.ctU.czj = 1;
                }
                if (p.this.aia() != null) {
                    p.this.aia().a(view, p.this.ctU);
                }
                p.this.er(view == p.this.ctS);
            }
        };
        this.cwE = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.card.data.k> aia = p.this.aia();
                if (aia != null) {
                    view.setTag("2");
                    aia.a(view, p.this.ctU);
                }
            }
        };
        this.ayi = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.ctU == null) {
                    if (p.this.aia() != null) {
                        p.this.aia().a(view, p.this.ctU);
                        return;
                    }
                    return;
                }
                if (view == p.this.bGY.getUserName()) {
                    p.this.ctU.czj = 3;
                } else if (view == p.this.bGY.getHeaderImg()) {
                    p.this.ctU.czj = 4;
                } else if (view == p.this.cwB) {
                    p.this.ctU.czj = 2;
                    return;
                } else {
                    p.this.ctU.czj = 1;
                }
                if (p.this.aia() != null) {
                    p.this.aia().a(view, p.this.ctU);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bHK = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bHK.getHeadView() != null) {
            this.bHK.getHeadView().setIsRound(true);
            this.bHK.getHeadView().setDrawBorder(false);
            this.bHK.getHeadView().setDefaultResource(17170445);
            this.bHK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bHK.getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.bHK.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bHK.setHasPendantStyle();
        if (this.bHK.getPendantView() != null) {
            this.bHK.getPendantView().setIsRound(true);
            this.bHK.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cwy = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cwy.setAfterClickListener(this.cwE);
        this.cwA = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cwA.setVisibility(8);
        this.cwB = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.ctT = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.cwB.setChildClickListener(this.ctV);
        this.cwB.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.cwB.setImageProcessor(eVar);
        this.cwz = view.findViewById(d.g.divider_line_above_praise);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bGY = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bHl = new NEGFeedBackView(this.mPageContext);
        this.cwD = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.bHl.a(this.cwD, com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds120), 0);
        if (this.bGZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGZ.setLayoutParams(layoutParams);
        }
        this.bGZ.setOnClickListener(this.ctV);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setShareVisible(true);
        this.bGZ.setFrom(1);
        this.bGZ.setShareReportFrom(3);
        this.bGZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aia() != null) {
                    p.this.aia().a(view2, p.this.ctU);
                }
                if (p.this.ctU != null && p.this.ctU.threadData != null) {
                    o.kY(p.this.ctU.threadData.getId());
                    if (!p.this.aie()) {
                        o.a(p.this.mTitle, p.this.ctU.SV().getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
                        o.a(p.this.cwA, p.this.ctU.threadData.getId(), d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
                        o.a(p.this.ctS.getGodReplyContent(), p.this.ctU.threadData.getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
                    }
                }
            }
        });
        this.bHY = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.ctS = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.ctS.setOnClickListener(this.ctV);
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.bHN.ayE.setOnClickListener(this.ctV);
        this.bHN.setFrom(1);
        this.bHN.setShareReportFrom(3);
        this.bHN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aia() != null) {
                    p.this.aia().a(view2, p.this.ctU);
                }
                if (p.this.ctU != null && p.this.ctU.threadData != null && view2 != p.this.bHN.ayD) {
                    o.kY(p.this.ctU.threadData.getId());
                    if (!p.this.aie()) {
                        o.a(p.this.mTitle, p.this.ctU.SV().getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
                        o.a(p.this.cwA, p.this.ctU.threadData.getId(), d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
                        o.a(p.this.ctS.getGodReplyContent(), p.this.ctU.threadData.getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cwB != null) {
            this.cwB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cwB != null) {
            this.cwB.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            am.j(this.cwz, d.C0142d.transparent);
            this.cwB.onChangeSkinType();
            this.bGZ.onChangeSkinType();
            this.ctS.onChangeSkinType();
            this.bGY.onChangeSkinType();
            if (this.bHl != null) {
                this.bHl.onChangeSkinType();
            }
            am.j(this.ctT, d.C0142d.cp_bg_line_e);
            if (this.bHN != null) {
                this.bHN.onChangeSkinType();
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
        if (kVar == null || kVar.SV() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ctU = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ctV);
        }
        if (this.bHl != null) {
            if (this.ctU.agZ != null && this.ctU.agZ.size() > 0) {
                ai aiVar = new ai();
                aiVar.dk(this.ctU.SV().getTid());
                aiVar.setFid(this.ctU.SV().getFid());
                aiVar.a(this.ctU.agZ);
                this.bHl.setData(aiVar);
                this.bHl.setFirstRowSingleColumn(true);
                if (kVar.threadData.vw() != null && !StringUtils.isNull(kVar.threadData.vw().getUserId())) {
                    if (kVar.threadData.vw().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bHl.setVisibility(8);
                    } else if (this.bHl != null) {
                        this.bHl.setVisibility(this.cwC ? 0 : 8);
                    }
                }
            } else {
                this.bHl.setVisibility(8);
            }
        }
        this.bGY.setData(kVar.threadData);
        this.ctS.setFromCDN(this.atn);
        this.ctS.setData(kVar.threadData.wI());
        if (!aie() && o.kZ(this.ctU.threadData.getId())) {
            o.a(this.mTitle, this.ctU.SV().getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            o.a(this.cwA, this.ctU.threadData.getId(), d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
            o.a(this.ctS.getGodReplyContent(), this.ctU.threadData.getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
        }
        this.bGY.setUserAfterClickListener(this.ayi);
        final bc SV = kVar.SV();
        if (this.bGY.getHeaderImg() != null) {
            if (this.bGY.getIsSimpleThread()) {
                this.bGY.getHeaderImg().setVisibility(8);
                this.bHK.setVisibility(8);
            } else if (SV.vw() == null || SV.vw().getPendantData() == null || StringUtils.isNull(SV.vw().getPendantData().uh())) {
                this.bHK.setVisibility(8);
                this.bGY.getHeaderImg().setVisibility(0);
                this.bGY.getHeaderImg().setData(SV);
            } else {
                this.bGY.getHeaderImg().setVisibility(4);
                this.bHK.setVisibility(0);
                this.bHK.setData(SV);
            }
        }
        I(SV);
        J(SV);
        ArrayList<VoiceData.VoiceModel> vK = kVar.threadData.vK();
        if (com.baidu.tbadk.core.util.w.A(vK)) {
            this.cwy.setVisibility(8);
            z = false;
        } else {
            this.cwy.setVisibility(0);
            VoiceData.VoiceModel voiceModel = vK.get(0);
            this.cwy.setVoiceModel(voiceModel);
            this.cwy.setTag(voiceModel);
            this.cwy.aOt();
            if (voiceModel != null) {
                this.cwy.ot(voiceModel.voice_status.intValue());
            }
            this.cwy.byM();
            z = true;
        }
        if (this.ctU.czG && z) {
            this.cwB.setVisibility(8);
        } else {
            ArrayList<MediaData> vG = SV.vG();
            if (com.baidu.tbadk.core.i.tt().tz() && com.baidu.tbadk.core.util.w.z(vG) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < vG.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.d(vG, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.w.z(linkedList) > 0) {
                    this.cwB.setVisibility(0);
                    this.cwB.setFromCDN(this.atn);
                    this.cwB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view, int i2, boolean z2) {
                            ad<com.baidu.tieba.card.data.k> aia = p.this.aia();
                            if (aia != null) {
                                view.setTag("1");
                                if (p.this.ayi != null) {
                                    p.this.ayi.onClick(p.this.cwB);
                                }
                                aia.a(view, p.this.ctU);
                            }
                            if (z2) {
                                p.this.ait();
                            } else {
                                p.this.a(view, linkedList, i2, SV);
                            }
                        }
                    });
                    this.cwB.setImageMediaList(linkedList);
                } else {
                    this.cwB.setVisibility(8);
                }
            } else {
                this.cwB.setVisibility(8);
            }
        }
        air();
        ais();
        setPageUniqueId(getTag());
        hh(gp(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void air() {
        if (this.cwz != null && this.cwB != null && this.ctS != null) {
            if (this.cwB.getVisibility() == 8 && this.ctS.getVisibility() == 8) {
                this.cwz.setVisibility(0);
            } else {
                this.cwz.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bc bcVar) {
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
                    imageUrlData.urlType = this.atn ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bcVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bcVar.vB(), String.valueOf(bcVar.getFid()), bcVar.getTid(), this.atn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void ais() {
        if (!this.ctU.aNy) {
            this.cwy.setClickable(false);
        } else {
            this.cwy.setClickable(true);
        }
        int childCount = this.cwB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cwB.getChildAt(i);
            if (childAt != null) {
                if (!this.ctU.aNy) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.atn = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cwB != null) {
            this.cwB.setPageUniqueId(bdUniqueId);
        }
        if (this.bHl != null) {
            this.bHl.setUniqueId(bdUniqueId);
        }
        if (this.bGY != null) {
            this.bGY.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bHl != null) {
            this.bHl.setEventCallback(aVar);
        }
    }

    public View aic() {
        return this.ctS;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bGY != null) {
            return this.bGY.aye;
        }
        return null;
    }

    public View aid() {
        if (this.bGY != null) {
            return this.bGY.ayf;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ait() {
        er(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er(boolean z) {
        if (this.ctU != null && this.ctU.threadData != null) {
            if (!aie()) {
                o.kY(this.ctU.threadData.getId());
                o.a(this.mTitle, this.ctU.SV().getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
                o.a(this.cwA, this.ctU.threadData.getId(), d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
                o.a(this.ctS.getGodReplyContent(), this.ctU.threadData.getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ctU.threadData, null, o.vk(), 18003, true, false, false).addLocateParam(this.ctU.aiK());
            addLocateParam.setForumId(String.valueOf(this.ctU.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.ctU.threadData.vB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.kY(this.ctU.SV().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aie() {
        return this.ctU.czG && !this.ctU.aNy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean I(bc bcVar) {
        SpannableStringBuilder g = bcVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bcVar.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        }
        return true;
    }

    private void J(bc bcVar) {
        if (bcVar != null && gp(2) == 1) {
            SpannableString wK = bcVar.wK();
            if (wK != null && !ap.isEmpty(wK.toString())) {
                this.cwA.setVisibility(0);
                this.cwA.setOnTouchListener(new com.baidu.tieba.view.k(wK));
                this.cwA.setText(wK);
                o.a(this.cwA, bcVar.getId(), d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
                return;
            }
            this.cwA.setVisibility(8);
            return;
        }
        this.cwA.setVisibility(8);
    }

    public void et(boolean z) {
        if (this.ctT != null) {
            this.ctT.setVisibility(z ? 0 : 8);
        }
    }

    public void eu(boolean z) {
        this.cwC = z;
    }

    public void hh(int i) {
        if (this.ctU != null && this.ctU.threadData != null) {
            this.mStType = o.vk();
            if (i == 1) {
                this.bGZ.setVisibility(8);
                this.bHN.setStType(this.mStType);
                this.bHN.setData(this.ctU.threadData);
                this.bGY.showForumNameView(false);
                return;
            }
            this.bGZ.setData(this.ctU.threadData);
            this.bGZ.setStType(this.mStType);
            this.bHN.setVisibility(8);
            this.bGY.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}
