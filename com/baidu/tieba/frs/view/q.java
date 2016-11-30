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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends PopupWindow implements View.OnClickListener {
    private final TbPageContext<?> GO;
    private ViewGroup Wh;
    private final List<b> aOf;
    private View aWi;
    private final a cmE;
    private ViewGroup cmF;
    private ViewGroup cmG;
    private ImageView cmH;

    /* loaded from: classes.dex */
    public interface a {
        void iJ(int i);
    }

    public q(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aOf = new ArrayList();
        this.GO = tbPageContext;
        this.cmE = aVar;
        this.aWi = view;
        initView();
    }

    private void initView() {
        this.Wh = (ViewGroup) LayoutInflater.from(this.GO.getPageActivity()).inflate(r.h.frs_write_popup, (ViewGroup) null);
        setContentView(this.Wh);
        this.cmF = (ViewGroup) this.Wh.findViewById(r.g.frs_write_popup_item_container);
        this.cmG = (ViewGroup) this.Wh.findViewById(r.g.frs_write_popup_board);
        this.cmH = (ImageView) this.Wh.findViewById(r.g.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.GO.getResources().getColor(r.d.common_color_10262)));
        this.GO.getLayoutMode().x(this.Wh);
        this.cmG.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.Wh.setOnClickListener(this);
        this.cmH.setOnClickListener(this);
        this.cmG.setOnClickListener(this);
        this.Wh.setOnKeyListener(new r(this));
    }

    public void o(boolean z, boolean z2) {
        p(z, z2);
        aia();
        aib();
    }

    private void p(boolean z, boolean z2) {
        this.aOf.add(new b(0, this.GO.getPageActivity().getString(r.j.publish_topic_thread), r.f.write_popup_normal_item_selector));
        if (z) {
            this.aOf.add(new b(1, this.GO.getPageActivity().getString(r.j.publish_live_thread), r.f.write_popup_live_item_selector));
        }
        if (z2) {
            this.aOf.add(new b(3, this.GO.getPageActivity().getString(r.j.publish_video_thread), r.f.write_popup_video_item_selector));
        }
        this.aOf.add(new b(2, this.GO.getPageActivity().getString(r.j.publish_vote_thread), r.f.write_popup_vote_item_selector));
        this.aOf.add(new b(4, this.GO.getPageActivity().getString(r.j.publish_product_thread), r.f.write_popup_product_item_selector));
    }

    private void aia() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aOf.size()) {
            b bVar = this.aOf.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.GO.getPageActivity()).inflate(r.h.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(r.g.text_frs_write_popup_item);
                at.j((View) textView, r.d.cp_cont_b);
                textView.setText(bVar.mTitle);
                at.c((ImageView) inflate.findViewById(r.g.image_frs_write_popup_item), bVar.cmL);
                inflate.setOnClickListener(new s(this, bVar));
                int dimensionPixelOffset = this.GO.getResources().getDimensionPixelOffset(r.e.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.GO.getPageActivity());
                    linearLayout.setPadding(this.GO.getResources().getDimensionPixelOffset(r.e.ds80), 0, this.GO.getResources().getDimensionPixelOffset(r.e.ds80), this.GO.getResources().getDimensionPixelOffset(r.e.ds76));
                    this.cmF.addView(linearLayout);
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
        if (this.Wh == view || this.cmH == view) {
            aic();
        }
    }

    private void aib() {
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this, this.aWi, 0, 0, 1);
        this.cmG.startAnimation(AnimationUtils.loadAnimation(this.GO.getPageActivity(), r.a.write_popup_in));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aic() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.GO.getPageActivity(), r.a.write_popup_out);
        loadAnimation.setAnimationListener(new t(this));
        this.cmG.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int cmK;
        public int cmL;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.cmK = i;
            this.mTitle = str;
            this.cmL = i2;
        }
    }
}
