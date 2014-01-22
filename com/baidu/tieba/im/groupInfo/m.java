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
import com.baidu.tieba.im.message.br;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.a.e {
    private LinearLayout A;
    private TextView B;
    private RelativeLayout C;
    private RelativeLayout D;
    private LinearLayout E;
    private Dialog F;
    private LinearLayout G;
    private Dialog H;
    private x I;
    private TextView J;
    private String K;
    private ImageView L;
    private RelativeLayout M;
    private TextView N;
    private ImageView O;
    private RelativeLayout P;
    private RelativeLayout Q;
    private ImageView R;
    private ImageView S;
    private View T;
    private TextView U;
    private TextView V;
    private boolean W;
    private LinearLayout X;
    private NavigationBar Y;
    private TextView Z;
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
    private ImageView v;
    private DialogInterface.OnClickListener w;
    private RelativeLayout x;
    private com.baidu.tieba.util.i y;
    private LinearLayout z;

    public m(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity);
        this.l = null;
        this.m = null;
        this.u = null;
        this.w = null;
        this.K = "";
        this.W = true;
        this.a = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.y = new com.baidu.tieba.util.i(groupInfoActivity);
        this.y.d(false);
        a(groupInfoActivity);
        b(groupInfoActivity);
        c(groupInfoActivity);
    }

    public void a(String str) {
        this.N.setText(str);
        f(str);
    }

    private void f(String str) {
        this.Z = this.Y.a(str);
    }

    public void b(String str) {
        this.h.setText(str);
    }

    private void a(GroupInfoActivity groupInfoActivity) {
        this.Y = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.Z = this.Y.a("");
        this.d = this.Y.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupInfoActivity);
        this.J = this.Y.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupInfoActivity.getString(R.string.setup));
        this.J.setOnClickListener(groupInfoActivity);
        this.J.setVisibility(8);
    }

    private void b(GroupInfoActivity groupInfoActivity) {
        this.c = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.x = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.x.setOnClickListener(groupInfoActivity);
        this.G = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.L = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.f = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.g = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.R = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
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
        this.v = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.T = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.q = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.j.setOnClickListener(groupInfoActivity);
        this.p = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.p.setOnClickListener(groupInfoActivity);
        this.s = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.t = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.t.setOnClickListener(groupInfoActivity);
        this.z = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.A = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.X = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.B = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.X.setOnClickListener(this.a);
        this.C = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_share);
        this.C.setOnClickListener(groupInfoActivity);
        this.D = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.D.setOnClickListener(groupInfoActivity);
        this.E = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.M = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.M.setOnClickListener(groupInfoActivity);
        this.N = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.O = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.S = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.P = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.P.setOnClickListener(groupInfoActivity);
        this.P.setOnClickListener(groupInfoActivity);
        this.P.setLongClickable(true);
        this.P.setOnLongClickListener(groupInfoActivity);
        this.U = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.U.setClickable(true);
        this.U.setOnClickListener(new o(this));
        this.Q = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.Q.setOnLongClickListener(groupInfoActivity);
        this.V = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.e = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
    }

    private void c(GroupInfoActivity groupInfoActivity) {
        this.k = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.k.setPhotoClickListener(groupInfoActivity);
        this.k.setPhotoLongClickListener(groupInfoActivity);
        this.k.setVisibility(8);
    }

    public RelativeLayout a() {
        return this.Q;
    }

    public RelativeLayout e() {
        return this.j;
    }

    public LinearLayout f() {
        return this.z;
    }

    public RelativeLayout g() {
        return this.C;
    }

    public RelativeLayout h() {
        return this.D;
    }

    public RelativeLayout i() {
        return this.P;
    }

    public RelativeLayout j() {
        return this.M;
    }

    public TextView k() {
        return this.J;
    }

    public LinearLayout l() {
        return this.X;
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
            this.x.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.x.setVisibility(8);
        } else {
            this.g.setText(str);
            this.x.setVisibility(0);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.g.setText(this.b.getString(R.string.group_info_address_hide));
        } else {
            this.x.setVisibility(8);
        }
    }

    public RelativeLayout s() {
        return this.x;
    }

    public void a(br brVar) {
        a(brVar, false);
    }

    public void a(br brVar, boolean z) {
        if (brVar != null) {
            if (TiebaApplication.h().al() == 1) {
            }
            this.G.setVisibility(0);
            this.A.setVisibility(0);
            if (brVar.a() != null) {
                f(brVar.a().getName());
                this.f.setText(String.valueOf(brVar.a().getGroupId()));
                if (brVar.a().isMeizhi()) {
                    this.v.setVisibility(0);
                } else {
                    this.v.setVisibility(8);
                }
                if (brVar.a().getGroupType() == 4) {
                    this.L.setVisibility(0);
                    this.r.setVisibility(8);
                    this.S.setVisibility(8);
                    this.T.setVisibility(8);
                    this.n.setText(R.string.group_info_forum_author);
                    this.o.setEnabled(false);
                    this.v.setVisibility(8);
                } else {
                    this.L.setVisibility(8);
                    this.r.setVisibility(0);
                    this.S.setVisibility(0);
                    this.T.setVisibility(0);
                    this.n.setText(brVar.a().getAuthorName());
                    this.o.setEnabled(true);
                }
                String position = brVar.a().getPosition();
                String business = brVar.a().getBusiness();
                StringBuffer stringBuffer = new StringBuffer();
                if (position != null) {
                    stringBuffer.append(position);
                }
                if (business != null) {
                    stringBuffer.append(business);
                }
                this.K = stringBuffer.toString();
                this.g.setText(this.K);
                this.h.setText(brVar.a().getIntro());
                this.s.setText("(" + brVar.a().getMemberNum() + "/" + brVar.a().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(brVar.a().getAuthorPortrait())) {
                    this.y.c(brVar.a().getAuthorPortrait(), new p(this));
                }
                if (brVar.a().getForumName() != null && brVar.a().getForumName().length() > 0) {
                    this.j.setVisibility(0);
                    this.i.setText(brVar.a().getForumName() + this.a.getString(R.string.bar));
                } else {
                    this.j.setVisibility(8);
                }
                this.q.removeAllViews();
                boolean j = brVar.j();
                boolean i = brVar.i();
                if (i) {
                    bs.a(this.Z, R.color.im_group_vip_text, 1);
                }
                if (brVar.a().getGrade() > 0) {
                    for (int i2 = 0; i2 < brVar.a().getGrade(); i2++) {
                        ImageView imageView = new ImageView(this.a);
                        if (i) {
                            bs.d(imageView, (int) R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            bs.d(imageView, (int) R.drawable.icon_grade_middle_star_s);
                        }
                        this.q.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.a);
                    if (i) {
                        bs.d(imageView2, (int) R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        bs.d(imageView2, (int) R.drawable.icon_grade_middle_star_n);
                    }
                    this.q.addView(imageView2);
                }
                if (j) {
                    this.V.setVisibility(0);
                } else {
                    this.V.setVisibility(8);
                }
            }
            this.z.removeAllViews();
            if (brVar.b() != null && brVar.b().size() > 0) {
                List<MemberData> b = brVar.b();
                int size = b.size();
                int i3 = size > 7 ? 7 : size;
                for (int i4 = 0; i4 < i3; i4++) {
                    MemberData memberData = b.get(i4);
                    HeadImageView headImageView = new HeadImageView(this.a);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(true);
                    headImageView.setTag(String.valueOf(memberData.getUserId()));
                    int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_photo_width);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_photo_margin);
                    this.z.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        com.baidu.adp.widget.ImageView.d c = this.y.c(memberData.getPortrait());
                        if (c != null) {
                            c.a(headImageView);
                        } else {
                            this.y.c(memberData.getPortrait(), new q(this, headImageView));
                        }
                    }
                }
            }
            if (brVar.g()) {
                this.x.setEnabled(true);
                this.P.setEnabled(true);
                this.M.setVisibility(0);
                this.R.setVisibility(0);
                this.O.setVisibility(0);
                if (brVar.a() != null) {
                    this.N.setText(brVar.a().getName());
                }
            } else {
                this.x.setEnabled(false);
                this.P.setEnabled(true);
                this.O.setVisibility(8);
                this.R.setVisibility(8);
                this.h.setPadding(0, 0, 0, 0);
            }
            if (brVar.f()) {
                this.E.setVisibility(0);
                this.J.setVisibility(0);
                if (!this.W) {
                    this.C.setVisibility(8);
                }
                if (this.t.getParent() != this.E) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_paddingtb);
                    int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_side_paddinglr);
                    this.t.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, 0);
                    this.G.removeView(this.t);
                    this.E.addView(this.t, 1, layoutParams2);
                }
                t();
            } else {
                this.E.setVisibility(8);
                this.J.setVisibility(8);
                if (this.t.getParent() != this.G) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int dimensionPixelSize4 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_bigside_paddinglr);
                    this.t.setPadding(dimensionPixelSize4, 0, dimensionPixelSize4, 0);
                    this.E.removeView(this.t);
                    this.G.addView(this.t, 3, layoutParams3);
                }
                if (b(brVar.a().getFlag())) {
                    b(z);
                } else {
                    y();
                }
            }
            if (brVar.a().getGroupType() == 4 || brVar.a().getGroupType() == 5) {
                this.p.setVisibility(8);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelSize5 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_side_paddinglr);
                this.o.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                this.o.setLayoutParams(layoutParams4);
            } else {
                this.p.setVisibility(0);
            }
            b(brVar);
            if (brVar.a().getIsHidePosition() == 1) {
                a(brVar.g());
            } else {
                a(brVar.g(), this.K);
            }
        }
    }

    public void t() {
        if (TiebaApplication.h().al() == 1) {
            this.B.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_jinba_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.B.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_bottom_text_1));
            this.X.setBackgroundResource(R.drawable.group_info_foot_selector_1);
        } else {
            this.B.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
            this.B.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_bottom_text));
            this.X.setBackgroundResource(R.drawable.group_info_foot_selector);
        }
        this.B.setText(this.a.getString(R.string.group_info_enter_chat));
        this.X.setEnabled(true);
    }

    private void b(boolean z) {
        this.B.setText(this.a.getString(R.string.group_info_join));
        if (TiebaApplication.h().al() == 1) {
            if (z) {
                this.B.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.B.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_bottom_text_1));
            } else {
                this.B.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.B.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_join_disable_color_1));
            }
            this.X.setBackgroundResource(R.drawable.group_info_foot_selector_1);
        } else {
            if (z) {
                this.B.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
                this.B.setTextColor(this.a.getResources().getColorStateList(R.color.white));
            } else {
                this.B.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
                this.B.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_join_disable_color));
            }
            this.X.setBackgroundResource(R.drawable.group_info_foot_selector);
        }
        this.X.setEnabled(true);
    }

    private boolean b(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void y() {
        this.B.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.B.setText(this.a.getString(R.string.group_info_refuse_join));
        this.B.setTextColor(this.a.getResources().getColorStateList(R.color.group_info_join_resuse_color));
        this.X.setBackgroundColor(0);
        this.X.setEnabled(false);
    }

    public void c(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.z.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.z.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.z.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void b(br brVar) {
        if (brVar != null) {
            this.k.setIsManager(brVar.g());
            if (brVar.g()) {
                this.k.setVisibility(0);
                if (brVar.c() != null && brVar.c().size() == 1 && TextUtils.isEmpty(brVar.c().get(0).getPicId())) {
                    this.k.setData(null);
                } else {
                    this.k.setData(brVar.c());
                }
            } else if (brVar.c() != null && brVar.c().size() > 0) {
                if (brVar.c().size() == 1 && TextUtils.isEmpty(brVar.c().get(0).getPicId())) {
                    this.k.setVisibility(8);
                    return;
                }
                this.k.setVisibility(0);
                this.k.setData(brVar.c());
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void a(x xVar) {
        this.I = xVar;
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
        if (this.H != null) {
            this.H.dismiss();
            this.H = null;
        }
        b(obj, i);
        this.H.show();
    }

    public void v() {
        this.H.dismiss();
    }

    private void b(Object obj, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.a.getResources().getString(R.string.group_info_set_portrait), this.a.getResources().getString(R.string.delete), this.a.getResources().getString(R.string.cancel)}, new r(this, obj, i));
        this.H = builder.create();
        this.H.setCanceledOnTouchOutside(true);
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
        if (this.F == null) {
            g(str);
        }
        this.F.show();
    }

    private void g(String str) {
        if (this.F == null) {
            CharSequence[] charSequenceArr = {this.a.getString(R.string.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setTitle(this.a.getString(R.string.operation));
            builder.setItems(charSequenceArr, new t(this, str));
            this.F = builder.create();
            this.F.setCanceledOnTouchOutside(true);
        }
    }

    public void x() {
        ColorStateList colorStateList;
        Resources resources = this.a.getResources();
        if (TiebaApplication.h().al() == 1) {
            colorStateList = resources.getColorStateList(R.color.group_info_join_disable_color_1);
            if (colorStateList != null) {
                this.B.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else {
            colorStateList = resources.getColorStateList(R.color.group_info_join_disable_color);
            if (colorStateList != null) {
                this.B.setCompoundDrawablesWithIntrinsicBounds(this.a.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.B.setTextColor(colorStateList);
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.c);
        this.k.a(i, this.a);
        this.Y.c(i);
    }
}
