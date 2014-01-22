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
import com.baidu.tieba.data.IconData;
import com.baidu.tieba.util.bu;
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
public class ad extends BaseAdapter {
    private Context a;
    private ArrayList<com.baidu.tieba.data.bb> b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private com.baidu.tieba.util.i g;
    private int h;
    private boolean j;
    private int o;
    private int p;
    private int q;
    private int i = 200;
    private float k = 0.4f;
    private boolean l = false;
    private LinkedList<IconData> m = null;
    private LinkedList<IconData> n = null;

    private int b(ArrayList<com.baidu.tieba.data.bb> arrayList) {
        int i = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.tieba.data.bb> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.tieba.data.bb next = it.next();
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

    public ad(Context context, ArrayList<com.baidu.tieba.data.bb> arrayList, int i, boolean z) {
        this.h = 200;
        this.j = false;
        this.a = context;
        this.b = arrayList;
        this.g = new com.baidu.tieba.util.i(this.a);
        this.g.f("frs");
        this.h = i;
        this.j = z;
        a(z);
        this.q = b(this.b);
        this.o = this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_margin);
        this.p = this.a.getResources().getDimensionPixelSize(R.dimen.listview_divider_height);
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
            if (this.i > com.baidu.adp.lib.g.g.a(this.a, 320.0f)) {
                this.i = com.baidu.adp.lib.g.g.a(this.a, 320.0f);
            }
            this.g.b("_small");
        } else {
            if (this.i > this.k * 480.0f) {
                this.i = (int) (this.k * 480.0f);
            }
            if (this.i > com.baidu.adp.lib.g.g.a(this.a, 320.0f) * this.k) {
                this.i = (int) (com.baidu.adp.lib.g.g.a(this.a, 320.0f) * this.k);
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

    public void a(ArrayList<com.baidu.tieba.data.bb> arrayList) {
        this.b = arrayList;
        this.q = b(this.b);
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
        if (i < this.q) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int al = TiebaApplication.h().al();
        switch (getItemViewType(i)) {
            case 0:
                return a(view, al);
            case 1:
                return b(view, al);
            case 2:
                return a(i, view, al);
            case 3:
                return b(i, view, al);
            default:
                return null;
        }
    }

    private View a(int i, View view, int i2) {
        ag agVar;
        View view2;
        View view3;
        ag agVar2;
        BitmapDrawable bitmapDrawable;
        if (view == null) {
            view2 = e();
            agVar = (ag) view2.getTag();
        } else {
            agVar = null;
            view2 = view;
        }
        if (agVar == null) {
            View e = e();
            view3 = e;
            agVar2 = (ag) e.getTag();
        } else {
            view3 = view2;
            agVar2 = agVar;
        }
        ((FrsActivity) this.a).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.a).getLayoutMode().a(view3);
        com.baidu.tieba.data.bb bbVar = (com.baidu.tieba.data.bb) getItem(i);
        agVar2.b.setText(bbVar.c());
        com.baidu.tieba.util.bq au = TiebaApplication.h().au();
        if (au != null && au.b(bbVar.a())) {
            agVar2.b.setTextColor(this.a.getResources().getColor(R.color.read_thread_color));
        }
        if (i2 == 1) {
            if (bbVar.f() == 1) {
                bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_top_1);
            } else {
                bitmapDrawable = bbVar.f() == 2 ? (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_notice_1) : null;
            }
            if (this.q == 1) {
                agVar2.a.setBackgroundResource(R.drawable.bg_frs_top_selector_1);
                agVar2.c.setVisibility(8);
            } else if (this.q >= 2) {
                if (i == 0) {
                    agVar2.a.setBackgroundResource(R.drawable.bg_frs_top_up_selector_1);
                    agVar2.c.setVisibility(0);
                } else if (i == this.q - 1) {
                    agVar2.a.setBackgroundResource(R.drawable.bg_frs_top_down_selector_1);
                    agVar2.c.setVisibility(8);
                } else {
                    agVar2.a.setBackgroundResource(R.drawable.bg_frs_top_middle_selector_1);
                    agVar2.c.setVisibility(0);
                }
            }
        } else {
            if (bbVar.f() == 1) {
                bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_top);
            } else {
                bitmapDrawable = bbVar.f() == 2 ? (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_notice) : null;
            }
            if (this.q == 1) {
                agVar2.a.setBackgroundResource(R.drawable.bg_frs_top_selector);
                agVar2.c.setVisibility(8);
            } else if (this.q >= 2) {
                if (i == 0) {
                    agVar2.a.setBackgroundResource(R.drawable.bg_frs_top_up_selector);
                } else if (i == this.q - 1) {
                    agVar2.a.setBackgroundResource(R.drawable.bg_frs_top_down_selector);
                    agVar2.c.setVisibility(8);
                } else {
                    agVar2.a.setBackgroundResource(R.drawable.bg_frs_top_middle_selector);
                }
            }
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        agVar2.b.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view3;
    }

