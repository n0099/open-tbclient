package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.v.b.d;
import d.b.i0.v.b.f;
/* loaded from: classes4.dex */
public class VotedAreaLayout extends CardBasicLayout {

    /* renamed from: h  reason: collision with root package name */
    public Context f15201h;
    public TextView i;

    public VotedAreaLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        this.i = (TextView) findViewById(R.id.vote_num);
    }

    public void b() {
        this.f15201h = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(R.drawable.bar_select_bg_voted_area_layout);
        setMinimumHeight(l.g(getContext(), R.dimen.tbds62));
        setMinimumWidth(l.g(getContext(), R.dimen.tbds172));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.voted_area_layout, (ViewGroup) this, true);
        a();
    }

    public void c(int i) {
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
        SkinManager.setBackgroundResource(this, R.drawable.bar_select_bg_voted_area_layout, i);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.f15194f != null && this.f15195g != null && this.f15193e >= 0) {
            TextView textView = this.i;
            textView.setText(StringHelper.numFormatOverWan(this.f15195g.m()) + "票");
            c(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        setVisibility(8);
    }

    public void setMyRecordData(d dVar) {
        if (dVar != null) {
            this.f15195g = dVar;
            TextView textView = this.i;
            textView.setText(StringHelper.numFormatOverWan(this.f15195g.m()) + "票");
        }
    }

    public VotedAreaLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
