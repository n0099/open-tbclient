package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.im.chat.ViewPagerAdapter;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FaceView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f1223a;
    private double b;
    private int c;
    private com.baidu.tieba.im.chat.m d;
    private ArrayList<View> e;
    private ArrayList<ImageView> f;
    private RelativeLayout g;
    private ViewPager h;
    private LinearLayout i;
    private Context j;
    private h k;

    public FaceView(Context context) {
        super(context);
        this.f1223a = 1;
        this.b = 0.0d;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = null;
        this.j = context;
        a();
    }

    public FaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1223a = 1;
        this.b = 0.0d;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = null;
        this.j = context;
        a();
    }

    public FaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1223a = 1;
        this.b = 0.0d;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = null;
        this.j = context;
        a();
    }

    protected void a() {
        LayoutInflater.from(this.j).inflate(R.layout.common_face_view, (ViewGroup) this, true);
        this.g = this;
        this.h = (ViewPager) findViewById(R.id.face_im_contains);
        this.e = new ArrayList<>();
        this.b = TbFaceManager.a().b();
        int ceil = (int) Math.ceil(this.b / 27.0d);
        View view = new View(this.j);
        view.setBackgroundColor(0);
        this.e.add(view);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ceil; i++) {
            GridView gridView = new GridView(this.j);
            this.c = i * 28;
            this.d = new com.baidu.tieba.im.chat.m(this.j, 28, this.c - i, i);
            gridView.setAdapter((ListAdapter) this.d);
            arrayList.add(this.d);
            gridView.setNumColumns(7);
            gridView.setHorizontalScrollBarEnabled(false);
            gridView.setVerticalScrollBarEnabled(false);
            gridView.setBackgroundColor(0);
            gridView.setHorizontalSpacing(5);
            gridView.setVerticalSpacing(5);
            gridView.setStretchMode(2);
            gridView.setSelector(new ColorDrawable(0));
            gridView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            gridView.setGravity(17);
            this.e.add(gridView);
            gridView.setOnItemClickListener(new e(this));
        }
        View view2 = new View(this.j);
        view2.setBackgroundColor(0);
        this.e.add(view2);
        this.h.setAdapter(new ViewPagerAdapter(this.e));
        setCurrentItem(1);
        this.h.setOnPageChangeListener(new f(this));
        b();
    }

    public void setOnDataSelected(h hVar) {
        this.k = hVar;
    }

    private void b() {
        this.i = (LinearLayout) findViewById(R.id.iv_image);
        this.f = new ArrayList<>();
        for (int i = 0; i < this.e.size(); i++) {
            ImageView imageView = new ImageView(this.j);
            imageView.setBackgroundResource(R.drawable.dot_pb_expression_n);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
            layoutParams.leftMargin = 14;
            layoutParams.rightMargin = 14;
            this.i.addView(imageView, layoutParams);
            if (i == 0 || i == this.e.size() - 1) {
                imageView.setVisibility(8);
            }
            if (i == 1) {
                imageView.setBackgroundResource(R.drawable.dot_pb_expression_s);
            }
            this.f.add(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 < this.f.size()) {
                if (i == i3) {
                    this.f.get(i3).setBackgroundResource(R.drawable.dot_pb_expression_s);
                } else {
                    this.f.get(i3).setBackgroundResource(R.drawable.dot_pb_expression_n);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void setCurrentItem(int i) {
        if (i >= 0) {
            this.h.setCurrentItem(i);
        }
    }
}
