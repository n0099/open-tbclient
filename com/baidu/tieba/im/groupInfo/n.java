package com.baidu.tieba.im.groupInfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.e {
    private RelativeLayout A;
    private LinearLayout B;
    private Dialog C;
    private LinearLayout D;
    private Dialog E;
    private y F;
    private TextView G;
    private String H;
    private ImageView I;
    private RelativeLayout J;
    private TextView K;
    private ImageView L;
    private RelativeLayout M;
    private RelativeLayout N;
    private ImageView O;
    private ImageView P;
    private TextView Q;
    private boolean R;
    private LinearLayout S;
    private NavigationBar T;

    /* renamed from: a  reason: collision with root package name */
    private GroupInfoActivity f1696a;
    private ImageView c;
    private ProgressBar d;
    private TextView e;
    private TextView f;
    private EllipsizingTextView g;
    private TextView h;
    private RelativeLayout i;
    private PhotoWallView j;
    private DialogInterface.OnClickListener k;
    private Dialog l;
    private TextView m;
    private RelativeLayout n;
    private RelativeLayout o;
    private LinearLayout p;
    private HeadImageView q;
    private TextView r;
    private RelativeLayout s;
    private AlertDialog t;
    private DialogInterface.OnClickListener u;
    private RelativeLayout v;
    private com.baidu.tieba.util.i w;
    private LinearLayout x;
    private LinearLayout y;
    private TextView z;

    public n(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity);
        this.k = null;
        this.l = null;
        this.t = null;
        this.u = null;
        this.H = null;
        this.R = true;
        this.f1696a = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.w = new com.baidu.tieba.util.i(groupInfoActivity);
        this.w.d(false);
        a(groupInfoActivity);
        b(groupInfoActivity);
        c(groupInfoActivity);
    }

    public void a(String str) {
        this.K.setText(str);
        f(str);
    }

    private void f(String str) {
        this.T.a(com.baidu.adp.lib.h.f.a(this.T.a(str).getPaint(), str, com.baidu.adp.lib.h.f.a(this.f1696a) - com.baidu.adp.lib.h.f.a(this.b, 184)));
    }

    public void b(String str) {
        this.g.setText(str);
    }

    private void a(GroupInfoActivity groupInfoActivity) {
        this.T = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.c = this.T.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupInfoActivity);
        this.G = this.T.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupInfoActivity.getString(R.string.setup));
        this.G.setOnClickListener(groupInfoActivity);
    }

    private void b(GroupInfoActivity groupInfoActivity) {
        this.v = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.v.setOnClickListener(groupInfoActivity);
        this.D = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.I = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.e = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.f = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.O = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.g = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.g.setMaxLines(20);
        this.g.a(new o(this));
        this.i = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.h = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.i.setOnClickListener(groupInfoActivity);
        this.q = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.q.setAutoChangeStyle(false);
        this.m = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.n = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.n.setOnClickListener(groupInfoActivity);
        this.p = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.i.setOnClickListener(groupInfoActivity);
        this.o = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.o.setOnClickListener(groupInfoActivity);
        this.r = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.s = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.s.setOnClickListener(groupInfoActivity);
        this.x = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.x.setOnClickListener(groupInfoActivity);
        ((HorizontalScrollView) groupInfoActivity.findViewById(R.id.scr_group_member_photo)).setHorizontalScrollBarEnabled(false);
        this.y = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.S = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.z = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.S.setOnClickListener(this.f1696a);
        this.A = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_share);
        this.A.setOnClickListener(groupInfoActivity);
        this.B = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.J = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.J.setOnClickListener(groupInfoActivity);
        this.K = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.L = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.P = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.M = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.M.setOnClickListener(groupInfoActivity);
        this.M.setOnClickListener(groupInfoActivity);
        this.M.setLongClickable(true);
        this.M.setOnLongClickListener(groupInfoActivity);
        this.Q = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.Q.setClickable(true);
        this.Q.setOnClickListener(new p(this));
        this.N = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.N.setOnLongClickListener(groupInfoActivity);
        this.d = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
    }

    private void c(GroupInfoActivity groupInfoActivity) {
        this.j = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.j.setPhotoClickListener(groupInfoActivity);
        this.j.setPhotoLongClickListener(groupInfoActivity);
        this.j.setVisibility(8);
    }

    public RelativeLayout a() {
        return this.N;
    }

    public RelativeLayout e() {
        return this.i;
    }

    public LinearLayout f() {
        return this.x;
    }

    public RelativeLayout g() {
        return this.A;
    }

    public RelativeLayout h() {
        return this.M;
    }

    public RelativeLayout i() {
        return this.J;
    }

    public TextView j() {
        return this.G;
    }

    public LinearLayout k() {
        return this.S;
    }

    public RelativeLayout l() {
        return this.n;
    }

    public RelativeLayout m() {
        return this.o;
    }

    public RelativeLayout n() {
        return this.s;
    }

    public ImageView o() {
        return this.c;
    }

    public void p() {
        this.d.setVisibility(8);
    }

    public void q() {
        this.d.setVisibility(0);
    }

    public void a(boolean z) {
        if (z) {
            this.f.setText(this.H);
            this.v.setVisibility(0);
            return;
        }
        this.f.setText(this.H);
        this.v.setVisibility(0);
    }

    public void b(boolean z) {
        if (z) {
            this.f.setText("");
        } else {
            this.v.setVisibility(8);
        }
    }

    public RelativeLayout r() {
        return this.v;
    }

    public void a(ResponseGroupInfoMessage responseGroupInfoMessage) {
        a(responseGroupInfoMessage, false);
    }

    public void a(ResponseGroupInfoMessage responseGroupInfoMessage, boolean z) {
        if (responseGroupInfoMessage != null) {
            this.D.setVisibility(0);
            this.y.setVisibility(0);
            if (responseGroupInfoMessage.getGroup() != null) {
                f(responseGroupInfoMessage.getGroup().getName());
                this.e.setText(String.valueOf(responseGroupInfoMessage.getGroup().getGroupId()));
                if (responseGroupInfoMessage.getGroup().getGroupType() == 4) {
                    this.I.setVisibility(0);
                    this.q.setVisibility(8);
                    this.P.setVisibility(8);
                    this.m.setText(R.string.group_info_forum_author);
                    this.n.setEnabled(false);
                } else {
                    this.I.setVisibility(8);
                    this.q.setVisibility(0);
                    this.P.setVisibility(0);
                    this.m.setText(responseGroupInfoMessage.getGroup().getAuthorName());
                    this.n.setEnabled(true);
                }
                this.H = responseGroupInfoMessage.getGroup().getPosition();
                this.f.setText(this.H);
                this.g.setText(responseGroupInfoMessage.getGroup().getIntro());
                this.r.setText("(" + responseGroupInfoMessage.getGroup().getMemberNum() + "/" + responseGroupInfoMessage.getGroup().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(responseGroupInfoMessage.getGroup().getAuthorPortrait())) {
                    com.baidu.adp.widget.ImageView.e c = this.w.c(responseGroupInfoMessage.getGroup().getAuthorPortrait());
                    if (c != null) {
                        c.a(this.q);
                    } else {
                        this.w.b(responseGroupInfoMessage.getGroup().getAuthorPortrait(), new q(this));
                    }
                }
                if (responseGroupInfoMessage.getGroup().getForumName() != null && responseGroupInfoMessage.getGroup().getForumName().length() > 0) {
                    this.i.setVisibility(0);
                    this.h.setText(responseGroupInfoMessage.getGroup().getForumName() + this.f1696a.getString(R.string.bar));
                } else {
                    this.i.setVisibility(8);
                }
                this.p.removeAllViews();
                if (responseGroupInfoMessage.getGroup().getGrade() > 0) {
                    for (int i = 0; i < responseGroupInfoMessage.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.f1696a);
                        imageView.setImageResource(R.drawable.icon_grade_middle_star_s);
                        this.p.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.f1696a);
                    imageView2.setImageResource(R.drawable.icon_grade_middle_star_n);
                    this.p.addView(imageView2);
                }
            }
            this.x.removeAllViews();
            if (responseGroupInfoMessage.getMembers() != null && responseGroupInfoMessage.getMembers().size() > 0) {
                List<MemberData> members = responseGroupInfoMessage.getMembers();
                int size = members.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MemberData memberData = members.get(i2);
                    HeadImageView headImageView = new HeadImageView(this.f1696a);
                    headImageView.setAutoChangeStyle(false);
                    headImageView.setTag(String.valueOf(memberData.getUserId()));
                    int a2 = UtilHelper.a((Context) this.f1696a, 35.0f);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
                    layoutParams.rightMargin = UtilHelper.a((Context) this.f1696a, 5.0f);
                    this.x.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        com.baidu.adp.widget.ImageView.e c2 = this.w.c(memberData.getPortrait());
                        if (c2 != null) {
                            c2.a(headImageView);
                        } else {
                            this.w.b(memberData.getPortrait(), new r(this, headImageView));
                        }
                    }
                }
            }
            if (responseGroupInfoMessage.isGroupManager()) {
                this.v.setEnabled(true);
                this.M.setEnabled(true);
                this.J.setVisibility(0);
                this.O.setVisibility(0);
                this.L.setVisibility(0);
                if (responseGroupInfoMessage.getGroup() != null) {
                    this.K.setText(responseGroupInfoMessage.getGroup().getName());
                }
                this.g.setPadding(0, 0, UtilHelper.a((Context) this.f1696a, 16.0f), 0);
            } else {
                this.v.setEnabled(false);
                this.M.setEnabled(true);
                this.L.setVisibility(8);
                this.O.setVisibility(8);
                this.g.setPadding(0, 0, 0, 0);
            }
            if (responseGroupInfoMessage.isJoin()) {
                this.B.setVisibility(0);
                this.G.setVisibility(0);
                if (!this.R) {
                    this.A.setVisibility(8);
                }
                if (this.s.getParent() != this.B) {
                    if (responseGroupInfoMessage.isGroupManager()) {
                        if (this.R) {
                            this.s.setBackgroundResource(R.drawable.more_middle);
                        } else {
                            this.s.setBackgroundResource(R.drawable.more_down);
                        }
                    } else if (this.R) {
                        this.s.setBackgroundResource(R.drawable.more_up);
                    } else {
                        this.s.setBackgroundResource(R.drawable.more_all);
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, UtilHelper.a((Context) this.f1696a, 90.0f));
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.topMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int a3 = UtilHelper.a((Context) this.f1696a, 13.0f);
                    int a4 = UtilHelper.a((Context) this.f1696a, 10.0f);
                    this.s.setPadding(a4, a3, a4, 0);
                    this.D.removeView(this.s);
                    this.B.addView(this.s, 1, layoutParams2);
                }
                s();
            } else {
                this.B.setVisibility(8);
                this.G.setVisibility(8);
                if (this.s.getParent() != this.D) {
                    this.s.setBackgroundResource(R.drawable.more_all);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, UtilHelper.a((Context) this.f1696a, 87.0f));
                    layoutParams3.rightMargin = UtilHelper.a((Context) this.f1696a, 10.0f);
                    layoutParams3.leftMargin = UtilHelper.a((Context) this.f1696a, 10.0f);
                    layoutParams3.topMargin = 0;
                    layoutParams3.bottomMargin = UtilHelper.a((Context) this.f1696a, 10.0f);
                    int a5 = UtilHelper.a((Context) this.f1696a, 13.0f);
                    int a6 = UtilHelper.a((Context) this.f1696a, 10.0f);
                    this.s.setPadding(a6, a5, a6, 0);
                    this.B.removeView(this.s);
                    this.D.addView(this.s, 3, layoutParams3);
                }
                if (b(responseGroupInfoMessage.getGroup().getFlag())) {
                    c(z);
                } else {
                    y();
                }
            }
            if (responseGroupInfoMessage.getGroup().getGroupType() == 4 || responseGroupInfoMessage.getGroup().getGroupType() == 5) {
                this.o.setVisibility(8);
                this.n.setBackgroundResource(R.drawable.more_all);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, UtilHelper.a((Context) this.f1696a, 54.0f));
                int a7 = UtilHelper.a((Context) this.f1696a, 10.0f);
                this.n.setPadding(a7, 0, a7, 0);
                this.n.setLayoutParams(layoutParams4);
            } else {
                this.o.setVisibility(0);
            }
            b(responseGroupInfoMessage);
            if (responseGroupInfoMessage.getGroup().getIsHidePosition() == 1) {
                b(responseGroupInfoMessage.isGroupManager());
            } else {
                a(responseGroupInfoMessage.isGroupManager());
            }
            if (TextUtils.isEmpty(responseGroupInfoMessage.getGroup().getPosition())) {
                this.v.setVisibility(8);
            }
        }
    }

    public void s() {
        this.z.setCompoundDrawablesWithIntrinsicBounds(this.f1696a.getResources().getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        this.z.setText(this.f1696a.getString(R.string.group_info_enter_chat));
        this.z.setTextColor(this.f1696a.getResources().getColorStateList(R.color.white));
        this.S.setBackgroundResource(R.drawable.group_info_foot_selector);
        this.S.setEnabled(true);
    }

    private void c(boolean z) {
        this.z.setText(this.f1696a.getString(R.string.group_info_join));
        if (z) {
            this.z.setCompoundDrawablesWithIntrinsicBounds(this.f1696a.getResources().getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            this.z.setTextColor(this.f1696a.getResources().getColorStateList(R.color.white));
        } else {
            this.z.setCompoundDrawablesWithIntrinsicBounds(this.f1696a.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            this.z.setTextColor(this.f1696a.getResources().getColorStateList(R.color.group_info_join_disable_color));
        }
        this.S.setBackgroundResource(R.drawable.group_info_foot_selector);
        this.S.setEnabled(true);
    }

    private boolean b(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void y() {
        this.z.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.z.setText(this.f1696a.getString(R.string.group_info_refuse_join));
        this.z.setTextColor(this.f1696a.getResources().getColorStateList(R.color.group_info_join_resuse_color));
        this.S.setBackgroundColor(0);
        this.S.setEnabled(false);
    }

    public void c(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.x.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.x.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.x.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void b(ResponseGroupInfoMessage responseGroupInfoMessage) {
        if (responseGroupInfoMessage != null) {
            this.j.setIsManager(responseGroupInfoMessage.isGroupManager());
            if (responseGroupInfoMessage.isGroupManager()) {
                this.j.setVisibility(0);
                if (responseGroupInfoMessage.getPhotos() != null && responseGroupInfoMessage.getPhotos().size() == 1 && TextUtils.isEmpty(responseGroupInfoMessage.getPhotos().get(0).getPicId())) {
                    this.j.setData(null);
                } else {
                    this.j.setData(responseGroupInfoMessage.getPhotos());
                }
            } else if (responseGroupInfoMessage.getPhotos() != null && responseGroupInfoMessage.getPhotos().size() > 0) {
                if (responseGroupInfoMessage.getPhotos().size() == 1 && TextUtils.isEmpty(responseGroupInfoMessage.getPhotos().get(0).getPicId())) {
                    this.j.setVisibility(8);
                    return;
                }
                this.j.setVisibility(0);
                this.j.setData(responseGroupInfoMessage.getPhotos());
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void a(y yVar) {
        this.F = yVar;
    }

    public void t() {
        if (this.l == null) {
            z();
        }
        this.l.show();
    }

    private void z() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1696a);
        builder.setTitle(this.f1696a.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.f1696a.getResources().getString(R.string.take_photo), this.f1696a.getResources().getString(R.string.album)}, this.k);
        this.l = builder.create();
        this.l.setCanceledOnTouchOutside(true);
    }

    public void a(Object obj, int i) {
        if (this.E != null) {
            this.E.dismiss();
            this.E = null;
        }
        b(obj, i);
        this.E.show();
    }

    public void u() {
        this.E.dismiss();
    }

    private void b(Object obj, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1696a);
        builder.setTitle(this.f1696a.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.f1696a.getResources().getString(R.string.group_info_set_portrait), this.f1696a.getResources().getString(R.string.delete), this.f1696a.getResources().getString(R.string.cancel)}, new s(this, obj, i));
        this.E = builder.create();
        this.E.setCanceledOnTouchOutside(true);
    }

    public void v() {
        if (this.j != null) {
            this.j.a();
        }
    }

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public void w() {
        if (this.t == null) {
            this.t = new AlertDialog.Builder(this.f1696a).setTitle(R.string.group_address_option).setItems(new CharSequence[]{new SpannableString(this.f1696a.getString(R.string.group_address_show)), new SpannableString(this.f1696a.getString(R.string.group_address_hide))}, this.u).create();
        }
        this.t.setCanceledOnTouchOutside(true);
        this.t.show();
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.f1696a.getString(R.string.copy_group_introduction)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f1696a);
            builder.setTitle(this.f1696a.getString(R.string.operation));
            builder.setItems(charSequenceArr, new t(this, str));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
    }

    public void e(String str) {
        if (this.C == null) {
            g(str);
        }
        this.C.show();
    }

    private void g(String str) {
        if (this.C == null) {
            CharSequence[] charSequenceArr = {this.f1696a.getString(R.string.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f1696a);
            builder.setTitle(this.f1696a.getString(R.string.operation));
            builder.setItems(charSequenceArr, new u(this, str));
            this.C = builder.create();
            this.C.setCanceledOnTouchOutside(true);
        }
    }

    public void x() {
        ColorStateList colorStateList = this.f1696a.getResources().getColorStateList(R.color.group_info_join_disable_color);
        if (colorStateList != null) {
            this.z.setCompoundDrawablesWithIntrinsicBounds(this.f1696a.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            this.z.setTextColor(colorStateList);
        }
    }

    public void a(int i) {
        this.T.c(0);
    }
}
