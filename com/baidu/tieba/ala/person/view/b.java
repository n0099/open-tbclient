package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.bc;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class b extends c {
    public HeadImageView hwl;
    public DrawableTextView hwm;
    public TextView hwn;
    private LinearLayout hwo;

    public b(View view, int i) {
        super(view, i);
        this.hwm = (DrawableTextView) view.findViewById(a.g.attention_btn);
        this.hwl = (HeadImageView) view.findViewById(a.g.user_icon);
        this.hwl.setAutoChangeStyle(false);
        this.hwl.setIsRound(true);
        this.hwn = (TextView) view.findViewById(a.g.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.e.sdk_ds96)));
        }
        if (i == 2) {
            this.hwo = (LinearLayout) view.findViewById(a.g.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hwm.setVisibility(8);
        } else {
            this.hwm.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void H(final Object obj) {
        if (obj instanceof bc) {
            bc bcVar = (bc) obj;
            if (bcVar != null) {
                this.hwl.startLoad(bcVar.portrait, 10, false);
                this.hwn.setText(bcVar.getNameShow());
                if (bcVar.aNJ == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hwm.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
                        this.hwm.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_person_follow_text_seletor));
                    } else {
                        this.hwm.setBackgroundResource(a.f.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.hwm.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.f.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.hwm.setText(this.mRootView.getContext().getString(a.i.ala_person_attention));
                } else {
                    this.hwm.setBackgroundResource(a.f.sdk_unfollow_btn_bg);
                    this.hwm.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10037));
                    this.hwm.setText(this.mRootView.getContext().getString(a.i.ala_person_has_attention));
                }
                if (bcVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hwm.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.hwm.setVisibility(8);
                } else {
                    this.hwm.setVisibility(0);
                }
                if (bcVar.live_status == 1) {
                    if (this.hwo != null) {
                        this.hwo.setVisibility(0);
                    }
                } else if (this.hwo != null) {
                    this.hwo.setVisibility(8);
                }
            }
            this.hwm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.huh != null) {
                        b.this.huh.a((bc) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.hui != null) {
                            b.this.hui.b((bc) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.hwn, a.d.sdk_cp_cont_b, 1, i);
    }
}
