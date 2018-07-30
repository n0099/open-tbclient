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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    protected boolean asR;
    protected bb atD;
    private View axE;
    private final View.OnClickListener axO;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    protected ThreadCommentAndPraiseInfoLayout bHO;
    protected ThreadSourceShareAndPraiseLayout bIC;
    public LinearLayout bIN;
    private HeadPendantClickableView bIz;
    protected View bkE;
    public TbImageView cAK;
    private TbImageView cAM;
    private RelativeLayout cSA;
    private ThreadGodReplyLayout cwv;
    private View.OnClickListener cwy;
    private PlayVoiceBntNew czb;
    protected View czc;
    private TextView czd;
    protected ConstrainImageGroup cze;
    private final View.OnClickListener czh;
    private com.baidu.tieba.frs.vc.g duX;
    private String dvh;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.asR = true;
        this.cwy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.atD().atE()) {
                    if (e.this.bHO != null) {
                        e.this.bHO.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (e.this.aiz() != null) {
                    e.this.aiz().a(view, e.this.atD);
                }
                e.this.es(view == e.this.cwv);
            }
        };
        this.czh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> aiz = e.this.aiz();
                if (aiz != null) {
                    view.setTag("2");
                    aiz.a(view, e.this.atD);
                }
            }
        };
        this.axO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aiz() != null) {
                    e.this.aiz().a(view, e.this.atD);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bIz = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.bIz.setAfterClickListener(this.axO);
        this.bkE = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.czb = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.czb.setAfterClickListener(this.czh);
        this.czd = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.czd.setVisibility(8);
        this.czc = view.findViewById(d.g.divider_line_above_praise);
        this.cze = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cze.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cze.setChildClickListener(this.cwy);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.h(1.0d);
        this.cze.setImageProcessor(eVar);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bHN.setUserAfterClickListener(this.axO);
        this.bHN.setFrom(3);
        this.bHO.setOnClickListener(this.cwy);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setShareVisible(true);
        this.bHO.setShareReportFrom(1);
        this.bHO.setStType("frs_page");
        this.bHO.setFrom(2);
        this.bHO.ajY = 3;
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        if (this.bIC != null) {
            this.bIC.ayr.setOnClickListener(this.cwy);
            this.bIC.setFrom(2);
            this.bIC.setShareReportFrom(1);
            this.bIC.setSourceFromForPb(3);
            this.bIC.setStType("frs_page");
            this.bIC.setHideBarName(true);
            this.bIC.ayr.setNeedAddReplyIcon(true);
        }
        this.cSA = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.duX = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.cSA);
        this.duX.setUniqueId(getTag());
        this.cwv = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.cwv.setOnClickListener(this.cwy);
        this.cAK = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cAK.setPageId(getTag());
        this.cAM = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        if (this.cAM != null) {
            this.cAM.setPageId(getTag());
        }
        this.axE = view.findViewById(d.g.thread_multi_del_mask_view);
        this.axE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bHO != null) {
                    e.this.bHO.changeSelectStatus();
                }
            }
        });
        this.bHO.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void aU(boolean z) {
                if (e.this.axE != null) {
                    e.this.axE.setBackgroundColor(am.getColor(z ? d.C0140d.cp_bg_line_d : d.C0140d.transparent));
                }
            }
        });
        this.bIN = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout VA() {
        return this.bHO;
    }

    public ThreadCommentAndPraiseInfoLayout VB() {
        if (this.bIC != null) {
            return this.bIC.ayr;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.cze != null) {
            this.cze.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cze != null) {
            this.cze.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cze != null) {
            this.cze.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.addresslist_item_bg);
            am.j(this.bkE, d.C0140d.cp_bg_line_e);
            this.cze.onChangeSkinType();
            this.bHO.onChangeSkinType();
            this.bHN.onChangeSkinType();
            this.duX.onChangeSkinType();
            if (this.bIC != null && this.bIC.getVisibility() == 0) {
                this.bIC.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(final bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.atD = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwy);
        }
        this.cwv.onChangeSkinType();
        if (!aiD() && o.kX(this.atD.getId())) {
            o.a(this.mTitle, this.atD.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            o.a(this.czd, this.atD.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
            o.a(this.cwv.getGodReplyContent(), this.atD.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        }
        P(bbVar);
        this.duX.ae(this.atD);
        M(bbVar);
        this.bHN.setData(this.atD);
        this.cwv.setFromCDN(this.asR);
        this.cwv.setData(this.atD.wx());
        this.bHN.setUserAfterClickListener(this.axO);
        hn(gu(1));
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (bbVar.vk() == null || bbVar.vk().getPendantData() == null || StringUtils.isNull(bbVar.vk().getPendantData().tU())) {
                this.bIz.setVisibility(8);
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(bbVar);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
                this.bIz.setVisibility(0);
                this.bIz.setData(bbVar);
            }
        }
        K(bbVar);
        L(bbVar);
        ArrayList<VoiceData.VoiceModel> vz = bbVar.vz();
        if (w.z(vz)) {
            this.czb.setVisibility(8);
        } else {
            this.czb.bxp();
            this.czb.setVisibility(0);
            VoiceData.VoiceModel voiceModel = vz.get(0);
            this.czb.setVoiceModel(voiceModel);
            this.czb.setTag(voiceModel);
            this.czb.aPt();
            if (voiceModel != null) {
                this.czb.oH(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> vv = bbVar.vv();
        if (com.baidu.tbadk.core.i.te().tk() && w.y(vv) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < vv.size(); i++) {
                MediaData mediaData = (MediaData) w.d(vv, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (w.y(linkedList) > 0) {
                this.cze.setVisibility(0);
                this.cze.setFromCDN(this.asR);
                this.cze.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void c(View view, int i2, boolean z) {
                        ad<bb> aiz = e.this.aiz();
                        if (z) {
                            if (aiz != null) {
                                view.setTag("1");
                                aiz.bhE = true;
                                aiz.a(view, e.this.atD);
                            }
                            e.this.es(false);
                            return;
                        }
                        if (aiz != null) {
                            view.setTag("1");
                            aiz.bhE = false;
                            aiz.a(view, e.this.atD);
                        }
                        e.this.a(view, linkedList, i2, bbVar);
                    }
                });
                this.cze.setImageMediaList(linkedList);
            } else {
                this.cze.setVisibility(8);
            }
        } else {
            this.cze.setVisibility(8);
        }
        aiQ();
        aiR();
        axw();
        if (this.bHO.isInFrsAllThread() && com.baidu.tieba.frs.a.atD().atE()) {
            this.axE.setVisibility(0);
            if (this.atD.wH() || this.atD.wI()) {
                am.j(this.axE, d.C0140d.cp_bg_line_d);
            } else {
                this.axE.setBackgroundResource(d.C0140d.transparent);
            }
        } else {
            this.axE.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aiQ() {
        if (this.czc != null && this.cze != null && this.cwv != null) {
            if (this.cze.getVisibility() == 8 && this.cwv.getVisibility() == 8) {
                this.czc.setVisibility(0);
            } else {
                this.czc.setVisibility(8);
            }
        }
    }

    private void M(final bb bbVar) {
        if (this.cAM != null) {
            if (this.cAK == null || bbVar == null) {
                this.cAM.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.ajI) && this.cAK.getVisibility() != 0) {
                if (this.duX != null && this.duX.aAM() && (this.cAM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAM.getLayoutParams();
                    layoutParams.rightMargin = l.f(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cAM.setLayoutParams(layoutParams);
                }
                this.cAM.setVisibility(0);
                this.cAM.setImageDrawable(null);
                this.cAM.startLoad(bbVar.ajI, 10, false);
                this.cAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bbVar.ajJ, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cAM.setVisibility(8);
            }
        }
    }

    public void P(bb bbVar) {
        MetaData vk;
        if (bbVar != null && this.cAK != null && (vk = bbVar.vk()) != null) {
            final ThemeCardInUserData themeCard = vk.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cAK.setVisibility(8);
                return;
            }
            this.cAK.setVisibility(0);
            this.cAK.setImageDrawable(null);
            this.cAK.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cAK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
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
            l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.asR ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bbVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!w.z(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.vq(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.asR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void aiR() {
        this.czb.setClickable(true);
        int childCount = this.cze.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cze.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.asR = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bHO != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bHN != null) {
            this.bHN.setPageUniqueId(bdUniqueId);
        }
        if (this.cze != null) {
            this.cze.setPageUniqueId(bdUniqueId);
        }
    }

    protected void es(boolean z) {
        if (this.atD != null) {
            o.kW(this.atD.getId());
            o.a(this.mTitle, this.atD.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            o.a(this.czd, this.atD.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
            o.a(this.cwv.getGodReplyContent(), this.atD.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
            m wd = this.atD.wd();
            if (wd != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.aU(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), wd.getCartoonId(), wd.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.atD.ajf;
            if (this.atD.aje == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aeD;
                long j = jVar.aeE;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aeR = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.atD, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.atD.vZ() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aiD() {
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
    public void hl(int i) {
        this.currentPageType = i;
        if (this.bHO != null) {
            this.bHO.ajY = i;
            if (i == 15) {
                this.bHO.setFrom(10);
            } else {
                this.bHO.setFrom(2);
            }
        }
        if (this.bHN != null) {
            if (i == 15) {
                this.bHN.setFrom(5);
            } else {
                this.bHN.setFrom(3);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.czb != null) {
            this.czb.setVoiceManager(voiceManager);
        }
    }

    private boolean K(bb bbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dvh)) {
            bbVar.O(this.mUrl, this.dvh);
        }
        SpannableStringBuilder g = bbVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bbVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
        return true;
    }

    private void L(bb bbVar) {
        if (bbVar != null && gu(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dvh)) {
                bbVar.O(this.mUrl, this.dvh);
            }
            SpannableString wz = bbVar.wz();
            if (wz != null && !ap.isEmpty(wz.toString())) {
                this.czd.setVisibility(0);
                this.czd.setOnTouchListener(new k(wz));
                this.czd.setText(wz);
                o.a(this.czd, bbVar.getId(), d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
                return;
            }
            this.czd.setVisibility(8);
            return;
        }
        this.czd.setVisibility(8);
    }

    private void axw() {
        if (this.mTitle != null && this.czb != null && this.cze != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.czb.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.czb.setLayoutParams(layoutParams);
            if (this.czb.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cze.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.cze.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hn(int i) {
        if (this.atD != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                if (this.bIC != null) {
                    this.bIC.setData(this.atD);
                    return;
                }
                return;
            }
            this.bHO.setData(this.atD);
            if (this.bIC != null) {
                this.bIC.setVisibility(8);
            }
        }
    }

    public void O(String str, String str2) {
        this.mUrl = str;
        this.dvh = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gu(int i) {
        return com.baidu.tieba.a.d.QI().G(this.bHB, i);
    }
}
