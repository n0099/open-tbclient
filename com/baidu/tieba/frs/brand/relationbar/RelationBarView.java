package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.layout.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes4.dex */
public class RelationBarView extends ForbidParentSwipeBackLinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16043e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f16044f;

    /* renamed from: g  reason: collision with root package name */
    public RelationBarAdapter f16045g;

    public RelationBarView(Context context) {
        super(context);
        this.f16043e = 3;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_brand_relation_bar_layout, (ViewGroup) this, true);
        setOrientation(1);
        this.f16044f = (RecyclerView) findViewById(R.id.frs_brand_bar_list);
        RelationBarAdapter relationBarAdapter = new RelationBarAdapter(context);
        this.f16045g = relationBarAdapter;
        this.f16044f.setAdapter(relationBarAdapter);
        this.f16044f.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f16044f.setItemAnimator(new DefaultItemAnimator());
        int g2 = l.g(context, R.dimen.tbds44);
        this.f16044f.addItemDecoration(new RelationSpaceItemDecoration(g2, l.g(context, R.dimen.tbds26), g2));
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16043e) {
            return;
        }
        this.f16043e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        this.f16045g.notifyDataSetChanged();
    }

    public void setData(List<OriForumInfo> list) {
        if (ListUtils.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f16045g.setData(list);
        this.f16045g.notifyDataSetChanged();
    }

    public RelationBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16043e = 3;
        a(context);
    }

    public RelationBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16043e = 3;
        a(context);
    }
}
