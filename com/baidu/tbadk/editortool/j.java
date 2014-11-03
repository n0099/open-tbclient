package com.baidu.tbadk.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    final /* synthetic */ EmotionTabContentView RI;
    private final int RK;
    private final int count;

    public j(EmotionTabContentView emotionTabContentView, Context context, int i, int i2) {
        this.RI = emotionTabContentView;
        this.count = i;
        this.RK = i2;
    }

    public int rw() {
        return this.RK;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.count;
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
        ad adVar;
        ad adVar2;
        int i2;
        ad adVar3;
        ad adVar4;
        ad adVar5;
        int i3;
        int color;
        int i4;
        int i5;
        int i6;
        int i7 = this.RK + i;
        if (view == null) {
            LinearLayout linearLayout2 = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(TbadkApplication.m251getInst(), com.baidu.tieba.w.emotion_tab_content_item, null);
            i4 = this.RI.RB;
            i5 = this.RI.RB;
            i6 = this.RI.RB;
            linearLayout2.setPadding(i4, i5, i6, 0);
            linearLayout = linearLayout2;
        } else {
            linearLayout = view;
        }
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        adVar = this.RI.Rt;
        int rS = measuredWidth / adVar.rS();
        adVar2 = this.RI.Rt;
        LinearLayout linearLayout3 = (LinearLayout) linearLayout;
        linearLayout3.setLayoutParams(new AbsListView.LayoutParams(rS, measuredHeight / adVar2.rT()));
        TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(com.baidu.tieba.v.emotion_tab_content_img);
        tbImageView.setAutoChangeStyle(false);
        int i8 = com.baidu.tieba.u.btn_choose_face_selector;
        i2 = this.RI.RH;
        aw.c(tbImageView, i8, i2);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        adVar3 = this.RI.Rt;
        String cG = adVar3.cG(i7);
        tbImageView.setTag(cG);
        Object a = com.baidu.adp.lib.f.d.ef().a(cG, 20, new k(this), 0, 0, null, null, cG, false, null);
        com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
        if (aVar != null) {
            aVar.a(tbImageView);
            tbImageView.setTag(null);
        }
        TextView textView = (TextView) linearLayout3.findViewById(com.baidu.tieba.v.emotion_tab_content_tip);
        adVar4 = this.RI.Rt;
        if (adVar4.rt() == EmotionGroupType.BIG_EMOTION) {
            adVar5 = this.RI.Rt;
            String cG2 = adVar5.cG(i7);
            if (!TextUtils.isEmpty(cG2)) {
                i3 = this.RI.RH;
                if (i3 == 0) {
                    color = this.RI.getContext().getResources().getColor(com.baidu.tieba.s.pb_emotion_content);
                } else {
                    color = aw.getColor(com.baidu.tieba.s.pb_emotion_content);
                }
                textView.setVisibility(0);
                textView.setTextColor(color);
                textView.setText(cG2.substring(cG2.lastIndexOf("_") + 1, cG2.length() - 1));
            }
        } else {
            textView.setVisibility(8);
        }
        return linearLayout3;
    }
}
