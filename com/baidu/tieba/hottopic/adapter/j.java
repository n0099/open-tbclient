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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.holder.RelateTopicForumItemHolder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class j extends BaseAdapter {
    private String fgR;
    private RelateTopicForumActivity kpl;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener kpm = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (j.this.kpl != null && j.this.kpl.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) j.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new aq("c10371").dX("fid", String.valueOf(relateForumItemData.forumId)).an("obj_type", com.baidu.tieba.hottopic.data.k.kry).dX("topic_id", j.this.fgR));
                }
                if (at.isForumName(relateForumItemData.forumName)) {
                    j.this.kpl.jYX.gr(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        this.kpl = relateTopicForumActivity;
    }

    public void c(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.fgR = str;
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
        RelateTopicForumItemHolder relateTopicForumItemHolder;
        if (view == null) {
            view = LayoutInflater.from(this.kpl.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            RelateTopicForumItemHolder relateTopicForumItemHolder2 = new RelateTopicForumItemHolder(view);
            view.setTag(relateTopicForumItemHolder2);
            relateTopicForumItemHolder2.ksA.setOnClickListener(this.kpm);
            relateTopicForumItemHolder = relateTopicForumItemHolder2;
        } else {
            relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
        }
        relateTopicForumItemHolder.ksA.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (relateTopicForumItemHolder.akW != skinType) {
                ao.setViewTextColor(relateTopicForumItemHolder.ksx, R.color.CAM_X0105, 1);
                ao.setViewTextColor(relateTopicForumItemHolder.jOX, R.color.CAM_X0108, 1);
                ao.setViewTextColor(relateTopicForumItemHolder.jOY, R.color.CAM_X0108, 1);
                ao.setViewTextColor(relateTopicForumItemHolder.ksy, R.color.CAM_X0108, 1);
                ao.setViewTextColor(relateTopicForumItemHolder.ksz, R.color.CAM_X0108, 1);
                ao.setViewTextColor(relateTopicForumItemHolder.hmK, R.color.CAM_X0109, 1);
                ao.setBackgroundResource(relateTopicForumItemHolder.ibo, R.color.CAM_X0204);
                ao.setBackgroundResource(relateTopicForumItemHolder.ksA, R.drawable.btn_appdownload);
                ao.setBackgroundResource(view, R.drawable.list_item_selector);
                relateTopicForumItemHolder.akW = skinType;
            }
            relateTopicForumItemHolder.ksx.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                relateTopicForumItemHolder.ksw.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            relateTopicForumItemHolder.jOX.setText(at.numberUniformFormat(this.dataList.get(i).postNum));
            relateTopicForumItemHolder.jOY.setText(at.numberUniformFormat(this.dataList.get(i).followNum));
            relateTopicForumItemHolder.hmK.setText(at.forceLToR(this.dataList.get(i).forumAbstract));
            d(relateTopicForumItemHolder.ksA, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                dk(relateTopicForumItemHolder.ibo);
            }
        }
        return view;
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            ao.setViewTextColor(textView, R.color.CAM_X0109, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        ao.setViewTextColor(textView, R.color.CAM_X0101, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        ao.setBackgroundResource(textView, R.drawable.btn_appdownload);
        textView.setEnabled(true);
    }

    public void dk(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
