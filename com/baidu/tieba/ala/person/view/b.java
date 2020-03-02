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
    public HeadImageView fsD;
    public DrawableTextView fsE;
    public TextView fsF;
    private LinearLayout fsG;

    public b(View view, int i) {
        super(view, i);
        this.fsE = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.fsD = (HeadImageView) view.findViewById(a.g.user_icon);
        this.fsD.setAutoChangeStyle(false);
        this.fsD.setIsRound(true);
        this.fsF = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.fsG = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fsE.setVisibility(8);
        } else {
            this.fsE.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void A(final Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.b) {
            com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
            if (bVar != null) {
                this.fsD.startLoad(bVar.portrait, 10, false);
                this.fsF.setText(bVar.getNameShow());
                if (bVar.eLB == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.fsE.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.fsE.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.fsE.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.fsE.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.fsE.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.fsE.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.fsE.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.fsE.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (bVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.fsE.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fsE.setVisibility(8);
                } else {
                    this.fsE.setVisibility(0);
                }
                if (bVar.live_status == 1) {
                    if (this.fsG != null) {
                        this.fsG.setVisibility(0);
                    }
                } else if (this.fsG != null) {
                    this.fsG.setVisibility(8);
                }
            }
            this.fsE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.fqu != null) {
                        b.this.fqu.a((com.baidu.tieba.ala.person.a.b) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.fqv != null) {
                            b.this.fqv.b((com.baidu.tieba.ala.person.a.b) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.fsF, a.d.sdk_cp_cont_b, 1, i);
    }
}
