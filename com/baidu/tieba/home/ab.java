package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f = false;
    private ArrayList g = null;
    private View.OnClickListener h = null;
    private boolean i = false;
    private boolean j = true;

    public ab(Context context, ArrayList arrayList) {
        this.a = context;
        this.b = arrayList;
        c(true);
        b();
    }

    public void a() {
        if (this.g != null) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                ((ProgressBar) it.next()).setVisibility(8);
            }
        }
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void b() {
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

    public void b(boolean z) {
        this.i = z;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
        b();
    }

    public ArrayList c() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.b == null || this.b.size() == 0) ? this.c : this.c + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((getItemId(i) > 0L ? 1 : (getItemId(i) == 0L ? 0 : -1)) >= 0) | this.d ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.d && (size = this.b.size()) > 0 && i < size) {
            return this.b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.b == null || i < this.b.size()) {
            return i;
        }
        return -1L;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0110: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:37:0x010f */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0073 A[Catch: Exception -> 0x010e, TryCatch #0 {Exception -> 0x010e, blocks: (B:7:0x0018, B:8:0x0065, B:10:0x0073, B:12:0x0077, B:13:0x008b, B:32:0x00f3, B:34:0x00f7, B:39:0x0134, B:40:0x014b, B:42:0x014f, B:43:0x016a, B:45:0x0174, B:46:0x019c, B:54:0x01eb, B:56:0x01f5, B:57:0x01fe, B:58:0x0229, B:53:0x01cb, B:49:0x01a5, B:51:0x01bc, B:52:0x01c3, B:20:0x00a9, B:22:0x00c0, B:23:0x00c7), top: B:63:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014b A[Catch: Exception -> 0x010e, TryCatch #0 {Exception -> 0x010e, blocks: (B:7:0x0018, B:8:0x0065, B:10:0x0073, B:12:0x0077, B:13:0x008b, B:32:0x00f3, B:34:0x00f7, B:39:0x0134, B:40:0x014b, B:42:0x014f, B:43:0x016a, B:45:0x0174, B:46:0x019c, B:54:0x01eb, B:56:0x01f5, B:57:0x01fe, B:58:0x0229, B:53:0x01cb, B:49:0x01a5, B:51:0x01bc, B:52:0x01c3, B:20:0x00a9, B:22:0x00c0, B:23:0x00c7), top: B:63:0x0002 }] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        ac acVar;
        View view4;
        ad adVar = null;
        try {
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    if (getItemViewType(i) == 0) {
                        view4 = from.inflate(R.layout.home_mark_item, (ViewGroup) null);
                        ad adVar2 = new ad(this, null);
                        adVar2.a = (TextView) view4.findViewById(R.id.home_lv_markitem_reply);
                        adVar2.b = (LinearLayout) view4.findViewById(R.id.home_lv_markitem_content);
                        adVar2.c = (TextView) view4.findViewById(R.id.home_lv_markitem_title);
                        adVar2.d = (TextView) view4.findViewById(R.id.home_lv_markitem_author);
                        adVar2.e = (TextView) view4.findViewById(R.id.forum_lv_nodata);
                        adVar2.f = (ImageButton) view4.findViewById(R.id.home_lv_markitem_delete);
                        view4.setTag(adVar2);
                        acVar = null;
                        adVar = adVar2;
                    } else {
                        if (getItemViewType(i) == 1) {
                            ac acVar2 = new ac(this, null);
                            view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                            acVar2.a = (TextView) view4.findViewById(R.id.page_text);
                            acVar2.b = (ProgressBar) view4.findViewById(R.id.progress);
                            if (this.g == null) {
                                this.g = new ArrayList();
                            }
                            this.g.add(acVar2.b);
                            view4.setTag(acVar2);
                            acVar = acVar2;
                        }
                        acVar = null;
                        view4 = view;
                    }
                    int ah = TiebaApplication.b().ah();
                    if (getItemViewType(i) != 1) {
                        if (this.i) {
                            acVar.b.setVisibility(0);
                            acVar.a.setText(this.a.getString(R.string.loading));
                        } else if (!this.j) {
                            acVar.b.setVisibility(8);
                            acVar.a.setText(this.a.getString(R.string.no_more_mark));
                        } else {
                            acVar.b.setVisibility(8);
                            acVar.a.setText(this.a.getString(R.string.load_more));
                        }
                        com.baidu.tieba.c.ae.b(acVar.a, ah);
                        return view4;
                    }
                    if (this.d) {
                        adVar.a.setVisibility(8);
                        adVar.b.setVisibility(8);
                        adVar.f.setVisibility(8);
                        adVar.e.setVisibility(0);
                    } else {
                        adVar.a.setVisibility(0);
                        adVar.b.setVisibility(0);
                        adVar.e.setVisibility(8);
                        if (this.f) {
                            adVar.f.setVisibility(0);
                        } else {
                            adVar.f.setVisibility(8);
                        }
                    }
                    if (TiebaApplication.b().ah() == 1) {
                        adVar.a.setTextColor(com.baidu.tieba.c.ae.b(1));
                        adVar.c.setTextColor(com.baidu.tieba.c.ae.a(1));
                        adVar.d.setTextColor(com.baidu.tieba.c.ae.b(1));
                        adVar.e.setTextColor(com.baidu.tieba.c.ae.a(1));
                    } else {
                        adVar.a.setTextColor(-11250603);
                        adVar.c.setTextColor(-16777216);
                        adVar.d.setTextColor(-9276814);
                        adVar.e.setTextColor(-4276546);
                    }
                    Object item = getItem(i);
                    if (item == null) {
                        return view4;
                    }
                    com.baidu.tieba.a.ae aeVar = (com.baidu.tieba.a.ae) item;
                    int b = aeVar.b();
                    if (b <= 999) {
                        adVar.a.setText(String.valueOf(b));
                    } else {
                        adVar.a.setText("999+");
                    }
                    adVar.c.setText(aeVar.d());
                    adVar.d.setText(aeVar.a());
                    adVar.f.setOnClickListener(this.h);
                    adVar.f.setFocusable(false);
                    adVar.f.setTag(Integer.valueOf(i));
                    return view4;
                }
                if (getItemViewType(i) == 0) {
                    view4 = view;
                    acVar = null;
                    adVar = (ad) view.getTag();
                } else {
                    if (getItemViewType(i) == 1) {
                        acVar = (ac) view.getTag();
                        view4 = view;
                    }
                    acVar = null;
                    view4 = view;
                }
                int ah2 = TiebaApplication.b().ah();
                if (getItemViewType(i) != 1) {
                }
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
            com.baidu.tieba.c.ag.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
            return view2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.d || (!this.j && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void c(boolean z) {
        this.e = z;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public boolean d() {
        return this.f;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }
}
