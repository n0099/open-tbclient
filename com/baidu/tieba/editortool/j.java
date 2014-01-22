package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    final /* synthetic */ EmotionTabContentView a;
    private int b;
    private int c;

    public j(EmotionTabContentView emotionTabContentView, Context context, int i, int i2) {
        this.a = emotionTabContentView;
        this.b = i;
        this.c = i2;
    }

    public int a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        WritableEmotionGroup writableEmotionGroup;
        WritableEmotionGroup writableEmotionGroup2;
        int i2;
        WritableEmotionGroup writableEmotionGroup3;
        com.baidu.tieba.util.i iVar;
        int i3;
        int i4;
        int i5;
        int i6;
        LinearLayout.LayoutParams layoutParams;
        int i7 = this.c + i;
        if (view == null) {
            LinearLayout linearLayout2 = new LinearLayout(this.a.getContext());
            i3 = this.a.k;
            i4 = this.a.k;
            i5 = this.a.k;
            i6 = this.a.k;
            linearLayout2.setPadding(i3, i4, i5, i6);
            BDImageView bDImageView = new BDImageView(this.a.getContext());
            bDImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            layoutParams = this.a.s;
            linearLayout2.addView(bDImageView, layoutParams);
            linearLayout = linearLayout2;
        } else {
            linearLayout = view;
        }
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        writableEmotionGroup = this.a.b;
        int j = measuredWidth / writableEmotionGroup.j();
        writableEmotionGroup2 = this.a.b;
        LinearLayout linearLayout3 = (LinearLayout) linearLayout;
        linearLayout3.setLayoutParams(new AbsListView.LayoutParams(j, measuredHeight / writableEmotionGroup2.k()));
        BDImageView bDImageView2 = (BDImageView) linearLayout3.getChildAt(0);
        i2 = this.a.q;
        bDImageView2.setBackgroundResource(i2 == 1 ? R.drawable.btn_choose_face_selector_1 : R.drawable.btn_choose_face_selector);
        bDImageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        writableEmotionGroup3 = this.a.b;
        String a = writableEmotionGroup3.a(i7);
        bDImageView2.setTag(a);
        iVar = this.a.r;
        com.baidu.adp.widget.ImageView.d a2 = iVar.a(a, false, (com.baidu.tbadk.imageManager.c) new k(this));
        if (a2 != null) {
            a2.a(bDImageView2);
            bDImageView2.setTag(null);
        }
        return linearLayout3;
    }
}
