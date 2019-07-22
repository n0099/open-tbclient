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
    private int Nk;
    EditText gCM;
    private ImageButton gCN;
    private int gCO;
    CreateGroupStepActivity gCp;
    TbImageView gCq;
    private int mIndex;
    View mView;

    public EditText bBr() {
        return this.gCM;
    }

    public View bBs() {
        return this.gCN;
    }

    public void bBt() {
        this.gCM.setText("");
    }

    public int bBm() {
        return com.baidu.tieba.im.util.f.i(this.gCM);
    }

    public void lU(boolean z) {
        if (z) {
            this.gCN.setVisibility(0);
        } else {
            this.gCN.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCp = null;
        this.mView = null;
        this.gCq = null;
        this.gCM = null;
        this.gCN = null;
        this.gCp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.gCM = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.gCq = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.gCN = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.gCN.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.Nk = i2;
        this.gCO = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bAY() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gCp.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBe() {
        this.gCq.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBf() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCp.getLayoutMode().setNightMode(z);
        this.gCp.getLayoutMode().onModeChanged(this.mView);
        this.gCq.startLoad(c.a(this.gCp.getPageContext().getPageActivity(), c.gCx, z), 29, false);
        this.gCM.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gCp.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.Nk));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bBh() {
        if (this.mIndex != this.gCO) {
            return this.gCp.getPageContext().getString(R.string.next_step);
        }
        return this.gCp.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBi() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gCp.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBj() {
        return true;
    }
}
