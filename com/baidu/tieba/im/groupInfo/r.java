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
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.f {
    public static int a = 0;
    public static int b = 0;
    private AlertDialog A;
    private ImageView B;
    private PopupWindow C;
    private final View D;
    private DialogInterface.OnClickListener E;
    private RelativeLayout F;
    private LinearLayout G;
    private LinearLayout H;
    private TextView I;
    private RelativeLayout J;
    private RelativeLayout K;
    private LinearLayout L;
    private Dialog M;
    private LinearLayout N;
    private Dialog O;
    private ac P;
    private TextView Q;
    private String R;
    private ImageView S;
    private RelativeLayout T;
    private TextView U;
    private ImageView V;
    private RelativeLayout W;
    private RelativeLayout X;
    private ImageView Y;
    private ImageView Z;
    private View aa;
    private TextView ab;
    private TextView ac;
    private final boolean ad;
    private LinearLayout ae;
    private NavigationBar af;
    private TextView ag;
    private com.baidu.tieba.im.message.j ah;
    private final Handler ai;
    private final GroupInfoActivity c;
    private View d;
    private RelativeLayout e;
    private View f;
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

    public r(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity);
        this.r = null;
        this.s = null;
        this.A = null;
        this.E = null;
        this.R = "";
        this.ad = true;
        this.ai = new s(this);
        this.c = groupInfoActivity;
        groupInfoActivity.setContentView(com.baidu.tieba.v.im_group_info_activity);
        this.D = com.baidu.adp.lib.e.b.a().a(groupInfoActivity, com.baidu.tieba.v.group_activity_guide_toast, null);
        a(groupInfoActivity);
        b(groupInfoActivity);
        c(groupInfoActivity);
    }

    public void a() {
        this.ai.removeMessages(0);
        A();
    }

    private boolean x() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_activity_guide_toast", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_activity_guide_toast", true);
    }

    public void a(String str) {
        this.U.setText(str);
        f(str);
    }

    private void f(String str) {
        if (str != null) {
            this.ag.setText(str);
        }
    }

    public void b(String str) {
        this.n.setText(str);
    }

    private void a(GroupInfoActivity groupInfoActivity) {
        this.af = (NavigationBar) groupInfoActivity.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.f = this.af.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ag = this.af.a("");
        this.Q = this.af.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupInfoActivity.getString(com.baidu.tieba.x.setup));
        this.Q.setOnClickListener(groupInfoActivity);
        this.Q.setVisibility(8);
    }

    private void b(GroupInfoActivity groupInfoActivity) {
        this.d = groupInfoActivity.findViewById(com.baidu.tieba.u.line_activity_name_down);
        this.e = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.group_info_container);
        this.h = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_activity);
        this.h.setOnClickListener(groupInfoActivity);
        this.i = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.tv_activity_name);
        this.j = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_activity_status);
        this.k = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_activity_name);
        this.F = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.address_layout);
        this.F.setOnClickListener(groupInfoActivity);
        this.N = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_body);
        this.S = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.u.img_group_type_icon);
        this.l = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_group_number);
        this.m = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_group_place);
        this.Y = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.u.img_group_place);
        this.n = (EllipsizingTextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_group_intro);
        this.n.setMaxLines(20);
        this.n.a(new t(this));
        this.p = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_forum);
        this.o = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_group_forum);
        this.p.setOnClickListener(groupInfoActivity);
        this.x = (HeadImageView) groupInfoActivity.findViewById(com.baidu.tieba.u.img_group_author);
        this.x.setAutoChangeStyle(true);
        this.x.setIsRound(false);
        this.t = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_group_author);
        this.u = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_author);
        this.u.setOnClickListener(groupInfoActivity);
        this.B = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.u.meizhi_icon);
        this.aa = groupInfoActivity.findViewById(com.baidu.tieba.u.line_group_author_down);
        this.w = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_grade_star);
        this.p.setOnClickListener(groupInfoActivity);
        this.v = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_grade);
        this.v.setOnClickListener(groupInfoActivity);
        this.y = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_group_member_count);
        this.z = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_member);
        this.z.setOnClickListener(groupInfoActivity);
        this.G = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_member_photo);
        this.H = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.bottom_bar);
        this.ae = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_bottom_button);
        this.I = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_join);
        this.ae.setOnClickListener(this.c);
        this.J = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_share);
        this.J.setOnClickListener(groupInfoActivity);
        this.K = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_invite);
        this.K.setOnClickListener(groupInfoActivity);
        this.L = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_notice_share);
        this.T = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_name);
        this.T.setOnClickListener(groupInfoActivity);
        this.U = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_group_name);
        this.V = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.u.img_group_intro_arrow);
        this.Z = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.u.img_group_author_arrow);
        this.W = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_intro);
        this.W.setOnClickListener(groupInfoActivity);
        this.W.setLongClickable(true);
        this.W.setOnLongClickListener(groupInfoActivity);
        this.ab = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.txt_group_intro_more);
        this.ab.setClickable(true);
        this.ab.setOnClickListener(new u(this));
        this.X = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.u.lay_group_number);
        this.X.setOnLongClickListener(groupInfoActivity);
        this.ac = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.u.can_create_mem_group);
        this.g = (ProgressBar) groupInfoActivity.findViewById(com.baidu.tieba.u.progress_loading);
    }

    private void c(GroupInfoActivity groupInfoActivity) {
        this.q = (PhotoWallView) groupInfoActivity.findViewById(com.baidu.tieba.u.photo_wall);
        this.q.setPhotoClickListener(groupInfoActivity);
        this.q.setPhotoLongClickListener(groupInfoActivity);
        this.q.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        try {
            if (this.C == null) {
                this.C = new PopupWindow(this.c);
                this.C.setContentView(this.D);
                this.C.setWidth(this.c.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds504));
                this.C.setHeight(this.c.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds128));
                this.C.setBackgroundDrawable(new BitmapDrawable());
                this.C.setOutsideTouchable(true);
                this.C.setFocusable(true);
            }
            if (this.C.isShowing()) {
                com.baidu.adp.lib.e.e.a(this.C, this.c);
            } else {
                com.baidu.adp.lib.e.e.a(this.C, this.i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.C != null && this.C.isShowing()) {
            try {
                this.C.dismiss();
                this.C = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public RelativeLayout b() {
        return this.X;
    }

    public RelativeLayout c() {
        return this.p;
    }

    public LinearLayout d() {
        return this.G;
    }

    public RelativeLayout e() {
        return this.J;
    }

    public RelativeLayout f() {
        return this.K;
    }

    public RelativeLayout g() {
        return this.W;
    }

    public RelativeLayout h() {
        return this.T;
    }

    public RelativeLayout i() {
        return this.h;
    }

    public TextView j() {
        return this.Q;
    }

    public LinearLayout k() {
        return this.ae;
    }

    public RelativeLayout l() {
        return this.u;
    }

    public RelativeLayout m() {
        return this.v;
    }

    public RelativeLayout n() {
        return this.z;
    }

    public View o() {
        return this.f;
    }

    public void p() {
        this.g.setVisibility(8);
    }

    public void q() {
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
            this.m.setText(this.mContext.getString(com.baidu.tieba.x.group_info_address_hide));
        } else {
            this.F.setVisibility(8);
        }
    }

    public RelativeLayout r() {
        return this.F;
    }

    public void a(com.baidu.tieba.im.message.j jVar) {
        a(jVar, false);
    }

    public void a(com.baidu.tieba.im.message.j jVar, boolean z) {
        if (jVar != null) {
            this.ah = jVar;
            if (jVar.b() != null) {
                a = jVar.b().getGroupId();
            }
            if (jVar.a() != null) {
                b = jVar.a().getActivityId();
            }
            boolean z2 = TbadkApplication.m252getInst().getSkinType() == 1;
            this.N.setVisibility(0);
            this.H.setVisibility(0);
            if (jVar.b() != null) {
                f(jVar.b().getName());
                this.l.setText(String.valueOf(jVar.b().getGroupId()));
                if (jVar.b().isMeizhi()) {
                    this.B.setVisibility(0);
                } else {
                    this.B.setVisibility(8);
                }
                if (jVar.b().getGroupType() == 4) {
                    this.S.setVisibility(0);
                    this.x.setVisibility(8);
                    this.Z.setVisibility(8);
                    this.aa.setVisibility(8);
                    this.t.setText(com.baidu.tieba.x.group_info_forum_author);
                    this.u.setEnabled(false);
                    this.B.setVisibility(8);
                } else {
                    this.S.setVisibility(8);
                    this.x.setVisibility(0);
                    this.Z.setVisibility(0);
                    this.aa.setVisibility(0);
                    this.t.setText(jVar.b().getAuthorName());
                    this.u.setEnabled(true);
                }
                String position = jVar.b().getPosition();
                String business = jVar.b().getBusiness();
                StringBuffer stringBuffer = new StringBuffer();
                if (position != null) {
                    stringBuffer.append(position);
                }
                if (business != null) {
                    stringBuffer.append(business);
                }
                this.R = stringBuffer.toString();
                this.m.setText(this.R);
                this.n.setText(jVar.b().getIntro());
                this.y.setText("(" + jVar.b().getMemberNum() + "/" + jVar.b().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(jVar.b().getAuthorPortrait())) {
                    this.x.a(jVar.b().getAuthorPortrait(), 12, false);
                }
                if (jVar.b().getForumName() != null && jVar.b().getForumName().length() > 0) {
                    this.p.setVisibility(0);
                    this.o.setText(String.valueOf(jVar.b().getForumName()) + this.c.getString(com.baidu.tieba.x.bar));
                } else {
                    this.p.setVisibility(8);
                }
                this.w.removeAllViews();
                boolean k = jVar.k();
                boolean j = jVar.j();
                if (j) {
                    ay.a(this.ag, com.baidu.tieba.r.im_group_vip_text, 1);
                }
                if (jVar.b().getGrade() > 0) {
                    for (int i = 0; i < jVar.b().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.c);
                        if (j) {
                            ay.c(imageView, com.baidu.tieba.t.icon_vip_grade_big_middle_s);
                        } else {
                            ay.c(imageView, com.baidu.tieba.t.icon_grade_middle_star_s);
                        }
                        this.w.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.c);
                    if (j) {
                        ay.c(imageView2, com.baidu.tieba.t.icon_vip_grade_big_middle_n);
                    } else {
                        ay.c(imageView2, com.baidu.tieba.t.icon_grade_middle_star_n);
                    }
                    this.w.addView(imageView2);
                }
                if (k) {
                    this.ac.setVisibility(0);
                } else {
                    this.ac.setVisibility(8);
                }
            }
            if (jVar.h() && !x()) {
                this.ai.removeMessages(0);
                this.ai.sendEmptyMessageDelayed(0, 600L);
            }
            if (jVar.a() != null) {
                this.h.setVisibility(0);
                this.d.setVisibility(0);
                GroupActivityData a2 = jVar.a();
                if (!jVar.g()) {
                    if (a2.getIsEnd() != 1) {
                        this.j.setVisibility(4);
                        this.k.setText(com.baidu.tieba.x.group_info_activity_not_join_tip);
                    }
                } else {
                    this.j.setVisibility(0);
                    this.k.setText(a2.getgActivityTitle());
                    if (a2.getIsEnd() != 1) {
                        this.j.setText(com.baidu.tieba.x.group_info_activity_doing);
                        if (z2) {
                            this.j.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.r.group_info_activity_doing_1));
                        } else {
                            this.j.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.r.group_info_activity_doing));
                        }
                    } else {
                        this.j.setText(com.baidu.tieba.x.group_info_activity_finish);
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            this.j.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.r.group_info_activity_finish_1));
                        } else {
                            this.j.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.r.group_info_activity_finish));
                        }
                    }
                    this.k.setText(a2.getgActivityTitle());
                }
            } else if (jVar.h()) {
                this.h.setVisibility(0);
                this.d.setVisibility(0);
                this.j.setVisibility(4);
                this.k.setText(com.baidu.tieba.x.group_info_create_activity);
            } else {
                this.h.setVisibility(8);
                this.d.setVisibility(8);
            }
            this.G.removeAllViews();
            if (jVar.c() != null && jVar.c().size() > 0) {
                List<MemberData> c = jVar.c();
                int size = c.size();
                int i2 = size > 7 ? 7 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = c.get(i3);
                    HeadImageView headImageView = new HeadImageView(this.c);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(false);
                    headImageView.setTag(String.valueOf(memberData.getUserId()));
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.s.im_group_info_photo_width);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.s.im_group_info_photo_margin);
                    this.G.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.a(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (jVar.h()) {
                this.F.setEnabled(true);
                this.W.setEnabled(true);
                this.T.setVisibility(0);
                this.Y.setVisibility(0);
                this.V.setVisibility(0);
                if (jVar.b() != null) {
                    this.U.setText(jVar.b().getName());
                }
            } else {
                this.F.setEnabled(false);
                this.W.setEnabled(true);
                this.V.setVisibility(8);
                this.Y.setVisibility(8);
                this.n.setPadding(0, 0, 0, 0);
            }
            if (jVar.g()) {
                this.L.setVisibility(0);
                this.Q.setVisibility(0);
                if (this.z.getParent() != this.L) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.s.im_group_info_item_paddingtb);
                    int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.s.im_group_info_item_side_paddinglr);
                    this.z.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, 0);
                    this.N.removeView(this.z);
                    this.L.addView(this.z, 1, layoutParams2);
                }
                s();
            } else {
                this.L.setVisibility(8);
                this.Q.setVisibility(8);
                if (this.z.getParent() != this.N) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.s.im_group_info_item_bigside_paddinglr);
                    this.z.setPadding(dimensionPixelSize4, 0, dimensionPixelSize4, 0);
                    this.L.removeView(this.z);
                    this.N.addView(this.z, 3, layoutParams3);
                }
                if (b(jVar.b().getFlag())) {
                    b(z);
                } else {
                    B();
                }
            }
            if (jVar.b().getGroupType() == 4 || jVar.b().getGroupType() == 5) {
                this.v.setVisibility(8);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.s.im_group_info_item_side_paddinglr);
                this.u.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                this.u.setLayoutParams(layoutParams4);
            } else {
                this.v.setVisibility(0);
            }
            b(jVar);
            if (jVar.b().getIsHidePosition() == 1) {
                a(jVar.h());
            } else {
                a(jVar.h(), this.R);
            }
        }
    }

    public void s() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.t.icon_brief_jinba_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.r.group_info_bottom_text_1));
            this.ae.setBackgroundResource(com.baidu.tieba.t.group_info_foot_selector_1);
        } else {
            this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.t.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
            this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.r.group_info_bottom_text));
            this.ae.setBackgroundResource(com.baidu.tieba.t.group_info_foot_selector);
        }
        this.I.setText(this.c.getString(com.baidu.tieba.x.group_info_enter_chat));
        this.ae.setEnabled(true);
    }

    private void b(boolean z) {
        this.I.setText(this.c.getString(com.baidu.tieba.x.group_info_join));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (z) {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.t.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.r.group_info_bottom_text_1));
            } else {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.t.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.r.group_info_join_disable_color_1));
            }
            this.ae.setBackgroundResource(com.baidu.tieba.t.group_info_foot_selector_1);
        } else {
            if (z) {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.t.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
                this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.r.white));
            } else {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.t.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
                this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.r.group_info_join_disable_color));
            }
            this.ae.setBackgroundResource(com.baidu.tieba.t.group_info_foot_selector);
        }
        this.ae.setEnabled(true);
    }

    private boolean b(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void B() {
        this.I.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.I.setText(this.c.getString(com.baidu.tieba.x.group_info_refuse_join));
        this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.r.group_info_join_resuse_color));
        this.ae.setBackgroundColor(0);
        this.ae.setEnabled(false);
    }

    public void c(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.G.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.G.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.G.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void b(com.baidu.tieba.im.message.j jVar) {
        if (jVar != null) {
            this.q.setIsManager(jVar.h());
            if (jVar.h()) {
                this.q.setVisibility(0);
                if (jVar.d() != null && jVar.d().size() == 1 && TextUtils.isEmpty(jVar.d().get(0).getPicId())) {
                    this.q.setData(null);
                } else {
                    this.q.setData(jVar.d());
                }
            } else if (jVar.d() != null && jVar.d().size() > 0) {
                if (jVar.d().size() == 1 && TextUtils.isEmpty(jVar.d().get(0).getPicId())) {
                    this.q.setVisibility(8);
                    return;
                }
                this.q.setVisibility(0);
                this.q.setData(jVar.d());
            } else {
                this.q.setVisibility(8);
            }
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void a(ac acVar) {
        this.P = acVar;
    }

    public void t() {
        if (this.s == null) {
            C();
        }
        com.baidu.adp.lib.e.e.a(this.s, this.c);
    }

    private void C() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
        builder.setTitle(this.c.getResources().getString(com.baidu.tieba.x.operation));
        builder.setItems(new String[]{this.c.getResources().getString(com.baidu.tieba.x.take_photo), this.c.getResources().getString(com.baidu.tieba.x.album)}, this.r);
        this.s = builder.create();
        this.s.setCanceledOnTouchOutside(true);
    }

    public void a(Object obj, int i) {
        if (this.O != null) {
            this.O.dismiss();
            this.O = null;
        }
        b(obj, i);
        com.baidu.adp.lib.e.e.a(this.O, this.c);
    }

    public void u() {
        this.O.dismiss();
    }

    private void b(Object obj, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
        builder.setTitle(this.c.getResources().getString(com.baidu.tieba.x.operation));
        builder.setItems(new String[]{this.c.getResources().getString(com.baidu.tieba.x.group_info_set_portrait), this.c.getResources().getString(com.baidu.tieba.x.delete), this.c.getResources().getString(com.baidu.tieba.x.cancel)}, new v(this, obj, i));
        this.O = builder.create();
        this.O.setCanceledOnTouchOutside(true);
    }

    public void v() {
        if (this.q != null) {
            this.q.a();
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.c.getString(com.baidu.tieba.x.copy_group_introduction)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
            builder.setTitle(this.c.getString(com.baidu.tieba.x.operation));
            builder.setItems(charSequenceArr, new w(this, str));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.e.e.a(create, this.c);
        }
    }

    public void e(String str) {
        if (this.M == null) {
            g(str);
        }
        com.baidu.adp.lib.e.e.a(this.M, this.c);
    }

    private void g(String str) {
        if (this.M == null) {
            CharSequence[] charSequenceArr = {this.c.getString(com.baidu.tieba.x.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
            builder.setTitle(this.c.getString(com.baidu.tieba.x.operation));
            builder.setItems(charSequenceArr, new x(this, str));
            this.M = builder.create();
            this.M.setCanceledOnTouchOutside(true);
        }
    }

    public void w() {
        ColorStateList colorStateList;
        Resources resources = this.c.getResources();
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            colorStateList = resources.getColorStateList(com.baidu.tieba.r.group_info_join_disable_color_1);
            if (colorStateList != null) {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.t.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else {
            colorStateList = resources.getColorStateList(com.baidu.tieba.r.group_info_join_disable_color);
            if (colorStateList != null) {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.t.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.I.setTextColor(colorStateList);
    }

    public void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a((View) this.e);
        this.c.getLayoutMode().a(this.D);
        this.q.a(i, this.c);
        this.af.c(i);
        if (this.ah != null && this.ah.j()) {
            ay.a(this.ag, com.baidu.tieba.r.im_group_vip_text, 1);
        }
    }
}
