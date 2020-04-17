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
    TextView ihA;
    CreateGroupStepActivity ihp;
    TbImageView ihq;
    private int iht;
    EditText ihz;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ihp = null;
        this.mView = null;
        this.ihq = null;
        this.ihz = null;
        this.ihA = null;
        this.ihp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.ihq = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.ihz = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.ihA = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.iht = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cdF() {
        return this.mIndex;
    }

    public EditText cdR() {
        return this.ihz;
    }

    public TextView cdS() {
        return this.ihA;
    }

    public void wM(int i) {
        String charSequence2String;
        if (cdT() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.ihz.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.ihz.setText(charSequence2String);
            this.ihz.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.ihp.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int cdT() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.ihz);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdL() {
        this.ihq.setBackgroundDrawable(null);
    }

    public void cdU() {
        this.ihp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ihp.getLayoutMode().onModeChanged(this.ihA);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdM() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ihp.getLayoutMode().setNightMode(z);
        this.ihp.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.ihp.getActivity(), c.ihv, z);
        this.ihz.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.ihq.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ihp.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cdO() {
        if (this.mIndex != this.iht) {
            return this.ihp.getPageContext().getString(R.string.next_step);
        }
        return this.ihp.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdP() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.ihp.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdQ() {
        return true;
    }
}
