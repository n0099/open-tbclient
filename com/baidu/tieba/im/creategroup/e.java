package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class e implements o {
    private CreateGroupStepActivity gCY;
    private TbImageView gDk;
    private Button gDl;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.gCY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_lbs_tips, (ViewGroup) null);
        this.gDl = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.gDk = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.gDl.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.gCY.getActivity(), c.gDd, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gCY.getActivity(), c.gDg, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gCY.getActivity(), c.gDe, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byR() {
        this.gDk.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byS() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCY.getLayoutMode().setNightMode(z);
        this.gCY.getLayoutMode().onModeChanged(this.mView);
        this.gDk.startLoad(c.a(this.gCY.getActivity(), c.gDf, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byL() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.gCY.getPageContext().getString(R.string.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byU() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byV() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button bzb() {
        return this.gDl;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byW() {
        return false;
    }
}
