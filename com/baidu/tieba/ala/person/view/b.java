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
/* loaded from: classes10.dex */
public class b extends d {
    public HeadImageView hZu;
    public DrawableTextView hZv;
    public TextView hZw;
    private LinearLayout hZx;

    public b(View view, int i) {
        super(view, i);
        this.hZv = (DrawableTextView) view.findViewById(a.f.attention_btn);
        this.hZu = (HeadImageView) view.findViewById(a.f.user_icon);
        this.hZu.setAutoChangeStyle(false);
        this.hZu.setIsRound(true);
        this.hZw = (TextView) view.findViewById(a.f.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds96)));
        }
        if (i == 2) {
            this.hZx = (LinearLayout) view.findViewById(a.f.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hZv.setVisibility(8);
        } else {
            this.hZv.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void E(final Object obj) {
        if (obj instanceof bl) {
            bl blVar = (bl) obj;
            if (blVar != null) {
                this.hZu.startLoad(blVar.portrait, 10, false);
                this.hZw.setText(blVar.getNameShow());
                if (blVar.aQz == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hZv.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
                        this.hZv.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_person_follow_text_seletor));
                    } else {
                        this.hZv.setBackgroundResource(a.e.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.hZv.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.hZv.setText(this.mRootView.getContext().getString(a.h.ala_person_attention));
                } else {
                    this.hZv.setBackgroundResource(a.e.sdk_unfollow_btn_bg);
                    this.hZv.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10037));
                    this.hZv.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
                }
                if (blVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hZv.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.hZv.setVisibility(8);
                } else {
                    this.hZv.setVisibility(0);
                }
                if (blVar.live_status == 1) {
                    if (this.hZx != null) {
                        this.hZx.setVisibility(0);
                    }
                } else if (this.hZx != null) {
                    this.hZx.setVisibility(8);
                }
            }
            this.hZv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hXp != null) {
                        b.this.hXp.a((bl) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.hXq != null) {
                            b.this.hXq.b((bl) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.hZw, a.c.sdk_cp_cont_b, 1, i);
    }
}
