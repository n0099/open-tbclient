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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class f extends d {
    private boolean aiR;
    public PlayVoiceBntNew bSW;
    private ConstrainImageGroup bSZ;
    private final View.OnClickListener bTa;
    private View dfd;
    private ConcernVideoImageView dfq;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aiR = true;
        this.bTa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.homepage.concern.b.b> ZJ = f.this.ZJ();
                if (ZJ != null) {
                    view.setTag("2");
                    ZJ.a(view, f.this.dfl);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ad(View view) {
        if (view != null) {
            this.bSW = (PlayVoiceBntNew) view.findViewById(d.g.card_recommend_god_therad_voice);
            this.bSW.setAfterClickListener(this.bTa);
            this.bSZ = (ConstrainImageGroup) view.findViewById(d.g.card_recommend_god_therad_img_layout);
            this.dfq = (ConcernVideoImageView) view.findViewById(d.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            this.bSZ.setChildClickListener(this.dfo);
            this.bSZ.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
            fVar.e(1.0d);
            this.bSZ.setImageProcessor(fVar);
            this.dfd = view.findViewById(d.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.bSZ != null) {
            this.bSZ.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bSZ != null) {
            this.bSZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bSZ != null) {
            this.bSZ.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bSZ.onChangeSkinType();
        aj.k(this.dfd, d.C0080d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void S(bh bhVar) {
        if (bhVar == null || bhVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.boQ.setVisibility(8);
            ((LinearLayout.LayoutParams) this.dfk.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(d.e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.dfo);
        }
        this.boQ.setVisibility(0);
        ArrayList<MediaData> rE = bhVar.rE();
        int u = v.u(rE);
        if (!this.dfm) {
            StringBuilder sb = new StringBuilder();
            if (bhVar.getAbstract() != null && !StringUtils.isNull(bhVar.getAbstract())) {
                sb.append(bhVar.getAbstract());
            }
            if (rE != null && u > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < u; i++) {
                    if (rE.get(i).getVideoUrl() != null && rE.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(rE.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bhVar.g(sb.toString(), true))) {
                    SpannableString cJ = bhVar.cJ(sb.toString());
                    this.mTitle.setOnTouchListener(new l(cJ));
                    this.mTitle.setText(cJ);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> rI = bhVar.rI();
        if (v.v(rI)) {
            this.bSW.setVisibility(8);
        } else {
            this.bSW.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rI.get(0);
            this.bSW.setVoiceModel(voiceModel);
            this.bSW.setTag(voiceModel);
            this.bSW.bjz();
            if (voiceModel != null) {
                this.bSW.ny(voiceModel.voice_status.intValue());
            }
        }
        if (h.oT().oZ() && u > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < u; i2++) {
                MediaData mediaData = (MediaData) v.c(rE, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (v.u(linkedList) > 0) {
                this.bSZ.setVisibility(0);
                this.dfq.setVisibility(8);
                this.dfd.setVisibility(8);
                this.bSZ.setFromCDN(this.aiR);
                this.bSZ.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i3, boolean z) {
                        x<com.baidu.tieba.homepage.concern.b.b> ZJ = f.this.ZJ();
                        if (ZJ != null) {
                            view.setTag("1");
                            ZJ.a(view, f.this.dfl);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.biZ);
                        } else {
                            f.this.aab();
                        }
                    }
                });
                this.bSZ.setImageMediaList(linkedList);
            } else if (v.u(linkedList2) > 0) {
                this.bSZ.setVisibility(8);
                this.dfq.setVisibility(0);
                this.dfd.setVisibility(8);
                this.dfq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.aab();
                    }
                });
                this.dfq.setData(linkedList2);
            } else {
                this.bSZ.setVisibility(8);
                this.dfd.setVisibility(0);
            }
        } else {
            this.bSZ.setVisibility(8);
            this.dfq.setVisibility(8);
            this.dfd.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            com.baidu.adp.lib.util.l.showToast(this.mPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aiR ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.rz(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bSZ != null) {
            this.bSZ.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
