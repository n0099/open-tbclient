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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class p extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private boolean aAb;
    private final View.OnClickListener aGk;
    private String bVS;
    private HeadPendantClickableView bWP;
    public ThreadSourceShareAndPraiseLayout bWS;
    public ThreadUserInfoLayout bWe;
    public ThreadCommentAndPraiseInfoLayout bWf;
    private NEGFeedBackView bWq;
    protected LinearLayout bXd;
    private ThreadGodReplyLayout cKD;
    private View cKE;
    private com.baidu.tieba.card.data.k cKF;
    private View.OnClickListener cKG;
    public PlayVoiceBntNew cNk;
    private View cNl;
    private TextView cNm;
    private ConstrainImageGroup cNn;
    private boolean cNo;
    private RelativeLayout cNp;
    private final View.OnClickListener cNq;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bWq = null;
        this.mSkinType = 3;
        this.aAb = true;
        this.cNo = true;
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cKF != null) {
                    p.this.cKF.aBa = 1;
                }
                if (p.this.anP() != null) {
                    p.this.anP().a(view, p.this.cKF);
                }
                p.this.fb(view == p.this.cKD);
            }
        };
        this.cNq = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.card.data.k> anP = p.this.anP();
                if (anP != null) {
                    view.setTag("2");
                    anP.a(view, p.this.cKF);
                }
            }
        };
        this.aGk = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cKF == null) {
                    if (p.this.anP() != null) {
                        p.this.anP().a(view, p.this.cKF);
                        return;
                    }
                    return;
                }
                if (view == p.this.bWe.getUserName()) {
                    p.this.cKF.aBa = 3;
                } else if (view == p.this.bWe.getHeaderImg()) {
                    p.this.cKF.aBa = 4;
                } else if (view == p.this.cNn) {
                    p.this.cKF.aBa = 2;
                    return;
                } else {
                    p.this.cKF.aBa = 1;
                }
                if (p.this.anP() != null) {
                    p.this.anP().a(view, p.this.cKF);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bWP = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bWP.getHeadView() != null) {
            this.bWP.getHeadView().setIsRound(true);
            this.bWP.getHeadView().setDrawBorder(false);
            this.bWP.getHeadView().setDefaultResource(17170445);
            this.bWP.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bWP.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bWP.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0175e.ds70));
        }
        this.bWP.setHasPendantStyle();
        if (this.bWP.getPendantView() != null) {
            this.bWP.getPendantView().setIsRound(true);
            this.bWP.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cNk = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cNk.setAfterClickListener(this.cNq);
        this.cNm = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cNm.setVisibility(8);
        this.cNn = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cKE = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds20);
        this.cNn.setChildClickListener(this.cKG);
        this.cNn.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cNn.setImageProcessor(eVar);
        this.cNl = view.findViewById(e.g.divider_line_above_praise);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bWe = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bWq = new NEGFeedBackView(this.mPageContext);
        this.cNp = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.bWq.a(this.cNp, com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds120), 0);
        if (this.bWf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWf.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bWf.setLayoutParams(layoutParams);
        }
        this.bWf.setOnClickListener(this.cKG);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setShareVisible(true);
        this.bWf.setFrom(1);
        this.bWf.setDisPraiseFrom(1);
        this.bWf.setShareReportFrom(3);
        this.bWf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.anP() != null) {
                    p.this.anP().a(view2, p.this.cKF);
                }
                if (p.this.cKF != null && p.this.cKF.threadData != null) {
                    o.md(p.this.cKF.threadData.getId());
                    if (!p.this.anT()) {
                        o.a(p.this.mTitle, p.this.cKF.YB().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cNm, p.this.cKF.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cKD.getGodReplyContent(), p.this.cKF.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
        this.bXd = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.cKD = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cKD.setOnClickListener(this.cKG);
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        this.bWS.aFS.setOnClickListener(this.cKG);
        this.bWS.setFrom(1);
        this.bWS.setShareReportFrom(3);
        this.bWS.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.anP() != null) {
                    p.this.anP().a(view2, p.this.cKF);
                }
                if (p.this.cKF != null && p.this.cKF.threadData != null && view2 != p.this.bWS.aFR) {
                    o.md(p.this.cKF.threadData.getId());
                    if (!p.this.anT()) {
                        o.a(p.this.mTitle, p.this.cKF.YB().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cNm, p.this.cKF.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cKD.getGodReplyContent(), p.this.cKF.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cNn != null) {
            this.cNn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cNn != null) {
            this.cNn.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.cNl, e.d.transparent);
            this.cNn.onChangeSkinType();
            this.bWf.onChangeSkinType();
            this.cKD.onChangeSkinType();
            this.bWe.onChangeSkinType();
            if (this.bWq != null) {
                this.bWq.onChangeSkinType();
            }
            al.j(this.cKE, e.d.cp_bg_line_e);
            if (this.bWS != null) {
                this.bWS.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        boolean z;
        if (kVar == null || kVar.YB() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cKF = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cKG);
        }
        if (this.bWq != null) {
            if (this.cKF.anO != null && this.cKF.anO.size() > 0) {
                ah ahVar = new ah();
                ahVar.setTid(this.cKF.YB().getTid());
                ahVar.setFid(this.cKF.YB().getFid());
                ahVar.a(this.cKF.anO);
                this.bWq.setData(ahVar);
                this.bWq.setFirstRowSingleColumn(true);
                if (kVar.threadData.yv() != null && !StringUtils.isNull(kVar.threadData.yv().getUserId())) {
                    if (kVar.threadData.yv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bWq.setVisibility(8);
                    } else if (this.bWq != null) {
                        this.bWq.setVisibility(this.cNo ? 0 : 8);
                    }
                }
            } else {
                this.bWq.setVisibility(8);
            }
        }
        this.bWe.setData(kVar.threadData);
        this.cKD.setFromCDN(this.aAb);
        this.cKD.setData(kVar.threadData.zM());
        if (!anT() && o.me(this.cKF.threadData.getId())) {
            o.a(this.mTitle, this.cKF.YB().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cNm, this.cKF.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cKD.getGodReplyContent(), this.cKF.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.bWe.setUserAfterClickListener(this.aGk);
        final bb YB = kVar.YB();
        if (this.bWe.getHeaderImg() != null) {
            if (this.bWe.getIsSimpleThread()) {
                this.bWe.getHeaderImg().setVisibility(8);
                this.bWP.setVisibility(8);
            } else if (YB.yv() == null || YB.yv().getPendantData() == null || StringUtils.isNull(YB.yv().getPendantData().xf())) {
                this.bWP.setVisibility(8);
                this.bWe.getHeaderImg().setVisibility(0);
                this.bWe.getHeaderImg().setData(YB);
            } else {
                this.bWe.getHeaderImg().setVisibility(4);
                this.bWP.setVisibility(0);
                this.bWP.setData(YB);
            }
        }
        L(YB);
        M(YB);
        ArrayList<VoiceData.VoiceModel> yK = kVar.threadData.yK();
        if (com.baidu.tbadk.core.util.v.J(yK)) {
            this.cNk.setVisibility(8);
            z = false;
        } else {
            this.cNk.setVisibility(0);
            VoiceData.VoiceModel voiceModel = yK.get(0);
            this.cNk.setVoiceModel(voiceModel);
            this.cNk.setTag(voiceModel);
            this.cNk.aUR();
            if (voiceModel != null) {
                this.cNk.pJ(voiceModel.voice_status.intValue());
            }
            this.cNk.bDm();
            z = true;
        }
        if (this.cKF.cQt && z) {
            this.cNn.setVisibility(8);
        } else {
            ArrayList<MediaData> yG = YB.yG();
            if (com.baidu.tbadk.core.i.ws().ww() && com.baidu.tbadk.core.util.v.I(yG) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < yG.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(yG, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.I(linkedList) > 0) {
                    this.cNn.setVisibility(0);
                    this.cNn.setFromCDN(this.aAb);
                    this.cNn.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<com.baidu.tieba.card.data.k> anP = p.this.anP();
                            if (anP != null) {
                                view.setTag("1");
                                if (p.this.aGk != null) {
                                    p.this.aGk.onClick(p.this.cNn);
                                }
                                anP.a(view, p.this.cKF);
                            }
                            if (z2) {
                                p.this.aoj();
                            } else {
                                p.this.a(view, linkedList, i2, YB);
                            }
                        }
                    });
                    this.cNn.setImageMediaList(linkedList);
                } else {
                    this.cNn.setVisibility(8);
                }
            } else {
                this.cNn.setVisibility(8);
            }
        }
        aoh();
        aoi();
        setPageUniqueId(getTag());
        ik(hb(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aoh() {
        if (this.cNl != null && this.cNn != null && this.cKD != null) {
            if (this.cNn.getVisibility() == 8 && this.cKD.getVisibility() == 8) {
                this.cNl.setVisibility(0);
            } else {
                this.cNl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aAb ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bbVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.yB(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aAb, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void aoi() {
        if (!this.cKF.aVo) {
            this.cNk.setClickable(false);
        } else {
            this.cNk.setClickable(true);
        }
        int childCount = this.cNn.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cNn.getChildAt(i);
            if (childAt != null) {
                if (!this.cKF.aVo) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aAb = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cNn != null) {
            this.cNn.setPageUniqueId(bdUniqueId);
        }
        if (this.bWq != null) {
            this.bWq.setUniqueId(bdUniqueId);
        }
        if (this.bWe != null) {
            this.bWe.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bWq != null) {
            this.bWq.setEventCallback(aVar);
        }
    }

    public View anR() {
        return this.cKD;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bWe != null) {
            return this.bWe.aFX;
        }
        return null;
    }

    public View anS() {
        if (this.bWe != null) {
            return this.bWe.aFZ;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoj() {
        fb(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(boolean z) {
        if (this.cKF != null && this.cKF.threadData != null) {
            if (!anT()) {
                o.md(this.cKF.threadData.getId());
                o.a(this.mTitle, this.cKF.YB().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cNm, this.cKF.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                o.a(this.cKD.getGodReplyContent(), this.cKF.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cKF.threadData, null, o.yj(), 18003, true, false, false).addLocateParam(this.cKF.aoA());
            addLocateParam.setForumId(String.valueOf(this.cKF.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cKF.threadData.yB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.md(this.cKF.YB().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anT() {
        return this.cKF.cQt && !this.cKF.aVo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean L(bb bbVar) {
        SpannableStringBuilder i = bbVar.i(false, true);
        if (i == null || StringUtils.isNull(i.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        return true;
    }

    private void M(bb bbVar) {
        if (bbVar != null && hb(2) == 1) {
            SpannableString zO = bbVar.zO();
            if (zO != null && !ao.isEmpty(zO.toString())) {
                this.cNm.setVisibility(0);
                this.cNm.setOnTouchListener(new com.baidu.tieba.view.k(zO));
                this.cNm.setText(zO);
                o.a(this.cNm, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cNm.setVisibility(8);
            return;
        }
        this.cNm.setVisibility(8);
    }

    public void fd(boolean z) {
        if (this.cKE != null) {
            this.cKE.setVisibility(z ? 0 : 8);
        }
    }

    public void fe(boolean z) {
        this.cNo = z;
    }

    public void ik(int i) {
        if (this.cKF != null && this.cKF.threadData != null) {
            this.mStType = o.yj();
            if (i == 1) {
                this.bWf.setVisibility(8);
                this.bWS.setStType(this.mStType);
                this.bWS.setData(this.cKF.threadData);
                this.bWe.showForumNameView(false);
                return;
            }
            this.bWf.setData(this.cKF.threadData);
            this.bWf.setStType(this.mStType);
            this.bWS.setVisibility(8);
            this.bWe.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cNn != null) {
            this.cNn.setPreloadSizeReadyCallback(bVar);
        }
    }
}
