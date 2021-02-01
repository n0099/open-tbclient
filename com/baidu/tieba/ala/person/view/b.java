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
    private LinearLayout hXA;
    public HeadImageView hXx;
    public DrawableTextView hXy;
    public TextView hXz;

    public b(View view, int i) {
        super(view, i);
        this.hXy = (DrawableTextView) view.findViewById(a.f.attention_btn);
        this.hXx = (HeadImageView) view.findViewById(a.f.user_icon);
        this.hXx.setAutoChangeStyle(false);
        this.hXx.setIsRound(true);
        this.hXz = (TextView) view.findViewById(a.f.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds96)));
        }
        if (i == 2) {
            this.hXA = (LinearLayout) view.findViewById(a.f.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hXy.setVisibility(8);
        } else {
            this.hXy.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void C(final Object obj) {
        if (obj instanceof bl) {
            bl blVar = (bl) obj;
            if (blVar != null) {
                this.hXx.startLoad(blVar.portrait, 10, false);
                this.hXz.setText(blVar.getNameShow());
                if (blVar.aOZ == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hXy.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
                        this.hXy.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_person_follow_text_seletor));
                    } else {
                        this.hXy.setBackgroundResource(a.e.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.hXy.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.hXy.setText(this.mRootView.getContext().getString(a.h.ala_person_attention));
                } else {
                    this.hXy.setBackgroundResource(a.e.sdk_unfollow_btn_bg);
                    this.hXy.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10037));
                    this.hXy.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
                }
                if (blVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hXy.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.hXy.setVisibility(8);
                } else {
                    this.hXy.setVisibility(0);
                }
                if (blVar.live_status == 1) {
                    if (this.hXA != null) {
                        this.hXA.setVisibility(0);
                    }
                } else if (this.hXA != null) {
                    this.hXA.setVisibility(8);
                }
            }
            this.hXy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hVs != null) {
                        b.this.hVs.a((bl) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.hVt != null) {
                            b.this.hVt.b((bl) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.hXz, a.c.sdk_cp_cont_b, 1, i);
    }
}
