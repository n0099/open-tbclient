package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends BaseAdapter {
    final /* synthetic */ EmotionManageActivity a;

    private d(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(EmotionManageActivity emotionManageActivity, byte b) {
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
            view = View.inflate(this.a, R.layout.emotion_manage_list_item, null);
            g gVar = new g((byte) 0);
            gVar.a = (ImageView) view.findViewById(R.id.emotion_group_select);
            gVar.b = (ImageView) view.findViewById(R.id.emotion_group_photo);
            gVar.c = (TextView) view.findViewById(R.id.emotion_group_name);
            view.setTag(gVar);
        }
        g gVar2 = (g) view.getTag();
        list = this.a.a;
        Bitmap bitmap = ((e) list.get(i)).d;
        if (bitmap != null) {
            gVar2.b.setImageBitmap(bitmap);
        } else {
            bq.d(gVar2.b, (int) R.drawable.pic_image_h_not);
        }
        z = this.a.p;
        if (z) {
            list3 = this.a.a;
            if (((e) list3.get(i)).c) {
                bq.d(gVar2.a, (int) R.drawable.btn_expression_choose_s);
            } else {
                bq.d(gVar2.a, (int) R.drawable.btn_expression_choose_n);
            }
            gVar2.a.setVisibility(0);
        } else {
            gVar2.a.setVisibility(8);
        }
        TextView textView = gVar2.c;
        list2 = this.a.a;
        textView.setText(((e) list2.get(i)).b);
        this.a.getLayoutMode().a(view);
        return view;
    }
}
