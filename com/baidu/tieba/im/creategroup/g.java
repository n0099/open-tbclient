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
    CreateGroupStepActivity iwR;
    TbImageView iwS;
    EditText ixo;
    private ImageButton ixp;
    private int ixq;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText ckE() {
        return this.ixo;
    }

    public View ckF() {
        return this.ixp;
    }

    public void ckG() {
        this.ixo.setText("");
    }

    public int ckz() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.ixo);
    }

    public void oT(boolean z) {
        if (z) {
            this.ixp.setVisibility(0);
        } else {
            this.ixp.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iwR = null;
        this.mView = null;
        this.iwS = null;
        this.ixo = null;
        this.ixp = null;
        this.iwR = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.ixo = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.iwS = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.ixp = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.ixp.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.ixq = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int ckl() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.iwR.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void ckr() {
        this.iwS.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cks() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iwR.getLayoutMode().setNightMode(z);
        this.iwR.getLayoutMode().onModeChanged(this.mView);
        this.iwS.startLoad(c.a(this.iwR.getPageContext().getPageActivity(), c.iwZ, z), 29, false);
        this.ixo.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iwR.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cku() {
        if (this.mIndex != this.ixq) {
            return this.iwR.getPageContext().getString(R.string.next_step);
        }
        return this.iwR.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckv() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.iwR.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckw() {
        return true;
    }
}
