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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class d implements o {
    private int Pl;
    CreateGroupStepActivity geP;
    TbImageView geQ;
    private int geT;
    EditText geZ;
    TextView gfa;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.geP = null;
        this.mView = null;
        this.geQ = null;
        this.geZ = null;
        this.gfa = null;
        this.geP = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step2_view, (ViewGroup) null);
        this.geQ = (TbImageView) this.mView.findViewById(d.g.step2_img_bg);
        this.geZ = (EditText) this.mView.findViewById(d.g.step2_group_info);
        this.gfa = (TextView) this.mView.findViewById(d.g.step2_group_info_count);
        this.mIndex = i;
        this.Pl = i2;
        this.geT = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bqE() {
        return this.mIndex;
    }

    public EditText bqQ() {
        return this.geZ;
    }

    public TextView bqR() {
        return this.gfa;
    }

    public void tB(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.geZ.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.pN(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.geZ.setText(a);
            this.geZ.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.geP.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.i(this.geZ);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqK() {
        this.geQ.setBackgroundDrawable(null);
    }

    public void bqS() {
        this.geP.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.geP.getLayoutMode().onModeChanged(this.gfa);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqL() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.geP.getLayoutMode().setNightMode(z);
        this.geP.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.geP.getActivity(), c.geV, z);
        this.geZ.setHintTextColor(al.getColor(d.C0277d.common_color_10005));
        this.geQ.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.geP.getPageContext().getString(d.j.group_create_step_intro), Integer.valueOf(this.Pl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bqN() {
        if (this.mIndex != this.geT) {
            return this.geP.getPageContext().getString(d.j.next_step);
        }
        return this.geP.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqO() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.geP.getPageContext().getString(d.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqP() {
        return true;
    }
}
