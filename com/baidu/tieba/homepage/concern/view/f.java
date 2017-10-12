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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class f extends d {
    private boolean aiG;
    public PlayVoiceBntNew bLr;
    private ConstrainImageGroup bLu;
    private final View.OnClickListener bLv;
    private View cWG;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aiG = true;
        this.bLv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.homepage.concern.b.b> Xr = f.this.Xr();
                if (Xr != null) {
                    view.setTag("2");
                    Xr.a(view, f.this.cWN);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void aa(View view) {
        if (view != null) {
            this.bLr = (PlayVoiceBntNew) view.findViewById(d.h.card_recommend_god_therad_voice);
            this.bLr.setAfterClickListener(this.bLv);
            this.bLu = (ConstrainImageGroup) view.findViewById(d.h.card_recommend_god_therad_img_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
            this.bLu.setChildClickListener(this.cWQ);
            this.bLu.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
            fVar.e(1.0d);
            this.bLu.setImageProcessor(fVar);
            this.cWG = view.findViewById(d.h.no_image_divider_line);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.bLu != null) {
            this.bLu.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLu != null) {
            this.bLu.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLu != null) {
            this.bLu.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bLu.onChangeSkinType();
        aj.k(this.cWG, d.e.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void Q(bh bhVar) {
        ArrayList<MediaData> arrayList;
        int i;
        if (bhVar == null || bhVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.bnn.setVisibility(8);
            ((LinearLayout.LayoutParams) this.cWM.getLayoutParams()).bottomMargin = (int) this.mG.getResources().getDimension(d.f.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cWQ);
        }
        this.bnn.setVisibility(0);
        if (this.cWO) {
            arrayList = null;
            i = 0;
        } else {
            StringBuilder sb = new StringBuilder();
            if (bhVar.rD() != null && !StringUtils.isNull(bhVar.rD())) {
                sb.append(bhVar.rD());
            }
            arrayList = bhVar.rF();
            if (arrayList != null) {
                i = arrayList.size();
                StringBuilder sb2 = new StringBuilder();
                for (int i2 = 0; i2 < i; i2++) {
                    if (arrayList.get(i2).getVideoUrl() != null && arrayList.get(i2).getVideoUrl().endsWith("swf")) {
                        sb2.append(arrayList.get(i2).getVideoUrl());
                    }
                }
                sb.append(sb2.toString());
                if (!TextUtils.isEmpty(bhVar.g(sb.toString(), true))) {
                    SpannableString cE = bhVar.cE(sb.toString());
                    this.mTitle.setOnTouchListener(new k(cE));
                    this.mTitle.setText(cE);
                    this.mTitle.setVisibility(0);
                } else {
                    this.mTitle.setVisibility(8);
                }
            } else {
                this.mTitle.setVisibility(8);
                i = 0;
            }
        }
        ArrayList<VoiceData.VoiceModel> rJ = bhVar.rJ();
        if (v.u(rJ)) {
            this.bLr.setVisibility(8);
        } else {
            this.bLr.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rJ.get(0);
            this.bLr.setVoiceModel(voiceModel);
            this.bLr.setTag(voiceModel);
            this.bLr.bgh();
            if (voiceModel != null) {
                this.bLr.nh(voiceModel.voice_status.intValue());
            }
        }
        if (h.oT().oZ() && v.t(arrayList) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) v.c(arrayList, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.t(linkedList) > 0) {
                this.bLu.setVisibility(0);
                this.cWG.setVisibility(8);
                this.bLu.setFromCDN(this.aiG);
                this.bLu.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i4, boolean z) {
                        x<com.baidu.tieba.homepage.concern.b.b> Xr = f.this.Xr();
                        if (Xr != null) {
                            view.setTag("1");
                            Xr.a(view, f.this.cWN);
                        }
                        if (!z) {
                            f.this.a(view, linkedList, i4, f.this.bit);
                        } else {
                            f.this.XJ();
                        }
                    }
                });
                this.bLu.setImageMediaList(linkedList);
            } else {
                this.bLu.setVisibility(8);
                this.cWG.setVisibility(0);
            }
        } else {
            this.bLu.setVisibility(8);
            this.cWG.setVisibility(0);
        }
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mG.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aiG ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mG.getPageActivity()).createConfig(arrayList, i, bhVar.rA(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.aiG, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bLu != null) {
            this.bLu.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
