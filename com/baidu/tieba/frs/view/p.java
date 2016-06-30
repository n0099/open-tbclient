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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends PopupWindow implements View.OnClickListener {
    private final TbPageContext<?> Ea;
    private ViewGroup Sb;
    private final List<b> aJj;
    private View aMZ;
    private final a bUp;
    private ViewGroup bUq;
    private ViewGroup bUr;
    private ImageView bUs;

    /* loaded from: classes.dex */
    public interface a {
        void hU(int i);
    }

    public p(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aJj = new ArrayList();
        this.Ea = tbPageContext;
        this.bUp = aVar;
        this.aMZ = view;
        initView();
    }

    private void initView() {
        this.Sb = (ViewGroup) LayoutInflater.from(this.Ea.getPageActivity()).inflate(u.h.frs_write_popup, (ViewGroup) null);
        setContentView(this.Sb);
        this.bUq = (ViewGroup) this.Sb.findViewById(u.g.frs_write_popup_item_container);
        this.bUr = (ViewGroup) this.Sb.findViewById(u.g.frs_write_popup_board);
        this.bUs = (ImageView) this.Sb.findViewById(u.g.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.Ea.getResources().getColor(u.d.common_color_10262)));
        this.Ea.getLayoutMode().w(this.Sb);
        this.bUr.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.Sb.setOnClickListener(this);
        this.bUs.setOnClickListener(this);
        this.bUr.setOnClickListener(this);
        this.Sb.setOnKeyListener(new q(this));
    }

    public void d(boolean z, boolean z2, boolean z3) {
        e(z, z2, z3);
        aaE();
        aaF();
    }

    private void e(boolean z, boolean z2, boolean z3) {
        this.aJj.add(new b(0, this.Ea.getPageActivity().getString(u.j.publish_topic_thread), u.f.write_popup_normal_item_selector));
        if (z) {
            this.aJj.add(new b(1, this.Ea.getPageActivity().getString(u.j.publish_live_thread), u.f.write_popup_live_item_selector));
        }
        if (z2) {
            this.aJj.add(new b(3, this.Ea.getPageActivity().getString(u.j.publish_video_thread), u.f.write_popup_video_item_selector));
        }
        this.aJj.add(new b(2, this.Ea.getPageActivity().getString(u.j.publish_vote_thread), u.f.write_popup_vote_item_selector));
        if (z3) {
            this.aJj.add(new b(4, this.Ea.getPageActivity().getString(u.j.publish_activity_thread), u.f.write_popup_togetherhi_item_selector));
        }
        this.aJj.add(new b(5, this.Ea.getPageActivity().getString(u.j.publish_product_thread), u.f.write_popup_product_item_selector));
    }

    private void aaE() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aJj.size()) {
            b bVar = this.aJj.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.Ea.getPageActivity()).inflate(u.h.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(u.g.text_frs_write_popup_item);
                av.j((View) textView, u.d.cp_cont_b);
                textView.setText(bVar.mTitle);
                av.c((ImageView) inflate.findViewById(u.g.image_frs_write_popup_item), bVar.bUw);
                inflate.setOnClickListener(new r(this, bVar));
                int dimensionPixelOffset = this.Ea.getResources().getDimensionPixelOffset(u.e.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.Ea.getPageActivity());
                    linearLayout.setPadding(this.Ea.getResources().getDimensionPixelOffset(u.e.ds80), 0, this.Ea.getResources().getDimensionPixelOffset(u.e.ds80), this.Ea.getResources().getDimensionPixelOffset(u.e.ds76));
                    this.bUq.addView(linearLayout);
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
        if (this.Sb == view || this.bUs == view) {
            aaG();
        }
    }

    private void aaF() {
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this, this.aMZ, 0, 0, 1);
        this.bUr.startAnimation(AnimationUtils.loadAnimation(this.Ea.getPageActivity(), u.a.write_popup_in));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaG() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.Ea.getPageActivity(), u.a.write_popup_out);
        loadAnimation.setAnimationListener(new s(this));
        this.bUr.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int bUv;
        public int bUw;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.bUv = i;
            this.mTitle = str;
            this.bUw = i2;
        }
    }
}
