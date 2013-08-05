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
public class bb extends BaseAdapter {
    private Context b;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.bd f1141a = null;
    private int c = 0;
    private ArrayList d = null;

    public bb(Context context) {
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
        if (this.f1141a == null) {
            return false;
        }
        return this.f1141a.c();
    }

    public boolean c() {
        if (this.f1141a == null) {
            return false;
        }
        return this.f1141a.b();
    }

    public void a(com.baidu.tieba.data.bd bdVar) {
        this.f1141a = bdVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1141a == null || this.f1141a.a() == null) {
            return 0;
        }
        int size = this.f1141a.a().size();
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
        if (this.f1141a == null || this.f1141a.a() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.f1141a.a().size()) {
            return null;
        }
        return this.f1141a.a().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f1141a == null || this.f1141a.a() == null) {
            return -1L;
        }
        if (b()) {
            if (i <= this.f1141a.a().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.f1141a.a().size()) {
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
        bc bcVar;
        bd bdVar;
        if (this.f1141a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    bdVar = new bd(this, null);
                    view = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    bdVar.c = (TextView) view.findViewById(R.id.title);
                    bdVar.b = (TextView) view.findViewById(R.id.content);
                    bdVar.d = (TextView) view.findViewById(R.id.forum);
                    bdVar.f1143a = (TextView) view.findViewById(R.id.time);
                    bdVar.e = (LinearLayout) view.findViewById(R.id.content_layout);
                    view.setTag(bdVar);
                    bcVar = null;
                } else {
                    bc bcVar2 = new bc(this, null);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    bcVar2.f1142a = (TextView) view.findViewById(R.id.page_text);
                    bcVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList();
                    }
                    this.d.add(bcVar2.b);
                    view.setTag(bcVar2);
                    bcVar = bcVar2;
                    bdVar = null;
                }
            } else if (getItemViewType(i) == 0) {
                bdVar = (bd) view.getTag();
                bcVar = null;
            } else {
                bcVar = (bc) view.getTag();
                bdVar = null;
            }
            int au = TiebaApplication.f().au();
            if (getItemViewType(i) == 0) {
                com.baidu.tieba.data.bc bcVar3 = (com.baidu.tieba.data.bc) getItem(i);
                if (bcVar3 != null) {
                    bdVar.d.setText(String.valueOf(bcVar3.d()) + this.b.getString(R.string.bar));
                    bdVar.f1143a.setText(com.baidu.tieba.util.ai.d(new Date(bcVar3.g())));
                    if (bcVar3.f() == null || bcVar3.f().length() < 1) {
                        bdVar.e.setVisibility(8);
                    } else {
                        bdVar.e.setVisibility(0);
                        bdVar.b.setText(Html.fromHtml(com.baidu.tieba.util.ai.a(bcVar3.f(), (Color) null)));
                    }
                    bdVar.c.setText(Html.fromHtml(com.baidu.tieba.util.ai.a(bcVar3.e(), (Color) null)));
                    com.baidu.tieba.util.ah.b(bdVar.b, au);
                    if (au == 0) {
                        com.baidu.tieba.util.ah.h(bdVar.e, (int) R.drawable.search_replay_back);
                        bdVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        bdVar.f1143a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        bdVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        com.baidu.tieba.util.ah.h(bdVar.e, (int) R.drawable.search_replay_back_1);
                        bdVar.d.setTextColor(com.baidu.tieba.util.ah.c(au));
                        bdVar.f1143a.setTextColor(com.baidu.tieba.util.ah.c(au));
                        bdVar.b.setTextColor(com.baidu.tieba.util.ah.a(au));
                        bdVar.c.setTextColor(com.baidu.tieba.util.ah.b(au));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    bcVar.b.setVisibility(0);
                    bcVar.f1142a.setText(this.b.getString(R.string.loading));
                } else {
                    bcVar.b.setVisibility(8);
                    bcVar.f1142a.setText(this.b.getString(R.string.pre_page));
                }
                com.baidu.tieba.util.ah.b(bcVar.f1142a, au);
            } else {
                if (this.c == 2) {
                    bcVar.b.setVisibility(0);
                    bcVar.f1142a.setText(this.b.getString(R.string.loading));
                } else {
                    bcVar.b.setVisibility(8);
                    bcVar.f1142a.setText(this.b.getString(R.string.next_page));
                }
                com.baidu.tieba.util.ah.b(bcVar.f1142a, au);
            }
        }
        return view;
    }
}
