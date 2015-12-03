package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private RelateTopicForumActivity bCV;
    private ArrayList<RelateForumItemData> Yg = new ArrayList<>();
    private ArrayList<TextView> bCW = new ArrayList<>();
    private View.OnClickListener bCX = new v(this);

    public u(RelateTopicForumActivity relateTopicForumActivity) {
        this.bCV = relateTopicForumActivity;
    }

    public void setData(List<RelateForumItemData> list) {
        this.Yg.clear();
        this.Yg.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Yg.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Yg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.hottopic.b.g gVar;
        if (view == null) {
            view = LayoutInflater.from(this.bCV.getPageContext().getContext()).inflate(n.g.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.b.g gVar2 = new com.baidu.tieba.hottopic.b.g(view);
            view.setTag(gVar2);
            gVar2.bFn.setOnClickListener(this.bCX);
            this.bCW.add(gVar2.bFn);
            gVar2.bFn.setTag(Integer.valueOf(i));
            gVar = gVar2;
        } else {
            gVar = (com.baidu.tieba.hottopic.b.g) view.getTag();
        }
        if (this.Yg != null && this.Yg.get(i) != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (gVar.afY != skinType) {
                as.b(gVar.bAL, n.c.cp_cont_b, 1);
                as.b(gVar.bkT, n.c.cp_cont_c, 1);
                as.b(gVar.bkU, n.c.cp_cont_c, 1);
                as.b(gVar.bFo, n.c.cp_cont_c, 1);
                as.b(gVar.bFp, n.c.cp_cont_c, 1);
                as.b(gVar.ano, n.c.cp_cont_d, 1);
                as.i(gVar.line, n.c.cp_bg_line_b);
                as.i((View) gVar.bFn, n.e.btn_appdownload);
                as.i(view, n.e.list_item_selector);
                gVar.afY = skinType;
            }
            gVar.bAL.setText(this.Yg.get(i).forumName);
            if (!StringUtils.isNULL(this.Yg.get(i).forumAvatar)) {
                gVar.bFh.d(this.Yg.get(i).forumAvatar, 10, false);
            }
            gVar.bkT.setText(aJ(this.Yg.get(i).postNum));
            gVar.bkU.setText(aJ(this.Yg.get(i).followNum));
            gVar.ano.setText(ax.dw(this.Yg.get(i).forumAbstract));
            a(gVar.bFn, this.Yg.get(i).isLiked);
            if (i == this.Yg.size() - 1) {
                O(gVar.line);
            }
        }
        return view;
    }

    private void a(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            as.b(textView, n.c.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(n.i.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        as.b(textView, n.c.cp_cont_i, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(n.i.forum_list_attention_tv));
        as.i((View) textView, n.e.btn_appdownload);
        textView.setEnabled(true);
    }

    private String aJ(long j) {
        if (j < 0) {
            return "0";
        }
        if (j <= 999999) {
            return String.valueOf(j);
        }
        return String.format("%.0fw", Float.valueOf(((float) j) / 10000.0f));
    }

    public void O(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
