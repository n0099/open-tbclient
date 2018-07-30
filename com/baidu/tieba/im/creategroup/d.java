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
    private int LQ;
    CreateGroupStepActivity eoi;
    TbImageView eoj;
    private int eom;
    EditText eos;
    TextView eot;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eoi = null;
        this.mView = null;
        this.eoj = null;
        this.eos = null;
        this.eot = null;
        this.eoi = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step2_view, (ViewGroup) null);
        this.eoj = (TbImageView) this.mView.findViewById(d.g.step2_img_bg);
        this.eos = (EditText) this.mView.findViewById(d.g.step2_group_info);
        this.eot = (TextView) this.mView.findViewById(d.g.step2_group_info_count);
        this.mIndex = i;
        this.LQ = i2;
        this.eom = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aHY() {
        return this.mIndex;
    }

    public EditText aIk() {
        return this.eos;
    }

    public TextView aIl() {
        return this.eot;
    }

    public void nS(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.eos.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.hH(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.eos.setText(a);
            this.eos.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eoi.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eos);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIe() {
        this.eoj.setBackgroundDrawable(null);
    }

    public void aIm() {
        this.eoi.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eoi.getLayoutMode().onModeChanged(this.eot);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIf() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eoi.getLayoutMode().setNightMode(z);
        this.eoi.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.eoi.getActivity(), c.eoo, z);
        this.eos.setHintTextColor(am.getColor(d.C0140d.common_color_10005));
        this.eoj.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eoi.getPageContext().getString(d.j.group_create_step_intro), Integer.valueOf(this.LQ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aIh() {
        if (this.mIndex != this.eom) {
            return this.eoi.getPageContext().getString(d.j.next_step);
        }
        return this.eoi.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIi() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eoi.getPageContext().getString(d.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIj() {
        return true;
    }
}
