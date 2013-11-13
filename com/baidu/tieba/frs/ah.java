package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.CommonImageLayout;
import com.baidu.tieba.view.DottedLine;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ah extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1309a;
    private ArrayList<com.baidu.tieba.data.ba> b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private com.baidu.tieba.util.i g;
    private int h;
    private boolean j;
    private int n;
    private int o;
    private int p;
    private int i = 200;
    private float k = 0.4f;
    private boolean l = false;
    private LinkedList<com.baidu.tieba.data.aa> m = null;

    private int b(ArrayList<com.baidu.tieba.data.ba> arrayList) {
        int i = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.tieba.data.ba> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.tieba.data.ba next = it.next();
                if (next.f() == 1 || next.f() == 2) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public ah(Context context, ArrayList<com.baidu.tieba.data.ba> arrayList, int i, boolean z) {
        this.h = 200;
        this.j = false;
        this.f1309a = context;
        this.b = arrayList;
        this.g = new com.baidu.tieba.util.i(this.f1309a);
        this.g.f("frs");
        this.h = i;
        this.j = z;
        a(z);
        this.p = b(this.b);
        this.n = this.f1309a.getResources().getDimensionPixelSize(R.dimen.listview_item_margin);
        this.o = this.f1309a.getResources().getDimensionPixelSize(R.dimen.listview_divider_height);
    }

    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
        }
        this.i = this.h;
        if (this.j) {
            if (this.i > 480) {
                this.i = 480;
            }
            if (this.i > UtilHelper.a(this.f1309a, 320.0f)) {
                this.i = UtilHelper.a(this.f1309a, 320.0f);
            }
            this.g.b("_small");
        } else {
            if (this.i > this.k * 480.0f) {
                this.i = (int) (this.k * 480.0f);
            }
            if (this.i > UtilHelper.a(this.f1309a, 320.0f) * this.k) {
                this.i = (int) (UtilHelper.a(this.f1309a, 320.0f) * this.k);
            }
            this.g.b("_mobile");
        }
        this.g.a(this.i, this.i);
    }

    public com.baidu.tieba.util.i a() {
        return this.g;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.e;
    }

    public void c(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
    }

    public void d(boolean z) {
        this.c = z;
    }

    public void e(boolean z) {
        this.d = z;
    }

    public void a(ArrayList<com.baidu.tieba.data.ba> arrayList) {
        this.b = arrayList;
        this.p = b(this.b);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b == null) {
            return 0;
        }
        int size = 0 + this.b.size();
        if (this.c) {
            size++;
        }
        if (this.d) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.b.size()) {
            return null;
        }
        return this.b.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2 = this.c ? i - 1 : i;
        if (this.d && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.c && i == 0) {
            return 0;
        }
        if (this.d && i == getCount() - 1) {
            return 1;
        }
        if (i < this.p) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int ap = TiebaApplication.g().ap();
        switch (getItemViewType(i)) {
            case 0:
                return a(view, ap);
            case 1:
                return b(view, ap);
            case 2:
                return a(i, view, ap);
            case 3:
                return b(i, view, ap);
            default:
                return null;
        }
    }

    private View a(int i, View view, int i2) {
        ak akVar;
        BitmapDrawable bitmapDrawable;
        if (view == null) {
            view = LayoutInflater.from(this.f1309a).inflate(R.layout.frs_top_item, (ViewGroup) null);
            akVar = new ak(this);
            akVar.f1311a = (LinearLayout) view.findViewById(R.id.frs_top_item);
            akVar.b = (TextView) view.findViewById(R.id.frs_top_title);
            akVar.c = view.findViewById(R.id.frs_top_divider);
            view.setTag(akVar);
        } else {
            akVar = (ak) view.getTag();
        }
        ((FrsActivity) this.f1309a).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.f1309a).getLayoutMode().a(view);
        com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) getItem(i);
        akVar.b.setText(baVar.c());
        com.baidu.tieba.util.bc aw = TiebaApplication.g().aw();
        if (aw != null && aw.b(baVar.a())) {
            akVar.b.setTextColor(this.f1309a.getResources().getColor(R.color.read_thread_color));
        }
        if (i2 == 1) {
            if (baVar.f() == 1) {
                bitmapDrawable = (BitmapDrawable) this.f1309a.getResources().getDrawable(R.drawable.icon_top_1);
            } else {
                bitmapDrawable = baVar.f() == 2 ? (BitmapDrawable) this.f1309a.getResources().getDrawable(R.drawable.icon_notice_1) : null;
            }
            if (this.p == 1) {
                akVar.f1311a.setBackgroundResource(R.drawable.bg_frs_top_selector_1);
                akVar.c.setVisibility(8);
            } else if (this.p >= 2) {
                if (i == 0) {
                    akVar.f1311a.setBackgroundResource(R.drawable.bg_frs_top_up_selector_1);
                    akVar.c.setVisibility(0);
                } else if (i == this.p - 1) {
                    akVar.f1311a.setBackgroundResource(R.drawable.bg_frs_top_down_selector_1);
                    akVar.c.setVisibility(8);
                } else {
                    akVar.f1311a.setBackgroundResource(R.drawable.bg_frs_top_middle_selector_1);
                    akVar.c.setVisibility(0);
                }
            }
        } else {
            if (baVar.f() == 1) {
                bitmapDrawable = (BitmapDrawable) this.f1309a.getResources().getDrawable(R.drawable.icon_top);
            } else {
                bitmapDrawable = baVar.f() == 2 ? (BitmapDrawable) this.f1309a.getResources().getDrawable(R.drawable.icon_notice) : null;
            }
            if (this.p == 1) {
                akVar.f1311a.setBackgroundResource(R.drawable.bg_frs_top_selector);
                akVar.c.setVisibility(8);
            } else if (this.p >= 2) {
                if (i == 0) {
                    akVar.f1311a.setBackgroundResource(R.drawable.bg_frs_top_up_selector);
                } else if (i == this.p - 1) {
                    akVar.f1311a.setBackgroundResource(R.drawable.bg_frs_top_down_selector);
                    akVar.c.setVisibility(8);
                } else {
                    akVar.f1311a.setBackgroundResource(R.drawable.bg_frs_top_middle_selector);
                }
            }
        }
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        akVar.b.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view;
    }

    private View b(int i, View view, int i2) {
        al alVar;
        int i3;
        if (view == null) {
            view = LayoutInflater.from(this.f1309a).inflate(R.layout.frs_item, (ViewGroup) null);
            al alVar2 = new al(this);
            alVar2.f1312a = (LinearLayout) view.findViewById(R.id.frs_list);
            alVar2.b = (LinearLayout) view.findViewById(R.id.frs_list_item_top);
            alVar2.c = (RelativeLayout) view.findViewById(R.id.item_bottom_layout);
            alVar2.g = (TextView) view.findViewById(R.id.frs_lv_reply_num);
            alVar2.k = (ImageView) view.findViewById(R.id.frs_discuss_icon);
            alVar2.h = (TextView) view.findViewById(R.id.frs_lv_reply_time);
            alVar2.i = (TextView) view.findViewById(R.id.frs_lv_title);
            alVar2.j = (TextView) view.findViewById(R.id.frs_lv_author);
            alVar2.d = (TextView) view.findViewById(R.id.abstract_text);
            alVar2.f = (CommonImageLayout) view.findViewById(R.id.abstract_img_layout);
            alVar2.e = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
            alVar2.l = (ViewGroup) view.findViewById(R.id.frs_list_divider_wrapper);
            alVar2.m = (DottedLine) view.findViewById(R.id.frs_list_divider);
            alVar2.n = (UserIconBox) view.findViewById(R.id.user_icon_box);
            view.setTag(alVar2);
            alVar = alVar2;
        } else {
            alVar = (al) view.getTag();
        }
        if (i2 == 1) {
            alVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg_1);
            alVar.c.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg_1);
        } else {
            alVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg);
            alVar.c.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg);
        }
        alVar.f1312a.setPadding(0, i - this.p == 0 ? this.n : this.o, 0, 0);
        alVar.l.setVisibility(8);
        ((FrsActivity) this.f1309a).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.f1309a).getLayoutMode().a(view);
        com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) getItem(i);
        int d = baVar.d();
        alVar.k.setVisibility(0);
        if (d <= 999999) {
            if (d > 0) {
                alVar.g.setText(String.valueOf(d));
            } else {
                alVar.g.setText((CharSequence) null);
                alVar.k.setVisibility(4);
            }
        } else {
            alVar.g.setText("999999+");
        }
        alVar.h.setText(com.baidu.tieba.util.be.b(baVar.e() * 1000));
        alVar.i.setText(baVar.r());
        com.baidu.tieba.util.bc aw = TiebaApplication.g().aw();
        if (aw != null && aw.b(baVar.a())) {
            alVar.i.setTextColor(i2 == 1 ? this.f1309a.getResources().getColor(R.color.listview_item_thread_read_1) : this.f1309a.getResources().getColor(R.color.listview_item_thread_read));
        }
        alVar.j.setText(baVar.j().getName());
        this.m = baVar.j().getIconInfo();
        if (alVar.n != null) {
            alVar.n.a(this.m, 3, this.f1309a.getResources().getDimensionPixelSize(R.dimen.frs_icon_width), this.f1309a.getResources().getDimensionPixelSize(R.dimen.frs_icon_height), this.f1309a.getResources().getDimensionPixelSize(R.dimen.frs_icon_margin));
        }
        alVar.c.setVisibility(0);
        alVar.f.setVisibility(0);
        alVar.e.setVisibility(0);
        alVar.d.setVisibility(0);
        StringBuffer stringBuffer = new StringBuffer();
        if (baVar.m() != null) {
            stringBuffer.append(baVar.m());
        }
        ArrayList<com.baidu.tieba.data.aj> p = baVar.p();
        if (p != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < p.size(); i4++) {
                if (p.get(i4).c() != null && p.get(i4).c().endsWith("swf")) {
                    stringBuffer2.append(p.get(i4).c());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 1) {
                alVar.d.setText(stringBuffer.toString());
            } else {
                alVar.d.setVisibility(8);
            }
        }
        if (com.baidu.tieba.d.a.a().f() && p != null) {
            if (p.size() > 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < p.size(); i6++) {
                    if (p.get(i6) != null && (p.get(i6).a() == 3 || p.get(i6).a() == 5)) {
                        i5++;
                    }
                }
                int i7 = i5 > 3 ? 3 : i5;
                if (i7 > 0) {
                    com.baidu.tieba.data.aj[] ajVarArr = new com.baidu.tieba.data.aj[i7];
                    int i8 = 0;
                    int i9 = 0;
                    while (i9 < p.size() && i8 < i7) {
                        if (p.get(i9).a() == 3 || p.get(i9).a() == 5) {
                            ajVarArr[i8] = p.get(i9);
                            i3 = i8 + 1;
                        } else {
                            i3 = i8;
                        }
                        i9++;
                        i8 = i3;
                    }
                    alVar.f.setShowBig(this.j);
                    alVar.f.setData(ajVarArr);
                    alVar.f.setImageFrom("frs");
                    alVar.f.setFromCDN(this.l);
                }
            } else {
                alVar.f.setVisibility(8);
            }
        }
        ArrayList<VoiceManager.VoiceModel> q = baVar.q();
        if (q != null && q.size() > 0) {
            VoiceManager.VoiceModel voiceModel = q.get(0);
            alVar.e.setVoiceModel(voiceModel);
            alVar.e.setTag(voiceModel);
            alVar.e.c();
        } else {
            alVar.e.setVisibility(8);
        }
        alVar.c.setVisibility(0);
        return view;
    }

    private View a(View view, int i) {
        aj ajVar;
        if (view == null) {
            view = LayoutInflater.from(this.f1309a).inflate(R.layout.frs_item_control, (ViewGroup) null);
            aj ajVar2 = new aj(this);
            ajVar2.f1310a = (FrameLayout) view.findViewById(R.id.frs_list_control);
            ajVar2.b = (LinearLayout) view.findViewById(R.id.frs_list_control_in);
            ajVar2.d = (ProgressBar) view.findViewById(R.id.frs_list_control_progress);
            ajVar2.c = (TextView) view.findViewById(R.id.frs_list_control_tv);
            view.setTag(ajVar2);
            ajVar = ajVar2;
        } else {
            ajVar = (aj) view.getTag();
        }
        if (this.c) {
            ajVar.f1310a.setVisibility(0);
            ajVar.f1310a.setPadding(0, this.n, 0, 0);
            if (this.f) {
                ajVar.c.setText(R.string.loading);
                ajVar.d.setVisibility(0);
            } else {
                ajVar.c.setText(R.string.frs_pre);
                ajVar.d.setVisibility(8);
            }
            if (i == 1) {
                ajVar.b.setBackgroundResource(R.drawable.frs_item_control_bg_1);
            } else {
                ajVar.b.setBackgroundResource(R.drawable.frs_item_control_bg);
            }
            com.baidu.tieba.util.bd.b(ajVar.c, i);
        } else {
            ajVar.f1310a.setVisibility(8);
        }
        return view;
    }

    private View b(View view, int i) {
        aj ajVar;
        if (view == null) {
            view = LayoutInflater.from(this.f1309a).inflate(R.layout.frs_item_control, (ViewGroup) null);
            aj ajVar2 = new aj(this);
            ajVar2.f1310a = (FrameLayout) view.findViewById(R.id.frs_list_control);
            ajVar2.b = (LinearLayout) view.findViewById(R.id.frs_list_control_in);
            ajVar2.d = (ProgressBar) view.findViewById(R.id.frs_list_control_progress);
            ajVar2.c = (TextView) view.findViewById(R.id.frs_list_control_tv);
            view.setTag(ajVar2);
            ajVar = ajVar2;
        } else {
            ajVar = (aj) view.getTag();
        }
        if (this.d) {
            ajVar.f1310a.setVisibility(0);
            ajVar.f1310a.setPadding(0, this.n, 0, this.n);
            if (this.e) {
                ajVar.c.setText(R.string.loading);
                ajVar.d.setVisibility(0);
            } else {
                ajVar.c.setText(R.string.frs_next);
                ajVar.d.setVisibility(8);
            }
            if (i == 1) {
                ajVar.b.setBackgroundResource(R.drawable.frs_item_control_bg_1);
            } else {
                ajVar.b.setBackgroundResource(R.drawable.frs_item_control_bg);
            }
            com.baidu.tieba.util.bd.b(ajVar.c, i);
        } else {
            ajVar.f1310a.setVisibility(8);
        }
        return view;
    }

    public void d() {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size && this.b.get(i).f() != 0; i++) {
                this.b.get(i).t();
            }
        }
    }

    public void f(boolean z) {
        this.l = z;
        this.g.d(z);
    }
}
