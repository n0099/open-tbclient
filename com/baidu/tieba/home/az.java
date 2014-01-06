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
public class az extends BaseAdapter {
    private Context b;
    private SearchPostModel a = null;
    private int c = 0;
    private ArrayList<ProgressBar> d = null;

    public az(Context context) {
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
        bb bbVar;
        bc bcVar;
        View inflate;
        if (this.a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    bcVar = new bc(this);
                    inflate = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    bcVar.c = (TextView) inflate.findViewById(R.id.title);
                    bcVar.b = (TextView) inflate.findViewById(R.id.content);
                    bcVar.d = (TextView) inflate.findViewById(R.id.forum);
                    bcVar.a = (TextView) inflate.findViewById(R.id.time);
                    bcVar.e = (LinearLayout) inflate.findViewById(R.id.content_layout);
                    inflate.setTag(bcVar);
                    bbVar = null;
                } else {
                    bb bbVar2 = new bb(this);
                    inflate = from.inflate(R.layout.page_item, (ViewGroup) null);
                    bbVar2.a = (TextView) inflate.findViewById(R.id.page_text);
                    bbVar2.b = (ProgressBar) inflate.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList<>();
                    }
                    this.d.add(bbVar2.b);
                    inflate.setTag(bbVar2);
                    bbVar = bbVar2;
                    bcVar = null;
                }
                view = inflate;
            } else if (getItemViewType(i) == 0) {
                bcVar = (bc) view.getTag();
                bbVar = null;
            } else {
                bbVar = (bb) view.getTag();
                bcVar = null;
            }
            int an = TiebaApplication.g().an();
            if (getItemViewType(i) == 0) {
                com.baidu.tieba.data.aw awVar = (com.baidu.tieba.data.aw) getItem(i);
                if (awVar != null) {
                    bcVar.d.setText(awVar.d() + this.b.getString(R.string.bar));
                    bcVar.a.setText(com.baidu.tieba.util.bm.b(awVar.g()));
                    if (awVar.f() == null || awVar.f().length() < 1) {
                        bcVar.e.setVisibility(8);
                    } else {
                        bcVar.e.setVisibility(0);
                        bcVar.b.setText(Html.fromHtml(com.baidu.tieba.util.bm.a(awVar.f(), (Color) null)));
                    }
                    bcVar.c.setText(Html.fromHtml(com.baidu.tieba.util.bm.a(awVar.e(), (Color) null)));
                    com.baidu.tieba.util.bl.b(bcVar.b, an);
                    if (an == 0) {
                        com.baidu.tieba.util.bl.e(bcVar.e, (int) R.drawable.search_replay_back);
                        bcVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        bcVar.a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        bcVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        com.baidu.tieba.util.bl.e(bcVar.e, (int) R.drawable.search_replay_back_1);
                        bcVar.d.setTextColor(com.baidu.tieba.util.bl.c(an));
                        bcVar.a.setTextColor(com.baidu.tieba.util.bl.c(an));
                        bcVar.b.setTextColor(com.baidu.tieba.util.bl.a(an));
                        bcVar.c.setTextColor(com.baidu.tieba.util.bl.b(an));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    bbVar.b.setVisibility(0);
                    bbVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    bbVar.b.setVisibility(8);
                    bbVar.a.setText(this.b.getString(R.string.pre_page));
                }
                com.baidu.tieba.util.bl.b(bbVar.a, an);
            } else {
                if (this.c == 2) {
                    bbVar.b.setVisibility(0);
                    bbVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    bbVar.b.setVisibility(8);
                    bbVar.a.setText(this.b.getString(R.string.next_page));
                }
                com.baidu.tieba.util.bl.b(bbVar.a, an);
            }
        }
        return view;
    }
}
