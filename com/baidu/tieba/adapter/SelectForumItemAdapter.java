package com.baidu.tieba.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.t.j;
import d.b.j0.d;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    public d f14227a;

    /* renamed from: b  reason: collision with root package name */
    public int f14228b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f14229c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f14230d = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar = (j) view.getTag();
            if (jVar == null) {
                return;
            }
            if (!jVar.f52230f) {
                SelectForumItemAdapter.this.f14227a.b(jVar.f52231g);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, jVar.f52231g));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", jVar.f52225a).param("obj_source", SelectForumItemAdapter.this.f14228b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, jVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f14232a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14233b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f14234c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14235d;

        public b(SelectForumItemAdapter selectForumItemAdapter, View view) {
            super(view);
            this.f14232a = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.f14233b = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.f14234c = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.f14235d = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }

    public SelectForumItemAdapter(d dVar) {
        this.f14227a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        j jVar = (j) ListUtils.getItem(this.f14229c, i);
        if (jVar == null) {
            return;
        }
        bVar.f14232a.setPlaceHolder(1);
        bVar.f14232a.setShowOval(true);
        bVar.f14232a.setShowOuterBorder(true);
        bVar.f14232a.setShowInnerBorder(false);
        bVar.f14232a.setStrokeColorResId(R.color.CAM_X0401);
        bVar.f14232a.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        bVar.f14232a.W(jVar.f52226b, 10, false);
        bVar.f14233b.setText(jVar.f52227c);
        SkinManager.setViewTextColor(bVar.f14233b, R.color.CAM_X0105);
        if (jVar.f52228d <= 0) {
            bVar.f14234c.setVisibility(8);
        } else {
            bVar.f14234c.setVisibility(0);
            SkinManager.setImageResource(bVar.f14234c, BitmapHelper.getGradeResourceIdInEnterForum(jVar.f52228d));
        }
        bVar.f14235d.setVisibility(jVar.f52229e ? 0 : 8);
        SkinManager.setViewTextColor(bVar.f14235d, R.color.CAM_X0302);
        bVar.itemView.setTag(jVar);
        SkinManager.setBackgroundResource(bVar.itemView, R.drawable.forum_selected_view_bg);
        bVar.itemView.setOnClickListener(this.f14230d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_select_forum_layout, viewGroup, false));
    }

    public void g(List<j> list) {
        this.f14229c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f14229c);
    }

    public void h(int i) {
        this.f14228b = i;
    }
}
