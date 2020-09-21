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
/* loaded from: classes22.dex */
public class g implements o {
    CreateGroupStepActivity jsK;
    TbImageView jsL;
    EditText jth;
    private ImageButton jti;
    private int jtj;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cGx() {
        return this.jth;
    }

    public View cGy() {
        return this.jti;
    }

    public void cGz() {
        this.jth.setText("");
    }

    public int wg() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.jth);
    }

    public void qz(boolean z) {
        if (z) {
            this.jti.setVisibility(0);
        } else {
            this.jti.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jsK = null;
        this.mView = null;
        this.jsL = null;
        this.jth = null;
        this.jti = null;
        this.jsK = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.jth = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.jsL = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.jti = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.jti.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.jtj = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cGf() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.jsK.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cGl() {
        this.jsL.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cGm() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jsK.getLayoutMode().setNightMode(z);
        this.jsK.getLayoutMode().onModeChanged(this.mView);
        this.jsL.startLoad(c.a(this.jsK.getPageContext().getPageActivity(), c.jsS, z), 29, false);
        this.jth.setHintTextColor(ap.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jsK.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cGo() {
        if (this.mIndex != this.jtj) {
            return this.jsK.getPageContext().getString(R.string.next_step);
        }
        return this.jsK.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cGp() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.jsK.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cGq() {
        return true;
    }
}
