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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.base.f {
    private LiveRoomSettingActivity a;
    private View b;
    private NavigationBar c;
    private View d;
    private TextView e;
    private TbImageView f;
    private ImageView g;
    private EditText h;
    private EditText i;
    private EditText j;
    private TextView k;
    private RelativeLayout l;
    private ProgressBar m;
    private boolean n;
    private AlertDialog o;
    private String p;
    private String q;
    private DialogInterface.OnClickListener r;
    private DialogInterface.OnClickListener s;

    public bk(LiveRoomSettingActivity liveRoomSettingActivity) {
        super(liveRoomSettingActivity);
        this.p = "";
        this.q = "";
        this.r = null;
        this.s = null;
        this.a = liveRoomSettingActivity;
        liveRoomSettingActivity.setContentView(com.baidu.tieba.v.live_room_setting_view);
        a(liveRoomSettingActivity);
    }

    private void a(LiveRoomSettingActivity liveRoomSettingActivity) {
        this.b = (RelativeLayout) liveRoomSettingActivity.findViewById(com.baidu.tieba.u.container);
        this.c = (NavigationBar) liveRoomSettingActivity.findViewById(com.baidu.tieba.u.lay_title_bar);
        this.d = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, liveRoomSettingActivity);
        this.e = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getResources().getString(com.baidu.tieba.x.group_update_done));
        this.e.setOnClickListener(liveRoomSettingActivity);
        this.c.a(com.baidu.tieba.x.live_room_setting);
        this.j = (EditText) liveRoomSettingActivity.findViewById(com.baidu.tieba.u.fxk);
        this.f = (TbImageView) liveRoomSettingActivity.findViewById(com.baidu.tieba.u.cover_photo);
        this.f.setOnClickListener(liveRoomSettingActivity);
        this.f.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f.setDefaultResource(com.baidu.tieba.t.image_group_qzl);
        this.f.setNightDefaultResource(com.baidu.tieba.t.image_group_qzl_1);
        this.g = (ImageView) liveRoomSettingActivity.findViewById(com.baidu.tieba.u.cover_camera);
        this.g.setOnClickListener(liveRoomSettingActivity);
        this.h = (EditText) liveRoomSettingActivity.findViewById(com.baidu.tieba.u.room_name);
        this.i = (EditText) liveRoomSettingActivity.findViewById(com.baidu.tieba.u.room_intro);
        this.i.setOnTouchListener(new bl(this));
        this.k = (TextView) liveRoomSettingActivity.findViewById(com.baidu.tieba.u.black_count);
        this.l = (RelativeLayout) liveRoomSettingActivity.findViewById(com.baidu.tieba.u.black_list);
        this.l.setOnClickListener(liveRoomSettingActivity);
        this.m = (ProgressBar) liveRoomSettingActivity.findViewById(com.baidu.tieba.u.setting_progress);
        this.h.addTextChangedListener(new bm(this));
        a(false);
        v();
    }

    public void a(int i) {
        this.c.c(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.b);
        com.baidu.tbadk.core.util.ay.g(this.e, i);
        u();
    }

    private void a(boolean z) {
        this.n = z;
        this.e.setEnabled(z);
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        int length = this.h.length();
        if (length >= 2 && length <= 15) {
            a(true);
        } else {
            a(false);
        }
    }

    private void u() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (this.n) {
                com.baidu.tbadk.core.util.ay.e((View) this.e, com.baidu.tieba.t.navi_done_text_bg_1);
                this.e.setTextColor(this.a.getResources().getColorStateList(com.baidu.tieba.r.navi_done_text_1));
                return;
            }
            com.baidu.tbadk.core.util.ay.e((View) this.e, com.baidu.tieba.t.btn_titlebar_finish_d_1);
            this.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.navi_done_text_d_1));
        } else if (this.n) {
            com.baidu.tbadk.core.util.ay.e((View) this.e, com.baidu.tieba.t.navi_done_text_bg);
            this.e.setTextColor(this.a.getResources().getColorStateList(com.baidu.tieba.r.navi_done_text));
        } else {
            com.baidu.tbadk.core.util.ay.e((View) this.e, com.baidu.tieba.t.btn_titlebar_finish_d);
            this.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.navi_done_text_d));
        }
    }

    public TextView a() {
        return this.e;
    }

    public TbImageView b() {
        return this.f;
    }

    public ImageView c() {
        return this.g;
    }

    public View d() {
        return this.d;
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public String e() {
        return this.h.getText().toString();
    }

    public String f() {
        return this.i.getText().toString();
    }

    private void v() {
        String[] strArr = {this.a.getString(com.baidu.tieba.x.take_photo), this.a.getString(com.baidu.tieba.x.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setTitle(this.a.getString(com.baidu.tieba.x.operation));
        builder.setItems(strArr, this.a);
        if (this.o == null) {
            this.o = builder.create();
            this.o.setCanceledOnTouchOutside(true);
        }
    }

    public AlertDialog g() {
        if (this.o == null) {
            v();
        }
        return this.o;
    }

    public RelativeLayout h() {
        return this.l;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.g.setVisibility(8);
            this.f.setDefaultResource(0);
            this.f.setNightDefaultResource(0);
            this.f.setDefaultBgResource(0);
            this.f.setNightDefaultBgResource(0);
            this.f.setImageDrawable(null);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.f.setBackgroundResource(com.baidu.tieba.t.live_room_setting_add_selector_1);
                return;
            } else {
                this.f.setBackgroundResource(com.baidu.tieba.t.live_room_setting_add_selector);
                return;
            }
        }
        this.g.setVisibility(0);
        if (this.m.getVisibility() == 8) {
            this.m.setVisibility(0);
        }
        com.baidu.adp.lib.resourceLoader.d.a().a(str, 10, new bn(this), this.mContext instanceof BaseActivity ? ((BaseActivity) this.mContext).getUniqueId() : null);
    }

    public void b(String str) {
        this.p = str;
        d(str);
    }

    public void c(String str) {
        this.q = str;
        e(str);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.h.setText(str);
        this.h.setSelection(this.h.getText().toString().length());
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.i.setText(str);
    }

    public boolean i() {
        com.baidu.tieba.im.d.l.c(this.h);
        com.baidu.tieba.im.d.l.c(this.i);
        if (!this.n || TextUtils.isEmpty(e()) || e().equals(this.p)) {
            return (!this.n || TextUtils.isEmpty(f()) || f().equals(this.q)) ? false : true;
        }
        return true;
    }

    public boolean j() {
        return com.baidu.tieba.im.d.l.c(this.h) || this.h.getText().length() >= 2;
    }

    public void k() {
        com.baidu.adp.lib.e.e.a(new AlertDialog.Builder(this.a).setTitle(com.baidu.tieba.x.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.x.group_update_alert_save).setPositiveButton(com.baidu.tieba.x.group_update_canel, new bo(this)).setNegativeButton(com.baidu.tieba.x.group_update_done, new bp(this)).create(), this.a);
    }

    public void b(int i) {
        if (i <= 0) {
            this.k.setText("");
        } else {
            this.k.setText(String.format(this.a.getString(com.baidu.tieba.x.black_list_member), Integer.valueOf(i)));
        }
    }

    public void l() {
        this.m.setVisibility(0);
    }

    public void m() {
        this.m.setVisibility(8);
    }

    public void n() {
        m();
    }

    public boolean o() {
        return this.n;
    }

    public void p() {
        HidenSoftKeyPad(this.h);
        HidenSoftKeyPad(this.i);
    }

    public void q() {
        this.j.requestFocus();
    }

    public EditText r() {
        return this.h;
    }

    public EditText s() {
        return this.i;
    }
}
