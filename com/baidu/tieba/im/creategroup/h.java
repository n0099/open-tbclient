package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class h implements o {
    private CreateGroupStepActivity kaN;
    private TbImageView kaZ;
    private Button kba;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.kaN = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.kba = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.kaZ = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.kba.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.kaN.getPageContext().getPageActivity(), c.kaS, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.kaN.getPageContext().getPageActivity(), c.kaV, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.kaN.getPageContext().getPageActivity(), c.kaT, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPi() {
        this.kaZ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kaN.getLayoutMode().setNightMode(z);
        this.kaN.getLayoutMode().onModeChanged(this.mView);
        this.kaZ.startLoad(c.a(this.kaN.getPageContext().getPageActivity(), c.kaW, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cPc() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.kaN.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cPl() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPm() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPn() {
        return false;
    }

    public Button cPr() {
        return this.kba;
    }
}
