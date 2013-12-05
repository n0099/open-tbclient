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
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.a.e {
    private TextView A;
    private RelativeLayout B;
    private LinearLayout C;
    private Dialog D;
    private LinearLayout E;
    private Dialog F;
    private x G;
    private TextView H;
    private String I;
    private ImageView J;
    private RelativeLayout K;
    private TextView L;
    private ImageView M;
    private RelativeLayout N;
    private RelativeLayout O;
    private ImageView P;
    private ImageView Q;
    private View R;
    private TextView S;
    private boolean T;
    private LinearLayout U;
    private NavigationBar V;

    /* renamed from: a  reason: collision with root package name */
    private GroupInfoActivity f1753a;
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
        this.I = "";
        this.T = true;
        this.f1753a = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.x = new com.baidu.tieba.util.i(groupInfoActivity);
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
        this.V.a(str);
    }

    public void b(String str) {
        this.h.setText(str);
    }

    private void a(GroupInfoActivity groupInfoActivity) {
        this.V = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.V.a("");
        this.d = this.V.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupInfoActivity);
        this.H = this.V.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupInfoActivity.getString(R.string.setup));
        this.H.setOnClickListener(groupInfoActivity);
        this.H.setVisibility(8);
    }

    private void b(GroupInfoActivity groupInfoActivity) {
        this.c = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.w = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.w.setOnClickListener(groupInfoActivity);
        this.E = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.J = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.f = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.g = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.P = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
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
        this.R = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.q = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.j.setOnClickListener(groupInfoActivity);
        this.p = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.p.setOnClickListener(groupInfoActivity);
        this.s = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.t = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.t.setOnClickListener(groupInfoActivity);
        this.y = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.z = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.U = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.A = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.U.setOnClickListener(this.f1753a);
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
        this.S = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.S.setClickable(true);
        this.S.setOnClickListener(new o(this));
        this.O = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.O.setOnLongClickListener(groupInfoActivity);
        this.e = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
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

    public TextView j() {
        return this.H;
    }

    public LinearLayout k() {
        return this.U;
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
        return this.d;
    }

    public void p() {
        this.e.setVisibility(8);
    }

    public void q() {
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

    public RelativeLayout r() {
        return this.w;
    }

    public void a(ResponseGroupInfoMessage responseGroupInfoMessage) {
        a(responseGroupInfoMessage, false);
    }

    public void a(ResponseGroupInfoMessage responseGroupInfoMessage, boolean z) {
        if (responseGroupInfoMessage != null) {
            boolean z2 = TiebaApplication.h().an() == 1;
            this.E.setVisibility(0);
            this.z.setVisibility(0);
            if (responseGroupInfoMessage.getGroup() != null) {
                f(responseGroupInfoMessage.getGroup().getName());
                this.f.setText(String.valueOf(responseGroupInfoMessage.getGroup().getGroupId()));
                if (responseGroupInfoMessage.getGroup().getGroupType() == 4) {
                    this.J.setVisibility(0);
                    this.r.setVisibility(8);
                    this.Q.setVisibility(8);
                    this.R.setVisibility(8);
                    this.n.setText(R.string.group_info_forum_author);
                    this.o.setEnabled(false);
                } else {
                    this.J.setVisibility(8);
                    this.r.setVisibility(0);
                    this.Q.setVisibility(0);
                    this.R.setVisibility(0);
                    this.n.setText(responseGroupInfoMessage.getGroup().getAuthorName());
                    this.o.setEnabled(true);
                }
                String position = responseGroupInfoMessage.getGroup().getPosition();
                String business = responseGroupInfoMessage.getGroup().getBusiness();
                StringBuffer stringBuffer = new StringBuffer();
                if (position != null) {
                    stringBuffer.append(position);
                }
                if (business != null) {
                    stringBuffer.append(business);
                }
                this.I = stringBuffer.toString();
                this.g.setText(this.I);
                this.h.setText(responseGroupInfoMessage.getGroup().getIntro());
                this.s.setText("(" + responseGroupInfoMessage.getGroup().getMemberNum() + "/" + responseGroupInfoMessage.getGroup().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(responseGroupInfoMessage.getGroup().getAuthorPortrait())) {
                    com.baidu.adp.widget.ImageView.e c = this.x.c(responseGroupInfoMessage.getGroup().getAuthorPortrait());
                    if (c != null) {
                        c.a(this.r);
                    } else {
                        this.x.b(responseGroupInfoMessage.getGroup().getAuthorPortrait(), new p(this));
                    }
                }
                if (responseGroupInfoMessage.getGroup().getForumName() != null && responseGroupInfoMessage.getGroup().getForumName().length() > 0) {
                    this.j.setVisibility(0);
                    this.i.setText(responseGroupInfoMessage.getGroup().getForumName() + this.f1753a.getString(R.string.bar));
                } else {
                    this.j.setVisibility(8);
                }
                this.q.removeAllViews();
                if (responseGroupInfoMessage.getGroup().getGrade() > 0) {
                    for (int i = 0; i < responseGroupInfoMessage.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.f1753a);
                        if (z2) {
                            imageView.setImageResource(R.drawable.icon_grade_middle_star_s_1);
                        } else {
                            imageView.setImageResource(R.drawable.icon_grade_middle_star_s);
                        }
                        this.q.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.f1753a);
                    if (z2) {
                        imageView2.setImageResource(R.drawable.icon_grade_middle_star_n_1);
                    } else {
                        imageView2.setImageResource(R.drawable.icon_grade_middle_star_n);
                    }
                    this.q.addView(imageView2);
                }
            }
            this.y.removeAllViews();
            if (responseGroupInfoMessage.getMembers() != null && responseGroupInfoMessage.getMembers().size() > 0) {
                List<MemberData> members = responseGroupInfoMessage.getMembers();
                int size = members.size();
                int i2 = size > 7 ? 7 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = members.get(i3);
                    HeadImageView headImageView = new HeadImageView(this.f1753a);
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
            if (responseGroupInfoMessage.isGroupManager()) {
                this.w.setEnabled(true);
                this.N.setEnabled(true);
                this.K.setVisibility(0);
                this.P.setVisibility(0);
                this.M.setVisibility(0);
                if (responseGroupInfoMessage.getGroup() != null) {
                    this.L.setText(responseGroupInfoMessage.getGroup().getName());
                }
            } else {
                this.w.setEnabled(false);
                this.N.setEnabled(true);
                this.M.setVisibility(8);
                this.P.setVisibility(8);
                this.h.setPadding(0, 0, 0, 0);
            }
            if (responseGroupInfoMessage.isJoin()) {
                this.C.setVisibility(0);
                this.H.setVisibility(0);
                if (!this.T) {
                    this.B.setVisibility(8);
                }
                if (this.t.getParent() != this.C) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_paddingtb);
                    int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_side_paddinglr);
                    this.t.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, 0);
                    this.E.removeView(this.t);
                    this.C.addView(this.t, 1, layoutParams2);
                }
                s();
            } else {
                this.C.setVisibility(8);
                this.H.setVisibility(8);
                if (this.t.getParent() != this.E) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int dimensionPixelSize4 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_bigside_paddinglr);
                    this.t.setPadding(dimensionPixelSize4, 0, dimensionPixelSize4, 0);
                    this.C.removeView(this.t);
                    this.E.addView(this.t, 3, layoutParams3);
                }
                if (b(responseGroupInfoMessage.getGroup().getFlag())) {
                    b(z);
                } else {
                    x();
                }
            }
            if (responseGroupInfoMessage.getGroup().getGroupType() == 4 || responseGroupInfoMessage.getGroup().getGroupType() == 5) {
                this.p.setVisibility(8);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelSize5 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_side_paddinglr);
                this.o.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                this.o.setLayoutParams(layoutParams4);
            } else {
                this.p.setVisibility(0);
            }
            b(responseGroupInfoMessage);
            if (responseGroupInfoMessage.getGroup().getIsHidePosition() == 1) {
                a(responseGroupInfoMessage.isGroupManager());
            } else {
                a(responseGroupInfoMessage.isGroupManager(), this.I);
            }
        }
    }

    public void s() {
        if (TiebaApplication.h().an() == 1) {
            this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1753a.getResources().getDrawable(R.drawable.icon_brief_jinba_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.A.setTextColor(this.f1753a.getResources().getColorStateList(R.color.group_info_bottom_text_1));
            this.U.setBackgroundResource(R.drawable.group_info_foot_selector_1);
        } else {
            this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1753a.getResources().getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
            this.A.setTextColor(this.f1753a.getResources().getColorStateList(R.color.group_info_bottom_text));
            this.U.setBackgroundResource(R.drawable.group_info_foot_selector);
        }
        this.A.setText(this.f1753a.getString(R.string.group_info_enter_chat));
        this.U.setEnabled(true);
    }

    private void b(boolean z) {
        this.A.setText(this.f1753a.getString(R.string.group_info_join));
        if (TiebaApplication.h().an() == 1) {
            if (z) {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1753a.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.A.setTextColor(this.f1753a.getResources().getColorStateList(R.color.group_info_bottom_text_1));
            } else {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1753a.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.A.setTextColor(this.f1753a.getResources().getColorStateList(R.color.group_info_join_disable_color_1));
            }
            this.U.setBackgroundResource(R.drawable.group_info_foot_selector_1);
        } else {
            if (z) {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1753a.getResources().getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
                this.A.setTextColor(this.f1753a.getResources().getColorStateList(R.color.white));
            } else {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1753a.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
                this.A.setTextColor(this.f1753a.getResources().getColorStateList(R.color.group_info_join_disable_color));
            }
            this.U.setBackgroundResource(R.drawable.group_info_foot_selector);
        }
        this.U.setEnabled(true);
    }

    private boolean b(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void x() {
        this.A.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.A.setText(this.f1753a.getString(R.string.group_info_refuse_join));
        this.A.setTextColor(this.f1753a.getResources().getColorStateList(R.color.group_info_join_resuse_color));
        this.U.setBackgroundColor(0);
        this.U.setEnabled(false);
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

    public void a(x xVar) {
        this.G = xVar;
    }

    public void t() {
        if (this.m == null) {
            y();
        }
        this.m.show();
    }

    private void y() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1753a);
        builder.setTitle(this.f1753a.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.f1753a.getResources().getString(R.string.take_photo), this.f1753a.getResources().getString(R.string.album)}, this.l);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1753a);
        builder.setTitle(this.f1753a.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.f1753a.getResources().getString(R.string.group_info_set_portrait), this.f1753a.getResources().getString(R.string.delete), this.f1753a.getResources().getString(R.string.cancel)}, new r(this, obj, i));
        this.F = builder.create();
        this.F.setCanceledOnTouchOutside(true);
    }

    public void v() {
        if (this.k != null) {
            this.k.a();
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.f1753a.getString(R.string.copy_group_introduction)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f1753a);
            builder.setTitle(this.f1753a.getString(R.string.operation));
            builder.setItems(charSequenceArr, new s(this, str));
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
            CharSequence[] charSequenceArr = {this.f1753a.getString(R.string.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f1753a);
            builder.setTitle(this.f1753a.getString(R.string.operation));
            builder.setItems(charSequenceArr, new t(this, str));
            this.D = builder.create();
            this.D.setCanceledOnTouchOutside(true);
        }
    }

    public void w() {
        ColorStateList colorStateList;
        Resources resources = this.f1753a.getResources();
        if (TiebaApplication.h().an() == 1) {
            colorStateList = resources.getColorStateList(R.color.group_info_join_disable_color_1);
            if (colorStateList != null) {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1753a.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else {
            colorStateList = resources.getColorStateList(R.color.group_info_join_disable_color);
            if (colorStateList != null) {
                this.A.setCompoundDrawablesWithIntrinsicBounds(this.f1753a.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.A.setTextColor(colorStateList);
    }

    public void a(int i) {
        this.f1753a.getLayoutMode().a(i == 1);
        this.f1753a.getLayoutMode().a(this.c);
        this.k.a(i, this.f1753a);
        this.V.c(i);
    }
}
