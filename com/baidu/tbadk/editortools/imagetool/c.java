package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    public static y i(Context context, int i) {
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        MultiImgToolView multiImgToolView = (MultiImgToolView) LayoutInflater.from(context).inflate(r.j.editor_tool_container_image, (ViewGroup) null);
        multiImgToolView.initView();
        if (multiImgToolView == null || multiImgToolView.getDragLayer() == null || multiImgToolView.getDragHorizonScrollView() == null || multiImgToolView.getMutiImageTips() == null) {
            return null;
        }
        multiImgToolView.setAsyncLocalImageLoader(bVar);
        com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(context);
        bVar2.a(multiImgToolView.getDragLayer());
        bVar2.a((com.baidu.tieba.tbadkCore.imgView.g) multiImgToolView.getDragHorizonScrollView());
        bVar2.a((com.baidu.tieba.tbadkCore.imgView.f) multiImgToolView.getDragHorizonScrollView());
        if (i > 1) {
            multiImgToolView.getDragHorizonScrollView().setAddView(a(context, multiImgToolView));
        } else {
            multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
        }
        multiImgToolView.getDragHorizonScrollView().setOnSwapDataListener(multiImgToolView);
        multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        ap.c(multiImgToolView.getMutiImageTips(), r.e.cp_cont_c, 1);
        return multiImgToolView;
    }

    private static View a(Context context, y yVar) {
        ImageView imageView = new ImageView(context);
        ap.c(imageView, r.g.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setContentDescription(context.getString(r.l.add));
        int dip2px = k.dip2px(context, 3.0f);
        imageView.setPadding(dip2px, k.dip2px(context, 1.0f) + context.getResources().getDimensionPixelSize(r.f.ds30) + dip2px, context.getResources().getDimensionPixelSize(r.f.ds32) + dip2px, dip2px);
        imageView.setOnClickListener(new d(yVar));
        return imageView;
    }
}
