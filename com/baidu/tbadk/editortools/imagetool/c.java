package com.baidu.tbadk.editortools.imagetool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class c {
    @SuppressLint({"ResourceAsColor"})
    public static l m(Context context, int i) {
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        MultiImgToolView multiImgToolView = (MultiImgToolView) LayoutInflater.from(context).inflate(e.h.editor_tool_container_image, (ViewGroup) null);
        multiImgToolView.initView();
        if (multiImgToolView == null || multiImgToolView.getDragLayer() == null || multiImgToolView.getDragHorizonScrollView() == null || multiImgToolView.getMutiImageTips() == null) {
            return null;
        }
        multiImgToolView.setAsyncLocalImageLoader(bVar);
        com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(context);
        aVar.a(multiImgToolView.getDragLayer());
        aVar.a((com.baidu.tieba.tbadkCore.imgView.d) multiImgToolView.getDragHorizonScrollView());
        aVar.a((com.baidu.tieba.tbadkCore.imgView.c) multiImgToolView.getDragHorizonScrollView());
        if (i > 1) {
            multiImgToolView.getDragHorizonScrollView().setAddView(a(context, multiImgToolView));
        } else {
            multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
        }
        multiImgToolView.getDragHorizonScrollView().setOnSwapDataListener(multiImgToolView);
        multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        al.c(multiImgToolView.getMutiImageTips(), e.d.cp_cont_c, 1);
        return multiImgToolView;
    }

    private static View a(Context context, final l lVar) {
        ImageView imageView = new ImageView(context);
        al.c(imageView, e.f.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setContentDescription(context.getString(e.j.add));
        int dip2px = com.baidu.adp.lib.util.l.dip2px(context, 3.0f);
        imageView.setPadding(dip2px, com.baidu.adp.lib.util.l.dip2px(context, 1.0f) + context.getResources().getDimensionPixelSize(e.C0200e.ds30) + dip2px, context.getResources().getDimensionPixelSize(e.C0200e.ds32) + dip2px, dip2px);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this != null) {
                    l.this.b(new com.baidu.tbadk.editortools.a(14, -1, true));
                }
            }
        });
        return imageView;
    }
}
