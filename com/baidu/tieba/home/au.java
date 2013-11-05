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
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.bc;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class au extends BaseAdapter {
    private Context b;

    /* renamed from: a  reason: collision with root package name */
    private SearchPostModel f1346a = null;
    private int c = 0;
    private ArrayList<ProgressBar> d = null;

    public au(Context context) {
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
        if (this.f1346a == null) {
            return false;
        }
        return this.f1346a.hasPre();
    }

    public boolean c() {
        if (this.f1346a == null) {
            return false;
        }
        return this.f1346a.hasMore();
    }

    public void a(SearchPostModel searchPostModel) {
        this.f1346a = searchPostModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1346a == null || this.f1346a.getData() == null) {
            return 0;
        }
        int size = this.f1346a.getData().size();
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
        if (this.f1346a == null || this.f1346a.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.f1346a.getData().size()) {
            return null;
        }
        return this.f1346a.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f1346a == null || this.f1346a.getData() == null) {
            return -1L;
        }
        if (b()) {
            if (i <= this.f1346a.getData().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.f1346a.getData().size()) {
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
        aw awVar;
        ax axVar;
        View inflate;
        if (this.f1346a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    axVar = new ax(this);
                    inflate = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    axVar.c = (TextView) inflate.findViewById(R.id.title);
                    axVar.b = (TextView) inflate.findViewById(R.id.content);
                    axVar.d = (TextView) inflate.findViewById(R.id.forum);
                    axVar.f1348a = (TextView) inflate.findViewById(R.id.time);
                    axVar.e = (LinearLayout) inflate.findViewById(R.id.content_layout);
                    inflate.setTag(axVar);
                    awVar = null;
                } else {
                    aw awVar2 = new aw(this);
                    inflate = from.inflate(R.layout.page_item, (ViewGroup) null);
                    awVar2.f1347a = (TextView) inflate.findViewById(R.id.page_text);
                    awVar2.b = (ProgressBar) inflate.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList<>();
                    }
                    this.d.add(awVar2.b);
                    inflate.setTag(awVar2);
                    awVar = awVar2;
                    axVar = null;
                }
                view = inflate;
            } else if (getItemViewType(i) == 0) {
                axVar = (ax) view.getTag();
                awVar = null;
            } else {
                awVar = (aw) view.getTag();
                axVar = null;
            }
            int as = TiebaApplication.g().as();
            if (getItemViewType(i) == 0) {
                com.baidu.tieba.data.ax axVar2 = (com.baidu.tieba.data.ax) getItem(i);
                if (axVar2 != null) {
                    axVar.d.setText(axVar2.d() + this.b.getString(R.string.bar));
                    axVar.f1348a.setText(bc.g(new Date(axVar2.g())));
                    if (axVar2.f() == null || axVar2.f().length() < 1) {
                        axVar.e.setVisibility(8);
                    } else {
                        axVar.e.setVisibility(0);
                        axVar.b.setText(Html.fromHtml(bc.a(axVar2.f(), (Color) null)));
                    }
                    axVar.c.setText(Html.fromHtml(bc.a(axVar2.e(), (Color) null)));
                    bb.b(axVar.b, as);
                    if (as == 0) {
                        bb.e(axVar.e, (int) R.drawable.search_replay_back);
                        axVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        axVar.f1348a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        axVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        bb.e(axVar.e, (int) R.drawable.search_replay_back_1);
                        axVar.d.setTextColor(bb.c(as));
                        axVar.f1348a.setTextColor(bb.c(as));
                        axVar.b.setTextColor(bb.a(as));
                        axVar.c.setTextColor(bb.b(as));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    awVar.b.setVisibility(0);
                    awVar.f1347a.setText(this.b.getString(R.string.loading));
                } else {
                    awVar.b.setVisibility(8);
                    awVar.f1347a.setText(this.b.getString(R.string.pre_page));
                }
                bb.b(awVar.f1347a, as);
            } else {
                if (this.c == 2) {
                    awVar.b.setVisibility(0);
                    awVar.f1347a.setText(this.b.getString(R.string.loading));
                } else {
                    awVar.b.setVisibility(8);
                    awVar.f1347a.setText(this.b.getString(R.string.next_page));
                }
                bb.b(awVar.f1347a, as);
            }
        }
        return view;
    }
}
