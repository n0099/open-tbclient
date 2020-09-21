package com.baidu.tieba.hottopic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class l extends BaseAdapter {
    private String eqD;
    private RelateTopicForumActivity jgo;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener jgp = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (l.this.jgo != null && l.this.jgo.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) l.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new aq("c10371").dF("fid", String.valueOf(relateForumItemData.forumId)).ai("obj_type", com.baidu.tieba.hottopic.data.k.jiB).dF("topic_id", l.this.eqD));
                }
                if (at.isForumName(relateForumItemData.forumName)) {
                    l.this.jgo.iPZ.gd(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.jgo = relateTopicForumActivity;
    }

    public void b(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.eqD = str;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dataList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dataList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.hottopic.a.f fVar;
        if (view == null) {
            view = LayoutInflater.from(this.jgo.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.a.f fVar2 = new com.baidu.tieba.hottopic.a.f(view);
            view.setTag(fVar2);
            fVar2.jjE.setOnClickListener(this.jgp);
            fVar = fVar2;
        } else {
            fVar = (com.baidu.tieba.hottopic.a.f) view.getTag();
        }
        fVar.jjE.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.aiX != skinType) {
                ap.setViewTextColor(fVar.jjA, R.color.cp_cont_b, 1);
                ap.setViewTextColor(fVar.iGU, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.iGV, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jjB, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jjC, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jjD, R.color.cp_cont_d, 1);
                ap.setBackgroundResource(fVar.gYK, R.color.cp_bg_line_c);
                ap.setBackgroundResource(fVar.jjE, R.drawable.btn_appdownload);
                ap.setBackgroundResource(view, R.drawable.list_item_selector);
                fVar.aiX = skinType;
            }
            fVar.jjA.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                fVar.jjz.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            fVar.iGU.setText(at.numberUniformFormat(this.dataList.get(i).postNum));
            fVar.iGV.setText(at.numberUniformFormat(this.dataList.get(i).followNum));
            fVar.jjD.setText(at.forceLToR(this.dataList.get(i).forumAbstract));
            d(fVar.jjE, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                cB(fVar.gYK);
            }
        }
        return view;
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            ap.setViewTextColor(textView, R.color.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        ap.setViewTextColor(textView, R.color.cp_cont_a, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        ap.setBackgroundResource(textView, R.drawable.btn_appdownload);
        textView.setEnabled(true);
    }

    public void cB(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
