package com.baidu.tieba.homepage.concern.view;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<l> {
    private boolean aiq;
    private TbPageContext<?> ako;
    private final View.OnClickListener anD;
    private final View.OnClickListener ann;
    private HeadPendantClickableView bEC;
    private View bEG;
    private l bEH;
    private View.OnClickListener bEI;
    public PlayVoiceBntNew bGq;
    private TextView bGr;
    private ConstrainImageGroup bGs;
    private final View.OnClickListener bGt;
    public ThreadCommentAndPraiseInfoLayout bjP;
    protected LinearLayout bjT;
    public ConcernThreadUserInfoLayout cPo;
    private int mSkinType;
    private TextView mTitle;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aiq = true;
        this.bEI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.VZ() != null) {
                    b.this.VZ().a(view, b.this.bEH);
                }
                b.this.Wp();
            }
        };
        this.bGt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<l> VZ = b.this.VZ();
                if (VZ != null) {
                    view.setTag("2");
                    VZ.a(view, b.this.bEH);
                }
            }
        };
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.VZ() != null) {
                    b.this.VZ().a(view, b.this.bEH);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.VZ() != null) {
                    b.this.VZ().a(view, b.this.bEH);
                }
            }
        };
        View view = getView();
        this.ako = tbPageContext;
        this.bEC = (HeadPendantClickableView) view.findViewById(d.h.card_concern_normal_thread_user_pendant_header);
        if (this.bEC.getHeadView() != null) {
            this.bEC.getHeadView().setIsRound(true);
            this.bEC.getHeadView().setDrawBorder(false);
            this.bEC.getHeadView().setDefaultResource(17170445);
            this.bEC.getHeadView().setDefaultErrorResource(d.g.icon_default_avatar100);
            this.bEC.getHeadView().setDefaultBgResource(d.e.cp_bg_line_e);
            this.bEC.getHeadView().setRadius(k.g(this.ako.getPageActivity(), d.f.ds60));
        }
        if (this.bEC.getPendantView() != null) {
            this.bEC.getPendantView().setIsRound(true);
            this.bEC.getPendantView().setDrawBorder(false);
        }
        this.mTitle = (TextView) view.findViewById(d.h.card_concern_normal_thread_title);
        this.bGq = (PlayVoiceBntNew) view.findViewById(d.h.card_concern_normal_thread_abstract_voice);
        this.bGq.setAfterClickListener(this.bGt);
        this.bGr = (TextView) view.findViewById(d.h.card_concern_normal_thread_abstract);
        this.bGs = (ConstrainImageGroup) view.findViewById(d.h.card_concern_normal_thread_img_layout);
        this.bEG = view.findViewById(d.h.divider_line);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
        this.bGs.setChildClickListener(this.bEI);
        this.bGs.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.e(1.0d);
        this.bGs.setImageProcessor(fVar);
        this.bjP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_concern_normal_thread_info_layout);
        this.cPo = (ConcernThreadUserInfoLayout) view.findViewById(d.h.card_concern_normal_thread_user_info_layout);
        if (this.bjP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bjP.setLayoutParams(layoutParams);
        }
        this.bjP.setOnClickListener(this.bEI);
        this.bjP.setReplyTimeVisible(false);
        this.bjP.setIsBarViewVisible(false);
        this.bjP.setShowPraiseNum(true);
        this.bjP.setNeedAddPraiseIcon(true);
        this.bjP.setNeedAddReplyIcon(true);
        this.bjP.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bjP.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.VZ() != null) {
                    b.this.VZ().a(view2, b.this.bEH);
                }
            }
        });
        this.bjT = (LinearLayout) view.findViewById(d.h.card_concern_normal_thread_content_layout);
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
            this.bGs.onChangeSkinType();
            this.bjP.onChangeSkinType();
            this.cPo.onChangeSkinType();
            ai.k(this.bEG, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_concern_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0215  */
    @Override // com.baidu.tieba.card.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(l lVar) {
        boolean z;
        StringBuilder sb;
        ArrayList<MediaData> rF;
        int i;
        boolean z2;
        ArrayList<VoiceData.VoiceModel> rJ;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        boolean z6 = false;
        if (lVar == null || lVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.bEH = lVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.bEI);
        }
        this.cPo.a(lVar.threadData);
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        if (!Wd() && m.iZ(this.bEH.threadData.getId())) {
            m.a(this.mTitle, this.bEH.MA().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            m.a(this.bGr, this.bEH.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
        }
        this.cPo.setUserAfterClickListener(this.anD);
        this.bjP.a(lVar.threadData);
        final bl MA = lVar.MA();
        if (this.cPo.getHeaderImg() != null) {
            if (this.cPo.getIsSimpleThread()) {
                this.cPo.getHeaderImg().setVisibility(8);
                this.bEC.setVisibility(8);
            } else if (MA.getAuthor() == null || MA.getAuthor().getPendantData() == null || StringUtils.isNull(MA.getAuthor().getPendantData().pL())) {
                this.bEC.setVisibility(8);
                this.cPo.getHeaderImg().setVisibility(0);
                this.cPo.getHeaderImg().setData(MA);
            } else {
                this.cPo.getHeaderImg().setVisibility(4);
            }
        }
        m.b(MA, this.mTitle);
        if ((StringUtils.isNull(MA.getTitle()) && (MA.rt() == null || MA.rt().size() == 0)) || MA.rK() == 1) {
            MA.e(false, true);
            if (MA.rV() == null || StringUtils.isNull(MA.rV().toString())) {
                z = false;
                sb = new StringBuilder();
                if (MA.rD() != null && !StringUtils.isNull(MA.rD())) {
                    sb.append(MA.rD());
                }
                rF = lVar.threadData.rF();
                if (rF == null) {
                    i = rF.size();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 0; i2 < i; i2++) {
                        if (rF.get(i2).getVideoUrl() != null && rF.get(i2).getVideoUrl().endsWith("swf")) {
                            sb2.append(rF.get(i2).getVideoUrl());
                        }
                    }
                    sb.append(sb2.toString());
                    if (!TextUtils.isEmpty(lVar.MA().g(sb.toString(), true))) {
                        SpannableString cF = lVar.threadData.cF(sb.toString());
                        this.bGr.setOnTouchListener(new com.baidu.tieba.view.l(cF));
                        this.bGr.setText(cF);
                        this.bGr.setVisibility(0);
                        m.a(this.bGr, lVar.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                        z4 = true;
                    } else {
                        this.bGr.setVisibility(8);
                        z4 = false;
                    }
                    z2 = z4;
                } else {
                    this.bGr.setVisibility(8);
                    i = 0;
                    z2 = false;
                }
                rJ = lVar.threadData.rJ();
                if (!u.v(rJ)) {
                    this.bGq.setVisibility(8);
                    z3 = false;
                } else {
                    this.bGq.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = rJ.get(0);
                    this.bGq.setVoiceModel(voiceModel);
                    this.bGq.setTag(voiceModel);
                    this.bGq.bhH();
                    if (voiceModel != null) {
                        this.bGq.mH(voiceModel.voice_status.intValue());
                    }
                    z3 = true;
                }
                if (!this.bEH.bIy && z3) {
                    this.bGs.setVisibility(8);
                } else if (!h.oN().oT() && u.u(rF) != 0) {
                    LinkedList linkedList = new LinkedList();
                    final LinkedList linkedList2 = new LinkedList();
                    for (int i3 = 0; i3 < i; i3++) {
                        MediaData mediaData = (MediaData) u.c(rF, i3);
                        if (mediaData != null && mediaData.getType() == 3) {
                            linkedList.add(mediaData.getThumbnails_url());
                            linkedList2.add(mediaData);
                        }
                    }
                    if (u.u(linkedList) > 0) {
                        this.bGs.setVisibility(0);
                        this.bGs.setFromCDN(this.aiq);
                        this.bGs.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.b.2
                            @Override // com.baidu.tbadk.widget.layout.d
                            public void c(View view, int i4, boolean z7) {
                                x<l> VZ = b.this.VZ();
                                if (VZ != null) {
                                    view.setTag("1");
                                    VZ.a(view, b.this.bEH);
                                }
                                if (z7) {
                                    b.this.Wp();
                                } else {
                                    b.this.a(linkedList2, i4, MA);
                                }
                            }
                        });
                        this.bGs.setImageUrls(linkedList);
                    } else {
                        this.bGs.setVisibility(8);
                        z5 = false;
                    }
                    z6 = z5;
                } else {
                    this.bGs.setVisibility(8);
                }
                Wo();
                g(z, z2, z6);
                setPageUniqueId(getTag());
            }
        }
        z = true;
        sb = new StringBuilder();
        if (MA.rD() != null) {
            sb.append(MA.rD());
        }
        rF = lVar.threadData.rF();
        if (rF == null) {
        }
        rJ = lVar.threadData.rJ();
        if (!u.v(rJ)) {
        }
        if (!this.bEH.bIy) {
        }
        if (!h.oN().oT()) {
        }
        this.bGs.setVisibility(8);
        Wo();
        g(z, z2, z6);
        setPageUniqueId(getTag());
    }

    private void g(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGr.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bjP.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bGs.getLayoutParams();
        if (!z && z2) {
            layoutParams.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams2.topMargin = k.g(this.mContext, d.f.ds2);
            } else if (z) {
                layoutParams2.topMargin = 0;
            }
        } else if (z2) {
            layoutParams3.topMargin = k.g(this.mContext, d.f.ds13);
        } else if (z) {
            layoutParams3.topMargin = k.g(this.mContext, d.f.ds10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bl blVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            k.showToast(this.ako.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
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
        if (!this.bEH.aCd) {
            this.bGq.setClickable(false);
        } else {
            this.bGq.setClickable(true);
        }
        int childCount = this.bGs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bGs.getChildAt(i);
            if (childAt != null) {
                if (!this.bEH.aCd) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bGs != null) {
            this.bGs.setPageUniqueId(bdUniqueId);
        }
        if (this.cPo != null) {
            this.cPo.setPageUniqueId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cPo != null) {
            return this.cPo.getHeaderImg();
        }
        return null;
    }

    public View Wc() {
        if (this.cPo != null) {
            return this.cPo.anz;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wp() {
        if (this.bEH != null && this.bEH.threadData != null) {
            if (!Wd()) {
                m.iY(this.bEH.threadData.getId());
                m.a(this.mTitle, this.bEH.MA().getId(), d.e.cp_cont_b, d.e.cp_cont_d);
                m.a(this.bGr, this.bEH.threadData.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ako.getPageActivity()).createCfgForPersonCenter(this.bEH.threadData.getId(), this.bEH.threadData.rL(), m.rm(), 18005)));
        }
    }

    private boolean Wd() {
        return this.bEH.bIy && !this.bEH.aCd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
