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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class f extends d {
    private boolean aAb;
    public PlayVoiceBntNew cNk;
    private ConstrainImageGroup cNn;
    private final View.OnClickListener cNq;
    private View ejb;
    private ConcernVideoImageView ejp;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aAb = true;
        this.cNq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.homepage.concern.b.b> anP = f.this.anP();
                if (anP != null) {
                    view.setTag("2");
                    anP.a(view, f.this.ejj);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void av(View view) {
        if (view != null) {
            this.cNk = (PlayVoiceBntNew) view.findViewById(e.g.card_recommend_god_therad_voice);
            this.cNk.setAfterClickListener(this.cNq);
            this.cNn = (ConstrainImageGroup) view.findViewById(e.g.card_recommend_god_therad_img_layout);
            this.ejp = (ConcernVideoImageView) view.findViewById(e.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds16);
            this.cNn.setChildClickListener(this.ejm);
            this.cNn.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
            eVar.g(1.0d);
            this.cNn.setImageProcessor(eVar);
            this.ejb = view.findViewById(e.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.cNn != null) {
            this.cNn.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cNn != null) {
            this.cNn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cNn != null) {
            this.cNn.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cNn.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ag(bb bbVar) {
        if (bbVar == null || bbVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.bXd.setVisibility(8);
            ((LinearLayout.LayoutParams) this.eji.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(e.C0175e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ejm);
        }
        this.bXd.setVisibility(0);
        ArrayList<MediaData> yG = bbVar.yG();
        int I = v.I(yG);
        if (!this.ejk) {
            StringBuilder sb = new StringBuilder();
            if (bbVar.getAbstract() != null && !StringUtils.isNull(bbVar.getAbstract())) {
                sb.append(bbVar.getAbstract());
            }
            if (yG != null && I > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < I; i++) {
                    if (yG.get(i).getVideoUrl() != null && yG.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(yG.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bbVar.n(sb.toString(), true))) {
                    SpannableString dW = bbVar.dW(sb.toString());
                    this.mTitle.setOnTouchListener(new k(dW));
                    this.mTitle.setText(dW);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> yK = bbVar.yK();
        if (v.J(yK)) {
            this.cNk.setVisibility(8);
        } else {
            this.cNk.setVisibility(0);
            VoiceData.VoiceModel voiceModel = yK.get(0);
            this.cNk.setVoiceModel(voiceModel);
            this.cNk.setTag(voiceModel);
            this.cNk.aUR();
            if (voiceModel != null) {
                this.cNk.pJ(voiceModel.voice_status.intValue());
            }
        }
        if (i.ws().ww() && I > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < I; i2++) {
                MediaData mediaData = (MediaData) v.d(yG, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (v.I(linkedList) > 0) {
                this.ejb.setVisibility(8);
                this.cNn.setVisibility(0);
                this.ejp.setVisibility(8);
                this.cNn.setFromCDN(this.aAb);
                this.cNn.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i3, boolean z) {
                        ad<com.baidu.tieba.homepage.concern.b.b> anP = f.this.anP();
                        if (anP != null) {
                            view.setTag("1");
                            anP.a(view, f.this.ejj);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.bIV);
                        } else {
                            f.this.aoj();
                        }
                    }
                });
                this.cNn.setImageMediaList(linkedList);
            } else if (v.I(linkedList2) > 0) {
                this.cNn.setVisibility(8);
                this.ejp.setVisibility(0);
                this.ejp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.aoj();
                    }
                });
                this.ejp.setData(linkedList2);
                this.ejb.setVisibility(0);
            } else {
                this.cNn.setVisibility(8);
            }
        } else {
            this.cNn.setVisibility(8);
            this.ejp.setVisibility(8);
            this.ejb.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aAb ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bbVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.yB(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aAb, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cNn != null) {
            this.cNn.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
