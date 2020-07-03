package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class d implements o {
    CreateGroupStepActivity iNW;
    TbImageView iNX;
    private int iOa;
    EditText iOg;
    TextView iOh;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iNW = null;
        this.mView = null;
        this.iNX = null;
        this.iOg = null;
        this.iOh = null;
        this.iNW = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.iNX = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.iOg = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.iOh = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.iOa = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int coa() {
        return this.mIndex;
    }

    public EditText com() {
        return this.iOg;
    }

    public TextView con() {
        return this.iOh;
    }

    public void ye(int i) {
        String charSequence2String;
        if (coo() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.iOg.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.iOg.setText(charSequence2String);
            this.iOg.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.iNW.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int coo() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.iOg);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cog() {
        this.iNX.setBackgroundDrawable(null);
    }

    public void cop() {
        this.iNW.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iNW.getLayoutMode().onModeChanged(this.iOh);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void coh() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iNW.getLayoutMode().setNightMode(z);
        this.iNW.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.iNW.getActivity(), c.iOc, z);
        this.iOg.setHintTextColor(an.getColor(R.color.common_color_10005));
        this.iNX.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iNW.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String coj() {
        if (this.mIndex != this.iOa) {
            return this.iNW.getPageContext().getString(R.string.next_step);
        }
        return this.iNW.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cok() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.iNW.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean col() {
        return true;
    }
}
