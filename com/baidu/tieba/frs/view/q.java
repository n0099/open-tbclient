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
    private final List<b> aSD;
    private View aXB;
    private ViewGroup aat;
    private final TbPageContext<?> ajU;
    private final a cgG;
    private ViewGroup cgH;
    private ViewGroup cgI;
    private ImageView cgJ;
    private final List<View> cgK;

    /* loaded from: classes.dex */
    public interface a {
        void iJ(int i);
    }

    public q(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aSD = new ArrayList();
        this.cgK = new ArrayList();
        this.ajU = tbPageContext;
        this.cgG = aVar;
        this.aXB = view;
        initView();
    }

    private void initView() {
        this.aat = (ViewGroup) LayoutInflater.from(this.ajU.getPageActivity()).inflate(w.j.frs_write_popup, (ViewGroup) null);
        setContentView(this.aat);
        this.cgH = (ViewGroup) this.aat.findViewById(w.h.frs_write_popup_item_container);
        this.cgI = (ViewGroup) this.aat.findViewById(w.h.frs_write_popup_board);
        this.cgJ = (ImageView) this.aat.findViewById(w.h.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.ajU.getResources().getColor(w.e.common_color_10262)));
        this.ajU.getLayoutMode().t(this.aat);
        this.cgI.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.aat.setOnClickListener(this);
        this.cgJ.setOnClickListener(this);
        this.cgI.setOnClickListener(this);
        this.aat.setOnKeyListener(new r(this));
    }

    public void d(boolean z, boolean z2, boolean z3) {
        e(z, z2, z3);
        afD();
        afE();
    }

    private void e(boolean z, boolean z2, boolean z3) {
        this.aSD.add(new b(0, this.ajU.getPageActivity().getString(w.l.topic_thread), w.g.write_popup_normal_item_selector));
        if (z) {
            this.aSD.add(new b(1, this.ajU.getPageActivity().getString(w.l.publish_live_thread), w.g.write_popup_live_item_selector));
        }
        if (z2) {
            this.aSD.add(new b(3, this.ajU.getPageActivity().getString(w.l.msglist_video), w.g.write_popup_video_item_selector));
        }
        this.aSD.add(new b(2, this.ajU.getPageActivity().getString(w.l.publish_vote_thread), w.g.write_popup_vote_item_selector));
        if (z3) {
            this.aSD.add(new b(5, this.ajU.getPageActivity().getString(w.l.ala_live_write_title), w.g.write_popup_live_video_item_selector));
        }
    }

    private void afD() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aSD.size()) {
            b bVar = this.aSD.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.ajU.getPageActivity()).inflate(w.j.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(w.h.text_frs_write_popup_item);
                aq.i(textView, w.e.cp_cont_b);
                textView.setText(bVar.mTitle);
                aq.c((ImageView) inflate.findViewById(w.h.image_frs_write_popup_item), bVar.cgO);
                inflate.setOnClickListener(new s(this, bVar));
                int dimensionPixelOffset = this.ajU.getResources().getDimensionPixelOffset(w.f.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.ajU.getPageActivity());
                    linearLayout.setPadding(this.ajU.getResources().getDimensionPixelOffset(w.f.ds80), 0, this.ajU.getResources().getDimensionPixelOffset(w.f.ds80), 0);
                    this.cgH.addView(linearLayout);
                } else {
                    linearLayout = linearLayout2;
                }
                inflate.setTag(bVar);
                this.cgK.add(inflate);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (i >= 3) {
                        layoutParams.topMargin = this.ajU.getResources().getDimensionPixelOffset(w.f.ds76);
                        layoutParams.bottomMargin = this.ajU.getResources().getDimensionPixelOffset(w.f.ds76);
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
        if (this.aat == view || this.cgJ == view) {
            afF();
        }
    }

    private void afE() {
        long j = com.baidu.tbadk.core.sharedPref.b.uL().getLong("key_frs_videolive_last_popup_time", 0L);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this, this.aXB, 0, 0, 1);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ajU.getPageActivity(), w.a.write_popup_in);
        if (j == 0 && this.cgK != null && this.cgK.size() > 0) {
            loadAnimation.setAnimationListener(new t(this));
        }
        this.cgI.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afF() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ajU.getPageActivity(), w.a.write_popup_out);
        loadAnimation.setAnimationListener(new u(this));
        this.cgI.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int cgN;
        public int cgO;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.cgN = i;
            this.mTitle = str;
            this.cgO = i2;
        }
    }
}
