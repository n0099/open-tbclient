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
import d.b.b.e.p.l;
import d.b.h0.t.i;
import d.b.i0.d;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    public d f14541a;

    /* renamed from: b  reason: collision with root package name */
    public int f14542b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f14543c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f14544d = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = (i) view.getTag();
            if (iVar == null) {
                return;
            }
            if (!iVar.f51476f) {
                SelectForumItemAdapter.this.f14541a.b(iVar.f51477g);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, iVar.f51477g));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", iVar.f51471a).param("obj_source", SelectForumItemAdapter.this.f14542b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, iVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f14546a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14547b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f14548c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14549d;

        public b(SelectForumItemAdapter selectForumItemAdapter, View view) {
            super(view);
            this.f14546a = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.f14547b = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.f14548c = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.f14549d = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }

    public SelectForumItemAdapter(d dVar) {
        this.f14541a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        i iVar = (i) ListUtils.getItem(this.f14543c, i);
        if (iVar == null) {
            return;
        }
        bVar.f14546a.setPlaceHolder(1);
        bVar.f14546a.setShowOval(true);
        bVar.f14546a.setShowOuterBorder(true);
        bVar.f14546a.setShowInnerBorder(false);
        bVar.f14546a.setStrokeColorResId(R.color.CAM_X0401);
        bVar.f14546a.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        bVar.f14546a.W(iVar.f51472b, 10, false);
        bVar.f14547b.setText(iVar.f51473c);
        SkinManager.setViewTextColor(bVar.f14547b, R.color.CAM_X0105);
        if (iVar.f51474d <= 0) {
            bVar.f14548c.setVisibility(8);
        } else {
            bVar.f14548c.setVisibility(0);
            SkinManager.setImageResource(bVar.f14548c, BitmapHelper.getGradeResourceIdInEnterForum(iVar.f51474d));
        }
        bVar.f14549d.setVisibility(iVar.f51475e ? 0 : 8);
        SkinManager.setViewTextColor(bVar.f14549d, R.color.CAM_X0302);
        bVar.itemView.setTag(iVar);
        SkinManager.setBackgroundResource(bVar.itemView, R.drawable.forum_selected_view_bg);
        bVar.itemView.setOnClickListener(this.f14544d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_select_forum_layout, viewGroup, false));
    }

    public void g(List<i> list) {
        this.f14543c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f14543c);
    }

    public void h(int i) {
        this.f14542b = i;
    }
}
