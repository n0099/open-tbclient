package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class e implements v {
    CreateGroupStepActivity a;
    View b;
    ImageView c;
    EditText d;
    private ImageButton e;

    public EditText e() {
        return this.d;
    }

    public View f() {
        return this.e;
    }

    public void g() {
        this.d.setText("");
    }

    public int h() {
        return com.baidu.tieba.im.d.g.a(this.d);
    }

    public void a(boolean z) {
        if (z) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
    }

    public e(CreateGroupStepActivity createGroupStepActivity) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.d = (EditText) this.b.findViewById(R.id.step1_group_name);
        this.c = (ImageView) this.b.findViewById(R.id.step1_img_bg);
        this.e = (ImageButton) this.b.findViewById(R.id.button_del);
        this.e.setOnClickListener(createGroupStepActivity);
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int c() {
        return R.string.group_create_step_tip;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int d() {
        return R.string.group_create_step1;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public int b() {
        return 1;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public View a() {
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.a, "create_g_name", "pv", 1);
        }
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public void j() {
        this.c.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.v
    public void k() {
        this.a.getLayoutMode().a(TiebaApplication.h().an() == 1);
        this.a.getLayoutMode().a(this.b);
        if (TiebaApplication.h().an() == 1) {
            this.d.setHintTextColor(this.a.getResources().getColor(R.color.create_group_input_hintcolor_1));
        } else {
            this.d.setHintTextColor(this.a.getResources().getColor(R.color.create_group_input_hintcolor));
        }
    }
}
