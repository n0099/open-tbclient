package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class e implements o {
    private CreateGroupStepActivity eod;
    private TbImageView eoq;
    private Button eor;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.eod = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(f.h.create_group_lbs_tips, (ViewGroup) null);
        this.eor = (Button) this.mView.findViewById(f.g.create_group_tips_btn);
        this.eoq = (TbImageView) this.mView.findViewById(f.g.create_group_tips_image);
        this.mIndex = i;
        this.eor.setText(String.format(createGroupStepActivity.getPageContext().getString(f.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.eod.getActivity(), c.eoj, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eod.getActivity(), c.eom, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eod.getActivity(), c.eok, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIb() {
        this.eoq.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIc() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eod.getLayoutMode().setNightMode(z);
        this.eod.getLayoutMode().onModeChanged(this.mView);
        this.eoq.startLoad(c.a(this.eod.getActivity(), c.eol, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aHV() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.eod.getPageContext().getString(f.j.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aIe() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIf() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button aIk() {
        return this.eor;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIg() {
        return false;
    }
}
