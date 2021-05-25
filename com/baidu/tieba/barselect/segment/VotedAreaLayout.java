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
import d.a.c.e.p.l;
import d.a.n0.x.b.d;
import d.a.n0.x.b.f;
/* loaded from: classes4.dex */
public class VotedAreaLayout extends CardBasicLayout {

    /* renamed from: h  reason: collision with root package name */
    public Context f14187h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14188i;

    public VotedAreaLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f14188i = (TextView) findViewById(R.id.vote_num);
    }

    public void b() {
        this.f14187h = getContext();
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

    public void c(int i2) {
        SkinManager.setViewTextColor(this.f14188i, R.color.CAM_X0105, 1, i2);
        SkinManager.setBackgroundResource(this, R.drawable.bar_select_bg_voted_area_layout, i2);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        super.setData(i2, fVar);
        if (this.f14178f != null && this.f14179g != null && this.f14177e >= 0) {
            TextView textView = this.f14188i;
            textView.setText(StringHelper.numFormatOverWan(this.f14179g.m()) + "票");
            c(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        setVisibility(8);
    }

    public void setMyRecordData(d dVar) {
        if (dVar != null) {
            this.f14179g = dVar;
            TextView textView = this.f14188i;
            textView.setText(StringHelper.numFormatOverWan(this.f14179g.m()) + "票");
        }
    }

    public VotedAreaLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
