package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class g implements o {
    private int MT;
    EditText gwB;
    private ImageButton gwC;
    private int gwD;
    CreateGroupStepActivity gwe;
    TbImageView gwf;
    private int mIndex;
    View mView;

    public EditText byM() {
        return this.gwB;
    }

    public View byN() {
        return this.gwC;
    }

    public void byO() {
        this.gwB.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.i(this.gwB);
    }

    public void lG(boolean z) {
        if (z) {
            this.gwC.setVisibility(0);
        } else {
            this.gwC.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwe = null;
        this.mView = null;
        this.gwf = null;
        this.gwB = null;
        this.gwC = null;
        this.gwe = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.gwB = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.gwf = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.gwC = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.gwC.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.MT = i2;
        this.gwD = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byu() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gwe.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byA() {
        this.gwf.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byB() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwe.getLayoutMode().setNightMode(z);
        this.gwe.getLayoutMode().onModeChanged(this.mView);
        this.gwf.startLoad(c.a(this.gwe.getPageContext().getPageActivity(), c.gwm, z), 29, false);
        this.gwB.setHintTextColor(al.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwe.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.MT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byD() {
        if (this.mIndex != this.gwD) {
            return this.gwe.getPageContext().getString(R.string.next_step);
        }
        return this.gwe.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byE() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gwe.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byF() {
        return true;
    }
}
