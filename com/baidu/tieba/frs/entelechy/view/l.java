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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.card.a<bl> implements v {
    private View aVB;
    private boolean ajJ;
    private bl akj;
    private TbPageContext<?> alI;
    private final View.OnClickListener aoW;
    private HeadPendantClickableView bFM;
    private ThreadGodReplyLayout bFN;
    private View bFO;
    private View.OnClickListener bFS;
    private PlayVoiceBntNew bHA;
    private TextView bHB;
    private ConstrainImageGroup bHC;
    private final View.OnClickListener bHD;
    private ThreadUserInfoLayout bkV;
    private ThreadCommentAndPraiseInfoLayout bkZ;
    private com.baidu.tieba.frs.g.g coH;
    private String mForumName;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajJ = true;
        this.bFS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.We() != null) {
                    l.this.We().a(view, l.this.akj);
                }
                l.this.dD(view == l.this.bFN);
            }
        };
        this.bHD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bl> We = l.this.We();
                if (We != null) {
                    view.setTag("2");
                    We.a(view, l.this.akj);
                }
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.We() != null) {
                    l.this.We().a(view, l.this.akj);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.alI = tbPageContext;
        this.bFM = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bFM.getHeadView() != null) {
            this.bFM.getHeadView().setIsRound(true);
            this.bFM.getHeadView().setDrawBorder(false);
            this.bFM.getHeadView().setDefaultResource(17170445);
            this.bFM.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bFM.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bFM.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds70));
        }
        this.bFM.wD();
        if (this.bFM.getPendantView() != null) {
            this.bFM.getPendantView().setIsRound(true);
            this.bFM.getPendantView().setDrawBorder(false);
        }
        this.bFM.setAfterClickListener(this.aoW);
        this.aVB = view.findViewById(d.h.divider_line);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bHA = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bHA.setAfterClickListener(this.bHD);
        this.bHB = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bHC = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bHC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bHC.setChildClickListener(this.bFS);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bHC.setImageProcessor(fVar);
        this.bkZ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bkV = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bkV.setUserAfterClickListener(this.aoW);
        this.bkV.setFrom(3);
        this.bFO = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bkZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bkZ.setLayoutParams(layoutParams);
        }
        this.bkZ.setOnClickListener(this.bFS);
        this.bkZ.setReplyTimeVisible(false);
        this.bkZ.setShowPraiseNum(true);
        this.bkZ.setNeedAddPraiseIcon(true);
        this.bkZ.setNeedAddReplyIcon(true);
        this.bkZ.setIsBarViewVisible(false);
        this.bkZ.setReplyIcon(d.g.icon_home_card_comment_n);
        this.coH = new com.baidu.tieba.frs.g.g(this.alI, this.bkV);
        this.coH.setUniqueId(getTag());
        this.bFN = (ThreadGodReplyLayout) view.findViewById(d.h.card_frs_god_reply_layout);
        this.bFN.setOnClickListener(this.bFS);
    }

    public void setSingleImageRatio(double d) {
        if (this.bHC != null) {
            this.bHC.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bHC != null) {
            this.bHC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bHC != null) {
            this.bHC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            ai.k(this.aVB, d.e.cp_bg_line_c);
            this.bHC.onChangeSkinType();
            this.bkZ.onChangeSkinType();
            this.bkV.onChangeSkinType();
            this.coH.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: x */
    public void a(final bl blVar) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (blVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.akj = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bFS);
        }
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        this.bFN.onChangeSkinType();
        if (!Wi() && m.je(this.akj.getId())) {
            m.a(this.mTitle, this.akj.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bHB, this.akj.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bFN.getGodReplyContent(), this.akj.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bFN.getPraiseNum(), this.akj.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.coH.P(this.akj);
        this.bkV.a(this.akj);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.alI.getResources().getDimension(d.f.ds10);
        this.bkZ.setLayoutParams(layoutParams);
        this.bFN.setFromCDN(this.ajJ);
        this.bFN.setData(this.akj.sU());
        this.bkV.setUserAfterClickListener(this.aoW);
        this.bkZ.a(blVar);
        this.bFO.setVisibility(0);
        this.mStType = m.rw();
        if (this.bkV.getHeaderImg() != null) {
            if (this.bkV.getIsSimpleThread()) {
                this.bkV.getHeaderImg().setVisibility(8);
                this.bFM.setVisibility(8);
            } else if (blVar.getAuthor() == null || blVar.getAuthor().getPendantData() == null || StringUtils.isNull(blVar.getAuthor().getPendantData().pV())) {
                this.bFM.setVisibility(8);
                this.bkV.getHeaderImg().setVisibility(0);
                this.bkV.getHeaderImg().setData(blVar);
            } else {
                this.bkV.getHeaderImg().setVisibility(4);
                this.bFM.setVisibility(0);
                this.bFM.setData(blVar);
            }
        }
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rD() == null || blVar.rD().size() == 0)) || blVar.rU() == 1) {
            blVar.e(false, true);
            if (blVar.sf() == null || StringUtils.isNull(blVar.sf().toString())) {
                this.mTitle.setVisibility(8);
                z = false;
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(blVar.sf());
                z = false;
            }
        } else {
            this.mTitle.setVisibility(0);
            blVar.Zo = 0;
            blVar.e(false, blVar.sC());
            SpannableStringBuilder sf = blVar.sf();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(sf));
            this.mTitle.setText(sf);
            m.a(this.mTitle, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        if (blVar.rN() != null && !StringUtils.isNull(blVar.rN())) {
            sb.append(blVar.rN());
        }
        ArrayList<MediaData> rP = blVar.rP();
        if (rP != null) {
            i = rP.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rP.get(i2).getVideoUrl() != null && rP.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rP.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(blVar.g(sb.toString(), true))) {
                SpannableString cL = blVar.cL(sb.toString());
                this.bHB.setOnTouchListener(new com.baidu.tieba.view.l(cL));
                this.bHB.setText(cL);
                this.bHB.setVisibility(0);
                m.a(this.bHB, blVar.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                z3 = true;
            } else {
                this.bHB.setVisibility(8);
                z3 = false;
            }
            z2 = z3;
        } else {
            this.bHB.setVisibility(8);
            i = 0;
            z2 = false;
        }
        ArrayList<VoiceData.VoiceModel> rT = blVar.rT();
        if (u.v(rT)) {
            this.bHA.setVisibility(8);
        } else {
            this.bHA.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rT.get(0);
            this.bHA.setVoiceModel(voiceModel);
            this.bHA.setTag(voiceModel);
            this.bHA.bhR();
            if (voiceModel != null) {
                this.bHA.mG(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oX().pd() && u.u(rP) != 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) u.c(rP, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !al.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (u.u(linkedList) > 0) {
                this.bHC.setVisibility(0);
                this.bHC.setFromCDN(this.ajJ);
                this.bHC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i4, boolean z5) {
                        x<bl> We = l.this.We();
                        if (z5) {
                            if (We != null) {
                                view.setTag("1");
                                We.aTS = true;
                                We.a(view, l.this.akj);
                            }
                            l.this.dD(false);
                            return;
                        }
                        if (We != null) {
                            view.setTag("1");
                            We.aTS = false;
                            We.a(view, l.this.akj);
                        }
                        l.this.a(linkedList2, i4, blVar);
                    }
                });
                this.bHC.setImageUrls(linkedList);
                Wt();
                g(z, z2, z4);
            }
            this.bHC.setVisibility(8);
        } else {
            this.bHC.setVisibility(8);
        }
        z4 = false;
        Wt();
        g(z, z2, z4);
    }

    private void g(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitle.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bHB.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.bHC.getLayoutParams();
        if (!z && z2) {
            layoutParams2.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams3.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2);
            } else if (z) {
                layoutParams3.topMargin = 0;
            }
        } else if (z2) {
            layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds13);
        } else if (z) {
            layoutParams4.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.alI.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajJ ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(blVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.alI.getPageActivity()).createConfig(arrayList, i, blVar.rK(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Wt() {
        this.bHA.setClickable(true);
        int childCount = this.bHC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bHC.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajJ = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bkZ != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bkV != null) {
            this.bkV.setPageUniqueId(bdUniqueId);
        }
        if (this.bHC != null) {
            this.bHC.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        if (this.akj != null) {
            m.jd(this.akj.getId());
            m.a(this.mTitle, this.akj.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bHB, this.akj.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bFN.getGodReplyContent(), this.akj.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bFN.getPraiseNum(), this.akj.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            n sB = this.akj.sB();
            if (sB != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aN(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.alI.getPageActivity(), sB.getCartoonId(), sB.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.akj.aav;
            if (this.akj.aau == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.VL;
                long j = kVar.VM;
                aq aqVar = new aq();
                aqVar.pageContext = this.alI;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.alI.getPageActivity()).createFromThreadCfg(this.akj, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.akj.getFid()));
            addLocateParam.setForumName(this.akj.rK());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.alI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wi() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.bHA != null) {
            this.bHA.setVoiceManager(voiceManager);
        }
    }
}
