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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AppletsCellView;
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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.a<bb> implements com.baidu.tieba.a.e, ab {
    protected bb aAQ;
    protected boolean aAb;
    private final View.OnClickListener aGk;
    private String bVS;
    private HeadPendantClickableView bWP;
    protected ThreadSourceShareAndPraiseLayout bWS;
    public ThreadUserInfoLayout bWe;
    protected ThreadCommentAndPraiseInfoLayout bWf;
    public LinearLayout bXd;
    protected View buH;
    private ThreadGodReplyLayout cKD;
    private View.OnClickListener cKG;
    private PlayVoiceBntNew cNk;
    protected View cNl;
    private TextView cNm;
    protected ConstrainImageGroup cNn;
    private final View.OnClickListener cNq;
    public TbImageView cOT;
    private TbImageView cOV;
    private com.baidu.tieba.frs.vc.g dJC;
    private String dJN;
    private AppletsCellView dJO;
    private RelativeLayout dgE;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aAb = true;
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.ayM().ayN()) {
                    if (e.this.bWf != null) {
                        e.this.bWf.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (e.this.anO() != null) {
                    e.this.anO().a(view, e.this.aAQ);
                }
                e.this.fb(view == e.this.cKD);
            }
        };
        this.cNq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<bb> anO = e.this.anO();
                if (anO != null) {
                    view.setTag("2");
                    anO.a(view, e.this.aAQ);
                }
            }
        };
        this.aGk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.anO() != null) {
                    e.this.anO().a(view, e.this.aAQ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.bWP = (HeadPendantClickableView) view.findViewById(e.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bWP.getHeadView() != null) {
            this.bWP.getHeadView().setIsRound(true);
            this.bWP.getHeadView().setDrawBorder(false);
            this.bWP.getHeadView().setDefaultResource(17170445);
            this.bWP.getHeadView().setDefaultErrorResource(e.f.icon_default_avatar100);
            this.bWP.getHeadView().setDefaultBgResource(e.d.cp_bg_line_e);
            this.bWP.getHeadView().setRadius(l.h(this.mPageContext.getPageActivity(), e.C0175e.ds70));
        }
        this.bWP.setHasPendantStyle();
        if (this.bWP.getPendantView() != null) {
            this.bWP.getPendantView().setIsRound(true);
            this.bWP.getPendantView().setDrawBorder(false);
        }
        this.bWP.setAfterClickListener(this.aGk);
        this.buH = view.findViewById(e.g.divider_line);
        this.mTitle = (TextView) view.findViewById(e.g.card_home_page_normal_thread_title);
        this.cNk = (PlayVoiceBntNew) view.findViewById(e.g.card_home_page_normal_thread_abstract_voice);
        this.cNk.setAfterClickListener(this.cNq);
        this.cNm = (TextView) view.findViewById(e.g.card_home_page_normal_thread_abstract);
        this.cNm.setVisibility(8);
        this.cNl = view.findViewById(e.g.divider_line_above_praise);
        this.cNn = (ConstrainImageGroup) view.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cNn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds20));
        this.cNn.setChildClickListener(this.cKG);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cNn.setImageProcessor(eVar);
        this.bWf = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.bWe = (ThreadUserInfoLayout) view.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        this.bWe.setUserAfterClickListener(this.aGk);
        this.bWe.setFrom(3);
        this.bWf.setOnClickListener(this.cKG);
        this.bWf.setReplyTimeVisible(false);
        this.bWf.setShowPraiseNum(true);
        this.bWf.setNeedAddPraiseIcon(true);
        this.bWf.setNeedAddReplyIcon(true);
        this.bWf.setIsBarViewVisible(false);
        this.bWf.setShareVisible(true);
        this.bWf.setShareReportFrom(1);
        this.bWf.setStType("frs_page");
        this.bWf.setFrom(2);
        this.bWf.setDisPraiseFrom(2);
        this.bWf.ary = 3;
        this.bWS = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_home_page_source_read_share_layout);
        if (this.bWS != null) {
            this.bWS.aFS.setOnClickListener(this.cKG);
            this.bWS.setFrom(2);
            this.bWS.setShareReportFrom(1);
            this.bWS.setSourceFromForPb(3);
            this.bWS.setStType("frs_page");
            this.bWS.setHideBarName(true);
            this.bWS.aFS.setNeedAddReplyIcon(true);
        }
        this.dgE = (RelativeLayout) view.findViewById(e.g.card_home_page_normal_thread_root);
        this.dJC = new com.baidu.tieba.frs.vc.g(this.mPageContext, this.dgE);
        this.dJC.setUniqueId(getTag());
        this.cKD = (ThreadGodReplyLayout) view.findViewById(e.g.card_frs_god_reply_layout);
        this.cKD.setOnClickListener(this.cKG);
        this.cOT = (TbImageView) view.findViewById(e.g.frs_normal_item_theme_card);
        this.cOT.setPageId(getTag());
        this.cOV = (TbImageView) view.findViewById(e.g.frs_normal_item_star_view);
        if (this.cOV != null) {
            this.cOV.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(e.g.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bWf != null) {
                    e.this.bWf.changeSelectStatus();
                }
            }
        });
        this.bWf.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.e.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void br(boolean z) {
                if (e.this.mMaskView != null) {
                    e.this.mMaskView.setBackgroundColor(al.getColor(z ? e.d.cp_bg_line_d : e.d.transparent));
                }
            }
        });
        this.bXd = (LinearLayout) view.findViewById(e.g.card_home_page_normal_thread_content_layout);
        this.dJO = (AppletsCellView) view.findViewById(e.g.card_home_page_normal_thread_share_info);
    }

    public ThreadCommentAndPraiseInfoLayout aaX() {
        return this.bWf;
    }

    public ThreadCommentAndPraiseInfoLayout aaY() {
        if (this.bWS != null) {
            return this.bWS.aFS;
        }
        return null;
    }

    public void setSingleImageRatio(double d) {
        if (this.cNn != null) {
            this.cNn.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cNn != null) {
            this.cNn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cNn != null) {
            this.cNn.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.j(this.buH, e.d.cp_bg_line_e);
            this.cNn.onChangeSkinType();
            this.bWf.onChangeSkinType();
            this.bWe.onChangeSkinType();
            this.dJC.onChangeSkinType();
            if (this.bWS != null && this.bWS.getVisibility() == 0) {
                this.bWS.onChangeSkinType();
            }
            if (this.dJO != null) {
                this.dJO.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(final bb bbVar) {
        if (bbVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aAQ = bbVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cKG);
        }
        this.cKD.onChangeSkinType();
        if (!anS() && o.me(this.aAQ.getId())) {
            o.a(this.mTitle, this.aAQ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cNm, this.aAQ.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cKD.getGodReplyContent(), this.aAQ.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
        }
        Q(bbVar);
        this.dJC.af(this.aAQ);
        N(bbVar);
        this.bWe.setData(this.aAQ);
        this.cKD.setFromCDN(this.aAb);
        this.cKD.setData(this.aAQ.zM());
        this.bWe.setUserAfterClickListener(this.aGk);
        ik(hb(1));
        if (this.bWe.getHeaderImg() != null) {
            if (this.bWe.getIsSimpleThread()) {
                this.bWe.getHeaderImg().setVisibility(8);
                this.bWP.setVisibility(8);
            } else if (bbVar.yv() == null || bbVar.yv().getPendantData() == null || StringUtils.isNull(bbVar.yv().getPendantData().xf())) {
                this.bWP.setVisibility(8);
                this.bWe.getHeaderImg().setVisibility(0);
                this.bWe.getHeaderImg().setData(bbVar);
            } else {
                this.bWe.getHeaderImg().setVisibility(4);
                this.bWP.setVisibility(0);
                this.bWP.setData(bbVar);
            }
        }
        L(bbVar);
        M(bbVar);
        this.dJO.setData(bbVar.zb());
        this.dJO.setForumId(String.valueOf(bbVar.getFid()));
        AppletsCellView appletsCellView = this.dJO;
        AppletsCellView appletsCellView2 = this.dJO;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> yK = bbVar.yK();
        if (v.J(yK)) {
            this.cNk.setVisibility(8);
        } else {
            this.cNk.bDm();
            this.cNk.setVisibility(0);
            VoiceData.VoiceModel voiceModel = yK.get(0);
            this.cNk.setVoiceModel(voiceModel);
            this.cNk.setTag(voiceModel);
            this.cNk.aUR();
            if (voiceModel != null) {
                this.cNk.pJ(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> yG = bbVar.yG();
        if (com.baidu.tbadk.core.i.ws().ww() && v.I(yG) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < yG.size(); i++) {
                MediaData mediaData = (MediaData) v.d(yG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.I(linkedList) > 0) {
                this.cNn.setVisibility(0);
                this.cNn.setFromCDN(this.aAb);
                this.cNn.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.frs.entelechy.view.e.3
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i2, boolean z) {
                        ad<bb> anO = e.this.anO();
                        if (z) {
                            if (anO != null) {
                                view.setTag("1");
                                anO.brz = true;
                                anO.a(view, e.this.aAQ);
                            }
                            e.this.fb(false);
                            return;
                        }
                        if (anO != null) {
                            view.setTag("1");
                            anO.brz = false;
                            anO.a(view, e.this.aAQ);
                        }
                        e.this.a(view, linkedList, i2, bbVar);
                    }
                });
                this.cNn.setImageMediaList(linkedList);
            } else {
                this.cNn.setVisibility(8);
            }
        } else {
            this.cNn.setVisibility(8);
        }
        aog();
        aoh();
        aDc();
        if (this.bWf.isInFrsAllThread() && com.baidu.tieba.frs.a.ayM().ayN()) {
            this.mMaskView.setVisibility(0);
            if (this.aAQ.zW() || this.aAQ.zX()) {
                al.j(this.mMaskView, e.d.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(e.d.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aog() {
        if (this.cNl != null && this.cNn != null && this.cKD != null) {
            if (this.cNn.getVisibility() == 8 && this.cKD.getVisibility() == 8 && this.dJO.getVisibility() == 8) {
                this.cNl.setVisibility(0);
            } else {
                this.cNl.setVisibility(8);
            }
        }
    }

    private void N(final bb bbVar) {
        if (this.cOV != null) {
            if (this.cOT == null || bbVar == null) {
                this.cOV.setVisibility(8);
            } else if (!StringUtils.isNull(bbVar.arh) && this.cOT.getVisibility() != 0) {
                if (this.dJC != null && this.dJC.aGk() && (this.cOV.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cOV.getLayoutParams();
                    layoutParams.rightMargin = l.h(this.mPageContext.getPageActivity(), e.C0175e.tbds106);
                    this.cOV.setLayoutParams(layoutParams);
                }
                this.cOV.setVisibility(0);
                this.cOV.setImageDrawable(null);
                this.cOV.startLoad(bbVar.arh, 10, false);
                this.cOV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.mPageContext != null) {
                            e.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(e.this.mTbPageContext.getContext(), "", bbVar.ari, true)));
                        }
                        TiebaStatic.log(new am("c12883"));
                    }
                });
            } else {
                this.cOV.setVisibility(8);
            }
        }
    }

    public void Q(bb bbVar) {
        MetaData yv;
        if (bbVar != null && this.cOT != null && (yv = bbVar.yv()) != null) {
            final ThemeCardInUserData themeCard = yv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.cOT.setVisibility(8);
                return;
            }
            this.cOT.setVisibility(0);
            this.cOT.setImageDrawable(null);
            this.cOT.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.cOT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.e.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(e.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.aAb ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bbVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.J(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.yB(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aAb, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
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

    private void aoh() {
        this.cNk.setClickable(true);
        int childCount = this.cNn.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cNn.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aAb = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bWf != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bWe != null) {
            this.bWe.setPageUniqueId(bdUniqueId);
        }
        if (this.cNn != null) {
            this.cNn.setPageUniqueId(bdUniqueId);
        }
    }

    protected void fb(boolean z) {
        if (this.aAQ != null) {
            o.md(this.aAQ.getId());
            o.a(this.mTitle, this.aAQ.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
            o.a(this.cNm, this.aAQ.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
            o.a(this.cKD.getGodReplyContent(), this.aAQ.getId(), e.d.cp_cont_f, e.d.cp_cont_d);
            m zq = this.aAQ.zq();
            if (zq != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ba.bH(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), zq.getCartoonId(), zq.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.j jVar = this.aAQ.aqC;
            if (this.aAQ.aqB == 1 && jVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = jVar.ama;
                long j = jVar.amb;
                ak akVar = new ak();
                akVar.pageContext = this.mPageContext;
                akVar.amo = str;
                akVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, akVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.aAQ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.aAQ.zm() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean anS() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void ii(int i) {
        this.currentPageType = i;
        if (this.bWf != null) {
            this.bWf.ary = i;
            if (i == 15) {
                this.bWf.setFrom(10);
            } else {
                this.bWf.setFrom(2);
                this.bWf.setDisPraiseFrom(2);
            }
        }
        if (this.bWe != null) {
            if (i == 15) {
                this.bWe.setFrom(5);
            } else {
                this.bWe.setFrom(3);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.cNk != null) {
            this.cNk.setVoiceManager(voiceManager);
        }
    }

    private boolean L(bb bbVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dJN)) {
            bbVar.ai(this.mUrl, this.dJN);
        }
        SpannableStringBuilder i = bbVar.i(false, true);
        if (i == null || StringUtils.isNull(i.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(i));
            this.mTitle.setText(i);
            o.a(this.mTitle, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        }
        return true;
    }

    private void M(bb bbVar) {
        if (bbVar != null && hb(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.dJN)) {
                bbVar.ai(this.mUrl, this.dJN);
            }
            SpannableString zO = bbVar.zO();
            if (zO != null && !ao.isEmpty(zO.toString())) {
                this.cNm.setVisibility(0);
                this.cNm.setOnTouchListener(new k(zO));
                this.cNm.setText(zO);
                o.a(this.cNm, bbVar.getId(), e.d.cp_cont_j, e.d.cp_cont_d);
                return;
            }
            this.cNm.setVisibility(8);
            return;
        }
        this.cNm.setVisibility(8);
    }

    private void aDc() {
        if (this.mTitle != null && this.cNk != null && this.cNn != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNk.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds20);
            this.cNk.setLayoutParams(layoutParams);
            if (this.cNk.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cNn.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds28);
                this.cNn.setLayoutParams(layoutParams2);
            }
        }
    }

    public void ik(int i) {
        if (this.aAQ != null) {
            if (i == 1) {
                this.bWf.setVisibility(8);
                if (this.bWS != null) {
                    this.bWS.setData(this.aAQ);
                    return;
                }
                return;
            }
            this.bWf.setData(this.aAQ);
            if (this.bWS != null) {
                this.bWS.setVisibility(8);
            }
        }
    }

    public void ai(String str, String str2) {
        this.mUrl = str;
        this.dJN = str2;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bVS = str;
    }

    public int hb(int i) {
        return com.baidu.tieba.a.d.Ux().M(this.bVS, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.cNn != null) {
            this.cNn.setPreloadSizeReadyCallback(bVar);
        }
    }
}
