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
    CreateGroupStepActivity gwc;
    TbImageView gwd;
    private int gwg;
    EditText gwm;
    TextView gwn;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwc = null;
        this.mView = null;
        this.gwd = null;
        this.gwm = null;
        this.gwn = null;
        this.gwc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.gwd = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.gwm = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.gwn = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.MU = i2;
        this.gwg = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byt() {
        return this.mIndex;
    }

    public EditText byF() {
        return this.gwm;
    }

    public TextView byG() {
        return this.gwn;
    }

    public void uI(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.gwm.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.qW(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.gwm.setText(a);
            this.gwm.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gwc.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.i(this.gwm);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byz() {
        this.gwd.setBackgroundDrawable(null);
    }

    public void byH() {
        this.gwc.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gwc.getLayoutMode().onModeChanged(this.gwn);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byA() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwc.getLayoutMode().setNightMode(z);
        this.gwc.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.gwc.getActivity(), c.gwi, z);
        this.gwm.setHintTextColor(al.getColor(R.color.common_color_10005));
        this.gwd.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwc.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.MU));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byC() {
        if (this.mIndex != this.gwg) {
            return this.gwc.getPageContext().getString(R.string.next_step);
        }
        return this.gwc.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byD() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gwc.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byE() {
        return true;
    }
}
