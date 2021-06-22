package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
/* loaded from: classes4.dex */
public class FrsEmpertyItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f15108a;

    public FrsEmpertyItemViewHolder(View view) {
        super(view);
        this.f15108a = view;
    }

    public void b(int i2) {
        if (i2 == 0) {
            return;
        }
        SkinManager.setBackgroundResource(this.f15108a, i2);
    }

    public void c(int i2) {
        if (i2 < 0) {
            this.f15108a.setMinimumHeight(0);
        } else {
            this.f15108a.setMinimumHeight(i2);
        }
    }
}
