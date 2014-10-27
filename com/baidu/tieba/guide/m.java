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
    private ao aKL;
    private Button aLB;
    private NewUserGuideActivity aLi;
    private ViewGroup aLo;
    private View aLp;
    private TbImageView aLq;
    private TbImageView aLr;
    private TbImageView aLs;
    private TbImageView aLt;
    private TbImageView aLu;
    private TbImageView aLv;
    private TbImageView aLw;
    private TbImageView aLx;
    private TbImageView aLy;
    private TbImageView aLz;
    private final Hashtable<Integer, TbImageView> aLA = new Hashtable<>();
    private boolean aKN = false;
    private boolean aLC = false;
    private boolean aLD = true;
    private final View.OnClickListener Nw = new n(this);

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.aLC = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aLi = (NewUserGuideActivity) getActivity();
        this.aKL = this.aLi.Iv();
        d(bundle);
    }

    private void d(Bundle bundle) {
        if (this.aKL != null && !this.aLC) {
            if (bundle != null) {
                this.aKN = bundle.getBoolean("is_new_user");
            } else {
                this.aKN = this.aLi.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.aKL.TP());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.aLA.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.c(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.aLo = (ViewGroup) com.baidu.adp.lib.g.b.ek().inflate(layoutInflater.getContext(), com.baidu.tieba.w.guide_main, null);
            this.aLp = this.aLo.findViewById(com.baidu.tieba.v.root_main_view_cover);
            this.aLq = (TbImageView) this.aLo.findViewById(com.baidu.tieba.v.icon_1);
            this.aLr = (TbImageView) this.aLo.findViewById(com.baidu.tieba.v.icon_2);
            this.aLs = (TbImageView) this.aLo.findViewById(com.baidu.tieba.v.icon_3);
            this.aLt = (TbImageView) this.aLo.findViewById(com.baidu.tieba.v.icon_4);
            this.aLu = (TbImageView) this.aLo.findViewById(com.baidu.tieba.v.icon_5);
            this.aLv = (TbImageView) this.aLo.findViewById(com.baidu.tieba.v.icon_6);
            this.aLw = (TbImageView) this.aLo.findViewById(com.baidu.tieba.v.icon_7);
            this.aLx = (TbImageView) this.aLo.findViewById(com.baidu.tieba.v.icon_8);
            this.aLy = (TbImageView) this.aLo.findViewById(com.baidu.tieba.v.icon_9);
            this.aLz = (TbImageView) this.aLo.findViewById(com.baidu.tieba.v.icon_10);
            this.aLB = (Button) this.aLo.findViewById(com.baidu.tieba.v.btn_next);
            this.aLA.put(1, this.aLq);
            this.aLA.put(2, this.aLr);
            this.aLA.put(3, this.aLs);
            this.aLA.put(4, this.aLt);
            this.aLA.put(5, this.aLu);
            this.aLA.put(6, this.aLv);
            this.aLA.put(7, this.aLw);
            this.aLA.put(8, this.aLx);
            this.aLA.put(9, this.aLy);
            this.aLA.put(10, this.aLz);
            this.aLB.setOnClickListener(this.Nw);
            this.aLq.setOnClickListener(this.Nw);
            this.aLr.setOnClickListener(this.Nw);
            this.aLs.setOnClickListener(this.Nw);
            this.aLt.setOnClickListener(this.Nw);
            this.aLu.setOnClickListener(this.Nw);
            this.aLv.setOnClickListener(this.Nw);
            this.aLw.setOnClickListener(this.Nw);
            this.aLx.setOnClickListener(this.Nw);
            this.aLy.setOnClickListener(this.Nw);
            this.aLy.setOnClickListener(this.Nw);
            this.aLz.setOnClickListener(this.Nw);
            return this.aLo;
        } catch (InflateException e) {
            if (TbadkApplication.m251getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.aLi.Ix();
            TbadkApplication.m251getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
