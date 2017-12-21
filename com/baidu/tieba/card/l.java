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
    private boolean ajk;
    private final View.OnClickListener aog;
    private HeadPendantClickableView bZi;
    private ThreadGodReplyLayout bZj;
    private com.baidu.tieba.NEGFeedBack.c bZk;
    private View bZl;
    private com.baidu.tieba.card.data.l bZm;
    private View.OnClickListener bZn;
    public ThreadUserInfoLayout bvI;
    public ThreadCommentAndPraiseInfoLayout bvM;
    protected LinearLayout bvP;
    public PlayVoiceBntNew caQ;
    private View caR;
    private TextView caS;
    private ConstrainImageGroup caT;
    private boolean caU;
    private RelativeLayout caV;
    private final View.OnClickListener caW;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bZk = null;
        this.mSkinType = 3;
        this.ajk = true;
        this.caU = true;
        this.bZn = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abt() != null) {
                    l.this.abt().a(view, l.this.bZm);
                }
                l.this.dO(view == l.this.bZj);
            }
        };
        this.caW = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.card.data.l> abt = l.this.abt();
                if (abt != null) {
                    view.setTag("2");
                    abt.a(view, l.this.bZm);
                }
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.abt() != null) {
                    l.this.abt().a(view, l.this.bZm);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.bZi = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.bZi.getHeadView() != null) {
            this.bZi.getHeadView().setIsRound(true);
            this.bZi.getHeadView().setDrawBorder(false);
            this.bZi.getHeadView().setDefaultResource(17170445);
            this.bZi.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZi.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.bZi.getHeadView().setRadius(com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.bZi.wi();
        if (this.bZi.getPendantView() != null) {
            this.bZi.getPendantView().setIsRound(true);
            this.bZi.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.caQ = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.caQ.setAfterClickListener(this.caW);
        this.caS = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.caS.setVisibility(8);
        this.caT = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.bZl = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.caT.setChildClickListener(this.bZn);
        this.caT.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.caT.setImageProcessor(fVar);
        this.caR = view.findViewById(d.g.divider_line_above_praise);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.bvI = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.bZk = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.caV = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.bZk.a(this.caV, com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds120), 0);
        if (this.bvM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvM.setLayoutParams(layoutParams);
        }
        this.bvM.setOnClickListener(this.bZn);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setShareVisible(true);
        this.bvM.setFrom(1);
        this.bvM.setShareReportFrom(3);
        this.bvM.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.abt() != null) {
                    l.this.abt().a(view2, l.this.bZm);
                }
            }
        });
        this.bvP = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.bZj = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.bZj.setOnClickListener(this.bZn);
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
            aj.k(this.caR, d.C0095d.transparent);
            this.caT.onChangeSkinType();
            this.bvM.onChangeSkinType();
            this.bZj.onChangeSkinType();
            this.bvI.onChangeSkinType();
            if (this.bZk != null) {
                this.bZk.onChangeSkinType();
            }
            aj.k(this.bZl, d.C0095d.cp_bg_line_e);
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
        this.bZm = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bZn);
        }
        if (this.bZk != null) {
            if (this.bZm.XB != null && this.bZm.XB.size() > 0) {
                ah ahVar = new ah();
                ahVar.cD(this.bZm.Ox().getTid());
                ahVar.setFid(this.bZm.Ox().getFid());
                ahVar.a(this.bZm.XB);
                this.bZk.setData(ahVar);
                this.bZk.setFirstRowSingleColumn(true);
                if (lVar.threadData.rv() != null && !StringUtils.isNull(lVar.threadData.rv().getUserId())) {
                    if (lVar.threadData.rv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.bZk.setVisibility(8);
                    } else if (this.bZk != null) {
                        this.bZk.setVisibility(this.caU ? 0 : 8);
                    }
                }
            } else {
                this.bZk.setVisibility(8);
            }
        }
        this.bvI.setData(lVar.threadData);
        this.bZj.setFromCDN(this.ajk);
        this.bZj.setData(lVar.threadData.sM());
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        this.bZj.onChangeSkinType();
        if (!abx() && k.jP(this.bZm.threadData.getId())) {
            k.a(this.mTitle, this.bZm.Ox().getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            k.a(this.caS, this.bZm.threadData.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
            k.a(this.bZj.getGodReplyContent(), this.bZm.threadData.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
        }
        this.bvI.setUserAfterClickListener(this.aog);
        this.bvM.setData(lVar.threadData);
        this.mStType = k.rl();
        this.bvM.setStType(this.mStType);
        final bd Ox = lVar.Ox();
        if (this.bvI.getHeaderImg() != null) {
            if (this.bvI.getIsSimpleThread()) {
                this.bvI.getHeaderImg().setVisibility(8);
                this.bZi.setVisibility(8);
            } else if (Ox.rv() == null || Ox.rv().getPendantData() == null || StringUtils.isNull(Ox.rv().getPendantData().pR())) {
                this.bZi.setVisibility(8);
                this.bvI.getHeaderImg().setVisibility(0);
                this.bvI.getHeaderImg().setData(Ox);
            } else {
                this.bvI.getHeaderImg().setVisibility(4);
                this.bZi.setVisibility(0);
                this.bZi.setData(Ox);
            }
        }
        B(Ox);
        ArrayList<VoiceData.VoiceModel> rK = lVar.threadData.rK();
        if (com.baidu.tbadk.core.util.v.w(rK)) {
            this.caQ.setVisibility(8);
            z = false;
        } else {
            this.caQ.setVisibility(0);
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
                    this.caT.setVisibility(0);
                    this.caT.setFromCDN(this.ajk);
                    this.caT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.l.2
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void c(View view, int i2, boolean z2) {
                            v<com.baidu.tieba.card.data.l> abt = l.this.abt();
                            if (abt != null) {
                                view.setTag("1");
                                abt.a(view, l.this.bZm);
                            }
                            if (z2) {
                                l.this.abM();
                            } else {
                                l.this.a(view, linkedList, i2, Ox);
                            }
                        }
                    });
                    this.caT.setImageMediaList(linkedList);
                } else {
                    this.caT.setVisibility(8);
                }
            } else {
                this.caT.setVisibility(8);
            }
        }
        abK();
        abL();
        setPageUniqueId(getTag());
    }

    private void abK() {
        if (this.caR != null && this.caT != null && this.bZj != null) {
            if (this.caT.getVisibility() == 8 && this.bZj.getVisibility() == 8) {
                this.caR.setVisibility(0);
            } else {
                this.caR.setVisibility(8);
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
                    imageUrlData.urlType = this.ajk ? 13 : 14;
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

    public void setFromCDN(boolean z) {
        this.ajk = z;
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
        if (this.bZk != null) {
            this.bZk.setUniqueId(bdUniqueId);
        }
        if (this.bvI != null) {
            this.bvI.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.bZk != null) {
            this.bZk.setEventCallback(aVar);
        }
    }

    public View abv() {
        return this.bZj;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.bvI != null) {
            return this.bvI.aob;
        }
        return null;
    }

    public View abw() {
        if (this.bvI != null) {
            return this.bvI.aoc;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abM() {
        dO(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(boolean z) {
        if (this.bZm != null && this.bZm.threadData != null) {
            if (!abx()) {
                k.jO(this.bZm.threadData.getId());
                k.a(this.mTitle, this.bZm.Ox().getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
                k.a(this.caS, this.bZm.threadData.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
                k.a(this.bZj.getGodReplyContent(), this.bZm.threadData.getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.bZm.threadData, null, k.rl(), 18003, true, false, false).addLocateParam(this.bZm.acf());
            addLocateParam.setForumId(String.valueOf(this.bZm.threadData.getFid()));
            addLocateParam.setForumName(this.bZm.threadData.rB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            k.jO(this.bZm.Ox().getTid());
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
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

    public void dQ(boolean z) {
        if (this.bZl != null) {
            this.bZl.setVisibility(z ? 0 : 8);
        }
    }

    public void dR(boolean z) {
        this.caU = z;
    }
}
