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
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f = false;
    private View.OnClickListener g = null;

    public y(Context context, ArrayList arrayList) {
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
        if (size != 0) {
            this.c = size;
        } else if (!this.e) {
            this.c = 0;
        } else {
            this.c = 1;
            this.d = true;
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
        a();
    }

    public void a(boolean z) {
        this.e = z;
    }

    public ArrayList b() {
        return this.b;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
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
        z zVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.home_mark_item, (ViewGroup) null);
                try {
                    zVar = new z(this, null);
                    zVar.a = (TextView) view3.findViewById(R.id.home_lv_markitem_reply);
                    zVar.b = (LinearLayout) view3.findViewById(R.id.home_lv_markitem_content);
                    zVar.c = (TextView) view3.findViewById(R.id.home_lv_markitem_title);
                    zVar.d = (TextView) view3.findViewById(R.id.home_lv_markitem_author);
                    zVar.e = (TextView) view3.findViewById(R.id.forum_lv_nodata);
                    zVar.f = (ImageButton) view3.findViewById(R.id.home_lv_markitem_delete);
                    view3.setTag(zVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.c.ae.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                zVar = (z) view.getTag();
                view3 = view;
            }
            if (this.d) {
                zVar.a.setVisibility(8);
                zVar.b.setVisibility(8);
                zVar.f.setVisibility(8);
                zVar.e.setVisibility(0);
            } else {
                zVar.a.setVisibility(0);
                zVar.b.setVisibility(0);
                zVar.e.setVisibility(8);
                if (this.f) {
                    zVar.f.setVisibility(0);
                } else {
                    zVar.f.setVisibility(8);
                }
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            com.baidu.tieba.a.ae aeVar = (com.baidu.tieba.a.ae) item;
            int b = aeVar.b();
            if (b <= 999) {
                zVar.a.setText(String.valueOf(b));
            } else {
                zVar.a.setText("999+");
            }
            zVar.c.setText(aeVar.g());
            zVar.d.setText(aeVar.a());
            zVar.f.setOnClickListener(this.g);
            zVar.f.setFocusable(false);
            zVar.f.setTag(Integer.valueOf(i));
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
}
