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
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.a<k> implements e {
    private TextView KA;
    private String LC;
    private boolean NJ;
    public PlayVoiceBntNew NY;
    private final View.OnClickListener Nw;
    private final View.OnClickListener dhI;
    public ThreadSourceShareAndPraiseLayout eNX;
    public ThreadCommentAndPraiseInfoLayout eNl;
    protected LinearLayout egF;
    private k fJM;
    private ConstrainImageGroup fJN;
    private View fJO;
    private View.OnClickListener fJS;
    private final View.OnClickListener fJT;
    private HeadPendantClickableView fJn;
    public ConcernThreadUserInfoLayout gYq;
    public ConcernForumThreadUserInfoLayout gYr;
    public com.baidu.tbadk.core.view.c gYs;
    private View gYt;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.NJ = true;
        this.fJS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buE() != null) {
                    a.this.buE().a(view, a.this.fJM);
                }
                a.this.aMw();
            }
        };
        this.fJT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<k> buE = a.this.buE();
                if (buE != null) {
                    view.setTag("2");
                    buE.a(view, a.this.fJM);
                }
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buE() != null) {
                    a.this.buE().a(view, a.this.fJM);
                }
            }
        };
        this.dhI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buE() != null) {
                    a.this.buE().a(view, a.this.fJM);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.fJn = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.fJn.getHeadView() != null) {
            this.fJn.getHeadView().setIsRound(true);
            this.fJn.getHeadView().setDrawBorder(false);
            this.fJn.getHeadView().setDefaultResource(17170445);
            this.fJn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJn.getHeadView().setPlaceHolder(1);
            this.fJn.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.fJn.getPendantView() != null) {
            this.fJn.getPendantView().setIsRound(true);
            this.fJn.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.NY = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.NY.setAfterClickListener(this.fJT);
        this.KA = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.KA.setVisibility(8);
        this.fJN = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.fJO = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.fJN.setChildClickListener(this.fJS);
        this.fJN.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fJN.setImageProcessor(fVar);
        this.eNl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.eNl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNl.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNl.setLayoutParams(layoutParams);
        }
        this.eNl.setOnClickListener(this.fJS);
        this.eNl.setReplyTimeVisible(false);
        this.eNl.setIsBarViewVisible(false);
        this.eNl.setShowPraiseNum(true);
        this.eNl.setNeedAddPraiseIcon(true);
        this.eNl.setNeedAddReplyIcon(true);
        this.eNl.setShareVisible(true);
        this.eNl.setShareReportFrom(4);
        this.eNl.setFrom(9);
        this.eNl.dhF = this.currentPageType;
        this.eNl.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.buE() != null) {
                    a.this.buE().a(view2, a.this.fJM);
                }
                if (a.this.fJM != null && a.this.fJM.cRe != null) {
                    com.baidu.tieba.card.l.zS(a.this.fJM.cRe.getId());
                    a.this.bNn();
                }
            }
        });
        this.eNX = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.eNX.diG.setOnClickListener(this.fJS);
        this.eNX.setShareReportFrom(4);
        this.eNX.setFrom(9);
        this.eNX.diG.dhF = this.currentPageType;
        this.eNX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.buE() != null) {
                    a.this.buE().a(view2, a.this.fJM);
                }
                if (a.this.fJM != null && a.this.fJM.cRe != null && view2 != a.this.eNX.dhS) {
                    com.baidu.tieba.card.l.zS(a.this.fJM.cRe.getId());
                    a.this.bNn();
                }
            }
        });
        this.egF = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gYt = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.fJN != null) {
            this.fJN.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fJN != null) {
            this.fJN.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fJN != null) {
            this.fJN.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.fJN.onChangeSkinType();
            this.eNl.onChangeSkinType();
            am.setBackgroundColor(this.fJO, R.color.cp_bg_line_c);
            this.eNX.onChangeSkinType();
        }
        if (this.gYq != null && this.gYq.getVisibility() == 0) {
            this.gYq.onChangeSkinType(i);
        }
        if (this.gYr != null && this.gYr.getVisibility() == 0) {
            this.gYr.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNn() {
        if (this.fJM != null && this.fJM.cRe.getId() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.fJM.aAe().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.KA, this.fJM.cRe.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bNo() {
        if (this.gYq == null) {
            this.gYq = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bNp() {
        if (this.gYr == null) {
            this.gYr = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.gYr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buE() != null) {
                    a.this.buE().a(view, a.this.fJM);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.cRe == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.fJM = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fJS);
        }
        if (kVar.bvt()) {
            bNp();
            this.gYs = this.gYr;
            this.gYr.setVisibility(0);
            if (this.gYq != null) {
                this.gYq.setVisibility(8);
            }
        } else {
            bNo();
            this.gYs = this.gYq;
            this.gYq.setVisibility(0);
            if (this.gYr != null) {
                this.gYr.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!buP() && com.baidu.tieba.card.l.zT(this.fJM.cRe.getId())) {
            bNn();
        }
        final bj aAe = kVar.aAe();
        if (this.gYs.getHeaderImg() != null) {
            if (this.gYs.getIsSimpleThread()) {
                this.gYs.getHeaderImg().setVisibility(8);
                this.fJn.setVisibility(8);
            } else if (aAe.aCm() == null || aAe.aCm().getPendantData() == null || StringUtils.isNull(aAe.aCm().getPendantData().aAE())) {
                this.fJn.setVisibility(8);
                this.gYs.getHeaderImg().setVisibility(0);
                this.gYs.getHeaderImg().setData(aAe, !kVar.bvt());
            } else {
                this.gYs.getHeaderImg().setVisibility(4);
                this.fJn.setVisibility(0);
                this.fJn.setData(aAe);
            }
        }
        this.gYs.setData(kVar.cRe);
        this.gYs.setUserAfterClickListener(this.Nw);
        aq(aAe);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aCA = kVar.cRe.aCA();
        if (v.isEmpty(aCA)) {
            this.NY.setVisibility(8);
            kn(false);
            z = false;
        } else {
            this.NY.setVisibility(0);
            kn(true);
            VoiceData.VoiceModel voiceModel = aCA.get(0);
            this.NY.setVoiceModel(voiceModel);
            this.NY.setTag(voiceModel);
            this.NY.bHq();
            if (voiceModel != null) {
                this.NY.wW(voiceModel.voice_status.intValue());
            }
            this.NY.cMf();
            z = true;
        }
        if (this.fJM.fNl && z) {
            this.fJN.setVisibility(8);
            this.gYt.setVisibility(0);
        } else {
            ArrayList<MediaData> aCw = kVar.cRe.aCw();
            if (i.azM().isShowImages() && v.getCount(aCw) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aCw.size(); i++) {
                    MediaData mediaData = (MediaData) v.getItem(aCw, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.getCount(linkedList) > 0) {
                    this.fJN.setVisibility(0);
                    this.gYt.setVisibility(8);
                    this.fJN.setFromCDN(this.NJ);
                    this.fJN.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            z<k> buE = a.this.buE();
                            if (buE != null) {
                                view.setTag("1");
                                buE.a(view, a.this.fJM);
                            }
                            if (z2) {
                                a.this.aMw();
                            } else {
                                a.this.a(view, linkedList, i2, aAe);
                            }
                        }
                    });
                    this.fJN.setImageMediaList(linkedList);
                } else {
                    this.fJN.setVisibility(8);
                    this.gYt.setVisibility(0);
                }
            } else {
                this.fJN.setVisibility(8);
                this.gYt.setVisibility(0);
            }
        }
        buY();
        setPageUniqueId(getTag());
        bHs();
        pB(oc(1));
    }

    private void kn(boolean z) {
        if (this.fJN != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJN.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.fJN.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.NJ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCr(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bjVar.aCr();
        historyMessage.postID = bjVar.aCC();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void buY() {
        if (!this.fJM.dxT) {
            this.NY.setClickable(false);
        } else {
            this.NY.setClickable(true);
        }
        int childCount = this.fJN.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fJN.getChildAt(i);
            if (childAt != null) {
                if (!this.fJM.dxT) {
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
        if (this.fJN != null) {
            this.fJN.setPageUniqueId(bdUniqueId);
        }
        if (this.gYs != null) {
            this.gYs.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMw() {
        if (this.fJM != null && this.fJM.cRe != null) {
            if (!buP()) {
                com.baidu.tieba.card.l.zS(this.fJM.cRe.getId());
                com.baidu.tieba.card.l.a(this.mTitle, this.fJM.aAe().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                com.baidu.tieba.card.l.a(this.KA, this.fJM.cRe.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.fJM.cRe, null, com.baidu.tieba.card.l.aBY(), RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.fJM.cRe.getFid()));
            createFromThreadCfg.setForumName(this.fJM.cRe.aCr());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setThreadData(this.fJM.cRe);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean buP() {
        return this.fJM.fNl && !this.fJM.dxT;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean aq(bj bjVar) {
        SpannableStringBuilder u = bjVar.u(false, true);
        if (u == null || StringUtils.isNull(u.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new h(u));
            this.mTitle.setText(u);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.cRe == null || kVar.bvt()) {
            this.KA.setVisibility(8);
            return;
        }
        bj bjVar = kVar.cRe;
        if (oc(2) == 1) {
            SpannableString aDe = bjVar.aDe();
            if (aDe != null && !aq.isEmpty(aDe.toString())) {
                this.KA.setVisibility(0);
                this.KA.setOnTouchListener(new h(aDe));
                this.KA.setText(aDe);
                com.baidu.tieba.card.l.a(this.KA, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.KA.setVisibility(8);
            return;
        }
        this.KA.setVisibility(8);
    }

    private void bHs() {
        if (this.mTitle != null && this.NY != null && this.fJN != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.NY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.NY.setLayoutParams(layoutParams);
            if (this.NY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fJN.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.fJN.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pB(int i) {
        if (this.fJM != null && this.fJM.cRe != null) {
            if (!this.fJM.bvt() && i == 1) {
                this.eNl.setVisibility(8);
                this.eNX.setStType(com.baidu.tieba.card.l.aBY());
                this.eNX.setData(this.fJM.cRe);
                this.gYs.fR(false);
                return;
            }
            this.eNl.setData(this.fJM.cRe);
            this.eNl.setStType(com.baidu.tieba.card.l.aBY());
            this.eNX.setVisibility(8);
            this.gYs.fR(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXD().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fJN != null) {
            this.fJN.setPreloadSizeReadyCallback(bVar);
        }
    }
}
