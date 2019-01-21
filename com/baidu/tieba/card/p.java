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
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class p extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private boolean aEU;
    private final View.OnClickListener aLf;
    private ThreadGodReplyLayout cVS;
    private View cVT;
    private com.baidu.tieba.card.data.k cVU;
    private View.OnClickListener cVV;
    private View cYA;
    private TextView cYB;
    private ConstrainImageGroup cYC;
    private boolean cYD;
    private RelativeLayout cYE;
    private final View.OnClickListener cYF;
    public PlayVoiceBntNew cYz;
    private NEGFeedBackView cbJ;
    private String cbl;
    public ThreadUserInfoLayout cbx;
    public ThreadCommentAndPraiseInfoLayout cby;
    private HeadPendantClickableView cci;
    public ThreadSourceShareAndPraiseLayout ccl;
    protected LinearLayout ccx;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbJ = null;
        this.mSkinType = 3;
        this.aEU = true;
        this.cYD = true;
        this.cVV = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cVU != null) {
                    p.this.cVU.aFT = 1;
                }
                if (p.this.aqp() != null) {
                    p.this.aqp().a(view, p.this.cVU);
                }
                p.this.fs(view == p.this.cVS);
            }
        };
        this.cYF = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.card.data.k> aqp = p.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, p.this.cVU);
                }
            }
        };
        this.aLf = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cVU == null) {
                    if (p.this.aqp() != null) {
                        p.this.aqp().a(view, p.this.cVU);
                        return;
                    }
                    return;
                }
                if (view == p.this.cbx.getUserName()) {
                    p.this.cVU.aFT = 3;
                } else if (view == p.this.cbx.getHeaderImg()) {
                    p.this.cVU.aFT = 4;
                } else if (view == p.this.cYC) {
                    p.this.cVU.aFT = 2;
                    return;
                } else {
                    p.this.cVU.aFT = 1;
                }
                if (p.this.aqp() != null) {
                    p.this.aqp().a(view, p.this.cVU);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cci = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cci.getHeadView() != null) {
            this.cci.getHeadView().setIsRound(true);
            this.cci.getHeadView().setDrawBorder(false);
            this.cci.getHeadView().setDefaultResource(17170445);
            this.cci.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cci.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cci.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cci.setHasPendantStyle();
        if (this.cci.getPendantView() != null) {
            this.cci.getPendantView().setIsRound(true);
            this.cci.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cYz = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cYz.setAfterClickListener(this.cYF);
        this.cYB = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cYB.setVisibility(8);
        this.cYC = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cVT = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20);
        this.cYC.setChildClickListener(this.cVV);
        this.cYC.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cYC.setImageProcessor(eVar);
        this.cYA = view.findViewById(e.g.divider_line_above_praise);
        this.cby = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.cbx = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.cbJ = new NEGFeedBackView(this.mPageContext);
        this.cYE = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.cbJ.a(this.cYE, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120), 0);
        if (this.cby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cby.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cby.setLayoutParams(layoutParams);
        }
        this.cby.setOnClickListener(this.cVV);
        this.cby.setReplyTimeVisible(false);
        this.cby.setShowPraiseNum(true);
        this.cby.setNeedAddPraiseIcon(true);
        this.cby.setNeedAddReplyIcon(true);
        this.cby.setShareVisible(true);
        this.cby.setFrom(1);
        this.cby.setDisPraiseFrom(1);
        this.cby.setShareReportFrom(3);
        this.cby.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aqp() != null) {
                    p.this.aqp().a(view2, p.this.cVU);
                }
                if (p.this.cVU != null && p.this.cVU.threadData != null) {
                    o.mW(p.this.cVU.threadData.getId());
                    if (!p.this.aqt()) {
                        o.a(p.this.mTitle, p.this.cVU.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cYB, p.this.cVU.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cVS.getGodReplyContent(), p.this.cVU.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
        this.ccx = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.cVS = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cVS.setOnClickListener(this.cVV);
        this.ccl = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        this.ccl.aKN.setOnClickListener(this.cVV);
        this.ccl.setFrom(1);
        this.ccl.setShareReportFrom(3);
        this.ccl.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aqp() != null) {
                    p.this.aqp().a(view2, p.this.cVU);
                }
                if (p.this.cVU != null && p.this.cVU.threadData != null && view2 != p.this.ccl.aKM) {
                    o.mW(p.this.cVU.threadData.getId());
                    if (!p.this.aqt()) {
                        o.a(p.this.mTitle, p.this.cVU.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cYB, p.this.cVU.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cVS.getGodReplyContent(), p.this.cVU.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYC != null) {
            this.cYC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYC != null) {
            this.cYC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cYA, e.d.transparent);
            this.cYC.onChangeSkinType();
            this.cby.onChangeSkinType();
            this.cVS.onChangeSkinType();
            this.cbx.onChangeSkinType();
            if (this.cbJ != null) {
                this.cbJ.onChangeSkinType();
            }
            al.j(this.cVT, e.d.cp_bg_line_e);
            if (this.ccl != null) {
                this.ccl.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        boolean z;
        if (kVar == null || kVar.aaq() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cVU = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVV);
        }
        if (this.cbJ != null) {
            if (this.cVU.asF != null && this.cVU.asF.size() > 0) {
                ah ahVar = new ah();
                ahVar.setTid(this.cVU.aaq().getTid());
                ahVar.setFid(this.cVU.aaq().getFid());
                ahVar.a(this.cVU.asF);
                this.cbJ.setData(ahVar);
                this.cbJ.setFirstRowSingleColumn(true);
                if (kVar.threadData.zT() != null && !StringUtils.isNull(kVar.threadData.zT().getUserId())) {
                    if (kVar.threadData.zT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.cbJ.setVisibility(8);
                    } else if (this.cbJ != null) {
                        this.cbJ.setVisibility(this.cYD ? 0 : 8);
                    }
                }
            } else {
                this.cbJ.setVisibility(8);
            }
        }
        this.cbx.setData(kVar.threadData);
        this.cVS.setFromCDN(this.aEU);
        this.cVS.setData(kVar.threadData.Bk());
        if (!aqt() && o.mX(this.cVU.threadData.getId())) {
            o.a(this.mTitle, this.cVU.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cYB, this.cVU.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cVS.getGodReplyContent(), this.cVU.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cbx.setUserAfterClickListener(this.aLf);
        final bb aaq = kVar.aaq();
        if (this.cbx.getHeaderImg() != null) {
            if (this.cbx.getIsSimpleThread()) {
                this.cbx.getHeaderImg().setVisibility(8);
                this.cci.setVisibility(8);
            } else if (aaq.zT() == null || aaq.zT().getPendantData() == null || StringUtils.isNull(aaq.zT().getPendantData().yF())) {
                this.cci.setVisibility(8);
                this.cbx.getHeaderImg().setVisibility(0);
                this.cbx.getHeaderImg().setData(aaq);
            } else {
                this.cbx.getHeaderImg().setVisibility(4);
                this.cci.setVisibility(0);
                this.cci.setData(aaq);
            }
        }
        L(aaq);
        M(aaq);
        ArrayList<VoiceData.VoiceModel> Ai = kVar.threadData.Ai();
        if (com.baidu.tbadk.core.util.v.I(Ai)) {
            this.cYz.setVisibility(8);
            z = false;
        } else {
            this.cYz.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Ai.get(0);
            this.cYz.setVoiceModel(voiceModel);
            this.cYz.setTag(voiceModel);
            this.cYz.aXt();
            if (voiceModel != null) {
                this.cYz.qK(voiceModel.voice_status.intValue());
            }
            this.cYz.bGc();
            z = true;
        }
        if (this.cVU.dbK && z) {
            this.cYC.setVisibility(8);
        } else {
            ArrayList<MediaData> Ae = aaq.Ae();
            if (com.baidu.tbadk.core.i.xR().xV() && com.baidu.tbadk.core.util.v.H(Ae) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < Ae.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(Ae, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.H(linkedList) > 0) {
                    this.cYC.setVisibility(0);
                    this.cYC.setFromCDN(this.aEU);
                    this.cYC.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<com.baidu.tieba.card.data.k> aqp = p.this.aqp();
                            if (aqp != null) {
                                view.setTag("1");
                                if (p.this.aLf != null) {
                                    p.this.aLf.onClick(p.this.cYC);
                                }
                                aqp.a(view, p.this.cVU);
                            }
                            if (z2) {
                                p.this.aqJ();
                            } else {
                                p.this.a(view, linkedList, i2, aaq);
                            }
                        }
                    });
                    this.cYC.setImageMediaList(linkedList);
                } else {
                    this.cYC.setVisibility(8);
                }
            } else {
                this.cYC.setVisibility(8);
            }
        }
        aqH();
        aqI();
        setPageUniqueId(getTag());
        iM(hD(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aqH() {
        if (this.cYA != null && this.cYC != null && this.cVS != null) {
            if (this.cYC.getVisibility() == 8 && this.cVS.getVisibility() == 8) {
                this.cYA.setVisibility(0);
            } else {
                this.cYA.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aEU ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bbVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zZ(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bbVar.getId();
        historyMessage.threadName = bbVar.getTitle();
        historyMessage.forumName = bbVar.zZ();
        historyMessage.postID = bbVar.Ak();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void aqI() {
        if (!this.cVU.bap) {
            this.cYz.setClickable(false);
        } else {
            this.cYz.setClickable(true);
        }
        int childCount = this.cYC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cYC.getChildAt(i);
            if (childAt != null) {
                if (!this.cVU.bap) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aEU = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cYC != null) {
            this.cYC.setPageUniqueId(bdUniqueId);
        }
        if (this.cbJ != null) {
            this.cbJ.setUniqueId(bdUniqueId);
        }
        if (this.cbx != null) {
            this.cbx.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.cbJ != null) {
            this.cbJ.setEventCallback(aVar);
        }
    }

    public View aqr() {
        return this.cVS;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbx != null) {
            return this.cbx.aKS;
        }
        return null;
    }

    public View aqs() {
        if (this.cbx != null) {
            return this.cbx.aKU;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqJ() {
        fs(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (this.cVU != null && this.cVU.threadData != null) {
            if (!aqt()) {
                o.mW(this.cVU.threadData.getId());
                o.a(this.mTitle, this.cVU.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cYB, this.cVU.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                o.a(this.cVS.getGodReplyContent(), this.cVU.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVU.threadData, null, o.zH(), 18003, true, false, false).addLocateParam(this.cVU.ara());
            addLocateParam.setForumId(String.valueOf(this.cVU.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cVU.threadData.zZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.mW(this.cVU.aaq().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqt() {
        return this.cVU.dbK && !this.cVU.bap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean L(bb bbVar) {
        SpannableStringBuilder i = bbVar.i(false, true);
        if (i == null || StringUtils.isNull(i.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        return true;
    }

    private void M(bb bbVar) {
        if (bbVar != null && hD(2) == 1) {
            SpannableString Bm = bbVar.Bm();
            if (Bm != null && !ao.isEmpty(Bm.toString())) {
                this.cYB.setVisibility(0);
                this.cYB.setOnTouchListener(new com.baidu.tieba.view.k(Bm));
                this.cYB.setText(Bm);
                o.a(this.cYB, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cYB.setVisibility(8);
            return;
        }
        this.cYB.setVisibility(8);
    }

    public void fu(boolean z) {
        if (this.cVT != null) {
            this.cVT.setVisibility(z ? 0 : 8);
        }
    }

    public void fv(boolean z) {
        this.cYD = z;
    }

    public void iM(int i) {
        if (this.cVU != null && this.cVU.threadData != null) {
            this.mStType = o.zH();
            if (i == 1) {
                this.cby.setVisibility(8);
                this.ccl.setStType(this.mStType);
                this.ccl.setData(this.cVU.threadData);
                this.cbx.showForumNameView(false);
                return;
            }
            this.cby.setData(this.cVU.threadData);
            this.cby.setStType(this.mStType);
            this.ccl.setVisibility(8);
            this.cbx.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbl = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbl, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cYC != null) {
            this.cYC.setPreloadSizeReadyCallback(bVar);
        }
    }

    public void kL(int i) {
        if (this.cby != null) {
            this.cby.aKg = String.valueOf(i);
        }
    }
}
