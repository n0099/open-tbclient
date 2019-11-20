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
    EditText gCE;
    private ImageButton gCF;
    private int gCG;
    CreateGroupStepActivity gCh;
    TbImageView gCi;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText bzc() {
        return this.gCE;
    }

    public View bzd() {
        return this.gCF;
    }

    public void bze() {
        this.gCE.setText("");
    }

    public int byX() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.gCE);
    }

    public void lL(boolean z) {
        if (z) {
            this.gCF.setVisibility(0);
        } else {
            this.gCF.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCh = null;
        this.mView = null;
        this.gCi = null;
        this.gCE = null;
        this.gCF = null;
        this.gCh = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.gCE = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.gCi = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.gCF = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.gCF.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.gCG = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byJ() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gCh.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byP() {
        this.gCi.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byQ() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCh.getLayoutMode().setNightMode(z);
        this.gCh.getLayoutMode().onModeChanged(this.mView);
        this.gCi.startLoad(c.a(this.gCh.getPageContext().getPageActivity(), c.gCp, z), 29, false);
        this.gCE.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gCh.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byS() {
        if (this.mIndex != this.gCG) {
            return this.gCh.getPageContext().getString(R.string.next_step);
        }
        return this.gCh.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byT() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gCh.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byU() {
        return true;
    }
}
