package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class g implements o {
    private int MU;
    private ImageButton gwA;
    private int gwB;
    CreateGroupStepActivity gwc;
    TbImageView gwd;
    EditText gwz;
    private int mIndex;
    View mView;

    public EditText byL() {
        return this.gwz;
    }

    public View byM() {
        return this.gwA;
    }

    public void byN() {
        this.gwz.setText("");
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.i(this.gwz);
    }

    public void lF(boolean z) {
        if (z) {
            this.gwA.setVisibility(0);
        } else {
            this.gwA.setVisibility(8);
        }
    }

    public g(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwc = null;
        this.mView = null;
        this.gwd = null;
        this.gwz = null;
        this.gwA = null;
        this.gwc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step1_view, (ViewGroup) null);
        this.gwz = (EditText) this.mView.findViewById(R.id.step1_group_name);
        this.gwd = (TbImageView) this.mView.findViewById(R.id.step1_img_bg);
        this.gwA = (ImageButton) this.mView.findViewById(R.id.button_del);
        this.gwA.setOnClickListener(createGroupStepActivity);
        this.mIndex = i;
        this.MU = i2;
        this.gwB = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byt() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gwc.getPageContext().getPageActivity(), "create_g_name", "pv", 1, new Object[0]);
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byz() {
        this.gwd.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byA() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwc.getLayoutMode().setNightMode(z);
        this.gwc.getLayoutMode().onModeChanged(this.mView);
        this.gwd.startLoad(c.a(this.gwc.getPageContext().getPageActivity(), c.gwk, z), 29, false);
        this.gwz.setHintTextColor(al.getColor(R.color.common_color_10005));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwc.getPageContext().getString(R.string.group_create_step_name), Integer.valueOf(this.MU));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byC() {
        if (this.mIndex != this.gwB) {
            return this.gwc.getPageContext().getString(R.string.next_step);
        }
        return this.gwc.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byD() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gwc.getPageContext().getString(R.string.group_step_name_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byE() {
        return true;
    }
}
