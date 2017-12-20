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
    private boolean ajh;
    private final View.OnClickListener anQ;
    private final View.OnClickListener aod;
    private HeadPendantClickableView bZe;
    private View bZh;
    private l bZi;
    private View.OnClickListener bZj;
    public ThreadCommentAndPraiseInfoLayout bvI;
    protected LinearLayout bvL;
    public PlayVoiceBntNew caM;
    private TextView caO;
    private ConstrainImageGroup caP;
    private final View.OnClickListener caS;
    public ConcernThreadUserInfoLayout doN;
    private View doQ;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajh = true;
        this.bZj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.abt() != null) {
                    b.this.abt().a(view, b.this.bZi);
                }
                b.this.abM();
            }
        };
        this.caS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<l> abt = b.this.abt();
                if (abt != null) {
                    view.setTag("2");
                    abt.a(view, b.this.bZi);
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.abt() != null) {
                    b.this.abt().a(view, b.this.bZi);
                }
            }
        };
        this.anQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.abt() != null) {
                    b.this.abt().a(view, b.this.bZi);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.currentPageType = 1;
        this.bZe = (HeadPendantClickableView) view.findViewById(d.g.card_concern_normal_thread_user_pendant_header);
        if (this.bZe.getHeadView() != null) {
            this.bZe.getHeadView().setIsRound(true);
            this.bZe.getHeadView().setDrawBorder(false);
            this.bZe.getHeadView().setDefaultResource(17170445);
            this.bZe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZe.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.bZe.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds60));
        }
        if (this.bZe.getPendantView() != null) {
            this.bZe.getPendantView().setIsRound(true);
            this.bZe.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_concern_normal_thread_title);
        this.caM = (PlayVoiceBntNew) view.findViewById(d.g.card_concern_normal_thread_abstract_voice);
        this.caM.setAfterClickListener(this.caS);
        this.caO = (TextView) view.findViewById(d.g.card_concern_normal_thread_abstract);
        this.caO.setVisibility(8);
        this.caP = (ConstrainImageGroup) view.findViewById(d.g.card_concern_normal_thread_img_layout);
        this.bZh = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
        this.caP.setChildClickListener(this.bZj);
        this.caP.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caP.setImageProcessor(fVar);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_concern_normal_thread_info_layout);
        this.doN = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_normal_thread_user_info_layout);
        if (this.bvI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvI.setLayoutParams(layoutParams);
        }
        this.bvI.setOnClickListener(this.bZj);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setIsBarViewVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setShareVisible(true);
        this.bvI.setShareReportFrom(4);
        this.bvI.anO = this.currentPageType;
        this.bvI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.abt() != null) {
                    b.this.abt().a(view2, b.this.bZi);
                }
            }
        });
        this.bvL = (LinearLayout) view.findViewById(d.g.card_concern_normal_thread_content_layout);
        this.doQ = view.findViewById(d.g.no_image_divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.caP != null) {
            this.caP.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.caP != null) {
            this.caP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.caP != null) {
            this.caP.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            this.caP.onChangeSkinType();
            this.bvI.onChangeSkinType();
            this.doN.onChangeSkinType();
            aj.k(this.bZh, d.C0096d.cp_bg_line_e);
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
        this.bZi = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZj);
        }
        this.doN.setData(lVar.threadData);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (!abx() && k.jP(this.bZi.threadData.getId())) {
            k.a(this.mTitle, this.bZi.Ox().getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            k.a(this.caO, this.bZi.threadData.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
        }
        this.doN.setUserAfterClickListener(this.aod);
        this.bvI.setData(lVar.threadData);
        this.bvI.setStType(k.rl());
        final bd Ox = lVar.Ox();
        if (this.doN.getHeaderImg() != null) {
            if (this.doN.getIsSimpleThread()) {
                this.doN.getHeaderImg().setVisibility(8);
                this.bZe.setVisibility(8);
            } else if (Ox.rv() == null || Ox.rv().getPendantData() == null || StringUtils.isNull(Ox.rv().getPendantData().pR())) {
                this.bZe.setVisibility(8);
                this.doN.getHeaderImg().setVisibility(0);
                this.doN.getHeaderImg().setData(Ox);
            } else {
                this.doN.getHeaderImg().setVisibility(4);
            }
        }
        B(Ox);
        ArrayList<VoiceData.VoiceModel> rK = lVar.threadData.rK();
        if (com.baidu.tbadk.core.util.v.w(rK)) {
            this.caM.setVisibility(8);
            dS(false);
            z = false;
        } else {
            this.caM.setVisibility(0);
            dS(true);
            VoiceData.VoiceModel voiceModel = rK.get(0);
            this.caM.setVoiceModel(voiceModel);
            this.caM.setTag(voiceModel);
            this.caM.bme();
            if (voiceModel != null) {
                this.caM.nT(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.bZi.cdT && z) {
            this.caP.setVisibility(8);
            this.doQ.setVisibility(0);
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
                    this.caP.setVisibility(0);
                    this.doQ.setVisibility(8);
                    this.caP.setFromCDN(this.ajh);
                    this.caP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            v<l> abt = b.this.abt();
                            if (abt != null) {
                                view.setTag("1");
                                abt.a(view, b.this.bZi);
                            }
                            if (z2) {
                                b.this.abM();
                            } else {
                                b.this.a(view, linkedList, i2, Ox);
                            }
                        }
                    });
                    this.caP.setImageMediaList(linkedList);
                } else {
                    this.caP.setVisibility(8);
                    this.doQ.setVisibility(0);
                }
            } else {
                this.caP.setVisibility(8);
                this.doQ.setVisibility(0);
            }
        }
        abL();
        setPageUniqueId(getTag());
        aod();
    }

    private void dS(boolean z) {
        if (this.caP != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caP.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10);
            }
            this.caP.setLayoutParams(layoutParams);
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
                    imageUrlData.urlType = this.ajh ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rB(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.ajh, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void abL() {
        if (!this.bZi.aDm) {
            this.caM.setClickable(false);
        } else {
            this.caM.setClickable(true);
        }
        int childCount = this.caP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.caP.getChildAt(i);
            if (childAt != null) {
                if (!this.bZi.aDm) {
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
        if (this.caP != null) {
            this.caP.setPageUniqueId(bdUniqueId);
        }
        if (this.doN != null) {
            this.doN.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.doN != null) {
            return this.doN.getHeaderImg();
        }
        return null;
    }

    public View abw() {
        if (this.doN != null) {
            return this.doN.anZ;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abM() {
        if (this.bZi != null && this.bZi.threadData != null) {
            if (!abx()) {
                k.jO(this.bZi.threadData.getId());
                k.a(this.mTitle, this.bZi.Ox().getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
                k.a(this.caO, this.bZi.threadData.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bZi.threadData, null, k.rl(), 18005, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.bZi.threadData.getFid()));
            createFromThreadCfg.setForumName(this.bZi.threadData.rB());
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private boolean abx() {
        return this.bZi.cdT && !this.bZi.aDm;
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
            k.a(this.mTitle, bdVar.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
        }
        return true;
    }

    private void aod() {
        if (this.mTitle != null && this.caM != null && this.caP != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.caM.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds24);
            this.caM.setLayoutParams(layoutParams);
            if (this.caM.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.caP.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                this.caP.setLayoutParams(layoutParams2);
            }
        }
    }
}
