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
    public int f15857e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f15858f;

    /* renamed from: g  reason: collision with root package name */
    public RelationBarAdapter f15859g;

    public RelationBarView(Context context) {
        super(context);
        this.f15857e = 3;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_brand_relation_bar_layout, (ViewGroup) this, true);
        setOrientation(1);
        this.f15858f = (RecyclerView) findViewById(R.id.frs_brand_bar_list);
        RelationBarAdapter relationBarAdapter = new RelationBarAdapter(context);
        this.f15859g = relationBarAdapter;
        this.f15858f.setAdapter(relationBarAdapter);
        this.f15858f.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f15858f.setItemAnimator(new DefaultItemAnimator());
        int g2 = l.g(context, R.dimen.tbds44);
        this.f15858f.addItemDecoration(new RelationSpaceItemDecoration(g2, l.g(context, R.dimen.tbds26), g2));
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f15857e) {
            return;
        }
        this.f15857e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        this.f15859g.notifyDataSetChanged();
    }

    public void setData(List<OriForumInfo> list) {
        if (ListUtils.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f15859g.setData(list);
        this.f15859g.notifyDataSetChanged();
    }

    public RelationBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15857e = 3;
        a(context);
    }

    public RelationBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15857e = 3;
        a(context);
    }
}
