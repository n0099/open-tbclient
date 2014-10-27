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
public class r extends BaseAdapter {
    final /* synthetic */ EmotionManageActivity asH;

    private r(EmotionManageActivity emotionManageActivity) {
        this.asH = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(EmotionManageActivity emotionManageActivity, r rVar) {
        this(emotionManageActivity);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.asH.asu;
        if (list != null) {
            list2 = this.asH.asu;
            return list2.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List list;
        List list2;
        List list3;
        list = this.asH.asu;
        if (list != null) {
            list2 = this.asH.asu;
            if (i <= list2.size()) {
                list3 = this.asH.asu;
                return list3.get(i);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        List list;
        List list2;
        list = this.asH.asu;
        if (list != null) {
            list2 = this.asH.asu;
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
            view = hA();
        }
        u uVar = (u) view.getTag();
        list = this.asH.asu;
        Bitmap bitmap = ((s) list.get(i)).asJ;
        if (bitmap != null) {
            uVar.asL.setImageBitmap(bitmap);
        } else {
            com.baidu.tbadk.core.util.aw.c(uVar.asL, by.pic_image_h_not);
        }
        z = this.asH.asG;
        if (z) {
            list3 = this.asH.asv;
            list4 = this.asH.asu;
            if (list3.contains(((s) list4.get(i)).id)) {
                com.baidu.tbadk.core.util.aw.c(uVar.asK, by.btn_expression_choose_s);
            } else {
                com.baidu.tbadk.core.util.aw.c(uVar.asK, by.btn_expression_choose_n);
            }
            uVar.asK.setVisibility(0);
            ImageView imageView = uVar.asK;
            list5 = this.asH.asu;
            imageView.setTag(((s) list5.get(i)).id);
        } else {
            uVar.asK.setVisibility(8);
        }
        TextView textView = uVar.UD;
        list2 = this.asH.asu;
        textView.setText(((s) list2.get(i)).name);
        this.asH.getLayoutMode().h(view);
        return view;
    }

    private View hA() {
        View inflate = View.inflate(this.asH, ca.emotion_manage_list_item, null);
        u uVar = new u(null);
        uVar.asK = (ImageView) inflate.findViewById(bz.emotion_group_select);
        uVar.asL = (ImageView) inflate.findViewById(bz.emotion_group_photo);
        uVar.UD = (TextView) inflate.findViewById(bz.emotion_group_name);
        inflate.setTag(uVar);
        return inflate;
    }
}
