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
    private boolean aYX;
    private final View.OnClickListener bdE;
    private final View.OnClickListener bdQ;
    private View cVv;
    private k cVw;
    private View.OnClickListener cVx;
    public PlayVoiceBntNew cWQ;
    private TextView cWS;
    private ConstrainImageGroup cWT;
    private final View.OnClickListener cWW;
    public ThreadCommentAndPraiseInfoLayout clX;
    private HeadPendantClickableView cmI;
    public ThreadSourceShareAndPraiseLayout cmL;
    protected LinearLayout cmX;
    public ConcernThreadUserInfoLayout egE;
    private View egH;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aYX = true;
        this.cVx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akO() != null) {
                    b.this.akO().a(view, b.this.cVw);
                }
                b.this.ali();
            }
        };
        this.cWW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<k> akO = b.this.akO();
                if (akO != null) {
                    view.setTag("2");
                    akO.a(view, b.this.cVw);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akO() != null) {
                    b.this.akO().a(view, b.this.cVw);
                }
            }
        };
        this.bdE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akO() != null) {
                    b.this.akO().a(view, b.this.cVw);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cmI = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.cmI.getHeadView() != null) {
            this.cmI.getHeadView().setIsRound(true);
            this.cmI.getHeadView().setDrawBorder(false);
            this.cmI.getHeadView().setDefaultResource(17170445);
            this.cmI.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmI.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmI.getHeadView().setRadius(l.t(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.cmI.getPendantView() != null) {
            this.cmI.getPendantView().setIsRound(true);
            this.cmI.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.cWQ = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.cWQ.setAfterClickListener(this.cWW);
        this.cWS = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.cWS.setVisibility(8);
        this.cWT = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.cVv = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cWT.setChildClickListener(this.cVx);
        this.cWT.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cWT.setImageProcessor(fVar);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.egE = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.clX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.clX.setLayoutParams(layoutParams);
        }
        this.clX.setOnClickListener(this.cVx);
        this.clX.setReplyTimeVisible(false);
        this.clX.setIsBarViewVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setShareVisible(true);
        this.clX.setShareReportFrom(4);
        this.clX.setFrom(9);
        this.clX.aQt = this.currentPageType;
        this.clX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.akO() != null) {
                    b.this.akO().a(view2, b.this.cVw);
                }
                if (b.this.cVw != null && b.this.cVw.threadData != null) {
                    j.kr(b.this.cVw.threadData.getId());
                    b.this.akT();
                }
            }
        });
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.cmL.bem.setOnClickListener(this.cVx);
        this.cmL.setShareReportFrom(4);
        this.cmL.setFrom(9);
        this.cmL.bem.aQt = this.currentPageType;
        this.cmL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.akO() != null) {
                    b.this.akO().a(view2, b.this.cVw);
                }
                if (b.this.cVw != null && b.this.cVw.threadData != null && view2 != b.this.cmL.bel) {
                    j.kr(b.this.cVw.threadData.getId());
                    b.this.akT();
                }
            }
        });
        this.cmX = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.egH = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cWT != null) {
            this.cWT.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cWT != null) {
            this.cWT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cWT != null) {
            this.cWT.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.cWT.onChangeSkinType();
            this.clX.onChangeSkinType();
            this.egE.onChangeSkinType();
            aj.t(this.cVv, d.C0141d.cp_bg_line_e);
            this.cmL.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akT() {
        if (this.cVw != null && this.cVw.threadData.getId() != null) {
            j.a(this.mTitle, this.cVw.WD().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            j.a(this.cWS, this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
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
        this.cVw = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVx);
        }
        this.egE.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!akS() && j.ks(this.cVw.threadData.getId())) {
            akT();
        }
        this.egE.setUserAfterClickListener(this.bdQ);
        final bd WD = kVar.WD();
        if (this.egE.getHeaderImg() != null) {
            if (this.egE.getIsSimpleThread()) {
                this.egE.getHeaderImg().setVisibility(8);
                this.cmI.setVisibility(8);
            } else if (WD.zn() == null || WD.zn().getPendantData() == null || StringUtils.isNull(WD.zn().getPendantData().ya())) {
                this.cmI.setVisibility(8);
                this.egE.getHeaderImg().setVisibility(0);
                this.egE.getHeaderImg().setData(WD);
            } else {
                this.egE.getHeaderImg().setVisibility(4);
            }
        }
        G(WD);
        ArrayList<VoiceData.VoiceModel> zC = kVar.threadData.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cWQ.setVisibility(8);
            eM(false);
            z = false;
        } else {
            this.cWQ.setVisibility(0);
            eM(true);
            VoiceData.VoiceModel voiceModel = zC.get(0);
            this.cWQ.setVoiceModel(voiceModel);
            this.cWQ.setTag(voiceModel);
            this.cWQ.aNQ();
            if (voiceModel != null) {
                this.cWQ.qG(voiceModel.voice_status.intValue());
            }
            this.cWQ.bya();
            z = true;
        }
        if (this.cVw.cZZ && z) {
            this.cWT.setVisibility(8);
            this.egH.setVisibility(0);
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
                    this.cWT.setVisibility(0);
                    this.egH.setVisibility(8);
                    this.cWT.setFromCDN(this.aYX);
                    this.cWT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<k> akO = b.this.akO();
                            if (akO != null) {
                                view.setTag("1");
                                akO.a(view, b.this.cVw);
                            }
                            if (z2) {
                                b.this.ali();
                            } else {
                                b.this.a(view, linkedList, i2, WD);
                            }
                        }
                    });
                    this.cWT.setImageMediaList(linkedList);
                } else {
                    this.cWT.setVisibility(8);
                    this.egH.setVisibility(0);
                }
            } else {
                this.cWT.setVisibility(8);
                this.egH.setVisibility(0);
            }
        }
        alh();
        setPageUniqueId(getTag());
        axJ();
        jX(WD.aQo);
    }

    private void eM(boolean z) {
        if (this.cWT != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWT.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cWT.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.aYX ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aYX, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void alh() {
        if (!this.cVw.btD) {
            this.cWQ.setClickable(false);
        } else {
            this.cWQ.setClickable(true);
        }
        int childCount = this.cWT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cWT.getChildAt(i);
            if (childAt != null) {
                if (!this.cVw.btD) {
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
        if (this.cWT != null) {
            this.cWT.setPageUniqueId(bdUniqueId);
        }
        if (this.egE != null) {
            this.egE.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.egE != null) {
            return this.egE.getHeaderImg();
        }
        return null;
    }

    public View akR() {
        if (this.egE != null) {
            return this.egE.bdM;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ali() {
        if (this.cVw != null && this.cVw.threadData != null) {
            if (!akS()) {
                j.kr(this.cVw.threadData.getId());
                j.a(this.mTitle, this.cVw.WD().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                j.a(this.cWS, this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVw.threadData, null, j.zd(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cVw.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cVw.threadData.zt());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean akS() {
        return this.cVw.cZZ && !this.cVw.btD;
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

    private void axJ() {
        if (this.mTitle != null && this.cWQ != null && this.cWT != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cWQ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.cWQ.setLayoutParams(layoutParams);
            if (this.cWQ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWT.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cWT.setLayoutParams(layoutParams2);
            }
        }
    }

    public void jX(int i) {
        if (this.cVw != null && this.cVw.threadData != null) {
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setStType(j.zd());
                this.cmL.setData(this.cVw.threadData);
                this.egE.showForumNameView(false);
                return;
            }
            this.clX.setData(this.cVw.threadData);
            this.clX.setStType(j.zd());
            this.cmL.setVisibility(8);
            this.egE.showForumNameView(true);
        }
    }
}
