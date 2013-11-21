package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private Activity f1487a;
    private EditText b;
    private int c = 1;
    private double d = 0.0d;
    private int e = 0;
    private m f = null;
    private ArrayList<View> g = null;
    private ArrayList<ImageView> h = null;
    private RelativeLayout i = null;
    private ViewPager j = null;
    private LinearLayout k = null;

    public aa(Activity activity, EditText editText) {
        this.b = null;
        this.f1487a = activity;
        this.b = editText;
        b();
        c();
    }

    private void b() {
        this.i = (RelativeLayout) this.f1487a.findViewById(R.id.face_view);
        this.j = (ViewPager) this.f1487a.findViewById(R.id.face_im_contains);
        this.g = new ArrayList<>();
        this.d = TbFaceManager.a().b();
        int ceil = (int) Math.ceil(this.d / 27.0d);
        View view = new View(this.f1487a);
        view.setBackgroundColor(0);
        this.g.add(view);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ceil; i++) {
            GridView gridView = new GridView(this.f1487a);
            this.e = i * 28;
            this.f = new m(this.f1487a, 28, this.e - i, i);
            gridView.setAdapter((ListAdapter) this.f);
            arrayList.add(this.f);
            gridView.setNumColumns(7);
            gridView.setBackgroundColor(0);
            gridView.setHorizontalSpacing(5);
            gridView.setVerticalSpacing(5);
            gridView.setStretchMode(2);
            gridView.setSelector(new ColorDrawable(0));
            gridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            gridView.setGravity(17);
            this.g.add(gridView);
            gridView.setOnItemClickListener(new ab(this));
        }
        View view2 = new View(this.f1487a);
        view2.setBackgroundColor(0);
        this.g.add(view2);
        this.j.setAdapter(new ViewPagerAdapter(this.g));
        b(1);
        this.j.setOnPageChangeListener(new ac(this));
    }

    private void c() {
        this.k = (LinearLayout) this.f1487a.findViewById(R.id.iv_image);
        this.h = new ArrayList<>();
        for (int i = 0; i < this.g.size(); i++) {
            ImageView imageView = new ImageView(this.f1487a);
            imageView.setBackgroundResource(R.drawable.dot_pb_expression_n);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
            layoutParams.leftMargin = 14;
            layoutParams.rightMargin = 14;
            this.k.addView(imageView, layoutParams);
            if (i == 0 || i == this.g.size() - 1) {
                imageView.setVisibility(8);
            }
            if (i == 1) {
                imageView.setBackgroundResource(R.drawable.dot_pb_expression_s);
            }
            this.h.add(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.h.size()) {
                if (i == i3) {
                    this.h.get(i3).setBackgroundResource(R.drawable.dot_pb_expression_s);
                } else {
                    this.h.get(i3).setBackgroundResource(R.drawable.dot_pb_expression_n);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i) {
        if (i == 0 || 8 == i || 4 == i) {
            this.i.setVisibility(i);
        }
    }

    public int a() {
        return this.i.getVisibility();
    }

    public void b(int i) {
        if (i >= 0) {
            this.j.setCurrentItem(i);
        }
    }
}
