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
    protected boolean aXA;
    protected bd aYc;
    protected View bOs;
    private final View.OnClickListener bcm;
    private ThreadGodReplyLayout cSK;
    private View.OnClickListener cSO;
    private PlayVoiceBntNew cUt;
    protected View cUu;
    private TextView cUv;
    protected ConstrainImageGroup cUw;
    private final View.OnClickListener cUz;
    public TbImageView cWl;
    private ThreadUserInfoLayout ciS;
    protected ThreadCommentAndPraiseInfoLayout ciT;
    private HeadPendantClickableView cjC;
    public LinearLayout cjQ;
    private com.baidu.tieba.frs.f.g dII;
    private RelativeLayout dmF;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aXA = true;
        this.cSO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akg() != null) {
                    l.this.akg().a(view, l.this.aYc);
                }
                l.this.eB(view == l.this.cSK);
            }
        };
        this.cUz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> akg = l.this.akg();
                if (akg != null) {
                    view.setTag("2");
                    akg.a(view, l.this.aYc);
                }
            }
        };
        this.bcm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akg() != null) {
                    l.this.akg().a(view, l.this.aYc);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.cjC = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cjC.getHeadView() != null) {
            this.cjC.getHeadView().setIsRound(true);
            this.cjC.getHeadView().setDrawBorder(false);
            this.cjC.getHeadView().setDefaultResource(17170445);
            this.cjC.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cjC.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.cjC.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cjC.Dz();
        if (this.cjC.getPendantView() != null) {
            this.cjC.getPendantView().setIsRound(true);
            this.cjC.getPendantView().setDrawBorder(false);
        }
        this.cjC.setAfterClickListener(this.bcm);
        this.bOs = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cUt = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cUt.setAfterClickListener(this.cUz);
        this.cUv = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cUv.setVisibility(8);
        this.cUu = view.findViewById(d.g.divider_line_above_praise);
        this.cUw = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cUw.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.cUw.setChildClickListener(this.cSO);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.g(1.0d);
        this.cUw.setImageProcessor(fVar);
        this.ciT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.ciS = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.ciS.setUserAfterClickListener(this.bcm);
        this.ciS.setFrom(3);
        this.ciT.setOnClickListener(this.cSO);
        this.ciT.setReplyTimeVisible(false);
        this.ciT.setShowPraiseNum(true);
        this.ciT.setNeedAddPraiseIcon(true);
        this.ciT.setNeedAddReplyIcon(true);
        this.ciT.setIsBarViewVisible(false);
        this.ciT.setShareVisible(true);
        this.ciT.setShareReportFrom(1);
        this.ciT.setStType("frs_page");
        this.ciT.setFrom(2);
        this.ciT.bbX = 3;
        this.dmF = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.dII = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dmF);
        this.dII.setUniqueId(getTag());
        this.cSK = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.cSK.setOnClickListener(this.cSO);
        this.cWl = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.cWl.setPageId(getTag());
        this.cjQ = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout akL() {
        return this.ciT;
    }

    public void setSingleImageRatio(double d) {
        if (this.cUw != null) {
            this.cUw.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUw != null) {
            this.cUw.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUw != null) {
            this.cUw.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.bOs, d.C0108d.cp_bg_line_e);
            this.cUw.onChangeSkinType();
            this.ciT.onChangeSkinType();
            this.ciS.onChangeSkinType();
            this.dII.onChangeSkinType();
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
        this.aYc = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cSO);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.cSK.onChangeSkinType();
        if (!akk() && com.baidu.tieba.card.k.kk(this.aYc.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.aYc.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cUv, this.aYc.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cSK.getGodReplyContent(), this.aYc.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
        }
        this.dII.T(this.aYc);
        this.ciS.setData(this.aYc);
        this.cSK.setFromCDN(this.aXA);
        this.cSK.setData(this.aYc.Ah());
        this.ciS.setUserAfterClickListener(this.bcm);
        this.ciT.setData(bdVar);
        if (this.ciS.getHeaderImg() != null) {
            if (this.ciS.getIsSimpleThread()) {
                this.ciS.getHeaderImg().setVisibility(8);
                this.cjC.setVisibility(8);
            } else if (bdVar.yT() == null || bdVar.yT().getPendantData() == null || StringUtils.isNull(bdVar.yT().getPendantData().xu())) {
                this.cjC.setVisibility(8);
                this.ciS.getHeaderImg().setVisibility(0);
                this.ciS.getHeaderImg().setData(bdVar);
            } else {
                this.ciS.getHeaderImg().setVisibility(4);
                this.cjC.setVisibility(0);
                this.cjC.setData(bdVar);
            }
        }
        F(bdVar);
        ArrayList<VoiceData.VoiceModel> zi = bdVar.zi();
        if (com.baidu.tbadk.core.util.v.E(zi)) {
            this.cUt.setVisibility(8);
        } else {
            this.cUt.bwR();
            this.cUt.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zi.get(0);
            this.cUt.setVoiceModel(voiceModel);
            this.cUt.setTag(voiceModel);
            this.cUt.bng();
            if (voiceModel != null) {
                this.cUt.qE(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> ze = bdVar.ze();
        if (com.baidu.tbadk.core.i.wB().wH() && com.baidu.tbadk.core.util.v.D(ze) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < ze.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(ze, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                this.cUw.setVisibility(0);
                this.cUw.setFromCDN(this.aXA);
                this.cUw.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void f(View view, int i2, boolean z) {
                        v<bd> akg = l.this.akg();
                        if (z) {
                            if (akg != null) {
                                view.setTag("1");
                                akg.bLL = true;
                                akg.a(view, l.this.aYc);
                            }
                            l.this.eB(false);
                            return;
                        }
                        if (akg != null) {
                            view.setTag("1");
                            akg.bLL = false;
                            akg.a(view, l.this.aYc);
                        }
                        l.this.a(view, linkedList, i2, bdVar);
                    }
                });
                this.cUw.setImageMediaList(linkedList);
            } else {
                this.cUw.setVisibility(8);
            }
        } else {
            this.cUw.setVisibility(8);
        }
        aky();
        akz();
        H(bdVar);
        awL();
    }

    private void aky() {
        if (this.cUu != null && this.cUw != null && this.cSK != null) {
            if (this.cUw.getVisibility() == 8 && this.cSK.getVisibility() == 8) {
                this.cUu.setVisibility(0);
            } else {
                this.cUu.setVisibility(8);
            }
        }
    }

    public void H(bd bdVar) {
        MetaData yT;
        if (bdVar != null && this.cWl != null && (yT = bdVar.yT()) != null) {
            final ThemeCardInUserData themeCard = yT.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cWl.setVisibility(8);
                return;
            }
            this.cWl.setVisibility(0);
            this.cWl.setImageDrawable(null);
            this.cWl.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cWl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
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
                imageUrlData.urlType = this.aXA ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yZ(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXA, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void akz() {
        this.cUt.setClickable(true);
        int childCount = this.cUw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cUw.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aXA = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ciT != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ciS != null) {
            this.ciS.setPageUniqueId(bdUniqueId);
        }
        if (this.cUw != null) {
            this.cUw.setPageUniqueId(bdUniqueId);
        }
    }

    protected void eB(boolean z) {
        if (this.aYc != null) {
            com.baidu.tieba.card.k.kj(this.aYc.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.aYc.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cUv, this.aYc.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.cSK.getGodReplyContent(), this.aYc.getId(), d.C0108d.cp_cont_f, d.C0108d.cp_cont_d);
            m zN = this.aYc.zN();
            if (zN != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.ba(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zN.getCartoonId(), zN.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aYc.aOA;
            if (this.aYc.aOz == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.aKn;
                long j = jVar.aKo;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.aKB = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aYc, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aYc.getFid()));
            addLocateParam.setForumName(this.aYc.yZ());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aYc.zI() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean akk() {
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
        if (this.cUt != null) {
            this.cUt.setVoiceManager(voiceManager);
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
            com.baidu.tieba.card.k.a(this.mTitle, bdVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
        }
        return true;
    }

    private void awL() {
        if (this.mTitle != null && this.cUt != null && this.cUw != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cUt.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.cUt.setLayoutParams(layoutParams);
            if (this.cUt.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cUw.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.cUw.setLayoutParams(layoutParams2);
            }
        }
    }
}
