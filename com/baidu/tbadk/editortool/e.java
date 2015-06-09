package com.baidu.tbadk.editortool;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    final /* synthetic */ EmotionTabContentView ajA;
    private final u ajB;

    public e(EmotionTabContentView emotionTabContentView, u uVar) {
        this.ajA = emotionTabContentView;
        this.ajB = uVar;
    }

    public int zq() {
        if (this.ajB == null) {
            return 0;
        }
        return this.ajB.zA();
    }

    public u zr() {
        return this.ajB;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ajB == null) {
            return 0;
        }
        return this.ajB.zz();
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
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int color;
        LinearLayout linearLayout = (LinearLayout) (view == null ? (LinearLayout) com.baidu.adp.lib.g.b.hr().inflate(TbadkCoreApplication.m411getInst().getContext(), com.baidu.tieba.r.emotion_tab_content_item, null) : view);
        if (this.ajB != null) {
            int zA = this.ajB.zA() + i;
            int measuredWidth = viewGroup.getMeasuredWidth();
            int measuredHeight = viewGroup.getMeasuredHeight();
            int zw = measuredWidth / this.ajB.zw();
            int row = measuredHeight / this.ajB.getRow();
            i2 = this.ajA.ajm;
            i3 = this.ajA.ajm;
            i4 = this.ajA.ajm;
            i5 = this.ajA.ajm;
            linearLayout.setPadding(i2 * 2, i3 * 2, i4 * 2, i5 * 2);
            linearLayout.setLayoutParams(new AbsListView.LayoutParams(zw, row));
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(com.baidu.tieba.q.emotion_tab_content_img);
            tbImageView.setAutoChangeStyle(false);
            int i8 = com.baidu.tieba.p.btn_choose_face_selector;
            i6 = this.ajA.ajy;
            ay.c(tbImageView, i8, i6);
            tbImageView.setPadding(0, 0, 0, 0);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            String dI = this.ajB.zu().dI(zA);
            tbImageView.setTag(dI);
            Object a = com.baidu.adp.lib.f.d.hl().a(dI, 20, new f(this), 0, 0, null, null, dI, false, null);
            com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
            if (aVar != null) {
                aVar.a(tbImageView);
                tbImageView.setTag(null);
            }
            TextView textView = (TextView) linearLayout.findViewById(com.baidu.tieba.q.emotion_tab_content_tip);
            if (this.ajB.zv() == EmotionGroupType.BIG_EMOTION) {
                String dI2 = this.ajB.zu().dI(zA);
                if (!TextUtils.isEmpty(dI2)) {
                    i7 = this.ajA.ajy;
                    if (i7 == 0) {
                        color = this.ajA.getContext().getResources().getColor(com.baidu.tieba.n.cp_cont_c);
                    } else {
                        color = ay.getColor(com.baidu.tieba.n.cp_cont_c);
                    }
                    textView.setVisibility(0);
                    textView.setTextColor(color);
                    textView.setText(dI2.substring(dI2.lastIndexOf("_") + 1, dI2.length() - 1));
                }
            } else {
                textView.setVisibility(8);
            }
        }
        return linearLayout;
    }
}
