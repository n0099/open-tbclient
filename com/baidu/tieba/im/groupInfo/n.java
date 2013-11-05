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
import android.widget.Button;
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
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.e {
    private TextView A;
    private RelativeLayout B;
    private LinearLayout C;
    private Dialog D;
    private LinearLayout E;
    private Dialog F;
    private y G;
    private Button H;
    private String I;
    private ImageView J;
    private RelativeLayout K;
    private TextView L;
    private ImageView M;
    private RelativeLayout N;
    private RelativeLayout O;
    private ImageView P;
    private ImageView Q;
    private TextView R;
    private boolean S;
    private LinearLayout T;

    /* renamed from: a  reason: collision with root package name */
    private GroupInfoActivity f1609a;
    private ImageView c;
    private ProgressBar d;
    private TextView e;
    private TextView f;
    private EllipsizingTextView g;
    private TextView h;
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
    private com.baidu.tieba.util.a x;
    private LinearLayout y;
    private LinearLayout z;

    public n(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity);
        this.l = null;
        this.m = null;
        this.u = null;
        this.v = null;
        this.I = null;
        this.S = true;
        this.f1609a = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.x = new com.baidu.tieba.util.a(groupInfoActivity);
        this.x.d(false);
        a(groupInfoActivity);
        b(groupInfoActivity);
        c(groupInfoActivity);
    }

    public void a(String str) {
        this.L.setText(str);
        f(str);
    }

    private void f(String str) {
        this.h.setText(com.baidu.adp.lib.h.f.a(this.h.getPaint(), str, com.baidu.adp.lib.h.f.a(this.f1609a) - com.baidu.adp.lib.h.f.a(this.b, 184)));
    }

    public void b(String str) {
        this.g.setText(str);
    }

    private void a(GroupInfoActivity groupInfoActivity) {
        this.c = (ImageView) groupInfoActivity.findViewById(R.id.title_back);
        this.c.setOnClickListener(groupInfoActivity);
        this.H = (Button) groupInfoActivity.findViewById(R.id.btn_setting);
        this.H.setOnClickListener(groupInfoActivity);
    }

    private void b(GroupInfoActivity groupInfoActivity) {
        this.w = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.w.setOnClickListener(groupInfoActivity);
        this.h = (TextView) groupInfoActivity.findViewById(R.id.title_name);
        this.E = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.J = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.e = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.f = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.P = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.g = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.g.setMaxLines(20);
        this.g.a(new o(this));
        this.j = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.i = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.j.setOnClickListener(groupInfoActivity);
        this.r = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.r.setAutoChangeStyle(false);
        this.n = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.o = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.o.setOnClickListener(groupInfoActivity);
        this.q = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.j.setOnClickListener(groupInfoActivity);
        this.p = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.p.setOnClickListener(groupInfoActivity);
        this.s = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.t = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.t.setOnClickListener(groupInfoActivity);
        this.y = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.y.setOnClickListener(groupInfoActivity);
        ((HorizontalScrollView) groupInfoActivity.findViewById(R.id.scr_group_member_photo)).setHorizontalScrollBarEnabled(false);
        this.z = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.T = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.A = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.T.setOnClickListener(this.f1609a);
        this.B = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_share);
        this.B.setOnClickListener(groupInfoActivity);
        this.C = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.K = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.K.setOnClickListener(groupInfoActivity);
        this.L = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.M = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.Q = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.N = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.N.setOnClickListener(groupInfoActivity);
        this.N.setOnClickListener(groupInfoActivity);
        this.N.setLongClickable(true);
        this.N.setOnLongClickListener(groupInfoActivity);
        this.R = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.R.setClickable(true);
        this.R.setOnClickListener(new p(this));
        this.O = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.O.setOnLongClickListener(groupInfoActivity);
        this.d = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
    }

    private void c(GroupInfoActivity groupInfoActivity) {
        this.k = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.k.setPhotoClickListener(groupInfoActivity);
        this.k.setPhotoLongClickListener(groupInfoActivity);
        this.k.setVisibility(8);
    }

    public RelativeLayout a() {
        return this.O;
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
        return this.N;
    }

    public RelativeLayout i() {
        return this.K;
    }

    public Button j() {
        return this.H;
    }

    public LinearLayout k() {
        return this.T;
    }

    public RelativeLayout l() {
        return this.o;
    }

    public RelativeLayout m() {
        return this.p;
    }

    public RelativeLayout n() {
        return this.t;
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
            this.f.setText(this.I);
            this.w.setVisibility(0);
            return;
        }
        this.f.setText(this.I);
        this.w.setVisibility(0);
    }

    public void b(boolean z) {
        if (z) {
            this.f.setText("");
        } else {
            this.w.setVisibility(8);
        }
    }

    public RelativeLayout r() {
        return this.w;
    }

    public void a(ResponseGroupInfoMessage responseGroupInfoMessage) {
        a(responseGroupInfoMessage, false);
    }

    public void a(ResponseGroupInfoMessage responseGroupInfoMessage, boolean z) {
        if (responseGroupInfoMessage != null) {
            this.E.setVisibility(0);
            this.z.setVisibility(0);
            if (responseGroupInfoMessage.getGroup() != null) {
                f(responseGroupInfoMessage.getGroup().getName());
                this.e.setText(String.valueOf(responseGroupInfoMessage.getGroup().getGroupId()));
                if (responseGroupInfoMessage.getGroup().getGroupType() == 4) {
                    this.J.setVisibility(0);
                    this.r.setVisibility(8);
                    this.Q.setVisibility(8);
                    this.n.setText(R.string.group_info_forum_author);
                    this.o.setEnabled(false);
                } else {
                    this.J.setVisibility(8);
                    this.r.setVisibility(0);
                    this.Q.setVisibility(0);
                    this.n.setText(responseGroupInfoMessage.getGroup().getAuthorName());
                    this.o.setEnabled(true);
                }
                this.I = responseGroupInfoMessage.getGroup().getPosition();
                this.f.setText(this.I);
                this.g.setText(responseGroupInfoMessage.getGroup().getIntro());
                this.s.setText("(" + responseGroupInfoMessage.getGroup().getMemberNum() + "/" + responseGroupInfoMessage.getGroup().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(responseGroupInfoMessage.getGroup().getAuthorPortrait())) {
                    com.baidu.adp.widget.ImageView.e c = this.x.c(responseGroupInfoMessage.getGroup().getAuthorPortrait());
                    if (c != null) {
                        c.a(this.r);
                    } else {
                        this.x.b(responseGroupInfoMessage.getGroup().getAuthorPortrait(), new q(this));
                    }
                }
                if (responseGroupInfoMessage.getGroup().getForumName() != null && responseGroupInfoMessage.getGroup().getForumName().length() > 0) {
                    this.j.setVisibility(0);
                    this.i.setText(responseGroupInfoMessage.getGroup().getForumName() + this.f1609a.getString(R.string.bar));
                } else {
                    this.j.setVisibility(8);
                }
                this.q.removeAllViews();
                if (responseGroupInfoMessage.getGroup().getGrade() > 0) {
                    for (int i = 0; i < responseGroupInfoMessage.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.f1609a);
                        imageView.setImageResource(R.drawable.icon_grade_middle_star_s);
                        this.q.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.f1609a);
                    imageView2.setImageResource(R.drawable.icon_grade_middle_star_n);
                    this.q.addView(imageView2);
                }
            }
            this.y.removeAllViews();
            if (responseGroupInfoMessage.getMembers() != null && responseGroupInfoMessage.getMembers().size() > 0) {
                List<MemberData> members = responseGroupInfoMessage.getMembers();
                int size = members.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MemberData memberData = members.get(i2);
                    HeadImageView headImageView = new HeadImageView(this.f1609a);
                    headImageView.setAutoChangeStyle(false);
                    headImageView.setTag(String.valueOf(memberData.getUserId()));
                    int a2 = UtilHelper.a((Context) this.f1609a, 35.0f);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
                    layoutParams.rightMargin = UtilHelper.a((Context) this.f1609a, 5.0f);
                    this.y.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        com.baidu.adp.widget.ImageView.e c2 = this.x.c(memberData.getPortrait());
                        if (c2 != null) {
                            c2.a(headImageView);
                        } else {
                            this.x.b(memberData.getPortrait(), new r(this, headImageView));
                        }
                    }
                }
            }
            if (responseGroupInfoMessage.isGroupManager()) {
                this.w.setEnabled(true);
                this.N.setEnabled(true);
                this.K.setVisibility(0);
                this.P.setVisibility(0);
                this.M.setVisibility(0);
                if (responseGroupInfoMessage.getGroup() != null) {
                    this.L.setText(responseGroupInfoMessage.getGroup().getName());
                }
                this.g.setPadding(0, 0, UtilHelper.a((Context) this.f1609a, 16.0f), 0);
            } else {
                this.w.setEnabled(false);
                this.N.setEnabled(true);
                this.M.setVisibility(8);
                this.P.setVisibility(8);
                this.g.setPadding(0, 0, 0, 0);
            }
            if (responseGroupInfoMessage.isJoin()) {
                this.C.setVisibility(0);
                this.H.setVisibility(0);
                if (!this.S) {
                    this.B.setVisibility(8);
                }
                if (this.t.getParent() != this.C) {
                    if (responseGroupInfoMessage.isGroupManager()) {
                        if (this.S) {
                            this.t.setBackgroundResource(R.drawable.more_middle);
                        } else {
                            this.t.setBackgroundResource(R.drawable.more_down);
                        }
                    } else if (this.S) {
                        this.t.setBackgroundResource(R.drawable.more_up);
                    } else {
                        this.t.setBackgroundResource(R.drawable.more_all);
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, UtilHelper.a((Context) this.f1609a, 90.0f));
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.topMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int a3 = UtilHelper.a((Context) this.f1609a, 13.0f);
                    int a4 = UtilHelper.a((Context) this.f1609a, 10.0f);
                    this.t.setPadding(a4, a3, a4, 0);
                    this.E.removeView(this.t);
                    this.C.addView(this.t, 1, layoutParams2);
                }
                s();
            } else {
                this.C.setVisibility(8);
                this.H.setVisibility(8);
                if (this.t.getParent() != this.E) {
                    this.t.setBackgroundResource(R.drawable.more_all);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, UtilHelper.a((Context) this.f1609a, 87.0f));
                    layoutParams3.rightMargin = UtilHelper.a((Context) this.f1609a, 10.0f);
                    layoutParams3.leftMargin = UtilHelper.a((Context) this.f1609a, 10.0f);
                    layoutParams3.topMargin = 0;
                    layoutParams3.bottomMargin = UtilHelper.a((Context) this.f1609a, 10.0f);
                    int a5 = UtilHelper.a((Context) this.f1609a, 13.0f);
                    int a6 = UtilHelper.a((Context) this.f1609a, 10.0f);
                    this.t.setPadding(a6, a5, a6, 0);
                    this.C.removeView(this.t);
                    this.E.addView(this.t, 3, layoutParams3);
                }
                if (a(responseGroupInfoMessage.getGroup().getFlag())) {
                    c(z);
                } else {
                    y();
                }
            }
            if (responseGroupInfoMessage.getGroup().getGroupType() == 4 || responseGroupInfoMessage.getGroup().getGroupType() == 5) {
                this.p.setVisibility(8);
                this.o.setBackgroundResource(R.drawable.more_all);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, UtilHelper.a((Context) this.f1609a, 54.0f));
                int a7 = UtilHelper.a((Context) this.f1609a, 10.0f);
                this.o.setPadding(a7, 0, a7, 0);
                this.o.setLayoutParams(layoutParams4);
            } else {
                this.p.setVisibility(0);
            }
            b(responseGroupInfoMessage);
            if (responseGroupInfoMessage.getGroup().getIsHidePosition() == 1) {
                b(responseGroupInfoMessage.isGroupManager());
            } else {
                a(responseGroupInfoMessage.isGroupManager());
            }
            if (TextUtils.isEmpty(responseGroupInfoMessage.getGroup().getPosition())) {
                this.w.setVisibility(8);
            }
        }
    }

    public void s() {
        this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1609a.getResources().getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        this.A.setText(this.f1609a.getString(R.string.group_info_enter_chat));
        this.A.setTextColor(this.f1609a.getResources().getColorStateList(R.color.white));
        this.T.setBackgroundResource(R.drawable.group_info_foot_selector);
        this.T.setEnabled(true);
    }

    private void c(boolean z) {
        this.A.setText(this.f1609a.getString(R.string.group_info_join));
        if (z) {
            this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1609a.getResources().getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            this.A.setTextColor(this.f1609a.getResources().getColorStateList(R.color.white));
        } else {
            this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1609a.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            this.A.setTextColor(this.f1609a.getResources().getColorStateList(R.color.group_info_join_disable_color));
        }
        this.T.setBackgroundResource(R.drawable.group_info_foot_selector);
        this.T.setEnabled(true);
    }

    private boolean a(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void y() {
        this.A.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.A.setText(this.f1609a.getString(R.string.group_info_refuse_join));
        this.A.setTextColor(this.f1609a.getResources().getColorStateList(R.color.group_info_join_resuse_color));
        this.T.setBackgroundColor(0);
        this.T.setEnabled(false);
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

    public void b(ResponseGroupInfoMessage responseGroupInfoMessage) {
        if (responseGroupInfoMessage != null) {
            this.k.setIsManager(responseGroupInfoMessage.isGroupManager());
            if (responseGroupInfoMessage.isGroupManager()) {
                this.k.setVisibility(0);
                if (responseGroupInfoMessage.getPhotos() != null && responseGroupInfoMessage.getPhotos().size() == 1 && TextUtils.isEmpty(responseGroupInfoMessage.getPhotos().get(0).getPicId())) {
                    this.k.setData(null);
                } else {
                    this.k.setData(responseGroupInfoMessage.getPhotos());
                }
            } else if (responseGroupInfoMessage.getPhotos() != null && responseGroupInfoMessage.getPhotos().size() > 0) {
                if (responseGroupInfoMessage.getPhotos().size() == 1 && TextUtils.isEmpty(responseGroupInfoMessage.getPhotos().get(0).getPicId())) {
                    this.k.setVisibility(8);
                    return;
                }
                this.k.setVisibility(0);
                this.k.setData(responseGroupInfoMessage.getPhotos());
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void a(y yVar) {
        this.G = yVar;
    }

    public void t() {
        if (this.m == null) {
            z();
        }
        this.m.show();
    }

    private void z() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1609a);
        builder.setTitle(this.f1609a.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.f1609a.getResources().getString(R.string.take_photo), this.f1609a.getResources().getString(R.string.album)}, this.l);
        this.m = builder.create();
        this.m.setCanceledOnTouchOutside(true);
    }

    public void a(Object obj, int i) {
        if (this.F != null) {
            this.F.dismiss();
            this.F = null;
        }
        b(obj, i);
        this.F.show();
    }

    public void u() {
        this.F.dismiss();
    }

    private void b(Object obj, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1609a);
        builder.setTitle(this.f1609a.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.f1609a.getResources().getString(R.string.group_info_set_portrait), this.f1609a.getResources().getString(R.string.delete), this.f1609a.getResources().getString(R.string.cancel)}, new s(this, obj, i));
        this.F = builder.create();
        this.F.setCanceledOnTouchOutside(true);
    }

    public void v() {
        if (this.k != null) {
            this.k.a();
        }
    }

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    public void w() {
        if (this.u == null) {
            this.u = new AlertDialog.Builder(this.f1609a).setTitle(R.string.group_address_option).setItems(new CharSequence[]{new SpannableString(this.f1609a.getString(R.string.group_address_show)), new SpannableString(this.f1609a.getString(R.string.group_address_hide))}, this.v).create();
        }
        this.u.setCanceledOnTouchOutside(true);
        this.u.show();
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.f1609a.getString(R.string.copy_group_introduction)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f1609a);
            builder.setTitle(this.f1609a.getString(R.string.operation));
            builder.setItems(charSequenceArr, new t(this, str));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
    }

    public void e(String str) {
        if (this.D == null) {
            g(str);
        }
        this.D.show();
    }

    private void g(String str) {
        if (this.D == null) {
            CharSequence[] charSequenceArr = {this.f1609a.getString(R.string.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f1609a);
            builder.setTitle(this.f1609a.getString(R.string.operation));
            builder.setItems(charSequenceArr, new u(this, str));
            this.D = builder.create();
            this.D.setCanceledOnTouchOutside(true);
        }
    }

    public void x() {
        ColorStateList colorStateList = this.f1609a.getResources().getColorStateList(R.color.group_info_join_disable_color);
        if (colorStateList != null) {
            this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1609a.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            this.A.setTextColor(colorStateList);
        }
    }
}
