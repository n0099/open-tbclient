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
    private boolean ZR;
    public PlayVoiceBntNew aaa;
    private ConstrainImageGroup eia;
    private final View.OnClickListener eig;
    private View fGZ;
    private ConcernVideoImageView fHn;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ZR = true;
        this.eig = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.homepage.concern.b.b> aQf = f.this.aQf();
                if (aQf != null) {
                    view.setTag("2");
                    aQf.a(view, f.this.fHg);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void bQ(View view) {
        if (view != null) {
            this.aaa = (PlayVoiceBntNew) view.findViewById(d.g.card_recommend_god_therad_voice);
            this.aaa.setAfterClickListener(this.eig);
            this.eia = (ConstrainImageGroup) view.findViewById(d.g.card_recommend_god_therad_img_layout);
            this.fHn = (ConcernVideoImageView) view.findViewById(d.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            this.eia.setChildClickListener(this.fHj);
            this.eia.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
            fVar.h(1.0d);
            this.eia.setImageProcessor(fVar);
            this.fGZ = view.findViewById(d.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.eia != null) {
            this.eia.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eia != null) {
            this.eia.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eia != null) {
            this.eia.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        this.eia.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void an(bg bgVar) {
        if (bgVar == null || bgVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.drz.setVisibility(8);
            ((LinearLayout.LayoutParams) this.fHf.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(d.e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.fHj);
        }
        this.drz.setVisibility(0);
        ArrayList<MediaData> YY = bgVar.YY();
        int S = v.S(YY);
        if (!this.fHh) {
            StringBuilder sb = new StringBuilder();
            if (bgVar.getAbstract() != null && !StringUtils.isNull(bgVar.getAbstract())) {
                sb.append(bgVar.getAbstract());
            }
            if (YY != null && S > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < S; i++) {
                    if (YY.get(i).getVideoUrl() != null && YY.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(YY.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bgVar.H(sb.toString(), true))) {
                    SpannableString lm = bgVar.lm(sb.toString());
                    this.mTitle.setOnTouchListener(new k(lm));
                    this.mTitle.setText(lm);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> Zc = bgVar.Zc();
        if (v.T(Zc)) {
            this.aaa.setVisibility(8);
        } else {
            this.aaa.setVisibility(0);
            VoiceData.VoiceModel voiceModel = Zc.get(0);
            this.aaa.setVoiceModel(voiceModel);
            this.aaa.setTag(voiceModel);
            this.aaa.bxS();
            if (voiceModel != null) {
                this.aaa.uq(voiceModel.voice_status.intValue());
            }
        }
        if (i.Wv().Wz() && S > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < S; i2++) {
                MediaData mediaData = (MediaData) v.c(YY, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (v.S(linkedList) > 0) {
                this.fGZ.setVisibility(8);
                this.eia.setVisibility(0);
                this.fHn.setVisibility(8);
                this.eia.setFromCDN(this.ZR);
                this.eia.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i3, boolean z) {
                        ab<com.baidu.tieba.homepage.concern.b.b> aQf = f.this.aQf();
                        if (aQf != null) {
                            view.setTag("1");
                            aQf.a(view, f.this.fHg);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.bTo);
                        } else {
                            f.this.ajU();
                        }
                    }
                });
                this.eia.setImageMediaList(linkedList);
            } else if (v.S(linkedList2) > 0) {
                this.eia.setVisibility(8);
                this.fHn.setVisibility(0);
                this.fHn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.ajU();
                    }
                });
                this.fHn.setData(linkedList2);
                this.fGZ.setVisibility(0);
            } else {
                this.eia.setVisibility(8);
            }
        } else {
            this.eia.setVisibility(8);
            this.fHn.setVisibility(8);
            this.fGZ.setVisibility(0);
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
                    imageUrlData.urlType = this.ZR ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YT(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_CONCERN);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eia != null) {
            this.eia.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
