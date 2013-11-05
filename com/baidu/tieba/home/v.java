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
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class v extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1371a;
    private ArrayList<MarkData> b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f = false;
    private ArrayList<ProgressBar> g = null;
    private View.OnClickListener h = null;
    private boolean i = false;
    private boolean j = true;

    public v(Context context) {
        this.f1371a = context;
        c(true);
        b();
    }

    public void a() {
        if (this.g != null) {
            Iterator<ProgressBar> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
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

    public void a(ArrayList<MarkData> arrayList) {
        this.b = arrayList;
        b();
        notifyDataSetChanged();
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

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        x xVar;
        y yVar;
        View view3;
        y yVar2 = null;
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.f1371a);
                if (getItemViewType(i) == 0) {
                    view = from.inflate(R.layout.home_mark_item, (ViewGroup) null);
                    y yVar3 = new y(this);
                    yVar3.b = (TextView) view.findViewById(R.id.home_lv_markitem_reply);
                    yVar3.c = (LinearLayout) view.findViewById(R.id.home_lv_markitem_content);
                    yVar3.d = (TextView) view.findViewById(R.id.home_lv_markitem_title);
                    yVar3.f = (TextView) view.findViewById(R.id.home_lv_markitem_author);
                    yVar3.g = (TextView) view.findViewById(R.id.forum_lv_nodata);
                    yVar3.i = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
                    yVar3.e = (ImageView) view.findViewById(R.id.mark_author_icon);
                    yVar3.f1373a = (ImageView) view.findViewById(R.id.mark_comment_icon);
                    yVar3.h = (ImageView) view.findViewById(R.id.new_mark_mention);
                    view.setTag(yVar3);
                    xVar = null;
                    yVar2 = yVar3;
                } else if (getItemViewType(i) == 1) {
                    x xVar2 = new x(this);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    xVar2.f1372a = (TextView) view.findViewById(R.id.page_text);
                    xVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.g == null) {
                        this.g = new ArrayList<>();
                    }
                    this.g.add(xVar2.b);
                    view.setTag(xVar2);
                    xVar = xVar2;
                } else {
                    xVar = null;
                }
                yVar = yVar2;
                view3 = view;
            } else if (getItemViewType(i) == 0) {
                yVar = (y) view.getTag();
                xVar = null;
                view3 = view;
            } else if (getItemViewType(i) == 1) {
                xVar = (x) view.getTag();
                yVar = null;
                view3 = view;
            } else {
                xVar = null;
                yVar = null;
                view3 = view;
            }
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            int as = TiebaApplication.g().as();
            if (getItemViewType(i) == 1) {
                if (this.i) {
                    xVar.b.setVisibility(0);
                    xVar.f1372a.setText(this.f1371a.getString(R.string.loading));
                } else if (!this.j) {
                    xVar.b.setVisibility(8);
                    xVar.f1372a.setText(this.f1371a.getString(R.string.no_more_mark));
                } else {
                    xVar.b.setVisibility(8);
                    xVar.f1372a.setText(this.f1371a.getString(R.string.load_more));
                }
                bb.b(xVar.f1372a, as);
            } else {
                if (this.d) {
                    yVar.b.setVisibility(8);
                    yVar.c.setVisibility(8);
                    yVar.i.setVisibility(8);
                    yVar.g.setVisibility(0);
                } else {
                    yVar.b.setVisibility(0);
                    yVar.c.setVisibility(0);
                    yVar.g.setVisibility(8);
                    if (this.f) {
                        yVar.i.setVisibility(0);
                    } else {
                        yVar.i.setVisibility(8);
                    }
                }
                if (TiebaApplication.g().as() == 1) {
                    yVar.b.setTextColor(-11446171);
                    yVar.d.setTextColor(bb.a(1));
                    yVar.f.setTextColor(-11446171);
                    yVar.g.setTextColor(bb.a(as));
                    yVar.f1373a.setBackgroundResource(R.drawable.icon_little_comment_1);
                    yVar.e.setBackgroundResource(R.drawable.icon_little_people_1);
                    yVar.h.setBackgroundResource(R.drawable.icon_new_tip_1);
                } else {
                    yVar.b.setTextColor(-5065030);
                    yVar.d.setTextColor(-14277082);
                    yVar.f.setTextColor(-5065030);
                    yVar.g.setTextColor(-4276546);
                    yVar.f1373a.setBackgroundResource(R.drawable.icon_little_comment_grey);
                    yVar.e.setBackgroundResource(R.drawable.icon_little_people);
                    yVar.h.setBackgroundResource(R.drawable.icon_new_tip);
                }
                Object item = getItem(i);
                if (item == null) {
                    return view3;
                }
                MarkData markData = (MarkData) item;
                if (markData.getNewCounts() > 0) {
                    yVar.h.setVisibility(0);
                } else {
                    yVar.h.setVisibility(8);
                }
                int replyNum = markData.getReplyNum();
                if (replyNum == 0) {
                    yVar.b.setVisibility(8);
                    yVar.f1373a.setVisibility(8);
                } else {
                    yVar.f1373a.setVisibility(0);
                    yVar.b.setVisibility(0);
                    yVar.b.setText(String.valueOf(replyNum));
                }
                yVar.d.setText(markData.getTitle());
                yVar.f.setText(markData.getAuthorName());
                yVar.i.setOnClickListener(this.h);
                yVar.i.setFocusable(false);
                yVar.i.setTag(Integer.valueOf(i));
            }
            return view3;
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            be.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
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
