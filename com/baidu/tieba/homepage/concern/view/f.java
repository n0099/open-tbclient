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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class f extends d {
    private boolean ZP;
    public PlayVoiceBntNew ZY;
    private ConstrainImageGroup ein;
    private final View.OnClickListener eit;
    private View fHl;
    private ConcernVideoImageView fHz;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ZP = true;
        this.eit = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.homepage.concern.b.b> aQh = f.this.aQh();
                if (aQh != null) {
                    view.setTag("2");
                    aQh.a(view, f.this.fHs);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void bQ(View view) {
        if (view != null) {
            this.ZY = (PlayVoiceBntNew) view.findViewById(d.g.card_recommend_god_therad_voice);
            this.ZY.setAfterClickListener(this.eit);
            this.ein = (ConstrainImageGroup) view.findViewById(d.g.card_recommend_god_therad_img_layout);
            this.fHz = (ConcernVideoImageView) view.findViewById(d.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            this.ein.setChildClickListener(this.fHv);
            this.ein.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
            fVar.h(1.0d);
            this.ein.setImageProcessor(fVar);
            this.fHl = view.findViewById(d.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.ein != null) {
            this.ein.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ein != null) {
            this.ein.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ein != null) {
            this.ein.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        this.ein.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ao(bg bgVar) {
        if (bgVar == null || bgVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.drv.setVisibility(8);
            ((LinearLayout.LayoutParams) this.fHr.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(d.e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fHv);
        }
        this.drv.setVisibility(0);
        ArrayList<MediaData> Zb = bgVar.Zb();
        int S = v.S(Zb);
        if (!this.fHt) {
            StringBuilder sb = new StringBuilder();
            if (bgVar.getAbstract() != null && !StringUtils.isNull(bgVar.getAbstract())) {
                sb.append(bgVar.getAbstract());
            }
            if (Zb != null && S > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < S; i++) {
                    if (Zb.get(i).getVideoUrl() != null && Zb.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(Zb.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bgVar.H(sb.toString(), true))) {
                    SpannableString ll = bgVar.ll(sb.toString());
                    this.mTitle.setOnTouchListener(new k(ll));
                    this.mTitle.setText(ll);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> Zf = bgVar.Zf();
        if (v.T(Zf)) {
            this.ZY.setVisibility(8);
        } else {
            this.ZY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Zf.get(0);
            this.ZY.setVoiceModel(voiceModel);
            this.ZY.setTag(voiceModel);
            this.ZY.bxV();
            if (voiceModel != null) {
                this.ZY.uu(voiceModel.voice_status.intValue());
            }
        }
        if (i.Wy().WC() && S > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < S; i2++) {
                MediaData mediaData = (MediaData) v.c(Zb, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (v.S(linkedList) > 0) {
                this.fHl.setVisibility(8);
                this.ein.setVisibility(0);
                this.fHz.setVisibility(8);
                this.ein.setFromCDN(this.ZP);
                this.ein.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i3, boolean z) {
                        ab<com.baidu.tieba.homepage.concern.b.b> aQh = f.this.aQh();
                        if (aQh != null) {
                            view.setTag("1");
                            aQh.a(view, f.this.fHs);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.bTl);
                        } else {
                            f.this.ajX();
                        }
                    }
                });
                this.ein.setImageMediaList(linkedList);
            } else if (v.S(linkedList2) > 0) {
                this.ein.setVisibility(8);
                this.fHz.setVisibility(0);
                this.fHz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.ajX();
                    }
                });
                this.fHz.setData(linkedList2);
                this.fHl.setVisibility(0);
            } else {
                this.ein.setVisibility(8);
            }
        } else {
            this.ein.setVisibility(8);
            this.fHz.setVisibility(8);
            this.fHl.setVisibility(0);
        }
        setPageUniqueId(getTag());
        onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
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
                    imageUrlData.urlType = this.ZP ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bgVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YW(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZP, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ein != null) {
            this.ein.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
