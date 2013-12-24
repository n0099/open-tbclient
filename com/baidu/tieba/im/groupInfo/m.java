package com.baidu.tieba.im.groupInfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.be;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.a.e {
    private TextView A;
    private RelativeLayout B;
    private RelativeLayout C;
    private LinearLayout D;
    private Dialog E;
    private LinearLayout F;
    private Dialog G;
    private x H;
    private TextView I;
    private String J;
    private ImageView K;
    private RelativeLayout L;
    private TextView M;
    private ImageView N;
    private RelativeLayout O;
    private RelativeLayout P;
    private ImageView Q;
    private ImageView R;
    private View S;
    private TextView T;
    private boolean U;
    private LinearLayout V;
    private NavigationBar W;
    private GroupInfoActivity a;
    private RelativeLayout c;
    private ImageView d;
    private ProgressBar e;
    private TextView f;
    private TextView g;
    private EllipsizingTextView h;
    private TextView i;
    private RelativeLayout j;
    private PhotoWallView k;
    private DialogInterface.OnClickListener l;
    private Dialog m;
    private TextView n;
    private RelativeLayout o;
    private RelativeLayout p;
    private LinearLayout q;
    private HeadImageView r;
    private TextView s;
    private RelativeLayout t;
    private AlertDialog u;
    private DialogInterface.OnClickListener v;
    private RelativeLayout w;
    private com.baidu.tieba.util.i x;
    private LinearLayout y;
    private LinearLayout z;

    public m(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity);
        this.l = null;
        this.m = null;
        this.u = null;
        this.v = null;
        this.J = "";
        this.U = true;
        this.a = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.x = new com.baidu.tieba.util.i(groupInfoActivity);
        this.x.d(false);
        a(groupInfoActivity);
        b(groupInfoActivity);
        c(groupInfoActivity);
    }

    public void a(String str) {
        this.M.setText(str);
        f(str);
    }

    private void f(String str) {
        this.W.a(str);
    }

    public void b(String str) {
        this.h.setText(str);
    }

    private void a(GroupInfoActivity groupInfoActivity) {
        this.W = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.W.a("");
        this.d = this.W.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupInfoActivity);
        this.I = this.W.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupInfoActivity.getString(R.string.setup));
        this.I.setOnClickListener(groupInfoActivity);
        this.I.setVisibility(8);
    }

    private void b(GroupInfoActivity groupInfoActivity) {
        this.c = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.w = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.w.setOnClickListener(groupInfoActivity);
        this.F = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.K = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.f = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.g = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.Q = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.h = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.h.setMaxLines(20);
        this.h.a(new n(this));
        this.j = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.i = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.j.setOnClickListener(groupInfoActivity);
        this.r = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.r.setAutoChangeStyle(true);
        this.r.setIsRound(true);
        this.n = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.o = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.o.setOnClickListener(groupInfoActivity);
        this.S = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.q = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.j.setOnClickListener(groupInfoActivity);
        this.p = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.p.setOnClickListener(groupInfoActivity);
        this.s = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.t = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.t.setOnClickListener(groupInfoActivity);
        this.y = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.z = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.V = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.A = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.V.setOnClickListener(this.a);
        this.B = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_share);
        this.B.setOnClickListener(groupInfoActivity);
        this.C = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.C.setOnClickListener(groupInfoActivity);
        this.D = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.L = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.L.setOnClickListener(groupInfoActivity);
        this.M = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.N = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.R = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.O = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.O.setOnClickListener(groupInfoActivity);
        this.O.setOnClickListener(groupInfoActivity);
        this.O.setLongClickable(true);
        this.O.setOnLongClickListener(groupInfoActivity);
        this.T = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.T.setClickable(true);
        this.T.setOnClickListener(new o(this));
        this.P = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.P.setOnLongClickListener(groupInfoActivity);
        this.e = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
    }

    private void c(GroupInfoActivity groupInfoActivity) {
        this.k = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.k.setPhotoClickListener(groupInfoActivity);
        this.k.setPhotoLongClickListener(groupInfoActivity);
        this.k.setVisibility(8);
    }

    public RelativeLayout a() {
        return this.P;
    }

    public RelativeLayout e() {
        return this.j;
    }

    public LinearLayout f() {
        return this.y;
    }

    public RelativeLayout g() {
        return this.B;
    }

    public RelativeLayout h() {
        return this.C;
    }

    public RelativeLayout i() {
        return this.O;
    }

    public RelativeLayout j() {
        return this.L;
    }

    public TextView k() {
        return this.I;
    }

    public LinearLayout l() {
        return this.V;
    }

    public RelativeLayout m() {
        return this.o;
    }

    public RelativeLayout n() {
        return this.p;
    }

    public RelativeLayout o() {
        return this.t;
    }

    public ImageView p() {
        return this.d;
    }

    public void q() {
        this.e.setVisibility(8);
    }

    public void r() {
        this.e.setVisibility(0);
    }

    public void a(boolean z, String str) {
        if (z) {
            this.g.setText(str);
            this.w.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.w.setVisibility(8);
        } else {
            this.g.setText(str);
            this.w.setVisibility(0);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.g.setText(this.b.getString(R.string.group_info_address_hide));
        } else {
            this.w.setVisibility(8);
        }
    }

    public RelativeLayout s() {
        return this.w;
    }

    public void a(be beVar) {
        a(beVar, false);
    }

    public void a(be beVar, boolean z) {
        if (beVar != null) {
            boolean z2 = TiebaApplication.h().an() == 1;
            this.F.setVisibility(0);
            this.z.setVisibility(0);
            if (beVar.a() != null) {
                f(beVar.a().getName());
                this.f.setText(String.valueOf(beVar.a().getGroupId()));
                if (beVar.a().getGroupType() == 4) {
                    this.K.setVisibility(0);
                    this.r.setVisibility(8);
                    this.R.setVisibility(8);
                    this.S.setVisibility(8);
                    this.n.setText(R.string.group_info_forum_author);
                    this.o.setEnabled(false);
                } else {
                    this.K.setVisibility(8);
                    this.r.setVisibility(0);
                    this.R.setVisibility(0);
                    this.S.setVisibility(0);
                    this.n.setText(beVar.a().getAuthorName());
                    this.o.setEnabled(true);
                }
                String position = beVar.a().getPosition();
                String business = beVar.a().getBusiness();
                StringBuffer stringBuffer = new StringBuffer();
                if (position != null) {
                    stringBuffer.append(position);
                }
                if (business != null) {
                    stringBuffer.append(business);
                }
                this.J = stringBuffer.toString();
                this.g.setText(this.J);
                this.h.setText(beVar.a().getIntro());
                this.s.setText("(" + beVar.a().getMemberNum() + "/" + beVar.a().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(beVar.a().getAuthorPortrait())) {
                    com.baidu.adp.widget.ImageView.e c = this.x.c(beVar.a().getAuthorPortrait());
                    if (c != null) {
                        c.a(this.r);
                    } else {
                        this.x.b(beVar.a().getAuthorPortrait(), new p(this));
                    }
                }
                if (beVar.a().getForumName() != null && beVar.a().getForumName().length() > 0) {
                    this.j.setVisibility(0);
                    this.i.setText(beVar.a().getForumName() + this.a.getString(R.string.bar));
                } else {
                    this.j.setVisibility(8);
                }
                this.q.removeAllViews();
                if (beVar.a().getGrade() > 0) {
                    for (int i = 0; i < beVar.a().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.a);
                        if (z2) {
                            imageView.setImageResource(R.drawable.icon_grade_middle_star_s_1);
                        } else {
                            imageView.setImageResource(R.drawable.icon_grade_middle_star_s);
                        }
                        this.q.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.a);
                    if (z2) {
                        imageView2.setImageResource(R.drawable.icon_grade_middle_star_n_1);
                    } else {
                        imageView2.setImageResource(R.drawable.icon_grade_middle_star_n);
                    }
                    this.q.addView(imageView2);
                }
            }
            this.y.removeAllViews();
            if (beVar.b() != null && beVar.b().size() > 0) {
                List<MemberData> b = beVar.b();
                int size = b.size();
                int i2 = size > 7 ? 7 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = b.get(i3);
                    HeadImageView headImageView = new HeadImageView(this.a);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(true);
                    headImageView.setTag(String.valueOf(memberData.getUserId()));
                    int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_photo_width);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_photo_margin);
                    this.y.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        com.baidu.adp.widget.ImageView.e c2 = this.x.c(memberData.getPortrait());
                        if (c2 != null) {
                            c2.a(headImageView);
                        } else {
                            this.x.b(memberData.getPortrait(), new q(this, headImageView));
                        }
                    }
                }
            }
            if (beVar.g()) {
                this.w.setEnabled(true);
                this.O.setEnabled(true);
                this.L.setVisibility(0);
                this.Q.setVisibility(0);
                this.N.setVisibility(0);
                if (beVar.a() != null) {
                    this.M.setText(beVar.a().getName());
                }
            } else {
                this.w.setEnabled(false);
                this.O.setEnabled(true);
                this.N.setVisibility(8);
                this.Q.setVisibility(8);
                this.h.setPadding(0, 0, 0, 0);
            }
            if (beVar.f()) {
                this.D.setVisibility(0);
                this.I.setVisibility(0);
                if (!this.U) {
                    this.B.setVisibility(8);
                }
                if (this.t.getParent() != this.D) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_paddingtb);
                    int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_side_paddinglr);
                    this.t.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, 0);
                    this.F.removeView(this.t);
                    this.D.addView(this.t, 1, layoutParams2);
                }
                t();
            } else {
                this.D.setVisibility(8);
                this.I.setVisibility(8);
                if (this.t.getParent() != this.F) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int dimensionPixelSize4 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_bigside_paddinglr);
                    this.t.setPadding(dimensionPixelSize4, 0, dimensionPixelSize4, 0);
                    this.D.removeView(this.t);
                    this.F.addView(this.t, 3, layoutParams3);
                }
                if (b(beVar.a().getFlag())) {
                    b(z);
                } else {
                    y();
                }
            }
            if (beVar.a().getGroupType() == 4 || beVar.a().getGroupType() == 5) {
                this.p.setVisibility(8);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelSize5 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_side_paddinglr);
                this.o.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                this.o.setLayoutParams(layoutParams4);
            } else {
                this.p.setVisibility(0);
            }
            b(beVar);
            if (beVar.a().getIsHidePosition() == 1) {
                a(beVar.g());
            } else {
                a(beVar.g(), this.J);
            }
        }
    }

    public void t() {
        if (TiebaApplication.h().an() == 1) {
            this.A.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_jinba_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.A.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_bottom_text_1));
            this.V.setBackgroundResource(R.drawable.group_info_foot_selector_1);
        } else {
            this.A.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
            this.A.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_bottom_text));
            this.V.setBackgroundResource(R.drawable.group_info_foot_selector);
        }
        this.A.setText(this.a.getString(R.string.group_info_enter_chat));
        this.V.setEnabled(true);
    }

    private void b(boolean z) {
        this.A.setText(this.a.getString(R.string.group_info_join));
        if (TiebaApplication.h().an() == 1) {
            if (z) {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.A.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_bottom_text_1));
            } else {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.A.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_join_disable_color_1));
            }
            this.V.setBackgroundResource(R.drawable.group_info_foot_selector_1);
        } else {
            if (z) {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
                this.A.setTextColor(this.a.getResources().getColorStateList(R.color.white));
            } else {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
                this.A.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_join_disable_color));
            }
            this.V.setBackgroundResource(R.drawable.group_info_foot_selector);
        }
        this.V.setEnabled(true);
    }

    private boolean b(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void y() {
        this.A.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.A.setText(this.a.getString(R.string.group_info_refuse_join));
        this.A.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_join_resuse_color));
        this.V.setBackgroundColor(0);
        this.V.setEnabled(false);
    }

    public void c(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.y.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.y.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.y.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void b(be beVar) {
        if (beVar != null) {
            this.k.setIsManager(beVar.g());
            if (beVar.g()) {
                this.k.setVisibility(0);
                if (beVar.c() != null && beVar.c().size() == 1 && TextUtils.isEmpty(beVar.c().get(0).getPicId())) {
                    this.k.setData(null);
                } else {
                    this.k.setData(beVar.c());
                }
            } else if (beVar.c() != null && beVar.c().size() > 0) {
                if (beVar.c().size() == 1 && TextUtils.isEmpty(beVar.c().get(0).getPicId())) {
                    this.k.setVisibility(8);
                    return;
                }
                this.k.setVisibility(0);
                this.k.setData(beVar.c());
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void a(x xVar) {
        this.H = xVar;
    }

    public void u() {
        if (this.m == null) {
            z();
        }
        this.m.show();
    }

    private void z() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.a.getResources().getString(R.string.take_photo), this.a.getResources().getString(R.string.album)}, this.l);
        this.m = builder.create();
        this.m.setCanceledOnTouchOutside(true);
    }

    public void a(Object obj, int i) {
        if (this.G != null) {
            this.G.dismiss();
            this.G = null;
        }
        b(obj, i);
        this.G.show();
    }

    public void v() {
        this.G.dismiss();
    }

    private void b(Object obj, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.a.getResources().getString(R.string.group_info_set_portrait), this.a.getResources().getString(R.string.delete), this.a.getResources().getString(R.string.cancel)}, new r(this, obj, i));
        this.G = builder.create();
        this.G.setCanceledOnTouchOutside(true);
    }

    public void w() {
        if (this.k != null) {
            this.k.a();
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.a.getString(R.string.copy_group_introduction)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setTitle(this.a.getString(R.string.operation));
            builder.setItems(charSequenceArr, new s(this, str));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
    }

    public void e(String str) {
        if (this.E == null) {
            g(str);
        }
        this.E.show();
    }

    private void g(String str) {
        if (this.E == null) {
            CharSequence[] charSequenceArr = {this.a.getString(R.string.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setTitle(this.a.getString(R.string.operation));
            builder.setItems(charSequenceArr, new t(this, str));
            this.E = builder.create();
            this.E.setCanceledOnTouchOutside(true);
        }
    }

    public void x() {
        ColorStateList colorStateList;
        Resources resources = this.a.getResources();
        if (TiebaApplication.h().an() == 1) {
            colorStateList = resources.getColorStateList(R.color.group_info_join_disable_color_1);
            if (colorStateList != null) {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else {
            colorStateList = resources.getColorStateList(R.color.group_info_join_disable_color);
            if (colorStateList != null) {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.A.setTextColor(colorStateList);
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.c);
        this.k.a(i, this.a);
        this.W.c(i);
    }
}
