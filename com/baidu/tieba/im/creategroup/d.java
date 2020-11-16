package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class d implements o {
    CreateGroupStepActivity kaN;
    TbImageView kaO;
    private int kaR;
    EditText kaX;
    TextView kaY;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kaN = null;
        this.mView = null;
        this.kaO = null;
        this.kaX = null;
        this.kaY = null;
        this.kaN = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.kaO = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.kaX = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.kaY = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.kaR = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cPc() {
        return this.mIndex;
    }

    public EditText cPo() {
        return this.kaX;
    }

    public TextView cPp() {
        return this.kaY;
    }

    public void De(int i) {
        String charSequence2String;
        if (wo() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.kaX.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.kaX.setText(charSequence2String);
            this.kaX.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.kaN.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int wo() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.kaX);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPi() {
        this.kaO.setBackgroundDrawable(null);
    }

    public void cPq() {
        this.kaN.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kaN.getLayoutMode().onModeChanged(this.kaY);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kaN.getLayoutMode().setNightMode(z);
        this.kaN.getLayoutMode().onModeChanged(this.mView);
        String a2 = c.a(this.kaN.getActivity(), c.kaT, z);
        this.kaX.setHintTextColor(ap.getColor(R.color.common_color_10005));
        this.kaO.startLoad(a2, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kaN.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cPl() {
        if (this.mIndex != this.kaR) {
            return this.kaN.getPageContext().getString(R.string.next_step);
        }
        return this.kaN.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPm() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.kaN.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPn() {
        return true;
    }
}
