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
    protected bd aZM;
    protected boolean aZj;
    protected View bQA;
    private final View.OnClickListener bec;
    private ThreadGodReplyLayout cVG;
    private View.OnClickListener cVJ;
    private PlayVoiceBntNew cXc;
    protected View cXd;
    private TextView cXe;
    protected ConstrainImageGroup cXf;
    private final View.OnClickListener cXi;
    public TbImageView cYW;
    private TbImageView cYY;
    private HeadPendantClickableView cmU;
    protected ThreadSourceShareAndPraiseLayout cmX;
    private ThreadUserInfoLayout cmj;
    protected ThreadCommentAndPraiseInfoLayout cmk;
    public LinearLayout cnj;
    private com.baidu.tieba.frs.g.g dLJ;
    private RelativeLayout dpw;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aZj = true;
        this.cVJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.aZM);
                }
                l.this.eI(view == l.this.cVG);
            }
        };
        this.cXi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> akP = l.this.akP();
                if (akP != null) {
                    view.setTag("2");
                    akP.a(view, l.this.aZM);
                }
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akP() != null) {
                    l.this.akP().a(view, l.this.aZM);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cmU = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmU.DT();
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.cmU.setAfterClickListener(this.bec);
        this.bQA = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cXc = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cXc.setAfterClickListener(this.cXi);
        this.cXe = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cXe.setVisibility(8);
        this.cXd = view.findViewById(d.g.divider_line_above_praise);
        this.cXf = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cXf.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cXf.setChildClickListener(this.cVJ);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cXf.setImageProcessor(fVar);
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.cmj = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.cmj.setUserAfterClickListener(this.bec);
        this.cmj.setFrom(3);
        this.cmk.setOnClickListener(this.cVJ);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setIsBarViewVisible(false);
        this.cmk.setShareVisible(true);
        this.cmk.setShareReportFrom(1);
        this.cmk.setStType("frs_page");
        this.cmk.setFrom(2);
        this.cmk.aQE = 3;
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.cmX.bez.setOnClickListener(this.cVJ);
        this.cmX.setFrom(2);
        this.cmX.setShareReportFrom(1);
        this.cmX.setSourceFromForPb(3);
        this.cmX.setStType("frs_page");
        this.cmX.setHideBarName(true);
        this.cmX.bez.setNeedAddReplyIcon(true);
        this.dpw = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.dLJ = new com.baidu.tieba.frs.g.g(this.mPageContext, this.dpw);
        this.dLJ.setUniqueId(getTag());
        this.cVG = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.cVG.setOnClickListener(this.cVJ);
        this.cYW = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cYW.setPageId(getTag());
        this.cYY = (TbImageView) view.findViewById(d.g.frs_normal_item_star_view);
        this.cYY.setPageId(getTag());
        this.cnj = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout alu() {
        return this.cmk;
    }

    public ThreadCommentAndPraiseInfoLayout alv() {
        return this.cmX.bez;
    }

    public void setSingleImageRatio(double d) {
        if (this.cXf != null) {
            this.cXf.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cXf != null) {
            this.cXf.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cXf != null) {
            this.cXf.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bQA, d.C0140d.cp_bg_line_e);
            this.cXf.onChangeSkinType();
            this.cmk.onChangeSkinType();
            this.cmj.onChangeSkinType();
            this.dLJ.onChangeSkinType();
            if (this.cmX != null && this.cmX.getVisibility() == 0) {
                this.cmX.onChangeSkinType();
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
        this.aZM = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVJ);
        }
        this.cVG.onChangeSkinType();
        if (!akT() && com.baidu.tieba.card.j.ks(this.aZM.getId())) {
            com.baidu.tieba.card.j.a(this.mTitle, this.aZM.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cXe, this.aZM.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cVG.getGodReplyContent(), this.aZM.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
        }
        K(bdVar);
        this.dLJ.W(this.aZM);
        H(bdVar);
        this.cmj.setData(this.aZM);
        this.cVG.setFromCDN(this.aZj);
        this.cVG.setData(this.aZM.AA());
        this.cmj.setUserAfterClickListener(this.bec);
        jX(bdVar.aQz);
        if (this.cmj.getHeaderImg() != null) {
            if (this.cmj.getIsSimpleThread()) {
                this.cmj.getHeaderImg().setVisibility(8);
                this.cmU.setVisibility(8);
            } else if (bdVar.zn() == null || bdVar.zn().getPendantData() == null || StringUtils.isNull(bdVar.zn().getPendantData().ya())) {
                this.cmU.setVisibility(8);
                this.cmj.getHeaderImg().setVisibility(0);
                this.cmj.getHeaderImg().setData(bdVar);
            } else {
                this.cmj.getHeaderImg().setVisibility(4);
                this.cmU.setVisibility(0);
                this.cmU.setData(bdVar);
            }
        }
        G(bdVar);
        ArrayList<VoiceData.VoiceModel> zC = bdVar.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cXc.setVisibility(8);
        } else {
            this.cXc.byb();
            this.cXc.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zC.get(0);
            this.cXc.setVoiceModel(voiceModel);
            this.cXc.setTag(voiceModel);
            this.cXc.aNR();
            if (voiceModel != null) {
                this.cXc.qG(voiceModel.voice_status.intValue());
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
                this.cXf.setVisibility(0);
                this.cXf.setFromCDN(this.aZj);
                this.cXf.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void f(View view, int i2, boolean z) {
                        v<bd> akP = l.this.akP();
                        if (z) {
                            if (akP != null) {
                                view.setTag("1");
                                akP.bNP = true;
                                akP.a(view, l.this.aZM);
                            }
                            l.this.eI(false);
                            return;
                        }
                        if (akP != null) {
                            view.setTag("1");
                            akP.bNP = false;
                            akP.a(view, l.this.aZM);
                        }
                        l.this.a(view, linkedList, i2, bdVar);
                    }
                });
                this.cXf.setImageMediaList(linkedList);
            } else {
                this.cXf.setVisibility(8);
            }
        } else {
            this.cXf.setVisibility(8);
        }
        alh();
        ali();
        axK();
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void alh() {
        if (this.cXd != null && this.cXf != null && this.cVG != null) {
            if (this.cXf.getVisibility() == 8 && this.cVG.getVisibility() == 8) {
                this.cXd.setVisibility(0);
            } else {
                this.cXd.setVisibility(8);
            }
        }
    }

    private void H(final bd bdVar) {
        if (this.cYY != null) {
            if (this.cYW == null || bdVar == null) {
                this.cYY.setVisibility(8);
            } else if (!StringUtils.isNull(bdVar.aQx) && this.cYW.getVisibility() != 0) {
                if (this.dLJ != null && this.dLJ.aAu() && (this.cYY.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cYY.getLayoutParams();
                    layoutParams.rightMargin = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.tbds106);
                    this.cYY.setLayoutParams(layoutParams);
                }
                this.cYY.setVisibility(0);
                this.cYY.setImageDrawable(null);
                this.cYY.startLoad(bdVar.aQx, 10, false);
                this.cYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (l.this.mPageContext != null) {
                            l.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(l.this.mTbPageContext.getContext(), "", bdVar.aQy, true)));
                        }
                        TiebaStatic.log(new ak("c12883"));
                    }
                });
            } else {
                this.cYY.setVisibility(8);
            }
        }
    }

    public void K(bd bdVar) {
        MetaData zn;
        if (bdVar != null && this.cYW != null && (zn = bdVar.zn()) != null) {
            final ThemeCardInUserData themeCard = zn.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cYW.setVisibility(8);
                return;
            }
            this.cYW.setVisibility(0);
            this.cYW.setImageDrawable(null);
            this.cYW.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
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
                imageUrlData.urlType = this.aZj ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aZj, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        this.cXc.setClickable(true);
        int childCount = this.cXf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cXf.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aZj = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.cmk != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cmj != null) {
            this.cmj.setPageUniqueId(bdUniqueId);
        }
        if (this.cXf != null) {
            this.cXf.setPageUniqueId(bdUniqueId);
        }
    }

    protected void eI(boolean z) {
        if (this.aZM != null) {
            com.baidu.tieba.card.j.kr(this.aZM.getId());
            com.baidu.tieba.card.j.a(this.mTitle, this.aZM.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cXe, this.aZM.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
            com.baidu.tieba.card.j.a(this.cVG.getGodReplyContent(), this.aZM.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
            com.baidu.tbadk.core.data.m Ag = this.aZM.Ag();
            if (Ag != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ay.aZ(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aZM.aPT;
            if (this.aZM.aPS == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aLH;
                long j = jVar.aLI;
                com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                akVar.pageContext = this.mPageContext;
                akVar.aLV = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aZM, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aZM.getFid()));
            addLocateParam.setForumName(this.aZM.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aZM.Ac() && addLocateParam.getIntent() != null) {
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
        if (this.cXc != null) {
            this.cXc.setVoiceManager(voiceManager);
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
            com.baidu.tieba.card.j.a(this.mTitle, bdVar.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        }
        return true;
    }

    private void axK() {
        if (this.mTitle != null && this.cXc != null && this.cXf != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cXc.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.cXc.setLayoutParams(layoutParams);
            if (this.cXc.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cXf.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.cXf.setLayoutParams(layoutParams2);
            }
        }
    }

    public void jX(int i) {
        if (this.aZM != null) {
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setData(this.aZM);
                return;
            }
            this.cmk.setData(this.aZM);
            this.cmX.setVisibility(8);
        }
    }
}
