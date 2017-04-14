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
public class q extends PopupWindow implements View.OnClickListener {
    private final List<b> aSB;
    private View aXy;
    private ViewGroup aas;
    private final TbPageContext<?> ajT;
    private final a cep;
    private ViewGroup ceq;
    private ViewGroup cer;
    private ImageView ces;
    private final List<View> cet;

    /* loaded from: classes.dex */
    public interface a {
        void iD(int i);
    }

    public q(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aSB = new ArrayList();
        this.cet = new ArrayList();
        this.ajT = tbPageContext;
        this.cep = aVar;
        this.aXy = view;
        initView();
    }

    private void initView() {
        this.aas = (ViewGroup) LayoutInflater.from(this.ajT.getPageActivity()).inflate(w.j.frs_write_popup, (ViewGroup) null);
        setContentView(this.aas);
        this.ceq = (ViewGroup) this.aas.findViewById(w.h.frs_write_popup_item_container);
        this.cer = (ViewGroup) this.aas.findViewById(w.h.frs_write_popup_board);
        this.ces = (ImageView) this.aas.findViewById(w.h.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.ajT.getResources().getColor(w.e.common_color_10262)));
        this.ajT.getLayoutMode().t(this.aas);
        this.cer.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.aas.setOnClickListener(this);
        this.ces.setOnClickListener(this);
        this.cer.setOnClickListener(this);
        this.aas.setOnKeyListener(new r(this));
    }

    public void d(boolean z, boolean z2, boolean z3) {
        e(z, z2, z3);
        aeC();
        aeD();
    }

    private void e(boolean z, boolean z2, boolean z3) {
        this.aSB.add(new b(0, this.ajT.getPageActivity().getString(w.l.topic_thread), w.g.write_popup_normal_item_selector));
        if (z) {
            this.aSB.add(new b(1, this.ajT.getPageActivity().getString(w.l.publish_live_thread), w.g.write_popup_live_item_selector));
        }
        if (z2) {
            this.aSB.add(new b(3, this.ajT.getPageActivity().getString(w.l.msglist_video), w.g.write_popup_video_item_selector));
        }
        this.aSB.add(new b(2, this.ajT.getPageActivity().getString(w.l.publish_vote_thread), w.g.write_popup_vote_item_selector));
        if (z3) {
            this.aSB.add(new b(5, this.ajT.getPageActivity().getString(w.l.ala_live_write_title), w.g.write_popup_live_video_item_selector));
        }
    }

    private void aeC() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aSB.size()) {
            b bVar = this.aSB.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.ajT.getPageActivity()).inflate(w.j.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(w.h.text_frs_write_popup_item);
                aq.i(textView, w.e.cp_cont_b);
                textView.setText(bVar.mTitle);
                aq.c((ImageView) inflate.findViewById(w.h.image_frs_write_popup_item), bVar.cex);
                inflate.setOnClickListener(new s(this, bVar));
                int dimensionPixelOffset = this.ajT.getResources().getDimensionPixelOffset(w.f.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.ajT.getPageActivity());
                    linearLayout.setPadding(this.ajT.getResources().getDimensionPixelOffset(w.f.ds80), 0, this.ajT.getResources().getDimensionPixelOffset(w.f.ds80), 0);
                    this.ceq.addView(linearLayout);
                } else {
                    linearLayout = linearLayout2;
                }
                inflate.setTag(bVar);
                this.cet.add(inflate);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (i >= 3) {
                        layoutParams.topMargin = this.ajT.getResources().getDimensionPixelOffset(w.f.ds76);
                        layoutParams.bottomMargin = this.ajT.getResources().getDimensionPixelOffset(w.f.ds76);
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
        if (this.aas == view || this.ces == view) {
            aeE();
        }
    }

    private void aeD() {
        long j = com.baidu.tbadk.core.sharedPref.b.uL().getLong("key_frs_videolive_last_popup_time", 0L);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this, this.aXy, 0, 0, 1);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ajT.getPageActivity(), w.a.write_popup_in);
        if (j == 0 && this.cet != null && this.cet.size() > 0) {
            loadAnimation.setAnimationListener(new t(this));
        }
        this.cer.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeE() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ajT.getPageActivity(), w.a.write_popup_out);
        loadAnimation.setAnimationListener(new u(this));
        this.cer.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int cew;
        public int cex;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.cew = i;
            this.mTitle = str;
            this.cex = i2;
        }
    }
}
