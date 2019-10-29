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
/* loaded from: classes5.dex */
public class g implements o {
    CreateGroupStepActivity gCY;
    TbImageView gCZ;
    EditText gDv;
    private ImageButton gDw;
    private int gDx;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText bze() {
        return this.gDv;
    }

    public View bzf() {
        return this.gDw;
    }

    public void bzg() {
        this.gDv.setText("");
    }

    public int byZ() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.gDv);
    }

    public void lL(boolean z) {
        if (z) {
            this.gDw.setVisibility(0);
        } else {
            this.gDw.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCY = null;
        this.mView = null;
        this.gCZ = null;
        this.gDv = null;
        this.gDw = null;
        this.gCY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.gDv = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.gCZ = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.gDw = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.gDw.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.gDx = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byL() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gCY.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byR() {
        this.gCZ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byS() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCY.getLayoutMode().setNightMode(z);
        this.gCY.getLayoutMode().onModeChanged(this.mView);
        this.gCZ.startLoad(c.a(this.gCY.getPageContext().getPageActivity(), c.gDg, z), 29, false);
        this.gDv.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gCY.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byU() {
        if (this.mIndex != this.gDx) {
            return this.gCY.getPageContext().getString(R.string.next_step);
        }
        return this.gCY.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byV() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gCY.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byW() {
        return true;
    }
}
