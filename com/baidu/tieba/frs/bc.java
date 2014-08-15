package com.baidu.tieba.frs;

import android.annotation.SuppressLint;
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
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
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
public class bc extends BaseAdapter implements View.OnClickListener {
    static final /* synthetic */ boolean a;
    private final FrsActivity b;
    private ArrayList<com.baidu.tbadk.core.data.n> c;
    private g d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private final int l;
    private final int m;
    private int p;
    private ArrayList<Integer> q;
    private final HashMap<Integer, com.baidu.tbadk.core.data.n> s;
    private ListView t;
    private View.OnClickListener u;
    private View.OnClickListener v;
    private bl w;
    private boolean j = false;
    private LinkedList<IconData> k = null;
    private long n = 0;
    private boolean o = true;
    private int r = -1;

    static {
        a = !bc.class.desiredAssertionStatus();
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
                if (next.m() == 2 || next.m() == 1) {
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
            if (nVar instanceof com.baidu.tbadk.core.data.a) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.s != null && !this.s.containsValue(nVar)) {
                    this.s.put(Integer.valueOf(i2), nVar);
                }
            }
            i = i2 + 1;
        }
    }

    public bc(FrsActivity frsActivity, ArrayList<com.baidu.tbadk.core.data.n> arrayList, int i, boolean z) {
        this.i = false;
        this.b = frsActivity;
        this.c = arrayList;
        this.i = z;
        a(z);
        this.p = a(this.c);
        this.l = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.listview_item_margin);
        this.m = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.listview_divider_height);
        this.s = new HashMap<>();
    }

    public void a(int i) {
        this.r = i;
    }

    public void a(boolean z) {
        if (this.i != z) {
            this.i = z;
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
        this.p = a(this.c);
        this.q = b(arrayList);
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
        return this.s;
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
        if (i < this.p) {
            return i;
        }
        if (!this.e) {
            i2 = i;
        } else if (i == this.p) {
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
        return 7;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i < this.p) {
            return 2;
        }
        if (this.e && i - this.p == 0) {
            return 0;
        }
        if (this.f && i == getCount() - 1) {
            return 1;
        }
        if (i == this.r) {
            return 5;
        }
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        if (nVar instanceof com.baidu.tbadk.core.data.a) {
            return 4;
        }
        if (nVar instanceof com.baidu.tieba.data.ag) {
            return 6;
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.t = (ListView) viewGroup;
        switch (getItemViewType(i)) {
            case 0:
                return a(view, skinType);
            case 1:
                return b(view, skinType);
            case 2:
                return a(i, view, skinType);
            case 3:
                return c(i, view, skinType);
            case 4:
                return d(i, view, skinType);
            case 5:
                return a(i, view, viewGroup, skinType);
            case 6:
                return b(i, view, skinType);
            default:
                return null;
        }
    }

    private View a(int i, View view, ViewGroup viewGroup, int i2) {
        bm bmVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bm)) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.v.frs_live_view_pager_div, viewGroup, false);
            bmVar = new bm(this, null);
            bmVar.d = (TextView) view.findViewById(com.baidu.tieba.u.live_title);
            bmVar.a = (ChildViewPager) view.findViewById(com.baidu.tieba.u.live_title_child);
            bmVar.c = (IndicatorView) view.findViewById(com.baidu.tieba.u.live_tab_indicator);
            bmVar.b = (TextView) view.findViewById(com.baidu.tieba.u.live_show_all);
            bmVar.e = view.findViewById(com.baidu.tieba.u.live_title_card_line);
            bmVar.f = view.findViewById(com.baidu.tieba.u.middle_layout);
            bmVar.g = (ImageView) view.findViewById(com.baidu.tieba.u.live_arrow);
            bmVar.h = (RelativeLayout) view.findViewById(com.baidu.tieba.u.frs_live_upItem);
            view.setTag(bmVar);
        } else {
            bmVar = (bm) view.getTag();
        }
        if (i >= 0 && i < this.c.size() && (this.c.get(i) instanceof com.baidu.tbadk.core.data.i)) {
            com.baidu.tbadk.core.data.i iVar = (com.baidu.tbadk.core.data.i) this.c.get(i);
            dq dqVar = new dq(a(iVar));
            bmVar.a.setAdapter(dqVar);
            bmVar.a.setOnPageChangeListener(new bd(this, bmVar.c));
            bmVar.a.setOnSingleTouchListener(new be(this, iVar));
            if (dqVar.getCount() > 1) {
                if (bmVar.c.getVisibility() != 0) {
                    bmVar.c.setVisibility(0);
                }
                bmVar.c.setCount(dqVar.getCount());
                bmVar.c.setPosition(0.0f);
            } else if (bmVar.c.getVisibility() != 8) {
                bmVar.c.setVisibility(8);
            }
            bmVar.b.setTag(Integer.valueOf(i));
            bmVar.g.setTag(Integer.valueOf(i));
            bmVar.h.setTag(Integer.valueOf(i));
            bmVar.h.setOnClickListener(this);
            com.baidu.tbadk.core.util.ay.f(bmVar.h, com.baidu.tieba.t.bg_live_card_up);
            com.baidu.tbadk.core.util.ay.a(bmVar.d, com.baidu.tieba.r.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ay.f(bmVar.f, com.baidu.tieba.t.bg_live_card_middle);
            com.baidu.tbadk.core.util.ay.a(bmVar.b, com.baidu.tieba.r.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ay.f(bmVar.e, com.baidu.tieba.r.cp_bg_line_b);
            com.baidu.tbadk.core.util.ay.c(bmVar.g, com.baidu.tieba.t.icon_frs_ba_arrows_live);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                bmVar.c.setSelector(this.b.getResources().getDrawable(com.baidu.tieba.t.dot_live_s_1));
                bmVar.c.setDrawable(this.b.getResources().getDrawable(com.baidu.tieba.t.dot_live_n_1));
            } else {
                bmVar.c.setSelector(this.b.getResources().getDrawable(com.baidu.tieba.t.dot_live_s));
                bmVar.c.setDrawable(this.b.getResources().getDrawable(com.baidu.tieba.t.dot_live_n));
            }
        }
        return view;
    }

    private ArrayList<View> a(com.baidu.tbadk.core.data.i iVar) {
        ArrayList<View> arrayList = new ArrayList<>();
        if (iVar != null && iVar.a() != null) {
            Iterator<LiveCardData> it = iVar.a().iterator();
            while (it.hasNext()) {
                LiveBroadcastCard liveBroadcastCard = (LiveBroadcastCard) LayoutInflater.from(this.b).inflate(com.baidu.tieba.v.frs_live_view_pager_item, (ViewGroup) null);
                liveBroadcastCard.setData(it.next());
                liveBroadcastCard.setStatisticsKey("forum_live_ck");
                liveBroadcastCard.a(TbadkApplication.m252getInst().getSkinType());
                arrayList.add(liveBroadcastCard);
            }
        }
        return arrayList;
    }

    private View a(int i, View view, int i2) {
        View j;
        bp bpVar;
        View view2;
        bp bpVar2;
        BitmapDrawable bitmapDrawable;
        int color;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bp)) {
            j = j();
            bpVar = (bp) j.getTag();
        } else {
            bpVar = null;
            j = view;
        }
        if (bpVar == null) {
            View j2 = j();
            view2 = j2;
            bpVar2 = (bp) j2.getTag();
        } else {
            view2 = j;
            bpVar2 = bpVar;
        }
        this.b.getLayoutMode().a(i2 == 1);
        this.b.getLayoutMode().a(view2);
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        bpVar2.b.setText(nVar.j());
        com.baidu.tieba.util.p B = com.baidu.tieba.ai.c().B();
        if (B != null && B.b(nVar.h())) {
            TextView textView = bpVar2.b;
            if (i2 == 1) {
                color = this.b.getResources().getColor(com.baidu.tieba.r.listview_item_thread_read_1);
            } else {
                color = this.b.getResources().getColor(com.baidu.tieba.r.listview_item_thread_read);
            }
            textView.setTextColor(color);
        }
        if (i2 == 1) {
            if (nVar.m() == 1) {
                bitmapDrawable = (BitmapDrawable) this.b.getResources().getDrawable(com.baidu.tieba.t.icon_top_1);
            } else {
                bitmapDrawable = nVar.m() == 2 ? (BitmapDrawable) this.b.getResources().getDrawable(com.baidu.tieba.t.icon_notice_1) : null;
            }
            bpVar2.a.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg_1);
        } else {
            if (nVar.m() == 1) {
                bitmapDrawable = (BitmapDrawable) this.b.getResources().getDrawable(com.baidu.tieba.t.icon_top);
            } else {
                bitmapDrawable = nVar.m() == 2 ? (BitmapDrawable) this.b.getResources().getDrawable(com.baidu.tieba.t.icon_notice) : null;
            }
            bpVar2.a.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg);
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        bpVar2.b.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view2;
    }

    private View b(int i, View view, int i2) {
        bn bnVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bn)) {
            bnVar = new bn(this, null);
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.v.frs_official_account_item, (ViewGroup) null);
            bnVar.b = (TextView) view.findViewById(com.baidu.tieba.u.frs_fortune_bag_content);
            bnVar.a = view.findViewById(com.baidu.tieba.u.frs_fortune_bag_item);
            bnVar.c = view.findViewById(com.baidu.tieba.u.frs_my_service_item);
            bnVar.d = (TextView) view.findViewById(com.baidu.tieba.u.frs_my_service_content);
            view.setTag(bnVar);
        } else {
            bnVar = (bn) view.getTag();
        }
        if (i >= 0 && i < this.c.size() && (this.c.get(i) instanceof com.baidu.tieba.data.ag)) {
            com.baidu.tieba.data.ag agVar = (com.baidu.tieba.data.ag) this.c.get(i);
            if (agVar.a()) {
                String b = agVar.b();
                if (b != null) {
                    bnVar.b.setText(b);
                } else if (this.d.i() != null && this.d.i().getName() != null) {
                    bnVar.b.setText(this.b.getString(com.baidu.tieba.x.get_fortune_hint_format, new Object[]{this.d.i().getName()}));
                }
                bnVar.a.setTag(Integer.valueOf(i));
                bnVar.a.setOnClickListener(this);
                bnVar.a.setVisibility(0);
            } else {
                bnVar.a.setVisibility(8);
            }
            com.baidu.tieba.data.u c = agVar.c();
            if (c != null && c.a() && !TextUtils.isEmpty(c.b())) {
                bnVar.d.setText(c.b());
                bnVar.c.setTag(Integer.valueOf(i));
                bnVar.c.setOnClickListener(this);
                bnVar.c.setVisibility(0);
            } else {
                bnVar.c.setVisibility(8);
            }
        }
        this.b.getLayoutMode().a(i2 == 1);
        this.b.getLayoutMode().a(view);
        return view;
    }

    private View j() {
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.v.frs_top_item, (ViewGroup) null);
        bp bpVar = new bp(this, null);
        bpVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.frs_top_item);
        bpVar.b = (TextView) inflate.findViewById(com.baidu.tieba.u.frs_top_title);
        inflate.setTag(bpVar);
        return inflate;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0421: INVOKE  (r2v15 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x041d: INVOKE  (r2v14 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tbadk.core.data.n) type: VIRTUAL call: com.baidu.tbadk.core.data.n.g():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View c(int i, View view, int i2) {
        bq bqVar;
        int color;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bq)) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.v.frs_item, (ViewGroup) null);
            bq bqVar2 = new bq(this, null);
            bqVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_list);
            bqVar2.s = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_item_user_info_view);
            bqVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_list_item_top_linear_layout);
            bqVar2.j = (HeadImageView) view.findViewById(com.baidu.tieba.u.frs_photo);
            bqVar2.i = (UserIconBox) view.findViewById(com.baidu.tieba.u.frs_user_tshow_icon_box);
            bqVar2.h = (TextView) view.findViewById(com.baidu.tieba.u.frs_lv_author);
            bqVar2.f = (TextView) view.findViewById(com.baidu.tieba.u.frs_lv_reply_time);
            bqVar2.g = (TextView) view.findViewById(com.baidu.tieba.u.frs_lv_title);
            bqVar2.c = (TextView) view.findViewById(com.baidu.tieba.u.abstract_text);
            bqVar2.d = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.u.abstract_voice);
            bqVar2.e = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.u.abstract_img_layout);
            bqVar2.k = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_praise_btn);
            bqVar2.l = (ImageView) view.findViewById(com.baidu.tieba.u.frs_praise_icon);
            bqVar2.m = (TextView) view.findViewById(com.baidu.tieba.u.frs_praise_num);
            bqVar2.n = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_reply_btn);
            bqVar2.o = (TextView) view.findViewById(com.baidu.tieba.u.frs_reply_num);
            bqVar2.p = (FrsPraiseView) view.findViewById(com.baidu.tieba.u.frs_praise_list_user_icon);
            bqVar2.q = (TextView) view.findViewById(com.baidu.tieba.u.frs_more_abstract);
            bqVar2.r = view.findViewById(com.baidu.tieba.u.frs_item_praise_divider_line);
            bqVar2.t = (LinearLayout) view.findViewById(com.baidu.tieba.u.live_card_layout);
            bqVar2.u = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.u.item_card);
            view.setTag(bqVar2);
            bqVar = bqVar2;
        } else {
            bqVar = (bq) view.getTag();
        }
        if (i2 == 1) {
            bqVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_btn_bg_1);
            bqVar.q.setBackgroundResource(com.baidu.tieba.t.frs_item_abstract_more_text_bg_1);
        } else {
            bqVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_btn_bg);
            bqVar.q.setBackgroundResource(com.baidu.tieba.t.frs_item_abstract_more_text_bg);
        }
        bqVar.k.setOnClickListener(this);
        com.baidu.adp.lib.util.j.a(this.b, bqVar.k, 0, 10, 0, 20);
        bqVar.n.setOnClickListener(this);
        com.baidu.adp.lib.util.j.a(this.b, bqVar.n, 0, 10, 0, 20);
        bqVar.q.setOnClickListener(this);
        bqVar.k.setOnTouchListener(new bo(this, null));
        bqVar.n.setTag(Integer.valueOf(i));
        bqVar.k.setTag(Integer.valueOf(i));
        bqVar.q.setTag(Integer.valueOf(i));
        this.b.getLayoutMode().a(i2 == 1);
        this.b.getLayoutMode().a(view);
        int i3 = i - this.p;
        if (i3 == 0) {
            if (i2 == 1) {
                bqVar.a.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.t.bg_frs_1));
            } else {
                bqVar.a.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.t.bg_frs));
            }
        } else {
            bqVar.a.setBackgroundColor(17170445);
        }
        bqVar.a.setPadding(0, i3 == 0 ? this.l : this.m, 0, 0);
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        bqVar.f.setText(com.baidu.tbadk.core.util.ba.a(nVar.l() * 1000));
        if (com.baidu.tbadk.core.h.a().d()) {
            bqVar.j.setVisibility(0);
            String portrait = nVar.q().getPortrait();
            bqVar.j.setUserId(nVar.q().getUserId());
            bqVar.j.setImageDrawable(null);
            bqVar.j.a(portrait, 12, false);
        } else {
            bqVar.j.setVisibility(8);
        }
        bqVar.s.setOnClickListener(new bf(this, nVar));
        nVar.q().getIconInfo();
        this.k = nVar.q().getTShowInfo();
        if (this.k != null && this.k.size() > 0) {
            bqVar.i.setVisibility(0);
            if (i2 == 1) {
                bqVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_h_1));
            } else {
                bqVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_h));
            }
            bqVar.i.a(this.k, 2, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_margin));
        } else {
            bqVar.i.setVisibility(8);
            if (i2 == 1) {
                bqVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_c_1));
            } else {
                bqVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_c));
            }
        }
        bqVar.h.setText(nVar.q().getUserName());
        bqVar.e.setVisibility(0);
        bqVar.c.setVisibility(0);
        nVar.D();
        bqVar.g.setText(nVar.B());
        com.baidu.tieba.util.p B = com.baidu.tieba.ai.c().B();
        if (B != null && B.b(nVar.h())) {
            TextView textView = bqVar.g;
            if (i2 == 1) {
                color = this.b.getResources().getColor(com.baidu.tieba.r.listview_item_thread_read_1);
            } else {
                color = this.b.getResources().getColor(com.baidu.tieba.r.listview_item_thread_read);
            }
            textView.setTextColor(color);
        }
        if (nVar.z() == 1) {
            bqVar.g.setVisibility(8);
        } else {
            bqVar.g.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (nVar.u() != null && nVar.u().trim().length() > 0) {
            stringBuffer.append(nVar.u());
        }
        ArrayList<MediaData> x = nVar.x();
        if (x != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= x.size()) {
                    break;
                }
                if (x.get(i5).getVideoUrl() != null && x.get(i5).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(x.get(i5).getVideoUrl());
                }
                i4 = i5 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                if (stringBuffer.length() > 170) {
                    bqVar.q.setVisibility(0);
                    bqVar.c.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    bqVar.q.setVisibility(8);
                    bqVar.c.setText(stringBuffer.toString());
                }
            } else {
                bqVar.q.setVisibility(8);
                bqVar.c.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.h.a().f()) {
            if (x != null) {
                if (x.size() > 0) {
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        int i9 = i6;
                        if (i9 >= x.size()) {
                            break;
                        }
                        if (x.get(i9) != null && (x.get(i9).getType() == 3 || x.get(i9).getType() == 5)) {
                            i7++;
                            i8++;
                        }
                        i6 = i9 + 1;
                    }
                    if (i7 > 0) {
                        MediaData[] mediaDataArr = new MediaData[i7];
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            int i12 = i10;
                            int i13 = i11;
                            if (i12 >= x.size() || i13 >= i7) {
                                break;
                            }
                            if (x.get(i12).getType() == 3 || x.get(i12).getType() == 5) {
                                mediaDataArr[i13] = x.get(i12);
                                i11 = i13 + 1;
                            } else {
                                i11 = i13;
                            }
                            i10 = i12 + 1;
                        }
                        bqVar.e.a(nVar, this.d.i().getName(), this.d.i().getId(), nVar.i());
                        bqVar.e.setShowBig(this.i);
                        bqVar.e.setDrawNum(true);
                        bqVar.e.setFromCDN(this.j);
                        bqVar.e.a(mediaDataArr, i8);
                        bqVar.e.setImageFrom("other");
                    }
                } else {
                    bqVar.e.setVisibility(8);
                }
            }
        } else {
            bqVar.e.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> y = nVar.y();
        if (y != null && y.size() > 0) {
            bqVar.d.setVisibility(0);
            VoiceData.VoiceModel voiceModel = y.get(0);
            bqVar.d.setVoiceModel(voiceModel);
            bqVar.d.setTag(voiceModel);
            bqVar.d.c();
        } else {
            bqVar.d.setVisibility(8);
        }
        if (nVar.g() != null && nVar.g().getNum() > 0) {
            if (com.baidu.tbadk.core.h.a().d()) {
                bqVar.p.setVisibility(0);
                bqVar.p.setIsFromPb(false);
                bqVar.p.a(i2);
                bqVar.r.setVisibility(0);
                bqVar.p.a(nVar.g(), nVar.h(), nVar.f(), false);
            } else {
                bqVar.p.setVisibility(8);
                bqVar.r.setVisibility(8);
            }
            if (nVar.g().getIsLike() == 1) {
                if (i2 == 1) {
                    bqVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_click_1);
                } else {
                    bqVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_click);
                }
            } else if (i2 == 1) {
                bqVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_normal_1);
            } else {
                bqVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_normal);
            }
            if (nVar.g().getNum() <= 999999) {
                bqVar.m.setText(new StringBuilder().append(nVar.g().getNum()).toString());
            } else {
                bqVar.m.setText("999999+");
            }
        } else {
            bqVar.r.setVisibility(8);
            bqVar.p.setVisibility(8);
            bqVar.m.setText(this.b.getResources().getString(com.baidu.tieba.x.frs_item_praise_text));
            if (i2 == 1) {
                bqVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_normal_1);
            } else {
                bqVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_normal);
            }
        }
        int k = nVar.k();
        if (k <= 999999) {
            if (k > 0) {
                bqVar.o.setText(String.valueOf(k));
            } else {
                bqVar.o.setText(this.b.getResources().getString(com.baidu.tieba.x.frs_item_reply_text));
            }
        } else {
            bqVar.o.setText("999999+");
        }
        if (nVar.E().getGroup_id() != 0) {
            bqVar.e.setVisibility(8);
            bqVar.t.setVisibility(0);
            LiveCardData liveCardData = new LiveCardData();
            liveCardData.setPublisherId(nVar.E().getAuthorId());
            liveCardData.setPublisherName(nVar.E().getAuthorName());
            liveCardData.setPublisherPortrait(nVar.E().getPublisherPortrait());
            liveCardData.setGroupId(nVar.E().getGroup_id());
            liveCardData.setIntro(nVar.E().getIntro());
            liveCardData.setLikers(nVar.E().getLikers());
            liveCardData.setListeners(nVar.E().getListeners());
            liveCardData.setName(nVar.E().getName());
            liveCardData.setPortrait(nVar.E().getPortrait());
            liveCardData.setStatus(nVar.E().getStatus());
            liveCardData.setStartTime(nVar.E().getStartTime());
            bqVar.u.setData(liveCardData);
            bqVar.u.setStatisticsKey("notice_frs_live");
        } else {
            bqVar.t.setVisibility(8);
        }
        return view;
    }

    private View d(int i, View view, int i2) {
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        if (nVar instanceof com.baidu.tbadk.core.data.a) {
            if (((com.baidu.tbadk.core.data.a) nVar).s.g == 1) {
                return e(i, view, i2);
            }
            return f(i, view, i2);
        }
        return e(i, view, i2);
    }

    private View e(int i, View view, int i2) {
        if (view == null || !(view.getTag() instanceof bi)) {
            view = k();
        }
        bi biVar = (bi) view.getTag();
        biVar.a.setPadding(0, i - this.p == 0 ? this.l : this.m, 0, 0);
        this.b.getLayoutMode().a(i2 == 1);
        this.b.getLayoutMode().a(view);
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        if (nVar instanceof com.baidu.tbadk.core.data.a) {
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) nVar;
            if (!aVar.t) {
                aVar.t = true;
                this.b.a(aVar, "show");
                this.b.b(aVar, "show");
            }
            biVar.d.setText(aVar.s.b);
            biVar.e.setText(aVar.s.d);
            if (com.baidu.tbadk.core.h.a().f()) {
                biVar.c.setVisibility(0);
                biVar.c.a(aVar.s.c, this.j ? 13 : 14, false);
            } else {
                biVar.c.setVisibility(8);
            }
            biVar.c.setTag(aVar.s.c);
            biVar.f.setTag(Integer.valueOf(i));
            if (i2 == 1) {
                com.baidu.tbadk.core.util.ay.e((View) biVar.b, com.baidu.tieba.t.bg_label_1);
            } else {
                com.baidu.tbadk.core.util.ay.e((View) biVar.b, com.baidu.tieba.t.bg_label);
            }
            if (aVar.c()) {
                a(i2, biVar);
                biVar.f.setText(com.baidu.tieba.x.view);
                biVar.f.setOnClickListener(this.u);
            } else if (aVar.b()) {
                switch (aVar.a) {
                    case 0:
                        a(i2, biVar);
                        biVar.f.setText(com.baidu.tieba.x.download);
                        biVar.f.setOnClickListener(this.v);
                        break;
                    case 1:
                        b(i2, biVar);
                        biVar.f.setText(com.baidu.tieba.x.downloading2);
                        biVar.f.setOnClickListener(null);
                        break;
                    case 2:
                        a(i2, biVar);
                        biVar.f.setText(com.baidu.tieba.x.frs_old_style_download_text);
                        biVar.f.setOnClickListener(this.v);
                        break;
                }
            }
        }
        return view;
    }

    public void a(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    private void a(int i, bi biVar) {
        if (i == 1) {
            biVar.f.setBackgroundResource(com.baidu.tieba.t.frs_praise_btn_bg_1);
            biVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_f_1));
            return;
        }
        biVar.f.setBackgroundResource(com.baidu.tieba.t.frs_praise_btn_bg);
        biVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_f));
    }

    private void b(int i, bi biVar) {
        if (i == 1) {
            biVar.f.setBackgroundResource(com.baidu.tieba.t.btn_content_download_d_1);
            biVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text_1));
            return;
        }
        biVar.f.setBackgroundResource(com.baidu.tieba.t.btn_content_download_d);
        biVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text));
    }

    public void b(View.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    private View k() {
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.v.frs_item_app, (ViewGroup) null);
        bi biVar = new bi(this, null);
        biVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.app_parent);
        biVar.d = (TextView) inflate.findViewById(com.baidu.tieba.u.app_name);
        biVar.e = (TextView) inflate.findViewById(com.baidu.tieba.u.app_desc);
        biVar.c = (HeadImageView) inflate.findViewById(com.baidu.tieba.u.app_icon);
        biVar.f = (TextView) inflate.findViewById(com.baidu.tieba.u.app_download);
        biVar.b = (TextView) inflate.findViewById(com.baidu.tieba.u.recommend_app);
        inflate.setTag(biVar);
        return inflate;
    }

    private View f(int i, View view, int i2) {
        if (view == null || !(view.getTag() instanceof bj)) {
            view = l();
        }
        bj bjVar = (bj) view.getTag();
        bjVar.a.setPadding(0, i - this.p == 0 ? this.l : this.m, 0, 0);
        this.b.getLayoutMode().a(i2 == 1);
        this.b.getLayoutMode().a(view);
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        if (nVar instanceof com.baidu.tbadk.core.data.a) {
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) nVar;
            if (!aVar.t) {
                aVar.t = true;
                this.b.a(aVar, "show");
                this.b.b(aVar, "show");
            }
            bjVar.c.setText(a(aVar.s.b));
            if (aVar.s == null) {
                return null;
            }
            if (TextUtils.isEmpty(aVar.s.d) || TextUtils.isEmpty(aVar.s.d.trim())) {
                bjVar.e.setVisibility(8);
            } else {
                bjVar.e.setVisibility(0);
                bjVar.e.setText(aVar.s.d);
            }
            bjVar.d.setText(com.baidu.tbadk.core.util.ba.a(aVar.r));
            if (com.baidu.tbadk.core.h.a().d()) {
                bjVar.b.setVisibility(0);
                bjVar.b.a(aVar.s.c, this.j ? 13 : 14, false);
            } else {
                bjVar.b.setVisibility(8);
            }
            bjVar.b.setTag(aVar.s.c);
            if (com.baidu.tbadk.core.h.a().f() && !TextUtils.isEmpty(aVar.s.e)) {
                bjVar.f.setVisibility(0);
                bjVar.f.a(aVar.s.e, this.j ? 13 : 14, false);
                bjVar.e.setPadding(0, 0, 0, 0);
            } else {
                bjVar.f.setVisibility(8);
                bjVar.e.setPadding(0, 0, 0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds16));
            }
            bjVar.g.setTag(Integer.valueOf(i));
            if (aVar.c()) {
                bjVar.g.setVisibility(8);
                return view;
            } else if (aVar.b()) {
                bjVar.g.setVisibility(0);
                switch (aVar.a) {
                    case 0:
                        a(i2, bjVar);
                        bjVar.g.setText(com.baidu.tieba.x.pb_app_download);
                        bjVar.g.setOnClickListener(this.v);
                        return view;
                    case 1:
                        b(i2, bjVar);
                        bjVar.g.setText(com.baidu.tieba.x.downloading2);
                        bjVar.g.setOnClickListener(null);
                        return view;
                    case 2:
                        a(i2, bjVar);
                        bjVar.g.setText(com.baidu.tieba.x.frs_new_style_download_text);
                        bjVar.g.setOnClickListener(this.v);
                        return view;
                    default:
                        return view;
                }
            } else {
                return view;
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

    private void a(int i, bj bjVar) {
        if (i == 1) {
            bjVar.g.setBackgroundResource(com.baidu.tieba.t.btn_appdownload_1);
            bjVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_i_1));
            return;
        }
        bjVar.g.setBackgroundResource(com.baidu.tieba.t.btn_appdownload);
        bjVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_i));
    }

    private void b(int i, bj bjVar) {
        if (i == 1) {
            bjVar.g.setBackgroundResource(com.baidu.tieba.t.btn_content_download_d_1);
            bjVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text_1));
            return;
        }
        bjVar.g.setBackgroundResource(com.baidu.tieba.t.btn_content_download_d);
        bjVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text));
    }

    private View l() {
        View inflate = LayoutInflater.from(this.b).inflate(com.baidu.tieba.v.frs_item_app_new, (ViewGroup) null);
        bj bjVar = new bj(this, null);
        if (a || inflate != 0) {
            bjVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.frs_app_item_parent);
            bjVar.b = (HeadImageView) inflate.findViewById(com.baidu.tieba.u.frs_app_icon);
            bjVar.c = (TextView) inflate.findViewById(com.baidu.tieba.u.frs_app_name);
            bjVar.d = (TextView) inflate.findViewById(com.baidu.tieba.u.frs_app_time);
            bjVar.e = (TextView) inflate.findViewById(com.baidu.tieba.u.frs_app_desc);
            bjVar.f = (TbImageView) inflate.findViewById(com.baidu.tieba.u.frs_app_url);
            bjVar.g = (TextView) inflate.findViewById(com.baidu.tieba.u.frs_app_download);
            inflate.setTag(bjVar);
            return inflate;
        }
        throw new AssertionError();
    }

    private View a(View view, int i) {
        bk bkVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bk)) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.v.frs_item_control, (ViewGroup) null);
            bk bkVar2 = new bk(this, null);
            bkVar2.a = (FrameLayout) view.findViewById(com.baidu.tieba.u.frs_list_control);
            bkVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_list_control_in);
            bkVar2.d = (ProgressBar) view.findViewById(com.baidu.tieba.u.frs_list_control_progress);
            bkVar2.c = (TextView) view.findViewById(com.baidu.tieba.u.frs_list_control_tv);
            view.setTag(bkVar2);
            bkVar = bkVar2;
        } else {
            bkVar = (bk) view.getTag();
        }
        if (this.e) {
            bkVar.a.setVisibility(0);
            bkVar.a.setPadding(0, this.l, 0, 0);
            if (this.h) {
                bkVar.c.setText(com.baidu.tieba.x.loading);
                bkVar.d.setVisibility(0);
            } else {
                bkVar.c.setText(com.baidu.tieba.x.frs_pre);
                bkVar.d.setVisibility(8);
            }
            if (i == 1) {
                bkVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_bg_1);
            } else {
                bkVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_bg);
            }
            com.baidu.tbadk.core.util.ay.b(bkVar.c, i);
        } else {
            bkVar.a.setVisibility(8);
        }
        return view;
    }

    private View b(View view, int i) {
        bk bkVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bk)) {
            view = LayoutInflater.from(this.b).inflate(com.baidu.tieba.v.frs_item_control, (ViewGroup) null);
            bk bkVar2 = new bk(this, null);
            bkVar2.a = (FrameLayout) view.findViewById(com.baidu.tieba.u.frs_list_control);
            bkVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_list_control_in);
            bkVar2.d = (ProgressBar) view.findViewById(com.baidu.tieba.u.frs_list_control_progress);
            bkVar2.c = (TextView) view.findViewById(com.baidu.tieba.u.frs_list_control_tv);
            view.setTag(bkVar2);
            bkVar = bkVar2;
        } else {
            bkVar = (bk) view.getTag();
        }
        if (this.f) {
            bkVar.a.setVisibility(0);
            bkVar.a.setPadding(0, this.l, 0, this.l);
            if (this.g) {
                bkVar.c.setText(com.baidu.tieba.x.loading);
                bkVar.d.setVisibility(0);
            } else {
                bkVar.c.setText(com.baidu.tieba.x.frs_next);
                bkVar.d.setVisibility(8);
            }
            if (i == 1) {
                bkVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_bg_1);
            } else {
                bkVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_bg);
            }
            com.baidu.tbadk.core.util.ay.b(bkVar.c, i);
        } else {
            bkVar.a.setVisibility(8);
        }
        return view;
    }

    public void d() {
        if (this.c != null) {
            int size = this.c.size();
            for (int i = 0; i < size && this.c.get(i).m() != 0; i++) {
                this.c.get(i).D();
            }
        }
    }

    public void f(boolean z) {
        this.j = z;
    }

    public void a(bl blVar) {
        this.w = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.w != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(intValue);
            View childAt = this.t.getChildAt(intValue - (this.t.getFirstVisiblePosition() - this.t.getHeaderViewsCount()));
            if (view.getId() == e()) {
                if (this.o) {
                    this.w.a(id, intValue, view, childAt, nVar);
                }
            } else if (view.getId() == com.baidu.tieba.u.frs_live_upItem) {
                com.baidu.tbadk.core.f.a(this.b, "all_live_read");
                if (this.d != null && this.d.i() != null && !TextUtils.isEmpty(this.d.i().getId()) && this.d.k() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.u(this.b, this.d.i().getId(), this.d.k().getIsManager())));
                }
            } else {
                this.w.a(id, intValue, view, childAt, nVar);
            }
        }
    }

    public int e() {
        return com.baidu.tieba.u.frs_praise_btn;
    }

    public int f() {
        return com.baidu.tieba.u.frs_reply_btn;
    }

    public int g() {
        return com.baidu.tieba.u.frs_more_abstract;
    }

    public int h() {
        return com.baidu.tieba.u.frs_fortune_bag_item;
    }

    public int i() {
        return com.baidu.tieba.u.frs_my_service_item;
    }

    public void a(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.b, com.baidu.tieba.o.praise_animation_scale2));
            new Handler().postDelayed(new bg(this), 200L);
        }
    }

    public void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.b, com.baidu.tieba.o.praise_animation_scale3));
            new Handler().postDelayed(new bh(this), 600L);
        }
    }

    public void a(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.b, com.baidu.tieba.o.praise_animation_scale1));
    }
}
