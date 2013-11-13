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
    private Context f1400a;
    private ArrayList<MarkData> b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f = false;
    private ArrayList<ProgressBar> g = null;
    private View.OnClickListener h = null;
    private boolean i = false;
    private boolean j = true;

    public af(Context context) {
        this.f1400a = context;
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
        ah ahVar;
        ai aiVar;
        View view3;
        ai aiVar2 = null;
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.f1400a);
                if (getItemViewType(i) == 0) {
                    view = from.inflate(R.layout.home_mark_item, (ViewGroup) null);
                    ai aiVar3 = new ai(this);
                    aiVar3.b = (TextView) view.findViewById(R.id.home_lv_markitem_reply);
                    aiVar3.c = (LinearLayout) view.findViewById(R.id.home_lv_markitem_content);
                    aiVar3.d = (TextView) view.findViewById(R.id.home_lv_markitem_title);
                    aiVar3.f = (TextView) view.findViewById(R.id.home_lv_markitem_author);
                    aiVar3.h = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
                    aiVar3.e = (ImageView) view.findViewById(R.id.mark_author_icon);
                    aiVar3.f1402a = (ImageView) view.findViewById(R.id.mark_comment_icon);
                    aiVar3.g = (ImageView) view.findViewById(R.id.new_mark_mention);
                    view.setTag(aiVar3);
                    ahVar = null;
                    aiVar2 = aiVar3;
                } else if (getItemViewType(i) == 1) {
                    ah ahVar2 = new ah(this);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    ahVar2.f1401a = (TextView) view.findViewById(R.id.page_text);
                    ahVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.g == null) {
                        this.g = new ArrayList<>();
                    }
                    this.g.add(ahVar2.b);
                    view.setTag(ahVar2);
                    ahVar = ahVar2;
                } else {
                    ahVar = null;
                }
                aiVar = aiVar2;
                view3 = view;
            } else if (getItemViewType(i) == 0) {
                aiVar = (ai) view.getTag();
                ahVar = null;
                view3 = view;
            } else if (getItemViewType(i) == 1) {
                ahVar = (ah) view.getTag();
                aiVar = null;
                view3 = view;
            } else {
                ahVar = null;
                aiVar = null;
                view3 = view;
            }
            try {
                int ap = TiebaApplication.g().ap();
                if (getItemViewType(i) == 1) {
                    if (this.i) {
                        ahVar.b.setVisibility(0);
                        ahVar.f1401a.setText(this.f1400a.getString(R.string.loading));
                    } else if (!this.j) {
                        ahVar.b.setVisibility(8);
                        ahVar.f1401a.setText(this.f1400a.getString(R.string.no_more_mark));
                    } else {
                        ahVar.b.setVisibility(8);
                        ahVar.f1401a.setText(this.f1400a.getString(R.string.load_more));
                    }
                    com.baidu.tieba.util.bd.b(ahVar.f1401a, ap);
                } else {
                    if (this.d) {
                        aiVar.b.setVisibility(8);
                        aiVar.c.setVisibility(8);
                        aiVar.h.setVisibility(8);
                        aiVar.g.setVisibility(8);
                    } else {
                        aiVar.b.setVisibility(0);
                        aiVar.c.setVisibility(0);
                        if (this.f) {
                            aiVar.h.setVisibility(0);
                        } else {
                            aiVar.h.setVisibility(8);
                        }
                    }
                    if (TiebaApplication.g().ap() == 1) {
                        aiVar.b.setTextColor(-11446171);
                        aiVar.d.setTextColor(com.baidu.tieba.util.bd.a(1));
                        aiVar.f.setTextColor(-11446171);
                        aiVar.f1402a.setBackgroundResource(R.drawable.icon_little_comment_1);
                        aiVar.e.setBackgroundResource(R.drawable.icon_little_people_1);
                        aiVar.g.setBackgroundResource(R.drawable.icon_new_tip_1);
                    } else {
                        aiVar.b.setTextColor(-5065030);
                        aiVar.d.setTextColor(-14277082);
                        aiVar.f.setTextColor(-5065030);
                        aiVar.f1402a.setBackgroundResource(R.drawable.icon_little_comment_grey);
                        aiVar.e.setBackgroundResource(R.drawable.icon_little_people);
                        aiVar.g.setBackgroundResource(R.drawable.icon_new_tip);
                    }
                    Object item = getItem(i);
                    if (item == null) {
                        return view3;
                    }
                    MarkData markData = (MarkData) item;
                    if (markData.getNewCounts() > 0) {
                        aiVar.g.setVisibility(0);
                    } else {
                        aiVar.g.setVisibility(8);
                    }
                    int replyNum = markData.getReplyNum();
                    if (replyNum == 0) {
                        aiVar.b.setVisibility(8);
                        aiVar.f1402a.setVisibility(8);
                    } else {
                        aiVar.f1402a.setVisibility(0);
                        aiVar.b.setVisibility(0);
                        aiVar.b.setText(String.valueOf(replyNum));
                    }
                    aiVar.d.setText(markData.getTitle());
                    aiVar.f.setText(markData.getAuthorName());
                    aiVar.h.setOnClickListener(this.h);
                    aiVar.h.setFocusable(false);
                    aiVar.h.setTag(Integer.valueOf(i));
                }
                return view3;
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.util.bg.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
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
