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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
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
    private TextView FK;
    protected bh FT;
    private String GC;
    private final View.OnClickListener HO;
    protected boolean HY;
    private AppletsCellView IU;
    private PlayVoiceBntNew Ii;
    private RelativeLayout aqs;
    public ThreadUserInfoLayout dTq;
    protected ThreadCommentAndPraiseInfoLayout dTr;
    protected ThreadSourceShareAndPraiseLayout dUf;
    public LinearLayout dUq;
    protected View deR;
    private ThreadGodReplyLayout eMG;
    private HeadPendantClickableView eMH;
    protected View eNg;
    protected ConstrainImageGroup eNi;
    private View.OnClickListener eNn;
    private final View.OnClickListener eNo;
    public TbImageView eOQ;
    private TbImageView eOS;
    private String fFG;
    private g fFw;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.HY = true;
        this.eNn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.biW().biX()) {
                    if (c.this.dTr != null) {
                        c.this.dTr.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.aZX() != null) {
                    c.this.aZX().a(view, c.this.FT);
                }
                c.this.iF(view == c.this.eMG);
            }
        };
        this.eNo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bh> aZX = c.this.aZX();
                if (aZX != null) {
                    view.setTag("2");
                    aZX.a(view, c.this.FT);
                }
            }
        };
        this.HO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZX() != null) {
                    c.this.aZX().a(view, c.this.FT);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.eMH = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.eMH.getHeadView() != null) {
            this.eMH.getHeadView().setIsRound(true);
            this.eMH.getHeadView().setDrawBorder(false);
            this.eMH.getHeadView().setDefaultResource(17170445);
            this.eMH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eMH.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.eMH.setHasPendantStyle();
        if (this.eMH.getPendantView() != null) {
            this.eMH.getPendantView().setIsRound(true);
            this.eMH.getPendantView().setDrawBorder(false);
        }
        this.eMH.setAfterClickListener(this.HO);
        this.deR = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.Ii = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.Ii.setAfterClickListener(this.eNo);
        this.FK = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.FK.setVisibility(8);
        this.eNg = view.findViewById(R.id.divider_line_above_praise);
        this.eNi = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.eNi.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eNi.setChildClickListener(this.eNn);
        f fVar = new f(3);
        fVar.g(1.0d);
        this.eNi.setImageProcessor(fVar);
        this.dTr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.dTq = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.dTq.setUserAfterClickListener(this.HO);
        this.dTq.setFrom(3);
        this.dTr.setOnClickListener(this.eNn);
        this.dTr.setForumAfterClickListener(this.HO);
        this.dTr.setReplyTimeVisible(false);
        this.dTr.setShowPraiseNum(true);
        this.dTr.setNeedAddPraiseIcon(true);
        this.dTr.setNeedAddReplyIcon(true);
        this.dTr.setIsBarViewVisible(false);
        this.dTr.setShareVisible(true);
        this.dTr.setShareReportFrom(1);
        this.dTr.setStType("frs_page");
        this.dTr.setFrom(2);
        this.dTr.setDisPraiseFrom(2);
        this.dTr.cqT = 3;
        this.dUf = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.dUf != null) {
            this.dUf.crO.setOnClickListener(this.eNn);
            this.dUf.setFrom(2);
            this.dUf.setShareReportFrom(1);
            this.dUf.setSourceFromForPb(3);
            this.dUf.setStType("frs_page");
            this.dUf.setHideBarName(true);
            this.dUf.crO.setNeedAddReplyIcon(true);
        }
        this.aqs = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.fFw = new g(this.mPageContext, this.aqs);
        this.fFw.setUniqueId(getTag());
        this.eMG = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.eMG.setOnClickListener(this.eNn);
        this.eOQ = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.eOQ.setPageId(getTag());
        this.eOS = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.eOS != null) {
            this.eOS.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dTr != null) {
                    c.this.dTr.changeSelectStatus();
                }
            }
        });
        this.dTr.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void ev(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.dUq = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.IU = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.eNi != null) {
            this.eNi.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eNi != null) {
            this.eNi.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eNi != null) {
            this.eNi.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.deR, R.color.cp_bg_line_c);
            this.eNi.onChangeSkinType();
            this.dTr.onChangeSkinType();
            this.dTq.onChangeSkinType();
            if (this.IU != null) {
                this.IU.onChangeSkinType();
            }
            this.fFw.onChangeSkinType();
            if (this.dUf != null && this.dUf.getVisibility() == 0) {
                this.dUf.onChangeSkinType();
            }
            if (this.eMH != null && this.eMH.getHeadView() != null && (this.eMH.getHeadView() instanceof TbImageView)) {
                this.eMH.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
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
        this.FT = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eNn);
        }
        this.eMG.onChangeSkinType();
        if (!bah() && n.uA(this.FT.getId())) {
            n.a(this.mTitle, this.FT.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.FK, this.FT.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.eMG.getGodReplyContent(), this.FT.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bhVar);
        this.fFw.am(this.FT);
        R(bhVar);
        this.dTq.setData(this.FT);
        this.eMG.setFromCDN(this.HY);
        this.eMG.setData(this.FT.akd());
        this.dTq.setUserAfterClickListener(this.HO);
        mZ(ly(1));
        if (this.dTq.getHeaderImg() != null) {
            if (this.dTq.getIsSimpleThread()) {
                this.dTq.getHeaderImg().setVisibility(8);
                this.eMH.setVisibility(8);
            } else if (bhVar.aiG() == null || bhVar.aiG().getPendantData() == null || StringUtils.isNull(bhVar.aiG().getPendantData().ahf())) {
                this.eMH.setVisibility(8);
                this.dTq.getHeaderImg().setVisibility(0);
                this.dTq.getHeaderImg().setData(bhVar);
            } else {
                this.dTq.getHeaderImg().setVisibility(4);
                this.eMH.setVisibility(0);
                this.eMH.setData(bhVar);
            }
        }
        ag(bhVar);
        ah(bhVar);
        this.IU.setData(bhVar.ajs());
        this.IU.setForumId(String.valueOf(bhVar.getFid()));
        AppletsCellView appletsCellView = this.IU;
        AppletsCellView appletsCellView2 = this.IU;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aiU = bhVar.aiU();
        if (v.isEmpty(aiU)) {
            this.Ii.setVisibility(8);
        } else {
            this.Ii.cpC();
            this.Ii.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aiU.get(0);
            this.Ii.setVoiceModel(voiceModel);
            this.Ii.setTag(voiceModel);
            this.Ii.bnq();
            if (voiceModel != null) {
                this.Ii.uK(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        if (i.agq().isShowImages() && v.getCount(aiQ) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aiQ.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiQ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.eNi.setVisibility(0);
                this.eNi.setFromCDN(this.HY);
                this.eNi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        ab<bh> aZX = c.this.aZX();
                        if (z) {
                            if (aZX != null) {
                                view.setTag("1");
                                aZX.HC = true;
                                aZX.a(view, c.this.FT);
                            }
                            c.this.iF(false);
                            return;
                        }
                        if (aZX != null) {
                            view.setTag("1");
                            aZX.HC = false;
                            aZX.a(view, c.this.FT);
                        }
                        c.this.a(view, linkedList, i2, bhVar);
                    }
                });
                this.eNi.setImageMediaList(linkedList);
            } else {
                this.eNi.setVisibility(8);
            }
        } else {
            this.eNi.setVisibility(8);
        }
        bap();
        baq();
        bns();
        if (this.dTr.isInFrsAllThread() && com.baidu.tieba.frs.a.biW().biX()) {
            this.mMaskView.setVisibility(0);
            if (this.FT.ako() || this.FT.akp()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void bap() {
        if (this.eNg != null && this.eNi != null && this.eMG != null) {
            if (this.eNi.getVisibility() == 8 && this.eMG.getVisibility() == 8 && this.IU.getVisibility() == 8) {
                this.eNg.setVisibility(0);
            } else {
                this.eNg.setVisibility(8);
            }
        }
    }

    private void R(final bh bhVar) {
        if (this.eOS != null) {
            if (this.eOQ == null || bhVar == null) {
                this.eOS.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.ced) && this.eOQ.getVisibility() != 0) {
                if (this.fFw != null && this.fFw.bqL() && (this.eOS.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eOS.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.eOS.setLayoutParams(layoutParams);
                }
                this.eOS.setVisibility(0);
                this.eOS.setImageDrawable(null);
                this.eOS.startLoad(bhVar.ced, 10, false);
                this.eOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bhVar.cee, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.eOS.setVisibility(8);
            }
        }
    }

    public void b(bh bhVar) {
        MetaData aiG;
        if (bhVar != null && this.eOQ != null && (aiG = bhVar.aiG()) != null) {
            final ThemeCardInUserData themeCard = aiG.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.eOQ.setVisibility(8);
                return;
            }
            this.eOQ.setVisibility(0);
            this.eOQ.setImageDrawable(null);
            this.eOQ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.eOQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
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
                imageUrlData.urlType = this.HY ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(bhVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!v.isEmpty(arrayList)) {
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aiL(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.HY, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bhVar.getId();
            historyMessage.threadName = bhVar.getTitle();
            historyMessage.forumName = bhVar.aiL();
            historyMessage.postID = bhVar.aiW();
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

    private void baq() {
        this.Ii.setClickable(true);
        int childCount = this.eNi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eNi.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dTr != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dTq != null) {
            this.dTq.setPageUniqueId(bdUniqueId);
        }
        if (this.eNi != null) {
            this.eNi.setPageUniqueId(bdUniqueId);
        }
    }

    protected void iF(boolean z) {
        if (this.FT != null) {
            n.uz(this.FT.getId());
            n.a(this.mTitle, this.FT.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.FK, this.FT.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.eMG.getGodReplyContent(), this.FT.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            o ajJ = this.FT.ajJ();
            if (ajJ != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ajJ.getCartoonId(), ajJ.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.FT.cdt;
            if (this.FT.cds == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.bYi;
                long j = lVar.bYj;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.mPageContext;
                amVar.bYw = str;
                amVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, amVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.FT, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.FT.ajF() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean bah() {
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
    public void mX(int i) {
        this.currentPageType = i;
        if (this.dTr != null) {
            this.dTr.cqT = i;
            if (i == 15) {
                this.dTr.setFrom(10);
            } else {
                this.dTr.setFrom(2);
                this.dTr.setDisPraiseFrom(2);
            }
        }
        if (this.dTq != null) {
            if (i == 15) {
                this.dTq.setFrom(5);
            } else {
                this.dTq.setFrom(3);
            }
        }
    }

    private boolean ag(bh bhVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fFG)) {
            bhVar.bI(this.mUrl, this.fFG);
        }
        SpannableStringBuilder s = bhVar.s(false, true);
        if (s == null || StringUtils.isNull(s.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(s));
            this.mTitle.setText(s);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void ah(bh bhVar) {
        if (bhVar != null && ly(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fFG)) {
                bhVar.bI(this.mUrl, this.fFG);
            }
            SpannableString akg = bhVar.akg();
            if (akg != null && !aq.isEmpty(akg.toString())) {
                this.FK.setVisibility(0);
                this.FK.setOnTouchListener(new k(akg));
                this.FK.setText(akg);
                n.a(this.FK, bhVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.FK.setVisibility(8);
            return;
        }
        this.FK.setVisibility(8);
    }

    private void bns() {
        if (this.mTitle != null && this.Ii != null && this.eNi != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ii.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.Ii.setLayoutParams(layoutParams);
            if (this.Ii.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eNi.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.eNi.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mZ(int i) {
        if (this.FT != null) {
            if (i == 1) {
                this.dTr.setVisibility(8);
                if (this.dUf != null) {
                    this.dUf.setData(this.FT);
                    return;
                }
                return;
            }
            this.dTr.setData(this.FT);
            if (this.dUf != null) {
                this.dUf.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.GC = str;
    }

    public int ly(int i) {
        return com.baidu.tieba.a.d.aDe().X(this.GC, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eNi != null) {
            this.eNi.setPreloadSizeReadyCallback(bVar);
        }
    }
}
