package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private RelateTopicForumActivity boh;
    private ArrayList<RelateForumItemData> Xo = new ArrayList<>();
    private ArrayList<TextView> boi = new ArrayList<>();
    private View.OnClickListener boj = new o(this);

    public n(RelateTopicForumActivity relateTopicForumActivity) {
        this.boh = relateTopicForumActivity;
    }

    public void setData(List<RelateForumItemData> list) {
        this.Xo.clear();
        this.Xo.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Xo.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Xo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.hottopic.b.i iVar;
        if (view == null) {
            view = LayoutInflater.from(this.boh.getPageContext().getContext()).inflate(i.g.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.b.i iVar2 = new com.baidu.tieba.hottopic.b.i(view);
            view.setTag(iVar2);
            iVar2.bpV.setOnClickListener(this.boj);
            this.boi.add(iVar2.bpV);
            iVar2.bpV.setTag(Integer.valueOf(i));
            iVar = iVar2;
        } else {
            iVar = (com.baidu.tieba.hottopic.b.i) view.getTag();
        }
        if (this.Xo != null && this.Xo.get(i) != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (iVar.apR != skinType) {
                am.b(iVar.bpS, i.c.cp_cont_b, 1);
                am.b(iVar.bdy, i.c.cp_cont_c, 1);
                am.b(iVar.bdz, i.c.cp_cont_c, 1);
                am.b(iVar.bpT, i.c.cp_cont_c, 1);
                am.b(iVar.bpU, i.c.cp_cont_c, 1);
                am.b(iVar.alx, i.c.cp_cont_d, 1);
                am.i(iVar.line, i.c.cp_bg_line_b);
                am.i((View) iVar.bpV, i.e.btn_appdownload);
                am.i(view, i.e.list_item_selector);
                iVar.apR = skinType;
            }
            iVar.bpS.setText(this.Xo.get(i).forumName);
            if (!StringUtils.isNULL(this.Xo.get(i).forumAvatar)) {
                iVar.bpR.d(this.Xo.get(i).forumAvatar, 10, false);
            }
            iVar.bdy.setText(an(this.Xo.get(i).postNum));
            iVar.bdz.setText(an(this.Xo.get(i).followNum));
            iVar.alx.setText(ar.dl(this.Xo.get(i).forumAbstract));
            a(iVar.bpV, this.Xo.get(i).isLiked);
            if (i == this.Xo.size() - 1) {
                H(iVar.line);
            }
        }
        return view;
    }

    private void a(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            am.b(textView, i.c.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(i.h.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        am.b(textView, i.c.cp_cont_i, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(i.h.forum_list_attention_tv));
        am.i((View) textView, i.e.btn_appdownload);
        textView.setEnabled(true);
    }

    private String an(long j) {
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
