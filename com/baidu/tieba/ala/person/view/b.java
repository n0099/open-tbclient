package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends c {
    public HeadImageView gmT;
    public DrawableTextView gmU;
    public TextView gmV;
    private LinearLayout gmW;

    public b(View view, int i) {
        super(view, i);
        this.gmU = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.gmT = (HeadImageView) view.findViewById(a.g.user_icon);
        this.gmT.setAutoChangeStyle(false);
        this.gmT.setIsRound(true);
        this.gmV = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.gmW = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gmU.setVisibility(8);
        } else {
            this.gmU.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void D(final Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.b) {
            com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
            if (bVar != null) {
                this.gmT.startLoad(bVar.portrait, 10, false);
                this.gmV.setText(bVar.getNameShow());
                if (bVar.fEM == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gmU.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.gmU.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.gmU.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.gmU.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.gmU.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.gmU.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.gmU.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.gmU.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (bVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.gmU.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gmU.setVisibility(8);
                } else {
                    this.gmU.setVisibility(0);
                }
                if (bVar.live_status == 1) {
                    if (this.gmW != null) {
                        this.gmW.setVisibility(0);
                    }
                } else if (this.gmW != null) {
                    this.gmW.setVisibility(8);
                }
            }
            this.gmU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gkN != null) {
                        b.this.gkN.a((com.baidu.tieba.ala.person.a.b) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.gkO != null) {
                            b.this.gkO.b((com.baidu.tieba.ala.person.a.b) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.gmV, a.d.sdk_cp_cont_b, 1, i);
    }
}
