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
    final /* synthetic */ EmotionManageActivity asQ;

    private r(EmotionManageActivity emotionManageActivity) {
        this.asQ = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(EmotionManageActivity emotionManageActivity, r rVar) {
        this(emotionManageActivity);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List list;
        List list2;
        list = this.asQ.asD;
        if (list != null) {
            list2 = this.asQ.asD;
            return list2.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List list;
        List list2;
        List list3;
        list = this.asQ.asD;
        if (list != null) {
            list2 = this.asQ.asD;
            if (i <= list2.size()) {
                list3 = this.asQ.asD;
                return list3.get(i);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        List list;
        List list2;
        list = this.asQ.asD;
        if (list != null) {
            list2 = this.asQ.asD;
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
        list = this.asQ.asD;
        Bitmap bitmap = ((s) list.get(i)).asS;
        if (bitmap != null) {
            uVar.asU.setImageBitmap(bitmap);
        } else {
            com.baidu.tbadk.core.util.aw.c(uVar.asU, by.pic_image_h_not);
        }
        z = this.asQ.asP;
        if (z) {
            list3 = this.asQ.asE;
            list4 = this.asQ.asD;
            if (list3.contains(((s) list4.get(i)).id)) {
                com.baidu.tbadk.core.util.aw.c(uVar.asT, by.btn_expression_choose_s);
            } else {
                com.baidu.tbadk.core.util.aw.c(uVar.asT, by.btn_expression_choose_n);
            }
            uVar.asT.setVisibility(0);
            ImageView imageView = uVar.asT;
            list5 = this.asQ.asD;
            imageView.setTag(((s) list5.get(i)).id);
        } else {
            uVar.asT.setVisibility(8);
        }
        TextView textView = uVar.UH;
        list2 = this.asQ.asD;
        textView.setText(((s) list2.get(i)).name);
        this.asQ.getLayoutMode().h(view);
        return view;
    }

    private View hA() {
        View inflate = View.inflate(this.asQ, ca.emotion_manage_list_item, null);
        u uVar = new u(null);
        uVar.asT = (ImageView) inflate.findViewById(bz.emotion_group_select);
        uVar.asU = (ImageView) inflate.findViewById(bz.emotion_group_photo);
        uVar.UH = (TextView) inflate.findViewById(bz.emotion_group_name);
        inflate.setTag(uVar);
        return inflate;
    }
}
