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
    private View aVC;
    private boolean ajL;
    private bl akl;
    private final View.OnClickListener aoX;
    private View.OnClickListener bGB;
    private HeadPendantClickableView bGv;
    private ThreadGodReplyLayout bGw;
    private View bGx;
    private PlayVoiceBntNew bIj;
    private TextView bIk;
    private ConstrainImageGroup bIl;
    private final View.OnClickListener bIm;
    private ThreadUserInfoLayout bkZ;
    private ThreadCommentAndPraiseInfoLayout bld;
    private com.baidu.tieba.frs.g.g cpp;
    private String mForumName;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;
    private TbPageContext<?> oV;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajL = true;
        this.bGB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.WA() != null) {
                    l.this.WA().a(view, l.this.akl);
                }
                l.this.dE(view == l.this.bGw);
            }
        };
        this.bIm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<bl> WA = l.this.WA();
                if (WA != null) {
                    view.setTag("2");
                    WA.a(view, l.this.akl);
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.WA() != null) {
                    l.this.WA().a(view, l.this.akl);
                }
            }
        };
        View view = getView();
        setTag(bdUniqueId);
        this.oV = tbPageContext;
        this.bGv = (HeadPendantClickableView) view.findViewById(d.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bGv.getHeadView() != null) {
            this.bGv.getHeadView().setIsRound(true);
            this.bGv.getHeadView().setDrawBorder(false);
            this.bGv.getHeadView().setDefaultResource(17170445);
            this.bGv.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bGv.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bGv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds70));
        }
        this.bGv.wD();
        if (this.bGv.getPendantView() != null) {
            this.bGv.getPendantView().setIsRound(true);
            this.bGv.getPendantView().setDrawBorder(false);
        }
        this.bGv.setAfterClickListener(this.aoX);
        this.aVC = view.findViewById(d.h.divider_line);
        this.mTitle = (TextView) view.findViewById(d.h.card_home_page_normal_thread_title);
        this.bIj = (PlayVoiceBntNew) view.findViewById(d.h.card_home_page_normal_thread_abstract_voice);
        this.bIj.setAfterClickListener(this.bIm);
        this.bIk = (TextView) view.findViewById(d.h.card_home_page_normal_thread_abstract);
        this.bIl = (ConstrainImageGroup) view.findViewById(d.h.card_home_page_normal_thread_img_layout);
        this.bIl.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16));
        this.bIl.setChildClickListener(this.bGB);
        com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
        fVar.e(1.0d);
        this.bIl.setImageProcessor(fVar);
        this.bld = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_info_layout);
        this.bkZ = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_normal_thread_user_info_layout);
        this.bkZ.setUserAfterClickListener(this.aoX);
        this.bkZ.setFrom(3);
        this.bGx = view.findViewById(d.h.divider_below_reply_number_layout);
        if (this.bld.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bld.setLayoutParams(layoutParams);
        }
        this.bld.setOnClickListener(this.bGB);
        this.bld.setReplyTimeVisible(false);
        this.bld.setShowPraiseNum(true);
        this.bld.setNeedAddPraiseIcon(true);
        this.bld.setNeedAddReplyIcon(true);
        this.bld.setIsBarViewVisible(false);
        this.bld.setReplyIcon(d.g.icon_home_card_comment_n);
        this.cpp = new com.baidu.tieba.frs.g.g(this.oV, this.bkZ);
        this.cpp.setUniqueId(getTag());
        this.bGw = (ThreadGodReplyLayout) view.findViewById(d.h.card_frs_god_reply_layout);
        this.bGw.setOnClickListener(this.bGB);
    }

    public void setSingleImageRatio(double d) {
        if (this.bIl != null) {
            this.bIl.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bIl != null) {
            this.bIl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bIl != null) {
            this.bIl.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.addresslist_item_bg);
            ai.k(this.aVC, d.e.cp_bg_line_c);
            this.bIl.onChangeSkinType();
            this.bld.onChangeSkinType();
            this.bkZ.onChangeSkinType();
            this.cpp.onChangeSkinType();
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
            getView().setOnClickListener(this.bGB);
        }
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        this.bGw.onChangeSkinType();
        if (!WE() && m.jf(this.akl.getId())) {
            m.a(this.mTitle, this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIk, this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGw.getGodReplyContent(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGw.getPraiseNum(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cpp.P(this.akl);
        this.bkZ.a(this.akl);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.oV.getResources().getDimension(d.f.ds10);
        this.bld.setLayoutParams(layoutParams);
        this.bGw.setFromCDN(this.ajL);
        this.bGw.setData(this.akl.sU());
        this.bkZ.setUserAfterClickListener(this.aoX);
        this.bld.a(blVar);
        this.bGx.setVisibility(0);
        this.mStType = m.rw();
        if (this.bkZ.getHeaderImg() != null) {
            if (this.bkZ.getIsSimpleThread()) {
                this.bkZ.getHeaderImg().setVisibility(8);
                this.bGv.setVisibility(8);
            } else if (blVar.getAuthor() == null || blVar.getAuthor().getPendantData() == null || StringUtils.isNull(blVar.getAuthor().getPendantData().pV())) {
                this.bGv.setVisibility(8);
                this.bkZ.getHeaderImg().setVisibility(0);
                this.bkZ.getHeaderImg().setData(blVar);
            } else {
                this.bkZ.getHeaderImg().setVisibility(4);
                this.bGv.setVisibility(0);
                this.bGv.setData(blVar);
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
            blVar.Zq = 0;
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
                this.bIk.setOnTouchListener(new com.baidu.tieba.view.l(cL));
                this.bIk.setText(cL);
                this.bIk.setVisibility(0);
                m.a(this.bIk, blVar.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                z3 = true;
            } else {
                this.bIk.setVisibility(8);
                z3 = false;
            }
            z2 = z3;
        } else {
            this.bIk.setVisibility(8);
            i = 0;
            z2 = false;
        }
        ArrayList<VoiceData.VoiceModel> rT = blVar.rT();
        if (u.v(rT)) {
            this.bIj.setVisibility(8);
        } else {
            this.bIj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rT.get(0);
            this.bIj.setVoiceModel(voiceModel);
            this.bIj.setTag(voiceModel);
            this.bIj.bix();
            if (voiceModel != null) {
                this.bIj.mQ(voiceModel.voice_status.intValue());
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
                this.bIl.setVisibility(0);
                this.bIl.setFromCDN(this.ajL);
                this.bIl.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.entelechy.view.l.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i4, boolean z5) {
                        x<bl> WA = l.this.WA();
                        if (z5) {
                            if (WA != null) {
                                view.setTag("1");
                                WA.aTT = true;
                                WA.a(view, l.this.akl);
                            }
                            l.this.dE(false);
                            return;
                        }
                        if (WA != null) {
                            view.setTag("1");
                            WA.aTT = false;
                            WA.a(view, l.this.akl);
                        }
                        l.this.a(linkedList2, i4, blVar);
                    }
                });
                this.bIl.setImageUrls(linkedList);
                WP();
                h(z, z2, z4);
            }
            this.bIl.setVisibility(8);
        } else {
            this.bIl.setVisibility(8);
        }
        z4 = false;
        WP();
        h(z, z2, z4);
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitle.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bIk.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bld.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.bIl.getLayoutParams();
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
            com.baidu.adp.lib.util.k.showToast(this.oV.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.oV.getPageActivity()).createConfig(arrayList, i, blVar.rK(), String.valueOf(blVar.getFid()), blVar.getTid(), this.ajL, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void WP() {
        this.bIj.setClickable(true);
        int childCount = this.bIl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bIl.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ajL = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bld != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bkZ != null) {
            this.bkZ.setPageUniqueId(bdUniqueId);
        }
        if (this.bIl != null) {
            this.bIl.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(boolean z) {
        if (this.akl != null) {
            m.je(this.akl.getId());
            m.a(this.mTitle, this.akl.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bIk, this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGw.getGodReplyContent(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            m.a(this.bGw.getPraiseNum(), this.akl.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            n sB = this.akl.sB();
            if (sB != null) {
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    aw.aN(this.mContext);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.oV.getPageActivity(), sB.getCartoonId(), sB.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.k kVar = this.akl.aax;
            if (this.akl.aaw == 1 && kVar != null && TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = kVar.VN;
                long j = kVar.VO;
                aq aqVar = new aq();
                aqVar.pageContext = this.oV;
                aqVar.bookId = str;
                aqVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.oV.getPageActivity()).createFromThreadCfg(this.akl, null, "frs_page", 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.akl.getFid()));
            addLocateParam.setForumName(this.akl.rK());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.oV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean WE() {
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
        if (this.bIj != null) {
            this.bIj.setVoiceManager(voiceManager);
        }
    }
}
