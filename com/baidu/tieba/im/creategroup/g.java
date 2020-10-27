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
    EditText jUD;
    private ImageButton jUE;
    private int jUF;
    CreateGroupStepActivity jUg;
    TbImageView jUh;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cNn() {
        return this.jUD;
    }

    public View cNo() {
        return this.jUE;
    }

    public void cNp() {
        this.jUD.setText("");
    }

    public int wp() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.jUD);
    }

    public void rx(boolean z) {
        if (z) {
            this.jUE.setVisibility(0);
        } else {
            this.jUE.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jUg = null;
        this.mView = null;
        this.jUh = null;
        this.jUD = null;
        this.jUE = null;
        this.jUg = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.jUD = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.jUh = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.jUE = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.jUE.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.jUF = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cMV() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.jUg.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cNb() {
        this.jUh.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cNc() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jUg.getLayoutMode().setNightMode(z);
        this.jUg.getLayoutMode().onModeChanged(this.mView);
        this.jUh.startLoad(c.a(this.jUg.getPageContext().getPageActivity(), c.jUo, z), 29, false);
        this.jUD.setHintTextColor(ap.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jUg.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cNe() {
        if (this.mIndex != this.jUF) {
            return this.jUg.getPageContext().getString(R.string.next_step);
        }
        return this.jUg.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cNf() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.jUg.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cNg() {
        return true;
    }
}
