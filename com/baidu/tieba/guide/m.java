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
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class m extends BaseFragment {
    private com.baidu.tieba.model.o aMT;
    private TbImageView aNA;
    private TbImageView aNB;
    private TbImageView aNC;
    private TbImageView aND;
    private TbImageView aNE;
    private TbImageView aNF;
    private TbImageView aNG;
    private NewUserGuideActivity aNp;
    private ViewGroup aNv;
    private View aNw;
    private TbImageView aNx;
    private TbImageView aNy;
    private TbImageView aNz;
    private Button mNext;
    private final Hashtable<Integer, TbImageView> aNH = new Hashtable<>();
    private boolean aMV = false;
    private boolean aNI = false;
    private boolean aNJ = true;
    private final View.OnClickListener onClickListener = new n(this);

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.aNI = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aNp = (NewUserGuideActivity) getBaseFragmentActivity();
        this.aMT = this.aNp.IQ();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.aMT != null && !this.aNI) {
            if (bundle != null) {
                this.aMV = bundle.getBoolean("is_new_user");
            } else {
                this.aMV = this.aNp.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.aMT.Up());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.aNH.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.d(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.aNv = (ViewGroup) com.baidu.adp.lib.g.b.ek().inflate(layoutInflater.getContext(), x.guide_main, null);
            this.aNw = this.aNv.findViewById(com.baidu.tieba.w.root_main_view_cover);
            this.aNx = (TbImageView) this.aNv.findViewById(com.baidu.tieba.w.icon_1);
            this.aNy = (TbImageView) this.aNv.findViewById(com.baidu.tieba.w.icon_2);
            this.aNz = (TbImageView) this.aNv.findViewById(com.baidu.tieba.w.icon_3);
            this.aNA = (TbImageView) this.aNv.findViewById(com.baidu.tieba.w.icon_4);
            this.aNB = (TbImageView) this.aNv.findViewById(com.baidu.tieba.w.icon_5);
            this.aNC = (TbImageView) this.aNv.findViewById(com.baidu.tieba.w.icon_6);
            this.aND = (TbImageView) this.aNv.findViewById(com.baidu.tieba.w.icon_7);
            this.aNE = (TbImageView) this.aNv.findViewById(com.baidu.tieba.w.icon_8);
            this.aNF = (TbImageView) this.aNv.findViewById(com.baidu.tieba.w.icon_9);
            this.aNG = (TbImageView) this.aNv.findViewById(com.baidu.tieba.w.icon_10);
            this.mNext = (Button) this.aNv.findViewById(com.baidu.tieba.w.btn_next);
            this.aNH.put(1, this.aNx);
            this.aNH.put(2, this.aNy);
            this.aNH.put(3, this.aNz);
            this.aNH.put(4, this.aNA);
            this.aNH.put(5, this.aNB);
            this.aNH.put(6, this.aNC);
            this.aNH.put(7, this.aND);
            this.aNH.put(8, this.aNE);
            this.aNH.put(9, this.aNF);
            this.aNH.put(10, this.aNG);
            this.mNext.setOnClickListener(this.onClickListener);
            this.aNx.setOnClickListener(this.onClickListener);
            this.aNy.setOnClickListener(this.onClickListener);
            this.aNz.setOnClickListener(this.onClickListener);
            this.aNA.setOnClickListener(this.onClickListener);
            this.aNB.setOnClickListener(this.onClickListener);
            this.aNC.setOnClickListener(this.onClickListener);
            this.aND.setOnClickListener(this.onClickListener);
            this.aNE.setOnClickListener(this.onClickListener);
            this.aNF.setOnClickListener(this.onClickListener);
            this.aNF.setOnClickListener(this.onClickListener);
            this.aNG.setOnClickListener(this.onClickListener);
            return this.aNv;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.aNp.IS();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
