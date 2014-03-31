package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends BaseAdapter {
    final /* synthetic */ EmotionManageActivity a;

    private r(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(EmotionManageActivity emotionManageActivity, byte b) {
        this(emotionManageActivity);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List list;
        List list2;
        list = this.a.a;
        if (list != null) {
            list2 = this.a.a;
            return list2.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List list;
        List list2;
        List list3;
        list = this.a.a;
        if (list != null) {
            list2 = this.a.a;
            if (i <= list2.size()) {
                list3 = this.a.a;
                return list3.get(i);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        List list;
        List list2;
        list = this.a.a;
        if (list != null) {
            list2 = this.a.a;
            if (i <= list2.size()) {
                return i;
            }
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        List list;
        boolean z;
        List list2;
        List list3;
        if (view == null) {
            view = View.inflate(this.a, com.baidu.tieba.a.i.emotion_manage_list_item, null);
            u uVar = new u((byte) 0);
            uVar.a = (ImageView) view.findViewById(com.baidu.tieba.a.h.emotion_group_select);
            uVar.b = (ImageView) view.findViewById(com.baidu.tieba.a.h.emotion_group_photo);
            uVar.c = (TextView) view.findViewById(com.baidu.tieba.a.h.emotion_group_name);
            view.setTag(uVar);
        }
        u uVar2 = (u) view.getTag();
        list = this.a.a;
        Bitmap bitmap = ((s) list.get(i)).d;
        if (bitmap != null) {
            uVar2.b.setImageBitmap(bitmap);
        } else {
            com.baidu.tbadk.core.util.ba.c(uVar2.b, com.baidu.tieba.a.g.pic_image_h_not);
        }
        z = this.a.p;
        if (z) {
            list3 = this.a.a;
            if (((s) list3.get(i)).c) {
                com.baidu.tbadk.core.util.ba.c(uVar2.a, com.baidu.tieba.a.g.btn_expression_choose_s);
            } else {
                com.baidu.tbadk.core.util.ba.c(uVar2.a, com.baidu.tieba.a.g.btn_expression_choose_n);
            }
            uVar2.a.setVisibility(0);
        } else {
            uVar2.a.setVisibility(8);
        }
        TextView textView = uVar2.c;
        list2 = this.a.a;
        textView.setText(((s) list2.get(i)).b);
        this.a.getLayoutMode().a(view);
        return view;
    }
}
