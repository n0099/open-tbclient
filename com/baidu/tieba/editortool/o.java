package com.baidu.tieba.editortool;

import android.content.Context;
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
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    final /* synthetic */ EmotionTabContentView a;
    private int b;
    private int c;

    public o(EmotionTabContentView emotionTabContentView, Context context, int i, int i2) {
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
        WritableEmotionGroup writableEmotionGroup4;
        WritableEmotionGroup writableEmotionGroup5;
        int i3;
        LayoutInflater layoutInflater;
        int i4;
        int i5;
        int i6;
        int i7 = this.c + i;
        if (view == null) {
            layoutInflater = this.a.t;
            LinearLayout linearLayout2 = (LinearLayout) layoutInflater.inflate(R.layout.emotion_tab_content_item, (ViewGroup) null);
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
        writableEmotionGroup = this.a.b;
        int j = measuredWidth / writableEmotionGroup.j();
        writableEmotionGroup2 = this.a.b;
        LinearLayout linearLayout3 = (LinearLayout) linearLayout;
        linearLayout3.setLayoutParams(new AbsListView.LayoutParams(j, measuredHeight / writableEmotionGroup2.k()));
        BDImageView bDImageView = (BDImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
        i2 = this.a.q;
        bDImageView.setBackgroundResource(i2 == 1 ? R.drawable.btn_choose_face_selector_1 : R.drawable.btn_choose_face_selector);
        bDImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        writableEmotionGroup3 = this.a.b;
        String a = writableEmotionGroup3.a(i7);
        bDImageView.setTag(a);
        iVar = this.a.r;
        com.baidu.adp.widget.ImageView.b a2 = iVar.a(a, false, (com.baidu.tbadk.imageManager.d) new p(this));
        if (a2 != null) {
            a2.a(bDImageView);
            bDImageView.setTag(null);
        }
        TextView textView = (TextView) linearLayout3.findViewById(R.id.emotion_tab_content_tip);
        writableEmotionGroup4 = this.a.b;
        if (writableEmotionGroup4.c() == WritableEmotionGroup.EmotionGroupType.BIG_EMOTION) {
            writableEmotionGroup5 = this.a.b;
            String a3 = writableEmotionGroup5.a(i7);
            if (!TextUtils.isEmpty(a3)) {
                i3 = this.a.q;
                int color = i3 == 1 ? this.a.getResources().getColor(R.color.pb_listitem_content_1) : this.a.getResources().getColor(R.color.pb_listitem_content);
                textView.setVisibility(0);
                textView.setTextColor(color);
                textView.setText(a3.substring(a3.lastIndexOf("_") + 1, a3.length() - 1));
            }
        } else {
            textView.setVisibility(8);
        }
        return linearLayout3;
    }
}
