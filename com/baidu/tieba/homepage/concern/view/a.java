package com.baidu.tieba.homepage.concern.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.a.e;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.n;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<k> implements e {
    private TextView FK;
    private String GC;
    private final View.OnClickListener HO;
    private boolean HY;
    public PlayVoiceBntNew Ii;
    private final View.OnClickListener cpN;
    public ThreadCommentAndPraiseInfoLayout dTr;
    public ThreadSourceShareAndPraiseLayout dUf;
    protected LinearLayout dUq;
    private HeadPendantClickableView eMH;
    private k eNh;
    private ConstrainImageGroup eNi;
    private View eNj;
    private View.OnClickListener eNn;
    private final View.OnClickListener eNo;
    public ConcernThreadUserInfoLayout gfj;
    public ConcernForumThreadUserInfoLayout gfk;
    public d gfl;
    private View gfm;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.HY = true;
        this.eNn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view, a.this.eNh);
                }
                a.this.asj();
            }
        };
        this.eNo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<k> aZX = a.this.aZX();
                if (aZX != null) {
                    view.setTag("2");
                    aZX.a(view, a.this.eNh);
                }
            }
        };
        this.HO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view, a.this.eNh);
                }
            }
        };
        this.cpN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view, a.this.eNh);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.eMH = (HeadPendantClickableView) view.findViewById(R.id.card_concern_normal_thread_user_pendant_header);
        if (this.eMH.getHeadView() != null) {
            this.eMH.getHeadView().setIsRound(true);
            this.eMH.getHeadView().setDrawBorder(false);
            this.eMH.getHeadView().setDefaultResource(17170445);
            this.eMH.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eMH.getHeadView().setDefaultBgResource(R.color.cp_bg_line_e);
            this.eMH.getHeadView().setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds60));
        }
        if (this.eMH.getPendantView() != null) {
            this.eMH.getPendantView().setIsRound(true);
            this.eMH.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(R.id.card_concern_normal_thread_title);
        this.Ii = (PlayVoiceBntNew) view.findViewById(R.id.card_concern_normal_thread_abstract_voice);
        this.Ii.setAfterClickListener(this.eNo);
        this.FK = (TextView) view.findViewById(R.id.card_concern_normal_thread_abstract);
        this.FK.setVisibility(8);
        this.eNi = (ConstrainImageGroup) view.findViewById(R.id.card_concern_normal_thread_img_layout);
        this.eNj = view.findViewById(R.id.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.eNi.setChildClickListener(this.eNn);
        this.eNi.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.g(1.0d);
        this.eNi.setImageProcessor(fVar);
        this.dTr = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_concern_normal_thread_info_layout);
        if (this.dTr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTr.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.dTr.setLayoutParams(layoutParams);
        }
        this.dTr.setOnClickListener(this.eNn);
        this.dTr.setReplyTimeVisible(false);
        this.dTr.setIsBarViewVisible(false);
        this.dTr.setShowPraiseNum(true);
        this.dTr.setNeedAddPraiseIcon(true);
        this.dTr.setNeedAddReplyIcon(true);
        this.dTr.setShareVisible(true);
        this.dTr.setShareReportFrom(4);
        this.dTr.setFrom(9);
        this.dTr.setDisPraiseFrom(4);
        this.dTr.cqT = this.currentPageType;
        this.dTr.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view2, a.this.eNh);
                }
                if (a.this.eNh != null && a.this.eNh.cbq != null) {
                    n.uz(a.this.eNh.cbq.getId());
                    a.this.btf();
                }
            }
        });
        this.dUf = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.card_concern_nomal_source_read_share_layout);
        this.dUf.crO.setOnClickListener(this.eNn);
        this.dUf.setShareReportFrom(4);
        this.dUf.setFrom(9);
        this.dUf.crO.cqT = this.currentPageType;
        this.dUf.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view2, a.this.eNh);
                }
                if (a.this.eNh != null && a.this.eNh.cbq != null && view2 != a.this.dUf.crd) {
                    n.uz(a.this.eNh.cbq.getId());
                    a.this.btf();
                }
            }
        });
        this.dUq = (LinearLayout) view.findViewById(R.id.card_concern_normal_thread_content_layout);
        this.gfm = view.findViewById(R.id.no_image_divider_line);
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
            this.eNi.onChangeSkinType();
            this.dTr.onChangeSkinType();
            am.setBackgroundColor(this.eNj, R.color.cp_bg_line_c);
            this.dUf.onChangeSkinType();
        }
        if (this.gfj != null && this.gfj.getVisibility() == 0) {
            this.gfj.onChangeSkinType(i);
        }
        if (this.gfk != null && this.gfk.getVisibility() == 0) {
            this.gfk.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btf() {
        if (this.eNh != null && this.eNh.cbq.getId() != null) {
            n.a(this.mTitle, this.eNh.agI().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            n.a(this.FK, this.eNh.cbq.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_concern_normal_thread;
    }

    private void btg() {
        if (this.gfj == null) {
            this.gfj = (ConcernThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_thread_user_info_layout)).inflate();
        }
    }

    private void bth() {
        if (this.gfk == null) {
            this.gfk = (ConcernForumThreadUserInfoLayout) ((ViewStub) getView().findViewById(R.id.viewstub_concern_normal_forum_thread_user_info_layout)).inflate();
        }
        this.gfk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZX() != null) {
                    a.this.aZX().a(view, a.this.eNh);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(k kVar) {
        boolean z;
        if (kVar == null || kVar.cbq == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.eNh = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eNn);
        }
        if (kVar.baL()) {
            bth();
            this.gfl = this.gfk;
            this.gfk.setVisibility(0);
            if (this.gfj != null) {
                this.gfj.setVisibility(8);
            }
        } else {
            btg();
            this.gfl = this.gfj;
            this.gfj.setVisibility(0);
            if (this.gfk != null) {
                this.gfk.setVisibility(8);
            }
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!bah() && n.uA(this.eNh.cbq.getId())) {
            btf();
        }
        final bh agI = kVar.agI();
        if (this.gfl.getHeaderImg() != null) {
            if (this.gfl.getIsSimpleThread()) {
                this.gfl.getHeaderImg().setVisibility(8);
                this.eMH.setVisibility(8);
            } else if (agI.aiG() == null || agI.aiG().getPendantData() == null || StringUtils.isNull(agI.aiG().getPendantData().ahf())) {
                this.eMH.setVisibility(8);
                this.gfl.getHeaderImg().setVisibility(0);
                this.gfl.getHeaderImg().setData(agI, !kVar.baL());
            } else {
                this.gfl.getHeaderImg().setVisibility(4);
                this.eMH.setVisibility(0);
                this.eMH.setData(agI);
            }
        }
        this.gfl.setData(kVar.cbq);
        this.gfl.setUserAfterClickListener(this.HO);
        ag(agI);
        b(kVar);
        ArrayList<VoiceData.VoiceModel> aiU = kVar.cbq.aiU();
        if (v.isEmpty(aiU)) {
            this.Ii.setVisibility(8);
            iI(false);
            z = false;
        } else {
            this.Ii.setVisibility(0);
            iI(true);
            VoiceData.VoiceModel voiceModel = aiU.get(0);
            this.Ii.setVoiceModel(voiceModel);
            this.Ii.setTag(voiceModel);
            this.Ii.bnq();
            if (voiceModel != null) {
                this.Ii.uK(voiceModel.voice_status.intValue());
            }
            this.Ii.cpC();
            z = true;
        }
        if (this.eNh.eQB && z) {
            this.eNi.setVisibility(8);
            this.gfm.setVisibility(0);
        } else {
            ArrayList<MediaData> aiQ = kVar.cbq.aiQ();
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
                    this.gfm.setVisibility(8);
                    this.eNi.setFromCDN(this.HY);
                    this.eNi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.a.4
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void b(View view, int i2, boolean z2) {
                            ab<k> aZX = a.this.aZX();
                            if (aZX != null) {
                                view.setTag("1");
                                aZX.a(view, a.this.eNh);
                            }
                            if (z2) {
                                a.this.asj();
                            } else {
                                a.this.a(view, linkedList, i2, agI);
                            }
                        }
                    });
                    this.eNi.setImageMediaList(linkedList);
                } else {
                    this.eNi.setVisibility(8);
                    this.gfm.setVisibility(0);
                }
            } else {
                this.eNi.setVisibility(8);
                this.gfm.setVisibility(0);
            }
        }
        baq();
        setPageUniqueId(getTag());
        bns();
        mZ(ly(1));
    }

    private void iI(boolean z) {
        if (this.eNi != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNi.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.eNi.setLayoutParams(layoutParams);
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
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.HY ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aiL(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.HY, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
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

    private void baq() {
        if (!this.eNh.cGz) {
            this.Ii.setClickable(false);
        } else {
            this.Ii.setClickable(true);
        }
        int childCount = this.eNi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eNi.getChildAt(i);
            if (childAt != null) {
                if (!this.eNh.cGz) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eNi != null) {
            this.eNi.setPageUniqueId(bdUniqueId);
        }
        if (this.gfl != null) {
            this.gfl.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.gfl != null) {
            return this.gfl.getHeaderImg();
        }
        return null;
    }

    public View bac() {
        if (this.gfl != null) {
            return this.gfl.getUserName();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asj() {
        if (this.eNh != null && this.eNh.cbq != null) {
            if (!bah()) {
                n.uz(this.eNh.cbq.getId());
                n.a(this.mTitle, this.eNh.agI().getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
                n.a(this.FK, this.eNh.cbq.getId(), (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.eNh.cbq, null, n.ait(), RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.eNh.cbq.getFid()));
            createFromThreadCfg.setForumName(this.eNh.cbq.aiL());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean bah() {
        return this.eNh.eQB && !this.eNh.cGz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean ag(bh bhVar) {
        SpannableStringBuilder s = bhVar.s(false, true);
        if (s == null || StringUtils.isNull(s.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.k(s));
            this.mTitle.setText(s);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.cbq == null || kVar.baL()) {
            this.FK.setVisibility(8);
            return;
        }
        bh bhVar = kVar.cbq;
        if (ly(2) == 1) {
            SpannableString akg = bhVar.akg();
            if (akg != null && !aq.isEmpty(akg.toString())) {
                this.FK.setVisibility(0);
                this.FK.setOnTouchListener(new com.baidu.tieba.view.k(akg));
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
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.Ii.setLayoutParams(layoutParams);
            if (this.Ii.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eNi.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.eNi.setLayoutParams(layoutParams2);
            }
        }
    }

    public void mZ(int i) {
        if (this.eNh != null && this.eNh.cbq != null) {
            if (!this.eNh.baL() && i == 1) {
                this.dTr.setVisibility(8);
                this.dUf.setStType(n.ait());
                this.dUf.setData(this.eNh.cbq);
                this.gfl.et(false);
                return;
            }
            this.dTr.setData(this.eNh.cbq);
            this.dTr.setStType(n.ait());
            this.dUf.setVisibility(8);
            this.gfl.et(true);
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
