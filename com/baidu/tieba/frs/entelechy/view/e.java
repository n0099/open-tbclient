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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    protected boolean asS;
    protected bb atE;
    private View axB;
    private final View.OnClickListener axL;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    protected ThreadCommentAndPraiseInfoLayout bHO;
    protected ThreadSourceShareAndPraiseLayout bIC;
    public LinearLayout bIN;
    private HeadPendantClickableView bIz;
    protected View bkJ;
    public TbImageView cAH;
    private TbImageView cAJ;
    private RelativeLayout cSx;
    private ThreadGodReplyLayout cws;
    private View.OnClickListener cwv;
    private PlayVoiceBntNew cyY;
    protected View cyZ;
    private TextView cza;
    protected ConstrainImageGroup czb;
    private final View.OnClickListener cze;
    private com.baidu.tieba.frs.vc.g duU;
    private String dve;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.asS = true;
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.atC().atD()) {
                    if (e.this.bHO != null) {
                        e.this.bHO.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (e.this.aiC() != null) {
                    e.this.aiC().a(view, e.this.atE);
                }
                e.this.es(view == e.this.cws);
            }
        };
        this.cze = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> aiC = e.this.aiC();
                if (aiC != null) {
                    view.setTag("2");
                    aiC.a(view, e.this.atE);
                }
            }
        };
        this.axL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aiC() != null) {
                    e.this.aiC().a(view, e.this.atE);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bIz = (HeadPendantClickableView) view.findViewById(f.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bIz.getHeadView() != null) {
            this.bIz.getHeadView().setIsRound(true);
            this.bIz.getHeadView().setDrawBorder(false);
            this.bIz.getHeadView().setDefaultResource(17170445);
            this.bIz.getHeadView().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.bIz.getHeadView().setDefaultBgResource(f.d.cp_bg_line_e);
            this.bIz.getHeadView().setRadius(l.f(this.mPageContext.getPageActivity(), f.e.ds70));
        }
        this.bIz.setHasPendantStyle();
        if (this.bIz.getPendantView() != null) {
            this.bIz.getPendantView().setIsRound(true);
            this.bIz.getPendantView().setDrawBorder(false);
        }
        this.bIz.setAfterClickListener(this.axL);
        this.bkJ = view.findViewById(f.g.divider_line);
        this.mTitle = (TextView) view.findViewById(f.g.card_home_page_normal_thread_title);
        this.cyY = (PlayVoiceBntNew) view.findViewById(f.g.card_home_page_normal_thread_abstract_voice);
        this.cyY.setAfterClickListener(this.cze);
        this.cza = (TextView) view.findViewById(f.g.card_home_page_normal_thread_abstract);
        this.cza.setVisibility(8);
        this.cyZ = view.findViewById(f.g.divider_line_above_praise);
        this.czb = (ConstrainImageGroup) view.findViewById(f.g.card_home_page_normal_thread_img_layout);
        this.czb.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds20));
        this.czb.setChildClickListener(this.cwv);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.czb.setImageProcessor(eVar);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.card_home_page_normal_thread_info_layout);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(f.g.card_home_page_normal_thread_user_info_layout);
        this.bHN.setUserAfterClickListener(this.axL);
        this.bHN.setFrom(3);
        this.bHO.setOnClickListener(this.cwv);
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
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.card_home_page_source_read_share_layout);
        if (this.bIC != null) {
            this.bIC.ayo.setOnClickListener(this.cwv);
            this.bIC.setFrom(2);
            this.bIC.setShareReportFrom(1);
            this.bIC.setSourceFromForPb(3);
            this.bIC.setStType("frs_page");
            this.bIC.setHideBarName(true);
            this.bIC.ayo.setNeedAddReplyIcon(true);
        }
        this.cSx = (RelativeLayout) view.findViewById(f.g.card_home_page_normal_thread_root);
        this.duU = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.cSx);
        this.duU.setUniqueId(getTag());
        this.cws = (ThreadGodReplyLayout) view.findViewById(f.g.card_frs_god_reply_layout);
        this.cws.setOnClickListener(this.cwv);
        this.cAH = (TbImageView) view.findViewById(f.g.frs_normal_item_theme_card);
        this.cAH.setPageId(getTag());
        this.cAJ = (TbImageView) view.findViewById(f.g.frs_normal_item_star_view);
        if (this.cAJ != null) {
            this.cAJ.setPageId(getTag());
        }
        this.axB = view.findViewById(f.g.thread_multi_del_mask_view);
        this.axB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bHO != null) {
                    e.this.bHO.changeSelectStatus();
                }
            }
        });
        this.bHO.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void aV(boolean z) {
                if (e.this.axB != null) {
                    e.this.axB.setBackgroundColor(am.getColor(z ? f.d.cp_bg_line_d : f.d.transparent));
                }
            }
        });
        this.bIN = (LinearLayout) view.findViewById(f.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout VD() {
        return this.bHO;
    }

    public ThreadCommentAndPraiseInfoLayout VE() {
        if (this.bIC != null) {
            return this.bIC.ayo;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.czb != null) {
            this.czb.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.czb != null) {
            this.czb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.czb != null) {
            this.czb.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.addresslist_item_bg);
            am.j(this.bkJ, f.d.cp_bg_line_e);
            this.czb.onChangeSkinType();
            this.bHO.onChangeSkinType();
            this.bHN.onChangeSkinType();
            this.duU.onChangeSkinType();
            if (this.bIC != null && this.bIC.getVisibility() == 0) {
                this.bIC.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_home_page_multi_img_new_frame;
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
        this.atE = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cwv);
        }
        this.cws.onChangeSkinType();
        if (!aiG() && o.kZ(this.atE.getId())) {
            o.a(this.mTitle, this.atE.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            o.a(this.cza, this.atE.getId(), f.d.cp_cont_j, f.d.cp_cont_d);
            o.a(this.cws.getGodReplyContent(), this.atE.getId(), f.d.cp_cont_f, f.d.cp_cont_d);
        }
        P(bbVar);
        this.duU.ae(this.atE);
        M(bbVar);
        this.bHN.setData(this.atE);
        this.cws.setFromCDN(this.asS);
        this.cws.setData(this.atE.ww());
        this.bHN.setUserAfterClickListener(this.axL);
        hm(gt(1));
        if (this.bHN.getHeaderImg() != null) {
            if (this.bHN.getIsSimpleThread()) {
                this.bHN.getHeaderImg().setVisibility(8);
                this.bIz.setVisibility(8);
            } else if (bbVar.vj() == null || bbVar.vj().getPendantData() == null || StringUtils.isNull(bbVar.vj().getPendantData().tT())) {
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
        ArrayList<VoiceData.VoiceModel> vy = bbVar.vy();
        if (w.z(vy)) {
            this.cyY.setVisibility(8);
        } else {
            this.cyY.bxq();
            this.cyY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = vy.get(0);
            this.cyY.setVoiceModel(voiceModel);
            this.cyY.setTag(voiceModel);
            this.cyY.aPq();
            if (voiceModel != null) {
                this.cyY.oH(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> vu = bbVar.vu();
        if (com.baidu.tbadk.core.i.td().tj() && w.y(vu) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < vu.size(); i++) {
                MediaData mediaData = (MediaData) w.d(vu, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (w.y(linkedList) > 0) {
                this.czb.setVisibility(0);
                this.czb.setFromCDN(this.asS);
                this.czb.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> aiC = e.this.aiC();
                        if (z) {
                            if (aiC != null) {
                                view.setTag("1");
                                aiC.bhF = true;
                                aiC.a(view, e.this.atE);
                            }
                            e.this.es(false);
                            return;
                        }
                        if (aiC != null) {
                            view.setTag("1");
                            aiC.bhF = false;
                            aiC.a(view, e.this.atE);
                        }
                        e.this.a(view, linkedList, i2, bbVar);
                    }
                });
                this.czb.setImageMediaList(linkedList);
            } else {
                this.czb.setVisibility(8);
            }
        } else {
            this.czb.setVisibility(8);
        }
        aiT();
        aiU();
        axv();
        if (this.bHO.isInFrsAllThread() && com.baidu.tieba.frs.a.atC().atD()) {
            this.axB.setVisibility(0);
            if (this.atE.wG() || this.atE.wH()) {
                am.j(this.axB, f.d.cp_bg_line_d);
            } else {
                this.axB.setBackgroundResource(f.d.transparent);
            }
        } else {
            this.axB.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aiT() {
        if (this.cyZ != null && this.czb != null && this.cws != null) {
            if (this.czb.getVisibility() == 8 && this.cws.getVisibility() == 8) {
                this.cyZ.setVisibility(0);
            } else {
                this.cyZ.setVisibility(8);
            }
        }
    }

    private void M(final bb bbVar) {
        if (this.cAJ != null) {
            if (this.cAH == null || bbVar == null) {
                this.cAJ.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.ajI) && this.cAH.getVisibility() != 0) {
                if (this.duU != null && this.duU.aAJ() && (this.cAJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAJ.getLayoutParams();
                    layoutParams.rightMargin = l.f(this.mPageContext.getPageActivity(), f.e.tbds106);
                    this.cAJ.setLayoutParams(layoutParams);
                }
                this.cAJ.setVisibility(0);
                this.cAJ.setImageDrawable(null);
                this.cAJ.startLoad(bbVar.ajI, 10, false);
                this.cAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bbVar.ajJ, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cAJ.setVisibility(8);
            }
        }
    }

    public void P(bb bbVar) {
        MetaData vj;
        if (bbVar != null && this.cAH != null && (vj = bbVar.vj()) != null) {
            final ThemeCardInUserData themeCard = vj.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cAH.setVisibility(8);
                return;
            }
            this.cAH.setVisibility(0);
            this.cAH.setImageDrawable(null);
            this.cAH.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
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
            l.showToast(this.mPageContext.getPageActivity(), f.j.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.asS ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.vp(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.asS, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void aiU() {
        this.cyY.setClickable(true);
        int childCount = this.czb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.czb.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.asS = z;
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
        if (this.czb != null) {
            this.czb.setPageUniqueId(bdUniqueId);
        }
    }

    protected void es(boolean z) {
        if (this.atE != null) {
            o.kY(this.atE.getId());
            o.a(this.mTitle, this.atE.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
            o.a(this.cza, this.atE.getId(), f.d.cp_cont_j, f.d.cp_cont_d);
            o.a(this.cws.getGodReplyContent(), this.atE.getId(), f.d.cp_cont_f, f.d.cp_cont_d);
            m wc = this.atE.wc();
            if (wc != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    com.baidu.tbadk.core.util.bb.aT(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), wc.getCartoonId(), wc.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.atE.ajf;
            if (this.atE.aje == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aeD;
                long j = jVar.aeE;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aeR = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.atE, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.atE.vY() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aiG() {
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
    public void hk(int i) {
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
        if (this.cyY != null) {
            this.cyY.setVoiceManager(voiceManager);
        }
    }

    private boolean K(bb bbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dve)) {
            bbVar.O(this.mUrl, this.dve);
        }
        SpannableStringBuilder g = bbVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bbVar.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        }
        return true;
    }

    private void L(bb bbVar) {
        if (bbVar != null && gt(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dve)) {
                bbVar.O(this.mUrl, this.dve);
            }
            SpannableString wy = bbVar.wy();
            if (wy != null && !ap.isEmpty(wy.toString())) {
                this.cza.setVisibility(0);
                this.cza.setOnTouchListener(new k(wy));
                this.cza.setText(wy);
                o.a(this.cza, bbVar.getId(), f.d.cp_cont_j, f.d.cp_cont_d);
                return;
            }
            this.cza.setVisibility(8);
            return;
        }
        this.cza.setVisibility(8);
    }

    private void axv() {
        if (this.mTitle != null && this.cyY != null && this.czb != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cyY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(f.e.tbds20);
            this.cyY.setLayoutParams(layoutParams);
            if (this.cyY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.czb.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(f.e.tbds28);
                this.czb.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hm(int i) {
        if (this.atE != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                if (this.bIC != null) {
                    this.bIC.setData(this.atE);
                    return;
                }
                return;
            }
            this.bHO.setData(this.atE);
            if (this.bIC != null) {
                this.bIC.setVisibility(8);
            }
        }
    }

    public void O(String str, String str2) {
        this.mUrl = str;
        this.dve = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}
