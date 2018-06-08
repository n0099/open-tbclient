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
    private TbImageView egI;
    private Button egJ;
    private CreateGroupStepActivity egw;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.egw = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_lbs_tips, (ViewGroup) null);
        this.egJ = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.egI = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.egJ.setText(String.format(createGroupStepActivity.getPageContext().getString(d.k.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.egw.getActivity(), c.egB, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.egw.getActivity(), c.egE, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.egw.getActivity(), c.egC, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aGx() {
        this.egI.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aGy() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.egw.getLayoutMode().setNightMode(z);
        this.egw.getLayoutMode().onModeChanged(this.mView);
        this.egI.startLoad(c.a(this.egw.getActivity(), c.egD, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aGr() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.egw.getPageContext().getString(d.k.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aGA() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aGB() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button aGG() {
        return this.egJ;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aGC() {
        return false;
    }
}
