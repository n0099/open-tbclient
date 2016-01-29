package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends BaseAdapter {
    private RelateTopicForumActivity bJQ;
    private ArrayList<RelateForumItemData> Zg = new ArrayList<>();
    private View.OnClickListener bJR = new w(this);

    public v(RelateTopicForumActivity relateTopicForumActivity) {
        this.bJQ = relateTopicForumActivity;
    }

    public void setData(List<RelateForumItemData> list) {
        this.Zg.clear();
        this.Zg.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.Zg.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Zg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.hottopic.b.h hVar;
        if (view == null) {
            view = LayoutInflater.from(this.bJQ.getPageContext().getContext()).inflate(t.h.hot_topic_list_item, (ViewGroup) null);
            com.baidu.tieba.hottopic.b.h hVar2 = new com.baidu.tieba.hottopic.b.h(view);
            view.setTag(hVar2);
            hVar2.bMA.setOnClickListener(this.bJR);
            hVar = hVar2;
        } else {
            hVar = (com.baidu.tieba.hottopic.b.h) view.getTag();
        }
        hVar.bMA.setTag(Integer.valueOf(i));
        if (this.Zg != null && this.Zg.get(i) != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (hVar.ahU != skinType) {
                ar.b(hVar.bMx, t.d.cp_cont_b, 1);
                ar.b(hVar.brH, t.d.cp_cont_c, 1);
                ar.b(hVar.brI, t.d.cp_cont_c, 1);
                ar.b(hVar.bMy, t.d.cp_cont_c, 1);
                ar.b(hVar.bMz, t.d.cp_cont_c, 1);
                ar.b(hVar.apr, t.d.cp_cont_d, 1);
                ar.k(hVar.aHm, t.d.cp_bg_line_b);
                ar.k(hVar.bMA, t.f.btn_appdownload);
                ar.k(view, t.f.list_item_selector);
                hVar.ahU = skinType;
            }
            hVar.bMx.setText(this.Zg.get(i).forumName);
            if (!StringUtils.isNULL(this.Zg.get(i).forumAvatar)) {
                hVar.bMw.d(this.Zg.get(i).forumAvatar, 10, false);
            }
            hVar.brH.setText(aw.x(this.Zg.get(i).postNum));
            hVar.brI.setText(aw.x(this.Zg.get(i).followNum));
            hVar.apr.setText(aw.dw(this.Zg.get(i).forumAbstract));
            a(hVar.bMA, this.Zg.get(i).isLiked);
            if (i == this.Zg.size() - 1) {
                ah(hVar.aHm);
            }
        }
        return view;
    }

    private void a(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            ar.b(textView, t.d.cp_cont_d, 1);
            textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        ar.b(textView, t.d.cp_cont_i, 1);
        textView.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        ar.k(textView, t.f.btn_appdownload);
        textView.setEnabled(true);
    }

    public void ah(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }
}
