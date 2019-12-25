package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class g implements o {
    EditText hqJ;
    private ImageButton hqK;
    private int hqL;
    CreateGroupStepActivity hqm;
    TbImageView hqn;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText bQt() {
        return this.hqJ;
    }

    public View bQu() {
        return this.hqK;
    }

    public void bQv() {
        this.hqJ.setText("");
    }

    public int bQo() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hqJ);
    }

    public void mZ(boolean z) {
        if (z) {
            this.hqK.setVisibility(0);
        } else {
            this.hqK.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hqm = null;
        this.mView = null;
        this.hqn = null;
        this.hqJ = null;
        this.hqK = null;
        this.hqm = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.hqJ = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.hqn = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.hqK = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.hqK.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.hqL = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bQa() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.hqm.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bQg() {
        this.hqn.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bQh() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hqm.getLayoutMode().setNightMode(z);
        this.hqm.getLayoutMode().onModeChanged(this.mView);
        this.hqn.startLoad(c.a(this.hqm.getPageContext().getPageActivity(), c.hqu, z), 29, false);
        this.hqJ.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hqm.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bQj() {
        if (this.mIndex != this.hqL) {
            return this.hqm.getPageContext().getString(R.string.next_step);
        }
        return this.hqm.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bQk() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.hqm.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bQl() {
        return true;
    }
}
