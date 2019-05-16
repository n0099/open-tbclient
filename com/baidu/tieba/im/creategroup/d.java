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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class d implements o {
    private int MU;
    CreateGroupStepActivity gwb;
    TbImageView gwc;
    private int gwf;
    EditText gwl;
    TextView gwm;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwb = null;
        this.mView = null;
        this.gwc = null;
        this.gwl = null;
        this.gwm = null;
        this.gwb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.gwc = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.gwl = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.gwm = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.MU = i2;
        this.gwf = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byq() {
        return this.mIndex;
    }

    public EditText byC() {
        return this.gwl;
    }

    public TextView byD() {
        return this.gwm;
    }

    public void uI(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.gwl.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.qW(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.gwl.setText(a);
            this.gwl.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gwb.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.i(this.gwl);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byw() {
        this.gwc.setBackgroundDrawable(null);
    }

    public void byE() {
        this.gwb.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gwb.getLayoutMode().onModeChanged(this.gwm);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byx() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwb.getLayoutMode().setNightMode(z);
        this.gwb.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.gwb.getActivity(), c.gwh, z);
        this.gwl.setHintTextColor(al.getColor(R.color.common_color_10005));
        this.gwc.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwb.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.MU));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byz() {
        if (this.mIndex != this.gwf) {
            return this.gwb.getPageContext().getString(R.string.next_step);
        }
        return this.gwb.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byA() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gwb.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byB() {
        return true;
    }
}
