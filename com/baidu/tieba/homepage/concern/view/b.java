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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<k> implements com.baidu.tieba.a.e {
    private TextView XK;
    private String YA;
    private final View.OnClickListener ZG;
    private boolean ZP;
    public PlayVoiceBntNew ZY;
    private final View.OnClickListener bRz;
    public ThreadCommentAndPraiseInfoLayout dqv;
    public ThreadSourceShareAndPraiseLayout drk;
    protected LinearLayout drv;
    private HeadPendantClickableView ehK;
    private k eim;
    private ConstrainImageGroup ein;
    private View eio;
    private View.OnClickListener eis;
    private final View.OnClickListener eit;
    public ConcernThreadUserInfoLayout fHh;
    public ConcernForumThreadUserInfoLayout fHj;
    public com.baidu.tbadk.core.view.d fHk;
    private View fHl;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ZP = true;
        this.eis = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQh() != null) {
                    b.this.aQh().a(view, b.this.eim);
                }
                b.this.ajX();
            }
        };
        this.eit = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aQh = b.this.aQh();
                if (aQh != null) {
                    view.setTag("2");
                    aQh.a(view, b.this.eim);
                }
            }
        };
        this.ZG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQh() != null) {
                    b.this.aQh().a(view, b.this.eim);
                }
            }
        };
        this.bRz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQh() != null) {
                    b.this.aQh().a(view, b.this.eim);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.ehK = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.ehK.getHeadView() != null) {
            this.ehK.getHeadView().setIsRound(true);
            this.ehK.getHeadView().setDrawBorder(false);
            this.ehK.getHeadView().setDefaultResource(17170445);
            this.ehK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ehK.getHeadView().setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.ehK.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.ehK.getPendantView() != null) {
            this.ehK.getPendantView().setIsRound(true);
            this.ehK.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.ZY = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.ZY.setAfterClickListener(this.eit);
        this.XK = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.XK.setVisibility(8);
        this.ein = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.eio = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.ein.setChildClickListener(this.eis);
        this.ein.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.ein.setImageProcessor(fVar);
        this.dqv = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        if (this.dqv.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqv.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dqv.setLayoutParams(layoutParams);
        }
        this.dqv.setOnClickListener(this.eis);
        this.dqv.setReplyTimeVisible(false);
        this.dqv.setIsBarViewVisible(false);
        this.dqv.setShowPraiseNum(true);
        this.dqv.setNeedAddPraiseIcon(true);
        this.dqv.setNeedAddReplyIcon(true);
        this.dqv.setShareVisible(true);
        this.dqv.setShareReportFrom(4);
        this.dqv.setFrom(9);
        this.dqv.setDisPraiseFrom(4);
        this.dqv.bSH = this.currentPageType;
        this.dqv.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aQh() != null) {
                    b.this.aQh().a(view2, b.this.eim);
                }
                if (b.this.eim != null && b.this.eim.threadData != null) {
                    n.tA(b.this.eim.threadData.getId());
                    b.this.blA();
                }
            }
        });
        this.drk = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.drk.bTz.setOnClickListener(this.eis);
        this.drk.setShareReportFrom(4);
        this.drk.setFrom(9);
        this.drk.bTz.bSH = this.currentPageType;
        this.drk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aQh() != null) {
                    b.this.aQh().a(view2, b.this.eim);
                }
                if (b.this.eim != null && b.this.eim.threadData != null && view2 != b.this.drk.bSQ) {
                    n.tA(b.this.eim.threadData.getId());
                    b.this.blA();
                }
            }
        });
        this.drv = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.fHl = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.ein != null) {
            this.ein.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ein != null) {
            this.ein.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ein != null) {
            this.ein.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.addresslist_item_bg);
            this.ein.onChangeSkinType();
            this.dqv.onChangeSkinType();
            al.l(this.eio, d.C0277d.cp_bg_line_e);
            this.drk.onChangeSkinType();
        }
        if (this.fHh != null && this.fHh.getVisibility() == 0) {
            this.fHh.onChangeSkinType(i);
        }
        if (this.fHj != null && this.fHj.getVisibility() == 0) {
            this.fHj.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blA() {
        if (this.eim != null && this.eim.threadData.getId() != null) {
            n.a(this.mTitle, this.eim.WR().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
            n.a(this.XK, this.eim.threadData.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_normal_thread;
    }

    private void blB() {
        if (this.fHh == null) {
            this.fHh = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void blC() {
        if (this.fHj == null) {
            this.fHj = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.fHj.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aQh() != null) {
                    b.this.aQh().a(view, b.this.eim);
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
        this.eim = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eis);
        }
        if (kVar.aQU()) {
            blC();
            this.fHk = this.fHj;
            this.fHj.setVisibility(0);
            if (this.fHh != null) {
                this.fHh.setVisibility(8);
            }
        } else {
            blB();
            this.fHk = this.fHh;
            this.fHh.setVisibility(0);
            if (this.fHj != null) {
                this.fHj.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aQr() && n.tB(this.eim.threadData.getId())) {
            blA();
        }
        final bg WR = kVar.WR();
        if (this.fHk.getHeaderImg() != null) {
            if (this.fHk.getIsSimpleThread()) {
                this.fHk.getHeaderImg().setVisibility(8);
                this.ehK.setVisibility(8);
            } else if (WR.YR() == null || WR.YR().getPendantData() == null || StringUtils.isNull(WR.YR().getPendantData().Xn())) {
                this.ehK.setVisibility(8);
                this.fHk.getHeaderImg().setVisibility(0);
                this.fHk.getHeaderImg().setData(WR, !kVar.aQU());
            } else {
                this.fHk.getHeaderImg().setVisibility(4);
                this.ehK.setVisibility(0);
                this.ehK.setData(WR);
            }
        }
        this.fHk.setData(kVar.threadData);
        this.fHk.setUserAfterClickListener(this.ZG);
        ah(WR);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> Zf = kVar.threadData.Zf();
        if (v.T(Zf)) {
            this.ZY.setVisibility(8);
            hO(false);
            z = false;
        } else {
            this.ZY.setVisibility(0);
            hO(true);
            VoiceData.VoiceModel voiceModel = Zf.get(0);
            this.ZY.setVoiceModel(voiceModel);
            this.ZY.setTag(voiceModel);
            this.ZY.bxV();
            if (voiceModel != null) {
                this.ZY.uu(voiceModel.voice_status.intValue());
            }
            this.ZY.cfD();
            z = true;
        }
        if (this.eim.elI && z) {
            this.ein.setVisibility(8);
            this.fHl.setVisibility(0);
        } else {
            ArrayList<MediaData> Zb = kVar.threadData.Zb();
            if (i.Wy().WC() && v.S(Zb) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < Zb.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(Zb, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.S(linkedList) > 0) {
                    this.ein.setVisibility(0);
                    this.fHl.setVisibility(8);
                    this.ein.setFromCDN(this.ZP);
                    this.ein.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z2) {
                            ab<k> aQh = b.this.aQh();
                            if (aQh != null) {
                                view.setTag("1");
                                aQh.a(view, b.this.eim);
                            }
                            if (z2) {
                                b.this.ajX();
                            } else {
                                b.this.a(view, linkedList, i2, WR);
                            }
                        }
                    });
                    this.ein.setImageMediaList(linkedList);
                } else {
                    this.ein.setVisibility(8);
                    this.fHl.setVisibility(0);
                }
            } else {
                this.ein.setVisibility(8);
                this.fHl.setVisibility(0);
            }
        }
        aQz();
        setPageUniqueId(getTag());
        bfT();
        mF(lt(1));
    }

    private void hO(boolean z) {
        if (this.ein != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ein.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.ein.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ZP ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bgVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YW(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZP, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bgVar.getId();
        historyMessage.threadName = bgVar.getTitle();
        historyMessage.forumName = bgVar.YW();
        historyMessage.postID = bgVar.Zh();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void aQz() {
        if (!this.eim.cjO) {
            this.ZY.setClickable(false);
        } else {
            this.ZY.setClickable(true);
        }
        int childCount = this.ein.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ein.getChildAt(i);
            if (childAt != null) {
                if (!this.eim.cjO) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ein != null) {
            this.ein.setPageUniqueId(bdUniqueId);
        }
        if (this.fHk != null) {
            this.fHk.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.fHk != null) {
            return this.fHk.getHeaderImg();
        }
        return null;
    }

    public View aQm() {
        if (this.fHk != null) {
            return this.fHk.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajX() {
        if (this.eim != null && this.eim.threadData != null) {
            if (!aQr()) {
                n.tA(this.eim.threadData.getId());
                n.a(this.mTitle, this.eim.WR().getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
                n.a(this.XK, this.eim.threadData.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.eim.threadData, null, n.YE(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.eim.threadData.getFid()));
            createFromThreadCfg.setForumName(this.eim.threadData.YW());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aQr() {
        return this.eim.elI && !this.eim.cjO;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean ah(bg bgVar) {
        SpannableStringBuilder m = bgVar.m(false, true);
        if (m == null || StringUtils.isNull(m.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(m));
            this.mTitle.setText(m);
            n.a(this.mTitle, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.aQU()) {
            this.XK.setVisibility(8);
            return;
        }
        bg bgVar = kVar.threadData;
        if (lt(2) == 1) {
            SpannableString aas = bgVar.aas();
            if (aas != null && !ap.isEmpty(aas.toString())) {
                this.XK.setVisibility(0);
                this.XK.setOnTouchListener(new com.baidu.tieba.view.k(aas));
                this.XK.setText(aas);
                n.a(this.XK, bgVar.getId(), d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
                return;
            }
            this.XK.setVisibility(8);
            return;
        }
        this.XK.setVisibility(8);
    }

    private void bfT() {
        if (this.mTitle != null && this.ZY != null && this.ein != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.ZY.setLayoutParams(layoutParams);
            if (this.ZY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ein.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.ein.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mF(int i) {
        if (this.eim != null && this.eim.threadData != null) {
            if (!this.eim.aQU() && i == 1) {
                this.dqv.setVisibility(8);
                this.drk.setStType(n.YE());
                this.drk.setData(this.eim.threadData);
                this.fHk.dN(false);
                return;
            }
            this.dqv.setData(this.eim.threadData);
            this.dqv.setStType(n.YE());
            this.drk.setVisibility(8);
            this.fHk.dN(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    public int lt(int i) {
        return com.baidu.tieba.a.d.awk().ak(this.YA, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.ein != null) {
            this.ein.setPreloadSizeReadyCallback(bVar);
        }
    }
}
