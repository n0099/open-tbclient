package com.baidu.tieba.b;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
/* loaded from: classes22.dex */
public class b extends RecyclerView.Adapter<a> {
    private d gaS;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.b.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar = (j) view.getTag();
            if (jVar != null) {
                if (!jVar.fsU) {
                    b.this.gaS.Ff(jVar.fsV);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, jVar.fsV));
                    return;
                }
                TiebaStatic.log(new ar("c13995").dY("fid", jVar.forumId).al("obj_source", b.this.mType));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, jVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
            }
        }
    };
    private List<j> mDataList;
    private int mType;

    public b(d dVar) {
        this.gaS = dVar;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void bl(List<j> list) {
        this.mDataList = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_select_forum_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        j jVar = (j) y.getItem(this.mDataList, i);
        if (jVar != null) {
            aVar.gaU.setPlaceHolder(1);
            aVar.gaU.setShowOval(true);
            aVar.gaU.setShowOuterBorder(true);
            aVar.gaU.setShowInnerBorder(false);
            aVar.gaU.setStrokeColorResId(R.color.CAM_X0401);
            aVar.gaU.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            aVar.gaU.startLoad(jVar.bjs, 10, false);
            aVar.gaV.setText(jVar.forumName);
            ap.setViewTextColor(aVar.gaV, R.color.CAM_X0105);
            if (jVar.level <= 0) {
                aVar.gaW.setVisibility(8);
            } else {
                aVar.gaW.setVisibility(0);
                ap.setImageResource(aVar.gaW, BitmapHelper.getGradeResourceIdInEnterForum(jVar.level));
            }
            aVar.gaX.setVisibility(jVar.fsT ? 0 : 8);
            ap.setViewTextColor(aVar.gaX, R.color.CAM_X0302);
            aVar.itemView.setTag(jVar);
            ap.setBackgroundResource(aVar.itemView, R.drawable.forum_selected_view_bg);
            aVar.itemView.setOnClickListener(this.mClickListener);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a extends RecyclerView.ViewHolder {
        BarImageView gaU;
        TextView gaV;
        ImageView gaW;
        TextView gaX;

        public a(View view) {
            super(view);
            this.gaU = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.gaV = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.gaW = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.gaX = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }
}
