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
    CreateGroupStepActivity hvO;
    TbImageView hvP;
    EditText hwl;
    private ImageButton hwm;
    private int hwn;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText bTd() {
        return this.hwl;
    }

    public View bTe() {
        return this.hwm;
    }

    public void bTf() {
        this.hwl.setText("");
    }

    public int bSY() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hwl);
    }

    public void nn(boolean z) {
        if (z) {
            this.hwm.setVisibility(0);
        } else {
            this.hwm.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hvO = null;
        this.mView = null;
        this.hvP = null;
        this.hwl = null;
        this.hwm = null;
        this.hvO = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.hwl = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.hvP = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.hwm = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.hwm.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.hwn = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSK() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.hvO.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSQ() {
        this.hvP.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSR() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hvO.getLayoutMode().setNightMode(z);
        this.hvO.getLayoutMode().onModeChanged(this.mView);
        this.hvP.startLoad(c.a(this.hvO.getPageContext().getPageActivity(), c.hvW, z), 29, false);
        this.hwl.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hvO.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bST() {
        if (this.mIndex != this.hwn) {
            return this.hvO.getPageContext().getString(R.string.next_step);
        }
        return this.hvO.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSU() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.hvO.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSV() {
        return true;
    }
}
