package com.baidu.tieba.card;

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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class l extends a<com.baidu.tieba.card.data.l> {
    private boolean ajh;
    private final View.OnClickListener aod;
    private HeadPendantClickableView bZe;
    private ThreadGodReplyLayout bZf;
    private com.baidu.tieba.NEGFeedBack.c bZg;
    private View bZh;
    private com.baidu.tieba.card.data.l bZi;
    private View.OnClickListener bZj;
    public ThreadUserInfoLayout bvE;
    public ThreadCommentAndPraiseInfoLayout bvI;
    protected LinearLayout bvL;
    public PlayVoiceBntNew caM;
    private View caN;
    private TextView caO;
    private ConstrainImageGroup caP;
    private boolean caQ;
    private RelativeLayout caR;
    private final View.OnClickListener caS;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZg = null;
        this.mSkinType = 3;
        this.ajh = true;
        this.caQ = true;
        this.bZj = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abt() != null) {
                    l.this.abt().a(view, l.this.bZi);
                }
                l.this.dO(view == l.this.bZf);
            }
        };
        this.caS = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.card.data.l> abt = l.this.abt();
                if (abt != null) {
                    view.setTag("2");
                    abt.a(view, l.this.bZi);
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abt() != null) {
                    l.this.abt().a(view, l.this.bZi);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bZe = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZe.getHeadView() != null) {
            this.bZe.getHeadView().setIsRound(true);
            this.bZe.getHeadView().setDrawBorder(false);
            this.bZe.getHeadView().setDefaultResource(17170445);
            this.bZe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZe.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.bZe.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZe.wi();
        if (this.bZe.getPendantView() != null) {
            this.bZe.getPendantView().setIsRound(true);
            this.bZe.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.caM = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.caM.setAfterClickListener(this.caS);
        this.caO = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.caO.setVisibility(8);
        this.caP = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.bZh = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.caP.setChildClickListener(this.bZj);
        this.caP.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caP.setImageProcessor(fVar);
        this.caN = view.findViewById(d.g.divider_line_above_praise);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvE = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bZg = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.caR = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.bZg.a(this.caR, com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds120), 0);
        if (this.bvI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvI.setLayoutParams(layoutParams);
        }
        this.bvI.setOnClickListener(this.bZj);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setShareVisible(true);
        this.bvI.setFrom(1);
        this.bvI.setShareReportFrom(3);
        this.bvI.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.abt() != null) {
                    l.this.abt().a(view2, l.this.bZi);
                }
            }
        });
        this.bvL = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.bZf = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bZf.setOnClickListener(this.bZj);
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
            aj.k(this.caN, d.C0096d.transparent);
            this.caP.onChangeSkinType();
            this.bvI.onChangeSkinType();
            this.bZf.onChangeSkinType();
            this.bvE.onChangeSkinType();
            if (this.bZg != null) {
                this.bZg.onChangeSkinType();
            }
            aj.k(this.bZh, d.C0096d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        boolean z;
        if (lVar == null || lVar.Ox() == null) {
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
        if (this.bZg != null) {
            if (this.bZi.Xy != null && this.bZi.Xy.size() > 0) {
                ah ahVar = new ah();
                ahVar.cD(this.bZi.Ox().getTid());
                ahVar.setFid(this.bZi.Ox().getFid());
                ahVar.a(this.bZi.Xy);
                this.bZg.setData(ahVar);
                this.bZg.setFirstRowSingleColumn(true);
                if (lVar.threadData.rv() != null && !StringUtils.isNull(lVar.threadData.rv().getUserId())) {
                    if (lVar.threadData.rv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bZg.setVisibility(8);
                    } else if (this.bZg != null) {
                        this.bZg.setVisibility(this.caQ ? 0 : 8);
                    }
                }
            } else {
                this.bZg.setVisibility(8);
            }
        }
        this.bvE.setData(lVar.threadData);
        this.bZf.setFromCDN(this.ajh);
        this.bZf.setData(lVar.threadData.sM());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bZf.onChangeSkinType();
        if (!abx() && k.jP(this.bZi.threadData.getId())) {
            k.a(this.mTitle, this.bZi.Ox().getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            k.a(this.caO, this.bZi.threadData.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
            k.a(this.bZf.getGodReplyContent(), this.bZi.threadData.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
        }
        this.bvE.setUserAfterClickListener(this.aod);
        this.bvI.setData(lVar.threadData);
        this.mStType = k.rl();
        this.bvI.setStType(this.mStType);
        final bd Ox = lVar.Ox();
        if (this.bvE.getHeaderImg() != null) {
            if (this.bvE.getIsSimpleThread()) {
                this.bvE.getHeaderImg().setVisibility(8);
                this.bZe.setVisibility(8);
            } else if (Ox.rv() == null || Ox.rv().getPendantData() == null || StringUtils.isNull(Ox.rv().getPendantData().pR())) {
                this.bZe.setVisibility(8);
                this.bvE.getHeaderImg().setVisibility(0);
                this.bvE.getHeaderImg().setData(Ox);
            } else {
                this.bvE.getHeaderImg().setVisibility(4);
                this.bZe.setVisibility(0);
                this.bZe.setData(Ox);
            }
        }
        B(Ox);
        ArrayList<VoiceData.VoiceModel> rK = lVar.threadData.rK();
        if (com.baidu.tbadk.core.util.v.w(rK)) {
            this.caM.setVisibility(8);
            z = false;
        } else {
            this.caM.setVisibility(0);
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
        } else {
            ArrayList<MediaData> rG = Ox.rG();
            if (com.baidu.tbadk.core.h.oY().pe() && com.baidu.tbadk.core.util.v.v(rG) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < rG.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(rG, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.v(linkedList) > 0) {
                    this.caP.setVisibility(0);
                    this.caP.setFromCDN(this.ajh);
                    this.caP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.l.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            v<com.baidu.tieba.card.data.l> abt = l.this.abt();
                            if (abt != null) {
                                view.setTag("1");
                                abt.a(view, l.this.bZi);
                            }
                            if (z2) {
                                l.this.abM();
                            } else {
                                l.this.a(view, linkedList, i2, Ox);
                            }
                        }
                    });
                    this.caP.setImageMediaList(linkedList);
                } else {
                    this.caP.setVisibility(8);
                }
            } else {
                this.caP.setVisibility(8);
            }
        }
        abK();
        abL();
        setPageUniqueId(getTag());
    }

    private void abK() {
        if (this.caN != null && this.caP != null && this.bZf != null) {
            if (this.caP.getVisibility() == 8 && this.bZf.getVisibility() == 8) {
                this.caN.setVisibility(0);
            } else {
                this.caN.setVisibility(8);
            }
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
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
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

    public void setFromCDN(boolean z) {
        this.ajh = z;
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
        if (this.bZg != null) {
            this.bZg.setUniqueId(bdUniqueId);
        }
        if (this.bvE != null) {
            this.bvE.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.bZg != null) {
            this.bZg.setEventCallback(aVar);
        }
    }

    public View abv() {
        return this.bZf;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvE != null) {
            return this.bvE.anY;
        }
        return null;
    }

    public View abw() {
        if (this.bvE != null) {
            return this.bvE.anZ;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abM() {
        dO(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(boolean z) {
        if (this.bZi != null && this.bZi.threadData != null) {
            if (!abx()) {
                k.jO(this.bZi.threadData.getId());
                k.a(this.mTitle, this.bZi.Ox().getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
                k.a(this.caO, this.bZi.threadData.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
                k.a(this.bZf.getGodReplyContent(), this.bZi.threadData.getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bZi.threadData, null, k.rl(), 18003, true, false, false).addLocateParam(this.bZi.acf());
            addLocateParam.setForumId(String.valueOf(this.bZi.threadData.getFid()));
            addLocateParam.setForumName(this.bZi.threadData.rB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            k.jO(this.bZi.Ox().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
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

    public void dQ(boolean z) {
        if (this.bZh != null) {
            this.bZh.setVisibility(z ? 0 : 8);
        }
    }

    public void dR(boolean z) {
        this.caQ = z;
    }
}
