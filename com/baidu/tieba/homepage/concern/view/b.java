package com.baidu.tieba.homepage.concern.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<k> implements com.baidu.tieba.a.e {
    private boolean atn;
    private final View.OnClickListener axT;
    private final View.OnClickListener ayi;
    private String bGM;
    public ThreadCommentAndPraiseInfoLayout bGZ;
    private HeadPendantClickableView bHK;
    public ThreadSourceShareAndPraiseLayout bHN;
    protected LinearLayout bHY;
    private View ctT;
    private k ctU;
    private View.OnClickListener ctV;
    private TextView cwA;
    private ConstrainImageGroup cwB;
    private final View.OnClickListener cwE;
    public PlayVoiceBntNew cwy;
    public ConcernThreadUserInfoLayout dRc;
    public ConcernForumThreadUserInfoLayout dRe;
    public com.baidu.tbadk.core.view.c dRf;
    private View dRg;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.atn = true;
        this.ctV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aia() != null) {
                    b.this.aia().a(view, b.this.ctU);
                }
                b.this.ait();
            }
        };
        this.cwE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<k> aia = b.this.aia();
                if (aia != null) {
                    view.setTag("2");
                    aia.a(view, b.this.ctU);
                }
            }
        };
        this.ayi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aia() != null) {
                    b.this.aia().a(view, b.this.ctU);
                }
            }
        };
        this.axT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aia() != null) {
                    b.this.aia().a(view, b.this.ctU);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bHK = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.bHK.getHeadView() != null) {
            this.bHK.getHeadView().setIsRound(true);
            this.bHK.getHeadView().setDrawBorder(false);
            this.bHK.getHeadView().setDefaultResource(17170445);
            this.bHK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bHK.getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.bHK.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.bHK.getPendantView() != null) {
            this.bHK.getPendantView().setIsRound(true);
            this.bHK.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.cwy = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.cwy.setAfterClickListener(this.cwE);
        this.cwA = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.cwA.setVisibility(8);
        this.cwB = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.ctT = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.cwB.setChildClickListener(this.ctV);
        this.cwB.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.cwB.setImageProcessor(eVar);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        if (this.bGZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bGZ.setLayoutParams(layoutParams);
        }
        this.bGZ.setOnClickListener(this.ctV);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setIsBarViewVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setShareVisible(true);
        this.bGZ.setShareReportFrom(4);
        this.bGZ.setFrom(9);
        this.bGZ.akz = this.currentPageType;
        this.bGZ.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aia() != null) {
                    b.this.aia().a(view2, b.this.ctU);
                }
                if (b.this.ctU != null && b.this.ctU.threadData != null) {
                    o.kY(b.this.ctU.threadData.getId());
                    b.this.aif();
                }
            }
        });
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_concern_nomal_source_read_share_layout);
        this.bHN.ayE.setOnClickListener(this.ctV);
        this.bHN.setShareReportFrom(4);
        this.bHN.setFrom(9);
        this.bHN.ayE.akz = this.currentPageType;
        this.bHN.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.aia() != null) {
                    b.this.aia().a(view2, b.this.ctU);
                }
                if (b.this.ctU != null && b.this.ctU.threadData != null && view2 != b.this.bHN.ayD) {
                    o.kY(b.this.ctU.threadData.getId());
                    b.this.aif();
                }
            }
        });
        this.bHY = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.dRg = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cwB != null) {
            this.cwB.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cwB != null) {
            this.cwB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cwB != null) {
            this.cwB.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            this.cwB.onChangeSkinType();
            this.bGZ.onChangeSkinType();
            am.j(this.ctT, d.C0142d.cp_bg_line_e);
            this.bHN.onChangeSkinType();
        }
        if (this.dRc != null && this.dRc.getVisibility() == 0) {
            this.dRc.onChangeSkinType(i);
        }
        if (this.dRe != null && this.dRe.getVisibility() == 0) {
            this.dRe.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aif() {
        if (this.ctU != null && this.ctU.threadData.getId() != null) {
            o.a(this.mTitle, this.ctU.SV().getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            o.a(this.cwA, this.ctU.threadData.getId(), d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_concern_normal_thread;
    }

    private void aCM() {
        if (this.dRc == null) {
            this.dRc = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aCN() {
        if (this.dRe == null) {
            this.dRe = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(d.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.dRe.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aia() != null) {
                    b.this.aia().a(view, b.this.ctU);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ctU = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ctV);
        }
        if (kVar.aiP()) {
            aCN();
            this.dRf = this.dRe;
            this.dRe.setVisibility(0);
            if (this.dRc != null) {
                this.dRc.setVisibility(8);
            }
        } else {
            aCM();
            this.dRf = this.dRc;
            this.dRc.setVisibility(0);
            if (this.dRe != null) {
                this.dRe.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!aie() && o.kZ(this.ctU.threadData.getId())) {
            aif();
        }
        final bc SV = kVar.SV();
        if (this.dRf.getHeaderImg() != null) {
            if (this.dRf.getIsSimpleThread()) {
                this.dRf.getHeaderImg().setVisibility(8);
                this.bHK.setVisibility(8);
            } else if (SV.vw() == null || SV.vw().getPendantData() == null || StringUtils.isNull(SV.vw().getPendantData().uh())) {
                this.bHK.setVisibility(8);
                this.dRf.getHeaderImg().setVisibility(0);
                this.dRf.getHeaderImg().setData(SV, !kVar.aiP());
            } else {
                this.dRf.getHeaderImg().setVisibility(4);
                this.bHK.setVisibility(0);
                this.bHK.setData(SV);
            }
        }
        this.dRf.setData(kVar.threadData);
        this.dRf.setUserAfterClickListener(this.ayi);
        I(SV);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> vK = kVar.threadData.vK();
        if (w.A(vK)) {
            this.cwy.setVisibility(8);
            ev(false);
            z = false;
        } else {
            this.cwy.setVisibility(0);
            ev(true);
            VoiceData.VoiceModel voiceModel = vK.get(0);
            this.cwy.setVoiceModel(voiceModel);
            this.cwy.setTag(voiceModel);
            this.cwy.aOt();
            if (voiceModel != null) {
                this.cwy.ot(voiceModel.voice_status.intValue());
            }
            this.cwy.byM();
            z = true;
        }
        if (this.ctU.czG && z) {
            this.cwB.setVisibility(8);
            this.dRg.setVisibility(0);
        } else {
            ArrayList<MediaData> vG = kVar.threadData.vG();
            if (i.tt().tz() && w.z(vG) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < vG.size(); i++) {
                    MediaData mediaData = (MediaData) w.d(vG, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (w.z(linkedList) > 0) {
                    this.cwB.setVisibility(0);
                    this.dRg.setVisibility(8);
                    this.cwB.setFromCDN(this.atn);
                    this.cwB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void c(View view, int i2, boolean z2) {
                            ad<k> aia = b.this.aia();
                            if (aia != null) {
                                view.setTag("1");
                                aia.a(view, b.this.ctU);
                            }
                            if (z2) {
                                b.this.ait();
                            } else {
                                b.this.a(view, linkedList, i2, SV);
                            }
                        }
                    });
                    this.cwB.setImageMediaList(linkedList);
                } else {
                    this.cwB.setVisibility(8);
                    this.dRg.setVisibility(0);
                }
            } else {
                this.cwB.setVisibility(8);
                this.dRg.setVisibility(0);
            }
        }
        ais();
        setPageUniqueId(getTag());
        awR();
        hh(gp(1));
    }

    private void ev(boolean z) {
        if (this.cwB != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cwB.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.cwB.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bc bcVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), d.k.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.atn ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bcVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bcVar.vB(), String.valueOf(bcVar.getFid()), bcVar.getTid(), this.atn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void ais() {
        if (!this.ctU.aNy) {
            this.cwy.setClickable(false);
        } else {
            this.cwy.setClickable(true);
        }
        int childCount = this.cwB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cwB.getChildAt(i);
            if (childAt != null) {
                if (!this.ctU.aNy) {
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
        if (this.cwB != null) {
            this.cwB.setPageUniqueId(bdUniqueId);
        }
        if (this.dRf != null) {
            this.dRf.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.dRf != null) {
            return this.dRf.getHeaderImg();
        }
        return null;
    }

    public View aid() {
        if (this.dRf != null) {
            return this.dRf.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ait() {
        if (this.ctU != null && this.ctU.threadData != null) {
            if (!aie()) {
                o.kY(this.ctU.threadData.getId());
                o.a(this.mTitle, this.ctU.SV().getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
                o.a(this.cwA, this.ctU.threadData.getId(), d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ctU.threadData, null, o.vk(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.ctU.threadData.getFid()));
            createFromThreadCfg.setForumName(this.ctU.threadData.vB());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean aie() {
        return this.ctU.czG && !this.ctU.aNy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean I(bc bcVar) {
        SpannableStringBuilder g = bcVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bcVar.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        }
        return true;
    }

    private void c(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.aiP()) {
            this.cwA.setVisibility(8);
            return;
        }
        bc bcVar = kVar.threadData;
        if (gp(2) == 1) {
            SpannableString wK = bcVar.wK();
            if (wK != null && !ap.isEmpty(wK.toString())) {
                this.cwA.setVisibility(0);
                this.cwA.setOnTouchListener(new com.baidu.tieba.view.k(wK));
                this.cwA.setText(wK);
                o.a(this.cwA, bcVar.getId(), d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
                return;
            }
            this.cwA.setVisibility(8);
            return;
        }
        this.cwA.setVisibility(8);
    }

    private void awR() {
        if (this.mTitle != null && this.cwy != null && this.cwB != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cwy.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.cwy.setLayoutParams(layoutParams);
            if (this.cwy.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cwB.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.cwB.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hh(int i) {
        if (this.ctU != null && this.ctU.threadData != null) {
            if (!this.ctU.aiP() && i == 1) {
                this.bGZ.setVisibility(8);
                this.bHN.setStType(o.vk());
                this.bHN.setData(this.ctU.threadData);
                this.dRf.showForumNameView(false);
                return;
            }
            this.bGZ.setData(this.ctU.threadData);
            this.bGZ.setStType(o.vk());
            this.bHN.setVisibility(8);
            this.dRf.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}
