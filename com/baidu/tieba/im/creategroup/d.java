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
/* loaded from: classes5.dex */
public class d implements o {
    private int Nk;
    CreateGroupStepActivity gDh;
    TbImageView gDi;
    private int gDl;
    EditText gDr;
    TextView gDs;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gDh = null;
        this.mView = null;
        this.gDi = null;
        this.gDr = null;
        this.gDs = null;
        this.gDh = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.gDi = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.gDr = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.gDs = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.Nk = i2;
        this.gDl = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bBm() {
        return this.mIndex;
    }

    public EditText bBy() {
        return this.gDr;
    }

    public TextView bBz() {
        return this.gDs;
    }

    public void vl(int i) {
        String a;
        if (bBA() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.gDr.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.rn(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.gDr.setText(a);
            this.gDr.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gDh.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int bBA() {
        return com.baidu.tieba.im.util.f.i(this.gDr);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBs() {
        this.gDi.setBackgroundDrawable(null);
    }

    public void bBB() {
        this.gDh.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gDh.getLayoutMode().onModeChanged(this.gDs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBt() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gDh.getLayoutMode().setNightMode(z);
        this.gDh.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.gDh.getActivity(), c.gDn, z);
        this.gDr.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.gDi.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gDh.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.Nk));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bBv() {
        if (this.mIndex != this.gDl) {
            return this.gDh.getPageContext().getString(R.string.next_step);
        }
        return this.gDh.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBw() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gDh.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBx() {
        return true;
    }
}
