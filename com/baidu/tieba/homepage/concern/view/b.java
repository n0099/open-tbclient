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
    private View clY;
    private k clZ;
    private View.OnClickListener cma;
    public PlayVoiceBntNew coR;
    private TextView coT;
    private ConstrainImageGroup coU;
    private final View.OnClickListener coX;
    private View dBA;
    public ConcernThreadUserInfoLayout dBx;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akC = true;
        this.cma = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view2, b.this.clZ);
                }
                b.this.afs();
            }
        };
        this.coX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<k> aeZ = b.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("2");
                    aeZ.a(view2, b.this.clZ);
                }
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view2, b.this.clZ);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view2, b.this.clZ);
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
        this.coR = (PlayVoiceBntNew) view2.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.coR.setAfterClickListener(this.coX);
        this.coT = (TextView) view2.findViewById(d.g.card_concern_normal_thread_abstract);
        this.coT.setVisibility(8);
        this.coU = (ConstrainImageGroup) view2.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.clY = view2.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.coU.setChildClickListener(this.cma);
        this.coU.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.coU.setImageProcessor(eVar);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.dBx = (ConcernThreadUserInfoLayout) view2.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.bwk.setOnClickListener(this.cma);
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
                    b.this.aeZ().a(view3, b.this.clZ);
                }
                if (b.this.clZ != null && b.this.clZ.threadData != null) {
                    o.kv(b.this.clZ.threadData.getId());
                    b.this.afe();
                }
            }
        });
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this.cma);
        this.bwZ.setShareReportFrom(4);
        this.bwZ.setFrom(9);
        this.bwZ.apG.abV = this.currentPageType;
        this.bwZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view3, b.this.clZ);
                }
                if (b.this.clZ != null && b.this.clZ.threadData != null && view3 != b.this.bwZ.apF) {
                    o.kv(b.this.clZ.threadData.getId());
                    b.this.afe();
                }
            }
        });
        this.bxk = (LinearLayout) view2.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.dBA = view2.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.coU != null) {
            this.coU.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.coU != null) {
            this.coU.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.coU != null) {
            this.coU.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            this.coU.onChangeSkinType();
            this.bwk.onChangeSkinType();
            this.dBx.onChangeSkinType();
            ak.j(this.clY, d.C0126d.cp_bg_line_e);
            this.bwZ.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afe() {
        if (this.clZ != null && this.clZ.threadData.getId() != null) {
            o.a(this.mTitle, this.clZ.Pe().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.coT, this.clZ.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
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
        this.clZ = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cma);
        }
        this.dBx.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!afd() && o.kw(this.clZ.threadData.getId())) {
            afe();
        }
        this.dBx.setUserAfterClickListener(this.apj);
        final bd Pe = kVar.Pe();
        if (this.dBx.getHeaderImg() != null) {
            if (this.dBx.getIsSimpleThread()) {
                this.dBx.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (Pe.rQ() == null || Pe.rQ().getPendantData() == null || StringUtils.isNull(Pe.rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.dBx.getHeaderImg().setVisibility(0);
                this.dBx.getHeaderImg().setData(Pe);
            } else {
                this.dBx.getHeaderImg().setVisibility(4);
            }
        }
        G(Pe);
        H(Pe);
        ArrayList<VoiceData.VoiceModel> se = kVar.threadData.se();
        if (v.w(se)) {
            this.coR.setVisibility(8);
            er(false);
            z = false;
        } else {
            this.coR.setVisibility(0);
            er(true);
            VoiceData.VoiceModel voiceModel = se.get(0);
            this.coR.setVoiceModel(voiceModel);
            this.coR.setTag(voiceModel);
            this.coR.aIT();
            if (voiceModel != null) {
                this.coR.ob(voiceModel.voice_status.intValue());
            }
            this.coR.btf();
            z = true;
        }
        if (this.clZ.crY && z) {
            this.coU.setVisibility(8);
            this.dBA.setVisibility(0);
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
                    this.coU.setVisibility(0);
                    this.dBA.setVisibility(8);
                    this.coU.setFromCDN(this.akC);
                    this.coU.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view2, int i2, boolean z2) {
                            ab<k> aeZ = b.this.aeZ();
                            if (aeZ != null) {
                                view2.setTag("1");
                                aeZ.a(view2, b.this.clZ);
                            }
                            if (z2) {
                                b.this.afs();
                            } else {
                                b.this.a(view2, linkedList, i2, Pe);
                            }
                        }
                    });
                    this.coU.setImageMediaList(linkedList);
                } else {
                    this.coU.setVisibility(8);
                    this.dBA.setVisibility(0);
                }
            } else {
                this.coU.setVisibility(8);
                this.dBA.setVisibility(0);
            }
        }
        afr();
        setPageUniqueId(getTag());
        asj();
        hb(gm(1));
    }

    private void er(boolean z) {
        if (this.coU != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coU.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.coU.setLayoutParams(layoutParams);
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
        if (!this.clZ.aEf) {
            this.coR.setClickable(false);
        } else {
            this.coR.setClickable(true);
        }
        int childCount = this.coU.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.coU.getChildAt(i);
            if (childAt != null) {
                if (!this.clZ.aEf) {
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
        if (this.coU != null) {
            this.coU.setPageUniqueId(bdUniqueId);
        }
        if (this.dBx != null) {
            this.dBx.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dBx != null) {
            return this.dBx.getHeaderImg();
        }
        return null;
    }

    public View afc() {
        if (this.dBx != null) {
            return this.dBx.apg;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        if (this.clZ != null && this.clZ.threadData != null) {
            if (!afd()) {
                o.kv(this.clZ.threadData.getId());
                o.a(this.mTitle, this.clZ.Pe().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                o.a(this.coT, this.clZ.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.clZ.threadData, null, o.rG(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.clZ.threadData.getFid()));
            createFromThreadCfg.setForumName(this.clZ.threadData.rV());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean afd() {
        return this.clZ.crY && !this.clZ.aEf;
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
                this.coT.setVisibility(0);
                this.coT.setOnTouchListener(new j(te));
                this.coT.setText(te);
                o.a(this.coT, bdVar.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                return;
            }
            this.coT.setVisibility(8);
            return;
        }
        this.coT.setVisibility(8);
    }

    private void asj() {
        if (this.mTitle != null && this.coR != null && this.coU != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coR.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.coR.setLayoutParams(layoutParams);
            if (this.coR.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.coU.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.coU.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hb(int i) {
        if (this.clZ != null && this.clZ.threadData != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setStType(o.rG());
                this.bwZ.setData(this.clZ.threadData);
                this.dBx.showForumNameView(false);
                return;
            }
            this.bwk.setData(this.clZ.threadData);
            this.bwk.setStType(o.rG());
            this.bwZ.setVisibility(8);
            this.dBx.showForumNameView(true);
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
