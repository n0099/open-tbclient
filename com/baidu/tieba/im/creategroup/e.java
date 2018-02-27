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
    private CreateGroupStepActivity ezl;
    private TbImageView ezx;
    private Button ezy;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.ezl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_lbs_tips, (ViewGroup) null);
        this.ezy = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.ezx = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.ezy.setText(String.format(createGroupStepActivity.getPageContext().getString(d.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.ezl.getActivity(), c.ezq, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ezl.getActivity(), c.ezt, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ezl.getActivity(), c.ezr, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGD() {
        this.ezx.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezl.getLayoutMode().aQ(z);
        this.ezl.getLayoutMode().aM(this.mView);
        this.ezx.startLoad(c.a(this.ezl.getActivity(), c.ezs, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGx() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return this.ezl.getPageContext().getString(d.j.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGG() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGH() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return null;
    }

    public Button aGM() {
        return this.ezy;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return false;
    }
}
