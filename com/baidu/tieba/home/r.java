package com.baidu.tieba.home;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class r extends BaseAdapter implements com.baidu.tbadk.a.d, com.baidu.tieba.view.v {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.a f937a;
    private com.baidu.tieba.g e;
    private View.OnClickListener j;
    private View.OnLongClickListener k;
    private View.OnClickListener l;
    private View b = null;
    private int c = 0;
    private int d = 0;
    private Boolean f = false;
    private com.baidu.tieba.data.ab g = null;
    private Boolean h = false;
    private Boolean i = false;

    public r(com.baidu.tieba.g gVar) {
        this.f937a = null;
        this.e = null;
        this.e = gVar;
        int a2 = com.baidu.tieba.util.ab.a(this.e, 54.0f);
        this.f937a = new com.baidu.tieba.util.a(this.e);
        this.f937a.a(a2, a2);
    }

    public void a(com.baidu.tieba.data.ab abVar) {
        this.g = abVar;
        b();
        notifyDataSetChanged();
    }

    private void b() {
        if (this.g != null && this.g.a() != null && this.g.a().size() > 6) {
            this.h = true;
            return;
        }
        this.h = false;
        this.i = false;
    }

    public void a(com.baidu.tieba.data.aa aaVar) {
        if (this.g != null && aaVar != null) {
            this.g.a(aaVar);
            b();
            notifyDataSetChanged();
        }
    }

    public void a(Boolean bool) {
        this.f = bool;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.g == null) {
            return 0;
        }
        if (!this.f.booleanValue() || this.g.a() == null || this.g.a().size() <= 0) {
            return 1;
        }
        int size = this.g.a().size();
        if (size > 6) {
            if (a().booleanValue()) {
                if (size > 100) {
                    return 51;
                }
                return (size % 2) + (size / 2) + 1;
            }
            return 4;
        }
        return (size % 2) + 0 + (size / 2);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        View view4;
        View view5;
        t tVar = null;
        v vVar = null;
        int at = TiebaApplication.f().at();
        int itemViewType = getItemViewType(i);
        Resources resources = this.e.getResources();
        if (itemViewType == 2) {
            if (view == null) {
                View inflate = LayoutInflater.from(this.e).inflate(R.layout.home_like_item, (ViewGroup) null);
                t tVar2 = new t(this, null);
                tVar2.f939a = (LinearLayout) inflate;
                tVar2.c = (ImageView) inflate.findViewById(R.id.forum_icon1);
                tVar2.f = (ImageView) inflate.findViewById(R.id.icon_sign1);
                tVar2.b = (RelativeLayout) inflate.findViewById(R.id.first);
                tVar2.b.setOnClickListener(this.j);
                tVar2.b.setOnLongClickListener(this.k);
                tVar2.d = (TextView) inflate.findViewById(R.id.home_lv_like_forum1);
                tVar2.e = (TextView) inflate.findViewById(R.id.forum_lv_like_grade1);
                tVar2.g = new t(this, null);
                tVar2.g.c = (ImageView) inflate.findViewById(R.id.forum_icon2);
                tVar2.g.f = (ImageView) inflate.findViewById(R.id.icon_sign2);
                tVar2.g.b = (RelativeLayout) inflate.findViewById(R.id.second);
                tVar2.g.b.setOnClickListener(this.j);
                tVar2.g.b.setOnLongClickListener(this.k);
                tVar2.g.d = (TextView) inflate.findViewById(R.id.home_lv_like_forum2);
                tVar2.g.e = (TextView) inflate.findViewById(R.id.forum_lv_like_grade2);
                inflate.setTag(tVar2);
                view5 = inflate;
            } else {
                view5 = view;
            }
            t tVar3 = (t) view5.getTag();
            if (at == 1) {
                com.baidu.tieba.util.x.h(tVar3.b, (int) R.drawable.home_like_item_bg_1);
                tVar3.f.setBackgroundResource(R.drawable.ico_sign_d_1);
                tVar3.g.f.setBackgroundResource(R.drawable.ico_sign_d_1);
                tVar3.d.setTextColor(-8682095);
                tVar3.e.setTextColor(-2235207);
                com.baidu.tieba.util.x.h(tVar3.g.b, (int) R.drawable.home_like_item_bg_1);
                tVar3.g.d.setTextColor(-8682095);
                tVar3.g.e.setTextColor(-1);
                tVar = tVar3;
                view2 = view5;
            } else {
                com.baidu.tieba.util.x.h(tVar3.b, (int) R.drawable.home_like_item_bg);
                tVar3.f.setBackgroundResource(R.drawable.ico_sign_d);
                tVar3.g.f.setBackgroundResource(R.drawable.ico_sign_d);
                tVar3.d.setTextColor(-14277082);
                tVar3.e.setTextColor(-1);
                com.baidu.tieba.util.x.h(tVar3.g.b, (int) R.drawable.home_like_item_bg);
                tVar3.g.d.setTextColor(-14277082);
                tVar3.g.e.setTextColor(-1);
                tVar = tVar3;
                view2 = view5;
            }
        } else if (itemViewType == 0) {
            if (view == null) {
                View inflate2 = LayoutInflater.from(this.e).inflate(R.layout.enter_forum_login, (ViewGroup) null);
                u uVar = new u(this, null);
                uVar.f940a = (LinearLayout) inflate2;
                uVar.b = (LinearLayout) inflate2.findViewById(R.id.container);
                uVar.c = (TextView) inflate2.findViewById(R.id.tip);
                uVar.d = (Button) inflate2.findViewById(R.id.want_login);
                uVar.d.setOnClickListener(this.l);
                inflate2.setTag(uVar);
                view4 = inflate2;
            } else {
                view4 = view;
            }
            u uVar2 = (u) view4.getTag();
            int a2 = com.baidu.tieba.util.ab.a(this.e, 7.0f);
            int a3 = com.baidu.tieba.util.ab.a(this.e, 5.0f);
            uVar2.f940a.setPadding(a2, a3, a2, a3);
            if (at == 1) {
                uVar2.b.setBackgroundColor(resources.getColor(R.color.skin_1_common_bg));
                uVar2.c.setTextColor(-8682095);
                uVar2.d.setTextColor(-5454368);
                uVar2.d.setBackgroundResource(R.drawable.want_login_1);
                return view4;
            }
            uVar2.b.setBackgroundColor(-328966);
            uVar2.c.setTextColor(-13421773);
            uVar2.d.setTextColor(resources.getColor(R.color.white));
            uVar2.d.setBackgroundResource(R.drawable.want_login);
            return view4;
        } else if (itemViewType == 1) {
            if (view == null) {
                View inflate3 = LayoutInflater.from(this.e).inflate(R.layout.home_like_nodata_item, (ViewGroup) null);
                v vVar2 = new v(this, null);
                vVar2.f941a = (TextView) inflate3.findViewById(R.id.forum_lv_nodata);
                inflate3.setTag(vVar2);
                vVar = vVar2;
                view3 = inflate3;
            } else {
                view3 = view;
            }
            if (at == 1) {
                vVar.f941a.setTextColor(-8682095);
            } else {
                vVar.f941a.setTextColor(-13421773);
            }
            v vVar3 = (v) view3.getTag();
            return view3;
        } else if (itemViewType == 3) {
            if (view == null) {
                view = LayoutInflater.from(this.e).inflate(R.layout.enter_forum_goon_show_like, (ViewGroup) null);
                s sVar = new s(this, null);
                sVar.f938a = (RelativeLayout) view.findViewById(R.id.show_more_layout);
                sVar.b = (TextView) view.findViewById(R.id.show_more_text);
                sVar.c = (ImageView) view.findViewById(R.id.show_more_icon);
                view.setTag(sVar);
            }
            s sVar2 = (s) view.getTag();
            sVar2.f938a.setOnClickListener(this.j);
            sVar2.b.setText(d());
            if (at == 1) {
                sVar2.b.setTextColor(-8682095);
                sVar2.f938a.setBackgroundResource(R.drawable.bg_unfold_1);
                if (this.i.booleanValue()) {
                    sVar2.c.setBackgroundResource(R.drawable.ico_upward_1);
                } else {
                    sVar2.c.setBackgroundResource(R.drawable.ico_downward_1);
                }
            } else {
                sVar2.b.setTextColor(-9405562);
                sVar2.f938a.setBackgroundResource(R.drawable.bg_unfold);
                if (this.i.booleanValue()) {
                    sVar2.c.setBackgroundResource(R.drawable.ico_upward);
                } else {
                    sVar2.c.setBackgroundResource(R.drawable.ico_downward);
                }
            }
            return view;
        } else {
            view2 = view;
        }
        if (itemViewType == 2 && tVar != null && this.g.a() != null) {
            int a4 = com.baidu.tieba.util.ab.a(this.e, 5.0f);
            tVar.f939a.setPadding(a4, a4, a4, 0);
            b();
            if (i == getCount() - 1 && !this.h.booleanValue()) {
                tVar.f939a.setPadding(a4, a4, a4, a4);
            }
            if (i >= 0) {
                if (i * 2 < this.g.a().size()) {
                    a((com.baidu.tieba.data.aa) this.g.a().get(i * 2), tVar);
                }
                if ((i * 2) + 1 < this.g.a().size()) {
                    tVar.g.b.setVisibility(0);
                    a((com.baidu.tieba.data.aa) this.g.a().get((i * 2) + 1), tVar.g);
                    return view2;
                }
                tVar.g.b.setVisibility(4);
                return view2;
            }
            return view2;
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (!this.f.booleanValue()) {
            return 0;
        }
        if (this.g == null || this.g.a() == null || this.g.a().size() == 0) {
            return 1;
        }
        if (a().booleanValue()) {
            if (i == getCount() - 1) {
                return 3;
            }
        } else if (i == 3 && this.h.booleanValue()) {
            return 3;
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    public void a(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.k = onLongClickListener;
    }

    public void b(Boolean bool) {
        this.i = bool;
    }

    public Boolean a() {
        return this.i;
    }

    private void a(com.baidu.tieba.data.aa aaVar, t tVar) {
        int at = TiebaApplication.f().at();
        if (aaVar != null && tVar != null) {
            int d = aaVar.d();
            tVar.b.setTag(aaVar);
            tVar.d.setText(aaVar.b());
            if (aaVar.c() == 0) {
                tVar.f.setVisibility(4);
            } else {
                tVar.f.setVisibility(0);
            }
            tVar.c.setTag(aaVar.e());
            if (aaVar.e() != null) {
                com.baidu.adp.widget.a.b c = this.f937a.c(aaVar.e());
                if (c != null) {
                    c.b(tVar.c);
                } else if (at == 1) {
                    tVar.c.setImageResource(R.drawable.pic_image_h_not_1);
                } else {
                    tVar.c.setImageResource(R.drawable.pic_image_h_not);
                }
            } else if (at == 1) {
                tVar.c.setImageResource(R.drawable.pic_image_h_not_1);
            } else {
                tVar.c.setImageResource(R.drawable.pic_image_h_not);
            }
            if (d == 0) {
                tVar.e.setVisibility(4);
                return;
            }
            tVar.e.setVisibility(0);
            tVar.e.setBackgroundResource(com.baidu.tieba.util.d.b(d));
            tVar.e.setText(String.valueOf(aaVar.d()));
        }
    }

    private SpannableString d() {
        String str;
        int i;
        int at = TiebaApplication.f().at();
        String str2 = "";
        String str3 = "";
        if (this.i.booleanValue()) {
            str2 = this.e.getString(R.string.fold_like_forum);
            str = "";
            i = 0;
        } else if (!this.h.booleanValue() || this.i.booleanValue()) {
            str = "";
            i = 0;
        } else {
            String string = this.e.getString(R.string.unfold_like_forum);
            int indexOf = string.indexOf(63);
            if (this.g != null && this.g.a() != null && this.g.a().size() > 6) {
                str3 = String.valueOf(String.valueOf(this.g.a().size() - 6)) + "个";
            }
            str2 = string.replace("?", str3);
            str = str3;
            i = indexOf;
        }
        SpannableString spannableString = new SpannableString(str2);
        if (at == 1) {
            spannableString.setSpan(new ForegroundColorSpan(Color.rgb(57, 124, 205)), i, str.length() + i, 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(Color.rgb(60, 133, 224)), i, str.length() + i, 33);
        }
        return spannableString;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ImageView imageView;
        if (bVar != null && this.b != null && (imageView = (ImageView) this.b.findViewWithTag(str)) != null) {
            bVar.b(imageView);
            imageView.invalidate();
        }
    }

    @Override // com.baidu.tieba.view.v
    public void c() {
        if (this.f937a != null) {
            this.f937a.b();
        }
    }

    @Override // com.baidu.tieba.view.v
    public void a(View view, int i, int i2) {
        int i3;
        String e;
        int i4 = 0;
        this.b = view;
        this.c = i * 2;
        this.d = (i2 * 2) + 2;
        try {
            if (this.c < 0) {
                this.c = 0;
            }
            if (this.d < 0) {
                this.d = 0;
            }
            this.f937a.a();
            if (this.g != null && this.g.a() != null && this.g.a().size() > 0) {
                if (this.d > this.g.a().size()) {
                    this.d = this.g.a().size();
                }
                int i5 = this.c;
                while (i5 < this.d) {
                    if (!(this.g.a().get(i5) instanceof com.baidu.tieba.data.aa) || (e = ((com.baidu.tieba.data.aa) this.g.a().get(i5)).e()) == null || e.equals("")) {
                        i3 = i4;
                    } else {
                        i3 = i4 + 1;
                        this.f937a.e(e, this);
                    }
                    i5++;
                    i4 = i3;
                }
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.z.b("LikeForumAdapter", "mGetImageRunnble.run", "error = " + e2.getMessage());
        }
    }
}
