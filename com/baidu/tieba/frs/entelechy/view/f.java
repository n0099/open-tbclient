package com.baidu.tieba.frs.entelechy.view;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class f extends e {
    private ArrayList<String> dpA;
    private View.OnClickListener dpB;
    private TextView dpw;
    private View dpx;
    private TbImageView dpy;
    private TextView dpz;
    private TbImageView.b mOnDrawListener;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dpA = new ArrayList<>();
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.tieba.frs.entelechy.view.f.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a he = com.baidu.tbadk.imageManager.c.ID().he(com.baidu.adp.lib.f.c.ig().f(tbImageView.getUrl(), f.this.asK ? 13 : 14));
                    if (he != null) {
                        int width = he.getWidth();
                        i = he.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f5 = height / i;
                                f2 = f5;
                                f3 = (width2 - (i2 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i2;
                                f = (height - (i * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        this.dpB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.y(f.this.dpA) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                        String str = (String) f.this.dpA.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = f.this.asK ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig createConfig = new ImageViewerConfig(f.this.mPageContext.getPageActivity()).createConfig(f.this.dpA, 0, "", "", "", f.this.asK, str, false, concurrentHashMap, false);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
                        createConfig.setIsShowHost(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
                        return;
                    }
                    l.showToast(f.this.mPageContext.getPageActivity(), d.k.plugin_image_viewer_install_error_tips);
                }
            }
        };
        View view = getView();
        if (view != null) {
            ((ViewStub) view.findViewById(d.g.viewstub_interview_live_info)).inflate();
            View findViewById = view.findViewById(d.g.text_interview_live);
            if (findViewById instanceof TextView) {
                this.dpw = (TextView) findViewById;
            }
            this.dpx = ((ViewStub) view.findViewById(d.g.viewstub_img_interview_live)).inflate();
            View findViewById2 = view.findViewById(d.g.img_interview_live);
            if (findViewById2 instanceof TbImageView) {
                this.dpy = (TbImageView) findViewById2;
                this.dpy.setPageId(bdUniqueId);
            }
            View findViewById3 = view.findViewById(d.g.interview_live_tip);
            if (findViewById3 instanceof TextView) {
                this.dpz = (TextView) findViewById3;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        if (bdVar != null && this.dpx != null && this.dpy != null && this.cyF != null) {
            if (bdVar.vw() != null) {
                bdVar.vw().clear();
            }
            bdVar.a((SparseArray<String>) null);
            bb uV = bdVar.uV();
            if (uV != null) {
                super.a(bdVar);
                if (com.baidu.tbadk.core.i.tt().tz() && uV != null && !StringUtils.isNull(uV.getThreadImgUrl())) {
                    this.dpA.clear();
                    this.dpA.add(uV.getThreadImgUrl());
                    this.dpx.setVisibility(0);
                    this.dpy.setSupportNoImage(true);
                    this.dpy.setScaleType(ImageView.ScaleType.MATRIX);
                    this.dpy.setOnDrawListener(this.mOnDrawListener);
                    this.dpy.startLoad(uV.getThreadImgUrl(), this.asK ? 13 : 14, false);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dpx.getLayoutParams();
                    layoutParams.width = l.ah(getContext()) - l.e(getContext(), d.e.ds68);
                    layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
                    this.dpx.setLayoutParams(layoutParams);
                } else {
                    this.dpx.setVisibility(8);
                }
                this.dpy.setOnClickListener(this.dpB);
                this.cyF.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            al.h(this.dpw, d.C0141d.cp_cont_f);
            al.h(this.dpz, d.C0141d.cp_cont_i);
        }
        super.d(tbPageContext, i);
    }

    public void fR(boolean z) {
        if (this.biz != null) {
            this.biz.setVisibility(z ? 0 : 8);
        }
    }
}
