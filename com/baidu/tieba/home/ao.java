package com.baidu.tieba.home;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ax;
import com.baidu.tieba.data.ay;
import com.baidu.tieba.util.at;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ao extends BaseAdapter {
    private Context b;

    /* renamed from: a  reason: collision with root package name */
    private ay f1206a = null;
    private int c = 0;
    private ArrayList<ProgressBar> d = null;

    public ao(Context context) {
        this.b = null;
        this.b = context;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a() {
        if (this.d != null) {
            Iterator<ProgressBar> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public boolean b() {
        if (this.f1206a == null) {
            return false;
        }
        return this.f1206a.c();
    }

    public boolean c() {
        if (this.f1206a == null) {
            return false;
        }
        return this.f1206a.b();
    }

    public void a(ay ayVar) {
        this.f1206a = ayVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1206a == null || this.f1206a.a() == null) {
            return 0;
        }
        int size = this.f1206a.a().size();
        if (b()) {
            size++;
        }
        if (c()) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.f1206a == null || this.f1206a.a() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.f1206a.a().size()) {
            return null;
        }
        return this.f1206a.a().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f1206a == null || this.f1206a.a() == null) {
            return -1L;
        }
        if (b()) {
            if (i <= this.f1206a.a().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.f1206a.a().size()) {
            return i;
        } else {
            return -2L;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ap apVar;
        aq aqVar;
        if (this.f1206a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    aqVar = new aq(this, null);
                    view = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    aqVar.c = (TextView) view.findViewById(R.id.title);
                    aqVar.b = (TextView) view.findViewById(R.id.content);
                    aqVar.d = (TextView) view.findViewById(R.id.forum);
                    aqVar.f1208a = (TextView) view.findViewById(R.id.time);
                    aqVar.e = (LinearLayout) view.findViewById(R.id.content_layout);
                    view.setTag(aqVar);
                    apVar = null;
                } else {
                    ap apVar2 = new ap(this, null);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    apVar2.f1207a = (TextView) view.findViewById(R.id.page_text);
                    apVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList<>();
                    }
                    this.d.add(apVar2.b);
                    view.setTag(apVar2);
                    apVar = apVar2;
                    aqVar = null;
                }
            } else if (getItemViewType(i) == 0) {
                aqVar = (aq) view.getTag();
                apVar = null;
            } else {
                apVar = (ap) view.getTag();
                aqVar = null;
            }
            int ap = TiebaApplication.g().ap();
            if (getItemViewType(i) == 0) {
                ax axVar = (ax) getItem(i);
                if (axVar != null) {
                    aqVar.d.setText(String.valueOf(axVar.d()) + this.b.getString(R.string.bar));
                    aqVar.f1208a.setText(at.h(new Date(axVar.g())));
                    if (axVar.f() == null || axVar.f().length() < 1) {
                        aqVar.e.setVisibility(8);
                    } else {
                        aqVar.e.setVisibility(0);
                        aqVar.b.setText(Html.fromHtml(at.a(axVar.f(), (Color) null)));
                    }
                    aqVar.c.setText(Html.fromHtml(at.a(axVar.e(), (Color) null)));
                    com.baidu.tieba.util.as.b(aqVar.b, ap);
                    if (ap == 0) {
                        com.baidu.tieba.util.as.e(aqVar.e, (int) R.drawable.search_replay_back);
                        aqVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        aqVar.f1208a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        aqVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        com.baidu.tieba.util.as.e(aqVar.e, (int) R.drawable.search_replay_back_1);
                        aqVar.d.setTextColor(com.baidu.tieba.util.as.c(ap));
                        aqVar.f1208a.setTextColor(com.baidu.tieba.util.as.c(ap));
                        aqVar.b.setTextColor(com.baidu.tieba.util.as.a(ap));
                        aqVar.c.setTextColor(com.baidu.tieba.util.as.b(ap));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    apVar.b.setVisibility(0);
                    apVar.f1207a.setText(this.b.getString(R.string.loading));
                } else {
                    apVar.b.setVisibility(8);
                    apVar.f1207a.setText(this.b.getString(R.string.pre_page));
                }
                com.baidu.tieba.util.as.b(apVar.f1207a, ap);
            } else {
                if (this.c == 2) {
                    apVar.b.setVisibility(0);
                    apVar.f1207a.setText(this.b.getString(R.string.loading));
                } else {
                    apVar.b.setVisibility(8);
                    apVar.f1207a.setText(this.b.getString(R.string.next_page));
                }
                com.baidu.tieba.util.as.b(apVar.f1207a, ap);
            }
        }
        return view;
    }
}
