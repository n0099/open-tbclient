package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class g implements o {
    private int Pl;
    CreateGroupStepActivity geP;
    TbImageView geQ;
    EditText gfm;
    private ImageButton gfn;
    private int gfo;
    private int mIndex;
    View mView;

    public EditText bqW() {
        return this.gfm;
    }

    public View bqX() {
        return this.gfn;
    }

    public void bqY() {
        this.gfm.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.i(this.gfm);
    }

    public void kQ(boolean z) {
        if (z) {
            this.gfn.setVisibility(0);
        } else {
            this.gfn.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.geP = null;
        this.mView = null;
        this.geQ = null;
        this.gfm = null;
        this.gfn = null;
        this.geP = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step1_view, (ViewGroup) null);
        this.gfm = (EditText) this.mView.findViewById(d.g.step1_group_name);
        this.geQ = (TbImageView) this.mView.findViewById(d.g.step1_img_bg);
        this.gfn = (ImageButton) this.mView.findViewById(d.g.button_del);
        this.gfn.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.Pl = i2;
        this.gfo = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bqE() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.geP.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqK() {
        this.geQ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqL() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.geP.getLayoutMode().setNightMode(z);
        this.geP.getLayoutMode().onModeChanged(this.mView);
        this.geQ.startLoad(c.a(this.geP.getPageContext().getPageActivity(), c.geX, z), 29, false);
        this.gfm.setHintTextColor(al.getColor(d.C0277d.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.geP.getPageContext().getString(d.j.group_create_step_name), Integer.valueOf(this.Pl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bqN() {
        if (this.mIndex != this.gfo) {
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
        return this.geP.getPageContext().getString(d.j.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqP() {
        return true;
    }
}
