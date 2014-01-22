package com.baidu.tieba.home;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.person.EditMarkActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private EditMarkActivity a;
    private ArrayList<MarkData> b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f = false;
    private ArrayList<ProgressBar> g = null;
    private View.OnClickListener h = null;
    private boolean i = false;
    private boolean j = true;
    private boolean k = true;

    public ab(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
        d(true);
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
        } else {
            int size = this.b.size();
            if (size == 0) {
                if (this.e) {
                    this.c = 0;
                    this.d = true;
                } else {
                    this.c = 0;
                }
            } else {
                this.c = size;
            }
        }
        notifyDataSetChanged();
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
        if (this.b == null || this.b.size() == 0) {
            return this.c;
        }
        if (this.k) {
            return this.c + 1;
        }
        return this.c;
    }

    public void c(boolean z) {
        this.k = z;
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0154: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:42:0x0153 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        ae aeVar;
        View view4;
        ad adVar = null;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (getItemViewType(i) == 0) {
                if (view == null || !(view.getTag() instanceof ae)) {
                    view4 = LayoutInflater.from(this.a).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    aeVar = new ae(this);
                    aeVar.b = (TextView) view4.findViewById(R.id.home_lv_markitem_reply);
                    aeVar.c = (LinearLayout) view4.findViewById(R.id.home_lv_markitem_content);
                    aeVar.d = (TextView) view4.findViewById(R.id.home_lv_markitem_title);
                    aeVar.h = (Button) view4.findViewById(R.id.home_lv_markitem_delete);
                    aeVar.a = (ImageView) view4.findViewById(R.id.mark_comment_icon);
                    aeVar.f = (ImageView) view4.findViewById(R.id.new_mark_mention_fack);
                    aeVar.g = (LinearLayout) view4.findViewById(R.id.new_mark);
                    aeVar.e = (TextView) view4.findViewById(R.id.home_lv_markitem_forum_name);
                    view4.setTag(aeVar);
                } else {
                    aeVar = (ae) view.getTag();
                    view4 = view;
                }
            } else if (getItemViewType(i) != 1) {
                aeVar = null;
                view4 = view;
            } else if (view == null || !(view.getTag() instanceof ad)) {
                LayoutInflater from = LayoutInflater.from(this.a);
                ad adVar2 = new ad(this);
                view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                adVar2.a = (TextView) view4.findViewById(R.id.page_text);
                adVar2.b = (ProgressBar) view4.findViewById(R.id.progress);
                if (this.g == null) {
                    this.g = new ArrayList<>();
                }
                this.g.add(adVar2.b);
                view4.setTag(adVar2);
                aeVar = null;
                adVar = adVar2;
            } else {
                aeVar = null;
                view4 = view;
                adVar = (ad) view.getTag();
            }
            int al = TiebaApplication.h().al();
            this.a.getLayoutMode().a(al == 1);
            this.a.getLayoutMode().a(view4);
            if (getItemViewType(i) == 1) {
                if (this.i) {
                    adVar.b.setVisibility(0);
                    adVar.a.setText(this.a.getString(R.string.loading));
                    if (al == 1) {
                        adVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_more_txt_1));
                    } else {
                        adVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_more_txt));
                    }
                } else if (!this.j) {
                    adVar.b.setVisibility(8);
                    adVar.a.setText(this.a.getString(R.string.no_more_mark));
                    if (al == 1) {
                        adVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_list_morebutton_nomore_text_1));
                    } else {
                        adVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_list_morebutton_nomore_text));
                    }
                } else {
                    adVar.b.setVisibility(8);
                    adVar.a.setText(this.a.getString(R.string.load_more));
                    if (al == 1) {
                        adVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_more_txt_1));
                    } else {
                        adVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_more_txt));
                    }
                }
            } else {
                if (this.d) {
                    aeVar.b.setVisibility(8);
                    aeVar.c.setVisibility(8);
                    aeVar.h.setVisibility(8);
                    a(aeVar, false);
                } else {
                    aeVar.b.setVisibility(0);
                    aeVar.c.setVisibility(0);
                    if (this.f) {
                        aeVar.h.setVisibility(0);
                    } else {
                        aeVar.h.setVisibility(8);
                    }
                }
                Object item = getItem(i);
                if (item != null) {
                    MarkData markData = (MarkData) item;
                    if (markData.getNewCounts() > 0) {
                        a(aeVar, true);
                    } else {
                        a(aeVar, false);
                    }
                    int replyNum = markData.getReplyNum();
                    if (replyNum < 0) {
                        aeVar.b.setVisibility(8);
                        aeVar.a.setVisibility(8);
                    } else {
                        aeVar.a.setVisibility(0);
                        aeVar.b.setVisibility(0);
                        aeVar.b.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        aeVar.d.setText(title);
                    } else {
                        aeVar.d.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        aeVar.e.setText(markData.getForumName() + this.a.getString(R.string.bar));
                    } else {
                        aeVar.e.setText("");
                    }
                    aeVar.h.setOnClickListener(this.h);
                    aeVar.h.setFocusable(false);
                    aeVar.h.setTag(Integer.valueOf(i));
                } else {
                    return view4;
                }
            }
            view2 = view4;
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            com.baidu.adp.lib.g.e.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
            return view2;
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.d || (!this.j && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void d(boolean z) {
        this.e = z;
    }

    public void e(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    private void a(ae aeVar, boolean z) {
        if (aeVar != null && aeVar.g != null && aeVar.f != null) {
            if (z) {
                aeVar.g.setVisibility(0);
                aeVar.f.setVisibility(4);
                return;
            }
            aeVar.g.setVisibility(8);
            aeVar.f.setVisibility(8);
        }
    }
}
