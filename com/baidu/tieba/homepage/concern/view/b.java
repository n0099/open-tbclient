package com.baidu.tieba.homepage.concern.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
import com.baidu.tieba.view.j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<k> implements com.baidu.tieba.a.e {
    private boolean akC;
    private final View.OnClickListener aoY;
    private final View.OnClickListener apj;
    private String bvX;
    private HeadPendantClickableView bwV;
    public ThreadSourceShareAndPraiseLayout bwZ;
    public ThreadCommentAndPraiseInfoLayout bwk;
    protected LinearLayout bxk;
    private View cmb;
    private k cmc;
    private View.OnClickListener cme;
    public PlayVoiceBntNew coU;
    private TextView coW;
    private ConstrainImageGroup coX;
    private final View.OnClickListener cpa;
    public ConcernThreadUserInfoLayout dBA;
    private View dBD;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akC = true;
        this.cme = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view2, b.this.cmc);
                }
                b.this.afs();
            }
        };
        this.cpa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<k> aeZ = b.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("2");
                    aeZ.a(view2, b.this.cmc);
                }
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view2, b.this.cmc);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view2, b.this.cmc);
                }
            }
        };
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bwV = (HeadPendantClickableView) view2.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.bwV.getHeadView() != null) {
            this.bwV.getHeadView().setIsRound(true);
            this.bwV.getHeadView().setDrawBorder(false);
            this.bwV.getHeadView().setDefaultResource(17170445);
            this.bwV.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bwV.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bwV.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.bwV.getPendantView() != null) {
            this.bwV.getPendantView().setIsRound(true);
            this.bwV.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view2.findViewById(d.g.card_concern_normal_thread_title);
        this.coU = (PlayVoiceBntNew) view2.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.coU.setAfterClickListener(this.cpa);
        this.coW = (TextView) view2.findViewById(d.g.card_concern_normal_thread_abstract);
        this.coW.setVisibility(8);
        this.coX = (ConstrainImageGroup) view2.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.cmb = view2.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.coX.setChildClickListener(this.cme);
        this.coX.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.coX.setImageProcessor(eVar);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.dBA = (ConcernThreadUserInfoLayout) view2.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.bwk.setOnClickListener(this.cme);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setIsBarViewVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setShareVisible(true);
        this.bwk.setShareReportFrom(4);
        this.bwk.setFrom(9);
        this.bwk.abV = this.currentPageType;
        this.bwk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view3, b.this.cmc);
                }
                if (b.this.cmc != null && b.this.cmc.threadData != null) {
                    o.kv(b.this.cmc.threadData.getId());
                    b.this.afe();
                }
            }
        });
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this.cme);
        this.bwZ.setShareReportFrom(4);
        this.bwZ.setFrom(9);
        this.bwZ.apG.abV = this.currentPageType;
        this.bwZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view3, b.this.cmc);
                }
                if (b.this.cmc != null && b.this.cmc.threadData != null && view3 != b.this.bwZ.apF) {
                    o.kv(b.this.cmc.threadData.getId());
                    b.this.afe();
                }
            }
        });
        this.bxk = (LinearLayout) view2.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.dBD = view2.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.coX != null) {
            this.coX.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.coX != null) {
            this.coX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.coX != null) {
            this.coX.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            this.coX.onChangeSkinType();
            this.bwk.onChangeSkinType();
            this.dBA.onChangeSkinType();
            ak.j(this.cmb, d.C0126d.cp_bg_line_e);
            this.bwZ.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afe() {
        if (this.cmc != null && this.cmc.threadData.getId() != null) {
            o.a(this.mTitle, this.cmc.Pe().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.coW, this.cmc.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_concern_normal_thread;
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
        this.cmc = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cme);
        }
        this.dBA.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!afd() && o.kw(this.cmc.threadData.getId())) {
            afe();
        }
        this.dBA.setUserAfterClickListener(this.apj);
        final bd Pe = kVar.Pe();
        if (this.dBA.getHeaderImg() != null) {
            if (this.dBA.getIsSimpleThread()) {
                this.dBA.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (Pe.rQ() == null || Pe.rQ().getPendantData() == null || StringUtils.isNull(Pe.rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.dBA.getHeaderImg().setVisibility(0);
                this.dBA.getHeaderImg().setData(Pe);
            } else {
                this.dBA.getHeaderImg().setVisibility(4);
            }
        }
        G(Pe);
        H(Pe);
        ArrayList<VoiceData.VoiceModel> se = kVar.threadData.se();
        if (v.w(se)) {
            this.coU.setVisibility(8);
            er(false);
            z = false;
        } else {
            this.coU.setVisibility(0);
            er(true);
            VoiceData.VoiceModel voiceModel = se.get(0);
            this.coU.setVoiceModel(voiceModel);
            this.coU.setTag(voiceModel);
            this.coU.aIT();
            if (voiceModel != null) {
                this.coU.ob(voiceModel.voice_status.intValue());
            }
            this.coU.btf();
            z = true;
        }
        if (this.cmc.csb && z) {
            this.coX.setVisibility(8);
            this.dBD.setVisibility(0);
        } else {
            ArrayList<MediaData> sa = kVar.threadData.sa();
            if (i.pY().qe() && v.v(sa) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < sa.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(sa, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.v(linkedList) > 0) {
                    this.coX.setVisibility(0);
                    this.dBD.setVisibility(8);
                    this.coX.setFromCDN(this.akC);
                    this.coX.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view2, int i2, boolean z2) {
                            ab<k> aeZ = b.this.aeZ();
                            if (aeZ != null) {
                                view2.setTag("1");
                                aeZ.a(view2, b.this.cmc);
                            }
                            if (z2) {
                                b.this.afs();
                            } else {
                                b.this.a(view2, linkedList, i2, Pe);
                            }
                        }
                    });
                    this.coX.setImageMediaList(linkedList);
                } else {
                    this.coX.setVisibility(8);
                    this.dBD.setVisibility(0);
                }
            } else {
                this.coX.setVisibility(8);
                this.dBD.setVisibility(0);
            }
        }
        afr();
        setPageUniqueId(getTag());
        asj();
        hb(gm(1));
    }

    private void er(boolean z) {
        if (this.coX != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coX.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.coX.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2, List<MediaData> list, int i, bd bdVar) {
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
                    imageUrlData.urlType = this.akC ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rV(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.akC, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view2.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void afr() {
        if (!this.cmc.aEf) {
            this.coU.setClickable(false);
        } else {
            this.coU.setClickable(true);
        }
        int childCount = this.coX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.coX.getChildAt(i);
            if (childAt != null) {
                if (!this.cmc.aEf) {
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
        if (this.coX != null) {
            this.coX.setPageUniqueId(bdUniqueId);
        }
        if (this.dBA != null) {
            this.dBA.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dBA != null) {
            return this.dBA.getHeaderImg();
        }
        return null;
    }

    public View afc() {
        if (this.dBA != null) {
            return this.dBA.apg;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        if (this.cmc != null && this.cmc.threadData != null) {
            if (!afd()) {
                o.kv(this.cmc.threadData.getId());
                o.a(this.mTitle, this.cmc.Pe().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                o.a(this.coW, this.cmc.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cmc.threadData, null, o.rG(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cmc.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cmc.threadData.rV());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean afd() {
        return this.cmc.csb && !this.cmc.aEf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    private boolean G(bd bdVar) {
        SpannableStringBuilder g = bdVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new j(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bdVar.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        }
        return true;
    }

    private void H(bd bdVar) {
        if (bdVar != null && gm(2) == 1) {
            SpannableString te = bdVar.te();
            if (te != null && !an.isEmpty(te.toString())) {
                this.coW.setVisibility(0);
                this.coW.setOnTouchListener(new j(te));
                this.coW.setText(te);
                o.a(this.coW, bdVar.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                return;
            }
            this.coW.setVisibility(8);
            return;
        }
        this.coW.setVisibility(8);
    }

    private void asj() {
        if (this.mTitle != null && this.coU != null && this.coX != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coU.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.coU.setLayoutParams(layoutParams);
            if (this.coU.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.coX.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.coX.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hb(int i) {
        if (this.cmc != null && this.cmc.threadData != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setStType(o.rG());
                this.bwZ.setData(this.cmc.threadData);
                this.dBA.showForumNameView(false);
                return;
            }
            this.bwk.setData(this.cmc.threadData);
            this.bwk.setStType(o.rG());
            this.bwZ.setVisibility(8);
            this.dBA.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gm(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
