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
    private View aUp;
    private bl aiQ;
    private boolean aiq;
    private TbPageContext<?> ako;
    private final View.OnClickListener anD;
    private HeadPendantClickableView bEC;
    private ThreadGodReplyLayout bED;
    private View bEE;
    private View.OnClickListener bEI;
    private PlayVoiceBntNew bGq;
    private TextView bGr;
    private ConstrainImageGroup bGs;
    private final View.OnClickListener bGt;
    private ThreadUserInfoLayout bjL;
    private ThreadCommentAndPraiseInfoLayout bjP;
    private com.baidu.tieba.frs.h.g cnw;
    private String mForumName;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiq = true;
        this.bEI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.VZ() != null) {
                    l.this.VZ().a(view, l.this.aiQ);
                }
                l.this.dD(view == l.this.bED);
            }
        };
        this.bGt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bl> VZ = l.this.VZ();
                if (VZ != null) {
                    view.setTag("2");
                    VZ.a(view, l.this.aiQ);
                }
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.VZ() != null) {
                    l.this.VZ().a(view, l.this.aiQ);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.ako = tbPageContext;
        this.bEC = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bEC.getHeadView() != null) {
            this.bEC.getHeadView().setIsRound(true);
            this.bEC.getHeadView().setDrawBorder(false);
            this.bEC.getHeadView().setDefaultResource(17170445);
            this.bEC.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bEC.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bEC.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds70));
        }
        this.bEC.wt();
        if (this.bEC.getPendantView() != null) {
            this.bEC.getPendantView().setIsRound(true);
            this.bEC.getPendantView().setDrawBorder(false);
        }
        this.bEC.setAfterClickListener(this.anD);
        this.aUp = view.findViewById(d.h.divider_line);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bGq = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bGq.setAfterClickListener(this.bGt);
        this.bGr = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bGs = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bGs.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bGs.setChildClickListener(this.bEI);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bGs.setImageProcessor(fVar);
        this.bjP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bjL = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bjL.setUserAfterClickListener(this.anD);
        this.bjL.setFrom(3);
        this.bEE = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bjP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bjP.setLayoutParams(layoutParams);
        }
        this.bjP.setOnClickListener(this.bEI);
        this.bjP.setReplyTimeVisible(false);
        this.bjP.setShowPraiseNum(true);
        this.bjP.setNeedAddPraiseIcon(true);
        this.bjP.setNeedAddReplyIcon(true);
        this.bjP.setIsBarViewVisible(false);
        this.bjP.setReplyIcon(d.g.icon_home_card_comment_n);
        this.cnw = new com.baidu.tieba.frs.h.g(this.ako, this.bjL);
        this.cnw.setUniqueId(getTag());
        this.bED = (ThreadGodReplyLayout) view.findViewById(d.h.card_frs_god_reply_layout);
        this.bED.setOnClickListener(this.bEI);
    }

    public void setSingleImageRatio(double d) {
        if (this.bGs != null) {
            this.bGs.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bGs != null) {
            this.bGs.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bGs != null) {
            this.bGs.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            ai.k(this.aUp, d.e.cp_bg_line_c);
            this.bGs.onChangeSkinType();
            this.bjP.onChangeSkinType();
            this.bjL.onChangeSkinType();
            this.cnw.onChangeSkinType();
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
        this.aiQ = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bEI);
        }
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        this.bED.onChangeSkinType();
        if (!Wd() && m.iZ(this.aiQ.getId())) {
            m.a(this.mTitle, this.aiQ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGr, this.aiQ.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bED.getGodReplyContent(), this.aiQ.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bED.getPraiseNum(), this.aiQ.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cnw.P(this.aiQ);
        this.bjL.a(this.aiQ);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.ako.getResources().getDimension(d.f.ds10);
        this.bjP.setLayoutParams(layoutParams);
        this.bED.setFromCDN(this.aiq);
        this.bED.setData(this.aiQ.sK());
        this.bjL.setUserAfterClickListener(this.anD);
        this.bjP.a(blVar);
        this.bEE.setVisibility(0);
        this.mStType = m.rm();
        if (this.bjL.getHeaderImg() != null) {
            if (this.bjL.getIsSimpleThread()) {
                this.bjL.getHeaderImg().setVisibility(8);
                this.bEC.setVisibility(8);
            } else if (blVar.getAuthor() == null || blVar.getAuthor().getPendantData() == null || StringUtils.isNull(blVar.getAuthor().getPendantData().pL())) {
                this.bEC.setVisibility(8);
                this.bjL.getHeaderImg().setVisibility(0);
                this.bjL.getHeaderImg().setData(blVar);
            } else {
                this.bjL.getHeaderImg().setVisibility(4);
                this.bEC.setVisibility(0);
                this.bEC.setData(blVar);
            }
        }
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rt() == null || blVar.rt().size() == 0)) || blVar.rK() == 1) {
            blVar.e(false, true);
            if (blVar.rV() == null || StringUtils.isNull(blVar.rV().toString())) {
                this.mTitle.setVisibility(8);
                z = false;
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(blVar.rV());
                z = false;
            }
        } else {
            this.mTitle.setVisibility(0);
            blVar.XS = 0;
            blVar.e(false, blVar.ss());
            SpannableStringBuilder rV = blVar.rV();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(rV));
            this.mTitle.setText(rV);
            m.a(this.mTitle, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        if (blVar.rD() != null && !StringUtils.isNull(blVar.rD())) {
            sb.append(blVar.rD());
        }
        ArrayList<MediaData> rF = blVar.rF();
        if (rF != null) {
            i = rF.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rF.get(i2).getVideoUrl() != null && rF.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rF.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(blVar.g(sb.toString(), true))) {
                SpannableString cF = blVar.cF(sb.toString());
                this.bGr.setOnTouchListener(new com.baidu.tieba.view.l(cF));
                this.bGr.setText(cF);
                this.bGr.setVisibility(0);
                m.a(this.bGr, blVar.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                z3 = true;
            } else {
                this.bGr.setVisibility(8);
                z3 = false;
            }
            z2 = z3;
        } else {
            this.bGr.setVisibility(8);
            i = 0;
            z2 = false;
        }
        ArrayList<VoiceData.VoiceModel> rJ = blVar.rJ();
        if (u.v(rJ)) {
            this.bGq.setVisibility(8);
        } else {
            this.bGq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rJ.get(0);
            this.bGq.setVoiceModel(voiceModel);
            this.bGq.setTag(voiceModel);
            this.bGq.bhH();
            if (voiceModel != null) {
                this.bGq.mG(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oN().oT() && u.u(rF) != 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) u.c(rF, i3);
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
                this.bGs.setVisibility(0);
                this.bGs.setFromCDN(this.aiq);
                this.bGs.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i4, boolean z5) {
                        x<bl> VZ = l.this.VZ();
                        if (z5) {
                            if (VZ != null) {
                                view.setTag("1");
                                VZ.aSG = true;
                                VZ.a(view, l.this.aiQ);
                            }
                            l.this.dD(false);
                            return;
                        }
                        if (VZ != null) {
                            view.setTag("1");
                            VZ.aSG = false;
                            VZ.a(view, l.this.aiQ);
                        }
                        l.this.a(linkedList2, i4, blVar);
                    }
                });
                this.bGs.setImageUrls(linkedList);
                Wo();
                g(z, z2, z4);
            }
            this.bGs.setVisibility(8);
        } else {
            this.bGs.setVisibility(8);
        }
        z4 = false;
        Wo();
        g(z, z2, z4);
    }

    private void g(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitle.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bGr.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.bGs.getLayoutParams();
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
            com.baidu.adp.lib.util.k.showToast(this.ako.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aiq ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(blVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ako.getPageActivity()).createConfig(arrayList, i, blVar.rA(), String.valueOf(blVar.getFid()), blVar.getTid(), this.aiq, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Wo() {
        this.bGq.setClickable(true);
        int childCount = this.bGs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bGs.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aiq = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bjP != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bjL != null) {
            this.bjL.setPageUniqueId(bdUniqueId);
        }
        if (this.bGs != null) {
            this.bGs.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(boolean z) {
        if (this.aiQ != null) {
            m.iY(this.aiQ.getId());
            m.a(this.mTitle, this.aiQ.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGr, this.aiQ.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bED.getGodReplyContent(), this.aiQ.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bED.getPraiseNum(), this.aiQ.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            n sr = this.aiQ.sr();
            if (sr != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aM(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ako.getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.aiQ.YZ;
            if (this.aiQ.YY == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.Um;
                long j = kVar.Un;
                aq aqVar = new aq();
                aqVar.pageContext = this.ako;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ako.getPageActivity()).createFromThreadCfg(this.aiQ, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aiQ.getFid()));
            addLocateParam.setForumName(this.aiQ.rA());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ako.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Wd() {
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
        if (this.bGq != null) {
            this.bGq.setVoiceManager(voiceManager);
        }
    }
}
