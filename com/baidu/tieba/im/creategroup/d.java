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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class d implements o {
    private int LQ;
    CreateGroupStepActivity eod;
    TbImageView eoe;
    private int eoi;
    EditText eoo;
    TextView eop;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eod = null;
        this.mView = null;
        this.eoe = null;
        this.eoo = null;
        this.eop = null;
        this.eod = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(f.h.create_group_step2_view, (ViewGroup) null);
        this.eoe = (TbImageView) this.mView.findViewById(f.g.step2_img_bg);
        this.eoo = (EditText) this.mView.findViewById(f.g.step2_group_info);
        this.eop = (TextView) this.mView.findViewById(f.g.step2_group_info_count);
        this.mIndex = i;
        this.LQ = i2;
        this.eoi = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aHV() {
        return this.mIndex;
    }

    public EditText aIh() {
        return this.eoo;
    }

    public TextView aIi() {
        return this.eop;
    }

    public void nS(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.eoo.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.hH(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.eoo.setText(a);
            this.eoo.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eod.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eoo);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIb() {
        this.eoe.setBackgroundDrawable(null);
    }

    public void aIj() {
        this.eod.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eod.getLayoutMode().onModeChanged(this.eop);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIc() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eod.getLayoutMode().setNightMode(z);
        this.eod.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.eod.getActivity(), c.eok, z);
        this.eoo.setHintTextColor(am.getColor(f.d.common_color_10005));
        this.eoe.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eod.getPageContext().getString(f.j.group_create_step_intro), Integer.valueOf(this.LQ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aIe() {
        if (this.mIndex != this.eoi) {
            return this.eod.getPageContext().getString(f.j.next_step);
        }
        return this.eod.getPageContext().getString(f.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIf() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eod.getPageContext().getString(f.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIg() {
        return true;
    }
}
