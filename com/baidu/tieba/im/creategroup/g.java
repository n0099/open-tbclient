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
    private ImageButton hwA;
    private int hwB;
    CreateGroupStepActivity hwc;
    TbImageView hwd;
    EditText hwz;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText bTg() {
        return this.hwz;
    }

    public View bTh() {
        return this.hwA;
    }

    public void bTi() {
        this.hwz.setText("");
    }

    public int bTb() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hwz);
    }

    public void nn(boolean z) {
        if (z) {
            this.hwA.setVisibility(0);
        } else {
            this.hwA.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hwc = null;
        this.mView = null;
        this.hwd = null;
        this.hwz = null;
        this.hwA = null;
        this.hwc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.hwz = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.hwd = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.hwA = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.hwA.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.hwB = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSN() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.hwc.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bST() {
        this.hwd.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSU() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hwc.getLayoutMode().setNightMode(z);
        this.hwc.getLayoutMode().onModeChanged(this.mView);
        this.hwd.startLoad(c.a(this.hwc.getPageContext().getPageActivity(), c.hwk, z), 29, false);
        this.hwz.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hwc.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bSW() {
        if (this.mIndex != this.hwB) {
            return this.hwc.getPageContext().getString(R.string.next_step);
        }
        return this.hwc.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSX() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.hwc.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSY() {
        return true;
    }
}
