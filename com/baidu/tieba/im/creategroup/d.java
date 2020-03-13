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
    CreateGroupStepActivity hwc;
    TbImageView hwd;
    private int hwg;
    EditText hwm;
    TextView hwn;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hwc = null;
        this.mView = null;
        this.hwd = null;
        this.hwm = null;
        this.hwn = null;
        this.hwc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.hwd = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.hwm = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.hwn = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.hwg = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSN() {
        return this.mIndex;
    }

    public EditText bSZ() {
        return this.hwm;
    }

    public TextView bTa() {
        return this.hwn;
    }

    public void wg(int i) {
        String charSequence2String;
        if (bTb() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.hwm.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.hwm.setText(charSequence2String);
            this.hwm.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.hwc.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int bTb() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hwm);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bST() {
        this.hwd.setBackgroundDrawable(null);
    }

    public void bTc() {
        this.hwc.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hwc.getLayoutMode().onModeChanged(this.hwn);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSU() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hwc.getLayoutMode().setNightMode(z);
        this.hwc.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.hwc.getActivity(), c.hwi, z);
        this.hwm.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.hwd.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hwc.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bSW() {
        if (this.mIndex != this.hwg) {
            return this.hwc.getPageContext().getString(R.string.next_step);
        }
        return this.hwc.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSX() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.hwc.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSY() {
        return true;
    }
}
