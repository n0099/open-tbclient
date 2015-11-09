package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private RelateTopicForumActivity boW;
    private ArrayList<RelateForumItemData> Xt = new ArrayList<>();
    private ArrayList<TextView> boX = new ArrayList<>();
    private View.OnClickListener boY = new o(this);

    public n(RelateTopicForumActivity relateTopicForumActivity) {
        this.boW = relateTopicForumActivity;
    }

    public void setData(List<RelateForumItemData> list) {
        this.Xt.clear();
        this.Xt.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Xt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Xt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.hottopic.b.i iVar;
        if (view == null) {
            view = LayoutInflater.from(this.boW.getPageContext().getContext()).inflate(i.g.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.b.i iVar2 = new com.baidu.tieba.hottopic.b.i(view);
            view.setTag(iVar2);
            iVar2.bqK.setOnClickListener(this.boY);
            this.boX.add(iVar2.bqK);
            iVar2.bqK.setTag(Integer.valueOf(i));
            iVar = iVar2;
        } else {
            iVar = (com.baidu.tieba.hottopic.b.i) view.getTag();
        }
        if (this.Xt != null && this.Xt.get(i) != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (iVar.arf != skinType) {
                an.b(iVar.bqH, i.c.cp_cont_b, 1);
                an.b(iVar.beo, i.c.cp_cont_c, 1);
                an.b(iVar.bep, i.c.cp_cont_c, 1);
                an.b(iVar.bqI, i.c.cp_cont_c, 1);
                an.b(iVar.bqJ, i.c.cp_cont_c, 1);
                an.b(iVar.alD, i.c.cp_cont_d, 1);
                an.i(iVar.line, i.c.cp_bg_line_b);
                an.i((View) iVar.bqK, i.e.btn_appdownload);
                an.i(view, i.e.list_item_selector);
                iVar.arf = skinType;
            }
            iVar.bqH.setText(this.Xt.get(i).forumName);
            if (!StringUtils.isNULL(this.Xt.get(i).forumAvatar)) {
                iVar.bqG.d(this.Xt.get(i).forumAvatar, 10, false);
            }
            iVar.beo.setText(av(this.Xt.get(i).postNum));
            iVar.bep.setText(av(this.Xt.get(i).followNum));
            iVar.alD.setText(as.dm(this.Xt.get(i).forumAbstract));
            a(iVar.bqK, this.Xt.get(i).isLiked);
            if (i == this.Xt.size() - 1) {
                I(iVar.line);
            }
        }
        return view;
    }

    private void a(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            an.b(textView, i.c.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        an.b(textView, i.c.cp_cont_i, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_attention_tv));
        an.i((View) textView, i.e.btn_appdownload);
        textView.setEnabled(true);
    }

    private String av(long j) {
        if (j < 0) {
            return "0";
        }
        if (j <= 999999) {
            return String.valueOf(j);
        }
        return String.format("%.0fw", Float.valueOf(((float) j) / 10000.0f));
    }

    public void I(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
