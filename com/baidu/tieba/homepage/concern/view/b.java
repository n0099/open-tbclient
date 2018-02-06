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
    private boolean aZj;
    private final View.OnClickListener bdQ;
    private final View.OnClickListener bec;
    private View cVH;
    private k cVI;
    private View.OnClickListener cVJ;
    public PlayVoiceBntNew cXc;
    private TextView cXe;
    private ConstrainImageGroup cXf;
    private final View.OnClickListener cXi;
    private HeadPendantClickableView cmU;
    public ThreadSourceShareAndPraiseLayout cmX;
    public ThreadCommentAndPraiseInfoLayout cmk;
    protected LinearLayout cnj;
    public ConcernThreadUserInfoLayout egQ;
    private View egT;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aZj = true;
        this.cVJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akP() != null) {
                    b.this.akP().a(view, b.this.cVI);
                }
                b.this.alj();
            }
        };
        this.cXi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<k> akP = b.this.akP();
                if (akP != null) {
                    view.setTag("2");
                    akP.a(view, b.this.cVI);
                }
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akP() != null) {
                    b.this.akP().a(view, b.this.cVI);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akP() != null) {
                    b.this.akP().a(view, b.this.cVI);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.cmU = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(l.t(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.cXc = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.cXc.setAfterClickListener(this.cXi);
        this.cXe = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.cXe.setVisibility(8);
        this.cXf = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.cVH = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cXf.setChildClickListener(this.cVJ);
        this.cXf.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cXf.setImageProcessor(fVar);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.egQ = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.cmk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cmk.setLayoutParams(layoutParams);
        }
        this.cmk.setOnClickListener(this.cVJ);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setIsBarViewVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setShareVisible(true);
        this.cmk.setShareReportFrom(4);
        this.cmk.setFrom(9);
        this.cmk.aQE = this.currentPageType;
        this.cmk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.akP() != null) {
                    b.this.akP().a(view2, b.this.cVI);
                }
                if (b.this.cVI != null && b.this.cVI.threadData != null) {
                    j.kr(b.this.cVI.threadData.getId());
                    b.this.akU();
                }
            }
        });
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.cmX.bez.setOnClickListener(this.cVJ);
        this.cmX.setShareReportFrom(4);
        this.cmX.setFrom(9);
        this.cmX.bez.aQE = this.currentPageType;
        this.cmX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.akP() != null) {
                    b.this.akP().a(view2, b.this.cVI);
                }
                if (b.this.cVI != null && b.this.cVI.threadData != null && view2 != b.this.cmX.bey) {
                    j.kr(b.this.cVI.threadData.getId());
                    b.this.akU();
                }
            }
        });
        this.cnj = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.egT = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cXf != null) {
            this.cXf.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cXf != null) {
            this.cXf.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cXf != null) {
            this.cXf.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.cXf.onChangeSkinType();
            this.cmk.onChangeSkinType();
            this.egQ.onChangeSkinType();
            aj.t(this.cVH, d.C0140d.cp_bg_line_e);
            this.cmX.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akU() {
        if (this.cVI != null && this.cVI.threadData.getId() != null) {
            j.a(this.mTitle, this.cVI.WE().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            j.a(this.cXe, this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
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
        this.cVI = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVJ);
        }
        this.egQ.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!akT() && j.ks(this.cVI.threadData.getId())) {
            akU();
        }
        this.egQ.setUserAfterClickListener(this.bec);
        final bd WE = kVar.WE();
        if (this.egQ.getHeaderImg() != null) {
            if (this.egQ.getIsSimpleThread()) {
                this.egQ.getHeaderImg().setVisibility(8);
                this.cmU.setVisibility(8);
            } else if (WE.zn() == null || WE.zn().getPendantData() == null || StringUtils.isNull(WE.zn().getPendantData().ya())) {
                this.cmU.setVisibility(8);
                this.egQ.getHeaderImg().setVisibility(0);
                this.egQ.getHeaderImg().setData(WE);
            } else {
                this.egQ.getHeaderImg().setVisibility(4);
            }
        }
        G(WE);
        ArrayList<VoiceData.VoiceModel> zC = kVar.threadData.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cXc.setVisibility(8);
            eM(false);
            z = false;
        } else {
            this.cXc.setVisibility(0);
            eM(true);
            VoiceData.VoiceModel voiceModel = zC.get(0);
            this.cXc.setVoiceModel(voiceModel);
            this.cXc.setTag(voiceModel);
            this.cXc.aNR();
            if (voiceModel != null) {
                this.cXc.qG(voiceModel.voice_status.intValue());
            }
            this.cXc.byb();
            z = true;
        }
        if (this.cVI.dal && z) {
            this.cXf.setVisibility(8);
            this.egT.setVisibility(0);
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
                    this.cXf.setVisibility(0);
                    this.egT.setVisibility(8);
                    this.cXf.setFromCDN(this.aZj);
                    this.cXf.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<k> akP = b.this.akP();
                            if (akP != null) {
                                view.setTag("1");
                                akP.a(view, b.this.cVI);
                            }
                            if (z2) {
                                b.this.alj();
                            } else {
                                b.this.a(view, linkedList, i2, WE);
                            }
                        }
                    });
                    this.cXf.setImageMediaList(linkedList);
                } else {
                    this.cXf.setVisibility(8);
                    this.egT.setVisibility(0);
                }
            } else {
                this.cXf.setVisibility(8);
                this.egT.setVisibility(0);
            }
        }
        ali();
        setPageUniqueId(getTag());
        axK();
        jX(WE.aQz);
    }

    private void eM(boolean z) {
        if (this.cXf != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXf.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cXf.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.aZj ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aZj, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void ali() {
        if (!this.cVI.btQ) {
            this.cXc.setClickable(false);
        } else {
            this.cXc.setClickable(true);
        }
        int childCount = this.cXf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cXf.getChildAt(i);
            if (childAt != null) {
                if (!this.cVI.btQ) {
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
        if (this.cXf != null) {
            this.cXf.setPageUniqueId(bdUniqueId);
        }
        if (this.egQ != null) {
            this.egQ.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.egQ != null) {
            return this.egQ.getHeaderImg();
        }
        return null;
    }

    public View akS() {
        if (this.egQ != null) {
            return this.egQ.bdY;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        if (this.cVI != null && this.cVI.threadData != null) {
            if (!akT()) {
                j.kr(this.cVI.threadData.getId());
                j.a(this.mTitle, this.cVI.WE().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                j.a(this.cXe, this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVI.threadData, null, j.zd(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cVI.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cVI.threadData.zt());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean akT() {
        return this.cVI.dal && !this.cVI.btQ;
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
            j.a(this.mTitle, bdVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
        return true;
    }

    private void axK() {
        if (this.mTitle != null && this.cXc != null && this.cXf != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cXc.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.cXc.setLayoutParams(layoutParams);
            if (this.cXc.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cXf.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cXf.setLayoutParams(layoutParams2);
            }
        }
    }

    public void jX(int i) {
        if (this.cVI != null && this.cVI.threadData != null) {
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setStType(j.zd());
                this.cmX.setData(this.cVI.threadData);
                this.egQ.showForumNameView(false);
                return;
            }
            this.cmk.setData(this.cVI.threadData);
            this.cmk.setStType(j.zd());
            this.cmX.setVisibility(8);
            this.egQ.showForumNameView(true);
        }
    }
}
