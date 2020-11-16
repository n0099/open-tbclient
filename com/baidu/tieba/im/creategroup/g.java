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
/* loaded from: classes22.dex */
public class g implements o {
    CreateGroupStepActivity kaN;
    TbImageView kaO;
    EditText kbk;
    private ImageButton kbl;
    private int kbm;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cPu() {
        return this.kbk;
    }

    public View cPv() {
        return this.kbl;
    }

    public void cPw() {
        this.kbk.setText("");
    }

    public int wo() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.kbk);
    }

    public void rJ(boolean z) {
        if (z) {
            this.kbl.setVisibility(0);
        } else {
            this.kbl.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kaN = null;
        this.mView = null;
        this.kaO = null;
        this.kbk = null;
        this.kbl = null;
        this.kaN = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.kbk = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.kaO = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.kbl = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.kbl.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.kbm = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cPc() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.kaN.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPi() {
        this.kaO.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kaN.getLayoutMode().setNightMode(z);
        this.kaN.getLayoutMode().onModeChanged(this.mView);
        this.kaO.startLoad(c.a(this.kaN.getPageContext().getPageActivity(), c.kaV, z), 29, false);
        this.kbk.setHintTextColor(ap.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kaN.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cPl() {
        if (this.mIndex != this.kbm) {
            return this.kaN.getPageContext().getString(R.string.next_step);
        }
        return this.kaN.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPm() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.kaN.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPn() {
        return true;
    }
}
