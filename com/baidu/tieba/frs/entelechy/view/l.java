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
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<bd> implements u {
    protected bd ajM;
    protected boolean ajn;
    private final View.OnClickListener aob;
    private HeadPendantClickableView bZa;
    private ThreadGodReplyLayout bZb;
    private View.OnClickListener bZf;
    protected View bam;
    private ThreadUserInfoLayout bvD;
    protected ThreadCommentAndPraiseInfoLayout bvH;
    public LinearLayout bvK;
    private com.baidu.tieba.frs.g.g cOH;
    private PlayVoiceBntNew caI;
    protected View caJ;
    private TextView caK;
    protected ConstrainImageGroup caL;
    private final View.OnClickListener caO;
    public TbImageView ccC;
    private RelativeLayout csY;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajn = true;
        this.bZf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abs() != null) {
                    l.this.abs().a(view, l.this.ajM);
                }
                l.this.dN(view == l.this.bZb);
            }
        };
        this.caO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> abs = l.this.abs();
                if (abs != null) {
                    view.setTag("2");
                    abs.a(view, l.this.ajM);
                }
            }
        };
        this.aob = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abs() != null) {
                    l.this.abs().a(view, l.this.ajM);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bZa = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZa.getHeadView() != null) {
            this.bZa.getHeadView().setIsRound(true);
            this.bZa.getHeadView().setDrawBorder(false);
            this.bZa.getHeadView().setDefaultResource(17170445);
            this.bZa.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZa.getHeadView().setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.bZa.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZa.wk();
        if (this.bZa.getPendantView() != null) {
            this.bZa.getPendantView().setIsRound(true);
            this.bZa.getPendantView().setDrawBorder(false);
        }
        this.bZa.setAfterClickListener(this.aob);
        this.bam = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.caI = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.caI.setAfterClickListener(this.caO);
        this.caK = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.caK.setVisibility(8);
        this.caJ = view.findViewById(d.g.divider_line_above_praise);
        this.caL = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.caL.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.caL.setChildClickListener(this.bZf);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caL.setImageProcessor(fVar);
        this.bvH = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvD = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bvD.setUserAfterClickListener(this.aob);
        this.bvD.setFrom(3);
        this.bvH.setOnClickListener(this.bZf);
        this.bvH.setReplyTimeVisible(false);
        this.bvH.setShowPraiseNum(true);
        this.bvH.setNeedAddPraiseIcon(true);
        this.bvH.setNeedAddReplyIcon(true);
        this.bvH.setIsBarViewVisible(false);
        this.bvH.setShareVisible(true);
        this.bvH.setShareReportFrom(1);
        this.bvH.setStType("frs_page");
        this.bvH.setFrom(2);
        this.bvH.anM = 3;
        this.csY = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.cOH = new com.baidu.tieba.frs.g.g(this.mPageContext, this.csY);
        this.cOH.setUniqueId(getTag());
        this.bZb = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.bZb.setOnClickListener(this.bZf);
        this.ccC = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ccC.setPageId(getTag());
        this.bvK = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public void setSingleImageRatio(double d) {
        if (this.caL != null) {
            this.caL.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caL != null) {
            this.caL.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caL != null) {
            this.caL.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.bam, d.C0082d.cp_bg_line_e);
            this.caL.onChangeSkinType();
            this.bvH.onChangeSkinType();
            this.bvD.onChangeSkinType();
            this.cOH.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: y */
    public void a(final bd bdVar) {
        if (bdVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ajM = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZf);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bZb.onChangeSkinType();
        if (!abw() && com.baidu.tieba.card.k.jR(this.ajM.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.ajM.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caK, this.ajM.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.bZb.getGodReplyContent(), this.ajM.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
        }
        this.cOH.S(this.ajM);
        this.bvD.setData(this.ajM);
        this.bZb.setFromCDN(this.ajn);
        this.bZb.setData(this.ajM.sO());
        this.bvD.setUserAfterClickListener(this.aob);
        this.bvH.setData(bdVar);
        if (this.bvD.getHeaderImg() != null) {
            if (this.bvD.getIsSimpleThread()) {
                this.bvD.getHeaderImg().setVisibility(8);
                this.bZa.setVisibility(8);
            } else if (bdVar.rx() == null || bdVar.rx().getPendantData() == null || StringUtils.isNull(bdVar.rx().getPendantData().pT())) {
                this.bZa.setVisibility(8);
                this.bvD.getHeaderImg().setVisibility(0);
                this.bvD.getHeaderImg().setData(bdVar);
            } else {
                this.bvD.getHeaderImg().setVisibility(4);
                this.bZa.setVisibility(0);
                this.bZa.setData(bdVar);
            }
        }
        z(bdVar);
        ArrayList<VoiceData.VoiceModel> rM = bdVar.rM();
        if (com.baidu.tbadk.core.util.v.w(rM)) {
            this.caI.setVisibility(8);
        } else {
            this.caI.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rM.get(0);
            this.caI.setVoiceModel(voiceModel);
            this.caI.setTag(voiceModel);
            this.caI.blz();
            if (voiceModel != null) {
                this.caI.nM(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> rI = bdVar.rI();
        if (com.baidu.tbadk.core.h.pa().pg() && com.baidu.tbadk.core.util.v.v(rI) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < rI.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rI, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                this.caL.setVisibility(0);
                this.caL.setFromCDN(this.ajn);
                this.caL.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        v<bd> abs = l.this.abs();
                        if (z) {
                            if (abs != null) {
                                view.setTag("1");
                                abs.aXB = true;
                                abs.a(view, l.this.ajM);
                            }
                            l.this.dN(false);
                            return;
                        }
                        if (abs != null) {
                            view.setTag("1");
                            abs.aXB = false;
                            abs.a(view, l.this.ajM);
                        }
                        l.this.a(view, linkedList, i2, bdVar);
                    }
                });
                this.caL.setImageMediaList(linkedList);
            } else {
                this.caL.setVisibility(8);
            }
        } else {
            this.caL.setVisibility(8);
        }
        abI();
        abJ();
        B(bdVar);
        anV();
    }

    private void abI() {
        if (this.caJ != null && this.caL != null && this.bZb != null) {
            if (this.caL.getVisibility() == 8 && this.bZb.getVisibility() == 8) {
                this.caJ.setVisibility(0);
            } else {
                this.caJ.setVisibility(8);
            }
        }
    }

    public void B(bd bdVar) {
        MetaData rx;
        if (bdVar != null && this.ccC != null && (rx = bdVar.rx()) != null) {
            final ThemeCardInUserData themeCard = rx.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccC.setVisibility(8);
                return;
            }
            this.ccC.setVisibility(0);
            this.ccC.setImageBitmap(null);
            this.ccC.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ccC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
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
                imageUrlData.urlType = this.ajn ? 13 : 14;
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
        if (!com.baidu.tbadk.core.util.v.w(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rD(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void abJ() {
        this.caI.setClickable(true);
        int childCount = this.caL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caL.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajn = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvH != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bvD != null) {
            this.bvD.setPageUniqueId(bdUniqueId);
        }
        if (this.caL != null) {
            this.caL.setPageUniqueId(bdUniqueId);
        }
    }

    protected void dN(boolean z) {
        if (this.ajM != null) {
            com.baidu.tieba.card.k.jQ(this.ajM.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.ajM.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caK, this.ajM.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.bZb.getGodReplyContent(), this.ajM.getId(), d.C0082d.cp_cont_f, d.C0082d.cp_cont_d);
            m su = this.ajM.su();
            if (su != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aU(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), su.getCartoonId(), su.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.ajM.aad;
            if (this.ajM.aac == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.VS;
                long j = jVar.VT;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.Wg = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajM, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajM.getFid()));
            addLocateParam.setForumName(this.ajM.rD());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.ajM.so() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abw() {
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
        if (this.caI != null) {
            this.caI.setVoiceManager(voiceManager);
        }
    }

    private boolean z(bd bdVar) {
        SpannableStringBuilder g = bdVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(g));
            this.mTitle.setText(g);
            com.baidu.tieba.card.k.a(this.mTitle, bdVar.getId(), d.C0082d.cp_cont_b, d.C0082d.cp_cont_d);
        }
        return true;
    }

    private void anV() {
        if (this.mTitle != null && this.caI != null && this.caL != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.caI.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.caI.setLayoutParams(layoutParams);
            if (this.caI.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.caL.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.caL.setLayoutParams(layoutParams2);
            }
        }
    }
}
