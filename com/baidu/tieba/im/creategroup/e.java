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
    private CreateGroupStepActivity hwc;
    private TbImageView hwo;
    private Button hwp;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.hwc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_lbs_tips, (ViewGroup) null);
        this.hwp = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.hwo = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.hwp.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.hwc.getActivity(), c.hwh, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.hwc.getActivity(), c.hwk, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.hwc.getActivity(), c.hwi, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bST() {
        this.hwo.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSU() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hwc.getLayoutMode().setNightMode(z);
        this.hwc.getLayoutMode().onModeChanged(this.mView);
        this.hwo.startLoad(c.a(this.hwc.getActivity(), c.hwj, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSN() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.hwc.getPageContext().getString(R.string.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bSW() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSX() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button bTd() {
        return this.hwp;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSY() {
        return false;
    }
}
