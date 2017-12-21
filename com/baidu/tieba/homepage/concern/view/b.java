package com.baidu.tieba.homepage.concern.view;

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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<l> {
    private boolean ajk;
    private final View.OnClickListener anT;
    private final View.OnClickListener aog;
    private HeadPendantClickableView bZi;
    private View bZl;
    private l bZm;
    private View.OnClickListener bZn;
    public ThreadCommentAndPraiseInfoLayout bvM;
    protected LinearLayout bvP;
    public PlayVoiceBntNew caQ;
    private TextView caS;
    private ConstrainImageGroup caT;
    private final View.OnClickListener caW;
    public ConcernThreadUserInfoLayout doR;
    private View doU;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajk = true;
        this.bZn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.abt() != null) {
                    b.this.abt().a(view, b.this.bZm);
                }
                b.this.abM();
            }
        };
        this.caW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<l> abt = b.this.abt();
                if (abt != null) {
                    view.setTag("2");
                    abt.a(view, b.this.bZm);
                }
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.abt() != null) {
                    b.this.abt().a(view, b.this.bZm);
                }
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.abt() != null) {
                    b.this.abt().a(view, b.this.bZm);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bZi = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.bZi.getHeadView() != null) {
            this.bZi.getHeadView().setIsRound(true);
            this.bZi.getHeadView().setDrawBorder(false);
            this.bZi.getHeadView().setDefaultResource(17170445);
            this.bZi.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZi.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.bZi.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.bZi.getPendantView() != null) {
            this.bZi.getPendantView().setIsRound(true);
            this.bZi.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.caQ = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.caQ.setAfterClickListener(this.caW);
        this.caS = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.caS.setVisibility(8);
        this.caT = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.bZl = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.caT.setChildClickListener(this.bZn);
        this.caT.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caT.setImageProcessor(fVar);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.doR = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.bvM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvM.setLayoutParams(layoutParams);
        }
        this.bvM.setOnClickListener(this.bZn);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setIsBarViewVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setShareVisible(true);
        this.bvM.setShareReportFrom(4);
        this.bvM.anR = this.currentPageType;
        this.bvM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.abt() != null) {
                    b.this.abt().a(view2, b.this.bZm);
                }
            }
        });
        this.bvP = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.doU = view.findViewById(d.g.no_image_divider_line);
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
            this.caT.onChangeSkinType();
            this.bvM.onChangeSkinType();
            this.doR.onChangeSkinType();
            aj.k(this.bZl, d.C0095d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(l lVar) {
        boolean z;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bZm = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZn);
        }
        this.doR.setData(lVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!abx() && k.jP(this.bZm.threadData.getId())) {
            k.a(this.mTitle, this.bZm.Ox().getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            k.a(this.caS, this.bZm.threadData.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
        }
        this.doR.setUserAfterClickListener(this.aog);
        this.bvM.setData(lVar.threadData);
        this.bvM.setStType(k.rl());
        final bd Ox = lVar.Ox();
        if (this.doR.getHeaderImg() != null) {
            if (this.doR.getIsSimpleThread()) {
                this.doR.getHeaderImg().setVisibility(8);
                this.bZi.setVisibility(8);
            } else if (Ox.rv() == null || Ox.rv().getPendantData() == null || StringUtils.isNull(Ox.rv().getPendantData().pR())) {
                this.bZi.setVisibility(8);
                this.doR.getHeaderImg().setVisibility(0);
                this.doR.getHeaderImg().setData(Ox);
            } else {
                this.doR.getHeaderImg().setVisibility(4);
            }
        }
        B(Ox);
        ArrayList<VoiceData.VoiceModel> rK = lVar.threadData.rK();
        if (com.baidu.tbadk.core.util.v.w(rK)) {
            this.caQ.setVisibility(8);
            dS(false);
            z = false;
        } else {
            this.caQ.setVisibility(0);
            dS(true);
            VoiceData.VoiceModel voiceModel = rK.get(0);
            this.caQ.setVoiceModel(voiceModel);
            this.caQ.setTag(voiceModel);
            this.caQ.bmf();
            if (voiceModel != null) {
                this.caQ.nT(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bZm.cdX && z) {
            this.caT.setVisibility(8);
            this.doU.setVisibility(0);
        } else {
            ArrayList<MediaData> rG = lVar.threadData.rG();
            if (h.oY().pe() && com.baidu.tbadk.core.util.v.v(rG) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < rG.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rG, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.caT.setVisibility(0);
                    this.doU.setVisibility(8);
                    this.caT.setFromCDN(this.ajk);
                    this.caT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            v<l> abt = b.this.abt();
                            if (abt != null) {
                                view.setTag("1");
                                abt.a(view, b.this.bZm);
                            }
                            if (z2) {
                                b.this.abM();
                            } else {
                                b.this.a(view, linkedList, i2, Ox);
                            }
                        }
                    });
                    this.caT.setImageMediaList(linkedList);
                } else {
                    this.caT.setVisibility(8);
                    this.doU.setVisibility(0);
                }
            } else {
                this.caT.setVisibility(8);
                this.doU.setVisibility(0);
            }
        }
        abL();
        setPageUniqueId(getTag());
        aoe();
    }

    private void dS(boolean z) {
        if (this.caT != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caT.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.caT.setLayoutParams(layoutParams);
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
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajk ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bdVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rB(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajk, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void abL() {
        if (!this.bZm.aDp) {
            this.caQ.setClickable(false);
        } else {
            this.caQ.setClickable(true);
        }
        int childCount = this.caT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caT.getChildAt(i);
            if (childAt != null) {
                if (!this.bZm.aDp) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.caT != null) {
            this.caT.setPageUniqueId(bdUniqueId);
        }
        if (this.doR != null) {
            this.doR.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.doR != null) {
            return this.doR.getHeaderImg();
        }
        return null;
    }

    public View abw() {
        if (this.doR != null) {
            return this.doR.aoc;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abM() {
        if (this.bZm != null && this.bZm.threadData != null) {
            if (!abx()) {
                k.jO(this.bZm.threadData.getId());
                k.a(this.mTitle, this.bZm.Ox().getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
                k.a(this.caS, this.bZm.threadData.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bZm.threadData, null, k.rl(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.bZm.threadData.getFid()));
            createFromThreadCfg.setForumName(this.bZm.threadData.rB());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean abx() {
        return this.bZm.cdX && !this.bZm.aDp;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean B(bd bdVar) {
        SpannableStringBuilder g = bdVar.g(false, true);
        if (g == null || StringUtils.isNull(g.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(g));
            this.mTitle.setText(g);
            k.a(this.mTitle, bdVar.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
        }
        return true;
    }

    private void aoe() {
        if (this.mTitle != null && this.caQ != null && this.caT != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.caQ.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.caQ.setLayoutParams(layoutParams);
            if (this.caQ.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.caT.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.caT.setLayoutParams(layoutParams2);
            }
        }
    }
}
