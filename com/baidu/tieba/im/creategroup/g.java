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
    EditText koQ;
    private ImageButton koR;
    private int koS;
    CreateGroupStepActivity kot;
    TbImageView kou;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText cUJ() {
        return this.koQ;
    }

    public View cUK() {
        return this.koR;
    }

    public void cUL() {
        this.koQ.setText("");
    }

    public int wg() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.koQ);
    }

    public void sl(boolean z) {
        if (z) {
            this.koR.setVisibility(0);
        } else {
            this.koR.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kot = null;
        this.mView = null;
        this.kou = null;
        this.koQ = null;
        this.koR = null;
        this.kot = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.koQ = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.kou = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.koR = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.koR.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.koS = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cUr() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.kot.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUx() {
        this.kou.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUy() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kot.getLayoutMode().setNightMode(z);
        this.kot.getLayoutMode().onModeChanged(this.mView);
        this.kou.startLoad(c.a(this.kot.getPageContext().getPageActivity(), c.koB, z), 29, false);
        this.koQ.setHintTextColor(ap.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kot.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cUA() {
        if (this.mIndex != this.koS) {
            return this.kot.getPageContext().getString(R.string.next_step);
        }
        return this.kot.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUB() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.kot.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUC() {
        return true;
    }
}
