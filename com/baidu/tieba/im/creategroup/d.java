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
    private int Nl;
    CreateGroupStepActivity gEY;
    TbImageView gEZ;
    private int gFc;
    EditText gFi;
    TextView gFj;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gEY = null;
        this.mView = null;
        this.gEZ = null;
        this.gFi = null;
        this.gFj = null;
        this.gEY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.gEZ = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.gFi = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.gFj = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.Nl = i2;
        this.gFc = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bCa() {
        return this.mIndex;
    }

    public EditText bCm() {
        return this.gFi;
    }

    public TextView bCn() {
        return this.gFj;
    }

    public void vp(int i) {
        String a;
        if (bCo() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.gFi.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.ry(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.gFi.setText(a);
            this.gFi.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gEY.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int bCo() {
        return com.baidu.tieba.im.util.f.i(this.gFi);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bCg() {
        this.gEZ.setBackgroundDrawable(null);
    }

    public void bCp() {
        this.gEY.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gEY.getLayoutMode().onModeChanged(this.gFj);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bCh() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gEY.getLayoutMode().setNightMode(z);
        this.gEY.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.gEY.getActivity(), c.gFe, z);
        this.gFi.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.gEZ.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gEY.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.Nl));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bCj() {
        if (this.mIndex != this.gFc) {
            return this.gEY.getPageContext().getString(R.string.next_step);
        }
        return this.gEY.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bCk() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gEY.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bCl() {
        return true;
    }
}
