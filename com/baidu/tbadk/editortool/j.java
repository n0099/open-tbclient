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
    final /* synthetic */ EmotionTabContentView RE;
    private final int RG;
    private final int count;

    public j(EmotionTabContentView emotionTabContentView, Context context, int i, int i2) {
        this.RE = emotionTabContentView;
        this.count = i;
        this.RG = i2;
    }

    public int ru() {
        return this.RG;
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
        int i7 = this.RG + i;
        if (view == null) {
            LinearLayout linearLayout2 = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(TbadkApplication.m251getInst(), com.baidu.tieba.w.emotion_tab_content_item, null);
            i4 = this.RE.Rx;
            i5 = this.RE.Rx;
            i6 = this.RE.Rx;
            linearLayout2.setPadding(i4, i5, i6, 0);
            linearLayout = linearLayout2;
        } else {
            linearLayout = view;
        }
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        adVar = this.RE.Rp;
        int rQ = measuredWidth / adVar.rQ();
        adVar2 = this.RE.Rp;
        LinearLayout linearLayout3 = (LinearLayout) linearLayout;
        linearLayout3.setLayoutParams(new AbsListView.LayoutParams(rQ, measuredHeight / adVar2.rR()));
        TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(com.baidu.tieba.v.emotion_tab_content_img);
        tbImageView.setAutoChangeStyle(false);
        int i8 = com.baidu.tieba.u.btn_choose_face_selector;
        i2 = this.RE.RD;
        aw.c(tbImageView, i8, i2);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        adVar3 = this.RE.Rp;
        String cG = adVar3.cG(i7);
        tbImageView.setTag(cG);
        Object a = com.baidu.adp.lib.f.d.ef().a(cG, 20, new k(this), 0, 0, null, null, cG, false, null);
        com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
        if (aVar != null) {
            aVar.a(tbImageView);
            tbImageView.setTag(null);
        }
        TextView textView = (TextView) linearLayout3.findViewById(com.baidu.tieba.v.emotion_tab_content_tip);
        adVar4 = this.RE.Rp;
        if (adVar4.rr() == EmotionGroupType.BIG_EMOTION) {
            adVar5 = this.RE.Rp;
            String cG2 = adVar5.cG(i7);
            if (!TextUtils.isEmpty(cG2)) {
                i3 = this.RE.RD;
                if (i3 == 0) {
                    color = this.RE.getContext().getResources().getColor(com.baidu.tieba.s.pb_emotion_content);
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
