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
    TextView gCA;
    CreateGroupStepActivity gCp;
    TbImageView gCq;
    private int gCt;
    EditText gCz;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCp = null;
        this.mView = null;
        this.gCq = null;
        this.gCz = null;
        this.gCA = null;
        this.gCp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.gCq = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.gCz = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.gCA = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.Nk = i2;
        this.gCt = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bAY() {
        return this.mIndex;
    }

    public EditText bBk() {
        return this.gCz;
    }

    public TextView bBl() {
        return this.gCA;
    }

    public void vj(int i) {
        String a;
        if (bBm() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.gCz.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.rn(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.gCz.setText(a);
            this.gCz.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gCp.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int bBm() {
        return com.baidu.tieba.im.util.f.i(this.gCz);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBe() {
        this.gCq.setBackgroundDrawable(null);
    }

    public void bBn() {
        this.gCp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gCp.getLayoutMode().onModeChanged(this.gCA);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bBf() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCp.getLayoutMode().setNightMode(z);
        this.gCp.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.gCp.getActivity(), c.gCv, z);
        this.gCz.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.gCq.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gCp.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.Nk));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bBh() {
        if (this.mIndex != this.gCt) {
            return this.gCp.getPageContext().getString(R.string.next_step);
        }
        return this.gCp.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBi() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gCp.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bBj() {
        return true;
    }
}
