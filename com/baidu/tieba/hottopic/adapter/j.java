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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.holder.RelateTopicForumItemHolder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class j extends BaseAdapter {
    private String ffX;
    private RelateTopicForumActivity kvd;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener kve = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (j.this.kvd != null && j.this.kvd.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) j.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new ar("c10371").dR("fid", String.valueOf(relateForumItemData.forumId)).aq("obj_type", com.baidu.tieba.hottopic.data.k.kxq).dR("topic_id", j.this.ffX));
                }
                if (au.isForumName(relateForumItemData.forumName)) {
                    j.this.kvd.kej.gy(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        this.kvd = relateTopicForumActivity;
    }

    public void setData(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.ffX = str;
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
            view = LayoutInflater.from(this.kvd.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            RelateTopicForumItemHolder relateTopicForumItemHolder2 = new RelateTopicForumItemHolder(view);
            view.setTag(relateTopicForumItemHolder2);
            relateTopicForumItemHolder2.kys.setOnClickListener(this.kve);
            relateTopicForumItemHolder = relateTopicForumItemHolder2;
        } else {
            relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
        }
        relateTopicForumItemHolder.kys.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (relateTopicForumItemHolder.aln != skinType) {
                ap.setViewTextColor(relateTopicForumItemHolder.kyp, R.color.CAM_X0105, 1);
                ap.setViewTextColor(relateTopicForumItemHolder.jTl, R.color.CAM_X0108, 1);
                ap.setViewTextColor(relateTopicForumItemHolder.jTm, R.color.CAM_X0108, 1);
                ap.setViewTextColor(relateTopicForumItemHolder.kyq, R.color.CAM_X0108, 1);
                ap.setViewTextColor(relateTopicForumItemHolder.kyr, R.color.CAM_X0108, 1);
                ap.setViewTextColor(relateTopicForumItemHolder.hoo, R.color.CAM_X0109, 1);
                ap.setBackgroundResource(relateTopicForumItemHolder.hjV, R.color.CAM_X0204);
                ap.setBackgroundResource(relateTopicForumItemHolder.kys, R.drawable.btn_appdownload);
                ap.setBackgroundResource(view, R.drawable.list_item_selector);
                relateTopicForumItemHolder.aln = skinType;
            }
            relateTopicForumItemHolder.kyp.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                relateTopicForumItemHolder.kyo.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            relateTopicForumItemHolder.jTl.setText(au.numberUniformFormat(this.dataList.get(i).postNum));
            relateTopicForumItemHolder.jTm.setText(au.numberUniformFormat(this.dataList.get(i).followNum));
            relateTopicForumItemHolder.hoo.setText(au.forceLToR(this.dataList.get(i).forumAbstract));
            e(relateTopicForumItemHolder.kys, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                di(relateTopicForumItemHolder.hjV);
            }
        }
        return view;
    }

    private void e(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            ap.setViewTextColor(textView, R.color.CAM_X0109, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        ap.setViewTextColor(textView, R.color.CAM_X0101, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        ap.setBackgroundResource(textView, R.drawable.btn_appdownload);
        textView.setEnabled(true);
    }

    public void di(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
