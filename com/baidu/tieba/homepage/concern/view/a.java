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
    private TextView adB;
    private String aeB;
    public PlayVoiceBntNew agJ;
    private final View.OnClickListener agl;
    private boolean agw;
    private final View.OnClickListener dIj;
    protected LinearLayout eHe;
    public ThreadCommentAndPraiseInfoLayout fsw;
    public ThreadSourceShareAndPraiseLayout fti;
    private HeadPendantClickableView goW;
    private View.OnClickListener gpC;
    private final View.OnClickListener gpD;
    private k gpw;
    private ConstrainImageGroup gpx;
    private View gpy;
    public ConcernThreadUserInfoLayout hJH;
    public ConcernForumThreadUserInfoLayout hJI;
    public com.baidu.tbadk.core.view.c hJJ;
    private View hJK;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.agw = true;
        this.gpC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEw() != null) {
                    a.this.bEw().a(view, a.this.gpw);
                }
                a.this.aUY();
            }
        };
        this.gpD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<k> bEw = a.this.bEw();
                if (bEw != null) {
                    view.setTag("2");
                    bEw.a(view, a.this.gpw);
                }
            }
        };
        this.agl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEw() != null) {
                    a.this.bEw().a(view, a.this.gpw);
                }
            }
        };
        this.dIj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEw() != null) {
                    a.this.bEw().a(view, a.this.gpw);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.goW = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.goW.getHeadView() != null) {
            this.goW.getHeadView().setIsRound(true);
            this.goW.getHeadView().setDrawBorder(false);
            this.goW.getHeadView().setDefaultResource(17170445);
            this.goW.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.goW.getHeadView().setPlaceHolder(1);
            this.goW.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.goW.getPendantView() != null) {
            this.goW.getPendantView().setIsRound(true);
            this.goW.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.agJ = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.agJ.setAfterClickListener(this.gpD);
        this.adB = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.adB.setVisibility(8);
        this.gpx = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.gpy = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.gpx.setChildClickListener(this.gpC);
        this.gpx.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.n(1.0d);
        this.gpx.setImageProcessor(fVar);
        this.fsw = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.fsw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsw.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.fsw.setLayoutParams(layoutParams);
        }
        this.fsw.setOnClickListener(this.gpC);
        this.fsw.setReplyTimeVisible(false);
        this.fsw.setIsBarViewVisible(false);
        this.fsw.setShowPraiseNum(true);
        this.fsw.setNeedAddPraiseIcon(true);
        this.fsw.setNeedAddReplyIcon(true);
        this.fsw.setShareVisible(true);
        this.fsw.setShareReportFrom(4);
        this.fsw.setFrom(9);
        this.fsw.dIg = this.currentPageType;
        this.fsw.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bEw() != null) {
                    a.this.bEw().a(view2, a.this.gpw);
                }
                if (a.this.gpw != null && a.this.gpw.dqE != null) {
                    com.baidu.tieba.card.l.BE(a.this.gpw.dqE.getId());
                    a.this.bYd();
                }
            }
        });
        this.fti = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.fti.dJe.setOnClickListener(this.gpC);
        this.fti.setShareReportFrom(4);
        this.fti.setFrom(9);
        this.fti.dJe.dIg = this.currentPageType;
        this.fti.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bEw() != null) {
                    a.this.bEw().a(view2, a.this.gpw);
                }
                if (a.this.gpw != null && a.this.gpw.dqE != null && view2 != a.this.fti.dIt) {
                    com.baidu.tieba.card.l.BE(a.this.gpw.dqE.getId());
                    a.this.bYd();
                }
            }
        });
        this.eHe = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.hJK = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.gpx != null) {
            this.gpx.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpx != null) {
            this.gpx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpx != null) {
            this.gpx.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.gpx.onChangeSkinType();
            this.fsw.onChangeSkinType();
            am.setBackgroundColor(this.gpy, R.color.cp_bg_line_c);
            this.fti.onChangeSkinType();
        }
        if (this.hJH != null && this.hJH.getVisibility() == 0) {
            this.hJH.onChangeSkinType(i);
        }
        if (this.hJI != null && this.hJI.getVisibility() == 0) {
            this.hJI.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYd() {
        if (this.gpw != null && this.gpw.dqE.getId() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.gpw.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.adB, this.gpw.dqE.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bYe() {
        if (this.hJH == null) {
            this.hJH = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bYf() {
        if (this.hJI == null) {
            this.hJI = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.hJI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bEw() != null) {
                    a.this.bEw().a(view, a.this.gpw);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.dqE == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.gpw = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.gpC);
        }
        if (kVar.bFk()) {
            bYf();
            this.hJJ = this.hJI;
            this.hJI.setVisibility(0);
            if (this.hJH != null) {
                this.hJH.setVisibility(8);
            }
        } else {
            bYe();
            this.hJJ = this.hJH;
            this.hJH.setVisibility(0);
            if (this.hJI != null) {
                this.hJI.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!bEH() && com.baidu.tieba.card.l.BF(this.gpw.dqE.getId())) {
            bYd();
        }
        final bj aIu = kVar.aIu();
        if (this.hJJ.getHeaderImg() != null) {
            if (this.hJJ.getIsSimpleThread()) {
                this.hJJ.getHeaderImg().setVisibility(8);
                this.goW.setVisibility(8);
            } else if (aIu.aKC() == null || aIu.aKC().getPendantData() == null || StringUtils.isNull(aIu.aKC().getPendantData().aIU())) {
                this.goW.setVisibility(8);
                this.hJJ.getHeaderImg().setVisibility(0);
                this.hJJ.getHeaderImg().setData(aIu, !kVar.bFk());
            } else {
                this.hJJ.getHeaderImg().setVisibility(4);
                this.goW.setVisibility(0);
                this.goW.setData(aIu);
            }
        }
        this.hJJ.setData(kVar.dqE);
        this.hJJ.setUserAfterClickListener(this.agl);
        as(aIu);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aKQ = kVar.dqE.aKQ();
        if (v.isEmpty(aKQ)) {
            this.agJ.setVisibility(8);
            lv(false);
            z = false;
        } else {
            this.agJ.setVisibility(0);
            lv(true);
            VoiceData.VoiceModel voiceModel = aKQ.get(0);
            this.agJ.setVoiceModel(voiceModel);
            this.agJ.setTag(voiceModel);
            this.agJ.ckM();
            if (voiceModel != null) {
                this.agJ.xC(voiceModel.voice_status.intValue());
            }
            this.agJ.cXw();
            z = true;
        }
        if (this.gpw.gsV && z) {
            this.gpx.setVisibility(8);
            this.hJK.setVisibility(0);
        } else {
            ArrayList<MediaData> aKM = kVar.dqE.aKM();
            if (i.aIc().isShowImages() && v.getCount(aKM) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aKM.size(); i++) {
                    MediaData mediaData = (MediaData) v.getItem(aKM, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.getCount(linkedList) > 0) {
                    this.gpx.setVisibility(0);
                    this.hJK.setVisibility(8);
                    this.gpx.setFromCDN(this.agw);
                    this.gpx.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            z<k> bEw = a.this.bEw();
                            if (bEw != null) {
                                view.setTag("1");
                                bEw.a(view, a.this.gpw);
                            }
                            if (z2) {
                                a.this.aUY();
                            } else {
                                a.this.a(view, linkedList, i2, aIu);
                            }
                        }
                    });
                    this.gpx.setImageMediaList(linkedList);
                } else {
                    this.gpx.setVisibility(8);
                    this.hJK.setVisibility(0);
                }
            } else {
                this.gpx.setVisibility(8);
                this.hJK.setVisibility(0);
            }
        }
        bEQ();
        setPageUniqueId(getTag());
        bSe();
        pX(or(1));
    }

    private void lv(boolean z) {
        if (this.gpx != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gpx.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.gpx.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.agw ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aKH(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.agw, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bjVar.aKH();
        historyMessage.postID = bjVar.aKS();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void bEQ() {
        if (!this.gpw.dYg) {
            this.agJ.setClickable(false);
        } else {
            this.agJ.setClickable(true);
        }
        int childCount = this.gpx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gpx.getChildAt(i);
            if (childAt != null) {
                if (!this.gpw.dYg) {
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
        if (this.gpx != null) {
            this.gpx.setPageUniqueId(bdUniqueId);
        }
        if (this.hJJ != null) {
            this.hJJ.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUY() {
        if (this.gpw != null && this.gpw.dqE != null) {
            if (!bEH()) {
                com.baidu.tieba.card.l.BE(this.gpw.dqE.getId());
                com.baidu.tieba.card.l.a(this.mTitle, this.gpw.aIu().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                com.baidu.tieba.card.l.a(this.adB, this.gpw.dqE.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.gpw.dqE, null, com.baidu.tieba.card.l.aKo(), RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.gpw.dqE.getFid()));
            createFromThreadCfg.setForumName(this.gpw.dqE.aKH());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setThreadData(this.gpw.dqE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean bEH() {
        return this.gpw.gsV && !this.gpw.dYg;
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
        if (kVar == null || kVar.dqE == null || kVar.bFk()) {
            this.adB.setVisibility(8);
            return;
        }
        bj bjVar = kVar.dqE;
        if (or(2) == 1) {
            SpannableString aLu = bjVar.aLu();
            if (aLu != null && !aq.isEmpty(aLu.toString())) {
                this.adB.setVisibility(0);
                this.adB.setOnTouchListener(new com.baidu.tieba.view.i(aLu));
                this.adB.setText(aLu);
                com.baidu.tieba.card.l.a(this.adB, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.adB.setVisibility(8);
            return;
        }
        this.adB.setVisibility(8);
    }

    private void bSe() {
        if (this.mTitle != null && this.agJ != null && this.gpx != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agJ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.agJ.setLayoutParams(layoutParams);
            if (this.agJ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gpx.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.gpx.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pX(int i) {
        if (this.gpw != null && this.gpw.dqE != null) {
            if (!this.gpw.bFk() && i == 1) {
                this.fsw.setVisibility(8);
                this.fti.setStType(com.baidu.tieba.card.l.aKo());
                this.fti.setData(this.gpw.dqE);
                this.hJJ.gQ(false);
                return;
            }
            this.fsw.setData(this.gpw.dqE);
            this.fsw.setStType(com.baidu.tieba.card.l.aKo());
            this.fti.setVisibility(8);
            this.hJJ.gQ(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    public int or(int i) {
        return com.baidu.tieba.a.d.bfN().ar(this.aeB, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.gpx != null) {
            this.gpx.setPreloadSizeReadyCallback(bVar);
        }
    }
}
