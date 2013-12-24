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
public class ay extends BaseAdapter {
    private Context b;
    private SearchPostModel a = null;
    private int c = 0;
    private ArrayList<ProgressBar> d = null;

    public ay(Context context) {
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
        if (this.a == null) {
            return false;
        }
        return this.a.hasPre();
    }

    public boolean c() {
        if (this.a == null) {
            return false;
        }
        return this.a.hasMore();
    }

    public void a(SearchPostModel searchPostModel) {
        this.a = searchPostModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null || this.a.getData() == null) {
            return 0;
        }
        int size = this.a.getData().size();
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
        if (this.a == null || this.a.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.a.getData().size()) {
            return null;
        }
        return this.a.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.a == null || this.a.getData() == null) {
            return -1L;
        }
        if (b()) {
            if (i <= this.a.getData().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.a.getData().size()) {
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
        View inflate;
        if (this.a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    bbVar = new bb(this);
                    inflate = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    bbVar.c = (TextView) inflate.findViewById(R.id.title);
                    bbVar.b = (TextView) inflate.findViewById(R.id.content);
                    bbVar.d = (TextView) inflate.findViewById(R.id.forum);
                    bbVar.a = (TextView) inflate.findViewById(R.id.time);
                    bbVar.e = (LinearLayout) inflate.findViewById(R.id.content_layout);
                    inflate.setTag(bbVar);
                    baVar = null;
                } else {
                    ba baVar2 = new ba(this);
                    inflate = from.inflate(R.layout.page_item, (ViewGroup) null);
                    baVar2.a = (TextView) inflate.findViewById(R.id.page_text);
                    baVar2.b = (ProgressBar) inflate.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList<>();
                    }
                    this.d.add(baVar2.b);
                    inflate.setTag(baVar2);
                    baVar = baVar2;
                    bbVar = null;
                }
                view = inflate;
            } else if (getItemViewType(i) == 0) {
                bbVar = (bb) view.getTag();
                baVar = null;
            } else {
                baVar = (ba) view.getTag();
                bbVar = null;
            }
            int an = TiebaApplication.h().an();
            if (getItemViewType(i) == 0) {
                com.baidu.tieba.data.au auVar = (com.baidu.tieba.data.au) getItem(i);
                if (auVar != null) {
                    bbVar.d.setText(auVar.d() + this.b.getString(R.string.bar));
                    bbVar.a.setText(com.baidu.tieba.util.bc.b(auVar.g()));
                    if (auVar.f() == null || auVar.f().length() < 1) {
                        bbVar.e.setVisibility(8);
                    } else {
                        bbVar.e.setVisibility(0);
                        bbVar.b.setText(Html.fromHtml(com.baidu.tieba.util.bc.a(auVar.f(), (Color) null)));
                    }
                    bbVar.c.setText(Html.fromHtml(com.baidu.tieba.util.bc.a(auVar.e(), (Color) null)));
                    com.baidu.tieba.util.bb.b(bbVar.b, an);
                    if (an == 0) {
                        com.baidu.tieba.util.bb.e(bbVar.e, (int) R.drawable.search_replay_back);
                        bbVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        bbVar.a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        bbVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        com.baidu.tieba.util.bb.e(bbVar.e, (int) R.drawable.search_replay_back_1);
                        bbVar.d.setTextColor(com.baidu.tieba.util.bb.c(an));
                        bbVar.a.setTextColor(com.baidu.tieba.util.bb.c(an));
                        bbVar.b.setTextColor(com.baidu.tieba.util.bb.a(an));
                        bbVar.c.setTextColor(com.baidu.tieba.util.bb.b(an));
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
                com.baidu.tieba.util.bb.b(baVar.a, an);
            } else {
                if (this.c == 2) {
                    baVar.b.setVisibility(0);
                    baVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    baVar.b.setVisibility(8);
                    baVar.a.setText(this.b.getString(R.string.next_page));
                }
                com.baidu.tieba.util.bb.b(baVar.a, an);
            }
        }
        return view;
    }
}
