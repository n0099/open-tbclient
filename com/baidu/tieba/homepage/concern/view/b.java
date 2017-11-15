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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<l> {
    private boolean aiR;
    private final View.OnClickListener anR;
    private final View.OnClickListener anz;
    private HeadPendantClickableView bRc;
    private View bRf;
    private l bRg;
    private View.OnClickListener bRh;
    public PlayVoiceBntNew bSW;
    private TextView bSY;
    private ConstrainImageGroup bSZ;
    private final View.OnClickListener bTa;
    public ThreadCommentAndPraiseInfoLayout boM;
    protected LinearLayout boQ;
    public ConcernThreadUserInfoLayout dfa;
    private View dfd;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiR = true;
        this.bRh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ZJ() != null) {
                    b.this.ZJ().a(view, b.this.bRg);
                }
                b.this.aab();
            }
        };
        this.bTa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<l> ZJ = b.this.ZJ();
                if (ZJ != null) {
                    view.setTag("2");
                    ZJ.a(view, b.this.bRg);
                }
            }
        };
        this.anR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ZJ() != null) {
                    b.this.ZJ().a(view, b.this.bRg);
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ZJ() != null) {
                    b.this.ZJ().a(view, b.this.bRg);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bRc = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.bRc.getHeadView() != null) {
            this.bRc.getHeadView().setIsRound(true);
            this.bRc.getHeadView().setDrawBorder(false);
            this.bRc.getHeadView().setDefaultResource(17170445);
            this.bRc.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bRc.getHeadView().setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.bRc.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.bRc.getPendantView() != null) {
            this.bRc.getPendantView().setIsRound(true);
            this.bRc.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.bSW = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.bSW.setAfterClickListener(this.bTa);
        this.bSY = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.bSY.setVisibility(8);
        this.bSZ = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.bRf = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.bSZ.setChildClickListener(this.bRh);
        this.bSZ.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bSZ.setImageProcessor(fVar);
        this.boM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.dfa = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.boM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.boM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.boM.setLayoutParams(layoutParams);
        }
        this.boM.setOnClickListener(this.bRh);
        this.boM.setReplyTimeVisible(false);
        this.boM.setIsBarViewVisible(false);
        this.boM.setShowPraiseNum(true);
        this.boM.setNeedAddPraiseIcon(true);
        this.boM.setNeedAddReplyIcon(true);
        this.boM.setShareVisible(true);
        this.boM.setShareReportFrom(4);
        this.boM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.ZJ() != null) {
                    b.this.ZJ().a(view2, b.this.bRg);
                }
            }
        });
        this.boQ = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.dfd = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.bSZ != null) {
            this.bSZ.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bSZ != null) {
            this.bSZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bSZ != null) {
            this.bSZ.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.dfd, d.C0080d.cp_bg_line_e);
            this.bSZ.onChangeSkinType();
            this.boM.onChangeSkinType();
            this.dfa.onChangeSkinType();
            aj.k(this.bRf, d.C0080d.cp_bg_line_e);
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
        if (lVar == null || lVar.blt == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bRg = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bRh);
        }
        this.dfa.setData(lVar.blt);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!ZN() && m.jM(this.bRg.blt.getId())) {
            m.a(this.mTitle, this.bRg.NA().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
            m.a(this.bSY, this.bRg.blt.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        }
        this.dfa.setUserAfterClickListener(this.anR);
        this.boM.setData(lVar.blt);
        this.boM.setStType(m.rj());
        final bh NA = lVar.NA();
        if (this.dfa.getHeaderImg() != null) {
            if (this.dfa.getIsSimpleThread()) {
                this.dfa.getHeaderImg().setVisibility(8);
                this.bRc.setVisibility(8);
            } else if (NA.rt() == null || NA.rt().getPendantData() == null || StringUtils.isNull(NA.rt().getPendantData().pQ())) {
                this.bRc.setVisibility(8);
                this.dfa.getHeaderImg().setVisibility(0);
                this.dfa.getHeaderImg().setData(NA);
            } else {
                this.dfa.getHeaderImg().setVisibility(4);
            }
        }
        y(NA);
        ArrayList<VoiceData.VoiceModel> rI = lVar.blt.rI();
        if (v.v(rI)) {
            this.bSW.setVisibility(8);
            dE(false);
            z = false;
        } else {
            this.bSW.setVisibility(0);
            dE(true);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bSW.setVoiceModel(voiceModel);
            this.bSW.setTag(voiceModel);
            this.bSW.bjz();
            if (voiceModel != null) {
                this.bSW.ny(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bRg.bVl && z) {
            this.bSZ.setVisibility(8);
            this.dfd.setVisibility(0);
        } else {
            ArrayList<MediaData> rE = lVar.blt.rE();
            if (h.oT().oZ() && v.u(rE) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < rE.size(); i++) {
                    MediaData mediaData = (MediaData) v.c(rE, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.u(linkedList) > 0) {
                    this.bSZ.setVisibility(0);
                    this.dfd.setVisibility(8);
                    this.bSZ.setFromCDN(this.aiR);
                    this.bSZ.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            x<l> ZJ = b.this.ZJ();
                            if (ZJ != null) {
                                view.setTag("1");
                                ZJ.a(view, b.this.bRg);
                            }
                            if (z2) {
                                b.this.aab();
                            } else {
                                b.this.a(view, linkedList, i2, NA);
                            }
                        }
                    });
                    this.bSZ.setImageMediaList(linkedList);
                } else {
                    this.bSZ.setVisibility(8);
                    this.dfd.setVisibility(0);
                }
            } else {
                this.bSZ.setVisibility(8);
                this.dfd.setVisibility(0);
            }
        }
        aaa();
        setPageUniqueId(getTag());
        aac();
    }

    private void dE(boolean z) {
        if (this.bSZ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSZ.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.bSZ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                    imageUrlData.urlType = this.aiR ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.rz(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void aaa() {
        if (!this.bRg.aCE) {
            this.bSW.setClickable(false);
        } else {
            this.bSW.setClickable(true);
        }
        int childCount = this.bSZ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bSZ.getChildAt(i);
            if (childAt != null) {
                if (!this.bRg.aCE) {
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
        if (this.bSZ != null) {
            this.bSZ.setPageUniqueId(bdUniqueId);
        }
        if (this.dfa != null) {
            this.dfa.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dfa != null) {
            return this.dfa.getHeaderImg();
        }
        return null;
    }

    public View ZM() {
        if (this.dfa != null) {
            return this.dfa.anN;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        if (this.bRg != null && this.bRg.blt != null) {
            if (!ZN()) {
                m.jL(this.bRg.blt.getId());
                m.a(this.mTitle, this.bRg.NA().getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
                m.a(this.bSY, this.bRg.blt.getId(), d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bRg.blt, null, m.rj(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.bRg.blt.getFid()));
            createFromThreadCfg.setForumName(this.bRg.blt.rz());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean ZN() {
        return this.bRg.bVl && !this.bRg.aCE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean y(bh bhVar) {
        SpannableStringBuilder g = bhVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(g));
            this.mTitle.setText(g);
            m.a(this.mTitle, bhVar.getId(), d.C0080d.cp_cont_b, d.C0080d.cp_cont_d);
        }
        return true;
    }

    private void aac() {
        if (this.mTitle != null && this.bSW != null && this.bSZ != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bSW.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.bSW.setLayoutParams(layoutParams);
            if (this.bSW.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bSZ.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.bSZ.setLayoutParams(layoutParams2);
            }
        }
    }
}
