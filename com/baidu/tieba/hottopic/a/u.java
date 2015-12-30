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
    private ArrayList<RelateForumItemData> YJ = new ArrayList<>();
    private ArrayList<TextView> bGA = new ArrayList<>();
    private View.OnClickListener bGB = new v(this);
    private RelateTopicForumActivity bGz;

    public u(RelateTopicForumActivity relateTopicForumActivity) {
        this.bGz = relateTopicForumActivity;
    }

    public void setData(List<RelateForumItemData> list) {
        this.YJ.clear();
        this.YJ.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.YJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.YJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.hottopic.b.g gVar;
        if (view == null) {
            view = LayoutInflater.from(this.bGz.getPageContext().getContext()).inflate(n.h.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.b.g gVar2 = new com.baidu.tieba.hottopic.b.g(view);
            view.setTag(gVar2);
            gVar2.bIU.setOnClickListener(this.bGB);
            this.bGA.add(gVar2.bIU);
            gVar2.bIU.setTag(Integer.valueOf(i));
            gVar = gVar2;
        } else {
            gVar = (com.baidu.tieba.hottopic.b.g) view.getTag();
        }
        if (this.YJ != null && this.YJ.get(i) != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (gVar.ahf != skinType) {
                as.b(gVar.bIP, n.d.cp_cont_b, 1);
                as.b(gVar.boK, n.d.cp_cont_c, 1);
                as.b(gVar.boL, n.d.cp_cont_c, 1);
                as.b(gVar.bIV, n.d.cp_cont_c, 1);
                as.b(gVar.bIW, n.d.cp_cont_c, 1);
                as.b(gVar.aoy, n.d.cp_cont_d, 1);
                as.i(gVar.line, n.d.cp_bg_line_b);
                as.i((View) gVar.bIU, n.f.btn_appdownload);
                as.i(view, n.f.list_item_selector);
                gVar.ahf = skinType;
            }
            gVar.bIP.setText(this.YJ.get(i).forumName);
            if (!StringUtils.isNULL(this.YJ.get(i).forumAvatar)) {
                gVar.bIN.d(this.YJ.get(i).forumAvatar, 10, false);
            }
            gVar.boK.setText(aK(this.YJ.get(i).postNum));
            gVar.boL.setText(aK(this.YJ.get(i).followNum));
            gVar.aoy.setText(ax.dz(this.YJ.get(i).forumAbstract));
            a(gVar.bIU, this.YJ.get(i).isLiked);
            if (i == this.YJ.size() - 1) {
                T(gVar.line);
            }
        }
        return view;
    }

    private void a(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            as.b(textView, n.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(n.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        as.b(textView, n.d.cp_cont_i, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(n.j.forum_list_attention_tv));
        as.i((View) textView, n.f.btn_appdownload);
        textView.setEnabled(true);
    }

    private String aK(long j) {
        if (j < 0) {
            return "0";
        }
        if (j <= 999999) {
            return String.valueOf(j);
        }
        return String.format("%.0fw", Float.valueOf(((float) j) / 10000.0f));
    }

    public void T(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
