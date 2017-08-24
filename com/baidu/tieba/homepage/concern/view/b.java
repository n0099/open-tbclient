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
    private View bGA;
    private l bGB;
    private View.OnClickListener bGC;
    private HeadPendantClickableView bGw;
    public PlayVoiceBntNew bIk;
    private TextView bIl;
    private ConstrainImageGroup bIm;
    private final View.OnClickListener bIn;
    public ThreadCommentAndPraiseInfoLayout ble;
    protected LinearLayout bli;
    public ConcernThreadUserInfoLayout cSG;
    private int mSkinType;
    private TextView mTitle;
    private TbPageContext<?> oW;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajL = true;
        this.bGC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Wx() != null) {
                    b.this.Wx().a(view, b.this.bGB);
                }
                b.this.WN();
            }
        };
        this.bIn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<l> Wx = b.this.Wx();
                if (Wx != null) {
                    view.setTag("2");
                    Wx.a(view, b.this.bGB);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Wx() != null) {
                    b.this.Wx().a(view, b.this.bGB);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.Wx() != null) {
                    b.this.Wx().a(view, b.this.bGB);
                }
            }
        };
        View view = getView();
        this.oW = tbPageContext;
        this.bGw = (HeadPendantClickableView) view.findViewById(d.h.card_concern_normal_thread_user_pendant_header);
        if (this.bGw.getHeadView() != null) {
            this.bGw.getHeadView().setIsRound(true);
            this.bGw.getHeadView().setDrawBorder(false);
            this.bGw.getHeadView().setDefaultResource(17170445);
            this.bGw.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGw.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGw.getHeadView().setRadius(k.g(this.oW.getPageActivity(), d.f.ds60));
        }
        if (this.bGw.getPendantView() != null) {
            this.bGw.getPendantView().setIsRound(true);
            this.bGw.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_normal_thread_title);
        this.bIk = (PlayVoiceBntNew) view.findViewById(d.h.card_concern_normal_thread_abstract_voice);
        this.bIk.setAfterClickListener(this.bIn);
        this.bIl = (TextView) view.findViewById(d.h.card_concern_normal_thread_abstract);
        this.bIm = (ConstrainImageGroup) view.findViewById(d.h.card_concern_normal_thread_img_layout);
        this.bGA = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bIm.setChildClickListener(this.bGC);
        this.bIm.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.e(1.0d);
        this.bIm.setImageProcessor(fVar);
        this.ble = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_normal_thread_info_layout);
        this.cSG = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_normal_thread_user_info_layout);
        if (this.ble.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ble.setLayoutParams(layoutParams);
        }
        this.ble.setOnClickListener(this.bGC);
        this.ble.setReplyTimeVisible(false);
        this.ble.setIsBarViewVisible(false);
        this.ble.setShowPraiseNum(true);
        this.ble.setNeedAddPraiseIcon(true);
        this.ble.setNeedAddReplyIcon(true);
        this.ble.setReplyIcon(d.g.icon_home_card_comment_n);
        this.ble.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.Wx() != null) {
                    b.this.Wx().a(view2, b.this.bGB);
                }
            }
        });
        this.bli = (LinearLayout) view.findViewById(d.h.card_concern_normal_thread_content_layout);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bIm != null) {
            this.bIm.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bIm != null) {
            this.bIm.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            this.bIm.onChangeSkinType();
            this.ble.onChangeSkinType();
            this.cSG.onChangeSkinType();
            ai.k(this.bGA, d.e.cp_bg_line_c);
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
        ArrayList<MediaData> rQ;
        int i;
        boolean z2;
        ArrayList<VoiceData.VoiceModel> rU;
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
        this.bGB = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGC);
        }
        this.cSG.a(lVar.threadData);
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        if (!WB() && m.ji(this.bGB.threadData.getId())) {
            m.a(this.mTitle, this.bGB.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIl, this.bGB.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cSG.setUserAfterClickListener(this.aoX);
        this.ble.a(lVar.threadData);
        final bl MF = lVar.MF();
        if (this.cSG.getHeaderImg() != null) {
            if (this.cSG.getIsSimpleThread()) {
                this.cSG.getHeaderImg().setVisibility(8);
                this.bGw.setVisibility(8);
            } else if (MF.getAuthor() == null || MF.getAuthor().getPendantData() == null || StringUtils.isNull(MF.getAuthor().getPendantData().pW())) {
                this.bGw.setVisibility(8);
                this.cSG.getHeaderImg().setVisibility(0);
                this.cSG.getHeaderImg().setData(MF);
            } else {
                this.cSG.getHeaderImg().setVisibility(4);
            }
        }
        m.b(MF, this.mTitle);
        if ((StringUtils.isNull(MF.getTitle()) && (MF.rE() == null || MF.rE().size() == 0)) || MF.rV() == 1) {
            MF.e(false, true);
            if (MF.sg() == null || StringUtils.isNull(MF.sg().toString())) {
                z = false;
                sb = new StringBuilder();
                if (MF.rO() != null && !StringUtils.isNull(MF.rO())) {
                    sb.append(MF.rO());
                }
                rQ = lVar.threadData.rQ();
                if (rQ == null) {
                    i = rQ.size();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 0; i2 < i; i2++) {
                        if (rQ.get(i2).getVideoUrl() != null && rQ.get(i2).getVideoUrl().endsWith("swf")) {
                            sb2.append(rQ.get(i2).getVideoUrl());
                        }
                    }
                    sb.append(sb2.toString());
                    if (!TextUtils.isEmpty(lVar.MF().g(sb.toString(), true))) {
                        SpannableString cO = lVar.threadData.cO(sb.toString());
                        this.bIl.setOnTouchListener(new com.baidu.tieba.view.l(cO));
                        this.bIl.setText(cO);
                        this.bIl.setVisibility(0);
                        m.a(this.bIl, lVar.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                        z4 = true;
                    } else {
                        this.bIl.setVisibility(8);
                        z4 = false;
                    }
                    z2 = z4;
                } else {
                    this.bIl.setVisibility(8);
                    i = 0;
                    z2 = false;
                }
                rU = lVar.threadData.rU();
                if (!u.v(rU)) {
                    this.bIk.setVisibility(8);
                    z3 = false;
                } else {
                    this.bIk.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rU.get(0);
                    this.bIk.setVoiceModel(voiceModel);
                    this.bIk.setTag(voiceModel);
                    this.bIk.bis();
                    if (voiceModel != null) {
                        this.bIk.mQ(voiceModel.voice_status.intValue());
                    }
                    z3 = true;
                }
                if (!this.bGB.bKs && z3) {
                    this.bIm.setVisibility(8);
                } else if (!h.oY().pe() && u.u(rQ) != 0) {
                    LinkedList linkedList = new LinkedList();
                    final LinkedList linkedList2 = new LinkedList();
                    for (int i3 = 0; i3 < i; i3++) {
                        MediaData mediaData = (MediaData) u.c(rQ, i3);
                        if (mediaData != null && mediaData.getType() == 3) {
                            linkedList.add(mediaData.getThumbnails_url());
                            linkedList2.add(mediaData);
                        }
                    }
                    if (u.u(linkedList) > 0) {
                        this.bIm.setVisibility(0);
                        this.bIm.setFromCDN(this.ajL);
                        this.bIm.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                            @Override // com.baidu.tbadk.widget.layout.d
                            public void c(View view, int i4, boolean z7) {
                                x<l> Wx = b.this.Wx();
                                if (Wx != null) {
                                    view.setTag("1");
                                    Wx.a(view, b.this.bGB);
                                }
                                if (z7) {
                                    b.this.WN();
                                } else {
                                    b.this.a(linkedList2, i4, MF);
                                }
                            }
                        });
                        this.bIm.setImageUrls(linkedList);
                    } else {
                        this.bIm.setVisibility(8);
                        z5 = false;
                    }
                    z6 = z5;
                } else {
                    this.bIm.setVisibility(8);
                }
                WM();
                h(z, z2, z6);
                setPageUniqueId(getTag());
            }
        }
        z = true;
        sb = new StringBuilder();
        if (MF.rO() != null) {
            sb.append(MF.rO());
        }
        rQ = lVar.threadData.rQ();
        if (rQ == null) {
        }
        rU = lVar.threadData.rU();
        if (!u.v(rU)) {
        }
        if (!this.bGB.bKs) {
        }
        if (!h.oY().pe()) {
        }
        this.bIm.setVisibility(8);
        WM();
        h(z, z2, z6);
        setPageUniqueId(getTag());
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIl.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bIm.getLayoutParams();
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
            k.showToast(this.oW.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.oW.getPageActivity()).createConfig(arrayList, i, blVar.rL(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajL, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void WM() {
        if (!this.bGB.aDw) {
            this.bIk.setClickable(false);
        } else {
            this.bIk.setClickable(true);
        }
        int childCount = this.bIm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIm.getChildAt(i);
            if (childAt != null) {
                if (!this.bGB.aDw) {
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
        if (this.bIm != null) {
            this.bIm.setPageUniqueId(bdUniqueId);
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

    public View WA() {
        if (this.cSG != null) {
            return this.cSG.aoT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WN() {
        if (this.bGB != null && this.bGB.threadData != null) {
            if (!WB()) {
                m.jh(this.bGB.threadData.getId());
                m.a(this.mTitle, this.bGB.MF().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bIl, this.bGB.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.oW.getPageActivity()).createCfgForPersonCenter(this.bGB.threadData.getId(), this.bGB.threadData.rW(), m.rx(), 18005)));
        }
    }

    private boolean WB() {
        return this.bGB.bKs && !this.bGB.aDw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
