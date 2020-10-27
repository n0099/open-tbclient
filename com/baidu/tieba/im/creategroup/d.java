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
/* loaded from: classes23.dex */
public class d implements o {
    CreateGroupStepActivity jUg;
    TbImageView jUh;
    private int jUk;
    EditText jUq;
    TextView jUr;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jUg = null;
        this.mView = null;
        this.jUh = null;
        this.jUq = null;
        this.jUr = null;
        this.jUg = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.jUh = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.jUq = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.jUr = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.jUk = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cMV() {
        return this.mIndex;
    }

    public EditText cNh() {
        return this.jUq;
    }

    public TextView cNi() {
        return this.jUr;
    }

    public void Ct(int i) {
        String charSequence2String;
        if (wp() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.jUq.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.jUq.setText(charSequence2String);
            this.jUq.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.jUg.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int wp() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.jUq);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cNb() {
        this.jUh.setBackgroundDrawable(null);
    }

    public void cNj() {
        this.jUg.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jUg.getLayoutMode().onModeChanged(this.jUr);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cNc() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jUg.getLayoutMode().setNightMode(z);
        this.jUg.getLayoutMode().onModeChanged(this.mView);
        String a2 = c.a(this.jUg.getActivity(), c.jUm, z);
        this.jUq.setHintTextColor(ap.getColor(R.color.common_color_10005));
        this.jUh.startLoad(a2, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jUg.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cNe() {
        if (this.mIndex != this.jUk) {
            return this.jUg.getPageContext().getString(R.string.next_step);
        }
        return this.jUg.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cNf() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.jUg.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cNg() {
        return true;
    }
}
