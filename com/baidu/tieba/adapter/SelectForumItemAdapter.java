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
import d.a.c.e.p.l;
import d.a.m0.t.j;
import d.a.n0.d;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    public d f13585a;

    /* renamed from: b  reason: collision with root package name */
    public int f13586b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f13587c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f13588d = new a();

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
            if (!jVar.f54467f) {
                SelectForumItemAdapter.this.f13585a.b(jVar.f54468g);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, jVar.f54468g));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", jVar.f54462a).param("obj_source", SelectForumItemAdapter.this.f13586b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, jVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f13590a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13591b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f13592c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13593d;

        public b(SelectForumItemAdapter selectForumItemAdapter, View view) {
            super(view);
            this.f13590a = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.f13591b = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.f13592c = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.f13593d = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }

    public SelectForumItemAdapter(d dVar) {
        this.f13585a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        j jVar = (j) ListUtils.getItem(this.f13587c, i2);
        if (jVar == null) {
            return;
        }
        bVar.f13590a.setPlaceHolder(1);
        bVar.f13590a.setShowOval(true);
        bVar.f13590a.setShowOuterBorder(true);
        bVar.f13590a.setShowInnerBorder(false);
        bVar.f13590a.setStrokeColorResId(R.color.CAM_X0401);
        bVar.f13590a.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        bVar.f13590a.U(jVar.f54463b, 10, false);
        bVar.f13591b.setText(jVar.f54464c);
        SkinManager.setViewTextColor(bVar.f13591b, R.color.CAM_X0105);
        if (jVar.f54465d <= 0) {
            bVar.f13592c.setVisibility(8);
        } else {
            bVar.f13592c.setVisibility(0);
            SkinManager.setImageResource(bVar.f13592c, BitmapHelper.getGradeResourceIdInEnterForum(jVar.f54465d));
        }
        bVar.f13593d.setVisibility(jVar.f54466e ? 0 : 8);
        SkinManager.setViewTextColor(bVar.f13593d, R.color.CAM_X0302);
        bVar.itemView.setTag(jVar);
        SkinManager.setBackgroundResource(bVar.itemView, R.drawable.forum_selected_view_bg);
        bVar.itemView.setOnClickListener(this.f13588d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_select_forum_layout, viewGroup, false));
    }

    public void g(List<j> list) {
        this.f13587c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f13587c);
    }

    public void h(int i2) {
        this.f13586b = i2;
    }
}
