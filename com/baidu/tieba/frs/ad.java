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
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.DottedLine;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1248a;
    private ArrayList<com.baidu.tieba.data.bf> b;
    private com.baidu.tieba.model.ak c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private com.baidu.tieba.util.a j;
    private int k;
    private boolean m;
    private int o;
    private int l = 200;
    private float n = 0.4f;
    private ArrayList<ProgressBar> i = new ArrayList<>();
    private boolean h = false;

    private LinearLayout a(com.baidu.tieba.data.ai aiVar, int i, int i2) {
        int i3;
        int i4;
        if (aiVar.c() != null && (aiVar.c().length() < 1 || aiVar.c().endsWith("swf"))) {
            return null;
        }
        com.baidu.tieba.view.aa aaVar = new com.baidu.tieba.view.aa(this.f1248a, aiVar.a());
        LinearLayout linearLayout = new LinearLayout(this.f1248a);
        aaVar.setPicNum(i);
        int a2 = this.k - UtilHelper.a(this.f1248a, 14);
        int i5 = 100;
        if (i == 1) {
            if (this.m) {
                i5 = (int) (a2 * 0.5d);
                i3 = 0;
                i4 = 0;
            } else {
                int i6 = (int) (a2 * this.n);
                i5 = (int) (i6 * 0.5d);
                i4 = UtilHelper.a(this.f1248a, 7);
                i3 = UtilHelper.a(this.f1248a, 7);
                a2 = (i6 - i4) - i3;
            }
        } else if (i == 2) {
            a2 /= 2;
            i5 = (a2 * 2) / 3;
            if (i2 == 0) {
                int a3 = UtilHelper.a(this.f1248a, 7);
                a2 -= a3;
                i4 = a3;
                i3 = 0;
            } else {
                if (i2 == 1) {
                    i4 = UtilHelper.a(this.f1248a, 7);
                    i3 = UtilHelper.a(this.f1248a, 7);
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
                int a4 = UtilHelper.a(this.f1248a, 7);
                a2 -= a4;
                i4 = a4;
                i3 = 0;
            } else if (i2 == 1) {
                int a5 = UtilHelper.a(this.f1248a, 7);
                a2 -= a5;
                i4 = a5;
                i3 = 0;
            } else {
                if (i2 == 2) {
                    i4 = UtilHelper.a(this.f1248a, 7);
                    i3 = UtilHelper.a(this.f1248a, 7);
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
        aaVar.setIsWifi(this.m);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(aaVar);
        if (aiVar.a() == 5) {
            aaVar.setOnClickListener(new ae(this, aiVar));
        } else if (aiVar.a() == 3) {
            aaVar.setClickable(false);
        }
        return linearLayout;
    }

    public void a(View.OnClickListener onClickListener) {
    }

    public void a(boolean z) {
        this.h = z;
    }

    private int a(ArrayList<com.baidu.tieba.data.bf> arrayList) {
        int i = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.tieba.data.bf> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext() && it.next().e() == 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public ad(Context context, ArrayList<com.baidu.tieba.data.bf> arrayList, int i, boolean z) {
        this.k = 200;
        this.m = false;
        this.f1248a = context;
        this.b = arrayList;
        this.j = new com.baidu.tieba.util.a(this.f1248a);
        this.k = i;
        this.m = z;
        b(z);
        this.o = a(this.b);
    }

    public void b(boolean z) {
        if (this.m != z) {
            this.m = z;
            if (this.m) {
                UtilHelper.a(this.f1248a, this.f1248a.getResources().getString(R.string.close_flow_mode));
            } else {
                UtilHelper.a(this.f1248a, this.f1248a.getResources().getString(R.string.open_flow_mode));
            }
        }
        this.l = this.k;
        if (this.m) {
            if (this.l > 480) {
                this.l = 480;
            }
            if (this.l > UtilHelper.a(this.f1248a, 320.0f)) {
                this.l = UtilHelper.a(this.f1248a, 320.0f);
            }
            this.j.b("_small");
        } else {
            if (this.l > this.n * 480.0f) {
                this.l = (int) (this.n * 480.0f);
            }
            if (this.l > UtilHelper.a(this.f1248a, 320.0f) * this.n) {
                this.l = (int) (UtilHelper.a(this.f1248a, 320.0f) * this.n);
            }
            this.j.b("_mobile");
        }
        this.j.a(this.l, this.l);
    }

    public com.baidu.tieba.util.a a() {
        return this.j;
    }

    public void c(boolean z) {
        this.f = z;
    }

    public boolean b() {
        return this.f;
    }

    public void d(boolean z) {
        this.g = z;
    }

    public boolean c() {
        return this.g;
    }

    public void e(boolean z) {
        this.d = z;
    }

    public void f(boolean z) {
        this.e = z;
    }

    public void a(ArrayList<com.baidu.tieba.data.bf> arrayList, com.baidu.tieba.model.ak akVar) {
        this.b = arrayList;
        this.c = akVar;
        this.o = a(this.b);
    }

    public void d() {
        if (this.i != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.i.size()) {
                    try {
                        this.i.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.util.be.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.i.clear();
                    return;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null || this.b == null) {
            return 0;
        }
        if (this.c.c() != null && this.c.c().getIfpost() == 0 && this.b.isEmpty()) {
            return 0;
        }
        if (this.b != null) {
            int size = this.b.size() + 1;
            if (this.d) {
                size++;
            }
            if (this.e) {
                return size + 1;
            }
            return size;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (getItemViewType(i) == 1) {
            return a(i - 1);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItemViewType(i) == 1) {
            return b(i - 1);
        }
        return -100L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 1 ? b(i - 1, view, viewGroup) : a(i, view, viewGroup);
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        View view2;
        af afVar;
        try {
            if (view == null) {
                view2 = LayoutInflater.from(this.f1248a).inflate(R.layout.frs_chat_group_item, (ViewGroup) null);
                try {
                    af afVar2 = new af(this, null);
                    afVar2.f1250a = (FrameLayout) view2.findViewById(R.id.frs_list_chat_group);
                    afVar2.m = (TextView) view2.findViewById(R.id.frs_chat_group_text_num);
                    afVar2.n = (TextView) view2.findViewById(R.id.frs_chat_group_text2);
                    view2.setTag(afVar2);
                    afVar = afVar2;
                } catch (Exception e) {
                    e = e;
                    com.baidu.tieba.util.be.b(getClass().getName(), "", "FrsAdapter.getView error = " + e.getMessage());
                    if (view2 == null) {
                        TextView textView = new TextView(this.f1248a);
                        textView.setVisibility(8);
                        textView.setHeight(0);
                        return textView;
                    }
                    return view2;
                }
            } else {
                afVar = (af) view.getTag();
                view2 = view;
            }
            int as = TiebaApplication.g().as();
            if (this.c == null || this.c.i() == null || this.c.i().a() == 0) {
                afVar.m.setText(SocialConstants.FALSE);
                afVar.m.setVisibility(8);
                afVar.n.setVisibility(8);
            } else {
                afVar.m.setText(String.valueOf(this.c.i().a()));
                afVar.m.setVisibility(0);
                afVar.n.setVisibility(0);
            }
            afVar.f1250a.setPadding(afVar.f1250a.getPaddingLeft(), UtilHelper.a(this.f1248a, 6.0f), afVar.f1250a.getPaddingRight(), UtilHelper.a(this.f1248a, 0.0f));
            ((FrsActivity) this.f1248a).m().a(as == 1);
            ((FrsActivity) this.f1248a).m().a(view2);
            return view2;
        } catch (Exception e2) {
            e = e2;
            view2 = view;
        }
    }

    public Object a(int i) {
        int b = (int) b(i);
        if (b < 0 || b >= this.b.size()) {
            return null;
        }
        return this.b.get(b);
    }

    public long b(int i) {
        int i2 = this.d ? i - 1 : i;
        if (this.e && i == getCount() - 2) {
            i2 = -2;
        }
        return i2;
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        View view2;
        af afVar;
        View view3;
        int i2;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.f1248a).inflate(R.layout.frs_item, (ViewGroup) null);
                try {
                    af afVar2 = new af(this, null);
                    afVar2.f1250a = (FrameLayout) view3.findViewById(R.id.frs_list);
                    afVar2.l = (LinearLayout) view3.findViewById(R.id.frs_list_item);
                    afVar2.c = (LinearLayout) view3.findViewById(R.id.frs_list_item_top);
                    afVar2.d = (RelativeLayout) view3.findViewById(R.id.item_bottom_layout);
                    afVar2.m = (TextView) view3.findViewById(R.id.frs_lv_reply_num);
                    afVar2.q = (ImageView) view3.findViewById(R.id.frs_discuss_icon);
                    afVar2.r = (ImageView) view3.findViewById(R.id.author_icon);
                    afVar2.n = (TextView) view3.findViewById(R.id.frs_lv_reply_time);
                    afVar2.o = (TextView) view3.findViewById(R.id.frs_lv_title);
                    afVar2.p = (TextView) view3.findViewById(R.id.frs_lv_author);
                    afVar2.b = (LinearLayout) view3.findViewById(R.id.frs_lv_abstract);
                    afVar2.e = (TextView) view3.findViewById(R.id.abstract_text);
                    afVar2.g = (LinearLayout) view3.findViewById(R.id.abstract_img_layout);
                    afVar2.f = (PlayVoiceBnt) view3.findViewById(R.id.abstract_voice);
                    afVar2.h = (FrameLayout) view3.findViewById(R.id.frs_list_control);
                    afVar2.i = (LinearLayout) view3.findViewById(R.id.frs_list_control_in);
                    afVar2.j = (TextView) view3.findViewById(R.id.frs_list_control_tv);
                    afVar2.k = (ProgressBar) view3.findViewById(R.id.frs_list_control_progress);
                    afVar2.s = (ViewGroup) view3.findViewById(R.id.frs_list_divider_wrapper);
                    afVar2.t = (DottedLine) view3.findViewById(R.id.frs_list_divider);
                    view3.setTag(afVar2);
                    this.i.add(afVar2.k);
                    afVar = afVar2;
                } catch (Exception e) {
                    e = e;
                    view2 = view3;
                    com.baidu.tieba.util.be.b(getClass().getName(), "", "FrsAdapter.getView error = " + e.getMessage());
                    if (view2 == null) {
                        TextView textView = new TextView(this.f1248a);
                        textView.setVisibility(8);
                        textView.setHeight(0);
                        return textView;
                    }
                    return view2;
                }
            } else {
                afVar = (af) view.getTag();
                view3 = view;
            }
            int as = TiebaApplication.g().as();
            long b = b(i);
            afVar.f1250a.setPadding(afVar.f1250a.getPaddingLeft(), UtilHelper.a(this.f1248a, 6.0f), afVar.f1250a.getPaddingRight(), UtilHelper.a(this.f1248a, 0.0f));
            afVar.s.setVisibility(8);
            if (b == -1) {
                afVar.l.setVisibility(8);
                afVar.h.setVisibility(0);
                afVar.h.setPadding(0, 0, 0, 0);
                if (this.g) {
                    afVar.j.setText(R.string.loading);
                    afVar.k.setVisibility(0);
                } else {
                    afVar.j.setText(R.string.frs_pre);
                    afVar.k.setVisibility(8);
                }
                if (as == 1) {
                    afVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    afVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
                com.baidu.tieba.util.bb.b(afVar.j, as);
            } else if (b == -2) {
                afVar.l.setVisibility(8);
                afVar.h.setVisibility(0);
                afVar.h.setPadding(0, 0, 0, UtilHelper.a(this.f1248a, 10.0f));
                if (this.f) {
                    afVar.j.setText(R.string.loading);
                    afVar.k.setVisibility(0);
                } else {
                    afVar.j.setText(R.string.frs_next);
                    afVar.k.setVisibility(8);
                }
                if (as == 1) {
                    afVar.i.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    afVar.i.setBackgroundResource(R.drawable.bg_list_all);
                }
                com.baidu.tieba.util.bb.b(afVar.j, as);
            } else {
                afVar.l.setVisibility(0);
                afVar.h.setVisibility(8);
                afVar.k.setVisibility(8);
                afVar.g.removeAllViews();
                ((FrsActivity) this.f1248a).m().a(as == 1);
                ((FrsActivity) this.f1248a).m().a(view3);
                com.baidu.tieba.data.bf bfVar = (com.baidu.tieba.data.bf) a(i);
                int c = bfVar.c();
                afVar.q.setVisibility(0);
                if (c <= 999999) {
                    if (c > 0) {
                        afVar.m.setText(String.valueOf(c));
                    } else {
                        afVar.m.setText((CharSequence) null);
                        afVar.q.setVisibility(4);
                    }
                } else {
                    afVar.m.setText("999999+");
                }
                Date date = new Date();
                date.setTime(bfVar.d() * 1000);
                afVar.n.setText(com.baidu.tieba.util.bc.h(date));
                afVar.o.setText(bfVar.o());
                afVar.o.setTextSize(2, 16.0f);
                afVar.o.setMaxLines(10);
                com.baidu.tieba.util.at az = TiebaApplication.g().az();
                if (az != null && az.b(bfVar.a())) {
                    afVar.o.setTextColor(this.f1248a.getResources().getColor(R.color.read_thread_color));
                }
                afVar.p.setText(bfVar.g().getName());
                if (this.h && bfVar.e() != 1) {
                    afVar.d.setVisibility(0);
                    afVar.b.setVisibility(0);
                    afVar.g.setVisibility(0);
                    afVar.f.setVisibility(0);
                    afVar.e.setVisibility(0);
                    ArrayList<com.baidu.tieba.data.ai> m = bfVar.m();
                    ArrayList<VoiceManager.VoiceModel> n = bfVar.n();
                    String str = bfVar.j() != null ? "" + bfVar.j() : "";
                    if (m != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i3 = 0; i3 < m.size(); i3++) {
                            if (m.get(i3).c() != null && m.get(i3).c().endsWith("swf")) {
                                stringBuffer.append(m.get(i3).c());
                            }
                        }
                        String str2 = str + stringBuffer.toString();
                        if (str2 != null && str2.length() > 1) {
                            afVar.e.setText(str2);
                        } else {
                            afVar.e.setVisibility(8);
                        }
                    }
                    if (n != null && n.size() > 0) {
                        afVar.f.setVisibility(0);
                        VoiceManager.VoiceModel voiceModel = n.get(0);
                        afVar.f.setVoiceModel(voiceModel);
                        afVar.f.setTag(voiceModel);
                        afVar.f.c();
                    } else {
                        afVar.f.setVisibility(8);
                    }
                    if (m != null) {
                        if (m.size() > 0) {
                            int i4 = 0;
                            int i5 = 0;
                            while (i5 < m.size()) {
                                int i6 = (m.get(i5) == null || !(m.get(i5).a() == 3 || m.get(i5).a() == 5)) ? i4 : i4 + 1;
                                i5++;
                                i4 = i6;
                            }
                            if (i4 > 3) {
                                i4 = 3;
                            }
                            int i7 = 0;
                            int i8 = 0;
                            while (i8 < m.size() && i7 < i4) {
                                if (m.get(i8).a() == 3 || m.get(i8).a() == 5) {
                                    LinearLayout a2 = a(m.get(i8), i4, i7);
                                    if (a2 != null) {
                                        afVar.g.addView(a2);
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
                            afVar.g.setVisibility(8);
                        }
                    }
                } else {
                    afVar.b.setVisibility(8);
                }
                if (bfVar.e() == 1) {
                    afVar.d.setVisibility(8);
                    a(afVar.f1250a, afVar.c, afVar.t, afVar.o, i);
                } else {
                    afVar.d.setVisibility(0);
                }
            }
            return view3;
        } catch (Exception e2) {
            e = e2;
            view2 = view;
        }
    }

    private void a(View view, View view2, DottedLine dottedLine, TextView textView, int i) {
        view.setPadding(view.getPaddingLeft(), i == 0 ? UtilHelper.a(this.f1248a, 6.0f) : UtilHelper.a(this.f1248a, 0.0f), view.getPaddingRight(), i == this.o + (-1) ? UtilHelper.a(this.f1248a, 2.0f) : UtilHelper.a(this.f1248a, 0.0f));
        textView.setTextSize(2, 15.0f);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        int as = TiebaApplication.g().as();
        ViewGroup viewGroup = (ViewGroup) dottedLine.getParent();
        if (as == 1) {
            dottedLine.setNight(true);
            viewGroup.setBackgroundResource(R.drawable.bg_frs_list_between_sepline_1);
            if (this.o == 1) {
                view2.setBackgroundResource(R.drawable.bg_list_all_1);
                return;
            } else if (this.o >= 2) {
                if (i == 0) {
                    view2.setBackgroundResource(R.drawable.bg_frs_list_top_1);
                    viewGroup.setVisibility(0);
                    return;
                } else if (i == this.o - 1) {
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
        if (this.o == 1) {
            view2.setBackgroundResource(R.drawable.bg_list_all);
        } else if (this.o >= 2) {
            if (i == 0) {
                view2.setBackgroundResource(R.drawable.bg_frs_list_top);
                viewGroup.setVisibility(0);
            } else if (i == this.o - 1) {
                view2.setBackgroundResource(R.drawable.bg_frs_list_foot);
            } else {
                view2.setBackgroundResource(R.drawable.bg_frs_list_between);
                viewGroup.setVisibility(0);
            }
        }
    }
}
