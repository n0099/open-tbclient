package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d implements o {
    private int LV;
    TextView ekA;
    CreateGroupStepActivity ekp;
    TbImageView ekq;
    private int ekt;
    EditText ekz;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ekp = null;
        this.mView = null;
        this.ekq = null;
        this.ekz = null;
        this.ekA = null;
        this.ekp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step2_view, (ViewGroup) null);
        this.ekq = (TbImageView) this.mView.findViewById(d.g.step2_img_bg);
        this.ekz = (EditText) this.mView.findViewById(d.g.step2_group_info);
        this.ekA = (TextView) this.mView.findViewById(d.g.step2_group_info_count);
        this.mIndex = i;
        this.LV = i2;
        this.ekt = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aGY() {
        return this.mIndex;
    }

    public EditText aHk() {
        return this.ekz;
    }

    public TextView aHl() {
        return this.ekA;
    }

    public void nE(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.ekz.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.hK(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.ekz.setText(a);
            this.ekz.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.ekp.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ekz);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aHe() {
        this.ekq.setBackgroundDrawable(null);
    }

    public void aHm() {
        this.ekp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ekp.getLayoutMode().onModeChanged(this.ekA);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aHf() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ekp.getLayoutMode().setNightMode(z);
        this.ekp.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.ekp.getActivity(), c.ekv, z);
        this.ekz.setHintTextColor(am.getColor(d.C0142d.common_color_10005));
        this.ekq.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ekp.getPageContext().getString(d.k.group_create_step_intro), Integer.valueOf(this.LV));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aHh() {
        if (this.mIndex != this.ekt) {
            return this.ekp.getPageContext().getString(d.k.next_step);
        }
        return this.ekp.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aHi() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.ekp.getPageContext().getString(d.k.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aHj() {
        return true;
    }
}
