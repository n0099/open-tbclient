package com.baidu.tieba.homepage.concern.view;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.j;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<k> {
    private boolean aYZ;
    private final View.OnClickListener bdG;
    private final View.OnClickListener bdT;
    private View.OnClickListener cVA;
    private View cVy;
    private k cVz;
    public PlayVoiceBntNew cWT;
    private TextView cWV;
    private ConstrainImageGroup cWW;
    private final View.OnClickListener cWZ;
    private HeadPendantClickableView cmL;
    public ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    protected LinearLayout cna;
    public ConcernThreadUserInfoLayout egU;
    private View egX;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aYZ = true;
        this.cVA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akP() != null) {
                    b.this.akP().a(view, b.this.cVz);
                }
                b.this.alj();
            }
        };
        this.cWZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<k> akP = b.this.akP();
                if (akP != null) {
                    view.setTag("2");
                    akP.a(view, b.this.cVz);
                }
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akP() != null) {
                    b.this.akP().a(view, b.this.cVz);
                }
            }
        };
        this.bdG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akP() != null) {
                    b.this.akP().a(view, b.this.cVz);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cmL = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(l.t(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.cWT = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.cWT.setAfterClickListener(this.cWZ);
        this.cWV = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.cWV.setVisibility(8);
        this.cWW = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.cVy = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cWW.setChildClickListener(this.cVA);
        this.cWW.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cWW.setImageProcessor(fVar);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.egU = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.cma.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cma.setLayoutParams(layoutParams);
        }
        this.cma.setOnClickListener(this.cVA);
        this.cma.setReplyTimeVisible(false);
        this.cma.setIsBarViewVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setShareVisible(true);
        this.cma.setShareReportFrom(4);
        this.cma.setFrom(9);
        this.cma.aQv = this.currentPageType;
        this.cma.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.akP() != null) {
                    b.this.akP().a(view2, b.this.cVz);
                }
                if (b.this.cVz != null && b.this.cVz.threadData != null) {
                    j.kr(b.this.cVz.threadData.getId());
                    b.this.akU();
                }
            }
        });
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.cmO.bep.setOnClickListener(this.cVA);
        this.cmO.setShareReportFrom(4);
        this.cmO.setFrom(9);
        this.cmO.bep.aQv = this.currentPageType;
        this.cmO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.akP() != null) {
                    b.this.akP().a(view2, b.this.cVz);
                }
                if (b.this.cVz != null && b.this.cVz.threadData != null && view2 != b.this.cmO.beo) {
                    j.kr(b.this.cVz.threadData.getId());
                    b.this.akU();
                }
            }
        });
        this.cna = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.egX = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cWW != null) {
            this.cWW.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cWW != null) {
            this.cWW.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cWW != null) {
            this.cWW.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.cWW.onChangeSkinType();
            this.cma.onChangeSkinType();
            this.egU.onChangeSkinType();
            aj.t(this.cVy, d.C0141d.cp_bg_line_e);
            this.cmO.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akU() {
        if (this.cVz != null && this.cVz.threadData.getId() != null) {
            j.a(this.mTitle, this.cVz.WE().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            j.a(this.cWV, this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_normal_thread;
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
        this.cVz = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVA);
        }
        this.egU.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!akT() && j.ks(this.cVz.threadData.getId())) {
            akU();
        }
        this.egU.setUserAfterClickListener(this.bdT);
        final bd WE = kVar.WE();
        if (this.egU.getHeaderImg() != null) {
            if (this.egU.getIsSimpleThread()) {
                this.egU.getHeaderImg().setVisibility(8);
                this.cmL.setVisibility(8);
            } else if (WE.zn() == null || WE.zn().getPendantData() == null || StringUtils.isNull(WE.zn().getPendantData().ya())) {
                this.cmL.setVisibility(8);
                this.egU.getHeaderImg().setVisibility(0);
                this.egU.getHeaderImg().setData(WE);
            } else {
                this.egU.getHeaderImg().setVisibility(4);
            }
        }
        G(WE);
        ArrayList<VoiceData.VoiceModel> zC = kVar.threadData.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cWT.setVisibility(8);
            eM(false);
            z = false;
        } else {
            this.cWT.setVisibility(0);
            eM(true);
            VoiceData.VoiceModel voiceModel = zC.get(0);
            this.cWT.setVoiceModel(voiceModel);
            this.cWT.setTag(voiceModel);
            this.cWT.aNR();
            if (voiceModel != null) {
                this.cWT.of(voiceModel.voice_status.intValue());
            }
            this.cWT.byf();
            z = true;
        }
        if (this.cVz.dac && z) {
            this.cWW.setVisibility(8);
            this.egX.setVisibility(0);
        } else {
            ArrayList<MediaData> zy = kVar.threadData.zy();
            if (i.xo().xu() && com.baidu.tbadk.core.util.v.D(zy) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zy.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zy, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                    this.cWW.setVisibility(0);
                    this.egX.setVisibility(8);
                    this.cWW.setFromCDN(this.aYZ);
                    this.cWW.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<k> akP = b.this.akP();
                            if (akP != null) {
                                view.setTag("1");
                                akP.a(view, b.this.cVz);
                            }
                            if (z2) {
                                b.this.alj();
                            } else {
                                b.this.a(view, linkedList, i2, WE);
                            }
                        }
                    });
                    this.cWW.setImageMediaList(linkedList);
                } else {
                    this.cWW.setVisibility(8);
                    this.egX.setVisibility(0);
                }
            } else {
                this.cWW.setVisibility(8);
                this.egX.setVisibility(0);
            }
        }
        ali();
        setPageUniqueId(getTag());
        axL();
        jX(WE.aQp);
    }

    private void eM(boolean z) {
        if (this.cWW != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWW.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cWW.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aYZ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aYZ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void ali() {
        if (!this.cVz.btG) {
            this.cWT.setClickable(false);
        } else {
            this.cWT.setClickable(true);
        }
        int childCount = this.cWW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cWW.getChildAt(i);
            if (childAt != null) {
                if (!this.cVz.btG) {
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
        if (this.cWW != null) {
            this.cWW.setPageUniqueId(bdUniqueId);
        }
        if (this.egU != null) {
            this.egU.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.egU != null) {
            return this.egU.getHeaderImg();
        }
        return null;
    }

    public View akS() {
        if (this.egU != null) {
            return this.egU.bdP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        if (this.cVz != null && this.cVz.threadData != null) {
            if (!akT()) {
                j.kr(this.cVz.threadData.getId());
                j.a(this.mTitle, this.cVz.WE().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                j.a(this.cWV, this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVz.threadData, null, j.zd(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cVz.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cVz.threadData.zt());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean akT() {
        return this.cVz.dac && !this.cVz.btG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean G(bd bdVar) {
        SpannableStringBuilder j = bdVar.j(false, true);
        if (j == null || StringUtils.isNull(j.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new m(j));
            this.mTitle.setText(j);
            j.a(this.mTitle, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        return true;
    }

    private void axL() {
        if (this.mTitle != null && this.cWT != null && this.cWW != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cWT.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.cWT.setLayoutParams(layoutParams);
            if (this.cWT.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWW.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cWW.setLayoutParams(layoutParams2);
            }
        }
    }

    public void jX(int i) {
        if (this.cVz != null && this.cVz.threadData != null) {
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setStType(j.zd());
                this.cmO.setData(this.cVz.threadData);
                this.egU.showForumNameView(false);
                return;
            }
            this.cma.setData(this.cVz.threadData);
            this.cma.setStType(j.zd());
            this.cmO.setVisibility(8);
            this.egU.showForumNameView(true);
        }
    }
}
