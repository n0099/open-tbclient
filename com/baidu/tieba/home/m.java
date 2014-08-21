package com.baidu.tieba.home;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.data.aa;
import com.baidu.tieba.data.ae;
import com.baidu.tieba.data.af;
import com.baidu.tieba.data.as;
import com.baidu.tieba.data.z;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private BaseFragmentActivity a;
    private com.baidu.tieba.data.o f;
    private boolean g;
    private boolean h;
    private View.OnClickListener i;
    private View.OnLongClickListener j;
    private BannerView k;
    private aa b = null;
    private as c = null;
    private int d = 0;
    private int e = 0;
    private View.OnClickListener l = new n(this);

    public void a(boolean z) {
        this.h = z;
    }

    public m(BaseFragmentActivity baseFragmentActivity) {
        this.a = null;
        this.a = baseFragmentActivity;
        a();
    }

    public void a() {
        this.e = com.baidu.adp.lib.util.j.a((Context) this.a, 8.0f);
        this.d = com.baidu.adp.lib.util.j.a((Context) this.a, 10.0f);
    }

    public void a(aa aaVar) {
        this.b = aaVar;
    }

    public void a(as asVar) {
        this.c = asVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        int size2;
        int i = 0;
        if (this.b == null) {
            return 0;
        }
        if (this.b.a() != null && (size2 = this.b.a().size()) > 0) {
            i = size2 > 500 ? 250 : (size2 + 1) / 2;
        }
        if (this.c != null && this.c.a() != null && (size = this.c.a().size()) > 0) {
            i = size > 500 ? 250 : i + 1 + ((size + 1) / 2);
        }
        if (this.g) {
            i++;
        }
        return this.h ? i + 1 : i;
    }

    public int b() {
        int size;
        if (this.b.a() == null || (size = this.b.a().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    public int c() {
        int size;
        if (this.c == null || this.c.a() == null || (size = this.c.a().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1 || itemViewType == 2 || itemViewType == 0 || itemViewType == 4 || itemViewType != 3) {
            return null;
        }
        if (this.g) {
            i--;
        }
        if (this.h) {
            i--;
        }
        int b = (i - 1) - ((b() + 1) / 2);
        if (b >= 0) {
            af afVar = new af();
            if (b * 2 < this.c.a().size()) {
                afVar.a = this.c.a().get(b * 2);
            }
            if ((b * 2) + 1 < this.c.a().size()) {
                afVar.b = this.c.a().get((b * 2) + 1);
            }
            return afVar;
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int c = (c() + 1) / 2;
        if (this.g && i == 0) {
            return 2;
        }
        if (this.h) {
            if (this.g && i == 1) {
                return 1;
            }
            if (!this.g && i == 0) {
                return 1;
            }
        }
        if (i < (getCount() - c) - 1) {
            return 0;
        }
        if (i == (getCount() - c) - 1) {
            return c > 0 ? 4 : 0;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            view = com.baidu.adp.lib.e.b.a().a(this.a, v.home_like_guide, null);
            if (b() <= 4) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view.setOnClickListener(this.l);
            a(view);
        } else if (itemViewType == 2) {
            if (this.k == null) {
                view = com.baidu.adp.lib.e.b.a().a(this.a, v.home_like_item_banner, null);
                this.k = (BannerView) view.findViewById(com.baidu.tieba.u.home_like_banner_view);
            }
            this.k.a("enter_bar_bck", "");
            this.k.b(this.f.f().a(), this.f.f().b());
        } else if (itemViewType == 0) {
            if (this.g) {
                i--;
            }
            if (this.h) {
                i--;
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (view == null) {
                view = a((s) null);
            }
            s sVar = 0 == 0 ? (s) view.getTag() : null;
            if (sVar != null && this.b != null && this.b.a() != null) {
                this.a.c().a(skinType == 1);
                this.a.c().a(view);
                a(skinType, sVar);
                sVar.a.setPadding(this.d, this.e, this.d, 0);
                if (i >= 0) {
                    if (i * 2 < this.b.a().size()) {
                        a(this.b.a().get(i * 2), sVar);
                    }
                    if ((i * 2) + 1 < this.b.a().size()) {
                        sVar.f.b.setVisibility(0);
                        a(this.b.a().get((i * 2) + 1), sVar.f);
                    } else {
                        sVar.f.b.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 4) {
            view = com.baidu.adp.lib.e.b.a().a(this.a, v.home_new_recommend_notice, null);
            if (c() > 0) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            a(view);
        } else if (itemViewType == 3) {
            if (this.g) {
                i--;
            }
            if (this.h) {
                i--;
            }
            int b = (i - 1) - ((b() + 1) / 2);
            int skinType2 = TbadkApplication.m252getInst().getSkinType();
            view = a((t) null);
            t tVar = 0 == 0 ? (t) view.getTag() : null;
            if (tVar != null && this.c != null && this.c.a() != null) {
                this.a.c().a(skinType2 == 1);
                this.a.c().a(view);
                if (b >= 0) {
                    if (b * 2 < this.c.a().size()) {
                        a(this.c.a().get(b * 2), tVar);
                    }
                    if ((b * 2) + 1 < this.c.a().size()) {
                        tVar.f.b.setVisibility(0);
                        a(this.c.a().get((b * 2) + 1), tVar.f);
                    } else {
                        tVar.f.b.setVisibility(4);
                    }
                }
            }
        }
        return view;
    }

    private void a(View view) {
        this.a.c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.c().a(view);
    }

    private View a(s sVar) {
        View a = com.baidu.adp.lib.e.b.a().a(this.a, v.home_like_item, null);
        s sVar2 = new s();
        sVar2.a = (LinearLayout) a;
        sVar2.e = (TextView) a.findViewById(com.baidu.tieba.u.forum_icon_sign1);
        sVar2.b = (RelativeLayout) a.findViewById(com.baidu.tieba.u.item_left);
        sVar2.b.setOnClickListener(this.i);
        sVar2.b.setOnLongClickListener(this.j);
        sVar2.c = (TextView) a.findViewById(com.baidu.tieba.u.home_lv_like_forum1);
        sVar2.d = (TextView) a.findViewById(com.baidu.tieba.u.forum_lv_like_grade1);
        sVar2.f = new s();
        sVar2.f.e = (TextView) a.findViewById(com.baidu.tieba.u.forum_icon_sign2);
        sVar2.f.b = (RelativeLayout) a.findViewById(com.baidu.tieba.u.item_right);
        sVar2.f.b.setOnClickListener(this.i);
        sVar2.f.b.setOnLongClickListener(this.j);
        sVar2.f.c = (TextView) a.findViewById(com.baidu.tieba.u.home_lv_like_forum2);
        sVar2.f.d = (TextView) a.findViewById(com.baidu.tieba.u.forum_lv_like_grade2);
        a.setTag(sVar2);
        return a;
    }

    private View a(t tVar) {
        View a = com.baidu.adp.lib.e.b.a().a(this.a, v.home_recommend_item, null);
        t tVar2 = new t();
        tVar2.a = (LinearLayout) a.findViewById(com.baidu.tieba.u.home_recommend_container);
        tVar2.b = (RelativeLayout) a.findViewById(com.baidu.tieba.u.recommend_item_left);
        tVar2.b.setOnClickListener(this.i);
        tVar2.d = (TextView) a.findViewById(com.baidu.tieba.u.left_bar_name);
        tVar2.e = (TextView) a.findViewById(com.baidu.tieba.u.left_focus_num);
        tVar2.c = (BarImageView) a.findViewById(com.baidu.tieba.u.left_bar_pic);
        tVar2.f = new t();
        tVar2.f.b = (RelativeLayout) a.findViewById(com.baidu.tieba.u.recommend_item_right);
        tVar2.f.b.setOnClickListener(this.i);
        tVar2.f.d = (TextView) a.findViewById(com.baidu.tieba.u.right_bar_name);
        tVar2.f.e = (TextView) a.findViewById(com.baidu.tieba.u.right_focus_num);
        tVar2.f.c = (BarImageView) a.findViewById(com.baidu.tieba.u.right_bar_pic);
        a.setTag(tVar2);
        return a;
    }

    public void a(int i) {
        notifyDataSetChanged();
    }

    private void a(int i, s sVar) {
        if (sVar != null && sVar.b(i)) {
            if (i == 1) {
                ay.e(sVar.b, com.baidu.tieba.t.home_like_item_bg_1);
                ay.e(sVar.f.b, com.baidu.tieba.t.home_like_item_bg_1);
                return;
            }
            ay.e(sVar.b, com.baidu.tieba.t.home_like_item_bg);
            ay.e(sVar.f.b, com.baidu.tieba.t.home_like_item_bg);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.j = onLongClickListener;
    }

    private void a(z zVar, s sVar) {
        if (zVar != null && sVar != null) {
            int d = zVar.d();
            sVar.b.setTag(zVar);
            sVar.c.setText(zVar.b());
            if (zVar.c() == 0) {
                sVar.e.setVisibility(8);
            } else {
                sVar.e.setVisibility(0);
            }
            if (d == 0) {
                sVar.d.setVisibility(4);
                return;
            }
            sVar.d.setVisibility(0);
            sVar.d.setBackgroundResource(com.baidu.tbadk.core.util.d.b(d));
            sVar.d.setText(String.valueOf(zVar.d()));
        }
    }

    private void a(ae aeVar, t tVar) {
        if (aeVar != null && tVar != null) {
            tVar.b.setTag(aeVar);
            tVar.d.setText(aeVar.a());
            tVar.e.setText(String.valueOf(this.a.getResources().getString(x.enter_forum_recommend_focus)) + String.valueOf(aeVar.b()));
            if (!TextUtils.isEmpty(aeVar.c())) {
                tVar.c.setTag(aeVar.c());
                tVar.c.a(aeVar.c(), 10, false);
            }
        }
    }

    public void a(com.baidu.tieba.data.o oVar) {
        this.f = oVar;
        if (this.k != null) {
            this.k.a();
        }
        if (oVar.f() != null && oVar.f().a() != null) {
            this.g = true;
        } else {
            this.g = false;
        }
        a(oVar.g());
        a(oVar.b());
        notifyDataSetChanged();
    }
}
