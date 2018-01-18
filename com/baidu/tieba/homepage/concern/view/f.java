package com.baidu.tieba.homepage.concern.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class f extends d {
    private boolean aXs;
    public PlayVoiceBntNew cTY;
    private ConstrainImageGroup cUb;
    private final View.OnClickListener cUe;
    private ConcernVideoImageView ecA;
    private View ecm;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aXs = true;
        this.cUe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.homepage.concern.b.b> akb = f.this.akb();
                if (akb != null) {
                    view.setTag("2");
                    akb.a(view, f.this.ecu);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void bz(View view) {
        if (view != null) {
            this.cTY = (PlayVoiceBntNew) view.findViewById(d.g.card_recommend_god_therad_voice);
            this.cTY.setAfterClickListener(this.cUe);
            this.cUb = (ConstrainImageGroup) view.findViewById(d.g.card_recommend_god_therad_img_layout);
            this.ecA = (ConcernVideoImageView) view.findViewById(d.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            this.cUb.setChildClickListener(this.ecx);
            this.cUb.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
            fVar.g(1.0d);
            this.cUb.setImageProcessor(fVar);
            this.ecm = view.findViewById(d.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.cUb != null) {
            this.cUb.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cUb != null) {
            this.cUb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cUb != null) {
            this.cUb.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cUb.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void U(bd bdVar) {
        if (bdVar == null || bdVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.cjI.setVisibility(8);
            ((LinearLayout.LayoutParams) this.ect.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(d.e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ecx);
        }
        this.cjI.setVisibility(0);
        ArrayList<MediaData> zd = bdVar.zd();
        int D = com.baidu.tbadk.core.util.v.D(zd);
        if (!this.ecv) {
            StringBuilder sb = new StringBuilder();
            if (bdVar.getAbstract() != null && !StringUtils.isNull(bdVar.getAbstract())) {
                sb.append(bdVar.getAbstract());
            }
            if (zd != null && D > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < D; i++) {
                    if (zd.get(i).getVideoUrl() != null && zd.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(zd.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bdVar.g(sb.toString(), true))) {
                    SpannableString cQ = bdVar.cQ(sb.toString());
                    this.mTitle.setOnTouchListener(new m(cQ));
                    this.mTitle.setText(cQ);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> zh = bdVar.zh();
        if (com.baidu.tbadk.core.util.v.E(zh)) {
            this.cTY.setVisibility(8);
        } else {
            this.cTY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zh.get(0);
            this.cTY.setVoiceModel(voiceModel);
            this.cTY.setTag(voiceModel);
            this.cTY.bnf();
            if (voiceModel != null) {
                this.cTY.qE(voiceModel.voice_status.intValue());
            }
        }
        if (i.wA().wG() && D > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < D; i2++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zd, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                this.ecm.setVisibility(8);
                this.cUb.setVisibility(0);
                this.ecA.setVisibility(8);
                this.cUb.setFromCDN(this.aXs);
                this.cUb.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void f(View view, int i3, boolean z) {
                        v<com.baidu.tieba.homepage.concern.b.b> akb = f.this.akb();
                        if (akb != null) {
                            view.setTag("1");
                            akb.a(view, f.this.ecu);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.bXM);
                        } else {
                            f.this.akv();
                        }
                    }
                });
                this.cUb.setImageMediaList(linkedList);
            } else if (com.baidu.tbadk.core.util.v.D(linkedList2) > 0) {
                this.cUb.setVisibility(8);
                this.ecA.setVisibility(0);
                this.ecA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.akv();
                    }
                });
                this.ecA.setData(linkedList2);
                this.ecm.setVisibility(0);
            } else {
                this.cUb.setVisibility(8);
            }
        } else {
            this.cUb.setVisibility(8);
            this.ecA.setVisibility(8);
            this.ecm.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aXs ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bdVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.yY(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aXs, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cUb != null) {
            this.cUb.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
