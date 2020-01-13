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
/* loaded from: classes8.dex */
public class g implements o {
    CreateGroupStepActivity htP;
    TbImageView htQ;
    EditText hum;
    private ImageButton hun;
    private int huo;
    private int mIndex;
    private int mStep;
    View mView;

    public EditText bRC() {
        return this.hum;
    }

    public View bRD() {
        return this.hun;
    }

    public void bRE() {
        this.hum.setText("");
    }

    public int bRx() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hum);
    }

    public void nl(boolean z) {
        if (z) {
            this.hun.setVisibility(0);
        } else {
            this.hun.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.htP = null;
        this.mView = null;
        this.htQ = null;
        this.hum = null;
        this.hun = null;
        this.htP = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.hum = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.htQ = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.hun = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.hun.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.mStep = i2;
        this.huo = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bRj() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.htP.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bRp() {
        this.htQ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bRq() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.htP.getLayoutMode().setNightMode(z);
        this.htP.getLayoutMode().onModeChanged(this.mView);
        this.htQ.startLoad(c.a(this.htP.getPageContext().getPageActivity(), c.htX, z), 29, false);
        this.hum.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.htP.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bRs() {
        if (this.mIndex != this.huo) {
            return this.htP.getPageContext().getString(R.string.next_step);
        }
        return this.htP.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bRt() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.htP.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bRu() {
        return true;
    }
}
