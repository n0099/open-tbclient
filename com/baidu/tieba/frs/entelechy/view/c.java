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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
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
import com.baidu.tieba.frs.vc.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<bw> implements com.baidu.tieba.a.e, z {
    private TextView agm;
    protected bw agx;
    private String ahu;
    private final View.OnClickListener ajG;
    protected boolean akk;
    private PlayVoiceBntNew akw;
    private AppletsCellView alA;
    private RelativeLayout byI;
    protected View fKv;
    public LinearLayout fSf;
    public ThreadUserInfoLayout gMr;
    protected ThreadCommentAndPraiseInfoLayout gMs;
    protected ThreadSourceShareAndPraiseLayout gNe;
    private ThreadGodReplyLayout hRJ;
    private HeadPendantClickableView hRK;
    protected View hSh;
    protected ConstrainImageGroup hSj;
    private View.OnClickListener hSo;
    private final View.OnClickListener hSp;
    public TbImageView hTS;
    private TbImageView hTU;
    private String iNJ;
    private i iNz;
    private String mForumName;
    private View mMaskView;
    protected TbPageContext<?> mPageContext;
    protected int mSkinType;
    private TextView mTitle;
    private String mUrl;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.akk = true;
        this.hSo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.frs.b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF()) {
                    if (c.this.gMs != null) {
                        c.this.gMs.changeSelectStatus();
                        return;
                    }
                    return;
                }
                if (c.this.cls() != null) {
                    c.this.cls().a(view, c.this.agx);
                }
                c.this.oj(view == c.this.hRJ);
            }
        };
        this.hSp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bw> cls = c.this.cls();
                if (cls != null) {
                    view.setTag("2");
                    cls.a(view, c.this.agx);
                }
            }
        };
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cls() != null) {
                    c.this.cls().a(view, c.this.agx);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.mPageContext = tbPageContext;
        this.currentPageType = 3;
        this.hRK = (HeadPendantClickableView) view.findViewById(R.id.card_home_page_normal_thread_user_pendant_header);
        if (this.hRK.getHeadView() != null) {
            this.hRK.getHeadView().setIsRound(true);
            this.hRK.getHeadView().setDrawBorder(false);
            this.hRK.getHeadView().setDefaultResource(17170445);
            this.hRK.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.hRK.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds70));
        }
        this.hRK.setHasPendantStyle();
        if (this.hRK.getPendantView() != null) {
            this.hRK.getPendantView().setIsRound(true);
            this.hRK.getPendantView().setDrawBorder(false);
        }
        this.hRK.setAfterClickListener(this.ajG);
        this.fKv = view.findViewById(R.id.divider_line);
        this.mTitle = (TextView) view.findViewById(R.id.card_home_page_normal_thread_title);
        this.akw = (PlayVoiceBntNew) view.findViewById(R.id.card_home_page_normal_thread_abstract_voice);
        this.akw.setAfterClickListener(this.hSp);
        this.agm = (TextView) view.findViewById(R.id.card_home_page_normal_thread_abstract);
        this.agm.setVisibility(8);
        this.hSh = view.findViewById(R.id.divider_line_above_praise);
        this.hSj = (ConstrainImageGroup) view.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hSj.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.hSj.setChildClickListener(this.hSo);
        f fVar = new f(3);
        fVar.y(1.0d);
        this.hSj.setImageProcessor(fVar);
        this.gMs = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.gMr = (ThreadUserInfoLayout) view.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        this.gMr.setUserAfterClickListener(this.ajG);
        this.gMr.setFrom(3);
        this.gMs.setOnClickListener(this.hSo);
        this.gMs.setForumAfterClickListener(this.ajG);
        this.gMs.setReplyTimeVisible(false);
        this.gMs.setShowPraiseNum(true);
        this.gMs.setNeedAddPraiseIcon(true);
        this.gMs.setNeedAddReplyIcon(true);
        this.gMs.setIsBarViewVisible(false);
        this.gMs.setShareVisible(true);
        this.gMs.setShareReportFrom(1);
        this.gMs.setStType("frs_page");
        this.gMs.setFrom(2);
        this.gMs.eQK = 3;
        this.gNe = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_home_page_source_read_share_layout);
        if (this.gNe != null) {
            this.gNe.eRI.setOnClickListener(this.hSo);
            this.gNe.setFrom(2);
            this.gNe.setShareReportFrom(1);
            this.gNe.setSourceFromForPb(3);
            this.gNe.setStType("frs_page");
            this.gNe.setHideBarName(true);
            this.gNe.eRI.setNeedAddReplyIcon(true);
        }
        this.byI = (RelativeLayout) view.findViewById(R.id.card_home_page_normal_thread_root);
        this.iNz = new i(this.mPageContext, this.byI);
        this.iNz.setUniqueId(getTag());
        this.hRJ = (ThreadGodReplyLayout) view.findViewById(R.id.card_frs_god_reply_layout);
        this.hRJ.setOnClickListener(this.hSo);
        this.hTS = (TbImageView) view.findViewById(R.id.frs_normal_item_theme_card);
        this.hTS.setPageId(getTag());
        this.hTU = (TbImageView) view.findViewById(R.id.frs_normal_item_star_view);
        if (this.hTU != null) {
            this.hTU.setPageId(getTag());
        }
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gMs != null) {
                    c.this.gMs.changeSelectStatus();
                }
            }
        });
        this.gMs.setOnSelectStatusChangeListener(new ThreadCommentAndPraiseInfoLayout.b() { // from class: com.baidu.tieba.frs.entelechy.view.c.2
            @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.b
            public void jj(boolean z) {
                if (c.this.mMaskView != null) {
                    c.this.mMaskView.setBackgroundColor(ap.getColor(z ? R.color.cp_bg_line_d : R.color.transparent));
                }
            }
        });
        this.fSf = (LinearLayout) view.findViewById(R.id.card_home_page_normal_thread_content_layout);
        this.alA = (AppletsCellView) view.findViewById(R.id.card_home_page_normal_thread_share_info);
    }

    public void setSingleImageRatio(double d) {
        if (this.hSj != null) {
            this.hSj.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hSj != null) {
            this.hSj.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hSj != null) {
            this.hSj.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.fKv, R.color.cp_bg_line_c);
            this.hSj.onChangeSkinType();
            this.gMs.onChangeSkinType();
            this.gMr.onChangeSkinType();
            if (this.alA != null) {
                this.alA.onChangeSkinType();
            }
            this.iNz.onChangeSkinType();
            if (this.gNe != null && this.gNe.getVisibility() == 0) {
                this.gNe.onChangeSkinType();
            }
            if (this.hRK != null && this.hRK.getHeadView() != null && (this.hRK.getHeadView() instanceof TbImageView)) {
                this.hRK.getHeadView().setPlaceHolder(1);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(final bw bwVar) {
        if (bwVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.agx = bwVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.hSo);
        }
        this.hRJ.onChangeSkinType();
        if (!clB() && n.IJ(this.agx.getId())) {
            n.a(this.mTitle, this.agx.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            n.a(this.agm, this.agx.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            n.a(this.hRJ.getGodReplyContent(), this.agx.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
        }
        b(bwVar);
        this.iNz.ay(this.agx);
        Y(bwVar);
        this.gMr.setData(this.agx);
        this.hRJ.setFromCDN(this.akk);
        this.hRJ.setData(this.agx.blD());
        this.gMr.setUserAfterClickListener(this.ajG);
        uS(sZ(1));
        if (this.gMr.getHeaderImg() != null) {
            if (this.gMr.getIsSimpleThread()) {
                this.gMr.getHeaderImg().setVisibility(8);
                this.hRK.setVisibility(8);
            } else if (bwVar.bka() == null || bwVar.bka().getPendantData() == null || StringUtils.isNull(bwVar.bka().getPendantData().bhW())) {
                this.hRK.setVisibility(8);
                this.gMr.getHeaderImg().setVisibility(0);
                this.gMr.getHeaderImg().setData(bwVar);
            } else {
                this.gMr.getHeaderImg().setVisibility(4);
                this.hRK.setVisibility(0);
                this.hRK.setData(bwVar);
            }
        }
        ar(bwVar);
        as(bwVar);
        this.alA.setData(bwVar.bkP());
        this.alA.setForumId(String.valueOf(bwVar.getFid()));
        AppletsCellView appletsCellView = this.alA;
        AppletsCellView appletsCellView2 = this.alA;
        appletsCellView.setFrom("frs_card");
        ArrayList<VoiceData.VoiceModel> bkn = bwVar.bkn();
        if (y.isEmpty(bkn)) {
            this.akw.setVisibility(8);
        } else {
            this.akw.bWJ();
            this.akw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bkn.get(0);
            this.akw.setVoiceModel(voiceModel);
            this.akw.setTag(voiceModel);
            this.akw.changeSkin();
            if (voiceModel != null) {
                this.akw.Dm(voiceModel.voice_status.intValue());
            }
        }
        ArrayList<MediaData> bkj = bwVar.bkj();
        if (k.bhh().isShowImages() && y.getCount(bkj) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bkj.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bkj, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.hSj.setVisibility(0);
                this.hSj.setFromCDN(this.akk);
                this.hSj.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.c.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        ab<bw> cls = c.this.cls();
                        if (z) {
                            if (cls != null) {
                                view.setTag("1");
                                cls.aiJ = true;
                                cls.a(view, c.this.agx);
                            }
                            c.this.oj(false);
                            return;
                        }
                        if (cls != null) {
                            view.setTag("1");
                            cls.aiJ = false;
                            cls.a(view, c.this.agx);
                        }
                        c.this.a(view, linkedList, i2, bwVar);
                    }
                });
                this.hSj.setImageMediaList(linkedList);
            } else {
                this.hSj.setVisibility(8);
            }
        } else {
            this.hSj.setVisibility(8);
        }
        clJ();
        clK();
        czN();
        if ((com.baidu.tieba.frs.b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF()) && this.gMs.isInFrsAllThread()) {
            this.mMaskView.setVisibility(0);
            if (this.agx.blL() || this.agx.blM() || this.agx.blN()) {
                ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            } else {
                this.mMaskView.setBackgroundResource(R.color.transparent);
            }
        } else {
            this.mMaskView.setVisibility(8);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void clJ() {
        if (this.hSh != null && this.hSj != null && this.hRJ != null) {
            if (this.hSj.getVisibility() == 8 && this.hRJ.getVisibility() == 8 && this.alA.getVisibility() == 8) {
                this.hSh.setVisibility(0);
            } else {
                this.hSh.setVisibility(8);
            }
        }
    }

    private void Y(final bw bwVar) {
        if (this.hTU != null) {
            if (this.hTS == null || bwVar == null) {
                this.hTU.setVisibility(8);
            } else if (!StringUtils.isNull(bwVar.eAz) && this.hTS.getVisibility() != 0) {
                if (this.iNz != null && this.iNz.cDB() && (this.hTU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hTU.getLayoutParams();
                    layoutParams.rightMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                    this.hTU.setLayoutParams(layoutParams);
                }
                this.hTU.setVisibility(0);
                this.hTU.setImageDrawable(null);
                this.hTU.startLoad(bwVar.eAz, 10, false);
                this.hTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.mPageContext != null) {
                            c.this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ShareWebActivityConfig(c.this.mTbPageContext.getContext(), "", bwVar.eAA, true)));
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
                    }
                });
            } else {
                this.hTU.setVisibility(8);
            }
        }
    }

    public void b(bw bwVar) {
        MetaData bka;
        if (bwVar != null && this.hTS != null && (bka = bwVar.bka()) != null) {
            final ThemeCardInUserData themeCard = bka.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.hTS.setVisibility(8);
                return;
            }
            this.hTS.setVisibility(0);
            this.hTS.setImageDrawable(null);
            this.hTS.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.hTS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(c.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
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
                imageUrlData.urlType = this.akk ? 13 : 14;
                imageUrlData.imageUrl = a(mediaData);
                imageUrlData.originalUrl = mediaData.getOriginalUrl();
                imageUrlData.originalSize = mediaData.getOriginalSize();
                imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                imageUrlData.isLongPic = mediaData.isLongPic();
                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
                imageUrlData.postId = mediaData.getPostId();
                concurrentHashMap.put(str, imageUrlData);
            }
        }
        if (!y.isEmpty(arrayList)) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).nF(i).Aq(bwVar.bke()).Ar(String.valueOf(bwVar.getFid())).As(bwVar.getTid()).io(this.akk).At(arrayList.size() > 0 ? arrayList.get(0) : "").ip(true).a(concurrentHashMap).iq(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
            ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
            dU.getIntent().putExtra("from", "frs");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.mPageContext;
            historyMessage.threadId = bwVar.getId();
            historyMessage.threadName = bwVar.getTitle();
            historyMessage.forumName = bwVar.bke();
            historyMessage.postID = bwVar.bkr();
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

    private void clK() {
        this.akw.setClickable(true);
        int childCount = this.hSj.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.hSj.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gMs != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gMr != null) {
            this.gMr.setPageUniqueId(bdUniqueId);
        }
        if (this.hSj != null) {
            this.hSj.setPageUniqueId(bdUniqueId);
        }
    }

    protected void oj(boolean z) {
        if (this.agx != null) {
            n.II(this.agx.getId());
            n.a(this.mTitle, this.agx.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
            n.a(this.agm, this.agx.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
            n.a(this.hRJ.getGodReplyContent(), this.agx.getId(), R.color.cp_cont_f, R.color.cp_cont_d);
            r bll = this.agx.bll();
            if (bll != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    bg.skipToLoginActivity(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.mPageContext.getPageActivity(), bll.getCartoonId(), bll.getChapterId(), 2)));
                return;
            }
            o oVar = this.agx.ezX;
            if (this.agx.ezW == 1 && oVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = oVar.eua;
                long j = oVar.eub;
                au auVar = new au();
                auVar.pageContext = this.mPageContext;
                auVar.euA = str;
                auVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.agx, null, "frs_page", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam("");
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setFrom("from_frs");
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            if (this.agx.blh() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean clB() {
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
    public void uQ(int i) {
        this.currentPageType = i;
        if (this.gMs != null) {
            this.gMs.eQK = i;
            this.gMs.setFrom(2);
        }
        if (this.gMr != null) {
            this.gMr.setFrom(3);
        }
    }

    private boolean ar(bw bwVar) {
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.iNJ)) {
            bwVar.dG(this.mUrl, this.iNJ);
        }
        SpannableStringBuilder B = bwVar.B(false, true);
        if (B == null || StringUtils.isNull(B.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.i(B));
            this.mTitle.setText(B);
            n.a(this.mTitle, bwVar.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        }
        return true;
    }

    private void as(bw bwVar) {
        if (bwVar != null && sZ(2) == 1) {
            if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.iNJ)) {
                bwVar.dG(this.mUrl, this.iNJ);
            }
            SpannableString bkV = bwVar.bkV();
            if (bkV != null && !at.isEmpty(bkV.toString())) {
                this.agm.setVisibility(0);
                this.agm.setOnTouchListener(new com.baidu.tieba.view.i(bkV));
                this.agm.setText(bkV);
                n.a(this.agm, bwVar.getId(), R.color.cp_cont_j, R.color.cp_cont_d);
                return;
            }
            this.agm.setVisibility(8);
            return;
        }
        this.agm.setVisibility(8);
    }

    private void czN() {
        if (this.mTitle != null && this.akw != null && this.hSj != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akw.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
            this.akw.setLayoutParams(layoutParams);
            if (this.akw.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hSj.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds28);
                this.hSj.setLayoutParams(layoutParams2);
            }
        }
    }

    public void uS(int i) {
        if (this.agx != null) {
            if (i == 1) {
                this.gMs.setVisibility(8);
                if (this.gNe != null) {
                    this.gNe.setData(this.agx);
                    return;
                }
                return;
            }
            this.gMs.setData(this.agx);
            if (this.gNe != null) {
                this.gNe.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    public int sZ(int i) {
        return com.baidu.tieba.a.d.bGs().av(this.ahu, i);
    }
}
