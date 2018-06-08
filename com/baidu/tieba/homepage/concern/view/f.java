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
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes2.dex */
public class f extends d {
    private boolean asK;
    public PlayVoiceBntNew cyE;
    private ConstrainImageGroup cyH;
    private final View.OnClickListener cyK;
    private View dNP;
    private ConcernVideoImageView dOd;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.asK = true;
        this.cyK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tieba.homepage.concern.b.b> aiI = f.this.aiI();
                if (aiI != null) {
                    view.setTag("2");
                    aiI.a(view, f.this.dNX);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ac(View view) {
        if (view != null) {
            this.cyE = (PlayVoiceBntNew) view.findViewById(d.g.card_recommend_god_therad_voice);
            this.cyE.setAfterClickListener(this.cyK);
            this.cyH = (ConstrainImageGroup) view.findViewById(d.g.card_recommend_god_therad_img_layout);
            this.dOd = (ConcernVideoImageView) view.findViewById(d.g.card_recommend_god_thread_video_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds16);
            this.cyH.setChildClickListener(this.dOa);
            this.cyH.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
            eVar.j(1.0d);
            this.cyH.setImageProcessor(eVar);
            this.dNP = view.findViewById(d.g.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.cyH != null) {
            this.cyH.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.cyH != null) {
            this.cyH.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.cyH != null) {
            this.cyH.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.cyH.onChangeSkinType();
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
            this.bGe.setVisibility(8);
            ((LinearLayout.LayoutParams) this.dNW.getLayoutParams()).bottomMargin = (int) this.mPageContext.getResources().getDimension(d.e.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.dOa);
        }
        this.bGe.setVisibility(0);
        ArrayList<MediaData> vw = bdVar.vw();
        int y = w.y(vw);
        if (!this.dNY) {
            StringBuilder sb = new StringBuilder();
            if (bdVar.getAbstract() != null && !StringUtils.isNull(bdVar.getAbstract())) {
                sb.append(bdVar.getAbstract());
            }
            if (vw != null && y > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < y; i++) {
                    if (vw.get(i).getVideoUrl() != null && vw.get(i).getVideoUrl().endsWith("swf")) {
                        sb2.append(vw.get(i).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bdVar.g(sb.toString(), true))) {
                    SpannableString m13do = bdVar.m13do(sb.toString());
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
        ArrayList<VoiceData.VoiceModel> vA = bdVar.vA();
        if (w.z(vA)) {
            this.cyE.setVisibility(8);
        } else {
            this.cyE.setVisibility(0);
            VoiceData.VoiceModel voiceModel = vA.get(0);
            this.cyE.setVoiceModel(voiceModel);
            this.cyE.setTag(voiceModel);
            this.cyE.aNN();
            if (voiceModel != null) {
                this.cyE.om(voiceModel.voice_status.intValue());
            }
        }
        if (i.tt().tz() && y > 0) {
            final LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (int i2 = 0; i2 < y; i2++) {
                MediaData mediaData = (MediaData) w.c(vw, i2);
                if (mediaData != null) {
                    if (mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    } else if (mediaData.getType() == 5) {
                        linkedList2.add(mediaData);
                    }
                }
            }
            if (w.y(linkedList) > 0) {
                this.dNP.setVisibility(8);
                this.cyH.setVisibility(0);
                this.dOd.setVisibility(8);
                this.cyH.setFromCDN(this.asK);
                this.cyH.setImageClickListener(new com.baidu.tbadk.widget.layout.c() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.c
                    public void c(View view, int i3, boolean z) {
                        ab<com.baidu.tieba.homepage.concern.b.b> aiI = f.this.aiI();
                        if (aiI != null) {
                            view.setTag("1");
                            aiI.a(view, f.this.dNX);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i3, f.this.bso);
                        } else {
                            f.this.ajb();
                        }
                    }
                });
                this.cyH.setImageMediaList(linkedList);
            } else if (w.y(linkedList2) > 0) {
                this.cyH.setVisibility(8);
                this.dOd.setVisibility(0);
                this.dOd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        f.this.ajb();
                    }
                });
                this.dOd.setData(linkedList2);
                this.dNP.setVisibility(0);
            } else {
                this.cyH.setVisibility(8);
            }
        } else {
            this.cyH.setVisibility(8);
            this.dOd.setVisibility(8);
            this.dNP.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bd bdVar) {
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
                    imageUrlData.urlType = this.asK ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, bdVar.vr(), String.valueOf(bdVar.getFid()), bdVar.getTid(), this.asK, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cyH != null) {
            this.cyH.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
