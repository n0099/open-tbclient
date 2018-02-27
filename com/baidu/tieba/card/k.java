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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
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
public class k extends a<com.baidu.tieba.card.data.k> {
    private boolean aYX;
    private final View.OnClickListener bdQ;
    private ThreadGodReplyLayout cVu;
    private View cVv;
    private com.baidu.tieba.card.data.k cVw;
    private View.OnClickListener cVx;
    public PlayVoiceBntNew cWQ;
    private View cWR;
    private TextView cWS;
    private ConstrainImageGroup cWT;
    private boolean cWU;
    private RelativeLayout cWV;
    private final View.OnClickListener cWW;
    public ThreadUserInfoLayout clW;
    public ThreadCommentAndPraiseInfoLayout clX;
    private HeadPendantClickableView cmI;
    public ThreadSourceShareAndPraiseLayout cmL;
    protected LinearLayout cmX;
    private com.baidu.tieba.NEGFeedBack.c cmj;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmj = null;
        this.mSkinType = 3;
        this.aYX = true;
        this.cWU = true;
        this.cVx = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.akO() != null) {
                    k.this.akO().a(view, k.this.cVw);
                }
                k.this.eI(view == k.this.cVu);
            }
        };
        this.cWW = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.card.data.k> akO = k.this.akO();
                if (akO != null) {
                    view.setTag("2");
                    akO.a(view, k.this.cVw);
                }
            }
        };
        this.bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.akO() != null) {
                    k.this.akO().a(view, k.this.cVw);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cmI = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmI.getHeadView() != null) {
            this.cmI.getHeadView().setIsRound(true);
            this.cmI.getHeadView().setDrawBorder(false);
            this.cmI.getHeadView().setDefaultResource(17170445);
            this.cmI.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmI.getHeadView().setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cmI.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmI.DS();
        if (this.cmI.getPendantView() != null) {
            this.cmI.getPendantView().setIsRound(true);
            this.cmI.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.g.card_home_page_normal_thread_title);
        this.cWQ = (PlayVoiceBntNew) view.findViewById(d.g.card_home_page_normal_thread_abstract_voice);
        this.cWQ.setAfterClickListener(this.cWW);
        this.cWS = (TextView) view.findViewById(d.g.card_home_page_normal_thread_abstract);
        this.cWS.setVisibility(8);
        this.cWT = (ConstrainImageGroup) view.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cVv = view.findViewById(d.g.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        this.cWT.setChildClickListener(this.cVx);
        this.cWT.setImageMargin(dimensionPixelSize);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.h(1.0d);
        this.cWT.setImageProcessor(fVar);
        this.cWR = view.findViewById(d.g.divider_line_above_praise);
        this.clX = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.clW = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.cmj = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cWV = (RelativeLayout) view.findViewById(d.g.card_home_page_normal_thread_root);
        this.cmj.a(this.cWV, com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds120), 0);
        if (this.clX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.clX.setLayoutParams(layoutParams);
        }
        this.clX.setOnClickListener(this.cVx);
        this.clX.setReplyTimeVisible(false);
        this.clX.setShowPraiseNum(true);
        this.clX.setNeedAddPraiseIcon(true);
        this.clX.setNeedAddReplyIcon(true);
        this.clX.setShareVisible(true);
        this.clX.setFrom(1);
        this.clX.setShareReportFrom(3);
        this.clX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.akO() != null) {
                    k.this.akO().a(view2, k.this.cVw);
                }
                if (k.this.cVw != null && k.this.cVw.threadData != null) {
                    j.kr(k.this.cVw.threadData.getId());
                    if (!k.this.akS()) {
                        j.a(k.this.mTitle, k.this.cVw.WD().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                        j.a(k.this.cWS, k.this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                        j.a(k.this.cVu.getGodReplyContent(), k.this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                    }
                }
            }
        });
        this.cmX = (LinearLayout) view.findViewById(d.g.card_home_page_normal_thread_content_layout);
        this.cVu = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cVu.setOnClickListener(this.cVx);
        this.cmL = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_home_page_source_read_share_layout);
        this.cmL.bem.setOnClickListener(this.cVx);
        this.cmL.setFrom(1);
        this.cmL.setShareReportFrom(3);
        this.cmL.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.akO() != null) {
                    k.this.akO().a(view2, k.this.cVw);
                }
                if (k.this.cVw != null && k.this.cVw.threadData != null && view2 != k.this.cmL.bel) {
                    j.kr(k.this.cVw.threadData.getId());
                    if (!k.this.akS()) {
                        j.a(k.this.mTitle, k.this.cVw.WD().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                        j.a(k.this.cWS, k.this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                        j.a(k.this.cVu.getGodReplyContent(), k.this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                    }
                }
            }
        });
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cWT != null) {
            this.cWT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cWT != null) {
            this.cWT.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.t(this.cWR, d.C0141d.transparent);
            this.cWT.onChangeSkinType();
            this.clX.onChangeSkinType();
            this.cVu.onChangeSkinType();
            this.clW.onChangeSkinType();
            if (this.cmj != null) {
                this.cmj.onChangeSkinType();
            }
            aj.t(this.cVv, d.C0141d.cp_bg_line_e);
            if (this.cmL != null) {
                this.cmL.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_multi_img_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        boolean z;
        if (kVar == null || kVar.WD() == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cVw = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVx);
        }
        if (this.cmj != null) {
            if (this.cVw.aNg != null && this.cVw.aNg.size() > 0) {
                ah ahVar = new ah();
                ahVar.cV(this.cVw.WD().getTid());
                ahVar.setFid(this.cVw.WD().getFid());
                ahVar.a(this.cVw.aNg);
                this.cmj.setData(ahVar);
                this.cmj.setFirstRowSingleColumn(true);
                if (kVar.threadData.zn() != null && !StringUtils.isNull(kVar.threadData.zn().getUserId())) {
                    if (kVar.threadData.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        this.cmj.setVisibility(8);
                    } else if (this.cmj != null) {
                        this.cmj.setVisibility(this.cWU ? 0 : 8);
                    }
                }
            } else {
                this.cmj.setVisibility(8);
            }
        }
        this.clW.setData(kVar.threadData);
        this.cVu.setFromCDN(this.aYX);
        this.cVu.setData(kVar.threadData.AA());
        if (!akS() && j.ks(this.cVw.threadData.getId())) {
            j.a(this.mTitle, this.cVw.WD().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
            j.a(this.cWS, this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            j.a(this.cVu.getGodReplyContent(), this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
        }
        this.clW.setUserAfterClickListener(this.bdQ);
        final bd WD = kVar.WD();
        if (this.clW.getHeaderImg() != null) {
            if (this.clW.getIsSimpleThread()) {
                this.clW.getHeaderImg().setVisibility(8);
                this.cmI.setVisibility(8);
            } else if (WD.zn() == null || WD.zn().getPendantData() == null || StringUtils.isNull(WD.zn().getPendantData().ya())) {
                this.cmI.setVisibility(8);
                this.clW.getHeaderImg().setVisibility(0);
                this.clW.getHeaderImg().setData(WD);
            } else {
                this.clW.getHeaderImg().setVisibility(4);
                this.cmI.setVisibility(0);
                this.cmI.setData(WD);
            }
        }
        G(WD);
        ArrayList<VoiceData.VoiceModel> zC = kVar.threadData.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cWQ.setVisibility(8);
            z = false;
        } else {
            this.cWQ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zC.get(0);
            this.cWQ.setVoiceModel(voiceModel);
            this.cWQ.setTag(voiceModel);
            this.cWQ.aNQ();
            if (voiceModel != null) {
                this.cWQ.qG(voiceModel.voice_status.intValue());
            }
            this.cWQ.bya();
            z = true;
        }
        if (this.cVw.cZZ && z) {
            this.cWT.setVisibility(8);
        } else {
            ArrayList<MediaData> zy = WD.zy();
            if (com.baidu.tbadk.core.i.xo().xu() && com.baidu.tbadk.core.util.v.D(zy) != 0) {
                final LinkedList linkedList = new LinkedList();
                for (int i = 0; i < zy.size(); i++) {
                    MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zy, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                    this.cWT.setVisibility(0);
                    this.cWT.setFromCDN(this.aYX);
                    this.cWT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.card.k.3
                        @Override // com.baidu.tbadk.widget.layout.d
                        public void f(View view, int i2, boolean z2) {
                            v<com.baidu.tieba.card.data.k> akO = k.this.akO();
                            if (akO != null) {
                                view.setTag("1");
                                akO.a(view, k.this.cVw);
                            }
                            if (z2) {
                                k.this.ali();
                            } else {
                                k.this.a(view, linkedList, i2, WD);
                            }
                        }
                    });
                    this.cWT.setImageMediaList(linkedList);
                } else {
                    this.cWT.setVisibility(8);
                }
            } else {
                this.cWT.setVisibility(8);
            }
        }
        alg();
        alh();
        setPageUniqueId(getTag());
        jX(WD.aQo);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void alg() {
        if (this.cWR != null && this.cWT != null && this.cVu != null) {
            if (this.cWT.getVisibility() == 8 && this.cVu.getVisibility() == 8) {
                this.cWR.setVisibility(0);
            } else {
                this.cWR.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
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
                    imageUrlData.urlType = this.aYX ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aYX, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void alh() {
        if (!this.cVw.btD) {
            this.cWQ.setClickable(false);
        } else {
            this.cWQ.setClickable(true);
        }
        int childCount = this.cWT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cWT.getChildAt(i);
            if (childAt != null) {
                if (!this.cVw.btD) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aYX = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cWT != null) {
            this.cWT.setPageUniqueId(bdUniqueId);
        }
        if (this.cmj != null) {
            this.cmj.setUniqueId(bdUniqueId);
        }
        if (this.clW != null) {
            this.clW.setPageUniqueId(bdUniqueId);
        }
    }

    public void a(c.a aVar) {
        if (this.cmj != null) {
            this.cmj.setEventCallback(aVar);
        }
    }

    public View akQ() {
        return this.cVu;
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.clW != null) {
            return this.clW.bdL;
        }
        return null;
    }

    public View akR() {
        if (this.clW != null) {
            return this.clW.bdM;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ali() {
        eI(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.cVw != null && this.cVw.threadData != null) {
            if (!akS()) {
                j.kr(this.cVw.threadData.getId());
                j.a(this.mTitle, this.cVw.WD().getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
                j.a(this.cWS, this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
                j.a(this.cVu.getGodReplyContent(), this.cVw.threadData.getId(), d.C0141d.cp_cont_f, d.C0141d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVw.threadData, null, j.zd(), 18003, true, false, false).addLocateParam(this.cVw.alB());
            addLocateParam.setForumId(String.valueOf(this.cVw.threadData.getFid()));
            addLocateParam.setForumName(this.cVw.threadData.zt());
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            j.kr(this.cVw.WD().getTid());
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akS() {
        return this.cVw.cZZ && !this.cVw.btD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private boolean G(bd bdVar) {
        SpannableStringBuilder j = bdVar.j(false, true);
        if (j == null || StringUtils.isNull(j.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.m(j));
            this.mTitle.setText(j);
            j.a(this.mTitle, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        }
        return true;
    }

    public void eK(boolean z) {
        if (this.cVv != null) {
            this.cVv.setVisibility(z ? 0 : 8);
        }
    }

    public void eL(boolean z) {
        this.cWU = z;
    }

    public void jX(int i) {
        if (this.cVw != null && this.cVw.threadData != null) {
            this.mStType = j.zd();
            if (i == 1) {
                this.clX.setVisibility(8);
                this.cmL.setStType(this.mStType);
                this.cmL.setData(this.cVw.threadData);
                this.clW.showForumNameView(false);
                return;
            }
            this.clX.setData(this.cVw.threadData);
            this.clX.setStType(this.mStType);
            this.cmL.setVisibility(8);
            this.clW.showForumNameView(true);
        }
    }
}
