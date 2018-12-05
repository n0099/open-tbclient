package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d implements o {
    private int OH;
    EditText eLE;
    TextView eLF;
    CreateGroupStepActivity eLu;
    TbImageView eLv;
    private int eLy;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eLu = null;
        this.mView = null;
        this.eLv = null;
        this.eLE = null;
        this.eLF = null;
        this.eLu = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step2_view, (ViewGroup) null);
        this.eLv = (TbImageView) this.mView.findViewById(e.g.step2_img_bg);
        this.eLE = (EditText) this.mView.findViewById(e.g.step2_group_info);
        this.eLF = (TextView) this.mView.findViewById(e.g.step2_group_info_count);
        this.mIndex = i;
        this.OH = i2;
        this.eLy = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aOP() {
        return this.mIndex;
    }

    public EditText aPb() {
        return this.eLE;
    }

    public TextView aPc() {
        return this.eLF;
    }

    public void pH(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.eLE.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.iL(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.eLE.setText(a);
            this.eLE.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eLu.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eLE);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aOV() {
        this.eLv.setBackgroundDrawable(null);
    }

    public void aPd() {
        this.eLu.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eLu.getLayoutMode().onModeChanged(this.eLF);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aOW() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eLu.getLayoutMode().setNightMode(z);
        this.eLu.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.eLu.getActivity(), c.eLA, z);
        this.eLE.setHintTextColor(al.getColor(e.d.common_color_10005));
        this.eLv.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eLu.getPageContext().getString(e.j.group_create_step_intro), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aOY() {
        if (this.mIndex != this.eLy) {
            return this.eLu.getPageContext().getString(e.j.next_step);
        }
        return this.eLu.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aOZ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eLu.getPageContext().getString(e.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aPa() {
        return true;
    }
}
