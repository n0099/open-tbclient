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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public final class ah extends com.baidu.tieba.j implements u {
    private AlbumActivity b;
    private p c;
    private e d;
    private View e;
    private NavigationBar f;
    private ImageView g;
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

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (AlbumActivity) getActivity();
        this.c = this.b.e();
        q.a().a(this);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.album_image_list_view, (ViewGroup) null);
        this.f = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.b);
        this.h = this.f.a("");
        this.i = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.b.getString(R.string.cancel), this.b);
        this.j = (GridView) this.e.findViewById(R.id.gv_image_list);
        this.k = new ab(this.b, this.c);
        this.j.setAdapter((ListAdapter) this.k);
        this.j.setOnScrollListener(this.k);
        this.p = new ai(this);
        this.q = new aj(this);
        this.k.a(this.p);
        this.k.a(this.q);
        this.l = this.e.findViewById(R.id.lay_no_data);
        return this.e;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        this.s = false;
        if (d()) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ImageFileInfo> list) {
        if (this.k != null) {
            this.c.a(list);
            this.k.a(list);
        }
    }

    @Override // com.baidu.tieba.j
    public final void c(int i) {
        super.c(i);
        this.b.a().a(i == 1);
        this.b.a().a(this.e);
        this.f.b(i);
    }

    public final ImageView a() {
        return this.g;
    }

    public final TextView b() {
        return this.i;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.b();
        }
        q.a().b(this);
    }

    public final void a(int i, boolean z) {
        if (this.j != null) {
            int firstVisiblePosition = this.j.getFirstVisiblePosition();
            int lastVisiblePosition = this.j.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = this.j.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    childAt.invalidate();
                    ImageView imageView = (ImageView) childAt.findViewById(R.id.select_icon);
                    int ae = TiebaApplication.g().ae();
                    if (z) {
                        if (ae == 1) {
                            imageView.setBackgroundResource(R.drawable.btn_choose_photo_s_1);
                        } else {
                            imageView.setBackgroundResource(R.drawable.btn_choose_photo_s);
                        }
                    } else if (ae == 1) {
                        imageView.setBackgroundResource(R.drawable.btn_choose_photo_n_1);
                    } else {
                        imageView.setBackgroundResource(R.drawable.btn_choose_photo_n);
                    }
                }
            }
        }
    }

    public final void a(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo != null && this.k != null) {
            a(this.k.a(imageFileInfo), z);
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
        this.s = true;
    }

    @Override // com.baidu.tieba.album.u
    public final void a(boolean z) {
        this.r = z;
        this.o = false;
        c();
    }

    private void c() {
        if (!isHidden() && !this.s) {
            if (this.r) {
                this.j.setVisibility(8);
                this.l.setVisibility(0);
                return;
            }
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            if (this.c == null && this.b != null) {
                this.c = this.b.e();
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
                if (this.d == null) {
                    this.d = new e(this.b);
                }
                this.d.a(e, new ak(this));
                this.m = e;
            }
        }
    }
}
