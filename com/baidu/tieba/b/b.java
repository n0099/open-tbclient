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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.i;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes21.dex */
public class b extends RecyclerView.Adapter<a> {
    private d fsF;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.b.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = (i) view.getTag();
            if (iVar != null) {
                if (!iVar.eLN) {
                    b.this.fsF.Dy(iVar.eLO);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, iVar.eLO));
                    return;
                }
                TiebaStatic.log(new aq("c13995").dF("fid", iVar.forumId).ai("obj_source", b.this.mType));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, iVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
            }
        }
    };
    private List<i> mDataList;
    private int mType;

    public b(d dVar) {
        this.fsF = dVar;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void aO(List<i> list) {
        this.mDataList = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_select_forum_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        i iVar = (i) y.getItem(this.mDataList, i);
        if (iVar != null) {
            aVar.fsH.setPlaceHolder(2);
            aVar.fsH.setShowOval(true);
            aVar.fsH.setShowOuterBorder(true);
            aVar.fsH.setShowInnerBorder(false);
            aVar.fsH.setStrokeColorResId(R.color.cp_border_a);
            aVar.fsH.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            aVar.fsH.startLoad(iVar.baJ, 10, false);
            aVar.fsI.setText(iVar.forumName);
            ap.setViewTextColor(aVar.fsI, R.color.cp_cont_b);
            if (iVar.level <= 0) {
                aVar.fsJ.setVisibility(8);
            } else {
                aVar.fsJ.setVisibility(0);
                ap.setImageResource(aVar.fsJ, BitmapHelper.getGradeResourceIdInEnterForum(iVar.level));
            }
            aVar.fsK.setVisibility(iVar.eLM ? 0 : 8);
            ap.setViewTextColor(aVar.fsK, R.color.cp_link_tip_a);
            aVar.itemView.setTag(iVar);
            ap.setBackgroundResource(aVar.itemView, R.drawable.forum_selected_view_bg);
            aVar.itemView.setOnClickListener(this.mClickListener);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a extends RecyclerView.ViewHolder {
        BarImageView fsH;
        TextView fsI;
        ImageView fsJ;
        TextView fsK;

        public a(View view) {
            super(view);
            this.fsH = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.fsI = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.fsJ = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.fsK = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }
}
