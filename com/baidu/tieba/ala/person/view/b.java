package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.bl;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class b extends d {
    public HeadImageView hXL;
    public DrawableTextView hXM;
    public TextView hXN;
    private LinearLayout hXO;

    public b(View view, int i) {
        super(view, i);
        this.hXM = (DrawableTextView) view.findViewById(a.f.attention_btn);
        this.hXL = (HeadImageView) view.findViewById(a.f.user_icon);
        this.hXL.setAutoChangeStyle(false);
        this.hXL.setIsRound(true);
        this.hXN = (TextView) view.findViewById(a.f.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds96)));
        }
        if (i == 2) {
            this.hXO = (LinearLayout) view.findViewById(a.f.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hXM.setVisibility(8);
        } else {
            this.hXM.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void C(final Object obj) {
        if (obj instanceof bl) {
            bl blVar = (bl) obj;
            if (blVar != null) {
                this.hXL.startLoad(blVar.portrait, 10, false);
                this.hXN.setText(blVar.getNameShow());
                if (blVar.aOZ == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hXM.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
                        this.hXM.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_person_follow_text_seletor));
                    } else {
                        this.hXM.setBackgroundResource(a.e.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.hXM.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.hXM.setText(this.mRootView.getContext().getString(a.h.ala_person_attention));
                } else {
                    this.hXM.setBackgroundResource(a.e.sdk_unfollow_btn_bg);
                    this.hXM.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10037));
                    this.hXM.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
                }
                if (blVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hXM.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.hXM.setVisibility(8);
                } else {
                    this.hXM.setVisibility(0);
                }
                if (blVar.live_status == 1) {
                    if (this.hXO != null) {
                        this.hXO.setVisibility(0);
                    }
                } else if (this.hXO != null) {
                    this.hXO.setVisibility(8);
                }
            }
            this.hXM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hVG != null) {
                        b.this.hVG.a((bl) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.hVH != null) {
                            b.this.hVH.b((bl) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.hXN, a.c.sdk_cp_cont_b, 1, i);
    }
}
