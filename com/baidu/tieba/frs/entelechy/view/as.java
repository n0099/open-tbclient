package com.baidu.tieba.frs.entelechy.view;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class as extends com.baidu.tieba.card.a<bk> implements cb {
    private View aUr;
    private bk ahV;
    private boolean ahv;
    private TbPageContext<?> ajr;
    private final View.OnClickListener amk;
    private com.baidu.tieba.frs.e.ae bTy;
    private ThreadUserInfoLayout bcp;
    private ThreadCommentAndPraiseInfoLayout bcq;
    private View buR;
    private HeadPendantClickableView buV;
    private PlayVoiceBntNew bvC;
    private ThreadGodReplyLayout bvD;
    private TextView bvF;
    private ConstrainImageGroup bvG;
    private View.OnClickListener bvI;
    private final View.OnClickListener bvJ;
    private String mForumName;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public as(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ahv = true;
        this.bvI = new at(this);
        this.bvJ = new au(this);
        this.amk = new av(this);
        View view = getView();
        setTag(bdUniqueId);
        this.ajr = tbPageContext;
        this.buV = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        if (this.buV.getHeadView() != null) {
            this.buV.getHeadView().setIsRound(true);
            this.buV.getHeadView().setDrawBorder(false);
            this.buV.getHeadView().setDefaultResource(17170445);
            this.buV.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.buV.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.buV.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds70));
        }
        this.buV.vY();
        if (this.buV.getPendantView() != null) {
            this.buV.getPendantView().setIsRound(true);
            this.buV.getPendantView().setDrawBorder(false);
        }
        this.aUr = view.findViewById(w.h.divider_line);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bvC = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bvC.setAfterClickListener(this.bvJ);
        this.bvF = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bvG = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bvG.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds8));
        this.bvG.setChildClickListener(this.bvI);
        com.baidu.tbadk.widget.layout.i iVar = new com.baidu.tbadk.widget.layout.i(3);
        iVar.c(1.0d);
        this.bvG.setImageProcessor(iVar);
        this.bcq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bcp = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_user_info_layout);
        this.buR = view.findViewById(w.h.divider_below_reply_number_layout);
        if (this.bcq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcq.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bcq.setLayoutParams(layoutParams);
        }
        this.bcq.setOnClickListener(this.bvI);
        this.bcq.setReplyTimeVisible(false);
        this.bcq.setShowPraiseNum(true);
        this.bcq.setNeedAddPraiseIcon(true);
        this.bcq.setNeedAddReplyIcon(true);
        this.bcq.setIsBarViewVisible(false);
        this.bcq.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bcq.setPraiseIcon(w.g.icon_home_card_like_n);
        this.bTy = new com.baidu.tieba.frs.e.ae(this.ajr, this.bcp);
        this.bTy.setUniqueId(getTag());
        this.bvD = (ThreadGodReplyLayout) view.findViewById(w.h.card_frs_god_reply_layout);
        this.bvD.setOnClickListener(this.bvI);
    }

    public void setSingleImageRatio(double d) {
        if (this.bvG != null) {
            this.bvG.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bvG != null) {
            this.bvG.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bvG != null) {
            this.bvG.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.aUr, w.e.cp_bg_line_c);
            this.bvG.onChangeSkinType();
            this.bcq.onChangeSkinType();
            this.bcp.onChangeSkinType();
            this.bTy.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: p */
    public void onBindDataToView(bk bkVar) {
        boolean z;
        int i;
        boolean z2;
        boolean z3 = false;
        if (bkVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ahV = bkVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bvI);
        }
        if (!Te() && com.baidu.tieba.card.ap.hZ(this.ahV.getId())) {
            com.baidu.tieba.card.ap.a(this.mTitle, this.ahV.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.ap.a(this.bvF, this.ahV.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.ap.a(this.bvD.getGodReplyContent(), this.ahV.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.ap.a(this.bvD.getPraiseNum(), this.ahV.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        }
        this.bTy.F(this.ahV);
        this.bcp.a(this.ahV);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcq.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.ajr.getResources().getDimension(w.f.ds10);
        this.bcq.setLayoutParams(layoutParams);
        this.bvD.setData(this.ahV.sI());
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        this.bvD.onChangeSkinType();
        this.bcp.setUserAfterClickListener(this.amk);
        this.bcq.a(bkVar);
        this.buR.setVisibility(0);
        this.mStType = com.baidu.tieba.card.ap.rp();
        if (this.bcp.getHeaderImg() != null) {
            if (this.bcp.getIsSimpleThread()) {
                this.bcp.getHeaderImg().setVisibility(8);
                this.buV.setVisibility(8);
            } else if (bkVar.getAuthor() == null || bkVar.getAuthor().getPendantData() == null || StringUtils.isNull(bkVar.getAuthor().getPendantData().pT())) {
                this.buV.setVisibility(8);
                this.bcp.getHeaderImg().setVisibility(0);
                this.bcp.getHeaderImg().setData(bkVar);
            } else {
                this.bcp.getHeaderImg().setVisibility(4);
                this.buV.setVisibility(0);
                this.buV.setData(bkVar);
            }
        }
        if ((StringUtils.isNull(bkVar.getTitle()) && (bkVar.rx() == null || bkVar.rx().size() == 0)) || bkVar.rN() == 1) {
            this.mTitle.setVisibility(8);
            z = false;
        } else {
            this.mTitle.setVisibility(0);
            bkVar.XF = 0;
            bkVar.e(false, bkVar.sv());
            SpannableStringBuilder rY = bkVar.rY();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.aa(rY));
            this.mTitle.setText(rY);
            com.baidu.tieba.card.ap.a(this.mTitle, bkVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        if (bkVar.rG() != null && !StringUtils.isNull(bkVar.rG())) {
            sb.append(bkVar.rG());
        }
        ArrayList<MediaData> rI = bkVar.rI();
        if (rI != null) {
            i = rI.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rI.get(i2).getVideoUrl() != null && rI.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rI.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bkVar.g(sb.toString(), true))) {
                SpannableString cv = bkVar.cv(sb.toString());
                this.bvF.setOnTouchListener(new com.baidu.tieba.view.aa(cv));
                this.bvF.setText(cv);
                this.bvF.setVisibility(0);
                com.baidu.tieba.card.ap.a(this.bvF, bkVar.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                z2 = true;
            } else {
                this.bvF.setVisibility(8);
                z2 = false;
            }
        } else {
            this.bvF.setVisibility(8);
            i = 0;
            z2 = false;
        }
        ArrayList<VoiceData.VoiceModel> rM = bkVar.rM();
        if (com.baidu.tbadk.core.util.x.r(rM)) {
            this.bvC.setVisibility(8);
        } else {
            this.bvC.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rM.get(0);
            this.bvC.setVoiceModel(voiceModel);
            this.bvC.setTag(voiceModel);
            this.bvC.aYC();
            if (voiceModel != null) {
                this.bvC.lT(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.r.oV().pb() && com.baidu.tbadk.core.util.x.q(rI) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(rI, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.au.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.q(linkedList) > 0) {
                this.bvG.setVisibility(0);
                this.bvG.setFromCDN(this.ahv);
                this.bvG.setImageClickListener(new aw(this, linkedList2, bkVar));
                this.bvG.setImageUrls(linkedList);
                z3 = true;
            } else {
                this.bvG.setVisibility(8);
            }
        } else {
            this.bvG.setVisibility(8);
        }
        Ti();
        d(z, z2, z3);
    }

    private void d(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitle.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bvF.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bcq.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.bvG.getLayoutParams();
        if (!z && z2) {
            layoutParams2.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2);
            } else if (z) {
                layoutParams3.topMargin = 0;
            }
        } else if (z2) {
            layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds13);
        } else if (z) {
            layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bk bkVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajr.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahv ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bkVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajr.getPageActivity()).createConfig(arrayList, i, bkVar.rD(), String.valueOf(bkVar.getFid()), bkVar.getTid(), this.ahv, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Ti() {
        this.bvC.setClickable(true);
        int childCount = this.bvG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvG.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahv = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bcq != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bcp != null) {
            this.bcp.setPageUniqueId(bdUniqueId);
        }
        if (this.bvG != null) {
            this.bvG.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(boolean z) {
        if (this.ahV != null) {
            com.baidu.tieba.card.ap.hY(this.ahV.getId());
            com.baidu.tieba.card.ap.a(this.mTitle, this.ahV.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.ap.a(this.bvF, this.ahV.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.ap.a(this.bvD.getGodReplyContent(), this.ahV.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.ap.a(this.bvD.getPraiseNum(), this.ahV.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tbadk.core.data.n su = this.ahV.su();
            if (su != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajr.getPageActivity(), su.getCartoonId(), su.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.ahV.YL;
            if (this.ahV.YK == 1 && kVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Uk;
                long j = kVar.Ul;
                com.baidu.tbadk.core.data.ap apVar = new com.baidu.tbadk.core.data.ap();
                apVar.pageContext = this.ajr;
                apVar.bookId = str;
                apVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, apVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajr.getPageActivity()).createFromThreadCfg(this.ahV, null, com.baidu.tieba.card.ap.rp(), 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ahV.getFid()));
            addLocateParam.setForumName(this.ahV.rD());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ajr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Te() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.cb
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.bvC != null) {
            this.bvC.setVoiceManager(voiceManager);
        }
    }
}
