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
public class aa extends BaseAdapter {
    private Context a;
    private ArrayList<MarkData> b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f = false;
    private ArrayList<ProgressBar> g = null;
    private View.OnClickListener h = null;
    private boolean i = false;
    private boolean j = true;

    public aa(Context context) {
        this.a = context;
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
        } else {
            int size = this.b.size();
            if (size == 0) {
                if (this.e) {
                    this.c = 1;
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
        ac acVar;
        ad adVar;
        View view3;
        ad adVar2 = null;
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (getItemViewType(i) == 0) {
                    view = from.inflate(R.layout.home_mark_item, (ViewGroup) null);
                    ad adVar3 = new ad(this);
                    adVar3.b = (TextView) view.findViewById(R.id.home_lv_markitem_reply);
                    adVar3.c = (LinearLayout) view.findViewById(R.id.home_lv_markitem_content);
                    adVar3.d = (TextView) view.findViewById(R.id.home_lv_markitem_title);
                    adVar3.f = (TextView) view.findViewById(R.id.home_lv_markitem_author);
                    adVar3.h = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
                    adVar3.e = (ImageView) view.findViewById(R.id.mark_author_icon);
                    adVar3.a = (ImageView) view.findViewById(R.id.mark_comment_icon);
                    adVar3.g = (ImageView) view.findViewById(R.id.new_mark_mention);
                    view.setTag(adVar3);
                    acVar = null;
                    adVar2 = adVar3;
                } else if (getItemViewType(i) == 1) {
                    ac acVar2 = new ac(this);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    acVar2.a = (TextView) view.findViewById(R.id.page_text);
                    acVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.g == null) {
                        this.g = new ArrayList<>();
                    }
                    this.g.add(acVar2.b);
                    view.setTag(acVar2);
                    acVar = acVar2;
                } else {
                    acVar = null;
                }
                adVar = adVar2;
                view3 = view;
            } else if (getItemViewType(i) == 0) {
                adVar = (ad) view.getTag();
                acVar = null;
                view3 = view;
            } else if (getItemViewType(i) == 1) {
                acVar = (ac) view.getTag();
                adVar = null;
                view3 = view;
            } else {
                acVar = null;
                adVar = null;
                view3 = view;
            }
            try {
                int an = TiebaApplication.h().an();
                if (getItemViewType(i) == 1) {
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
                    com.baidu.tieba.util.bb.b(acVar.a, an);
                } else {
                    if (this.d) {
                        adVar.b.setVisibility(8);
                        adVar.c.setVisibility(8);
                        adVar.h.setVisibility(8);
                        adVar.g.setVisibility(8);
                    } else {
                        adVar.b.setVisibility(0);
                        adVar.c.setVisibility(0);
                        if (this.f) {
                            adVar.h.setVisibility(0);
                        } else {
                            adVar.h.setVisibility(8);
                        }
                    }
                    if (TiebaApplication.h().an() == 1) {
                        adVar.b.setTextColor(-11446171);
                        adVar.d.setTextColor(com.baidu.tieba.util.bb.a(1));
                        adVar.f.setTextColor(-11446171);
                        adVar.a.setBackgroundResource(R.drawable.icon_little_comment_1);
                        adVar.e.setBackgroundResource(R.drawable.icon_little_people_1);
                        adVar.g.setBackgroundResource(R.drawable.icon_new_tip_1);
                    } else {
                        adVar.b.setTextColor(-5065030);
                        adVar.d.setTextColor(-14277082);
                        adVar.f.setTextColor(-5065030);
                        adVar.a.setBackgroundResource(R.drawable.icon_little_comment_grey);
                        adVar.e.setBackgroundResource(R.drawable.icon_little_people);
                        adVar.g.setBackgroundResource(R.drawable.icon_new_tip);
                    }
                    Object item = getItem(i);
                    if (item == null) {
                        return view3;
                    }
                    MarkData markData = (MarkData) item;
                    if (markData.getNewCounts() > 0) {
                        adVar.g.setVisibility(0);
                    } else {
                        adVar.g.setVisibility(8);
                    }
                    int replyNum = markData.getReplyNum();
                    if (replyNum == 0) {
                        adVar.b.setVisibility(8);
                        adVar.a.setVisibility(8);
                    } else {
                        adVar.a.setVisibility(0);
                        adVar.b.setVisibility(0);
                        adVar.b.setText(String.valueOf(replyNum));
                    }
                    adVar.d.setText(markData.getTitle());
                    adVar.f.setText(markData.getAuthorName());
                    adVar.h.setOnClickListener(this.h);
                    adVar.h.setFocusable(false);
                    adVar.h.setTag(Integer.valueOf(i));
                }
                return view3;
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.util.be.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
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
