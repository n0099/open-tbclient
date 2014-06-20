package com.baidu.tieba.frs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.view.ChildViewPager;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes.dex */
public class az extends BaseAdapter implements View.OnClickListener {
    static final /* synthetic */ boolean a;
    private final Context b;
    private ArrayList<com.baidu.tbadk.core.data.n> c;
    private g d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private final com.baidu.tbadk.editortool.ab i;
    private boolean j;
    private final int m;
    private final int n;
    private int q;
    private ArrayList<Integer> r;
    private final HashMap<Integer, com.baidu.tbadk.core.data.n> t;
    private ListView u;
    private bk w;
    private boolean k = false;
    private LinkedList<IconData> l = null;
    private long o = 0;
    private boolean p = true;
    private int s = -1;
    private final View.OnClickListener v = new ba(this);

    static {
        a = !az.class.desiredAssertionStatus();
    }

    private int a(ArrayList<com.baidu.tbadk.core.data.n> arrayList) {
        int i = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.tbadk.core.data.n> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.tbadk.core.data.n next = it.next();
                if (next.u() == 1 || next.u() == 2) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private ArrayList<Integer> b(ArrayList<com.baidu.tbadk.core.data.n> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return arrayList2;
            }
            com.baidu.tbadk.core.data.n nVar = arrayList.get(i2);
            if (nVar instanceof com.baidu.tbadk.core.data.b) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.t != null && !this.t.containsValue(nVar)) {
                    this.t.put(Integer.valueOf(i2), nVar);
                }
            }
            i = i2 + 1;
        }
    }

    public az(Context context, ArrayList<com.baidu.tbadk.core.data.n> arrayList, int i, boolean z) {
        this.j = false;
        this.b = context;
        this.c = arrayList;
        this.i = new com.baidu.tbadk.editortool.ab(this.b);
        this.i.d(true);
        this.j = z;
        a(z);
        this.q = a(this.c);
        this.m = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin);
        this.n = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_divider_height);
        this.t = new HashMap<>();
    }

    public void a(int i) {
        this.s = i;
    }

    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
        }
    }

    public void b(boolean z) {
        this.g = z;
    }

    public boolean a() {
        return this.g;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public boolean b() {
        return this.h;
    }

    public void d(boolean z) {
        this.e = z;
    }

    public void e(boolean z) {
        this.f = z;
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.n> arrayList, g gVar) {
        this.c = arrayList;
        this.d = gVar;
        this.q = a(this.c);
        this.r = b(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null || this.c == null) {
            return 0;
        }
        int size = 0 + this.c.size();
        if (this.e) {
            size++;
        }
        if (this.f) {
            return size + 1;
        }
        return size;
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.n> c() {
        return this.t;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.c.size()) {
            return null;
        }
        return this.c.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < this.q) {
            return i;
        }
        if (!this.e) {
            i2 = i;
        } else if (i == this.q) {
            return -1L;
        } else {
            i2 = i - 1;
        }
        if (this.f && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i < this.q) {
            return 2;
        }
        if (this.e && i - this.q == 0) {
            return 0;
        }
        if (this.f && i == getCount() - 1) {
            return 1;
        }
        if (this.r.contains(Integer.valueOf(i))) {
            return 4;
        }
        if (i == this.s) {
            return 5;
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.u = (ListView) viewGroup;
        switch (getItemViewType(i)) {
            case 0:
                return a(view, skinType);
            case 1:
                return b(view, skinType);
            case 2:
                return a(i, view, skinType);
            case 3:
                return b(i, view, skinType);
            case 4:
                return c(i, view, skinType);
            case 5:
                return a(i, view, viewGroup, skinType);
            default:
                return null;
        }
    }

    private View a(int i, View view, ViewGroup viewGroup, int i2) {
        bl blVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.frs_live_view_pager_div, viewGroup, false);
            blVar = new bl(this, null);
            blVar.d = (TextView) view.findViewById(com.baidu.tieba.v.live_title);
            blVar.a = (ChildViewPager) view.findViewById(com.baidu.tieba.v.live_title_child);
            blVar.c = (IndicatorView) view.findViewById(com.baidu.tieba.v.live_tab_indicator);
            blVar.b = (TextView) view.findViewById(com.baidu.tieba.v.live_show_all);
            blVar.e = view.findViewById(com.baidu.tieba.v.live_title_card_line);
            blVar.f = view.findViewById(com.baidu.tieba.v.middle_layout);
            blVar.g = (ImageView) view.findViewById(com.baidu.tieba.v.live_arrow);
            blVar.h = (RelativeLayout) view.findViewById(com.baidu.tieba.v.frs_live_upItem);
            view.setTag(blVar);
        } else {
            blVar = (bl) view.getTag();
        }
        if (i >= 0 && i < this.c.size() && (this.c.get(i) instanceof com.baidu.tbadk.core.data.h)) {
            com.baidu.tbadk.core.data.h hVar = (com.baidu.tbadk.core.data.h) this.c.get(i);
            dm dmVar = new dm(a(hVar));
            blVar.a.setAdapter(dmVar);
            blVar.a.setOnPageChangeListener(new bb(this, blVar.c));
            blVar.a.setOnSingleTouchListener(new bc(this, hVar));
            blVar.c.setCount(dmVar.getCount());
            blVar.c.setPosition(0.0f);
            blVar.b.setTag(Integer.valueOf(i));
            blVar.g.setTag(Integer.valueOf(i));
            blVar.h.setTag(Integer.valueOf(i));
            blVar.h.setOnClickListener(this);
            com.baidu.tbadk.core.util.be.f(blVar.h, com.baidu.tieba.u.bg_live_card_up);
            com.baidu.tbadk.core.util.be.a(blVar.d, com.baidu.tieba.s.cp_cont_c, 1);
            com.baidu.tbadk.core.util.be.f(blVar.f, com.baidu.tieba.u.bg_live_card_middle);
            com.baidu.tbadk.core.util.be.a(blVar.b, com.baidu.tieba.s.cp_cont_c, 1);
            com.baidu.tbadk.core.util.be.f(blVar.e, com.baidu.tieba.s.cp_bg_line_b);
            com.baidu.tbadk.core.util.be.c(blVar.g, com.baidu.tieba.u.icon_frs_ba_arrows_live);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                blVar.c.setSelector(this.b.getResources().getDrawable(com.baidu.tieba.u.dot_live_s_1));
                blVar.c.setDrawable(this.b.getResources().getDrawable(com.baidu.tieba.u.dot_live_n_1));
            } else {
                blVar.c.setSelector(this.b.getResources().getDrawable(com.baidu.tieba.u.dot_live_s));
                blVar.c.setDrawable(this.b.getResources().getDrawable(com.baidu.tieba.u.dot_live_n));
            }
        } else {
            BdLog.e("FrsAdapter:getLiveViewPager() position error or instanceof error");
        }
        return view;
    }

    private ArrayList<View> a(com.baidu.tbadk.core.data.h hVar) {
        ArrayList<View> arrayList = new ArrayList<>();
        if (hVar != null && hVar.a() != null) {
            com.baidu.tbadk.editortool.ab abVar = new com.baidu.tbadk.editortool.ab(this.b);
            abVar.d(true);
            Iterator<LiveCardData> it = hVar.a().iterator();
            while (it.hasNext()) {
                LiveBroadcastCard liveBroadcastCard = (LiveBroadcastCard) LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.frs_live_view_pager_item, (ViewGroup) null);
                liveBroadcastCard.a(it.next(), abVar);
                liveBroadcastCard.setStatisticsKey("forum_live_ck");
                liveBroadcastCard.a(TbadkApplication.m252getInst().getSkinType());
                arrayList.add(liveBroadcastCard);
            }
        }
        return arrayList;
    }

    private View a(int i, View view, int i2) {
        bn bnVar;
        View view2;
        View view3;
        bn bnVar2;
        BitmapDrawable bitmapDrawable;
        int color;
        if (view == null) {
            view2 = h();
            bnVar = (bn) view2.getTag();
        } else {
            bnVar = null;
            view2 = view;
        }
        if (bnVar == null) {
            View h = h();
            view3 = h;
            bnVar2 = (bn) h.getTag();
        } else {
            view3 = view2;
            bnVar2 = bnVar;
        }
        ((FrsActivity) this.b).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.b).getLayoutMode().a(view3);
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        bnVar2.b.setText(nVar.r());
        com.baidu.tieba.util.p C = com.baidu.tieba.ai.c().C();
        if (C != null && C.b(nVar.p())) {
            TextView textView = bnVar2.b;
            if (i2 == 1) {
                color = this.b.getResources().getColor(com.baidu.tieba.s.listview_item_thread_read_1);
            } else {
                color = this.b.getResources().getColor(com.baidu.tieba.s.listview_item_thread_read);
            }
            textView.setTextColor(color);
        }
        if (i2 == 1) {
            if (nVar.u() == 1) {
                bitmapDrawable = (BitmapDrawable) this.b.getResources().getDrawable(com.baidu.tieba.u.icon_top_1);
            } else {
                bitmapDrawable = nVar.u() == 2 ? (BitmapDrawable) this.b.getResources().getDrawable(com.baidu.tieba.u.icon_notice_1) : null;
            }
            bnVar2.a.setBackgroundResource(com.baidu.tieba.u.frs_top_item_bg_1);
        } else {
            if (nVar.u() == 1) {
                bitmapDrawable = (BitmapDrawable) this.b.getResources().getDrawable(com.baidu.tieba.u.icon_top);
            } else {
                bitmapDrawable = nVar.u() == 2 ? (BitmapDrawable) this.b.getResources().getDrawable(com.baidu.tieba.u.icon_notice) : null;
            }
            bnVar2.a.setBackgroundResource(com.baidu.tieba.u.frs_top_item_bg);
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        bnVar2.b.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view3;
    }

    private View h() {
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.frs_top_item, (ViewGroup) null);
        bn bnVar = new bn(this, null);
        bnVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_top_item);
        bnVar.b = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_top_title);
        inflate.setTag(bnVar);
        return inflate;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x042c: INVOKE  (r2v15 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x0428: INVOKE  (r2v14 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tbadk.core.data.n) type: VIRTUAL call: com.baidu.tbadk.core.data.n.o():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View b(int i, View view, int i2) {
        bo boVar;
        int color;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.frs_item, (ViewGroup) null);
            bo boVar2 = new bo(this, null);
            boVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list);
            boVar2.s = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_item_user_info_view);
            boVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list_item_top_linear_layout);
            boVar2.j = (HeadImageView) view.findViewById(com.baidu.tieba.v.frs_photo);
            boVar2.i = (UserIconBox) view.findViewById(com.baidu.tieba.v.frs_user_tshow_icon_box);
            boVar2.h = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_author);
            boVar2.f = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_reply_time);
            boVar2.g = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_title);
            boVar2.c = (TextView) view.findViewById(com.baidu.tieba.v.abstract_text);
            boVar2.d = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.v.abstract_voice);
            boVar2.e = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.v.abstract_img_layout);
            boVar2.k = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_praise_btn);
            boVar2.l = (ImageView) view.findViewById(com.baidu.tieba.v.frs_praise_icon);
            boVar2.m = (TextView) view.findViewById(com.baidu.tieba.v.frs_praise_num);
            boVar2.n = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_reply_btn);
            boVar2.o = (TextView) view.findViewById(com.baidu.tieba.v.frs_reply_num);
            boVar2.p = (FrsPraiseView) view.findViewById(com.baidu.tieba.v.frs_praise_list_user_icon);
            boVar2.q = (TextView) view.findViewById(com.baidu.tieba.v.frs_more_abstract);
            boVar2.r = view.findViewById(com.baidu.tieba.v.frs_item_praise_divider_line);
            boVar2.t = (LinearLayout) view.findViewById(com.baidu.tieba.v.live_card_layout);
            boVar2.u = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.v.item_card);
            view.setTag(boVar2);
            boVar = boVar2;
        } else {
            boVar = (bo) view.getTag();
        }
        if (i2 == 1) {
            boVar.b.setBackgroundResource(com.baidu.tieba.u.frs_item_control_btn_bg_1);
            boVar.n.setBackgroundResource(com.baidu.tieba.u.frs_praise_btn_bg_1);
            boVar.k.setBackgroundResource(com.baidu.tieba.u.frs_praise_btn_bg_1);
            boVar.q.setBackgroundResource(com.baidu.tieba.u.frs_item_abstract_more_text_bg_1);
        } else {
            boVar.b.setBackgroundResource(com.baidu.tieba.u.frs_item_control_btn_bg);
            boVar.n.setBackgroundResource(com.baidu.tieba.u.frs_praise_btn_bg);
            boVar.k.setBackgroundResource(com.baidu.tieba.u.frs_praise_btn_bg);
            boVar.q.setBackgroundResource(com.baidu.tieba.u.frs_item_abstract_more_text_bg);
        }
        boVar.k.setOnClickListener(this);
        com.baidu.adp.lib.util.k.a(this.b, boVar.k, 0, 10, 0, 20);
        boVar.n.setOnClickListener(this);
        com.baidu.adp.lib.util.k.a(this.b, boVar.n, 0, 10, 0, 20);
        boVar.q.setOnClickListener(this);
        boVar.k.setOnTouchListener(new bm(this, null));
        boVar.n.setTag(Integer.valueOf(i));
        boVar.k.setTag(Integer.valueOf(i));
        boVar.q.setTag(Integer.valueOf(i));
        ((FrsActivity) this.b).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.b).getLayoutMode().a(view);
        int i3 = i - this.q;
        if (i3 == 0) {
            if (i2 == 1) {
                boVar.a.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.u.bg_frs_1));
            } else {
                boVar.a.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.u.bg_frs));
            }
        } else {
            boVar.a.setBackgroundColor(17170445);
        }
        boVar.a.setPadding(0, i3 == 0 ? this.m : this.n, 0, 0);
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        boVar.f.setText(com.baidu.tbadk.core.util.bg.a(nVar.t() * 1000));
        if (com.baidu.tbadk.core.h.a().d()) {
            boVar.j.setVisibility(0);
            String portrait = nVar.y().getPortrait();
            boVar.j.setUserId(nVar.y().getUserId());
            boVar.j.setImageBitmap(null);
            boVar.j.a(portrait, 12, false);
            boVar.j.setDefaultResource(com.baidu.tieba.u.photo);
        } else {
            boVar.j.setVisibility(8);
        }
        boVar.s.setOnClickListener(new bd(this, nVar));
        nVar.y().getIconInfo();
        this.l = nVar.y().getTShowInfo();
        if (this.l != null && this.l.size() > 0) {
            boVar.i.setVisibility(0);
            if (i2 == 1) {
                boVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.frs_lv_item_user_name_vip_1));
            } else {
                boVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.frs_lv_item_user_name_vip));
            }
            boVar.i.a(this.l, 2, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
        } else {
            boVar.i.setVisibility(8);
            if (i2 == 1) {
                boVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.frs_lv_item_user_name_1));
            } else {
                boVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.frs_lv_item_user_name));
            }
        }
        boVar.h.setText(nVar.y().getUserName());
        boVar.e.setVisibility(0);
        boVar.c.setVisibility(0);
        nVar.L();
        boVar.g.setText(nVar.J());
        com.baidu.tieba.util.p C = com.baidu.tieba.ai.c().C();
        if (C != null && C.b(nVar.p())) {
            TextView textView = boVar.g;
            if (i2 == 1) {
                color = this.b.getResources().getColor(com.baidu.tieba.s.listview_item_thread_read_1);
            } else {
                color = this.b.getResources().getColor(com.baidu.tieba.s.listview_item_thread_read);
            }
            textView.setTextColor(color);
        }
        if (nVar.H() == 1) {
            boVar.g.setVisibility(8);
        } else {
            boVar.g.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (nVar.C() != null && nVar.C().trim().length() > 0) {
            stringBuffer.append(nVar.C());
        }
        ArrayList<com.baidu.tbadk.core.data.j> F = nVar.F();
        if (F != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= F.size()) {
                    break;
                }
                if (F.get(i5).d() != null && F.get(i5).d().endsWith("swf")) {
                    stringBuffer2.append(F.get(i5).d());
                }
                i4 = i5 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                if (stringBuffer.length() > 170) {
                    boVar.q.setVisibility(0);
                    boVar.c.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    boVar.q.setVisibility(8);
                    boVar.c.setText(stringBuffer.toString());
                }
            } else {
                boVar.q.setVisibility(8);
                boVar.c.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.h.a().f()) {
            if (F != null) {
                if (F.size() > 0) {
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        int i9 = i6;
                        if (i9 >= F.size()) {
                            break;
                        }
                        if (F.get(i9) != null && (F.get(i9).b() == 3 || F.get(i9).b() == 5)) {
                            i7++;
                            i8++;
                        }
                        i6 = i9 + 1;
                    }
                    if (i7 > 0) {
                        com.baidu.tbadk.core.data.j[] jVarArr = new com.baidu.tbadk.core.data.j[i7];
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            int i12 = i10;
                            int i13 = i11;
                            if (i12 >= F.size() || i13 >= i7) {
                                break;
                            }
                            if (F.get(i12).b() == 3 || F.get(i12).b() == 5) {
                                jVarArr[i13] = F.get(i12);
                                i11 = i13 + 1;
                            } else {
                                i11 = i13;
                            }
                            i10 = i12 + 1;
                        }
                        boVar.e.a(nVar, this.d.g().getName(), this.d.g().getId(), nVar.q());
                        boVar.e.setShowBig(this.j);
                        boVar.e.setDrawNum(true);
                        boVar.e.setFromCDN(this.k);
                        boVar.e.a(jVarArr, i8);
                        boVar.e.setImageFrom("other");
                    }
                } else {
                    boVar.e.setVisibility(8);
                }
            }
        } else {
            boVar.e.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> G = nVar.G();
        if (G != null && G.size() > 0) {
            boVar.d.setVisibility(0);
            VoiceData.VoiceModel voiceModel = G.get(0);
            boVar.d.setVoiceModel(voiceModel);
            boVar.d.setTag(voiceModel);
            boVar.d.c();
        } else {
            boVar.d.setVisibility(8);
        }
        if (nVar.o() != null && nVar.o().getNum() > 0) {
            if (com.baidu.tbadk.core.h.a().d()) {
                boVar.p.setVisibility(0);
                boVar.p.setIsFromPb(false);
                boVar.p.a(i2);
                boVar.r.setVisibility(0);
                boVar.p.a(nVar.o(), nVar.p(), nVar.n(), false);
            } else {
                boVar.p.setVisibility(8);
                boVar.r.setVisibility(8);
            }
            if (nVar.o().getIsLike() == 1) {
                if (i2 == 1) {
                    boVar.l.setImageResource(com.baidu.tieba.u.icon_hand_click_1);
                } else {
                    boVar.l.setImageResource(com.baidu.tieba.u.icon_hand_click);
                }
            } else if (i2 == 1) {
                boVar.l.setImageResource(com.baidu.tieba.u.icon_hand_normal_1);
            } else {
                boVar.l.setImageResource(com.baidu.tieba.u.icon_hand_normal);
            }
            if (nVar.o().getNum() <= 999999) {
                boVar.m.setText(new StringBuilder().append(nVar.o().getNum()).toString());
            } else {
                boVar.m.setText("999999+");
            }
        } else {
            boVar.r.setVisibility(8);
            boVar.p.setVisibility(8);
            boVar.m.setText(this.b.getResources().getString(com.baidu.tieba.y.frs_item_praise_text));
            if (i2 == 1) {
                boVar.l.setImageResource(com.baidu.tieba.u.icon_hand_normal_1);
            } else {
                boVar.l.setImageResource(com.baidu.tieba.u.icon_hand_normal);
            }
        }
        int s = nVar.s();
        if (s <= 999999) {
            if (s > 0) {
                boVar.o.setText(String.valueOf(s));
            } else {
                boVar.o.setText(this.b.getResources().getString(com.baidu.tieba.y.frs_item_reply_text));
            }
        } else {
            boVar.o.setText("999999+");
        }
        if (nVar.M().getGroup_id() != 0) {
            boVar.e.setVisibility(8);
            boVar.t.setVisibility(0);
            LiveCardData liveCardData = new LiveCardData();
            liveCardData.setPublisherId(nVar.M().getAuthorId());
            liveCardData.setPublisherName(nVar.M().getAuthorName());
            liveCardData.setPublisherPortrait(nVar.M().getPublisherPortrait());
            liveCardData.setGroupId(nVar.M().getGroup_id());
            liveCardData.setIntro(nVar.M().getIntro());
            liveCardData.setLikers(nVar.M().getLikers());
            liveCardData.setListeners(nVar.M().getListeners());
            liveCardData.setName(nVar.M().getName());
            liveCardData.setPortrait(nVar.M().getPortrait());
            liveCardData.setStatus(nVar.M().getStatus());
            liveCardData.setStartTime(nVar.M().getStartTime());
            boVar.u.a(liveCardData, this.i);
            boVar.u.setStatisticsKey("notice_frs_live");
        } else {
            boVar.t.setVisibility(8);
        }
        return view;
    }

    private View c(int i, View view, int i2) {
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        if (nVar instanceof com.baidu.tbadk.core.data.b) {
            if (((com.baidu.tbadk.core.data.b) nVar).d() == 2) {
                return e(i, view, i2);
            }
            return d(i, view, i2);
        }
        return d(i, view, i2);
    }

    private View d(int i, View view, int i2) {
        if (view == null) {
            view = i();
        } else if (!(view.getTag() instanceof bh)) {
            view = i();
        }
        bh bhVar = (bh) view.getTag();
        bhVar.a.setPadding(0, i - this.q == 0 ? this.m : this.n, 0, 0);
        view.setTag(bhVar);
        ((FrsActivity) this.b).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.b).getLayoutMode().a(view);
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        if (nVar instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) nVar;
            bhVar.d.setText(bVar.g());
            bhVar.e.setText(bVar.h());
            if (com.baidu.tbadk.core.h.a().f()) {
                bhVar.c.setVisibility(0);
                if (this.j) {
                    bhVar.c.setSuffix("_small");
                } else {
                    bhVar.c.setSuffix("_mobile");
                }
                bhVar.c.a(bVar.f(), this.k ? 13 : 14, false);
            } else {
                bhVar.c.setVisibility(8);
            }
            bhVar.c.setTag(bVar.f());
            bhVar.f.setTag(Integer.valueOf(i));
            if (i2 == 1) {
                com.baidu.tbadk.core.util.be.e((View) bhVar.b, com.baidu.tieba.u.bg_label_1);
            } else {
                com.baidu.tbadk.core.util.be.e((View) bhVar.b, com.baidu.tieba.u.bg_label);
            }
            switch (bVar.k()) {
                case 0:
                    a(i2, bhVar);
                    bhVar.f.setText(com.baidu.tieba.y.download);
                    bhVar.f.setOnClickListener(this.v);
                    break;
                case 1:
                    b(i2, bhVar);
                    bhVar.f.setText(com.baidu.tieba.y.downloading2);
                    bhVar.f.setOnClickListener(null);
                    break;
                case 2:
                    a(i2, bhVar);
                    bhVar.f.setText(com.baidu.tieba.y.downloaded);
                    bhVar.f.setOnClickListener(this.v);
                    break;
            }
        }
        return view;
    }

    private void a(int i, bh bhVar) {
        if (i == 1) {
            bhVar.f.setBackgroundResource(com.baidu.tieba.u.faceshop_list_btn_selector_1);
            bhVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_f_1));
            return;
        }
        bhVar.f.setBackgroundResource(com.baidu.tieba.u.faceshop_list_btn_selector);
        bhVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_f));
    }

    private void b(int i, bh bhVar) {
        if (i == 1) {
            bhVar.f.setBackgroundResource(com.baidu.tieba.u.btn_content_download_d_1);
            bhVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.faceshop_downloaded_text_1));
            return;
        }
        bhVar.f.setBackgroundResource(com.baidu.tieba.u.btn_content_download_d);
        bhVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.faceshop_downloaded_text));
    }

    private View i() {
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.frs_item_app, (ViewGroup) null);
        bh bhVar = new bh(this, null);
        bhVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.app_parent);
        bhVar.d = (TextView) inflate.findViewById(com.baidu.tieba.v.app_name);
        bhVar.e = (TextView) inflate.findViewById(com.baidu.tieba.v.app_desc);
        bhVar.c = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.app_icon);
        bhVar.f = (TextView) inflate.findViewById(com.baidu.tieba.v.app_download);
        bhVar.b = (TextView) inflate.findViewById(com.baidu.tieba.v.recommend_app);
        inflate.setTag(bhVar);
        return inflate;
    }

    private View e(int i, View view, int i2) {
        if (view == null) {
            view = j();
        } else if (!(view.getTag() instanceof bi)) {
            view = j();
        }
        bi biVar = (bi) view.getTag();
        biVar.a.setPadding(0, i - this.q == 0 ? this.m : this.n, 0, 0);
        view.setTag(biVar);
        ((FrsActivity) this.b).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.b).getLayoutMode().a(view);
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        if (nVar instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) nVar;
            biVar.c.setText(a(bVar.g()));
            biVar.e.setText(bVar.h());
            biVar.d.setText(com.baidu.tbadk.core.util.bg.a(bVar.c() * 1000));
            if (com.baidu.tbadk.core.h.a().d()) {
                biVar.b.setVisibility(0);
                biVar.b.setDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140);
                if (this.j) {
                    biVar.b.setSuffix("_small");
                } else {
                    biVar.b.setSuffix("_mobile");
                }
                biVar.b.a(bVar.f(), this.k ? 13 : 14, false);
            } else {
                biVar.b.setVisibility(8);
            }
            biVar.b.setTag(bVar.f());
            if (com.baidu.tbadk.core.h.a().f() && !TextUtils.isEmpty(bVar.b())) {
                biVar.f.setVisibility(0);
                biVar.f.setDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d);
                biVar.f.setNightDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d_1);
                biVar.f.a(bVar.b(), this.k ? 13 : 14, false);
            } else {
                biVar.f.setVisibility(8);
            }
            biVar.g.setTag(Integer.valueOf(i));
            if (TextUtils.isEmpty(bVar.j())) {
                a(i2, biVar);
                biVar.g.setText(com.baidu.tieba.y.pb_app_see);
                biVar.g.setOnClickListener(new be(this, bVar));
            } else {
                switch (bVar.k()) {
                    case 0:
                        a(i2, biVar);
                        biVar.g.setText(com.baidu.tieba.y.pb_app_download);
                        biVar.g.setOnClickListener(this.v);
                        break;
                    case 1:
                        b(i2, biVar);
                        biVar.g.setText(com.baidu.tieba.y.downloading2);
                        biVar.g.setOnClickListener(null);
                        break;
                    case 2:
                        a(i2, biVar);
                        biVar.g.setText(com.baidu.tieba.y.downloaded);
                        biVar.g.setOnClickListener(this.v);
                        break;
                }
            }
        }
        return view;
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    private void a(int i, bi biVar) {
        if (i == 1) {
            biVar.g.setBackgroundResource(com.baidu.tieba.u.btn_appdownload_1);
            biVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_i_1));
            return;
        }
        biVar.g.setBackgroundResource(com.baidu.tieba.u.btn_appdownload);
        biVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.cp_cont_i));
    }

    private void b(int i, bi biVar) {
        if (i == 1) {
            biVar.g.setBackgroundResource(com.baidu.tieba.u.btn_content_download_d_1);
            biVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.faceshop_downloaded_text_1));
            return;
        }
        biVar.g.setBackgroundResource(com.baidu.tieba.u.btn_content_download_d);
        biVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.faceshop_downloaded_text));
    }

    private View j() {
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.frs_item_app_new, (ViewGroup) null);
        bi biVar = new bi(this, null);
        if (a || inflate != 0) {
            biVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_app_item_parent);
            biVar.b = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.frs_app_icon);
            biVar.c = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_name);
            biVar.d = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_time);
            biVar.e = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_desc);
            biVar.f = (TbImageView) inflate.findViewById(com.baidu.tieba.v.frs_app_url);
            biVar.g = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_app_download);
            inflate.setTag(biVar);
            return inflate;
        }
        throw new AssertionError();
    }

    private View a(View view, int i) {
        bj bjVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.frs_item_control, (ViewGroup) null);
            bj bjVar2 = new bj(this, null);
            bjVar2.a = (FrameLayout) view.findViewById(com.baidu.tieba.v.frs_list_control);
            bjVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list_control_in);
            bjVar2.d = (ProgressBar) view.findViewById(com.baidu.tieba.v.frs_list_control_progress);
            bjVar2.c = (TextView) view.findViewById(com.baidu.tieba.v.frs_list_control_tv);
            view.setTag(bjVar2);
            bjVar = bjVar2;
        } else {
            bjVar = (bj) view.getTag();
        }
        if (this.e) {
            bjVar.a.setVisibility(0);
            bjVar.a.setPadding(0, this.m, 0, 0);
            if (this.h) {
                bjVar.c.setText(com.baidu.tieba.y.loading);
                bjVar.d.setVisibility(0);
            } else {
                bjVar.c.setText(com.baidu.tieba.y.frs_pre);
                bjVar.d.setVisibility(8);
            }
            if (i == 1) {
                bjVar.b.setBackgroundResource(com.baidu.tieba.u.frs_item_control_bg_1);
            } else {
                bjVar.b.setBackgroundResource(com.baidu.tieba.u.frs_item_control_bg);
            }
            com.baidu.tbadk.core.util.be.b(bjVar.c, i);
        } else {
            bjVar.a.setVisibility(8);
        }
        return view;
    }

    private View b(View view, int i) {
        bj bjVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.w.frs_item_control, (ViewGroup) null);
            bj bjVar2 = new bj(this, null);
            bjVar2.a = (FrameLayout) view.findViewById(com.baidu.tieba.v.frs_list_control);
            bjVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list_control_in);
            bjVar2.d = (ProgressBar) view.findViewById(com.baidu.tieba.v.frs_list_control_progress);
            bjVar2.c = (TextView) view.findViewById(com.baidu.tieba.v.frs_list_control_tv);
            view.setTag(bjVar2);
            bjVar = bjVar2;
        } else {
            bjVar = (bj) view.getTag();
        }
        if (this.f) {
            bjVar.a.setVisibility(0);
            bjVar.a.setPadding(0, this.m, 0, this.m);
            if (this.g) {
                bjVar.c.setText(com.baidu.tieba.y.loading);
                bjVar.d.setVisibility(0);
            } else {
                bjVar.c.setText(com.baidu.tieba.y.frs_next);
                bjVar.d.setVisibility(8);
            }
            if (i == 1) {
                bjVar.b.setBackgroundResource(com.baidu.tieba.u.frs_item_control_bg_1);
            } else {
                bjVar.b.setBackgroundResource(com.baidu.tieba.u.frs_item_control_bg);
            }
            com.baidu.tbadk.core.util.be.b(bjVar.c, i);
        } else {
            bjVar.a.setVisibility(8);
        }
        return view;
    }

    public void d() {
        if (this.c != null) {
            int size = this.c.size();
            for (int i = 0; i < size && this.c.get(i).u() != 0; i++) {
                this.c.get(i).L();
            }
        }
    }

    public void f(boolean z) {
        this.k = z;
    }

    public void a(bk bkVar) {
        this.w = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.w != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(intValue);
            View childAt = this.u.getChildAt(intValue - (this.u.getFirstVisiblePosition() - this.u.getHeaderViewsCount()));
            if (view.getId() == e()) {
                if (this.p) {
                    this.w.a(id, intValue, view, childAt, nVar);
                }
            } else if (view.getId() == com.baidu.tieba.v.frs_live_upItem) {
                com.baidu.tbadk.core.f.a(this.b, "all_live_read");
                if (this.d != null && this.d.g() != null && !TextUtils.isEmpty(this.d.g().getId()) && this.d.i() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.o(this.b, this.d.g().getId(), this.d.i().getIsManager())));
                } else {
                    BdLog.e("find nullPoint");
                }
            } else {
                this.w.a(id, intValue, view, childAt, nVar);
            }
        }
    }

    public int e() {
        return com.baidu.tieba.v.frs_praise_btn;
    }

    public int f() {
        return com.baidu.tieba.v.frs_reply_btn;
    }

    public int g() {
        return com.baidu.tieba.v.frs_more_abstract;
    }

    public void a(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.b, com.baidu.tieba.p.praise_animation_scale2));
            new Handler().postDelayed(new bf(this), 200L);
        }
    }

    public void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.b, com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new bg(this), 600L);
        }
    }

    public void a(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.b, com.baidu.tieba.p.praise_animation_scale1));
    }
}
