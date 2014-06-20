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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.c {
    public static int a = 0;
    public static int b = 0;
    private ImageView A;
    private PopupWindow B;
    private final View C;
    private DialogInterface.OnClickListener D;
    private RelativeLayout E;
    private final com.baidu.tbadk.editortool.ab F;
    private LinearLayout G;
    private LinearLayout H;
    private TextView I;
    private RelativeLayout J;
    private RelativeLayout K;
    private LinearLayout L;
    private Dialog M;
    private LinearLayout N;
    private Dialog O;
    private ad P;
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
    private final Handler ah;
    private final GroupInfoActivity c;
    private RelativeLayout d;
    private View e;
    private ProgressBar f;
    private RelativeLayout g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private EllipsizingTextView m;
    private TextView n;
    private RelativeLayout o;
    private PhotoWallView p;
    private DialogInterface.OnClickListener q;
    private Dialog r;
    private TextView s;
    private RelativeLayout t;
    private RelativeLayout u;
    private LinearLayout v;
    private HeadImageView w;
    private TextView x;
    private RelativeLayout y;
    private AlertDialog z;

    public r(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity);
        this.q = null;
        this.r = null;
        this.z = null;
        this.D = null;
        this.R = "";
        this.ad = true;
        this.ah = new s(this);
        this.c = groupInfoActivity;
        groupInfoActivity.setContentView(com.baidu.tieba.w.im_group_info_activity);
        this.F = new com.baidu.tbadk.editortool.ab(groupInfoActivity);
        this.F.d(false);
        this.C = ((LayoutInflater) groupInfoActivity.getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.group_activity_guide_toast, (ViewGroup) null);
        a(groupInfoActivity);
        b(groupInfoActivity);
        c(groupInfoActivity);
    }

    public void a() {
        this.ah.removeMessages(0);
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
        this.m.setText(str);
    }

    private void a(GroupInfoActivity groupInfoActivity) {
        this.af = (NavigationBar) groupInfoActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.e = this.af.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ag = this.af.a("");
        this.Q = this.af.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupInfoActivity.getString(com.baidu.tieba.y.setup));
        this.Q.setOnClickListener(groupInfoActivity);
        this.Q.setVisibility(8);
    }

    private void b(GroupInfoActivity groupInfoActivity) {
        this.d = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.group_info_container);
        this.g = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_activity);
        this.g.setOnClickListener(groupInfoActivity);
        this.h = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.tv_activity_name);
        this.i = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_activity_status);
        this.j = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_activity_name);
        this.E = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.address_layout);
        this.E.setOnClickListener(groupInfoActivity);
        this.N = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_body);
        this.S = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_type_icon);
        this.k = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_number);
        this.l = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_place);
        this.Y = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_place);
        this.m = (EllipsizingTextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_intro);
        this.m.setMaxLines(20);
        this.m.a(new t(this));
        this.o = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_forum);
        this.n = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_forum);
        this.o.setOnClickListener(groupInfoActivity);
        this.w = (HeadImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_author);
        this.w.setAutoChangeStyle(true);
        this.w.setIsRound(true);
        this.s = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_author);
        this.t = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_author);
        this.t.setOnClickListener(groupInfoActivity);
        this.A = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.meizhi_icon);
        this.aa = groupInfoActivity.findViewById(com.baidu.tieba.v.line_group_author_down);
        this.v = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_grade_star);
        this.o.setOnClickListener(groupInfoActivity);
        this.u = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_grade);
        this.u.setOnClickListener(groupInfoActivity);
        this.x = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_member_count);
        this.y = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_member);
        this.y.setOnClickListener(groupInfoActivity);
        this.G = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_member_photo);
        this.H = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.bottom_bar);
        this.ae = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_bottom_button);
        this.I = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_join);
        this.ae.setOnClickListener(this.c);
        this.J = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_share);
        this.J.setOnClickListener(groupInfoActivity);
        this.K = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_invite);
        this.K.setOnClickListener(groupInfoActivity);
        this.L = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_notice_share);
        this.T = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_name);
        this.T.setOnClickListener(groupInfoActivity);
        this.U = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_name);
        this.V = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_intro_arrow);
        this.Z = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_author_arrow);
        this.W = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_intro);
        this.W.setOnClickListener(groupInfoActivity);
        this.W.setOnClickListener(groupInfoActivity);
        this.W.setLongClickable(true);
        this.W.setOnLongClickListener(groupInfoActivity);
        this.ab = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_intro_more);
        this.ab.setClickable(true);
        this.ab.setOnClickListener(new u(this));
        this.X = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_number);
        this.X.setOnLongClickListener(groupInfoActivity);
        this.ac = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.can_create_mem_group);
        this.f = (ProgressBar) groupInfoActivity.findViewById(com.baidu.tieba.v.progress_loading);
    }

    private void c(GroupInfoActivity groupInfoActivity) {
        this.p = (PhotoWallView) groupInfoActivity.findViewById(com.baidu.tieba.v.photo_wall);
        this.p.setPhotoClickListener(groupInfoActivity);
        this.p.setPhotoLongClickListener(groupInfoActivity);
        this.p.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        try {
            if (this.B == null) {
                this.B = new PopupWindow(this.c);
                this.B.setContentView(this.C);
                this.B.setWidth(this.c.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds504));
                this.B.setHeight(this.c.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds128));
                this.B.setBackgroundDrawable(new BitmapDrawable());
                this.B.setOutsideTouchable(true);
                this.B.setFocusable(true);
            }
            if (this.B.isShowing()) {
                this.B.dismiss();
            } else {
                this.B.showAsDropDown(this.h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.B != null && this.B.isShowing()) {
            try {
                this.B.dismiss();
                this.B = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public RelativeLayout b() {
        return this.X;
    }

    public RelativeLayout c() {
        return this.o;
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
        return this.g;
    }

    public TextView j() {
        return this.Q;
    }

    public LinearLayout k() {
        return this.ae;
    }

    public RelativeLayout l() {
        return this.t;
    }

    public RelativeLayout m() {
        return this.u;
    }

    public RelativeLayout n() {
        return this.y;
    }

    public View o() {
        return this.e;
    }

    public void p() {
        this.f.setVisibility(8);
    }

    public void q() {
        this.f.setVisibility(0);
    }

    public void a(boolean z, String str) {
        if (z) {
            this.l.setText(str);
            this.E.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.E.setVisibility(8);
        } else {
            this.l.setText(str);
            this.E.setVisibility(0);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.l.setText(this.mContext.getString(com.baidu.tieba.y.group_info_address_hide));
        } else {
            this.E.setVisibility(8);
        }
    }

    public RelativeLayout r() {
        return this.E;
    }

    public void a(com.baidu.tieba.im.message.f fVar) {
        a(fVar, false);
    }

    public void a(com.baidu.tieba.im.message.f fVar, boolean z) {
        if (fVar != null) {
            if (fVar.b() != null) {
                a = fVar.b().getGroupId();
            }
            if (fVar.a() != null) {
                b = fVar.a().getActivityId();
            }
            boolean z2 = TbadkApplication.m252getInst().getSkinType() == 1;
            this.N.setVisibility(0);
            this.H.setVisibility(0);
            if (fVar.b() != null) {
                f(fVar.b().getName());
                this.k.setText(String.valueOf(fVar.b().getGroupId()));
                if (fVar.b().isMeizhi()) {
                    this.A.setVisibility(0);
                } else {
                    this.A.setVisibility(8);
                }
                if (fVar.b().getGroupType() == 4) {
                    this.S.setVisibility(0);
                    this.w.setVisibility(8);
                    this.Z.setVisibility(8);
                    this.aa.setVisibility(8);
                    this.s.setText(com.baidu.tieba.y.group_info_forum_author);
                    this.t.setEnabled(false);
                    this.A.setVisibility(8);
                } else {
                    this.S.setVisibility(8);
                    this.w.setVisibility(0);
                    this.Z.setVisibility(0);
                    this.aa.setVisibility(0);
                    this.s.setText(fVar.b().getAuthorName());
                    this.t.setEnabled(true);
                }
                String position = fVar.b().getPosition();
                String business = fVar.b().getBusiness();
                StringBuffer stringBuffer = new StringBuffer();
                if (position != null) {
                    stringBuffer.append(position);
                }
                if (business != null) {
                    stringBuffer.append(business);
                }
                this.R = stringBuffer.toString();
                this.l.setText(this.R);
                this.m.setText(fVar.b().getIntro());
                this.x.setText("(" + fVar.b().getMemberNum() + "/" + fVar.b().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(fVar.b().getAuthorPortrait())) {
                    this.F.c(fVar.b().getAuthorPortrait(), new v(this));
                }
                if (fVar.b().getForumName() != null && fVar.b().getForumName().length() > 0) {
                    this.o.setVisibility(0);
                    this.n.setText(String.valueOf(fVar.b().getForumName()) + this.c.getString(com.baidu.tieba.y.bar));
                } else {
                    this.o.setVisibility(8);
                }
                this.v.removeAllViews();
                boolean k = fVar.k();
                boolean j = fVar.j();
                if (j) {
                    be.a(this.ag, com.baidu.tieba.s.im_group_vip_text, 1);
                }
                if (fVar.b().getGrade() > 0) {
                    for (int i = 0; i < fVar.b().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.c);
                        if (j) {
                            be.c(imageView, com.baidu.tieba.u.icon_vip_grade_big_middle_s);
                        } else {
                            be.c(imageView, com.baidu.tieba.u.icon_grade_middle_star_s);
                        }
                        this.v.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.c);
                    if (j) {
                        be.c(imageView2, com.baidu.tieba.u.icon_vip_grade_big_middle_n);
                    } else {
                        be.c(imageView2, com.baidu.tieba.u.icon_grade_middle_star_n);
                    }
                    this.v.addView(imageView2);
                }
                if (k) {
                    this.ac.setVisibility(0);
                } else {
                    this.ac.setVisibility(8);
                }
            }
            if (fVar.h() && !x()) {
                this.ah.removeMessages(0);
                this.ah.sendEmptyMessageDelayed(0, 600L);
            }
            if (fVar.a() != null) {
                this.g.setVisibility(0);
                GroupActivityData a2 = fVar.a();
                if (!fVar.g()) {
                    if (a2.getIsEnd() != 1) {
                        this.i.setVisibility(4);
                        this.j.setText(com.baidu.tieba.y.group_info_activity_not_join_tip);
                    }
                } else {
                    this.i.setVisibility(0);
                    this.j.setText(a2.getgActivityTitle());
                    if (a2.getIsEnd() != 1) {
                        this.i.setText(com.baidu.tieba.y.group_info_activity_doing);
                        if (z2) {
                            this.i.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.group_info_activity_doing_1));
                        } else {
                            this.i.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.group_info_activity_doing));
                        }
                    } else {
                        this.i.setText(com.baidu.tieba.y.group_info_activity_finish);
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            this.i.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.group_info_activity_finish_1));
                        } else {
                            this.i.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.group_info_activity_finish));
                        }
                    }
                    this.j.setText(a2.getgActivityTitle());
                }
            } else if (fVar.h()) {
                this.g.setVisibility(0);
                this.i.setVisibility(4);
                this.j.setText(com.baidu.tieba.y.group_info_create_activity);
            } else {
                this.g.setVisibility(8);
            }
            this.G.removeAllViews();
            if (fVar.c() != null && fVar.c().size() > 0) {
                List<MemberData> c = fVar.c();
                int size = c.size();
                int i2 = size > 7 ? 7 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = c.get(i3);
                    HeadImageView headImageView = new HeadImageView(this.c);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(true);
                    headImageView.setTag(String.valueOf(memberData.getUserId()));
                    headImageView.setDefaultResource(com.baidu.tieba.u.photo);
                    headImageView.setNightDefaultResource(com.baidu.tieba.u.photo);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_photo_width);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_photo_margin);
                    this.G.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        com.baidu.adp.widget.a.a c2 = this.F.c(memberData.getPortrait());
                        if (c2 != null) {
                            c2.a(headImageView);
                        } else {
                            this.F.c(memberData.getPortrait(), new w(this, headImageView));
                        }
                    }
                }
            }
            if (fVar.h()) {
                this.E.setEnabled(true);
                this.W.setEnabled(true);
                this.T.setVisibility(0);
                this.Y.setVisibility(0);
                this.V.setVisibility(0);
                if (fVar.b() != null) {
                    this.U.setText(fVar.b().getName());
                }
            } else {
                this.E.setEnabled(false);
                this.W.setEnabled(true);
                this.V.setVisibility(8);
                this.Y.setVisibility(8);
                this.m.setPadding(0, 0, 0, 0);
            }
            if (fVar.g()) {
                this.L.setVisibility(0);
                this.Q.setVisibility(0);
                if (this.y.getParent() != this.L) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_paddingtb);
                    int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_side_paddinglr);
                    this.y.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, 0);
                    this.N.removeView(this.y);
                    this.L.addView(this.y, 1, layoutParams2);
                }
                s();
            } else {
                this.L.setVisibility(8);
                this.Q.setVisibility(8);
                if (this.y.getParent() != this.N) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_bigside_paddinglr);
                    this.y.setPadding(dimensionPixelSize4, 0, dimensionPixelSize4, 0);
                    this.L.removeView(this.y);
                    this.N.addView(this.y, 3, layoutParams3);
                }
                if (b(fVar.b().getFlag())) {
                    b(z);
                } else {
                    B();
                }
            }
            if (fVar.b().getGroupType() == 4 || fVar.b().getGroupType() == 5) {
                this.u.setVisibility(8);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_side_paddinglr);
                this.t.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                this.t.setLayoutParams(layoutParams4);
            } else {
                this.u.setVisibility(0);
            }
            b(fVar);
            if (fVar.b().getIsHidePosition() == 1) {
                a(fVar.h());
            } else {
                a(fVar.h(), this.R);
            }
        }
    }

    public void s() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.u.icon_brief_jinba_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.s.group_info_bottom_text_1));
            this.ae.setBackgroundResource(com.baidu.tieba.u.group_info_foot_selector_1);
        } else {
            this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.u.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
            this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.s.group_info_bottom_text));
            this.ae.setBackgroundResource(com.baidu.tieba.u.group_info_foot_selector);
        }
        this.I.setText(this.c.getString(com.baidu.tieba.y.group_info_enter_chat));
        this.ae.setEnabled(true);
    }

    private void b(boolean z) {
        this.I.setText(this.c.getString(com.baidu.tieba.y.group_info_join));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (z) {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.u.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.s.group_info_bottom_text_1));
            } else {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.u.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.s.group_info_join_disable_color_1));
            }
            this.ae.setBackgroundResource(com.baidu.tieba.u.group_info_foot_selector_1);
        } else {
            if (z) {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.u.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
                this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.s.white));
            } else {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.u.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
                this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.s.group_info_join_disable_color));
            }
            this.ae.setBackgroundResource(com.baidu.tieba.u.group_info_foot_selector);
        }
        this.ae.setEnabled(true);
    }

    private boolean b(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void B() {
        this.I.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.I.setText(this.c.getString(com.baidu.tieba.y.group_info_refuse_join));
        this.I.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.s.group_info_join_resuse_color));
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

    public void b(com.baidu.tieba.im.message.f fVar) {
        if (fVar != null) {
            this.p.setIsManager(fVar.h());
            if (fVar.h()) {
                this.p.setVisibility(0);
                if (fVar.d() != null && fVar.d().size() == 1 && TextUtils.isEmpty(fVar.d().get(0).getPicId())) {
                    this.p.setData(null);
                } else {
                    this.p.setData(fVar.d());
                }
            } else if (fVar.d() != null && fVar.d().size() > 0) {
                if (fVar.d().size() == 1 && TextUtils.isEmpty(fVar.d().get(0).getPicId())) {
                    this.p.setVisibility(8);
                    return;
                }
                this.p.setVisibility(0);
                this.p.setData(fVar.d());
            } else {
                this.p.setVisibility(8);
            }
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void a(ad adVar) {
        this.P = adVar;
    }

    public void t() {
        if (this.r == null) {
            C();
        }
        this.r.show();
    }

    private void C() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
        builder.setTitle(this.c.getResources().getString(com.baidu.tieba.y.operation));
        builder.setItems(new String[]{this.c.getResources().getString(com.baidu.tieba.y.take_photo), this.c.getResources().getString(com.baidu.tieba.y.album)}, this.q);
        this.r = builder.create();
        this.r.setCanceledOnTouchOutside(true);
    }

    public void a(Object obj, int i) {
        if (this.O != null) {
            this.O.dismiss();
            this.O = null;
        }
        b(obj, i);
        this.O.show();
    }

    public void u() {
        this.O.dismiss();
    }

    private void b(Object obj, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
        builder.setTitle(this.c.getResources().getString(com.baidu.tieba.y.operation));
        builder.setItems(new String[]{this.c.getResources().getString(com.baidu.tieba.y.group_info_set_portrait), this.c.getResources().getString(com.baidu.tieba.y.delete), this.c.getResources().getString(com.baidu.tieba.y.cancel)}, new x(this, obj, i));
        this.O = builder.create();
        this.O.setCanceledOnTouchOutside(true);
    }

    public void v() {
        if (this.p != null) {
            this.p.a();
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.c.getString(com.baidu.tieba.y.copy_group_introduction)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
            builder.setTitle(this.c.getString(com.baidu.tieba.y.operation));
            builder.setItems(charSequenceArr, new y(this, str));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
    }

    public void e(String str) {
        if (this.M == null) {
            g(str);
        }
        this.M.show();
    }

    private void g(String str) {
        if (this.M == null) {
            CharSequence[] charSequenceArr = {this.c.getString(com.baidu.tieba.y.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.c);
            builder.setTitle(this.c.getString(com.baidu.tieba.y.operation));
            builder.setItems(charSequenceArr, new z(this, str));
            this.M = builder.create();
            this.M.setCanceledOnTouchOutside(true);
        }
    }

    public void w() {
        ColorStateList colorStateList;
        Resources resources = this.c.getResources();
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            colorStateList = resources.getColorStateList(com.baidu.tieba.s.group_info_join_disable_color_1);
            if (colorStateList != null) {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.u.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else {
            colorStateList = resources.getColorStateList(com.baidu.tieba.s.group_info_join_disable_color);
            if (colorStateList != null) {
                this.I.setCompoundDrawablesWithIntrinsicBounds(this.c.getResources().getDrawable(com.baidu.tieba.u.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.I.setTextColor(colorStateList);
    }

    public void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a((View) this.d);
        this.c.getLayoutMode().a(this.C);
        this.p.a(i, this.c);
        this.af.c(i);
    }
}
