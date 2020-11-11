package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class e implements o {
    private CreateGroupStepActivity kac;
    private TbImageView kao;
    private Button kap;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.kac = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_lbs_tips, (ViewGroup) null);
        this.kap = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.kao = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.kap.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.kac.getActivity(), c.kah, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.kac.getActivity(), c.kak, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.kac.getActivity(), c.kai, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPC() {
        this.kao.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPD() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kac.getLayoutMode().setNightMode(z);
        this.kac.getLayoutMode().onModeChanged(this.mView);
        this.kao.startLoad(c.a(this.kac.getActivity(), c.kaj, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cPw() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.kac.getPageContext().getString(R.string.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cPF() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPG() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button cPL() {
        return this.kap;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPH() {
        return false;
    }
}
