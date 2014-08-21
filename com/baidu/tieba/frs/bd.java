package com.baidu.tieba.frs;

import android.annotation.SuppressLint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
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
public class bd extends BaseAdapter implements View.OnClickListener {
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
    private bm w;
    private boolean j = false;
    private LinkedList<IconData> k = null;
    private long n = 0;
    private boolean o = true;
    private int r = -1;

    static {
        a = !bd.class.desiredAssertionStatus();
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

    public bd(FrsActivity frsActivity, ArrayList<com.baidu.tbadk.core.data.n> arrayList, int i, boolean z) {
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
        bn bnVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bn)) {
            view = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.frs_live_view_pager_div, viewGroup, false);
            bnVar = new bn(this, null);
            bnVar.d = (TextView) view.findViewById(com.baidu.tieba.u.live_title);
            bnVar.a = (ChildViewPager) view.findViewById(com.baidu.tieba.u.live_title_child);
            bnVar.c = (IndicatorView) view.findViewById(com.baidu.tieba.u.live_tab_indicator);
            bnVar.b = (TextView) view.findViewById(com.baidu.tieba.u.live_show_all);
            bnVar.e = view.findViewById(com.baidu.tieba.u.live_title_card_line);
            bnVar.f = view.findViewById(com.baidu.tieba.u.middle_layout);
            bnVar.g = (ImageView) view.findViewById(com.baidu.tieba.u.live_arrow);
            bnVar.h = (RelativeLayout) view.findViewById(com.baidu.tieba.u.frs_live_upItem);
            view.setTag(bnVar);
        } else {
            bnVar = (bn) view.getTag();
        }
        if (i >= 0 && i < this.c.size() && (this.c.get(i) instanceof com.baidu.tbadk.core.data.i)) {
            com.baidu.tbadk.core.data.i iVar = (com.baidu.tbadk.core.data.i) this.c.get(i);
            ds dsVar = new ds(a(iVar));
            bnVar.a.setAdapter(dsVar);
            bnVar.a.setOnPageChangeListener(new be(this, bnVar.c));
            bnVar.a.setOnSingleTouchListener(new bf(this, iVar));
            if (dsVar.getCount() > 1) {
                if (bnVar.c.getVisibility() != 0) {
                    bnVar.c.setVisibility(0);
                }
                bnVar.c.setCount(dsVar.getCount());
                bnVar.c.setPosition(0.0f);
            } else if (bnVar.c.getVisibility() != 8) {
                bnVar.c.setVisibility(8);
            }
            bnVar.b.setTag(Integer.valueOf(i));
            bnVar.g.setTag(Integer.valueOf(i));
            bnVar.h.setTag(Integer.valueOf(i));
            bnVar.h.setOnClickListener(this);
            com.baidu.tbadk.core.util.ay.f(bnVar.h, com.baidu.tieba.t.bg_live_card_up);
            com.baidu.tbadk.core.util.ay.a(bnVar.d, com.baidu.tieba.r.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ay.f(bnVar.f, com.baidu.tieba.t.bg_live_card_middle);
            com.baidu.tbadk.core.util.ay.a(bnVar.b, com.baidu.tieba.r.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ay.f(bnVar.e, com.baidu.tieba.r.cp_bg_line_b);
            com.baidu.tbadk.core.util.ay.c(bnVar.g, com.baidu.tieba.t.icon_frs_ba_arrows_live);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                bnVar.c.setSelector(this.b.getResources().getDrawable(com.baidu.tieba.t.dot_live_s_1));
                bnVar.c.setDrawable(this.b.getResources().getDrawable(com.baidu.tieba.t.dot_live_n_1));
            } else {
                bnVar.c.setSelector(this.b.getResources().getDrawable(com.baidu.tieba.t.dot_live_s));
                bnVar.c.setDrawable(this.b.getResources().getDrawable(com.baidu.tieba.t.dot_live_n));
            }
        }
        return view;
    }

    private ArrayList<View> a(com.baidu.tbadk.core.data.i iVar) {
        ArrayList<View> arrayList = new ArrayList<>();
        if (iVar != null && iVar.a() != null) {
            Iterator<LiveCardData> it = iVar.a().iterator();
            while (it.hasNext()) {
                LiveBroadcastCard liveBroadcastCard = (LiveBroadcastCard) com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.frs_live_view_pager_item, null);
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
        bq bqVar;
        View view2;
        bq bqVar2;
        BitmapDrawable bitmapDrawable;
        int color;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bq)) {
            j = j();
            bqVar = (bq) j.getTag();
        } else {
            bqVar = null;
            j = view;
        }
        if (bqVar == null) {
            View j2 = j();
            view2 = j2;
            bqVar2 = (bq) j2.getTag();
        } else {
            view2 = j;
            bqVar2 = bqVar;
        }
        this.b.getLayoutMode().a(i2 == 1);
        this.b.getLayoutMode().a(view2);
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        bqVar2.b.setText(nVar.j());
        com.baidu.tieba.util.p B = com.baidu.tieba.ai.c().B();
        if (B != null && B.b(nVar.h())) {
            TextView textView = bqVar2.b;
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
            bqVar2.a.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg_1);
        } else {
            if (nVar.m() == 1) {
                bitmapDrawable = (BitmapDrawable) this.b.getResources().getDrawable(com.baidu.tieba.t.icon_top);
            } else {
                bitmapDrawable = nVar.m() == 2 ? (BitmapDrawable) this.b.getResources().getDrawable(com.baidu.tieba.t.icon_notice) : null;
            }
            bqVar2.a.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg);
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        bqVar2.b.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view2;
    }

    private View b(int i, View view, int i2) {
        bo boVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bo)) {
            boVar = new bo(this, null);
            view = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.frs_official_account_item, null);
            boVar.b = (TextView) view.findViewById(com.baidu.tieba.u.frs_fortune_bag_content);
            boVar.a = view.findViewById(com.baidu.tieba.u.frs_fortune_bag_item);
            boVar.c = view.findViewById(com.baidu.tieba.u.frs_my_service_item);
            boVar.d = (TextView) view.findViewById(com.baidu.tieba.u.frs_my_service_content);
            view.setTag(boVar);
        } else {
            boVar = (bo) view.getTag();
        }
        if (i >= 0 && i < this.c.size() && (this.c.get(i) instanceof com.baidu.tieba.data.ag)) {
            com.baidu.tieba.data.ag agVar = (com.baidu.tieba.data.ag) this.c.get(i);
            if (agVar.a()) {
                String b = agVar.b();
                if (b != null) {
                    boVar.b.setText(b);
                } else if (this.d.i() != null && this.d.i().getName() != null) {
                    boVar.b.setText(this.b.getString(com.baidu.tieba.x.get_fortune_hint_format, new Object[]{this.d.i().getName()}));
                }
                boVar.a.setTag(Integer.valueOf(i));
                boVar.a.setOnClickListener(this);
                boVar.a.setVisibility(0);
            } else {
                boVar.a.setVisibility(8);
            }
            com.baidu.tieba.data.u c = agVar.c();
            if (c != null && c.a() && !TextUtils.isEmpty(c.b())) {
                boVar.d.setText(c.b());
                boVar.c.setTag(Integer.valueOf(i));
                boVar.c.setOnClickListener(this);
                boVar.c.setVisibility(0);
            } else {
                boVar.c.setVisibility(8);
            }
        }
        this.b.getLayoutMode().a(i2 == 1);
        this.b.getLayoutMode().a(view);
        return view;
    }

    private View j() {
        View a2 = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.frs_top_item, null);
        bq bqVar = new bq(this, null);
        bqVar.a = (LinearLayout) a2.findViewById(com.baidu.tieba.u.frs_top_item);
        bqVar.b = (TextView) a2.findViewById(com.baidu.tieba.u.frs_top_title);
        a2.setTag(bqVar);
        return a2;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0421: INVOKE  (r2v17 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x041d: INVOKE  (r2v16 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tbadk.core.data.n) type: VIRTUAL call: com.baidu.tbadk.core.data.n.g():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View c(int i, View view, int i2) {
        br brVar;
        int color;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof br)) {
            view = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.frs_item, null);
            br brVar2 = new br(this, null);
            brVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_list);
            brVar2.s = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_item_user_info_view);
            brVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_list_item_top_linear_layout);
            brVar2.j = (HeadImageView) view.findViewById(com.baidu.tieba.u.frs_photo);
            brVar2.i = (UserIconBox) view.findViewById(com.baidu.tieba.u.frs_user_tshow_icon_box);
            brVar2.h = (TextView) view.findViewById(com.baidu.tieba.u.frs_lv_author);
            brVar2.f = (TextView) view.findViewById(com.baidu.tieba.u.frs_lv_reply_time);
            brVar2.g = (TextView) view.findViewById(com.baidu.tieba.u.frs_lv_title);
            brVar2.c = (TextView) view.findViewById(com.baidu.tieba.u.abstract_text);
            brVar2.d = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.u.abstract_voice);
            brVar2.e = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.u.abstract_img_layout);
            brVar2.k = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_praise_btn);
            brVar2.l = (ImageView) view.findViewById(com.baidu.tieba.u.frs_praise_icon);
            brVar2.m = (TextView) view.findViewById(com.baidu.tieba.u.frs_praise_num);
            brVar2.n = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_reply_btn);
            brVar2.o = (TextView) view.findViewById(com.baidu.tieba.u.frs_reply_num);
            brVar2.p = (FrsPraiseView) view.findViewById(com.baidu.tieba.u.frs_praise_list_user_icon);
            brVar2.q = (TextView) view.findViewById(com.baidu.tieba.u.frs_more_abstract);
            brVar2.r = view.findViewById(com.baidu.tieba.u.frs_item_praise_divider_line);
            brVar2.t = (LinearLayout) view.findViewById(com.baidu.tieba.u.live_card_layout);
            brVar2.u = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.u.item_card);
            view.setTag(brVar2);
            brVar = brVar2;
        } else {
            brVar = (br) view.getTag();
        }
        if (i2 == 1) {
            brVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_btn_bg_1);
            brVar.q.setBackgroundResource(com.baidu.tieba.t.frs_item_abstract_more_text_bg_1);
        } else {
            brVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_btn_bg);
            brVar.q.setBackgroundResource(com.baidu.tieba.t.frs_item_abstract_more_text_bg);
        }
        brVar.k.setOnClickListener(this);
        com.baidu.adp.lib.util.j.a(this.b, brVar.k, 0, 10, 0, 20);
        brVar.n.setOnClickListener(this);
        com.baidu.adp.lib.util.j.a(this.b, brVar.n, 0, 10, 0, 20);
        brVar.q.setOnClickListener(this);
        brVar.k.setOnTouchListener(new bp(this, null));
        brVar.n.setTag(Integer.valueOf(i));
        brVar.k.setTag(Integer.valueOf(i));
        brVar.q.setTag(Integer.valueOf(i));
        this.b.getLayoutMode().a(i2 == 1);
        this.b.getLayoutMode().a(view);
        int i3 = i - this.p;
        if (i3 == 0) {
            if (i2 == 1) {
                brVar.a.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.t.bg_frs_1));
            } else {
                brVar.a.setBackgroundDrawable(this.b.getResources().getDrawable(com.baidu.tieba.t.bg_frs));
            }
        } else {
            brVar.a.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.transparent));
        }
        brVar.a.setPadding(0, i3 == 0 ? this.l : this.m, 0, 0);
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        brVar.f.setText(com.baidu.tbadk.core.util.ba.a(nVar.l() * 1000));
        if (com.baidu.tbadk.core.h.a().d()) {
            brVar.j.setVisibility(0);
            String portrait = nVar.q().getPortrait();
            brVar.j.setUserId(nVar.q().getUserId());
            brVar.j.setImageDrawable(null);
            brVar.j.a(portrait, 12, false);
        } else {
            brVar.j.setVisibility(8);
        }
        brVar.s.setOnClickListener(new bg(this, nVar));
        nVar.q().getIconInfo();
        this.k = nVar.q().getTShowInfo();
        if (this.k != null && this.k.size() > 0) {
            brVar.i.setVisibility(0);
            if (i2 == 1) {
                brVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_h_1));
            } else {
                brVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_h));
            }
            brVar.i.a(this.k, 2, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_margin));
        } else {
            brVar.i.setVisibility(8);
            if (i2 == 1) {
                brVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_c_1));
            } else {
                brVar.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_c));
            }
        }
        brVar.h.setText(nVar.q().getUserName());
        brVar.e.setVisibility(0);
        brVar.c.setVisibility(0);
        nVar.D();
        brVar.g.setText(nVar.B());
        com.baidu.tieba.util.p B = com.baidu.tieba.ai.c().B();
        if (B != null && B.b(nVar.h())) {
            TextView textView = brVar.g;
            if (i2 == 1) {
                color = this.b.getResources().getColor(com.baidu.tieba.r.listview_item_thread_read_1);
            } else {
                color = this.b.getResources().getColor(com.baidu.tieba.r.listview_item_thread_read);
            }
            textView.setTextColor(color);
        }
        if (nVar.z() == 1) {
            brVar.g.setVisibility(8);
        } else {
            brVar.g.setVisibility(0);
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
                    brVar.q.setVisibility(0);
                    brVar.c.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    brVar.q.setVisibility(8);
                    brVar.c.setText(stringBuffer.toString());
                }
            } else {
                brVar.q.setVisibility(8);
                brVar.c.setVisibility(8);
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
                        brVar.e.a(nVar, this.d.i().getName(), this.d.i().getId(), nVar.i());
                        brVar.e.setShowBig(this.i);
                        brVar.e.setDrawNum(true);
                        brVar.e.setFromCDN(this.j);
                        brVar.e.a(mediaDataArr, i8);
                        brVar.e.setImageFrom("other");
                    }
                } else {
                    brVar.e.setVisibility(8);
                }
            }
        } else {
            brVar.e.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> y = nVar.y();
        if (y != null && y.size() > 0) {
            brVar.d.setVisibility(0);
            VoiceData.VoiceModel voiceModel = y.get(0);
            brVar.d.setVoiceModel(voiceModel);
            brVar.d.setTag(voiceModel);
            brVar.d.c();
        } else {
            brVar.d.setVisibility(8);
        }
        if (nVar.g() != null && nVar.g().getNum() > 0) {
            if (com.baidu.tbadk.core.h.a().d()) {
                brVar.p.setVisibility(0);
                brVar.p.setIsFromPb(false);
                brVar.p.a(i2);
                brVar.r.setVisibility(0);
                brVar.p.a(nVar.g(), nVar.h(), nVar.f(), false);
            } else {
                brVar.p.setVisibility(8);
                brVar.r.setVisibility(8);
            }
            if (nVar.g().getIsLike() == 1) {
                if (i2 == 1) {
                    brVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_click_1);
                } else {
                    brVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_click);
                }
            } else if (i2 == 1) {
                brVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_normal_1);
            } else {
                brVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_normal);
            }
            if (nVar.g().getNum() <= 999999) {
                brVar.m.setText(new StringBuilder().append(nVar.g().getNum()).toString());
            } else {
                brVar.m.setText("999999+");
            }
        } else {
            brVar.r.setVisibility(8);
            brVar.p.setVisibility(8);
            brVar.m.setText(this.b.getResources().getString(com.baidu.tieba.x.frs_item_praise_text));
            if (i2 == 1) {
                brVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_normal_1);
            } else {
                brVar.l.setImageResource(com.baidu.tieba.t.icon_hand_frs_normal);
            }
        }
        int k = nVar.k();
        if (k <= 999999) {
            if (k > 0) {
                brVar.o.setText(String.valueOf(k));
            } else {
                brVar.o.setText(this.b.getResources().getString(com.baidu.tieba.x.frs_item_reply_text));
            }
        } else {
            brVar.o.setText("999999+");
        }
        if (nVar.E().getGroup_id() != 0) {
            brVar.e.setVisibility(8);
            brVar.t.setVisibility(0);
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
            brVar.u.setData(liveCardData);
            brVar.u.setStatisticsKey("notice_frs_live");
        } else {
            brVar.t.setVisibility(8);
        }
        return view;
    }

    private View d(int i, View view, int i2) {
        com.baidu.tbadk.core.data.n nVar = (com.baidu.tbadk.core.data.n) getItem(i);
        if (this.b != null) {
            this.b.l();
        }
        if (nVar instanceof com.baidu.tbadk.core.data.a) {
            if (((com.baidu.tbadk.core.data.a) nVar).s.g == 1) {
                return e(i, view, i2);
            }
            return f(i, view, i2);
        }
        return e(i, view, i2);
    }

    private View e(int i, View view, int i2) {
        if (view == null || !(view.getTag() instanceof bj)) {
            view = k();
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
            bjVar.d.setText(aVar.s.b);
            bjVar.e.setText(aVar.s.d);
            if (com.baidu.tbadk.core.h.a().f()) {
                bjVar.c.setVisibility(0);
                bjVar.c.a(aVar.s.c, this.j ? 13 : 14, false);
            } else {
                bjVar.c.setVisibility(8);
            }
            bjVar.c.setTag(aVar.s.c);
            bjVar.f.setTag(Integer.valueOf(i));
            if (i2 == 1) {
                com.baidu.tbadk.core.util.ay.e((View) bjVar.b, com.baidu.tieba.t.bg_label_1);
            } else {
                com.baidu.tbadk.core.util.ay.e((View) bjVar.b, com.baidu.tieba.t.bg_label);
            }
            if (aVar.c()) {
                a(i2, bjVar);
                bjVar.f.setText(com.baidu.tieba.x.view);
                bjVar.f.setOnClickListener(this.u);
            } else if (aVar.b()) {
                switch (aVar.a) {
                    case 0:
                        a(i2, bjVar);
                        bjVar.f.setText(com.baidu.tieba.x.game_center_download);
                        bjVar.f.setOnClickListener(this.v);
                        break;
                    case 1:
                        b(i2, bjVar);
                        bjVar.f.setText(com.baidu.tieba.x.downloading2);
                        bjVar.f.setOnClickListener(null);
                        break;
                    case 2:
                        a(i2, bjVar);
                        bjVar.f.setText(com.baidu.tieba.x.frs_old_style_download_text);
                        bjVar.f.setOnClickListener(this.v);
                        break;
                }
            }
        }
        return view;
    }

    public void a(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    private void a(int i, bj bjVar) {
        if (i == 1) {
            bjVar.f.setBackgroundResource(com.baidu.tieba.t.frs_praise_btn_bg_1);
            bjVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_f_1));
            return;
        }
        bjVar.f.setBackgroundResource(com.baidu.tieba.t.frs_praise_btn_bg);
        bjVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_f));
    }

    private void b(int i, bj bjVar) {
        if (i == 1) {
            bjVar.f.setBackgroundResource(com.baidu.tieba.t.btn_content_download_d_1);
            bjVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text_1));
            return;
        }
        bjVar.f.setBackgroundResource(com.baidu.tieba.t.btn_content_download_d);
        bjVar.f.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text));
    }

    public void b(View.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    private View k() {
        View a2 = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.frs_item_app, null);
        bj bjVar = new bj(this, null);
        bjVar.a = (LinearLayout) a2.findViewById(com.baidu.tieba.u.app_parent);
        bjVar.d = (TextView) a2.findViewById(com.baidu.tieba.u.app_name);
        bjVar.e = (TextView) a2.findViewById(com.baidu.tieba.u.app_desc);
        bjVar.c = (HeadImageView) a2.findViewById(com.baidu.tieba.u.app_icon);
        bjVar.f = (TextView) a2.findViewById(com.baidu.tieba.u.app_download);
        bjVar.b = (TextView) a2.findViewById(com.baidu.tieba.u.recommend_app);
        a2.setTag(bjVar);
        return a2;
    }

    private View f(int i, View view, int i2) {
        if (view == null || !(view.getTag() instanceof bk)) {
            view = l();
        }
        bk bkVar = (bk) view.getTag();
        bkVar.a.setPadding(0, i - this.p == 0 ? this.l : this.m, 0, 0);
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
            bkVar.c.setText(a(aVar.s.b));
            if (aVar.s == null) {
                return null;
            }
            if (TextUtils.isEmpty(aVar.s.d) || TextUtils.isEmpty(aVar.s.d.trim())) {
                bkVar.e.setVisibility(8);
            } else {
                bkVar.e.setVisibility(0);
                bkVar.e.setText(aVar.s.d);
            }
            bkVar.d.setText(com.baidu.tbadk.core.util.ba.a(aVar.r));
            if (com.baidu.tbadk.core.h.a().d()) {
                bkVar.b.setVisibility(0);
                bkVar.b.a(aVar.s.c, this.j ? 13 : 14, false);
            } else {
                bkVar.b.setVisibility(8);
            }
            bkVar.b.setTag(aVar.s.c);
            if (com.baidu.tbadk.core.h.a().f() && !TextUtils.isEmpty(aVar.s.e)) {
                bkVar.f.setVisibility(0);
                bkVar.f.a(aVar.s.e, this.j ? 13 : 14, false);
                bkVar.e.setPadding(0, 0, 0, 0);
            } else {
                bkVar.f.setVisibility(8);
                bkVar.e.setPadding(0, 0, 0, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds30));
            }
            bkVar.g.setTag(Integer.valueOf(i));
            if (aVar.c()) {
                bkVar.g.setVisibility(8);
                return view;
            } else if (aVar.b()) {
                bkVar.g.setVisibility(0);
                switch (aVar.a) {
                    case 0:
                        a(i2, bkVar);
                        bkVar.g.setText(com.baidu.tieba.x.pb_app_download);
                        bkVar.g.setOnClickListener(this.v);
                        return view;
                    case 1:
                        b(i2, bkVar);
                        bkVar.g.setText(com.baidu.tieba.x.downloading2);
                        bkVar.g.setOnClickListener(null);
                        return view;
                    case 2:
                        a(i2, bkVar);
                        bkVar.g.setText(com.baidu.tieba.x.frs_new_style_download_text);
                        bkVar.g.setOnClickListener(this.v);
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

    private void a(int i, bk bkVar) {
        if (i == 1) {
            bkVar.g.setBackgroundResource(com.baidu.tieba.t.btn_appdownload_1);
            bkVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_i_1));
            return;
        }
        bkVar.g.setBackgroundResource(com.baidu.tieba.t.btn_appdownload);
        bkVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_i));
    }

    private void b(int i, bk bkVar) {
        if (i == 1) {
            bkVar.g.setBackgroundResource(com.baidu.tieba.t.btn_content_download_d_1);
            bkVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text_1));
            return;
        }
        bkVar.g.setBackgroundResource(com.baidu.tieba.t.btn_content_download_d);
        bkVar.g.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.faceshop_downloaded_text));
    }

    private View l() {
        View a2 = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.frs_item_app_new, null);
        bk bkVar = new bk(this, null);
        if (a || a2 != 0) {
            bkVar.a = (LinearLayout) a2.findViewById(com.baidu.tieba.u.frs_app_item_parent);
            bkVar.b = (HeadImageView) a2.findViewById(com.baidu.tieba.u.frs_app_icon);
            bkVar.c = (TextView) a2.findViewById(com.baidu.tieba.u.frs_app_name);
            bkVar.d = (TextView) a2.findViewById(com.baidu.tieba.u.frs_app_time);
            bkVar.e = (TextView) a2.findViewById(com.baidu.tieba.u.frs_app_desc);
            bkVar.f = (TbImageView) a2.findViewById(com.baidu.tieba.u.frs_app_url);
            bkVar.g = (TextView) a2.findViewById(com.baidu.tieba.u.frs_app_download);
            a2.setTag(bkVar);
            return a2;
        }
        throw new AssertionError();
    }

    private View a(View view, int i) {
        bl blVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bl)) {
            view = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.frs_item_control, null);
            bl blVar2 = new bl(this, null);
            blVar2.a = (FrameLayout) view.findViewById(com.baidu.tieba.u.frs_list_control);
            blVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_list_control_in);
            blVar2.d = (ProgressBar) view.findViewById(com.baidu.tieba.u.frs_list_control_progress);
            blVar2.c = (TextView) view.findViewById(com.baidu.tieba.u.frs_list_control_tv);
            view.setTag(blVar2);
            blVar = blVar2;
        } else {
            blVar = (bl) view.getTag();
        }
        if (this.e) {
            blVar.a.setVisibility(0);
            blVar.a.setPadding(0, this.l, 0, 0);
            if (this.h) {
                blVar.c.setText(com.baidu.tieba.x.loading);
                blVar.d.setVisibility(0);
            } else {
                blVar.c.setText(com.baidu.tieba.x.frs_pre);
                blVar.d.setVisibility(8);
            }
            if (i == 1) {
                blVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_bg_1);
            } else {
                blVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_bg);
            }
            com.baidu.tbadk.core.util.ay.b(blVar.c, i);
        } else {
            blVar.a.setVisibility(8);
        }
        return view;
    }

    private View b(View view, int i) {
        bl blVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof bl)) {
            view = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.frs_item_control, null);
            bl blVar2 = new bl(this, null);
            blVar2.a = (FrameLayout) view.findViewById(com.baidu.tieba.u.frs_list_control);
            blVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_list_control_in);
            blVar2.d = (ProgressBar) view.findViewById(com.baidu.tieba.u.frs_list_control_progress);
            blVar2.c = (TextView) view.findViewById(com.baidu.tieba.u.frs_list_control_tv);
            view.setTag(blVar2);
            blVar = blVar2;
        } else {
            blVar = (bl) view.getTag();
        }
        if (this.f) {
            blVar.a.setVisibility(0);
            blVar.a.setPadding(0, this.l, 0, this.l);
            if (this.g) {
                blVar.c.setText(com.baidu.tieba.x.loading);
                blVar.d.setVisibility(0);
            } else {
                blVar.c.setText(com.baidu.tieba.x.frs_next);
                blVar.d.setVisibility(8);
            }
            if (i == 1) {
                blVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_bg_1);
            } else {
                blVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_bg);
            }
            com.baidu.tbadk.core.util.ay.b(blVar.c, i);
        } else {
            blVar.a.setVisibility(8);
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

    public void a(bm bmVar) {
        this.w = bmVar;
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
            new Handler().postDelayed(new bh(this), 200L);
        }
    }

    public void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.b, com.baidu.tieba.o.praise_animation_scale3));
            new Handler().postDelayed(new bi(this), 600L);
        }
    }

    public void a(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.b, com.baidu.tieba.o.praise_animation_scale1));
    }
}
