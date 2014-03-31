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
public final class b extends com.baidu.tbadk.core.d {
    private AlbumActivity a;
    private p b;
    private com.baidu.tbadk.img.e c;
    private NavigationBar d;
    private View e;
    private TextView f;
    private ViewPager g;
    private h h;
    private int i = -1;
    private View j;
    private ImageView k;
    private View l;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = (AlbumActivity) getActivity();
        this.b = this.a.f();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.j = layoutInflater.inflate(com.baidu.tieba.a.i.album_big_image_view, (ViewGroup) null);
        this.d = (NavigationBar) this.j.findViewById(com.baidu.tieba.a.h.navigation_bar);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.a);
        this.f = this.d.a("");
        View inflate = layoutInflater.inflate(com.baidu.tieba.a.i.album_big_image_choose, (ViewGroup) null);
        this.k = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.img_choose);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, inflate, new c(this));
        this.g = (ViewPager) this.j.findViewById(com.baidu.tieba.a.h.viewPager);
        this.c = this.a.g();
        this.g.setOnPageChangeListener(new d(this));
        this.l = this.j.findViewById(com.baidu.tieba.a.h.album_no_data);
        return this.j;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (isShow() && !isHidden()) {
            this.l.setVisibility(8);
            this.g.setVisibility(0);
            if (this.b == null && this.a != null) {
                this.b = this.a.f();
            }
            if (this.b == null || this.b.f() == null) {
                return;
            }
            int g = this.b.g();
            if (g >= 0) {
                this.i = g;
                if (this.i > this.b.f().size() - 1) {
                    this.i = this.b.f().size() - 1;
                }
                this.b.a(-1);
                a(this.i + 1);
                this.h = null;
                this.h = new h(this.a, this.c);
                this.g.setAdapter(this.h);
                if (this.i == 0 && this.b.f() != null) {
                    if (this.b.c(this.b.f().get(this.i))) {
                        a(this.k, true);
                    } else {
                        a(this.k, false);
                    }
                }
            }
            this.h.a(this.b.f());
            this.g.setCurrentItem(this.i, false);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z && this.h != null) {
            this.h.a((List<ImageFileInfo>) null);
        }
    }

    public final View a() {
        return this.e;
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.b().a(i == 1);
        this.a.b().a(this.j);
        if (this.d != null) {
            this.d.b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ImageView imageView, boolean z) {
        if (imageView != null) {
            int l = TbadkApplication.j().l();
            if (z) {
                if (l == 1) {
                    imageView.setBackgroundResource(com.baidu.tieba.a.g.btn_add_finish_s_1);
                } else {
                    imageView.setBackgroundResource(com.baidu.tieba.a.g.btn_add_finish_s);
                }
            } else if (l == 1) {
                imageView.setBackgroundResource(com.baidu.tieba.a.g.btn_add_finish_n_1);
            } else {
                imageView.setBackgroundResource(com.baidu.tieba.a.g.btn_add_finish_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.b != null && this.b.f() != null) {
            String string = this.a.getString(com.baidu.tieba.a.k.album_big_image_title, new Object[]{Integer.valueOf(i), Integer.valueOf(this.b.f().size())});
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            this.f.setText(string);
        }
    }

    public final void a(ImageFileInfo imageFileInfo, boolean z) {
        ImageFileInfo a;
        if (imageFileInfo != null && imageFileInfo.getFilePath() != null && this.h != null && (a = this.h.a(this.i)) != null && a.getFilePath() != null && a.getFilePath().equals(imageFileInfo.getFilePath())) {
            a(this.k, z);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
    }
}
