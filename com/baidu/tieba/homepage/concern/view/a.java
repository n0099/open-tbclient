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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.a<k> implements e {
    private TextView ady;
    private String aey;
    public PlayVoiceBntNew agG;
    private final View.OnClickListener agi;
    private boolean agt;
    private final View.OnClickListener dIf;
    protected LinearLayout eGZ;
    public ThreadCommentAndPraiseInfoLayout fsr;
    public ThreadSourceShareAndPraiseLayout ftd;
    private HeadPendantClickableView goQ;
    private k gpq;
    private ConstrainImageGroup gpr;
    private View gps;
    private View.OnClickListener gpw;
    private final View.OnClickListener gpx;
    public ConcernThreadUserInfoLayout hJB;
    public ConcernForumThreadUserInfoLayout hJC;
    public com.baidu.tbadk.core.view.c hJD;
    private View hJE;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.agt = true;
        this.gpw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEy() != null) {
                    a.this.bEy().a(view, a.this.gpq);
                }
                a.this.aVa();
            }
        };
        this.gpx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<k> bEy = a.this.bEy();
                if (bEy != null) {
                    view.setTag("2");
                    bEy.a(view, a.this.gpq);
                }
            }
        };
        this.agi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEy() != null) {
                    a.this.bEy().a(view, a.this.gpq);
                }
            }
        };
        this.dIf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEy() != null) {
                    a.this.bEy().a(view, a.this.gpq);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.goQ = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.goQ.getHeadView() != null) {
            this.goQ.getHeadView().setIsRound(true);
            this.goQ.getHeadView().setDrawBorder(false);
            this.goQ.getHeadView().setDefaultResource(17170445);
            this.goQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goQ.getHeadView().setPlaceHolder(1);
            this.goQ.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.goQ.getPendantView() != null) {
            this.goQ.getPendantView().setIsRound(true);
            this.goQ.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.agG = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.agG.setAfterClickListener(this.gpx);
        this.ady = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.ady.setVisibility(8);
        this.gpr = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.gps = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.gpr.setChildClickListener(this.gpw);
        this.gpr.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.n(1.0d);
        this.gpr.setImageProcessor(fVar);
        this.fsr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.fsr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsr.setLayoutParams(layoutParams);
        }
        this.fsr.setOnClickListener(this.gpw);
        this.fsr.setReplyTimeVisible(false);
        this.fsr.setIsBarViewVisible(false);
        this.fsr.setShowPraiseNum(true);
        this.fsr.setNeedAddPraiseIcon(true);
        this.fsr.setNeedAddReplyIcon(true);
        this.fsr.setShareVisible(true);
        this.fsr.setShareReportFrom(4);
        this.fsr.setFrom(9);
        this.fsr.dIc = this.currentPageType;
        this.fsr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bEy() != null) {
                    a.this.bEy().a(view2, a.this.gpq);
                }
                if (a.this.gpq != null && a.this.gpq.dqA != null) {
                    com.baidu.tieba.card.l.BB(a.this.gpq.dqA.getId());
                    a.this.bYf();
                }
            }
        });
        this.ftd = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.ftd.dJa.setOnClickListener(this.gpw);
        this.ftd.setShareReportFrom(4);
        this.ftd.setFrom(9);
        this.ftd.dJa.dIc = this.currentPageType;
        this.ftd.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bEy() != null) {
                    a.this.bEy().a(view2, a.this.gpq);
                }
                if (a.this.gpq != null && a.this.gpq.dqA != null && view2 != a.this.ftd.dIp) {
                    com.baidu.tieba.card.l.BB(a.this.gpq.dqA.getId());
                    a.this.bYf();
                }
            }
        });
        this.eGZ = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.hJE = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.gpr != null) {
            this.gpr.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpr != null) {
            this.gpr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpr != null) {
            this.gpr.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.gpr.onChangeSkinType();
            this.fsr.onChangeSkinType();
            am.setBackgroundColor(this.gps, R.color.cp_bg_line_c);
            this.ftd.onChangeSkinType();
        }
        if (this.hJB != null && this.hJB.getVisibility() == 0) {
            this.hJB.onChangeSkinType(i);
        }
        if (this.hJC != null && this.hJC.getVisibility() == 0) {
            this.hJC.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYf() {
        if (this.gpq != null && this.gpq.dqA.getId() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.gpq.aIw().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.ady, this.gpq.dqA.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bYg() {
        if (this.hJB == null) {
            this.hJB = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bYh() {
        if (this.hJC == null) {
            this.hJC = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.hJC.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEy() != null) {
                    a.this.bEy().a(view, a.this.gpq);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.dqA == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.gpq = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gpw);
        }
        if (kVar.bFm()) {
            bYh();
            this.hJD = this.hJC;
            this.hJC.setVisibility(0);
            if (this.hJB != null) {
                this.hJB.setVisibility(8);
            }
        } else {
            bYg();
            this.hJD = this.hJB;
            this.hJB.setVisibility(0);
            if (this.hJC != null) {
                this.hJC.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!bEJ() && com.baidu.tieba.card.l.BC(this.gpq.dqA.getId())) {
            bYf();
        }
        final bj aIw = kVar.aIw();
        if (this.hJD.getHeaderImg() != null) {
            if (this.hJD.getIsSimpleThread()) {
                this.hJD.getHeaderImg().setVisibility(8);
                this.goQ.setVisibility(8);
            } else if (aIw.aKE() == null || aIw.aKE().getPendantData() == null || StringUtils.isNull(aIw.aKE().getPendantData().aIW())) {
                this.goQ.setVisibility(8);
                this.hJD.getHeaderImg().setVisibility(0);
                this.hJD.getHeaderImg().setData(aIw, !kVar.bFm());
            } else {
                this.hJD.getHeaderImg().setVisibility(4);
                this.goQ.setVisibility(0);
                this.goQ.setData(aIw);
            }
        }
        this.hJD.setData(kVar.dqA);
        this.hJD.setUserAfterClickListener(this.agi);
        as(aIw);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aKS = kVar.dqA.aKS();
        if (v.isEmpty(aKS)) {
            this.agG.setVisibility(8);
            lv(false);
            z = false;
        } else {
            this.agG.setVisibility(0);
            lv(true);
            VoiceData.VoiceModel voiceModel = aKS.get(0);
            this.agG.setVoiceModel(voiceModel);
            this.agG.setTag(voiceModel);
            this.agG.ckO();
            if (voiceModel != null) {
                this.agG.xC(voiceModel.voice_status.intValue());
            }
            this.agG.cXz();
            z = true;
        }
        if (this.gpq.gsP && z) {
            this.gpr.setVisibility(8);
            this.hJE.setVisibility(0);
        } else {
            ArrayList<MediaData> aKO = kVar.dqA.aKO();
            if (i.aIe().isShowImages() && v.getCount(aKO) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aKO.size(); i++) {
                    MediaData mediaData = (MediaData) v.getItem(aKO, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.getCount(linkedList) > 0) {
                    this.gpr.setVisibility(0);
                    this.hJE.setVisibility(8);
                    this.gpr.setFromCDN(this.agt);
                    this.gpr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            z<k> bEy = a.this.bEy();
                            if (bEy != null) {
                                view.setTag("1");
                                bEy.a(view, a.this.gpq);
                            }
                            if (z2) {
                                a.this.aVa();
                            } else {
                                a.this.a(view, linkedList, i2, aIw);
                            }
                        }
                    });
                    this.gpr.setImageMediaList(linkedList);
                } else {
                    this.gpr.setVisibility(8);
                    this.hJE.setVisibility(0);
                }
            } else {
                this.gpr.setVisibility(8);
                this.hJE.setVisibility(0);
            }
        }
        bES();
        setPageUniqueId(getTag());
        bSg();
        pX(or(1));
    }

    private void lv(boolean z) {
        if (this.gpr != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gpr.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.gpr.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.agt ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aKJ(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.agt, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bjVar.aKJ();
        historyMessage.postID = bjVar.aKU();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void bES() {
        if (!this.gpq.dYb) {
            this.agG.setClickable(false);
        } else {
            this.agG.setClickable(true);
        }
        int childCount = this.gpr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gpr.getChildAt(i);
            if (childAt != null) {
                if (!this.gpq.dYb) {
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
        if (this.gpr != null) {
            this.gpr.setPageUniqueId(bdUniqueId);
        }
        if (this.hJD != null) {
            this.hJD.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVa() {
        if (this.gpq != null && this.gpq.dqA != null) {
            if (!bEJ()) {
                com.baidu.tieba.card.l.BB(this.gpq.dqA.getId());
                com.baidu.tieba.card.l.a(this.mTitle, this.gpq.aIw().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                com.baidu.tieba.card.l.a(this.ady, this.gpq.dqA.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.gpq.dqA, null, com.baidu.tieba.card.l.aKq(), RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.gpq.dqA.getFid()));
            createFromThreadCfg.setForumName(this.gpq.dqA.aKJ());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setThreadData(this.gpq.dqA);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean bEJ() {
        return this.gpq.gsP && !this.gpq.dYb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean as(bj bjVar) {
        SpannableStringBuilder u = bjVar.u(false, true);
        if (u == null || StringUtils.isNull(u.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(u));
            this.mTitle.setText(u);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.dqA == null || kVar.bFm()) {
            this.ady.setVisibility(8);
            return;
        }
        bj bjVar = kVar.dqA;
        if (or(2) == 1) {
            SpannableString aLw = bjVar.aLw();
            if (aLw != null && !aq.isEmpty(aLw.toString())) {
                this.ady.setVisibility(0);
                this.ady.setOnTouchListener(new com.baidu.tieba.view.i(aLw));
                this.ady.setText(aLw);
                com.baidu.tieba.card.l.a(this.ady, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.ady.setVisibility(8);
            return;
        }
        this.ady.setVisibility(8);
    }

    private void bSg() {
        if (this.mTitle != null && this.agG != null && this.gpr != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agG.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.agG.setLayoutParams(layoutParams);
            if (this.agG.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gpr.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.gpr.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pX(int i) {
        if (this.gpq != null && this.gpq.dqA != null) {
            if (!this.gpq.bFm() && i == 1) {
                this.fsr.setVisibility(8);
                this.ftd.setStType(com.baidu.tieba.card.l.aKq());
                this.ftd.setData(this.gpq.dqA);
                this.hJD.gQ(false);
                return;
            }
            this.fsr.setData(this.gpq.dqA);
            this.fsr.setStType(com.baidu.tieba.card.l.aKq());
            this.ftd.setVisibility(8);
            this.hJD.gQ(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfP().ar(this.aey, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.gpr != null) {
            this.gpr.setPreloadSizeReadyCallback(bVar);
        }
    }
}
