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
    private int OG;
    CreateGroupStepActivity eDm;
    TbImageView eDn;
    private int eDq;
    EditText eDw;
    TextView eDx;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eDm = null;
        this.mView = null;
        this.eDn = null;
        this.eDw = null;
        this.eDx = null;
        this.eDm = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step2_view, (ViewGroup) null);
        this.eDn = (TbImageView) this.mView.findViewById(e.g.step2_img_bg);
        this.eDw = (EditText) this.mView.findViewById(e.g.step2_group_info);
        this.eDx = (TextView) this.mView.findViewById(e.g.step2_group_info_count);
        this.mIndex = i;
        this.OG = i2;
        this.eDq = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aNA() {
        return this.mIndex;
    }

    public EditText aNM() {
        return this.eDw;
    }

    public TextView aNN() {
        return this.eDx;
    }

    public void oU(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.eDw.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.is(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.eDw.setText(a);
            this.eDw.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eDm.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eDw);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNG() {
        this.eDn.setBackgroundDrawable(null);
    }

    public void aNO() {
        this.eDm.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eDm.getLayoutMode().onModeChanged(this.eDx);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNH() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eDm.getLayoutMode().setNightMode(z);
        this.eDm.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.eDm.getActivity(), c.eDs, z);
        this.eDw.setHintTextColor(al.getColor(e.d.common_color_10005));
        this.eDn.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eDm.getPageContext().getString(e.j.group_create_step_intro), Integer.valueOf(this.OG));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNJ() {
        if (this.mIndex != this.eDq) {
            return this.eDm.getPageContext().getString(e.j.next_step);
        }
        return this.eDm.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNK() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eDm.getPageContext().getString(e.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNL() {
        return true;
    }
}
