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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
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
    protected boolean asK;
    protected bd atn;
    private final View.OnClickListener axr;
    private String bER;
    private HeadPendantClickableView bFP;
    protected ThreadSourceShareAndPraiseLayout bFT;
    private ThreadUserInfoLayout bFd;
    protected ThreadCommentAndPraiseInfoLayout bFe;
    public LinearLayout bGe;
    protected View biz;
    public TbImageView cAo;
    private TbImageView cAq;
    private RelativeLayout cRQ;
    private ThreadGodReplyLayout cvM;
    private View.OnClickListener cvP;
    private PlayVoiceBntNew cyE;
    protected View cyF;
    private TextView cyG;
    protected ConstrainImageGroup cyH;
    private final View.OnClickListener cyK;
    private com.baidu.tieba.frs.vc.g dpb;
    private String dpk;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.asK = true;
        this.cvP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aiI() != null) {
                    e.this.aiI().a(view, e.this.atn);
                }
                e.this.es(view == e.this.cvM);
            }
        };
        this.cyK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bd> aiI = e.this.aiI();
                if (aiI != null) {
                    view.setTag("2");
                    aiI.a(view, e.this.atn);
                }
            }
        };
        this.axr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.aiI() != null) {
                    e.this.aiI().a(view, e.this.atn);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bFP = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bFP.getHeadView() != null) {
            this.bFP.getHeadView().setIsRound(true);
            this.bFP.getHeadView().setDrawBorder(false);
            this.bFP.getHeadView().setDefaultResource(17170445);
            this.bFP.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bFP.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bFP.getHeadView().setRadius(l.e(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bFP.setHasPendantStyle();
        if (this.bFP.getPendantView() != null) {
            this.bFP.getPendantView().setIsRound(true);
            this.bFP.getPendantView().setDrawBorder(false);
        }
        this.bFP.setAfterClickListener(this.axr);
        this.biz = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cyE = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cyE.setAfterClickListener(this.cyK);
        this.cyG = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cyG.setVisibility(8);
        this.cyF = view.findViewById(d.g.divider_line_above_praise);
        this.cyH = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cyH.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cyH.setChildClickListener(this.cvP);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.j(1.0d);
        this.cyH.setImageProcessor(eVar);
        this.bFe = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bFd = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bFd.setUserAfterClickListener(this.axr);
        this.bFd.setFrom(3);
        this.bFe.setOnClickListener(this.cvP);
        this.bFe.setReplyTimeVisible(false);
        this.bFe.setShowPraiseNum(true);
        this.bFe.setNeedAddPraiseIcon(true);
        this.bFe.setNeedAddReplyIcon(true);
        this.bFe.setIsBarViewVisible(false);
        this.bFe.setShareVisible(true);
        this.bFe.setShareReportFrom(1);
        this.bFe.setStType("frs_page");
        this.bFe.setFrom(2);
        this.bFe.aka = 3;
        this.bFT = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        if (this.bFT != null) {
            this.bFT.axN.setOnClickListener(this.cvP);
            this.bFT.setFrom(2);
            this.bFT.setShareReportFrom(1);
            this.bFT.setSourceFromForPb(3);
            this.bFT.setStType("frs_page");
            this.bFT.setHideBarName(true);
            this.bFT.axN.setNeedAddReplyIcon(true);
        }
        this.cRQ = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.dpb = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.cRQ);
        this.dpb.setUniqueId(getTag());
        this.cvM = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.cvM.setOnClickListener(this.cvP);
        this.cAo = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cAo.setPageId(getTag());
        this.cAq = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        if (this.cAq != null) {
            this.cAq.setPageId(getTag());
        }
        this.bGe = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout UW() {
        return this.bFe;
    }

    public ThreadCommentAndPraiseInfoLayout UX() {
        if (this.bFT != null) {
            return this.bFT.axN;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.cyH != null) {
            this.cyH.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cyH != null) {
            this.cyH.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cyH != null) {
            this.cyH.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.addresslist_item_bg);
            al.j(this.biz, d.C0141d.cp_bg_line_e);
            this.cyH.onChangeSkinType();
            this.bFe.onChangeSkinType();
            this.bFd.onChangeSkinType();
            this.dpb.onChangeSkinType();
            if (this.bFT != null && this.bFT.getVisibility() == 0) {
                this.bFT.onChangeSkinType();
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
        this.atn = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cvP);
        }
        this.cvM.onChangeSkinType();
        if (!aiM() && o.lc(this.atn.getId())) {
            o.a(this.mTitle, this.atn.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            o.a(this.cyG, this.atn.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
            o.a(this.cvM.getGodReplyContent(), this.atn.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        L(bdVar);
        this.dpb.X(this.atn);
        I(bdVar);
        this.bFd.setData(this.atn);
        this.cvM.setFromCDN(this.asK);
        this.cvM.setData(this.atn.wy());
        this.bFd.setUserAfterClickListener(this.axr);
        hd(go(1));
        if (this.bFd.getHeaderImg() != null) {
            if (this.bFd.getIsSimpleThread()) {
                this.bFd.getHeaderImg().setVisibility(8);
                this.bFP.setVisibility(8);
            } else if (bdVar.vm() == null || bdVar.vm().getPendantData() == null || StringUtils.isNull(bdVar.vm().getPendantData().ub())) {
                this.bFP.setVisibility(8);
                this.bFd.getHeaderImg().setVisibility(0);
                this.bFd.getHeaderImg().setData(bdVar);
            } else {
                this.bFd.getHeaderImg().setVisibility(4);
                this.bFP.setVisibility(0);
                this.bFP.setData(bdVar);
            }
        }
        G(bdVar);
        H(bdVar);
        ArrayList<VoiceData.VoiceModel> vA = bdVar.vA();
        if (w.z(vA)) {
            this.cyE.setVisibility(8);
        } else {
            this.cyE.byi();
            this.cyE.setVisibility(0);
            VoiceData.VoiceModel voiceModel = vA.get(0);
            this.cyE.setVoiceModel(voiceModel);
            this.cyE.setTag(voiceModel);
            this.cyE.aNN();
            if (voiceModel != null) {
                this.cyE.om(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> vw = bdVar.vw();
        if (com.baidu.tbadk.core.i.tt().tz() && w.y(vw) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < vw.size(); i++) {
                MediaData mediaData = (MediaData) w.c(vw, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (w.y(linkedList) > 0) {
                this.cyH.setVisibility(0);
                this.cyH.setFromCDN(this.asK);
                this.cyH.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void c(View view, int i2, boolean z) {
                        ab<bd> aiI = e.this.aiI();
                        if (z) {
                            if (aiI != null) {
                                view.setTag("1");
                                aiI.bfL = true;
                                aiI.a(view, e.this.atn);
                            }
                            e.this.es(false);
                            return;
                        }
                        if (aiI != null) {
                            view.setTag("1");
                            aiI.bfL = false;
                            aiI.a(view, e.this.atn);
                        }
                        e.this.a(view, linkedList, i2, bdVar);
                    }
                });
                this.cyH.setImageMediaList(linkedList);
            } else {
                this.cyH.setVisibility(8);
            }
        } else {
            this.cyH.setVisibility(8);
        }
        aiZ();
        aja();
        awn();
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aiZ() {
        if (this.cyF != null && this.cyH != null && this.cvM != null) {
            if (this.cyH.getVisibility() == 8 && this.cvM.getVisibility() == 8) {
                this.cyF.setVisibility(0);
            } else {
                this.cyF.setVisibility(8);
            }
        }
    }

    private void I(final bd bdVar) {
        if (this.cAq != null) {
            if (this.cAo == null || bdVar == null) {
                this.cAq.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.ajQ) && this.cAo.getVisibility() != 0) {
                if (this.dpb != null && this.dpb.azz() && (this.cAq.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cAq.getLayoutParams();
                    layoutParams.rightMargin = l.e(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cAq.setLayoutParams(layoutParams);
                }
                this.cAq.setVisibility(0);
                this.cAq.setImageDrawable(null);
                this.cAq.startLoad(bdVar.ajQ, 10, false);
                this.cAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bdVar.ajR, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cAq.setVisibility(8);
            }
        }
    }

    public void L(bd bdVar) {
        MetaData vm;
        if (bdVar != null && this.cAo != null && (vm = bdVar.vm()) != null) {
            final ThemeCardInUserData themeCard = vm.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cAo.setVisibility(8);
                return;
            }
            this.cAo.setVisibility(0);
            this.cAo.setImageDrawable(null);
            this.cAo.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cAo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
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
                imageUrlData.urlType = this.asK ? 13 : 14;
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
        if (!w.z(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.vr(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.asK, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void aja() {
        this.cyE.setClickable(true);
        int childCount = this.cyH.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cyH.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.asK = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bFe != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bFd != null) {
            this.bFd.setPageUniqueId(bdUniqueId);
        }
        if (this.cyH != null) {
            this.cyH.setPageUniqueId(bdUniqueId);
        }
    }

    protected void es(boolean z) {
        if (this.atn != null) {
            o.lb(this.atn.getId());
            o.a(this.mTitle, this.atn.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            o.a(this.cyG, this.atn.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
            o.a(this.cvM.getGodReplyContent(), this.atn.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            n we = this.atn.we();
            if (we != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.aT(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), we.getCartoonId(), we.getChapterId(), 2)));
                return;
            }
            k kVar = this.atn.ajn;
            if (this.atn.ajm == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.aeU;
                long j = kVar.aeV;
                com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                alVar.pageContext = this.mPageContext;
                alVar.afi = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, alVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.atn, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.atn.getFid()));
            addLocateParam.setForumName(this.atn.vr());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.atn.wa() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean aiM() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cyE != null) {
            this.cyE.setVoiceManager(voiceManager);
        }
    }

    private boolean G(bd bdVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dpk)) {
            bdVar.P(this.mUrl, this.dpk);
        }
        SpannableStringBuilder g = bdVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            o.a(this.mTitle, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        return true;
    }

    private void H(bd bdVar) {
        if (bdVar != null && go(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dpk)) {
                bdVar.P(this.mUrl, this.dpk);
            }
            SpannableString wA = bdVar.wA();
            if (wA != null && !ao.isEmpty(wA.toString())) {
                this.cyG.setVisibility(0);
                this.cyG.setOnTouchListener(new com.baidu.tieba.view.k(wA));
                this.cyG.setText(wA);
                o.a(this.cyG, bdVar.getId(), d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
                return;
            }
            this.cyG.setVisibility(8);
            return;
        }
        this.cyG.setVisibility(8);
    }

    private void awn() {
        if (this.mTitle != null && this.cyE != null && this.cyH != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cyE.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.cyE.setLayoutParams(layoutParams);
            if (this.cyE.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cyH.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.cyH.setLayoutParams(layoutParams2);
            }
        }
    }

    public void hd(int i) {
        if (this.atn != null) {
            if (i == 1) {
                this.bFe.setVisibility(8);
                if (this.bFT != null) {
                    this.bFT.setData(this.atn);
                    return;
                }
                return;
            }
            this.bFe.setData(this.atn);
            if (this.bFT != null) {
                this.bFT.setVisibility(8);
            }
        }
    }

    public void P(String str, String str2) {
        this.mUrl = str;
        this.dpk = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bER = str;
    }

    public int go(int i) {
        return com.baidu.tieba.a.d.Qe().L(this.bER, i);
    }
}
