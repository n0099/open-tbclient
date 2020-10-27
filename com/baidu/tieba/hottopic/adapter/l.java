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
    private String eLl;
    private RelateTopicForumActivity jHM;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener jHN = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (l.this.jHM != null && l.this.jHM.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) l.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new aq("c10371").dR("fid", String.valueOf(relateForumItemData.forumId)).aj("obj_type", com.baidu.tieba.hottopic.data.k.jJY).dR("topic_id", l.this.eLl));
                }
                if (at.isForumName(relateForumItemData.forumName)) {
                    l.this.jHM.jrr.gp(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.jHM = relateTopicForumActivity;
    }

    public void c(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.eLl = str;
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
            view = LayoutInflater.from(this.jHM.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.a.f fVar2 = new com.baidu.tieba.hottopic.a.f(view);
            view.setTag(fVar2);
            fVar2.jLb.setOnClickListener(this.jHN);
            fVar = fVar2;
        } else {
            fVar = (com.baidu.tieba.hottopic.a.f) view.getTag();
        }
        fVar.jLb.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.ajq != skinType) {
                ap.setViewTextColor(fVar.jKX, R.color.cp_cont_b, 1);
                ap.setViewTextColor(fVar.jih, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jii, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jKY, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jKZ, R.color.cp_cont_c, 1);
                ap.setViewTextColor(fVar.jLa, R.color.cp_cont_d, 1);
                ap.setBackgroundResource(fVar.hzG, R.color.cp_bg_line_c);
                ap.setBackgroundResource(fVar.jLb, R.drawable.btn_appdownload);
                ap.setBackgroundResource(view, R.drawable.list_item_selector);
                fVar.ajq = skinType;
            }
            fVar.jKX.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                fVar.jKW.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            fVar.jih.setText(at.numberUniformFormat(this.dataList.get(i).postNum));
            fVar.jii.setText(at.numberUniformFormat(this.dataList.get(i).followNum));
            fVar.jLa.setText(at.forceLToR(this.dataList.get(i).forumAbstract));
            d(fVar.jLb, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                cJ(fVar.hzG);
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

    public void cJ(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
