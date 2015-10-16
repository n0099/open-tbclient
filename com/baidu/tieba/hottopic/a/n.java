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
    private RelateTopicForumActivity bos;
    private ArrayList<RelateForumItemData> Xq = new ArrayList<>();
    private ArrayList<TextView> bot = new ArrayList<>();
    private View.OnClickListener bou = new o(this);

    public n(RelateTopicForumActivity relateTopicForumActivity) {
        this.bos = relateTopicForumActivity;
    }

    public void setData(List<RelateForumItemData> list) {
        this.Xq.clear();
        this.Xq.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Xq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Xq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.hottopic.b.i iVar;
        if (view == null) {
            view = LayoutInflater.from(this.bos.getPageContext().getContext()).inflate(i.g.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.b.i iVar2 = new com.baidu.tieba.hottopic.b.i(view);
            view.setTag(iVar2);
            iVar2.bqg.setOnClickListener(this.bou);
            this.bot.add(iVar2.bqg);
            iVar2.bqg.setTag(Integer.valueOf(i));
            iVar = iVar2;
        } else {
            iVar = (com.baidu.tieba.hottopic.b.i) view.getTag();
        }
        if (this.Xq != null && this.Xq.get(i) != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (iVar.apS != skinType) {
                an.b(iVar.bqd, i.c.cp_cont_b, 1);
                an.b(iVar.bdJ, i.c.cp_cont_c, 1);
                an.b(iVar.bdK, i.c.cp_cont_c, 1);
                an.b(iVar.bqe, i.c.cp_cont_c, 1);
                an.b(iVar.bqf, i.c.cp_cont_c, 1);
                an.b(iVar.aly, i.c.cp_cont_d, 1);
                an.i(iVar.line, i.c.cp_bg_line_b);
                an.i((View) iVar.bqg, i.e.btn_appdownload);
                an.i(view, i.e.list_item_selector);
                iVar.apS = skinType;
            }
            iVar.bqd.setText(this.Xq.get(i).forumName);
            if (!StringUtils.isNULL(this.Xq.get(i).forumAvatar)) {
                iVar.bqc.d(this.Xq.get(i).forumAvatar, 10, false);
            }
            iVar.bdJ.setText(ax(this.Xq.get(i).postNum));
            iVar.bdK.setText(ax(this.Xq.get(i).followNum));
            iVar.aly.setText(as.dm(this.Xq.get(i).forumAbstract));
            a(iVar.bqg, this.Xq.get(i).isLiked);
            if (i == this.Xq.size() - 1) {
                H(iVar.line);
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

    private String ax(long j) {
        if (j < 0) {
            return "0";
        }
        if (j <= 999999) {
            return String.valueOf(j);
        }
        return String.format("%.0fw", Float.valueOf(((float) j) / 10000.0f));
    }

    public void H(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
