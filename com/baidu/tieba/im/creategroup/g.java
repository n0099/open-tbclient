package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class g implements o {
    private int iVA;
    CreateGroupStepActivity iVb;
    TbImageView iVc;
    EditText iVy;
    private ImageButton iVz;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText crZ() {
        return this.iVy;
    }

    public View csa() {
        return this.iVz;
    }

    public void csb() {
        this.iVy.setText("");
    }

    public int crU() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.iVy);
    }

    public void pJ(boolean z) {
        if (z) {
            this.iVz.setVisibility(0);
        } else {
            this.iVz.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iVb = null;
        this.mView = null;
        this.iVc = null;
        this.iVy = null;
        this.iVz = null;
        this.iVb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.iVy = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.iVc = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.iVz = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.iVz.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.iVA = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int crG() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.iVb.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crM() {
        this.iVc.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crN() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iVb.getLayoutMode().setNightMode(z);
        this.iVb.getLayoutMode().onModeChanged(this.mView);
        this.iVc.startLoad(c.a(this.iVb.getPageContext().getPageActivity(), c.iVj, z), 29, false);
        this.iVy.setHintTextColor(ao.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iVb.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String crP() {
        if (this.mIndex != this.iVA) {
            return this.iVb.getPageContext().getString(R.string.next_step);
        }
        return this.iVb.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crQ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.iVb.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crR() {
        return true;
    }
}
