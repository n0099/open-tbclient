package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class g implements o {
    EditText kaA;
    private ImageButton kaB;
    private int kaC;
    CreateGroupStepActivity kac;
    TbImageView kad;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cPO() {
        return this.kaA;
    }

    public View cPP() {
        return this.kaB;
    }

    public void cPQ() {
        this.kaA.setText("");
    }

    public int wp() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.kaA);
    }

    public void rG(boolean z) {
        if (z) {
            this.kaB.setVisibility(0);
        } else {
            this.kaB.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kac = null;
        this.mView = null;
        this.kad = null;
        this.kaA = null;
        this.kaB = null;
        this.kac = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.kaA = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.kad = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.kaB = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.kaB.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.kaC = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cPw() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.kac.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPC() {
        this.kad.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPD() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kac.getLayoutMode().setNightMode(z);
        this.kac.getLayoutMode().onModeChanged(this.mView);
        this.kad.startLoad(c.a(this.kac.getPageContext().getPageActivity(), c.kak, z), 29, false);
        this.kaA.setHintTextColor(ap.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kac.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cPF() {
        if (this.mIndex != this.kaC) {
            return this.kac.getPageContext().getString(R.string.next_step);
        }
        return this.kac.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPG() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.kac.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPH() {
        return true;
    }
}
