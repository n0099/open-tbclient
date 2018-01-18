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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
public class l extends a<com.baidu.tieba.card.data.l> {
    private boolean aXs;
    private final View.OnClickListener bce;
    private ThreadGodReplyLayout cSp;
    private View cSq;
    public ThreadSourceShareAndPraiseLayout cSr;
    private com.baidu.tieba.card.data.l cSs;
    private View.OnClickListener cSt;
    public PlayVoiceBntNew cTY;
    private View cTZ;
    private TextView cUa;
    private ConstrainImageGroup cUb;
    private boolean cUc;
    private RelativeLayout cUd;
    private final View.OnClickListener cUe;
    public ThreadUserInfoLayout ciK;
    public ThreadCommentAndPraiseInfoLayout ciL;
    private com.baidu.tieba.NEGFeedBack.c ciW;
    protected LinearLayout cjI;
    private HeadPendantClickableView cju;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ciW = null;
        this.mSkinType = 3;
        this.aXs = true;
        this.cUc = true;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akb() != null) {
                    l.this.akb().a(view, l.this.cSs);
                }
                l.this.ez(view == l.this.cSp);
            }
        };
        this.cUe = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.card.data.l> akb = l.this.akb();
                if (akb != null) {
                    view.setTag("2");
                    akb.a(view, l.this.cSs);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akb() != null) {
                    l.this.akb().a(view, l.this.cSs);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cju = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cju.getHeadView() != null) {
            this.cju.getHeadView().setIsRound(true);
            this.cju.getHeadView().setDrawBorder(false);
            this.cju.getHeadView().setDefaultResource(17170445);
            this.cju.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cju.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.cju.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cju.Dx();
        if (this.cju.getPendantView() != null) {
            this.cju.getPendantView().setIsRound(true);
            this.cju.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cTY = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cTY.setAfterClickListener(this.cUe);
        this.cUa = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cUa.setVisibility(8);
        this.cUb = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cSq = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.cUb.setChildClickListener(this.cSt);
        this.cUb.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.g(1.0d);
        this.cUb.setImageProcessor(fVar);
        this.cTZ = view.findViewById(d.g.divider_line_above_praise);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciK = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.ciW = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cUd = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.ciW.a(this.cUd, com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds120), 0);
        if (this.ciL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciL.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ciL.setLayoutParams(layoutParams);
        }
        this.ciL.setOnClickListener(this.cSt);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setShareVisible(true);
        this.ciL.setFrom(1);
        this.ciL.setShareReportFrom(3);
        this.ciL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.akb() != null) {
                    l.this.akb().a(view2, l.this.cSs);
                }
                if (l.this.cSs != null && l.this.cSs.threadData != null) {
                    k.kc(l.this.cSs.threadData.getId());
                    if (!l.this.akf()) {
                        k.a(l.this.mTitle, l.this.cSs.VK().getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
                        k.a(l.this.cUa, l.this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
                        k.a(l.this.cSp.getGodReplyContent(), l.this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
                    }
                }
            }
        });
        this.cjI = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cSp = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cSp.setOnClickListener(this.cSt);
        this.cSr = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.cSr.bcA.setOnClickListener(this.cSt);
        this.cSr.setFrom(1);
        this.cSr.setShareReportFrom(3);
        this.cSr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.akb() != null) {
                    l.this.akb().a(view2, l.this.cSs);
                }
                if (l.this.cSs != null && l.this.cSs.threadData != null) {
                    k.kc(l.this.cSs.threadData.getId());
                    if (!l.this.akf()) {
                        k.a(l.this.mTitle, l.this.cSs.VK().getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
                        k.a(l.this.cUa, l.this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
                        k.a(l.this.cSp.getGodReplyContent(), l.this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUb != null) {
            this.cUb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUb != null) {
            this.cUb.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.cTZ, d.C0107d.transparent);
            this.cUb.onChangeSkinType();
            this.ciL.onChangeSkinType();
            this.cSp.onChangeSkinType();
            this.ciK.onChangeSkinType();
            if (this.ciW != null) {
                this.ciW.onChangeSkinType();
            }
            aj.t(this.cSq, d.C0107d.cp_bg_line_e);
            if (this.cSr != null) {
                this.cSr.onChangeSkinType();
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
    public void a(com.baidu.tieba.card.data.l lVar) {
        boolean z;
        if (lVar == null || lVar.VK() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cSs = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        if (this.ciW != null) {
            if (this.cSs.aLV != null && this.cSs.aLV.size() > 0) {
                ah ahVar = new ah();
                ahVar.cK(this.cSs.VK().getTid());
                ahVar.setFid(this.cSs.VK().getFid());
                ahVar.a(this.cSs.aLV);
                this.ciW.setData(ahVar);
                this.ciW.setFirstRowSingleColumn(true);
                if (lVar.threadData.yS() != null && !StringUtils.isNull(lVar.threadData.yS().getUserId())) {
                    if (lVar.threadData.yS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.ciW.setVisibility(8);
                    } else if (this.ciW != null) {
                        this.ciW.setVisibility(this.cUc ? 0 : 8);
                    }
                }
            } else {
                this.ciW.setVisibility(8);
            }
        }
        this.ciK.setData(lVar.threadData);
        this.cSp.setFromCDN(this.aXs);
        this.cSp.setData(lVar.threadData.Ag());
        if (!akf() && k.kd(this.cSs.threadData.getId())) {
            k.a(this.mTitle, this.cSs.VK().getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            k.a(this.cUa, this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
            k.a(this.cSp.getGodReplyContent(), this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
        }
        this.ciK.setUserAfterClickListener(this.bce);
        final bd VK = lVar.VK();
        if (this.ciK.getHeaderImg() != null) {
            if (this.ciK.getIsSimpleThread()) {
                this.ciK.getHeaderImg().setVisibility(8);
                this.cju.setVisibility(8);
            } else if (VK.yS() == null || VK.yS().getPendantData() == null || StringUtils.isNull(VK.yS().getPendantData().xt())) {
                this.cju.setVisibility(8);
                this.ciK.getHeaderImg().setVisibility(0);
                this.ciK.getHeaderImg().setData(VK);
            } else {
                this.ciK.getHeaderImg().setVisibility(4);
                this.cju.setVisibility(0);
                this.cju.setData(VK);
            }
        }
        F(VK);
        ArrayList<VoiceData.VoiceModel> zh = lVar.threadData.zh();
        if (com.baidu.tbadk.core.util.v.E(zh)) {
            this.cTY.setVisibility(8);
            z = false;
        } else {
            this.cTY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zh.get(0);
            this.cTY.setVoiceModel(voiceModel);
            this.cTY.setTag(voiceModel);
            this.cTY.bnf();
            if (voiceModel != null) {
                this.cTY.qE(voiceModel.voice_status.intValue());
            }
            this.cTY.bwP();
            z = true;
        }
        if (this.cSs.cXd && z) {
            this.cUb.setVisibility(8);
        } else {
            ArrayList<MediaData> zd = VK.zd();
            if (com.baidu.tbadk.core.i.wA().wG() && com.baidu.tbadk.core.util.v.D(zd) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zd.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zd, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                    this.cUb.setVisibility(0);
                    this.cUb.setFromCDN(this.aXs);
                    this.cUb.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.l.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<com.baidu.tieba.card.data.l> akb = l.this.akb();
                            if (akb != null) {
                                view.setTag("1");
                                akb.a(view, l.this.cSs);
                            }
                            if (z2) {
                                l.this.akv();
                            } else {
                                l.this.a(view, linkedList, i2, VK);
                            }
                        }
                    });
                    this.cUb.setImageMediaList(linkedList);
                } else {
                    this.cUb.setVisibility(8);
                }
            } else {
                this.cUb.setVisibility(8);
            }
        }
        akt();
        aku();
        setPageUniqueId(getTag());
        lD(VK.aPa);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void akt() {
        if (this.cTZ != null && this.cUb != null && this.cSp != null) {
            if (this.cUb.getVisibility() == 8 && this.cSp.getVisibility() == 8) {
                this.cTZ.setVisibility(0);
            } else {
                this.cTZ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
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
                    imageUrlData.urlType = this.aXs ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yY(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXs, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void aku() {
        if (!this.cSs.brt) {
            this.cTY.setClickable(false);
        } else {
            this.cTY.setClickable(true);
        }
        int childCount = this.cUb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cUb.getChildAt(i);
            if (childAt != null) {
                if (!this.cSs.brt) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aXs = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cUb != null) {
            this.cUb.setPageUniqueId(bdUniqueId);
        }
        if (this.ciW != null) {
            this.ciW.setUniqueId(bdUniqueId);
        }
        if (this.ciK != null) {
            this.ciK.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.ciW != null) {
            this.ciW.setEventCallback(aVar);
        }
    }

    public View akd() {
        return this.cSp;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ciK != null) {
            return this.ciK.bbZ;
        }
        return null;
    }

    public View ake() {
        if (this.ciK != null) {
            return this.ciK.bca;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        ez(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(boolean z) {
        if (this.cSs != null && this.cSs.threadData != null) {
            if (!akf()) {
                k.kc(this.cSs.threadData.getId());
                k.a(this.mTitle, this.cSs.VK().getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
                k.a(this.cUa, this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
                k.a(this.cSp.getGodReplyContent(), this.cSs.threadData.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cSs.threadData, null, k.yI(), 18003, true, false, false).addLocateParam(this.cSs.akO());
            addLocateParam.setForumId(String.valueOf(this.cSs.threadData.getFid()));
            addLocateParam.setForumName(this.cSs.threadData.yY());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            k.kc(this.cSs.VK().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akf() {
        return this.cSs.cXd && !this.cSs.brt;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean F(bd bdVar) {
        SpannableStringBuilder j = bdVar.j(false, true);
        if (j == null || StringUtils.isNull(j.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            k.a(this.mTitle, bdVar.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        }
        return true;
    }

    public void eB(boolean z) {
        if (this.cSq != null) {
            this.cSq.setVisibility(z ? 0 : 8);
        }
    }

    public void eC(boolean z) {
        this.cUc = z;
    }

    public void lD(int i) {
        if (this.cSs != null && this.cSs.threadData != null) {
            this.mStType = k.yI();
            if (i == 1) {
                this.ciL.setVisibility(8);
                this.cSr.setStType(this.mStType);
                this.cSr.setData(this.cSs.threadData);
                this.ciK.showForumNameView(false);
                return;
            }
            this.ciL.setData(this.cSs.threadData);
            this.ciL.setStType(this.mStType);
            this.cSr.setVisibility(8);
            this.ciK.showForumNameView(true);
        }
    }
}
