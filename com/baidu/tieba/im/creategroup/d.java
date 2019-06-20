package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class d implements o {
    private int MT;
    CreateGroupStepActivity gwe;
    TbImageView gwf;
    private int gwi;
    EditText gwo;
    TextView gwp;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gwe = null;
        this.mView = null;
        this.gwf = null;
        this.gwo = null;
        this.gwp = null;
        this.gwe = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.gwf = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.gwo = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.gwp = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.MT = i2;
        this.gwi = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byu() {
        return this.mIndex;
    }

    public EditText byG() {
        return this.gwo;
    }

    public TextView byH() {
        return this.gwp;
    }

    public void uI(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.gwo.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.qV(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.gwo.setText(a);
            this.gwo.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gwe.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.i(this.gwo);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byA() {
        this.gwf.setBackgroundDrawable(null);
    }

    public void byI() {
        this.gwe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gwe.getLayoutMode().onModeChanged(this.gwp);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byB() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gwe.getLayoutMode().setNightMode(z);
        this.gwe.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.gwe.getActivity(), c.gwk, z);
        this.gwo.setHintTextColor(al.getColor(R.color.common_color_10005));
        this.gwf.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gwe.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.MT));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byD() {
        if (this.mIndex != this.gwi) {
            return this.gwe.getPageContext().getString(R.string.next_step);
        }
        return this.gwe.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byE() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gwe.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byF() {
        return true;
    }
}
