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
import com.baidu.tieba.a.au;
import com.baidu.tieba.a.av;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ar extends BaseAdapter {
    private Context b;
    private av a = null;
    private int c = 0;
    private ArrayList d = null;

    public ar(Context context) {
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

    public void a(av avVar) {
        this.a = avVar;
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
        as asVar;
        at atVar;
        if (this.a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    atVar = new at(this, null);
                    view = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    atVar.c = (TextView) view.findViewById(R.id.title);
                    atVar.b = (TextView) view.findViewById(R.id.content);
                    atVar.d = (TextView) view.findViewById(R.id.forum);
                    atVar.a = (TextView) view.findViewById(R.id.time);
                    atVar.e = (LinearLayout) view.findViewById(R.id.content_layout);
                    view.setTag(atVar);
                    asVar = null;
                } else {
                    as asVar2 = new as(this, null);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    asVar2.a = (TextView) view.findViewById(R.id.page_text);
                    asVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList();
                    }
                    this.d.add(asVar2.b);
                    view.setTag(asVar2);
                    asVar = asVar2;
                    atVar = null;
                }
            } else if (getItemViewType(i) == 0) {
                atVar = (at) view.getTag();
                asVar = null;
            } else {
                asVar = (as) view.getTag();
                atVar = null;
            }
            int ai = TiebaApplication.d().ai();
            if (getItemViewType(i) == 0) {
                au auVar = (au) getItem(i);
                if (auVar != null) {
                    atVar.d.setText(String.valueOf(auVar.d()) + this.b.getString(R.string.bar));
                    atVar.a.setText(com.baidu.tieba.d.ad.c(new Date(auVar.g())));
                    if (auVar.f() == null || auVar.f().length() < 1) {
                        atVar.e.setVisibility(8);
                    } else {
                        atVar.e.setVisibility(0);
                        atVar.b.setText(Html.fromHtml(com.baidu.tieba.d.ad.a(auVar.f(), (Color) null)));
                    }
                    atVar.c.setText(Html.fromHtml(com.baidu.tieba.d.ad.a(auVar.e(), (Color) null)));
                    com.baidu.tieba.d.ac.b(atVar.b, ai);
                    if (ai == 0) {
                        com.baidu.tieba.d.ac.h(atVar.e, (int) R.drawable.search_replay_back);
                        atVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        atVar.a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        atVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        com.baidu.tieba.d.ac.h(atVar.e, (int) R.drawable.search_replay_back_1);
                        atVar.d.setTextColor(com.baidu.tieba.d.ac.c(ai));
                        atVar.a.setTextColor(com.baidu.tieba.d.ac.c(ai));
                        atVar.b.setTextColor(com.baidu.tieba.d.ac.a(ai));
                        atVar.c.setTextColor(com.baidu.tieba.d.ac.b(ai));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    asVar.b.setVisibility(0);
                    asVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    asVar.b.setVisibility(8);
                    asVar.a.setText(this.b.getString(R.string.pre_page));
                }
                com.baidu.tieba.d.ac.b(asVar.a, ai);
            } else {
                if (this.c == 2) {
                    asVar.b.setVisibility(0);
                    asVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    asVar.b.setVisibility(8);
                    asVar.a.setText(this.b.getString(R.string.next_page));
                }
                com.baidu.tieba.d.ac.b(asVar.a, ai);
            }
        }
        return view;
    }
}
