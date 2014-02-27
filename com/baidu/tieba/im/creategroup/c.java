package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class c implements x {
    CreateGroupStepActivity a;
    View b;
    ImageView c;
    EditText d;
    TextView e;
    private int f;
    private int g;
    private int h;

    public c(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = createGroupStepActivity;
        this.b = createGroupStepActivity.getLayoutInflater().inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.c = (ImageView) this.b.findViewById(R.id.step2_img_bg);
        this.d = (EditText) this.b.findViewById(R.id.step2_group_info);
        this.e = (TextView) this.b.findViewById(R.id.step2_group_info_count);
        this.f = i;
        this.g = i2;
        this.h = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final int b() {
        return this.f;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final View a() {
        cb.a(this.a, "create_g_intro", "pv", 1, new Object[0]);
        return this.b;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final void g() {
        this.c.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final void h() {
        this.a.getLayoutMode().a(TiebaApplication.g().ae() == 1);
        this.a.getLayoutMode().a(this.b);
        if (TiebaApplication.g().ae() == 1) {
            this.d.setHintTextColor(this.a.getResources().getColor(R.color.create_group_input_hintcolor_1));
        } else {
            this.d.setHintTextColor(this.a.getResources().getColor(R.color.create_group_input_hintcolor));
        }
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final String i() {
        return String.format(this.a.getString(R.string.group_create_step_intro), Integer.valueOf(this.g));
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final String j() {
        if (this.f != this.h) {
            return this.a.getString(R.string.group_create_step_tip);
        }
        return this.a.getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final boolean k() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final String l() {
        return this.a.getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.x
    public final boolean m() {
        return true;
    }
}
