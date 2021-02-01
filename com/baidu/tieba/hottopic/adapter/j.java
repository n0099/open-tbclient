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
/* loaded from: classes8.dex */
public class j extends BaseAdapter {
    private String fey;
    private RelateTopicForumActivity ksN;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener ksO = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (j.this.ksN != null && j.this.ksN.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) j.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new ar("c10371").dR("fid", String.valueOf(relateForumItemData.forumId)).ap("obj_type", com.baidu.tieba.hottopic.data.k.kva).dR("topic_id", j.this.fey));
                }
                if (au.isForumName(relateForumItemData.forumName)) {
                    j.this.ksN.kbT.gw(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        this.ksN = relateTopicForumActivity;
    }

    public void setData(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.fey = str;
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
            view = LayoutInflater.from(this.ksN.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            RelateTopicForumItemHolder relateTopicForumItemHolder2 = new RelateTopicForumItemHolder(view);
            view.setTag(relateTopicForumItemHolder2);
            relateTopicForumItemHolder2.kwc.setOnClickListener(this.ksO);
            relateTopicForumItemHolder = relateTopicForumItemHolder2;
        } else {
            relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
        }
        relateTopicForumItemHolder.kwc.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (relateTopicForumItemHolder.ajU != skinType) {
                ap.setViewTextColor(relateTopicForumItemHolder.kvZ, R.color.CAM_X0105, 1);
                ap.setViewTextColor(relateTopicForumItemHolder.jRo, R.color.CAM_X0108, 1);
                ap.setViewTextColor(relateTopicForumItemHolder.jRp, R.color.CAM_X0108, 1);
                ap.setViewTextColor(relateTopicForumItemHolder.kwa, R.color.CAM_X0108, 1);
                ap.setViewTextColor(relateTopicForumItemHolder.kwb, R.color.CAM_X0108, 1);
                ap.setViewTextColor(relateTopicForumItemHolder.hmr, R.color.CAM_X0109, 1);
                ap.setBackgroundResource(relateTopicForumItemHolder.hhX, R.color.CAM_X0204);
                ap.setBackgroundResource(relateTopicForumItemHolder.kwc, R.drawable.btn_appdownload);
                ap.setBackgroundResource(view, R.drawable.list_item_selector);
                relateTopicForumItemHolder.ajU = skinType;
            }
            relateTopicForumItemHolder.kvZ.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                relateTopicForumItemHolder.kvY.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            relateTopicForumItemHolder.jRo.setText(au.numberUniformFormat(this.dataList.get(i).postNum));
            relateTopicForumItemHolder.jRp.setText(au.numberUniformFormat(this.dataList.get(i).followNum));
            relateTopicForumItemHolder.hmr.setText(au.forceLToR(this.dataList.get(i).forumAbstract));
            e(relateTopicForumItemHolder.kwc, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                di(relateTopicForumItemHolder.hhX);
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
