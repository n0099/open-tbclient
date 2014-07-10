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
public class t extends BaseAdapter {
    final /* synthetic */ EmotionManageActivity a;

    private t(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(EmotionManageActivity emotionManageActivity, t tVar) {
        this(emotionManageActivity);
    }

    @Override // android.widget.Adapter
    public int getCount() {
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
    public Object getItem(int i) {
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
    public long getItemId(int i) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        List list;
        boolean z;
        List list2;
        List list3;
        List list4;
        List list5;
        if (view == null) {
            view = a();
        }
        w wVar = (w) view.getTag();
        list = this.a.a;
        Bitmap bitmap = ((u) list.get(i)).d;
        if (bitmap != null) {
            wVar.b.setImageBitmap(bitmap);
        } else {
            com.baidu.tbadk.core.util.bk.c(wVar.b, com.baidu.tieba.u.pic_image_h_not);
        }
        z = this.a.p;
        if (z) {
            list3 = this.a.b;
            list4 = this.a.a;
            if (list3.contains(((u) list4.get(i)).a)) {
                com.baidu.tbadk.core.util.bk.c(wVar.a, com.baidu.tieba.u.btn_expression_choose_s);
            } else {
                com.baidu.tbadk.core.util.bk.c(wVar.a, com.baidu.tieba.u.btn_expression_choose_n);
            }
            wVar.a.setVisibility(0);
            ImageView imageView = wVar.a;
            list5 = this.a.a;
            imageView.setTag(((u) list5.get(i)).a);
        } else {
            wVar.a.setVisibility(8);
        }
        TextView textView = wVar.c;
        list2 = this.a.a;
        textView.setText(((u) list2.get(i)).b);
        this.a.getLayoutMode().a(view);
        return view;
    }

    private View a() {
        View inflate = View.inflate(this.a, com.baidu.tieba.w.emotion_manage_list_item, null);
        w wVar = new w(null);
        wVar.a = (ImageView) inflate.findViewById(com.baidu.tieba.v.emotion_group_select);
        wVar.b = (ImageView) inflate.findViewById(com.baidu.tieba.v.emotion_group_photo);
        wVar.c = (TextView) inflate.findViewById(com.baidu.tieba.v.emotion_group_name);
        inflate.setTag(wVar);
        return inflate;
    }
}
