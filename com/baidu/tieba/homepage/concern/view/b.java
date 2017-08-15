package com.baidu.tieba.homepage.concern.view;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.f;
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
    private boolean ajL;
    private final View.OnClickListener aoH;
    private final View.OnClickListener aoX;
    private l bGA;
    private View.OnClickListener bGB;
    private HeadPendantClickableView bGv;
    private View bGz;
    public PlayVoiceBntNew bIj;
    private TextView bIk;
    private ConstrainImageGroup bIl;
    private final View.OnClickListener bIm;
    public ThreadCommentAndPraiseInfoLayout bld;
    protected LinearLayout blh;
    public ConcernThreadUserInfoLayout cSG;
    private int mSkinType;
    private TextView mTitle;
    private TbPageContext<?> oV;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajL = true;
        this.bGB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.WA() != null) {
                    b.this.WA().a(view, b.this.bGA);
                }
                b.this.WQ();
            }
        };
        this.bIm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<l> WA = b.this.WA();
                if (WA != null) {
                    view.setTag("2");
                    WA.a(view, b.this.bGA);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.WA() != null) {
                    b.this.WA().a(view, b.this.bGA);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.WA() != null) {
                    b.this.WA().a(view, b.this.bGA);
                }
            }
        };
        View view = getView();
        this.oV = tbPageContext;
        this.bGv = (HeadPendantClickableView) view.findViewById(d.h.card_concern_normal_thread_user_pendant_header);
        if (this.bGv.getHeadView() != null) {
            this.bGv.getHeadView().setIsRound(true);
            this.bGv.getHeadView().setDrawBorder(false);
            this.bGv.getHeadView().setDefaultResource(17170445);
            this.bGv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGv.getHeadView().setRadius(k.g(this.oV.getPageActivity(), d.f.ds60));
        }
        if (this.bGv.getPendantView() != null) {
            this.bGv.getPendantView().setIsRound(true);
            this.bGv.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_normal_thread_title);
        this.bIj = (PlayVoiceBntNew) view.findViewById(d.h.card_concern_normal_thread_abstract_voice);
        this.bIj.setAfterClickListener(this.bIm);
        this.bIk = (TextView) view.findViewById(d.h.card_concern_normal_thread_abstract);
        this.bIl = (ConstrainImageGroup) view.findViewById(d.h.card_concern_normal_thread_img_layout);
        this.bGz = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bIl.setChildClickListener(this.bGB);
        this.bIl.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.e(1.0d);
        this.bIl.setImageProcessor(fVar);
        this.bld = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_normal_thread_info_layout);
        this.cSG = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_normal_thread_user_info_layout);
        if (this.bld.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bld.setLayoutParams(layoutParams);
        }
        this.bld.setOnClickListener(this.bGB);
        this.bld.setReplyTimeVisible(false);
        this.bld.setIsBarViewVisible(false);
        this.bld.setShowPraiseNum(true);
        this.bld.setNeedAddPraiseIcon(true);
        this.bld.setNeedAddReplyIcon(true);
        this.bld.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bld.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.WA() != null) {
                    b.this.WA().a(view2, b.this.bGA);
                }
            }
        });
        this.blh = (LinearLayout) view.findViewById(d.h.card_concern_normal_thread_content_layout);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bIl != null) {
            this.bIl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bIl != null) {
            this.bIl.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bIl.onChangeSkinType();
            this.bld.onChangeSkinType();
            this.cSG.onChangeSkinType();
            ai.k(this.bGz, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_concern_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0215  */
    @Override // com.baidu.tieba.card.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(l lVar) {
        boolean z;
        StringBuilder sb;
        ArrayList<MediaData> rP;
        int i;
        boolean z2;
        ArrayList<VoiceData.VoiceModel> rT;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        boolean z6 = false;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bGA = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGB);
        }
        this.cSG.a(lVar.threadData);
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        if (!WE() && m.jf(this.bGA.threadData.getId())) {
            m.a(this.mTitle, this.bGA.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIk, this.bGA.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cSG.setUserAfterClickListener(this.aoX);
        this.bld.a(lVar.threadData);
        final bl MF = lVar.MF();
        if (this.cSG.getHeaderImg() != null) {
            if (this.cSG.getIsSimpleThread()) {
                this.cSG.getHeaderImg().setVisibility(8);
                this.bGv.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pV())) {
                this.bGv.setVisibility(8);
                this.cSG.getHeaderImg().setVisibility(0);
                this.cSG.getHeaderImg().setData(MF);
            } else {
                this.cSG.getHeaderImg().setVisibility(4);
            }
        }
        m.b(MF, this.mTitle);
        if ((StringUtils.isNull(MF.getTitle()) && (MF.rD() == null || MF.rD().size() == 0)) || MF.rU() == 1) {
            MF.e(false, true);
            if (MF.sf() == null || StringUtils.isNull(MF.sf().toString())) {
                z = false;
                sb = new StringBuilder();
                if (MF.rN() != null && !StringUtils.isNull(MF.rN())) {
                    sb.append(MF.rN());
                }
                rP = lVar.threadData.rP();
                if (rP == null) {
                    i = rP.size();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 0; i2 < i; i2++) {
                        if (rP.get(i2).getVideoUrl() != null && rP.get(i2).getVideoUrl().endsWith("swf")) {
                            sb2.append(rP.get(i2).getVideoUrl());
                        }
                    }
                    sb.append(sb2.toString());
                    if (!TextUtils.isEmpty(lVar.MF().g(sb.toString(), true))) {
                        SpannableString cL = lVar.threadData.cL(sb.toString());
                        this.bIk.setOnTouchListener(new com.baidu.tieba.view.l(cL));
                        this.bIk.setText(cL);
                        this.bIk.setVisibility(0);
                        m.a(this.bIk, lVar.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                        z4 = true;
                    } else {
                        this.bIk.setVisibility(8);
                        z4 = false;
                    }
                    z2 = z4;
                } else {
                    this.bIk.setVisibility(8);
                    i = 0;
                    z2 = false;
                }
                rT = lVar.threadData.rT();
                if (!u.v(rT)) {
                    this.bIj.setVisibility(8);
                    z3 = false;
                } else {
                    this.bIj.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rT.get(0);
                    this.bIj.setVoiceModel(voiceModel);
                    this.bIj.setTag(voiceModel);
                    this.bIj.bix();
                    if (voiceModel != null) {
                        this.bIj.mQ(voiceModel.voice_status.intValue());
                    }
                    z3 = true;
                }
                if (!this.bGA.bKr && z3) {
                    this.bIl.setVisibility(8);
                } else if (!h.oX().pd() && u.u(rP) != 0) {
                    LinkedList linkedList = new LinkedList();
                    final LinkedList linkedList2 = new LinkedList();
                    for (int i3 = 0; i3 < i; i3++) {
                        MediaData mediaData = (MediaData) u.c(rP, i3);
                        if (mediaData != null && mediaData.getType() == 3) {
                            linkedList.add(mediaData.getThumbnails_url());
                            linkedList2.add(mediaData);
                        }
                    }
                    if (u.u(linkedList) > 0) {
                        this.bIl.setVisibility(0);
                        this.bIl.setFromCDN(this.ajL);
                        this.bIl.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                            @Override // com.baidu.tbadk.widget.layout.d
                            public void c(View view, int i4, boolean z7) {
                                x<l> WA = b.this.WA();
                                if (WA != null) {
                                    view.setTag("1");
                                    WA.a(view, b.this.bGA);
                                }
                                if (z7) {
                                    b.this.WQ();
                                } else {
                                    b.this.a(linkedList2, i4, MF);
                                }
                            }
                        });
                        this.bIl.setImageUrls(linkedList);
                    } else {
                        this.bIl.setVisibility(8);
                        z5 = false;
                    }
                    z6 = z5;
                } else {
                    this.bIl.setVisibility(8);
                }
                WP();
                h(z, z2, z6);
                setPageUniqueId(getTag());
            }
        }
        z = true;
        sb = new StringBuilder();
        if (MF.rN() != null) {
            sb.append(MF.rN());
        }
        rP = lVar.threadData.rP();
        if (rP == null) {
        }
        rT = lVar.threadData.rT();
        if (!u.v(rT)) {
        }
        if (!this.bGA.bKr) {
        }
        if (!h.oX().pd()) {
        }
        this.bIl.setVisibility(8);
        WP();
        h(z, z2, z6);
        setPageUniqueId(getTag());
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIk.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bIl.getLayoutParams();
        if (!z && z2) {
            layoutParams.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams2.topMargin = k.g(this.mContext, d.f.ds2);
            } else if (z) {
                layoutParams2.topMargin = 0;
            }
        } else if (z2) {
            layoutParams3.topMargin = k.g(this.mContext, d.f.ds13);
        } else if (z) {
            layoutParams3.topMargin = k.g(this.mContext, d.f.ds10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            k.showToast(this.oV.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajL ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(blVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.oV.getPageActivity()).createConfig(arrayList, i, blVar.rK(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajL, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void WP() {
        if (!this.bGA.aDv) {
            this.bIj.setClickable(false);
        } else {
            this.bIj.setClickable(true);
        }
        int childCount = this.bIl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIl.getChildAt(i);
            if (childAt != null) {
                if (!this.bGA.aDv) {
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
        if (this.bIl != null) {
            this.bIl.setPageUniqueId(bdUniqueId);
        }
        if (this.cSG != null) {
            this.cSG.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cSG != null) {
            return this.cSG.getHeaderImg();
        }
        return null;
    }

    public View WD() {
        if (this.cSG != null) {
            return this.cSG.aoT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WQ() {
        if (this.bGA != null && this.bGA.threadData != null) {
            if (!WE()) {
                m.je(this.bGA.threadData.getId());
                m.a(this.mTitle, this.bGA.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bIk, this.bGA.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.oV.getPageActivity()).createCfgForPersonCenter(this.bGA.threadData.getId(), this.bGA.threadData.rV(), m.rw(), 18005)));
        }
    }

    private boolean WE() {
        return this.bGA.bKr && !this.bGA.aDv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
