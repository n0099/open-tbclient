package com.baidu.tieba.guide;

import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.ao;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class m extends BaseFragment {
    private ao aKZ;
    private ViewGroup aLC;
    private View aLD;
    private TbImageView aLE;
    private TbImageView aLF;
    private TbImageView aLG;
    private TbImageView aLH;
    private TbImageView aLI;
    private TbImageView aLJ;
    private TbImageView aLK;
    private TbImageView aLL;
    private TbImageView aLM;
    private TbImageView aLN;
    private Button aLP;
    private NewUserGuideActivity aLw;
    private final Hashtable<Integer, TbImageView> aLO = new Hashtable<>();
    private boolean aLb = false;
    private boolean aLQ = false;
    private boolean aLR = true;
    private final View.OnClickListener NA = new n(this);

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.aLQ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aLw = (NewUserGuideActivity) getActivity();
        this.aKZ = this.aLw.Iz();
        d(bundle);
    }

    private void d(Bundle bundle) {
        if (this.aKZ != null && !this.aLQ) {
            if (bundle != null) {
                this.aLb = bundle.getBoolean("is_new_user");
            } else {
                this.aLb = this.aLw.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.aKZ.TS());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.aLO.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.c(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.aLC = (ViewGroup) com.baidu.adp.lib.g.b.ek().inflate(layoutInflater.getContext(), com.baidu.tieba.w.guide_main, null);
            this.aLD = this.aLC.findViewById(com.baidu.tieba.v.root_main_view_cover);
            this.aLE = (TbImageView) this.aLC.findViewById(com.baidu.tieba.v.icon_1);
            this.aLF = (TbImageView) this.aLC.findViewById(com.baidu.tieba.v.icon_2);
            this.aLG = (TbImageView) this.aLC.findViewById(com.baidu.tieba.v.icon_3);
            this.aLH = (TbImageView) this.aLC.findViewById(com.baidu.tieba.v.icon_4);
            this.aLI = (TbImageView) this.aLC.findViewById(com.baidu.tieba.v.icon_5);
            this.aLJ = (TbImageView) this.aLC.findViewById(com.baidu.tieba.v.icon_6);
            this.aLK = (TbImageView) this.aLC.findViewById(com.baidu.tieba.v.icon_7);
            this.aLL = (TbImageView) this.aLC.findViewById(com.baidu.tieba.v.icon_8);
            this.aLM = (TbImageView) this.aLC.findViewById(com.baidu.tieba.v.icon_9);
            this.aLN = (TbImageView) this.aLC.findViewById(com.baidu.tieba.v.icon_10);
            this.aLP = (Button) this.aLC.findViewById(com.baidu.tieba.v.btn_next);
            this.aLO.put(1, this.aLE);
            this.aLO.put(2, this.aLF);
            this.aLO.put(3, this.aLG);
            this.aLO.put(4, this.aLH);
            this.aLO.put(5, this.aLI);
            this.aLO.put(6, this.aLJ);
            this.aLO.put(7, this.aLK);
            this.aLO.put(8, this.aLL);
            this.aLO.put(9, this.aLM);
            this.aLO.put(10, this.aLN);
            this.aLP.setOnClickListener(this.NA);
            this.aLE.setOnClickListener(this.NA);
            this.aLF.setOnClickListener(this.NA);
            this.aLG.setOnClickListener(this.NA);
            this.aLH.setOnClickListener(this.NA);
            this.aLI.setOnClickListener(this.NA);
            this.aLJ.setOnClickListener(this.NA);
            this.aLK.setOnClickListener(this.NA);
            this.aLL.setOnClickListener(this.NA);
            this.aLM.setOnClickListener(this.NA);
            this.aLM.setOnClickListener(this.NA);
            this.aLN.setOnClickListener(this.NA);
            return this.aLC;
        } catch (InflateException e) {
            if (TbadkApplication.m251getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.aLw.IB();
            TbadkApplication.m251getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
