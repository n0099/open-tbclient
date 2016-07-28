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
    private final TbPageContext<?> EA;
    private ViewGroup SJ;
    private final List<b> aKa;
    private View aNT;
    private final a bWp;
    private ViewGroup bWq;
    private ViewGroup bWr;
    private ImageView bWs;

    /* loaded from: classes.dex */
    public interface a {
        void hV(int i);
    }

    public p(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aKa = new ArrayList();
        this.EA = tbPageContext;
        this.bWp = aVar;
        this.aNT = view;
        initView();
    }

    private void initView() {
        this.SJ = (ViewGroup) LayoutInflater.from(this.EA.getPageActivity()).inflate(u.h.frs_write_popup, (ViewGroup) null);
        setContentView(this.SJ);
        this.bWq = (ViewGroup) this.SJ.findViewById(u.g.frs_write_popup_item_container);
        this.bWr = (ViewGroup) this.SJ.findViewById(u.g.frs_write_popup_board);
        this.bWs = (ImageView) this.SJ.findViewById(u.g.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.EA.getResources().getColor(u.d.common_color_10262)));
        this.EA.getLayoutMode().w(this.SJ);
        this.bWr.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.SJ.setOnClickListener(this);
        this.bWs.setOnClickListener(this);
        this.bWr.setOnClickListener(this);
        this.SJ.setOnKeyListener(new q(this));
    }

    public void d(boolean z, boolean z2, boolean z3) {
        e(z, z2, z3);
        abg();
        abh();
    }

    private void e(boolean z, boolean z2, boolean z3) {
        this.aKa.add(new b(0, this.EA.getPageActivity().getString(u.j.publish_topic_thread), u.f.write_popup_normal_item_selector));
        if (z) {
            this.aKa.add(new b(1, this.EA.getPageActivity().getString(u.j.publish_live_thread), u.f.write_popup_live_item_selector));
        }
        if (z2) {
            this.aKa.add(new b(3, this.EA.getPageActivity().getString(u.j.publish_video_thread), u.f.write_popup_video_item_selector));
        }
        this.aKa.add(new b(2, this.EA.getPageActivity().getString(u.j.publish_vote_thread), u.f.write_popup_vote_item_selector));
        if (z3) {
            this.aKa.add(new b(4, this.EA.getPageActivity().getString(u.j.publish_activity_thread), u.f.write_popup_togetherhi_item_selector));
        }
        this.aKa.add(new b(5, this.EA.getPageActivity().getString(u.j.publish_product_thread), u.f.write_popup_product_item_selector));
    }

    private void abg() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aKa.size()) {
            b bVar = this.aKa.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.EA.getPageActivity()).inflate(u.h.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(u.g.text_frs_write_popup_item);
                av.j((View) textView, u.d.cp_cont_b);
                textView.setText(bVar.mTitle);
                av.c((ImageView) inflate.findViewById(u.g.image_frs_write_popup_item), bVar.bWw);
                inflate.setOnClickListener(new r(this, bVar));
                int dimensionPixelOffset = this.EA.getResources().getDimensionPixelOffset(u.e.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.EA.getPageActivity());
                    linearLayout.setPadding(this.EA.getResources().getDimensionPixelOffset(u.e.ds80), 0, this.EA.getResources().getDimensionPixelOffset(u.e.ds80), this.EA.getResources().getDimensionPixelOffset(u.e.ds76));
                    this.bWq.addView(linearLayout);
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
        if (this.SJ == view || this.bWs == view) {
            abi();
        }
    }

    private void abh() {
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this, this.aNT, 0, 0, 1);
        this.bWr.startAnimation(AnimationUtils.loadAnimation(this.EA.getPageActivity(), u.a.write_popup_in));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abi() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.EA.getPageActivity(), u.a.write_popup_out);
        loadAnimation.setAnimationListener(new s(this));
        this.bWr.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int bWv;
        public int bWw;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.bWv = i;
            this.mTitle = str;
            this.bWw = i2;
        }
    }
}
