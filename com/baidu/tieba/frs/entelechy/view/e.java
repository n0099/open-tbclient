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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<bc> implements com.baidu.tieba.a.e, ab {
    protected bc atZ;
    protected boolean atn;
    private View axY;
    private final View.OnClickListener ayi;
    private String bGM;
    public ThreadUserInfoLayout bGY;
    protected ThreadCommentAndPraiseInfoLayout bGZ;
    private HeadPendantClickableView bHK;
    protected ThreadSourceShareAndPraiseLayout bHN;
    public LinearLayout bHY;
    protected View bjZ;
    private RelativeLayout cPO;
    private ThreadGodReplyLayout ctS;
    private View.OnClickListener ctV;
    private TextView cwA;
    protected ConstrainImageGroup cwB;
    private final View.OnClickListener cwE;
    private PlayVoiceBntNew cwy;
    protected View cwz;
    public TbImageView cyh;
    private TbImageView cyj;
    private com.baidu.tieba.frs.vc.g dsk;
    private String dst;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.atn = true;
        this.ctV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.asZ().ata()) {
                    if (e.this.bGZ != null) {
                        e.this.bGZ.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (e.this.aia() != null) {
                    e.this.aia().a(view, e.this.atZ);
                }
                e.this.er(view == e.this.ctS);
            }
        };
        this.cwE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bc> aia = e.this.aia();
                if (aia != null) {
                    view.setTag("2");
                    aia.a(view, e.this.atZ);
                }
            }
        };
        this.ayi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aia() != null) {
                    e.this.aia().a(view, e.this.atZ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bHK = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bHK.getHeadView() != null) {
            this.bHK.getHeadView().setIsRound(true);
            this.bHK.getHeadView().setDrawBorder(false);
            this.bHK.getHeadView().setDefaultResource(17170445);
            this.bHK.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bHK.getHeadView().setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.bHK.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bHK.setHasPendantStyle();
        if (this.bHK.getPendantView() != null) {
            this.bHK.getPendantView().setIsRound(true);
            this.bHK.getPendantView().setDrawBorder(false);
        }
        this.bHK.setAfterClickListener(this.ayi);
        this.bjZ = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cwy = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cwy.setAfterClickListener(this.cwE);
        this.cwA = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cwA.setVisibility(8);
        this.cwz = view.findViewById(d.g.divider_line_above_praise);
        this.cwB = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cwB.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cwB.setChildClickListener(this.ctV);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.cwB.setImageProcessor(eVar);
        this.bGZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bGY = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bGY.setUserAfterClickListener(this.ayi);
        this.bGY.setFrom(3);
        this.bGZ.setOnClickListener(this.ctV);
        this.bGZ.setReplyTimeVisible(false);
        this.bGZ.setShowPraiseNum(true);
        this.bGZ.setNeedAddPraiseIcon(true);
        this.bGZ.setNeedAddReplyIcon(true);
        this.bGZ.setIsBarViewVisible(false);
        this.bGZ.setShareVisible(true);
        this.bGZ.setShareReportFrom(1);
        this.bGZ.setStType("frs_page");
        this.bGZ.setFrom(2);
        this.bGZ.akz = 3;
        this.bHN = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        if (this.bHN != null) {
            this.bHN.ayE.setOnClickListener(this.ctV);
            this.bHN.setFrom(2);
            this.bHN.setShareReportFrom(1);
            this.bHN.setSourceFromForPb(3);
            this.bHN.setStType("frs_page");
            this.bHN.setHideBarName(true);
            this.bHN.ayE.setNeedAddReplyIcon(true);
        }
        this.cPO = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.dsk = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.cPO);
        this.dsk.setUniqueId(getTag());
        this.ctS = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.ctS.setOnClickListener(this.ctV);
        this.cyh = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cyh.setPageId(getTag());
        this.cyj = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        if (this.cyj != null) {
            this.cyj.setPageId(getTag());
        }
        this.axY = view.findViewById(d.g.thread_multi_del_mask_view);
        this.axY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bGZ != null) {
                    e.this.bGZ.changeSelectStatus();
                }
            }
        });
        this.bGZ.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void aW(boolean z) {
                if (e.this.axY != null) {
                    e.this.axY.setBackgroundColor(am.getColor(z ? d.C0142d.cp_bg_line_d : d.C0142d.transparent));
                }
            }
        });
        this.bHY = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout Vr() {
        return this.bGZ;
    }

    public ThreadCommentAndPraiseInfoLayout Vs() {
        if (this.bHN != null) {
            return this.bHN.ayE;
        }
        return null;
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
            am.j(this.bjZ, d.C0142d.cp_bg_line_e);
            this.cwB.onChangeSkinType();
            this.bGZ.onChangeSkinType();
            this.bGY.onChangeSkinType();
            this.dsk.onChangeSkinType();
            if (this.bHN != null && this.bHN.getVisibility() == 0) {
                this.bHN.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: C */
    public void a(final bc bcVar) {
        if (bcVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.atZ = bcVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ctV);
        }
        this.ctS.onChangeSkinType();
        if (!aie() && o.kZ(this.atZ.getId())) {
            o.a(this.mTitle, this.atZ.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            o.a(this.cwA, this.atZ.getId(), d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
            o.a(this.ctS.getGodReplyContent(), this.atZ.getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
        }
        N(bcVar);
        this.dsk.ac(this.atZ);
        K(bcVar);
        this.bGY.setData(this.atZ);
        this.ctS.setFromCDN(this.atn);
        this.ctS.setData(this.atZ.wI());
        this.bGY.setUserAfterClickListener(this.ayi);
        hh(gp(1));
        if (this.bGY.getHeaderImg() != null) {
            if (this.bGY.getIsSimpleThread()) {
                this.bGY.getHeaderImg().setVisibility(8);
                this.bHK.setVisibility(8);
            } else if (bcVar.vw() == null || bcVar.vw().getPendantData() == null || StringUtils.isNull(bcVar.vw().getPendantData().uh())) {
                this.bHK.setVisibility(8);
                this.bGY.getHeaderImg().setVisibility(0);
                this.bGY.getHeaderImg().setData(bcVar);
            } else {
                this.bGY.getHeaderImg().setVisibility(4);
                this.bHK.setVisibility(0);
                this.bHK.setData(bcVar);
            }
        }
        I(bcVar);
        J(bcVar);
        ArrayList<VoiceData.VoiceModel> vK = bcVar.vK();
        if (w.A(vK)) {
            this.cwy.setVisibility(8);
        } else {
            this.cwy.byM();
            this.cwy.setVisibility(0);
            VoiceData.VoiceModel voiceModel = vK.get(0);
            this.cwy.setVoiceModel(voiceModel);
            this.cwy.setTag(voiceModel);
            this.cwy.aOt();
            if (voiceModel != null) {
                this.cwy.ot(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> vG = bcVar.vG();
        if (com.baidu.tbadk.core.i.tt().tz() && w.z(vG) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < vG.size(); i++) {
                MediaData mediaData = (MediaData) w.d(vG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (w.z(linkedList) > 0) {
                this.cwB.setVisibility(0);
                this.cwB.setFromCDN(this.atn);
                this.cwB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void c(View view, int i2, boolean z) {
                        ad<bc> aia = e.this.aia();
                        if (z) {
                            if (aia != null) {
                                view.setTag("1");
                                aia.bgZ = true;
                                aia.a(view, e.this.atZ);
                            }
                            e.this.er(false);
                            return;
                        }
                        if (aia != null) {
                            view.setTag("1");
                            aia.bgZ = false;
                            aia.a(view, e.this.atZ);
                        }
                        e.this.a(view, linkedList, i2, bcVar);
                    }
                });
                this.cwB.setImageMediaList(linkedList);
            } else {
                this.cwB.setVisibility(8);
            }
        } else {
            this.cwB.setVisibility(8);
        }
        air();
        ais();
        awR();
        if (this.bGZ.isInFrsAllThread() && com.baidu.tieba.frs.a.asZ().ata()) {
            this.axY.setVisibility(0);
            if (this.atZ.wS() || this.atZ.wT()) {
                am.j(this.axY, d.C0142d.cp_bg_line_d);
            } else {
                this.axY.setBackgroundResource(d.C0142d.transparent);
            }
        } else {
            this.axY.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void air() {
        if (this.cwz != null && this.cwB != null && this.ctS != null) {
            if (this.cwB.getVisibility() == 8 && this.ctS.getVisibility() == 8) {
                this.cwz.setVisibility(0);
            } else {
                this.cwz.setVisibility(8);
            }
        }
    }

    private void K(final bc bcVar) {
        if (this.cyj != null) {
            if (this.cyh == null || bcVar == null) {
                this.cyj.setVisibility(8);
            } else if (!StringUtils.isNull(bcVar.akl) && this.cyh.getVisibility() != 0) {
                if (this.dsk != null && this.dsk.aAf() && (this.cyj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cyj.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cyj.setLayoutParams(layoutParams);
                }
                this.cyj.setVisibility(0);
                this.cyj.setImageDrawable(null);
                this.cyj.startLoad(bcVar.akl, 10, false);
                this.cyj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bcVar.akm, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.cyj.setVisibility(8);
            }
        }
    }

    public void N(bc bcVar) {
        MetaData vw;
        if (bcVar != null && this.cyh != null && (vw = bcVar.vw()) != null) {
            final ThemeCardInUserData themeCard = vw.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cyh.setVisibility(8);
                return;
            }
            this.cyh.setVisibility(0);
            this.cyh.setImageDrawable(null);
            this.cyh.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cyh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
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
            String str = null;
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                str = mediaData.getSrc_pic();
            } else if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                str = mediaData.getPicUrl();
            }
            if (!StringUtils.isNull(str)) {
                arrayList.add(str);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.atn ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bcVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!w.A(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bcVar.vB(), String.valueOf(bcVar.getFid()), bcVar.getTid(), this.atn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect);
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

    private void ais() {
        this.cwy.setClickable(true);
        int childCount = this.cwB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cwB.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.atn = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bGZ != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bGY != null) {
            this.bGY.setPageUniqueId(bdUniqueId);
        }
        if (this.cwB != null) {
            this.cwB.setPageUniqueId(bdUniqueId);
        }
    }

    protected void er(boolean z) {
        if (this.atZ != null) {
            o.kY(this.atZ.getId());
            o.a(this.mTitle, this.atZ.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
            o.a(this.cwA, this.atZ.getId(), d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
            o.a(this.ctS.getGodReplyContent(), this.atZ.getId(), d.C0142d.cp_cont_f, d.C0142d.cp_cont_d);
            n wo = this.atZ.wo();
            if (wo != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bb.aT(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), wo.getCartoonId(), wo.getChapterId(), 2)));
                return;
            }
            k kVar = this.atZ.ajI;
            if (this.atZ.ajH == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.afj;
                long j = kVar.afk;
                al alVar = new al();
                alVar.pageContext = this.mPageContext;
                alVar.afx = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.atZ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.atZ.wk() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aie() {
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
    public void hf(int i) {
        this.currentPageType = i;
        if (this.bGZ != null) {
            this.bGZ.akz = i;
            if (i == 15) {
                this.bGZ.setFrom(10);
            } else {
                this.bGZ.setFrom(2);
            }
        }
        if (this.bGY != null) {
            if (i == 15) {
                this.bGY.setFrom(5);
            } else {
                this.bGY.setFrom(3);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cwy != null) {
            this.cwy.setVoiceManager(voiceManager);
        }
    }

    private boolean I(bc bcVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dst)) {
            bcVar.P(this.mUrl, this.dst);
        }
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

    private void J(bc bcVar) {
        if (bcVar != null && gp(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dst)) {
                bcVar.P(this.mUrl, this.dst);
            }
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
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.cwy.setLayoutParams(layoutParams);
            if (this.cwy.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cwB.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.cwB.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hh(int i) {
        if (this.atZ != null) {
            if (i == 1) {
                this.bGZ.setVisibility(8);
                if (this.bHN != null) {
                    this.bHN.setData(this.atZ);
                    return;
                }
                return;
            }
            this.bGZ.setData(this.atZ);
            if (this.bHN != null) {
                this.bHN.setVisibility(8);
            }
        }
    }

    public void P(String str, String str2) {
        this.mUrl = str;
        this.dst = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bGM = str;
    }

    public int gp(int i) {
        return com.baidu.tieba.a.d.QB().L(this.bGM, i);
    }
}
