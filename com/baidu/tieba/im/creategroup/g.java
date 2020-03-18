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
    CreateGroupStepActivity hxC;
    TbImageView hxD;
    EditText hxZ;
    private ImageButton hya;
    private int hyb;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText bTy() {
        return this.hxZ;
    }

    public View bTz() {
        return this.hya;
    }

    public void bTA() {
        this.hxZ.setText("");
    }

    public int bTt() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hxZ);
    }

    public void nt(boolean z) {
        if (z) {
            this.hya.setVisibility(0);
        } else {
            this.hya.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hxC = null;
        this.mView = null;
        this.hxD = null;
        this.hxZ = null;
        this.hya = null;
        this.hxC = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.hxZ = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.hxD = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.hya = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.hya.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.hyb = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bTf() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.hxC.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bTl() {
        this.hxD.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bTm() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hxC.getLayoutMode().setNightMode(z);
        this.hxC.getLayoutMode().onModeChanged(this.mView);
        this.hxD.startLoad(c.a(this.hxC.getPageContext().getPageActivity(), c.hxK, z), 29, false);
        this.hxZ.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hxC.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bTo() {
        if (this.mIndex != this.hyb) {
            return this.hxC.getPageContext().getString(R.string.next_step);
        }
        return this.hxC.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bTp() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.hxC.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bTq() {
        return true;
    }
}
