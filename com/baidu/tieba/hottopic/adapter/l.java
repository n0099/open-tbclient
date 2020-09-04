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
/* loaded from: classes15.dex */
public class l extends BaseAdapter {
    private String eon;
    private RelateTopicForumActivity iXI;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener iXJ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (l.this.iXI != null && l.this.iXI.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) l.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new aq("c10371").dD("fid", String.valueOf(relateForumItemData.forumId)).ai("obj_type", com.baidu.tieba.hottopic.data.k.iZV).dD("topic_id", l.this.eon));
                }
                if (at.isForumName(relateForumItemData.forumName)) {
                    l.this.iXI.iYv.fR(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.iXI = relateTopicForumActivity;
    }

    public void b(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.eon = str;
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
            view = LayoutInflater.from(this.iXI.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.a.f fVar2 = new com.baidu.tieba.hottopic.a.f(view);
            view.setTag(fVar2);
            fVar2.jaY.setOnClickListener(this.iXJ);
            fVar = fVar2;
        } else {
            fVar = (com.baidu.tieba.hottopic.a.f) view.getTag();
        }
        fVar.jaY.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.aiD != skinType) {
                ap.setViewTextColor(fVar.jaU, R.color.cp_cont_b, 1);
                ap.setViewTextColor(fVar.izz, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.izA, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jaV, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jaW, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jaX, R.color.cp_cont_d, 1);
                ap.setBackgroundResource(fVar.gVd, R.color.cp_bg_line_c);
                ap.setBackgroundResource(fVar.jaY, R.drawable.btn_appdownload);
                ap.setBackgroundResource(view, R.drawable.list_item_selector);
                fVar.aiD = skinType;
            }
            fVar.jaU.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                fVar.jaT.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            fVar.izz.setText(at.numberUniformFormat(this.dataList.get(i).postNum));
            fVar.izA.setText(at.numberUniformFormat(this.dataList.get(i).followNum));
            fVar.jaX.setText(at.forceLToR(this.dataList.get(i).forumAbstract));
            d(fVar.jaY, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                cs(fVar.gVd);
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

    public void cs(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
