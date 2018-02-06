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
    private boolean aZj;
    public PlayVoiceBntNew cXc;
    private ConstrainImageGroup cXf;
    private final View.OnClickListener cXi;
    private View egT;
    private ConcernVideoImageView ehh;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aZj = true;
        this.cXi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                v<com.baidu.tieba.homepage.concern.b.b> akP = f.this.akP();
                if (akP != null) {
                    view.setTag("2");
                    akP.a(view, f.this.ehb);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void by(View view) {
        if (view != null) {
            this.cXc = (PlayVoiceBntNew) view.findViewById(d.g.card_recommend_god_therad_voice);
            this.cXc.setAfterClickListener(this.cXi);
            this.cXf = (ConstrainImageGroup) view.findViewById(d.g.card_recommend_god_therad_img_layout);
            this.ehh = (ConcernVideoImageView) view.findViewById(d.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            this.cXf.setChildClickListener(this.ehe);
            this.cXf.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
            fVar.h(1.0d);
            this.cXf.setImageProcessor(fVar);
            this.egT = view.findViewById(d.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.cXf != null) {
            this.cXf.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.cXf != null) {
            this.cXf.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cXf != null) {
            this.cXf.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cXf.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void X(bd bdVar) {
        if (bdVar == null || bdVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.cnj.setVisibility(8);
            ((LinearLayout.LayoutParams) this.eha.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(d.e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.ehe);
        }
        this.cnj.setVisibility(0);
        ArrayList<MediaData> zy = bdVar.zy();
        int D = com.baidu.tbadk.core.util.v.D(zy);
        if (!this.ehc) {
            StringBuilder sb = new StringBuilder();
            if (bdVar.getAbstract() != null && !StringUtils.isNull(bdVar.getAbstract())) {
                sb.append(bdVar.getAbstract());
            }
            if (zy != null && D > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < D; i++) {
                    if (zy.get(i).getVideoUrl() != null && zy.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(zy.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bdVar.g(sb.toString(), true))) {
                    SpannableString db = bdVar.db(sb.toString());
                    this.mTitle.setOnTouchListener(new m(db));
                    this.mTitle.setText(db);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
            }
        }
        ArrayList<VoiceData.VoiceModel> zC = bdVar.zC();
        if (com.baidu.tbadk.core.util.v.E(zC)) {
            this.cXc.setVisibility(8);
        } else {
            this.cXc.setVisibility(0);
            VoiceData.VoiceModel voiceModel = zC.get(0);
            this.cXc.setVoiceModel(voiceModel);
            this.cXc.setTag(voiceModel);
            this.cXc.aNR();
            if (voiceModel != null) {
                this.cXc.qG(voiceModel.voice_status.intValue());
            }
        }
        if (i.xo().xu() && D > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < D; i2++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.f(zy, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (com.baidu.tbadk.core.util.v.D(linkedList) > 0) {
                this.egT.setVisibility(8);
                this.cXf.setVisibility(0);
                this.ehh.setVisibility(8);
                this.cXf.setFromCDN(this.aZj);
                this.cXf.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void f(View view, int i3, boolean z) {
                        v<com.baidu.tieba.homepage.concern.b.b> akP = f.this.akP();
                        if (akP != null) {
                            view.setTag("1");
                            akP.a(view, f.this.ehb);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.cad);
                        } else {
                            f.this.alj();
                        }
                    }
                });
                this.cXf.setImageMediaList(linkedList);
            } else if (com.baidu.tbadk.core.util.v.D(linkedList2) > 0) {
                this.cXf.setVisibility(8);
                this.ehh.setVisibility(0);
                this.ehh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.alj();
                    }
                });
                this.ehh.setData(linkedList2);
                this.egT.setVisibility(0);
            } else {
                this.cXf.setVisibility(8);
            }
        } else {
            this.cXf.setVisibility(8);
            this.ehh.setVisibility(8);
            this.egT.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
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
                    imageUrlData.urlType = this.aZj ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.zt(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.aZj, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cXf != null) {
            this.cXf.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
