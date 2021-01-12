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
/* loaded from: classes7.dex */
public class j extends BaseAdapter {
    private String fci;
    private RelateTopicForumActivity kkG;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener kkH = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (j.this.kkG != null && j.this.kkG.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) j.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new aq("c10371").dW("fid", String.valueOf(relateForumItemData.forumId)).an("obj_type", com.baidu.tieba.hottopic.data.k.kmT).dW("topic_id", j.this.fci));
                }
                if (at.isForumName(relateForumItemData.forumName)) {
                    j.this.kkG.jUs.gq(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        this.kkG = relateTopicForumActivity;
    }

    public void c(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.fci = str;
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
            view = LayoutInflater.from(this.kkG.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            RelateTopicForumItemHolder relateTopicForumItemHolder2 = new RelateTopicForumItemHolder(view);
            view.setTag(relateTopicForumItemHolder2);
            relateTopicForumItemHolder2.knV.setOnClickListener(this.kkH);
            relateTopicForumItemHolder = relateTopicForumItemHolder2;
        } else {
            relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
        }
        relateTopicForumItemHolder.knV.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (relateTopicForumItemHolder.akf != skinType) {
                ao.setViewTextColor(relateTopicForumItemHolder.knS, R.color.CAM_X0105, 1);
                ao.setViewTextColor(relateTopicForumItemHolder.jKr, R.color.CAM_X0108, 1);
                ao.setViewTextColor(relateTopicForumItemHolder.jKs, R.color.CAM_X0108, 1);
                ao.setViewTextColor(relateTopicForumItemHolder.knT, R.color.CAM_X0108, 1);
                ao.setViewTextColor(relateTopicForumItemHolder.knU, R.color.CAM_X0108, 1);
                ao.setViewTextColor(relateTopicForumItemHolder.hie, R.color.CAM_X0109, 1);
                ao.setBackgroundResource(relateTopicForumItemHolder.hWH, R.color.CAM_X0204);
                ao.setBackgroundResource(relateTopicForumItemHolder.knV, R.drawable.btn_appdownload);
                ao.setBackgroundResource(view, R.drawable.list_item_selector);
                relateTopicForumItemHolder.akf = skinType;
            }
            relateTopicForumItemHolder.knS.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                relateTopicForumItemHolder.knR.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            relateTopicForumItemHolder.jKr.setText(at.numberUniformFormat(this.dataList.get(i).postNum));
            relateTopicForumItemHolder.jKs.setText(at.numberUniformFormat(this.dataList.get(i).followNum));
            relateTopicForumItemHolder.hie.setText(at.forceLToR(this.dataList.get(i).forumAbstract));
            d(relateTopicForumItemHolder.knV, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                dk(relateTopicForumItemHolder.hWH);
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
