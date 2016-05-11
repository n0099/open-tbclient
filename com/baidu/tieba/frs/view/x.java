package com.baidu.tieba.frs.view;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class x extends PopupWindow implements View.OnClickListener {
    private final TbPageContext<?> DV;
    private ViewGroup RI;
    private View aJB;
    private final List<b> aZH;
    private final a bwJ;
    private ViewGroup bwK;
    private ViewGroup bwL;
    private ImageView bwM;

    /* loaded from: classes.dex */
    public interface a {
        void gl(int i);
    }

    public x(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aZH = new ArrayList();
        this.DV = tbPageContext;
        this.bwJ = aVar;
        this.aJB = view;
        initView();
    }

    private void initView() {
        this.RI = (ViewGroup) LayoutInflater.from(this.DV.getPageActivity()).inflate(t.h.frs_write_popup, (ViewGroup) null);
        setContentView(this.RI);
        this.bwK = (ViewGroup) this.RI.findViewById(t.g.frs_write_popup_item_container);
        this.bwL = (ViewGroup) this.RI.findViewById(t.g.frs_write_popup_board);
        this.bwM = (ImageView) this.RI.findViewById(t.g.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.DV.getResources().getColor(t.d.white_alpha0)));
        this.DV.getLayoutMode().x(this.RI);
        this.bwL.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.RI.setOnClickListener(this);
        this.bwM.setOnClickListener(this);
        this.bwL.setOnClickListener(this);
        this.RI.setOnKeyListener(new y(this));
    }

    public void d(boolean z, boolean z2, boolean z3) {
        e(z, z2, z3);
        Up();
        Uq();
    }

    private void e(boolean z, boolean z2, boolean z3) {
        this.aZH.add(new b(0, this.DV.getPageActivity().getString(t.j.publish_topic_thread), t.f.write_popup_normal_item_selector));
        if (z) {
            this.aZH.add(new b(1, this.DV.getPageActivity().getString(t.j.publish_live_thread), t.f.write_popup_live_item_selector));
        }
        if (z2) {
            this.aZH.add(new b(3, this.DV.getPageActivity().getString(t.j.publish_video_thread), t.f.write_popup_video_item_selector));
        }
        this.aZH.add(new b(2, this.DV.getPageActivity().getString(t.j.publish_vote_thread), t.f.write_popup_vote_item_selector));
        if (z3) {
            this.aZH.add(new b(4, this.DV.getPageActivity().getString(t.j.publish_activity_thread), t.f.write_popup_togetherhi_item_selector));
        }
    }

    private void Up() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aZH.size()) {
            b bVar = this.aZH.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.DV.getPageActivity()).inflate(t.h.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(t.g.text_frs_write_popup_item);
                at.j((View) textView, t.d.cp_cont_b);
                textView.setText(bVar.mTitle);
                at.c((ImageView) inflate.findViewById(t.g.image_frs_write_popup_item), bVar.bwQ);
                inflate.setOnClickListener(new z(this, bVar));
                int dimensionPixelOffset = this.DV.getResources().getDimensionPixelOffset(t.e.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.DV.getPageActivity());
                    linearLayout.setPadding(this.DV.getResources().getDimensionPixelOffset(t.e.ds80), 0, this.DV.getResources().getDimensionPixelOffset(t.e.ds80), this.DV.getResources().getDimensionPixelOffset(t.e.ds76));
                    this.bwK.addView(linearLayout);
                } else {
                    linearLayout = linearLayout2;
                }
                if (linearLayout != null) {
                    linearLayout.addView(inflate);
                }
            }
            i++;
            linearLayout2 = linearLayout;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.RI == view || this.bwM == view) {
            Ur();
        }
    }

    private void Uq() {
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this, this.aJB, 0, 0, 1);
        this.bwL.startAnimation(AnimationUtils.loadAnimation(this.DV.getPageActivity(), t.a.write_popup_in));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ur() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.DV.getPageActivity(), t.a.write_popup_out);
        loadAnimation.setAnimationListener(new aa(this));
        this.bwL.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int bwP;
        public int bwQ;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.bwP = i;
            this.mTitle = str;
            this.bwQ = i2;
        }
    }
}
