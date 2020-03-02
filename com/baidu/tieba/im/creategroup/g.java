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
    CreateGroupStepActivity hvQ;
    TbImageView hvR;
    EditText hwn;
    private ImageButton hwo;
    private int hwp;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText bTf() {
        return this.hwn;
    }

    public View bTg() {
        return this.hwo;
    }

    public void bTh() {
        this.hwn.setText("");
    }

    public int bTa() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hwn);
    }

    public void nn(boolean z) {
        if (z) {
            this.hwo.setVisibility(0);
        } else {
            this.hwo.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hvQ = null;
        this.mView = null;
        this.hvR = null;
        this.hwn = null;
        this.hwo = null;
        this.hvQ = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.hwn = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.hvR = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.hwo = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.hwo.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.hwp = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSM() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.hvQ.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSS() {
        this.hvR.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bST() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hvQ.getLayoutMode().setNightMode(z);
        this.hvQ.getLayoutMode().onModeChanged(this.mView);
        this.hvR.startLoad(c.a(this.hvQ.getPageContext().getPageActivity(), c.hvY, z), 29, false);
        this.hwn.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hvQ.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bSV() {
        if (this.mIndex != this.hwp) {
            return this.hvQ.getPageContext().getString(R.string.next_step);
        }
        return this.hvQ.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSW() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.hvQ.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSX() {
        return true;
    }
}
