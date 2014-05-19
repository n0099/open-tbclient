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
public class ba extends BaseAdapter implements View.OnClickListener {
    private final Context a;
    private ArrayList<com.baidu.tbadk.core.data.o> b;
    private g c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final com.baidu.tbadk.editortool.ab h;
    private boolean i;
    private final int l;
    private final int m;
    private int p;
    private ArrayList<Integer> q;
    private final HashMap<Integer, com.baidu.tbadk.core.data.o> s;
    private ListView t;
    private bj v;
    private boolean j = false;
    private LinkedList<IconData> k = null;
    private long n = 0;
    private boolean o = true;
    private int r = -1;
    private final View.OnClickListener u = new bb(this);

    private int a(ArrayList<com.baidu.tbadk.core.data.o> arrayList) {
        int i = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.tbadk.core.data.o> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.tbadk.core.data.o next = it.next();
                if (next.p() == 1 || next.p() == 2) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    private ArrayList<Integer> b(ArrayList<com.baidu.tbadk.core.data.o> arrayList) {
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
            com.baidu.tbadk.core.data.o oVar = arrayList.get(i2);
            if (oVar instanceof com.baidu.tbadk.core.data.b) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.s != null && !this.s.containsValue(oVar)) {
                    this.s.put(Integer.valueOf(i2), oVar);
                }
            }
            i = i2 + 1;
        }
    }

    public ba(Context context, ArrayList<com.baidu.tbadk.core.data.o> arrayList, int i, boolean z) {
        this.i = false;
        this.a = context;
        this.b = arrayList;
        this.h = new com.baidu.tbadk.editortool.ab(this.a);
        this.h.d(true);
        this.i = z;
        a(z);
        this.p = a(this.b);
        this.l = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.listview_item_margin);
        this.m = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.listview_divider_height);
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
        this.f = z;
    }

    public boolean a() {
        return this.f;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public boolean b() {
        return this.g;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public void e(boolean z) {
        this.e = z;
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.o> arrayList, g gVar) {
        this.b = arrayList;
        this.c = gVar;
        this.p = a(this.b);
        this.q = b(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b == null) {
            return 0;
        }
        int size = 0 + this.b.size();
        if (this.d) {
            size++;
        }
        if (this.e) {
            return size + 1;
        }
        return size;
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.o> c() {
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
        int i2;
        if (i < this.p) {
            return i;
        }
        if (!this.d) {
            i2 = i;
        } else if (i == this.p) {
            return -1L;
        } else {
            i2 = i - 1;
        }
        if (this.e && i == getCount() - 1) {
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
        if (i < this.p) {
            return 2;
        }
        if (this.d && i - this.p == 0) {
            return 0;
        }
        if (this.e && i == getCount() - 1) {
            return 1;
        }
        if (this.q.contains(Integer.valueOf(i))) {
            return 4;
        }
        if (i == this.r) {
            return 5;
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
        bk bkVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.frs_live_view_pager_div, viewGroup, false);
            bkVar = new bk(this, null);
            bkVar.d = (TextView) view.findViewById(com.baidu.tieba.r.live_title);
            bkVar.a = (ChildViewPager) view.findViewById(com.baidu.tieba.r.live_title_child);
            bkVar.c = (IndicatorView) view.findViewById(com.baidu.tieba.r.live_tab_indicator);
            bkVar.b = (TextView) view.findViewById(com.baidu.tieba.r.live_show_all);
            bkVar.e = view.findViewById(com.baidu.tieba.r.live_title_card_line);
            bkVar.f = view.findViewById(com.baidu.tieba.r.live_title_card_line_2);
            bkVar.g = view.findViewById(com.baidu.tieba.r.middle_layout);
            view.setTag(bkVar);
        } else {
            bkVar = (bk) view.getTag();
        }
        if (i >= 0 && i < this.b.size() && (this.b.get(i) instanceof com.baidu.tbadk.core.data.h)) {
            com.baidu.tbadk.core.data.h hVar = (com.baidu.tbadk.core.data.h) this.b.get(i);
            dl dlVar = new dl(a(hVar));
            bkVar.a.setAdapter(dlVar);
            bkVar.a.setOnPageChangeListener(new bc(this, bkVar.c));
            bkVar.a.setOnSingleTouchListener(new bd(this, hVar));
            bkVar.c.setCount(dlVar.getCount());
            bkVar.c.setPosition(0.0f);
            bkVar.b.setTag(Integer.valueOf(i));
            bkVar.b.setOnClickListener(this);
            com.baidu.tbadk.core.util.bc.f((View) bkVar.d, com.baidu.tieba.q.bg_live_card_up);
            com.baidu.tbadk.core.util.bc.a(bkVar.d, com.baidu.tieba.o.cp_cont_c, 1);
            com.baidu.tbadk.core.util.bc.f(bkVar.g, com.baidu.tieba.q.bg_live_card_middle);
            com.baidu.tbadk.core.util.bc.f((View) bkVar.b, com.baidu.tieba.q.bg_live_card_down);
            com.baidu.tbadk.core.util.bc.a(bkVar.b, com.baidu.tieba.o.cp_cont_c, 1);
            com.baidu.tbadk.core.util.bc.f(bkVar.e, com.baidu.tieba.o.cp_bg_line_b);
            com.baidu.tbadk.core.util.bc.f(bkVar.f, com.baidu.tieba.o.cp_bg_line_b);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                bkVar.c.setSelector(this.a.getResources().getDrawable(com.baidu.tieba.q.dot_live_s_1));
                bkVar.c.setDrawable(this.a.getResources().getDrawable(com.baidu.tieba.q.dot_live_n_1));
            } else {
                bkVar.c.setSelector(this.a.getResources().getDrawable(com.baidu.tieba.q.dot_live_s));
                bkVar.c.setDrawable(this.a.getResources().getDrawable(com.baidu.tieba.q.dot_live_n));
            }
        } else {
            BdLog.e("FrsAdapter:getLiveViewPager() position error or instanceof error");
        }
        return view;
    }

    private ArrayList<View> a(com.baidu.tbadk.core.data.h hVar) {
        ArrayList<View> arrayList = new ArrayList<>();
        if (hVar != null && hVar.a() != null) {
            com.baidu.tbadk.editortool.ab abVar = new com.baidu.tbadk.editortool.ab(this.a);
            abVar.d(true);
            Iterator<LiveCardData> it = hVar.a().iterator();
            while (it.hasNext()) {
                LiveBroadcastCard liveBroadcastCard = (LiveBroadcastCard) LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.frs_live_view_pager_item, (ViewGroup) null);
                liveBroadcastCard.a(it.next(), abVar);
                liveBroadcastCard.setStatisticsKey("forum_live_ck");
                liveBroadcastCard.a(TbadkApplication.m252getInst().getSkinType());
                arrayList.add(liveBroadcastCard);
            }
        }
        return arrayList;
    }

    private View a(int i, View view, int i2) {
        bm bmVar;
        View view2;
        View view3;
        bm bmVar2;
        BitmapDrawable bitmapDrawable;
        int color;
        if (view == null) {
            view2 = h();
            bmVar = (bm) view2.getTag();
        } else {
            bmVar = null;
            view2 = view;
        }
        if (bmVar == null) {
            View h = h();
            view3 = h;
            bmVar2 = (bm) h.getTag();
        } else {
            view3 = view2;
            bmVar2 = bmVar;
        }
        ((FrsActivity) this.a).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.a).getLayoutMode().a(view3);
        com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) getItem(i);
        bmVar2.b.setText(oVar.m());
        com.baidu.tieba.util.p C = com.baidu.tieba.ad.c().C();
        if (C != null && C.b(oVar.k())) {
            TextView textView = bmVar2.b;
            if (i2 == 1) {
                color = this.a.getResources().getColor(com.baidu.tieba.o.listview_item_thread_read_1);
            } else {
                color = this.a.getResources().getColor(com.baidu.tieba.o.listview_item_thread_read);
            }
            textView.setTextColor(color);
        }
        if (i2 == 1) {
            if (oVar.p() == 1) {
                bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.q.icon_top_1);
            } else {
                bitmapDrawable = oVar.p() == 2 ? (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.q.icon_notice_1) : null;
            }
            bmVar2.a.setBackgroundResource(com.baidu.tieba.q.frs_top_item_bg_1);
        } else {
            if (oVar.p() == 1) {
                bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.q.icon_top);
            } else {
                bitmapDrawable = oVar.p() == 2 ? (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.q.icon_notice) : null;
            }
            bmVar2.a.setBackgroundResource(com.baidu.tieba.q.frs_top_item_bg);
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        bmVar2.b.setCompoundDrawables(bitmapDrawable, null, null, null);
        return view3;
    }

    private View h() {
        View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.frs_top_item, (ViewGroup) null);
        bm bmVar = new bm(this, null);
        bmVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.r.frs_top_item);
        bmVar.b = (TextView) inflate.findViewById(com.baidu.tieba.r.frs_top_title);
        inflate.setTag(bmVar);
        return inflate;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x042c: INVOKE  (r2v15 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x0428: INVOKE  (r2v14 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tbadk.core.data.o) type: VIRTUAL call: com.baidu.tbadk.core.data.o.j():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View b(int i, View view, int i2) {
        bn bnVar;
        int color;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.frs_item, (ViewGroup) null);
            bn bnVar2 = new bn(this, null);
            bnVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.r.frs_list);
            bnVar2.s = (LinearLayout) view.findViewById(com.baidu.tieba.r.frs_item_user_info_view);
            bnVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.r.frs_list_item_top_linear_layout);
            bnVar2.j = (HeadImageView) view.findViewById(com.baidu.tieba.r.frs_photo);
            bnVar2.i = (UserIconBox) view.findViewById(com.baidu.tieba.r.frs_user_tshow_icon_box);
            bnVar2.h = (TextView) view.findViewById(com.baidu.tieba.r.frs_lv_author);
            bnVar2.f = (TextView) view.findViewById(com.baidu.tieba.r.frs_lv_reply_time);
            bnVar2.g = (TextView) view.findViewById(com.baidu.tieba.r.frs_lv_title);
            bnVar2.c = (TextView) view.findViewById(com.baidu.tieba.r.abstract_text);
            bnVar2.d = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.r.abstract_voice);
            bnVar2.e = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.r.abstract_img_layout);
            bnVar2.k = (LinearLayout) view.findViewById(com.baidu.tieba.r.frs_praise_btn);
            bnVar2.l = (ImageView) view.findViewById(com.baidu.tieba.r.frs_praise_icon);
            bnVar2.m = (TextView) view.findViewById(com.baidu.tieba.r.frs_praise_num);
            bnVar2.n = (LinearLayout) view.findViewById(com.baidu.tieba.r.frs_reply_btn);
            bnVar2.o = (TextView) view.findViewById(com.baidu.tieba.r.frs_reply_num);
            bnVar2.p = (FrsPraiseView) view.findViewById(com.baidu.tieba.r.frs_praise_list_user_icon);
            bnVar2.q = (TextView) view.findViewById(com.baidu.tieba.r.frs_more_abstract);
            bnVar2.r = view.findViewById(com.baidu.tieba.r.frs_item_praise_divider_line);
            bnVar2.t = (LinearLayout) view.findViewById(com.baidu.tieba.r.live_card_layout);
            bnVar2.u = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.r.item_card);
            view.setTag(bnVar2);
            bnVar = bnVar2;
        } else {
            bnVar = (bn) view.getTag();
        }
        if (i2 == 1) {
            bnVar.b.setBackgroundResource(com.baidu.tieba.q.frs_item_control_btn_bg_1);
            bnVar.n.setBackgroundResource(com.baidu.tieba.q.frs_praise_btn_bg_1);
            bnVar.k.setBackgroundResource(com.baidu.tieba.q.frs_praise_btn_bg_1);
            bnVar.q.setBackgroundResource(com.baidu.tieba.q.frs_item_abstract_more_text_bg_1);
        } else {
            bnVar.b.setBackgroundResource(com.baidu.tieba.q.frs_item_control_btn_bg);
            bnVar.n.setBackgroundResource(com.baidu.tieba.q.frs_praise_btn_bg);
            bnVar.k.setBackgroundResource(com.baidu.tieba.q.frs_praise_btn_bg);
            bnVar.q.setBackgroundResource(com.baidu.tieba.q.frs_item_abstract_more_text_bg);
        }
        bnVar.k.setOnClickListener(this);
        com.baidu.adp.lib.util.h.a(this.a, bnVar.k, 0, 10, 0, 20);
        bnVar.n.setOnClickListener(this);
        com.baidu.adp.lib.util.h.a(this.a, bnVar.n, 0, 10, 0, 20);
        bnVar.q.setOnClickListener(this);
        bnVar.k.setOnTouchListener(new bl(this, null));
        bnVar.n.setTag(Integer.valueOf(i));
        bnVar.k.setTag(Integer.valueOf(i));
        bnVar.q.setTag(Integer.valueOf(i));
        ((FrsActivity) this.a).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.a).getLayoutMode().a(view);
        int i3 = i - this.p;
        if (i3 == 0) {
            if (i2 == 1) {
                bnVar.a.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.q.bg_frs_1));
            } else {
                bnVar.a.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.q.bg_frs));
            }
        } else {
            bnVar.a.setBackgroundColor(17170445);
        }
        bnVar.a.setPadding(0, i3 == 0 ? this.l : this.m, 0, 0);
        com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) getItem(i);
        bnVar.f.setText(com.baidu.tbadk.core.util.be.a(oVar.o() * 1000));
        if (com.baidu.tbadk.core.h.a().d()) {
            bnVar.j.setVisibility(0);
            String portrait = oVar.t().getPortrait();
            bnVar.j.setUserId(oVar.t().getUserId());
            bnVar.j.setImageBitmap(null);
            bnVar.j.a(portrait, 12, false);
            bnVar.j.setDefaultResource(com.baidu.tieba.q.photo);
        } else {
            bnVar.j.setVisibility(8);
        }
        bnVar.s.setOnClickListener(new be(this, oVar));
        oVar.t().getIconInfo();
        this.k = oVar.t().getTShowInfo();
        if (this.k != null && this.k.size() > 0) {
            bnVar.i.setVisibility(0);
            if (i2 == 1) {
                bnVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.frs_lv_item_user_name_vip_1));
            } else {
                bnVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.frs_lv_item_user_name_vip));
            }
            bnVar.i.a(this.k, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.small_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.small_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.small_icon_margin));
        } else {
            bnVar.i.setVisibility(8);
            if (i2 == 1) {
                bnVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.frs_lv_item_user_name_1));
            } else {
                bnVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.frs_lv_item_user_name));
            }
        }
        bnVar.h.setText(oVar.t().getUserName());
        bnVar.e.setVisibility(0);
        bnVar.c.setVisibility(0);
        oVar.G();
        bnVar.g.setText(oVar.E());
        com.baidu.tieba.util.p C = com.baidu.tieba.ad.c().C();
        if (C != null && C.b(oVar.k())) {
            TextView textView = bnVar.g;
            if (i2 == 1) {
                color = this.a.getResources().getColor(com.baidu.tieba.o.listview_item_thread_read_1);
            } else {
                color = this.a.getResources().getColor(com.baidu.tieba.o.listview_item_thread_read);
            }
            textView.setTextColor(color);
        }
        if (oVar.C() == 1) {
            bnVar.g.setVisibility(8);
        } else {
            bnVar.g.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (oVar.x() != null && oVar.x().trim().length() > 0) {
            stringBuffer.append(oVar.x());
        }
        ArrayList<com.baidu.tbadk.core.data.k> A = oVar.A();
        if (A != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= A.size()) {
                    break;
                }
                if (A.get(i5).d() != null && A.get(i5).d().endsWith("swf")) {
                    stringBuffer2.append(A.get(i5).d());
                }
                i4 = i5 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                if (stringBuffer.length() > 170) {
                    bnVar.q.setVisibility(0);
                    bnVar.c.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    bnVar.q.setVisibility(8);
                    bnVar.c.setText(stringBuffer.toString());
                }
            } else {
                bnVar.q.setVisibility(8);
                bnVar.c.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.h.a().f()) {
            if (A != null) {
                if (A.size() > 0) {
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        int i9 = i6;
                        if (i9 >= A.size()) {
                            break;
                        }
                        if (A.get(i9) != null && (A.get(i9).b() == 3 || A.get(i9).b() == 5)) {
                            i7++;
                            i8++;
                        }
                        i6 = i9 + 1;
                    }
                    if (i7 > 0) {
                        com.baidu.tbadk.core.data.k[] kVarArr = new com.baidu.tbadk.core.data.k[i7];
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            int i12 = i10;
                            int i13 = i11;
                            if (i12 >= A.size() || i13 >= i7) {
                                break;
                            }
                            if (A.get(i12).b() == 3 || A.get(i12).b() == 5) {
                                kVarArr[i13] = A.get(i12);
                                i11 = i13 + 1;
                            } else {
                                i11 = i13;
                            }
                            i10 = i12 + 1;
                        }
                        bnVar.e.a(oVar, this.c.g().getName(), this.c.g().getId(), oVar.l());
                        bnVar.e.setShowBig(this.i);
                        bnVar.e.setDrawNum(true);
                        bnVar.e.setFromCDN(this.j);
                        bnVar.e.a(kVarArr, i8);
                        bnVar.e.setImageFrom("other");
                    }
                } else {
                    bnVar.e.setVisibility(8);
                }
            }
        } else {
            bnVar.e.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> B = oVar.B();
        if (B != null && B.size() > 0) {
            bnVar.d.setVisibility(0);
            VoiceData.VoiceModel voiceModel = B.get(0);
            bnVar.d.setVoiceModel(voiceModel);
            bnVar.d.setTag(voiceModel);
            bnVar.d.c();
        } else {
            bnVar.d.setVisibility(8);
        }
        if (oVar.j() != null && oVar.j().getNum() > 0) {
            if (com.baidu.tbadk.core.h.a().d()) {
                bnVar.p.setVisibility(0);
                bnVar.p.setIsFromPb(false);
                bnVar.p.a(i2);
                bnVar.r.setVisibility(0);
                bnVar.p.a(oVar.j(), oVar.k(), oVar.i(), false);
            } else {
                bnVar.p.setVisibility(8);
                bnVar.r.setVisibility(8);
            }
            if (oVar.j().getIsLike() == 1) {
                if (i2 == 1) {
                    bnVar.l.setImageResource(com.baidu.tieba.q.icon_hand_click_1);
                } else {
                    bnVar.l.setImageResource(com.baidu.tieba.q.icon_hand_click);
                }
            } else if (i2 == 1) {
                bnVar.l.setImageResource(com.baidu.tieba.q.icon_hand_normal_1);
            } else {
                bnVar.l.setImageResource(com.baidu.tieba.q.icon_hand_normal);
            }
            if (oVar.j().getNum() <= 999999) {
                bnVar.m.setText(new StringBuilder().append(oVar.j().getNum()).toString());
            } else {
                bnVar.m.setText("999999+");
            }
        } else {
            bnVar.r.setVisibility(8);
            bnVar.p.setVisibility(8);
            bnVar.m.setText(this.a.getResources().getString(com.baidu.tieba.u.frs_item_praise_text));
            if (i2 == 1) {
                bnVar.l.setImageResource(com.baidu.tieba.q.icon_hand_normal_1);
            } else {
                bnVar.l.setImageResource(com.baidu.tieba.q.icon_hand_normal);
            }
        }
        int n = oVar.n();
        if (n <= 999999) {
            if (n > 0) {
                bnVar.o.setText(String.valueOf(n));
            } else {
                bnVar.o.setText(this.a.getResources().getString(com.baidu.tieba.u.frs_item_reply_text));
            }
        } else {
            bnVar.o.setText("999999+");
        }
        if (oVar.H().getGroup_id() != 0) {
            bnVar.e.setVisibility(8);
            bnVar.t.setVisibility(0);
            LiveCardData liveCardData = new LiveCardData();
            liveCardData.setPublisherId(oVar.H().getAuthorId());
            liveCardData.setPublisherName(oVar.H().getAuthorName());
            liveCardData.setPublisherPortrait(oVar.H().getPublisherPortrait());
            liveCardData.setGroupId(oVar.H().getGroup_id());
            liveCardData.setIntro(oVar.H().getIntro());
            liveCardData.setLikers(oVar.H().getLikers());
            liveCardData.setListeners(oVar.H().getListeners());
            liveCardData.setName(oVar.H().getName());
            liveCardData.setPortrait(oVar.H().getPortrait());
            liveCardData.setStatus(oVar.H().getStatus());
            liveCardData.setStartTime(oVar.H().getStartTime());
            bnVar.u.a(liveCardData, this.h);
            bnVar.u.setStatisticsKey("notice_frs_live");
        } else {
            bnVar.t.setVisibility(8);
        }
        return view;
    }

    private View c(int i, View view, int i2) {
        if (view == null) {
            view = i();
        }
        bh bhVar = (bh) view.getTag();
        bhVar.a.setPadding(0, i - this.p == 0 ? this.l : this.m, 0, 0);
        view.setTag(bhVar);
        ((FrsActivity) this.a).getLayoutMode().a(i2 == 1);
        ((FrsActivity) this.a).getLayoutMode().a(view);
        com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) getItem(i);
        if (oVar instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) oVar;
            bhVar.d.setText(bVar.c());
            bhVar.e.setText(bVar.d());
            if (com.baidu.tbadk.core.h.a().f()) {
                bhVar.c.setVisibility(0);
                if (this.i) {
                    bhVar.c.setSuffix("_small");
                } else {
                    bhVar.c.setSuffix("_mobile");
                }
                bhVar.c.a(bVar.b(), this.j ? 13 : 14, false);
            } else {
                bhVar.c.setVisibility(8);
            }
            bhVar.c.setTag(bVar.b());
            bhVar.f.setTag(Integer.valueOf(i));
            if (i2 == 1) {
                com.baidu.tbadk.core.util.bc.e((View) bhVar.b, com.baidu.tieba.q.bg_label_1);
            } else {
                com.baidu.tbadk.core.util.bc.e((View) bhVar.b, com.baidu.tieba.q.bg_label);
            }
            switch (bVar.g()) {
                case 0:
                    a(i2, bhVar);
                    bhVar.f.setText(com.baidu.tieba.u.download);
                    bhVar.f.setOnClickListener(this.u);
                    break;
                case 1:
                    b(i2, bhVar);
                    bhVar.f.setText(com.baidu.tieba.u.downloading2);
                    bhVar.f.setOnClickListener(null);
                    break;
                case 2:
                    b(i2, bhVar);
                    bhVar.f.setText(com.baidu.tieba.u.downloaded);
                    bhVar.f.setOnClickListener(this.u);
                    break;
            }
        }
        return view;
    }

    private void a(int i, bh bhVar) {
        if (i == 1) {
            bhVar.f.setBackgroundResource(com.baidu.tieba.q.faceshop_list_btn_selector_1);
            bhVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.cp_cont_f_1));
            return;
        }
        bhVar.f.setBackgroundResource(com.baidu.tieba.q.faceshop_list_btn_selector);
        bhVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.cp_cont_f));
    }

    private void b(int i, bh bhVar) {
        if (i == 1) {
            bhVar.f.setBackgroundResource(com.baidu.tieba.q.btn_content_download_d_1);
            bhVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.faceshop_downloaded_text_1));
            return;
        }
        bhVar.f.setBackgroundResource(com.baidu.tieba.q.btn_content_download_d);
        bhVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.faceshop_downloaded_text));
    }

    private View i() {
        View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.frs_item_app, (ViewGroup) null);
        bh bhVar = new bh(this, null);
        bhVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.r.app_parent);
        bhVar.d = (TextView) inflate.findViewById(com.baidu.tieba.r.app_name);
        bhVar.e = (TextView) inflate.findViewById(com.baidu.tieba.r.app_desc);
        bhVar.c = (HeadImageView) inflate.findViewById(com.baidu.tieba.r.app_icon);
        bhVar.f = (TextView) inflate.findViewById(com.baidu.tieba.r.app_download);
        bhVar.b = (TextView) inflate.findViewById(com.baidu.tieba.r.recommend_app);
        inflate.setTag(bhVar);
        return inflate;
    }

    private View a(View view, int i) {
        bi biVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.frs_item_control, (ViewGroup) null);
            bi biVar2 = new bi(this, null);
            biVar2.a = (FrameLayout) view.findViewById(com.baidu.tieba.r.frs_list_control);
            biVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.r.frs_list_control_in);
            biVar2.d = (ProgressBar) view.findViewById(com.baidu.tieba.r.frs_list_control_progress);
            biVar2.c = (TextView) view.findViewById(com.baidu.tieba.r.frs_list_control_tv);
            view.setTag(biVar2);
            biVar = biVar2;
        } else {
            biVar = (bi) view.getTag();
        }
        if (this.d) {
            biVar.a.setVisibility(0);
            biVar.a.setPadding(0, this.l, 0, 0);
            if (this.g) {
                biVar.c.setText(com.baidu.tieba.u.loading);
                biVar.d.setVisibility(0);
            } else {
                biVar.c.setText(com.baidu.tieba.u.frs_pre);
                biVar.d.setVisibility(8);
            }
            if (i == 1) {
                biVar.b.setBackgroundResource(com.baidu.tieba.q.frs_item_control_bg_1);
            } else {
                biVar.b.setBackgroundResource(com.baidu.tieba.q.frs_item_control_bg);
            }
            com.baidu.tbadk.core.util.bc.b(biVar.c, i);
        } else {
            biVar.a.setVisibility(8);
        }
        return view;
    }

    private View b(View view, int i) {
        bi biVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.frs_item_control, (ViewGroup) null);
            bi biVar2 = new bi(this, null);
            biVar2.a = (FrameLayout) view.findViewById(com.baidu.tieba.r.frs_list_control);
            biVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.r.frs_list_control_in);
            biVar2.d = (ProgressBar) view.findViewById(com.baidu.tieba.r.frs_list_control_progress);
            biVar2.c = (TextView) view.findViewById(com.baidu.tieba.r.frs_list_control_tv);
            view.setTag(biVar2);
            biVar = biVar2;
        } else {
            biVar = (bi) view.getTag();
        }
        if (this.e) {
            biVar.a.setVisibility(0);
            biVar.a.setPadding(0, this.l, 0, this.l);
            if (this.f) {
                biVar.c.setText(com.baidu.tieba.u.loading);
                biVar.d.setVisibility(0);
            } else {
                biVar.c.setText(com.baidu.tieba.u.frs_next);
                biVar.d.setVisibility(8);
            }
            if (i == 1) {
                biVar.b.setBackgroundResource(com.baidu.tieba.q.frs_item_control_bg_1);
            } else {
                biVar.b.setBackgroundResource(com.baidu.tieba.q.frs_item_control_bg);
            }
            com.baidu.tbadk.core.util.bc.b(biVar.c, i);
        } else {
            biVar.a.setVisibility(8);
        }
        return view;
    }

    public void d() {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size && this.b.get(i).p() != 0; i++) {
                this.b.get(i).G();
            }
        }
    }

    public void f(boolean z) {
        this.j = z;
    }

    public void a(bj bjVar) {
        this.v = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.v != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) getItem(intValue);
            View childAt = this.t.getChildAt(intValue - (this.t.getFirstVisiblePosition() - this.t.getHeaderViewsCount()));
            if (view.getId() == e()) {
                if (this.o) {
                    this.v.a(id, intValue, view, childAt, oVar);
                }
            } else if (view.getId() == com.baidu.tieba.r.live_show_all) {
                com.baidu.tbadk.core.g.a(this.a, "all_live_read");
                if (this.c != null && this.c.g() != null && !TextUtils.isEmpty(this.c.g().getId()) && this.c.i() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.o(this.a, this.c.g().getId(), this.c.i().getIsManager())));
                } else {
                    BdLog.e("find nullPoint");
                }
            } else {
                this.v.a(id, intValue, view, childAt, oVar);
            }
        }
    }

    public int e() {
        return com.baidu.tieba.r.frs_praise_btn;
    }

    public int f() {
        return com.baidu.tieba.r.frs_reply_btn;
    }

    public int g() {
        return com.baidu.tieba.r.frs_more_abstract;
    }

    public void a(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.a, com.baidu.tieba.l.praise_animation_scale2));
            new Handler().postDelayed(new bf(this), 200L);
        }
    }

    public void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.a, com.baidu.tieba.l.praise_animation_scale3));
            new Handler().postDelayed(new bg(this), 600L);
        }
    }

    public void a(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.a, com.baidu.tieba.l.praise_animation_scale1));
    }
}
