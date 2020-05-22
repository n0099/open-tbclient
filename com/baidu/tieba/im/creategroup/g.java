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
    EditText iwB;
    private ImageButton iwC;
    private int iwD;
    CreateGroupStepActivity iwe;
    TbImageView iwf;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText ckv() {
        return this.iwB;
    }

    public View ckw() {
        return this.iwC;
    }

    public void ckx() {
        this.iwB.setText("");
    }

    public int ckq() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.iwB);
    }

    public void oT(boolean z) {
        if (z) {
            this.iwC.setVisibility(0);
        } else {
            this.iwC.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iwe = null;
        this.mView = null;
        this.iwf = null;
        this.iwB = null;
        this.iwC = null;
        this.iwe = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.iwB = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.iwf = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.iwC = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.iwC.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.iwD = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int ckc() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.iwe.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cki() {
        this.iwf.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void ckj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iwe.getLayoutMode().setNightMode(z);
        this.iwe.getLayoutMode().onModeChanged(this.mView);
        this.iwf.startLoad(c.a(this.iwe.getPageContext().getPageActivity(), c.iwm, z), 29, false);
        this.iwB.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iwe.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String ckl() {
        if (this.mIndex != this.iwD) {
            return this.iwe.getPageContext().getString(R.string.next_step);
        }
        return this.iwe.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckm() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.iwe.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckn() {
        return true;
    }
}
