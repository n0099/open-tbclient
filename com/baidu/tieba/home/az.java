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
public class az extends BaseAdapter {
    private Context b;
    private com.baidu.tieba.a.ap a = null;
    private int c = 0;
    private ArrayList d = null;

    public az(Context context) {
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

    public void a(com.baidu.tieba.a.ap apVar) {
        this.a = apVar;
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
        ba baVar;
        bb bbVar;
        if (this.a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    bbVar = new bb(this, null);
                    view = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    bbVar.c = (TextView) view.findViewById(R.id.title);
                    bbVar.b = (TextView) view.findViewById(R.id.content);
                    bbVar.d = (TextView) view.findViewById(R.id.forum);
                    bbVar.a = (TextView) view.findViewById(R.id.time);
                    bbVar.e = (LinearLayout) view.findViewById(R.id.content_layout);
                    view.setTag(bbVar);
                    baVar = null;
                } else {
                    ba baVar2 = new ba(this, null);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    baVar2.a = (TextView) view.findViewById(R.id.page_text);
                    baVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList();
                    }
                    this.d.add(baVar2.b);
                    view.setTag(baVar2);
                    baVar = baVar2;
                    bbVar = null;
                }
            } else if (getItemViewType(i) == 0) {
                bbVar = (bb) view.getTag();
                baVar = null;
            } else {
                baVar = (ba) view.getTag();
                bbVar = null;
            }
            int ag = TiebaApplication.b().ag();
            if (getItemViewType(i) == 0) {
                com.baidu.tieba.a.ao aoVar = (com.baidu.tieba.a.ao) getItem(i);
                if (aoVar != null) {
                    bbVar.d.setText(String.valueOf(aoVar.d()) + this.b.getString(R.string.bar));
                    bbVar.a.setText(com.baidu.tieba.c.af.f(new Date(aoVar.g())));
                    if (aoVar.f() == null || aoVar.f().length() < 1) {
                        bbVar.e.setVisibility(8);
                    } else {
                        bbVar.e.setVisibility(0);
                        bbVar.b.setText(Html.fromHtml(com.baidu.tieba.c.af.a(aoVar.f(), (Color) null)));
                    }
                    bbVar.c.setText(Html.fromHtml(com.baidu.tieba.c.af.a(aoVar.e(), (Color) null)));
                    com.baidu.tieba.c.ae.b(bbVar.b, ag);
                    if (ag == 0) {
                        com.baidu.tieba.c.ae.i(bbVar.e, R.drawable.search_replay_back);
                        bbVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        bbVar.a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        bbVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        com.baidu.tieba.c.ae.i(bbVar.e, R.drawable.search_replay_back_1);
                        bbVar.d.setTextColor(com.baidu.tieba.c.ae.c(ag));
                        bbVar.a.setTextColor(com.baidu.tieba.c.ae.c(ag));
                        bbVar.b.setTextColor(com.baidu.tieba.c.ae.a(ag));
                        bbVar.c.setTextColor(com.baidu.tieba.c.ae.b(ag));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    baVar.b.setVisibility(0);
                    baVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    baVar.b.setVisibility(8);
                    baVar.a.setText(this.b.getString(R.string.pre_page));
                }
                com.baidu.tieba.c.ae.b(baVar.a, ag);
            } else {
                if (this.c == 2) {
                    baVar.b.setVisibility(0);
                    baVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    baVar.b.setVisibility(8);
                    baVar.a.setText(this.b.getString(R.string.next_page));
                }
                com.baidu.tieba.c.ae.b(baVar.a, ag);
            }
        }
        return view;
    }
}
