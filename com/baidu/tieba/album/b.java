package com.baidu.tieba.album;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.j implements t {
    private AlbumActivity b;
    private p c;
    private com.baidu.tieba.img.e d;
    private NavigationBar e;
    private ImageView f;
    private TextView g;
    private ViewPager h;
    private h i;
    private int j = -1;
    private View k;
    private ImageView l;
    private View m;
    private boolean n;

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (AlbumActivity) getActivity();
        this.c = this.b.f();
        q.a().a(this);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.e = (NavigationBar) this.k.findViewById(R.id.navigation_bar);
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.b);
        this.g = this.e.a("");
        View inflate = layoutInflater.inflate(R.layout.album_big_image_choose, (ViewGroup) null);
        this.l = (ImageView) inflate.findViewById(R.id.img_choose);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.h = (ViewPager) this.k.findViewById(R.id.viewPager);
        this.d = this.b.g();
        this.h.setOnPageChangeListener(new d(this));
        this.m = this.k.findViewById(R.id.album_no_data);
        return this.k;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (b()) {
            d();
        }
    }

    private void c() {
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

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.i != null) {
            this.i.a((List<ImageFileInfo>) null);
        }
    }

    public ImageView a() {
        return this.f;
    }

    @Override // com.baidu.tieba.j
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
            int al = TiebaApplication.g().al();
            if (z) {
                if (al == 1) {
                    imageView.setBackgroundResource(R.drawable.btn_add_finish_s_1);
                } else {
                    imageView.setBackgroundResource(R.drawable.btn_add_finish_s);
                }
            } else if (al == 1) {
                imageView.setBackgroundResource(R.drawable.btn_add_finish_n_1);
            } else {
                imageView.setBackgroundResource(R.drawable.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.c != null && this.c.f() != null) {
            String string = this.b.getString(R.string.album_big_image_title, new Object[]{Integer.valueOf(i), Integer.valueOf(this.c.f().size())});
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

    @Override // com.baidu.tieba.album.t
    public void a(boolean z) {
        this.n = z;
        this.c.a(this.j);
        d();
    }

    private void d() {
        if (!isHidden()) {
            if (this.n) {
                this.m.setVisibility(0);
                this.h.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            this.h.setVisibility(0);
            c();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        q.a().b(this);
    }
}
