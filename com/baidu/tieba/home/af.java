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
public class af extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1151a;
    private ArrayList b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f = false;
    private ArrayList g = null;
    private View.OnClickListener h = null;
    private boolean i = false;
    private boolean j = true;

    public af(Context context) {
        this.f1151a = context;
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0131: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:37:0x0130 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0094 A[Catch: Exception -> 0x012f, TryCatch #0 {Exception -> 0x012f, blocks: (B:7:0x0018, B:8:0x0086, B:10:0x0094, B:12:0x0098, B:13:0x00ac, B:32:0x0114, B:34:0x0118, B:39:0x0155, B:40:0x016c, B:42:0x0170, B:43:0x018b, B:45:0x0195, B:46:0x01d0, B:54:0x0238, B:56:0x0240, B:57:0x0246, B:59:0x024c, B:60:0x025a, B:62:0x028d, B:61:0x0285, B:53:0x01ff, B:49:0x01d9, B:51:0x01f0, B:52:0x01f7, B:20:0x00ca, B:22:0x00e1, B:23:0x00e8), top: B:67:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x016c A[Catch: Exception -> 0x012f, TryCatch #0 {Exception -> 0x012f, blocks: (B:7:0x0018, B:8:0x0086, B:10:0x0094, B:12:0x0098, B:13:0x00ac, B:32:0x0114, B:34:0x0118, B:39:0x0155, B:40:0x016c, B:42:0x0170, B:43:0x018b, B:45:0x0195, B:46:0x01d0, B:54:0x0238, B:56:0x0240, B:57:0x0246, B:59:0x024c, B:60:0x025a, B:62:0x028d, B:61:0x0285, B:53:0x01ff, B:49:0x01d9, B:51:0x01f0, B:52:0x01f7, B:20:0x00ca, B:22:0x00e1, B:23:0x00e8), top: B:67:0x0002 }] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        ag agVar;
        View view4;
        ah ahVar = null;
        try {
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.f1151a);
                    if (getItemViewType(i) == 0) {
                        view4 = from.inflate(R.layout.home_mark_item, (ViewGroup) null);
                        ah ahVar2 = new ah(this, null);
                        ahVar2.b = (TextView) view4.findViewById(R.id.home_lv_markitem_reply);
                        ahVar2.c = (LinearLayout) view4.findViewById(R.id.home_lv_markitem_content);
                        ahVar2.d = (TextView) view4.findViewById(R.id.home_lv_markitem_title);
                        ahVar2.f = (TextView) view4.findViewById(R.id.home_lv_markitem_author);
                        ahVar2.g = (TextView) view4.findViewById(R.id.forum_lv_nodata);
                        ahVar2.i = (ImageButton) view4.findViewById(R.id.home_lv_markitem_delete);
                        ahVar2.e = (ImageView) view4.findViewById(R.id.mark_author_icon);
                        ahVar2.f1153a = (ImageView) view4.findViewById(R.id.mark_comment_icon);
                        ahVar2.h = (ImageView) view4.findViewById(R.id.new_mark_mention);
                        view4.setTag(ahVar2);
                        agVar = null;
                        ahVar = ahVar2;
                    } else {
                        if (getItemViewType(i) == 1) {
                            ag agVar2 = new ag(this, null);
                            view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                            agVar2.f1152a = (TextView) view4.findViewById(R.id.page_text);
                            agVar2.b = (ProgressBar) view4.findViewById(R.id.progress);
                            if (this.g == null) {
                                this.g = new ArrayList();
                            }
                            this.g.add(agVar2.b);
                            view4.setTag(agVar2);
                            agVar = agVar2;
                        }
                        agVar = null;
                        view4 = view;
                    }
                    int an = TiebaApplication.g().an();
                    if (getItemViewType(i) != 1) {
                        if (this.i) {
                            agVar.b.setVisibility(0);
                            agVar.f1152a.setText(this.f1151a.getString(R.string.loading));
                        } else if (!this.j) {
                            agVar.b.setVisibility(8);
                            agVar.f1152a.setText(this.f1151a.getString(R.string.no_more_mark));
                        } else {
                            agVar.b.setVisibility(8);
                            agVar.f1152a.setText(this.f1151a.getString(R.string.load_more));
                        }
                        com.baidu.tieba.util.ao.b(agVar.f1152a, an);
                        return view4;
                    }
                    if (this.d) {
                        ahVar.b.setVisibility(8);
                        ahVar.c.setVisibility(8);
                        ahVar.i.setVisibility(8);
                        ahVar.g.setVisibility(0);
                    } else {
                        ahVar.b.setVisibility(0);
                        ahVar.c.setVisibility(0);
                        ahVar.g.setVisibility(8);
                        if (this.f) {
                            ahVar.i.setVisibility(0);
                        } else {
                            ahVar.i.setVisibility(8);
                        }
                    }
                    if (TiebaApplication.g().an() == 1) {
                        ahVar.b.setTextColor(-11446171);
                        ahVar.d.setTextColor(com.baidu.tieba.util.ao.a(1));
                        ahVar.f.setTextColor(-11446171);
                        ahVar.g.setTextColor(com.baidu.tieba.util.ao.a(an));
                        ahVar.f1153a.setBackgroundResource(R.drawable.icon_little_comment_1);
                        ahVar.e.setBackgroundResource(R.drawable.icon_little_people_1);
                        ahVar.h.setBackgroundResource(R.drawable.icon_new_tip_1);
                    } else {
                        ahVar.b.setTextColor(-5065030);
                        ahVar.d.setTextColor(-14277082);
                        ahVar.f.setTextColor(-5065030);
                        ahVar.g.setTextColor(-4276546);
                        ahVar.f1153a.setBackgroundResource(R.drawable.icon_little_comment_grey);
                        ahVar.e.setBackgroundResource(R.drawable.icon_little_people);
                        ahVar.h.setBackgroundResource(R.drawable.icon_new_tip);
                    }
                    Object item = getItem(i);
                    if (item == null) {
                        return view4;
                    }
                    MarkData markData = (MarkData) item;
                    if (markData.getNewCounts() > 0) {
                        ahVar.h.setVisibility(0);
                    } else {
                        ahVar.h.setVisibility(8);
                    }
                    int replyNum = markData.getReplyNum();
                    if (replyNum == 0) {
                        ahVar.b.setVisibility(8);
                        ahVar.f1153a.setVisibility(8);
                    } else {
                        ahVar.f1153a.setVisibility(0);
                        ahVar.b.setVisibility(0);
                        ahVar.b.setText(String.valueOf(replyNum));
                    }
                    ahVar.d.setText(markData.getTitle());
                    ahVar.f.setText(markData.getAuthorName());
                    ahVar.i.setOnClickListener(this.h);
                    ahVar.i.setFocusable(false);
                    ahVar.i.setTag(Integer.valueOf(i));
                    return view4;
                }
                if (getItemViewType(i) == 0) {
                    view4 = view;
                    agVar = null;
                    ahVar = (ah) view.getTag();
                } else {
                    if (getItemViewType(i) == 1) {
                        agVar = (ag) view.getTag();
                        view4 = view;
                    }
                    agVar = null;
                    view4 = view;
                }
                int an2 = TiebaApplication.g().an();
                if (getItemViewType(i) != 1) {
                }
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.util.aq.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
            com.baidu.tieba.util.aq.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
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
