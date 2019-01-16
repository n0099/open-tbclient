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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class f extends e {
    private TextView dVe;
    private View dVf;
    private TbImageView dVg;
    private TextView dVh;
    private ArrayList<String> dVi;
    private View.OnClickListener dVj;
    private long forumId;
    private TbImageView.b mOnDrawListener;
    private String taskId;

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dVi = new ArrayList<>();
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
                    com.baidu.adp.widget.ImageView.a iw = com.baidu.tbadk.imageManager.c.NM().iw(com.baidu.adp.lib.f.c.jA().k(tbImageView.getUrl(), f.this.aET ? 13 : 14));
                    if (iw != null) {
                        int width = iw.getWidth();
                        i = iw.getHeight();
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
        this.dVj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.H(f.this.dVi) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                        String str = (String) f.this.dVi.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = f.this.aET ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig createConfig = new ImageViewerConfig(f.this.mPageContext.getPageActivity()).createConfig(f.this.dVi, 0, "", "", "", f.this.aET, str, false, concurrentHashMap, false);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
                        createConfig.setIsShowHost(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
                        am amVar = new am("c13327");
                        amVar.i(ImageViewerConfig.FORUM_ID, f.this.forumId);
                        amVar.aB(VideoPlayActivityConfig.OBJ_ID, f.this.taskId);
                        TiebaStatic.log(amVar);
                        return;
                    }
                    l.showToast(f.this.mPageContext.getPageActivity(), e.j.plugin_image_viewer_install_error_tips);
                }
            }
        };
        View view = getView();
        if (view != null) {
            ((ViewStub) view.findViewById(e.g.viewstub_interview_live_info)).inflate();
            View findViewById = view.findViewById(e.g.text_interview_live);
            if (findViewById instanceof TextView) {
                this.dVe = (TextView) findViewById;
            }
            this.dVf = ((ViewStub) view.findViewById(e.g.viewstub_img_interview_live)).inflate();
            View findViewById2 = view.findViewById(e.g.img_interview_live);
            if (findViewById2 instanceof TbImageView) {
                this.dVg = (TbImageView) findViewById2;
                this.dVg.setPageId(bdUniqueId);
            }
            View findViewById3 = view.findViewById(e.g.interview_live_tip);
            if (findViewById3 instanceof TextView) {
                this.dVh = (TextView) findViewById3;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        if (bbVar != null && this.dVf != null && this.dVg != null && this.cYz != null) {
            if (bbVar.Ae() != null) {
                bbVar.Ae().clear();
            }
            bbVar.a((SparseArray<String>) null);
            ba zA = bbVar.zA();
            if (zA != null) {
                this.forumId = bbVar.getFid();
                this.taskId = zA.getTaskId();
                super.a(bbVar);
                if (com.baidu.tbadk.core.i.xR().xV() && zA != null && !StringUtils.isNull(zA.getThreadImgUrl())) {
                    this.dVi.clear();
                    this.dVi.add(zA.getThreadImgUrl());
                    this.dVf.setVisibility(0);
                    this.dVg.setSupportNoImage(true);
                    this.dVg.setScaleType(ImageView.ScaleType.MATRIX);
                    this.dVg.setOnDrawListener(this.mOnDrawListener);
                    this.dVg.startLoad(zA.getThreadImgUrl(), this.aET ? 13 : 14, false);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dVf.getLayoutParams();
                    layoutParams.width = l.aO(getContext()) - l.h(getContext(), e.C0210e.ds68);
                    layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
                    this.dVf.setLayoutParams(layoutParams);
                } else {
                    this.dVf.setVisibility(8);
                }
                this.dVg.setOnClickListener(this.dVj);
                this.cYz.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.e, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            al.h(this.dVe, e.d.cp_cont_f);
            al.h(this.dVh, e.d.cp_cont_i);
        }
        super.d(tbPageContext, i);
    }

    public void hi(boolean z) {
        if (this.bzG != null) {
            this.bzG.setVisibility(z ? 0 : 8);
        }
    }
}
