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
    private TbImageView ihH;
    private Button ihI;
    private CreateGroupStepActivity ihv;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.ihv = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_lbs_tips, (ViewGroup) null);
        this.ihI = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.ihH = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.ihI.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.ihv.getActivity(), c.ihA, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ihv.getActivity(), c.ihD, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ihv.getActivity(), c.ihB, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdJ() {
        this.ihH.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdK() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ihv.getLayoutMode().setNightMode(z);
        this.ihv.getLayoutMode().onModeChanged(this.mView);
        this.ihH.startLoad(c.a(this.ihv.getActivity(), c.ihC, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cdD() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.ihv.getPageContext().getString(R.string.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cdM() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdN() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button cdT() {
        return this.ihI;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdO() {
        return false;
    }
}
