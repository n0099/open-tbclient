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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bd;
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
public class l extends com.baidu.tieba.card.a<bd> implements u {
    protected bd aXU;
    protected boolean aXs;
    protected View bOk;
    private final View.OnClickListener bce;
    private ThreadGodReplyLayout cSp;
    private View.OnClickListener cSt;
    private PlayVoiceBntNew cTY;
    protected View cTZ;
    private TextView cUa;
    protected ConstrainImageGroup cUb;
    private final View.OnClickListener cUe;
    public TbImageView cVQ;
    private ThreadUserInfoLayout ciK;
    protected ThreadCommentAndPraiseInfoLayout ciL;
    public LinearLayout cjI;
    private HeadPendantClickableView cju;
    private com.baidu.tieba.frs.f.g dIn;
    private RelativeLayout dmk;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aXs = true;
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akb() != null) {
                    l.this.akb().a(view, l.this.aXU);
                }
                l.this.ez(view == l.this.cSp);
            }
        };
        this.cUe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> akb = l.this.akb();
                if (akb != null) {
                    view.setTag("2");
                    akb.a(view, l.this.aXU);
                }
            }
        };
        this.bce = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akb() != null) {
                    l.this.akb().a(view, l.this.aXU);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cju = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cju.getHeadView() != null) {
            this.cju.getHeadView().setIsRound(true);
            this.cju.getHeadView().setDrawBorder(false);
            this.cju.getHeadView().setDefaultResource(17170445);
            this.cju.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cju.getHeadView().setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.cju.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cju.Dx();
        if (this.cju.getPendantView() != null) {
            this.cju.getPendantView().setIsRound(true);
            this.cju.getPendantView().setDrawBorder(false);
        }
        this.cju.setAfterClickListener(this.bce);
        this.bOk = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cTY = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cTY.setAfterClickListener(this.cUe);
        this.cUa = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cUa.setVisibility(8);
        this.cTZ = view.findViewById(d.g.divider_line_above_praise);
        this.cUb = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cUb.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cUb.setChildClickListener(this.cSt);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.g(1.0d);
        this.cUb.setImageProcessor(fVar);
        this.ciL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciK = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.ciK.setUserAfterClickListener(this.bce);
        this.ciK.setFrom(3);
        this.ciL.setOnClickListener(this.cSt);
        this.ciL.setReplyTimeVisible(false);
        this.ciL.setShowPraiseNum(true);
        this.ciL.setNeedAddPraiseIcon(true);
        this.ciL.setNeedAddReplyIcon(true);
        this.ciL.setIsBarViewVisible(false);
        this.ciL.setShareVisible(true);
        this.ciL.setShareReportFrom(1);
        this.ciL.setStType("frs_page");
        this.ciL.setFrom(2);
        this.ciL.bbP = 3;
        this.dmk = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.dIn = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dmk);
        this.dIn.setUniqueId(getTag());
        this.cSp = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.cSp.setOnClickListener(this.cSt);
        this.cVQ = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cVQ.setPageId(getTag());
        this.cjI = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout akG() {
        return this.ciL;
    }

    public void setSingleImageRatio(double d) {
        if (this.cUb != null) {
            this.cUb.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUb != null) {
            this.cUb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUb != null) {
            this.cUb.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bOk, d.C0107d.cp_bg_line_e);
            this.cUb.onChangeSkinType();
            this.ciL.onChangeSkinType();
            this.ciK.onChangeSkinType();
            this.dIn.onChangeSkinType();
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
        this.aXU = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSt);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.cSp.onChangeSkinType();
        if (!akf() && com.baidu.tieba.card.k.kd(this.aXU.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.aXU.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cUa, this.aXU.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cSp.getGodReplyContent(), this.aXU.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
        }
        this.dIn.T(this.aXU);
        this.ciK.setData(this.aXU);
        this.cSp.setFromCDN(this.aXs);
        this.cSp.setData(this.aXU.Ag());
        this.ciK.setUserAfterClickListener(this.bce);
        this.ciL.setData(bdVar);
        if (this.ciK.getHeaderImg() != null) {
            if (this.ciK.getIsSimpleThread()) {
                this.ciK.getHeaderImg().setVisibility(8);
                this.cju.setVisibility(8);
            } else if (bdVar.yS() == null || bdVar.yS().getPendantData() == null || StringUtils.isNull(bdVar.yS().getPendantData().xt())) {
                this.cju.setVisibility(8);
                this.ciK.getHeaderImg().setVisibility(0);
                this.ciK.getHeaderImg().setData(bdVar);
            } else {
                this.ciK.getHeaderImg().setVisibility(4);
                this.cju.setVisibility(0);
                this.cju.setData(bdVar);
            }
        }
        F(bdVar);
        ArrayList<VoiceData.VoiceModel> zh = bdVar.zh();
        if (com.baidu.tbadk.core.util.v.E(zh)) {
            this.cTY.setVisibility(8);
        } else {
            this.cTY.bwP();
            this.cTY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zh.get(0);
            this.cTY.setVoiceModel(voiceModel);
            this.cTY.setTag(voiceModel);
            this.cTY.bnf();
            if (voiceModel != null) {
                this.cTY.qE(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> zd = bdVar.zd();
        if (com.baidu.tbadk.core.i.wA().wG() && com.baidu.tbadk.core.util.v.D(zd) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < zd.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zd, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                this.cUb.setVisibility(0);
                this.cUb.setFromCDN(this.aXs);
                this.cUb.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void f(View view, int i2, boolean z) {
                        v<bd> akb = l.this.akb();
                        if (z) {
                            if (akb != null) {
                                view.setTag("1");
                                akb.bLD = true;
                                akb.a(view, l.this.aXU);
                            }
                            l.this.ez(false);
                            return;
                        }
                        if (akb != null) {
                            view.setTag("1");
                            akb.bLD = false;
                            akb.a(view, l.this.aXU);
                        }
                        l.this.a(view, linkedList, i2, bdVar);
                    }
                });
                this.cUb.setImageMediaList(linkedList);
            } else {
                this.cUb.setVisibility(8);
            }
        } else {
            this.cUb.setVisibility(8);
        }
        akt();
        aku();
        H(bdVar);
        awG();
    }

    private void akt() {
        if (this.cTZ != null && this.cUb != null && this.cSp != null) {
            if (this.cUb.getVisibility() == 8 && this.cSp.getVisibility() == 8) {
                this.cTZ.setVisibility(0);
            } else {
                this.cTZ.setVisibility(8);
            }
        }
    }

    public void H(bd bdVar) {
        MetaData yS;
        if (bdVar != null && this.cVQ != null && (yS = bdVar.yS()) != null) {
            final ThemeCardInUserData themeCard = yS.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cVQ.setVisibility(8);
                return;
            }
            this.cVQ.setVisibility(0);
            this.cVQ.setImageDrawable(null);
            this.cVQ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(l.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
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
                imageUrlData.urlType = this.aXs ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yY(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXs, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void aku() {
        this.cTY.setClickable(true);
        int childCount = this.cUb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cUb.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aXs = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciL != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ciK != null) {
            this.ciK.setPageUniqueId(bdUniqueId);
        }
        if (this.cUb != null) {
            this.cUb.setPageUniqueId(bdUniqueId);
        }
    }

    protected void ez(boolean z) {
        if (this.aXU != null) {
            com.baidu.tieba.card.k.kc(this.aXU.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.aXU.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cUa, this.aXU.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cSp.getGodReplyContent(), this.aXU.getId(), d.C0107d.cp_cont_f, d.C0107d.cp_cont_d);
            m zM = this.aXU.zM();
            if (zM != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.bd(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zM.getCartoonId(), zM.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aXU.aOx;
            if (this.aXU.aOw == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aKk;
                long j = jVar.aKl;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aKy = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aXU, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aXU.getFid()));
            addLocateParam.setForumName(this.aXU.yY());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aXU.zH() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean akf() {
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
        if (this.cTY != null) {
            this.cTY.setVoiceManager(voiceManager);
        }
    }

    private boolean F(bd bdVar) {
        SpannableStringBuilder j = bdVar.j(false, true);
        if (j == null || StringUtils.isNull(j.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            com.baidu.tieba.card.k.a(this.mTitle, bdVar.getId(), d.C0107d.cp_cont_b, d.C0107d.cp_cont_d);
        }
        return true;
    }

    private void awG() {
        if (this.mTitle != null && this.cTY != null && this.cUb != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cTY.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.cTY.setLayoutParams(layoutParams);
            if (this.cTY.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cUb.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.cUb.setLayoutParams(layoutParams2);
            }
        }
    }
}
