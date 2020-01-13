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
/* loaded from: classes8.dex */
public class d implements o {
    CreateGroupStepActivity htP;
    TbImageView htQ;
    private int htT;
    EditText htZ;
    TextView hua;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.htP = null;
        this.mView = null;
        this.htQ = null;
        this.htZ = null;
        this.hua = null;
        this.htP = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.htQ = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.htZ = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.hua = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.htT = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bRj() {
        return this.mIndex;
    }

    public EditText bRv() {
        return this.htZ;
    }

    public TextView bRw() {
        return this.hua;
    }

    public void wa(int i) {
        String charSequence2String;
        if (bRx() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.htZ.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.htZ.setText(charSequence2String);
            this.htZ.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.htP.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int bRx() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.htZ);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bRp() {
        this.htQ.setBackgroundDrawable(null);
    }

    public void bRy() {
        this.htP.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.htP.getLayoutMode().onModeChanged(this.hua);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bRq() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.htP.getLayoutMode().setNightMode(z);
        this.htP.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.htP.getActivity(), c.htV, z);
        this.htZ.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.htQ.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.htP.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bRs() {
        if (this.mIndex != this.htT) {
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
        return this.htP.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bRu() {
        return true;
    }
}
