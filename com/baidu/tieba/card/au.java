package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
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
    private TbPageContext<?> Ea;
    private boolean ZM;
    private View aSa;
    private TextView aSd;
    private TextView aSj;
    public ThreadCommentAndPraiseInfoLayout aSl;
    public ClickableHeaderImageView aTK;
    public PlayVoiceBntNew aTL;
    public UserIconLayout aTM;
    private com.baidu.tieba.card.a.m aTN;
    private ConstrainImageGroup aTO;
    private View.OnClickListener aTP;
    private FrsCommonImageLayout.b aTQ;
    private final View.OnClickListener aTR;
    protected LinearLayout aTc;
    private CustomMessageListener aTw;
    private final View.OnClickListener adL;
    private final View.OnClickListener aei;
    private int mSkinType;

    public au(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ZM = true;
        this.aTP = new av(this);
        this.aTw = new aw(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aTQ = new ax(this);
        this.aTR = new ay(this);
        this.aei = new az(this);
        this.adL = new ba(this);
        View view = getView();
        this.Ea = tbPageContext;
        this.aSa = view.findViewById(u.g.card_home_page_normal_thread_top_line);
        this.aTK = (ClickableHeaderImageView) view.findViewById(u.g.card_home_page_normal_thread_user_header);
        this.aTK.setDefaultResource(17170445);
        this.aTK.setDefaultErrorResource(u.f.icon_default_avatar100);
        this.aTK.setDefaultBgResource(u.d.cp_bg_line_e);
        this.aTK.setRadius(com.baidu.adp.lib.util.k.c(this.Ea.getPageActivity(), u.e.ds70));
        this.aTM = (UserIconLayout) view.findViewById(u.g.card_home_page_normal_thread_user_layout);
        this.aSd = (TextView) view.findViewById(u.g.card_home_page_normal_thread_title);
        this.aTL = (PlayVoiceBntNew) view.findViewById(u.g.card_home_page_normal_thread_abstract_voice);
        this.aTL.setAfterClickListener(this.aTR);
        this.aSj = (TextView) view.findViewById(u.g.card_home_page_normal_thread_abstract);
        this.aTO = (ConstrainImageGroup) view.findViewById(u.g.card_home_page_normal_thread_img_layout);
        this.aTO.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds4));
        this.aTO.setChildClickListener(this.aTP);
        this.aSl = (ThreadCommentAndPraiseInfoLayout) view.findViewById(u.g.card_home_page_normal_thread_info_layout);
        this.aSl.setOnClickListener(this.aTP);
        this.aTc = (LinearLayout) view.findViewById(u.g.card_home_page_normal_thread_content_layout);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.aTO != null) {
            this.aTO.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        if (this.aTO != null) {
            this.aTO.setImageViewPool(bVar);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(getView(), u.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.aSa, u.d.cp_bg_line_b);
            this.aTO.se();
            this.aTM.se();
            this.aSl.se();
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
        this.aTN = mVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aTP);
        }
        d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.aTN.aVu) {
            this.aTK.setVisibility(8);
            this.aTM.setVisibility(8);
        } else {
            this.aTM.setVisibility(0);
            this.aTK.setVisibility(0);
            this.aTK.setData(mVar.threadData);
            this.aTK.setAfterClickListener(this.aei);
        }
        this.aTM.setData(mVar.threadData);
        this.aTM.setUserAfterClickListener(this.aei);
        this.aSl.setData(mVar.threadData);
        this.aSl.setForumAfterClickListener(this.adL);
        this.aSl.setStType(at.Lb());
        this.aSl.setYuelaouLocate("feed#" + mVar.Lh());
        if (StringUtils.isNull(mVar.threadData.getTitle()) || mVar.threadData.qU() == 1) {
            this.aSd.setVisibility(8);
        } else {
            this.aSd.setVisibility(0);
            mVar.threadData.Qo = 0;
            if (this.aTN.aVu || mVar.threadData.rk()) {
                this.aSd.setText(mVar.threadData.getTitle());
            } else {
                mVar.threadData.parser_title();
                this.aSd.setText(mVar.threadData.getSpan_str());
            }
            at.a(this.aSd, mVar.Ix().getId(), u.d.cp_cont_b, u.d.cp_cont_d);
        }
        StringBuilder sb = new StringBuilder();
        if (mVar.threadData.qO() != null && !StringUtils.isNull(mVar.threadData.qO())) {
            sb.append(mVar.threadData.qO());
        }
        ArrayList<MediaData> medias = mVar.threadData.getMedias();
        if (medias != null) {
            i = medias.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (medias.get(i2).getVideoUrl() != null && medias.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(medias.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (sb.length() > 0) {
                this.aSj.setText(sb.toString());
                this.aSj.setVisibility(0);
                at.a(this.aSj, mVar.threadData.getId(), u.d.cp_cont_j, u.d.cp_cont_d);
            } else {
                this.aSj.setVisibility(8);
            }
        } else {
            this.aSj.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> qT = mVar.threadData.qT();
        if (com.baidu.tbadk.core.util.y.t(qT)) {
            this.aTL.setVisibility(8);
            z = false;
        } else {
            this.aTL.setVisibility(0);
            VoiceData.VoiceModel voiceModel = qT.get(0);
            this.aTL.setVoiceModel(voiceModel);
            this.aTL.setTag(voiceModel);
            this.aTL.bdr();
            if (voiceModel != null) {
                this.aTL.ln(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.aTN.aVu && z) {
            this.aTO.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.nW().oc() && com.baidu.tbadk.core.util.y.s(medias) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            com.baidu.tbadk.core.data.az Ix = mVar.Ix();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.c(medias, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.y.s(linkedList) > 0) {
                this.aTO.setVisibility(0);
                this.aTO.setFromCDN(this.ZM);
                this.aTO.setImageClickListener(new bb(this, linkedList2, Ix));
                this.aTO.setImageUrls(linkedList);
            } else {
                this.aTO.setVisibility(8);
            }
        } else {
            this.aTO.setVisibility(8);
        }
        Lc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.az azVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.Ea.getPageActivity(), u.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ZM ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.h.b.c(azVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.Ea.getPageActivity()).createConfig(arrayList, i, azVar.getForum_name(), String.valueOf(azVar.getFid()), azVar.getTid(), this.ZM, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void Lc() {
        if (!this.aTN.arI) {
            this.aTL.setClickable(false);
            this.aSl.setBarNameClickEnabled(false);
        } else {
            this.aTL.setClickable(true);
            this.aSl.setBarNameClickEnabled(true);
        }
        int childCount = this.aTO.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aTO.getChildAt(i);
            if (childAt != null) {
                if (!this.aTN.arI) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.ZM = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aSl != null && this.aTw != null) {
            this.aSl.h(bdUniqueId);
            this.aTw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld() {
        if (this.aTN != null && this.aTN.threadData != null) {
            if (!KU()) {
                at.hb(this.aTN.threadData.getId());
            }
            this.Ea.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Ea.getPageActivity()).createFromThreadCfg(this.aTN.threadData, null, at.Lb(), 18003, true, false, false).addLocateParam(this.aTN.Li())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KU() {
        return this.aTN.aVu && !this.aTN.arI;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
