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
    protected boolean aYX;
    protected bd aZA;
    protected View bQn;
    private final View.OnClickListener bdQ;
    private ThreadGodReplyLayout cVu;
    private View.OnClickListener cVx;
    private PlayVoiceBntNew cWQ;
    protected View cWR;
    private TextView cWS;
    protected ConstrainImageGroup cWT;
    private final View.OnClickListener cWW;
    public TbImageView cYK;
    private TbImageView cYM;
    private ThreadUserInfoLayout clW;
    protected ThreadCommentAndPraiseInfoLayout clX;
    private HeadPendantClickableView cmI;
    protected ThreadSourceShareAndPraiseLayout cmL;
    public LinearLayout cmX;
    private com.baidu.tieba.frs.g.g dLx;
    private RelativeLayout dpk;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aYX = true;
        this.cVx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akO() != null) {
                    l.this.akO().a(view, l.this.aZA);
                }
                l.this.eI(view == l.this.cVu);
            }
        };
        this.cWW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> akO = l.this.akO();
                if (akO != null) {
                    view.setTag("2");
                    akO.a(view, l.this.aZA);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akO() != null) {
                    l.this.akO().a(view, l.this.aZA);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cmI = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmI.getHeadView() != null) {
            this.cmI.getHeadView().setIsRound(true);
            this.cmI.getHeadView().setDrawBorder(false);
            this.cmI.getHeadView().setDefaultResource(17170445);
            this.cmI.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmI.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmI.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmI.DS();
        if (this.cmI.getPendantView() != null) {
            this.cmI.getPendantView().setIsRound(true);
            this.cmI.getPendantView().setDrawBorder(false);
        }
        this.cmI.setAfterClickListener(this.bdQ);
        this.bQn = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cWQ = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cWQ.setAfterClickListener(this.cWW);
        this.cWS = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cWS.setVisibility(8);
        this.cWR = view.findViewById(d.g.divider_line_above_praise);
        this.cWT = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cWT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cWT.setChildClickListener(this.cVx);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cWT.setImageProcessor(fVar);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.clW = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.clW.setUserAfterClickListener(this.bdQ);
        this.clW.setFrom(3);
        this.clX.setOnClickListener(this.cVx);
        this.clX.setReplyTimeVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setIsBarViewVisible(false);
        this.clX.setShareVisible(true);
        this.clX.setShareReportFrom(1);
        this.clX.setStType("frs_page");
        this.clX.setFrom(2);
        this.clX.aQt = 3;
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.cmL.bem.setOnClickListener(this.cVx);
        this.cmL.setFrom(2);
        this.cmL.setShareReportFrom(1);
        this.cmL.setSourceFromForPb(3);
        this.cmL.setStType("frs_page");
        this.cmL.setHideBarName(true);
        this.cmL.bem.setNeedAddReplyIcon(true);
        this.dpk = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.dLx = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dpk);
        this.dLx.setUniqueId(getTag());
        this.cVu = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.cVu.setOnClickListener(this.cVx);
        this.cYK = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cYK.setPageId(getTag());
        this.cYM = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.cYM.setPageId(getTag());
        this.cmX = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout alt() {
        return this.clX;
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cmL.bem;
    }

    public void setSingleImageRatio(double d) {
        if (this.cWT != null) {
            this.cWT.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cWT != null) {
            this.cWT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cWT != null) {
            this.cWT.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bQn, d.C0141d.cp_bg_line_e);
            this.cWT.onChangeSkinType();
            this.clX.onChangeSkinType();
            this.clW.onChangeSkinType();
            this.dLx.onChangeSkinType();
            if (this.cmL != null && this.cmL.getVisibility() == 0) {
                this.cmL.onChangeSkinType();
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
        this.aZA = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVx);
        }
        this.cVu.onChangeSkinType();
        if (!akS() && com.baidu.tieba.card.j.ks(this.aZA.getId())) {
            com.baidu.tieba.card.j.a(this.mTitle, this.aZA.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cWS, this.aZA.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cVu.getGodReplyContent(), this.aZA.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        K(bdVar);
        this.dLx.W(this.aZA);
        H(bdVar);
        this.clW.setData(this.aZA);
        this.cVu.setFromCDN(this.aYX);
        this.cVu.setData(this.aZA.AA());
        this.clW.setUserAfterClickListener(this.bdQ);
        jX(bdVar.aQo);
        if (this.clW.getHeaderImg() != null) {
            if (this.clW.getIsSimpleThread()) {
                this.clW.getHeaderImg().setVisibility(8);
                this.cmI.setVisibility(8);
            } else if (bdVar.zn() == null || bdVar.zn().getPendantData() == null || StringUtils.isNull(bdVar.zn().getPendantData().ya())) {
                this.cmI.setVisibility(8);
                this.clW.getHeaderImg().setVisibility(0);
                this.clW.getHeaderImg().setData(bdVar);
            } else {
                this.clW.getHeaderImg().setVisibility(4);
                this.cmI.setVisibility(0);
                this.cmI.setData(bdVar);
            }
        }
        G(bdVar);
        ArrayList<VoiceData.VoiceModel> zC = bdVar.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cWQ.setVisibility(8);
        } else {
            this.cWQ.bya();
            this.cWQ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zC.get(0);
            this.cWQ.setVoiceModel(voiceModel);
            this.cWQ.setTag(voiceModel);
            this.cWQ.aNQ();
            if (voiceModel != null) {
                this.cWQ.qG(voiceModel.voice_status.intValue());
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
                this.cWT.setVisibility(0);
                this.cWT.setFromCDN(this.aYX);
                this.cWT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void f(View view, int i2, boolean z) {
                        v<bd> akO = l.this.akO();
                        if (z) {
                            if (akO != null) {
                                view.setTag("1");
                                akO.bNC = true;
                                akO.a(view, l.this.aZA);
                            }
                            l.this.eI(false);
                            return;
                        }
                        if (akO != null) {
                            view.setTag("1");
                            akO.bNC = false;
                            akO.a(view, l.this.aZA);
                        }
                        l.this.a(view, linkedList, i2, bdVar);
                    }
                });
                this.cWT.setImageMediaList(linkedList);
            } else {
                this.cWT.setVisibility(8);
            }
        } else {
            this.cWT.setVisibility(8);
        }
        alg();
        alh();
        axJ();
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void alg() {
        if (this.cWR != null && this.cWT != null && this.cVu != null) {
            if (this.cWT.getVisibility() == 8 && this.cVu.getVisibility() == 8) {
                this.cWR.setVisibility(0);
            } else {
                this.cWR.setVisibility(8);
            }
        }
    }

    private void H(final bd bdVar) {
        if (this.cYM != null) {
            if (this.cYK == null || bdVar == null) {
                this.cYM.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQm) && this.cYK.getVisibility() != 0) {
                if (this.dLx != null && this.dLx.aAt() && (this.cYM.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYM.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYM.setLayoutParams(layoutParams);
                }
                this.cYM.setVisibility(0);
                this.cYM.setImageDrawable(null);
                this.cYM.startLoad(bdVar.aQm, 10, false);
                this.cYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (l.this.mPageContext != null) {
                            l.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(l.this.mTbPageContext.getContext(), "", bdVar.aQn, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYM.setVisibility(8);
            }
        }
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYK != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYK.setVisibility(8);
                return;
            }
            this.cYK.setVisibility(0);
            this.cYK.setImageDrawable(null);
            this.cYK.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cYK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
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
                imageUrlData.urlType = this.aYX ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aYX, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void alh() {
        this.cWQ.setClickable(true);
        int childCount = this.cWT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cWT.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aYX = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.clX != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.clW != null) {
            this.clW.setPageUniqueId(bdUniqueId);
        }
        if (this.cWT != null) {
            this.cWT.setPageUniqueId(bdUniqueId);
        }
    }

    protected void eI(boolean z) {
        if (this.aZA != null) {
            com.baidu.tieba.card.j.kr(this.aZA.getId());
            com.baidu.tieba.card.j.a(this.mTitle, this.aZA.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cWS, this.aZA.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cVu.getGodReplyContent(), this.aZA.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            com.baidu.tbadk.core.data.m Ag = this.aZA.Ag();
            if (Ag != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ay.aZ(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aZA.aPI;
            if (this.aZA.aPH == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aLw;
                long j = jVar.aLx;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.aLK = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZA, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aZA.getFid()));
            addLocateParam.setForumName(this.aZA.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aZA.Ac() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean akS() {
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
        if (this.cWQ != null) {
            this.cWQ.setVoiceManager(voiceManager);
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

    private void axJ() {
        if (this.mTitle != null && this.cWQ != null && this.cWT != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cWQ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.cWQ.setLayoutParams(layoutParams);
            if (this.cWQ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cWT.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.cWT.setLayoutParams(layoutParams2);
            }
        }
    }

    public void jX(int i) {
        if (this.aZA != null) {
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setData(this.aZA);
                return;
            }
            this.clX.setData(this.aZA);
            this.cmL.setVisibility(8);
        }
    }
}
