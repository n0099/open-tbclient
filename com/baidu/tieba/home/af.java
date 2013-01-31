package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f = false;
    private View.OnClickListener g = null;

    public af(Context context, ArrayList arrayList) {
        this.a = context;
        this.b = arrayList;
        a(true);
        a();
    }

    public void a() {
        this.d = false;
        if (this.b == null) {
            this.c = 0;
            return;
        }
        int size = this.b.size();
        if (size == 0) {
            if (this.e) {
                this.c = 1;
                this.d = true;
                return;
            }
            this.c = 0;
            return;
        }
        this.c = size;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
        a();
    }

    public ArrayList b() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count;
        if (!this.d && (count = getCount()) > 0 && i < count) {
            return this.b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        ag agVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.home_mark_item, (ViewGroup) null);
                try {
                    agVar = new ag(this, null);
                    agVar.a = (TextView) view3.findViewById(R.id.home_lv_markitem_reply);
                    agVar.b = (LinearLayout) view3.findViewById(R.id.home_lv_markitem_content);
                    agVar.c = (TextView) view3.findViewById(R.id.home_lv_markitem_title);
                    agVar.d = (TextView) view3.findViewById(R.id.home_lv_markitem_author);
                    agVar.e = (TextView) view3.findViewById(R.id.forum_lv_nodata);
                    agVar.f = (ImageButton) view3.findViewById(R.id.home_lv_markitem_delete);
                    view3.setTag(agVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.c.af.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                agVar = (ag) view.getTag();
                view3 = view;
            }
            if (this.d) {
                agVar.a.setVisibility(8);
                agVar.b.setVisibility(8);
                agVar.f.setVisibility(8);
                agVar.e.setVisibility(0);
            } else {
                agVar.a.setVisibility(0);
                agVar.b.setVisibility(0);
                agVar.e.setVisibility(8);
                if (this.f) {
                    agVar.f.setVisibility(0);
                } else {
                    agVar.f.setVisibility(8);
                }
            }
            if (TiebaApplication.b().af() == 1) {
                agVar.a.setTextColor(com.baidu.tieba.c.ad.b(1));
                agVar.c.setTextColor(com.baidu.tieba.c.ad.a(1));
                agVar.d.setTextColor(com.baidu.tieba.c.ad.b(1));
                agVar.e.setTextColor(com.baidu.tieba.c.ad.a(1));
            } else {
                agVar.a.setTextColor(-11250603);
                agVar.c.setTextColor(-16777216);
                agVar.d.setTextColor(-9276814);
                agVar.e.setTextColor(-4276546);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            com.baidu.tieba.a.af afVar = (com.baidu.tieba.a.af) item;
            int b = afVar.b();
            if (b <= 999) {
                agVar.a.setText(String.valueOf(b));
            } else {
                agVar.a.setText("999+");
            }
            agVar.c.setText(afVar.g());
            agVar.d.setText(afVar.a());
            agVar.f.setOnClickListener(this.g);
            agVar.f.setFocusable(false);
            agVar.f.setTag(Integer.valueOf(i));
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.d) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
    }

    public void a(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }
}
