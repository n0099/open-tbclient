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
    private final List<b> aSl;
    private View aXk;
    private ViewGroup aac;
    private final TbPageContext<?> ajF;
    private final a cfP;
    private ViewGroup cfQ;
    private ViewGroup cfR;
    private ImageView cfS;
    private final List<View> cfT;

    /* loaded from: classes.dex */
    public interface a {
        void iC(int i);
    }

    public q(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aSl = new ArrayList();
        this.cfT = new ArrayList();
        this.ajF = tbPageContext;
        this.cfP = aVar;
        this.aXk = view;
        initView();
    }

    private void initView() {
        this.aac = (ViewGroup) LayoutInflater.from(this.ajF.getPageActivity()).inflate(w.j.frs_write_popup, (ViewGroup) null);
        setContentView(this.aac);
        this.cfQ = (ViewGroup) this.aac.findViewById(w.h.frs_write_popup_item_container);
        this.cfR = (ViewGroup) this.aac.findViewById(w.h.frs_write_popup_board);
        this.cfS = (ImageView) this.aac.findViewById(w.h.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.ajF.getResources().getColor(w.e.common_color_10262)));
        this.ajF.getLayoutMode().t(this.aac);
        this.cfR.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.aac.setOnClickListener(this);
        this.cfS.setOnClickListener(this);
        this.cfR.setOnClickListener(this);
        this.aac.setOnKeyListener(new r(this));
    }

    public void d(boolean z, boolean z2, boolean z3) {
        e(z, z2, z3);
        aeI();
        aeJ();
    }

    private void e(boolean z, boolean z2, boolean z3) {
        this.aSl.add(new b(0, this.ajF.getPageActivity().getString(w.l.topic_thread), w.g.write_popup_normal_item_selector));
        if (z) {
            this.aSl.add(new b(1, this.ajF.getPageActivity().getString(w.l.publish_live_thread), w.g.write_popup_live_item_selector));
        }
        if (z2) {
            this.aSl.add(new b(3, this.ajF.getPageActivity().getString(w.l.msglist_video), w.g.write_popup_video_item_selector));
        }
        this.aSl.add(new b(2, this.ajF.getPageActivity().getString(w.l.publish_vote_thread), w.g.write_popup_vote_item_selector));
        if (z3) {
            this.aSl.add(new b(5, this.ajF.getPageActivity().getString(w.l.ala_live_write_title), w.g.write_popup_live_video_item_selector));
        }
    }

    private void aeI() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aSl.size()) {
            b bVar = this.aSl.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.ajF.getPageActivity()).inflate(w.j.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(w.h.text_frs_write_popup_item);
                aq.i((View) textView, w.e.cp_cont_b);
                textView.setText(bVar.mTitle);
                aq.c((ImageView) inflate.findViewById(w.h.image_frs_write_popup_item), bVar.cfX);
                inflate.setOnClickListener(new s(this, bVar));
                int dimensionPixelOffset = this.ajF.getResources().getDimensionPixelOffset(w.f.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.ajF.getPageActivity());
                    linearLayout.setPadding(this.ajF.getResources().getDimensionPixelOffset(w.f.ds80), 0, this.ajF.getResources().getDimensionPixelOffset(w.f.ds80), 0);
                    this.cfQ.addView(linearLayout);
                } else {
                    linearLayout = linearLayout2;
                }
                inflate.setTag(bVar);
                this.cfT.add(inflate);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (i >= 3) {
                        layoutParams.topMargin = this.ajF.getResources().getDimensionPixelOffset(w.f.ds76);
                        layoutParams.bottomMargin = this.ajF.getResources().getDimensionPixelOffset(w.f.ds76);
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
        if (this.aac == view || this.cfS == view) {
            aeK();
        }
    }

    private void aeJ() {
        long j = com.baidu.tbadk.core.sharedPref.b.uo().getLong("key_frs_videolive_last_popup_time", 0L);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this, this.aXk, 0, 0, 1);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ajF.getPageActivity(), w.a.write_popup_in);
        if (j == 0 && this.cfT != null && this.cfT.size() > 0) {
            loadAnimation.setAnimationListener(new t(this));
        }
        this.cfR.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeK() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ajF.getPageActivity(), w.a.write_popup_out);
        loadAnimation.setAnimationListener(new u(this));
        this.cfR.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int cfW;
        public int cfX;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.cfW = i;
            this.mTitle = str;
            this.cfX = i2;
        }
    }
}
