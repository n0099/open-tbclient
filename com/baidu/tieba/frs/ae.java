package com.baidu.tieba.frs;

import android.content.Context;
import android.text.TextUtils;
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
import com.baidu.tieba.view.DottedLine;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ae extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1115a;
    private ArrayList<com.baidu.tieba.data.bh> b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private com.baidu.tieba.util.a i;
    private int j;
    private boolean l;
    private int n;
    private int k = 200;
    private float m = 0.4f;
    private ArrayList<ProgressBar> h = new ArrayList<>();
    private boolean g = false;

    private LinearLayout a(com.baidu.tieba.data.ai aiVar, int i, int i2) {
        int i3;
        int i4;
        if (aiVar.c() != null && (aiVar.c().length() < 1 || aiVar.c().endsWith("swf"))) {
            return null;
        }
        com.baidu.tieba.view.aa aaVar = new com.baidu.tieba.view.aa(this.f1115a, aiVar.a());
        LinearLayout linearLayout = new LinearLayout(this.f1115a);
        aaVar.setPicNum(i);
        int a2 = this.j - UtilHelper.a(this.f1115a, 14);
        int i5 = 100;
        if (i == 1) {
            if (this.l) {
                i5 = (int) (a2 * 0.5d);
                i3 = 0;
                i4 = 0;
            } else {
                int i6 = (int) (a2 * this.m);
                i5 = (int) (i6 * 0.5d);
                i4 = UtilHelper.a(this.f1115a, 7);
                i3 = UtilHelper.a(this.f1115a, 7);
                a2 = (i6 - i4) - i3;
            }
        } else if (i == 2) {
            a2 /= 2;
            i5 = (a2 * 2) / 3;
            if (i2 == 0) {
                int a3 = UtilHelper.a(this.f1115a, 7);
                a2 -= a3;
                i4 = a3;
                i3 = 0;
            } else {
                if (i2 == 1) {
                    i4 = UtilHelper.a(this.f1115a, 7);
                    i3 = UtilHelper.a(this.f1115a, 7);
                    a2 = (a2 - i4) - i3;
                }
                i3 = 0;
                i4 = 0;
            }
        } else if (i != 3) {
            a2 = 100;
            i3 = 0;
            i4 = 0;
        } else {
            a2 /= 3;
            i5 = (a2 * 3) / 4;
            if (i2 == 0) {
                int a4 = UtilHelper.a(this.f1115a, 7);
                a2 -= a4;
                i4 = a4;
                i3 = 0;
            } else if (i2 == 1) {
                int a5 = UtilHelper.a(this.f1115a, 7);
                a2 -= a5;
                i4 = a5;
                i3 = 0;
            } else {
                if (i2 == 2) {
                    i4 = UtilHelper.a(this.f1115a, 7);
                    i3 = UtilHelper.a(this.f1115a, 7);
                    a2 = (a2 - i4) - i3;
                }
                i3 = 0;
                i4 = 0;
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, i5);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a2, -2);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i3;
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        aaVar.setTag(aiVar.b());
        aaVar.setClickable(true);
        aaVar.setFocusable(false);
        aaVar.setLayoutParams(layoutParams);
        aaVar.setIsWifi(this.l);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(aaVar);
        if (aiVar.a() == 5) {
            aaVar.setOnClickListener(new af(this, aiVar));
        } else if (aiVar.a() == 3) {
            aaVar.setClickable(false);
        }
        return linearLayout;
    }

    private PlayVoiceBnt a(com.baidu.tieba.voice.ai aiVar) {
        PlayVoiceBnt b = b(aiVar);
        b.setVoiceModel(aiVar);
        b.setTag(aiVar);
        b.b();
        return b;
    }

    private PlayVoiceBnt b(com.baidu.tieba.voice.ai aiVar) {
        PlayVoiceBnt playVoiceBnt = new PlayVoiceBnt(this.f1115a, PlayVoiceBnt.PLAY_TYPE.NORMAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = UtilHelper.a(this.f1115a, 6.0f);
        playVoiceBnt.setLayoutParams(layoutParams);
        return playVoiceBnt;
    }

    public void a(View.OnClickListener onClickListener) {
    }

    public void a(boolean z) {
        this.g = z;
    }

    private int b(ArrayList<com.baidu.tieba.data.bh> arrayList) {
        int i = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.tieba.data.bh> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext() && it.next().e() == 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public ae(Context context, ArrayList<com.baidu.tieba.data.bh> arrayList, int i, boolean z) {
        this.j = 200;
        this.l = false;
        this.f1115a = context;
        this.b = arrayList;
        this.i = new com.baidu.tieba.util.a(this.f1115a);
        this.j = i;
        this.l = z;
        b(z);
        this.n = b(this.b);
    }

    public void b(boolean z) {
        if (this.l != z) {
            this.l = z;
            if (this.l) {
                UtilHelper.a(this.f1115a, this.f1115a.getResources().getString(R.string.close_flow_mode));
            } else {
                UtilHelper.a(this.f1115a, this.f1115a.getResources().getString(R.string.open_flow_mode));
            }
        }
        this.k = this.j;
        if (this.l) {
            if (this.k > 480) {
                this.k = 480;
            }
            if (this.k > UtilHelper.a(this.f1115a, 320.0f)) {
                this.k = UtilHelper.a(this.f1115a, 320.0f);
            }
            this.i.b("_small");
        } else {
            if (this.k > this.m * 480.0f) {
                this.k = (int) (this.m * 480.0f);
            }
            if (this.k > UtilHelper.a(this.f1115a, 320.0f) * this.m) {
                this.k = (int) (UtilHelper.a(this.f1115a, 320.0f) * this.m);
            }
            this.i.b("_mobile");
        }
        this.i.a(this.k, this.k);
    }

    public com.baidu.tieba.util.a a() {
        return this.i;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.e;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(boolean z) {
        this.d = z;
    }

    public void a(ArrayList<com.baidu.tieba.data.bh> arrayList) {
        this.b = arrayList;
        this.n = b(this.b);
    }

    public void d() {
        if (this.h != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.h.size()) {
                    try {
                        this.h.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.util.av.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.h.clear();
                    return;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size();
            if (this.c) {
                size++;
            }
            if (this.d) {
                return size + 1;
            }
            return size;
        }
        return 0;
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

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ag agVar;
        View view3;
        String str;
        int i2;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.f1115a).inflate(R.layout.frs_item, (ViewGroup) null);
                try {
                    ag agVar2 = new ag(this, null);
                    agVar2.f1117a = (FrameLayout) view3.findViewById(R.id.frs_list);
                    agVar2.l = (LinearLayout) view3.findViewById(R.id.frs_list_item);
                    agVar2.c = (LinearLayout) view3.findViewById(R.id.frs_list_item_top);
                    agVar2.d = (RelativeLayout) view3.findViewById(R.id.item_bottom_layout);
                    agVar2.m = (TextView) view3.findViewById(R.id.frs_lv_reply_num);
                    agVar2.q = (ImageView) view3.findViewById(R.id.frs_discuss_icon);
                    agVar2.r = (ImageView) view3.findViewById(R.id.author_icon);
                    agVar2.n = (TextView) view3.findViewById(R.id.frs_lv_reply_time);
                    agVar2.o = (TextView) view3.findViewById(R.id.frs_lv_title);
                    agVar2.p = (TextView) view3.findViewById(R.id.frs_lv_author);
                    agVar2.b = (LinearLayout) view3.findViewById(R.id.frs_lv_abstract);
                    agVar2.e = (TextView) view3.findViewById(R.id.abstract_text);
                    agVar2.g = (LinearLayout) view3.findViewById(R.id.abstract_img_layout);
                    agVar2.f = (LinearLayout) view3.findViewById(R.id.abstract_voice_layout);
                    agVar2.h = (FrameLayout) view3.findViewById(R.id.frs_list_control);
                    agVar2.i = (LinearLayout) view3.findViewById(R.id.frs_list_control_in);
                    agVar2.j = (TextView) view3.findViewById(R.id.frs_list_control_tv);
                    agVar2.k = (ProgressBar) view3.findViewById(R.id.frs_list_control_progress);
                    agVar2.s = (ViewGroup) view3.findViewById(R.id.frs_list_divider_wrapper);
                    agVar2.t = (DottedLine) view3.findViewById(R.id.frs_list_divider);
                    view3.setTag(agVar2);
                    this.h.add(agVar2.k);
                    agVar = agVar2;
                } catch (Exception e) {
                    e = e;
                    view2 = view3;
                    com.baidu.tieba.util.av.b(getClass().getName(), "", "FrsAdapter.getView error = " + e.getMessage());
                    if (view2 == null) {
                        TextView textView = new TextView(this.f1115a);
                        textView.setVisibility(8);
                        textView.setHeight(0);
                        return textView;
                    }
                    return view2;
                }
            } else {
                agVar = (ag) view.getTag();
                view3 = view;
            }
            int ap = TiebaApplication.g().ap();
            long itemId = getItemId(i);
            agVar.f1117a.setPadding(agVar.f1117a.getPaddingLeft(), UtilHelper.a(this.f1115a, 6.0f), agVar.f1117a.getPaddingRight(), UtilHelper.a(this.f1115a, 0.0f));
            agVar.s.setVisibility(8);
            if (itemId == -1) {
                agVar.l.setVisibility(8);
                agVar.h.setVisibility(0);
                agVar.h.setPadding(0, 0, 0, 0);
                if (this.f) {
                    agVar.j.setText(R.string.loading);
                    agVar.k.setVisibility(0);
                } else {
                    agVar.j.setText(R.string.frs_pre);
                    agVar.k.setVisibility(8);
                }
                if (ap == 1) {
                    agVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    agVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
                com.baidu.tieba.util.as.b(agVar.j, ap);
                return view3;
            } else if (itemId == -2) {
                agVar.l.setVisibility(8);
                agVar.h.setVisibility(0);
                agVar.h.setPadding(0, 0, 0, UtilHelper.a(this.f1115a, 10.0f));
                if (this.e) {
                    agVar.j.setText(R.string.loading);
                    agVar.k.setVisibility(0);
                } else {
                    agVar.j.setText(R.string.frs_next);
                    agVar.k.setVisibility(8);
                }
                if (ap == 1) {
                    agVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    agVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
                com.baidu.tieba.util.as.b(agVar.j, ap);
                return view3;
            } else {
                agVar.l.setVisibility(0);
                agVar.h.setVisibility(8);
                agVar.k.setVisibility(8);
                agVar.g.removeAllViews();
                ((FrsActivity) this.f1115a).l().a(ap == 1);
                ((FrsActivity) this.f1115a).l().a(view3);
                com.baidu.tieba.data.bh bhVar = (com.baidu.tieba.data.bh) getItem(i);
                int c = bhVar.c();
                agVar.q.setVisibility(0);
                if (c <= 999999) {
                    if (c > 0) {
                        agVar.m.setText(String.valueOf(c));
                    } else {
                        agVar.m.setText((CharSequence) null);
                        agVar.q.setVisibility(4);
                    }
                } else {
                    agVar.m.setText("999999+");
                }
                Date date = new Date();
                date.setTime(bhVar.d() * 1000);
                agVar.n.setText(com.baidu.tieba.util.at.i(date));
                agVar.o.setText(bhVar.q());
                agVar.o.setTextSize(2, 16.0f);
                agVar.o.setMaxLines(10);
                com.baidu.tieba.util.ak aw = TiebaApplication.g().aw();
                if (aw != null && aw.b(bhVar.a())) {
                    agVar.o.setTextColor(this.f1115a.getResources().getColor(R.color.read_thread_color));
                }
                agVar.p.setText(bhVar.g().getName());
                agVar.f.removeAllViews();
                if (this.g && bhVar.e() != 1) {
                    agVar.d.setVisibility(0);
                    agVar.b.setVisibility(0);
                    agVar.g.setVisibility(0);
                    agVar.f.setVisibility(0);
                    agVar.e.setVisibility(0);
                    ArrayList<com.baidu.tieba.data.ai> o = bhVar.o();
                    ArrayList<com.baidu.tieba.voice.ai> p = bhVar.p();
                    if (bhVar.j() == null) {
                        str = "";
                    } else {
                        str = String.valueOf("") + bhVar.j();
                    }
                    if (o != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i3 = 0; i3 < o.size(); i3++) {
                            if (o.get(i3).c() != null && o.get(i3).c().endsWith("swf")) {
                                stringBuffer.append(o.get(i3).c());
                            }
                        }
                        String str2 = String.valueOf(str) + stringBuffer.toString();
                        if (str2 != null && str2.length() > 1) {
                            agVar.e.setText(str2);
                        } else {
                            agVar.e.setVisibility(8);
                        }
                    }
                    if (p != null && p.size() > 0) {
                        agVar.f.addView(a(p.get(0)));
                    } else {
                        agVar.f.setVisibility(8);
                    }
                    if (o != null) {
                        if (o.size() > 0) {
                            int i4 = 0;
                            int i5 = 0;
                            while (i5 < o.size()) {
                                int i6 = (o.get(i5) == null || !(o.get(i5).a() == 3 || o.get(i5).a() == 5)) ? i4 : i4 + 1;
                                i5++;
                                i4 = i6;
                            }
                            if (i4 > 3) {
                                i4 = 3;
                            }
                            int i7 = 0;
                            int i8 = 0;
                            while (i8 < o.size() && i7 < i4) {
                                if (o.get(i8).a() == 3 || o.get(i8).a() == 5) {
                                    LinearLayout a2 = a(o.get(i8), i4, i7);
                                    if (a2 != null) {
                                        agVar.g.addView(a2);
                                        i2 = i7 + 1;
                                    } else {
                                        i2 = i7;
                                    }
                                } else {
                                    i2 = i7;
                                }
                                i8++;
                                i7 = i2;
                            }
                        } else {
                            agVar.g.setVisibility(8);
                        }
                    }
                } else {
                    agVar.b.setVisibility(8);
                }
                if (bhVar.e() == 1) {
                    agVar.d.setVisibility(8);
                    a(agVar.f1117a, agVar.c, agVar.t, agVar.o, i);
                    return view3;
                }
                agVar.d.setVisibility(0);
                return view3;
            }
        } catch (Exception e2) {
            e = e2;
            view2 = view;
        }
    }

    private void a(View view, View view2, DottedLine dottedLine, TextView textView, int i) {
        int a2;
        int a3;
        if (i == 0) {
            a2 = UtilHelper.a(this.f1115a, 6.0f);
        } else {
            a2 = UtilHelper.a(this.f1115a, 0.0f);
        }
        if (i == this.n - 1) {
            a3 = UtilHelper.a(this.f1115a, 2.0f);
        } else {
            a3 = UtilHelper.a(this.f1115a, 0.0f);
        }
        view.setPadding(view.getPaddingLeft(), a2, view.getPaddingRight(), a3);
        textView.setTextSize(2, 15.0f);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        int ap = TiebaApplication.g().ap();
        ViewGroup viewGroup = (ViewGroup) dottedLine.getParent();
        if (ap == 1) {
            dottedLine.setNight(true);
            viewGroup.setBackgroundResource(R.drawable.bg_frs_list_between_sepline_1);
            if (this.n == 1) {
                view2.setBackgroundResource(R.drawable.bg_list_all_1);
                return;
            } else if (this.n >= 2) {
                if (i == 0) {
                    view2.setBackgroundResource(R.drawable.bg_frs_list_top_1);
                    viewGroup.setVisibility(0);
                    return;
                } else if (i == this.n - 1) {
                    view2.setBackgroundResource(R.drawable.bg_frs_list_foot_1);
                    return;
                } else {
                    view2.setBackgroundResource(R.drawable.bg_frs_list_between_1);
                    viewGroup.setVisibility(0);
                    return;
                }
            } else {
                return;
            }
        }
        dottedLine.setNight(false);
        viewGroup.setBackgroundResource(R.drawable.bg_frs_list_between_sepline);
        if (this.n == 1) {
            view2.setBackgroundResource(R.drawable.bg_list_all);
        } else if (this.n >= 2) {
            if (i == 0) {
                view2.setBackgroundResource(R.drawable.bg_frs_list_top);
                viewGroup.setVisibility(0);
            } else if (i == this.n - 1) {
                view2.setBackgroundResource(R.drawable.bg_frs_list_foot);
            } else {
                view2.setBackgroundResource(R.drawable.bg_frs_list_between);
                viewGroup.setVisibility(0);
            }
        }
    }
}
