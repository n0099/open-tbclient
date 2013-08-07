package com.baidu.tieba.home;

import android.content.Context;
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
public class r extends BaseAdapter implements com.baidu.tbadk.a.d, com.baidu.tieba.view.z {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.a f1159a;
    private com.baidu.tieba.g e;
    private View.OnClickListener j;
    private View.OnLongClickListener k;
    private View.OnClickListener l;
    private View b = null;
    private int c = 0;
    private int d = 0;
    private Boolean f = false;
    private com.baidu.tieba.data.aj g = null;
    private Boolean h = false;
    private Boolean i = false;

    public r(com.baidu.tieba.g gVar) {
        this.f1159a = null;
        this.e = null;
        this.e = gVar;
        int a2 = com.baidu.tieba.util.am.a((Context) this.e, 54.0f);
        this.f1159a = new com.baidu.tieba.util.a(this.e);
        this.f1159a.a(a2, a2);
    }

    public void a(com.baidu.tieba.data.aj ajVar) {
        this.g = ajVar;
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

    public void a(com.baidu.tieba.data.ai aiVar) {
        if (this.g != null && aiVar != null) {
            this.g.a(aiVar);
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
        t tVar;
        View view2;
        View view3;
        int au = TiebaApplication.f().au();
        int itemViewType = getItemViewType(i);
        Resources resources = this.e.getResources();
        if (itemViewType == 2) {
            if (view == null) {
                view3 = LayoutInflater.from(this.e).inflate(R.layout.home_like_item, (ViewGroup) null);
                t tVar2 = new t(this, null);
                tVar2.f1161a = (LinearLayout) view3;
                tVar2.c = (ImageView) view3.findViewById(R.id.forum_icon1);
                tVar2.f = (ImageView) view3.findViewById(R.id.icon_sign1);
                tVar2.b = (RelativeLayout) view3.findViewById(R.id.first);
                tVar2.b.setOnClickListener(this.j);
                tVar2.b.setOnLongClickListener(this.k);
                tVar2.d = (TextView) view3.findViewById(R.id.home_lv_like_forum1);
                tVar2.e = (TextView) view3.findViewById(R.id.forum_lv_like_grade1);
                tVar2.g = new t(this, null);
                tVar2.g.c = (ImageView) view3.findViewById(R.id.forum_icon2);
                tVar2.g.f = (ImageView) view3.findViewById(R.id.icon_sign2);
                tVar2.g.b = (RelativeLayout) view3.findViewById(R.id.second);
                tVar2.g.b.setOnClickListener(this.j);
                tVar2.g.b.setOnLongClickListener(this.k);
                tVar2.g.d = (TextView) view3.findViewById(R.id.home_lv_like_forum2);
                tVar2.g.e = (TextView) view3.findViewById(R.id.forum_lv_like_grade2);
                view3.setTag(tVar2);
            } else {
                view3 = view;
            }
            t tVar3 = (t) view3.getTag();
            if (au == 1) {
                com.baidu.tieba.util.ah.h(tVar3.b, (int) R.drawable.home_like_item_bg_1);
                tVar3.f.setBackgroundResource(R.drawable.ico_sign_d_1);
                tVar3.g.f.setBackgroundResource(R.drawable.ico_sign_d_1);
                tVar3.d.setTextColor(-8682095);
                tVar3.e.setTextColor(-2235207);
                com.baidu.tieba.util.ah.h(tVar3.g.b, (int) R.drawable.home_like_item_bg_1);
                tVar3.g.d.setTextColor(-8682095);
                tVar3.g.e.setTextColor(-1);
                view = view3;
                tVar = tVar3;
            } else {
                com.baidu.tieba.util.ah.h(tVar3.b, (int) R.drawable.home_like_item_bg);
                tVar3.f.setBackgroundResource(R.drawable.ico_sign_d);
                tVar3.g.f.setBackgroundResource(R.drawable.ico_sign_d);
                tVar3.d.setTextColor(-14277082);
                tVar3.e.setTextColor(-1);
                com.baidu.tieba.util.ah.h(tVar3.g.b, (int) R.drawable.home_like_item_bg);
                tVar3.g.d.setTextColor(-14277082);
                tVar3.g.e.setTextColor(-1);
                view = view3;
                tVar = tVar3;
            }
        } else if (itemViewType == 0) {
            if (view == null) {
                view2 = LayoutInflater.from(this.e).inflate(R.layout.enter_forum_login, (ViewGroup) null);
                u uVar = new u(this, null);
                uVar.f1162a = (LinearLayout) view2;
                uVar.b = (LinearLayout) view2.findViewById(R.id.container);
                uVar.c = (TextView) view2.findViewById(R.id.tip);
                uVar.d = (Button) view2.findViewById(R.id.want_login);
                uVar.d.setOnClickListener(this.l);
                view2.setTag(uVar);
            } else {
                view2 = view;
            }
            u uVar2 = (u) view2.getTag();
            int a2 = com.baidu.tieba.util.am.a((Context) this.e, 7.0f);
            int a3 = com.baidu.tieba.util.am.a((Context) this.e, 5.0f);
            uVar2.f1162a.setPadding(a2, a3, a2, a3);
            if (au == 1) {
                uVar2.b.setBackgroundColor(resources.getColor(R.color.skin_1_common_bg));
                uVar2.c.setTextColor(-8682095);
                uVar2.d.setTextColor(-5454368);
                uVar2.d.setBackgroundResource(R.drawable.want_login_1);
            } else {
                uVar2.b.setBackgroundColor(-328966);
                uVar2.c.setTextColor(-13421773);
                uVar2.d.setTextColor(resources.getColor(R.color.white));
                uVar2.d.setBackgroundResource(R.drawable.want_login);
            }
            return view2;
        } else if (itemViewType == 1) {
            if (view == null) {
                view = LayoutInflater.from(this.e).inflate(R.layout.home_like_nodata_item, (ViewGroup) null);
                v vVar = new v(this, null);
                vVar.f1163a = (TextView) view.findViewById(R.id.forum_lv_nodata);
                view.setTag(vVar);
            }
            v vVar2 = (v) view.getTag();
            if (au == 1) {
                vVar2.f1163a.setTextColor(-8682095);
            } else {
                vVar2.f1163a.setTextColor(-13421773);
            }
            v vVar3 = (v) view.getTag();
            return view;
        } else if (itemViewType == 3) {
            if (view == null) {
                view = LayoutInflater.from(this.e).inflate(R.layout.enter_forum_goon_show_like, (ViewGroup) null);
                s sVar = new s(this, null);
                sVar.f1160a = (RelativeLayout) view.findViewById(R.id.show_more_layout);
                sVar.b = (TextView) view.findViewById(R.id.show_more_text);
                sVar.c = (ImageView) view.findViewById(R.id.show_more_icon);
                view.setTag(sVar);
            }
            s sVar2 = (s) view.getTag();
            sVar2.f1160a.setOnClickListener(this.j);
            sVar2.b.setText(d());
            if (au == 1) {
                sVar2.b.setTextColor(-8682095);
                sVar2.f1160a.setBackgroundResource(R.drawable.bg_unfold_1);
                if (this.i.booleanValue()) {
                    sVar2.c.setBackgroundResource(R.drawable.ico_upward_1);
                    return view;
                }
                sVar2.c.setBackgroundResource(R.drawable.ico_downward_1);
                return view;
            }
            sVar2.b.setTextColor(-9405562);
            sVar2.f1160a.setBackgroundResource(R.drawable.bg_unfold);
            if (this.i.booleanValue()) {
                sVar2.c.setBackgroundResource(R.drawable.ico_upward);
                return view;
            }
            sVar2.c.setBackgroundResource(R.drawable.ico_downward);
            return view;
        } else {
            tVar = null;
        }
        if (itemViewType == 2 && tVar != null && this.g.a() != null) {
            int a4 = com.baidu.tieba.util.am.a((Context) this.e, 5.0f);
            tVar.f1161a.setPadding(a4, a4, a4, 0);
            b();
            if (i == getCount() - 1 && !this.h.booleanValue()) {
                tVar.f1161a.setPadding(a4, a4, a4, a4);
            }
            if (i >= 0) {
                if (i * 2 < this.g.a().size()) {
                    a((com.baidu.tieba.data.ai) this.g.a().get(i * 2), tVar);
                }
                if ((i * 2) + 1 < this.g.a().size()) {
                    tVar.g.b.setVisibility(0);
                    a((com.baidu.tieba.data.ai) this.g.a().get((i * 2) + 1), tVar.g);
                    return view;
                }
                tVar.g.b.setVisibility(4);
                return view;
            }
            return view;
        }
        return view;
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

    private void a(com.baidu.tieba.data.ai aiVar, t tVar) {
        int au = TiebaApplication.f().au();
        if (aiVar != null && tVar != null) {
            int d = aiVar.d();
            tVar.b.setTag(aiVar);
            tVar.d.setText(aiVar.b());
            if (aiVar.c() == 0) {
                tVar.f.setVisibility(4);
            } else {
                tVar.f.setVisibility(0);
            }
            tVar.c.setTag(aiVar.e());
            if (aiVar.e() != null) {
                com.baidu.adp.widget.a.b d2 = this.f1159a.d(aiVar.e());
                if (d2 != null) {
                    d2.b(tVar.c);
                } else if (au == 1) {
                    tVar.c.setImageResource(R.drawable.pic_image_h_not_1);
                } else {
                    tVar.c.setImageResource(R.drawable.pic_image_h_not);
                }
            } else if (au == 1) {
                tVar.c.setImageResource(R.drawable.pic_image_h_not_1);
            } else {
                tVar.c.setImageResource(R.drawable.pic_image_h_not);
            }
            if (d == 0) {
                tVar.e.setVisibility(4);
                return;
            }
            tVar.e.setVisibility(0);
            tVar.e.setBackgroundResource(com.baidu.tieba.util.e.b(d));
            tVar.e.setText(String.valueOf(aiVar.d()));
        }
    }

    private SpannableString d() {
        String str;
        int i;
        int au = TiebaApplication.f().au();
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
        if (au == 1) {
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

    @Override // com.baidu.tieba.view.z
    public void c() {
        if (this.f1159a != null) {
            this.f1159a.b();
        }
    }

    @Override // com.baidu.tieba.view.z
    public void a(View view, int i, int i2) {
        String e;
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
            this.f1159a.a();
            if (this.g != null && this.g.a() != null && this.g.a().size() > 0) {
                if (this.d > this.g.a().size()) {
                    this.d = this.g.a().size();
                }
                int i3 = this.c;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.d) {
                        if ((this.g.a().get(i4) instanceof com.baidu.tieba.data.ai) && (e = ((com.baidu.tieba.data.ai) this.g.a().get(i4)).e()) != null && !e.equals("")) {
                            this.f1159a.e(e, this);
                        }
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.aj.b("LikeForumAdapter", "mGetImageRunnble.run", "error = " + e2.getMessage());
        }
    }
}
