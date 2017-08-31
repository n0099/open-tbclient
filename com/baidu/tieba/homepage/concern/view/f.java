package com.baidu.tieba.homepage.concern.view;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class f extends d {
    private boolean ajf;
    public PlayVoiceBntNew bLe;
    private TextView bLf;
    private ConstrainImageGroup bLg;
    private final View.OnClickListener bLh;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ajf = true;
        this.bLh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x<com.baidu.tieba.homepage.concern.b.b> XA = f.this.XA();
                if (XA != null) {
                    view.setTag("2");
                    XA.a(view, f.this.cZq);
                }
            }
        };
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void ab(View view) {
        if (view != null) {
            this.bLe = (PlayVoiceBntNew) view.findViewById(d.h.card_recommend_god_therad_voice);
            this.bLe.setAfterClickListener(this.bLh);
            this.bLf = (TextView) view.findViewById(d.h.card_recommend_god_therad_abstract);
            this.bLg = (ConstrainImageGroup) view.findViewById(d.h.card_recommend_god_therad_img_layout);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds16);
            this.bLg.setChildClickListener(this.cZt);
            this.bLg.setImageMargin(dimensionPixelSize);
            com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
            fVar.e(1.0d);
            this.bLg.setImageProcessor(fVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.bLg != null) {
            this.bLg.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        if (this.bLg != null) {
            this.bLg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.bLg != null) {
            this.bLg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.bLg.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_recgod_normal;
    }

    @Override // com.baidu.tieba.homepage.concern.view.d
    protected void V(bj bjVar) {
        int i;
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (bjVar == null || bjVar.getTid() == null) {
            if (getView() == null) {
                getView().setVisibility(8);
            }
            this.blD.setVisibility(8);
            ((LinearLayout.LayoutParams) this.cZp.getLayoutParams()).bottomMargin = (int) this.mF.getResources().getDimension(d.f.ds34);
            return;
        }
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cZt);
        }
        this.blD.setVisibility(0);
        StringBuilder sb = new StringBuilder();
        if (bjVar.rJ() != null && !StringUtils.isNull(bjVar.rJ())) {
            sb.append(bjVar.rJ());
        }
        ArrayList<MediaData> rL = bjVar.rL();
        if (rL != null) {
            i = rL.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                if (rL.get(i2).getVideoUrl() != null && rL.get(i2).getVideoUrl().endsWith("swf")) {
                    sb2.append(rL.get(i2).getVideoUrl());
                }
            }
            sb.append(sb2.toString());
            if (!TextUtils.isEmpty(bjVar.g(sb.toString(), true))) {
                SpannableString cE = bjVar.cE(sb.toString());
                this.bLf.setOnTouchListener(new m(cE));
                this.bLf.setText(cE);
                this.bLf.setVisibility(0);
                com.baidu.tieba.card.m.a(this.bLf, bjVar.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
                z2 = true;
            } else {
                this.bLf.setVisibility(8);
                z2 = false;
            }
            z = z2;
        } else {
            this.bLf.setVisibility(8);
            i = 0;
            z = false;
        }
        ArrayList<VoiceData.VoiceModel> rP = bjVar.rP();
        if (v.v(rP)) {
            this.bLe.setVisibility(8);
        } else {
            this.bLe.setVisibility(0);
            VoiceData.VoiceModel voiceModel = rP.get(0);
            this.bLe.setVoiceModel(voiceModel);
            this.bLe.setTag(voiceModel);
            this.bLe.bhr();
            if (voiceModel != null) {
                this.bLe.nj(voiceModel.voice_status.intValue());
            }
        }
        if (h.oS().oY() && v.u(rL) != 0) {
            LinkedList linkedList = new LinkedList();
            final LinkedList linkedList2 = new LinkedList();
            for (int i3 = 0; i3 < i; i3++) {
                MediaData mediaData = (MediaData) v.c(rL, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData.getThumbnails_url());
                    linkedList2.add(mediaData);
                }
            }
            if (v.u(linkedList) > 0) {
                this.bLg.setVisibility(0);
                this.bLg.setFromCDN(this.ajf);
                this.bLg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.concern.view.f.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i4, boolean z4) {
                        x<com.baidu.tieba.homepage.concern.b.b> XA = f.this.XA();
                        if (XA != null) {
                            view.setTag("1");
                            XA.a(view, f.this.cZq);
                        }
                        if (!z4) {
                            f.this.a(linkedList2, i4, f.this.bgI);
                        } else {
                            f.this.XR();
                        }
                    }
                });
                this.bLg.setImageUrls(linkedList);
                h(this.cZr, z, z3);
                setPageUniqueId(getTag());
                d(null, TbadkCoreApplication.getInst().getSkinType());
            }
            this.bLg.setVisibility(8);
        } else {
            this.bLg.setVisibility(8);
        }
        z3 = false;
        h(this.cZr, z, z3);
        setPageUniqueId(getTag());
        d(null, TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.concern.view.d
    public void XF() {
        super.XF();
        com.baidu.tieba.card.m.a(this.bLf, this.bgI.getId(), d.e.cp_cont_f, d.e.cp_cont_d);
    }

    private void h(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLf.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bLg.getLayoutParams();
        if (!z && z2) {
            layoutParams.topMargin = 0;
        }
        if (!z3) {
            if (z2) {
                layoutParams2.topMargin = k.g(this.mContext, d.f.ds2);
            } else if (z) {
                layoutParams2.topMargin = 0;
            }
        } else if (z2) {
            layoutParams3.topMargin = k.g(this.mContext, d.f.ds13);
        } else if (z) {
            layoutParams3.topMargin = k.g(this.mContext, d.f.ds10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            k.showToast(this.mF.getPageActivity(), d.l.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ajf ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bjVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mF.getPageActivity()).createConfig(arrayList, i, bjVar.rG(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.ajf, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        createConfig.getIntent().putExtra("from", "frs");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.bLg != null) {
            this.bLg.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.homepage.concern.view.d, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
