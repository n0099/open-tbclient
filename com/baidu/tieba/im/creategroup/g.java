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
    EditText ihS;
    private ImageButton ihT;
    private int ihU;
    CreateGroupStepActivity ihv;
    TbImageView ihw;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cdX() {
        return this.ihS;
    }

    public View cdY() {
        return this.ihT;
    }

    public void cdZ() {
        this.ihS.setText("");
    }

    public int cdS() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.ihS);
    }

    public void ox(boolean z) {
        if (z) {
            this.ihT.setVisibility(0);
        } else {
            this.ihT.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ihv = null;
        this.mView = null;
        this.ihw = null;
        this.ihS = null;
        this.ihT = null;
        this.ihv = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.ihS = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.ihw = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.ihT = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.ihT.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.ihU = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cdE() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.ihv.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdK() {
        this.ihw.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdL() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ihv.getLayoutMode().setNightMode(z);
        this.ihv.getLayoutMode().onModeChanged(this.mView);
        this.ihw.startLoad(c.a(this.ihv.getPageContext().getPageActivity(), c.ihD, z), 29, false);
        this.ihS.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ihv.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cdN() {
        if (this.mIndex != this.ihU) {
            return this.ihv.getPageContext().getString(R.string.next_step);
        }
        return this.ihv.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdO() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.ihv.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdP() {
        return true;
    }
}
