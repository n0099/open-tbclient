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
public class u extends BaseAdapter {
    final /* synthetic */ EmotionManageActivity a;

    private u(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(EmotionManageActivity emotionManageActivity, u uVar) {
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
        x xVar = (x) view.getTag();
        list = this.a.a;
        Bitmap bitmap = ((v) list.get(i)).d;
        if (bitmap != null) {
            xVar.b.setImageBitmap(bitmap);
        } else {
            com.baidu.tbadk.core.util.bc.c(xVar.b, com.baidu.tieba.q.pic_image_h_not);
        }
        z = this.a.p;
        if (z) {
            list3 = this.a.b;
            list4 = this.a.a;
            if (list3.contains(((v) list4.get(i)).a)) {
                com.baidu.tbadk.core.util.bc.c(xVar.a, com.baidu.tieba.q.btn_expression_choose_s);
            } else {
                com.baidu.tbadk.core.util.bc.c(xVar.a, com.baidu.tieba.q.btn_expression_choose_n);
            }
            xVar.a.setVisibility(0);
            ImageView imageView = xVar.a;
            list5 = this.a.a;
            imageView.setTag(((v) list5.get(i)).a);
        } else {
            xVar.a.setVisibility(8);
        }
        TextView textView = xVar.c;
        list2 = this.a.a;
        textView.setText(((v) list2.get(i)).b);
        this.a.getLayoutMode().a(view);
        return view;
    }

    private View a() {
        View inflate = View.inflate(this.a, com.baidu.tieba.s.emotion_manage_list_item, null);
        x xVar = new x(null);
        xVar.a = (ImageView) inflate.findViewById(com.baidu.tieba.r.emotion_group_select);
        xVar.b = (ImageView) inflate.findViewById(com.baidu.tieba.r.emotion_group_photo);
        xVar.c = (TextView) inflate.findViewById(com.baidu.tieba.r.emotion_group_name);
        inflate.setTag(xVar);
        return inflate;
    }
}
