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
import com.baidu.tieba.data.SearchPostModel;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class bd extends BaseAdapter {
    private Context b;

    /* renamed from: a  reason: collision with root package name */
    private SearchPostModel f1423a = null;
    private int c = 0;
    private ArrayList<ProgressBar> d = null;

    public bd(Context context) {
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
        if (this.f1423a == null) {
            return false;
        }
        return this.f1423a.hasPre();
    }

    public boolean c() {
        if (this.f1423a == null) {
            return false;
        }
        return this.f1423a.hasMore();
    }

    public void a(SearchPostModel searchPostModel) {
        this.f1423a = searchPostModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1423a == null || this.f1423a.getData() == null) {
            return 0;
        }
        int size = this.f1423a.getData().size();
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
        if (this.f1423a == null || this.f1423a.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.f1423a.getData().size()) {
            return null;
        }
        return this.f1423a.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f1423a == null || this.f1423a.getData() == null) {
            return -1L;
        }
        if (b()) {
            if (i <= this.f1423a.getData().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.f1423a.getData().size()) {
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
        bf bfVar;
        bg bgVar;
        View inflate;
        if (this.f1423a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    bgVar = new bg(this);
                    inflate = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    bgVar.c = (TextView) inflate.findViewById(R.id.title);
                    bgVar.b = (TextView) inflate.findViewById(R.id.content);
                    bgVar.d = (TextView) inflate.findViewById(R.id.forum);
                    bgVar.f1425a = (TextView) inflate.findViewById(R.id.time);
                    bgVar.e = (LinearLayout) inflate.findViewById(R.id.content_layout);
                    inflate.setTag(bgVar);
                    bfVar = null;
                } else {
                    bf bfVar2 = new bf(this);
                    inflate = from.inflate(R.layout.page_item, (ViewGroup) null);
                    bfVar2.f1424a = (TextView) inflate.findViewById(R.id.page_text);
                    bfVar2.b = (ProgressBar) inflate.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList<>();
                    }
                    this.d.add(bfVar2.b);
                    inflate.setTag(bfVar2);
                    bfVar = bfVar2;
                    bgVar = null;
                }
                view = inflate;
            } else if (getItemViewType(i) == 0) {
                bgVar = (bg) view.getTag();
                bfVar = null;
            } else {
                bfVar = (bf) view.getTag();
                bgVar = null;
            }
            int ap = TiebaApplication.g().ap();
            if (getItemViewType(i) == 0) {
                com.baidu.tieba.data.av avVar = (com.baidu.tieba.data.av) getItem(i);
                if (avVar != null) {
                    bgVar.d.setText(avVar.d() + this.b.getString(R.string.bar));
                    bgVar.f1425a.setText(com.baidu.tieba.util.be.b(avVar.g()));
                    if (avVar.f() == null || avVar.f().length() < 1) {
                        bgVar.e.setVisibility(8);
                    } else {
                        bgVar.e.setVisibility(0);
                        bgVar.b.setText(Html.fromHtml(com.baidu.tieba.util.be.a(avVar.f(), (Color) null)));
                    }
                    bgVar.c.setText(Html.fromHtml(com.baidu.tieba.util.be.a(avVar.e(), (Color) null)));
                    com.baidu.tieba.util.bd.b(bgVar.b, ap);
                    if (ap == 0) {
                        com.baidu.tieba.util.bd.e(bgVar.e, (int) R.drawable.search_replay_back);
                        bgVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        bgVar.f1425a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        bgVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        com.baidu.tieba.util.bd.e(bgVar.e, (int) R.drawable.search_replay_back_1);
                        bgVar.d.setTextColor(com.baidu.tieba.util.bd.c(ap));
                        bgVar.f1425a.setTextColor(com.baidu.tieba.util.bd.c(ap));
                        bgVar.b.setTextColor(com.baidu.tieba.util.bd.a(ap));
                        bgVar.c.setTextColor(com.baidu.tieba.util.bd.b(ap));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    bfVar.b.setVisibility(0);
                    bfVar.f1424a.setText(this.b.getString(R.string.loading));
                } else {
                    bfVar.b.setVisibility(8);
                    bfVar.f1424a.setText(this.b.getString(R.string.pre_page));
                }
                com.baidu.tieba.util.bd.b(bfVar.f1424a, ap);
            } else {
                if (this.c == 2) {
                    bfVar.b.setVisibility(0);
                    bfVar.f1424a.setText(this.b.getString(R.string.loading));
                } else {
                    bfVar.b.setVisibility(8);
                    bfVar.f1424a.setText(this.b.getString(R.string.next_page));
                }
                com.baidu.tieba.util.bd.b(bfVar.f1424a, ap);
            }
        }
        return view;
    }
}
