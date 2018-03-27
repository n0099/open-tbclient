package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Rect;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.card.a<bd> implements t {
    protected boolean aYZ;
    protected bd aZC;
    protected View bQq;
    private final View.OnClickListener bdT;
    private View.OnClickListener cVA;
    private ThreadGodReplyLayout cVx;
    private PlayVoiceBntNew cWT;
    protected View cWU;
    private TextView cWV;
    protected ConstrainImageGroup cWW;
    private final View.OnClickListener cWZ;
    public TbImageView cYN;
    private TbImageView cYP;
    private ThreadUserInfoLayout clZ;
    private HeadPendantClickableView cmL;
    protected ThreadSourceShareAndPraiseLayout cmO;
    protected ThreadCommentAndPraiseInfoLayout cma;
    public LinearLayout cna;
    private com.baidu.tieba.frs.g.g dLC;
    private RelativeLayout dpn;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aYZ = true;
        this.cVA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.aZC);
                }
                l.this.eI(view == l.this.cVx);
            }
        };
        this.cWZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> akP = l.this.akP();
                if (akP != null) {
                    view.setTag("2");
                    akP.a(view, l.this.aZC);
                }
            }
        };
        this.bdT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.aZC);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cmL = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmL.getHeadView() != null) {
            this.cmL.getHeadView().setIsRound(true);
            this.cmL.getHeadView().setDrawBorder(false);
            this.cmL.getHeadView().setDefaultResource(17170445);
            this.cmL.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmL.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmL.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmL.DT();
        if (this.cmL.getPendantView() != null) {
            this.cmL.getPendantView().setIsRound(true);
            this.cmL.getPendantView().setDrawBorder(false);
        }
        this.cmL.setAfterClickListener(this.bdT);
        this.bQq = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cWT = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cWT.setAfterClickListener(this.cWZ);
        this.cWV = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cWV.setVisibility(8);
        this.cWU = view.findViewById(d.g.divider_line_above_praise);
        this.cWW = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cWW.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cWW.setChildClickListener(this.cVA);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cWW.setImageProcessor(fVar);
        this.cma = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.clZ = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.clZ.setUserAfterClickListener(this.bdT);
        this.clZ.setFrom(3);
        this.cma.setOnClickListener(this.cVA);
        this.cma.setReplyTimeVisible(false);
        this.cma.setShowPraiseNum(true);
        this.cma.setNeedAddPraiseIcon(true);
        this.cma.setNeedAddReplyIcon(true);
        this.cma.setIsBarViewVisible(false);
        this.cma.setShareVisible(true);
        this.cma.setShareReportFrom(1);
        this.cma.setStType("frs_page");
        this.cma.setFrom(2);
        this.cma.aQv = 3;
        this.cmO = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.cmO.bep.setOnClickListener(this.cVA);
        this.cmO.setFrom(2);
        this.cmO.setShareReportFrom(1);
        this.cmO.setSourceFromForPb(3);
        this.cmO.setStType("frs_page");
        this.cmO.setHideBarName(true);
        this.cmO.bep.setNeedAddReplyIcon(true);
        this.dpn = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.dLC = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dpn);
        this.dLC.setUniqueId(getTag());
        this.cVx = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.cVx.setOnClickListener(this.cVA);
        this.cYN = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cYN.setPageId(getTag());
        this.cYP = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.cYP.setPageId(getTag());
        this.cna = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cma;
    }

    public ThreadCommentAndPraiseInfoLayout alv() {
        return this.cmO.bep;
    }

    public void setSingleImageRatio(double d) {
        if (this.cWW != null) {
            this.cWW.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cWW != null) {
            this.cWW.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cWW != null) {
            this.cWW.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bQq, d.C0141d.cp_bg_line_e);
            this.cWW.onChangeSkinType();
            this.cma.onChangeSkinType();
            this.clZ.onChangeSkinType();
            this.dLC.onChangeSkinType();
            if (this.cmO != null && this.cmO.getVisibility() == 0) {
                this.cmO.onChangeSkinType();
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
    /* renamed from: B */
    public void a(final bd bdVar) {
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aZC = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVA);
        }
        this.cVx.onChangeSkinType();
        if (!akT() && com.baidu.tieba.card.j.ks(this.aZC.getId())) {
            com.baidu.tieba.card.j.a(this.mTitle, this.aZC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cWV, this.aZC.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cVx.getGodReplyContent(), this.aZC.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        K(bdVar);
        this.dLC.W(this.aZC);
        H(bdVar);
        this.clZ.setData(this.aZC);
        this.cVx.setFromCDN(this.aYZ);
        this.cVx.setGrayScaleMode(this.aZC.AC());
        this.cVx.setData(this.aZC.AA());
        this.clZ.setUserAfterClickListener(this.bdT);
        jX(bdVar.aQp);
        if (this.clZ.getHeaderImg() != null) {
            if (this.clZ.getIsSimpleThread()) {
                this.clZ.getHeaderImg().setVisibility(8);
                this.cmL.setVisibility(8);
            } else if (bdVar.zn() == null || bdVar.zn().getPendantData() == null || StringUtils.isNull(bdVar.zn().getPendantData().ya())) {
                this.cmL.setVisibility(8);
                this.clZ.getHeaderImg().setVisibility(0);
                this.clZ.getHeaderImg().setData(bdVar);
            } else {
                this.clZ.getHeaderImg().setVisibility(4);
                this.cmL.setVisibility(0);
                this.cmL.setData(bdVar);
            }
        }
        G(bdVar);
        ArrayList<VoiceData.VoiceModel> zC = bdVar.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cWT.setVisibility(8);
        } else {
            this.cWT.byf();
            this.cWT.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zC.get(0);
            this.cWT.setVoiceModel(voiceModel);
            this.cWT.setTag(voiceModel);
            this.cWT.aNR();
            if (voiceModel != null) {
                this.cWT.of(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> zy = bdVar.zy();
        if (com.baidu.tbadk.core.i.xo().xu() && com.baidu.tbadk.core.util.v.D(zy) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < zy.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                this.cWW.setVisibility(0);
                this.cWW.setFromCDN(this.aYZ);
                this.cWW.setGrayScaleMode(bdVar.AC());
                this.cWW.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void f(View view, int i2, boolean z) {
                        v<bd> akP = l.this.akP();
                        if (z) {
                            if (akP != null) {
                                view.setTag("1");
                                akP.bNF = true;
                                akP.a(view, l.this.aZC);
                            }
                            l.this.eI(false);
                            return;
                        }
                        if (akP != null) {
                            view.setTag("1");
                            akP.bNF = false;
                            akP.a(view, l.this.aZC);
                        }
                        l.this.a(view, linkedList, i2, bdVar);
                    }
                });
                this.cWW.setImageMediaList(linkedList);
            } else {
                this.cWW.setVisibility(8);
            }
        } else {
            this.cWW.setVisibility(8);
        }
        alh();
        ali();
        axL();
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void alh() {
        if (this.cWU != null && this.cWW != null && this.cVx != null) {
            if (this.cWW.getVisibility() == 8 && this.cVx.getVisibility() == 8) {
                this.cWU.setVisibility(0);
            } else {
                this.cWU.setVisibility(8);
            }
        }
    }

    private void H(final bd bdVar) {
        if (this.cYP != null) {
            if (this.cYN == null || bdVar == null) {
                this.cYP.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQn) && this.cYN.getVisibility() != 0) {
                if (this.dLC != null && this.dLC.aAv() && (this.cYP.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYP.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYP.setLayoutParams(layoutParams);
                }
                this.cYP.changeGrayScaleMode(bdVar.AC());
                this.cYP.setVisibility(0);
                this.cYP.setImageDrawable(null);
                this.cYP.startLoad(bdVar.aQn, 10, false);
                this.cYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (l.this.mPageContext != null && !StringUtils.isNull(bdVar.aQo)) {
                            l.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(l.this.mTbPageContext.getContext(), "", bdVar.aQo, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYP.setVisibility(8);
            }
        }
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYN != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYN.setVisibility(8);
                return;
            }
            this.cYN.setVisibility(0);
            this.cYN.changeGrayScaleMode(bdVar.AC());
            this.cYN.setImageDrawable(null);
            this.cYN.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(l.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.aYZ ? 13 : 14;
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
        if (!com.baidu.tbadk.core.util.v.E(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aYZ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void ali() {
        this.cWT.setClickable(true);
        int childCount = this.cWW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cWW.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aYZ = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cma != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.clZ != null) {
            this.clZ.setPageUniqueId(bdUniqueId);
        }
        if (this.cWW != null) {
            this.cWW.setPageUniqueId(bdUniqueId);
        }
    }

    protected void eI(boolean z) {
        if (this.aZC != null) {
            com.baidu.tieba.card.j.kr(this.aZC.getId());
            com.baidu.tieba.card.j.a(this.mTitle, this.aZC.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cWV, this.aZC.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cVx.getGodReplyContent(), this.aZC.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            com.baidu.tbadk.core.data.m Ag = this.aZC.Ag();
            if (Ag != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ay.aZ(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aZC.aPJ;
            if (this.aZC.aPI == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aLx;
                long j = jVar.aLy;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.aLL = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZC, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aZC.getFid()));
            addLocateParam.setForumName(this.aZC.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aZC.Ac() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean akT() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cWT != null) {
            this.cWT.setVoiceManager(voiceManager);
        }
    }

    private boolean G(bd bdVar) {
        SpannableStringBuilder j = bdVar.j(false, true);
        if (j == null || StringUtils.isNull(j.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            com.baidu.tieba.card.j.a(this.mTitle, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        return true;
    }

    private void axL() {
        if (this.mTitle != null && this.cWT != null && this.cWW != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cWT.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.cWT.setLayoutParams(layoutParams);
            if (this.cWT.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWW.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.cWW.setLayoutParams(layoutParams2);
            }
        }
    }

    public void jX(int i) {
        if (this.aZC != null) {
            if (i == 1) {
                this.cma.setVisibility(8);
                this.cmO.setData(this.aZC);
                return;
            }
            this.cma.setData(this.aZC);
            this.cmO.setVisibility(8);
        }
    }
}
