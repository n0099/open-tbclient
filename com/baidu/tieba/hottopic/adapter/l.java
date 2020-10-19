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
/* loaded from: classes21.dex */
public class l extends BaseAdapter {
    private String eCP;
    private RelateTopicForumActivity jvn;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener jvo = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (l.this.jvn != null && l.this.jvn.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) l.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new aq("c10371").dK("fid", String.valueOf(relateForumItemData.forumId)).aj("obj_type", com.baidu.tieba.hottopic.data.k.jxz).dK("topic_id", l.this.eCP));
                }
                if (at.isForumName(relateForumItemData.forumName)) {
                    l.this.jvn.jeT.gk(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.jvn = relateTopicForumActivity;
    }

    public void b(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.eCP = str;
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
            view = LayoutInflater.from(this.jvn.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.a.f fVar2 = new com.baidu.tieba.hottopic.a.f(view);
            view.setTag(fVar2);
            fVar2.jyC.setOnClickListener(this.jvo);
            fVar = fVar2;
        } else {
            fVar = (com.baidu.tieba.hottopic.a.f) view.getTag();
        }
        fVar.jyC.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.ajp != skinType) {
                ap.setViewTextColor(fVar.jyy, R.color.cp_cont_b, 1);
                ap.setViewTextColor(fVar.iVK, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.iVL, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jyz, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jyA, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jyB, R.color.cp_cont_d, 1);
                ap.setBackgroundResource(fVar.hnL, R.color.cp_bg_line_c);
                ap.setBackgroundResource(fVar.jyC, R.drawable.btn_appdownload);
                ap.setBackgroundResource(view, R.drawable.list_item_selector);
                fVar.ajp = skinType;
            }
            fVar.jyy.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                fVar.jyx.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            fVar.iVK.setText(at.numberUniformFormat(this.dataList.get(i).postNum));
            fVar.iVL.setText(at.numberUniformFormat(this.dataList.get(i).followNum));
            fVar.jyB.setText(at.forceLToR(this.dataList.get(i).forumAbstract));
            d(fVar.jyC, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                cF(fVar.hnL);
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

    public void cF(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
