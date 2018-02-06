package com.baidu.tieba.card;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class k extends a<com.baidu.tieba.card.data.k> {
    private boolean aZj;
    private final View.OnClickListener bec;
    private ThreadGodReplyLayout cVG;
    private View cVH;
    private com.baidu.tieba.card.data.k cVI;
    private View.OnClickListener cVJ;
    public PlayVoiceBntNew cXc;
    private View cXd;
    private TextView cXe;
    private ConstrainImageGroup cXf;
    private boolean cXg;
    private RelativeLayout cXh;
    private final View.OnClickListener cXi;
    private HeadPendantClickableView cmU;
    public ThreadSourceShareAndPraiseLayout cmX;
    public ThreadUserInfoLayout cmj;
    public ThreadCommentAndPraiseInfoLayout cmk;
    private com.baidu.tieba.NEGFeedBack.c cmv;
    protected LinearLayout cnj;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmv = null;
        this.mSkinType = 3;
        this.aZj = true;
        this.cXg = true;
        this.cVJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.akP() != null) {
                    k.this.akP().a(view, k.this.cVI);
                }
                k.this.eI(view == k.this.cVG);
            }
        };
        this.cXi = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.card.data.k> akP = k.this.akP();
                if (akP != null) {
                    view.setTag("2");
                    akP.a(view, k.this.cVI);
                }
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.akP() != null) {
                    k.this.akP().a(view, k.this.cVI);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cmU = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmU.DT();
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cXc = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cXc.setAfterClickListener(this.cXi);
        this.cXe = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cXe.setVisibility(8);
        this.cXf = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cVH = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.cXf.setChildClickListener(this.cVJ);
        this.cXf.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cXf.setImageProcessor(fVar);
        this.cXd = view.findViewById(d.g.divider_line_above_praise);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.cmj = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.cmv = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cXh = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.cmv.a(this.cXh, com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds120), 0);
        if (this.cmk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cmk.setLayoutParams(layoutParams);
        }
        this.cmk.setOnClickListener(this.cVJ);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setShareVisible(true);
        this.cmk.setFrom(1);
        this.cmk.setShareReportFrom(3);
        this.cmk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.akP() != null) {
                    k.this.akP().a(view2, k.this.cVI);
                }
                if (k.this.cVI != null && k.this.cVI.threadData != null) {
                    j.kr(k.this.cVI.threadData.getId());
                    if (!k.this.akT()) {
                        j.a(k.this.mTitle, k.this.cVI.WE().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                        j.a(k.this.cXe, k.this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
                        j.a(k.this.cVG.getGodReplyContent(), k.this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
                    }
                }
            }
        });
        this.cnj = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cVG = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cVG.setOnClickListener(this.cVJ);
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.cmX.bez.setOnClickListener(this.cVJ);
        this.cmX.setFrom(1);
        this.cmX.setShareReportFrom(3);
        this.cmX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.akP() != null) {
                    k.this.akP().a(view2, k.this.cVI);
                }
                if (k.this.cVI != null && k.this.cVI.threadData != null && view2 != k.this.cmX.bey) {
                    j.kr(k.this.cVI.threadData.getId());
                    if (!k.this.akT()) {
                        j.a(k.this.mTitle, k.this.cVI.WE().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                        j.a(k.this.cXe, k.this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
                        j.a(k.this.cVG.getGodReplyContent(), k.this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
                    }
                }
            }
        });
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
            aj.t(this.cXd, d.C0140d.transparent);
            this.cXf.onChangeSkinType();
            this.cmk.onChangeSkinType();
            this.cVG.onChangeSkinType();
            this.cmj.onChangeSkinType();
            if (this.cmv != null) {
                this.cmv.onChangeSkinType();
            }
            aj.t(this.cVH, d.C0140d.cp_bg_line_e);
            if (this.cmX != null) {
                this.cmX.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        boolean z;
        if (kVar == null || kVar.WE() == null) {
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
        if (this.cmv != null) {
            if (this.cVI.aNr != null && this.cVI.aNr.size() > 0) {
                ah ahVar = new ah();
                ahVar.cV(this.cVI.WE().getTid());
                ahVar.setFid(this.cVI.WE().getFid());
                ahVar.a(this.cVI.aNr);
                this.cmv.setData(ahVar);
                this.cmv.setFirstRowSingleColumn(true);
                if (kVar.threadData.zn() != null && !StringUtils.isNull(kVar.threadData.zn().getUserId())) {
                    if (kVar.threadData.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.cmv.setVisibility(8);
                    } else if (this.cmv != null) {
                        this.cmv.setVisibility(this.cXg ? 0 : 8);
                    }
                }
            } else {
                this.cmv.setVisibility(8);
            }
        }
        this.cmj.setData(kVar.threadData);
        this.cVG.setFromCDN(this.aZj);
        this.cVG.setData(kVar.threadData.AA());
        if (!akT() && j.ks(this.cVI.threadData.getId())) {
            j.a(this.mTitle, this.cVI.WE().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            j.a(this.cXe, this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
            j.a(this.cVG.getGodReplyContent(), this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        }
        this.cmj.setUserAfterClickListener(this.bec);
        final bd WE = kVar.WE();
        if (this.cmj.getHeaderImg() != null) {
            if (this.cmj.getIsSimpleThread()) {
                this.cmj.getHeaderImg().setVisibility(8);
                this.cmU.setVisibility(8);
            } else if (WE.zn() == null || WE.zn().getPendantData() == null || StringUtils.isNull(WE.zn().getPendantData().ya())) {
                this.cmU.setVisibility(8);
                this.cmj.getHeaderImg().setVisibility(0);
                this.cmj.getHeaderImg().setData(WE);
            } else {
                this.cmj.getHeaderImg().setVisibility(4);
                this.cmU.setVisibility(0);
                this.cmU.setData(WE);
            }
        }
        G(WE);
        ArrayList<VoiceData.VoiceModel> zC = kVar.threadData.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cXc.setVisibility(8);
            z = false;
        } else {
            this.cXc.setVisibility(0);
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
        } else {
            ArrayList<MediaData> zy = WE.zy();
            if (com.baidu.tbadk.core.i.xo().xu() && com.baidu.tbadk.core.util.v.D(zy) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zy.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zy, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                    this.cXf.setVisibility(0);
                    this.cXf.setFromCDN(this.aZj);
                    this.cXf.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.k.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<com.baidu.tieba.card.data.k> akP = k.this.akP();
                            if (akP != null) {
                                view.setTag("1");
                                akP.a(view, k.this.cVI);
                            }
                            if (z2) {
                                k.this.alj();
                            } else {
                                k.this.a(view, linkedList, i2, WE);
                            }
                        }
                    });
                    this.cXf.setImageMediaList(linkedList);
                } else {
                    this.cXf.setVisibility(8);
                }
            } else {
                this.cXf.setVisibility(8);
            }
        }
        alh();
        ali();
        setPageUniqueId(getTag());
        jX(WE.aQz);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void alh() {
        if (this.cXd != null && this.cXf != null && this.cVG != null) {
            if (this.cXf.getVisibility() == 8 && this.cVG.getVisibility() == 8) {
                this.cXd.setVisibility(0);
            } else {
                this.cXd.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
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

    public void setFromCDN(boolean z) {
        this.aZj = z;
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
        if (this.cmv != null) {
            this.cmv.setUniqueId(bdUniqueId);
        }
        if (this.cmj != null) {
            this.cmj.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.cmv != null) {
            this.cmv.setEventCallback(aVar);
        }
    }

    public View akR() {
        return this.cVG;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cmj != null) {
            return this.cmj.bdX;
        }
        return null;
    }

    public View akS() {
        if (this.cmj != null) {
            return this.cmj.bdY;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        eI(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.cVI != null && this.cVI.threadData != null) {
            if (!akT()) {
                j.kr(this.cVI.threadData.getId());
                j.a(this.mTitle, this.cVI.WE().getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
                j.a(this.cXe, this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
                j.a(this.cVG.getGodReplyContent(), this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVI.threadData, null, j.zd(), 18003, true, false, false).addLocateParam(this.cVI.alC());
            addLocateParam.setForumId(String.valueOf(this.cVI.threadData.getFid()));
            addLocateParam.setForumName(this.cVI.threadData.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            j.kr(this.cVI.WE().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akT() {
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
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            j.a(this.mTitle, bdVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
        return true;
    }

    public void eK(boolean z) {
        if (this.cVH != null) {
            this.cVH.setVisibility(z ? 0 : 8);
        }
    }

    public void eL(boolean z) {
        this.cXg = z;
    }

    public void jX(int i) {
        if (this.cVI != null && this.cVI.threadData != null) {
            this.mStType = j.zd();
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setStType(this.mStType);
                this.cmX.setData(this.cVI.threadData);
                this.cmj.showForumNameView(false);
                return;
            }
            this.cmk.setData(this.cVI.threadData);
            this.cmk.setStType(this.mStType);
            this.cmX.setVisibility(8);
            this.cmj.showForumNameView(true);
        }
    }
}
