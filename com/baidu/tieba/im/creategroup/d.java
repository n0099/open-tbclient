package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class d implements o {
    CreateGroupStepActivity hvO;
    TbImageView hvP;
    private int hvS;
    EditText hvY;
    TextView hvZ;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hvO = null;
        this.mView = null;
        this.hvP = null;
        this.hvY = null;
        this.hvZ = null;
        this.hvO = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.hvP = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.hvY = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.hvZ = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.hvS = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSK() {
        return this.mIndex;
    }

    public EditText bSW() {
        return this.hvY;
    }

    public TextView bSX() {
        return this.hvZ;
    }

    public void wg(int i) {
        String charSequence2String;
        if (bSY() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.hvY.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.hvY.setText(charSequence2String);
            this.hvY.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.hvO.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int bSY() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hvY);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSQ() {
        this.hvP.setBackgroundDrawable(null);
    }

    public void bSZ() {
        this.hvO.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hvO.getLayoutMode().onModeChanged(this.hvZ);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSR() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hvO.getLayoutMode().setNightMode(z);
        this.hvO.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.hvO.getActivity(), c.hvU, z);
        this.hvY.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.hvP.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hvO.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bST() {
        if (this.mIndex != this.hvS) {
            return this.hvO.getPageContext().getString(R.string.next_step);
        }
        return this.hvO.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSU() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.hvO.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSV() {
        return true;
    }
}
