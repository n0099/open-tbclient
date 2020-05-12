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
    EditText ihF;
    TextView ihG;
    CreateGroupStepActivity ihv;
    TbImageView ihw;
    private int ihz;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ihv = null;
        this.mView = null;
        this.ihw = null;
        this.ihF = null;
        this.ihG = null;
        this.ihv = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.ihw = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.ihF = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.ihG = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.ihz = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cdE() {
        return this.mIndex;
    }

    public EditText cdQ() {
        return this.ihF;
    }

    public TextView cdR() {
        return this.ihG;
    }

    public void wM(int i) {
        String charSequence2String;
        if (cdS() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.ihF.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.ihF.setText(charSequence2String);
            this.ihF.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.ihv.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int cdS() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.ihF);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdK() {
        this.ihw.setBackgroundDrawable(null);
    }

    public void cdT() {
        this.ihv.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ihv.getLayoutMode().onModeChanged(this.ihG);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdL() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ihv.getLayoutMode().setNightMode(z);
        this.ihv.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.ihv.getActivity(), c.ihB, z);
        this.ihF.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.ihw.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.ihv.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cdN() {
        if (this.mIndex != this.ihz) {
            return this.ihv.getPageContext().getString(R.string.next_step);
        }
        return this.ihv.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdO() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.ihv.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdP() {
        return true;
    }
}
