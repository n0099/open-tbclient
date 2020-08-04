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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class l extends BaseAdapter {
    private String eeI;
    private RelateTopicForumActivity iIE;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener iIF = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (l.this.iIE != null && l.this.iIE.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) l.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new ap("c10371").dn("fid", String.valueOf(relateForumItemData.forumId)).ah("obj_type", com.baidu.tieba.hottopic.data.k.iKR).dn("topic_id", l.this.eeI));
                }
                if (as.isForumName(relateForumItemData.forumName)) {
                    l.this.iIE.iJr.fz(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.iIE = relateTopicForumActivity;
    }

    public void b(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.eeI = str;
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
            view = LayoutInflater.from(this.iIE.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.a.f fVar2 = new com.baidu.tieba.hottopic.a.f(view);
            view.setTag(fVar2);
            fVar2.iLU.setOnClickListener(this.iIF);
            fVar = fVar2;
        } else {
            fVar = (com.baidu.tieba.hottopic.a.f) view.getTag();
        }
        fVar.iLU.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.aho != skinType) {
                ao.setViewTextColor(fVar.iLQ, R.color.cp_cont_b, 1);
                ao.setViewTextColor(fVar.ilq, R.color.cp_cont_c, 1);
                ao.setViewTextColor(fVar.ilr, R.color.cp_cont_c, 1);
                ao.setViewTextColor(fVar.iLR, R.color.cp_cont_c, 1);
                ao.setViewTextColor(fVar.iLS, R.color.cp_cont_c, 1);
                ao.setViewTextColor(fVar.iLT, R.color.cp_cont_d, 1);
                ao.setBackgroundResource(fVar.gIw, R.color.cp_bg_line_c);
                ao.setBackgroundResource(fVar.iLU, R.drawable.btn_appdownload);
                ao.setBackgroundResource(view, R.drawable.list_item_selector);
                fVar.aho = skinType;
            }
            fVar.iLQ.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                fVar.iLP.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            fVar.ilq.setText(as.numberUniformFormat(this.dataList.get(i).postNum));
            fVar.ilr.setText(as.numberUniformFormat(this.dataList.get(i).followNum));
            fVar.iLT.setText(as.forceLToR(this.dataList.get(i).forumAbstract));
            d(fVar.iLU, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                cp(fVar.gIw);
            }
        }
        return view;
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            ao.setViewTextColor(textView, R.color.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        ao.setViewTextColor(textView, R.color.cp_cont_a, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        ao.setBackgroundResource(textView, R.drawable.btn_appdownload);
        textView.setEnabled(true);
    }

    public void cp(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
