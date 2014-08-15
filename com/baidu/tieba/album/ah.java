package com.baidu.tieba.album;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ah extends com.baidu.tbadk.core.d implements u {
    private AlbumActivity b;
    private p c;
    private e d;
    private View e;
    private NavigationBar f;
    private View g;
    private TextView h;
    private TextView i;
    private GridView j;
    private ab k;
    private View l;
    private String m;
    private List<ImageFileInfo> n;
    private boolean o = true;
    private aa p;
    private z q;
    private boolean r;
    private boolean s;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (AlbumActivity) getActivity();
        this.c = this.b.h();
        q.a().a(this);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(com.baidu.tieba.v.album_image_list_view, (ViewGroup) null);
        this.f = (NavigationBar) this.e.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.b);
        this.h = this.f.a("");
        this.i = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.b.getString(com.baidu.tieba.x.cancel), this.b);
        this.j = (GridView) this.e.findViewById(com.baidu.tieba.u.gv_image_list);
        this.k = new ab(this.b, this.c);
        this.j.setAdapter((ListAdapter) this.k);
        this.j.setOnScrollListener(this.k);
        this.p = new ai(this);
        this.q = new aj(this);
        this.k.a(this.p);
        this.k.a(this.q);
        this.l = this.e.findViewById(com.baidu.tieba.u.lay_no_data);
        return this.e;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.s = false;
        if (d_()) {
            h();
        }
    }

    private void g() {
        if (this.c == null && this.b != null) {
            this.c = this.b.h();
        }
        if (this.c != null) {
            String e = this.c.e();
            if (TextUtils.isEmpty(e)) {
                e = this.c.c();
                if (TextUtils.isEmpty(e)) {
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.m) && this.m.equals(e) && this.o) {
                if (this.k != null) {
                    this.k.notifyDataSetChanged();
                    return;
                }
                return;
            }
            a((List<ImageFileInfo>) null);
            c(e);
            this.m = e;
        }
    }

    private void c(String str) {
        if (this.d == null) {
            this.d = new e(this.b);
        }
        this.d.a(str, new ak(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ImageFileInfo> list) {
        if (this.k != null) {
            this.c.a(list);
            this.k.a(list);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        this.b.c().a(i == 1);
        this.b.c().a(this.e);
        this.f.c(i);
    }

    public View a() {
        return this.g;
    }

    public TextView f() {
        return this.i;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.b();
        }
        q.a().b(this);
    }

    public void a(int i, boolean z) {
        if (this.j != null) {
            int firstVisiblePosition = this.j.getFirstVisiblePosition();
            int lastVisiblePosition = this.j.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.j.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(com.baidu.tieba.u.select_icon);
                    int skinType = TbadkApplication.m252getInst().getSkinType();
                    if (z) {
                        if (skinType == 1) {
                            imageView.setBackgroundResource(com.baidu.tieba.t.btn_choose_photo_s_1);
                        } else {
                            imageView.setBackgroundResource(com.baidu.tieba.t.btn_choose_photo_s);
                        }
                    } else if (skinType == 1) {
                        imageView.setBackgroundResource(com.baidu.tieba.t.btn_choose_photo_n_1);
                    } else {
                        imageView.setBackgroundResource(com.baidu.tieba.t.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public void a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.k != null) {
            a(this.k.a(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.s = true;
    }

    @Override // com.baidu.tieba.album.u
    public void a(boolean z) {
        this.r = z;
        this.o = false;
        h();
    }

    private void h() {
        if (!isHidden() && !this.s) {
            if (this.r) {
                this.j.setVisibility(8);
                this.l.setVisibility(0);
                return;
            }
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            g();
        }
    }
}
