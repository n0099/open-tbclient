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
    private boolean aAQ;
    public PlayVoiceBntNew cOq;
    private ConstrainImageGroup cOt;
    private final View.OnClickListener cOw;
    private ConcernVideoImageView ekJ;
    private View ekv;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aAQ = true;
        this.cOw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.homepage.concern.b.b> anq = f.this.anq();
                if (anq != null) {
                    view.setTag("2");
                    anq.a(view, f.this.ekD);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ax(View view) {
        if (view != null) {
            this.cOq = (PlayVoiceBntNew) view.findViewById(e.g.card_recommend_god_therad_voice);
            this.cOq.setAfterClickListener(this.cOw);
            this.cOt = (ConstrainImageGroup) view.findViewById(e.g.card_recommend_god_therad_img_layout);
            this.ekJ = (ConcernVideoImageView) view.findViewById(e.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds16);
            this.cOt.setChildClickListener(this.ekG);
            this.cOt.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
            eVar.g(1.0d);
            this.cOt.setImageProcessor(eVar);
            this.ekv = view.findViewById(e.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.cOt != null) {
            this.cOt.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cOt != null) {
            this.cOt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cOt != null) {
            this.cOt.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cOt.onChangeSkinType();
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
            this.bXP.setVisibility(8);
            ((LinearLayout.LayoutParams) this.ekC.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(e.C0200e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ekG);
        }
        this.bXP.setVisibility(0);
        ArrayList<MediaData> yN = bbVar.yN();
        int H = v.H(yN);
        if (!this.ekE) {
            StringBuilder sb = new StringBuilder();
            if (bbVar.getAbstract() != null && !StringUtils.isNull(bbVar.getAbstract())) {
                sb.append(bbVar.getAbstract());
            }
            if (yN != null && H > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < H; i++) {
                    if (yN.get(i).getVideoUrl() != null && yN.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(yN.get(i).getVideoUrl());
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
        ArrayList<VoiceData.VoiceModel> yR = bbVar.yR();
        if (v.I(yR)) {
            this.cOq.setVisibility(8);
        } else {
            this.cOq.setVisibility(0);
            VoiceData.VoiceModel voiceModel = yR.get(0);
            this.cOq.setVoiceModel(voiceModel);
            this.cOq.setTag(voiceModel);
            this.cOq.aUo();
            if (voiceModel != null) {
                this.cOq.qc(voiceModel.voice_status.intValue());
            }
        }
        if (i.wA().wE() && H > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < H; i2++) {
                MediaData mediaData = (MediaData) v.d(yN, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (v.H(linkedList) > 0) {
                this.ekv.setVisibility(8);
                this.cOt.setVisibility(0);
                this.ekJ.setVisibility(8);
                this.cOt.setFromCDN(this.aAQ);
                this.cOt.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i3, boolean z) {
                        ad<com.baidu.tieba.homepage.concern.b.b> anq = f.this.anq();
                        if (anq != null) {
                            view.setTag("1");
                            anq.a(view, f.this.ekD);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.bJG);
                        } else {
                            f.this.anK();
                        }
                    }
                });
                this.cOt.setImageMediaList(linkedList);
            } else if (v.H(linkedList2) > 0) {
                this.cOt.setVisibility(8);
                this.ekJ.setVisibility(0);
                this.ekJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.anK();
                    }
                });
                this.ekJ.setData(linkedList2);
                this.ekv.setVisibility(0);
            } else {
                this.cOt.setVisibility(8);
            }
        } else {
            this.cOt.setVisibility(8);
            this.ekJ.setVisibility(8);
            this.ekv.setVisibility(0);
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
                    imageUrlData.urlType = this.aAQ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.yI(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.aAQ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cOt != null) {
            this.cOt.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
