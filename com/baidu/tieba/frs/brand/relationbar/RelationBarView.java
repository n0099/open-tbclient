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
    public int f15405e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f15406f;

    /* renamed from: g  reason: collision with root package name */
    public RelationBarAdapter f15407g;

    public RelationBarView(Context context) {
        super(context);
        this.f15405e = 3;
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_brand_relation_bar_layout, (ViewGroup) this, true);
        setOrientation(1);
        this.f15406f = (RecyclerView) findViewById(R.id.frs_brand_bar_list);
        RelationBarAdapter relationBarAdapter = new RelationBarAdapter(context);
        this.f15407g = relationBarAdapter;
        this.f15406f.setAdapter(relationBarAdapter);
        this.f15406f.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f15406f.setItemAnimator(new DefaultItemAnimator());
        int g2 = l.g(context, R.dimen.tbds44);
        this.f15406f.addItemDecoration(new RelationSpaceItemDecoration(g2, l.g(context, R.dimen.tbds26), g2));
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f15405e) {
            return;
        }
        this.f15405e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        this.f15407g.notifyDataSetChanged();
    }

    public void setData(List<OriForumInfo> list) {
        if (ListUtils.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f15407g.setData(list);
        this.f15407g.notifyDataSetChanged();
    }

    public RelationBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15405e = 3;
        a(context);
    }

    public RelationBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15405e = 3;
        a(context);
    }
}
