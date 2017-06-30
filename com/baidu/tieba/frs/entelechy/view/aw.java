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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class aw extends com.baidu.tieba.card.a<bm> implements cg {
    private View aTm;
    private boolean ahU;
    private bm aiu;
    private TbPageContext<?> ajP;
    private final View.OnClickListener amS;
    private View.OnClickListener bAB;
    private HeadPendantClickableView bAv;
    private ThreadGodReplyLayout bAw;
    private View bAx;
    private PlayVoiceBntNew bCj;
    private TextView bCk;
    private ConstrainImageGroup bCl;
    private final View.OnClickListener bCm;
    private ThreadUserInfoLayout bgE;
    private ThreadCommentAndPraiseInfoLayout bgF;
    private com.baidu.tieba.frs.f.v chz;
    private String mForumName;
    private int mSkinType;
    private String mStType;
    private TextView mTitle;

    public aw(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ahU = true;
        this.bAB = new ax(this);
        this.bCm = new ay(this);
        this.amS = new az(this);
        View view = getView();
        setTag(bdUniqueId);
        this.ajP = tbPageContext;
        this.bAv = (HeadPendantClickableView) view.findViewById(w.h.card_home_page_normal_thread_user_pendant_header);
        if (this.bAv.getHeadView() != null) {
            this.bAv.getHeadView().setIsRound(true);
            this.bAv.getHeadView().setDrawBorder(false);
            this.bAv.getHeadView().setDefaultResource(17170445);
            this.bAv.getHeadView().setDefaultErrorResource(w.g.icon_default_avatar100);
            this.bAv.getHeadView().setDefaultBgResource(w.e.cp_bg_line_e);
            this.bAv.getHeadView().setRadius(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds70));
        }
        this.bAv.wm();
        if (this.bAv.getPendantView() != null) {
            this.bAv.getPendantView().setIsRound(true);
            this.bAv.getPendantView().setDrawBorder(false);
        }
        this.bAv.setAfterClickListener(this.amS);
        this.aTm = view.findViewById(w.h.divider_line);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.bCj = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.bCj.setAfterClickListener(this.bCm);
        this.bCk = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.bCl = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.bCl.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds8));
        this.bCl.setChildClickListener(this.bAB);
        com.baidu.tbadk.widget.layout.i iVar = new com.baidu.tbadk.widget.layout.i(3);
        iVar.e(1.0d);
        this.bCl.setImageProcessor(iVar);
        this.bgF = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.bgE = (ThreadUserInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_user_info_layout);
        this.bgE.setUserAfterClickListener(this.amS);
        this.bgE.setFrom(3);
        this.bAx = view.findViewById(w.h.divider_below_reply_number_layout);
        if (this.bgF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgF.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bgF.setLayoutParams(layoutParams);
        }
        this.bgF.setOnClickListener(this.bAB);
        this.bgF.setReplyTimeVisible(false);
        this.bgF.setShowPraiseNum(true);
        this.bgF.setNeedAddPraiseIcon(true);
        this.bgF.setNeedAddReplyIcon(true);
        this.bgF.setIsBarViewVisible(false);
        this.bgF.setReplyIcon(w.g.icon_home_card_comment_n);
        this.bgF.setPraiseIcon(w.g.icon_home_card_like_n);
        this.chz = new com.baidu.tieba.frs.f.v(this.ajP, this.bgE);
        this.chz.setUniqueId(getTag());
        this.bAw = (ThreadGodReplyLayout) view.findViewById(w.h.card_frs_god_reply_layout);
        this.bAw.setOnClickListener(this.bAB);
    }

    public void setSingleImageRatio(double d) {
        if (this.bCl != null) {
            this.bCl.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.bCl != null) {
            this.bCl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bCl != null) {
            this.bCl.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.as.k(this.aTm, w.e.cp_bg_line_c);
            this.bCl.onChangeSkinType();
            this.bgF.onChangeSkinType();
            this.bgE.onChangeSkinType();
            this.chz.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img_new_frame;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: t */
    public void a(bm bmVar) {
        boolean z;
        int i;
        boolean z2;
        boolean z3 = false;
        if (bmVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aiu = bmVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bAB);
        }
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        this.bAw.onChangeSkinType();
        if (!Vw() && com.baidu.tieba.card.at.iJ(this.aiu.getId())) {
            com.baidu.tieba.card.at.a(this.mTitle, this.aiu.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bCk, this.aiu.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bAw.getGodReplyContent(), this.aiu.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bAw.getPraiseNum(), this.aiu.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
        }
        this.chz.L(this.aiu);
        this.bgE.a(this.aiu);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgF.getLayoutParams();
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = (int) this.ajP.getResources().getDimension(w.f.ds10);
        this.bgF.setLayoutParams(layoutParams);
        this.bAw.setFromCDN(this.ahU);
        this.bAw.setData(this.aiu.sE());
        this.bgE.setUserAfterClickListener(this.amS);
        this.bgF.a(bmVar);
        this.bAx.setVisibility(0);
        this.mStType = com.baidu.tieba.card.at.ri();
        if (this.bgE.getHeaderImg() != null) {
            if (this.bgE.getIsSimpleThread()) {
                this.bgE.getHeaderImg().setVisibility(8);
                this.bAv.setVisibility(8);
            } else if (bmVar.getAuthor() == null || bmVar.getAuthor().getPendantData() == null || StringUtils.isNull(bmVar.getAuthor().getPendantData().pI())) {
                this.bAv.setVisibility(8);
                this.bgE.getHeaderImg().setVisibility(0);
                this.bgE.getHeaderImg().setData(bmVar);
            } else {
                this.bgE.getHeaderImg().setVisibility(4);
                this.bAv.setVisibility(0);
                this.bAv.setData(bmVar);
            }
        }
        if ((StringUtils.isNull(bmVar.getTitle()) && (bmVar.rp() == null || bmVar.rp().size() == 0)) || bmVar.rG() == 1) {
            bmVar.e(false, true);
            if (bmVar.rR() == null || StringUtils.isNull(bmVar.rR().toString())) {
                this.mTitle.setVisibility(8);
                z = false;
            } else {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(bmVar.rR());
                z = false;
            }
        } else {
            this.mTitle.setVisibility(0);
            bmVar.XB = 0;
            bmVar.e(false, bmVar.so());
            SpannableStringBuilder rR = bmVar.rR();
            this.mTitle.setOnTouchListener(new com.baidu.tieba.view.aa(rR));
            this.mTitle.setText(rR);
            com.baidu.tieba.card.at.a(this.mTitle, bmVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        if (bmVar.rz() != null && !StringUtils.isNull(bmVar.rz())) {
            sb.append(bmVar.rz());
        }
        ArrayList<MediaData> rB = bmVar.rB();
        if (rB != null) {
            i = rB.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rB.get(i2).getVideoUrl() != null && rB.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rB.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bmVar.g(sb.toString(), true))) {
                SpannableString cA = bmVar.cA(sb.toString());
                this.bCk.setOnTouchListener(new com.baidu.tieba.view.aa(cA));
                this.bCk.setText(cA);
                this.bCk.setVisibility(0);
                com.baidu.tieba.card.at.a(this.bCk, bmVar.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
                z2 = true;
            } else {
                this.bCk.setVisibility(8);
                z2 = false;
            }
        } else {
            this.bCk.setVisibility(8);
            i = 0;
            z2 = false;
        }
        ArrayList<VoiceData.VoiceModel> rF = bmVar.rF();
        if (com.baidu.tbadk.core.util.z.t(rF)) {
            this.bCj.setVisibility(8);
        } else {
            this.bCj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rF.get(0);
            this.bCj.setVoiceModel(voiceModel);
            this.bCj.setTag(voiceModel);
            this.bCj.bef();
            if (voiceModel != null) {
                this.bCj.my(voiceModel.voice_status.intValue());
            }
        }
        if (com.baidu.tbadk.core.r.oK().oQ() && com.baidu.tbadk.core.util.z.s(rB) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.z.c(rB, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (mediaData.getThumbnails_url() != null && !com.baidu.tbadk.core.util.aw.isEmpty(mediaData.getThumbnails_url())) {
                        linkedList.add(mediaData.getThumbnails_url());
                    } else {
                        linkedList.add(mediaData.getPicUrl());
                    }
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.z.s(linkedList) > 0) {
                this.bCl.setVisibility(0);
                this.bCl.setFromCDN(this.ahU);
                this.bCl.setImageClickListener(new ba(this, linkedList2, bmVar));
                this.bCl.setImageUrls(linkedList);
                z3 = true;
            } else {
                this.bCl.setVisibility(8);
            }
        } else {
            this.bCl.setVisibility(8);
        }
        VH();
        e(z, z2, z3);
    }

    private void e(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitle.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bCk.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bgF.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.bCl.getLayoutParams();
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
    public void a(List<MediaData> list, int i, bm bmVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajP.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ahU ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bmVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajP.getPageActivity()).createConfig(arrayList, i, bmVar.rw(), String.valueOf(bmVar.getFid()), bmVar.getTid(), this.ahU, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void VH() {
        this.bCj.setClickable(true);
        int childCount = this.bCl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bCl.getChildAt(i);
            if (childAt != null) {
                childAt.setClickable(true);
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ahU = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bgF != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bgE != null) {
            this.bgE.setPageUniqueId(bdUniqueId);
        }
        if (this.bCl != null) {
            this.bCl.setPageUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(boolean z) {
        if (this.aiu != null) {
            com.baidu.tieba.card.at.iI(this.aiu.getId());
            com.baidu.tieba.card.at.a(this.mTitle, this.aiu.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bCk, this.aiu.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bAw.getGodReplyContent(), this.aiu.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tieba.card.at.a(this.bAw.getPraiseNum(), this.aiu.getId(), w.e.cp_cont_f, w.e.cp_cont_d);
            com.baidu.tbadk.core.data.o sn = this.aiu.sn();
            if (sn != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.ajP.getPageActivity(), sn.getCartoonId(), sn.getChapterId(), 2)));
                return;
            }
            com.baidu.tbadk.core.data.l lVar = this.aiu.YI;
            if (this.aiu.YH == 1 && lVar != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                String str = lVar.TW;
                long j = lVar.TX;
                com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
                arVar.pageContext = this.ajP;
                arVar.bookId = str;
                arVar.chapterId = (int) j;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, arVar));
                return;
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ajP.getPageActivity()).createFromThreadCfg(this.aiu, null, com.baidu.tieba.card.at.ri(), 18003, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aiu.getFid()));
            addLocateParam.setForumName(this.aiu.rw());
            addLocateParam.setStartFrom(1);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.ajP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private boolean Vw() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        if (this.bCj != null) {
            this.bCj.setVoiceManager(voiceManager);
        }
    }
}
