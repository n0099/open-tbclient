package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.be;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class b extends c {
    public HeadImageView hBP;
    public DrawableTextView hBQ;
    public TextView hBR;
    private LinearLayout hBS;

    public b(View view, int i) {
        super(view, i);
        this.hBQ = (DrawableTextView) view.findViewById(a.f.attention_btn);
        this.hBP = (HeadImageView) view.findViewById(a.f.user_icon);
        this.hBP.setAutoChangeStyle(false);
        this.hBP.setIsRound(true);
        this.hBR = (TextView) view.findViewById(a.f.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds96)));
        }
        if (i == 2) {
            this.hBS = (LinearLayout) view.findViewById(a.f.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hBQ.setVisibility(8);
        } else {
            this.hBQ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void H(final Object obj) {
        if (obj instanceof be) {
            be beVar = (be) obj;
            if (beVar != null) {
                this.hBP.startLoad(beVar.portrait, 10, false);
                this.hBR.setText(beVar.getNameShow());
                if (beVar.aNb == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hBQ.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
                        this.hBQ.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_person_follow_text_seletor));
                    } else {
                        this.hBQ.setBackgroundResource(a.e.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.hBQ.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.hBQ.setText(this.mRootView.getContext().getString(a.h.ala_person_attention));
                } else {
                    this.hBQ.setBackgroundResource(a.e.sdk_unfollow_btn_bg);
                    this.hBQ.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10037));
                    this.hBQ.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
                }
                if (beVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hBQ.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.hBQ.setVisibility(8);
                } else {
                    this.hBQ.setVisibility(0);
                }
                if (beVar.live_status == 1) {
                    if (this.hBS != null) {
                        this.hBS.setVisibility(0);
                    }
                } else if (this.hBS != null) {
                    this.hBS.setVisibility(8);
                }
            }
            this.hBQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hzL != null) {
                        b.this.hzL.a((be) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.hzM != null) {
                            b.this.hzM.b((be) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.hBR, a.c.sdk_cp_cont_b, 1, i);
    }
}
