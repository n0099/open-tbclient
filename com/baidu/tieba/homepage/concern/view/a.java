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
    private TextView VW;
    private String WN;
    private final View.OnClickListener XU;
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    private final View.OnClickListener caw;
    public ThreadCommentAndPraiseInfoLayout dEB;
    public ThreadSourceShareAndPraiseLayout dFo;
    protected LinearLayout dFz;
    private k eCL;
    private ConstrainImageGroup eCM;
    private View eCN;
    private View.OnClickListener eCR;
    private final View.OnClickListener eCS;
    private HeadPendantClickableView eCk;
    public ConcernThreadUserInfoLayout gde;
    public ConcernForumThreadUserInfoLayout gdf;
    public d gdg;
    private View gdh;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Yd = true;
        this.eCR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view, a.this.eCL);
                }
                a.this.aqb();
            }
        };
        this.eCS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aZo = a.this.aZo();
                if (aZo != null) {
                    view.setTag("2");
                    aZo.a(view, a.this.eCL);
                }
            }
        };
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view, a.this.eCL);
                }
            }
        };
        this.caw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view, a.this.eCL);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.eCk = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.eCk.getHeadView() != null) {
            this.eCk.getHeadView().setIsRound(true);
            this.eCk.getHeadView().setDrawBorder(false);
            this.eCk.getHeadView().setDefaultResource(17170445);
            this.eCk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eCk.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.eCk.getHeadView().setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.eCk.getPendantView() != null) {
            this.eCk.getPendantView().setIsRound(true);
            this.eCk.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.Ym = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.Ym.setAfterClickListener(this.eCS);
        this.VW = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.VW.setVisibility(8);
        this.eCM = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.eCN = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.eCM.setChildClickListener(this.eCR);
        this.eCM.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.eCM.setImageProcessor(fVar);
        this.dEB = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.dEB.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEB.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dEB.setLayoutParams(layoutParams);
        }
        this.dEB.setOnClickListener(this.eCR);
        this.dEB.setReplyTimeVisible(false);
        this.dEB.setIsBarViewVisible(false);
        this.dEB.setShowPraiseNum(true);
        this.dEB.setNeedAddPraiseIcon(true);
        this.dEB.setNeedAddReplyIcon(true);
        this.dEB.setShareVisible(true);
        this.dEB.setShareReportFrom(4);
        this.dEB.setFrom(9);
        this.dEB.setDisPraiseFrom(4);
        this.dEB.cbF = this.currentPageType;
        this.dEB.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view2, a.this.eCL);
                }
                if (a.this.eCL != null && a.this.eCL.threadData != null) {
                    n.vw(a.this.eCL.threadData.getId());
                    a.this.buZ();
                }
            }
        });
        this.dFo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.dFo.ccA.setOnClickListener(this.eCR);
        this.dFo.setShareReportFrom(4);
        this.dFo.setFrom(9);
        this.dFo.ccA.cbF = this.currentPageType;
        this.dFo.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view2, a.this.eCL);
                }
                if (a.this.eCL != null && a.this.eCL.threadData != null && view2 != a.this.dFo.cbO) {
                    n.vw(a.this.eCL.threadData.getId());
                    a.this.buZ();
                }
            }
        });
        this.dFz = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gdh = view.findViewById(R.id.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eCM != null) {
            this.eCM.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCM != null) {
            this.eCM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCM != null) {
            this.eCM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.addresslist_item_bg);
            this.eCM.onChangeSkinType();
            this.dEB.onChangeSkinType();
            am.l(this.eCN, R.color.cp_bg_line_e);
            this.dFo.onChangeSkinType();
        }
        if (this.gde != null && this.gde.getVisibility() == 0) {
            this.gde.onChangeSkinType(i);
        }
        if (this.gdf != null && this.gdf.getVisibility() == 0) {
            this.gdf.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buZ() {
        if (this.eCL != null && this.eCL.threadData.getId() != null) {
            n.a(this.mTitle, this.eCL.acx().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VW, this.eCL.threadData.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void bva() {
        if (this.gde == null) {
            this.gde = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bvb() {
        if (this.gdf == null) {
            this.gdf = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.gdf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view, a.this.eCL);
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
        this.eCL = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eCR);
        }
        if (kVar.bad()) {
            bvb();
            this.gdg = this.gdf;
            this.gdf.setVisibility(0);
            if (this.gde != null) {
                this.gde.setVisibility(8);
            }
        } else {
            bva();
            this.gdg = this.gde;
            this.gde.setVisibility(0);
            if (this.gdf != null) {
                this.gdf.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aZy() && n.vx(this.eCL.threadData.getId())) {
            buZ();
        }
        final bg acx = kVar.acx();
        if (this.gdg.getHeaderImg() != null) {
            if (this.gdg.getIsSimpleThread()) {
                this.gdg.getHeaderImg().setVisibility(8);
                this.eCk.setVisibility(8);
            } else if (acx.aex() == null || acx.aex().getPendantData() == null || StringUtils.isNull(acx.aex().getPendantData().acU())) {
                this.eCk.setVisibility(8);
                this.gdg.getHeaderImg().setVisibility(0);
                this.gdg.getHeaderImg().setData(acx, !kVar.bad());
            } else {
                this.gdg.getHeaderImg().setVisibility(4);
                this.eCk.setVisibility(0);
                this.eCk.setData(acx);
            }
        }
        this.gdg.setData(kVar.threadData);
        this.gdg.setUserAfterClickListener(this.XU);
        ag(acx);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aeL = kVar.threadData.aeL();
        if (v.aa(aeL)) {
            this.Ym.setVisibility(8);
            iC(false);
            z = false;
        } else {
            this.Ym.setVisibility(0);
            iC(true);
            VoiceData.VoiceModel voiceModel = aeL.get(0);
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bIl();
            if (voiceModel != null) {
                this.Ym.vY(voiceModel.voice_status.intValue());
            }
            this.Ym.cqz();
            z = true;
        }
        if (this.eCL.eGg && z) {
            this.eCM.setVisibility(8);
            this.gdh.setVisibility(0);
        } else {
            ArrayList<MediaData> aeH = kVar.threadData.aeH();
            if (i.aca().ace() && v.Z(aeH) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < aeH.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(aeH, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.Z(linkedList) > 0) {
                    this.eCM.setVisibility(0);
                    this.gdh.setVisibility(8);
                    this.eCM.setFromCDN(this.Yd);
                    this.eCM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void a(View view, int i2, boolean z2) {
                            ab<k> aZo = a.this.aZo();
                            if (aZo != null) {
                                view.setTag("1");
                                aZo.a(view, a.this.eCL);
                            }
                            if (z2) {
                                a.this.aqb();
                            } else {
                                a.this.a(view, linkedList, i2, acx);
                            }
                        }
                    });
                    this.eCM.setImageMediaList(linkedList);
                } else {
                    this.eCM.setVisibility(8);
                    this.gdh.setVisibility(0);
                }
            } else {
                this.eCM.setVisibility(8);
                this.gdh.setVisibility(0);
            }
        }
        aZH();
        setPageUniqueId(getTag());
        bpo();
        nE(mo(1));
    }

    private void iC(boolean z) {
        if (this.eCM != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCM.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.eCM.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
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
                    imageUrlData.urlType = this.Yd ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bgVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.aeC(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mPageContext;
        historyMessage.threadId = bgVar.getId();
        historyMessage.threadName = bgVar.getTitle();
        historyMessage.forumName = bgVar.aeC();
        historyMessage.postID = bgVar.aeN();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    private void aZH() {
        if (!this.eCL.ctn) {
            this.Ym.setClickable(false);
        } else {
            this.Ym.setClickable(true);
        }
        int childCount = this.eCM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eCM.getChildAt(i);
            if (childAt != null) {
                if (!this.eCL.ctn) {
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
        if (this.eCM != null) {
            this.eCM.setPageUniqueId(bdUniqueId);
        }
        if (this.gdg != null) {
            this.gdg.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gdg != null) {
            return this.gdg.getHeaderImg();
        }
        return null;
    }

    public View aZt() {
        if (this.gdg != null) {
            return this.gdg.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqb() {
        if (this.eCL != null && this.eCL.threadData != null) {
            if (!aZy()) {
                n.vw(this.eCL.threadData.getId());
                n.a(this.mTitle, this.eCL.acx().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.VW, this.eCL.threadData.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.eCL.threadData, null, n.aek(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.eCL.threadData.getFid()));
            createFromThreadCfg.setForumName(this.eCL.threadData.aeC());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aZy() {
        return this.eCL.eGg && !this.eCL.ctn;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean ag(bg bgVar) {
        SpannableStringBuilder o = bgVar.o(false, true);
        if (o == null || StringUtils.isNull(o.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(o));
            this.mTitle.setText(o);
            n.a(this.mTitle, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.bad()) {
            this.VW.setVisibility(8);
            return;
        }
        bg bgVar = kVar.threadData;
        if (mo(2) == 1) {
            SpannableString afY = bgVar.afY();
            if (afY != null && !aq.isEmpty(afY.toString())) {
                this.VW.setVisibility(0);
                this.VW.setOnTouchListener(new com.baidu.tieba.view.k(afY));
                this.VW.setText(afY);
                n.a(this.VW, bgVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.VW.setVisibility(8);
            return;
        }
        this.VW.setVisibility(8);
    }

    private void bpo() {
        if (this.mTitle != null && this.Ym != null && this.eCM != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ym.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.Ym.setLayoutParams(layoutParams);
            if (this.Ym.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eCM.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.eCM.setLayoutParams(layoutParams2);
            }
        }
    }

    public void nE(int i) {
        if (this.eCL != null && this.eCL.threadData != null) {
            if (!this.eCL.bad() && i == 1) {
                this.dEB.setVisibility(8);
                this.dFo.setStType(n.aek());
                this.dFo.setData(this.eCL.threadData);
                this.gdg.en(false);
                return;
            }
            this.dEB.setData(this.eCL.threadData);
            this.dEB.setStType(n.aek());
            this.dFo.setVisibility(8);
            this.gdg.en(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    public int mo(int i) {
        return com.baidu.tieba.a.d.aCF().ag(this.WN, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eCM != null) {
            this.eCM.setPreloadSizeReadyCallback(bVar);
        }
    }
}
