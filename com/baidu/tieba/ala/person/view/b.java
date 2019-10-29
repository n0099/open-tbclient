package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class b extends c {
    public HeadImageView ewh;
    public DrawableTextView ewi;
    public TextView ewj;
    private LinearLayout ewk;

    public b(View view, int i) {
        super(view, i);
        this.ewi = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.ewh = (HeadImageView) view.findViewById(a.g.user_icon);
        this.ewh.setAutoChangeStyle(false);
        this.ewh.setIsRound(true);
        this.ewj = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.ewk = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ewi.setVisibility(8);
        } else {
            this.ewi.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void z(final Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.b) {
            com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
            if (bVar != null) {
                this.ewh.startLoad(bVar.portrait, 10, false);
                this.ewj.setText(bVar.getNameShow());
                if (bVar.dRG == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.ewi.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.ewi.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.ewi.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.ewi.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.ewi.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.ewi.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.ewi.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.ewi.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (bVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.ewi.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.ewi.setVisibility(8);
                } else {
                    this.ewi.setVisibility(0);
                }
                if (bVar.live_status == 1) {
                    if (this.ewk != null) {
                        this.ewk.setVisibility(0);
                    }
                } else if (this.ewk != null) {
                    this.ewk.setVisibility(8);
                }
            }
            this.ewi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eua != null) {
                        b.this.eua.a((com.baidu.tieba.ala.person.a.b) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.eub != null) {
                            b.this.eub.b((com.baidu.tieba.ala.person.a.b) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.ewj, a.d.sdk_cp_cont_b, 1, i);
    }
}
