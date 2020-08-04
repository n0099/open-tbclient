package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class d implements o {
    CreateGroupStepActivity iVb;
    TbImageView iVc;
    private int iVf;
    EditText iVl;
    TextView iVm;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iVb = null;
        this.mView = null;
        this.iVc = null;
        this.iVl = null;
        this.iVm = null;
        this.iVb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.iVc = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.iVl = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.iVm = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.iVf = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int crG() {
        return this.mIndex;
    }

    public EditText crS() {
        return this.iVl;
    }

    public TextView crT() {
        return this.iVm;
    }

    public void yz(int i) {
        String charSequence2String;
        if (crU() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.iVl.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.iVl.setText(charSequence2String);
            this.iVl.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.iVb.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int crU() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.iVl);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crM() {
        this.iVc.setBackgroundDrawable(null);
    }

    public void crV() {
        this.iVb.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iVb.getLayoutMode().onModeChanged(this.iVm);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crN() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iVb.getLayoutMode().setNightMode(z);
        this.iVb.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.iVb.getActivity(), c.iVh, z);
        this.iVl.setHintTextColor(ao.getColor(R.color.common_color_10005));
        this.iVc.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iVb.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String crP() {
        if (this.mIndex != this.iVf) {
            return this.iVb.getPageContext().getString(R.string.next_step);
        }
        return this.iVb.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crQ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.iVb.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crR() {
        return true;
    }
}
