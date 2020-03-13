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
    private final View.OnClickListener dhW;
    public ThreadCommentAndPraiseInfoLayout eNz;
    public ThreadSourceShareAndPraiseLayout eOl;
    protected LinearLayout egT;
    private HeadPendantClickableView fJC;
    private k fKb;
    private ConstrainImageGroup fKc;
    private View fKd;
    private View.OnClickListener fKh;
    private final View.OnClickListener fKi;
    public ConcernThreadUserInfoLayout gYE;
    public ConcernForumThreadUserInfoLayout gYF;
    public com.baidu.tbadk.core.view.c gYG;
    private View gYH;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.NJ = true;
        this.fKh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buH() != null) {
                    a.this.buH().a(view, a.this.fKb);
                }
                a.this.aMz();
            }
        };
        this.fKi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<k> buH = a.this.buH();
                if (buH != null) {
                    view.setTag("2");
                    buH.a(view, a.this.fKb);
                }
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buH() != null) {
                    a.this.buH().a(view, a.this.fKb);
                }
            }
        };
        this.dhW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buH() != null) {
                    a.this.buH().a(view, a.this.fKb);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.fJC = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.fJC.getHeadView() != null) {
            this.fJC.getHeadView().setIsRound(true);
            this.fJC.getHeadView().setDrawBorder(false);
            this.fJC.getHeadView().setDefaultResource(17170445);
            this.fJC.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJC.getHeadView().setPlaceHolder(1);
            this.fJC.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.fJC.getPendantView() != null) {
            this.fJC.getPendantView().setIsRound(true);
            this.fJC.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.NY = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.NY.setAfterClickListener(this.fKi);
        this.KA = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.KA.setVisibility(8);
        this.fKc = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.fKd = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.fKc.setChildClickListener(this.fKh);
        this.fKc.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fKc.setImageProcessor(fVar);
        this.eNz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.eNz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNz.setLayoutParams(layoutParams);
        }
        this.eNz.setOnClickListener(this.fKh);
        this.eNz.setReplyTimeVisible(false);
        this.eNz.setIsBarViewVisible(false);
        this.eNz.setShowPraiseNum(true);
        this.eNz.setNeedAddPraiseIcon(true);
        this.eNz.setNeedAddReplyIcon(true);
        this.eNz.setShareVisible(true);
        this.eNz.setShareReportFrom(4);
        this.eNz.setFrom(9);
        this.eNz.dhT = this.currentPageType;
        this.eNz.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.buH() != null) {
                    a.this.buH().a(view2, a.this.fKb);
                }
                if (a.this.fKb != null && a.this.fKb.cRg != null) {
                    com.baidu.tieba.card.l.zT(a.this.fKb.cRg.getId());
                    a.this.bNq();
                }
            }
        });
        this.eOl = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.eOl.diU.setOnClickListener(this.fKh);
        this.eOl.setShareReportFrom(4);
        this.eOl.setFrom(9);
        this.eOl.diU.dhT = this.currentPageType;
        this.eOl.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.buH() != null) {
                    a.this.buH().a(view2, a.this.fKb);
                }
                if (a.this.fKb != null && a.this.fKb.cRg != null && view2 != a.this.eOl.dih) {
                    com.baidu.tieba.card.l.zT(a.this.fKb.cRg.getId());
                    a.this.bNq();
                }
            }
        });
        this.egT = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gYH = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.fKc != null) {
            this.fKc.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fKc != null) {
            this.fKc.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fKc != null) {
            this.fKc.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.fKc.onChangeSkinType();
            this.eNz.onChangeSkinType();
            am.setBackgroundColor(this.fKd, R.color.cp_bg_line_c);
            this.eOl.onChangeSkinType();
        }
        if (this.gYE != null && this.gYE.getVisibility() == 0) {
            this.gYE.onChangeSkinType(i);
        }
        if (this.gYF != null && this.gYF.getVisibility() == 0) {
            this.gYF.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNq() {
        if (this.fKb != null && this.fKb.cRg.getId() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.fKb.aAg().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.KA, this.fKb.cRg.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bNr() {
        if (this.gYE == null) {
            this.gYE = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bNs() {
        if (this.gYF == null) {
            this.gYF = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.gYF.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buH() != null) {
                    a.this.buH().a(view, a.this.fKb);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.cRg == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.fKb = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fKh);
        }
        if (kVar.bvw()) {
            bNs();
            this.gYG = this.gYF;
            this.gYF.setVisibility(0);
            if (this.gYE != null) {
                this.gYE.setVisibility(8);
            }
        } else {
            bNr();
            this.gYG = this.gYE;
            this.gYE.setVisibility(0);
            if (this.gYF != null) {
                this.gYF.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!buS() && com.baidu.tieba.card.l.zU(this.fKb.cRg.getId())) {
            bNq();
        }
        final bj aAg = kVar.aAg();
        if (this.gYG.getHeaderImg() != null) {
            if (this.gYG.getIsSimpleThread()) {
                this.gYG.getHeaderImg().setVisibility(8);
                this.fJC.setVisibility(8);
            } else if (aAg.aCo() == null || aAg.aCo().getPendantData() == null || StringUtils.isNull(aAg.aCo().getPendantData().aAG())) {
                this.fJC.setVisibility(8);
                this.gYG.getHeaderImg().setVisibility(0);
                this.gYG.getHeaderImg().setData(aAg, !kVar.bvw());
            } else {
                this.gYG.getHeaderImg().setVisibility(4);
                this.fJC.setVisibility(0);
                this.fJC.setData(aAg);
            }
        }
        this.gYG.setData(kVar.cRg);
        this.gYG.setUserAfterClickListener(this.Nw);
        aq(aAg);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aCC = kVar.cRg.aCC();
        if (v.isEmpty(aCC)) {
            this.NY.setVisibility(8);
            kn(false);
            z = false;
        } else {
            this.NY.setVisibility(0);
            kn(true);
            VoiceData.VoiceModel voiceModel = aCC.get(0);
            this.NY.setVoiceModel(voiceModel);
            this.NY.setTag(voiceModel);
            this.NY.bHt();
            if (voiceModel != null) {
                this.NY.wW(voiceModel.voice_status.intValue());
            }
            this.NY.cMi();
            z = true;
        }
        if (this.fKb.fNA && z) {
            this.fKc.setVisibility(8);
            this.gYH.setVisibility(0);
        } else {
            ArrayList<MediaData> aCy = kVar.cRg.aCy();
            if (i.azO().isShowImages() && v.getCount(aCy) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aCy.size(); i++) {
                    MediaData mediaData = (MediaData) v.getItem(aCy, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.getCount(linkedList) > 0) {
                    this.fKc.setVisibility(0);
                    this.gYH.setVisibility(8);
                    this.fKc.setFromCDN(this.NJ);
                    this.fKc.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            z<k> buH = a.this.buH();
                            if (buH != null) {
                                view.setTag("1");
                                buH.a(view, a.this.fKb);
                            }
                            if (z2) {
                                a.this.aMz();
                            } else {
                                a.this.a(view, linkedList, i2, aAg);
                            }
                        }
                    });
                    this.fKc.setImageMediaList(linkedList);
                } else {
                    this.fKc.setVisibility(8);
                    this.gYH.setVisibility(0);
                }
            } else {
                this.fKc.setVisibility(8);
                this.gYH.setVisibility(0);
            }
        }
        bvb();
        setPageUniqueId(getTag());
        bHv();
        pB(oc(1));
    }

    private void kn(boolean z) {
        if (this.fKc != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKc.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.fKc.setLayoutParams(layoutParams);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCt(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bjVar.aCt();
        historyMessage.postID = bjVar.aCE();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void bvb() {
        if (!this.fKb.dyh) {
            this.NY.setClickable(false);
        } else {
            this.NY.setClickable(true);
        }
        int childCount = this.fKc.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fKc.getChildAt(i);
            if (childAt != null) {
                if (!this.fKb.dyh) {
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
        if (this.fKc != null) {
            this.fKc.setPageUniqueId(bdUniqueId);
        }
        if (this.gYG != null) {
            this.gYG.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMz() {
        if (this.fKb != null && this.fKb.cRg != null) {
            if (!buS()) {
                com.baidu.tieba.card.l.zT(this.fKb.cRg.getId());
                com.baidu.tieba.card.l.a(this.mTitle, this.fKb.aAg().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                com.baidu.tieba.card.l.a(this.KA, this.fKb.cRg.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.fKb.cRg, null, com.baidu.tieba.card.l.aCa(), RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.fKb.cRg.getFid()));
            createFromThreadCfg.setForumName(this.fKb.cRg.aCt());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setThreadData(this.fKb.cRg);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean buS() {
        return this.fKb.fNA && !this.fKb.dyh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean aq(bj bjVar) {
        SpannableStringBuilder v = bjVar.v(false, true);
        if (v == null || StringUtils.isNull(v.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new h(v));
            this.mTitle.setText(v);
            com.baidu.tieba.card.l.a(this.mTitle, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.cRg == null || kVar.bvw()) {
            this.KA.setVisibility(8);
            return;
        }
        bj bjVar = kVar.cRg;
        if (oc(2) == 1) {
            SpannableString aDg = bjVar.aDg();
            if (aDg != null && !aq.isEmpty(aDg.toString())) {
                this.KA.setVisibility(0);
                this.KA.setOnTouchListener(new h(aDg));
                this.KA.setText(aDg);
                com.baidu.tieba.card.l.a(this.KA, bjVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.KA.setVisibility(8);
            return;
        }
        this.KA.setVisibility(8);
    }

    private void bHv() {
        if (this.mTitle != null && this.NY != null && this.fKc != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.NY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.NY.setLayoutParams(layoutParams);
            if (this.NY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fKc.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.fKc.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pB(int i) {
        if (this.fKb != null && this.fKb.cRg != null) {
            if (!this.fKb.bvw() && i == 1) {
                this.eNz.setVisibility(8);
                this.eOl.setStType(com.baidu.tieba.card.l.aCa());
                this.eOl.setData(this.fKb.cRg);
                this.gYG.fR(false);
                return;
            }
            this.eNz.setData(this.fKb.cRg);
            this.eNz.setStType(com.baidu.tieba.card.l.aCa());
            this.eOl.setVisibility(8);
            this.gYG.fR(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXG().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fKc != null) {
            this.fKc.setPreloadSizeReadyCallback(bVar);
        }
    }
}
