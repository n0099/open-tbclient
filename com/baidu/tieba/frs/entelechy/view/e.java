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
    protected View ban;
    private String bwO;
    private HeadPendantClickableView bxM;
    protected ThreadSourceShareAndPraiseLayout bxQ;
    private ThreadUserInfoLayout bxa;
    protected ThreadCommentAndPraiseInfoLayout bxb;
    public LinearLayout byb;
    private RelativeLayout cIJ;
    private ThreadGodReplyLayout cnh;
    private View.OnClickListener cnk;
    private PlayVoiceBntNew cqb;
    protected View cqc;
    private TextView cqd;
    protected ConstrainImageGroup cqe;
    private final View.OnClickListener cqh;
    public TbImageView crL;
    private TbImageView crN;
    private com.baidu.tieba.frs.vc.g dfM;
    private String dfV;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akC = true;
        this.cnk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.aeZ() != null) {
                    e.this.aeZ().a(view2, e.this.alf);
                }
                e.this.eo(view2 == e.this.cnh);
            }
        };
        this.cqh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
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
        this.bxM = (HeadPendantClickableView) view2.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bxM.getHeadView() != null) {
            this.bxM.getHeadView().setIsRound(true);
            this.bxM.getHeadView().setDrawBorder(false);
            this.bxM.getHeadView().setDefaultResource(17170445);
            this.bxM.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bxM.getHeadView().setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.bxM.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bxM.setHasPendantStyle();
        if (this.bxM.getPendantView() != null) {
            this.bxM.getPendantView().setIsRound(true);
            this.bxM.getPendantView().setDrawBorder(false);
        }
        this.bxM.setAfterClickListener(this.apj);
        this.ban = view2.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_title);
        this.cqb = (PlayVoiceBntNew) view2.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cqb.setAfterClickListener(this.cqh);
        this.cqd = (TextView) view2.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cqd.setVisibility(8);
        this.cqc = view2.findViewById(d.g.divider_line_above_praise);
        this.cqe = (ConstrainImageGroup) view2.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cqe.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cqe.setChildClickListener(this.cnk);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.i(1.0d);
        this.cqe.setImageProcessor(eVar);
        this.bxb = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bxa = (ThreadUserInfoLayout) view2.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bxa.setUserAfterClickListener(this.apj);
        this.bxa.setFrom(3);
        this.bxb.setOnClickListener(this.cnk);
        this.bxb.setReplyTimeVisible(false);
        this.bxb.setShowPraiseNum(true);
        this.bxb.setNeedAddPraiseIcon(true);
        this.bxb.setNeedAddReplyIcon(true);
        this.bxb.setIsBarViewVisible(false);
        this.bxb.setShareVisible(true);
        this.bxb.setShareReportFrom(1);
        this.bxb.setStType("frs_page");
        this.bxb.setFrom(2);
        this.bxb.abW = 3;
        this.bxQ = (ThreadSourceShareAndPraiseLayout) view2.findViewById(d.g.card_home_page_source_read_share_layout);
        if (this.bxQ != null) {
            this.bxQ.apG.setOnClickListener(this.cnk);
            this.bxQ.setFrom(2);
            this.bxQ.setShareReportFrom(1);
            this.bxQ.setSourceFromForPb(3);
            this.bxQ.setStType("frs_page");
            this.bxQ.setHideBarName(true);
            this.bxQ.apG.setNeedAddReplyIcon(true);
        }
        this.cIJ = (RelativeLayout) view2.findViewById(d.g.card_home_page_normal_thread_root);
        this.dfM = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.cIJ);
        this.dfM.setUniqueId(getTag());
        this.cnh = (ThreadGodReplyLayout) view2.findViewById(d.g.card_frs_god_reply_layout);
        this.cnh.setOnClickListener(this.cnk);
        this.crL = (TbImageView) view2.findViewById(d.g.frs_normal_item_theme_card);
        this.crL.setPageId(getTag());
        this.crN = (TbImageView) view2.findViewById(d.g.frs_normal_item_star_view);
        if (this.crN != null) {
            this.crN.setPageId(getTag());
        }
        this.byb = (LinearLayout) view2.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout afz() {
        return this.bxb;
    }

    public ThreadCommentAndPraiseInfoLayout afA() {
        if (this.bxQ != null) {
            return this.bxQ.apG;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.cqe != null) {
            this.cqe.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cqe != null) {
            this.cqe.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cqe != null) {
            this.cqe.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.j(this.ban, d.C0126d.cp_bg_line_e);
            this.cqe.onChangeSkinType();
            this.bxb.onChangeSkinType();
            this.bxa.onChangeSkinType();
            this.dfM.onChangeSkinType();
            if (this.bxQ != null && this.bxQ.getVisibility() == 0) {
                this.bxQ.onChangeSkinType();
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
            getView().setOnClickListener(this.cnk);
        }
        this.cnh.onChangeSkinType();
        if (!afd() && o.kz(this.alf.getId())) {
            o.a(this.mTitle, this.alf.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.cqd, this.alf.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            o.a(this.cnh.getGodReplyContent(), this.alf.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
        }
        L(bdVar);
        this.dfM.X(this.alf);
        I(bdVar);
        this.bxa.setData(this.alf);
        this.cnh.setFromCDN(this.akC);
        this.cnh.setData(this.alf.tb());
        this.bxa.setUserAfterClickListener(this.apj);
        hc(gn(1));
        if (this.bxa.getHeaderImg() != null) {
            if (this.bxa.getIsSimpleThread()) {
                this.bxa.getHeaderImg().setVisibility(8);
                this.bxM.setVisibility(8);
            } else if (bdVar.rP() == null || bdVar.rP().getPendantData() == null || StringUtils.isNull(bdVar.rP().getPendantData().qF())) {
                this.bxM.setVisibility(8);
                this.bxa.getHeaderImg().setVisibility(0);
                this.bxa.getHeaderImg().setData(bdVar);
            } else {
                this.bxa.getHeaderImg().setVisibility(4);
                this.bxM.setVisibility(0);
                this.bxM.setData(bdVar);
            }
        }
        G(bdVar);
        H(bdVar);
        ArrayList<VoiceData.VoiceModel> sd = bdVar.sd();
        if (v.w(sd)) {
            this.cqb.setVisibility(8);
        } else {
            this.cqb.btd();
            this.cqb.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sd.get(0);
            this.cqb.setVoiceModel(voiceModel);
            this.cqb.setTag(voiceModel);
            this.cqb.aIS();
            if (voiceModel != null) {
                this.cqb.oa(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> rZ = bdVar.rZ();
        if (com.baidu.tbadk.core.i.pX().qd() && v.v(rZ) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < rZ.size(); i++) {
                MediaData mediaData = (MediaData) v.c(rZ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.v(linkedList) > 0) {
                this.cqe.setVisibility(0);
                this.cqe.setFromCDN(this.akC);
                this.cqe.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void c(View view2, int i2, boolean z) {
                        ab<bd> aeZ = e.this.aeZ();
                        if (z) {
                            if (aeZ != null) {
                                view2.setTag("1");
                                aeZ.aXE = true;
                                aeZ.a(view2, e.this.alf);
                            }
                            e.this.eo(false);
                            return;
                        }
                        if (aeZ != null) {
                            view2.setTag("1");
                            aeZ.aXE = false;
                            aeZ.a(view2, e.this.alf);
                        }
                        e.this.a(view2, linkedList, i2, bdVar);
                    }
                });
                this.cqe.setImageMediaList(linkedList);
            } else {
                this.cqe.setVisibility(8);
            }
        } else {
            this.cqe.setVisibility(8);
        }
        afq();
        afr();
        asi();
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void afq() {
        if (this.cqc != null && this.cqe != null && this.cnh != null) {
            if (this.cqe.getVisibility() == 8 && this.cnh.getVisibility() == 8) {
                this.cqc.setVisibility(0);
            } else {
                this.cqc.setVisibility(8);
            }
        }
    }

    private void I(final bd bdVar) {
        if (this.crN != null) {
            if (this.crL == null || bdVar == null) {
                this.crN.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.abN) && this.crL.getVisibility() != 0) {
                if (this.dfM != null && this.dfM.avq() && (this.crN.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.crN.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.crN.setLayoutParams(layoutParams);
                }
                this.crN.setVisibility(0);
                this.crN.setImageDrawable(null);
                this.crN.startLoad(bdVar.abN, 10, false);
                this.crN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bdVar.abO, true)));
                        }
                        TiebaStatic.log(new al("c12883"));
                    }
                });
            } else {
                this.crN.setVisibility(8);
            }
        }
    }

    public void L(bd bdVar) {
        MetaData rP;
        if (bdVar != null && this.crL != null && (rP = bdVar.rP()) != null) {
            final ThemeCardInUserData themeCard = rP.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.crL.setVisibility(8);
                return;
            }
            this.crL.setVisibility(0);
            this.crL.setImageDrawable(null);
            this.crL.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.crL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rU(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.akC, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        this.cqb.setClickable(true);
        int childCount = this.cqe.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cqe.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.akC = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bxb != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bxa != null) {
            this.bxa.setPageUniqueId(bdUniqueId);
        }
        if (this.cqe != null) {
            this.cqe.setPageUniqueId(bdUniqueId);
        }
    }

    protected void eo(boolean z) {
        if (this.alf != null) {
            o.ky(this.alf.getId());
            o.a(this.mTitle, this.alf.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
            o.a(this.cqd, this.alf.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
            o.a(this.cnh.getGodReplyContent(), this.alf.getId(), d.C0126d.cp_cont_f, d.C0126d.cp_cont_d);
            n sH = this.alf.sH();
            if (sH != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    az.aJ(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), sH.getCartoonId(), sH.getChapterId(), 2)));
                return;
            }
            k kVar = this.alf.abj;
            if (this.alf.abi == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.WT;
                long j = kVar.WU;
                com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                alVar.pageContext = this.mPageContext;
                alVar.Xh = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.alf, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.alf.getFid()));
            addLocateParam.setForumName(this.alf.rU());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.alf.sD() && addLocateParam.getIntent() != null) {
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
        if (this.cqb != null) {
            this.cqb.setVoiceManager(voiceManager);
        }
    }

    private boolean G(bd bdVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dfV)) {
            bdVar.M(this.mUrl, this.dfV);
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
        if (bdVar != null && gn(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dfV)) {
                bdVar.M(this.mUrl, this.dfV);
            }
            SpannableString td = bdVar.td();
            if (td != null && !an.isEmpty(td.toString())) {
                this.cqd.setVisibility(0);
                this.cqd.setOnTouchListener(new com.baidu.tieba.view.j(td));
                this.cqd.setText(td);
                o.a(this.cqd, bdVar.getId(), d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
                return;
            }
            this.cqd.setVisibility(8);
            return;
        }
        this.cqd.setVisibility(8);
    }

    private void asi() {
        if (this.mTitle != null && this.cqb != null && this.cqe != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqb.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.cqb.setLayoutParams(layoutParams);
            if (this.cqb.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cqe.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.cqe.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hc(int i) {
        if (this.alf != null) {
            if (i == 1) {
                this.bxb.setVisibility(8);
                if (this.bxQ != null) {
                    this.bxQ.setData(this.alf);
                    return;
                }
                return;
            }
            this.bxb.setData(this.alf);
            if (this.bxQ != null) {
                this.bxQ.setVisibility(8);
            }
        }
    }

    public void M(String str, String str2) {
        this.mUrl = str;
        this.dfV = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bwO = str;
    }

    public int gn(int i) {
        return com.baidu.tieba.a.d.MF().L(this.bwO, i);
    }
}
