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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<a> {
    private d gjK;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.adapter.SelectForumItemAdapter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar = (j) view.getTag();
            if (jVar != null) {
                if (!jVar.fBG) {
                    SelectForumItemAdapter.this.gjK.Et(jVar.fBH);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, jVar.fBH));
                    return;
                }
                TiebaStatic.log(new ar("c13995").dR("fid", jVar.forumId).aq("obj_source", SelectForumItemAdapter.this.mType));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, jVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
            }
        }
    };
    private List<j> mDataList;
    private int mType;

    public SelectForumItemAdapter(d dVar) {
        this.gjK = dVar;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void bn(List<j> list) {
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
        j jVar = (j) y.getItem(this.mDataList, i);
        if (jVar != null) {
            aVar.gjM.setPlaceHolder(1);
            aVar.gjM.setShowOval(true);
            aVar.gjM.setShowOuterBorder(true);
            aVar.gjM.setShowInnerBorder(false);
            aVar.gjM.setStrokeColorResId(R.color.CAM_X0401);
            aVar.gjM.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            aVar.gjM.startLoad(jVar.aWJ, 10, false);
            aVar.gjN.setText(jVar.forumName);
            ap.setViewTextColor(aVar.gjN, R.color.CAM_X0105);
            if (jVar.level <= 0) {
                aVar.gjO.setVisibility(8);
            } else {
                aVar.gjO.setVisibility(0);
                ap.setImageResource(aVar.gjO, BitmapHelper.getGradeResourceIdInEnterForum(jVar.level));
            }
            aVar.gjP.setVisibility(jVar.fBF ? 0 : 8);
            ap.setViewTextColor(aVar.gjP, R.color.CAM_X0302);
            aVar.itemView.setTag(jVar);
            ap.setBackgroundResource(aVar.itemView, R.drawable.forum_selected_view_bg);
            aVar.itemView.setOnClickListener(this.mClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        BarImageView gjM;
        TextView gjN;
        ImageView gjO;
        TextView gjP;

        public a(View view) {
            super(view);
            this.gjM = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.gjN = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.gjO = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.gjP = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }
}
