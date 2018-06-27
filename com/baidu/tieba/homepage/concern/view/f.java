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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class f extends d {
    private boolean atn;
    private ConstrainImageGroup cwB;
    private final View.OnClickListener cwE;
    public PlayVoiceBntNew cwy;
    private View dRg;
    private ConcernVideoImageView dRu;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.atn = true;
        this.cwE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ad<com.baidu.tieba.homepage.concern.b.b> aia = f.this.aia();
                if (aia != null) {
                    view.setTag("2");
                    aia.a(view, f.this.dRo);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ae(View view) {
        if (view != null) {
            this.cwy = (PlayVoiceBntNew) view.findViewById(d.g.card_recommend_god_therad_voice);
            this.cwy.setAfterClickListener(this.cwE);
            this.cwB = (ConstrainImageGroup) view.findViewById(d.g.card_recommend_god_therad_img_layout);
            this.dRu = (ConcernVideoImageView) view.findViewById(d.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            this.cwB.setChildClickListener(this.dRr);
            this.cwB.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
            eVar.i(1.0d);
            this.cwB.setImageProcessor(eVar);
            this.dRg = view.findViewById(d.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.cwB != null) {
            this.cwB.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cwB != null) {
            this.cwB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cwB != null) {
            this.cwB.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cwB.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ad(bc bcVar) {
        if (bcVar == null || bcVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.bHY.setVisibility(8);
            ((LinearLayout.LayoutParams) this.dRn.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(d.e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.dRr);
        }
        this.bHY.setVisibility(0);
        ArrayList<MediaData> vG = bcVar.vG();
        int z = w.z(vG);
        if (!this.dRp) {
            StringBuilder sb = new StringBuilder();
            if (bcVar.getAbstract() != null && !StringUtils.isNull(bcVar.getAbstract())) {
                sb.append(bcVar.getAbstract());
            }
            if (vG != null && z > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < z; i++) {
                    if (vG.get(i).getVideoUrl() != null && vG.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(vG.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bcVar.g(sb.toString(), true))) {
                    SpannableString dr = bcVar.dr(sb.toString());
                    this.mTitle.setOnTouchListener(new k(dr));
                    this.mTitle.setText(dr);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> vK = bcVar.vK();
        if (w.A(vK)) {
            this.cwy.setVisibility(8);
        } else {
            this.cwy.setVisibility(0);
            VoiceData.VoiceModel voiceModel = vK.get(0);
            this.cwy.setVoiceModel(voiceModel);
            this.cwy.setTag(voiceModel);
            this.cwy.aOt();
            if (voiceModel != null) {
                this.cwy.ot(voiceModel.voice_status.intValue());
            }
        }
        if (i.tt().tz() && z > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < z; i2++) {
                MediaData mediaData = (MediaData) w.d(vG, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (w.z(linkedList) > 0) {
                this.dRg.setVisibility(8);
                this.cwB.setVisibility(0);
                this.dRu.setVisibility(8);
                this.cwB.setFromCDN(this.atn);
                this.cwB.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void c(View view, int i3, boolean z2) {
                        ad<com.baidu.tieba.homepage.concern.b.b> aia = f.this.aia();
                        if (aia != null) {
                            view.setTag("1");
                            aia.a(view, f.this.dRo);
                        }
                        if (!z2) {
                            f.this.a(view, linkedList, i3, f.this.btP);
                        } else {
                            f.this.ait();
                        }
                    }
                });
                this.cwB.setImageMediaList(linkedList);
            } else if (w.z(linkedList2) > 0) {
                this.cwB.setVisibility(8);
                this.dRu.setVisibility(0);
                this.dRu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.ait();
                    }
                });
                this.dRu.setData(linkedList2);
                this.dRg.setVisibility(0);
            } else {
                this.cwB.setVisibility(8);
            }
        } else {
            this.cwB.setVisibility(8);
            this.dRu.setVisibility(8);
            this.dRg.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bc bcVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mPageContext.getPageActivity(), d.k.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.atn ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bcVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bcVar.vB(), String.valueOf(bcVar.getFid()), bcVar.getTid(), this.atn, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cwB != null) {
            this.cwB.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
