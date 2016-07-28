package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class au extends a<com.baidu.tieba.card.a.m> {
    private TbPageContext<?> EA;
    private View aSU;
    public ViewStub aSW;
    public TbImageView aSX;
    private TextView aSZ;
    protected LinearLayout aTY;
    private TextView aTf;
    public ThreadCommentAndPraiseInfoLayout aTh;
    public ClickableHeaderImageView aUG;
    public PlayVoiceBntNew aUH;
    public UserIconLayout aUI;
    private com.baidu.tieba.card.a.m aUJ;
    private ConstrainImageGroup aUK;
    private View.OnClickListener aUL;
    private FrsCommonImageLayout.b aUM;
    private final View.OnClickListener aUN;
    private CustomMessageListener aUs;
    private boolean aav;
    private final View.OnClickListener aeW;
    private final View.OnClickListener aez;
    private int mSkinType;

    public au(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aav = true;
        this.aUL = new av(this);
        this.aUs = new aw(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aUM = new ax(this);
        this.aUN = new ay(this);
        this.aeW = new az(this);
        this.aez = new ba(this);
        View view = getView();
        this.EA = tbPageContext;
        this.aSU = view.findViewById(u.g.card_home_page_normal_thread_top_line);
        this.aUG = (ClickableHeaderImageView) view.findViewById(u.g.card_home_page_normal_thread_user_header);
        this.aSW = (ViewStub) view.findViewById(u.g.viewstub_headimage_mask);
        this.aUG.setDefaultResource(17170445);
        this.aUG.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aUG.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aUG.setRadius(com.baidu.adp.lib.util.k.c(this.EA.getPageActivity(), u.e.ds70));
        this.aUI = (UserIconLayout) view.findViewById(u.g.card_home_page_normal_thread_user_layout);
        this.aSZ = (TextView) view.findViewById(u.g.card_home_page_normal_thread_title);
        this.aUH = (PlayVoiceBntNew) view.findViewById(u.g.card_home_page_normal_thread_abstract_voice);
        this.aUH.setAfterClickListener(this.aUN);
        this.aTf = (TextView) view.findViewById(u.g.card_home_page_normal_thread_abstract);
        this.aUK = (ConstrainImageGroup) view.findViewById(u.g.card_home_page_normal_thread_img_layout);
        this.aUK.setImageMargin(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds4));
        this.aUK.setChildClickListener(this.aUL);
        this.aTh = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.card_home_page_normal_thread_info_layout);
        this.aTh.setOnClickListener(this.aUL);
        this.aTY = (LinearLayout) view.findViewById(u.g.card_home_page_normal_thread_content_layout);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.aUK != null) {
            this.aUK.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.aUK != null) {
            this.aUK.setImageViewPool(bVar);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aSU, u.d.cp_bg_line_b);
            this.aUK.sd();
            this.aUI.sd();
            this.aTh.sd();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.card_home_page_multi_img;
    }

    public void a(com.baidu.tieba.card.a.m mVar) {
        int i;
        boolean z;
        if (mVar == null || mVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aUJ = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aUL);
        }
        d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
        if (this.aUJ.aWs) {
            this.aUG.setVisibility(8);
            this.aUI.setVisibility(8);
        } else {
            this.aUI.setVisibility(0);
            this.aUG.setVisibility(0);
            this.aUG.setData(mVar.threadData);
            this.aUG.setAfterClickListener(this.aeW);
            UserTbVipInfoData qx = this.aUJ.threadData.qx();
            if (qx != null && qx.getvipV_url() != null && this.aSW != null) {
                if (this.aSX == null) {
                    this.aSW.inflate();
                    this.aSX = (TbImageView) getView().findViewById(u.g.user_head_mask);
                }
                this.aSX.c(qx.getvipV_url(), 10, false);
                this.aUG.setIsBigV(true);
            }
        }
        this.aUI.setData(mVar.threadData);
        this.aUI.setUserAfterClickListener(this.aeW);
        this.aTh.setData(mVar.threadData);
        this.aTh.setForumAfterClickListener(this.aez);
        this.aTh.setStType(at.La());
        this.aTh.setYuelaouLocate("feed#" + mVar.Lg());
        if (StringUtils.isNull(mVar.threadData.getTitle()) || mVar.threadData.qK() == 1) {
            this.aSZ.setVisibility(8);
        } else {
            this.aSZ.setVisibility(0);
            mVar.threadData.QJ = 0;
            if (this.aUJ.aWs || mVar.threadData.ri()) {
                this.aSZ.setText(mVar.threadData.getTitle());
            } else {
                mVar.threadData.rd();
                this.aSZ.setText(mVar.threadData.qV());
            }
            at.a(this.aSZ, mVar.Iw().getId(), u.d.cp_cont_b, u.d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (mVar.threadData.qD() != null && !StringUtils.isNull(mVar.threadData.qD())) {
            sb.append(mVar.threadData.qD());
        }
        ArrayList<MediaData> qF = mVar.threadData.qF();
        if (qF != null) {
            i = qF.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (qF.get(i2).getVideoUrl() != null && qF.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(qF.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (sb.length() > 0) {
                this.aTf.setText(sb.toString());
                this.aTf.setVisibility(0);
                at.a(this.aTf, mVar.threadData.getId(), u.d.cp_cont_j, u.d.cp_cont_d);
            } else {
                this.aTf.setVisibility(8);
            }
        } else {
            this.aTf.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> qJ = mVar.threadData.qJ();
        if (com.baidu.tbadk.core.util.y.t(qJ)) {
            this.aUH.setVisibility(8);
            z = false;
        } else {
            this.aUH.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qJ.get(0);
            this.aUH.setVoiceModel(voiceModel);
            this.aUH.setTag(voiceModel);
            this.aUH.bgJ();
            if (voiceModel != null) {
                this.aUH.lt(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.aUJ.aWs && z) {
            this.aUK.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.nL().nR() && com.baidu.tbadk.core.util.y.s(qF) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.be Iw = mVar.Iw();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.c(qF, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.s(linkedList) > 0) {
                this.aUK.setVisibility(0);
                this.aUK.setFromCDN(this.aav);
                this.aUK.setImageClickListener(new bb(this, linkedList2, Iw));
                this.aUK.setImageUrls(linkedList);
            } else {
                this.aUK.setVisibility(8);
            }
        } else {
            this.aUK.setVisibility(8);
        }
        Lb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.be beVar) {
        if (!TbadkCoreApplication.m10getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.EA.getPageActivity(), u.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aav ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(beVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.EA.getPageActivity()).createConfig(arrayList, i, beVar.getForum_name(), String.valueOf(beVar.getFid()), beVar.getTid(), this.aav, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Lb() {
        if (!this.aUJ.asx) {
            this.aUH.setClickable(false);
            this.aTh.setBarNameClickEnabled(false);
        } else {
            this.aUH.setClickable(true);
            this.aTh.setBarNameClickEnabled(true);
        }
        int childCount = this.aUK.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aUK.getChildAt(i);
            if (childAt != null) {
                if (!this.aUJ.asx) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aav = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aTh != null && this.aUs != null) {
            this.aTh.h(bdUniqueId);
            this.aUs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lc() {
        if (this.aUJ != null && this.aUJ.threadData != null) {
            if (!KT()) {
                at.hb(this.aUJ.threadData.getId());
            }
            this.EA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.EA.getPageActivity()).createFromThreadCfg(this.aUJ.threadData, null, at.La(), 18003, true, false, false).addLocateParam(this.aUJ.Lh())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KT() {
        return this.aUJ.aWs && !this.aUJ.asx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
