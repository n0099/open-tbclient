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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.card.a<be> implements u {
    protected be aXV;
    protected boolean aXt;
    protected View bOc;
    private final View.OnClickListener bce;
    private HeadPendantClickableView cNO;
    private ThreadGodReplyLayout cNP;
    private View.OnClickListener cNS;
    private final View.OnClickListener cPC;
    private PlayVoiceBntNew cPw;
    protected View cPx;
    private TextView cPy;
    protected ConstrainImageGroup cPz;
    public TbImageView cRo;
    private ThreadUserInfoLayout ciD;
    protected ThreadCommentAndPraiseInfoLayout ciE;
    public LinearLayout cjA;
    private com.baidu.tieba.frs.f.g dDM;
    private RelativeLayout dhJ;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aXt = true;
        this.cNS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aiY() != null) {
                    l.this.aiY().a(view, l.this.aXV);
                }
                l.this.ev(view == l.this.cNP);
            }
        };
        this.cPC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<be> aiY = l.this.aiY();
                if (aiY != null) {
                    view.setTag("2");
                    aiY.a(view, l.this.aXV);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aiY() != null) {
                    l.this.aiY().a(view, l.this.aXV);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cNO = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cNO.getHeadView() != null) {
            this.cNO.getHeadView().setIsRound(true);
            this.cNO.getHeadView().setDrawBorder(false);
            this.cNO.getHeadView().setDefaultResource(17170445);
            this.cNO.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cNO.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cNO.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cNO.DG();
        if (this.cNO.getPendantView() != null) {
            this.cNO.getPendantView().setIsRound(true);
            this.cNO.getPendantView().setDrawBorder(false);
        }
        this.cNO.setAfterClickListener(this.bce);
        this.bOc = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cPw = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cPw.setAfterClickListener(this.cPC);
        this.cPy = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cPy.setVisibility(8);
        this.cPx = view.findViewById(d.g.divider_line_above_praise);
        this.cPz = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cPz.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cPz.setChildClickListener(this.cNS);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.f(1.0d);
        this.cPz.setImageProcessor(fVar);
        this.ciE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.ciD.setUserAfterClickListener(this.bce);
        this.ciD.setFrom(3);
        this.ciE.setOnClickListener(this.cNS);
        this.ciE.setReplyTimeVisible(false);
        this.ciE.setShowPraiseNum(true);
        this.ciE.setNeedAddPraiseIcon(true);
        this.ciE.setNeedAddReplyIcon(true);
        this.ciE.setIsBarViewVisible(false);
        this.ciE.setShareVisible(true);
        this.ciE.setShareReportFrom(1);
        this.ciE.setStType("frs_page");
        this.ciE.setFrom(2);
        this.ciE.bbP = 3;
        this.dhJ = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.dDM = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dhJ);
        this.dDM.setUniqueId(getTag());
        this.cNP = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.cNP.setOnClickListener(this.cNS);
        this.cRo = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cRo.setPageId(getTag());
        this.cjA = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout ajD() {
        return this.ciE;
    }

    public void setSingleImageRatio(double d) {
        if (this.cPz != null) {
            this.cPz.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cPz != null) {
            this.cPz.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cPz != null) {
            this.cPz.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bOc, d.C0108d.cp_bg_line_e);
            this.cPz.onChangeSkinType();
            this.ciE.onChangeSkinType();
            this.ciD.onChangeSkinType();
            this.dDM.onChangeSkinType();
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
    public void a(final be beVar) {
        if (beVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aXV = beVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cNS);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.cNP.onChangeSkinType();
        if (!ajc() && com.baidu.tieba.card.k.jU(this.aXV.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.aXV.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cPy, this.aXV.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cNP.getGodReplyContent(), this.aXV.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
        this.dDM.T(this.aXV);
        this.ciD.setData(this.aXV);
        this.cNP.setFromCDN(this.aXt);
        this.cNP.setData(this.aXV.Ao());
        this.ciD.setUserAfterClickListener(this.bce);
        this.ciE.setData(beVar);
        if (this.ciD.getHeaderImg() != null) {
            if (this.ciD.getIsSimpleThread()) {
                this.ciD.getHeaderImg().setVisibility(8);
                this.cNO.setVisibility(8);
            } else if (beVar.yX() == null || beVar.yX().getPendantData() == null || StringUtils.isNull(beVar.yX().getPendantData().xu())) {
                this.cNO.setVisibility(8);
                this.ciD.getHeaderImg().setVisibility(0);
                this.ciD.getHeaderImg().setData(beVar);
            } else {
                this.ciD.getHeaderImg().setVisibility(4);
                this.cNO.setVisibility(0);
                this.cNO.setData(beVar);
            }
        }
        F(beVar);
        ArrayList<VoiceData.VoiceModel> zm = beVar.zm();
        if (com.baidu.tbadk.core.util.v.G(zm)) {
            this.cPw.setVisibility(8);
        } else {
            this.cPw.bDs();
            this.cPw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zm.get(0);
            this.cPw.setVoiceModel(voiceModel);
            this.cPw.setTag(voiceModel);
            this.cPw.btM();
            if (voiceModel != null) {
                this.cPw.qL(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> zi = beVar.zi();
        if (com.baidu.tbadk.core.i.wB().wH() && com.baidu.tbadk.core.util.v.F(zi) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < zi.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zi, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.F(linkedList) > 0) {
                this.cPz.setVisibility(0);
                this.cPz.setFromCDN(this.aXt);
                this.cPz.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void f(View view, int i2, boolean z) {
                        v<be> aiY = l.this.aiY();
                        if (z) {
                            if (aiY != null) {
                                view.setTag("1");
                                aiY.bLv = true;
                                aiY.a(view, l.this.aXV);
                            }
                            l.this.ev(false);
                            return;
                        }
                        if (aiY != null) {
                            view.setTag("1");
                            aiY.bLv = false;
                            aiY.a(view, l.this.aXV);
                        }
                        l.this.a(view, linkedList, i2, beVar);
                    }
                });
                this.cPz.setImageMediaList(linkedList);
            } else {
                this.cPz.setVisibility(8);
            }
        } else {
            this.cPz.setVisibility(8);
        }
        ajq();
        ajr();
        H(beVar);
        avD();
    }

    private void ajq() {
        if (this.cPx != null && this.cPz != null && this.cNP != null) {
            if (this.cPz.getVisibility() == 8 && this.cNP.getVisibility() == 8) {
                this.cPx.setVisibility(0);
            } else {
                this.cPx.setVisibility(8);
            }
        }
    }

    public void H(be beVar) {
        MetaData yX;
        if (beVar != null && this.cRo != null && (yX = beVar.yX()) != null) {
            final ThemeCardInUserData themeCard = yX.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cRo.setVisibility(8);
                return;
            }
            this.cRo.setVisibility(0);
            this.cRo.setImageDrawable(null);
            this.cRo.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cRo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(l.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, be beVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
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
                imageUrlData.urlType = this.aXt ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(beVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!com.baidu.tbadk.core.util.v.G(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, beVar.zd(), String.valueOf(beVar.getFid()), beVar.getTid(), this.aXt, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
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

    private void ajr() {
        this.cPw.setClickable(true);
        int childCount = this.cPz.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cPz.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aXt = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciE != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ciD != null) {
            this.ciD.setPageUniqueId(bdUniqueId);
        }
        if (this.cPz != null) {
            this.cPz.setPageUniqueId(bdUniqueId);
        }
    }

    protected void ev(boolean z) {
        if (this.aXV != null) {
            com.baidu.tieba.card.k.jT(this.aXV.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.aXV.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cPy, this.aXV.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cNP.getGodReplyContent(), this.aXV.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            m zU = this.aXV.zU();
            if (zU != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.bd(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zU.getCartoonId(), zU.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aXV.aOz;
            if (this.aXV.aOy == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aKm;
                long j = jVar.aKn;
                al alVar = new al();
                alVar.pageContext = this.mPageContext;
                alVar.aKA = str;
                alVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, alVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aXV, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aXV.getFid()));
            addLocateParam.setForumName(this.aXV.zd());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aXV.zO() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean ajc() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cPw != null) {
            this.cPw.setVoiceManager(voiceManager);
        }
    }

    private boolean F(be beVar) {
        SpannableStringBuilder j = beVar.j(false, true);
        if (j == null || StringUtils.isNull(j.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            com.baidu.tieba.card.k.a(this.mTitle, beVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
        return true;
    }

    private void avD() {
        if (this.mTitle != null && this.cPw != null && this.cPz != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cPw.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.cPw.setLayoutParams(layoutParams);
            if (this.cPw.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cPz.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.cPz.setLayoutParams(layoutParams2);
            }
        }
    }
}
