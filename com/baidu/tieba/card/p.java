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
    private boolean aEq;
    private final View.OnClickListener aKA;
    private ThreadGodReplyLayout cSq;
    private View cSr;
    private com.baidu.tieba.card.data.k cSs;
    private View.OnClickListener cSt;
    public PlayVoiceBntNew cUX;
    private View cUY;
    private TextView cUZ;
    private ConstrainImageGroup cVa;
    private boolean cVb;
    private RelativeLayout cVc;
    private final View.OnClickListener cVd;
    public ThreadUserInfoLayout caI;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private NEGFeedBackView caU;
    private String caw;
    protected LinearLayout cbH;
    private HeadPendantClickableView cbt;
    public ThreadSourceShareAndPraiseLayout cbw;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caU = null;
        this.mSkinType = 3;
        this.aEq = true;
        this.cVb = true;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cSs != null) {
                    p.this.cSs.aFp = 1;
                }
                if (p.this.apc() != null) {
                    p.this.apc().a(view, p.this.cSs);
                }
                p.this.fn(view == p.this.cSq);
            }
        };
        this.cVd = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.card.data.k> apc = p.this.apc();
                if (apc != null) {
                    view.setTag("2");
                    apc.a(view, p.this.cSs);
                }
            }
        };
        this.aKA = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cSs == null) {
                    if (p.this.apc() != null) {
                        p.this.apc().a(view, p.this.cSs);
                        return;
                    }
                    return;
                }
                if (view == p.this.caI.getUserName()) {
                    p.this.cSs.aFp = 3;
                } else if (view == p.this.caI.getHeaderImg()) {
                    p.this.cSs.aFp = 4;
                } else if (view == p.this.cVa) {
                    p.this.cSs.aFp = 2;
                    return;
                } else {
                    p.this.cSs.aFp = 1;
                }
                if (p.this.apc() != null) {
                    p.this.apc().a(view, p.this.cSs);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cbt = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cbt.getHeadView() != null) {
            this.cbt.getHeadView().setIsRound(true);
            this.cbt.getHeadView().setDrawBorder(false);
            this.cbt.getHeadView().setDefaultResource(17170445);
            this.cbt.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbt.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbt.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0210e.ds70));
        }
        this.cbt.setHasPendantStyle();
        if (this.cbt.getPendantView() != null) {
            this.cbt.getPendantView().setIsRound(true);
            this.cbt.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cUX = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cUX.setAfterClickListener(this.cVd);
        this.cUZ = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cUZ.setVisibility(8);
        this.cVa = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cSr = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20);
        this.cVa.setChildClickListener(this.cSt);
        this.cVa.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cVa.setImageProcessor(eVar);
        this.cUY = view.findViewById(e.g.divider_line_above_praise);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.caI = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.caU = new NEGFeedBackView(this.mPageContext);
        this.cVc = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.caU.a(this.cVc, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120), 0);
        if (this.caJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caJ.setLayoutParams(layoutParams);
        }
        this.caJ.setOnClickListener(this.cSt);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setShareVisible(true);
        this.caJ.setFrom(1);
        this.caJ.setDisPraiseFrom(1);
        this.caJ.setShareReportFrom(3);
        this.caJ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.apc() != null) {
                    p.this.apc().a(view2, p.this.cSs);
                }
                if (p.this.cSs != null && p.this.cSs.threadData != null) {
                    o.mD(p.this.cSs.threadData.getId());
                    if (!p.this.apg()) {
                        o.a(p.this.mTitle, p.this.cSs.ZR().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cUZ, p.this.cSs.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cSq.getGodReplyContent(), p.this.cSs.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
        this.cbH = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.cSq = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cSq.setOnClickListener(this.cSt);
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        this.cbw.aKi.setOnClickListener(this.cSt);
        this.cbw.setFrom(1);
        this.cbw.setShareReportFrom(3);
        this.cbw.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.apc() != null) {
                    p.this.apc().a(view2, p.this.cSs);
                }
                if (p.this.cSs != null && p.this.cSs.threadData != null && view2 != p.this.cbw.aKh) {
                    o.mD(p.this.cSs.threadData.getId());
                    if (!p.this.apg()) {
                        o.a(p.this.mTitle, p.this.cSs.ZR().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cUZ, p.this.cSs.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cSq.getGodReplyContent(), p.this.cSs.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cVa != null) {
            this.cVa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cVa != null) {
            this.cVa.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cUY, e.d.transparent);
            this.cVa.onChangeSkinType();
            this.caJ.onChangeSkinType();
            this.cSq.onChangeSkinType();
            this.caI.onChangeSkinType();
            if (this.caU != null) {
                this.caU.onChangeSkinType();
            }
            al.j(this.cSr, e.d.cp_bg_line_e);
            if (this.cbw != null) {
                this.cbw.onChangeSkinType();
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
        if (kVar == null || kVar.ZR() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cSs = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        if (this.caU != null) {
            if (this.cSs.asc != null && this.cSs.asc.size() > 0) {
                ah ahVar = new ah();
                ahVar.setTid(this.cSs.ZR().getTid());
                ahVar.setFid(this.cSs.ZR().getFid());
                ahVar.a(this.cSs.asc);
                this.caU.setData(ahVar);
                this.caU.setFirstRowSingleColumn(true);
                if (kVar.threadData.zG() != null && !StringUtils.isNull(kVar.threadData.zG().getUserId())) {
                    if (kVar.threadData.zG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.caU.setVisibility(8);
                    } else if (this.caU != null) {
                        this.caU.setVisibility(this.cVb ? 0 : 8);
                    }
                }
            } else {
                this.caU.setVisibility(8);
            }
        }
        this.caI.setData(kVar.threadData);
        this.cSq.setFromCDN(this.aEq);
        this.cSq.setData(kVar.threadData.AX());
        if (!apg() && o.mE(this.cSs.threadData.getId())) {
            o.a(this.mTitle, this.cSs.ZR().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cUZ, this.cSs.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cSq.getGodReplyContent(), this.cSs.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.caI.setUserAfterClickListener(this.aKA);
        final bb ZR = kVar.ZR();
        if (this.caI.getHeaderImg() != null) {
            if (this.caI.getIsSimpleThread()) {
                this.caI.getHeaderImg().setVisibility(8);
                this.cbt.setVisibility(8);
            } else if (ZR.zG() == null || ZR.zG().getPendantData() == null || StringUtils.isNull(ZR.zG().getPendantData().ys())) {
                this.cbt.setVisibility(8);
                this.caI.getHeaderImg().setVisibility(0);
                this.caI.getHeaderImg().setData(ZR);
            } else {
                this.caI.getHeaderImg().setVisibility(4);
                this.cbt.setVisibility(0);
                this.cbt.setData(ZR);
            }
        }
        L(ZR);
        M(ZR);
        ArrayList<VoiceData.VoiceModel> zV = kVar.threadData.zV();
        if (com.baidu.tbadk.core.util.v.I(zV)) {
            this.cUX.setVisibility(8);
            z = false;
        } else {
            this.cUX.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zV.get(0);
            this.cUX.setVoiceModel(voiceModel);
            this.cUX.setTag(voiceModel);
            this.cUX.aWg();
            if (voiceModel != null) {
                this.cUX.qw(voiceModel.voice_status.intValue());
            }
            this.cUX.bEC();
            z = true;
        }
        if (this.cSs.cYg && z) {
            this.cVa.setVisibility(8);
        } else {
            ArrayList<MediaData> zR = ZR.zR();
            if (com.baidu.tbadk.core.i.xE().xI() && com.baidu.tbadk.core.util.v.H(zR) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zR.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(zR, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.H(linkedList) > 0) {
                    this.cVa.setVisibility(0);
                    this.cVa.setFromCDN(this.aEq);
                    this.cVa.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<com.baidu.tieba.card.data.k> apc = p.this.apc();
                            if (apc != null) {
                                view.setTag("1");
                                if (p.this.aKA != null) {
                                    p.this.aKA.onClick(p.this.cVa);
                                }
                                apc.a(view, p.this.cSs);
                            }
                            if (z2) {
                                p.this.apx();
                            } else {
                                p.this.a(view, linkedList, i2, ZR);
                            }
                        }
                    });
                    this.cVa.setImageMediaList(linkedList);
                } else {
                    this.cVa.setVisibility(8);
                }
            } else {
                this.cVa.setVisibility(8);
            }
        }
        apv();
        apw();
        setPageUniqueId(getTag());
        iL(hC(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void apv() {
        if (this.cUY != null && this.cVa != null && this.cSq != null) {
            if (this.cVa.getVisibility() == 8 && this.cSq.getVisibility() == 8) {
                this.cUY.setVisibility(0);
            } else {
                this.cUY.setVisibility(8);
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
                    imageUrlData.urlType = this.aEq ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.zM(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aEq, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bbVar.zM();
        historyMessage.postID = bbVar.zX();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void apw() {
        if (!this.cSs.aZB) {
            this.cUX.setClickable(false);
        } else {
            this.cUX.setClickable(true);
        }
        int childCount = this.cVa.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cVa.getChildAt(i);
            if (childAt != null) {
                if (!this.cSs.aZB) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aEq = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cVa != null) {
            this.cVa.setPageUniqueId(bdUniqueId);
        }
        if (this.caU != null) {
            this.caU.setUniqueId(bdUniqueId);
        }
        if (this.caI != null) {
            this.caI.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.caU != null) {
            this.caU.setEventCallback(aVar);
        }
    }

    public View ape() {
        return this.cSq;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.caI != null) {
            return this.caI.aKn;
        }
        return null;
    }

    public View apf() {
        if (this.caI != null) {
            return this.caI.aKp;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        fn(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(boolean z) {
        if (this.cSs != null && this.cSs.threadData != null) {
            if (!apg()) {
                o.mD(this.cSs.threadData.getId());
                o.a(this.mTitle, this.cSs.ZR().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cUZ, this.cSs.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                o.a(this.cSq.getGodReplyContent(), this.cSs.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cSs.threadData, null, o.zu(), 18003, true, false, false).addLocateParam(this.cSs.apO());
            addLocateParam.setForumId(String.valueOf(this.cSs.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cSs.threadData.zM());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.mD(this.cSs.ZR().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apg() {
        return this.cSs.cYg && !this.cSs.aZB;
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
        if (bbVar != null && hC(2) == 1) {
            SpannableString AZ = bbVar.AZ();
            if (AZ != null && !ao.isEmpty(AZ.toString())) {
                this.cUZ.setVisibility(0);
                this.cUZ.setOnTouchListener(new com.baidu.tieba.view.k(AZ));
                this.cUZ.setText(AZ);
                o.a(this.cUZ, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cUZ.setVisibility(8);
            return;
        }
        this.cUZ.setVisibility(8);
    }

    public void fp(boolean z) {
        if (this.cSr != null) {
            this.cSr.setVisibility(z ? 0 : 8);
        }
    }

    public void fq(boolean z) {
        this.cVb = z;
    }

    public void iL(int i) {
        if (this.cSs != null && this.cSs.threadData != null) {
            this.mStType = o.zu();
            if (i == 1) {
                this.caJ.setVisibility(8);
                this.cbw.setStType(this.mStType);
                this.cbw.setData(this.cSs.threadData);
                this.caI.showForumNameView(false);
                return;
            }
            this.caJ.setData(this.cSs.threadData);
            this.caJ.setStType(this.mStType);
            this.cbw.setVisibility(8);
            this.caI.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cVa != null) {
            this.cVa.setPreloadSizeReadyCallback(bVar);
        }
    }
}
