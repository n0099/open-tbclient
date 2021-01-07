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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<a> {
    private d gkl;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.adapter.SelectForumItemAdapter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar = (j) view.getTag();
            if (jVar != null) {
                if (!jVar.fCz) {
                    SelectForumItemAdapter.this.gkl.Fc(jVar.fCA);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, jVar.fCA));
                    return;
                }
                TiebaStatic.log(new aq("c13995").dX("fid", jVar.forumId).an("obj_source", SelectForumItemAdapter.this.mType));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, jVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
            }
        }
    };
    private List<j> mDataList;
    private int mType;

    public SelectForumItemAdapter(d dVar) {
        this.gkl = dVar;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void bs(List<j> list) {
        this.mDataList = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: s */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_select_forum_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        j jVar = (j) x.getItem(this.mDataList, i);
        if (jVar != null) {
            aVar.gkn.setPlaceHolder(1);
            aVar.gkn.setShowOval(true);
            aVar.gkn.setShowOuterBorder(true);
            aVar.gkn.setShowInnerBorder(false);
            aVar.gkn.setStrokeColorResId(R.color.CAM_X0401);
            aVar.gkn.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            aVar.gkn.startLoad(jVar.aWS, 10, false);
            aVar.gko.setText(jVar.forumName);
            ao.setViewTextColor(aVar.gko, R.color.CAM_X0105);
            if (jVar.level <= 0) {
                aVar.gkp.setVisibility(8);
            } else {
                aVar.gkp.setVisibility(0);
                ao.setImageResource(aVar.gkp, BitmapHelper.getGradeResourceIdInEnterForum(jVar.level));
            }
            aVar.gkq.setVisibility(jVar.fCy ? 0 : 8);
            ao.setViewTextColor(aVar.gkq, R.color.CAM_X0302);
            aVar.itemView.setTag(jVar);
            ao.setBackgroundResource(aVar.itemView, R.drawable.forum_selected_view_bg);
            aVar.itemView.setOnClickListener(this.mClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return x.getCount(this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        BarImageView gkn;
        TextView gko;
        ImageView gkp;
        TextView gkq;

        public a(View view) {
            super(view);
            this.gkn = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.gko = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.gkp = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.gkq = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }
}
