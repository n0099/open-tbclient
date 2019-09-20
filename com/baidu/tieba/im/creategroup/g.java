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
    private int Nl;
    CreateGroupStepActivity gEY;
    TbImageView gEZ;
    EditText gFv;
    private ImageButton gFw;
    private int gFx;
    private int mIndex;
    View mView;

    public EditText bCt() {
        return this.gFv;
    }

    public View bCu() {
        return this.gFw;
    }

    public void bCv() {
        this.gFv.setText("");
    }

    public int bCo() {
        return com.baidu.tieba.im.util.f.i(this.gFv);
    }

    public void lX(boolean z) {
        if (z) {
            this.gFw.setVisibility(0);
        } else {
            this.gFw.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gEY = null;
        this.mView = null;
        this.gEZ = null;
        this.gFv = null;
        this.gFw = null;
        this.gEY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.gFv = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.gEZ = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.gFw = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.gFw.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.Nl = i2;
        this.gFx = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bCa() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gEY.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bCg() {
        this.gEZ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bCh() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gEY.getLayoutMode().setNightMode(z);
        this.gEY.getLayoutMode().onModeChanged(this.mView);
        this.gEZ.startLoad(c.a(this.gEY.getPageContext().getPageActivity(), c.gFg, z), 29, false);
        this.gFv.setHintTextColor(am.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gEY.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.Nl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bCj() {
        if (this.mIndex != this.gFx) {
            return this.gEY.getPageContext().getString(R.string.next_step);
        }
        return this.gEY.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bCk() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gEY.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bCl() {
        return true;
    }
}
