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
import d.b.c.e.p.l;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes4.dex */
public class RelationBarView extends ForbidParentSwipeBackLinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f15849e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f15850f;

    /* renamed from: g  reason: collision with root package name */
    public RelationBarAdapter f15851g;

    public RelationBarView(Context context) {
        super(context);
        this.f15849e = 3;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_brand_relation_bar_layout, (ViewGroup) this, true);
        setOrientation(1);
        this.f15850f = (RecyclerView) findViewById(R.id.frs_brand_bar_list);
        RelationBarAdapter relationBarAdapter = new RelationBarAdapter(context);
        this.f15851g = relationBarAdapter;
        this.f15850f.setAdapter(relationBarAdapter);
        this.f15850f.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f15850f.setItemAnimator(new DefaultItemAnimator());
        int g2 = l.g(context, R.dimen.tbds44);
        this.f15850f.addItemDecoration(new RelationSpaceItemDecoration(g2, l.g(context, R.dimen.tbds26), g2));
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f15849e) {
            return;
        }
        this.f15849e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        this.f15851g.notifyDataSetChanged();
    }

    public void setData(List<OriForumInfo> list) {
        if (ListUtils.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f15851g.setData(list);
        this.f15851g.notifyDataSetChanged();
    }

    public RelationBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15849e = 3;
        a(context);
    }

    public RelationBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15849e = 3;
        a(context);
    }
}
