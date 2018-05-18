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
    private String bwO;
    private HeadPendantClickableView bxM;
    public ThreadSourceShareAndPraiseLayout bxQ;
    public ThreadUserInfoLayout bxa;
    public ThreadCommentAndPraiseInfoLayout bxb;
    private NEGFeedBackView bxn;
    protected LinearLayout byb;
    private ThreadGodReplyLayout cnh;
    private View cni;
    private com.baidu.tieba.card.data.k cnj;
    private View.OnClickListener cnk;
    public PlayVoiceBntNew cqb;
    private View cqc;
    private TextView cqd;
    private ConstrainImageGroup cqe;
    private boolean cqf;
    private RelativeLayout cqg;
    private final View.OnClickListener cqh;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bxn = null;
        this.mSkinType = 3;
        this.akC = true;
        this.cqf = true;
        this.cnk = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aeZ() != null) {
                    p.this.aeZ().a(view2, p.this.cnj);
                }
                p.this.eo(view2 == p.this.cnh);
            }
        };
        this.cqh = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<com.baidu.tieba.card.data.k> aeZ = p.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("2");
                    aeZ.a(view2, p.this.cnj);
                }
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.aeZ() != null) {
                    p.this.aeZ().a(view2, p.this.cnj);
                }
            }
        };
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.bxM = (HeadPendantClickableView) view2.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bxM.getHeadView() != null) {
            this.bxM.getHeadView().setIsRound(true);
            this.bxM.getHeadView().setDrawBorder(false);
            this.bxM.getHeadView().setDefaultResource(17170445);
            this.bxM.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bxM.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bxM.getHeadView().setRadius(com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bxM.setHasPendantStyle();
        if (this.bxM.getPendantView() != null) {
            this.bxM.getPendantView().setIsRound(true);
            this.bxM.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_title);
        this.cqb = (PlayVoiceBntNew) view2.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cqb.setAfterClickListener(this.cqh);
        this.cqd = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cqd.setVisibility(8);
        this.cqe = (ConstrainImageGroup) view2.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cni = view2.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.cqe.setChildClickListener(this.cnk);
        this.cqe.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.cqe.setImageProcessor(eVar);
        this.cqc = view2.findViewById(d.g.divider_line_above_praise);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bxa = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bxn = new NEGFeedBackView(this.mPageContext);
        this.cqg = (RelativeLayout) view2.findViewById(d.g.card_home_page_normal_thread_root);
        this.bxn.a(this.cqg, com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds120), 0);
        if (this.bxb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bxb.setLayoutParams(layoutParams);
        }
        this.bxb.setOnClickListener(this.cnk);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setShareVisible(true);
        this.bxb.setFrom(1);
        this.bxb.setShareReportFrom(3);
        this.bxb.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (p.this.aeZ() != null) {
                    p.this.aeZ().a(view3, p.this.cnj);
                }
                if (p.this.cnj != null && p.this.cnj.threadData != null) {
                    o.ky(p.this.cnj.threadData.getId());
                    if (!p.this.afd()) {
                        o.a(p.this.mTitle, p.this.cnj.Pb().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                        o.a(p.this.cqd, p.this.cnj.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                        o.a(p.this.cnh.getGodReplyContent(), p.this.cnj.threadData.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
                    }
                }
            }
        });
        this.byb = (LinearLayout) view2.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cnh = (ThreadGodReplyLayout) view2.findViewById(d.g.card_home_page_god_reply_layout);
        this.cnh.setOnClickListener(this.cnk);
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_home_page_source_read_share_layout);
        this.bxQ.apG.setOnClickListener(this.cnk);
        this.bxQ.setFrom(1);
        this.bxQ.setShareReportFrom(3);
        this.bxQ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (p.this.aeZ() != null) {
                    p.this.aeZ().a(view3, p.this.cnj);
                }
                if (p.this.cnj != null && p.this.cnj.threadData != null && view3 != p.this.bxQ.apF) {
                    o.ky(p.this.cnj.threadData.getId());
                    if (!p.this.afd()) {
                        o.a(p.this.mTitle, p.this.cnj.Pb().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                        o.a(p.this.cqd, p.this.cnj.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                        o.a(p.this.cnh.getGodReplyContent(), p.this.cnj.threadData.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cqe != null) {
            this.cqe.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cqe != null) {
            this.cqe.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.j(this.cqc, d.C0126d.transparent);
            this.cqe.onChangeSkinType();
            this.bxb.onChangeSkinType();
            this.cnh.onChangeSkinType();
            this.bxa.onChangeSkinType();
            if (this.bxn != null) {
                this.bxn.onChangeSkinType();
            }
            ak.j(this.cni, d.C0126d.cp_bg_line_e);
            if (this.bxQ != null) {
                this.bxQ.onChangeSkinType();
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
        if (kVar == null || kVar.Pb() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cnj = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cnk);
        }
        if (this.bxn != null) {
            if (this.cnj.YI != null && this.cnj.YI.size() > 0) {
                ai aiVar = new ai();
                aiVar.cJ(this.cnj.Pb().getTid());
                aiVar.setFid(this.cnj.Pb().getFid());
                aiVar.a(this.cnj.YI);
                this.bxn.setData(aiVar);
                this.bxn.setFirstRowSingleColumn(true);
                if (kVar.threadData.rP() != null && !StringUtils.isNull(kVar.threadData.rP().getUserId())) {
                    if (kVar.threadData.rP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bxn.setVisibility(8);
                    } else if (this.bxn != null) {
                        this.bxn.setVisibility(this.cqf ? 0 : 8);
                    }
                }
            } else {
                this.bxn.setVisibility(8);
            }
        }
        this.bxa.setData(kVar.threadData);
        this.cnh.setFromCDN(this.akC);
        this.cnh.setData(kVar.threadData.tb());
        if (!afd() && o.kz(this.cnj.threadData.getId())) {
            o.a(this.mTitle, this.cnj.Pb().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.cqd, this.cnj.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            o.a(this.cnh.getGodReplyContent(), this.cnj.threadData.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        }
        this.bxa.setUserAfterClickListener(this.apj);
        final bd Pb = kVar.Pb();
        if (this.bxa.getHeaderImg() != null) {
            if (this.bxa.getIsSimpleThread()) {
                this.bxa.getHeaderImg().setVisibility(8);
                this.bxM.setVisibility(8);
            } else if (Pb.rP() == null || Pb.rP().getPendantData() == null || StringUtils.isNull(Pb.rP().getPendantData().qF())) {
                this.bxM.setVisibility(8);
                this.bxa.getHeaderImg().setVisibility(0);
                this.bxa.getHeaderImg().setData(Pb);
            } else {
                this.bxa.getHeaderImg().setVisibility(4);
                this.bxM.setVisibility(0);
                this.bxM.setData(Pb);
            }
        }
        G(Pb);
        H(Pb);
        ArrayList<VoiceData.VoiceModel> sd = kVar.threadData.sd();
        if (com.baidu.tbadk.core.util.v.w(sd)) {
            this.cqb.setVisibility(8);
            z = false;
        } else {
            this.cqb.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sd.get(0);
            this.cqb.setVoiceModel(voiceModel);
            this.cqb.setTag(voiceModel);
            this.cqb.aIS();
            if (voiceModel != null) {
                this.cqb.oa(voiceModel.voice_status.intValue());
            }
            this.cqb.btd();
            z = true;
        }
        if (this.cnj.cth && z) {
            this.cqe.setVisibility(8);
        } else {
            ArrayList<MediaData> rZ = Pb.rZ();
            if (com.baidu.tbadk.core.i.pX().qd() && com.baidu.tbadk.core.util.v.v(rZ) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < rZ.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rZ, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.cqe.setVisibility(0);
                    this.cqe.setFromCDN(this.akC);
                    this.cqe.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view2, int i2, boolean z2) {
                            ab<com.baidu.tieba.card.data.k> aeZ = p.this.aeZ();
                            if (aeZ != null) {
                                view2.setTag("1");
                                aeZ.a(view2, p.this.cnj);
                            }
                            if (z2) {
                                p.this.afs();
                            } else {
                                p.this.a(view2, linkedList, i2, Pb);
                            }
                        }
                    });
                    this.cqe.setImageMediaList(linkedList);
                } else {
                    this.cqe.setVisibility(8);
                }
            } else {
                this.cqe.setVisibility(8);
            }
        }
        afq();
        afr();
        setPageUniqueId(getTag());
        hc(gn(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void afq() {
        if (this.cqc != null && this.cqe != null && this.cnh != null) {
            if (this.cqe.getVisibility() == 8 && this.cnh.getVisibility() == 8) {
                this.cqc.setVisibility(0);
            } else {
                this.cqc.setVisibility(8);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rU(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.akC, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view2.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void afr() {
        if (!this.cnj.aEg) {
            this.cqb.setClickable(false);
        } else {
            this.cqb.setClickable(true);
        }
        int childCount = this.cqe.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cqe.getChildAt(i);
            if (childAt != null) {
                if (!this.cnj.aEg) {
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
        if (this.cqe != null) {
            this.cqe.setPageUniqueId(bdUniqueId);
        }
        if (this.bxn != null) {
            this.bxn.setUniqueId(bdUniqueId);
        }
        if (this.bxa != null) {
            this.bxa.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bxn != null) {
            this.bxn.setEventCallback(aVar);
        }
    }

    public View afb() {
        return this.cnh;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bxa != null) {
            return this.bxa.apf;
        }
        return null;
    }

    public View afc() {
        if (this.bxa != null) {
            return this.bxa.apg;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        eo(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(boolean z) {
        if (this.cnj != null && this.cnj.threadData != null) {
            if (!afd()) {
                o.ky(this.cnj.threadData.getId());
                o.a(this.mTitle, this.cnj.Pb().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                o.a(this.cqd, this.cnj.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                o.a(this.cnh.getGodReplyContent(), this.cnj.threadData.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cnj.threadData, null, o.rF(), 18003, true, false, false).addLocateParam(this.cnj.afJ());
            addLocateParam.setForumId(String.valueOf(this.cnj.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cnj.threadData.rU());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.ky(this.cnj.Pb().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afd() {
        return this.cnj.cth && !this.cnj.aEg;
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
        if (bdVar != null && gn(2) == 1) {
            SpannableString td = bdVar.td();
            if (td != null && !an.isEmpty(td.toString())) {
                this.cqd.setVisibility(0);
                this.cqd.setOnTouchListener(new com.baidu.tieba.view.j(td));
                this.cqd.setText(td);
                o.a(this.cqd, bdVar.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                return;
            }
            this.cqd.setVisibility(8);
            return;
        }
        this.cqd.setVisibility(8);
    }

    public void eq(boolean z) {
        if (this.cni != null) {
            this.cni.setVisibility(z ? 0 : 8);
        }
    }

    public void er(boolean z) {
        this.cqf = z;
    }

    public void hc(int i) {
        if (this.cnj != null && this.cnj.threadData != null) {
            this.mStType = o.rF();
            if (i == 1) {
                this.bxb.setVisibility(8);
                this.bxQ.setStType(this.mStType);
                this.bxQ.setData(this.cnj.threadData);
                this.bxa.showForumNameView(false);
                return;
            }
            this.bxb.setData(this.cnj.threadData);
            this.bxb.setStType(this.mStType);
            this.bxQ.setVisibility(8);
            this.bxa.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}
