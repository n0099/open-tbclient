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
    public HeadImageView evq;
    public DrawableTextView evr;
    public TextView evs;
    private LinearLayout evt;

    public b(View view, int i) {
        super(view, i);
        this.evr = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.evq = (HeadImageView) view.findViewById(a.g.user_icon);
        this.evq.setAutoChangeStyle(false);
        this.evq.setIsRound(true);
        this.evs = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.evt = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.evr.setVisibility(8);
        } else {
            this.evr.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void z(final Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.b) {
            com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
            if (bVar != null) {
                this.evq.startLoad(bVar.portrait, 10, false);
                this.evs.setText(bVar.getNameShow());
                if (bVar.dQP == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.evr.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.evr.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.evr.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.evr.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.evr.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.evr.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.evr.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.evr.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (bVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.evr.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.evr.setVisibility(8);
                } else {
                    this.evr.setVisibility(0);
                }
                if (bVar.live_status == 1) {
                    if (this.evt != null) {
                        this.evt.setVisibility(0);
                    }
                } else if (this.evt != null) {
                    this.evt.setVisibility(8);
                }
            }
            this.evr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.etj != null) {
                        b.this.etj.a((com.baidu.tieba.ala.person.a.b) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.etk != null) {
                            b.this.etk.b((com.baidu.tieba.ala.person.a.b) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.evs, a.d.sdk_cp_cont_b, 1, i);
    }
}
