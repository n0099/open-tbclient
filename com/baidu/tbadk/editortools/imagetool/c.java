package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c {
    public static w h(Context context, int i) {
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        MultiImgToolView multiImgToolView = (MultiImgToolView) LayoutInflater.from(context).inflate(i.g.editor_tool_container_image, (ViewGroup) null);
        multiImgToolView.initView();
        if (multiImgToolView == null || multiImgToolView.getDragLayer() == null || multiImgToolView.getDragHorizonScrollView() == null || multiImgToolView.getMutiImageTips() == null) {
            return null;
        }
        multiImgToolView.setAsyncLocalImageLoader(bVar);
        com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(context);
        aVar.a(multiImgToolView.getDragLayer());
        aVar.a((com.baidu.tieba.tbadkCore.imgView.f) multiImgToolView.getDragHorizonScrollView());
        aVar.a((com.baidu.tieba.tbadkCore.imgView.e) multiImgToolView.getDragHorizonScrollView());
        if (i > 1) {
            multiImgToolView.getDragHorizonScrollView().setAddView(a(context, multiImgToolView));
        } else {
            multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
        }
        multiImgToolView.getDragHorizonScrollView().setOnSwapDataListener(multiImgToolView);
        multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        al.b(multiImgToolView.getMutiImageTips(), i.c.cp_cont_c, 1);
        return multiImgToolView;
    }

    private static View a(Context context, w wVar) {
        ImageView imageView = new ImageView(context);
        al.c(imageView, i.e.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        int dip2px = k.dip2px(context, 3.0f);
        imageView.setPadding(dip2px, k.dip2px(context, 1.0f) + context.getResources().getDimensionPixelSize(i.d.default_gap_20) + dip2px, context.getResources().getDimensionPixelSize(i.d.default_gap_24) + dip2px, dip2px);
        imageView.setOnClickListener(new d(wVar));
        return imageView;
    }
}
