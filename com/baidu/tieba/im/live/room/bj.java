package com.baidu.tieba.im.live.room;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class bj extends com.baidu.adp.base.f {
    private final int a;
    private final int b;
    private LiveRoomSettingActivity c;
    private View d;
    private NavigationBar e;
    private View f;
    private TextView g;
    private TbImageView h;
    private ImageView i;
    private EditText j;
    private EditText k;
    private EditText l;
    private TextView m;
    private RelativeLayout n;
    private ProgressBar o;
    private boolean p;
    private AlertDialog q;
    private com.baidu.tbadk.editortool.aa r;
    private String s;
    private String t;
    private DialogInterface.OnClickListener u;
    private DialogInterface.OnClickListener v;

    public bj(LiveRoomSettingActivity liveRoomSettingActivity) {
        super(liveRoomSettingActivity);
        this.a = 2;
        this.b = 15;
        this.s = "";
        this.t = "";
        this.u = null;
        this.v = null;
        this.c = liveRoomSettingActivity;
        liveRoomSettingActivity.setContentView(com.baidu.tieba.w.live_room_setting_view);
        a(liveRoomSettingActivity);
    }

    private void a(LiveRoomSettingActivity liveRoomSettingActivity) {
        this.d = (RelativeLayout) liveRoomSettingActivity.findViewById(com.baidu.tieba.v.container);
        this.e = (NavigationBar) liveRoomSettingActivity.findViewById(com.baidu.tieba.v.lay_title_bar);
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, liveRoomSettingActivity);
        this.g = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c.getResources().getString(com.baidu.tieba.y.group_update_done));
        this.g.setOnClickListener(liveRoomSettingActivity);
        this.e.a(com.baidu.tieba.y.live_room_setting);
        this.l = (EditText) liveRoomSettingActivity.findViewById(com.baidu.tieba.v.fxk);
        this.h = (TbImageView) liveRoomSettingActivity.findViewById(com.baidu.tieba.v.cover_photo);
        this.h.setOnClickListener(liveRoomSettingActivity);
        this.h.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.h.setDefaultResource(com.baidu.tieba.u.image_group_qzl);
        this.h.setNightDefaultResource(com.baidu.tieba.u.image_group_qzl_1);
        this.i = (ImageView) liveRoomSettingActivity.findViewById(com.baidu.tieba.v.cover_camera);
        this.i.setOnClickListener(liveRoomSettingActivity);
        this.j = (EditText) liveRoomSettingActivity.findViewById(com.baidu.tieba.v.room_name);
        this.k = (EditText) liveRoomSettingActivity.findViewById(com.baidu.tieba.v.room_intro);
        this.k.setOnTouchListener(new bk(this));
        this.m = (TextView) liveRoomSettingActivity.findViewById(com.baidu.tieba.v.black_count);
        this.n = (RelativeLayout) liveRoomSettingActivity.findViewById(com.baidu.tieba.v.black_list);
        this.n.setOnClickListener(liveRoomSettingActivity);
        this.o = (ProgressBar) liveRoomSettingActivity.findViewById(com.baidu.tieba.v.setting_progress);
        this.j.addTextChangedListener(new bl(this));
        a(false);
        v();
        this.r = new com.baidu.tbadk.editortool.aa(this.c);
    }

    public void a(int i) {
        this.e.c(i);
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.d);
        com.baidu.tbadk.core.util.bk.g(this.g, i);
        u();
    }

    private void a(boolean z) {
        this.p = z;
        this.g.setEnabled(z);
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        int length = this.j.length();
        if (length >= 2 && length <= 15) {
            a(true);
        } else {
            a(false);
        }
    }

    private void u() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (this.p) {
                com.baidu.tbadk.core.util.bk.e((View) this.g, com.baidu.tieba.u.navi_done_text_bg_1);
                this.g.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.s.navi_done_text_1));
                return;
            }
            com.baidu.tbadk.core.util.bk.e((View) this.g, com.baidu.tieba.u.btn_titlebar_finish_d_1);
            this.g.setTextColor(this.c.getResources().getColor(com.baidu.tieba.s.navi_done_text_d_1));
        } else if (this.p) {
            com.baidu.tbadk.core.util.bk.e((View) this.g, com.baidu.tieba.u.navi_done_text_bg);
            this.g.setTextColor(this.c.getResources().getColorStateList(com.baidu.tieba.s.navi_done_text));
        } else {
            com.baidu.tbadk.core.util.bk.e((View) this.g, com.baidu.tieba.u.btn_titlebar_finish_d);
            this.g.setTextColor(this.c.getResources().getColor(com.baidu.tieba.s.navi_done_text_d));
        }
    }

    public TextView a() {
        return this.g;
    }

    public TbImageView b() {
        return this.h;
    }

    public ImageView c() {
        return this.i;
    }

    public View d() {
        return this.f;
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    public String e() {
        return this.j.getText().toString();
    }

    public String f() {
        return this.k.getText().toString();
    }

    private void v() {
        String[] strArr = {this.c.getString(com.baidu.tieba.y.take_photo), this.c.getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setTitle(this.c.getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, this.c);
        if (this.q == null) {
            this.q = builder.create();
            this.q.setCanceledOnTouchOutside(true);
        }
    }

    public AlertDialog g() {
        if (this.q == null) {
            v();
        }
        return this.q;
    }

    public RelativeLayout h() {
        return this.n;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.i.setVisibility(8);
            this.h.setDefaultResource(0);
            this.h.setNightDefaultResource(0);
            this.h.setImageBitmap(null);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.h.setBackgroundResource(com.baidu.tieba.u.live_room_setting_add_selector_1);
                return;
            } else {
                this.h.setBackgroundResource(com.baidu.tieba.u.live_room_setting_add_selector);
                return;
            }
        }
        this.i.setVisibility(0);
        if (this.o.getVisibility() == 8) {
            this.o.setVisibility(0);
        }
        if (this.r == null) {
            this.r = new com.baidu.tbadk.editortool.aa(this.c);
        }
        this.r.b(true);
        this.r.b(str, new bm(this));
    }

    public void b(String str) {
        this.s = str;
        d(str);
    }

    public void c(String str) {
        this.t = str;
        e(str);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.j.setText(str);
        this.j.setSelection(this.j.getText().toString().length());
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.k.setText(str);
    }

    public boolean i() {
        com.baidu.tieba.im.e.t.c(this.j);
        com.baidu.tieba.im.e.t.c(this.k);
        if (!this.p || TextUtils.isEmpty(e()) || e().equals(this.s)) {
            return (!this.p || TextUtils.isEmpty(f()) || f().equals(this.t)) ? false : true;
        }
        return true;
    }

    public boolean j() {
        return com.baidu.tieba.im.e.t.c(this.j) || this.j.getText().length() >= 2;
    }

    public void k() {
        new AlertDialog.Builder(this.c).setTitle(com.baidu.tieba.y.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.group_update_alert_save).setPositiveButton(com.baidu.tieba.y.group_update_canel, new bn(this)).setNegativeButton(com.baidu.tieba.y.group_update_done, new bo(this)).create().show();
    }

    public void b(int i) {
        if (i <= 0) {
            this.m.setText("");
        } else {
            this.m.setText(String.format(this.c.getString(com.baidu.tieba.y.black_list_member), Integer.valueOf(i)));
        }
    }

    public void l() {
        this.o.setVisibility(0);
    }

    public void m() {
        this.o.setVisibility(8);
    }

    public void n() {
        m();
    }

    public boolean o() {
        return this.p;
    }

    public void p() {
        HidenSoftKeyPad(this.j);
        HidenSoftKeyPad(this.k);
    }

    public void q() {
        this.l.requestFocus();
    }

    public EditText r() {
        return this.j;
    }

    public EditText s() {
        return this.k;
    }
}
