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
    private int Or;
    private int evB;
    EditText evH;
    TextView evI;
    CreateGroupStepActivity evx;
    TbImageView evy;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.evx = null;
        this.mView = null;
        this.evy = null;
        this.evH = null;
        this.evI = null;
        this.evx = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step2_view, (ViewGroup) null);
        this.evy = (TbImageView) this.mView.findViewById(e.g.step2_img_bg);
        this.evH = (EditText) this.mView.findViewById(e.g.step2_group_info);
        this.evI = (TextView) this.mView.findViewById(e.g.step2_group_info_count);
        this.mIndex = i;
        this.Or = i2;
        this.evB = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aKk() {
        return this.mIndex;
    }

    public EditText aKw() {
        return this.evH;
    }

    public TextView aKx() {
        return this.evI;
    }

    public void ow(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.evH.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.m19if(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.evH.setText(a);
            this.evH.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.evx.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.evH);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aKq() {
        this.evy.setBackgroundDrawable(null);
    }

    public void aKy() {
        this.evx.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.evx.getLayoutMode().onModeChanged(this.evI);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aKr() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.evx.getLayoutMode().setNightMode(z);
        this.evx.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.evx.getActivity(), c.evD, z);
        this.evH.setHintTextColor(al.getColor(e.d.common_color_10005));
        this.evy.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.evx.getPageContext().getString(e.j.group_create_step_intro), Integer.valueOf(this.Or));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aKt() {
        if (this.mIndex != this.evB) {
            return this.evx.getPageContext().getString(e.j.next_step);
        }
        return this.evx.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aKu() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.evx.getPageContext().getString(e.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aKv() {
        return true;
    }
}
