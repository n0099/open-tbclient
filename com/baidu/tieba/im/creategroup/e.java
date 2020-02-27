package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class e implements o {
    private CreateGroupStepActivity hvO;
    private TbImageView hwa;
    private Button hwb;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.hvO = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_lbs_tips, (ViewGroup) null);
        this.hwb = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.hwa = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.hwb.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.hvO.getActivity(), c.hvT, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.hvO.getActivity(), c.hvW, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.hvO.getActivity(), c.hvU, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSQ() {
        this.hwa.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSR() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hvO.getLayoutMode().setNightMode(z);
        this.hvO.getLayoutMode().onModeChanged(this.mView);
        this.hwa.startLoad(c.a(this.hvO.getActivity(), c.hvV, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSK() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.hvO.getPageContext().getString(R.string.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bST() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSU() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button bTa() {
        return this.hwb;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSV() {
        return false;
    }
}
