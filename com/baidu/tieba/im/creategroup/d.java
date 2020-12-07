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
    EditText koB;
    TextView koC;
    CreateGroupStepActivity kor;
    TbImageView kos;
    private int kov;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kor = null;
        this.mView = null;
        this.kos = null;
        this.koB = null;
        this.koC = null;
        this.kor = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.kos = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.koB = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.koC = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.kov = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cUq() {
        return this.mIndex;
    }

    public EditText cUC() {
        return this.koB;
    }

    public TextView cUD() {
        return this.koC;
    }

    public void DT(int i) {
        String charSequence2String;
        if (wg() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.koB.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.koB.setText(charSequence2String);
            this.koB.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.kor.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int wg() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.koB);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUw() {
        this.kos.setBackgroundDrawable(null);
    }

    public void cUE() {
        this.kor.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kor.getLayoutMode().onModeChanged(this.koC);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUx() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kor.getLayoutMode().setNightMode(z);
        this.kor.getLayoutMode().onModeChanged(this.mView);
        String a2 = c.a(this.kor.getActivity(), c.kox, z);
        this.koB.setHintTextColor(ap.getColor(R.color.common_color_10005));
        this.kos.startLoad(a2, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kor.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cUz() {
        if (this.mIndex != this.kov) {
            return this.kor.getPageContext().getString(R.string.next_step);
        }
        return this.kor.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUA() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.kor.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUB() {
        return true;
    }
}
