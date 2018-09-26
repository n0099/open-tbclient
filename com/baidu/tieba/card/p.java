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
/* loaded from: classes2.dex */
public class p extends a<com.baidu.tieba.card.data.k> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aBE;
    private boolean avq;
    public ThreadUserInfoLayout bNC;
    public ThreadCommentAndPraiseInfoLayout bND;
    private NEGFeedBackView bNP;
    private String bNq;
    protected LinearLayout bOC;
    private HeadPendantClickableView bOo;
    public ThreadSourceShareAndPraiseLayout bOr;
    private ThreadGodReplyLayout cCi;
    private View cCj;
    private com.baidu.tieba.card.data.k cCk;
    private View.OnClickListener cCl;
    public PlayVoiceBntNew cEQ;
    private View cER;
    private TextView cES;
    private ConstrainImageGroup cET;
    private boolean cEU;
    private RelativeLayout cEV;
    private final View.OnClickListener cEW;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bNP = null;
        this.mSkinType = 3;
        this.avq = true;
        this.cEU = true;
        this.cCl = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cCk != null) {
                    p.this.cCk.awp = 1;
                }
                if (p.this.akm() != null) {
                    p.this.akm().a(view, p.this.cCk);
                }
                p.this.eJ(view == p.this.cCi);
            }
        };
        this.cEW = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.card.data.k> akm = p.this.akm();
                if (akm != null) {
                    view.setTag("2");
                    akm.a(view, p.this.cCk);
                }
            }
        };
        this.aBE = new View.OnClickListener() { // from class: com.baidu.tieba.card.p.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (p.this.cCk == null) {
                    if (p.this.akm() != null) {
                        p.this.akm().a(view, p.this.cCk);
                        return;
                    }
                    return;
                }
                if (view == p.this.bNC.getUserName()) {
                    p.this.cCk.awp = 3;
                } else if (view == p.this.bNC.getHeaderImg()) {
                    p.this.cCk.awp = 4;
                } else if (view == p.this.cET) {
                    p.this.cCk.awp = 2;
                    return;
                } else {
                    p.this.cCk.awp = 1;
                }
                if (p.this.akm() != null) {
                    p.this.akm().a(view, p.this.cCk);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bOo = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bOo.getHeadView() != null) {
            this.bOo.getHeadView().setIsRound(true);
            this.bOo.getHeadView().setDrawBorder(false);
            this.bOo.getHeadView().setDefaultResource(17170445);
            this.bOo.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bOo.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bOo.getHeadView().setRadius(com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0141e.ds70));
        }
        this.bOo.setHasPendantStyle();
        if (this.bOo.getPendantView() != null) {
            this.bOo.getPendantView().setIsRound(true);
            this.bOo.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cEQ = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cEQ.setAfterClickListener(this.cEW);
        this.cES = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cES.setVisibility(8);
        this.cET = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cCj = view.findViewById(e.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.tbds20);
        this.cET.setChildClickListener(this.cCl);
        this.cET.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cET.setImageProcessor(eVar);
        this.cER = view.findViewById(e.g.divider_line_above_praise);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bNC = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bNP = new NEGFeedBackView(this.mPageContext);
        this.cEV = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.bNP.a(this.cEV, com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds120), 0);
        if (this.bND.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bND.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bND.setLayoutParams(layoutParams);
        }
        this.bND.setOnClickListener(this.cCl);
        this.bND.setReplyTimeVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setShareVisible(true);
        this.bND.setFrom(1);
        this.bND.setDisPraiseFrom(1);
        this.bND.setShareReportFrom(3);
        this.bND.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.akm() != null) {
                    p.this.akm().a(view2, p.this.cCk);
                }
                if (p.this.cCk != null && p.this.cCk.threadData != null) {
                    o.lA(p.this.cCk.threadData.getId());
                    if (!p.this.akq()) {
                        o.a(p.this.mTitle, p.this.cCk.UT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cES, p.this.cCk.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cCi.getGodReplyContent(), p.this.cCk.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
        this.bOC = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.cCi = (ThreadGodReplyLayout) view.findViewById(e.g.card_home_page_god_reply_layout);
        this.cCi.setOnClickListener(this.cCl);
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        this.bOr.aBl.setOnClickListener(this.cCl);
        this.bOr.setFrom(1);
        this.bOr.setShareReportFrom(3);
        this.bOr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (p.this.akm() != null) {
                    p.this.akm().a(view2, p.this.cCk);
                }
                if (p.this.cCk != null && p.this.cCk.threadData != null && view2 != p.this.bOr.aBk) {
                    o.lA(p.this.cCk.threadData.getId());
                    if (!p.this.akq()) {
                        o.a(p.this.mTitle, p.this.cCk.UT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                        o.a(p.this.cES, p.this.cCk.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                        o.a(p.this.cCi.getGodReplyContent(), p.this.cCk.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
                    }
                }
            }
        });
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
            al.j(this.cER, e.d.transparent);
            this.cET.onChangeSkinType();
            this.bND.onChangeSkinType();
            this.cCi.onChangeSkinType();
            this.bNC.onChangeSkinType();
            if (this.bNP != null) {
                this.bNP.onChangeSkinType();
            }
            al.j(this.cCj, e.d.cp_bg_line_e);
            if (this.bOr != null) {
                this.bOr.onChangeSkinType();
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
        if (kVar == null || kVar.UT() == null) {
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
        if (this.bNP != null) {
            if (this.cCk.aiT != null && this.cCk.aiT.size() > 0) {
                ah ahVar = new ah();
                ahVar.setTid(this.cCk.UT().getTid());
                ahVar.setFid(this.cCk.UT().getFid());
                ahVar.a(this.cCk.aiT);
                this.bNP.setData(ahVar);
                this.bNP.setFirstRowSingleColumn(true);
                if (kVar.threadData.wm() != null && !StringUtils.isNull(kVar.threadData.wm().getUserId())) {
                    if (kVar.threadData.wm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bNP.setVisibility(8);
                    } else if (this.bNP != null) {
                        this.bNP.setVisibility(this.cEU ? 0 : 8);
                    }
                }
            } else {
                this.bNP.setVisibility(8);
            }
        }
        this.bNC.setData(kVar.threadData);
        this.cCi.setFromCDN(this.avq);
        this.cCi.setData(kVar.threadData.xD());
        if (!akq() && o.lB(this.cCk.threadData.getId())) {
            o.a(this.mTitle, this.cCk.UT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cES, this.cCk.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cCi.getGodReplyContent(), this.cCk.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        this.bNC.setUserAfterClickListener(this.aBE);
        final bb UT = kVar.UT();
        if (this.bNC.getHeaderImg() != null) {
            if (this.bNC.getIsSimpleThread()) {
                this.bNC.getHeaderImg().setVisibility(8);
                this.bOo.setVisibility(8);
            } else if (UT.wm() == null || UT.wm().getPendantData() == null || StringUtils.isNull(UT.wm().getPendantData().uW())) {
                this.bOo.setVisibility(8);
                this.bNC.getHeaderImg().setVisibility(0);
                this.bNC.getHeaderImg().setData(UT);
            } else {
                this.bNC.getHeaderImg().setVisibility(4);
                this.bOo.setVisibility(0);
                this.bOo.setData(UT);
            }
        }
        L(UT);
        M(UT);
        ArrayList<VoiceData.VoiceModel> wB = kVar.threadData.wB();
        if (com.baidu.tbadk.core.util.v.z(wB)) {
            this.cEQ.setVisibility(8);
            z = false;
        } else {
            this.cEQ.setVisibility(0);
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
        } else {
            ArrayList<MediaData> wx = UT.wx();
            if (com.baidu.tbadk.core.i.uj().un() && com.baidu.tbadk.core.util.v.y(wx) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < wx.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.d(wx, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.y(linkedList) > 0) {
                    this.cET.setVisibility(0);
                    this.cET.setFromCDN(this.avq);
                    this.cET.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.card.p.3
                        @Override // com.baidu.tbadk.widget.layout.c
                        public void b(View view, int i2, boolean z2) {
                            ad<com.baidu.tieba.card.data.k> akm = p.this.akm();
                            if (akm != null) {
                                view.setTag("1");
                                if (p.this.aBE != null) {
                                    p.this.aBE.onClick(p.this.cET);
                                }
                                akm.a(view, p.this.cCk);
                            }
                            if (z2) {
                                p.this.akG();
                            } else {
                                p.this.a(view, linkedList, i2, UT);
                            }
                        }
                    });
                    this.cET.setImageMediaList(linkedList);
                } else {
                    this.cET.setVisibility(8);
                }
            } else {
                this.cET.setVisibility(8);
            }
        }
        akE();
        akF();
        setPageUniqueId(getTag());
        hM(gT(1));
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void akE() {
        if (this.cER != null && this.cET != null && this.cCi != null) {
            if (this.cET.getVisibility() == 8 && this.cCi.getVisibility() == 8) {
                this.cER.setVisibility(0);
            } else {
                this.cER.setVisibility(8);
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
                    imageUrlData.urlType = this.avq ? 13 : 14;
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

    public void setFromCDN(boolean z) {
        this.avq = z;
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
        if (this.bNP != null) {
            this.bNP.setUniqueId(bdUniqueId);
        }
        if (this.bNC != null) {
            this.bNC.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.bNP != null) {
            this.bNP.setEventCallback(aVar);
        }
    }

    public View ako() {
        return this.cCi;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bNC != null) {
            return this.bNC.aBr;
        }
        return null;
    }

    public View akp() {
        if (this.bNC != null) {
            return this.bNC.aBt;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akG() {
        eJ(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(boolean z) {
        if (this.cCk != null && this.cCk.threadData != null) {
            if (!akq()) {
                o.lA(this.cCk.threadData.getId());
                o.a(this.mTitle, this.cCk.UT().getId(), e.d.cp_cont_b, e.d.cp_cont_d);
                o.a(this.cES, this.cCk.threadData.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                o.a(this.cCi.getGodReplyContent(), this.cCk.threadData.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cCk.threadData, null, o.wa(), 18003, true, false, false).addLocateParam(this.cCk.akX());
            addLocateParam.setForumId(String.valueOf(this.cCk.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.cCk.threadData.ws());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            o.lA(this.cCk.UT().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akq() {
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

    private void M(bb bbVar) {
        if (bbVar != null && gT(2) == 1) {
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

    public void eL(boolean z) {
        if (this.cCj != null) {
            this.cCj.setVisibility(z ? 0 : 8);
        }
    }

    public void eM(boolean z) {
        this.cEU = z;
    }

    public void hM(int i) {
        if (this.cCk != null && this.cCk.threadData != null) {
            this.mStType = o.wa();
            if (i == 1) {
                this.bND.setVisibility(8);
                this.bOr.setStType(this.mStType);
                this.bOr.setData(this.cCk.threadData);
                this.bNC.showForumNameView(false);
                return;
            }
            this.bND.setData(this.cCk.threadData);
            this.bND.setStType(this.mStType);
            this.bOr.setVisibility(8);
            this.bNC.showForumNameView(true);
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
