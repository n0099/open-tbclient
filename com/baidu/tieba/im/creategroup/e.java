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
    private TbImageView koF;
    private Button koG;
    private CreateGroupStepActivity kot;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.kot = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_lbs_tips, (ViewGroup) null);
        this.koG = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.koF = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.koG.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.kot.getActivity(), c.koy, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.kot.getActivity(), c.koB, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.kot.getActivity(), c.koz, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUx() {
        this.koF.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUy() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kot.getLayoutMode().setNightMode(z);
        this.kot.getLayoutMode().onModeChanged(this.mView);
        this.koF.startLoad(c.a(this.kot.getActivity(), c.koA, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cUr() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.kot.getPageContext().getString(R.string.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cUA() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUB() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button cUG() {
        return this.koG;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUC() {
        return false;
    }
}
