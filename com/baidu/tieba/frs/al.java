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
public final class al extends BaseAdapter {
    private Context a;
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
    private View.OnClickListener t = new am(this);
    private ArrayList<com.baidu.tieba.data.az> b = null;

    private static int b(ArrayList<com.baidu.tieba.data.az> arrayList) {
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

    public al(Context context, ArrayList<com.baidu.tieba.data.az> arrayList, int i, boolean z) {
        this.h = 200;
        this.j = false;
        this.a = context;
        this.g = new com.baidu.tieba.util.i(this.a);
        this.g.b("frs");
        this.h = i;
        this.j = z;
        a(z);
        this.q = b(this.b);
        this.o = this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_margin);
        this.p = this.a.getResources().getDimensionPixelSize(R.dimen.listview_divider_height);
        this.s = new HashMap<>();
    }

    public final void a(boolean z) {
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
            this.g.f = "_small";
        } else {
            if (this.i > this.k * 480.0f) {
                this.i = (int) (this.k * 480.0f);
            }
            if (this.i > BdUtilHelper.a(this.a, 320.0f) * this.k) {
                this.i = (int) (BdUtilHelper.a(this.a, 320.0f) * this.k);
            }
            this.g.f = "_mobile";
        }
        this.g.a(this.i, this.i);
    }

    public final com.baidu.tieba.util.i a() {
        return this.g;
    }

    public final void b(boolean z) {
        this.e = z;
    }

    public final boolean b() {
        return this.e;
    }

    public final void c(boolean z) {
        this.f = z;
    }

    public final boolean c() {
        return this.f;
    }

    public final void d(boolean z) {
        this.c = z;
    }

    public final void e(boolean z) {
        this.d = z;
    }

    public final void a(ArrayList<com.baidu.tieba.data.az> arrayList) {
        ArrayList<Integer> arrayList2;
        this.b = arrayList;
        this.q = b(this.b);
        if (arrayList == null || arrayList.size() == 0) {
            arrayList2 = null;
        } else {
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            Iterator<com.baidu.tieba.data.az> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.data.az next = it.next();
                if (next instanceof g) {
                    int r = (((g) next).r() + this.q) - 1;
                    arrayList3.add(Integer.valueOf(r));
                    if (this.s != null && !this.s.containsValue(next)) {
                        this.s.put(Integer.valueOf(r), next);
                    }
                }
            }
            arrayList2 = arrayList3;
        }
        this.r = arrayList2;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null || this.b == null) {
            return 0;
        }
        int size = this.b.size() + 0;
        if (this.c) {
            size++;
        }
        if (this.d) {
            return size + 1;
        }
        return size;
    }

    public final HashMap<Integer, com.baidu.tieba.data.az> d() {
        return this.s;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.b.size()) {
            return null;
        }
        return this.b.get(itemId);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        int i2 = this.c ? i - 1 : i;
        if (this.d && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 5;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
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
    public final View getView(int i, View view, ViewGroup viewGroup) {
        aq aqVar;
        View view2;
        View view3;
        ap apVar;
        BitmapDrawable bitmapDrawable;
        ao aoVar;
        ao aoVar2;
        int ae = TiebaApplication.g().ae();
        switch (getItemViewType(i)) {
            case 0:
                if (view == null) {
                    view = LayoutInflater.from(this.a).inflate(R.layout.frs_item_control, (ViewGroup) null);
                    ao aoVar3 = new ao(this, (byte) 0);
                    aoVar3.a = (FrameLayout) view.findViewById(R.id.frs_list_control);
                    aoVar3.b = (LinearLayout) view.findViewById(R.id.frs_list_control_in);
                    aoVar3.d = (ProgressBar) view.findViewById(R.id.frs_list_control_progress);
                    aoVar3.c = (TextView) view.findViewById(R.id.frs_list_control_tv);
                    view.setTag(aoVar3);
                    aoVar2 = aoVar3;
                } else {
                    aoVar2 = (ao) view.getTag();
                }
                if (!this.c) {
                    aoVar2.a.setVisibility(8);
                    return view;
                }
                aoVar2.a.setVisibility(0);
                aoVar2.a.setPadding(0, this.o, 0, 0);
                if (this.f) {
                    aoVar2.c.setText(R.string.loading);
                    aoVar2.d.setVisibility(0);
                } else {
                    aoVar2.c.setText(R.string.frs_pre);
                    aoVar2.d.setVisibility(8);
                }
                if (ae == 1) {
                    aoVar2.b.setBackgroundResource(R.drawable.frs_item_control_bg_1);
                } else {
                    aoVar2.b.setBackgroundResource(R.drawable.frs_item_control_bg);
                }
                com.baidu.tieba.util.bq.b(aoVar2.c, ae);
                return view;
            case 1:
                if (view == null) {
                    view = LayoutInflater.from(this.a).inflate(R.layout.frs_item_control, (ViewGroup) null);
                    ao aoVar4 = new ao(this, (byte) 0);
                    aoVar4.a = (FrameLayout) view.findViewById(R.id.frs_list_control);
                    aoVar4.b = (LinearLayout) view.findViewById(R.id.frs_list_control_in);
                    aoVar4.d = (ProgressBar) view.findViewById(R.id.frs_list_control_progress);
                    aoVar4.c = (TextView) view.findViewById(R.id.frs_list_control_tv);
                    view.setTag(aoVar4);
                    aoVar = aoVar4;
                } else {
                    aoVar = (ao) view.getTag();
                }
                if (!this.d) {
                    aoVar.a.setVisibility(8);
                    return view;
                }
                aoVar.a.setVisibility(0);
                aoVar.a.setPadding(0, this.o, 0, this.o);
                if (this.e) {
                    aoVar.c.setText(R.string.loading);
                    aoVar.d.setVisibility(0);
                } else {
                    aoVar.c.setText(R.string.frs_next);
                    aoVar.d.setVisibility(8);
                }
                if (ae == 1) {
                    aoVar.b.setBackgroundResource(R.drawable.frs_item_control_bg_1);
                } else {
                    aoVar.b.setBackgroundResource(R.drawable.frs_item_control_bg);
                }
                com.baidu.tieba.util.bq.b(aoVar.c, ae);
                return view;
            case 2:
                ap apVar2 = null;
                if (view == null) {
                    view2 = f();
                    apVar2 = (ap) view2.getTag();
                } else {
                    view2 = view;
                }
                if (apVar2 == null) {
                    View f = f();
                    view3 = f;
                    apVar = (ap) f.getTag();
                } else {
                    view3 = view2;
                    apVar = apVar2;
                }
                ((FrsActivity) this.a).getLayoutMode().a(ae == 1);
                ((FrsActivity) this.a).getLayoutMode().a(view3);
                com.baidu.tieba.data.az azVar = (com.baidu.tieba.data.az) getItem(i);
                apVar.b.setText(azVar.c());
                com.baidu.tieba.util.bo am = TiebaApplication.g().am();
                if (am != null && am.b(azVar.a())) {
                    apVar.b.setTextColor(this.a.getResources().getColor(R.color.read_thread_color));
                }
                if (ae == 1) {
                    bitmapDrawable = azVar.f() == 1 ? (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_top_1) : azVar.f() == 2 ? (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_notice_1) : null;
                    if (this.q == 1) {
                        apVar.a.setBackgroundResource(R.drawable.bg_frs_top_selector_1);
                        apVar.c.setVisibility(8);
                    } else if (this.q >= 2) {
                        if (i == 0) {
                            apVar.a.setBackgroundResource(R.drawable.bg_frs_top_up_selector_1);
                            apVar.c.setVisibility(0);
                        } else if (i == this.q - 1) {
                            apVar.a.setBackgroundResource(R.drawable.bg_frs_top_down_selector_1);
                            apVar.c.setVisibility(8);
                        } else {
                            apVar.a.setBackgroundResource(R.drawable.bg_frs_top_middle_selector_1);
                            apVar.c.setVisibility(0);
                        }
                    }
                } else {
                    bitmapDrawable = azVar.f() == 1 ? (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_top) : azVar.f() == 2 ? (BitmapDrawable) this.a.getResources().getDrawable(R.drawable.icon_notice) : null;
                    if (this.q == 1) {
                        apVar.a.setBackgroundResource(R.drawable.bg_frs_top_selector);
                        apVar.c.setVisibility(8);
                    } else if (this.q >= 2) {
                        if (i == 0) {
                            apVar.a.setBackgroundResource(R.drawable.bg_frs_top_up_selector);
                        } else if (i == this.q - 1) {
                            apVar.a.setBackgroundResource(R.drawable.bg_frs_top_down_selector);
                            apVar.c.setVisibility(8);
                        } else {
                            apVar.a.setBackgroundResource(R.drawable.bg_frs_top_middle_selector);
                        }
                    }
                }
                if (bitmapDrawable != null) {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                }
                apVar.b.setCompoundDrawables(bitmapDrawable, null, null, null);
                return view3;
            case 3:
                if (view == null) {
                    view = LayoutInflater.from(this.a).inflate(R.layout.frs_item, (ViewGroup) null);
                    aq aqVar2 = new aq(this, (byte) 0);
                    aqVar2.a = (LinearLayout) view.findViewById(R.id.frs_list);
                    aqVar2.b = (LinearLayout) view.findViewById(R.id.frs_list_item_top);
                    aqVar2.c = (RelativeLayout) view.findViewById(R.id.item_bottom_layout);
                    aqVar2.g = (TextView) view.findViewById(R.id.frs_lv_reply_num);
                    aqVar2.k = (ImageView) view.findViewById(R.id.frs_discuss_icon);
                    aqVar2.h = (TextView) view.findViewById(R.id.frs_lv_reply_time);
                    aqVar2.i = (TextView) view.findViewById(R.id.frs_lv_title);
                    aqVar2.j = (TextView) view.findViewById(R.id.frs_lv_author);
                    aqVar2.d = (TextView) view.findViewById(R.id.abstract_text);
                    aqVar2.f = (CommonImageLayout) view.findViewById(R.id.abstract_img_layout);
                    aqVar2.e = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
                    aqVar2.l = (ViewGroup) view.findViewById(R.id.frs_list_divider_wrapper);
                    aqVar2.m = (DottedLine) view.findViewById(R.id.frs_list_divider);
                    aqVar2.n = (UserIconBox) view.findViewById(R.id.user_icon_box);
                    aqVar2.o = (UserIconBox) view.findViewById(R.id.user_tshow_icon_box);
                    view.setTag(aqVar2);
                    aqVar = aqVar2;
                } else {
                    aqVar = (aq) view.getTag();
                }
                if (ae == 1) {
                    aqVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg_1);
                    aqVar.c.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg_1);
                } else {
                    aqVar.b.setBackgroundResource(R.drawable.forumfeed_frs_list_item_top_bg);
                    aqVar.c.setBackgroundResource(R.drawable.forumfeed_frs_list_item_foot_bg);
                }
                aqVar.a.setPadding(0, i - this.q == 0 ? this.o : this.p, 0, 0);
                aqVar.l.setVisibility(8);
                ((FrsActivity) this.a).getLayoutMode().a(ae == 1);
                ((FrsActivity) this.a).getLayoutMode().a(view);
                com.baidu.tieba.data.az azVar2 = (com.baidu.tieba.data.az) getItem(i);
                int d = azVar2.d();
                aqVar.k.setVisibility(0);
                if (d > 999999) {
                    aqVar.g.setText("999999+");
                } else if (d > 0) {
                    aqVar.g.setText(String.valueOf(d));
                } else {
                    aqVar.g.setText((CharSequence) null);
                    aqVar.k.setVisibility(4);
                }
                aqVar.h.setText(com.baidu.tieba.util.bs.a(azVar2.e() * 1000));
                aqVar.i.setText(azVar2.p());
                com.baidu.tieba.util.bo am2 = TiebaApplication.g().am();
                if (am2 != null && am2.b(azVar2.a())) {
                    aqVar.i.setTextColor(ae == 1 ? this.a.getResources().getColor(R.color.listview_item_thread_read_1) : this.a.getResources().getColor(R.color.listview_item_thread_read));
                }
                aqVar.j.setText(azVar2.i().getUserName());
                this.m = azVar2.i().getIconInfo();
                this.n = azVar2.i().getTShowInfo();
                if (aqVar.n != null) {
                    aqVar.n.a(this.m, 3, this.a.getResources().getDimensionPixelSize(R.dimen.frs_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.frs_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.frs_icon_margin));
                }
                if (aqVar.o != null) {
                    aqVar.o.a(this.n, 2, this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.small_icon_margin));
                }
                if (this.n == null || this.n.size() <= 0) {
                    aqVar.j.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.listview_item_padding), 0, 0, 0);
                } else {
                    aqVar.j.setPadding(0, 0, 0, 0);
                }
                aqVar.c.setVisibility(0);
                aqVar.f.setVisibility(0);
                aqVar.e.setVisibility(0);
                aqVar.d.setVisibility(0);
                StringBuffer stringBuffer = new StringBuffer();
                if (azVar2.k() != null && azVar2.k().trim().length() > 0) {
                    stringBuffer.append(azVar2.k());
                }
                ArrayList<com.baidu.tieba.data.ah> n = azVar2.n();
                if (n != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= n.size()) {
                            stringBuffer.append(stringBuffer2.toString());
                            if (stringBuffer.length() > 0) {
                                aqVar.d.setText(stringBuffer.toString());
                            } else {
                                aqVar.d.setVisibility(8);
                            }
                        } else {
                            if (n.get(i3).c() != null && n.get(i3).c().endsWith("swf")) {
                                stringBuffer2.append(n.get(i3).c());
                            }
                            i2 = i3 + 1;
                        }
                    }
                }
                if (!com.baidu.tieba.h.a.a().f()) {
                    aqVar.f.setVisibility(8);
                } else if (n != null) {
                    if (n.size() > 0) {
                        int i4 = 0;
                        int i5 = 0;
                        while (true) {
                            int i6 = i4;
                            if (i6 >= n.size()) {
                                int i7 = i5 > 3 ? 3 : i5;
                                if (i7 > 0) {
                                    com.baidu.tieba.data.ah[] ahVarArr = new com.baidu.tieba.data.ah[i7];
                                    int i8 = 0;
                                    int i9 = 0;
                                    while (true) {
                                        int i10 = i8;
                                        int i11 = i9;
                                        if (i10 < n.size() && i11 < i7) {
                                            if (n.get(i10).a() == 3 || n.get(i10).a() == 5) {
                                                ahVarArr[i11] = n.get(i10);
                                                i9 = i11 + 1;
                                            } else {
                                                i9 = i11;
                                            }
                                            i8 = i10 + 1;
                                        }
                                    }
                                    aqVar.f.setShowBig(this.j);
                                    aqVar.f.setData(ahVarArr);
                                    aqVar.f.setImageFrom("frs");
                                    aqVar.f.setFromCDN(this.l);
                                }
                            } else {
                                if (n.get(i6) != null && (n.get(i6).a() == 3 || n.get(i6).a() == 5)) {
                                    i5++;
                                }
                                i4 = i6 + 1;
                            }
                        }
                    } else {
                        aqVar.f.setVisibility(8);
                    }
                }
                ArrayList<VoiceManager.VoiceModel> o = azVar2.o();
                if (o == null || o.size() <= 0) {
                    aqVar.e.setVisibility(8);
                } else {
                    VoiceManager.VoiceModel voiceModel = o.get(0);
                    aqVar.e.setVoiceModel(voiceModel);
                    aqVar.e.setTag(voiceModel);
                    aqVar.e.a();
                }
                aqVar.c.setVisibility(0);
                return view;
            case 4:
                if (view == null) {
                    view = LayoutInflater.from(this.a).inflate(R.layout.frs_item_app, (ViewGroup) null);
                    an anVar = new an(this, (byte) 0);
                    anVar.a = (LinearLayout) view.findViewById(R.id.app_parent);
                    anVar.d = (TextView) view.findViewById(R.id.app_name);
                    anVar.e = (TextView) view.findViewById(R.id.app_desc);
                    anVar.c = (HeadImageView) view.findViewById(R.id.app_icon);
                    anVar.f = (TextView) view.findViewById(R.id.app_download);
                    anVar.b = (TextView) view.findViewById(R.id.recommend_app);
                    view.setTag(anVar);
                }
                an anVar2 = (an) view.getTag();
                anVar2.a.setPadding(0, i - this.q == 0 ? this.o : this.p, 0, 0);
                view.setTag(anVar2);
                ((FrsActivity) this.a).getLayoutMode().a(ae == 1);
                ((FrsActivity) this.a).getLayoutMode().a(view);
                com.baidu.tieba.data.az azVar3 = (com.baidu.tieba.data.az) getItem(i);
                if (azVar3 instanceof g) {
                    g gVar = (g) azVar3;
                    anVar2.d.setText(gVar.t());
                    anVar2.e.setText(gVar.u());
                    if (com.baidu.tieba.h.a.a().f()) {
                        anVar2.c.setVisibility(0);
                        if (this.j) {
                            anVar2.c.setSuffix("_small");
                        } else {
                            anVar2.c.setSuffix("_mobile");
                        }
                    } else {
                        anVar2.c.setVisibility(8);
                    }
                    anVar2.c.setTag(gVar.s());
                    anVar2.f.setTag(Integer.valueOf(i));
                    if (ae == 1) {
                        com.baidu.tieba.util.bq.e((View) anVar2.b, (int) R.drawable.bg_label_1);
                    } else {
                        com.baidu.tieba.util.bq.e((View) anVar2.b, (int) R.drawable.bg_label);
                    }
                    switch (gVar.x()) {
                        case 0:
                            if (ae == 1) {
                                anVar2.f.setBackgroundResource(R.drawable.faceshop_list_btn_selector_1);
                                anVar2.f.setTextColor(this.a.getResources().getColor(R.color.faceshop_btn_color_1));
                            } else {
                                anVar2.f.setBackgroundResource(R.drawable.faceshop_list_btn_selector);
                                anVar2.f.setTextColor(this.a.getResources().getColor(R.color.faceshop_btn_color));
                            }
                            anVar2.f.setText(R.string.download);
                            anVar2.f.setOnClickListener(this.t);
                            return view;
                        case 1:
                            a(ae, anVar2);
                            anVar2.f.setText(R.string.downloading2);
                            anVar2.f.setOnClickListener(null);
                            return view;
                        case 2:
                            a(ae, anVar2);
                            anVar2.f.setText(R.string.downloaded);
                            anVar2.f.setOnClickListener(this.t);
                            return view;
                        default:
                            return view;
                    }
                }
                return view;
            default:
                return null;
        }
    }

    private View f() {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.frs_top_item, (ViewGroup) null);
        ap apVar = new ap(this, (byte) 0);
        apVar.a = (LinearLayout) inflate.findViewById(R.id.frs_top_item);
        apVar.b = (TextView) inflate.findViewById(R.id.frs_top_title);
        apVar.c = inflate.findViewById(R.id.frs_top_divider);
        inflate.setTag(apVar);
        return inflate;
    }

    private void a(int i, an anVar) {
        if (i == 1) {
            anVar.f.setBackgroundResource(R.drawable.btn_content_download_d_1);
            anVar.f.setTextColor(this.a.getResources().getColor(R.color.faceshop_downloaded_text_1));
            return;
        }
        anVar.f.setBackgroundResource(R.drawable.btn_content_download_d);
        anVar.f.setTextColor(this.a.getResources().getColor(R.color.faceshop_downloaded_text));
    }

    public final void e() {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size && this.b.get(i).f() != 0; i++) {
                this.b.get(i).q();
            }
        }
    }

    public final void f(boolean z) {
        this.l = z;
        this.g.a(z);
    }
}
