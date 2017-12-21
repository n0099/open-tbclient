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
    protected boolean ajk;
    private final View.OnClickListener aog;
    private HeadPendantClickableView bZi;
    private ThreadGodReplyLayout bZj;
    private View.OnClickListener bZn;
    protected View bas;
    private ThreadUserInfoLayout bvI;
    protected ThreadCommentAndPraiseInfoLayout bvM;
    public LinearLayout bvP;
    private com.baidu.tieba.frs.g.g cOW;
    private PlayVoiceBntNew caQ;
    protected View caR;
    private TextView caS;
    protected ConstrainImageGroup caT;
    private final View.OnClickListener caW;
    public TbImageView ccL;
    private RelativeLayout ctl;
    private String mForumName;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajk = true;
        this.bZn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abt() != null) {
                    l.this.abt().a(view, l.this.ajM);
                }
                l.this.dO(view == l.this.bZj);
            }
        };
        this.caW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<bd> abt = l.this.abt();
                if (abt != null) {
                    view.setTag("2");
                    abt.a(view, l.this.ajM);
                }
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abt() != null) {
                    l.this.abt().a(view, l.this.ajM);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bZi = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZi.getHeadView() != null) {
            this.bZi.getHeadView().setIsRound(true);
            this.bZi.getHeadView().setDrawBorder(false);
            this.bZi.getHeadView().setDefaultResource(17170445);
            this.bZi.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZi.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.bZi.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZi.wi();
        if (this.bZi.getPendantView() != null) {
            this.bZi.getPendantView().setIsRound(true);
            this.bZi.getPendantView().setDrawBorder(false);
        }
        this.bZi.setAfterClickListener(this.aog);
        this.bas = view.findViewById(d.g.divider_line);
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.caQ = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.caQ.setAfterClickListener(this.caW);
        this.caS = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.caS.setVisibility(8);
        this.caR = view.findViewById(d.g.divider_line_above_praise);
        this.caT = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.caT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20));
        this.caT.setChildClickListener(this.bZn);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caT.setImageProcessor(fVar);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bvI.setUserAfterClickListener(this.aog);
        this.bvI.setFrom(3);
        this.bvM.setOnClickListener(this.bZn);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setIsBarViewVisible(false);
        this.bvM.setShareVisible(true);
        this.bvM.setShareReportFrom(1);
        this.bvM.setStType("frs_page");
        this.bvM.setFrom(2);
        this.bvM.anR = 3;
        this.ctl = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.cOW = new com.baidu.tieba.frs.g.g(this.mPageContext, this.ctl);
        this.cOW.setUniqueId(getTag());
        this.bZj = (ThreadGodReplyLayout) view.findViewById(d.g.card_frs_god_reply_layout);
        this.bZj.setOnClickListener(this.bZn);
        this.ccL = (TbImageView) view.findViewById(d.g.frs_normal_item_theme_card);
        this.ccL.setPageId(getTag());
        this.bvP = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
    }

    public ThreadCommentAndPraiseInfoLayout abX() {
        return this.bvM;
    }

    public void setSingleImageRatio(double d) {
        if (this.caT != null) {
            this.caT.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caT != null) {
            this.caT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caT != null) {
            this.caT.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.k(this.bas, d.C0095d.cp_bg_line_e);
            this.caT.onChangeSkinType();
            this.bvM.onChangeSkinType();
            this.bvI.onChangeSkinType();
            this.cOW.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new_frame;
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
        this.ajM = bdVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZn);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bZj.onChangeSkinType();
        if (!abx() && com.baidu.tieba.card.k.jP(this.ajM.getId())) {
            com.baidu.tieba.card.k.a(this.mTitle, this.ajM.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caS, this.ajM.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.bZj.getGodReplyContent(), this.ajM.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
        }
        this.cOW.U(this.ajM);
        this.bvI.setData(this.ajM);
        this.bZj.setFromCDN(this.ajk);
        this.bZj.setData(this.ajM.sM());
        this.bvI.setUserAfterClickListener(this.aog);
        this.bvM.setData(bdVar);
        if (this.bvI.getHeaderImg() != null) {
            if (this.bvI.getIsSimpleThread()) {
                this.bvI.getHeaderImg().setVisibility(8);
                this.bZi.setVisibility(8);
            } else if (bdVar.rv() == null || bdVar.rv().getPendantData() == null || StringUtils.isNull(bdVar.rv().getPendantData().pR())) {
                this.bZi.setVisibility(8);
                this.bvI.getHeaderImg().setVisibility(0);
                this.bvI.getHeaderImg().setData(bdVar);
            } else {
                this.bvI.getHeaderImg().setVisibility(4);
                this.bZi.setVisibility(0);
                this.bZi.setData(bdVar);
            }
        }
        B(bdVar);
        ArrayList<VoiceData.VoiceModel> rK = bdVar.rK();
        if (com.baidu.tbadk.core.util.v.w(rK)) {
            this.caQ.setVisibility(8);
        } else {
            this.caQ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rK.get(0);
            this.caQ.setVoiceModel(voiceModel);
            this.caQ.setTag(voiceModel);
            this.caQ.bmf();
            if (voiceModel != null) {
                this.caQ.nT(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> rG = bdVar.rG();
        if (com.baidu.tbadk.core.h.oY().pe() && com.baidu.tbadk.core.util.v.v(rG) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < rG.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                this.caT.setVisibility(0);
                this.caT.setFromCDN(this.ajk);
                this.caT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        v<bd> abt = l.this.abt();
                        if (z) {
                            if (abt != null) {
                                view.setTag("1");
                                abt.aXH = true;
                                abt.a(view, l.this.ajM);
                            }
                            l.this.dO(false);
                            return;
                        }
                        if (abt != null) {
                            view.setTag("1");
                            abt.aXH = false;
                            abt.a(view, l.this.ajM);
                        }
                        l.this.a(view, linkedList, i2, bdVar);
                    }
                });
                this.caT.setImageMediaList(linkedList);
            } else {
                this.caT.setVisibility(8);
            }
        } else {
            this.caT.setVisibility(8);
        }
        abK();
        abL();
        D(bdVar);
        aoe();
    }

    private void abK() {
        if (this.caR != null && this.caT != null && this.bZj != null) {
            if (this.caT.getVisibility() == 8 && this.bZj.getVisibility() == 8) {
                this.caR.setVisibility(0);
            } else {
                this.caR.setVisibility(8);
            }
        }
    }

    public void D(bd bdVar) {
        MetaData rv;
        if (bdVar != null && this.ccL != null && (rv = bdVar.rv()) != null) {
            final ThemeCardInUserData themeCard = rv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.ccL.setVisibility(8);
                return;
            }
            this.ccL.setVisibility(0);
            this.ccL.setImageBitmap(null);
            this.ccL.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ccL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
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
                imageUrlData.urlType = this.ajk ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rB(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajk, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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

    private void abL() {
        this.caQ.setClickable(true);
        int childCount = this.caT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caT.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajk = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bvM != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bvI != null) {
            this.bvI.setPageUniqueId(bdUniqueId);
        }
        if (this.caT != null) {
            this.caT.setPageUniqueId(bdUniqueId);
        }
    }

    protected void dO(boolean z) {
        if (this.ajM != null) {
            com.baidu.tieba.card.k.jO(this.ajM.getId());
            com.baidu.tieba.card.k.a(this.mTitle, this.ajM.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.caS, this.ajM.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
            com.baidu.tieba.card.k.a(this.bZj.getGodReplyContent(), this.ajM.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
            m ss = this.ajM.ss();
            if (ss != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aR(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ss.getCartoonId(), ss.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.ajM.aaa;
            if (this.ajM.ZZ == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.VP;
                long j = jVar.VQ;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.Wd = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.ajM, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajM.getFid()));
            addLocateParam.setForumName(this.ajM.rB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.ajM.sm() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean abx() {
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
        if (this.caQ != null) {
            this.caQ.setVoiceManager(voiceManager);
        }
    }

    private boolean B(bd bdVar) {
        SpannableStringBuilder g = bdVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(g));
            this.mTitle.setText(g);
            com.baidu.tieba.card.k.a(this.mTitle, bdVar.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
        }
        return true;
    }

    private void aoe() {
        if (this.mTitle != null && this.caQ != null && this.caT != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.caQ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds20);
            this.caQ.setLayoutParams(layoutParams);
            if (this.caQ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.caT.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds28);
                this.caT.setLayoutParams(layoutParams2);
            }
        }
    }
}
