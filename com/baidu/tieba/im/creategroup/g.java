package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class g implements o {
    CreateGroupStepActivity iNW;
    TbImageView iNX;
    EditText iOt;
    private ImageButton iOu;
    private int iOv;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cou() {
        return this.iOt;
    }

    public View cov() {
        return this.iOu;
    }

    public void cow() {
        this.iOt.setText("");
    }

    public int cop() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.iOt);
    }

    public void pd(boolean z) {
        if (z) {
            this.iOu.setVisibility(0);
        } else {
            this.iOu.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iNW = null;
        this.mView = null;
        this.iNX = null;
        this.iOt = null;
        this.iOu = null;
        this.iNW = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.iOt = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.iNX = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.iOu = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.iOu.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.iOv = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cob() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.iNW.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void coh() {
        this.iNX.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void coi() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iNW.getLayoutMode().setNightMode(z);
        this.iNW.getLayoutMode().onModeChanged(this.mView);
        this.iNX.startLoad(c.a(this.iNW.getPageContext().getPageActivity(), c.iOe, z), 29, false);
        this.iOt.setHintTextColor(an.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iNW.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cok() {
        if (this.mIndex != this.iOv) {
            return this.iNW.getPageContext().getString(R.string.next_step);
        }
        return this.iNW.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean col() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.iNW.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean com() {
        return true;
    }
}
