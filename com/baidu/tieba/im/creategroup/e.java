package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class e implements o {
    private CreateGroupStepActivity iUZ;
    private TbImageView iVl;
    private Button iVm;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.iUZ = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_lbs_tips, (ViewGroup) null);
        this.iVm = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.iVl = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.iVm.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.iUZ.getActivity(), c.iVe, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.iUZ.getActivity(), c.iVh, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.iUZ.getActivity(), c.iVf, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crM() {
        this.iVl.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crN() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iUZ.getLayoutMode().setNightMode(z);
        this.iUZ.getLayoutMode().onModeChanged(this.mView);
        this.iVl.startLoad(c.a(this.iUZ.getActivity(), c.iVg, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int crG() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.iUZ.getPageContext().getString(R.string.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String crP() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crQ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button crW() {
        return this.iVm;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crR() {
        return false;
    }
}
