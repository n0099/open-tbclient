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
    private boolean ajJ;
    private TbPageContext<?> alI;
    private final View.OnClickListener aoG;
    private final View.OnClickListener aoW;
    private HeadPendantClickableView bFM;
    private View bFQ;
    private l bFR;
    private View.OnClickListener bFS;
    public PlayVoiceBntNew bHA;
    private TextView bHB;
    private ConstrainImageGroup bHC;
    private final View.OnClickListener bHD;
    public ThreadCommentAndPraiseInfoLayout bkZ;
    protected LinearLayout bld;
    public ConcernThreadUserInfoLayout cQH;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajJ = true;
        this.bFS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.We() != null) {
                    b.this.We().a(view, b.this.bFR);
                }
                b.this.Wu();
            }
        };
        this.bHD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<l> We = b.this.We();
                if (We != null) {
                    view.setTag("2");
                    We.a(view, b.this.bFR);
                }
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.We() != null) {
                    b.this.We().a(view, b.this.bFR);
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.We() != null) {
                    b.this.We().a(view, b.this.bFR);
                }
            }
        };
        View view = getView();
        this.alI = tbPageContext;
        this.bFM = (HeadPendantClickableView) view.findViewById(d.h.card_concern_normal_thread_user_pendant_header);
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(k.g(this.alI.getPageActivity(), d.f.ds60));
        }
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_normal_thread_title);
        this.bHA = (PlayVoiceBntNew) view.findViewById(d.h.card_concern_normal_thread_abstract_voice);
        this.bHA.setAfterClickListener(this.bHD);
        this.bHB = (TextView) view.findViewById(d.h.card_concern_normal_thread_abstract);
        this.bHC = (ConstrainImageGroup) view.findViewById(d.h.card_concern_normal_thread_img_layout);
        this.bFQ = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bHC.setChildClickListener(this.bFS);
        this.bHC.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.e(1.0d);
        this.bHC.setImageProcessor(fVar);
        this.bkZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_normal_thread_info_layout);
        this.cQH = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_normal_thread_user_info_layout);
        if (this.bkZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bkZ.setLayoutParams(layoutParams);
        }
        this.bkZ.setOnClickListener(this.bFS);
        this.bkZ.setReplyTimeVisible(false);
        this.bkZ.setIsBarViewVisible(false);
        this.bkZ.setShowPraiseNum(true);
        this.bkZ.setNeedAddPraiseIcon(true);
        this.bkZ.setNeedAddReplyIcon(true);
        this.bkZ.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bkZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.We() != null) {
                    b.this.We().a(view2, b.this.bFR);
                }
            }
        });
        this.bld = (LinearLayout) view.findViewById(d.h.card_concern_normal_thread_content_layout);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bHC != null) {
            this.bHC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bHC != null) {
            this.bHC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bHC.onChangeSkinType();
            this.bkZ.onChangeSkinType();
            this.cQH.onChangeSkinType();
            ai.k(this.bFQ, d.e.cp_bg_line_c);
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
        this.bFR = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bFS);
        }
        this.cQH.a(lVar.threadData);
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        if (!Wi() && m.je(this.bFR.threadData.getId())) {
            m.a(this.mTitle, this.bFR.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bHB, this.bFR.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cQH.setUserAfterClickListener(this.aoW);
        this.bkZ.a(lVar.threadData);
        final bl MF = lVar.MF();
        if (this.cQH.getHeaderImg() != null) {
            if (this.cQH.getIsSimpleThread()) {
                this.cQH.getHeaderImg().setVisibility(8);
                this.bFM.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pV())) {
                this.bFM.setVisibility(8);
                this.cQH.getHeaderImg().setVisibility(0);
                this.cQH.getHeaderImg().setData(MF);
            } else {
                this.cQH.getHeaderImg().setVisibility(4);
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
                        this.bHB.setOnTouchListener(new com.baidu.tieba.view.l(cL));
                        this.bHB.setText(cL);
                        this.bHB.setVisibility(0);
                        m.a(this.bHB, lVar.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                        z4 = true;
                    } else {
                        this.bHB.setVisibility(8);
                        z4 = false;
                    }
                    z2 = z4;
                } else {
                    this.bHB.setVisibility(8);
                    i = 0;
                    z2 = false;
                }
                rT = lVar.threadData.rT();
                if (!u.v(rT)) {
                    this.bHA.setVisibility(8);
                    z3 = false;
                } else {
                    this.bHA.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rT.get(0);
                    this.bHA.setVoiceModel(voiceModel);
                    this.bHA.setTag(voiceModel);
                    this.bHA.bhR();
                    if (voiceModel != null) {
                        this.bHA.mG(voiceModel.voice_status.intValue());
                    }
                    z3 = true;
                }
                if (!this.bFR.bJI && z3) {
                    this.bHC.setVisibility(8);
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
                        this.bHC.setVisibility(0);
                        this.bHC.setFromCDN(this.ajJ);
                        this.bHC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                            @Override // com.baidu.tbadk.widget.layout.d
                            public void c(View view, int i4, boolean z7) {
                                x<l> We = b.this.We();
                                if (We != null) {
                                    view.setTag("1");
                                    We.a(view, b.this.bFR);
                                }
                                if (z7) {
                                    b.this.Wu();
                                } else {
                                    b.this.a(linkedList2, i4, MF);
                                }
                            }
                        });
                        this.bHC.setImageUrls(linkedList);
                    } else {
                        this.bHC.setVisibility(8);
                        z5 = false;
                    }
                    z6 = z5;
                } else {
                    this.bHC.setVisibility(8);
                }
                Wt();
                g(z, z2, z6);
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
        if (!this.bFR.bJI) {
        }
        if (!h.oX().pd()) {
        }
        this.bHC.setVisibility(8);
        Wt();
        g(z, z2, z6);
        setPageUniqueId(getTag());
    }

    private void g(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHB.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bHC.getLayoutParams();
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
            k.showToast(this.alI.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajJ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.alI.getPageActivity()).createConfig(arrayList, i, blVar.rK(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Wt() {
        if (!this.bFR.aDu) {
            this.bHA.setClickable(false);
        } else {
            this.bHA.setClickable(true);
        }
        int childCount = this.bHC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bHC.getChildAt(i);
            if (childAt != null) {
                if (!this.bFR.aDu) {
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
        if (this.bHC != null) {
            this.bHC.setPageUniqueId(bdUniqueId);
        }
        if (this.cQH != null) {
            this.cQH.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cQH != null) {
            return this.cQH.getHeaderImg();
        }
        return null;
    }

    public View Wh() {
        if (this.cQH != null) {
            return this.cQH.aoS;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wu() {
        if (this.bFR != null && this.bFR.threadData != null) {
            if (!Wi()) {
                m.jd(this.bFR.threadData.getId());
                m.a(this.mTitle, this.bFR.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bHB, this.bFR.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.alI.getPageActivity()).createCfgForPersonCenter(this.bFR.threadData.getId(), this.bFR.threadData.rV(), m.rw(), 18005)));
        }
    }

    private boolean Wi() {
        return this.bFR.bJI && !this.bFR.aDu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
