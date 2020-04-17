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
/* loaded from: classes10.dex */
public class g implements o {
    EditText ihM;
    private ImageButton ihN;
    private int ihO;
    CreateGroupStepActivity ihp;
    TbImageView ihq;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cdY() {
        return this.ihM;
    }

    public View cdZ() {
        return this.ihN;
    }

    public void cea() {
        this.ihM.setText("");
    }

    public int cdT() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.ihM);
    }

    public void ox(boolean z) {
        if (z) {
            this.ihN.setVisibility(0);
        } else {
            this.ihN.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ihp = null;
        this.mView = null;
        this.ihq = null;
        this.ihM = null;
        this.ihN = null;
        this.ihp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.ihM = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.ihq = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.ihN = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.ihN.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.ihO = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cdF() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.ihp.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdL() {
        this.ihq.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdM() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ihp.getLayoutMode().setNightMode(z);
        this.ihp.getLayoutMode().onModeChanged(this.mView);
        this.ihq.startLoad(c.a(this.ihp.getPageContext().getPageActivity(), c.ihx, z), 29, false);
        this.ihM.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ihp.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cdO() {
        if (this.mIndex != this.ihO) {
            return this.ihp.getPageContext().getString(R.string.next_step);
        }
        return this.ihp.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdP() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.ihp.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdQ() {
        return true;
    }
}
