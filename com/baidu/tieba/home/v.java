package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class v extends BaseAdapter {
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

    public v(Context context) {
        this.a = context;
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
        return (getItemId(i) >= 0 || this.d) ? 0 : 1;
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0126: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:37:0x0125 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0089 A[Catch: Exception -> 0x0124, TryCatch #0 {Exception -> 0x0124, blocks: (B:7:0x0018, B:8:0x007b, B:10:0x0089, B:12:0x008d, B:13:0x00a1, B:32:0x0109, B:34:0x010d, B:39:0x014a, B:40:0x0161, B:42:0x0165, B:43:0x0180, B:45:0x018a, B:46:0x01be, B:54:0x021e, B:56:0x0226, B:57:0x0234, B:58:0x025f, B:60:0x026f, B:61:0x0279, B:53:0x01ed, B:49:0x01c7, B:51:0x01de, B:52:0x01e5, B:20:0x00bf, B:22:0x00d6, B:23:0x00dd), top: B:66:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0161 A[Catch: Exception -> 0x0124, TryCatch #0 {Exception -> 0x0124, blocks: (B:7:0x0018, B:8:0x007b, B:10:0x0089, B:12:0x008d, B:13:0x00a1, B:32:0x0109, B:34:0x010d, B:39:0x014a, B:40:0x0161, B:42:0x0165, B:43:0x0180, B:45:0x018a, B:46:0x01be, B:54:0x021e, B:56:0x0226, B:57:0x0234, B:58:0x025f, B:60:0x026f, B:61:0x0279, B:53:0x01ed, B:49:0x01c7, B:51:0x01de, B:52:0x01e5, B:20:0x00bf, B:22:0x00d6, B:23:0x00dd), top: B:66:0x0002 }] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        w wVar;
        View view4;
        x xVar = null;
        try {
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    if (getItemViewType(i) == 0) {
                        view4 = from.inflate(R.layout.home_mark_item, (ViewGroup) null);
                        x xVar2 = new x(this, null);
                        xVar2.b = (TextView) view4.findViewById(R.id.home_lv_markitem_reply);
                        xVar2.c = (LinearLayout) view4.findViewById(R.id.home_lv_markitem_content);
                        xVar2.d = (TextView) view4.findViewById(R.id.home_lv_markitem_title);
                        xVar2.f = (TextView) view4.findViewById(R.id.home_lv_markitem_author);
                        xVar2.g = (TextView) view4.findViewById(R.id.forum_lv_nodata);
                        xVar2.h = (ImageButton) view4.findViewById(R.id.home_lv_markitem_delete);
                        xVar2.e = (ImageView) view4.findViewById(R.id.mark_author_icon);
                        xVar2.a = (ImageView) view4.findViewById(R.id.mark_comment_icon);
                        view4.setTag(xVar2);
                        wVar = null;
                        xVar = xVar2;
                    } else {
                        if (getItemViewType(i) == 1) {
                            w wVar2 = new w(this, null);
                            view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                            wVar2.a = (TextView) view4.findViewById(R.id.page_text);
                            wVar2.b = (ProgressBar) view4.findViewById(R.id.progress);
                            if (this.g == null) {
                                this.g = new ArrayList();
                            }
                            this.g.add(wVar2.b);
                            view4.setTag(wVar2);
                            wVar = wVar2;
                        }
                        wVar = null;
                        view4 = view;
                    }
                    int as = TiebaApplication.e().as();
                    if (getItemViewType(i) != 1) {
                        if (this.i) {
                            wVar.b.setVisibility(0);
                            wVar.a.setText(this.a.getString(R.string.loading));
                        } else if (!this.j) {
                            wVar.b.setVisibility(8);
                            wVar.a.setText(this.a.getString(R.string.no_more_mark));
                        } else {
                            wVar.b.setVisibility(8);
                            wVar.a.setText(this.a.getString(R.string.load_more));
                        }
                        com.baidu.tieba.d.ac.b(wVar.a, as);
                        return view4;
                    }
                    if (this.d) {
                        xVar.b.setVisibility(8);
                        xVar.c.setVisibility(8);
                        xVar.h.setVisibility(8);
                        xVar.g.setVisibility(0);
                    } else {
                        xVar.b.setVisibility(0);
                        xVar.c.setVisibility(0);
                        xVar.g.setVisibility(8);
                        if (this.f) {
                            xVar.h.setVisibility(0);
                        } else {
                            xVar.h.setVisibility(8);
                        }
                    }
                    if (TiebaApplication.e().as() == 1) {
                        xVar.b.setTextColor(-11446171);
                        xVar.d.setTextColor(com.baidu.tieba.d.ac.a(1));
                        xVar.f.setTextColor(-11446171);
                        xVar.g.setTextColor(com.baidu.tieba.d.ac.a(1));
                        xVar.a.setBackgroundResource(R.drawable.icon_little_comment_1);
                        xVar.e.setBackgroundResource(R.drawable.icon_little_people_1);
                    } else {
                        xVar.b.setTextColor(-5065030);
                        xVar.d.setTextColor(-14277082);
                        xVar.f.setTextColor(-5065030);
                        xVar.g.setTextColor(-14277082);
                        xVar.a.setBackgroundResource(R.drawable.icon_little_comment_grey);
                        xVar.e.setBackgroundResource(R.drawable.icon_little_people);
                    }
                    Object item = getItem(i);
                    if (item == null) {
                        return view4;
                    }
                    com.baidu.tieba.a.af afVar = (com.baidu.tieba.a.af) item;
                    int b = afVar.b();
                    if (b == 0) {
                        xVar.b.setVisibility(8);
                        xVar.a.setVisibility(8);
                    } else {
                        xVar.a.setVisibility(0);
                        xVar.b.setVisibility(0);
                        if (b <= 999) {
                            xVar.b.setText(String.valueOf(b));
                        } else {
                            xVar.b.setText("999+");
                        }
                    }
                    xVar.d.setText(afVar.d());
                    xVar.f.setText(afVar.a());
                    xVar.h.setOnClickListener(this.h);
                    xVar.h.setFocusable(false);
                    xVar.h.setTag(Integer.valueOf(i));
                    return view4;
                }
                if (getItemViewType(i) == 0) {
                    view4 = view;
                    wVar = null;
                    xVar = (x) view.getTag();
                } else {
                    if (getItemViewType(i) == 1) {
                        wVar = (w) view.getTag();
                        view4 = view;
                    }
                    wVar = null;
                    view4 = view;
                }
                int as2 = TiebaApplication.e().as();
                if (getItemViewType(i) != 1) {
                }
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.d.ae.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
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

    public boolean c() {
        return this.f;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }
}
