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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends PopupWindow implements View.OnClickListener {
    private final TbPageContext<?> GM;
    private ViewGroup VJ;
    private final List<b> aMf;
    private View aTX;
    private ImageView chA;
    private final a chx;
    private ViewGroup chy;
    private ViewGroup chz;

    /* loaded from: classes.dex */
    public interface a {
        void iD(int i);
    }

    public p(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aMf = new ArrayList();
        this.GM = tbPageContext;
        this.chx = aVar;
        this.aTX = view;
        initView();
    }

    private void initView() {
        this.VJ = (ViewGroup) LayoutInflater.from(this.GM.getPageActivity()).inflate(r.h.frs_write_popup, (ViewGroup) null);
        setContentView(this.VJ);
        this.chy = (ViewGroup) this.VJ.findViewById(r.g.frs_write_popup_item_container);
        this.chz = (ViewGroup) this.VJ.findViewById(r.g.frs_write_popup_board);
        this.chA = (ImageView) this.VJ.findViewById(r.g.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.GM.getResources().getColor(r.d.common_color_10262)));
        this.GM.getLayoutMode().x(this.VJ);
        this.chz.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.VJ.setOnClickListener(this);
        this.chA.setOnClickListener(this);
        this.chz.setOnClickListener(this);
        this.VJ.setOnKeyListener(new q(this));
    }

    public void o(boolean z, boolean z2) {
        p(z, z2);
        agf();
        agg();
    }

    private void p(boolean z, boolean z2) {
        this.aMf.add(new b(0, this.GM.getPageActivity().getString(r.j.publish_topic_thread), r.f.write_popup_normal_item_selector));
        if (z) {
            this.aMf.add(new b(1, this.GM.getPageActivity().getString(r.j.publish_live_thread), r.f.write_popup_live_item_selector));
        }
        if (z2) {
            this.aMf.add(new b(3, this.GM.getPageActivity().getString(r.j.publish_video_thread), r.f.write_popup_video_item_selector));
        }
        this.aMf.add(new b(2, this.GM.getPageActivity().getString(r.j.publish_vote_thread), r.f.write_popup_vote_item_selector));
        this.aMf.add(new b(4, this.GM.getPageActivity().getString(r.j.publish_product_thread), r.f.write_popup_product_item_selector));
    }

    private void agf() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aMf.size()) {
            b bVar = this.aMf.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.GM.getPageActivity()).inflate(r.h.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(r.g.text_frs_write_popup_item);
                av.j((View) textView, r.d.cp_cont_b);
                textView.setText(bVar.mTitle);
                av.c((ImageView) inflate.findViewById(r.g.image_frs_write_popup_item), bVar.chE);
                inflate.setOnClickListener(new r(this, bVar));
                int dimensionPixelOffset = this.GM.getResources().getDimensionPixelOffset(r.e.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.GM.getPageActivity());
                    linearLayout.setPadding(this.GM.getResources().getDimensionPixelOffset(r.e.ds80), 0, this.GM.getResources().getDimensionPixelOffset(r.e.ds80), this.GM.getResources().getDimensionPixelOffset(r.e.ds76));
                    this.chy.addView(linearLayout);
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
        if (this.VJ == view || this.chA == view) {
            agh();
        }
    }

    private void agg() {
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this, this.aTX, 0, 0, 1);
        this.chz.startAnimation(AnimationUtils.loadAnimation(this.GM.getPageActivity(), r.a.write_popup_in));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agh() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.GM.getPageActivity(), r.a.write_popup_out);
        loadAnimation.setAnimationListener(new s(this));
        this.chz.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int chD;
        public int chE;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.chD = i;
            this.mTitle = str;
            this.chE = i2;
        }
    }
}
