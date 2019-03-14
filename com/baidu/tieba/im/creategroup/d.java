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
    CreateGroupStepActivity gfb;
    TbImageView gfc;
    private int gff;
    EditText gfl;
    TextView gfm;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gfb = null;
        this.mView = null;
        this.gfc = null;
        this.gfl = null;
        this.gfm = null;
        this.gfb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step2_view, (ViewGroup) null);
        this.gfc = (TbImageView) this.mView.findViewById(d.g.step2_img_bg);
        this.gfl = (EditText) this.mView.findViewById(d.g.step2_group_info);
        this.gfm = (TextView) this.mView.findViewById(d.g.step2_group_info_count);
        this.mIndex = i;
        this.Pl = i2;
        this.gff = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bqH() {
        return this.mIndex;
    }

    public EditText bqT() {
        return this.gfl;
    }

    public TextView bqU() {
        return this.gfm;
    }

    public void tF(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.gfl.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.pM(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.gfl.setText(a);
            this.gfl.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gfb.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.i(this.gfl);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqN() {
        this.gfc.setBackgroundDrawable(null);
    }

    public void bqV() {
        this.gfb.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gfb.getLayoutMode().onModeChanged(this.gfm);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqO() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gfb.getLayoutMode().setNightMode(z);
        this.gfb.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.gfb.getActivity(), c.gfh, z);
        this.gfl.setHintTextColor(al.getColor(d.C0277d.common_color_10005));
        this.gfc.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gfb.getPageContext().getString(d.j.group_create_step_intro), Integer.valueOf(this.Pl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bqQ() {
        if (this.mIndex != this.gff) {
            return this.gfb.getPageContext().getString(d.j.next_step);
        }
        return this.gfb.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqR() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gfb.getPageContext().getString(d.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqS() {
        return true;
    }
}
