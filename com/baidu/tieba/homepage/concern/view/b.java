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
    private String bwO;
    private HeadPendantClickableView bxM;
    public ThreadSourceShareAndPraiseLayout bxQ;
    public ThreadCommentAndPraiseInfoLayout bxb;
    protected LinearLayout byb;
    private View cni;
    private k cnj;
    private View.OnClickListener cnk;
    public PlayVoiceBntNew cqb;
    private TextView cqd;
    private ConstrainImageGroup cqe;
    private final View.OnClickListener cqh;
    public ConcernThreadUserInfoLayout dCE;
    private View dCH;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akC = true;
        this.cnk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view2, b.this.cnj);
                }
                b.this.afs();
            }
        };
        this.cqh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<k> aeZ = b.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("2");
                    aeZ.a(view2, b.this.cnj);
                }
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view2, b.this.cnj);
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view2, b.this.cnj);
                }
            }
        };
        View view2 = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bxM = (HeadPendantClickableView) view2.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.bxM.getHeadView() != null) {
            this.bxM.getHeadView().setIsRound(true);
            this.bxM.getHeadView().setDrawBorder(false);
            this.bxM.getHeadView().setDefaultResource(17170445);
            this.bxM.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bxM.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bxM.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.bxM.getPendantView() != null) {
            this.bxM.getPendantView().setIsRound(true);
            this.bxM.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view2.findViewById(d.g.card_concern_normal_thread_title);
        this.cqb = (PlayVoiceBntNew) view2.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.cqb.setAfterClickListener(this.cqh);
        this.cqd = (TextView) view2.findViewById(d.g.card_concern_normal_thread_abstract);
        this.cqd.setVisibility(8);
        this.cqe = (ConstrainImageGroup) view2.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.cni = view2.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cqe.setChildClickListener(this.cnk);
        this.cqe.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.cqe.setImageProcessor(eVar);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.dCE = (ConcernThreadUserInfoLayout) view2.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.bxb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxb.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bxb.setLayoutParams(layoutParams);
        }
        this.bxb.setOnClickListener(this.cnk);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setIsBarViewVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setShareVisible(true);
        this.bxb.setShareReportFrom(4);
        this.bxb.setFrom(9);
        this.bxb.abW = this.currentPageType;
        this.bxb.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view3, b.this.cnj);
                }
                if (b.this.cnj != null && b.this.cnj.threadData != null) {
                    o.ky(b.this.cnj.threadData.getId());
                    b.this.afe();
                }
            }
        });
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.bxQ.apG.setOnClickListener(this.cnk);
        this.bxQ.setShareReportFrom(4);
        this.bxQ.setFrom(9);
        this.bxQ.apG.abW = this.currentPageType;
        this.bxQ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (b.this.aeZ() != null) {
                    b.this.aeZ().a(view3, b.this.cnj);
                }
                if (b.this.cnj != null && b.this.cnj.threadData != null && view3 != b.this.bxQ.apF) {
                    o.ky(b.this.cnj.threadData.getId());
                    b.this.afe();
                }
            }
        });
        this.byb = (LinearLayout) view2.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.dCH = view2.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cqe != null) {
            this.cqe.setSingleImageRatio(d);
        }
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
            this.cqe.onChangeSkinType();
            this.bxb.onChangeSkinType();
            this.dCE.onChangeSkinType();
            ak.j(this.cni, d.C0126d.cp_bg_line_e);
            this.bxQ.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afe() {
        if (this.cnj != null && this.cnj.threadData.getId() != null) {
            o.a(this.mTitle, this.cnj.Pb().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.cqd, this.cnj.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
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
        this.cnj = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cnk);
        }
        this.dCE.setData(kVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!afd() && o.kz(this.cnj.threadData.getId())) {
            afe();
        }
        this.dCE.setUserAfterClickListener(this.apj);
        final bd Pb = kVar.Pb();
        if (this.dCE.getHeaderImg() != null) {
            if (this.dCE.getIsSimpleThread()) {
                this.dCE.getHeaderImg().setVisibility(8);
                this.bxM.setVisibility(8);
            } else if (Pb.rP() == null || Pb.rP().getPendantData() == null || StringUtils.isNull(Pb.rP().getPendantData().qF())) {
                this.bxM.setVisibility(8);
                this.dCE.getHeaderImg().setVisibility(0);
                this.dCE.getHeaderImg().setData(Pb);
            } else {
                this.dCE.getHeaderImg().setVisibility(4);
            }
        }
        G(Pb);
        H(Pb);
        ArrayList<VoiceData.VoiceModel> sd = kVar.threadData.sd();
        if (v.w(sd)) {
            this.cqb.setVisibility(8);
            es(false);
            z = false;
        } else {
            this.cqb.setVisibility(0);
            es(true);
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
            this.dCH.setVisibility(0);
        } else {
            ArrayList<MediaData> rZ = kVar.threadData.rZ();
            if (i.pX().qd() && v.v(rZ) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < rZ.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(rZ, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.v(linkedList) > 0) {
                    this.cqe.setVisibility(0);
                    this.dCH.setVisibility(8);
                    this.cqe.setFromCDN(this.akC);
                    this.cqe.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view2, int i2, boolean z2) {
                            ab<k> aeZ = b.this.aeZ();
                            if (aeZ != null) {
                                view2.setTag("1");
                                aeZ.a(view2, b.this.cnj);
                            }
                            if (z2) {
                                b.this.afs();
                            } else {
                                b.this.a(view2, linkedList, i2, Pb);
                            }
                        }
                    });
                    this.cqe.setImageMediaList(linkedList);
                } else {
                    this.cqe.setVisibility(8);
                    this.dCH.setVisibility(0);
                }
            } else {
                this.cqe.setVisibility(8);
                this.dCH.setVisibility(0);
            }
        }
        afr();
        setPageUniqueId(getTag());
        asi();
        hc(gn(1));
    }

    private void es(boolean z) {
        if (this.cqe != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqe.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cqe.setLayoutParams(layoutParams);
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
        if (this.dCE != null) {
            this.dCE.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dCE != null) {
            return this.dCE.getHeaderImg();
        }
        return null;
    }

    public View afc() {
        if (this.dCE != null) {
            return this.dCE.apg;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        if (this.cnj != null && this.cnj.threadData != null) {
            if (!afd()) {
                o.ky(this.cnj.threadData.getId());
                o.a(this.mTitle, this.cnj.Pb().getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
                o.a(this.cqd, this.cnj.threadData.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cnj.threadData, null, o.rF(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cnj.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cnj.threadData.rU());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean afd() {
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
            this.mTitle.setOnTouchListener(new j(g));
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
                this.cqd.setOnTouchListener(new j(td));
                this.cqd.setText(td);
                o.a(this.cqd, bdVar.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                return;
            }
            this.cqd.setVisibility(8);
            return;
        }
        this.cqd.setVisibility(8);
    }

    private void asi() {
        if (this.mTitle != null && this.cqb != null && this.cqe != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqb.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.cqb.setLayoutParams(layoutParams);
            if (this.cqb.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cqe.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cqe.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hc(int i) {
        if (this.cnj != null && this.cnj.threadData != null) {
            if (i == 1) {
                this.bxb.setVisibility(8);
                this.bxQ.setStType(o.rF());
                this.bxQ.setData(this.cnj.threadData);
                this.dCE.showForumNameView(false);
                return;
            }
            this.bxb.setData(this.cnj.threadData);
            this.bxb.setStType(o.rF());
            this.bxQ.setVisibility(8);
            this.dCE.showForumNameView(true);
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
