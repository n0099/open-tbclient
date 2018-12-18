package com.baidu.tieba.homepage.concern.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<k> implements com.baidu.tieba.a.e {
    private boolean aEq;
    private final View.OnClickListener aIx;
    private final View.OnClickListener aKA;
    private View cSr;
    private k cSs;
    private View.OnClickListener cSt;
    public PlayVoiceBntNew cUX;
    private TextView cUZ;
    private ConstrainImageGroup cVa;
    private final View.OnClickListener cVd;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private String caw;
    protected LinearLayout cbH;
    private HeadPendantClickableView cbt;
    public ThreadSourceShareAndPraiseLayout cbw;
    public ConcernThreadUserInfoLayout erl;
    public ConcernForumThreadUserInfoLayout ern;
    public com.baidu.tbadk.core.view.f ero;
    private View erp;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aEq = true;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.apc() != null) {
                    b.this.apc().a(view, b.this.cSs);
                }
                b.this.apx();
            }
        };
        this.cVd = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<k> apc = b.this.apc();
                if (apc != null) {
                    view.setTag("2");
                    apc.a(view, b.this.cSs);
                }
            }
        };
        this.aKA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.apc() != null) {
                    b.this.apc().a(view, b.this.cSs);
                }
            }
        };
        this.aIx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.apc() != null) {
                    b.this.apc().a(view, b.this.cSs);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cbt = (HeadPendantClickableView) view.findViewById(e.g.card_concern_normal_thread_user_pendant_header);
        if (this.cbt.getHeadView() != null) {
            this.cbt.getHeadView().setIsRound(true);
            this.cbt.getHeadView().setDrawBorder(false);
            this.cbt.getHeadView().setDefaultResource(17170445);
            this.cbt.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cbt.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.cbt.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0210e.ds60));
        }
        if (this.cbt.getPendantView() != null) {
            this.cbt.getPendantView().setIsRound(true);
            this.cbt.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_normal_thread_title);
        this.cUX = (PlayVoiceBntNew) view.findViewById(e.g.card_concern_normal_thread_abstract_voice);
        this.cUX.setAfterClickListener(this.cVd);
        this.cUZ = (TextView) view.findViewById(e.g.card_concern_normal_thread_abstract);
        this.cUZ.setVisibility(8);
        this.cVa = (ConstrainImageGroup) view.findViewById(e.g.card_concern_normal_thread_img_layout);
        this.cSr = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.cVa.setChildClickListener(this.cSt);
        this.cVa.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cVa.setImageProcessor(eVar);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_normal_thread_info_layout);
        if (this.caJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caJ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.caJ.setLayoutParams(layoutParams);
        }
        this.caJ.setOnClickListener(this.cSt);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setIsBarViewVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setShareVisible(true);
        this.caJ.setShareReportFrom(4);
        this.caJ.setFrom(9);
        this.caJ.setDisPraiseFrom(4);
        this.caJ.avL = this.currentPageType;
        this.caJ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.apc() != null) {
                    b.this.apc().a(view2, b.this.cSs);
                }
                if (b.this.cSs != null && b.this.cSs.threadData != null) {
                    o.mD(b.this.cSs.threadData.getId());
                    b.this.aph();
                }
            }
        });
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_nomal_source_read_share_layout);
        this.cbw.aKi.setOnClickListener(this.cSt);
        this.cbw.setShareReportFrom(4);
        this.cbw.setFrom(9);
        this.cbw.aKi.avL = this.currentPageType;
        this.cbw.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.apc() != null) {
                    b.this.apc().a(view2, b.this.cSs);
                }
                if (b.this.cSs != null && b.this.cSs.threadData != null && view2 != b.this.cbw.aKh) {
                    o.mD(b.this.cSs.threadData.getId());
                    b.this.aph();
                }
            }
        });
        this.cbH = (LinearLayout) view.findViewById(e.g.card_concern_normal_thread_content_layout);
        this.erp = view.findViewById(e.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cVa != null) {
            this.cVa.setSingleImageRatio(d);
        }
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
            this.cVa.onChangeSkinType();
            this.caJ.onChangeSkinType();
            al.j(this.cSr, e.d.cp_bg_line_e);
            this.cbw.onChangeSkinType();
        }
        if (this.erl != null && this.erl.getVisibility() == 0) {
            this.erl.onChangeSkinType(i);
        }
        if (this.ern != null && this.ern.getVisibility() == 0) {
            this.ern.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aph() {
        if (this.cSs != null && this.cSs.threadData.getId() != null) {
            o.a(this.mTitle, this.cSs.ZR().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cUZ, this.cSs.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_normal_thread;
    }

    private void aKl() {
        if (this.erl == null) {
            this.erl = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aKm() {
        if (this.ern == null) {
            this.ern = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.ern.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.apc() != null) {
                    b.this.apc().a(view, b.this.cSs);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.threadData == null) {
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
        if (kVar.apT()) {
            aKm();
            this.ero = this.ern;
            this.ern.setVisibility(0);
            if (this.erl != null) {
                this.erl.setVisibility(8);
            }
        } else {
            aKl();
            this.ero = this.erl;
            this.erl.setVisibility(0);
            if (this.ern != null) {
                this.ern.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!apg() && o.mE(this.cSs.threadData.getId())) {
            aph();
        }
        final bb ZR = kVar.ZR();
        if (this.ero.getHeaderImg() != null) {
            if (this.ero.getIsSimpleThread()) {
                this.ero.getHeaderImg().setVisibility(8);
                this.cbt.setVisibility(8);
            } else if (ZR.zG() == null || ZR.zG().getPendantData() == null || StringUtils.isNull(ZR.zG().getPendantData().ys())) {
                this.cbt.setVisibility(8);
                this.ero.getHeaderImg().setVisibility(0);
                this.ero.getHeaderImg().setData(ZR, !kVar.apT());
            } else {
                this.ero.getHeaderImg().setVisibility(4);
                this.cbt.setVisibility(0);
                this.cbt.setData(ZR);
            }
        }
        this.ero.setData(kVar.threadData);
        this.ero.setUserAfterClickListener(this.aKA);
        L(ZR);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> zV = kVar.threadData.zV();
        if (v.I(zV)) {
            this.cUX.setVisibility(8);
            fr(false);
            z = false;
        } else {
            this.cUX.setVisibility(0);
            fr(true);
            VoiceData.VoiceModel voiceModel = zV.get(0);
            this.cUX.setVoiceModel(voiceModel);
            this.cUX.setTag(voiceModel);
            this.cUX.aWf();
            if (voiceModel != null) {
                this.cUX.qw(voiceModel.voice_status.intValue());
            }
            this.cUX.bEB();
            z = true;
        }
        if (this.cSs.cYg && z) {
            this.cVa.setVisibility(8);
            this.erp.setVisibility(0);
        } else {
            ArrayList<MediaData> zR = kVar.threadData.zR();
            if (i.xE().xI() && v.H(zR) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zR.size(); i++) {
                    MediaData mediaData = (MediaData) v.d(zR, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.H(linkedList) > 0) {
                    this.cVa.setVisibility(0);
                    this.erp.setVisibility(8);
                    this.cVa.setFromCDN(this.aEq);
                    this.cVa.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<k> apc = b.this.apc();
                            if (apc != null) {
                                view.setTag("1");
                                apc.a(view, b.this.cSs);
                            }
                            if (z2) {
                                b.this.apx();
                            } else {
                                b.this.a(view, linkedList, i2, ZR);
                            }
                        }
                    });
                    this.cVa.setImageMediaList(linkedList);
                } else {
                    this.cVa.setVisibility(8);
                    this.erp.setVisibility(0);
                }
            } else {
                this.cVa.setVisibility(8);
                this.erp.setVisibility(0);
            }
        }
        apw();
        setPageUniqueId(getTag());
        aEj();
        iL(hC(1));
    }

    private void fr(boolean z) {
        if (this.cVa != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVa.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds10);
            }
            this.cVa.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
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
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
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
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
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
        if (this.ero != null) {
            this.ero.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ero != null) {
            return this.ero.getHeaderImg();
        }
        return null;
    }

    public View apf() {
        if (this.ero != null) {
            return this.ero.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        if (this.cSs != null && this.cSs.threadData != null) {
            if (!apg()) {
                o.mD(this.cSs.threadData.getId());
                o.a(this.mTitle, this.cSs.ZR().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cUZ, this.cSs.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cSs.threadData, null, o.zu(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cSs.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cSs.threadData.zM());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean apg() {
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

    private void c(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.apT()) {
            this.cUZ.setVisibility(8);
            return;
        }
        bb bbVar = kVar.threadData;
        if (hC(2) == 1) {
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

    private void aEj() {
        if (this.mTitle != null && this.cUX != null && this.cVa != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUX.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds24);
            this.cUX.setLayoutParams(layoutParams);
            if (this.cUX.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cVa.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                this.cVa.setLayoutParams(layoutParams2);
            }
        }
    }

    public void iL(int i) {
        if (this.cSs != null && this.cSs.threadData != null) {
            if (!this.cSs.apT() && i == 1) {
                this.caJ.setVisibility(8);
                this.cbw.setStType(o.zu());
                this.cbw.setData(this.cSs.threadData);
                this.ero.showForumNameView(false);
                return;
            }
            this.caJ.setData(this.cSs.threadData);
            this.caJ.setStType(o.zu());
            this.cbw.setVisibility(8);
            this.ero.showForumNameView(true);
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
