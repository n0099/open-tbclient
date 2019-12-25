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
/* loaded from: classes7.dex */
public class d implements o {
    CreateGroupStepActivity hqm;
    TbImageView hqn;
    private int hqq;
    EditText hqw;
    TextView hqx;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hqm = null;
        this.mView = null;
        this.hqn = null;
        this.hqw = null;
        this.hqx = null;
        this.hqm = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.hqn = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.hqw = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.hqx = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.hqq = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bQa() {
        return this.mIndex;
    }

    public EditText bQm() {
        return this.hqw;
    }

    public TextView bQn() {
        return this.hqx;
    }

    public void vV(int i) {
        String charSequence2String;
        if (bQo() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.hqw.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.hqw.setText(charSequence2String);
            this.hqw.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.hqm.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int bQo() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hqw);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bQg() {
        this.hqn.setBackgroundDrawable(null);
    }

    public void bQp() {
        this.hqm.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hqm.getLayoutMode().onModeChanged(this.hqx);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bQh() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hqm.getLayoutMode().setNightMode(z);
        this.hqm.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.hqm.getActivity(), c.hqs, z);
        this.hqw.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.hqn.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hqm.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bQj() {
        if (this.mIndex != this.hqq) {
            return this.hqm.getPageContext().getString(R.string.next_step);
        }
        return this.hqm.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bQk() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.hqm.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bQl() {
        return true;
    }
}
