package com.baidu.tieba.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.b.f b = null;
    private Boolean c = false;
    private Boolean d = true;
    private Boolean e = false;
    private Boolean f;
    private String g;
    private View.OnClickListener h;
    private View.OnLongClickListener i;
    private View.OnClickListener j;
    private View.OnClickListener k;
    private ArrayList l;
    private int m;

    public f(Context context, com.baidu.tieba.b.f fVar) {
        this.f = false;
        this.m = 10;
        this.a = context;
        a(fVar);
        this.g = this.a.getText(R.string.grade).toString();
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = com.baidu.tieba.c.ag.a(this.a, 10.0f);
        this.l = new ArrayList();
        this.f = Boolean.valueOf(TiebaApplication.a().n() != null);
    }

    private int a(int i) {
        if (this.c.booleanValue()) {
            if (this.b == null || this.b.c() == null || this.b.c().size() == 0) {
                return 4;
            }
            return (i == 5 && this.e.booleanValue() && !this.f.booleanValue()) ? 6 : 5;
        }
        return 1;
    }

    private void a(com.baidu.tieba.a.ac acVar, g gVar) {
        if (acVar == null || gVar == null) {
            return;
        }
        int f = acVar.f();
        gVar.b.setTag(acVar);
        gVar.c.setText(acVar.b());
        if (f == 0 || acVar.d() == 0) {
            gVar.d.setVisibility(8);
            gVar.e.setVisibility(8);
            return;
        }
        gVar.d.setVisibility(0);
        gVar.e.setVisibility(0);
        if (1 <= f && f <= 3) {
            gVar.d.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.home_grade_1));
        } else if (4 <= f && f <= 9) {
            gVar.d.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.home_grade_2));
        } else if (10 > f || f > 15) {
            gVar.d.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.home_grade_4));
        } else {
            gVar.d.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.home_grade_3));
        }
        gVar.e.setText(String.valueOf(acVar.f()).concat(this.g));
    }

    public void a() {
        if (this.l == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.l.size()) {
                this.l.clear();
                return;
            }
            try {
                ((ProgressBar) this.l.get(i2)).setVisibility(8);
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
            }
            i = i2 + 1;
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.i = onLongClickListener;
    }

    public void a(com.baidu.tieba.b.f fVar) {
        this.b = fVar;
        if (fVar == null || fVar.c() == null || fVar.c().size() <= 8) {
            this.e = false;
        } else {
            this.e = true;
        }
        if (fVar != null) {
            if (fVar.d() == null || fVar.d().size() == 0) {
                this.f = true;
            }
        }
    }

    public void a(Boolean bool) {
        this.c = bool;
        this.d = false;
    }

    public void b() {
        this.f = true;
    }

    public void b(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public int c() {
        if (this.b == null || this.b.d() == null) {
            return 3;
        }
        return this.b.d().size() == 0 ? (getCount() - this.b.d().size()) - 1 : getCount() - this.b.d().size();
    }

    public void c(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 2;
        if (this.b == null) {
            return 1;
        }
        if (this.c.booleanValue() && this.b.c() != null && this.b.c().size() > 0) {
            int size = this.b.c().size();
            i = size > 8 ? this.f.booleanValue() ? (size % 2) + 1 + (size / 2) : 6 : (size % 2) + 1 + (size / 2);
        }
        return (this.b.d() == null || this.b.d().size() <= 0) ? i : i + this.b.d().size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 3) {
            int c = i - c();
            if (this.b != null && this.b.d() != null && c >= 0 && this.b.d().size() > c) {
                return this.b.d().get(c);
            }
        }
        return Integer.valueOf(itemViewType);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int c = c();
        if (i == 0) {
            return 0;
        }
        if (this.b != null && this.b.d() != null && this.b.d().size() > 0) {
            if (i == c - 1) {
                return 2;
            }
            if (i >= c) {
                return 3;
            }
        }
        return a(i);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0047: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:20:0x0046 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        int itemViewType;
        View view3;
        g gVar;
        h hVar;
        View view4;
        try {
            itemViewType = getItemViewType(i);
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (itemViewType == 0) {
                    return from.inflate(R.layout.enter_forum_enter, (ViewGroup) null);
                }
                if (itemViewType == 1) {
                    View inflate = from.inflate(R.layout.enter_forum_login, (ViewGroup) null);
                    ((Button) inflate.findViewById(R.id.want_login)).setOnClickListener(this.j);
                    if (this.d.booleanValue()) {
                        inflate.setVisibility(4);
                    } else {
                        inflate.setVisibility(0);
                    }
                    return inflate;
                } else if (itemViewType == 2) {
                    return from.inflate(R.layout.enter_forum_recommend_tip, (ViewGroup) null);
                } else {
                    if (itemViewType == 4) {
                        return from.inflate(R.layout.home_like_nodata_item, (ViewGroup) null);
                    }
                    if (itemViewType == 6) {
                        return from.inflate(R.layout.enter_forum_goon_show_like, (ViewGroup) null);
                    }
                    if (itemViewType == 3) {
                        view4 = from.inflate(R.layout.enter_forum_recommand_item, (ViewGroup) null);
                        h hVar2 = new h(this, null);
                        hVar2.a = (RelativeLayout) view4;
                        hVar2.b = (TextView) view4.findViewById(R.id.recommend_forum_name);
                        hVar2.c = (TextView) view4.findViewById(R.id.member_count);
                        hVar2.d = (TextView) view4.findViewById(R.id.forum_abstract);
                        hVar2.e = (ImageView) view4.findViewById(R.id.recommend_like);
                        hVar2.e.setOnClickListener(this.k);
                        view4.setTag(hVar2);
                        gVar = null;
                        hVar = hVar2;
                    } else if (itemViewType == 5) {
                        view4 = from.inflate(R.layout.home_like_item, (ViewGroup) null);
                        g gVar2 = new g(this, null);
                        gVar2.a = (LinearLayout) view4;
                        gVar2.b = (LinearLayout) view4.findViewById(R.id.first);
                        gVar2.b.setOnClickListener(this.h);
                        gVar2.b.setOnLongClickListener(this.i);
                        gVar2.c = (TextView) view4.findViewById(R.id.home_lv_like_forum1);
                        gVar2.d = (ImageView) view4.findViewById(R.id.home_lv_like_gimg1);
                        gVar2.e = (TextView) view4.findViewById(R.id.forum_lv_like_grade1);
                        gVar2.f = new g(this, null);
                        gVar2.f.b = (LinearLayout) view4.findViewById(R.id.second);
                        gVar2.f.b.setOnClickListener(this.h);
                        gVar2.f.b.setOnLongClickListener(this.i);
                        gVar2.f.c = (TextView) view4.findViewById(R.id.home_lv_like_forum2);
                        gVar2.f.d = (ImageView) view4.findViewById(R.id.home_lv_like_gimg2);
                        gVar2.f.e = (TextView) view4.findViewById(R.id.forum_lv_like_grade2);
                        view4.setTag(gVar2);
                        gVar = gVar2;
                        hVar = null;
                    } else {
                        gVar = null;
                        view4 = view;
                        hVar = null;
                    }
                }
            } else {
                h hVar3 = itemViewType == 3 ? (h) view.getTag() : null;
                if (itemViewType == 5) {
                    hVar = hVar3;
                    gVar = (g) view.getTag();
                    view4 = view;
                } else {
                    gVar = null;
                    hVar = hVar3;
                    view4 = view;
                }
            }
            Resources resources = this.a.getResources();
            if (itemViewType == 3 && hVar != null && this.b.d() != null) {
                Object item = getItem(i);
                com.baidu.tieba.a.ac acVar = null;
                if (item != null && (item instanceof com.baidu.tieba.a.ac)) {
                    acVar = (com.baidu.tieba.a.ac) item;
                }
                if (acVar != null) {
                    hVar.b.setText(String.valueOf(acVar.b()) + resources.getString(R.string.forum));
                    hVar.c.setText(MessageFormat.format(resources.getString(R.string.forum_like_memeber), Integer.valueOf(acVar.c())));
                    hVar.d.setText(acVar.h());
                    hVar.e.setVisibility(this.c.booleanValue() ? 0 : 4);
                    hVar.a.setVisibility(0);
                    hVar.e.setTag(acVar);
                } else {
                    hVar.a.setVisibility(4);
                }
            }
            if (itemViewType == 5 && gVar != null && this.b.c() != null) {
                if (i == 1) {
                    gVar.a.setPadding(0, this.m, 0, this.m);
                } else {
                    gVar.a.setPadding(0, 0, 0, this.m);
                }
                if (i >= 1) {
                    if ((i - 1) * 2 < this.b.c().size()) {
                        a((com.baidu.tieba.a.ac) this.b.c().get((i - 1) * 2), gVar);
                    }
                    if (((i - 1) * 2) + 1 >= this.b.c().size()) {
                        gVar.f.b.setVisibility(4);
                        return view4;
                    }
                    gVar.f.b.setVisibility(0);
                    a((com.baidu.tieba.a.ac) this.b.c().get(((i - 1) * 2) + 1), gVar.f);
                    return view4;
                }
            }
            return view4;
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            com.baidu.tieba.c.ae.b(getClass().getName(), "getView", exc.getMessage());
            return view2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 7;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItemViewType(i) == 3 || getItemViewType(i) == 6 || getItemViewType(i) == 0;
    }
}
