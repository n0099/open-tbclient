package com.baidu.tieba.frs.entelechy.view;

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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    private View aAH;
    private final View.OnClickListener aBE;
    protected boolean avq;
    protected bb awf;
    public ThreadUserInfoLayout bNC;
    protected ThreadCommentAndPraiseInfoLayout bND;
    private String bNq;
    public LinearLayout bOC;
    private HeadPendantClickableView bOo;
    protected ThreadSourceShareAndPraiseLayout bOr;
    protected View bqy;
    private ThreadGodReplyLayout cCi;
    private View.OnClickListener cCl;
    private PlayVoiceBntNew cEQ;
    protected View cER;
    private TextView cES;
    protected ConstrainImageGroup cET;
    private final View.OnClickListener cEW;
    private TbImageView cGB;
    public TbImageView cGz;
    private RelativeLayout cYo;
    private com.baidu.tieba.frs.vc.g dBC;
    private String dBN;
    private AppletsCellView dBO;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.avq = true;
        this.cCl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.avq().avr()) {
                    if (e.this.bND != null) {
                        e.this.bND.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (e.this.akm() != null) {
                    e.this.akm().a(view, e.this.awf);
                }
                e.this.eJ(view == e.this.cCi);
            }
        };
        this.cEW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> akm = e.this.akm();
                if (akm != null) {
                    view.setTag("2");
                    akm.a(view, e.this.awf);
                }
            }
        };
        this.aBE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.akm() != null) {
                    e.this.akm().a(view, e.this.awf);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bOo = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bOo.getHeadView() != null) {
            this.bOo.getHeadView().setIsRound(true);
            this.bOo.getHeadView().setDrawBorder(false);
            this.bOo.getHeadView().setDefaultResource(17170445);
            this.bOo.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bOo.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bOo.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0141e.ds70));
        }
        this.bOo.setHasPendantStyle();
        if (this.bOo.getPendantView() != null) {
            this.bOo.getPendantView().setIsRound(true);
            this.bOo.getPendantView().setDrawBorder(false);
        }
        this.bOo.setAfterClickListener(this.aBE);
        this.bqy = view.findViewById(e.g.divider_line);
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cEQ = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cEQ.setAfterClickListener(this.cEW);
        this.cES = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cES.setVisibility(8);
        this.cER = view.findViewById(e.g.divider_line_above_praise);
        this.cET = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cET.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.tbds20));
        this.cET.setChildClickListener(this.cCl);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cET.setImageProcessor(eVar);
        this.bND = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bNC = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bNC.setUserAfterClickListener(this.aBE);
        this.bNC.setFrom(3);
        this.bND.setOnClickListener(this.cCl);
        this.bND.setReplyTimeVisible(false);
        this.bND.setShowPraiseNum(true);
        this.bND.setNeedAddPraiseIcon(true);
        this.bND.setNeedAddReplyIcon(true);
        this.bND.setIsBarViewVisible(false);
        this.bND.setShareVisible(true);
        this.bND.setShareReportFrom(1);
        this.bND.setStType("frs_page");
        this.bND.setFrom(2);
        this.bND.setDisPraiseFrom(2);
        this.bND.amD = 3;
        this.bOr = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        if (this.bOr != null) {
            this.bOr.aBl.setOnClickListener(this.cCl);
            this.bOr.setFrom(2);
            this.bOr.setShareReportFrom(1);
            this.bOr.setSourceFromForPb(3);
            this.bOr.setStType("frs_page");
            this.bOr.setHideBarName(true);
            this.bOr.aBl.setNeedAddReplyIcon(true);
        }
        this.cYo = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.dBC = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.cYo);
        this.dBC.setUniqueId(getTag());
        this.cCi = (ThreadGodReplyLayout) view.findViewById(e.g.card_frs_god_reply_layout);
        this.cCi.setOnClickListener(this.cCl);
        this.cGz = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.cGz.setPageId(getTag());
        this.cGB = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        if (this.cGB != null) {
            this.cGB.setPageId(getTag());
        }
        this.aAH = view.findViewById(e.g.thread_multi_del_mask_view);
        this.aAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bND != null) {
                    e.this.bND.changeSelectStatus();
                }
            }
        });
        this.bND.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void bh(boolean z) {
                if (e.this.aAH != null) {
                    e.this.aAH.setBackgroundColor(al.getColor(z ? e.d.cp_bg_line_d : e.d.transparent));
                }
            }
        });
        this.bOC = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.dBO = (AppletsCellView) view.findViewById(e.g.card_home_page_normal_thread_share_info);
    }

    public ThreadCommentAndPraiseInfoLayout Xq() {
        return this.bND;
    }

    public ThreadCommentAndPraiseInfoLayout Xr() {
        if (this.bOr != null) {
            return this.bOr.aBl;
        }
        return null;
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
            al.j(this.bqy, e.d.cp_bg_line_e);
            this.cET.onChangeSkinType();
            this.bND.onChangeSkinType();
            this.bNC.onChangeSkinType();
            this.dBC.onChangeSkinType();
            if (this.bOr != null && this.bOr.getVisibility() == 0) {
                this.bOr.onChangeSkinType();
            }
            if (this.dBO != null) {
                this.dBO.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(final bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.awf = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cCl);
        }
        this.cCi.onChangeSkinType();
        if (!akq() && o.lB(this.awf.getId())) {
            o.a(this.mTitle, this.awf.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cES, this.awf.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cCi.getGodReplyContent(), this.awf.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        Q(bbVar);
        this.dBC.af(this.awf);
        N(bbVar);
        this.bNC.setData(this.awf);
        this.cCi.setFromCDN(this.avq);
        this.cCi.setData(this.awf.xD());
        this.bNC.setUserAfterClickListener(this.aBE);
        hM(gT(1));
        if (this.bNC.getHeaderImg() != null) {
            if (this.bNC.getIsSimpleThread()) {
                this.bNC.getHeaderImg().setVisibility(8);
                this.bOo.setVisibility(8);
            } else if (bbVar.wm() == null || bbVar.wm().getPendantData() == null || StringUtils.isNull(bbVar.wm().getPendantData().uW())) {
                this.bOo.setVisibility(8);
                this.bNC.getHeaderImg().setVisibility(0);
                this.bNC.getHeaderImg().setData(bbVar);
            } else {
                this.bNC.getHeaderImg().setVisibility(4);
                this.bOo.setVisibility(0);
                this.bOo.setData(bbVar);
            }
        }
        L(bbVar);
        M(bbVar);
        this.dBO.setData(bbVar.wS());
        this.dBO.setForumId(String.valueOf(bbVar.getFid()));
        AppletsCellView appletsCellView = this.dBO;
        AppletsCellView appletsCellView2 = this.dBO;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> wB = bbVar.wB();
        if (v.z(wB)) {
            this.cEQ.setVisibility(8);
        } else {
            this.cEQ.bzY();
            this.cEQ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = wB.get(0);
            this.cEQ.setVoiceModel(voiceModel);
            this.cEQ.setTag(voiceModel);
            this.cEQ.aRD();
            if (voiceModel != null) {
                this.cEQ.pl(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> wx = bbVar.wx();
        if (com.baidu.tbadk.core.i.uj().un() && v.y(wx) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < wx.size(); i++) {
                MediaData mediaData = (MediaData) v.d(wx, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.y(linkedList) > 0) {
                this.cET.setVisibility(0);
                this.cET.setFromCDN(this.avq);
                this.cET.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> akm = e.this.akm();
                        if (z) {
                            if (akm != null) {
                                view.setTag("1");
                                akm.bnx = true;
                                akm.a(view, e.this.awf);
                            }
                            e.this.eJ(false);
                            return;
                        }
                        if (akm != null) {
                            view.setTag("1");
                            akm.bnx = false;
                            akm.a(view, e.this.awf);
                        }
                        e.this.a(view, linkedList, i2, bbVar);
                    }
                });
                this.cET.setImageMediaList(linkedList);
            } else {
                this.cET.setVisibility(8);
            }
        } else {
            this.cET.setVisibility(8);
        }
        akE();
        akF();
        azJ();
        if (this.bND.isInFrsAllThread() && com.baidu.tieba.frs.a.avq().avr()) {
            this.aAH.setVisibility(0);
            if (this.awf.xN() || this.awf.xO()) {
                al.j(this.aAH, e.d.cp_bg_line_d);
            } else {
                this.aAH.setBackgroundResource(e.d.transparent);
            }
        } else {
            this.aAH.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void akE() {
        if (this.cER != null && this.cET != null && this.cCi != null) {
            if (this.cET.getVisibility() == 8 && this.cCi.getVisibility() == 8 && this.dBO.getVisibility() == 8) {
                this.cER.setVisibility(0);
            } else {
                this.cER.setVisibility(8);
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.cGB != null) {
            if (this.cGz == null || bbVar == null) {
                this.cGB.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.amm) && this.cGz.getVisibility() != 0) {
                if (this.dBC != null && this.dBC.aCS() && (this.cGB.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGB.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0141e.tbds106);
                    this.cGB.setLayoutParams(layoutParams);
                }
                this.cGB.setVisibility(0);
                this.cGB.setImageDrawable(null);
                this.cGB.startLoad(bbVar.amm, 10, false);
                this.cGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bbVar.amn, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cGB.setVisibility(8);
            }
        }
    }

    public void Q(bb bbVar) {
        MetaData wm;
        if (bbVar != null && this.cGz != null && (wm = bbVar.wm()) != null) {
            final ThemeCardInUserData themeCard = wm.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cGz.setVisibility(8);
                return;
            }
            this.cGz.setVisibility(0);
            this.cGz.setImageDrawable(null);
            this.cGz.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
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
            String str = null;
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                str = mediaData.getSrc_pic();
            } else if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                str = mediaData.getPicUrl();
            }
            if (!StringUtils.isNull(str)) {
                arrayList.add(str);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.avq ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bbVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.z(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.ws(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.avq, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        }
    }

    private String a(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            return mediaData.getSrc_pic();
        }
        return picUrl;
    }

    private void akF() {
        this.cEQ.setClickable(true);
        int childCount = this.cET.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cET.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.avq = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bND != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bNC != null) {
            this.bNC.setPageUniqueId(bdUniqueId);
        }
        if (this.cET != null) {
            this.cET.setPageUniqueId(bdUniqueId);
        }
    }

    protected void eJ(boolean z) {
        if (this.awf != null) {
            o.lA(this.awf.getId());
            o.a(this.mTitle, this.awf.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cES, this.awf.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cCi.getGodReplyContent(), this.awf.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            m xh = this.awf.xh();
            if (xh != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bz(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), xh.getCartoonId(), xh.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.awf.alH;
            if (this.awf.alG == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.ahe;
                long j = jVar.ahf;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.ahs = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.awf, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.awf.xd() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean akq() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hK(int i) {
        this.currentPageType = i;
        if (this.bND != null) {
            this.bND.amD = i;
            if (i == 15) {
                this.bND.setFrom(10);
            } else {
                this.bND.setFrom(2);
                this.bND.setDisPraiseFrom(2);
            }
        }
        if (this.bNC != null) {
            if (i == 15) {
                this.bNC.setFrom(5);
            } else {
                this.bNC.setFrom(3);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cEQ != null) {
            this.cEQ.setVoiceManager(voiceManager);
        }
    }

    private boolean L(bb bbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dBN)) {
            bbVar.V(this.mUrl, this.dBN);
        }
        SpannableStringBuilder i = bbVar.i(false, true);
        if (i == null || StringUtils.isNull(i.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        return true;
    }

    private void M(bb bbVar) {
        if (bbVar != null && gT(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dBN)) {
                bbVar.V(this.mUrl, this.dBN);
            }
            SpannableString xF = bbVar.xF();
            if (xF != null && !ao.isEmpty(xF.toString())) {
                this.cES.setVisibility(0);
                this.cES.setOnTouchListener(new k(xF));
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
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds20);
            this.cEQ.setLayoutParams(layoutParams);
            if (this.cEQ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cET.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds28);
                this.cET.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hM(int i) {
        if (this.awf != null) {
            if (i == 1) {
                this.bND.setVisibility(8);
                if (this.bOr != null) {
                    this.bOr.setData(this.awf);
                    return;
                }
                return;
            }
            this.bND.setData(this.awf);
            if (this.bOr != null) {
                this.bOr.setVisibility(8);
            }
        }
    }

    public void V(String str, String str2) {
        this.mUrl = str;
        this.dBN = str2;
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
