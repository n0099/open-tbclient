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
    private int MU;
    private int gwA;
    CreateGroupStepActivity gwb;
    TbImageView gwc;
    EditText gwy;
    private ImageButton gwz;
    private int mIndex;
    View mView;

    public EditText byI() {
        return this.gwy;
    }

    public View byJ() {
        return this.gwz;
    }

    public void byK() {
        this.gwy.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.i(this.gwy);
    }

    public void lF(boolean z) {
        if (z) {
            this.gwz.setVisibility(0);
        } else {
            this.gwz.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwb = null;
        this.mView = null;
        this.gwc = null;
        this.gwy = null;
        this.gwz = null;
        this.gwb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.gwy = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.gwc = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.gwz = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.gwz.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.MU = i2;
        this.gwA = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byq() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gwb.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byw() {
        this.gwc.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byx() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwb.getLayoutMode().setNightMode(z);
        this.gwb.getLayoutMode().onModeChanged(this.mView);
        this.gwc.startLoad(c.a(this.gwb.getPageContext().getPageActivity(), c.gwj, z), 29, false);
        this.gwy.setHintTextColor(al.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwb.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.MU));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byz() {
        if (this.mIndex != this.gwA) {
            return this.gwb.getPageContext().getString(R.string.next_step);
        }
        return this.gwb.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byA() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gwb.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byB() {
        return true;
    }
}
