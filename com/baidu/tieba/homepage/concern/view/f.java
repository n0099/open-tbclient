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
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class f extends d {
    private boolean akC;
    public PlayVoiceBntNew coU;
    private ConstrainImageGroup coX;
    private final View.OnClickListener cpa;
    private View dBD;
    private ConcernVideoImageView dBR;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.akC = true;
        this.cpa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ab<com.baidu.tieba.homepage.concern.b.b> aeZ = f.this.aeZ();
                if (aeZ != null) {
                    view2.setTag("2");
                    aeZ.a(view2, f.this.dBL);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ac(View view2) {
        if (view2 != null) {
            this.coU = (PlayVoiceBntNew) view2.findViewById(d.g.card_recommend_god_therad_voice);
            this.coU.setAfterClickListener(this.cpa);
            this.coX = (ConstrainImageGroup) view2.findViewById(d.g.card_recommend_god_therad_img_layout);
            this.dBR = (ConcernVideoImageView) view2.findViewById(d.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            this.coX.setChildClickListener(this.dBO);
            this.coX.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
            eVar.i(1.0d);
            this.coX.setImageProcessor(eVar);
            this.dBD = view2.findViewById(d.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.coX != null) {
            this.coX.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.coX != null) {
            this.coX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.coX != null) {
            this.coX.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.coX.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void Y(bd bdVar) {
        if (bdVar == null || bdVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.bxk.setVisibility(8);
            ((LinearLayout.LayoutParams) this.dBK.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(d.e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.dBO);
        }
        this.bxk.setVisibility(0);
        ArrayList<MediaData> sa = bdVar.sa();
        int v = v.v(sa);
        if (!this.dBM) {
            StringBuilder sb = new StringBuilder();
            if (bdVar.getAbstract() != null && !StringUtils.isNull(bdVar.getAbstract())) {
                sb.append(bdVar.getAbstract());
            }
            if (sa != null && v > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < v; i++) {
                    if (sa.get(i).getVideoUrl() != null && sa.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(sa.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bdVar.g(sb.toString(), true))) {
                    SpannableString cP = bdVar.cP(sb.toString());
                    this.mTitle.setOnTouchListener(new j(cP));
                    this.mTitle.setText(cP);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> se = bdVar.se();
        if (v.w(se)) {
            this.coU.setVisibility(8);
        } else {
            this.coU.setVisibility(0);
            VoiceData.VoiceModel voiceModel = se.get(0);
            this.coU.setVoiceModel(voiceModel);
            this.coU.setTag(voiceModel);
            this.coU.aIT();
            if (voiceModel != null) {
                this.coU.ob(voiceModel.voice_status.intValue());
            }
        }
        if (i.pY().qe() && v > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < v; i2++) {
                MediaData mediaData = (MediaData) v.c(sa, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (v.v(linkedList) > 0) {
                this.dBD.setVisibility(8);
                this.coX.setVisibility(0);
                this.dBR.setVisibility(8);
                this.coX.setFromCDN(this.akC);
                this.coX.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void c(View view2, int i3, boolean z) {
                        ab<com.baidu.tieba.homepage.concern.b.b> aeZ = f.this.aeZ();
                        if (aeZ != null) {
                            view2.setTag("1");
                            aeZ.a(view2, f.this.dBL);
                        }
                        if (!z) {
                            f.this.a(view2, linkedList, i3, f.this.bjU);
                        } else {
                            f.this.afs();
                        }
                    }
                });
                this.coX.setImageMediaList(linkedList);
            } else if (v.v(linkedList2) > 0) {
                this.coX.setVisibility(8);
                this.dBR.setVisibility(0);
                this.dBR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        f.this.afs();
                    }
                });
                this.dBR.setData(linkedList2);
                this.dBD.setVisibility(0);
            } else {
                this.coX.setVisibility(8);
            }
        } else {
            this.coX.setVisibility(8);
            this.dBR.setVisibility(8);
            this.dBD.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2, List<MediaData> list, int i, bd bdVar) {
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
                    imageUrlData.urlType = this.akC ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.rV(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.akC, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view2.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.coX != null) {
            this.coX.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view2) {
    }
}
