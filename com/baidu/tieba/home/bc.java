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
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class bc extends BaseAdapter {
    private Context b;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.ay f1175a = null;
    private int c = 0;
    private ArrayList d = null;

    public bc(Context context) {
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
        if (this.f1175a == null) {
            return false;
        }
        return this.f1175a.c();
    }

    public boolean c() {
        if (this.f1175a == null) {
            return false;
        }
        return this.f1175a.b();
    }

    public void a(com.baidu.tieba.data.ay ayVar) {
        this.f1175a = ayVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1175a == null || this.f1175a.a() == null) {
            return 0;
        }
        int size = this.f1175a.a().size();
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
        if (this.f1175a == null || this.f1175a.a() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.f1175a.a().size()) {
            return null;
        }
        return this.f1175a.a().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f1175a == null || this.f1175a.a() == null) {
            return -1L;
        }
        if (b()) {
            if (i <= this.f1175a.a().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.f1175a.a().size()) {
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
        bd bdVar;
        be beVar;
        if (this.f1175a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    beVar = new be(this, null);
                    view = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    beVar.c = (TextView) view.findViewById(R.id.title);
                    beVar.b = (TextView) view.findViewById(R.id.content);
                    beVar.d = (TextView) view.findViewById(R.id.forum);
                    beVar.f1177a = (TextView) view.findViewById(R.id.time);
                    beVar.e = (LinearLayout) view.findViewById(R.id.content_layout);
                    view.setTag(beVar);
                    bdVar = null;
                } else {
                    bd bdVar2 = new bd(this, null);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    bdVar2.f1176a = (TextView) view.findViewById(R.id.page_text);
                    bdVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList();
                    }
                    this.d.add(bdVar2.b);
                    view.setTag(bdVar2);
                    bdVar = bdVar2;
                    beVar = null;
                }
            } else if (getItemViewType(i) == 0) {
                beVar = (be) view.getTag();
                bdVar = null;
            } else {
                bdVar = (bd) view.getTag();
                beVar = null;
            }
            int an = TiebaApplication.g().an();
            if (getItemViewType(i) == 0) {
                com.baidu.tieba.data.ax axVar = (com.baidu.tieba.data.ax) getItem(i);
                if (axVar != null) {
                    beVar.d.setText(String.valueOf(axVar.d()) + this.b.getString(R.string.bar));
                    beVar.f1177a.setText(com.baidu.tieba.util.ap.f(new Date(axVar.g())));
                    if (axVar.f() == null || axVar.f().length() < 1) {
                        beVar.e.setVisibility(8);
                    } else {
                        beVar.e.setVisibility(0);
                        beVar.b.setText(Html.fromHtml(com.baidu.tieba.util.ap.a(axVar.f(), (Color) null)));
                    }
                    beVar.c.setText(Html.fromHtml(com.baidu.tieba.util.ap.a(axVar.e(), (Color) null)));
                    com.baidu.tieba.util.ao.b(beVar.b, an);
                    if (an == 0) {
                        com.baidu.tieba.util.ao.g(beVar.e, (int) R.drawable.search_replay_back);
                        beVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        beVar.f1177a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        beVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        com.baidu.tieba.util.ao.g(beVar.e, (int) R.drawable.search_replay_back_1);
                        beVar.d.setTextColor(com.baidu.tieba.util.ao.c(an));
                        beVar.f1177a.setTextColor(com.baidu.tieba.util.ao.c(an));
                        beVar.b.setTextColor(com.baidu.tieba.util.ao.a(an));
                        beVar.c.setTextColor(com.baidu.tieba.util.ao.b(an));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    bdVar.b.setVisibility(0);
                    bdVar.f1176a.setText(this.b.getString(R.string.loading));
                } else {
                    bdVar.b.setVisibility(8);
                    bdVar.f1176a.setText(this.b.getString(R.string.pre_page));
                }
                com.baidu.tieba.util.ao.b(bdVar.f1176a, an);
            } else {
                if (this.c == 2) {
                    bdVar.b.setVisibility(0);
                    bdVar.f1176a.setText(this.b.getString(R.string.loading));
                } else {
                    bdVar.b.setVisibility(8);
                    bdVar.f1176a.setText(this.b.getString(R.string.next_page));
                }
                com.baidu.tieba.util.ao.b(bdVar.f1176a, an);
            }
        }
        return view;
    }
}
