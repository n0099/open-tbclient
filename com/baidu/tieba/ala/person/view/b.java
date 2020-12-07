package com.baidu.tieba.ala.person.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.bf;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class b extends c {
    public HeadImageView hLu;
    public DrawableTextView hLv;
    public TextView hLw;
    private LinearLayout hLx;

    public b(View view, int i) {
        super(view, i);
        this.hLv = (DrawableTextView) view.findViewById(a.f.attention_btn);
        this.hLu = (HeadImageView) view.findViewById(a.f.user_icon);
        this.hLu.setAutoChangeStyle(false);
        this.hLu.setIsRound(true);
        this.hLw = (TextView) view.findViewById(a.f.user_name);
        if (i == 1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, view.getContext().getResources().getDimensionPixelSize(a.d.sdk_ds96)));
        }
        if (i == 2) {
            this.hLx = (LinearLayout) view.findViewById(a.f.live_tail_light);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hLv.setVisibility(8);
        } else {
            this.hLv.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void H(final Object obj) {
        if (obj instanceof bf) {
            bf bfVar = (bf) obj;
            if (bfVar != null) {
                this.hLu.startLoad(bfVar.portrait, 10, false);
                this.hLw.setText(bfVar.getNameShow());
                if (bfVar.aQa == 0) {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hLv.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
                        this.hLv.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_person_follow_text_seletor));
                    } else {
                        this.hLv.setBackgroundResource(a.e.sdk_qm_ala_person_follow_btn_bg_seletor);
                        this.hLv.setTextColor(this.mRootView.getContext().getResources().getColorStateList(a.e.sdk_qm_ala_person_follow_text_seletor));
                    }
                    this.hLv.setText(this.mRootView.getContext().getString(a.h.ala_person_attention));
                } else {
                    this.hLv.setBackgroundResource(a.e.sdk_unfollow_btn_bg);
                    this.hLv.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10037));
                    this.hLv.setText(this.mRootView.getContext().getString(a.h.ala_person_has_attention));
                }
                if (bfVar.id.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hLv.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.hLv.setVisibility(8);
                } else {
                    this.hLv.setVisibility(0);
                }
                if (bfVar.live_status == 1) {
                    if (this.hLx != null) {
                        this.hLx.setVisibility(0);
                    }
                } else if (this.hLx != null) {
                    this.hLx.setVisibility(8);
                }
            }
            this.hLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hJq != null) {
                        b.this.hJq.a((bf) obj, view);
                    }
                }
            });
            if (this.mRootView != null) {
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.hJr != null) {
                            b.this.hJr.b((bf) obj, view);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.hLw, a.c.sdk_cp_cont_b, 1, i);
    }
}
