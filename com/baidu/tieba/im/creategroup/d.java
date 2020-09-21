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
    CreateGroupStepActivity jsK;
    TbImageView jsL;
    private int jsO;
    EditText jsU;
    TextView jsV;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jsK = null;
        this.mView = null;
        this.jsL = null;
        this.jsU = null;
        this.jsV = null;
        this.jsK = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.jsL = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.jsU = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.jsV = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.jsO = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cGf() {
        return this.mIndex;
    }

    public EditText cGr() {
        return this.jsU;
    }

    public TextView cGs() {
        return this.jsV;
    }

    public void Bu(int i) {
        String charSequence2String;
        if (wg() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.jsU.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.jsU.setText(charSequence2String);
            this.jsU.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.jsK.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int wg() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.jsU);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cGl() {
        this.jsL.setBackgroundDrawable(null);
    }

    public void cGt() {
        this.jsK.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jsK.getLayoutMode().onModeChanged(this.jsV);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cGm() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jsK.getLayoutMode().setNightMode(z);
        this.jsK.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.jsK.getActivity(), c.jsQ, z);
        this.jsU.setHintTextColor(ap.getColor(R.color.common_color_10005));
        this.jsL.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jsK.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cGo() {
        if (this.mIndex != this.jsO) {
            return this.jsK.getPageContext().getString(R.string.next_step);
        }
        return this.jsK.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cGp() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.jsK.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cGq() {
        return true;
    }
}
