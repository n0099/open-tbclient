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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.CommonImageLayout;
import com.baidu.tieba.view.DottedLine;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ak extends BaseAdapter {
    private Context a;
    private ArrayList<com.baidu.tieba.data.az> b;
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
    private ArrayList<Integer> r;
    private HashMap<Integer, com.baidu.tieba.data.az> s;
    private int i = 200;
    private float k = 0.4f;
    private boolean l = false;
    private LinkedList<IconData> m = null;
    private LinkedList<IconData> n = null;
    private View.OnClickListener t = new al(this);

    private int b(ArrayList<com.baidu.tieba.data.az> arrayList) {
        int i = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.tieba.data.az> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.tieba.data.az next = it.next();
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

    private ArrayList<Integer> c(ArrayList<com.baidu.tieba.data.az> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.tieba.data.az> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.data.az next = it.next();
            if (next instanceof g) {
                int u = (((g) next).u() + this.q) - 1;
                arrayList2.add(Integer.valueOf(u));
                if (this.s != null && !this.s.containsValue(next)) {
                    this.s.put(Integer.valueOf(u), next);
                }
            }
        }
        return arrayList2;
    }

    public ak(Context context, ArrayList<com.baidu.tieba.data.az> arrayList, int i, boolean z) {
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
        this.s = new HashMap<>();
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
            if (this.i > BdUtilHelper.a(this.a, 320.0f)) {
                this.i = BdUtilHelper.a(this.a, 320.0f);
            }
            this.g.b("_small");
        } else {
            if (this.i > this.k * 480.0f) {
                this.i = (int) (this.k * 480.0f);
            }
            if (this.i > BdUtilHelper.a(this.a, 320.0f) * this.k) {
                this.i = (int) (BdUtilHelper.a(this.a, 320.0f) * this.k);
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

    public void a(ArrayList<com.baidu.tieba.data.az> arrayList) {
        this.b = arrayList;
        this.q = b(this.b);
        this.r = c(arrayList);
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

    public HashMap<Integer, com.baidu.tieba.data.az> d() {
        return this.s;
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
        return 5;
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
        if (this.r.contains(Integer.valueOf(i))) {
            return 4;
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int al = TiebaApplication.g().al();
        switch (getItemViewType(i)) {
            case 0:
                return a(view, al);
            case 1:
                return b(view, al);
            case 2:
                return a(i, view, al);
            case 3:
                return b(i, view, al);
            case 4:
                return c(i, view, al);
            default:
                return null;
        }
    }

    private View a(int i, View view, int i2) {
        ao aoVar;
        View view2;
        View view3;
        ao aoVar2;
        BitmapDrawable bitmapDrawable;
        if (view == null) {
            view2 = f();
            aoVar = (ao) view2.getTag();
        } else {
            aoVar = null;
            view2 = view;
        }
        if (aoVar == null) {
            View f = f();
            view3 = f;
            aoVar2 = (ao) f.getTag();
        } else {
            view3 = view2;
            aoVar2 = aoVar;
        }
        ((FrsActivity) this.a).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.a).getLayoutMode().a(view3);
        com.baidu.tieba.data.az azVar = (com.baidu.tieba.data.az) getItem(i);
        aoVar2.b.setText(azVar.c());
        com.baidu.tieba.util.bo at = TiebaApplication.g().at();
        if (at != null && at.b(azVar.a())) {
            aoVar2.b.setTextColor(this.a.getResources().getColor(R.color.read_thread_color));
        }
        if (i2 == 1) {
            if (azVar.f() == 1) {
                bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_top_1);
            } else {
                bitmapDrawable = azVar.f() == 2 ? (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_notice_1) : null;
            }
            if (this.q == 1) {
                aoVar2.a.setBackgroundResource(R.drawable.bg_frs_top_selector_1);
                aoVar2.c.setVisibility(8);
            } else if (this.q >= 2) {
                if (i == 0) {
                    aoVar2.a.setBackgroundResource(R.drawable.bg_frs_top_up_selector_1);
                    aoVar2.c.setVisibility(0);
                } else if (i == this.q - 1) {
                    aoVar2.a.setBackgroundResource(R.drawable.bg_frs_top_down_selector_1);
                    aoVar2.c.setVisibility(8);
                } else {
                    aoVar2.a.setBackgroundResource(R.drawable.bg_frs_top_middle_selector_1);
                    aoVar2.c.setVisibility(0);
                }
            }
        } else {
            if (azVar.f() == 1) {
                bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_top);
            } else {
                bitmapDrawable = azVar.f() == 2 ? (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_notice) : null;
            }
            if (this.q == 1) {
                aoVar2.a.setBackgroundResource(R.drawable.bg_frs_top_selector);
                aoVar2.c.setVisibility(8);
            } else if (this.q >= 2) {
                if (i == 0) {
                    aoVar2.a.setBackgroundResource(R.drawable.bg_frs_top_up_selector);
                } else if (i == this.q - 1) {
                    aoVar2.a.setBackgroundResource(R.drawable.bg_frs_top_down_selector);
                    aoVar2.c.setVisibility(8);
                } else {
                    aoVar2.a.setBackgroundResource(R.drawable.bg_frs_top_middle_selector);
                }
            }
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        aoVar2.b.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view3;
    }

    private View f() {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.frs_top_item, (ViewGroup) null);
        ao aoVar = new ao(this, null);
        aoVar.a = (LinearLayout) inflate.findViewById(R.id.frs_top_item);
        aoVar.b = (TextView) inflate.findViewById(R.id.frs_top_title);
        aoVar.c = inflate.findViewById(R.id.frs_top_divider);
        inflate.setTag(aoVar);
        return inflate;
    }

    private View b(int i, View view, int i2) {
        ap apVar;
        int color;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.frs_item, (ViewGroup) null);
            ap apVar2 = new ap(this, null);
            apVar2.a = (LinearLayout) view.findViewById(R.id.frs_list);
            apVar2.b = (LinearLayout) view.findViewById(R.id.frs_list_item_top);
            apVar2.c = (RelativeLayout) view.findViewById(R.id.item_bottom_layout);
            apVar2.g = (TextView) view.findViewById(R.id.frs_lv_reply_num);
            apVar2.k = (ImageView) view.findViewById(R.id.frs_discuss_icon);
            apVar2.h = (TextView) view.findViewById(R.id.frs_lv_reply_time);
            apVar2.i = (TextView) view.findViewById(R.id.frs_lv_title);
            apVar2.j = (TextView) view.findViewById(R.id.frs_lv_author);
            apVar2.d = (TextView) view.findViewById(R.id.abstract_text);
            apVar2.f = (CommonImageLayout) view.findViewById(R.id.abstract_img_layout);
            apVar2.e = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
            apVar2.l = (ViewGroup) view.findViewById(R.id.frs_list_divider_wrapper);
            apVar2.m = (DottedLine) view.findViewById(R.id.frs_list_divider);
            apVar2.n = (UserIconBox) view.findViewById(R.id.user_icon_box);
            apVar2.o = (UserIconBox) view.findViewById(R.id.user_tshow_icon_box);
            view.setTag(apVar2);
            apVar = apVar2;
        } else {
            apVar = (ap) view.getTag();
        }
        if (i2 == 1) {
            apVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg_1);
            apVar.c.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg_1);
        } else {
            apVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg);
            apVar.c.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg);
        }
        apVar.a.setPadding(0, i - this.q == 0 ? this.o : this.p, 0, 0);
        apVar.l.setVisibility(8);
        ((FrsActivity) this.a).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.a).getLayoutMode().a(view);
        com.baidu.tieba.data.az azVar = (com.baidu.tieba.data.az) getItem(i);
        int d = azVar.d();
        apVar.k.setVisibility(0);
        if (d <= 999999) {
            if (d > 0) {
                apVar.g.setText(String.valueOf(d));
            } else {
                apVar.g.setText((CharSequence) null);
                apVar.k.setVisibility(4);
            }
        } else {
            apVar.g.setText("999999+");
        }
        apVar.h.setText(com.baidu.tieba.util.bs.a(azVar.e() * 1000));
        apVar.i.setText(azVar.r());
        com.baidu.tieba.util.bo at = TiebaApplication.g().at();
        if (at != null && at.b(azVar.a())) {
            TextView textView = apVar.i;
            if (i2 == 1) {
                color = this.a.getResources().getColor(R.color.listview_item_thread_read_1);
            } else {
                color = this.a.getResources().getColor(R.color.listview_item_thread_read);
            }
            textView.setTextColor(color);
        }
        apVar.j.setText(azVar.j().getUserName());
        this.m = azVar.j().getIconInfo();
        this.n = azVar.j().getTShowInfo();
        if (apVar.n != null) {
            apVar.n.a(this.m, 3, this.a.getResources().getDimensionPixelSize(R.dimen.frs_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.frs_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.frs_icon_margin));
        }
        if (apVar.o != null) {
            apVar.o.a(this.n, 2, this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_margin));
        }
        if (this.n != null && this.n.size() > 0) {
            apVar.j.setPadding(0, 0, 0, 0);
        } else {
            apVar.j.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_padding), 0, 0, 0);
        }
        apVar.c.setVisibility(0);
        apVar.f.setVisibility(0);
        apVar.e.setVisibility(0);
        apVar.d.setVisibility(0);
        StringBuffer stringBuffer = new StringBuffer();
        if (azVar.m() != null && azVar.m().trim().length() > 0) {
            stringBuffer.append(azVar.m());
        }
        ArrayList<com.baidu.tieba.data.ah> p = azVar.p();
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
                apVar.d.setText(stringBuffer.toString());
            } else {
                apVar.d.setVisibility(8);
            }
        }
        if (com.baidu.tieba.h.a.a().f()) {
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
                        com.baidu.tieba.data.ah[] ahVarArr = new com.baidu.tieba.data.ah[i8];
                        int i9 = 0;
                        int i10 = 0;
                        while (true) {
                            int i11 = i9;
                            int i12 = i10;
                            if (i11 >= p.size() || i12 >= i8) {
                                break;
                            }
                            if (p.get(i11).a() == 3 || p.get(i11).a() == 5) {
                                ahVarArr[i12] = p.get(i11);
                                i10 = i12 + 1;
                            } else {
                                i10 = i12;
                            }
                            i9 = i11 + 1;
                        }
                        apVar.f.setShowBig(this.j);
                        apVar.f.setData(ahVarArr);
                        apVar.f.setImageFrom("frs");
                        apVar.f.setFromCDN(this.l);
                    }
                } else {
                    apVar.f.setVisibility(8);
                }
            }
        } else {
            apVar.f.setVisibility(8);
        }
        ArrayList<VoiceManager.VoiceModel> q = azVar.q();
        if (q != null && q.size() > 0) {
            VoiceManager.VoiceModel voiceModel = q.get(0);
            apVar.e.setVoiceModel(voiceModel);
            apVar.e.setTag(voiceModel);
            apVar.e.c();
        } else {
            apVar.e.setVisibility(8);
        }
        apVar.c.setVisibility(0);
        return view;
    }

    private View c(int i, View view, int i2) {
        if (view == null) {
            view = g();
        }
        am amVar = (am) view.getTag();
        amVar.a.setPadding(0, i - this.q == 0 ? this.o : this.p, 0, 0);
        view.setTag(amVar);
        ((FrsActivity) this.a).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.a).getLayoutMode().a(view);
        com.baidu.tieba.data.az azVar = (com.baidu.tieba.data.az) getItem(i);
        if (azVar instanceof g) {
            g gVar = (g) azVar;
            amVar.d.setText(gVar.w());
            amVar.e.setText(gVar.x());
            if (com.baidu.tieba.h.a.a().f()) {
                amVar.c.setVisibility(0);
                if (this.j) {
                    amVar.c.setSuffix("_small");
                } else {
                    amVar.c.setSuffix("_mobile");
                }
            } else {
                amVar.c.setVisibility(8);
            }
            amVar.c.setTag(gVar.v());
            amVar.f.setTag(Integer.valueOf(i));
            if (i2 == 1) {
                com.baidu.tieba.util.bq.e((View) amVar.b, (int) R.drawable.bg_label_1);
            } else {
                com.baidu.tieba.util.bq.e((View) amVar.b, (int) R.drawable.bg_label);
            }
            switch (gVar.A()) {
                case 0:
                    a(i2, amVar);
                    amVar.f.setText(R.string.download);
                    amVar.f.setOnClickListener(this.t);
                    break;
                case 1:
                    b(i2, amVar);
                    amVar.f.setText(R.string.downloading2);
                    amVar.f.setOnClickListener(null);
                    break;
                case 2:
                    b(i2, amVar);
                    amVar.f.setText(R.string.downloaded);
                    amVar.f.setOnClickListener(this.t);
                    break;
            }
        }
        return view;
    }

    private void a(int i, am amVar) {
        if (i == 1) {
            amVar.f.setBackgroundResource(R.drawable.faceshop_list_btn_selector_1);
            amVar.f.setTextColor(this.a.getResources().getColor(R.color.faceshop_btn_color_1));
            return;
        }
        amVar.f.setBackgroundResource(R.drawable.faceshop_list_btn_selector);
        amVar.f.setTextColor(this.a.getResources().getColor(R.color.faceshop_btn_color));
    }

    private void b(int i, am amVar) {
        if (i == 1) {
            amVar.f.setBackgroundResource(R.drawable.btn_content_download_d_1);
            amVar.f.setTextColor(this.a.getResources().getColor(R.color.faceshop_downloaded_text_1));
            return;
        }
        amVar.f.setBackgroundResource(R.drawable.btn_content_download_d);
        amVar.f.setTextColor(this.a.getResources().getColor(R.color.faceshop_downloaded_text));
    }

    private View g() {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.frs_item_app, (ViewGroup) null);
        am amVar = new am(this, null);
        amVar.a = (LinearLayout) inflate.findViewById(R.id.app_parent);
        amVar.d = (TextView) inflate.findViewById(R.id.app_name);
        amVar.e = (TextView) inflate.findViewById(R.id.app_desc);
        amVar.c = (HeadImageView) inflate.findViewById(R.id.app_icon);
        amVar.f = (TextView) inflate.findViewById(R.id.app_download);
        amVar.b = (TextView) inflate.findViewById(R.id.recommend_app);
        inflate.setTag(amVar);
        return inflate;
    }

    private View a(View view, int i) {
        an anVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.frs_item_control, (ViewGroup) null);
            an anVar2 = new an(this, null);
            anVar2.a = (FrameLayout) view.findViewById(R.id.frs_list_control);
            anVar2.b = (LinearLayout) view.findViewById(R.id.frs_list_control_in);
            anVar2.d = (ProgressBar) view.findViewById(R.id.frs_list_control_progress);
            anVar2.c = (TextView) view.findViewById(R.id.frs_list_control_tv);
            view.setTag(anVar2);
            anVar = anVar2;
        } else {
            anVar = (an) view.getTag();
        }
        if (this.c) {
            anVar.a.setVisibility(0);
            anVar.a.setPadding(0, this.o, 0, 0);
            if (this.f) {
                anVar.c.setText(R.string.loading);
                anVar.d.setVisibility(0);
            } else {
                anVar.c.setText(R.string.frs_pre);
                anVar.d.setVisibility(8);
            }
            if (i == 1) {
                anVar.b.setBackgroundResource(R.drawable.frs_item_control_bg_1);
            } else {
                anVar.b.setBackgroundResource(R.drawable.frs_item_control_bg);
            }
            com.baidu.tieba.util.bq.b(anVar.c, i);
        } else {
            anVar.a.setVisibility(8);
        }
        return view;
    }

    private View b(View view, int i) {
        an anVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.frs_item_control, (ViewGroup) null);
            an anVar2 = new an(this, null);
            anVar2.a = (FrameLayout) view.findViewById(R.id.frs_list_control);
            anVar2.b = (LinearLayout) view.findViewById(R.id.frs_list_control_in);
            anVar2.d = (ProgressBar) view.findViewById(R.id.frs_list_control_progress);
            anVar2.c = (TextView) view.findViewById(R.id.frs_list_control_tv);
            view.setTag(anVar2);
            anVar = anVar2;
        } else {
            anVar = (an) view.getTag();
        }
        if (this.d) {
            anVar.a.setVisibility(0);
            anVar.a.setPadding(0, this.o, 0, this.o);
            if (this.e) {
                anVar.c.setText(R.string.loading);
                anVar.d.setVisibility(0);
            } else {
                anVar.c.setText(R.string.frs_next);
                anVar.d.setVisibility(8);
            }
            if (i == 1) {
                anVar.b.setBackgroundResource(R.drawable.frs_item_control_bg_1);
            } else {
                anVar.b.setBackgroundResource(R.drawable.frs_item_control_bg);
            }
            com.baidu.tieba.util.bq.b(anVar.c, i);
        } else {
            anVar.a.setVisibility(8);
        }
        return view;
    }

    public void e() {
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
