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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.card.a<k> implements e {
    private TextView Kf;
    private String Lg;
    private final View.OnClickListener MX;
    private boolean Nj;
    public PlayVoiceBntNew Nw;
    private final View.OnClickListener ddE;
    public ThreadCommentAndPraiseInfoLayout eJr;
    public ThreadSourceShareAndPraiseLayout eKe;
    protected LinearLayout ecC;
    private HeadPendantClickableView fGQ;
    private k fHp;
    private ConstrainImageGroup fHq;
    private View fHr;
    private View.OnClickListener fHv;
    private final View.OnClickListener fHw;
    public ConcernThreadUserInfoLayout gWp;
    public ConcernForumThreadUserInfoLayout gWq;
    public com.baidu.tbadk.core.view.c gWr;
    private View gWs;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Nj = true;
        this.fHv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bta() != null) {
                    a.this.bta().a(view, a.this.fHp);
                }
                a.this.aKa();
            }
        };
        this.fHw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<k> bta = a.this.bta();
                if (bta != null) {
                    view.setTag("2");
                    bta.a(view, a.this.fHp);
                }
            }
        };
        this.MX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bta() != null) {
                    a.this.bta().a(view, a.this.fHp);
                }
            }
        };
        this.ddE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bta() != null) {
                    a.this.bta().a(view, a.this.fHp);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.fGQ = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.fGQ.getHeadView() != null) {
            this.fGQ.getHeadView().setIsRound(true);
            this.fGQ.getHeadView().setDrawBorder(false);
            this.fGQ.getHeadView().setDefaultResource(17170445);
            this.fGQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fGQ.getHeadView().setPlaceHolder(1);
            this.fGQ.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.fGQ.getPendantView() != null) {
            this.fGQ.getPendantView().setIsRound(true);
            this.fGQ.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.Nw = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.Nw.setAfterClickListener(this.fHw);
        this.Kf = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.Kf.setVisibility(8);
        this.fHq = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.fHr = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.fHq.setChildClickListener(this.fHv);
        this.fHq.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fHq.setImageProcessor(fVar);
        this.eJr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.eJr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eJr.setLayoutParams(layoutParams);
        }
        this.eJr.setOnClickListener(this.fHv);
        this.eJr.setReplyTimeVisible(false);
        this.eJr.setIsBarViewVisible(false);
        this.eJr.setShowPraiseNum(true);
        this.eJr.setNeedAddPraiseIcon(true);
        this.eJr.setNeedAddReplyIcon(true);
        this.eJr.setShareVisible(true);
        this.eJr.setShareReportFrom(4);
        this.eJr.setFrom(9);
        this.eJr.ddB = this.currentPageType;
        this.eJr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bta() != null) {
                    a.this.bta().a(view2, a.this.fHp);
                }
                if (a.this.fHp != null && a.this.fHp.cNb != null) {
                    com.baidu.tieba.card.l.zC(a.this.fHp.cNb.getId());
                    a.this.bLK();
                }
            }
        });
        this.eKe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.eKe.deA.setOnClickListener(this.fHv);
        this.eKe.setShareReportFrom(4);
        this.eKe.setFrom(9);
        this.eKe.deA.ddB = this.currentPageType;
        this.eKe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bta() != null) {
                    a.this.bta().a(view2, a.this.fHp);
                }
                if (a.this.fHp != null && a.this.fHp.cNb != null && view2 != a.this.eKe.ddO) {
                    com.baidu.tieba.card.l.zC(a.this.fHp.cNb.getId());
                    a.this.bLK();
                }
            }
        });
        this.ecC = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gWs = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.fHq != null) {
            this.fHq.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fHq != null) {
            this.fHq.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fHq != null) {
            this.fHq.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.fHq.onChangeSkinType();
            this.eJr.onChangeSkinType();
            am.setBackgroundColor(this.fHr, R.color.cp_bg_line_c);
            this.eKe.onChangeSkinType();
        }
        if (this.gWp != null && this.gWp.getVisibility() == 0) {
            this.gWp.onChangeSkinType(i);
        }
        if (this.gWq != null && this.gWq.getVisibility() == 0) {
            this.gWq.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLK() {
        if (this.fHp != null && this.fHp.cNb.getId() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.fHp.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.Kf, this.fHp.cNb.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bLL() {
        if (this.gWp == null) {
            this.gWp = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bLM() {
        if (this.gWq == null) {
            this.gWq = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.gWq.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bta() != null) {
                    a.this.bta().a(view, a.this.fHp);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.cNb == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.fHp = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fHv);
        }
        if (kVar.btP()) {
            bLM();
            this.gWr = this.gWq;
            this.gWq.setVisibility(0);
            if (this.gWp != null) {
                this.gWp.setVisibility(8);
            }
        } else {
            bLL();
            this.gWr = this.gWp;
            this.gWp.setVisibility(0);
            if (this.gWq != null) {
                this.gWq.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!btl() && com.baidu.tieba.card.l.zD(this.fHp.cNb.getId())) {
            bLK();
        }
        final bj axQ = kVar.axQ();
        if (this.gWr.getHeaderImg() != null) {
            if (this.gWr.getIsSimpleThread()) {
                this.gWr.getHeaderImg().setVisibility(8);
                this.fGQ.setVisibility(8);
            } else if (axQ.azX() == null || axQ.azX().getPendantData() == null || StringUtils.isNull(axQ.azX().getPendantData().ayq())) {
                this.fGQ.setVisibility(8);
                this.gWr.getHeaderImg().setVisibility(0);
                this.gWr.getHeaderImg().setData(axQ, !kVar.btP());
            } else {
                this.gWr.getHeaderImg().setVisibility(4);
                this.fGQ.setVisibility(0);
                this.fGQ.setData(axQ);
            }
        }
        this.gWr.setData(kVar.cNb);
        this.gWr.setUserAfterClickListener(this.MX);
        ao(axQ);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aAl = kVar.cNb.aAl();
        if (v.isEmpty(aAl)) {
            this.Nw.setVisibility(8);
            kl(false);
            z = false;
        } else {
            this.Nw.setVisibility(0);
            kl(true);
            VoiceData.VoiceModel voiceModel = aAl.get(0);
            this.Nw.setVoiceModel(voiceModel);
            this.Nw.setTag(voiceModel);
            this.Nw.bFO();
            if (voiceModel != null) {
                this.Nw.wQ(voiceModel.voice_status.intValue());
            }
            this.Nw.cKI();
            z = true;
        }
        if (this.fHp.fKP && z) {
            this.fHq.setVisibility(8);
            this.gWs.setVisibility(0);
        } else {
            ArrayList<MediaData> aAh = kVar.cNb.aAh();
            if (i.axy().isShowImages() && v.getCount(aAh) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aAh.size(); i++) {
                    MediaData mediaData = (MediaData) v.getItem(aAh, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.getCount(linkedList) > 0) {
                    this.fHq.setVisibility(0);
                    this.gWs.setVisibility(8);
                    this.fHq.setFromCDN(this.Nj);
                    this.fHq.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            z<k> bta = a.this.bta();
                            if (bta != null) {
                                view.setTag("1");
                                bta.a(view, a.this.fHp);
                            }
                            if (z2) {
                                a.this.aKa();
                            } else {
                                a.this.a(view, linkedList, i2, axQ);
                            }
                        }
                    });
                    this.fHq.setImageMediaList(linkedList);
                } else {
                    this.fHq.setVisibility(8);
                    this.gWs.setVisibility(0);
                }
            } else {
                this.fHq.setVisibility(8);
                this.gWs.setVisibility(0);
            }
        }
        btu();
        setPageUniqueId(getTag());
        bFQ();
        pq(nL(1));
    }

    private void kl(boolean z) {
        if (this.fHq != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHq.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.fHq.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bj bjVar) {
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
                    imageUrlData.urlType = this.Nj ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aAc(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.Nj, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bjVar.getId();
        historyMessage.threadName = bjVar.getTitle();
        historyMessage.forumName = bjVar.aAc();
        historyMessage.postID = bjVar.aAn();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void btu() {
        if (!this.fHp.dtN) {
            this.Nw.setClickable(false);
        } else {
            this.Nw.setClickable(true);
        }
        int childCount = this.fHq.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fHq.getChildAt(i);
            if (childAt != null) {
                if (!this.fHp.dtN) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fHq != null) {
            this.fHq.setPageUniqueId(bdUniqueId);
        }
        if (this.gWr != null) {
            this.gWr.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKa() {
        if (this.fHp != null && this.fHp.cNb != null) {
            if (!btl()) {
                com.baidu.tieba.card.l.zC(this.fHp.cNb.getId());
                com.baidu.tieba.card.l.a(this.mTitle, this.fHp.axQ().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                com.baidu.tieba.card.l.a(this.Kf, this.fHp.cNb.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.fHp.cNb, null, com.baidu.tieba.card.l.azJ(), RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.fHp.cNb.getFid()));
            createFromThreadCfg.setForumName(this.fHp.cNb.aAc());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setThreadData(this.fHp.cNb);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean btl() {
        return this.fHp.fKP && !this.fHp.dtN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean ao(bj bjVar) {
        SpannableStringBuilder r = bjVar.r(false, true);
        if (r == null || StringUtils.isNull(r.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new h(r));
            this.mTitle.setText(r);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.cNb == null || kVar.btP()) {
            this.Kf.setVisibility(8);
            return;
        }
        bj bjVar = kVar.cNb;
        if (nL(2) == 1) {
            SpannableString aAP = bjVar.aAP();
            if (aAP != null && !aq.isEmpty(aAP.toString())) {
                this.Kf.setVisibility(0);
                this.Kf.setOnTouchListener(new h(aAP));
                this.Kf.setText(aAP);
                com.baidu.tieba.card.l.a(this.Kf, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.Kf.setVisibility(8);
            return;
        }
        this.Kf.setVisibility(8);
    }

    private void bFQ() {
        if (this.mTitle != null && this.Nw != null && this.fHq != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Nw.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.Nw.setLayoutParams(layoutParams);
            if (this.Nw.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fHq.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.fHq.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pq(int i) {
        if (this.fHp != null && this.fHp.cNb != null) {
            if (!this.fHp.btP() && i == 1) {
                this.eJr.setVisibility(8);
                this.eKe.setStType(com.baidu.tieba.card.l.azJ());
                this.eKe.setData(this.fHp.cNb);
                this.gWr.fK(false);
                return;
            }
            this.eJr.setData(this.fHp.cNb);
            this.eJr.setStType(com.baidu.tieba.card.l.azJ());
            this.eKe.setVisibility(8);
            this.gWr.fK(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aVo().ak(this.Lg, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fHq != null) {
            this.fHq.setPreloadSizeReadyCallback(bVar);
        }
    }
}
