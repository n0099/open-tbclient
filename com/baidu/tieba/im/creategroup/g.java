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
    CreateGroupStepActivity iUZ;
    TbImageView iVa;
    EditText iVw;
    private ImageButton iVx;
    private int iVy;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText crZ() {
        return this.iVw;
    }

    public View csa() {
        return this.iVx;
    }

    public void csb() {
        this.iVw.setText("");
    }

    public int crU() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.iVw);
    }

    public void pJ(boolean z) {
        if (z) {
            this.iVx.setVisibility(0);
        } else {
            this.iVx.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iUZ = null;
        this.mView = null;
        this.iVa = null;
        this.iVw = null;
        this.iVx = null;
        this.iUZ = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.iVw = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.iVa = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.iVx = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.iVx.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.iVy = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int crG() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.iUZ.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crM() {
        this.iVa.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crN() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iUZ.getLayoutMode().setNightMode(z);
        this.iUZ.getLayoutMode().onModeChanged(this.mView);
        this.iVa.startLoad(c.a(this.iUZ.getPageContext().getPageActivity(), c.iVh, z), 29, false);
        this.iVw.setHintTextColor(ao.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iUZ.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String crP() {
        if (this.mIndex != this.iVy) {
            return this.iUZ.getPageContext().getString(R.string.next_step);
        }
        return this.iUZ.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crQ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.iUZ.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crR() {
        return true;
    }
}
