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
    private View aVD;
    private boolean ajL;
    private bl akl;
    private final View.OnClickListener aoX;
    private View.OnClickListener bGC;
    private HeadPendantClickableView bGw;
    private ThreadGodReplyLayout bGx;
    private View bGy;
    private PlayVoiceBntNew bIk;
    private TextView bIl;
    private ConstrainImageGroup bIm;
    private final View.OnClickListener bIn;
    private ThreadUserInfoLayout bla;
    private ThreadCommentAndPraiseInfoLayout ble;
    private com.baidu.tieba.frs.g.g cpq;
    private String mForumName;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;
    private TbPageContext<?> oW;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajL = true;
        this.bGC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.Wx() != null) {
                    l.this.Wx().a(view, l.this.akl);
                }
                l.this.dE(view == l.this.bGx);
            }
        };
        this.bIn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bl> Wx = l.this.Wx();
                if (Wx != null) {
                    view.setTag("2");
                    Wx.a(view, l.this.akl);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.Wx() != null) {
                    l.this.Wx().a(view, l.this.akl);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.oW = tbPageContext;
        this.bGw = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bGw.getHeadView() != null) {
            this.bGw.getHeadView().setIsRound(true);
            this.bGw.getHeadView().setDrawBorder(false);
            this.bGw.getHeadView().setDefaultResource(17170445);
            this.bGw.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGw.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGw.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds70));
        }
        this.bGw.wE();
        if (this.bGw.getPendantView() != null) {
            this.bGw.getPendantView().setIsRound(true);
            this.bGw.getPendantView().setDrawBorder(false);
        }
        this.bGw.setAfterClickListener(this.aoX);
        this.aVD = view.findViewById(d.h.divider_line);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bIk = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bIk.setAfterClickListener(this.bIn);
        this.bIl = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bIm = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bIm.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bIm.setChildClickListener(this.bGC);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bIm.setImageProcessor(fVar);
        this.ble = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bla = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bla.setUserAfterClickListener(this.aoX);
        this.bla.setFrom(3);
        this.bGy = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.ble.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.ble.setLayoutParams(layoutParams);
        }
        this.ble.setOnClickListener(this.bGC);
        this.ble.setReplyTimeVisible(false);
        this.ble.setShowPraiseNum(true);
        this.ble.setNeedAddPraiseIcon(true);
        this.ble.setNeedAddReplyIcon(true);
        this.ble.setIsBarViewVisible(false);
        this.ble.setReplyIcon(d.g.icon_home_card_comment_n);
        this.cpq = new com.baidu.tieba.frs.g.g(this.oW, this.bla);
        this.cpq.setUniqueId(getTag());
        this.bGx = (ThreadGodReplyLayout) view.findViewById(d.h.card_frs_god_reply_layout);
        this.bGx.setOnClickListener(this.bGC);
    }

    public void setSingleImageRatio(double d) {
        if (this.bIm != null) {
            this.bIm.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bIm != null) {
            this.bIm.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bIm != null) {
            this.bIm.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            ai.k(this.aVD, d.e.cp_bg_line_c);
            this.bIm.onChangeSkinType();
            this.ble.onChangeSkinType();
            this.bla.onChangeSkinType();
            this.cpq.onChangeSkinType();
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
        this.akl = blVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bGC);
        }
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
        this.bGx.onChangeSkinType();
        if (!WB() && m.ji(this.akl.getId())) {
            m.a(this.mTitle, this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIl, this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGx.getGodReplyContent(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGx.getPraiseNum(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cpq.P(this.akl);
        this.bla.a(this.akl);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.oW.getResources().getDimension(d.f.ds10);
        this.ble.setLayoutParams(layoutParams);
        this.bGx.setFromCDN(this.ajL);
        this.bGx.setData(this.akl.sV());
        this.bla.setUserAfterClickListener(this.aoX);
        this.ble.a(blVar);
        this.bGy.setVisibility(0);
        this.mStType = m.rx();
        if (this.bla.getHeaderImg() != null) {
            if (this.bla.getIsSimpleThread()) {
                this.bla.getHeaderImg().setVisibility(8);
                this.bGw.setVisibility(8);
            } else if (blVar.getAuthor() == null || blVar.getAuthor().getPendantData() == null || StringUtils.isNull(blVar.getAuthor().getPendantData().pW())) {
                this.bGw.setVisibility(8);
                this.bla.getHeaderImg().setVisibility(0);
                this.bla.getHeaderImg().setData(blVar);
            } else {
                this.bla.getHeaderImg().setVisibility(4);
                this.bGw.setVisibility(0);
                this.bGw.setData(blVar);
            }
        }
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rE() == null || blVar.rE().size() == 0)) || blVar.rV() == 1) {
            blVar.e(false, true);
            if (blVar.sg() == null || StringUtils.isNull(blVar.sg().toString())) {
                this.mTitle.setVisibility(8);
                z = false;
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(blVar.sg());
                z = false;
            }
        } else {
            this.mTitle.setVisibility(0);
            blVar.Zr = 0;
            blVar.e(false, blVar.sD());
            SpannableStringBuilder sg = blVar.sg();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.l(sg));
            this.mTitle.setText(sg);
            m.a(this.mTitle, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        if (blVar.rO() != null && !StringUtils.isNull(blVar.rO())) {
            sb.append(blVar.rO());
        }
        ArrayList<MediaData> rQ = blVar.rQ();
        if (rQ != null) {
            i = rQ.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rQ.get(i2).getVideoUrl() != null && rQ.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rQ.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(blVar.g(sb.toString(), true))) {
                SpannableString cO = blVar.cO(sb.toString());
                this.bIl.setOnTouchListener(new com.baidu.tieba.view.l(cO));
                this.bIl.setText(cO);
                this.bIl.setVisibility(0);
                m.a(this.bIl, blVar.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                z3 = true;
            } else {
                this.bIl.setVisibility(8);
                z3 = false;
            }
            z2 = z3;
        } else {
            this.bIl.setVisibility(8);
            i = 0;
            z2 = false;
        }
        ArrayList<VoiceData.VoiceModel> rU = blVar.rU();
        if (u.v(rU)) {
            this.bIk.setVisibility(8);
        } else {
            this.bIk.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rU.get(0);
            this.bIk.setVoiceModel(voiceModel);
            this.bIk.setTag(voiceModel);
            this.bIk.bis();
            if (voiceModel != null) {
                this.bIk.mQ(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.h.oY().pe() && u.u(rQ) != 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) u.c(rQ, i3);
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
                this.bIm.setVisibility(0);
                this.bIm.setFromCDN(this.ajL);
                this.bIm.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i4, boolean z5) {
                        x<bl> Wx = l.this.Wx();
                        if (z5) {
                            if (Wx != null) {
                                view.setTag("1");
                                Wx.aTU = true;
                                Wx.a(view, l.this.akl);
                            }
                            l.this.dE(false);
                            return;
                        }
                        if (Wx != null) {
                            view.setTag("1");
                            Wx.aTU = false;
                            Wx.a(view, l.this.akl);
                        }
                        l.this.a(linkedList2, i4, blVar);
                    }
                });
                this.bIm.setImageUrls(linkedList);
                WM();
                h(z, z2, z4);
            }
            this.bIm.setVisibility(8);
        } else {
            this.bIm.setVisibility(8);
        }
        z4 = false;
        WM();
        h(z, z2, z4);
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitle.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bIl.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ble.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.bIm.getLayoutParams();
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
            com.baidu.adp.lib.util.k.showToast(this.oW.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajL ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.oW.getPageActivity()).createConfig(arrayList, i, blVar.rL(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajL, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void WM() {
        this.bIk.setClickable(true);
        int childCount = this.bIm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIm.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajL = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ble != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bla != null) {
            this.bla.setPageUniqueId(bdUniqueId);
        }
        if (this.bIm != null) {
            this.bIm.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(boolean z) {
        if (this.akl != null) {
            m.jh(this.akl.getId());
            m.a(this.mTitle, this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIl, this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGx.getGodReplyContent(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGx.getPraiseNum(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            n sC = this.akl.sC();
            if (sC != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aN(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.oW.getPageActivity(), sC.getCartoonId(), sC.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.akl.aax;
            if (this.akl.aaw == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.VO;
                long j = kVar.VP;
                aq aqVar = new aq();
                aqVar.pageContext = this.oW;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.oW.getPageActivity()).createFromThreadCfg(this.akl, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.akl.getFid()));
            addLocateParam.setForumName(this.akl.rL());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.oW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean WB() {
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
        if (this.bIk != null) {
            this.bIk.setVoiceManager(voiceManager);
        }
    }
}
