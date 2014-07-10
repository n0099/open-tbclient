package com.baidu.tieba.im.live.livelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class ai extends BaseAdapter {
    private LiveGroupHistoryActivity a;
    private boolean c;
    private boolean d = true;
    private List<com.baidu.tieba.im.data.g> b = new ArrayList();

    public boolean a() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public ai(LiveGroupHistoryActivity liveGroupHistoryActivity) {
        this.a = liveGroupHistoryActivity;
    }

    public void a(List<com.baidu.tieba.im.data.g> list) {
        this.b.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (getItemId(i) != -1 && i >= 0 && i < this.b.size()) {
            return this.b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.b.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) == -1 ? -1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == -1) {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.live_list_foot, viewGroup, false);
            View findViewById = view.findViewById(com.baidu.tieba.v.bottom_line);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(com.baidu.tieba.v.bottom_more);
            TextView textView = (TextView) view.findViewById(com.baidu.tieba.v.more_title);
            ProgressBar progressBar = (ProgressBar) view.findViewById(com.baidu.tieba.v.more_progress);
            if (this.d) {
                findViewById.setVisibility(8);
                viewGroup2.setVisibility(8);
            } else {
                findViewById.setVisibility(8);
                viewGroup2.setVisibility(0);
                if (this.c) {
                    textView.setText(com.baidu.tieba.y.live_frs_list_hasmore);
                    progressBar.setVisibility(0);
                } else {
                    textView.setText(com.baidu.tieba.y.live_frs_list_nomore);
                    progressBar.setVisibility(8);
                }
            }
        } else {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.live_group_history_list_item, viewGroup, false);
                aj ajVar = new aj(this);
                ajVar.a = (TextView) view.findViewById(com.baidu.tieba.v.item_day);
                ajVar.b = (TextView) view.findViewById(com.baidu.tieba.v.item_timelast);
                view.setTag(ajVar);
            }
            aj ajVar2 = (aj) view.getTag();
            Object item = getItem(i);
            if (item != null) {
                com.baidu.tieba.im.data.g gVar = (com.baidu.tieba.im.data.g) item;
                ajVar2.a.setText(a(gVar.a()));
                ajVar2.b.setText(a(gVar.a(), gVar.b()));
            }
        }
        a(view);
        return view;
    }

    private String a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(1000 * j));
    }

    private String a(long j, long j2) {
        return StringUtils.translateSecondsToString((int) (j2 - j));
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(view);
    }
}
