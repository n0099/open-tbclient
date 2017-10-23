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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<bh> implements v {
    private View aWK;
    private bh aiU;
    private boolean aiu;
    private final View.OnClickListener anx;
    private HeadPendantClickableView bJj;
    private ThreadGodReplyLayout bJk;
    private View.OnClickListener bJo;
    private PlayVoiceBntNew bLf;
    private View bLg;
    private TextView bLh;
    private ConstrainImageGroup bLi;
    private final View.OnClickListener bLj;
    private ThreadUserInfoLayout bmR;
    private ThreadCommentAndPraiseInfoLayout bmV;
    public LinearLayout bmZ;
    public TbImageView csi;
    private com.baidu.tieba.frs.h.g cxr;
    private String mForumName;
    private TbPageContext<?> mH;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiu = true;
        this.bJo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.Xn() != null) {
                    l.this.Xn().a(view, l.this.aiU);
                }
                l.this.dz(view == l.this.bJk);
            }
        };
        this.bLj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bh> Xn = l.this.Xn();
                if (Xn != null) {
                    view.setTag("2");
                    Xn.a(view, l.this.aiU);
                }
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.Xn() != null) {
                    l.this.Xn().a(view, l.this.aiU);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mH = tbPageContext;
        this.bJj = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bJj.getHeadView() != null) {
            this.bJj.getHeadView().setIsRound(true);
            this.bJj.getHeadView().setDrawBorder(false);
            this.bJj.getHeadView().setDefaultResource(17170445);
            this.bJj.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bJj.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bJj.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mH.getPageActivity(), d.f.ds70));
        }
        this.bJj.vZ();
        if (this.bJj.getPendantView() != null) {
            this.bJj.getPendantView().setIsRound(true);
            this.bJj.getPendantView().setDrawBorder(false);
        }
        this.bJj.setAfterClickListener(this.anx);
        this.aWK = view.findViewById(d.h.divider_line);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bLf = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bLf.setAfterClickListener(this.bLj);
        this.bLh = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bLh.setVisibility(8);
        this.bLg = view.findViewById(d.h.divider_line_above_praise);
        this.bLi = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bLi.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bLi.setChildClickListener(this.bJo);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bLi.setImageProcessor(fVar);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bmR = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bmR.setUserAfterClickListener(this.anx);
        this.bmR.setFrom(3);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bmV.setOnClickListener(this.bJo);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(true);
        this.bmV.setIsBarViewVisible(false);
        this.bmV.setShareVisible(true);
        this.bmV.setShareReportFrom(1);
        this.bmV.setFrom(2);
        this.cxr = new com.baidu.tieba.frs.h.g(this.mH, this.bmR);
        this.cxr.setUniqueId(getTag());
        this.bJk = (ThreadGodReplyLayout) view.findViewById(d.h.card_frs_god_reply_layout);
        this.bJk.setOnClickListener(this.bJo);
        this.csi = (TbImageView) view.findViewById(d.h.frs_normal_item_theme_card);
        this.csi.setPageId(getTag());
        this.bmZ = (LinearLayout) view.findViewById(d.h.card_home_page_normal_thread_content_layout);
    }

    public void setSingleImageRatio(double d) {
        if (this.bLi != null) {
            this.bLi.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLi != null) {
            this.bLi.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLi != null) {
            this.bLi.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.k(this.aWK, d.e.cp_bg_line_e);
            aj.k(this.bLg, d.e.cp_bg_line_e);
            this.bLi.onChangeSkinType();
            this.bmV.onChangeSkinType();
            this.bmR.onChangeSkinType();
            this.cxr.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: w */
    public void a(final bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiU = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bJo);
        }
        d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        this.bJk.onChangeSkinType();
        if (!Xr() && m.jm(this.aiU.getId())) {
            m.a(this.mTitle, this.aiU.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLh, this.aiU.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJk.getGodReplyContent(), this.aiU.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cxr.O(this.aiU);
        this.bmR.setData(this.aiU);
        this.bJk.setFromCDN(this.aiu);
        this.bJk.setData(this.aiU.sE());
        this.bmR.setUserAfterClickListener(this.anx);
        this.bmV.setData(bhVar);
        this.mStType = m.rf();
        if (this.bmR.getHeaderImg() != null) {
            if (this.bmR.getIsSimpleThread()) {
                this.bmR.getHeaderImg().setVisibility(8);
                this.bJj.setVisibility(8);
            } else if (bhVar.getAuthor() == null || bhVar.getAuthor().getPendantData() == null || StringUtils.isNull(bhVar.getAuthor().getPendantData().pL())) {
                this.bJj.setVisibility(8);
                this.bmR.getHeaderImg().setVisibility(0);
                this.bmR.getHeaderImg().setData(bhVar);
            } else {
                this.bmR.getHeaderImg().setVisibility(4);
                this.bJj.setVisibility(0);
                this.bJj.setData(bhVar);
            }
        }
        y(bhVar);
        ArrayList<VoiceData.VoiceModel> rC = bhVar.rC();
        if (com.baidu.tbadk.core.util.v.u(rC)) {
            this.bLf.setVisibility(8);
            dA(false);
        } else {
            this.bLf.setVisibility(0);
            dA(true);
            VoiceData.VoiceModel voiceModel = rC.get(0);
            this.bLf.setVoiceModel(voiceModel);
            this.bLf.setTag(voiceModel);
            this.bLf.bgc();
            if (voiceModel != null) {
                this.bLf.ng(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> ry = bhVar.ry();
        if (com.baidu.tbadk.core.h.oM().oS() && com.baidu.tbadk.core.util.v.t(ry) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < ry.size(); i++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(ry, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.v.t(linkedList) > 0) {
                this.bLi.setVisibility(0);
                this.bLi.setFromCDN(this.aiu);
                this.bLi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        x<bh> Xn = l.this.Xn();
                        if (z) {
                            if (Xn != null) {
                                view.setTag("1");
                                Xn.aUn = true;
                                Xn.a(view, l.this.aiU);
                            }
                            l.this.dz(false);
                            return;
                        }
                        if (Xn != null) {
                            view.setTag("1");
                            Xn.aUn = false;
                            Xn.a(view, l.this.aiU);
                        }
                        l.this.a(view, linkedList, i2, bhVar);
                    }
                });
                this.bLi.setImageMediaList(linkedList);
            } else {
                this.bLi.setVisibility(8);
            }
        } else {
            this.bLi.setVisibility(8);
        }
        XD();
        XE();
        F(bhVar);
        XG();
    }

    private void XD() {
        if (this.bLg != null && this.bLi != null && this.bJk != null) {
            if (this.bLi.getVisibility() == 8 && this.bJk.getVisibility() == 8) {
                this.bLg.setVisibility(0);
            } else {
                this.bLg.setVisibility(8);
            }
        }
    }

    private void dA(boolean z) {
        if (this.bLi != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLi.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10);
            }
            this.bLi.setLayoutParams(layoutParams);
        }
    }

    public void F(bh bhVar) {
        MetaData author;
        if (bhVar != null && this.csi != null && (author = bhVar.getAuthor()) != null) {
            final ThemeCardInUserData themeCard = author.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.csi.setVisibility(8);
                return;
            }
            this.csi.setVisibility(0);
            this.csi.setImageBitmap(null);
            this.csi.c(themeCard.getCardImageUrlAndroid(), 10, false);
            this.csi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(l.this.mH.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mH.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aiu ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mH.getPageActivity()).createConfig(arrayList, i, bhVar.rt(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiu, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void XE() {
        this.bLf.setClickable(true);
        int childCount = this.bLi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bLi.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiu = z;
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bmV != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bmR != null) {
            this.bmR.setPageUniqueId(bdUniqueId);
        }
        if (this.bLi != null) {
            this.bLi.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dz(boolean z) {
        if (this.aiU != null) {
            m.jl(this.aiU.getId());
            m.a(this.mTitle, this.aiU.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bLh, this.aiU.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bJk.getGodReplyContent(), this.aiU.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            n sk = this.aiU.sk();
            if (sk != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ax.aS(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mH.getPageActivity(), sk.getCartoonId(), sk.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.aiU.Zp;
            if (this.aiU.Zo == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.UT;
                long j = kVar.UU;
                ao aoVar = new ao();
                aoVar.pageContext = this.mH;
                aoVar.Vr = str;
                aoVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mH.getPageActivity()).createFromThreadCfg(this.aiU, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aiU.getFid()));
            addLocateParam.setForumName(this.aiU.rt());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Xr() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.bLf != null) {
            this.bLf.setVoiceManager(voiceManager);
        }
    }

    private boolean y(bh bhVar) {
        SpannableStringBuilder g = bhVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(g));
            this.mTitle.setText(g);
            m.a(this.mTitle, bhVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
        }
        return true;
    }

    private void XG() {
        if (this.mTitle != null && this.bLf != null && this.bLi != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bLf.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds24);
            this.bLf.setLayoutParams(layoutParams);
            if (this.bLf.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bLi.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds24);
                this.bLi.setLayoutParams(layoutParams2);
            }
        }
    }
}
