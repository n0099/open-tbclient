package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class g implements o {
    CreateGroupStepActivity jHH;
    TbImageView jHI;
    EditText jIe;
    private ImageButton jIf;
    private int jIg;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cKg() {
        return this.jIe;
    }

    public View cKh() {
        return this.jIf;
    }

    public void cKi() {
        this.jIe.setText("");
    }

    public int wp() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.jIe);
    }

    public void rf(boolean z) {
        if (z) {
            this.jIf.setVisibility(0);
        } else {
            this.jIf.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jHH = null;
        this.mView = null;
        this.jHI = null;
        this.jIe = null;
        this.jIf = null;
        this.jHH = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.jIe = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.jHI = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.jIf = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.jIf.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.jIg = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cJO() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.jHH.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cJU() {
        this.jHI.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cJV() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jHH.getLayoutMode().setNightMode(z);
        this.jHH.getLayoutMode().onModeChanged(this.mView);
        this.jHI.startLoad(c.a(this.jHH.getPageContext().getPageActivity(), c.jHP, z), 29, false);
        this.jIe.setHintTextColor(ap.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jHH.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cJX() {
        if (this.mIndex != this.jIg) {
            return this.jHH.getPageContext().getString(R.string.next_step);
        }
        return this.jHH.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cJY() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.jHH.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cJZ() {
        return true;
    }
}
