package com.baidu.tbadk.editortools.imagetool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.imgView.e;
/* loaded from: classes.dex */
public class c {
    @SuppressLint({"ResourceAsColor"})
    public static s j(Context context, int i) {
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        MultiImgToolView multiImgToolView = (MultiImgToolView) LayoutInflater.from(context).inflate(d.h.editor_tool_container_image, (ViewGroup) null);
        multiImgToolView.initView();
        if (multiImgToolView == null || multiImgToolView.getDragLayer() == null || multiImgToolView.getDragHorizonScrollView() == null || multiImgToolView.getMutiImageTips() == null) {
            return null;
        }
        multiImgToolView.setAsyncLocalImageLoader(bVar);
        com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(context);
        bVar2.a(multiImgToolView.getDragLayer());
        bVar2.a((e) multiImgToolView.getDragHorizonScrollView());
        bVar2.a((com.baidu.tieba.tbadkCore.imgView.d) multiImgToolView.getDragHorizonScrollView());
        if (i > 1) {
            multiImgToolView.getDragHorizonScrollView().setAddView(a(context, multiImgToolView));
        } else {
            multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
        }
        multiImgToolView.getDragHorizonScrollView().setOnSwapDataListener(multiImgToolView);
        multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        aj.c(multiImgToolView.getMutiImageTips(), d.C0096d.cp_cont_c, 1);
        return multiImgToolView;
    }

    private static View a(Context context, final s sVar) {
        ImageView imageView = new ImageView(context);
        aj.c(imageView, d.f.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setContentDescription(context.getString(d.j.add));
        int dip2px = l.dip2px(context, 3.0f);
        imageView.setPadding(dip2px, l.dip2px(context, 1.0f) + context.getResources().getDimensionPixelSize(d.e.ds30) + dip2px, context.getResources().getDimensionPixelSize(d.e.ds32) + dip2px, dip2px);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.imagetool.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this != null) {
                    s.this.b(new com.baidu.tbadk.editortools.a(14, -1, true));
                }
            }
        });
        return imageView;
    }
}
