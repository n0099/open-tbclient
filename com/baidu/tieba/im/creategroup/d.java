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
    CreateGroupStepActivity eDl;
    TbImageView eDm;
    private int eDp;
    EditText eDv;
    TextView eDw;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eDl = null;
        this.mView = null;
        this.eDm = null;
        this.eDv = null;
        this.eDw = null;
        this.eDl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step2_view, (ViewGroup) null);
        this.eDm = (TbImageView) this.mView.findViewById(e.g.step2_img_bg);
        this.eDv = (EditText) this.mView.findViewById(e.g.step2_group_info);
        this.eDw = (TextView) this.mView.findViewById(e.g.step2_group_info_count);
        this.mIndex = i;
        this.OG = i2;
        this.eDp = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aNA() {
        return this.mIndex;
    }

    public EditText aNM() {
        return this.eDv;
    }

    public TextView aNN() {
        return this.eDw;
    }

    public void oU(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.eDv.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.is(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.eDv.setText(a);
            this.eDv.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.eDl.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.eDv);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNG() {
        this.eDm.setBackgroundDrawable(null);
    }

    public void aNO() {
        this.eDl.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eDl.getLayoutMode().onModeChanged(this.eDw);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNH() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eDl.getLayoutMode().setNightMode(z);
        this.eDl.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.eDl.getActivity(), c.eDr, z);
        this.eDv.setHintTextColor(al.getColor(e.d.common_color_10005));
        this.eDm.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eDl.getPageContext().getString(e.j.group_create_step_intro), Integer.valueOf(this.OG));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNJ() {
        if (this.mIndex != this.eDp) {
            return this.eDl.getPageContext().getString(e.j.next_step);
        }
        return this.eDl.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNK() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.eDl.getPageContext().getString(e.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNL() {
        return true;
    }
}
