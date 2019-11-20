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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.n;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<k> implements e {
    private TextView Fk;
    private String Gc;
    public PlayVoiceBntNew HH;
    private final View.OnClickListener Ho;
    private boolean Hx;
    private final View.OnClickListener coV;
    public ThreadCommentAndPraiseInfoLayout dSA;
    public ThreadSourceShareAndPraiseLayout dTo;
    protected LinearLayout dTz;
    private HeadPendantClickableView eLQ;
    private k eMq;
    private ConstrainImageGroup eMr;
    private View eMs;
    private View.OnClickListener eMw;
    private final View.OnClickListener eMx;
    public ConcernThreadUserInfoLayout ges;
    public ConcernForumThreadUserInfoLayout get;
    public d geu;
    private View gev;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Hx = true;
        this.eMw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view, a.this.eMq);
                }
                a.this.ash();
            }
        };
        this.eMx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aZV = a.this.aZV();
                if (aZV != null) {
                    view.setTag("2");
                    aZV.a(view, a.this.eMq);
                }
            }
        };
        this.Ho = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view, a.this.eMq);
                }
            }
        };
        this.coV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view, a.this.eMq);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.eLQ = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.eLQ.getHeadView() != null) {
            this.eLQ.getHeadView().setIsRound(true);
            this.eLQ.getHeadView().setDrawBorder(false);
            this.eLQ.getHeadView().setDefaultResource(17170445);
            this.eLQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eLQ.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.eLQ.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.eLQ.getPendantView() != null) {
            this.eLQ.getPendantView().setIsRound(true);
            this.eLQ.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.HH = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.HH.setAfterClickListener(this.eMx);
        this.Fk = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.Fk.setVisibility(8);
        this.eMr = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.eMs = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.eMr.setChildClickListener(this.eMw);
        this.eMr.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.g(1.0d);
        this.eMr.setImageProcessor(fVar);
        this.dSA = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.dSA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSA.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dSA.setLayoutParams(layoutParams);
        }
        this.dSA.setOnClickListener(this.eMw);
        this.dSA.setReplyTimeVisible(false);
        this.dSA.setIsBarViewVisible(false);
        this.dSA.setShowPraiseNum(true);
        this.dSA.setNeedAddPraiseIcon(true);
        this.dSA.setNeedAddReplyIcon(true);
        this.dSA.setShareVisible(true);
        this.dSA.setShareReportFrom(4);
        this.dSA.setFrom(9);
        this.dSA.setDisPraiseFrom(4);
        this.dSA.cqc = this.currentPageType;
        this.dSA.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view2, a.this.eMq);
                }
                if (a.this.eMq != null && a.this.eMq.caz != null) {
                    n.uz(a.this.eMq.caz.getId());
                    a.this.btd();
                }
            }
        });
        this.dTo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.dTo.cqW.setOnClickListener(this.eMw);
        this.dTo.setShareReportFrom(4);
        this.dTo.setFrom(9);
        this.dTo.cqW.cqc = this.currentPageType;
        this.dTo.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view2, a.this.eMq);
                }
                if (a.this.eMq != null && a.this.eMq.caz != null && view2 != a.this.dTo.cql) {
                    n.uz(a.this.eMq.caz.getId());
                    a.this.btd();
                }
            }
        });
        this.dTz = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gev = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eMr != null) {
            this.eMr.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eMr != null) {
            this.eMr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eMr != null) {
            this.eMr.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.eMr.onChangeSkinType();
            this.dSA.onChangeSkinType();
            am.setBackgroundColor(this.eMs, R.color.cp_bg_line_c);
            this.dTo.onChangeSkinType();
        }
        if (this.ges != null && this.ges.getVisibility() == 0) {
            this.ges.onChangeSkinType(i);
        }
        if (this.get != null && this.get.getVisibility() == 0) {
            this.get.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btd() {
        if (this.eMq != null && this.eMq.caz.getId() != null) {
            n.a(this.mTitle, this.eMq.agG().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.Fk, this.eMq.caz.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bte() {
        if (this.ges == null) {
            this.ges = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void btf() {
        if (this.get == null) {
            this.get = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.get.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view, a.this.eMq);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.caz == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.eMq = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eMw);
        }
        if (kVar.baJ()) {
            btf();
            this.geu = this.get;
            this.get.setVisibility(0);
            if (this.ges != null) {
                this.ges.setVisibility(8);
            }
        } else {
            bte();
            this.geu = this.ges;
            this.ges.setVisibility(0);
            if (this.get != null) {
                this.get.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!baf() && n.uA(this.eMq.caz.getId())) {
            btd();
        }
        final bh agG = kVar.agG();
        if (this.geu.getHeaderImg() != null) {
            if (this.geu.getIsSimpleThread()) {
                this.geu.getHeaderImg().setVisibility(8);
                this.eLQ.setVisibility(8);
            } else if (agG.aiE() == null || agG.aiE().getPendantData() == null || StringUtils.isNull(agG.aiE().getPendantData().ahd())) {
                this.eLQ.setVisibility(8);
                this.geu.getHeaderImg().setVisibility(0);
                this.geu.getHeaderImg().setData(agG, !kVar.baJ());
            } else {
                this.geu.getHeaderImg().setVisibility(4);
                this.eLQ.setVisibility(0);
                this.eLQ.setData(agG);
            }
        }
        this.geu.setData(kVar.caz);
        this.geu.setUserAfterClickListener(this.Ho);
        ag(agG);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aiS = kVar.caz.aiS();
        if (v.isEmpty(aiS)) {
            this.HH.setVisibility(8);
            iI(false);
            z = false;
        } else {
            this.HH.setVisibility(0);
            iI(true);
            VoiceData.VoiceModel voiceModel = aiS.get(0);
            this.HH.setVoiceModel(voiceModel);
            this.HH.setTag(voiceModel);
            this.HH.bno();
            if (voiceModel != null) {
                this.HH.uJ(voiceModel.voice_status.intValue());
            }
            this.HH.cpA();
            z = true;
        }
        if (this.eMq.ePK && z) {
            this.eMr.setVisibility(8);
            this.gev.setVisibility(0);
        } else {
            ArrayList<MediaData> aiO = kVar.caz.aiO();
            if (i.ago().isShowImages() && v.getCount(aiO) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aiO.size(); i++) {
                    MediaData mediaData = (MediaData) v.getItem(aiO, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.getCount(linkedList) > 0) {
                    this.eMr.setVisibility(0);
                    this.gev.setVisibility(8);
                    this.eMr.setFromCDN(this.Hx);
                    this.eMr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            ab<k> aZV = a.this.aZV();
                            if (aZV != null) {
                                view.setTag("1");
                                aZV.a(view, a.this.eMq);
                            }
                            if (z2) {
                                a.this.ash();
                            } else {
                                a.this.a(view, linkedList, i2, agG);
                            }
                        }
                    });
                    this.eMr.setImageMediaList(linkedList);
                } else {
                    this.eMr.setVisibility(8);
                    this.gev.setVisibility(0);
                }
            } else {
                this.eMr.setVisibility(8);
                this.gev.setVisibility(0);
            }
        }
        bao();
        setPageUniqueId(getTag());
        bnq();
        mY(lx(1));
    }

    private void iI(boolean z) {
        if (this.eMr != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMr.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.eMr.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.Hx ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aiJ(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Hx, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bhVar.getId();
        historyMessage.threadName = bhVar.getTitle();
        historyMessage.forumName = bhVar.aiJ();
        historyMessage.postID = bhVar.aiU();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void bao() {
        if (!this.eMq.cFI) {
            this.HH.setClickable(false);
        } else {
            this.HH.setClickable(true);
        }
        int childCount = this.eMr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eMr.getChildAt(i);
            if (childAt != null) {
                if (!this.eMq.cFI) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eMr != null) {
            this.eMr.setPageUniqueId(bdUniqueId);
        }
        if (this.geu != null) {
            this.geu.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.geu != null) {
            return this.geu.getHeaderImg();
        }
        return null;
    }

    public View baa() {
        if (this.geu != null) {
            return this.geu.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ash() {
        if (this.eMq != null && this.eMq.caz != null) {
            if (!baf()) {
                n.uz(this.eMq.caz.getId());
                n.a(this.mTitle, this.eMq.agG().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.Fk, this.eMq.caz.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.eMq.caz, null, n.air(), RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.eMq.caz.getFid()));
            createFromThreadCfg.setForumName(this.eMq.caz.aiJ());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean baf() {
        return this.eMq.ePK && !this.eMq.cFI;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean ag(bh bhVar) {
        SpannableStringBuilder s = bhVar.s(false, true);
        if (s == null || StringUtils.isNull(s.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(s));
            this.mTitle.setText(s);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.caz == null || kVar.baJ()) {
            this.Fk.setVisibility(8);
            return;
        }
        bh bhVar = kVar.caz;
        if (lx(2) == 1) {
            SpannableString ake = bhVar.ake();
            if (ake != null && !aq.isEmpty(ake.toString())) {
                this.Fk.setVisibility(0);
                this.Fk.setOnTouchListener(new com.baidu.tieba.view.k(ake));
                this.Fk.setText(ake);
                n.a(this.Fk, bhVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.Fk.setVisibility(8);
            return;
        }
        this.Fk.setVisibility(8);
    }

    private void bnq() {
        if (this.mTitle != null && this.HH != null && this.eMr != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HH.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.HH.setLayoutParams(layoutParams);
            if (this.HH.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eMr.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.eMr.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mY(int i) {
        if (this.eMq != null && this.eMq.caz != null) {
            if (!this.eMq.baJ() && i == 1) {
                this.dSA.setVisibility(8);
                this.dTo.setStType(n.air());
                this.dTo.setData(this.eMq.caz);
                this.geu.et(false);
                return;
            }
            this.dSA.setData(this.eMq.caz);
            this.dSA.setStType(n.air());
            this.dTo.setVisibility(8);
            this.geu.et(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Gc = str;
    }

    public int lx(int i) {
        return com.baidu.tieba.a.d.aDc().X(this.Gc, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eMr != null) {
            this.eMr.setPreloadSizeReadyCallback(bVar);
        }
    }
}
