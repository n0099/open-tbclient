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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    final /* synthetic */ EmotionTabContentView Yl;
    private final int Yn;
    private final int count;

    public j(EmotionTabContentView emotionTabContentView, Context context, int i, int i2) {
        this.Yl = emotionTabContentView;
        this.count = i;
        this.Yn = i2;
    }

    public int vo() {
        return this.Yn;
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
        ae aeVar;
        ae aeVar2;
        int i2;
        ae aeVar3;
        ae aeVar4;
        ae aeVar5;
        int i3;
        int color;
        int i4;
        int i5;
        int i6;
        int i7 = this.Yn + i;
        if (view == null) {
            LinearLayout linearLayout2 = (LinearLayout) com.baidu.adp.lib.g.b.ei().inflate(TbadkCoreApplication.m255getInst().getContext(), com.baidu.tieba.x.emotion_tab_content_item, null);
            i4 = this.Yl.Ye;
            i5 = this.Yl.Ye;
            i6 = this.Yl.Ye;
            linearLayout2.setPadding(i4, i5, i6, 0);
            linearLayout = linearLayout2;
        } else {
            linearLayout = view;
        }
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredHeight = viewGroup.getMeasuredHeight();
        aeVar = this.Yl.XW;
        int vL = measuredWidth / aeVar.vL();
        aeVar2 = this.Yl.XW;
        LinearLayout linearLayout3 = (LinearLayout) linearLayout;
        linearLayout3.setLayoutParams(new AbsListView.LayoutParams(vL, measuredHeight / aeVar2.vM()));
        TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(com.baidu.tieba.w.emotion_tab_content_img);
        tbImageView.setAutoChangeStyle(false);
        int i8 = com.baidu.tieba.v.btn_choose_face_selector;
        i2 = this.Yl.Yk;
        bc.c(tbImageView, i8, i2);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        aeVar3 = this.Yl.XW;
        String dl = aeVar3.dl(i7);
        tbImageView.setTag(dl);
        Object a = com.baidu.adp.lib.f.d.ec().a(dl, 20, new k(this), 0, 0, null, null, dl, false, null);
        com.baidu.adp.widget.a.a aVar = (a == null || !(a instanceof com.baidu.adp.widget.a.a)) ? null : (com.baidu.adp.widget.a.a) a;
        if (aVar != null) {
            aVar.a(tbImageView);
            tbImageView.setTag(null);
        }
        TextView textView = (TextView) linearLayout3.findViewById(com.baidu.tieba.w.emotion_tab_content_tip);
        aeVar4 = this.Yl.XW;
        if (aeVar4.vl() == EmotionGroupType.BIG_EMOTION) {
            aeVar5 = this.Yl.XW;
            String dl2 = aeVar5.dl(i7);
            if (!TextUtils.isEmpty(dl2)) {
                i3 = this.Yl.Yk;
                if (i3 == 0) {
                    color = this.Yl.getContext().getResources().getColor(com.baidu.tieba.t.pb_emotion_content);
                } else {
                    color = bc.getColor(com.baidu.tieba.t.pb_emotion_content);
                }
                textView.setVisibility(0);
                textView.setTextColor(color);
                textView.setText(dl2.substring(dl2.lastIndexOf("_") + 1, dl2.length() - 1));
            }
        } else {
            textView.setVisibility(8);
        }
        return linearLayout3;
    }
}
