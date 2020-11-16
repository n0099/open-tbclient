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
import com.baidu.tbadk.data.i;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes21.dex */
public class b extends RecyclerView.Adapter<a> {
    private d fSI;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.b.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = (i) view.getTag();
            if (iVar != null) {
                if (!iVar.flr) {
                    b.this.fSI.Er(iVar.fls);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, iVar.fls));
                    return;
                }
                TiebaStatic.log(new ar("c13995").dR("fid", iVar.forumId).ak("obj_source", b.this.mType));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, iVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
            }
        }
    };
    private List<i> mDataList;
    private int mType;

    public b(d dVar) {
        this.fSI = dVar;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void bi(List<i> list) {
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
        i iVar = (i) y.getItem(this.mDataList, i);
        if (iVar != null) {
            aVar.fSK.setPlaceHolder(1);
            aVar.fSK.setShowOval(true);
            aVar.fSK.setShowOuterBorder(true);
            aVar.fSK.setShowInnerBorder(false);
            aVar.fSK.setStrokeColorResId(R.color.CAM_X0401);
            aVar.fSK.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            aVar.fSK.startLoad(iVar.bfc, 10, false);
            aVar.fSL.setText(iVar.forumName);
            ap.setViewTextColor(aVar.fSL, R.color.CAM_X0105);
            if (iVar.level <= 0) {
                aVar.fSM.setVisibility(8);
            } else {
                aVar.fSM.setVisibility(0);
                ap.setImageResource(aVar.fSM, BitmapHelper.getGradeResourceIdInEnterForum(iVar.level));
            }
            aVar.fSN.setVisibility(iVar.flq ? 0 : 8);
            ap.setViewTextColor(aVar.fSN, R.color.CAM_X0302);
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
        BarImageView fSK;
        TextView fSL;
        ImageView fSM;
        TextView fSN;

        public a(View view) {
            super(view);
            this.fSK = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.fSL = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.fSM = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.fSN = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }
}
