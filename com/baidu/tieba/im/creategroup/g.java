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
/* loaded from: classes17.dex */
public class g implements o {
    EditText jkD;
    private ImageButton jkE;
    private int jkF;
    CreateGroupStepActivity jkg;
    TbImageView jkh;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cCR() {
        return this.jkD;
    }

    public View cCS() {
        return this.jkE;
    }

    public void cCT() {
        this.jkD.setText("");
    }

    public int vS() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.jkD);
    }

    public void qr(boolean z) {
        if (z) {
            this.jkE.setVisibility(0);
        } else {
            this.jkE.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jkg = null;
        this.mView = null;
        this.jkh = null;
        this.jkD = null;
        this.jkE = null;
        this.jkg = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.jkD = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.jkh = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.jkE = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.jkE.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.jkF = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cCz() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.jkg.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCF() {
        this.jkh.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCG() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jkg.getLayoutMode().setNightMode(z);
        this.jkg.getLayoutMode().onModeChanged(this.mView);
        this.jkh.startLoad(c.a(this.jkg.getPageContext().getPageActivity(), c.jko, z), 29, false);
        this.jkD.setHintTextColor(ap.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jkg.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cCI() {
        if (this.mIndex != this.jkF) {
            return this.jkg.getPageContext().getString(R.string.next_step);
        }
        return this.jkg.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCJ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.jkg.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCK() {
        return true;
    }
}
