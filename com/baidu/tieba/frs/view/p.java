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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends PopupWindow implements View.OnClickListener {
    private final TbPageContext<?> GM;
    private ViewGroup Vz;
    private final List<b> aOE;
    private View aTn;
    private ViewGroup chA;
    private ViewGroup chB;
    private ImageView chC;
    private final a chz;

    /* loaded from: classes.dex */
    public interface a {
        void iy(int i);
    }

    public p(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aOE = new ArrayList();
        this.GM = tbPageContext;
        this.chz = aVar;
        this.aTn = view;
        initView();
    }

    private void initView() {
        this.Vz = (ViewGroup) LayoutInflater.from(this.GM.getPageActivity()).inflate(t.h.frs_write_popup, (ViewGroup) null);
        setContentView(this.Vz);
        this.chA = (ViewGroup) this.Vz.findViewById(t.g.frs_write_popup_item_container);
        this.chB = (ViewGroup) this.Vz.findViewById(t.g.frs_write_popup_board);
        this.chC = (ImageView) this.Vz.findViewById(t.g.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.GM.getResources().getColor(t.d.common_color_10262)));
        this.GM.getLayoutMode().x(this.Vz);
        this.chB.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.Vz.setOnClickListener(this);
        this.chC.setOnClickListener(this);
        this.chB.setOnClickListener(this);
        this.Vz.setOnKeyListener(new q(this));
    }

    public void d(boolean z, boolean z2, boolean z3) {
        e(z, z2, z3);
        afR();
        afS();
    }

    private void e(boolean z, boolean z2, boolean z3) {
        this.aOE.add(new b(0, this.GM.getPageActivity().getString(t.j.publish_topic_thread), t.f.write_popup_normal_item_selector));
        if (z) {
            this.aOE.add(new b(1, this.GM.getPageActivity().getString(t.j.publish_live_thread), t.f.write_popup_live_item_selector));
        }
        if (z2) {
            this.aOE.add(new b(3, this.GM.getPageActivity().getString(t.j.publish_video_thread), t.f.write_popup_video_item_selector));
        }
        this.aOE.add(new b(2, this.GM.getPageActivity().getString(t.j.publish_vote_thread), t.f.write_popup_vote_item_selector));
        if (z3) {
            this.aOE.add(new b(4, this.GM.getPageActivity().getString(t.j.publish_activity_thread), t.f.write_popup_togetherhi_item_selector));
        }
        this.aOE.add(new b(5, this.GM.getPageActivity().getString(t.j.publish_product_thread), t.f.write_popup_product_item_selector));
    }

    private void afR() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aOE.size()) {
            b bVar = this.aOE.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.GM.getPageActivity()).inflate(t.h.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(t.g.text_frs_write_popup_item);
                av.j((View) textView, t.d.cp_cont_b);
                textView.setText(bVar.mTitle);
                av.c((ImageView) inflate.findViewById(t.g.image_frs_write_popup_item), bVar.chG);
                inflate.setOnClickListener(new r(this, bVar));
                int dimensionPixelOffset = this.GM.getResources().getDimensionPixelOffset(t.e.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.GM.getPageActivity());
                    linearLayout.setPadding(this.GM.getResources().getDimensionPixelOffset(t.e.ds80), 0, this.GM.getResources().getDimensionPixelOffset(t.e.ds80), this.GM.getResources().getDimensionPixelOffset(t.e.ds76));
                    this.chA.addView(linearLayout);
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
        if (this.Vz == view || this.chC == view) {
            afT();
        }
    }

    private void afS() {
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this, this.aTn, 0, 0, 1);
        this.chB.startAnimation(AnimationUtils.loadAnimation(this.GM.getPageActivity(), t.a.write_popup_in));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afT() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.GM.getPageActivity(), t.a.write_popup_out);
        loadAnimation.setAnimationListener(new s(this));
        this.chB.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int chF;
        public int chG;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.chF = i;
            this.mTitle = str;
            this.chG = i2;
        }
    }
}
