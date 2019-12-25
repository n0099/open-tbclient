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
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<k> implements e {
    private TextView JZ;
    private String La;
    private final View.OnClickListener MT;
    private boolean Nf;
    public PlayVoiceBntNew Ns;
    private final View.OnClickListener ddt;
    public ThreadSourceShareAndPraiseLayout eIU;
    public ThreadCommentAndPraiseInfoLayout eIh;
    protected LinearLayout ect;
    private HeadPendantClickableView fDG;
    private k fEf;
    private ConstrainImageGroup fEg;
    private View fEh;
    private View.OnClickListener fEl;
    private final View.OnClickListener fEm;
    public ConcernThreadUserInfoLayout gSV;
    public ConcernForumThreadUserInfoLayout gSW;
    public com.baidu.tbadk.core.view.c gSX;
    private View gSY;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Nf = true;
        this.fEl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.brY() != null) {
                    a.this.brY().a(view, a.this.fEf);
                }
                a.this.aJG();
            }
        };
        this.fEm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<k> brY = a.this.brY();
                if (brY != null) {
                    view.setTag("2");
                    brY.a(view, a.this.fEf);
                }
            }
        };
        this.MT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.brY() != null) {
                    a.this.brY().a(view, a.this.fEf);
                }
            }
        };
        this.ddt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.brY() != null) {
                    a.this.brY().a(view, a.this.fEf);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.fDG = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.fDG.getHeadView() != null) {
            this.fDG.getHeadView().setIsRound(true);
            this.fDG.getHeadView().setDrawBorder(false);
            this.fDG.getHeadView().setDefaultResource(17170445);
            this.fDG.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fDG.getHeadView().setPlaceHolder(1);
            this.fDG.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.fDG.getPendantView() != null) {
            this.fDG.getPendantView().setIsRound(true);
            this.fDG.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.Ns = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.Ns.setAfterClickListener(this.fEm);
        this.JZ = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.JZ.setVisibility(8);
        this.fEg = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.fEh = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.fEg.setChildClickListener(this.fEl);
        this.fEg.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fEg.setImageProcessor(fVar);
        this.eIh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.eIh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIh.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eIh.setLayoutParams(layoutParams);
        }
        this.eIh.setOnClickListener(this.fEl);
        this.eIh.setReplyTimeVisible(false);
        this.eIh.setIsBarViewVisible(false);
        this.eIh.setShowPraiseNum(true);
        this.eIh.setNeedAddPraiseIcon(true);
        this.eIh.setNeedAddReplyIcon(true);
        this.eIh.setShareVisible(true);
        this.eIh.setShareReportFrom(4);
        this.eIh.setFrom(9);
        this.eIh.ddq = this.currentPageType;
        this.eIh.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.brY() != null) {
                    a.this.brY().a(view2, a.this.fEf);
                }
                if (a.this.fEf != null && a.this.fEf.cMR != null) {
                    com.baidu.tieba.card.l.zs(a.this.fEf.cMR.getId());
                    a.this.bKF();
                }
            }
        });
        this.eIU = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.eIU.dep.setOnClickListener(this.fEl);
        this.eIU.setShareReportFrom(4);
        this.eIU.setFrom(9);
        this.eIU.dep.ddq = this.currentPageType;
        this.eIU.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.brY() != null) {
                    a.this.brY().a(view2, a.this.fEf);
                }
                if (a.this.fEf != null && a.this.fEf.cMR != null && view2 != a.this.eIU.ddE) {
                    com.baidu.tieba.card.l.zs(a.this.fEf.cMR.getId());
                    a.this.bKF();
                }
            }
        });
        this.ect = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gSY = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.fEg != null) {
            this.fEg.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fEg != null) {
            this.fEg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fEg != null) {
            this.fEg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.fEg.onChangeSkinType();
            this.eIh.onChangeSkinType();
            am.setBackgroundColor(this.fEh, R.color.cp_bg_line_c);
            this.eIU.onChangeSkinType();
        }
        if (this.gSV != null && this.gSV.getVisibility() == 0) {
            this.gSV.onChangeSkinType(i);
        }
        if (this.gSW != null && this.gSW.getVisibility() == 0) {
            this.gSW.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKF() {
        if (this.fEf != null && this.fEf.cMR.getId() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.fEf.axx().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.JZ, this.fEf.cMR.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bKG() {
        if (this.gSV == null) {
            this.gSV = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bKH() {
        if (this.gSW == null) {
            this.gSW = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.gSW.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.brY() != null) {
                    a.this.brY().a(view, a.this.fEf);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.cMR == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.fEf = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fEl);
        }
        if (kVar.bsN()) {
            bKH();
            this.gSX = this.gSW;
            this.gSW.setVisibility(0);
            if (this.gSV != null) {
                this.gSV.setVisibility(8);
            }
        } else {
            bKG();
            this.gSX = this.gSV;
            this.gSV.setVisibility(0);
            if (this.gSW != null) {
                this.gSW.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!bsj() && com.baidu.tieba.card.l.zt(this.fEf.cMR.getId())) {
            bKF();
        }
        final bj axx = kVar.axx();
        if (this.gSX.getHeaderImg() != null) {
            if (this.gSX.getIsSimpleThread()) {
                this.gSX.getHeaderImg().setVisibility(8);
                this.fDG.setVisibility(8);
            } else if (axx.azE() == null || axx.azE().getPendantData() == null || StringUtils.isNull(axx.azE().getPendantData().axX())) {
                this.fDG.setVisibility(8);
                this.gSX.getHeaderImg().setVisibility(0);
                this.gSX.getHeaderImg().setData(axx, !kVar.bsN());
            } else {
                this.gSX.getHeaderImg().setVisibility(4);
                this.fDG.setVisibility(0);
                this.fDG.setData(axx);
            }
        }
        this.gSX.setData(kVar.cMR);
        this.gSX.setUserAfterClickListener(this.MT);
        an(axx);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> azS = kVar.cMR.azS();
        if (v.isEmpty(azS)) {
            this.Ns.setVisibility(8);
            ka(false);
            z = false;
        } else {
            this.Ns.setVisibility(0);
            ka(true);
            VoiceData.VoiceModel voiceModel = azS.get(0);
            this.Ns.setVoiceModel(voiceModel);
            this.Ns.setTag(voiceModel);
            this.Ns.bEM();
            if (voiceModel != null) {
                this.Ns.wL(voiceModel.voice_status.intValue());
            }
            this.Ns.cJE();
            z = true;
        }
        if (this.fEf.fHF && z) {
            this.fEg.setVisibility(8);
            this.gSY.setVisibility(0);
        } else {
            ArrayList<MediaData> azO = kVar.cMR.azO();
            if (i.axf().isShowImages() && v.getCount(azO) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < azO.size(); i++) {
                    MediaData mediaData = (MediaData) v.getItem(azO, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.getCount(linkedList) > 0) {
                    this.fEg.setVisibility(0);
                    this.gSY.setVisibility(8);
                    this.fEg.setFromCDN(this.Nf);
                    this.fEg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            z<k> brY = a.this.brY();
                            if (brY != null) {
                                view.setTag("1");
                                brY.a(view, a.this.fEf);
                            }
                            if (z2) {
                                a.this.aJG();
                            } else {
                                a.this.a(view, linkedList, i2, axx);
                            }
                        }
                    });
                    this.fEg.setImageMediaList(linkedList);
                } else {
                    this.fEg.setVisibility(8);
                    this.gSY.setVisibility(0);
                }
            } else {
                this.fEg.setVisibility(8);
                this.gSY.setVisibility(0);
            }
        }
        bss();
        setPageUniqueId(getTag());
        bEO();
        pp(nL(1));
    }

    private void ka(boolean z) {
        if (this.fEg != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fEg.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.fEg.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.Nf ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.azJ(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.Nf, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bjVar.azJ();
        historyMessage.postID = bjVar.azU();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void bss() {
        if (!this.fEf.dtC) {
            this.Ns.setClickable(false);
        } else {
            this.Ns.setClickable(true);
        }
        int childCount = this.fEg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fEg.getChildAt(i);
            if (childAt != null) {
                if (!this.fEf.dtC) {
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
        if (this.fEg != null) {
            this.fEg.setPageUniqueId(bdUniqueId);
        }
        if (this.gSX != null) {
            this.gSX.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJG() {
        if (this.fEf != null && this.fEf.cMR != null) {
            if (!bsj()) {
                com.baidu.tieba.card.l.zs(this.fEf.cMR.getId());
                com.baidu.tieba.card.l.a(this.mTitle, this.fEf.axx().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                com.baidu.tieba.card.l.a(this.JZ, this.fEf.cMR.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.fEf.cMR, null, com.baidu.tieba.card.l.azq(), RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.fEf.cMR.getFid()));
            createFromThreadCfg.setForumName(this.fEf.cMR.azJ());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setThreadData(this.fEf.cMR);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean bsj() {
        return this.fEf.fHF && !this.fEf.dtC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean an(bj bjVar) {
        SpannableStringBuilder s = bjVar.s(false, true);
        if (s == null || StringUtils.isNull(s.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new h(s));
            this.mTitle.setText(s);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.cMR == null || kVar.bsN()) {
            this.JZ.setVisibility(8);
            return;
        }
        bj bjVar = kVar.cMR;
        if (nL(2) == 1) {
            SpannableString aAw = bjVar.aAw();
            if (aAw != null && !aq.isEmpty(aAw.toString())) {
                this.JZ.setVisibility(0);
                this.JZ.setOnTouchListener(new h(aAw));
                this.JZ.setText(aAw);
                com.baidu.tieba.card.l.a(this.JZ, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.JZ.setVisibility(8);
            return;
        }
        this.JZ.setVisibility(8);
    }

    private void bEO() {
        if (this.mTitle != null && this.Ns != null && this.fEg != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ns.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.Ns.setLayoutParams(layoutParams);
            if (this.Ns.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fEg.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.fEg.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pp(int i) {
        if (this.fEf != null && this.fEf.cMR != null) {
            if (!this.fEf.bsN() && i == 1) {
                this.eIh.setVisibility(8);
                this.eIU.setStType(com.baidu.tieba.card.l.azq());
                this.eIU.setData(this.fEf.cMR);
                this.gSX.fF(false);
                return;
            }
            this.eIh.setData(this.fEf.cMR);
            this.eIh.setStType(com.baidu.tieba.card.l.azq());
            this.eIU.setVisibility(8);
            this.gSX.fF(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    public int nL(int i) {
        return com.baidu.tieba.a.d.aUV().aj(this.La, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fEg != null) {
            this.fEg.setPreloadSizeReadyCallback(bVar);
        }
    }
}
