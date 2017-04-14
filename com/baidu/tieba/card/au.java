package com.baidu.tieba.card;

import android.text.SpannableString;
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
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class au extends a<com.baidu.tieba.card.data.n> {
    private boolean aic;
    private TbPageContext<?> ajT;
    private final View.OnClickListener ama;
    private final View.OnClickListener amx;
    private View avH;
    public ViewStub bba;
    public TbImageView bbb;
    protected LinearLayout bbe;
    private TextView brC;
    public ThreadCommentAndPraiseInfoLayout brE;
    private com.baidu.tbadk.core.view.o bsC;
    private CustomMessageListener bsD;
    public TextView bsG;
    private CardGroupDividerView bsk;
    public ClickableHeaderImageView btk;
    public PlayVoiceBntNew btl;
    public View btm;
    public UserIconLayout bto;
    private com.baidu.tieba.card.data.n btp;
    private ConstrainImageGroup btq;
    private View.OnClickListener btr;
    private FrsCommonImageLayout.b bts;
    private final View.OnClickListener btt;
    private int mSkinType;
    private TextView mTitle;

    public au(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bsC = null;
        this.mSkinType = 3;
        this.aic = true;
        this.btr = new av(this);
        this.bsD = new aw(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.bts = new ax(this);
        this.btt = new ay(this);
        this.amx = new az(this);
        this.ama = new ba(this);
        View view = getView();
        this.ajT = tbPageContext;
        this.avH = view.findViewById(w.h.card_home_page_normal_thread_top_line);
        this.btk = (ClickableHeaderImageView) view.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.bba = (ViewStub) view.findViewById(w.h.viewstub_headimage_mask);
        this.btk.setDefaultResource(17170445);
        this.btk.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.btk.setDefaultBgResource(w.e.cp_bg_line_e);
        this.btk.setRadius(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds70));
        this.bto = (UserIconLayout) view.findViewById(w.h.card_home_page_normal_thread_user_layout);
        this.mTitle = (TextView) view.findViewById(w.h.card_home_page_normal_thread_title);
        this.btl = (PlayVoiceBntNew) view.findViewById(w.h.card_home_page_normal_thread_abstract_voice);
        this.btl.setAfterClickListener(this.btt);
        this.brC = (TextView) view.findViewById(w.h.card_home_page_normal_thread_abstract);
        this.btq = (ConstrainImageGroup) view.findViewById(w.h.card_home_page_normal_thread_img_layout);
        this.btq.setImageMargin(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds4));
        this.btq.setChildClickListener(this.btr);
        this.brE = (ThreadCommentAndPraiseInfoLayout) view.findViewById(w.h.card_home_page_normal_thread_info_layout);
        this.btm = view.findViewById(w.h.divider_below_reply_number_layout);
        this.bsC = new com.baidu.tbadk.core.view.o(this.ajT);
        this.bsC.wQ();
        this.brE.addView(this.bsC);
        if (this.brE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brE.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.brE.setLayoutParams(layoutParams);
        }
        this.brE.setOnClickListener(this.btr);
        this.bbe = (LinearLayout) view.findViewById(w.h.card_home_page_normal_thread_content_layout);
        this.bsk = (CardGroupDividerView) view.findViewById(w.h.header_divider);
    }

    public void SK() {
        if (this.bsG == null) {
            this.bsG = new TextView(this.ajT.getPageActivity());
            this.bsG.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds24));
            this.bsG.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds20);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds2);
            this.bsG.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.aq.i(this.bsG, w.e.cp_cont_b);
            this.bto.addView(this.bsG);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.btq != null) {
            this.btq.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.c> bVar) {
        if (this.btq != null) {
            this.btq.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.btq != null) {
            this.btq.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(getView(), w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.k(this.avH, w.e.cp_bg_line_b);
            this.btq.onChangeSkinType();
            this.bto.onChangeSkinType();
            com.baidu.tbadk.core.util.aq.i(this.bsG, w.e.cp_cont_b);
            this.brE.onChangeSkinType();
            if (this.bsC != null) {
                this.bsC.onChangeSkinType();
            }
            if (this.bsk != null) {
                this.bsk.onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_home_page_multi_img;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.n nVar) {
        int i;
        boolean z;
        if (nVar == null || nVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.btp = nVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.btr);
        }
        if (this.bsC != null && this.btp.Kn() != null) {
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.cp(this.btp.Kn().getTid());
            alVar.setFid(this.btp.Kn().getFid());
            alVar.a(this.btp.WT);
            this.bsC.setData(alVar);
        }
        onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
        if (this.btp.bvi) {
            this.btk.setVisibility(8);
            this.bto.setVisibility(8);
        } else {
            this.bto.setVisibility(0);
            this.btk.setVisibility(0);
            this.btk.setData(nVar.threadData);
            this.btk.setAfterClickListener(this.amx);
            UserTbVipInfoData sp = this.btp.threadData.sp();
            if (sp != null && sp.getvipV_url() != null && this.bba != null) {
                if (this.bbb == null) {
                    this.bba.inflate();
                    this.bbb = (TbImageView) getView().findViewById(w.h.user_head_mask);
                }
                this.bbb.c(sp.getvipV_url(), 10, false);
                this.btk.setIsBigV(true);
            }
        }
        this.bto.setData(nVar.threadData);
        this.bto.setUserAfterClickListener(this.amx);
        if (this.brE.a(nVar.threadData)) {
            this.btm.setVisibility(8);
        } else {
            this.btm.setVisibility(0);
        }
        if (this.bsG != null) {
            if (nVar.threadData.sj() <= 0) {
                this.bsG.setVisibility(8);
            } else {
                this.bsG.setVisibility(0);
                this.bsG.setText(com.baidu.tbadk.core.util.au.r(nVar.threadData.sj() * 1000));
            }
        }
        this.brE.setForumAfterClickListener(this.ama);
        this.brE.setStType(at.sf());
        this.brE.setYuelaouLocate("feed#" + nVar.SV());
        com.baidu.tbadk.core.data.bi Kn = nVar.Kn();
        at.a(Kn, this.mTitle);
        StringBuilder sb = new StringBuilder();
        if (Kn.sw() != null && !StringUtils.isNull(Kn.sw())) {
            sb.append(Kn.sw());
        }
        ArrayList<MediaData> sy = nVar.threadData.sy();
        if (sy != null) {
            i = sy.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (sy.get(i2).getVideoUrl() != null && sy.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(sy.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(nVar.Kn().g(sb.toString(), true))) {
                SpannableString cx = nVar.threadData.cx(sb.toString());
                this.brC.setOnTouchListener(new com.baidu.tieba.view.x(cx));
                this.brC.setText(cx);
                this.brC.setVisibility(0);
                at.a(this.brC, nVar.threadData.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
            } else {
                this.brC.setVisibility(8);
            }
        } else {
            this.brC.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> sC = nVar.threadData.sC();
        if (com.baidu.tbadk.core.util.x.q(sC)) {
            this.btl.setVisibility(8);
            z = false;
        } else {
            this.btl.setVisibility(0);
            VoiceData.VoiceModel voiceModel = sC.get(0);
            this.btl.setVoiceModel(voiceModel);
            this.btl.setTag(voiceModel);
            this.btl.bac();
            if (voiceModel != null) {
                this.btl.ma(voiceModel.voice_status.intValue());
            }
            z = true;
        }
        if (this.btp.bvi && z) {
            this.btq.setVisibility(8);
        } else if (com.baidu.tbadk.core.q.po().pu() && com.baidu.tbadk.core.util.x.p(sy) != 0) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.c(sy, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (com.baidu.tbadk.core.util.x.p(linkedList) > 0) {
                this.btq.setVisibility(0);
                this.btq.setFromCDN(this.aic);
                this.btq.setImageClickListener(new bb(this, linkedList2, Kn));
                this.btq.setImageUrls(linkedList);
            } else {
                this.btq.setVisibility(8);
            }
        } else {
            this.btq.setVisibility(8);
        }
        SO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, com.baidu.tbadk.core.data.bi biVar) {
        if (!TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.k.showToast(this.ajT.getPageActivity(), w.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aic ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(biVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.ajT.getPageActivity()).createConfig(arrayList, i, biVar.st(), String.valueOf(biVar.getFid()), biVar.getTid(), this.aic, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void SO() {
        if (!this.btp.aAo) {
            this.btl.setClickable(false);
            this.brE.setBarNameClickEnabled(false);
        } else {
            this.btl.setClickable(true);
            this.brE.setBarNameClickEnabled(true);
        }
        int childCount = this.btq.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.btq.getChildAt(i);
            if (childAt != null) {
                if (!this.btp.aAo) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aic = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.brE != null && this.bsD != null) {
            this.brE.h(bdUniqueId);
            this.bsD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsD);
        }
    }

    public void a(o.a aVar) {
        if (this.bsC != null) {
            this.bsC.setEventCallback(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SP() {
        if (this.btp != null && this.btp.threadData != null) {
            if (!SL()) {
                at.hY(this.btp.threadData.getId());
            }
            this.ajT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajT.getPageActivity()).createFromThreadCfg(this.btp.threadData, null, at.sf(), 18003, true, false, false).addLocateParam(this.btp.SW())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SL() {
        return this.btp.bvi && !this.btp.aAo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
