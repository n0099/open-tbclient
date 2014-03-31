package com.baidu.tbadk.editortool;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public final class k extends BaseAdapter {
    final /* synthetic */ EmotionTabContentView a;
    private final int b;
    private final int c;

    public k(EmotionTabContentView emotionTabContentView, int i, int i2) {
        this.a = emotionTabContentView;
        this.b = i;
        this.c = i2;
    }

    public final int a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        af afVar;
        af afVar2;
        int i2;
        af afVar3;
        aa aaVar;
        af afVar4;
        af afVar5;
        int i3;
        LayoutInflater layoutInflater;
        int i4;
        int i5;
        int i6;
        int i7 = this.c + i;
        if (view == null) {
            layoutInflater = this.a.s;
            LinearLayout linearLayout2 = (LinearLayout) layoutInflater.inflate(com.baidu.tbadk.k.emotion_tab_content_item, (ViewGroup) null);
            i4 = this.a.k;
            i5 = this.a.k;
            i6 = this.a.k;
            linearLayout2.setPadding(i4, i5, i6, 0);
            linearLayout = linearLayout2;
        } else {
            linearLayout = view;
        }
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        afVar = this.a.b;
        int j = measuredWidth / afVar.j();
        afVar2 = this.a.b;
        LinearLayout linearLayout3 = (LinearLayout) linearLayout;
        linearLayout3.setLayoutParams(new AbsListView.LayoutParams(j, measuredHeight / afVar2.k()));
        BDImageView bDImageView = (BDImageView) linearLayout3.findViewById(com.baidu.tbadk.j.emotion_tab_content_img);
        i2 = this.a.q;
        bDImageView.setBackgroundResource(i2 == 1 ? com.baidu.tbadk.i.btn_choose_face_selector_1 : com.baidu.tbadk.i.btn_choose_face_selector);
        bDImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        afVar3 = this.a.b;
        String a = afVar3.a(i7);
        bDImageView.setTag(a);
        aaVar = this.a.r;
        com.baidu.adp.widget.ImageView.b b = aaVar.b(a, false, new l(this));
        if (b != null) {
            b.a(bDImageView);
            bDImageView.setTag(null);
        }
        TextView textView = (TextView) linearLayout3.findViewById(com.baidu.tbadk.j.emotion_tab_content_tip);
        afVar4 = this.a.b;
        if (afVar4.c() == EmotionGroupType.BIG_EMOTION) {
            afVar5 = this.a.b;
            String a2 = afVar5.a(i7);
            if (!TextUtils.isEmpty(a2)) {
                i3 = this.a.q;
                int color = i3 == 1 ? this.a.getResources().getColor(com.baidu.tbadk.g.pb_emotion_content_1) : this.a.getResources().getColor(com.baidu.tbadk.g.pb_emotion_content);
                textView.setVisibility(0);
                textView.setTextColor(color);
                textView.setText(a2.substring(a2.lastIndexOf("_") + 1, a2.length() - 1));
            }
        } else {
            textView.setVisibility(8);
        }
        return linearLayout3;
    }
}
