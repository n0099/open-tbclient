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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class f extends d {
    private boolean asS;
    public PlayVoiceBntNew cyY;
    private ConstrainImageGroup czb;
    private final View.OnClickListener cze;
    private View dTO;
    private ConcernVideoImageView dUc;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.asS = true;
        this.cze = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.homepage.concern.b.b> aiC = f.this.aiC();
                if (aiC != null) {
                    view.setTag("2");
                    aiC.a(view, f.this.dTW);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ah(View view) {
        if (view != null) {
            this.cyY = (PlayVoiceBntNew) view.findViewById(f.g.card_recommend_god_therad_voice);
            this.cyY.setAfterClickListener(this.cze);
            this.czb = (ConstrainImageGroup) view.findViewById(f.g.card_recommend_god_therad_img_layout);
            this.dUc = (ConcernVideoImageView) view.findViewById(f.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds16);
            this.czb.setChildClickListener(this.dTZ);
            this.czb.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
            eVar.g(1.0d);
            this.czb.setImageProcessor(eVar);
            this.dTO = view.findViewById(f.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.czb != null) {
            this.czb.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.czb != null) {
            this.czb.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.czb != null) {
            this.czb.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.czb.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void af(bb bbVar) {
        if (bbVar == null || bbVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.bIN.setVisibility(8);
            ((LinearLayout.LayoutParams) this.dTV.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(f.e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.dTZ);
        }
        this.bIN.setVisibility(0);
        ArrayList<MediaData> vu = bbVar.vu();
        int y = w.y(vu);
        if (!this.dTX) {
            StringBuilder sb = new StringBuilder();
            if (bbVar.getAbstract() != null && !StringUtils.isNull(bbVar.getAbstract())) {
                sb.append(bbVar.getAbstract());
            }
            if (vu != null && y > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < y; i++) {
                    if (vu.get(i).getVideoUrl() != null && vu.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(vu.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bbVar.f(sb.toString(), true))) {
                    SpannableString m13do = bbVar.m13do(sb.toString());
                    this.mTitle.setOnTouchListener(new k(m13do));
                    this.mTitle.setText(m13do);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> vy = bbVar.vy();
        if (w.z(vy)) {
            this.cyY.setVisibility(8);
        } else {
            this.cyY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = vy.get(0);
            this.cyY.setVoiceModel(voiceModel);
            this.cyY.setTag(voiceModel);
            this.cyY.aPq();
            if (voiceModel != null) {
                this.cyY.oH(voiceModel.voice_status.intValue());
            }
        }
        if (i.td().tj() && y > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < y; i2++) {
                MediaData mediaData = (MediaData) w.d(vu, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (w.y(linkedList) > 0) {
                this.dTO.setVisibility(8);
                this.czb.setVisibility(0);
                this.dUc.setVisibility(8);
                this.czb.setFromCDN(this.asS);
                this.czb.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void b(View view, int i3, boolean z) {
                        ad<com.baidu.tieba.homepage.concern.b.b> aiC = f.this.aiC();
                        if (aiC != null) {
                            view.setTag("1");
                            aiC.a(view, f.this.dTW);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.buy);
                        } else {
                            f.this.aiV();
                        }
                    }
                });
                this.czb.setImageMediaList(linkedList);
            } else if (w.y(linkedList2) > 0) {
                this.czb.setVisibility(8);
                this.dUc.setVisibility(0);
                this.dUc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.aiV();
                    }
                });
                this.dUc.setData(linkedList2);
                this.dTO.setVisibility(0);
            } else {
                this.czb.setVisibility(8);
            }
        } else {
            this.czb.setVisibility(8);
            this.dUc.setVisibility(8);
            this.dTO.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bb bbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), f.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.asS ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bbVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bbVar.vp(), String.valueOf(bbVar.getFid()), bbVar.getTid(), this.asS, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.czb != null) {
            this.czb.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
