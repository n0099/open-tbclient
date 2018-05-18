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
    private CreateGroupStepActivity dVj;
    private TbImageView dVv;
    private Button dVw;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.dVj = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_lbs_tips, (ViewGroup) null);
        this.dVw = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.dVv = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.dVw.setText(String.format(createGroupStepActivity.getPageContext().getString(d.k.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.dVj.getActivity(), c.dVo, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.dVj.getActivity(), c.dVr, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.dVj.getActivity(), c.dVp, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBC() {
        this.dVv.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aBD() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.dVj.getLayoutMode().setNightMode(z);
        this.dVj.getLayoutMode().u(this.mView);
        this.dVv.startLoad(c.a(this.dVj.getActivity(), c.dVq, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aBw() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.dVj.getPageContext().getString(d.k.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aBF() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBG() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button aBL() {
        return this.dVw;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aBH() {
        return false;
    }
}
