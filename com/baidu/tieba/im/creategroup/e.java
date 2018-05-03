package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e implements o {
    private CreateGroupStepActivity dUc;
    private TbImageView dUo;
    private Button dUp;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.dUc = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_lbs_tips, (ViewGroup) null);
        this.dUp = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.dUo = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.dUp.setText(String.format(createGroupStepActivity.getPageContext().getString(d.k.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.dUc.getActivity(), c.dUh, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.dUc.getActivity(), c.dUk, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.dUc.getActivity(), c.dUi, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBE() {
        this.dUo.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dUc.getLayoutMode().setNightMode(z);
        this.dUc.getLayoutMode().u(this.mView);
        this.dUo.startLoad(c.a(this.dUc.getActivity(), c.dUj, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.dUc.getPageContext().getString(d.k.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBH() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button aBN() {
        return this.dUp;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBJ() {
        return false;
    }
}
