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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class l extends BaseAdapter {
    private String eXq;
    private RelateTopicForumActivity kbZ;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener kca = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (l.this.kbZ != null && l.this.kbZ.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) l.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new ar("c10371").dY("fid", String.valueOf(relateForumItemData.forumId)).al("obj_type", com.baidu.tieba.hottopic.data.k.kel).dY("topic_id", l.this.eXq));
                }
                if (au.isForumName(relateForumItemData.forumName)) {
                    l.this.kbZ.jLJ.gu(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.kbZ = relateTopicForumActivity;
    }

    public void c(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.eXq = str;
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
            view = LayoutInflater.from(this.kbZ.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.a.f fVar2 = new com.baidu.tieba.hottopic.a.f(view);
            view.setTag(fVar2);
            fVar2.kfo.setOnClickListener(this.kca);
            fVar = fVar2;
        } else {
            fVar = (com.baidu.tieba.hottopic.a.f) view.getTag();
        }
        fVar.kfo.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.aku != skinType) {
                ap.setViewTextColor(fVar.kfl, R.color.CAM_X0105, 1);
                ap.setViewTextColor(fVar.jCv, R.color.CAM_X0108, 1);
                ap.setViewTextColor(fVar.jCw, R.color.CAM_X0108, 1);
                ap.setViewTextColor(fVar.kfm, R.color.CAM_X0108, 1);
                ap.setViewTextColor(fVar.kfn, R.color.CAM_X0108, 1);
                ap.setViewTextColor(fVar.haY, R.color.CAM_X0109, 1);
                ap.setBackgroundResource(fVar.hOT, R.color.CAM_X0204);
                ap.setBackgroundResource(fVar.kfo, R.drawable.btn_appdownload);
                ap.setBackgroundResource(view, R.drawable.list_item_selector);
                fVar.aku = skinType;
            }
            fVar.kfl.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                fVar.kfk.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            fVar.jCv.setText(au.numberUniformFormat(this.dataList.get(i).postNum));
            fVar.jCw.setText(au.numberUniformFormat(this.dataList.get(i).followNum));
            fVar.haY.setText(au.forceLToR(this.dataList.get(i).forumAbstract));
            d(fVar.kfo, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                da(fVar.hOT);
            }
        }
        return view;
    }

    private void d(TextView textView, boolean z) {
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

    public void da(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
