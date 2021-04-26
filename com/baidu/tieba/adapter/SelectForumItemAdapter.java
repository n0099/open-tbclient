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
import d.a.i0.t.j;
import d.a.j0.d;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    public d f14281a;

    /* renamed from: b  reason: collision with root package name */
    public int f14282b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f14283c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f14284d = new a();

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
            if (!jVar.f49898f) {
                SelectForumItemAdapter.this.f14281a.b(jVar.f49899g);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, jVar.f49899g));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", jVar.f49893a).param("obj_source", SelectForumItemAdapter.this.f14282b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, jVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f14286a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14287b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f14288c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14289d;

        public b(SelectForumItemAdapter selectForumItemAdapter, View view) {
            super(view);
            this.f14286a = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.f14287b = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.f14288c = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.f14289d = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }

    public SelectForumItemAdapter(d dVar) {
        this.f14281a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        j jVar = (j) ListUtils.getItem(this.f14283c, i2);
        if (jVar == null) {
            return;
        }
        bVar.f14286a.setPlaceHolder(1);
        bVar.f14286a.setShowOval(true);
        bVar.f14286a.setShowOuterBorder(true);
        bVar.f14286a.setShowInnerBorder(false);
        bVar.f14286a.setStrokeColorResId(R.color.CAM_X0401);
        bVar.f14286a.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        bVar.f14286a.V(jVar.f49894b, 10, false);
        bVar.f14287b.setText(jVar.f49895c);
        SkinManager.setViewTextColor(bVar.f14287b, R.color.CAM_X0105);
        if (jVar.f49896d <= 0) {
            bVar.f14288c.setVisibility(8);
        } else {
            bVar.f14288c.setVisibility(0);
            SkinManager.setImageResource(bVar.f14288c, BitmapHelper.getGradeResourceIdInEnterForum(jVar.f49896d));
        }
        bVar.f14289d.setVisibility(jVar.f49897e ? 0 : 8);
        SkinManager.setViewTextColor(bVar.f14289d, R.color.CAM_X0302);
        bVar.itemView.setTag(jVar);
        SkinManager.setBackgroundResource(bVar.itemView, R.drawable.forum_selected_view_bg);
        bVar.itemView.setOnClickListener(this.f14284d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_select_forum_layout, viewGroup, false));
    }

    public void g(List<j> list) {
        this.f14283c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f14283c);
    }

    public void h(int i2) {
        this.f14282b = i2;
    }
}
