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
/* loaded from: classes17.dex */
public class g implements o {
    CreateGroupStepActivity jka;
    TbImageView jkb;
    EditText jkx;
    private ImageButton jky;
    private int jkz;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cCQ() {
        return this.jkx;
    }

    public View cCR() {
        return this.jky;
    }

    public void cCS() {
        this.jkx.setText("");
    }

    public int vS() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.jkx);
    }

    public void qp(boolean z) {
        if (z) {
            this.jky.setVisibility(0);
        } else {
            this.jky.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jka = null;
        this.mView = null;
        this.jkb = null;
        this.jkx = null;
        this.jky = null;
        this.jka = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.jkx = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.jkb = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.jky = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.jky.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.jkz = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cCy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.jka.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCE() {
        this.jkb.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jka.getLayoutMode().setNightMode(z);
        this.jka.getLayoutMode().onModeChanged(this.mView);
        this.jkb.startLoad(c.a(this.jka.getPageContext().getPageActivity(), c.jki, z), 29, false);
        this.jkx.setHintTextColor(ap.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jka.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cCH() {
        if (this.mIndex != this.jkz) {
            return this.jka.getPageContext().getString(R.string.next_step);
        }
        return this.jka.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.jka.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCJ() {
        return true;
    }
}
