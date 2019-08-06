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
    EditText gDE;
    private ImageButton gDF;
    private int gDG;
    CreateGroupStepActivity gDh;
    TbImageView gDi;
    private int mIndex;
    View mView;

    public EditText bBF() {
        return this.gDE;
    }

    public View bBG() {
        return this.gDF;
    }

    public void bBH() {
        this.gDE.setText("");
    }

    public int bBA() {
        return com.baidu.tieba.im.util.f.i(this.gDE);
    }

    public void lU(boolean z) {
        if (z) {
            this.gDF.setVisibility(0);
        } else {
            this.gDF.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gDh = null;
        this.mView = null;
        this.gDi = null;
        this.gDE = null;
        this.gDF = null;
        this.gDh = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.gDE = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.gDi = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.gDF = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.gDF.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.Nk = i2;
        this.gDG = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bBm() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gDh.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBs() {
        this.gDi.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBt() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gDh.getLayoutMode().setNightMode(z);
        this.gDh.getLayoutMode().onModeChanged(this.mView);
        this.gDi.startLoad(c.a(this.gDh.getPageContext().getPageActivity(), c.gDp, z), 29, false);
        this.gDE.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gDh.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.Nk));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bBv() {
        if (this.mIndex != this.gDG) {
            return this.gDh.getPageContext().getString(R.string.next_step);
        }
        return this.gDh.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBw() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gDh.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBx() {
        return true;
    }
}
