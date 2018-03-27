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
    private CreateGroupStepActivity ezB;
    private TbImageView ezN;
    private Button ezO;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.ezB = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_lbs_tips, (ViewGroup) null);
        this.ezO = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.ezN = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.ezO.setText(String.format(createGroupStepActivity.getPageContext().getString(d.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.ezB.getActivity(), c.ezG, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ezB.getActivity(), c.ezJ, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ezB.getActivity(), c.ezH, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        this.ezN.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezB.getLayoutMode().aQ(z);
        this.ezB.getLayoutMode().aM(this.mView);
        this.ezN.startLoad(c.a(this.ezB.getActivity(), c.ezI, z), 29, false);
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
        return this.ezB.getPageContext().getString(d.j.group_create_tips_lbs);
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
        return this.ezO;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGJ() {
        return false;
    }
}
