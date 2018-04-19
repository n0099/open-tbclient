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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<bd> implements com.baidu.tieba.a.e, aa {
    protected boolean akC;
    protected bd alf;
    private final View.OnClickListener apj;
    protected View bam;
    private String bvX;
    private HeadPendantClickableView bwV;
    protected ThreadSourceShareAndPraiseLayout bwZ;
    private ThreadUserInfoLayout bwj;
    protected ThreadCommentAndPraiseInfoLayout bwk;
    public LinearLayout bxk;
    private RelativeLayout cHD;
    private ThreadGodReplyLayout cma;
    private View.OnClickListener cme;
    private PlayVoiceBntNew coU;
    protected View coV;
    private TextView coW;
    protected ConstrainImageGroup coX;
    private final View.OnClickListener cpa;
    public TbImageView cqE;
    private TbImageView cqG;
    private com.baidu.tieba.frs.vc.g deI;
    private String deR;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akC = true;
        this.cme = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.aeZ() != null) {
                    e.this.aeZ().a(view2, e.this.alf);
                }
                e.this.en(view2 == e.this.cma);
            }
        };
        this.cpa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<bd> aeZ = e.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("2");
                    aeZ.a(view2, e.this.alf);
                }
            }
        };
        this.apj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.aeZ() != null) {
                    e.this.aeZ().a(view2, e.this.alf);
                }
            }
        };
        View view2 = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bwV = (HeadPendantClickableView) view2.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bwV.getHeadView() != null) {
            this.bwV.getHeadView().setIsRound(true);
            this.bwV.getHeadView().setDrawBorder(false);
            this.bwV.getHeadView().setDefaultResource(17170445);
            this.bwV.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bwV.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bwV.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bwV.setHasPendantStyle();
        if (this.bwV.getPendantView() != null) {
            this.bwV.getPendantView().setIsRound(true);
            this.bwV.getPendantView().setDrawBorder(false);
        }
        this.bwV.setAfterClickListener(this.apj);
        this.bam = view2.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_title);
        this.coU = (PlayVoiceBntNew) view2.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.coU.setAfterClickListener(this.cpa);
        this.coW = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.coW.setVisibility(8);
        this.coV = view2.findViewById(d.g.divider_line_above_praise);
        this.coX = (ConstrainImageGroup) view2.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.coX.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.coX.setChildClickListener(this.cme);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.coX.setImageProcessor(eVar);
        this.bwk = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bwj = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bwj.setUserAfterClickListener(this.apj);
        this.bwj.setFrom(3);
        this.bwk.setOnClickListener(this.cme);
        this.bwk.setReplyTimeVisible(false);
        this.bwk.setShowPraiseNum(true);
        this.bwk.setNeedAddPraiseIcon(true);
        this.bwk.setNeedAddReplyIcon(true);
        this.bwk.setIsBarViewVisible(false);
        this.bwk.setShareVisible(true);
        this.bwk.setShareReportFrom(1);
        this.bwk.setStType("frs_page");
        this.bwk.setFrom(2);
        this.bwk.abV = 3;
        this.bwZ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_home_page_source_read_share_layout);
        if (this.bwZ != null) {
            this.bwZ.apG.setOnClickListener(this.cme);
            this.bwZ.setFrom(2);
            this.bwZ.setShareReportFrom(1);
            this.bwZ.setSourceFromForPb(3);
            this.bwZ.setStType("frs_page");
            this.bwZ.setHideBarName(true);
            this.bwZ.apG.setNeedAddReplyIcon(true);
        }
        this.cHD = (RelativeLayout) view2.findViewById(d.g.card_home_page_normal_thread_root);
        this.deI = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.cHD);
        this.deI.setUniqueId(getTag());
        this.cma = (ThreadGodReplyLayout) view2.findViewById(d.g.card_frs_god_reply_layout);
        this.cma.setOnClickListener(this.cme);
        this.cqE = (TbImageView) view2.findViewById(d.g.frs_normal_item_theme_card);
        this.cqE.setPageId(getTag());
        this.cqG = (TbImageView) view2.findViewById(d.g.frs_normal_item_star_view);
        if (this.cqG != null) {
            this.cqG.setPageId(getTag());
        }
        this.bxk = (LinearLayout) view2.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout afz() {
        return this.bwk;
    }

    public ThreadCommentAndPraiseInfoLayout afA() {
        if (this.bwZ != null) {
            return this.bwZ.apG;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.coX != null) {
            this.coX.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.coX != null) {
            this.coX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.coX != null) {
            this.coX.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.j(this.bam, d.C0126d.cp_bg_line_e);
            this.coX.onChangeSkinType();
            this.bwk.onChangeSkinType();
            this.bwj.onChangeSkinType();
            this.deI.onChangeSkinType();
            if (this.bwZ != null && this.bwZ.getVisibility() == 0) {
                this.bwZ.onChangeSkinType();
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
    /* renamed from: A */
    public void a(final bd bdVar) {
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.alf = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cme);
        }
        this.cma.onChangeSkinType();
        if (!afd() && o.kw(this.alf.getId())) {
            o.a(this.mTitle, this.alf.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.coW, this.alf.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            o.a(this.cma.getGodReplyContent(), this.alf.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        }
        L(bdVar);
        this.deI.X(this.alf);
        I(bdVar);
        this.bwj.setData(this.alf);
        this.cma.setFromCDN(this.akC);
        this.cma.setData(this.alf.tc());
        this.bwj.setUserAfterClickListener(this.apj);
        hb(gm(1));
        if (this.bwj.getHeaderImg() != null) {
            if (this.bwj.getIsSimpleThread()) {
                this.bwj.getHeaderImg().setVisibility(8);
                this.bwV.setVisibility(8);
            } else if (bdVar.rQ() == null || bdVar.rQ().getPendantData() == null || StringUtils.isNull(bdVar.rQ().getPendantData().qG())) {
                this.bwV.setVisibility(8);
                this.bwj.getHeaderImg().setVisibility(0);
                this.bwj.getHeaderImg().setData(bdVar);
            } else {
                this.bwj.getHeaderImg().setVisibility(4);
                this.bwV.setVisibility(0);
                this.bwV.setData(bdVar);
            }
        }
        G(bdVar);
        H(bdVar);
        ArrayList<VoiceData.VoiceModel> se = bdVar.se();
        if (v.w(se)) {
            this.coU.setVisibility(8);
        } else {
            this.coU.btf();
            this.coU.setVisibility(0);
            VoiceData.VoiceModel voiceModel = se.get(0);
            this.coU.setVoiceModel(voiceModel);
            this.coU.setTag(voiceModel);
            this.coU.aIT();
            if (voiceModel != null) {
                this.coU.ob(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> sa = bdVar.sa();
        if (com.baidu.tbadk.core.i.pY().qe() && v.v(sa) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < sa.size(); i++) {
                MediaData mediaData = (MediaData) v.c(sa, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.v(linkedList) > 0) {
                this.coX.setVisibility(0);
                this.coX.setFromCDN(this.akC);
                this.coX.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void c(View view2, int i2, boolean z) {
                        ab<bd> aeZ = e.this.aeZ();
                        if (z) {
                            if (aeZ != null) {
                                view2.setTag("1");
                                aeZ.aXD = true;
                                aeZ.a(view2, e.this.alf);
                            }
                            e.this.en(false);
                            return;
                        }
                        if (aeZ != null) {
                            view2.setTag("1");
                            aeZ.aXD = false;
                            aeZ.a(view2, e.this.alf);
                        }
                        e.this.a(view2, linkedList, i2, bdVar);
                    }
                });
                this.coX.setImageMediaList(linkedList);
            } else {
                this.coX.setVisibility(8);
            }
        } else {
            this.coX.setVisibility(8);
        }
        afq();
        afr();
        asj();
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void afq() {
        if (this.coV != null && this.coX != null && this.cma != null) {
            if (this.coX.getVisibility() == 8 && this.cma.getVisibility() == 8) {
                this.coV.setVisibility(0);
            } else {
                this.coV.setVisibility(8);
            }
        }
    }

    private void I(final bd bdVar) {
        if (this.cqG != null) {
            if (this.cqE == null || bdVar == null) {
                this.cqG.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.abM) && this.cqE.getVisibility() != 0) {
                if (this.deI != null && this.deI.avr() && (this.cqG.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cqG.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cqG.setLayoutParams(layoutParams);
                }
                this.cqG.setVisibility(0);
                this.cqG.setImageDrawable(null);
                this.cqG.startLoad(bdVar.abM, 10, false);
                this.cqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bdVar.abN, true)));
                        }
                        TiebaStatic.log(new al("c12883"));
                    }
                });
            } else {
                this.cqG.setVisibility(8);
            }
        }
    }

    public void L(bd bdVar) {
        MetaData rQ;
        if (bdVar != null && this.cqE != null && (rQ = bdVar.rQ()) != null) {
            final ThemeCardInUserData themeCard = rQ.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cqE.setVisibility(8);
                return;
            }
            this.cqE.setVisibility(0);
            this.cqE.setImageDrawable(null);
            this.cqE.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cqE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2, List<MediaData> list, int i, bd bdVar) {
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
                imageUrlData.urlType = this.akC ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bdVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.w(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rV(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.akC, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
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

    private void afr() {
        this.coU.setClickable(true);
        int childCount = this.coX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.coX.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.akC = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bwk != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bwj != null) {
            this.bwj.setPageUniqueId(bdUniqueId);
        }
        if (this.coX != null) {
            this.coX.setPageUniqueId(bdUniqueId);
        }
    }

    protected void en(boolean z) {
        if (this.alf != null) {
            o.kv(this.alf.getId());
            o.a(this.mTitle, this.alf.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.coW, this.alf.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            o.a(this.cma.getGodReplyContent(), this.alf.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
            n sI = this.alf.sI();
            if (sI != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    az.aJ(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), sI.getCartoonId(), sI.getChapterId(), 2)));
                return;
            }
            k kVar = this.alf.abi;
            if (this.alf.abh == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.WS;
                long j = kVar.WT;
                com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                alVar.pageContext = this.mPageContext;
                alVar.Xg = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.alf, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.alf.getFid()));
            addLocateParam.setForumName(this.alf.rV());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.alf.sE() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean afd() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.coU != null) {
            this.coU.setVoiceManager(voiceManager);
        }
    }

    private boolean G(bd bdVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.deR)) {
            bdVar.M(this.mUrl, this.deR);
        }
        SpannableStringBuilder g = bdVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.j(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bdVar.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        }
        return true;
    }

    private void H(bd bdVar) {
        if (bdVar != null && gm(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.deR)) {
                bdVar.M(this.mUrl, this.deR);
            }
            SpannableString te = bdVar.te();
            if (te != null && !an.isEmpty(te.toString())) {
                this.coW.setVisibility(0);
                this.coW.setOnTouchListener(new com.baidu.tieba.view.j(te));
                this.coW.setText(te);
                o.a(this.coW, bdVar.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                return;
            }
            this.coW.setVisibility(8);
            return;
        }
        this.coW.setVisibility(8);
    }

    private void asj() {
        if (this.mTitle != null && this.coU != null && this.coX != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coU.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.coU.setLayoutParams(layoutParams);
            if (this.coU.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.coX.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.coX.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hb(int i) {
        if (this.alf != null) {
            if (i == 1) {
                this.bwk.setVisibility(8);
                if (this.bwZ != null) {
                    this.bwZ.setData(this.alf);
                    return;
                }
                return;
            }
            this.bwk.setData(this.alf);
            if (this.bwZ != null) {
                this.bwZ.setVisibility(8);
            }
        }
    }

    public void M(String str, String str2) {
        this.mUrl = str;
        this.deR = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bvX = str;
    }

    public int gm(int i) {
        return com.baidu.tieba.a.d.MH().L(this.bvX, i);
    }
}
