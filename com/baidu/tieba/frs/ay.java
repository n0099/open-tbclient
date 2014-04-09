package com.baidu.tieba.frs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.frs.view.FrsReplyView;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes.dex */
public final class ay extends BaseAdapter implements View.OnClickListener {
    private final Context a;
    private g c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final com.baidu.tbadk.editortool.ab h;
    private int i;
    private boolean k;
    private final int o;
    private final int p;
    private int s;
    private ArrayList<Integer> t;
    private final HashMap<Integer, com.baidu.tbadk.core.data.o> u;
    private ListView v;
    private bf x;
    private int j = 200;
    private final float l = 0.4f;
    private boolean m = false;
    private LinkedList<IconData> n = null;
    private long q = 0;
    private boolean r = true;
    private final View.OnClickListener w = new az(this);
    private ArrayList<com.baidu.tbadk.core.data.o> b = null;

    private static int a(ArrayList<com.baidu.tbadk.core.data.o> arrayList) {
        int i = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.tbadk.core.data.o> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.tbadk.core.data.o next = it.next();
                if (next.q() == 1 || next.q() == 2) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    public ay(Context context, ArrayList<com.baidu.tbadk.core.data.o> arrayList, int i, boolean z) {
        this.i = 200;
        this.k = false;
        this.a = context;
        this.h = new com.baidu.tbadk.editortool.ab(this.a);
        this.h.b("frs");
        this.i = i;
        this.k = z;
        a(z);
        this.s = a(this.b);
        this.o = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.listview_item_margin);
        this.p = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.listview_divider_height);
        this.u = new HashMap<>();
    }

    public final void a(boolean z) {
        if (this.k != z) {
            this.k = z;
        }
        this.j = this.i;
        if (this.k) {
            if (this.j > 480) {
                this.j = 480;
            }
            if (this.j > com.baidu.adp.lib.util.i.a(this.a, 320.0f)) {
                this.j = com.baidu.adp.lib.util.i.a(this.a, 320.0f);
            }
            this.h.f = "_small";
        } else {
            if (this.j > 192.0f) {
                this.j = 192;
            }
            if (this.j > com.baidu.adp.lib.util.i.a(this.a, 320.0f) * 0.4f) {
                this.j = (int) (com.baidu.adp.lib.util.i.a(this.a, 320.0f) * 0.4f);
            }
            this.h.f = "_mobile";
        }
        this.h.a(this.j, this.j);
    }

    public final com.baidu.tbadk.editortool.ab a() {
        return this.h;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final boolean b() {
        return this.f;
    }

    public final void c(boolean z) {
        this.g = z;
    }

    public final boolean c() {
        return this.g;
    }

    public final void d(boolean z) {
        this.d = z;
    }

    public final void e(boolean z) {
        this.e = z;
    }

    public final void a(ArrayList<com.baidu.tbadk.core.data.o> arrayList, g gVar) {
        ArrayList<Integer> arrayList2;
        this.b = arrayList;
        this.c = gVar;
        this.s = a(this.b);
        if (arrayList == null || arrayList.size() == 0) {
            arrayList2 = null;
        } else {
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.o oVar = arrayList.get(i2);
                if (oVar instanceof com.baidu.tbadk.core.data.b) {
                    arrayList3.add(Integer.valueOf(i2));
                    if (this.u != null && !this.u.containsValue(oVar)) {
                        this.u.put(Integer.valueOf(i2), oVar);
                    }
                }
                i = i2 + 1;
            }
            arrayList2 = arrayList3;
        }
        this.t = arrayList2;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null || this.b == null) {
            return 0;
        }
        int size = this.b.size() + 0;
        if (this.d) {
            size++;
        }
        if (this.e) {
            return size + 1;
        }
        return size;
    }

    public final HashMap<Integer, com.baidu.tbadk.core.data.o> d() {
        return this.u;
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
        int i2 = this.d ? i - 1 : i;
        if (this.e && i == getCount() - 1) {
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
        if (this.d && i == 0) {
            return 0;
        }
        if (this.e && i == getCount() - 1) {
            return 1;
        }
        if (i < this.s) {
            return 2;
        }
        if (this.t.contains(Integer.valueOf(i))) {
            return 4;
        }
        return 3;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x069a: INVOKE  (r2v81 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x0696: INVOKE  (r2v80 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tbadk.core.data.o) type: VIRTUAL call: com.baidu.tbadk.core.data.o.k():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        bi biVar;
        View view2;
        View view3;
        bh bhVar;
        BitmapDrawable bitmapDrawable;
        be beVar;
        be beVar2;
        int l = TbadkApplication.j().l();
        this.v = (ListView) viewGroup;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null) {
                    view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.frs_item_control, (ViewGroup) null);
                    be beVar3 = new be(this, (byte) 0);
                    beVar3.a = (FrameLayout) view.findViewById(com.baidu.tieba.a.h.frs_list_control);
                    beVar3.b = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.frs_list_control_in);
                    beVar3.d = (ProgressBar) view.findViewById(com.baidu.tieba.a.h.frs_list_control_progress);
                    beVar3.c = (TextView) view.findViewById(com.baidu.tieba.a.h.frs_list_control_tv);
                    view.setTag(beVar3);
                    beVar2 = beVar3;
                } else {
                    beVar2 = (be) view.getTag();
                }
                if (!this.d) {
                    beVar2.a.setVisibility(8);
                    return view;
                }
                beVar2.a.setVisibility(0);
                beVar2.a.setPadding(0, this.o, 0, 0);
                if (this.g) {
                    beVar2.c.setText(com.baidu.tieba.a.k.loading);
                    beVar2.d.setVisibility(0);
                } else {
                    beVar2.c.setText(com.baidu.tieba.a.k.frs_pre);
                    beVar2.d.setVisibility(8);
                }
                if (l == 1) {
                    beVar2.b.setBackgroundResource(com.baidu.tieba.a.g.frs_item_control_bg_1);
                } else {
                    beVar2.b.setBackgroundResource(com.baidu.tieba.a.g.frs_item_control_bg);
                }
                com.baidu.tbadk.core.util.ba.b(beVar2.c, l);
                return view;
            case 1:
                if (view == null) {
                    view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.frs_item_control, (ViewGroup) null);
                    be beVar4 = new be(this, (byte) 0);
                    beVar4.a = (FrameLayout) view.findViewById(com.baidu.tieba.a.h.frs_list_control);
                    beVar4.b = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.frs_list_control_in);
                    beVar4.d = (ProgressBar) view.findViewById(com.baidu.tieba.a.h.frs_list_control_progress);
                    beVar4.c = (TextView) view.findViewById(com.baidu.tieba.a.h.frs_list_control_tv);
                    view.setTag(beVar4);
                    beVar = beVar4;
                } else {
                    beVar = (be) view.getTag();
                }
                if (!this.e) {
                    beVar.a.setVisibility(8);
                    return view;
                }
                beVar.a.setVisibility(0);
                beVar.a.setPadding(0, this.o, 0, this.o);
                if (this.f) {
                    beVar.c.setText(com.baidu.tieba.a.k.loading);
                    beVar.d.setVisibility(0);
                } else {
                    beVar.c.setText(com.baidu.tieba.a.k.frs_next);
                    beVar.d.setVisibility(8);
                }
                if (l == 1) {
                    beVar.b.setBackgroundResource(com.baidu.tieba.a.g.frs_item_control_bg_1);
                } else {
                    beVar.b.setBackgroundResource(com.baidu.tieba.a.g.frs_item_control_bg);
                }
                com.baidu.tbadk.core.util.ba.b(beVar.c, l);
                return view;
            case 2:
                bh bhVar2 = null;
                if (view == null) {
                    view2 = j();
                    bhVar2 = (bh) view2.getTag();
                } else {
                    view2 = view;
                }
                if (bhVar2 == null) {
                    View j = j();
                    view3 = j;
                    bhVar = (bh) j.getTag();
                } else {
                    view3 = view2;
                    bhVar = bhVar2;
                }
                ((FrsActivity) this.a).getLayoutMode().a(l == 1);
                ((FrsActivity) this.a).getLayoutMode().a(view3);
                com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) getItem(i);
                bhVar.b.setText(oVar.n());
                com.baidu.tieba.util.p z = com.baidu.tieba.p.c().z();
                if (z != null && z.b(oVar.l())) {
                    bhVar.b.setTextColor(l == 1 ? this.a.getResources().getColor(com.baidu.tieba.a.e.listview_item_thread_read_1) : this.a.getResources().getColor(com.baidu.tieba.a.e.listview_item_thread_read));
                }
                if (l == 1) {
                    bitmapDrawable = oVar.q() == 1 ? (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.a.g.icon_top_1) : oVar.q() == 2 ? (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.a.g.icon_notice_1) : null;
                    bhVar.a.setBackgroundResource(com.baidu.tieba.a.g.frs_top_item_bg_1);
                } else {
                    bitmapDrawable = oVar.q() == 1 ? (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.a.g.icon_top) : oVar.q() == 2 ? (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.a.g.icon_notice) : null;
                    bhVar.a.setBackgroundResource(com.baidu.tieba.a.g.frs_top_item_bg);
                }
                if (bitmapDrawable != null) {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                }
                bhVar.b.setCompoundDrawables(bitmapDrawable, null, null, null);
                return view3;
            case 3:
                if (view == null) {
                    view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.frs_item, (ViewGroup) null);
                    bi biVar2 = new bi(this, (byte) 0);
                    biVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.frs_list);
                    biVar2.w = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.frs_item_user_info_view);
                    biVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.frs_list_item_top_linear_layout);
                    biVar2.j = (HeadImageView) view.findViewById(com.baidu.tieba.a.h.frs_photo);
                    biVar2.i = (UserIconBox) view.findViewById(com.baidu.tieba.a.h.frs_user_tshow_icon_box);
                    biVar2.h = (TextView) view.findViewById(com.baidu.tieba.a.h.frs_lv_author);
                    biVar2.f = (TextView) view.findViewById(com.baidu.tieba.a.h.frs_lv_reply_time);
                    biVar2.g = (TextView) view.findViewById(com.baidu.tieba.a.h.frs_lv_title);
                    biVar2.c = (TextView) view.findViewById(com.baidu.tieba.a.h.abstract_text);
                    biVar2.d = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.a.h.abstract_voice);
                    biVar2.e = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.a.h.abstract_img_layout);
                    biVar2.k = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.frs_praise_btn);
                    biVar2.l = (ImageView) view.findViewById(com.baidu.tieba.a.h.frs_praise_icon);
                    biVar2.m = (TextView) view.findViewById(com.baidu.tieba.a.h.frs_praise_num);
                    biVar2.n = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.frs_reply_btn);
                    biVar2.o = (TextView) view.findViewById(com.baidu.tieba.a.h.frs_reply_num);
                    biVar2.p = (FrsPraiseView) view.findViewById(com.baidu.tieba.a.h.frs_praise_list_user_icon);
                    biVar2.q = (TextView) view.findViewById(com.baidu.tieba.a.h.frs_more_abstract);
                    biVar2.r = view.findViewById(com.baidu.tieba.a.h.frs_item_praise_divider_line);
                    biVar2.s = (FrsReplyView) view.findViewById(com.baidu.tieba.a.h.frs_item_reply_item1);
                    biVar2.t = (FrsReplyView) view.findViewById(com.baidu.tieba.a.h.frs_item_reply_item2);
                    biVar2.u = (FrsReplyView) view.findViewById(com.baidu.tieba.a.h.frs_item_reply_item3);
                    biVar2.v = (TextView) view.findViewById(com.baidu.tieba.a.h.frs_item_more_reply_text);
                    biVar2.x = view.findViewById(com.baidu.tieba.a.h.frs_item_praise_divider_line2);
                    biVar2.y = view.findViewById(com.baidu.tieba.a.h.frs_item_reply_view_di);
                    view.setTag(biVar2);
                    biVar = biVar2;
                } else {
                    biVar = (bi) view.getTag();
                }
                if (l == 1) {
                    biVar.b.setBackgroundResource(com.baidu.tieba.a.g.frs_item_control_btn_bg_1);
                    biVar.n.setBackgroundResource(com.baidu.tieba.a.g.frs_praise_btn_bg_1);
                    biVar.k.setBackgroundResource(com.baidu.tieba.a.g.frs_praise_btn_bg_1);
                    biVar.q.setBackgroundResource(com.baidu.tieba.a.g.frs_item_abstract_more_text_bg_1);
                } else {
                    biVar.b.setBackgroundResource(com.baidu.tieba.a.g.frs_item_control_btn_bg);
                    biVar.n.setBackgroundResource(com.baidu.tieba.a.g.frs_praise_btn_bg);
                    biVar.k.setBackgroundResource(com.baidu.tieba.a.g.frs_praise_btn_bg);
                    biVar.q.setBackgroundResource(com.baidu.tieba.a.g.frs_item_abstract_more_text_bg);
                }
                biVar.k.setOnClickListener(this);
                com.baidu.adp.lib.util.i.a(this.a, biVar.k, 0, 10, 0, 20);
                biVar.n.setOnClickListener(this);
                com.baidu.adp.lib.util.i.a(this.a, biVar.n, 0, 10, 0, 20);
                biVar.q.setOnClickListener(this);
                biVar.v.setOnClickListener(this);
                biVar.k.setOnTouchListener(new bg(this, (byte) 0));
                biVar.n.setTag(Integer.valueOf(i));
                biVar.k.setTag(Integer.valueOf(i));
                biVar.q.setTag(Integer.valueOf(i));
                biVar.v.setTag(Integer.valueOf(i));
                ((FrsActivity) this.a).getLayoutMode().a(l == 1);
                ((FrsActivity) this.a).getLayoutMode().a(view);
                int i2 = i - this.s;
                if (i2 != 0) {
                    biVar.a.setBackgroundColor(17170445);
                } else if (l == 1) {
                    biVar.a.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.a.g.bg_frs_1));
                } else {
                    biVar.a.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.a.g.bg_frs));
                }
                biVar.a.setPadding(0, i2 == 0 ? this.o : this.p, 0, 0);
                com.baidu.tbadk.core.data.o oVar2 = (com.baidu.tbadk.core.data.o) getItem(i);
                biVar.f.setText(com.baidu.tbadk.core.util.bc.a(oVar2.p() * 1000));
                String portrait = oVar2.t().getPortrait();
                com.baidu.tbadk.editortool.ab abVar = this.h;
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                biVar.j.setUserId(oVar2.t().getUserId());
                biVar.j.setImageBitmap(null);
                if (b != null) {
                    b.a(biVar.j);
                } else {
                    biVar.j.setTag(portrait);
                    biVar.j.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.photo));
                }
                biVar.w.setOnClickListener(new ba(this, oVar2));
                oVar2.t().getIconInfo();
                this.n = oVar2.t().getTShowInfo();
                if (this.n == null || this.n.size() <= 0) {
                    biVar.i.setVisibility(8);
                    if (l == 1) {
                        biVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_lv_item_user_name_1));
                    } else {
                        biVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_lv_item_user_name));
                    }
                } else {
                    biVar.i.setVisibility(0);
                    if (l == 1) {
                        biVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_lv_item_user_name_vip_1));
                    } else {
                        biVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.frs_lv_item_user_name_vip));
                    }
                    biVar.i.a(this.n, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.small_icon_margin));
                }
                biVar.h.setText(oVar2.t().getUserName());
                biVar.e.setVisibility(0);
                biVar.c.setVisibility(0);
                oVar2.E();
                biVar.g.setText(oVar2.D());
                com.baidu.tieba.util.p z2 = com.baidu.tieba.p.c().z();
                if (z2 != null && z2.b(oVar2.l())) {
                    biVar.g.setTextColor(l == 1 ? this.a.getResources().getColor(com.baidu.tieba.a.e.listview_item_thread_read_1) : this.a.getResources().getColor(com.baidu.tieba.a.e.listview_item_thread_read));
                }
                if (oVar2.B() == 1) {
                    biVar.g.setVisibility(8);
                } else {
                    biVar.g.setVisibility(0);
                }
                StringBuffer stringBuffer = new StringBuffer();
                if (oVar2.w() != null && oVar2.w().trim().length() > 0) {
                    stringBuffer.append(oVar2.w());
                }
                ArrayList<com.baidu.tbadk.core.data.j> z3 = oVar2.z();
                if (z3 != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= z3.size()) {
                            stringBuffer.append(stringBuffer2.toString());
                            if (stringBuffer.length() <= 0) {
                                biVar.q.setVisibility(8);
                                biVar.c.setVisibility(8);
                            } else if (stringBuffer.length() > 170) {
                                biVar.q.setVisibility(0);
                                biVar.c.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                            } else {
                                biVar.q.setVisibility(8);
                                biVar.c.setText(stringBuffer.toString());
                            }
                        } else {
                            if (z3.get(i4).d() != null && z3.get(i4).d().endsWith("swf")) {
                                stringBuffer2.append(z3.get(i4).d());
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (!com.baidu.tbadk.core.h.a().f()) {
                    biVar.e.setVisibility(8);
                } else if (z3 != null) {
                    if (z3.size() > 0) {
                        int i5 = 0;
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            int i8 = i5;
                            if (i8 < z3.size()) {
                                if (z3.get(i8) != null && (z3.get(i8).b() == 3 || z3.get(i8).b() == 5)) {
                                    i6++;
                                    i7++;
                                }
                                i5 = i8 + 1;
                            } else if (i6 > 0) {
                                com.baidu.tbadk.core.data.j[] jVarArr = new com.baidu.tbadk.core.data.j[i6];
                                int i9 = 0;
                                int i10 = 0;
                                while (true) {
                                    int i11 = i9;
                                    int i12 = i10;
                                    if (i11 < z3.size() && i12 < i6) {
                                        if (z3.get(i11).b() == 3 || z3.get(i11).b() == 5) {
                                            jVarArr[i12] = z3.get(i11);
                                            i10 = i12 + 1;
                                        } else {
                                            i10 = i12;
                                        }
                                        i9 = i11 + 1;
                                    }
                                }
                                biVar.e.a(this.c.f().getName(), this.c.f().getId(), oVar2.m());
                                biVar.e.setShowBig(this.k);
                                biVar.e.setDrawNum(true);
                                biVar.e.a(jVarArr, i7);
                                biVar.e.setImageFrom("other");
                                biVar.e.setFromCDN(this.m);
                            }
                        }
                    } else {
                        biVar.e.setVisibility(8);
                    }
                }
                ArrayList<VoiceData.VoiceModel> A = oVar2.A();
                if (A == null || A.size() <= 0) {
                    biVar.d.setVisibility(8);
                } else {
                    biVar.d.setVisibility(0);
                    VoiceData.VoiceModel voiceModel = A.get(0);
                    biVar.d.setVoiceModel(voiceModel);
                    biVar.d.setTag(voiceModel);
                    biVar.d.a();
                }
                if (oVar2.k() == null || oVar2.k().getNum() <= 0) {
                    biVar.r.setVisibility(8);
                    biVar.p.setVisibility(8);
                    biVar.m.setText(this.a.getResources().getString(com.baidu.tieba.a.k.frs_item_praise_text));
                    if (l == 1) {
                        biVar.l.setImageResource(com.baidu.tieba.a.g.icon_hand_normal_1);
                    } else {
                        biVar.l.setImageResource(com.baidu.tieba.a.g.icon_hand_normal);
                    }
                } else {
                    biVar.p.setVisibility(0);
                    biVar.p.setIsFromPb(false);
                    biVar.p.a(l);
                    biVar.r.setVisibility(0);
                    if (oVar2.k().getIsLike() == 1) {
                        if (l == 1) {
                            biVar.l.setImageResource(com.baidu.tieba.a.g.icon_hand_click_1);
                        } else {
                            biVar.l.setImageResource(com.baidu.tieba.a.g.icon_hand_click);
                        }
                    } else if (l == 1) {
                        biVar.l.setImageResource(com.baidu.tieba.a.g.icon_hand_normal_1);
                    } else {
                        biVar.l.setImageResource(com.baidu.tieba.a.g.icon_hand_normal);
                    }
                    biVar.p.setImageLoad(this.h);
                    biVar.p.a(oVar2.k(), oVar2.l(), oVar2.j(), false);
                    if (oVar2.k().getNum() <= 999999) {
                        biVar.m.setText(new StringBuilder().append(oVar2.k().getNum()).toString());
                    } else {
                        biVar.m.setText("999999+");
                    }
                }
                int size = oVar2.h().size() > 3 ? 3 : oVar2.h().size();
                if (size <= 0) {
                    biVar.s.setVisibility(8);
                    biVar.t.setVisibility(8);
                    biVar.u.setVisibility(8);
                    biVar.x.setVisibility(8);
                } else if (size == 1) {
                    biVar.x.setVisibility(0);
                    biVar.s.setVisibility(0);
                    biVar.t.setVisibility(8);
                    biVar.u.setVisibility(8);
                    biVar.s.a(l);
                    biVar.s.setData(oVar2.h().get(0));
                } else if (size == 2) {
                    biVar.x.setVisibility(0);
                    biVar.s.setVisibility(0);
                    biVar.t.setVisibility(0);
                    biVar.u.setVisibility(8);
                    biVar.s.a(l);
                    biVar.s.setData(oVar2.h().get(0));
                    biVar.t.a(l);
                    biVar.t.setData(oVar2.h().get(1));
                } else if (size == 3) {
                    biVar.x.setVisibility(0);
                    biVar.s.setVisibility(0);
                    biVar.t.setVisibility(0);
                    biVar.u.setVisibility(0);
                    biVar.s.a(l);
                    biVar.s.setData(oVar2.h().get(0));
                    biVar.t.a(l);
                    biVar.t.setData(oVar2.h().get(1));
                    biVar.u.a(l);
                    biVar.u.setData(oVar2.h().get(2));
                }
                int o = oVar2.o();
                if ((o <= 3 || size <= 0) && size > 0) {
                    biVar.y.setVisibility(0);
                } else {
                    biVar.y.setVisibility(8);
                }
                if (o > 999999) {
                    biVar.o.setText("999999+");
                    if (size <= 0) {
                        biVar.v.setVisibility(8);
                        return view;
                    }
                    biVar.v.setVisibility(0);
                    biVar.v.setText(String.valueOf(this.a.getString(com.baidu.tieba.a.k.frs_item_more_reply_item1)) + "999999+" + this.a.getString(com.baidu.tieba.a.k.frs_item_more_reply_item2));
                    return view;
                } else if (o <= 0) {
                    biVar.v.setVisibility(8);
                    biVar.o.setText(this.a.getResources().getString(com.baidu.tieba.a.k.frs_item_reply_text));
                    return view;
                } else {
                    biVar.o.setText(String.valueOf(o));
                    int i13 = o - size;
                    if (i13 <= 0 || size <= 0) {
                        biVar.v.setVisibility(8);
                        return view;
                    }
                    biVar.v.setVisibility(0);
                    biVar.v.setText(String.valueOf(this.a.getString(com.baidu.tieba.a.k.frs_item_more_reply_item1)) + i13 + this.a.getString(com.baidu.tieba.a.k.frs_item_more_reply_item2));
                    return view;
                }
            case 4:
                if (view == null) {
                    view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.frs_item_app, (ViewGroup) null);
                    bd bdVar = new bd(this, (byte) 0);
                    bdVar.a = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.app_parent);
                    bdVar.d = (TextView) view.findViewById(com.baidu.tieba.a.h.app_name);
                    bdVar.e = (TextView) view.findViewById(com.baidu.tieba.a.h.app_desc);
                    bdVar.c = (HeadImageView) view.findViewById(com.baidu.tieba.a.h.app_icon);
                    bdVar.f = (TextView) view.findViewById(com.baidu.tieba.a.h.app_download);
                    bdVar.b = (TextView) view.findViewById(com.baidu.tieba.a.h.recommend_app);
                    view.setTag(bdVar);
                }
                bd bdVar2 = (bd) view.getTag();
                bdVar2.a.setPadding(0, i - this.s == 0 ? this.o : this.p, 0, 0);
                view.setTag(bdVar2);
                ((FrsActivity) this.a).getLayoutMode().a(l == 1);
                ((FrsActivity) this.a).getLayoutMode().a(view);
                com.baidu.tbadk.core.data.o oVar3 = (com.baidu.tbadk.core.data.o) getItem(i);
                if (oVar3 instanceof com.baidu.tbadk.core.data.b) {
                    com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) oVar3;
                    bdVar2.d.setText(bVar.c());
                    bdVar2.e.setText(bVar.d());
                    if (com.baidu.tbadk.core.h.a().f()) {
                        bdVar2.c.setVisibility(0);
                        if (this.k) {
                            bdVar2.c.setSuffix("_small");
                        } else {
                            bdVar2.c.setSuffix("_mobile");
                        }
                    } else {
                        bdVar2.c.setVisibility(8);
                    }
                    bdVar2.c.setTag(bVar.b());
                    bdVar2.f.setTag(Integer.valueOf(i));
                    if (l == 1) {
                        com.baidu.tbadk.core.util.ba.e((View) bdVar2.b, com.baidu.tieba.a.g.bg_label_1);
                    } else {
                        com.baidu.tbadk.core.util.ba.e((View) bdVar2.b, com.baidu.tieba.a.g.bg_label);
                    }
                    switch (bVar.g()) {
                        case 0:
                            if (l == 1) {
                                bdVar2.f.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_btn_selector_1);
                                bdVar2.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f_1));
                            } else {
                                bdVar2.f.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_btn_selector);
                                bdVar2.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.cp_cont_f));
                            }
                            bdVar2.f.setText(com.baidu.tieba.a.k.download);
                            bdVar2.f.setOnClickListener(this.w);
                            return view;
                        case 1:
                            a(l, bdVar2);
                            bdVar2.f.setText(com.baidu.tieba.a.k.downloading2);
                            bdVar2.f.setOnClickListener(null);
                            return view;
                        case 2:
                            a(l, bdVar2);
                            bdVar2.f.setText(com.baidu.tieba.a.k.downloaded);
                            bdVar2.f.setOnClickListener(this.w);
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

    private View j() {
        View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.frs_top_item, (ViewGroup) null);
        bh bhVar = new bh(this, (byte) 0);
        bhVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.frs_top_item);
        bhVar.b = (TextView) inflate.findViewById(com.baidu.tieba.a.h.frs_top_title);
        inflate.setTag(bhVar);
        return inflate;
    }

    private void a(int i, bd bdVar) {
        if (i == 1) {
            bdVar.f.setBackgroundResource(com.baidu.tieba.a.g.btn_content_download_d_1);
            bdVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.faceshop_downloaded_text_1));
            return;
        }
        bdVar.f.setBackgroundResource(com.baidu.tieba.a.g.btn_content_download_d);
        bdVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.faceshop_downloaded_text));
    }

    public final void e() {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size && this.b.get(i).q() != 0; i++) {
                this.b.get(i).E();
            }
        }
    }

    public final void f(boolean z) {
        this.m = z;
        this.h.a(z);
    }

    public final void a(bf bfVar) {
        this.x = bfVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.x != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) getItem(intValue);
            View childAt = this.v.getChildAt(intValue - (this.v.getFirstVisiblePosition() - this.v.getHeaderViewsCount()));
            if (view.getId() != com.baidu.tieba.a.h.frs_praise_btn || this.r) {
                this.x.a(id, intValue, view, childAt, oVar);
            }
        }
    }

    public static int f() {
        return com.baidu.tieba.a.h.frs_praise_btn;
    }

    public static int g() {
        return com.baidu.tieba.a.h.frs_reply_btn;
    }

    public static int h() {
        return com.baidu.tieba.a.h.frs_more_abstract;
    }

    public static int i() {
        return com.baidu.tieba.a.h.frs_item_more_reply_text;
    }

    public static /* synthetic */ void b(ay ayVar, View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(ayVar.a, com.baidu.tieba.a.b.praise_animation_scale2));
            new Handler().postDelayed(new bb(ayVar), 200L);
        }
    }

    public static /* synthetic */ void a(ay ayVar, View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(ayVar.a, com.baidu.tieba.a.b.praise_animation_scale3));
            new Handler().postDelayed(new bc(ayVar), 600L);
        }
    }
}
