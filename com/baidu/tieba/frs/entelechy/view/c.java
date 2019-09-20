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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.vc.g;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<bh> implements com.baidu.tieba.a.e, z {
    private TextView VV;
    private String WM;
    protected bh Wd;
    private final View.OnClickListener XU;
    private AppletsCellView YV;
    protected boolean Yd;
    private PlayVoiceBntNew Ym;
    protected View cVw;
    public ThreadUserInfoLayout dGs;
    protected ThreadCommentAndPraiseInfoLayout dGt;
    protected ThreadSourceShareAndPraiseLayout dHg;
    public LinearLayout dHr;
    private ThreadGodReplyLayout eDZ;
    protected View eEA;
    protected ConstrainImageGroup eEC;
    private View.OnClickListener eEH;
    private final View.OnClickListener eEI;
    private HeadPendantClickableView eEa;
    public TbImageView eGj;
    private TbImageView eGl;
    private RelativeLayout ewL;
    private g fGf;
    private String fGp;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Yd = true;
        this.eEH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.blQ().blR()) {
                    if (c.this.dGt != null) {
                        c.this.dGt.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.aZU() != null) {
                    c.this.aZU().a(view, c.this.Wd);
                }
                c.this.iC(view == c.this.eDZ);
            }
        };
        this.eEI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bh> aZU = c.this.aZU();
                if (aZU != null) {
                    view.setTag("2");
                    aZU.a(view, c.this.Wd);
                }
            }
        };
        this.XU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZU() != null) {
                    c.this.aZU().a(view, c.this.Wd);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.eEa = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.eEa.getHeadView() != null) {
            this.eEa.getHeadView().setIsRound(true);
            this.eEa.getHeadView().setDrawBorder(false);
            this.eEa.getHeadView().setDefaultResource(17170445);
            this.eEa.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eEa.getHeadView().setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.eEa.setHasPendantStyle();
        if (this.eEa.getPendantView() != null) {
            this.eEa.getPendantView().setIsRound(true);
            this.eEa.getPendantView().setDrawBorder(false);
        }
        this.eEa.setAfterClickListener(this.XU);
        this.cVw = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.Ym = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.Ym.setAfterClickListener(this.eEI);
        this.VV = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.VV.setVisibility(8);
        this.eEA = view.findViewById(R.id.divider_line_above_praise);
        this.eEC = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.eEC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eEC.setChildClickListener(this.eEH);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.eEC.setImageProcessor(fVar);
        this.dGt = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.dGs = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.dGs.setUserAfterClickListener(this.XU);
        this.dGs.setFrom(3);
        this.dGt.setOnClickListener(this.eEH);
        this.dGt.setForumAfterClickListener(this.XU);
        this.dGt.setReplyTimeVisible(false);
        this.dGt.setShowPraiseNum(true);
        this.dGt.setNeedAddPraiseIcon(true);
        this.dGt.setNeedAddReplyIcon(true);
        this.dGt.setIsBarViewVisible(false);
        this.dGt.setShareVisible(true);
        this.dGt.setShareReportFrom(1);
        this.dGt.setStType("frs_page");
        this.dGt.setFrom(2);
        this.dGt.setDisPraiseFrom(2);
        this.dGt.ccG = 3;
        this.dHg = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.dHg != null) {
            this.dHg.cdA.setOnClickListener(this.eEH);
            this.dHg.setFrom(2);
            this.dHg.setShareReportFrom(1);
            this.dHg.setSourceFromForPb(3);
            this.dHg.setStType("frs_page");
            this.dHg.setHideBarName(true);
            this.dHg.cdA.setNeedAddReplyIcon(true);
        }
        this.ewL = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.fGf = new g(this.mPageContext, this.ewL);
        this.fGf.setUniqueId(getTag());
        this.eDZ = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.eDZ.setOnClickListener(this.eEH);
        this.eGj = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.eGj.setPageId(getTag());
        this.eGl = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.eGl != null) {
            this.eGl.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dGt != null) {
                    c.this.dGt.changeSelectStatus();
                }
            }
        });
        this.dGt.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void ex(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.dHr = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.YV = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.eEC != null) {
            this.eEC.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eEC != null) {
            this.eEC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eEC != null) {
            this.eEC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.addresslist_item_bg);
            am.l(this.cVw, R.color.cp_bg_line_c);
            this.eEC.onChangeSkinType();
            this.dGt.onChangeSkinType();
            this.dGs.onChangeSkinType();
            if (this.YV != null) {
                this.YV.onChangeSkinType();
            }
            this.fGf.onChangeSkinType();
            if (this.dHg != null && this.dHg.getVisibility() == 0) {
                this.dHg.onChangeSkinType();
            }
            if (this.eEa != null && this.eEa.getHeadView() != null && (this.eEa.getHeadView() instanceof TbImageView)) {
                this.eEa.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(final bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.Wd = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eEH);
        }
        this.eDZ.onChangeSkinType();
        if (!bae() && n.vX(this.Wd.getId())) {
            n.a(this.mTitle, this.Wd.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VV, this.Wd.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.eDZ.getGodReplyContent(), this.Wd.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bhVar);
        this.fGf.ao(this.Wd);
        T(bhVar);
        this.dGs.setData(this.Wd);
        this.eDZ.setFromCDN(this.Yd);
        this.eDZ.setData(this.Wd.aga());
        this.dGs.setUserAfterClickListener(this.XU);
        nJ(mt(1));
        if (this.dGs.getHeaderImg() != null) {
            if (this.dGs.getIsSimpleThread()) {
                this.dGs.getHeaderImg().setVisibility(8);
                this.eEa.setVisibility(8);
            } else if (bhVar.aeC() == null || bhVar.aeC().getPendantData() == null || StringUtils.isNull(bhVar.aeC().getPendantData().acZ())) {
                this.eEa.setVisibility(8);
                this.dGs.getHeaderImg().setVisibility(0);
                this.dGs.getHeaderImg().setData(bhVar);
            } else {
                this.dGs.getHeaderImg().setVisibility(4);
                this.eEa.setVisibility(0);
                this.eEa.setData(bhVar);
            }
        }
        ai(bhVar);
        aj(bhVar);
        this.YV.setData(bhVar.afo());
        this.YV.setForumId(String.valueOf(bhVar.getFid()));
        AppletsCellView appletsCellView = this.YV;
        AppletsCellView appletsCellView2 = this.YV;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aeQ = bhVar.aeQ();
        if (v.aa(aeQ)) {
            this.Ym.setVisibility(8);
        } else {
            this.Ym.crJ();
            this.Ym.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aeQ.get(0);
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bql();
            if (voiceModel != null) {
                this.Ym.we(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aeM = bhVar.aeM();
        if (i.ace().aci() && v.Z(aeM) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aeM.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeM, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.eEC.setVisibility(0);
                this.eEC.setFromCDN(this.Yd);
                this.eEC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bh> aZU = c.this.aZU();
                        if (z) {
                            if (aZU != null) {
                                view.setTag("1");
                                aZU.XI = true;
                                aZU.a(view, c.this.Wd);
                            }
                            c.this.iC(false);
                            return;
                        }
                        if (aZU != null) {
                            view.setTag("1");
                            aZU.XI = false;
                            aZU.a(view, c.this.Wd);
                        }
                        c.this.a(view, linkedList, i2, bhVar);
                    }
                });
                this.eEC.setImageMediaList(linkedList);
            } else {
                this.eEC.setVisibility(8);
            }
        } else {
            this.eEC.setVisibility(8);
        }
        bam();
        ban();
        bqn();
        if (this.dGt.isInFrsAllThread() && com.baidu.tieba.frs.a.blQ().blR()) {
            this.mMaskView.setVisibility(0);
            if (this.Wd.agl() || this.Wd.agm()) {
                am.l(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bam() {
        if (this.eEA != null && this.eEC != null && this.eDZ != null) {
            if (this.eEC.getVisibility() == 8 && this.eDZ.getVisibility() == 8 && this.YV.getVisibility() == 8) {
                this.eEA.setVisibility(0);
            } else {
                this.eEA.setVisibility(8);
            }
        }
    }

    private void T(final bh bhVar) {
        if (this.eGl != null) {
            if (this.eGj == null || bhVar == null) {
                this.eGl.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.bMu) && this.eGj.getVisibility() != 0) {
                if (this.fGf != null && this.fGf.btI() && (this.eGl.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eGl.getLayoutParams();
                    layoutParams.rightMargin = l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.eGl.setLayoutParams(layoutParams);
                }
                this.eGl.setVisibility(0);
                this.eGl.setImageDrawable(null);
                this.eGl.startLoad(bhVar.bMu, 10, false);
                this.eGl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bhVar.bMv, true)));
                        }
                        TiebaStatic.log(new an("c12883"));
                    }
                });
            } else {
                this.eGl.setVisibility(8);
            }
        }
    }

    public void b(bh bhVar) {
        MetaData aeC;
        if (bhVar != null && this.eGj != null && (aeC = bhVar.aeC()) != null) {
            final ThemeCardInUserData themeCard = aeC.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.eGj.setVisibility(8);
                return;
            }
            this.eGj.setVisibility(0);
            this.eGj.setImageDrawable(null);
            this.eGj.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.eGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.Yd ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.e(bhVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.aa(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aeH(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bhVar.getId();
            historyMessage.threadName = bhVar.getTitle();
            historyMessage.forumName = bhVar.aeH();
            historyMessage.postID = bhVar.aeS();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
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

    private void ban() {
        this.Ym.setClickable(true);
        int childCount = this.eEC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eEC.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dGt != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dGs != null) {
            this.dGs.setPageUniqueId(bdUniqueId);
        }
        if (this.eEC != null) {
            this.eEC.setPageUniqueId(bdUniqueId);
        }
    }

    protected void iC(boolean z) {
        if (this.Wd != null) {
            n.vW(this.Wd.getId());
            n.a(this.mTitle, this.Wd.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.VV, this.Wd.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.eDZ.getGodReplyContent(), this.Wd.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            o afF = this.Wd.afF();
            if (afF != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.cE(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), afF.getCartoonId(), afF.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.Wd.bLK;
            if (this.Wd.bLJ == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.bGx;
                long j = lVar.bGy;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.mPageContext;
                amVar.bGL = str;
                amVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001417, amVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.Wd, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.Wd.afB() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private boolean bae() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nH(int i) {
        this.currentPageType = i;
        if (this.dGt != null) {
            this.dGt.ccG = i;
            if (i == 15) {
                this.dGt.setFrom(10);
            } else {
                this.dGt.setFrom(2);
                this.dGt.setDisPraiseFrom(2);
            }
        }
        if (this.dGs != null) {
            if (i == 15) {
                this.dGs.setFrom(5);
            } else {
                this.dGs.setFrom(3);
            }
        }
    }

    private boolean ai(bh bhVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fGp)) {
            bhVar.bC(this.mUrl, this.fGp);
        }
        SpannableStringBuilder o = bhVar.o(false, true);
        if (o == null || StringUtils.isNull(o.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(o));
            this.mTitle.setText(o);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void aj(bh bhVar) {
        if (bhVar != null && mt(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fGp)) {
                bhVar.bC(this.mUrl, this.fGp);
            }
            SpannableString agd = bhVar.agd();
            if (agd != null && !aq.isEmpty(agd.toString())) {
                this.VV.setVisibility(0);
                this.VV.setOnTouchListener(new k(agd));
                this.VV.setText(agd);
                n.a(this.VV, bhVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.VV.setVisibility(8);
            return;
        }
        this.VV.setVisibility(8);
    }

    private void bqn() {
        if (this.mTitle != null && this.Ym != null && this.eEC != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ym.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.Ym.setLayoutParams(layoutParams);
            if (this.Ym.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eEC.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.eEC.setLayoutParams(layoutParams2);
            }
        }
    }

    public void nJ(int i) {
        if (this.Wd != null) {
            if (i == 1) {
                this.dGt.setVisibility(8);
                if (this.dHg != null) {
                    this.dHg.setData(this.Wd);
                    return;
                }
                return;
            }
            this.dGt.setData(this.Wd);
            if (this.dHg != null) {
                this.dHg.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WM = str;
    }

    public int mt(int i) {
        return com.baidu.tieba.a.d.aCV().ag(this.WM, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eEC != null) {
            this.eEC.setPreloadSizeReadyCallback(bVar);
        }
    }
}
