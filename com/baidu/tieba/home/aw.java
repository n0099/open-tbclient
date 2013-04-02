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
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class aw extends BaseAdapter {
    private Context b;
    private com.baidu.tieba.a.ar a = null;
    private int c = 0;
    private ArrayList d = null;

    public aw(Context context) {
        this.b = null;
        this.b = context;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a() {
        if (this.d != null) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((ProgressBar) it.next()).setVisibility(8);
            }
        }
    }

    public boolean b() {
        if (this.a == null) {
            return false;
        }
        return this.a.c();
    }

    public boolean c() {
        if (this.a == null) {
            return false;
        }
        return this.a.b();
    }

    public void a(com.baidu.tieba.a.ar arVar) {
        this.a = arVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null || this.a.a() == null) {
            return 0;
        }
        int size = this.a.a().size();
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
        if (this.a == null || this.a.a() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.a.a().size()) {
            return null;
        }
        return this.a.a().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.a == null || this.a.a() == null) {
            return -1L;
        }
        if (b()) {
            if (i <= this.a.a().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.a.a().size()) {
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
        ax axVar;
        ay ayVar;
        if (this.a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    ayVar = new ay(this, null);
                    view = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    ayVar.c = (TextView) view.findViewById(R.id.title);
                    ayVar.b = (TextView) view.findViewById(R.id.content);
                    ayVar.d = (TextView) view.findViewById(R.id.forum);
                    ayVar.a = (TextView) view.findViewById(R.id.time);
                    ayVar.e = (LinearLayout) view.findViewById(R.id.content_layout);
                    view.setTag(ayVar);
                    axVar = null;
                } else {
                    ax axVar2 = new ax(this, null);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    axVar2.a = (TextView) view.findViewById(R.id.page_text);
                    axVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList();
                    }
                    this.d.add(axVar2.b);
                    view.setTag(axVar2);
                    axVar = axVar2;
                    ayVar = null;
                }
            } else if (getItemViewType(i) == 0) {
                ayVar = (ay) view.getTag();
                axVar = null;
            } else {
                axVar = (ax) view.getTag();
                ayVar = null;
            }
            int ah = TiebaApplication.b().ah();
            if (getItemViewType(i) == 0) {
                com.baidu.tieba.a.aq aqVar = (com.baidu.tieba.a.aq) getItem(i);
                if (aqVar != null) {
                    ayVar.d.setText(String.valueOf(aqVar.d()) + this.b.getString(R.string.bar));
                    ayVar.a.setText(com.baidu.tieba.c.af.f(new Date(aqVar.g())));
                    if (aqVar.f() == null || aqVar.f().length() < 1) {
                        ayVar.e.setVisibility(8);
                    } else {
                        ayVar.e.setVisibility(0);
                        ayVar.b.setText(Html.fromHtml(com.baidu.tieba.c.af.a(aqVar.f(), (Color) null)));
                    }
                    ayVar.c.setText(Html.fromHtml(com.baidu.tieba.c.af.a(aqVar.e(), (Color) null)));
                    com.baidu.tieba.c.ae.b(ayVar.b, ah);
                    if (ah == 0) {
                        com.baidu.tieba.c.ae.h(ayVar.e, R.drawable.search_replay_back);
                        ayVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        ayVar.a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        ayVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        com.baidu.tieba.c.ae.h(ayVar.e, R.drawable.search_replay_back_1);
                        ayVar.d.setTextColor(com.baidu.tieba.c.ae.c(ah));
                        ayVar.a.setTextColor(com.baidu.tieba.c.ae.c(ah));
                        ayVar.b.setTextColor(com.baidu.tieba.c.ae.a(ah));
                        ayVar.c.setTextColor(com.baidu.tieba.c.ae.b(ah));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    axVar.b.setVisibility(0);
                    axVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    axVar.b.setVisibility(8);
                    axVar.a.setText(this.b.getString(R.string.pre_page));
                }
                com.baidu.tieba.c.ae.b(axVar.a, ah);
            } else {
                if (this.c == 2) {
                    axVar.b.setVisibility(0);
                    axVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    axVar.b.setVisibility(8);
                    axVar.a.setText(this.b.getString(R.string.next_page));
                }
                com.baidu.tieba.c.ae.b(axVar.a, ah);
            }
        }
        return view;
    }
}
