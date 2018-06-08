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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<k> implements com.baidu.tieba.a.e {
    private boolean asK;
    private final View.OnClickListener axg;
    private final View.OnClickListener axr;
    private String bER;
    private HeadPendantClickableView bFP;
    public ThreadSourceShareAndPraiseLayout bFT;
    public ThreadCommentAndPraiseInfoLayout bFe;
    protected LinearLayout bGe;
    private View cvN;
    private k cvO;
    private View.OnClickListener cvP;
    public PlayVoiceBntNew cyE;
    private TextView cyG;
    private ConstrainImageGroup cyH;
    private final View.OnClickListener cyK;
    public ConcernThreadUserInfoLayout dNK;
    public ConcernForumThreadUserInfoLayout dNN;
    public com.baidu.tbadk.core.view.b dNO;
    private View dNP;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.asK = true;
        this.cvP = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiI() != null) {
                    b.this.aiI().a(view, b.this.cvO);
                }
                b.this.ajb();
            }
        };
        this.cyK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aiI = b.this.aiI();
                if (aiI != null) {
                    view.setTag("2");
                    aiI.a(view, b.this.cvO);
                }
            }
        };
        this.axr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiI() != null) {
                    b.this.aiI().a(view, b.this.cvO);
                }
            }
        };
        this.axg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiI() != null) {
                    b.this.aiI().a(view, b.this.cvO);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bFP = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.bFP.getHeadView() != null) {
            this.bFP.getHeadView().setIsRound(true);
            this.bFP.getHeadView().setDrawBorder(false);
            this.bFP.getHeadView().setDefaultResource(17170445);
            this.bFP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bFP.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bFP.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.bFP.getPendantView() != null) {
            this.bFP.getPendantView().setIsRound(true);
            this.bFP.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.cyE = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.cyE.setAfterClickListener(this.cyK);
        this.cyG = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.cyG.setVisibility(8);
        this.cyH = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.cvN = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cyH.setChildClickListener(this.cvP);
        this.cyH.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.j(1.0d);
        this.cyH.setImageProcessor(eVar);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        if (this.bFe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFe.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bFe.setLayoutParams(layoutParams);
        }
        this.bFe.setOnClickListener(this.cvP);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setIsBarViewVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setShareVisible(true);
        this.bFe.setShareReportFrom(4);
        this.bFe.setFrom(9);
        this.bFe.aka = this.currentPageType;
        this.bFe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aiI() != null) {
                    b.this.aiI().a(view2, b.this.cvO);
                }
                if (b.this.cvO != null && b.this.cvO.threadData != null) {
                    o.lb(b.this.cvO.threadData.getId());
                    b.this.aiN();
                }
            }
        });
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.bFT.axN.setOnClickListener(this.cvP);
        this.bFT.setShareReportFrom(4);
        this.bFT.setFrom(9);
        this.bFT.axN.aka = this.currentPageType;
        this.bFT.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aiI() != null) {
                    b.this.aiI().a(view2, b.this.cvO);
                }
                if (b.this.cvO != null && b.this.cvO.threadData != null && view2 != b.this.bFT.axM) {
                    o.lb(b.this.cvO.threadData.getId());
                    b.this.aiN();
                }
            }
        });
        this.bGe = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.dNP = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cyH != null) {
            this.cyH.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cyH != null) {
            this.cyH.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cyH != null) {
            this.cyH.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.addresslist_item_bg);
            this.cyH.onChangeSkinType();
            this.bFe.onChangeSkinType();
            al.j(this.cvN, d.C0141d.cp_bg_line_e);
            this.bFT.onChangeSkinType();
        }
        if (this.dNK != null && this.dNK.getVisibility() == 0) {
            this.dNK.onChangeSkinType(i);
        }
        if (this.dNN != null && this.dNN.getVisibility() == 0) {
            this.dNN.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiN() {
        if (this.cvO != null && this.cvO.threadData.getId() != null) {
            o.a(this.mTitle, this.cvO.Sz().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            o.a(this.cyG, this.cvO.threadData.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_concern_normal_thread;
    }

    private void aCi() {
        if (this.dNK == null) {
            this.dNK = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aCj() {
        if (this.dNN == null) {
            this.dNN = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.dNN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiI() != null) {
                    b.this.aiI().a(view, b.this.cvO);
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
        this.cvO = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cvP);
        }
        if (kVar.ajv()) {
            aCj();
            this.dNO = this.dNN;
            this.dNN.setVisibility(0);
            if (this.dNK != null) {
                this.dNK.setVisibility(8);
            }
        } else {
            aCi();
            this.dNO = this.dNK;
            this.dNK.setVisibility(0);
            if (this.dNN != null) {
                this.dNN.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aiM() && o.lc(this.cvO.threadData.getId())) {
            aiN();
        }
        final bd Sz = kVar.Sz();
        if (this.dNO.getHeaderImg() != null) {
            if (this.dNO.getIsSimpleThread()) {
                this.dNO.getHeaderImg().setVisibility(8);
                this.bFP.setVisibility(8);
            } else if (Sz.vm() == null || Sz.vm().getPendantData() == null || StringUtils.isNull(Sz.vm().getPendantData().ub())) {
                this.bFP.setVisibility(8);
                this.dNO.getHeaderImg().setVisibility(0);
                this.dNO.getHeaderImg().setData(Sz, !kVar.ajv());
            } else {
                this.dNO.getHeaderImg().setVisibility(4);
                this.bFP.setVisibility(0);
                this.bFP.setData(Sz);
            }
        }
        this.dNO.setData(kVar.threadData);
        this.dNO.setUserAfterClickListener(this.axr);
        G(Sz);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> vA = kVar.threadData.vA();
        if (w.z(vA)) {
            this.cyE.setVisibility(8);
            ew(false);
            z = false;
        } else {
            this.cyE.setVisibility(0);
            ew(true);
            VoiceData.VoiceModel voiceModel = vA.get(0);
            this.cyE.setVoiceModel(voiceModel);
            this.cyE.setTag(voiceModel);
            this.cyE.aNN();
            if (voiceModel != null) {
                this.cyE.om(voiceModel.voice_status.intValue());
            }
            this.cyE.byi();
            z = true;
        }
        if (this.cvO.cBM && z) {
            this.cyH.setVisibility(8);
            this.dNP.setVisibility(0);
        } else {
            ArrayList<MediaData> vw = kVar.threadData.vw();
            if (i.tt().tz() && w.y(vw) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < vw.size(); i++) {
                    MediaData mediaData = (MediaData) w.c(vw, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (w.y(linkedList) > 0) {
                    this.cyH.setVisibility(0);
                    this.dNP.setVisibility(8);
                    this.cyH.setFromCDN(this.asK);
                    this.cyH.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view, int i2, boolean z2) {
                            ab<k> aiI = b.this.aiI();
                            if (aiI != null) {
                                view.setTag("1");
                                aiI.a(view, b.this.cvO);
                            }
                            if (z2) {
                                b.this.ajb();
                            } else {
                                b.this.a(view, linkedList, i2, Sz);
                            }
                        }
                    });
                    this.cyH.setImageMediaList(linkedList);
                } else {
                    this.cyH.setVisibility(8);
                    this.dNP.setVisibility(0);
                }
            } else {
                this.cyH.setVisibility(8);
                this.dNP.setVisibility(0);
            }
        }
        aja();
        setPageUniqueId(getTag());
        awn();
        hd(go(1));
    }

    private void ew(boolean z) {
        if (this.cyH != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cyH.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cyH.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), d.k.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.asK ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bdVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.vr(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.asK, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void aja() {
        if (!this.cvO.aMC) {
            this.cyE.setClickable(false);
        } else {
            this.cyE.setClickable(true);
        }
        int childCount = this.cyH.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cyH.getChildAt(i);
            if (childAt != null) {
                if (!this.cvO.aMC) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cyH != null) {
            this.cyH.setPageUniqueId(bdUniqueId);
        }
        if (this.dNO != null) {
            this.dNO.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dNO != null) {
            return this.dNO.getHeaderImg();
        }
        return null;
    }

    public View aiL() {
        if (this.dNO != null) {
            return this.dNO.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajb() {
        if (this.cvO != null && this.cvO.threadData != null) {
            if (!aiM()) {
                o.lb(this.cvO.threadData.getId());
                o.a(this.mTitle, this.cvO.Sz().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                o.a(this.cyG, this.cvO.threadData.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cvO.threadData, null, o.vb(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cvO.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cvO.threadData.vr());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aiM() {
        return this.cvO.cBM && !this.cvO.aMC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean G(bd bdVar) {
        SpannableStringBuilder g = bdVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        return true;
    }

    private void c(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.ajv()) {
            this.cyG.setVisibility(8);
            return;
        }
        bd bdVar = kVar.threadData;
        if (go(2) == 1) {
            SpannableString wA = bdVar.wA();
            if (wA != null && !ao.isEmpty(wA.toString())) {
                this.cyG.setVisibility(0);
                this.cyG.setOnTouchListener(new com.baidu.tieba.view.k(wA));
                this.cyG.setText(wA);
                o.a(this.cyG, bdVar.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                return;
            }
            this.cyG.setVisibility(8);
            return;
        }
        this.cyG.setVisibility(8);
    }

    private void awn() {
        if (this.mTitle != null && this.cyE != null && this.cyH != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cyE.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.cyE.setLayoutParams(layoutParams);
            if (this.cyE.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cyH.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cyH.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hd(int i) {
        if (this.cvO != null && this.cvO.threadData != null) {
            if (!this.cvO.ajv() && i == 1) {
                this.bFe.setVisibility(8);
                this.bFT.setStType(o.vb());
                this.bFT.setData(this.cvO.threadData);
                this.dNO.showForumNameView(false);
                return;
            }
            this.bFe.setData(this.cvO.threadData);
            this.bFe.setStType(o.vb());
            this.bFT.setVisibility(8);
            this.dNO.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}
