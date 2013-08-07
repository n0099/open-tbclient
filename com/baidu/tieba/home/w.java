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
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class w extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1164a;
    private ArrayList b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f = false;
    private ArrayList g = null;
    private View.OnClickListener h = null;
    private boolean i = false;
    private boolean j = true;

    public w(Context context) {
        this.f1164a = context;
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
        x xVar;
        View view4;
        y yVar = null;
        try {
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.f1164a);
                    if (getItemViewType(i) == 0) {
                        view4 = from.inflate(R.layout.home_mark_item, (ViewGroup) null);
                        y yVar2 = new y(this, null);
                        yVar2.b = (TextView) view4.findViewById(R.id.home_lv_markitem_reply);
                        yVar2.c = (LinearLayout) view4.findViewById(R.id.home_lv_markitem_content);
                        yVar2.d = (TextView) view4.findViewById(R.id.home_lv_markitem_title);
                        yVar2.f = (TextView) view4.findViewById(R.id.home_lv_markitem_author);
                        yVar2.g = (TextView) view4.findViewById(R.id.forum_lv_nodata);
                        yVar2.h = (ImageButton) view4.findViewById(R.id.home_lv_markitem_delete);
                        yVar2.e = (ImageView) view4.findViewById(R.id.mark_author_icon);
                        yVar2.f1166a = (ImageView) view4.findViewById(R.id.mark_comment_icon);
                        view4.setTag(yVar2);
                        xVar = null;
                        yVar = yVar2;
                    } else {
                        if (getItemViewType(i) == 1) {
                            x xVar2 = new x(this, null);
                            view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                            xVar2.f1165a = (TextView) view4.findViewById(R.id.page_text);
                            xVar2.b = (ProgressBar) view4.findViewById(R.id.progress);
                            if (this.g == null) {
                                this.g = new ArrayList();
                            }
                            this.g.add(xVar2.b);
                            view4.setTag(xVar2);
                            xVar = xVar2;
                        }
                        xVar = null;
                        view4 = view;
                    }
                    int au = TiebaApplication.f().au();
                    if (getItemViewType(i) != 1) {
                        if (this.i) {
                            xVar.b.setVisibility(0);
                            xVar.f1165a.setText(this.f1164a.getString(R.string.loading));
                        } else if (!this.j) {
                            xVar.b.setVisibility(8);
                            xVar.f1165a.setText(this.f1164a.getString(R.string.no_more_mark));
                        } else {
                            xVar.b.setVisibility(8);
                            xVar.f1165a.setText(this.f1164a.getString(R.string.load_more));
                        }
                        com.baidu.tieba.util.ah.b(xVar.f1165a, au);
                        return view4;
                    }
                    if (this.d) {
                        yVar.b.setVisibility(8);
                        yVar.c.setVisibility(8);
                        yVar.h.setVisibility(8);
                        yVar.g.setVisibility(0);
                    } else {
                        yVar.b.setVisibility(0);
                        yVar.c.setVisibility(0);
                        yVar.g.setVisibility(8);
                        if (this.f) {
                            yVar.h.setVisibility(0);
                        } else {
                            yVar.h.setVisibility(8);
                        }
                    }
                    if (TiebaApplication.f().au() == 1) {
                        yVar.b.setTextColor(-11446171);
                        yVar.d.setTextColor(com.baidu.tieba.util.ah.a(1));
                        yVar.f.setTextColor(-11446171);
                        yVar.g.setTextColor(com.baidu.tieba.util.ah.a(1));
                        yVar.f1166a.setBackgroundResource(R.drawable.icon_little_comment_1);
                        yVar.e.setBackgroundResource(R.drawable.icon_little_people_1);
                    } else {
                        yVar.b.setTextColor(-5065030);
                        yVar.d.setTextColor(-14277082);
                        yVar.f.setTextColor(-5065030);
                        yVar.g.setTextColor(-14277082);
                        yVar.f1166a.setBackgroundResource(R.drawable.icon_little_comment_grey);
                        yVar.e.setBackgroundResource(R.drawable.icon_little_people);
                    }
                    Object item = getItem(i);
                    if (item == null) {
                        return view4;
                    }
                    MarkData markData = (MarkData) item;
                    int replyNum = markData.getReplyNum();
                    if (replyNum == 0) {
                        yVar.b.setVisibility(8);
                        yVar.f1166a.setVisibility(8);
                    } else {
                        yVar.f1166a.setVisibility(0);
                        yVar.b.setVisibility(0);
                        if (replyNum <= 999) {
                            yVar.b.setText(String.valueOf(replyNum));
                        } else {
                            yVar.b.setText("999+");
                        }
                    }
                    yVar.d.setText(markData.getTitle());
                    yVar.f.setText(markData.getAuthorName());
                    yVar.h.setOnClickListener(this.h);
                    yVar.h.setFocusable(false);
                    yVar.h.setTag(Integer.valueOf(i));
                    return view4;
                }
                if (getItemViewType(i) == 0) {
                    view4 = view;
                    xVar = null;
                    yVar = (y) view.getTag();
                } else {
                    if (getItemViewType(i) == 1) {
                        xVar = (x) view.getTag();
                        view4 = view;
                    }
                    xVar = null;
                    view4 = view;
                }
                int au2 = TiebaApplication.f().au();
                if (getItemViewType(i) != 1) {
                }
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.util.aj.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
            com.baidu.tieba.util.aj.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
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
