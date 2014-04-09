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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.bk;
import java.util.List;
/* loaded from: classes.dex */
public final class r extends com.baidu.adp.a.f {
    public static int a = 0;
    public static int c = 0;
    private AlertDialog A;
    private ImageView B;
    private PopupWindow C;
    private final View D;
    private DialogInterface.OnClickListener E;
    private RelativeLayout F;
    private final com.baidu.tbadk.editortool.ab G;
    private LinearLayout H;
    private LinearLayout I;
    private TextView J;
    private RelativeLayout K;
    private RelativeLayout L;
    private LinearLayout M;
    private Dialog N;
    private LinearLayout O;
    private Dialog P;
    private ad Q;
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
    private final boolean ae;
    private LinearLayout af;
    private NavigationBar ag;
    private TextView ah;
    private final Handler ai;
    private final GroupInfoActivity d;
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
        this.S = "";
        this.ae = true;
        this.ai = new s(this);
        this.d = groupInfoActivity;
        groupInfoActivity.setContentView(com.baidu.tieba.im.i.im_group_info_activity);
        this.G = new com.baidu.tbadk.editortool.ab(groupInfoActivity);
        this.G.a(false);
        this.D = ((LayoutInflater) groupInfoActivity.getSystemService("layout_inflater")).inflate(com.baidu.tieba.im.i.group_activity_guide_toast, (ViewGroup) null);
        this.ag = (NavigationBar) groupInfoActivity.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.f = this.ag.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ah = this.ag.a("");
        this.R = this.ag.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupInfoActivity.getString(com.baidu.tieba.im.j.setup));
        this.R.setOnClickListener(groupInfoActivity);
        this.R.setVisibility(8);
        this.e = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.group_info_container);
        this.h = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_activity);
        this.h.setOnClickListener(groupInfoActivity);
        this.i = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.tv_activity_name);
        this.j = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_activity_status);
        this.k = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_activity_name);
        this.F = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.address_layout);
        this.F.setOnClickListener(groupInfoActivity);
        this.O = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_body);
        this.T = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.img_group_type_icon);
        this.l = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_group_number);
        this.m = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_group_place);
        this.Z = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.img_group_place);
        this.n = (EllipsizingTextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_group_intro);
        this.n.setMaxLines(20);
        this.n.a(new t(this));
        this.p = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_forum);
        this.o = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_group_forum);
        this.p.setOnClickListener(groupInfoActivity);
        this.x = (HeadImageView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.img_group_author);
        this.x.setAutoChangeStyle(true);
        this.x.setIsRound(true);
        this.t = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_group_author);
        this.u = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_author);
        this.u.setOnClickListener(groupInfoActivity);
        this.B = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.meizhi_icon);
        this.ab = groupInfoActivity.findViewById(com.baidu.tieba.im.h.line_group_author_down);
        this.w = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_grade_star);
        this.p.setOnClickListener(groupInfoActivity);
        this.v = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_grade);
        this.v.setOnClickListener(groupInfoActivity);
        this.y = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_group_member_count);
        this.z = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_member);
        this.z.setOnClickListener(groupInfoActivity);
        this.H = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_member_photo);
        this.I = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.bottom_bar);
        this.af = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_bottom_button);
        this.J = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_join);
        this.af.setOnClickListener(this.d);
        this.K = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_share);
        this.K.setOnClickListener(groupInfoActivity);
        this.L = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_invite);
        this.L.setOnClickListener(groupInfoActivity);
        this.M = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_notice_share);
        this.U = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_name);
        this.U.setOnClickListener(groupInfoActivity);
        this.V = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_group_name);
        this.W = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.img_group_intro_arrow);
        this.aa = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.img_group_author_arrow);
        this.X = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_intro);
        this.X.setOnClickListener(groupInfoActivity);
        this.X.setOnClickListener(groupInfoActivity);
        this.X.setLongClickable(true);
        this.X.setOnLongClickListener(groupInfoActivity);
        this.ac = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.txt_group_intro_more);
        this.ac.setClickable(true);
        this.ac.setOnClickListener(new u(this));
        this.Y = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.im.h.lay_group_number);
        this.Y.setOnLongClickListener(groupInfoActivity);
        this.ad = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.can_create_mem_group);
        this.g = (ProgressBar) groupInfoActivity.findViewById(com.baidu.tieba.im.h.progress_loading);
        this.q = (PhotoWallView) groupInfoActivity.findViewById(com.baidu.tieba.im.h.photo_wall);
        this.q.setPhotoClickListener(groupInfoActivity);
        this.q.setPhotoLongClickListener(groupInfoActivity);
        this.q.setVisibility(8);
    }

    public final void a() {
        this.ai.removeMessages(0);
        z();
    }

    public final void a(String str) {
        this.V.setText(str);
        f(str);
    }

    private void f(String str) {
        if (str != null) {
            this.ah.setText(str);
        }
    }

    public final void b(String str) {
        this.n.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(r rVar) {
        try {
            if (rVar.C == null) {
                rVar.C = new PopupWindow(rVar.d);
                rVar.C.setContentView(rVar.D);
                rVar.C.setWidth(rVar.d.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.ds504));
                rVar.C.setHeight(rVar.d.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.ds128));
                rVar.C.setBackgroundDrawable(new BitmapDrawable());
                rVar.C.setOutsideTouchable(true);
                rVar.C.setFocusable(true);
            }
            if (rVar.C.isShowing()) {
                rVar.C.dismiss();
            } else {
                rVar.C.showAsDropDown(rVar.i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.C != null && this.C.isShowing()) {
            try {
                this.C.dismiss();
                this.C = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final RelativeLayout d() {
        return this.Y;
    }

    public final RelativeLayout e() {
        return this.p;
    }

    public final LinearLayout f() {
        return this.H;
    }

    public final RelativeLayout g() {
        return this.K;
    }

    public final RelativeLayout h() {
        return this.L;
    }

    public final RelativeLayout i() {
        return this.X;
    }

    public final RelativeLayout j() {
        return this.U;
    }

    public final RelativeLayout k() {
        return this.h;
    }

    public final TextView l() {
        return this.R;
    }

    public final LinearLayout m() {
        return this.af;
    }

    public final RelativeLayout n() {
        return this.u;
    }

    public final RelativeLayout o() {
        return this.v;
    }

    public final RelativeLayout p() {
        return this.z;
    }

    public final View q() {
        return this.f;
    }

    public final void r() {
        this.g.setVisibility(8);
    }

    public final void s() {
        this.g.setVisibility(0);
    }

    public final void a(boolean z, String str) {
        if (!z && TextUtils.isEmpty(str)) {
            this.F.setVisibility(8);
            return;
        }
        this.m.setText(str);
        this.F.setVisibility(0);
    }

    public final void a(boolean z) {
        if (z) {
            this.m.setText(this.b.getString(com.baidu.tieba.im.j.group_info_address_hide));
        } else {
            this.F.setVisibility(8);
        }
    }

    public final RelativeLayout t() {
        return this.F;
    }

    public final void a(bk bkVar) {
        a(bkVar, false);
    }

    public final void a(bk bkVar, boolean z) {
        if (bkVar != null) {
            if (bkVar.b() != null) {
                a = bkVar.b().getGroupId();
            }
            if (bkVar.a() != null) {
                c = bkVar.a().getActivityId();
            }
            boolean z2 = TbadkApplication.j().l() == 1;
            this.O.setVisibility(0);
            this.I.setVisibility(0);
            if (bkVar.b() != null) {
                f(bkVar.b().getName());
                this.l.setText(String.valueOf(bkVar.b().getGroupId()));
                if (bkVar.b().isMeizhi()) {
                    this.B.setVisibility(0);
                } else {
                    this.B.setVisibility(8);
                }
                if (bkVar.b().getGroupType() == 4) {
                    this.T.setVisibility(0);
                    this.x.setVisibility(8);
                    this.aa.setVisibility(8);
                    this.ab.setVisibility(8);
                    this.t.setText(com.baidu.tieba.im.j.group_info_forum_author);
                    this.u.setEnabled(false);
                    this.B.setVisibility(8);
                } else {
                    this.T.setVisibility(8);
                    this.x.setVisibility(0);
                    this.aa.setVisibility(0);
                    this.ab.setVisibility(0);
                    this.t.setText(bkVar.b().getAuthorName());
                    this.u.setEnabled(true);
                }
                String position = bkVar.b().getPosition();
                String business = bkVar.b().getBusiness();
                StringBuffer stringBuffer = new StringBuffer();
                if (position != null) {
                    stringBuffer.append(position);
                }
                if (business != null) {
                    stringBuffer.append(business);
                }
                this.S = stringBuffer.toString();
                this.m.setText(this.S);
                this.n.setText(bkVar.b().getIntro());
                this.y.setText("(" + bkVar.b().getMemberNum() + "/" + bkVar.b().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(bkVar.b().getAuthorPortrait())) {
                    this.G.c(bkVar.b().getAuthorPortrait(), new v(this));
                }
                if (bkVar.b().getForumName() != null && bkVar.b().getForumName().length() > 0) {
                    this.p.setVisibility(0);
                    this.o.setText(String.valueOf(bkVar.b().getForumName()) + this.d.getString(com.baidu.tieba.im.j.bar));
                } else {
                    this.p.setVisibility(8);
                }
                this.w.removeAllViews();
                boolean k = bkVar.k();
                boolean j = bkVar.j();
                if (j) {
                    ba.a(this.ah, com.baidu.tieba.im.e.im_group_vip_text, 1);
                }
                if (bkVar.b().getGrade() > 0) {
                    for (int i = 0; i < bkVar.b().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.d);
                        if (j) {
                            ba.c(imageView, com.baidu.tieba.im.g.icon_vip_grade_big_middle_s);
                        } else {
                            ba.c(imageView, com.baidu.tieba.im.g.icon_grade_middle_star_s);
                        }
                        this.w.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.d);
                    if (j) {
                        ba.c(imageView2, com.baidu.tieba.im.g.icon_vip_grade_big_middle_n);
                    } else {
                        ba.c(imageView2, com.baidu.tieba.im.g.icon_grade_middle_star_n);
                    }
                    this.w.addView(imageView2);
                }
                if (k) {
                    this.ad.setVisibility(0);
                } else {
                    this.ad.setVisibility(8);
                }
            }
            if (bkVar.h() && !com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_activity_guide_toast", false)) {
                this.ai.removeMessages(0);
                this.ai.sendEmptyMessageDelayed(0, 600L);
            }
            if (bkVar.a() != null) {
                this.h.setVisibility(0);
                GroupActivityData a2 = bkVar.a();
                if (!bkVar.g()) {
                    if (a2.getIsEnd() != 1) {
                        this.j.setVisibility(4);
                        this.k.setText(com.baidu.tieba.im.j.group_info_activity_not_join_tip);
                    }
                } else {
                    this.j.setVisibility(0);
                    this.k.setText(a2.getgActivityTitle());
                    if (a2.getIsEnd() != 1) {
                        this.j.setText(com.baidu.tieba.im.j.group_info_activity_doing);
                        if (z2) {
                            this.j.setTextColor(this.b.getResources().getColor(com.baidu.tieba.im.e.group_info_activity_doing_1));
                        } else {
                            this.j.setTextColor(this.b.getResources().getColor(com.baidu.tieba.im.e.group_info_activity_doing));
                        }
                    } else {
                        this.j.setText(com.baidu.tieba.im.j.group_info_activity_finish);
                        if (TbadkApplication.j().l() == 1) {
                            this.j.setTextColor(this.b.getResources().getColor(com.baidu.tieba.im.e.group_info_activity_finish_1));
                        } else {
                            this.j.setTextColor(this.b.getResources().getColor(com.baidu.tieba.im.e.group_info_activity_finish));
                        }
                    }
                    this.k.setText(a2.getgActivityTitle());
                }
            } else if (bkVar.h()) {
                this.h.setVisibility(0);
                this.j.setVisibility(4);
                this.k.setText(com.baidu.tieba.im.j.group_info_create_activity);
            } else {
                this.h.setVisibility(8);
            }
            this.H.removeAllViews();
            if (bkVar.c() != null && bkVar.c().size() > 0) {
                List<MemberData> c2 = bkVar.c();
                int size = c2.size();
                int i2 = size > 7 ? 7 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = c2.get(i3);
                    HeadImageView headImageView = new HeadImageView(this.d);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(true);
                    headImageView.setTag(String.valueOf(memberData.getUserId()));
                    headImageView.setDefaultResource(com.baidu.tieba.im.g.photo);
                    headImageView.setNightDefaultResource(com.baidu.tieba.im.g.photo);
                    int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.im_group_info_photo_width);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.im_group_info_photo_margin);
                    this.H.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        com.baidu.tbadk.editortool.ab abVar = this.G;
                        com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(memberData.getPortrait());
                        if (b != null) {
                            b.a(headImageView);
                        } else {
                            this.G.c(memberData.getPortrait(), new w(this, headImageView));
                        }
                    }
                }
            }
            if (bkVar.h()) {
                this.F.setEnabled(true);
                this.X.setEnabled(true);
                this.U.setVisibility(0);
                this.Z.setVisibility(0);
                this.W.setVisibility(0);
                if (bkVar.b() != null) {
                    this.V.setText(bkVar.b().getName());
                }
            } else {
                this.F.setEnabled(false);
                this.X.setEnabled(true);
                this.W.setVisibility(8);
                this.Z.setVisibility(8);
                this.n.setPadding(0, 0, 0, 0);
            }
            if (bkVar.g()) {
                this.M.setVisibility(0);
                this.R.setVisibility(0);
                if (this.z.getParent() != this.M) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.im_group_info_item_paddingtb);
                    int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.im_group_info_item_side_paddinglr);
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
                    int dimensionPixelSize4 = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.im_group_info_item_bigside_paddinglr);
                    this.z.setPadding(dimensionPixelSize4, 0, dimensionPixelSize4, 0);
                    this.M.removeView(this.z);
                    this.O.addView(this.z, 3, layoutParams3);
                }
                if (((bkVar.b().getFlag() & 2) >> 1) != 1) {
                    this.J.setText(this.d.getString(com.baidu.tieba.im.j.group_info_join));
                    if (TbadkApplication.j().l() == 1) {
                        if (z) {
                            this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                            this.J.setTextColor(this.d.getResources().getColorStateList(com.baidu.tieba.im.e.group_info_bottom_text_1));
                        } else {
                            this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
                            this.J.setTextColor(this.d.getResources().getColorStateList(com.baidu.tieba.im.e.group_info_join_disable_color_1));
                        }
                        this.af.setBackgroundResource(com.baidu.tieba.im.g.group_info_foot_selector_1);
                    } else {
                        if (z) {
                            this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
                            this.J.setTextColor(this.d.getResources().getColorStateList(com.baidu.tieba.im.e.white));
                        } else {
                            this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
                            this.J.setTextColor(this.d.getResources().getColorStateList(com.baidu.tieba.im.e.group_info_join_disable_color));
                        }
                        this.af.setBackgroundResource(com.baidu.tieba.im.g.group_info_foot_selector);
                    }
                    this.af.setEnabled(true);
                } else {
                    this.J.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.J.setText(this.d.getString(com.baidu.tieba.im.j.group_info_refuse_join));
                    this.J.setTextColor(this.d.getResources().getColorStateList(com.baidu.tieba.im.e.group_info_join_resuse_color));
                    this.af.setBackgroundColor(0);
                    this.af.setEnabled(false);
                }
            }
            if (bkVar.b().getGroupType() == 4 || bkVar.b().getGroupType() == 5) {
                this.v.setVisibility(8);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelSize5 = this.b.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.im_group_info_item_side_paddinglr);
                this.u.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                this.u.setLayoutParams(layoutParams4);
            } else {
                this.v.setVisibility(0);
            }
            b(bkVar);
            if (bkVar.b().getIsHidePosition() == 1) {
                a(bkVar.h());
            } else {
                a(bkVar.h(), this.S);
            }
        }
    }

    public final void u() {
        if (TbadkApplication.j().l() == 1) {
            this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_jinba_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.J.setTextColor(this.d.getResources().getColorStateList(com.baidu.tieba.im.e.group_info_bottom_text_1));
            this.af.setBackgroundResource(com.baidu.tieba.im.g.group_info_foot_selector_1);
        } else {
            this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
            this.J.setTextColor(this.d.getResources().getColorStateList(com.baidu.tieba.im.e.group_info_bottom_text));
            this.af.setBackgroundResource(com.baidu.tieba.im.g.group_info_foot_selector);
        }
        this.J.setText(this.d.getString(com.baidu.tieba.im.j.group_info_enter_chat));
        this.af.setEnabled(true);
    }

    public final void c(String str) {
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

    public final void b(bk bkVar) {
        if (bkVar != null) {
            this.q.setIsManager(bkVar.h());
            if (bkVar.h()) {
                this.q.setVisibility(0);
                if (bkVar.d() != null && bkVar.d().size() == 1 && TextUtils.isEmpty(bkVar.d().get(0).getPicId())) {
                    this.q.setData(null);
                } else {
                    this.q.setData(bkVar.d());
                }
            } else if (bkVar.d() != null && bkVar.d().size() > 0 && (bkVar.d().size() != 1 || !TextUtils.isEmpty(bkVar.d().get(0).getPicId()))) {
                this.q.setVisibility(0);
                this.q.setData(bkVar.d());
            } else {
                this.q.setVisibility(8);
            }
        }
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public final void a(ad adVar) {
        this.Q = adVar;
    }

    public final void v() {
        if (this.s == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
            builder.setTitle(this.d.getResources().getString(com.baidu.tieba.im.j.operation));
            builder.setItems(new String[]{this.d.getResources().getString(com.baidu.tieba.im.j.take_photo), this.d.getResources().getString(com.baidu.tieba.im.j.album)}, this.r);
            this.s = builder.create();
            this.s.setCanceledOnTouchOutside(true);
        }
        this.s.show();
    }

    public final void a(Object obj, int i) {
        if (this.P != null) {
            this.P.dismiss();
            this.P = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(this.d.getResources().getString(com.baidu.tieba.im.j.operation));
        builder.setItems(new String[]{this.d.getResources().getString(com.baidu.tieba.im.j.group_info_set_portrait), this.d.getResources().getString(com.baidu.tieba.im.j.delete), this.d.getResources().getString(com.baidu.tieba.im.j.cancel)}, new x(this, obj, i));
        this.P = builder.create();
        this.P.setCanceledOnTouchOutside(true);
        this.P.show();
    }

    public final void w() {
        this.P.dismiss();
    }

    public final void x() {
        if (this.q != null) {
            this.q.a();
        }
    }

    public final void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.d.getString(com.baidu.tieba.im.j.copy_group_introduction)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
            builder.setTitle(this.d.getString(com.baidu.tieba.im.j.operation));
            builder.setItems(charSequenceArr, new y(this, str));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
    }

    public final void e(String str) {
        if (this.N == null && this.N == null) {
            CharSequence[] charSequenceArr = {this.d.getString(com.baidu.tieba.im.j.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
            builder.setTitle(this.d.getString(com.baidu.tieba.im.j.operation));
            builder.setItems(charSequenceArr, new z(this, str));
            this.N = builder.create();
            this.N.setCanceledOnTouchOutside(true);
        }
        this.N.show();
    }

    public final void y() {
        ColorStateList colorStateList;
        Resources resources = this.d.getResources();
        if (TbadkApplication.j().l() == 1) {
            colorStateList = resources.getColorStateList(com.baidu.tieba.im.e.group_info_join_disable_color_1);
            if (colorStateList != null) {
                this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_attention_1), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else {
            colorStateList = resources.getColorStateList(com.baidu.tieba.im.e.group_info_join_disable_color);
            if (colorStateList != null) {
                this.J.setCompoundDrawablesWithIntrinsicBounds(this.d.getResources().getDrawable(com.baidu.tieba.im.g.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        this.J.setTextColor(colorStateList);
    }

    public final void a(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a(this.e);
        this.d.getLayoutMode().a(this.D);
        this.q.a((com.baidu.tbadk.a) this.d);
        this.ag.b(i);
    }
}
