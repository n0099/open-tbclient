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
    private boolean aYZ;
    private final View.OnClickListener bdT;
    private View.OnClickListener cVA;
    private ThreadGodReplyLayout cVx;
    private View cVy;
    private com.baidu.tieba.card.data.k cVz;
    public PlayVoiceBntNew cWT;
    private View cWU;
    private TextView cWV;
    private ConstrainImageGroup cWW;
    private boolean cWX;
    private RelativeLayout cWY;
    private final View.OnClickListener cWZ;
    public ThreadUserInfoLayout clZ;
    private HeadPendantClickableView cmL;
    public ThreadSourceShareAndPraiseLayout cmO;
    public ThreadCommentAndPraiseInfoLayout cma;
    private com.baidu.tieba.NEGFeedBack.c cmm;
    protected LinearLayout cna;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmm = null;
        this.mSkinType = 3;
        this.aYZ = true;
        this.cWX = true;
        this.cVA = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.akP() != null) {
                    k.this.akP().a(view, k.this.cVz);
                }
                k.this.eI(view == k.this.cVx);
            }
        };
        this.cWZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.card.data.k> akP = k.this.akP();
                if (akP != null) {
                    view.setTag("2");
                    akP.a(view, k.this.cVz);
                }
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.akP() != null) {
                    k.this.akP().a(view, k.this.cVz);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cmL = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmL.DT();
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cWT = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cWT.setAfterClickListener(this.cWZ);
        this.cWV = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cWV.setVisibility(8);
        this.cWW = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cVy = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.cWW.setChildClickListener(this.cVA);
        this.cWW.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cWW.setImageProcessor(fVar);
        this.cWU = view.findViewById(d.g.divider_line_above_praise);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.clZ = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.cmm = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cWY = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.cmm.a(this.cWY, com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds120), 0);
        if (this.cma.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cma.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cma.setLayoutParams(layoutParams);
        }
        this.cma.setOnClickListener(this.cVA);
        this.cma.setReplyTimeVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setShareVisible(true);
        this.cma.setFrom(1);
        this.cma.setShareReportFrom(3);
        this.cma.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.akP() != null) {
                    k.this.akP().a(view2, k.this.cVz);
                }
                if (k.this.cVz != null && k.this.cVz.threadData != null) {
                    j.kr(k.this.cVz.threadData.getId());
                    if (!k.this.akT()) {
                        j.a(k.this.mTitle, k.this.cVz.WE().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                        j.a(k.this.cWV, k.this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                        j.a(k.this.cVx.getGodReplyContent(), k.this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                    }
                }
            }
        });
        this.cna = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cVx = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cVx.setOnClickListener(this.cVA);
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.cmO.bep.setOnClickListener(this.cVA);
        this.cmO.setFrom(1);
        this.cmO.setShareReportFrom(3);
        this.cmO.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.akP() != null) {
                    k.this.akP().a(view2, k.this.cVz);
                }
                if (k.this.cVz != null && k.this.cVz.threadData != null && view2 != k.this.cmO.beo) {
                    j.kr(k.this.cVz.threadData.getId());
                    if (!k.this.akT()) {
                        j.a(k.this.mTitle, k.this.cVz.WE().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                        j.a(k.this.cWV, k.this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                        j.a(k.this.cVx.getGodReplyContent(), k.this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                    }
                }
            }
        });
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
            aj.t(this.cWU, d.C0141d.transparent);
            this.cWW.onChangeSkinType();
            this.cma.onChangeSkinType();
            this.cVx.onChangeSkinType();
            this.clZ.onChangeSkinType();
            if (this.cmm != null) {
                this.cmm.onChangeSkinType();
            }
            aj.t(this.cVy, d.C0141d.cp_bg_line_e);
            if (this.cmO != null) {
                this.cmO.onChangeSkinType();
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
        this.cVz = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVA);
        }
        if (this.cmm != null) {
            if (this.cVz.aNh != null && this.cVz.aNh.size() > 0) {
                ah ahVar = new ah();
                ahVar.cV(this.cVz.WE().getTid());
                ahVar.setFid(this.cVz.WE().getFid());
                ahVar.a(this.cVz.aNh);
                this.cmm.setData(ahVar);
                this.cmm.setFirstRowSingleColumn(true);
                if (kVar.threadData.zn() != null && !StringUtils.isNull(kVar.threadData.zn().getUserId())) {
                    if (kVar.threadData.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.cmm.setVisibility(8);
                    } else if (this.cmm != null) {
                        this.cmm.setVisibility(this.cWX ? 0 : 8);
                    }
                }
            } else {
                this.cmm.setVisibility(8);
            }
        }
        this.clZ.setData(kVar.threadData);
        this.cVx.setFromCDN(this.aYZ);
        this.cVx.setGrayScaleMode(kVar.threadData.AC());
        this.cVx.setData(kVar.threadData.AA());
        if (!akT() && j.ks(this.cVz.threadData.getId())) {
            j.a(this.mTitle, this.cVz.WE().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            j.a(this.cWV, this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            j.a(this.cVx.getGodReplyContent(), this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        this.clZ.setUserAfterClickListener(this.bdT);
        final bd WE = kVar.WE();
        if (this.clZ.getHeaderImg() != null) {
            if (this.clZ.getIsSimpleThread()) {
                this.clZ.getHeaderImg().setVisibility(8);
                this.cmL.setVisibility(8);
            } else if (WE.zn() == null || WE.zn().getPendantData() == null || StringUtils.isNull(WE.zn().getPendantData().ya())) {
                this.cmL.setVisibility(8);
                this.clZ.getHeaderImg().setVisibility(0);
                this.clZ.getHeaderImg().setData(WE);
            } else {
                this.clZ.getHeaderImg().setVisibility(4);
                this.cmL.setVisibility(0);
                this.cmL.setData(WE);
            }
        }
        G(WE);
        ArrayList<VoiceData.VoiceModel> zC = kVar.threadData.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cWT.setVisibility(8);
            z = false;
        } else {
            this.cWT.setVisibility(0);
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
                    this.cWW.setVisibility(0);
                    this.cWW.setFromCDN(this.aYZ);
                    this.cWW.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.k.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<com.baidu.tieba.card.data.k> akP = k.this.akP();
                            if (akP != null) {
                                view.setTag("1");
                                akP.a(view, k.this.cVz);
                            }
                            if (z2) {
                                k.this.alj();
                            } else {
                                k.this.a(view, linkedList, i2, WE);
                            }
                        }
                    });
                    this.cWW.setImageMediaList(linkedList);
                } else {
                    this.cWW.setVisibility(8);
                }
            } else {
                this.cWW.setVisibility(8);
            }
        }
        alh();
        ali();
        setPageUniqueId(getTag());
        jX(WE.aQp);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void alh() {
        if (this.cWU != null && this.cWW != null && this.cVx != null) {
            if (this.cWW.getVisibility() == 8 && this.cVx.getVisibility() == 8) {
                this.cWU.setVisibility(0);
            } else {
                this.cWU.setVisibility(8);
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
                    imageUrlData.urlType = this.aYZ ? 13 : 14;
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

    public void setFromCDN(boolean z) {
        this.aYZ = z;
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
        if (this.cmm != null) {
            this.cmm.setUniqueId(bdUniqueId);
        }
        if (this.clZ != null) {
            this.clZ.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.cmm != null) {
            this.cmm.setEventCallback(aVar);
        }
    }

    public View akR() {
        return this.cVx;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.clZ != null) {
            return this.clZ.bdO;
        }
        return null;
    }

    public View akS() {
        if (this.clZ != null) {
            return this.clZ.bdP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        eI(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.cVz != null && this.cVz.threadData != null) {
            if (!akT()) {
                j.kr(this.cVz.threadData.getId());
                j.a(this.mTitle, this.cVz.WE().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                j.a(this.cWV, this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                j.a(this.cVx.getGodReplyContent(), this.cVz.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVz.threadData, null, j.zd(), 18003, true, false, false).addLocateParam(this.cVz.alC());
            addLocateParam.setForumId(String.valueOf(this.cVz.threadData.getFid()));
            addLocateParam.setForumName(this.cVz.threadData.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            j.kr(this.cVz.WE().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akT() {
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
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            j.a(this.mTitle, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        return true;
    }

    public void eK(boolean z) {
        if (this.cVy != null) {
            this.cVy.setVisibility(z ? 0 : 8);
        }
    }

    public void eL(boolean z) {
        this.cWX = z;
    }

    public void jX(int i) {
        if (this.cVz != null && this.cVz.threadData != null) {
            this.mStType = j.zd();
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setStType(this.mStType);
                this.cmO.setData(this.cVz.threadData);
                this.clZ.showForumNameView(false);
                return;
            }
            this.cma.setData(this.cVz.threadData);
            this.cma.setStType(this.mStType);
            this.cmO.setVisibility(8);
            this.clZ.showForumNameView(true);
        }
    }
}