    private View e() {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.frs_top_item, (ViewGroup) null);
        ag agVar = new ag(this);
        agVar.a = (LinearLayout) inflate.findViewById(R.id.frs_top_item);
        agVar.b = (TextView) inflate.findViewById(R.id.frs_top_title);
        agVar.c = inflate.findViewById(R.id.frs_top_divider);
        inflate.setTag(agVar);
        return inflate;
    }

    private View b(int i, View view, int i2) {
        ah ahVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.frs_item, (ViewGroup) null);
            ah ahVar2 = new ah(this);
            ahVar2.a = (LinearLayout) view.findViewById(R.id.frs_list);
            ahVar2.b = (LinearLayout) view.findViewById(R.id.frs_list_item_top);
            ahVar2.c = (RelativeLayout) view.findViewById(R.id.item_bottom_layout);
            ahVar2.g = (TextView) view.findViewById(R.id.frs_lv_reply_num);
            ahVar2.k = (ImageView) view.findViewById(R.id.frs_discuss_icon);
            ahVar2.h = (TextView) view.findViewById(R.id.frs_lv_reply_time);
            ahVar2.i = (TextView) view.findViewById(R.id.frs_lv_title);
            ahVar2.j = (TextView) view.findViewById(R.id.frs_lv_author);
            ahVar2.d = (TextView) view.findViewById(R.id.abstract_text);
            ahVar2.f = (CommonImageLayout) view.findViewById(R.id.abstract_img_layout);
            ahVar2.e = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
            ahVar2.l = (ViewGroup) view.findViewById(R.id.frs_list_divider_wrapper);
            ahVar2.m = (DottedLine) view.findViewById(R.id.frs_list_divider);
            ahVar2.n = (UserIconBox) view.findViewById(R.id.user_icon_box);
            ahVar2.o = (UserIconBox) view.findViewById(R.id.user_tshow_icon_box);
            view.setTag(ahVar2);
            ahVar = ahVar2;
        } else {
            ahVar = (ah) view.getTag();
        }
        if (i2 == 1) {
            ahVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg_1);
            ahVar.c.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg_1);
        } else {
            ahVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg);
            ahVar.c.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg);
        }
        ahVar.a.setPadding(0, i - this.q == 0 ? this.o : this.p, 0, 0);
        ahVar.l.setVisibility(8);
        ((FrsActivity) this.a).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.a).getLayoutMode().a(view);
        com.baidu.tieba.data.bb bbVar = (com.baidu.tieba.data.bb) getItem(i);
        int d = bbVar.d();
        ahVar.k.setVisibility(0);
        if (d <= 999999) {
            if (d > 0) {
                ahVar.g.setText(String.valueOf(d));
            } else {
                ahVar.g.setText((CharSequence) null);
                ahVar.k.setVisibility(4);
            }
        } else {
            ahVar.g.setText("999999+");
        }
        ahVar.h.setText(bu.a(bbVar.e() * 1000));
        ahVar.i.setText(bbVar.r());
        com.baidu.tieba.util.bq au = TiebaApplication.h().au();
        if (au != null && au.b(bbVar.a())) {
            ahVar.i.setTextColor(i2 == 1 ? this.a.getResources().getColor(R.color.listview_item_thread_read_1) : this.a.getResources().getColor(R.color.listview_item_thread_read));
        }
        ahVar.j.setText(bbVar.j().getName());
        this.m = bbVar.j().getIconInfo();
        this.n = bbVar.j().getTShowInfo();
        if (ahVar.n != null) {
            ahVar.n.a(this.m, 3, this.a.getResources().getDimensionPixelSize(R.dimen.frs_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.frs_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.frs_icon_margin));
        }
        if (ahVar.o != null) {
            ahVar.o.a(this.n, 2, this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_margin));
        }
        if (this.n != null && this.n.size() > 0) {
            ahVar.j.setPadding(0, 0, 0, 0);
        } else {
            ahVar.j.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_padding), 0, 0, 0);
        }
        ahVar.c.setVisibility(0);
        ahVar.f.setVisibility(0);
        ahVar.e.setVisibility(0);
        ahVar.d.setVisibility(0);
        StringBuffer stringBuffer = new StringBuffer();
        if (bbVar.m() != null && bbVar.m().trim().length() > 0) {
            stringBuffer.append(bbVar.m());
        }
        ArrayList<com.baidu.tieba.data.aj> p = bbVar.p();
        if (p != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= p.size()) {
                    break;
                }
                if (p.get(i4).c() != null && p.get(i4).c().endsWith("swf")) {
                    stringBuffer2.append(p.get(i4).c());
                }
                i3 = i4 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                ahVar.d.setText(stringBuffer.toString());
            } else {
                ahVar.d.setVisibility(8);
            }
        }
        if (com.baidu.tieba.e.a.a().f()) {
            if (p != null) {
                if (p.size() > 0) {
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        int i7 = i5;
                        if (i7 >= p.size()) {
                            break;
                        }
                        if (p.get(i7) != null && (p.get(i7).a() == 3 || p.get(i7).a() == 5)) {
                            i6++;
                        }
                        i5 = i7 + 1;
                    }
                    int i8 = i6 > 3 ? 3 : i6;
                    if (i8 > 0) {
                        com.baidu.tieba.data.aj[] ajVarArr = new com.baidu.tieba.data.aj[i8];
                        int i9 = 0;
                        int i10 = 0;
                        while (true) {
                            int i11 = i9;
                            int i12 = i10;
                            if (i11 >= p.size() || i12 >= i8) {
                                break;
                            }
                            if (p.get(i11).a() == 3 || p.get(i11).a() == 5) {
                                ajVarArr[i12] = p.get(i11);
                                i10 = i12 + 1;
                            } else {
                                i10 = i12;
                            }
                            i9 = i11 + 1;
                        }
                        ahVar.f.setShowBig(this.j);
                        ahVar.f.setData(ajVarArr);
                        ahVar.f.setImageFrom("frs");
                        ahVar.f.setFromCDN(this.l);
                    }
                } else {
                    ahVar.f.setVisibility(8);
                }
            }
        } else {
            ahVar.f.setVisibility(8);
        }
        ArrayList<VoiceManager.VoiceModel> q = bbVar.q();
        if (q != null && q.size() > 0) {
            VoiceManager.VoiceModel voiceModel = q.get(0);
            ahVar.e.setVoiceModel(voiceModel);
            ahVar.e.setTag(voiceModel);
            ahVar.e.c();
        } else {
            ahVar.e.setVisibility(8);
        }
        ahVar.c.setVisibility(0);
        return view;
    }

    private View a(View view, int i) {
        af afVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.frs_item_control, (ViewGroup) null);
            af afVar2 = new af(this);
            afVar2.a = (FrameLayout) view.findViewById(R.id.frs_list_control);
            afVar2.b = (LinearLayout) view.findViewById(R.id.frs_list_control_in);
            afVar2.d = (ProgressBar) view.findViewById(R.id.frs_list_control_progress);
            afVar2.c = (TextView) view.findViewById(R.id.frs_list_control_tv);
            view.setTag(afVar2);
            afVar = afVar2;
        } else {
            afVar = (af) view.getTag();
        }
        if (this.c) {
            afVar.a.setVisibility(0);
            afVar.a.setPadding(0, this.o, 0, 0);
            if (this.f) {
                afVar.c.setText(R.string.loading);
                afVar.d.setVisibility(0);
            } else {
                afVar.c.setText(R.string.frs_pre);
                afVar.d.setVisibility(8);
            }
            if (i == 1) {
                afVar.b.setBackgroundResource(R.drawable.frs_item_control_bg_1);
            } else {
                afVar.b.setBackgroundResource(R.drawable.frs_item_control_bg);
            }
            com.baidu.tieba.util.bs.b(afVar.c, i);
        } else {
            afVar.a.setVisibility(8);
        }
        return view;
    }

    private View b(View view, int i) {
        af afVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.frs_item_control, (ViewGroup) null);
            af afVar2 = new af(this);
            afVar2.a = (FrameLayout) view.findViewById(R.id.frs_list_control);
            afVar2.b = (LinearLayout) view.findViewById(R.id.frs_list_control_in);
            afVar2.d = (ProgressBar) view.findViewById(R.id.frs_list_control_progress);
            afVar2.c = (TextView) view.findViewById(R.id.frs_list_control_tv);
            view.setTag(afVar2);
            afVar = afVar2;
        } else {
            afVar = (af) view.getTag();
        }
        if (this.d) {
            afVar.a.setVisibility(0);
            afVar.a.setPadding(0, this.o, 0, this.o);
            if (this.e) {
                afVar.c.setText(R.string.loading);
                afVar.d.setVisibility(0);
            } else {
                afVar.c.setText(R.string.frs_next);
                afVar.d.setVisibility(8);
            }
            if (i == 1) {
                afVar.b.setBackgroundResource(R.drawable.frs_item_control_bg_1);
            } else {
                afVar.b.setBackgroundResource(R.drawable.frs_item_control_bg);
            }
            com.baidu.tieba.util.bs.b(afVar.c, i);
        } else {
            afVar.a.setVisibility(8);
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
