package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
/* loaded from: classes4.dex */
public class FrsEmpertyItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f15920a;

    public FrsEmpertyItemViewHolder(View view) {
        super(view);
        this.f15920a = view;
    }

    public void b(int i) {
        if (i == 0) {
            return;
        }
        SkinManager.setBackgroundResource(this.f15920a, i);
    }

    public void c(int i) {
        if (i < 0) {
            this.f15920a.setMinimumHeight(0);
        } else {
            this.f15920a.setMinimumHeight(i);
        }
    }
}
