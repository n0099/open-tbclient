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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class l extends BaseAdapter {
    private String dYw;
    private RelateTopicForumActivity iCy;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener iCz = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (l.this.iCy != null && l.this.iCy.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) l.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new ao("c10371").dk("fid", String.valueOf(relateForumItemData.forumId)).ag("obj_type", com.baidu.tieba.hottopic.data.k.iEL).dk("topic_id", l.this.dYw));
                }
                if (ar.isForumName(relateForumItemData.forumName)) {
                    l.this.iCy.iDl.fx(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.iCy = relateTopicForumActivity;
    }

    public void b(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.dYw = str;
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
            view = LayoutInflater.from(this.iCy.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.a.f fVar2 = new com.baidu.tieba.hottopic.a.f(view);
            view.setTag(fVar2);
            fVar2.iFO.setOnClickListener(this.iCz);
            fVar = fVar2;
        } else {
            fVar = (com.baidu.tieba.hottopic.a.f) view.getTag();
        }
        fVar.iFO.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.ahx != skinType) {
                an.setViewTextColor(fVar.iFK, R.color.cp_cont_b, 1);
                an.setViewTextColor(fVar.ifo, R.color.cp_cont_c, 1);
                an.setViewTextColor(fVar.ifp, R.color.cp_cont_c, 1);
                an.setViewTextColor(fVar.iFL, R.color.cp_cont_c, 1);
                an.setViewTextColor(fVar.iFM, R.color.cp_cont_c, 1);
                an.setViewTextColor(fVar.iFN, R.color.cp_cont_d, 1);
                an.setBackgroundResource(fVar.gCZ, R.color.cp_bg_line_c);
                an.setBackgroundResource(fVar.iFO, R.drawable.btn_appdownload);
                an.setBackgroundResource(view, R.drawable.list_item_selector);
                fVar.ahx = skinType;
            }
            fVar.iFK.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                fVar.iFJ.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            fVar.ifo.setText(ar.numberUniformFormat(this.dataList.get(i).postNum));
            fVar.ifp.setText(ar.numberUniformFormat(this.dataList.get(i).followNum));
            fVar.iFN.setText(ar.forceLToR(this.dataList.get(i).forumAbstract));
            d(fVar.iFO, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                cj(fVar.gCZ);
            }
        }
        return view;
    }

    private void d(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            an.setViewTextColor(textView, R.color.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        an.setViewTextColor(textView, R.color.cp_cont_a, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        an.setBackgroundResource(textView, R.drawable.btn_appdownload);
        textView.setEnabled(true);
    }

    public void cj(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
