package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e implements p {
    private TbImageView ezJ;
    private Button ezK;
    private CreateGroupStepActivity ezx;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.ezx = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_lbs_tips, (ViewGroup) null);
        this.ezK = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.ezJ = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.ezK.setText(String.format(createGroupStepActivity.getPageContext().getString(d.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.ezx.getActivity(), c.ezC, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ezx.getActivity(), c.ezF, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ezx.getActivity(), c.ezD, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        this.ezJ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezx.getLayoutMode().aQ(z);
        this.ezx.getLayoutMode().aM(this.mView);
        this.ezJ.startLoad(c.a(this.ezx.getActivity(), c.ezE, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGy() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return this.ezx.getPageContext().getString(d.j.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGH() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return null;
    }

    public Button aGN() {
        return this.ezK;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGJ() {
        return false;
    }
}
