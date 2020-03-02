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
    private final View.OnClickListener dhJ;
    public ThreadSourceShareAndPraiseLayout eNY;
    public ThreadCommentAndPraiseInfoLayout eNm;
    protected LinearLayout egG;
    private k fJO;
    private ConstrainImageGroup fJP;
    private View fJQ;
    private View.OnClickListener fJU;
    private final View.OnClickListener fJV;
    private HeadPendantClickableView fJp;
    public ConcernThreadUserInfoLayout gYs;
    public ConcernForumThreadUserInfoLayout gYt;
    public com.baidu.tbadk.core.view.c gYu;
    private View gYv;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.NJ = true;
        this.fJU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buG() != null) {
                    a.this.buG().a(view, a.this.fJO);
                }
                a.this.aMy();
            }
        };
        this.fJV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<k> buG = a.this.buG();
                if (buG != null) {
                    view.setTag("2");
                    buG.a(view, a.this.fJO);
                }
            }
        };
        this.Nw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buG() != null) {
                    a.this.buG().a(view, a.this.fJO);
                }
            }
        };
        this.dhJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buG() != null) {
                    a.this.buG().a(view, a.this.fJO);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.fJp = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.fJp.getHeadView() != null) {
            this.fJp.getHeadView().setIsRound(true);
            this.fJp.getHeadView().setDrawBorder(false);
            this.fJp.getHeadView().setDefaultResource(17170445);
            this.fJp.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fJp.getHeadView().setPlaceHolder(1);
            this.fJp.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.fJp.getPendantView() != null) {
            this.fJp.getPendantView().setIsRound(true);
            this.fJp.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.NY = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.NY.setAfterClickListener(this.fJV);
        this.KA = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.KA.setVisibility(8);
        this.fJP = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.fJQ = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.fJP.setChildClickListener(this.fJU);
        this.fJP.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.fJP.setImageProcessor(fVar);
        this.eNm = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.eNm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNm.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.eNm.setLayoutParams(layoutParams);
        }
        this.eNm.setOnClickListener(this.fJU);
        this.eNm.setReplyTimeVisible(false);
        this.eNm.setIsBarViewVisible(false);
        this.eNm.setShowPraiseNum(true);
        this.eNm.setNeedAddPraiseIcon(true);
        this.eNm.setNeedAddReplyIcon(true);
        this.eNm.setShareVisible(true);
        this.eNm.setShareReportFrom(4);
        this.eNm.setFrom(9);
        this.eNm.dhG = this.currentPageType;
        this.eNm.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.buG() != null) {
                    a.this.buG().a(view2, a.this.fJO);
                }
                if (a.this.fJO != null && a.this.fJO.cRf != null) {
                    com.baidu.tieba.card.l.zS(a.this.fJO.cRf.getId());
                    a.this.bNp();
                }
            }
        });
        this.eNY = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.eNY.diH.setOnClickListener(this.fJU);
        this.eNY.setShareReportFrom(4);
        this.eNY.setFrom(9);
        this.eNY.diH.dhG = this.currentPageType;
        this.eNY.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.buG() != null) {
                    a.this.buG().a(view2, a.this.fJO);
                }
                if (a.this.fJO != null && a.this.fJO.cRf != null && view2 != a.this.eNY.dhT) {
                    com.baidu.tieba.card.l.zS(a.this.fJO.cRf.getId());
                    a.this.bNp();
                }
            }
        });
        this.egG = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gYv = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.fJP != null) {
            this.fJP.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fJP != null) {
            this.fJP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fJP != null) {
            this.fJP.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.fJP.onChangeSkinType();
            this.eNm.onChangeSkinType();
            am.setBackgroundColor(this.fJQ, R.color.cp_bg_line_c);
            this.eNY.onChangeSkinType();
        }
        if (this.gYs != null && this.gYs.getVisibility() == 0) {
            this.gYs.onChangeSkinType(i);
        }
        if (this.gYt != null && this.gYt.getVisibility() == 0) {
            this.gYt.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNp() {
        if (this.fJO != null && this.fJO.cRf.getId() != null) {
            com.baidu.tieba.card.l.a(this.mTitle, this.fJO.aAg().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            com.baidu.tieba.card.l.a(this.KA, this.fJO.cRf.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bNq() {
        if (this.gYs == null) {
            this.gYs = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bNr() {
        if (this.gYt == null) {
            this.gYt = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.gYt.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.buG() != null) {
                    a.this.buG().a(view, a.this.fJO);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.cRf == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.fJO = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fJU);
        }
        if (kVar.bvv()) {
            bNr();
            this.gYu = this.gYt;
            this.gYt.setVisibility(0);
            if (this.gYs != null) {
                this.gYs.setVisibility(8);
            }
        } else {
            bNq();
            this.gYu = this.gYs;
            this.gYs.setVisibility(0);
            if (this.gYt != null) {
                this.gYt.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!buR() && com.baidu.tieba.card.l.zT(this.fJO.cRf.getId())) {
            bNp();
        }
        final bj aAg = kVar.aAg();
        if (this.gYu.getHeaderImg() != null) {
            if (this.gYu.getIsSimpleThread()) {
                this.gYu.getHeaderImg().setVisibility(8);
                this.fJp.setVisibility(8);
            } else if (aAg.aCo() == null || aAg.aCo().getPendantData() == null || StringUtils.isNull(aAg.aCo().getPendantData().aAG())) {
                this.fJp.setVisibility(8);
                this.gYu.getHeaderImg().setVisibility(0);
                this.gYu.getHeaderImg().setData(aAg, !kVar.bvv());
            } else {
                this.gYu.getHeaderImg().setVisibility(4);
                this.fJp.setVisibility(0);
                this.fJp.setData(aAg);
            }
        }
        this.gYu.setData(kVar.cRf);
        this.gYu.setUserAfterClickListener(this.Nw);
        aq(aAg);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aCC = kVar.cRf.aCC();
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
            this.NY.bHs();
            if (voiceModel != null) {
                this.NY.wW(voiceModel.voice_status.intValue());
            }
            this.NY.cMh();
            z = true;
        }
        if (this.fJO.fNn && z) {
            this.fJP.setVisibility(8);
            this.gYv.setVisibility(0);
        } else {
            ArrayList<MediaData> aCy = kVar.cRf.aCy();
            if (i.azO().isShowImages() && v.getCount(aCy) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aCy.size(); i++) {
                    MediaData mediaData = (MediaData) v.getItem(aCy, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.getCount(linkedList) > 0) {
                    this.fJP.setVisibility(0);
                    this.gYv.setVisibility(8);
                    this.fJP.setFromCDN(this.NJ);
                    this.fJP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            z<k> buG = a.this.buG();
                            if (buG != null) {
                                view.setTag("1");
                                buG.a(view, a.this.fJO);
                            }
                            if (z2) {
                                a.this.aMy();
                            } else {
                                a.this.a(view, linkedList, i2, aAg);
                            }
                        }
                    });
                    this.fJP.setImageMediaList(linkedList);
                } else {
                    this.fJP.setVisibility(8);
                    this.gYv.setVisibility(0);
                }
            } else {
                this.fJP.setVisibility(8);
                this.gYv.setVisibility(0);
            }
        }
        bva();
        setPageUniqueId(getTag());
        bHu();
        pB(oc(1));
    }

    private void kn(boolean z) {
        if (this.fJP != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJP.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.fJP.setLayoutParams(layoutParams);
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

    private void bva() {
        if (!this.fJO.dxU) {
            this.NY.setClickable(false);
        } else {
            this.NY.setClickable(true);
        }
        int childCount = this.fJP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fJP.getChildAt(i);
            if (childAt != null) {
                if (!this.fJO.dxU) {
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
        if (this.fJP != null) {
            this.fJP.setPageUniqueId(bdUniqueId);
        }
        if (this.gYu != null) {
            this.gYu.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMy() {
        if (this.fJO != null && this.fJO.cRf != null) {
            if (!buR()) {
                com.baidu.tieba.card.l.zS(this.fJO.cRf.getId());
                com.baidu.tieba.card.l.a(this.mTitle, this.fJO.aAg().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                com.baidu.tieba.card.l.a(this.KA, this.fJO.cRf.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.fJO.cRf, null, com.baidu.tieba.card.l.aCa(), RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.fJO.cRf.getFid()));
            createFromThreadCfg.setForumName(this.fJO.cRf.aCt());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            createFromThreadCfg.setThreadData(this.fJO.cRf);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean buR() {
        return this.fJO.fNn && !this.fJO.dxU;
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
        if (kVar == null || kVar.cRf == null || kVar.bvv()) {
            this.KA.setVisibility(8);
            return;
        }
        bj bjVar = kVar.cRf;
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

    private void bHu() {
        if (this.mTitle != null && this.NY != null && this.fJP != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.NY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.NY.setLayoutParams(layoutParams);
            if (this.NY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fJP.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.fJP.setLayoutParams(layoutParams2);
            }
        }
    }

    public void pB(int i) {
        if (this.fJO != null && this.fJO.cRf != null) {
            if (!this.fJO.bvv() && i == 1) {
                this.eNm.setVisibility(8);
                this.eNY.setStType(com.baidu.tieba.card.l.aCa());
                this.eNY.setData(this.fJO.cRf);
                this.gYu.fR(false);
                return;
            }
            this.eNm.setData(this.fJO.cRf);
            this.eNm.setStType(com.baidu.tieba.card.l.aCa());
            this.eNY.setVisibility(8);
            this.gYu.fR(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    public int oc(int i) {
        return com.baidu.tieba.a.d.aXF().ai(this.LC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fJP != null) {
            this.fJP.setPreloadSizeReadyCallback(bVar);
        }
    }
}
