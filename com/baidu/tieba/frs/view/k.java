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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends PopupWindow implements View.OnClickListener {
    private ViewGroup ZO;
    private final List<b> aSY;
    private View aXX;
    private final TbPageContext<?> ajr;
    private final a cdC;
    private ViewGroup cdD;
    private ViewGroup cdE;
    private ImageView cdF;
    private final List<View> cdG;

    /* loaded from: classes.dex */
    public interface a {
        void iB(int i);
    }

    public k(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aSY = new ArrayList();
        this.cdG = new ArrayList();
        this.ajr = tbPageContext;
        this.cdC = aVar;
        this.aXX = view;
        initView();
    }

    private void initView() {
        this.ZO = (ViewGroup) LayoutInflater.from(this.ajr.getPageActivity()).inflate(w.j.frs_write_popup, (ViewGroup) null);
        setContentView(this.ZO);
        this.cdD = (ViewGroup) this.ZO.findViewById(w.h.frs_write_popup_item_container);
        this.cdE = (ViewGroup) this.ZO.findViewById(w.h.frs_write_popup_board);
        this.cdF = (ImageView) this.ZO.findViewById(w.h.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.ajr.getResources().getColor(w.e.common_color_10262)));
        this.ajr.getLayoutMode().t(this.ZO);
        this.cdE.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.ZO.setOnClickListener(this);
        this.cdF.setOnClickListener(this);
        this.cdE.setOnClickListener(this);
        this.ZO.setOnKeyListener(new l(this));
    }

    public void e(boolean z, boolean z2, boolean z3) {
        f(z, z2, z3);
        adm();
        adn();
    }

    private void f(boolean z, boolean z2, boolean z3) {
        this.aSY.add(new b(0, this.ajr.getPageActivity().getString(w.l.topic_thread), w.g.write_popup_normal_item_selector));
        if (z2) {
            this.aSY.add(new b(3, this.ajr.getPageActivity().getString(w.l.msglist_video), w.g.write_popup_video_item_selector));
        }
        if (z3) {
            this.aSY.add(new b(5, this.ajr.getPageActivity().getString(w.l.ala_live_write_title), w.g.write_popup_live_video_item_selector));
        }
    }

    private void adm() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aSY.size()) {
            b bVar = this.aSY.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.ajr.getPageActivity()).inflate(w.j.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(w.h.text_frs_write_popup_item);
                aq.i(textView, w.e.cp_cont_b);
                textView.setText(bVar.mTitle);
                aq.c((ImageView) inflate.findViewById(w.h.image_frs_write_popup_item), bVar.cdK);
                inflate.setOnClickListener(new m(this, bVar));
                int dimensionPixelOffset = this.ajr.getResources().getDimensionPixelOffset(w.f.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.ajr.getPageActivity());
                    linearLayout.setPadding(this.ajr.getResources().getDimensionPixelOffset(w.f.ds80), 0, this.ajr.getResources().getDimensionPixelOffset(w.f.ds80), 0);
                    this.cdD.addView(linearLayout);
                } else {
                    linearLayout = linearLayout2;
                }
                inflate.setTag(bVar);
                this.cdG.add(inflate);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (i >= 3) {
                        layoutParams.topMargin = this.ajr.getResources().getDimensionPixelOffset(w.f.ds76);
                        layoutParams.bottomMargin = this.ajr.getResources().getDimensionPixelOffset(w.f.ds76);
                    }
                    linearLayout.addView(inflate, layoutParams);
                }
            }
            i++;
            linearLayout2 = linearLayout;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ZO == view || this.cdF == view) {
            ado();
        }
    }

    private void adn() {
        long j = com.baidu.tbadk.core.sharedPref.b.tX().getLong("key_frs_videolive_last_popup_time", 0L);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this, this.aXX, 0, 0, 1);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ajr.getPageActivity(), w.a.write_popup_in);
        if (j == 0 && this.cdG != null && this.cdG.size() > 0) {
            loadAnimation.setAnimationListener(new n(this));
        }
        this.cdE.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ado() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ajr.getPageActivity(), w.a.write_popup_out);
        loadAnimation.setAnimationListener(new o(this));
        this.cdE.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int cdJ;
        public int cdK;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.cdJ = i;
            this.mTitle = str;
            this.cdK = i2;
        }
    }
}
