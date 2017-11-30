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
    private boolean ajn;
    private final View.OnClickListener aob;
    private HeadPendantClickableView bZa;
    private ThreadGodReplyLayout bZb;
    private com.baidu.tieba.NEGFeedBack.c bZc;
    private View bZd;
    private com.baidu.tieba.card.data.l bZe;
    private View.OnClickListener bZf;
    public ThreadUserInfoLayout bvD;
    public ThreadCommentAndPraiseInfoLayout bvH;
    protected LinearLayout bvK;
    public PlayVoiceBntNew caI;
    private View caJ;
    private TextView caK;
    private ConstrainImageGroup caL;
    private boolean caM;
    private RelativeLayout caN;
    private final View.OnClickListener caO;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZc = null;
        this.mSkinType = 3;
        this.ajn = true;
        this.caM = true;
        this.bZf = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abs() != null) {
                    l.this.abs().a(view, l.this.bZe);
                }
                l.this.dN(view == l.this.bZb);
            }
        };
        this.caO = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.card.data.l> abs = l.this.abs();
                if (abs != null) {
                    view.setTag("2");
                    abs.a(view, l.this.bZe);
                }
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abs() != null) {
                    l.this.abs().a(view, l.this.bZe);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bZa = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZa.getHeadView() != null) {
            this.bZa.getHeadView().setIsRound(true);
            this.bZa.getHeadView().setDrawBorder(false);
            this.bZa.getHeadView().setDefaultResource(17170445);
            this.bZa.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZa.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.bZa.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZa.wk();
        if (this.bZa.getPendantView() != null) {
            this.bZa.getPendantView().setIsRound(true);
            this.bZa.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.caI = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.caI.setAfterClickListener(this.caO);
        this.caK = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.caK.setVisibility(8);
        this.caL = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.bZd = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.caL.setChildClickListener(this.bZf);
        this.caL.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caL.setImageProcessor(fVar);
        this.caJ = view.findViewById(d.g.divider_line_above_praise);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bZc = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.caN = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.bZc.a(this.caN, com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds120), 0);
        if (this.bvH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvH.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvH.setLayoutParams(layoutParams);
        }
        this.bvH.setOnClickListener(this.bZf);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setShareVisible(true);
        this.bvH.setFrom(1);
        this.bvH.setShareReportFrom(3);
        this.bvH.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.abs() != null) {
                    l.this.abs().a(view2, l.this.bZe);
                }
            }
        });
        this.bvK = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.bZb = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bZb.setOnClickListener(this.bZf);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caL != null) {
            this.caL.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caL != null) {
            this.caL.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.caJ, d.C0082d.transparent);
            this.caL.onChangeSkinType();
            this.bvH.onChangeSkinType();
            this.bZb.onChangeSkinType();
            this.bvD.onChangeSkinType();
            if (this.bZc != null) {
                this.bZc.onChangeSkinType();
            }
            aj.k(this.bZd, d.C0082d.cp_bg_line_e);
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
        if (lVar == null || lVar.Ox() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bZe = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZf);
        }
        if (this.bZc != null) {
            if (this.bZe.XE != null && this.bZe.XE.size() > 0) {
                ah ahVar = new ah();
                ahVar.cD(this.bZe.Ox().getTid());
                ahVar.setFid(this.bZe.Ox().getFid());
                ahVar.a(this.bZe.XE);
                this.bZc.setData(ahVar);
                this.bZc.setFirstRowSingleColumn(true);
                if (lVar.threadData.rx() != null && !StringUtils.isNull(lVar.threadData.rx().getUserId())) {
                    if (lVar.threadData.rx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bZc.setVisibility(8);
                    } else if (this.bZc != null) {
                        this.bZc.setVisibility(this.caM ? 0 : 8);
                    }
                }
            } else {
                this.bZc.setVisibility(8);
            }
        }
        this.bvD.setData(lVar.threadData);
        this.bZb.setFromCDN(this.ajn);
        this.bZb.setData(lVar.threadData.sO());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bZb.onChangeSkinType();
        if (!abw() && k.jR(this.bZe.threadData.getId())) {
            k.a(this.mTitle, this.bZe.Ox().getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            k.a(this.caK, this.bZe.threadData.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
            k.a(this.bZb.getGodReplyContent(), this.bZe.threadData.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
        }
        this.bvD.setUserAfterClickListener(this.aob);
        this.bvH.setData(lVar.threadData);
        this.mStType = k.rn();
        this.bvH.setStType(this.mStType);
        final bd Ox = lVar.Ox();
        if (this.bvD.getHeaderImg() != null) {
            if (this.bvD.getIsSimpleThread()) {
                this.bvD.getHeaderImg().setVisibility(8);
                this.bZa.setVisibility(8);
            } else if (Ox.rx() == null || Ox.rx().getPendantData() == null || StringUtils.isNull(Ox.rx().getPendantData().pT())) {
                this.bZa.setVisibility(8);
                this.bvD.getHeaderImg().setVisibility(0);
                this.bvD.getHeaderImg().setData(Ox);
            } else {
                this.bvD.getHeaderImg().setVisibility(4);
                this.bZa.setVisibility(0);
                this.bZa.setData(Ox);
            }
        }
        z(Ox);
        ArrayList<VoiceData.VoiceModel> rM = lVar.threadData.rM();
        if (com.baidu.tbadk.core.util.v.w(rM)) {
            this.caI.setVisibility(8);
            z = false;
        } else {
            this.caI.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rM.get(0);
            this.caI.setVoiceModel(voiceModel);
            this.caI.setTag(voiceModel);
            this.caI.blz();
            if (voiceModel != null) {
                this.caI.nM(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bZe.cdF && z) {
            this.caL.setVisibility(8);
        } else {
            ArrayList<MediaData> rI = Ox.rI();
            if (com.baidu.tbadk.core.h.pa().pg() && com.baidu.tbadk.core.util.v.v(rI) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < rI.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rI, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.caL.setVisibility(0);
                    this.caL.setFromCDN(this.ajn);
                    this.caL.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.l.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            v<com.baidu.tieba.card.data.l> abs = l.this.abs();
                            if (abs != null) {
                                view.setTag("1");
                                abs.a(view, l.this.bZe);
                            }
                            if (z2) {
                                l.this.abK();
                            } else {
                                l.this.a(view, linkedList, i2, Ox);
                            }
                        }
                    });
                    this.caL.setImageMediaList(linkedList);
                } else {
                    this.caL.setVisibility(8);
                }
            } else {
                this.caL.setVisibility(8);
            }
        }
        abI();
        abJ();
        setPageUniqueId(getTag());
    }

    private void abI() {
        if (this.caJ != null && this.caL != null && this.bZb != null) {
            if (this.caL.getVisibility() == 8 && this.bZb.getVisibility() == 8) {
                this.caJ.setVisibility(0);
            } else {
                this.caJ.setVisibility(8);
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
                    imageUrlData.urlType = this.ajn ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rD(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void abJ() {
        if (!this.bZe.aDh) {
            this.caI.setClickable(false);
        } else {
            this.caI.setClickable(true);
        }
        int childCount = this.caL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caL.getChildAt(i);
            if (childAt != null) {
                if (!this.bZe.aDh) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajn = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.caL != null) {
            this.caL.setPageUniqueId(bdUniqueId);
        }
        if (this.bZc != null) {
            this.bZc.setUniqueId(bdUniqueId);
        }
        if (this.bvD != null) {
            this.bvD.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.bZc != null) {
            this.bZc.setEventCallback(aVar);
        }
    }

    public View abu() {
        return this.bZb;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvD != null) {
            return this.bvD.anW;
        }
        return null;
    }

    public View abv() {
        if (this.bvD != null) {
            return this.bvD.anX;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abK() {
        dN(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dN(boolean z) {
        if (this.bZe != null && this.bZe.threadData != null) {
            if (!abw()) {
                k.jQ(this.bZe.threadData.getId());
                k.a(this.mTitle, this.bZe.Ox().getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
                k.a(this.caK, this.bZe.threadData.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
                k.a(this.bZb.getGodReplyContent(), this.bZe.threadData.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bZe.threadData, null, k.rn(), 18003, true, false, false).addLocateParam(this.bZe.abW());
            addLocateParam.setForumId(String.valueOf(this.bZe.threadData.getFid()));
            addLocateParam.setForumName(this.bZe.threadData.rD());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            k.jQ(this.bZe.Ox().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abw() {
        return this.bZe.cdF && !this.bZe.aDh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean z(bd bdVar) {
        SpannableStringBuilder g = bdVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(g));
            this.mTitle.setText(g);
            k.a(this.mTitle, bdVar.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        }
        return true;
    }

    public void dP(boolean z) {
        if (this.bZd != null) {
            this.bZd.setVisibility(z ? 0 : 8);
        }
    }

    public void dQ(boolean z) {
        this.caM = z;
    }
}
