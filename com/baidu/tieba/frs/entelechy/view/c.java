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
    private TextView Fk;
    protected bh Fs;
    private String Gc;
    private PlayVoiceBntNew HH;
    private final View.OnClickListener Ho;
    protected boolean Hx;
    private AppletsCellView Ir;
    private RelativeLayout aqa;
    protected ThreadCommentAndPraiseInfoLayout dSA;
    public ThreadUserInfoLayout dSz;
    protected ThreadSourceShareAndPraiseLayout dTo;
    public LinearLayout dTz;
    protected View ddZ;
    private ThreadGodReplyLayout eLP;
    private HeadPendantClickableView eLQ;
    protected View eMp;
    protected ConstrainImageGroup eMr;
    private View.OnClickListener eMw;
    private final View.OnClickListener eMx;
    public TbImageView eNZ;
    private TbImageView eOb;
    private g fEF;
    private String fEP;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.Hx = true;
        this.eMw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.a.biU().biV()) {
                    if (c.this.dSA != null) {
                        c.this.dSA.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.aZV() != null) {
                    c.this.aZV().a(view, c.this.Fs);
                }
                c.this.iF(view == c.this.eLP);
            }
        };
        this.eMx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bh> aZV = c.this.aZV();
                if (aZV != null) {
                    view.setTag("2");
                    aZV.a(view, c.this.Fs);
                }
            }
        };
        this.Ho = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aZV() != null) {
                    c.this.aZV().a(view, c.this.Fs);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.eLQ = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.eLQ.getHeadView() != null) {
            this.eLQ.getHeadView().setIsRound(true);
            this.eLQ.getHeadView().setDrawBorder(false);
            this.eLQ.getHeadView().setDefaultResource(17170445);
            this.eLQ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eLQ.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.eLQ.setHasPendantStyle();
        if (this.eLQ.getPendantView() != null) {
            this.eLQ.getPendantView().setIsRound(true);
            this.eLQ.getPendantView().setDrawBorder(false);
        }
        this.eLQ.setAfterClickListener(this.Ho);
        this.ddZ = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.HH = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.HH.setAfterClickListener(this.eMx);
        this.Fk = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.Fk.setVisibility(8);
        this.eMp = view.findViewById(R.id.divider_line_above_praise);
        this.eMr = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.eMr.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eMr.setChildClickListener(this.eMw);
        f fVar = new f(3);
        fVar.g(1.0d);
        this.eMr.setImageProcessor(fVar);
        this.dSA = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.dSz = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.dSz.setUserAfterClickListener(this.Ho);
        this.dSz.setFrom(3);
        this.dSA.setOnClickListener(this.eMw);
        this.dSA.setForumAfterClickListener(this.Ho);
        this.dSA.setReplyTimeVisible(false);
        this.dSA.setShowPraiseNum(true);
        this.dSA.setNeedAddPraiseIcon(true);
        this.dSA.setNeedAddReplyIcon(true);
        this.dSA.setIsBarViewVisible(false);
        this.dSA.setShareVisible(true);
        this.dSA.setShareReportFrom(1);
        this.dSA.setStType("frs_page");
        this.dSA.setFrom(2);
        this.dSA.setDisPraiseFrom(2);
        this.dSA.cqc = 3;
        this.dTo = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.dTo != null) {
            this.dTo.cqW.setOnClickListener(this.eMw);
            this.dTo.setFrom(2);
            this.dTo.setShareReportFrom(1);
            this.dTo.setSourceFromForPb(3);
            this.dTo.setStType("frs_page");
            this.dTo.setHideBarName(true);
            this.dTo.cqW.setNeedAddReplyIcon(true);
        }
        this.aqa = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.fEF = new g(this.mPageContext, this.aqa);
        this.fEF.setUniqueId(getTag());
        this.eLP = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.eLP.setOnClickListener(this.eMw);
        this.eNZ = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.eNZ.setPageId(getTag());
        this.eOb = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.eOb != null) {
            this.eOb.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dSA != null) {
                    c.this.dSA.changeSelectStatus();
                }
            }
        });
        this.dSA.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
            public void ev(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(am.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.dTz = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.Ir = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.eMr != null) {
            this.eMr.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eMr != null) {
            this.eMr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eMr != null) {
            this.eMr.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.ddZ, R.color.cp_bg_line_c);
            this.eMr.onChangeSkinType();
            this.dSA.onChangeSkinType();
            this.dSz.onChangeSkinType();
            if (this.Ir != null) {
                this.Ir.onChangeSkinType();
            }
            this.fEF.onChangeSkinType();
            if (this.dTo != null && this.dTo.getVisibility() == 0) {
                this.dTo.onChangeSkinType();
            }
            if (this.eLQ != null && this.eLQ.getHeadView() != null && (this.eLQ.getHeadView() instanceof TbImageView)) {
                this.eLQ.getHeadView().setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
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
        this.Fs = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eMw);
        }
        this.eLP.onChangeSkinType();
        if (!baf() && n.uA(this.Fs.getId())) {
            n.a(this.mTitle, this.Fs.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.Fk, this.Fs.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.eLP.getGodReplyContent(), this.Fs.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
        }
        b(bhVar);
        this.fEF.am(this.Fs);
        R(bhVar);
        this.dSz.setData(this.Fs);
        this.eLP.setFromCDN(this.Hx);
        this.eLP.setData(this.Fs.akb());
        this.dSz.setUserAfterClickListener(this.Ho);
        mY(lx(1));
        if (this.dSz.getHeaderImg() != null) {
            if (this.dSz.getIsSimpleThread()) {
                this.dSz.getHeaderImg().setVisibility(8);
                this.eLQ.setVisibility(8);
            } else if (bhVar.aiE() == null || bhVar.aiE().getPendantData() == null || StringUtils.isNull(bhVar.aiE().getPendantData().ahd())) {
                this.eLQ.setVisibility(8);
                this.dSz.getHeaderImg().setVisibility(0);
                this.dSz.getHeaderImg().setData(bhVar);
            } else {
                this.dSz.getHeaderImg().setVisibility(4);
                this.eLQ.setVisibility(0);
                this.eLQ.setData(bhVar);
            }
        }
        ag(bhVar);
        ah(bhVar);
        this.Ir.setData(bhVar.ajq());
        this.Ir.setForumId(String.valueOf(bhVar.getFid()));
        AppletsCellView appletsCellView = this.Ir;
        AppletsCellView appletsCellView2 = this.Ir;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> aiS = bhVar.aiS();
        if (v.isEmpty(aiS)) {
            this.HH.setVisibility(8);
        } else {
            this.HH.cpA();
            this.HH.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aiS.get(0);
            this.HH.setVoiceModel(voiceModel);
            this.HH.setTag(voiceModel);
            this.HH.bno();
            if (voiceModel != null) {
                this.HH.uJ(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> aiO = bhVar.aiO();
        if (i.ago().isShowImages() && v.getCount(aiO) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aiO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.eMr.setVisibility(0);
                this.eMr.setFromCDN(this.Hx);
                this.eMr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        ab<bh> aZV = c.this.aZV();
                        if (z) {
                            if (aZV != null) {
                                view.setTag("1");
                                aZV.Hc = true;
                                aZV.a(view, c.this.Fs);
                            }
                            c.this.iF(false);
                            return;
                        }
                        if (aZV != null) {
                            view.setTag("1");
                            aZV.Hc = false;
                            aZV.a(view, c.this.Fs);
                        }
                        c.this.a(view, linkedList, i2, bhVar);
                    }
                });
                this.eMr.setImageMediaList(linkedList);
            } else {
                this.eMr.setVisibility(8);
            }
        } else {
            this.eMr.setVisibility(8);
        }
        ban();
        bao();
        bnq();
        if (this.dSA.isInFrsAllThread() && com.baidu.tieba.frs.a.biU().biV()) {
            this.mMaskView.setVisibility(0);
            if (this.Fs.akm() || this.Fs.akn()) {
                am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void ban() {
        if (this.eMp != null && this.eMr != null && this.eLP != null) {
            if (this.eMr.getVisibility() == 8 && this.eLP.getVisibility() == 8 && this.Ir.getVisibility() == 8) {
                this.eMp.setVisibility(0);
            } else {
                this.eMp.setVisibility(8);
            }
        }
    }

    private void R(final bh bhVar) {
        if (this.eOb != null) {
            if (this.eNZ == null || bhVar == null) {
                this.eOb.setVisibility(8);
            } else if (!StringUtils.isNull(bhVar.cdm) && this.eNZ.getVisibility() != 0) {
                if (this.fEF != null && this.fEF.bqJ() && (this.eOb.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eOb.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.eOb.setLayoutParams(layoutParams);
                }
                this.eOb.setVisibility(0);
                this.eOb.setImageDrawable(null);
                this.eOb.startLoad(bhVar.cdm, 10, false);
                this.eOb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bhVar.cdn, true)));
                        }
                        TiebaStatic.log(new an(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.eOb.setVisibility(8);
            }
        }
    }

    public void b(bh bhVar) {
        MetaData aiE;
        if (bhVar != null && this.eNZ != null && (aiE = bhVar.aiE()) != null) {
            final ThemeCardInUserData themeCard = aiE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.eNZ.setVisibility(8);
                return;
            }
            this.eNZ.setVisibility(0);
            this.eNZ.setImageDrawable(null);
            this.eNZ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.eNZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
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
                imageUrlData.urlType = this.Hx ? 13 : 14;
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
            ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aiJ(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Hx, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
            createConfig.getIntent().putExtra("from", "frs");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bhVar.getId();
            historyMessage.threadName = bhVar.getTitle();
            historyMessage.forumName = bhVar.aiJ();
            historyMessage.postID = bhVar.aiU();
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

    private void bao() {
        this.HH.setClickable(true);
        int childCount = this.eMr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eMr.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.dSA != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dSz != null) {
            this.dSz.setPageUniqueId(bdUniqueId);
        }
        if (this.eMr != null) {
            this.eMr.setPageUniqueId(bdUniqueId);
        }
    }

    protected void iF(boolean z) {
        if (this.Fs != null) {
            n.uz(this.Fs.getId());
            n.a(this.mTitle, this.Fs.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.Fk, this.Fs.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            n.a(this.eLP.getGodReplyContent(), this.Fs.getId(), (int) R.color.cp_cont_f, (int) R.color.cp_cont_d);
            o ajH = this.Fs.ajH();
            if (ajH != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bc.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), ajH.getCartoonId(), ajH.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.Fs.ccC;
            if (this.Fs.ccB == 1 && lVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.bXr;
                long j = lVar.bXs;
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.pageContext = this.mPageContext;
                amVar.bXF = str;
                amVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, amVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.Fs, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.Fs.ajD() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean baf() {
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
    public void mW(int i) {
        this.currentPageType = i;
        if (this.dSA != null) {
            this.dSA.cqc = i;
            if (i == 15) {
                this.dSA.setFrom(10);
            } else {
                this.dSA.setFrom(2);
                this.dSA.setDisPraiseFrom(2);
            }
        }
        if (this.dSz != null) {
            if (i == 15) {
                this.dSz.setFrom(5);
            } else {
                this.dSz.setFrom(3);
            }
        }
    }

    private boolean ag(bh bhVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fEP)) {
            bhVar.bI(this.mUrl, this.fEP);
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
        if (bhVar != null && lx(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.fEP)) {
                bhVar.bI(this.mUrl, this.fEP);
            }
            SpannableString ake = bhVar.ake();
            if (ake != null && !aq.isEmpty(ake.toString())) {
                this.Fk.setVisibility(0);
                this.Fk.setOnTouchListener(new k(ake));
                this.Fk.setText(ake);
                n.a(this.Fk, bhVar.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
                return;
            }
            this.Fk.setVisibility(8);
            return;
        }
        this.Fk.setVisibility(8);
    }

    private void bnq() {
        if (this.mTitle != null && this.HH != null && this.eMr != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HH.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.HH.setLayoutParams(layoutParams);
            if (this.HH.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eMr.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.eMr.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mY(int i) {
        if (this.Fs != null) {
            if (i == 1) {
                this.dSA.setVisibility(8);
                if (this.dTo != null) {
                    this.dTo.setData(this.Fs);
                    return;
                }
                return;
            }
            this.dSA.setData(this.Fs);
            if (this.dTo != null) {
                this.dTo.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Gc = str;
    }

    public int lx(int i) {
        return com.baidu.tieba.a.d.aDc().X(this.Gc, i);
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eMr != null) {
            this.eMr.setPreloadSizeReadyCallback(bVar);
        }
    }
}
