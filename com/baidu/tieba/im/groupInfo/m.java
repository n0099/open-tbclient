package com.baidu.tieba.im.groupInfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ca;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.a.e {
    public static int a = 0;
    public static int c = 0;
    private AlertDialog A;
    private ImageView B;
    private PopupWindow C;
    private View D;
    private DialogInterface.OnClickListener E;
    private RelativeLayout F;
    private com.baidu.tieba.util.i G;
    private LinearLayout H;
    private LinearLayout I;
    private TextView J;
    private RelativeLayout K;
    private RelativeLayout L;
    private LinearLayout M;
    private Dialog N;
    private LinearLayout O;
    private Dialog P;
    private y Q;
    private TextView R;
    private String S;
    private ImageView T;
    private RelativeLayout U;
    private TextView V;
    private ImageView W;
    private RelativeLayout X;
    private RelativeLayout Y;
    private ImageView Z;
    private ImageView aa;
    private View ab;
    private TextView ac;
    private TextView ad;
    private boolean ae;
    private LinearLayout af;
    private NavigationBar ag;
    private TextView ah;
    private Handler ai;
    private GroupInfoActivity d;
    private RelativeLayout e;
    private ImageView f;
    private ProgressBar g;
    private RelativeLayout h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private EllipsizingTextView n;
    private TextView o;
    private RelativeLayout p;
    private PhotoWallView q;
    private DialogInterface.OnClickListener r;
    private Dialog s;
    private TextView t;
    private RelativeLayout u;
    private RelativeLayout v;
    private LinearLayout w;
    private HeadImageView x;
    private TextView y;
    private RelativeLayout z;

    public m(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity);
        this.r = null;
        this.s = null;
        this.A = null;
        this.E = null;
        this.S = "";
        this.ae = true;
        this.ai = new n(this);
        this.d = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.G = new com.baidu.tieba.util.i(groupInfoActivity);
        this.G.d(false);
        this.D = ((LayoutInflater) groupInfoActivity.getSystemService("layout_inflater")).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        a(groupInfoActivity);
        b(groupInfoActivity);
        c(groupInfoActivity);
    }

    private boolean z() {
        return com.baidu.tieba.sharedPref.b.a().a("has_shown_activity_guide_toast", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.baidu.tieba.sharedPref.b.a().b("has_shown_activity_guide_toast", true);
    }

    public void a(String str) {
        this.V.setText(str);
        f(str);
    }

    private void f(String str) {
        this.ah = this.ag.a(str);
    }

    public void b(String str) {
        this.n.setText(str);
    }

    private void a(GroupInfoActivity groupInfoActivity) {
        this.ag = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.ah = this.ag.a("");
        this.f = this.ag.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupInfoActivity);
        this.R = this.ag.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupInfoActivity.getString(R.string.setup));
        this.R.setOnClickListener(groupInfoActivity);
        this.R.setVisibility(8);
    }

    private void b(GroupInfoActivity groupInfoActivity) {
        this.e = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.h = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.h.setOnClickListener(groupInfoActivity);
        this.i = (TextView) groupInfoActivity.findViewById(R.id.tv_activity_name);
        this.j = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.k = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.F = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.F.setOnClickListener(groupInfoActivity);
        this.O = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.T = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.l = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.m = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.Z = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.n = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.n.setMaxLines(20);
        this.n.a(new o(this));
        this.p = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.o = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.p.setOnClickListener(groupInfoActivity);
        this.x = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.x.setAutoChangeStyle(true);
        this.x.setIsRound(true);
        this.t = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.u = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.u.setOnClickListener(groupInfoActivity);
        this.B = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.ab = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.w = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.p.setOnClickListener(groupInfoActivity);
        this.v = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.v.setOnClickListener(groupInfoActivity);
        this.y = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.z = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.z.setOnClickListener(groupInfoActivity);
        this.H = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.I = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.af = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.J = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.af.setOnClickListener(this.d);
        this.K = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_share);
        this.K.setOnClickListener(groupInfoActivity);
        this.L = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.L.setOnClickListener(groupInfoActivity);
        this.M = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.U = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.U.setOnClickListener(groupInfoActivity);
        this.V = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.W = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.aa = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.X = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.X.setOnClickListener(groupInfoActivity);
        this.X.setOnClickListener(groupInfoActivity);
        this.X.setLongClickable(true);
        this.X.setOnLongClickListener(groupInfoActivity);
        this.ac = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.ac.setClickable(true);
        this.ac.setOnClickListener(new p(this));
        this.Y = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.Y.setOnLongClickListener(groupInfoActivity);
        this.ad = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.g = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
    }

    private void c(GroupInfoActivity groupInfoActivity) {
        this.q = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.q.setPhotoClickListener(groupInfoActivity);
        this.q.setPhotoLongClickListener(groupInfoActivity);
        this.q.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.C == null) {
            this.C = new PopupWindow(this.d);
            this.C.setContentView(this.D);
            this.C.setWidth(this.d.getResources().getDimensionPixelSize(R.dimen.ds504));
            this.C.setHeight(this.d.getResources().getDimensionPixelSize(R.dimen.ds128));
            this.C.setBackgroundDrawable(new BitmapDrawable());
            this.C.setOutsideTouchable(true);
            this.C.setFocusable(true);
        }
        if (this.C.isShowing()) {
            this.C.dismiss();
        } else {
            this.C.showAsDropDown(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.C != null && this.C.isShowing()) {
            this.C.dismiss();
        }
    }

    public RelativeLayout a() {
        return this.Y;
    }

    public RelativeLayout e() {
        return this.p;
    }

    public LinearLayout f() {
        return this.H;
    }

    public RelativeLayout g() {
        return this.K;
    }

    public RelativeLayout h() {
        return this.L;
    }

    public RelativeLayout i() {
        return this.X;
    }

    public RelativeLayout j() {
        return this.U;
    }

    public RelativeLayout k() {
        return this.h;
    }

    public TextView l() {
        return this.R;
    }

    public LinearLayout m() {
        return this.af;
    }

    public RelativeLayout n() {
        return this.u;
    }

    public RelativeLayout o() {
        return this.v;
    }

    public RelativeLayout p() {
        return this.z;
    }

    public ImageView q() {
        return this.f;
    }

    public void r() {
        this.g.setVisibility(8);
    }

    public void s() {
        this.g.setVisibility(0);
    }

    public void a(boolean z, String str) {
        if (z) {
            this.m.setText(str);
            this.F.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.F.setVisibility(8);
        } else {
            this.m.setText(str);
            this.F.setVisibility(0);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.m.setText(this.b.getString(R.string.group_info_address_hide));
        } else {
            this.F.setVisibility(8);
        }
    }

    public RelativeLayout t() {
        return this.F;
    }

    public void a(ca caVar) {
        a(caVar, false);
    }

    public void a(ca caVar, boolean z) {
        if (caVar != null) {
            if (caVar.b() != null) {
                a = caVar.b().getGroupId();
            }
            if (caVar.a() != null) {
                c = caVar.a().getActivityId();
            }
            boolean z2 = TiebaApplication.g().al() == 1;
            this.O.setVisibility(0);
            this.I.setVisibility(0);
            if (caVar.b() != null) {
                f(caVar.b().getName());
                this.l.setText(String.valueOf(caVar.b().getGroupId()));
                if (caVar.b().isMeizhi()) {
                    this.B.setVisibility(0);
                } else {
                    this.B.setVisibility(8);
                }
                if (caVar.b().getGroupType() == 4) {
                    this.T.setVisibility(0);
                    this.x.setVisibility(8);
                    this.aa.setVisibility(8);
                    this.ab.setVisibility(8);
                    this.t.setText(R.string.group_info_forum_author);
                    this.u.setEnabled(false);
                    this.B.setVisibility(8);
                } else {
                    this.T.setVisibility(8);
                    this.x.setVisibility(0);
                    this.aa.setVisibility(0);
                    this.ab.setVisibility(0);
                    this.t.setText(caVar.b().getAuthorName());
                    this.u.setEnabled(true);
                }
                String position = caVar.b().getPosition();
                String business = caVar.b().getBusiness();
                StringBuffer stringBuffer = new StringBuffer();
                if (position != null) {
                    stringBuffer.append(position);
                }
                if (business != null) {
                    stringBuffer.append(business);
                }
                this.S = stringBuffer.toString();
                this.m.setText(this.S);
                this.n.setText(caVar.b().getIntro());
                this.y.setText("(" + caVar.b().getMemberNum() + "/" + caVar.b().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(caVar.b().getAuthorPortrait())) {
                    this.G.c(caVar.b().getAuthorPortrait(), new q(this));
                }
                if (caVar.b().getForumName() != null && caVar.b().getForumName().length() > 0) {
                    this.p.setVisibility(0);
                    this.o.setText(String.valueOf(caVar.b().getForumName()) + this.d.getString(R.string.bar));
                } else {
                    this.p.setVisibility(8);
                }
                this.w.removeAllViews();
                boolean k = caVar.k();
                boolean j = caVar.j();
                if (j) {
                    bq.a(this.ah, R.color.im_group_vip_text, 1);
                }
                if (caVar.b().getGrade() > 0) {
                    for (int i = 0; i < caVar.b().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.d);
                        if (j) {
                            bq.d(imageView, (int) R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            bq.d(imageView, (int) R.drawable.icon_grade_middle_star_s);
                        }
                        this.w.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.d);
                    if (j) {
                        bq.d(imageView2, (int) R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        bq.d(imageView2, (int) R.drawable.icon_grade_middle_star_n);
                    }
                    this.w.addView(imageView2);
                }
                if (k) {
                    this.ad.setVisibility(0);
                } else {
                    this.ad.setVisibility(8);
                }
            }
            if (caVar.h() && !z()) {
                this.ai.removeMessages(0);
                this.ai.sendEmptyMessageDelayed(0, 600L);
            }
            if (caVar.a() != null) {
                this.h.setVisibility(0);
                GroupActivityData a2 = caVar.a();
                if (!caVar.g()) {
                    if (a2.getIsEnd() != 1) {
                        this.j.setVisibility(4);
                        this.k.setText(R.string.group_info_activity_not_join_tip);
                    }
                } else {
                    this.j.setVisibility(0);
                    this.k.setText(a2.getgActivityTitle());
                    if (a2.getIsEnd() != 1) {
                        this.j.setText(R.string.group_info_activity_doing);
                        if (z2) {
                            this.j.setTextColor(this.b.getResources().getColor(R.color.group_info_activity_doing_1));
                        } else {
                            this.j.setTextColor(this.b.getResources().getColor(R.color.group_info_activity_doing));
                        }
                    } else {
                        this.j.setText(R.string.group_info_activity_finish);
                        if (TiebaApplication.g().al() == 1) {
                            this.j.setTextColor(this.b.getResources().getColor(R.color.group_info_activity_finish_1));
                        } else {
                            this.j.setTextColor(this.b.getResources().getColor(R.color.group_info_activity_finish));
                        }
                    }
                    this.k.setText(a2.getgActivityTitle());
                }
            } else if (caVar.h()) {
                this.h.setVisibility(0);
                this.j.setVisibility(4);
                this.k.setText(R.string.group_info_create_activity);
            } else {
                this.h.setVisibility(8);
            }
            this.H.removeAllViews();
            if (caVar.c() != null && caVar.c().size() > 0) {
                List<MemberData> c2 = caVar.c();
                int size = c2.size();
                int i2 = size > 7 ? 7 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = c2.get(i3);
                    HeadImageView headImageView = new HeadImageView(this.d);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(true);
                    headImageView.setTag(String.valueOf(memberData.getUserId()));
                    int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_photo_width);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_photo_margin);
                    this.H.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        com.baidu.adp.widget.ImageView.b c3 = this.G.c(memberData.getPortrait());
                        if (c3 != null) {
                            c3.a(headImageView);
                        } else {
                            this.G.c(memberData.getPortrait(), new r(this, headImageView));
                        }
                    }
                }
            }
            if (caVar.h()) {
                this.F.setEnabled(true);
                this.X.setEnabled(true);
                this.U.setVisibility(0);
                this.Z.setVisibility(0);
                this.W.setVisibility(0);
                if (caVar.b() != null) {
                    this.V.setText(caVar.b().getName());
                }
            } else {
                this.F.setEnabled(false);
                this.X.setEnabled(true);
                this.W.setVisibility(8);
                this.Z.setVisibility(8);
                this.n.setPadding(0, 0, 0, 0);
            }
            if (caVar.g()) {
                this.M.setVisibility(0);
                this.R.setVisibility(0);
                if (!this.ae) {
                    this.K.setVisibility(8);
                }
                if (this.z.getParent() != this.M) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_paddingtb);
                    int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_side_paddinglr);
                    this.z.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, 0);
                    this.O.removeView(this.z);
                    this.M.addView(this.z, 1, layoutParams2);
                }
                u();
            } else {
                this.M.setVisibility(8);
                this.R.setVisibility(8);
                if (this.z.getParent() != this.O) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int dimensionPixelSize4 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_bigside_paddinglr);
                    this.z.setPadding(dimensionPixelSize4, 0, dimensionPixelSize4, 0);
                    this.M.removeView(this.z);
                    this.O.addView(this.z, 3, layoutParams3);
                }
                if (b(caVar.b().getFlag())) {
                    b(z);
                } else {
                    D();
                }
            }
            if (caVar.b().getGroupType() == 4 || caVar.b().getGroupType() == 5) {
                this.v.setVisibility(8);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelSize5 = this.b.getResources().getDimensionPixelSize(R.dimen.im_group_info_item_side_paddinglr);
                this.u.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                this.u.setLayoutParams(layoutParams4);
            } else {
                this.v.setVisibility(0);
            }
            b(caVar);
            if (caVar.b().getIsHidePosition() == 1) {
                a(caVar.h());
            } else {
                a(caVar.h(), this.S);
            }
        }
    }

    public void u() {
        if (TiebaApplication.g().al() == 1) {
            this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(R.drawable.icon_brief_jinba_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.J.setTextColor(this.d.getResources().getColorStateList(R.color.group_info_bottom_text_1));
            this.af.setBackgroundResource(R.drawable.group_info_foot_selector_1);
        } else {
            this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
            this.J.setTextColor(this.d.getResources().getColorStateList(R.color.group_info_bottom_text));
            this.af.setBackgroundResource(R.drawable.group_info_foot_selector);
        }
        this.J.setText(this.d.getString(R.string.group_info_enter_chat));
        this.af.setEnabled(true);
    }

    private void b(boolean z) {
        this.J.setText(this.d.getString(R.string.group_info_join));
        if (TiebaApplication.g().al() == 1) {
            if (z) {
                this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.J.setTextColor(this.d.getResources().getColorStateList(R.color.group_info_bottom_text_1));
            } else {
                this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.J.setTextColor(this.d.getResources().getColorStateList(R.color.group_info_join_disable_color_1));
            }
            this.af.setBackgroundResource(R.drawable.group_info_foot_selector_1);
        } else {
            if (z) {
                this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
                this.J.setTextColor(this.d.getResources().getColorStateList(R.color.white));
            } else {
                this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
                this.J.setTextColor(this.d.getResources().getColorStateList(R.color.group_info_join_disable_color));
            }
            this.af.setBackgroundResource(R.drawable.group_info_foot_selector);
        }
        this.af.setEnabled(true);
    }

    private boolean b(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void D() {
        this.J.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.J.setText(this.d.getString(R.string.group_info_refuse_join));
        this.J.setTextColor(this.d.getResources().getColorStateList(R.color.group_info_join_resuse_color));
        this.af.setBackgroundColor(0);
        this.af.setEnabled(false);
    }

    public void c(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.H.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.H.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.H.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void b(ca caVar) {
        if (caVar != null) {
            this.q.setIsManager(caVar.h());
            if (caVar.h()) {
                this.q.setVisibility(0);
                if (caVar.d() != null && caVar.d().size() == 1 && TextUtils.isEmpty(caVar.d().get(0).getPicId())) {
                    this.q.setData(null);
                } else {
                    this.q.setData(caVar.d());
                }
            } else if (caVar.d() != null && caVar.d().size() > 0) {
                if (caVar.d().size() == 1 && TextUtils.isEmpty(caVar.d().get(0).getPicId())) {
                    this.q.setVisibility(8);
                    return;
                }
                this.q.setVisibility(0);
                this.q.setData(caVar.d());
            } else {
                this.q.setVisibility(8);
            }
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void a(y yVar) {
        this.Q = yVar;
    }

    public void v() {
        if (this.s == null) {
            E();
        }
        this.s.show();
    }

    private void E() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(this.d.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.d.getResources().getString(R.string.take_photo), this.d.getResources().getString(R.string.album)}, this.r);
        this.s = builder.create();
        this.s.setCanceledOnTouchOutside(true);
    }

    public void a(Object obj, int i) {
        if (this.P != null) {
            this.P.dismiss();
            this.P = null;
        }
        b(obj, i);
        this.P.show();
    }

    public void w() {
        this.P.dismiss();
    }

    private void b(Object obj, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(this.d.getResources().getString(R.string.operation));
        builder.setItems(new String[]{this.d.getResources().getString(R.string.group_info_set_portrait), this.d.getResources().getString(R.string.delete), this.d.getResources().getString(R.string.cancel)}, new s(this, obj, i));
        this.P = builder.create();
        this.P.setCanceledOnTouchOutside(true);
    }

    public void x() {
        if (this.q != null) {
            this.q.a();
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.d.getString(R.string.copy_group_introduction)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
            builder.setTitle(this.d.getString(R.string.operation));
            builder.setItems(charSequenceArr, new t(this, str));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
    }

    public void e(String str) {
        if (this.N == null) {
            g(str);
        }
        this.N.show();
    }

    private void g(String str) {
        if (this.N == null) {
            CharSequence[] charSequenceArr = {this.d.getString(R.string.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
            builder.setTitle(this.d.getString(R.string.operation));
            builder.setItems(charSequenceArr, new u(this, str));
            this.N = builder.create();
            this.N.setCanceledOnTouchOutside(true);
        }
    }

    public void y() {
        ColorStateList colorStateList;
        Resources resources = this.d.getResources();
        if (TiebaApplication.g().al() == 1) {
            colorStateList = resources.getColorStateList(R.color.group_info_join_disable_color_1);
            if (colorStateList != null) {
                this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(R.drawable.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else {
            colorStateList = resources.getColorStateList(R.color.group_info_join_disable_color);
            if (colorStateList != null) {
                this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.J.setTextColor(colorStateList);
    }

    public void a(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a((View) this.e);
        this.d.getLayoutMode().a(this.D);
        this.q.a(i, this.d);
        this.ag.c(i);
    }
}
