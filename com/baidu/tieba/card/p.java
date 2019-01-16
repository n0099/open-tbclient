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
    private boolean aET;
    private final View.OnClickListener aLe;
    private ThreadGodReplyLayout cVR;
    private View cVS;
    private com.baidu.tieba.card.data.k cVT;
    private View.OnClickListener cVU;
    private TextView cYA;
    private ConstrainImageGroup cYB;
    private boolean cYC;
    private RelativeLayout cYD;
    private final View.OnClickListener cYE;
    public PlayVoiceBntNew cYy;
    private View cYz;
    private NEGFeedBackView cbI;
    private String cbk;
    public ThreadUserInfoLayout cbw;
    public ThreadCommentAndPraiseInfoLayout cbx;
    private HeadPendantClickableView cch;
    public ThreadSourceShareAndPraiseLayout cck;
    protected LinearLayout ccw;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cbI = null;
        this.mSkinType = 3;
        this.aET = true;
        this.cYC = true;
        this.cVU = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cVT != null) {
                    p.this.cVT.aFS = 1;
                }
                if (p.this.aqp() != null) {
                    p.this.aqp().a(view, p.this.cVT);
                }
                p.this.fs(view == p.this.cVR);
            }
        };
        this.cYE = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.card.data.k> aqp = p.this.aqp();
                if (aqp != null) {
                    view.setTag("2");
                    aqp.a(view, p.this.cVT);
                }
            }
        };
        this.aLe = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cVT == null) {
                    if (p.this.aqp() != null) {
                        p.this.aqp().a(view, p.this.cVT);
                        return;
                    }
                    return;
                }
                if (view == p.this.cbw.getUserName()) {
                    p.this.cVT.aFS = 3;
                } else if (view == p.this.cbw.getHeaderImg()) {
                    p.this.cVT.aFS = 4;
                } else if (view == p.this.cYB) {
                    p.this.cVT.aFS = 2;
                    return;
                } else {
                    p.this.cVT.aFS = 1;
                }
                if (p.this.aqp() != null) {
                    p.this.aqp().a(view, p.this.cVT);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cch = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cch.getHeadView() != null) {
            this.cch.getHeadView().setIsRound(true);
            this.cch.getHeadView().setDrawBorder(false);
            this.cch.getHeadView().setDefaultResource(17170445);
            this.cch.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cch.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cch.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cch.setHasPendantStyle();
        if (this.cch.getPendantView() != null) {
            this.cch.getPendantView().setIsRound(true);
            this.cch.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cYy = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cYy.setAfterClickListener(this.cYE);
        this.cYA = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cYA.setVisibility(8);
        this.cYB = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cVS = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20);
        this.cYB.setChildClickListener(this.cVU);
        this.cYB.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cYB.setImageProcessor(eVar);
        this.cYz = view.findViewById(e.g.divider_line_above_praise);
        this.cbx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.cbw = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.cbI = new NEGFeedBackView(this.mPageContext);
        this.cYD = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.cbI.a(this.cYD, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120), 0);
        if (this.cbx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbx.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cbx.setLayoutParams(layoutParams);
        }
        this.cbx.setOnClickListener(this.cVU);
        this.cbx.setReplyTimeVisible(false);
        this.cbx.setShowPraiseNum(true);
        this.cbx.setNeedAddPraiseIcon(true);
        this.cbx.setNeedAddReplyIcon(true);
        this.cbx.setShareVisible(true);
        this.cbx.setFrom(1);
        this.cbx.setDisPraiseFrom(1);
        this.cbx.setShareReportFrom(3);
        this.cbx.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aqp() != null) {
                    p.this.aqp().a(view2, p.this.cVT);
                }
                if (p.this.cVT != null && p.this.cVT.threadData != null) {
                    o.mW(p.this.cVT.threadData.getId());
                    if (!p.this.aqt()) {
                        o.a(p.this.mTitle, p.this.cVT.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cYA, p.this.cVT.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cVR.getGodReplyContent(), p.this.cVT.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
        this.ccw = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.cVR = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cVR.setOnClickListener(this.cVU);
        this.cck = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        this.cck.aKM.setOnClickListener(this.cVU);
        this.cck.setFrom(1);
        this.cck.setShareReportFrom(3);
        this.cck.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aqp() != null) {
                    p.this.aqp().a(view2, p.this.cVT);
                }
                if (p.this.cVT != null && p.this.cVT.threadData != null && view2 != p.this.cck.aKL) {
                    o.mW(p.this.cVT.threadData.getId());
                    if (!p.this.aqt()) {
                        o.a(p.this.mTitle, p.this.cVT.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cYA, p.this.cVT.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cVR.getGodReplyContent(), p.this.cVT.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cYB != null) {
            this.cYB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cYB != null) {
            this.cYB.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cYz, e.d.transparent);
            this.cYB.onChangeSkinType();
            this.cbx.onChangeSkinType();
            this.cVR.onChangeSkinType();
            this.cbw.onChangeSkinType();
            if (this.cbI != null) {
                this.cbI.onChangeSkinType();
            }
            al.j(this.cVS, e.d.cp_bg_line_e);
            if (this.cck != null) {
                this.cck.onChangeSkinType();
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
        this.cVT = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVU);
        }
        if (this.cbI != null) {
            if (this.cVT.asE != null && this.cVT.asE.size() > 0) {
                ah ahVar = new ah();
                ahVar.setTid(this.cVT.aaq().getTid());
                ahVar.setFid(this.cVT.aaq().getFid());
                ahVar.a(this.cVT.asE);
                this.cbI.setData(ahVar);
                this.cbI.setFirstRowSingleColumn(true);
                if (kVar.threadData.zT() != null && !StringUtils.isNull(kVar.threadData.zT().getUserId())) {
                    if (kVar.threadData.zT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.cbI.setVisibility(8);
                    } else if (this.cbI != null) {
                        this.cbI.setVisibility(this.cYC ? 0 : 8);
                    }
                }
            } else {
                this.cbI.setVisibility(8);
            }
        }
        this.cbw.setData(kVar.threadData);
        this.cVR.setFromCDN(this.aET);
        this.cVR.setData(kVar.threadData.Bk());
        if (!aqt() && o.mX(this.cVT.threadData.getId())) {
            o.a(this.mTitle, this.cVT.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cYA, this.cVT.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cVR.getGodReplyContent(), this.cVT.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.cbw.setUserAfterClickListener(this.aLe);
        final bb aaq = kVar.aaq();
        if (this.cbw.getHeaderImg() != null) {
            if (this.cbw.getIsSimpleThread()) {
                this.cbw.getHeaderImg().setVisibility(8);
                this.cch.setVisibility(8);
            } else if (aaq.zT() == null || aaq.zT().getPendantData() == null || StringUtils.isNull(aaq.zT().getPendantData().yF())) {
                this.cch.setVisibility(8);
                this.cbw.getHeaderImg().setVisibility(0);
                this.cbw.getHeaderImg().setData(aaq);
            } else {
                this.cbw.getHeaderImg().setVisibility(4);
                this.cch.setVisibility(0);
                this.cch.setData(aaq);
            }
        }
        L(aaq);
        M(aaq);
        ArrayList<VoiceData.VoiceModel> Ai = kVar.threadData.Ai();
        if (com.baidu.tbadk.core.util.v.I(Ai)) {
            this.cYy.setVisibility(8);
            z = false;
        } else {
            this.cYy.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Ai.get(0);
            this.cYy.setVoiceModel(voiceModel);
            this.cYy.setTag(voiceModel);
            this.cYy.aXt();
            if (voiceModel != null) {
                this.cYy.qK(voiceModel.voice_status.intValue());
            }
            this.cYy.bGc();
            z = true;
        }
        if (this.cVT.dbJ && z) {
            this.cYB.setVisibility(8);
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
                    this.cYB.setVisibility(0);
                    this.cYB.setFromCDN(this.aET);
                    this.cYB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<com.baidu.tieba.card.data.k> aqp = p.this.aqp();
                            if (aqp != null) {
                                view.setTag("1");
                                if (p.this.aLe != null) {
                                    p.this.aLe.onClick(p.this.cYB);
                                }
                                aqp.a(view, p.this.cVT);
                            }
                            if (z2) {
                                p.this.aqJ();
                            } else {
                                p.this.a(view, linkedList, i2, aaq);
                            }
                        }
                    });
                    this.cYB.setImageMediaList(linkedList);
                } else {
                    this.cYB.setVisibility(8);
                }
            } else {
                this.cYB.setVisibility(8);
            }
        }
        aqH();
        aqI();
        setPageUniqueId(getTag());
        iM(hD(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aqH() {
        if (this.cYz != null && this.cYB != null && this.cVR != null) {
            if (this.cYB.getVisibility() == 8 && this.cVR.getVisibility() == 8) {
                this.cYz.setVisibility(0);
            } else {
                this.cYz.setVisibility(8);
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
                    imageUrlData.urlType = this.aET ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zZ(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aET, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        if (!this.cVT.bao) {
            this.cYy.setClickable(false);
        } else {
            this.cYy.setClickable(true);
        }
        int childCount = this.cYB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cYB.getChildAt(i);
            if (childAt != null) {
                if (!this.cVT.bao) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aET = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cYB != null) {
            this.cYB.setPageUniqueId(bdUniqueId);
        }
        if (this.cbI != null) {
            this.cbI.setUniqueId(bdUniqueId);
        }
        if (this.cbw != null) {
            this.cbw.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.cbI != null) {
            this.cbI.setEventCallback(aVar);
        }
    }

    public View aqr() {
        return this.cVR;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cbw != null) {
            return this.cbw.aKR;
        }
        return null;
    }

    public View aqs() {
        if (this.cbw != null) {
            return this.cbw.aKT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqJ() {
        fs(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (this.cVT != null && this.cVT.threadData != null) {
            if (!aqt()) {
                o.mW(this.cVT.threadData.getId());
                o.a(this.mTitle, this.cVT.aaq().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cYA, this.cVT.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                o.a(this.cVR.getGodReplyContent(), this.cVT.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVT.threadData, null, o.zH(), 18003, true, false, false).addLocateParam(this.cVT.ara());
            addLocateParam.setForumId(String.valueOf(this.cVT.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cVT.threadData.zZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.mW(this.cVT.aaq().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqt() {
        return this.cVT.dbJ && !this.cVT.bao;
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
                this.cYA.setVisibility(0);
                this.cYA.setOnTouchListener(new com.baidu.tieba.view.k(Bm));
                this.cYA.setText(Bm);
                o.a(this.cYA, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cYA.setVisibility(8);
            return;
        }
        this.cYA.setVisibility(8);
    }

    public void fu(boolean z) {
        if (this.cVS != null) {
            this.cVS.setVisibility(z ? 0 : 8);
        }
    }

    public void fv(boolean z) {
        this.cYC = z;
    }

    public void iM(int i) {
        if (this.cVT != null && this.cVT.threadData != null) {
            this.mStType = o.zH();
            if (i == 1) {
                this.cbx.setVisibility(8);
                this.cck.setStType(this.mStType);
                this.cck.setData(this.cVT.threadData);
                this.cbw.showForumNameView(false);
                return;
            }
            this.cbx.setData(this.cVT.threadData);
            this.cbx.setStType(this.mStType);
            this.cck.setVisibility(8);
            this.cbw.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.cbk = str;
    }

    public int hD(int i) {
        return com.baidu.tieba.a.d.Wk().N(this.cbk, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cYB != null) {
            this.cYB.setPreloadSizeReadyCallback(bVar);
        }
    }

    public void kL(int i) {
        if (this.cbx != null) {
            this.cbx.aKf = String.valueOf(i);
        }
    }
}
