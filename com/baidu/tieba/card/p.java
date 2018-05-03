package com.baidu.tieba.card;

import android.graphics.Rect;
import android.text.SpannableString;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class p extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private boolean akC;
    private final View.OnClickListener apj;
    private String bvX;
    private HeadPendantClickableView bwV;
    public ThreadSourceShareAndPraiseLayout bwZ;
    public ThreadUserInfoLayout bwj;
    public ThreadCommentAndPraiseInfoLayout bwk;
    private NEGFeedBackView bww;
    protected LinearLayout bxk;
    private ThreadGodReplyLayout clX;
    private View clY;
    private com.baidu.tieba.card.data.k clZ;
    private View.OnClickListener cma;
    public PlayVoiceBntNew coR;
    private View coS;
    private TextView coT;
    private ConstrainImageGroup coU;
    private boolean coV;
    private RelativeLayout coW;
    private final View.OnClickListener coX;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bww = null;
        this.mSkinType = 3;
        this.akC = true;
        this.coV = true;
        this.cma = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aeZ() != null) {
                    p.this.aeZ().a(view2, p.this.clZ);
                }
                p.this.en(view2 == p.this.clX);
            }
        };
        this.coX = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<com.baidu.tieba.card.data.k> aeZ = p.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("2");
                    aeZ.a(view2, p.this.clZ);
                }
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aeZ() != null) {
                    p.this.aeZ().a(view2, p.this.clZ);
                }
            }
        };
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.bwV = (HeadPendantClickableView) view2.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bwV.getHeadView() != null) {
            this.bwV.getHeadView().setIsRound(true);
            this.bwV.getHeadView().setDrawBorder(false);
            this.bwV.getHeadView().setDefaultResource(17170445);
            this.bwV.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bwV.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bwV.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bwV.setHasPendantStyle();
        if (this.bwV.getPendantView() != null) {
            this.bwV.getPendantView().setIsRound(true);
            this.bwV.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_title);
        this.coR = (PlayVoiceBntNew) view2.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.coR.setAfterClickListener(this.coX);
        this.coT = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.coT.setVisibility(8);
        this.coU = (ConstrainImageGroup) view2.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.clY = view2.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.coU.setChildClickListener(this.cma);
        this.coU.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.coU.setImageProcessor(eVar);
        this.coS = view2.findViewById(d.g.divider_line_above_praise);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bww = new NEGFeedBackView(this.mPageContext);
        this.coW = (RelativeLayout) view2.findViewById(d.g.card_home_page_normal_thread_root);
        this.bww.a(this.coW, com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds120), 0);
        if (this.bwk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bwk.setLayoutParams(layoutParams);
        }
        this.bwk.setOnClickListener(this.cma);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setShareVisible(true);
        this.bwk.setFrom(1);
        this.bwk.setShareReportFrom(3);
        this.bwk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (p.this.aeZ() != null) {
                    p.this.aeZ().a(view3, p.this.clZ);
                }
                if (p.this.clZ != null && p.this.clZ.threadData != null) {
                    o.kv(p.this.clZ.threadData.getId());
                    if (!p.this.afd()) {
                        o.a(p.this.mTitle, p.this.clZ.Pe().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                        o.a(p.this.coT, p.this.clZ.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                        o.a(p.this.clX.getGodReplyContent(), p.this.clZ.threadData.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
                    }
                }
            }
        });
        this.bxk = (LinearLayout) view2.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.clX = (ThreadGodReplyLayout) view2.findViewById(d.g.card_home_page_god_reply_layout);
        this.clX.setOnClickListener(this.cma);
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_home_page_source_read_share_layout);
        this.bwZ.apG.setOnClickListener(this.cma);
        this.bwZ.setFrom(1);
        this.bwZ.setShareReportFrom(3);
        this.bwZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (p.this.aeZ() != null) {
                    p.this.aeZ().a(view3, p.this.clZ);
                }
                if (p.this.clZ != null && p.this.clZ.threadData != null && view3 != p.this.bwZ.apF) {
                    o.kv(p.this.clZ.threadData.getId());
                    if (!p.this.afd()) {
                        o.a(p.this.mTitle, p.this.clZ.Pe().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                        o.a(p.this.coT, p.this.clZ.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                        o.a(p.this.clX.getGodReplyContent(), p.this.clZ.threadData.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
                    }
                }
            }
        });
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
            ak.j(this.coS, d.C0126d.transparent);
            this.coU.onChangeSkinType();
            this.bwk.onChangeSkinType();
            this.clX.onChangeSkinType();
            this.bwj.onChangeSkinType();
            if (this.bww != null) {
                this.bww.onChangeSkinType();
            }
            ak.j(this.clY, d.C0126d.cp_bg_line_e);
            if (this.bwZ != null) {
                this.bwZ.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        boolean z;
        if (kVar == null || kVar.Pe() == null) {
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
        if (this.bww != null) {
            if (this.clZ.YI != null && this.clZ.YI.size() > 0) {
                ai aiVar = new ai();
                aiVar.cJ(this.clZ.Pe().getTid());
                aiVar.setFid(this.clZ.Pe().getFid());
                aiVar.a(this.clZ.YI);
                this.bww.setData(aiVar);
                this.bww.setFirstRowSingleColumn(true);
                if (kVar.threadData.rQ() != null && !StringUtils.isNull(kVar.threadData.rQ().getUserId())) {
                    if (kVar.threadData.rQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bww.setVisibility(8);
                    } else if (this.bww != null) {
                        this.bww.setVisibility(this.coV ? 0 : 8);
                    }
                }
            } else {
                this.bww.setVisibility(8);
            }
        }
        this.bwj.setData(kVar.threadData);
        this.clX.setFromCDN(this.akC);
        this.clX.setData(kVar.threadData.tc());
        if (!afd() && o.kw(this.clZ.threadData.getId())) {
            o.a(this.mTitle, this.clZ.Pe().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.coT, this.clZ.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            o.a(this.clX.getGodReplyContent(), this.clZ.threadData.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        }
        this.bwj.setUserAfterClickListener(this.apj);
        final bd Pe = kVar.Pe();
        if (this.bwj.getHeaderImg() != null) {
            if (this.bwj.getIsSimpleThread()) {
                this.bwj.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (Pe.rQ() == null || Pe.rQ().getPendantData() == null || StringUtils.isNull(Pe.rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.bwj.getHeaderImg().setVisibility(0);
                this.bwj.getHeaderImg().setData(Pe);
            } else {
                this.bwj.getHeaderImg().setVisibility(4);
                this.bwV.setVisibility(0);
                this.bwV.setData(Pe);
            }
        }
        G(Pe);
        H(Pe);
        ArrayList<VoiceData.VoiceModel> se = kVar.threadData.se();
        if (com.baidu.tbadk.core.util.v.w(se)) {
            this.coR.setVisibility(8);
            z = false;
        } else {
            this.coR.setVisibility(0);
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
        } else {
            ArrayList<MediaData> sa = Pe.sa();
            if (com.baidu.tbadk.core.i.pY().qe() && com.baidu.tbadk.core.util.v.v(sa) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < sa.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(sa, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.coU.setVisibility(0);
                    this.coU.setFromCDN(this.akC);
                    this.coU.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view2, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.k> aeZ = p.this.aeZ();
                            if (aeZ != null) {
                                view2.setTag("1");
                                aeZ.a(view2, p.this.clZ);
                            }
                            if (z2) {
                                p.this.afs();
                            } else {
                                p.this.a(view2, linkedList, i2, Pe);
                            }
                        }
                    });
                    this.coU.setImageMediaList(linkedList);
                } else {
                    this.coU.setVisibility(8);
                }
            } else {
                this.coU.setVisibility(8);
            }
        }
        afq();
        afr();
        setPageUniqueId(getTag());
        hb(gm(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void afq() {
        if (this.coS != null && this.coU != null && this.clX != null) {
            if (this.coU.getVisibility() == 8 && this.clX.getVisibility() == 8) {
                this.coS.setVisibility(0);
            } else {
                this.coS.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.k.plugin_image_viewer_install_error_tips);
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
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
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

    public void setFromCDN(boolean z) {
        this.akC = z;
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
        if (this.bww != null) {
            this.bww.setUniqueId(bdUniqueId);
        }
        if (this.bwj != null) {
            this.bwj.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bww != null) {
            this.bww.setEventCallback(aVar);
        }
    }

    public View afb() {
        return this.clX;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bwj != null) {
            return this.bwj.apf;
        }
        return null;
    }

    public View afc() {
        if (this.bwj != null) {
            return this.bwj.apg;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        en(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en(boolean z) {
        if (this.clZ != null && this.clZ.threadData != null) {
            if (!afd()) {
                o.kv(this.clZ.threadData.getId());
                o.a(this.mTitle, this.clZ.Pe().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                o.a(this.coT, this.clZ.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                o.a(this.clX.getGodReplyContent(), this.clZ.threadData.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.clZ.threadData, null, o.rG(), 18003, true, false, false).addLocateParam(this.clZ.afJ());
            addLocateParam.setForumId(String.valueOf(this.clZ.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.clZ.threadData.rV());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.kv(this.clZ.Pe().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afd() {
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
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.j(g));
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
                this.coT.setOnTouchListener(new com.baidu.tieba.view.j(te));
                this.coT.setText(te);
                o.a(this.coT, bdVar.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                return;
            }
            this.coT.setVisibility(8);
            return;
        }
        this.coT.setVisibility(8);
    }

    public void ep(boolean z) {
        if (this.clY != null) {
            this.clY.setVisibility(z ? 0 : 8);
        }
    }

    public void eq(boolean z) {
        this.coV = z;
    }

    public void hb(int i) {
        if (this.clZ != null && this.clZ.threadData != null) {
            this.mStType = o.rG();
            if (i == 1) {
                this.bwk.setVisibility(8);
                this.bwZ.setStType(this.mStType);
                this.bwZ.setData(this.clZ.threadData);
                this.bwj.showForumNameView(false);
                return;
            }
            this.bwk.setData(this.clZ.threadData);
            this.bwk.setStType(this.mStType);
            this.bwZ.setVisibility(8);
            this.bwj.showForumNameView(true);
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
