package com.baidu.tieba.album;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.core.d {
    private AlbumActivity b;
    private p c;
    private com.baidu.tbadk.img.e d;
    private NavigationBar e;
    private View f;
    private TextView g;
    private ViewPager h;
    private h i;
    private int j = -1;
    private View k;
    private ImageView l;
    private View m;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (AlbumActivity) getActivity();
        this.c = this.b.f();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = layoutInflater.inflate(com.baidu.tieba.s.album_big_image_view, (ViewGroup) null);
        this.e = (NavigationBar) this.k.findViewById(com.baidu.tieba.r.navigation_bar);
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.b);
        this.g = this.e.a("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.s.album_big_image_choose, (ViewGroup) null);
        this.l = (ImageView) inflate.findViewById(com.baidu.tieba.r.img_choose);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.h = (ViewPager) this.k.findViewById(com.baidu.tieba.r.viewPager);
        this.d = this.b.g();
        this.h.setOnPageChangeListener(new d(this));
        this.m = this.k.findViewById(com.baidu.tieba.r.album_no_data);
        return this.k;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (d_()) {
            g();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    private void f() {
        if (this.c == null && this.b != null) {
            this.c = this.b.f();
        }
        if (this.c != null && this.c.f() != null) {
            int g = this.c.g();
            if (g >= 0) {
                this.j = g;
                if (this.j > this.c.f().size() - 1) {
                    this.j = this.c.f().size() - 1;
                }
                this.c.a(-1);
                d(this.j + 1);
                this.i = null;
                this.i = new h(this.b, this.d);
                this.h.setAdapter(this.i);
                if (this.j == 0 && this.c.f() != null) {
                    if (this.c.c(this.c.f().get(this.j))) {
                        a(this.l, true);
                    } else {
                        a(this.l, false);
                    }
                }
            }
            this.i.a(this.c.f());
            this.h.setCurrentItem(this.j, false);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.i != null) {
            this.i.a((List<ImageFileInfo>) null);
        }
    }

    public View a() {
        return this.f;
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        this.b.a().a(i == 1);
        this.b.a().a(this.k);
        if (this.e != null) {
            this.e.c(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (imageView != null) {
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (z) {
                if (skinType == 1) {
                    imageView.setBackgroundResource(com.baidu.tieba.q.btn_add_finish_s_1);
                } else {
                    imageView.setBackgroundResource(com.baidu.tieba.q.btn_add_finish_s);
                }
            } else if (skinType == 1) {
                imageView.setBackgroundResource(com.baidu.tieba.q.btn_add_finish_n_1);
            } else {
                imageView.setBackgroundResource(com.baidu.tieba.q.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.c != null && this.c.f() != null) {
            String string = this.b.getString(com.baidu.tieba.u.album_big_image_title, new Object[]{Integer.valueOf(i), Integer.valueOf(this.c.f().size())});
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.g.setText(string);
        }
    }

    public void a(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo a;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.i != null && (a = this.i.a(this.j)) != null && a.getFilePath() != null && a.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.l, z);
        }
    }

    private void g() {
        if (!isHidden()) {
            this.m.setVisibility(8);
            this.h.setVisibility(0);
            f();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
