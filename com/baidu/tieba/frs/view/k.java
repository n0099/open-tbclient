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
    private ViewGroup ZN;
    private View aVz;
    private final TbPageContext<?> ajh;
    private final a cjQ;
    private ViewGroup cjR;
    private ViewGroup cjS;
    private ImageView cjT;
    private final List<View> cjU;
    private final List<b> mDataList;

    /* loaded from: classes.dex */
    public interface a {
        void iZ(int i);
    }

    public k(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.mDataList = new ArrayList();
        this.cjU = new ArrayList();
        this.ajh = tbPageContext;
        this.cjQ = aVar;
        this.aVz = view;
        initView();
    }

    private void initView() {
        this.ZN = (ViewGroup) LayoutInflater.from(this.ajh.getPageActivity()).inflate(w.j.frs_write_popup, (ViewGroup) null);
        setContentView(this.ZN);
        this.cjR = (ViewGroup) this.ZN.findViewById(w.h.frs_write_popup_item_container);
        this.cjS = (ViewGroup) this.ZN.findViewById(w.h.frs_write_popup_board);
        this.cjT = (ImageView) this.ZN.findViewById(w.h.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.ajh.getResources().getColor(w.e.common_color_10262)));
        this.ajh.getLayoutMode().t(this.ZN);
        this.cjS.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.ZN.setOnClickListener(this);
        this.cjT.setOnClickListener(this);
        this.cjS.setOnClickListener(this);
        this.ZN.setOnKeyListener(new l(this));
    }

    public void f(boolean z, boolean z2, boolean z3) {
        g(z, z2, z3);
        aep();
        aeq();
    }

    private void g(boolean z, boolean z2, boolean z3) {
        this.mDataList.add(new b(0, this.ajh.getPageActivity().getString(w.l.topic_thread), w.g.write_popup_normal_item_selector));
        if (z2) {
            this.mDataList.add(new b(3, this.ajh.getPageActivity().getString(w.l.msglist_video), w.g.write_popup_video_item_selector));
        }
        if (z3) {
            this.mDataList.add(new b(5, this.ajh.getPageActivity().getString(w.l.ala_live_write_title), w.g.write_popup_live_video_item_selector));
        }
    }

    private void aep() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.mDataList.size()) {
            b bVar = this.mDataList.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.ajh.getPageActivity()).inflate(w.j.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(w.h.text_frs_write_popup_item);
                aq.i(textView, w.e.cp_cont_b);
                textView.setText(bVar.mTitle);
                aq.c((ImageView) inflate.findViewById(w.h.image_frs_write_popup_item), bVar.cjY);
                inflate.setOnClickListener(new m(this, bVar));
                int dimensionPixelOffset = this.ajh.getResources().getDimensionPixelOffset(w.f.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.ajh.getPageActivity());
                    linearLayout.setPadding(this.ajh.getResources().getDimensionPixelOffset(w.f.ds80), 0, this.ajh.getResources().getDimensionPixelOffset(w.f.ds80), 0);
                    this.cjR.addView(linearLayout);
                } else {
                    linearLayout = linearLayout2;
                }
                inflate.setTag(bVar);
                this.cjU.add(inflate);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (i >= 3) {
                        layoutParams.topMargin = this.ajh.getResources().getDimensionPixelOffset(w.f.ds76);
                        layoutParams.bottomMargin = this.ajh.getResources().getDimensionPixelOffset(w.f.ds76);
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
        if (this.ZN == view || this.cjT == view) {
            aer();
        }
    }

    private void aeq() {
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_frs_videolive_last_popup_time", 0L);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this, this.aVz, 0, 0, 1);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ajh.getPageActivity(), w.a.write_popup_in);
        if (j == 0 && this.cjU != null && this.cjU.size() > 0) {
            loadAnimation.setAnimationListener(new n(this));
        }
        this.cjS.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aer() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ajh.getPageActivity(), w.a.write_popup_out);
        loadAnimation.setAnimationListener(new o(this));
        this.cjS.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int cjX;
        public int cjY;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.cjX = i;
            this.mTitle = str;
            this.cjY = i2;
        }
    }
}
