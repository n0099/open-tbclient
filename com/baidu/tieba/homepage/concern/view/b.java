package com.baidu.tieba.homepage.concern.view;

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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<l> {
    private boolean ajn;
    private final View.OnClickListener anO;
    private final View.OnClickListener aob;
    private HeadPendantClickableView bZa;
    private View bZd;
    private l bZe;
    private View.OnClickListener bZf;
    public ThreadCommentAndPraiseInfoLayout bvH;
    protected LinearLayout bvK;
    public PlayVoiceBntNew caI;
    private TextView caK;
    private ConstrainImageGroup caL;
    private final View.OnClickListener caO;
    public ConcernThreadUserInfoLayout dnH;
    private View dnK;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajn = true;
        this.bZf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.abs() != null) {
                    b.this.abs().a(view, b.this.bZe);
                }
                b.this.abK();
            }
        };
        this.caO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<l> abs = b.this.abs();
                if (abs != null) {
                    view.setTag("2");
                    abs.a(view, b.this.bZe);
                }
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.abs() != null) {
                    b.this.abs().a(view, b.this.bZe);
                }
            }
        };
        this.anO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.abs() != null) {
                    b.this.abs().a(view, b.this.bZe);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bZa = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.bZa.getHeadView() != null) {
            this.bZa.getHeadView().setIsRound(true);
            this.bZa.getHeadView().setDrawBorder(false);
            this.bZa.getHeadView().setDefaultResource(17170445);
            this.bZa.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZa.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.bZa.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.bZa.getPendantView() != null) {
            this.bZa.getPendantView().setIsRound(true);
            this.bZa.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.caI = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.caI.setAfterClickListener(this.caO);
        this.caK = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.caK.setVisibility(8);
        this.caL = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.bZd = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.caL.setChildClickListener(this.bZf);
        this.caL.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caL.setImageProcessor(fVar);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.dnH = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.bvH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvH.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvH.setLayoutParams(layoutParams);
        }
        this.bvH.setOnClickListener(this.bZf);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setIsBarViewVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setShareVisible(true);
        this.bvH.setShareReportFrom(4);
        this.bvH.anM = this.currentPageType;
        this.bvH.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.abs() != null) {
                    b.this.abs().a(view2, b.this.bZe);
                }
            }
        });
        this.bvK = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.dnK = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.caL != null) {
            this.caL.setSingleImageRatio(d);
        }
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
            this.caL.onChangeSkinType();
            this.bvH.onChangeSkinType();
            this.dnH.onChangeSkinType();
            aj.k(this.bZd, d.C0082d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        boolean z;
        if (lVar == null || lVar.threadData == null) {
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
        this.dnH.setData(lVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!abw() && k.jR(this.bZe.threadData.getId())) {
            k.a(this.mTitle, this.bZe.Ox().getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            k.a(this.caK, this.bZe.threadData.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
        }
        this.dnH.setUserAfterClickListener(this.aob);
        this.bvH.setData(lVar.threadData);
        this.bvH.setStType(k.rn());
        final bd Ox = lVar.Ox();
        if (this.dnH.getHeaderImg() != null) {
            if (this.dnH.getIsSimpleThread()) {
                this.dnH.getHeaderImg().setVisibility(8);
                this.bZa.setVisibility(8);
            } else if (Ox.rx() == null || Ox.rx().getPendantData() == null || StringUtils.isNull(Ox.rx().getPendantData().pT())) {
                this.bZa.setVisibility(8);
                this.dnH.getHeaderImg().setVisibility(0);
                this.dnH.getHeaderImg().setData(Ox);
            } else {
                this.dnH.getHeaderImg().setVisibility(4);
            }
        }
        z(Ox);
        ArrayList<VoiceData.VoiceModel> rM = lVar.threadData.rM();
        if (com.baidu.tbadk.core.util.v.w(rM)) {
            this.caI.setVisibility(8);
            dR(false);
            z = false;
        } else {
            this.caI.setVisibility(0);
            dR(true);
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
            this.dnK.setVisibility(0);
        } else {
            ArrayList<MediaData> rI = lVar.threadData.rI();
            if (h.pa().pg() && com.baidu.tbadk.core.util.v.v(rI) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < rI.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rI, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.caL.setVisibility(0);
                    this.dnK.setVisibility(8);
                    this.caL.setFromCDN(this.ajn);
                    this.caL.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            v<l> abs = b.this.abs();
                            if (abs != null) {
                                view.setTag("1");
                                abs.a(view, b.this.bZe);
                            }
                            if (z2) {
                                b.this.abK();
                            } else {
                                b.this.a(view, linkedList, i2, Ox);
                            }
                        }
                    });
                    this.caL.setImageMediaList(linkedList);
                } else {
                    this.caL.setVisibility(8);
                    this.dnK.setVisibility(0);
                }
            } else {
                this.caL.setVisibility(8);
                this.dnK.setVisibility(0);
            }
        }
        abJ();
        setPageUniqueId(getTag());
        anV();
    }

    private void dR(boolean z) {
        if (this.caL != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caL.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.caL.setLayoutParams(layoutParams);
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
        if (this.dnH != null) {
            this.dnH.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dnH != null) {
            return this.dnH.getHeaderImg();
        }
        return null;
    }

    public View abv() {
        if (this.dnH != null) {
            return this.dnH.anX;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abK() {
        if (this.bZe != null && this.bZe.threadData != null) {
            if (!abw()) {
                k.jQ(this.bZe.threadData.getId());
                k.a(this.mTitle, this.bZe.Ox().getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
                k.a(this.caK, this.bZe.threadData.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bZe.threadData, null, k.rn(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.bZe.threadData.getFid()));
            createFromThreadCfg.setForumName(this.bZe.threadData.rD());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
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

    private void anV() {
        if (this.mTitle != null && this.caI != null && this.caL != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.caI.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.caI.setLayoutParams(layoutParams);
            if (this.caI.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.caL.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.caL.setLayoutParams(layoutParams2);
            }
        }
    }
}
