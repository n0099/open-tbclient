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
/* loaded from: classes20.dex */
public class l extends BaseAdapter {
    private String eQb;
    private RelateTopicForumActivity jOu;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private View.OnClickListener jOv = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.adapter.l.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (l.this.jOu != null && l.this.jOu.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) l.this.dataList.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new ar("c10371").dR("fid", String.valueOf(relateForumItemData.forumId)).ak("obj_type", com.baidu.tieba.hottopic.data.k.jQG).dR("topic_id", l.this.eQb));
                }
                if (au.isForumName(relateForumItemData.forumName)) {
                    l.this.jOu.jyf.gp(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    };

    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.jOu = relateTopicForumActivity;
    }

    public void c(List<RelateForumItemData> list, String str) {
        this.dataList.clear();
        this.dataList.addAll(list);
        this.eQb = str;
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
            view = LayoutInflater.from(this.jOu.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.a.f fVar2 = new com.baidu.tieba.hottopic.a.f(view);
            view.setTag(fVar2);
            fVar2.jRI.setOnClickListener(this.jOv);
            fVar = fVar2;
        } else {
            fVar = (com.baidu.tieba.hottopic.a.f) view.getTag();
        }
        fVar.jRI.setTag(Integer.valueOf(i));
        if (this.dataList != null && this.dataList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.ajv != skinType) {
                ap.setViewTextColor(fVar.jRF, R.color.CAM_X0105, 1);
                ap.setViewTextColor(fVar.joR, R.color.CAM_X0108, 1);
                ap.setViewTextColor(fVar.joS, R.color.CAM_X0108, 1);
                ap.setViewTextColor(fVar.jRG, R.color.CAM_X0108, 1);
                ap.setViewTextColor(fVar.jRH, R.color.CAM_X0108, 1);
                ap.setViewTextColor(fVar.gRJ, R.color.CAM_X0109, 1);
                ap.setBackgroundResource(fVar.hFk, R.color.CAM_X0204);
                ap.setBackgroundResource(fVar.jRI, R.drawable.btn_appdownload);
                ap.setBackgroundResource(view, R.drawable.list_item_selector);
                fVar.ajv = skinType;
            }
            fVar.jRF.setText(this.dataList.get(i).forumName);
            if (!StringUtils.isNULL(this.dataList.get(i).forumAvatar)) {
                fVar.jRE.startLoad(this.dataList.get(i).forumAvatar, 10, false);
            }
            fVar.joR.setText(au.numberUniformFormat(this.dataList.get(i).postNum));
            fVar.joS.setText(au.numberUniformFormat(this.dataList.get(i).followNum));
            fVar.gRJ.setText(au.forceLToR(this.dataList.get(i).forumAbstract));
            d(fVar.jRI, this.dataList.get(i).isLiked);
            if (i == this.dataList.size() - 1) {
                cT(fVar.hFk);
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

    public void cT(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
