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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<k> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aBE;
    private boolean avq;
    private final View.OnClickListener azz;
    public ThreadCommentAndPraiseInfoLayout bND;
    private String bNq;
    protected LinearLayout bOC;
    private HeadPendantClickableView bOo;
    public ThreadSourceShareAndPraiseLayout bOr;
    private View cCj;
    private k cCk;
    private View.OnClickListener cCl;
    public PlayVoiceBntNew cEQ;
    private TextView cES;
    private ConstrainImageGroup cET;
    private final View.OnClickListener cEW;
    public ConcernThreadUserInfoLayout ebd;
    public ConcernForumThreadUserInfoLayout ebf;
    public com.baidu.tbadk.core.view.f ebg;
    private View ebh;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.avq = true;
        this.cCl = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akm() != null) {
                    b.this.akm().a(view, b.this.cCk);
                }
                b.this.akG();
            }
        };
        this.cEW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<k> akm = b.this.akm();
                if (akm != null) {
                    view.setTag("2");
                    akm.a(view, b.this.cCk);
                }
            }
        };
        this.aBE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akm() != null) {
                    b.this.akm().a(view, b.this.cCk);
                }
            }
        };
        this.azz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akm() != null) {
                    b.this.akm().a(view, b.this.cCk);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bOo = (HeadPendantClickableView) view.findViewById(e.g.card_concern_normal_thread_user_pendant_header);
        if (this.bOo.getHeadView() != null) {
            this.bOo.getHeadView().setIsRound(true);
            this.bOo.getHeadView().setDrawBorder(false);
            this.bOo.getHeadView().setDefaultResource(17170445);
            this.bOo.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bOo.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bOo.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0141e.ds60));
        }
        if (this.bOo.getPendantView() != null) {
            this.bOo.getPendantView().setIsRound(true);
            this.bOo.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_concern_normal_thread_title);
        this.cEQ = (PlayVoiceBntNew) view.findViewById(e.g.card_concern_normal_thread_abstract_voice);
        this.cEQ.setAfterClickListener(this.cEW);
        this.cES = (TextView) view.findViewById(e.g.card_concern_normal_thread_abstract);
        this.cES.setVisibility(8);
        this.cET = (ConstrainImageGroup) view.findViewById(e.g.card_concern_normal_thread_img_layout);
        this.cCj = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds16);
        this.cET.setChildClickListener(this.cCl);
        this.cET.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cET.setImageProcessor(eVar);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_concern_normal_thread_info_layout);
        if (this.bND.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bND.setLayoutParams(layoutParams);
        }
        this.bND.setOnClickListener(this.cCl);
        this.bND.setReplyTimeVisible(false);
        this.bND.setIsBarViewVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setShareVisible(true);
        this.bND.setShareReportFrom(4);
        this.bND.setFrom(9);
        this.bND.setDisPraiseFrom(4);
        this.bND.amD = this.currentPageType;
        this.bND.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.akm() != null) {
                    b.this.akm().a(view2, b.this.cCk);
                }
                if (b.this.cCk != null && b.this.cCk.threadData != null) {
                    o.lA(b.this.cCk.threadData.getId());
                    b.this.akr();
                }
            }
        });
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_nomal_source_read_share_layout);
        this.bOr.aBl.setOnClickListener(this.cCl);
        this.bOr.setShareReportFrom(4);
        this.bOr.setFrom(9);
        this.bOr.aBl.amD = this.currentPageType;
        this.bOr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.akm() != null) {
                    b.this.akm().a(view2, b.this.cCk);
                }
                if (b.this.cCk != null && b.this.cCk.threadData != null && view2 != b.this.bOr.aBk) {
                    o.lA(b.this.cCk.threadData.getId());
                    b.this.akr();
                }
            }
        });
        this.bOC = (LinearLayout) view.findViewById(e.g.card_concern_normal_thread_content_layout);
        this.ebh = view.findViewById(e.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.cET != null) {
            this.cET.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cET != null) {
            this.cET.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cET != null) {
            this.cET.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            this.cET.onChangeSkinType();
            this.bND.onChangeSkinType();
            al.j(this.cCj, e.d.cp_bg_line_e);
            this.bOr.onChangeSkinType();
        }
        if (this.ebd != null && this.ebd.getVisibility() == 0) {
            this.ebd.onChangeSkinType(i);
        }
        if (this.ebf != null && this.ebf.getVisibility() == 0) {
            this.ebf.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akr() {
        if (this.cCk != null && this.cCk.threadData.getId() != null) {
            o.a(this.mTitle, this.cCk.UT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cES, this.cCk.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_concern_normal_thread;
    }

    private void aFE() {
        if (this.ebd == null) {
            this.ebd = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void aFF() {
        if (this.ebf == null) {
            this.ebf = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(e.g.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.ebf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.akm() != null) {
                    b.this.akm().a(view, b.this.cCk);
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
        this.cCk = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cCl);
        }
        if (kVar.alc()) {
            aFF();
            this.ebg = this.ebf;
            this.ebf.setVisibility(0);
            if (this.ebd != null) {
                this.ebd.setVisibility(8);
            }
        } else {
            aFE();
            this.ebg = this.ebd;
            this.ebd.setVisibility(0);
            if (this.ebf != null) {
                this.ebf.setVisibility(8);
            }
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!akq() && o.lB(this.cCk.threadData.getId())) {
            akr();
        }
        final bb UT = kVar.UT();
        if (this.ebg.getHeaderImg() != null) {
            if (this.ebg.getIsSimpleThread()) {
                this.ebg.getHeaderImg().setVisibility(8);
                this.bOo.setVisibility(8);
            } else if (UT.wm() == null || UT.wm().getPendantData() == null || StringUtils.isNull(UT.wm().getPendantData().uW())) {
                this.bOo.setVisibility(8);
                this.ebg.getHeaderImg().setVisibility(0);
                this.ebg.getHeaderImg().setData(UT, !kVar.alc());
            } else {
                this.ebg.getHeaderImg().setVisibility(4);
                this.bOo.setVisibility(0);
                this.bOo.setData(UT);
            }
        }
        this.ebg.setData(kVar.threadData);
        this.ebg.setUserAfterClickListener(this.aBE);
        L(UT);
        c(kVar);
        ArrayList<VoiceData.VoiceModel> wB = kVar.threadData.wB();
        if (v.z(wB)) {
            this.cEQ.setVisibility(8);
            eN(false);
            z = false;
        } else {
            this.cEQ.setVisibility(0);
            eN(true);
            VoiceData.VoiceModel voiceModel = wB.get(0);
            this.cEQ.setVoiceModel(voiceModel);
            this.cEQ.setTag(voiceModel);
            this.cEQ.aRD();
            if (voiceModel != null) {
                this.cEQ.pl(voiceModel.voice_status.intValue());
            }
            this.cEQ.bzY();
            z = true;
        }
        if (this.cCk.cIa && z) {
            this.cET.setVisibility(8);
            this.ebh.setVisibility(0);
        } else {
            ArrayList<MediaData> wx = kVar.threadData.wx();
            if (i.uj().un() && v.y(wx) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < wx.size(); i++) {
                    MediaData mediaData = (MediaData) v.d(wx, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (v.y(linkedList) > 0) {
                    this.cET.setVisibility(0);
                    this.ebh.setVisibility(8);
                    this.cET.setFromCDN(this.avq);
                    this.cET.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.b.4
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<k> akm = b.this.akm();
                            if (akm != null) {
                                view.setTag("1");
                                akm.a(view, b.this.cCk);
                            }
                            if (z2) {
                                b.this.akG();
                            } else {
                                b.this.a(view, linkedList, i2, UT);
                            }
                        }
                    });
                    this.cET.setImageMediaList(linkedList);
                } else {
                    this.cET.setVisibility(8);
                    this.ebh.setVisibility(0);
                }
            } else {
                this.cET.setVisibility(8);
                this.ebh.setVisibility(0);
            }
        }
        akF();
        setPageUniqueId(getTag());
        azJ();
        hM(gT(1));
    }

    private void eN(boolean z) {
        if (this.cET != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cET.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds10);
            }
            this.cET.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.avq ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.ws(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.avq, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void akF() {
        if (!this.cCk.aQN) {
            this.cEQ.setClickable(false);
        } else {
            this.cEQ.setClickable(true);
        }
        int childCount = this.cET.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cET.getChildAt(i);
            if (childAt != null) {
                if (!this.cCk.aQN) {
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
        if (this.cET != null) {
            this.cET.setPageUniqueId(bdUniqueId);
        }
        if (this.ebg != null) {
            this.ebg.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.ebg != null) {
            return this.ebg.getHeaderImg();
        }
        return null;
    }

    public View akp() {
        if (this.ebg != null) {
            return this.ebg.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akG() {
        if (this.cCk != null && this.cCk.threadData != null) {
            if (!akq()) {
                o.lA(this.cCk.threadData.getId());
                o.a(this.mTitle, this.cCk.UT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cES, this.cCk.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cCk.threadData, null, o.wa(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.cCk.threadData.getFid()));
            createFromThreadCfg.setForumName(this.cCk.threadData.ws());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    private boolean akq() {
        return this.cCk.cIa && !this.cCk.aQN;
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

    private void c(k kVar) {
        if (kVar == null || kVar.threadData == null || kVar.alc()) {
            this.cES.setVisibility(8);
            return;
        }
        bb bbVar = kVar.threadData;
        if (gT(2) == 1) {
            SpannableString xF = bbVar.xF();
            if (xF != null && !ao.isEmpty(xF.toString())) {
                this.cES.setVisibility(0);
                this.cES.setOnTouchListener(new com.baidu.tieba.view.k(xF));
                this.cES.setText(xF);
                o.a(this.cES, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cES.setVisibility(8);
            return;
        }
        this.cES.setVisibility(8);
    }

    private void azJ() {
        if (this.mTitle != null && this.cEQ != null && this.cET != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cEQ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds24);
            this.cEQ.setLayoutParams(layoutParams);
            if (this.cEQ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cET.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds10);
                this.cET.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hM(int i) {
        if (this.cCk != null && this.cCk.threadData != null) {
            if (!this.cCk.alc() && i == 1) {
                this.bND.setVisibility(8);
                this.bOr.setStType(o.wa());
                this.bOr.setData(this.cCk.threadData);
                this.ebg.showForumNameView(false);
                return;
            }
            this.bND.setData(this.cCk.threadData);
            this.bND.setStType(o.wa());
            this.bOr.setVisibility(8);
            this.ebg.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bNq = str;
    }

    public int gT(int i) {
        return com.baidu.tieba.a.d.SB().L(this.bNq, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cET != null) {
            this.cET.setPreloadSizeReadyCallback(bVar);
        }
    }
}
